package p006io.realm;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.JsonReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p006io.realm.BaseRealm;
import p006io.realm.RealmCache;
import p006io.realm.RealmConfiguration;
import p006io.realm.exceptions.RealmException;
import p006io.realm.exceptions.RealmFileException;
import p006io.realm.exceptions.RealmMigrationNeededException;
import p006io.realm.internal.ColumnIndices;
import p006io.realm.internal.ColumnInfo;
import p006io.realm.internal.ObjectServerFacade;
import p006io.realm.internal.RealmCore;
import p006io.realm.internal.RealmNotifier;
import p006io.realm.internal.RealmObjectProxy;
import p006io.realm.internal.RealmProxyMediator;
import p006io.realm.internal.SharedRealm;
import p006io.realm.internal.Table;
import p006io.realm.internal.async.RealmAsyncTaskImpl;
import p006io.realm.log.RealmLog;
import rx.Observable;

/* renamed from: io.realm.Realm */
public class Realm extends BaseRealm {
    public static final String DEFAULT_REALM_NAME = "default.realm";
    private static RealmConfiguration defaultConfiguration;

    public /* bridge */ /* synthetic */ void beginTransaction() {
        super.beginTransaction();
    }

    public /* bridge */ /* synthetic */ void cancelTransaction() {
        super.cancelTransaction();
    }

    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    public /* bridge */ /* synthetic */ void commitTransaction() {
        super.commitTransaction();
    }

    public /* bridge */ /* synthetic */ void deleteAll() {
        super.deleteAll();
    }

    public /* bridge */ /* synthetic */ RealmConfiguration getConfiguration() {
        return super.getConfiguration();
    }

    public /* bridge */ /* synthetic */ String getPath() {
        return super.getPath();
    }

    public /* bridge */ /* synthetic */ RealmSchema getSchema() {
        return super.getSchema();
    }

    public /* bridge */ /* synthetic */ long getVersion() {
        return super.getVersion();
    }

    public /* bridge */ /* synthetic */ boolean isAutoRefresh() {
        return super.isAutoRefresh();
    }

    public /* bridge */ /* synthetic */ boolean isClosed() {
        return super.isClosed();
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public /* bridge */ /* synthetic */ boolean isInTransaction() {
        return super.isInTransaction();
    }

    public /* bridge */ /* synthetic */ void setAutoRefresh(boolean z) {
        super.setAutoRefresh(z);
    }

    public /* bridge */ /* synthetic */ void stopWaitForChange() {
        super.stopWaitForChange();
    }

    public /* bridge */ /* synthetic */ boolean waitForChange() {
        return super.waitForChange();
    }

    public /* bridge */ /* synthetic */ void writeCopyTo(File file) {
        super.writeCopyTo(file);
    }

    public /* bridge */ /* synthetic */ void writeEncryptedCopyTo(File file, byte[] bArr) {
        super.writeEncryptedCopyTo(file, bArr);
    }

    Realm(RealmConfiguration configuration) {
        super(configuration);
    }

    public Observable<Realm> asObservable() {
        return this.configuration.getRxFactory().from(this);
    }

    public static synchronized void init(Context context) {
        synchronized (Realm.class) {
            if (BaseRealm.applicationContext == null) {
                if (context == null) {
                    throw new IllegalArgumentException("Non-null context required.");
                }
                RealmCore.loadLibrary(context);
                defaultConfiguration = new RealmConfiguration.Builder(context).build();
                ObjectServerFacade.getSyncFacadeIfPossible().init(context);
                BaseRealm.applicationContext = context.getApplicationContext();
                SharedRealm.initialize(new File(context.getFilesDir(), ".realm.temp"));
            }
        }
    }

    public static Realm getDefaultInstance() {
        if (defaultConfiguration != null) {
            return (Realm) RealmCache.createRealmOrGetFromCache(defaultConfiguration, Realm.class);
        }
        throw new IllegalStateException("Call `Realm.init(Context)` before calling this method.");
    }

    public static Realm getInstance(RealmConfiguration configuration) {
        if (configuration != null) {
            return (Realm) RealmCache.createRealmOrGetFromCache(configuration, Realm.class);
        }
        throw new IllegalArgumentException("A non-null RealmConfiguration must be provided");
    }

    public static void setDefaultConfiguration(RealmConfiguration configuration) {
        if (configuration == null) {
            throw new IllegalArgumentException("A non-null RealmConfiguration must be provided");
        }
        defaultConfiguration = configuration;
    }

    public static void removeDefaultConfiguration() {
        defaultConfiguration = null;
    }

    static Realm createInstance(RealmConfiguration configuration, ColumnIndices[] globalCacheArray) {
        try {
            return createAndValidate(configuration, globalCacheArray);
        } catch (RealmMigrationNeededException e) {
            if (configuration.shouldDeleteRealmIfMigrationNeeded()) {
                deleteRealm(configuration);
            } else {
                try {
                    migrateRealm(configuration, e);
                } catch (FileNotFoundException fileNotFoundException) {
                    throw new RealmFileException(RealmFileException.Kind.NOT_FOUND, (Throwable) fileNotFoundException);
                }
            }
            return createAndValidate(configuration, globalCacheArray);
        }
    }

    static Realm createAndValidate(RealmConfiguration configuration, ColumnIndices[] globalCacheArray) {
        Realm realm = new Realm(configuration);
        long currentVersion = realm.getVersion();
        long requiredVersion = configuration.getSchemaVersion();
        ColumnIndices columnIndices = RealmCache.findColumnIndices(globalCacheArray, requiredVersion);
        if (columnIndices != null) {
            realm.schema.columnIndices = columnIndices.clone();
        } else {
            boolean syncingConfig = configuration.isSyncConfiguration();
            if (!syncingConfig && currentVersion != -1) {
                if (currentVersion < requiredVersion) {
                    realm.doClose();
                    throw new RealmMigrationNeededException(configuration.getPath(), String.format("Realm on disk need to migrate from v%s to v%s", new Object[]{Long.valueOf(currentVersion), Long.valueOf(requiredVersion)}));
                } else if (requiredVersion < currentVersion) {
                    realm.doClose();
                    throw new IllegalArgumentException(String.format("Realm on disk is newer than the one specified: v%s vs. v%s", new Object[]{Long.valueOf(currentVersion), Long.valueOf(requiredVersion)}));
                }
            }
            if (!syncingConfig) {
                try {
                    initializeRealm(realm);
                } catch (RuntimeException e) {
                    realm.doClose();
                    throw e;
                }
            } else {
                initializeSyncedRealm(realm);
            }
        }
        return realm;
    }

    private static void initializeRealm(Realm realm) {
        Transaction transaction;
        boolean unversioned = false;
        try {
            realm.beginTransaction();
            long currentVersion = realm.getVersion();
            if (currentVersion == -1) {
                unversioned = true;
            }
            boolean commitChanges = unversioned;
            if (unversioned) {
                realm.setVersion(realm.configuration.getSchemaVersion());
            }
            RealmProxyMediator mediator = realm.configuration.getSchemaMediator();
            Set<Class<? extends RealmModel>> modelClasses = mediator.getModelClasses();
            Map<Class<? extends RealmModel>, ColumnInfo> columnInfoMap = new HashMap<>(modelClasses.size());
            for (Class<? extends RealmModel> modelClass : modelClasses) {
                if (unversioned) {
                    mediator.createTable(modelClass, realm.sharedRealm);
                }
                columnInfoMap.put(modelClass, mediator.validateTable(modelClass, realm.sharedRealm, false));
            }
            RealmSchema realmSchema = realm.schema;
            if (unversioned) {
                currentVersion = realm.configuration.getSchemaVersion();
            }
            realmSchema.columnIndices = new ColumnIndices(currentVersion, columnInfoMap);
            if (unversioned && (transaction = realm.configuration.getInitialDataTransaction()) != null) {
                transaction.execute(realm);
            }
            if (commitChanges) {
                realm.commitTransaction();
            } else {
                realm.cancelTransaction();
            }
        } catch (Exception e) {
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                realm.commitTransaction();
            } else {
                realm.cancelTransaction();
            }
            throw th;
        }
    }

    private static void initializeSyncedRealm(Realm realm) {
        Transaction transaction;
        boolean commitChanges = false;
        try {
            realm.beginTransaction();
            long currentVersion = realm.getVersion();
            boolean unversioned = currentVersion == -1;
            RealmProxyMediator mediator = realm.configuration.getSchemaMediator();
            Set<Class<? extends RealmModel>> modelClasses = mediator.getModelClasses();
            ArrayList<RealmObjectSchema> realmObjectSchemas = new ArrayList<>();
            RealmSchema realmSchemaCache = new RealmSchema();
            for (Class<? extends RealmModel> modelClass : modelClasses) {
                realmObjectSchemas.add(mediator.createRealmObjectSchema(modelClass, realmSchemaCache));
            }
            RealmSchema schema = new RealmSchema(realmObjectSchemas);
            long newVersion = realm.configuration.getSchemaVersion();
            if (realm.sharedRealm.requiresMigration(schema)) {
                if (currentVersion >= newVersion) {
                    throw new IllegalArgumentException(String.format("The schema was changed but the schema version was not updated. The configured schema version (%d) must be higher than the one in the Realm file (%d) in order to update the schema.", new Object[]{Long.valueOf(newVersion), Long.valueOf(currentVersion)}));
                }
                realm.sharedRealm.updateSchema(schema, newVersion);
                realm.setVersion(newVersion);
                commitChanges = true;
            }
            Map<Class<? extends RealmModel>, ColumnInfo> columnInfoMap = new HashMap<>(modelClasses.size());
            for (Class<? extends RealmModel> modelClass2 : modelClasses) {
                columnInfoMap.put(modelClass2, mediator.validateTable(modelClass2, realm.sharedRealm, false));
            }
            RealmSchema realmSchema = realm.schema;
            if (!unversioned) {
                newVersion = currentVersion;
            }
            realmSchema.columnIndices = new ColumnIndices(newVersion, columnInfoMap);
            if (unversioned && (transaction = realm.configuration.getInitialDataTransaction()) != null) {
                transaction.execute(realm);
            }
            if (commitChanges) {
                realm.commitTransaction();
            } else {
                realm.cancelTransaction();
            }
        } catch (Exception e) {
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                realm.commitTransaction();
            } else {
                realm.cancelTransaction();
            }
            throw th;
        }
    }

    public <E extends RealmModel> void createAllFromJson(Class<E> clazz, JSONArray json) {
        if (clazz != null && json != null) {
            checkIfValid();
            int i = 0;
            while (i < json.length()) {
                try {
                    this.configuration.getSchemaMediator().createOrUpdateUsingJsonObject(clazz, this, json.getJSONObject(i), false);
                    i++;
                } catch (JSONException e) {
                    throw new RealmException("Could not map JSON", e);
                }
            }
        }
    }

    public <E extends RealmModel> void createOrUpdateAllFromJson(Class<E> clazz, JSONArray json) {
        if (clazz != null && json != null) {
            checkIfValid();
            checkHasPrimaryKey(clazz);
            int i = 0;
            while (i < json.length()) {
                try {
                    this.configuration.getSchemaMediator().createOrUpdateUsingJsonObject(clazz, this, json.getJSONObject(i), true);
                    i++;
                } catch (JSONException e) {
                    throw new RealmException("Could not map JSON", e);
                }
            }
        }
    }

    public <E extends RealmModel> void createAllFromJson(Class<E> clazz, String json) {
        if (clazz != null && json != null && json.length() != 0) {
            try {
                createAllFromJson(clazz, new JSONArray(json));
            } catch (JSONException e) {
                throw new RealmException("Could not create JSON array from string", e);
            }
        }
    }

    public <E extends RealmModel> void createOrUpdateAllFromJson(Class<E> clazz, String json) {
        if (clazz != null && json != null && json.length() != 0) {
            checkIfValid();
            checkHasPrimaryKey(clazz);
            try {
                createOrUpdateAllFromJson(clazz, new JSONArray(json));
            } catch (JSONException e) {
                throw new RealmException("Could not create JSON array from string", e);
            }
        }
    }

    @TargetApi(11)
    public <E extends RealmModel> void createAllFromJson(Class<E> clazz, InputStream inputStream) throws IOException {
        if (clazz != null && inputStream != null) {
            checkIfValid();
            JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
            try {
                reader.beginArray();
                while (reader.hasNext()) {
                    this.configuration.getSchemaMediator().createUsingJsonStream(clazz, this, reader);
                }
                reader.endArray();
            } finally {
                reader.close();
            }
        }
    }

    @TargetApi(11)
    public <E extends RealmModel> void createOrUpdateAllFromJson(Class<E> clazz, InputStream in) throws IOException {
        if (clazz != null && in != null) {
            checkIfValid();
            checkHasPrimaryKey(clazz);
            Scanner scanner = null;
            try {
                Scanner scanner2 = getFullStringScanner(in);
                JSONArray json = new JSONArray(scanner2.next());
                for (int i = 0; i < json.length(); i++) {
                    this.configuration.getSchemaMediator().createOrUpdateUsingJsonObject(clazz, this, json.getJSONObject(i), true);
                }
                if (scanner2 != null) {
                    scanner2.close();
                }
            } catch (JSONException e) {
                throw new RealmException("Failed to read JSON", e);
            } catch (Throwable th) {
                if (scanner != null) {
                    scanner.close();
                }
                throw th;
            }
        }
    }

    public <E extends RealmModel> E createObjectFromJson(Class<E> clazz, JSONObject json) {
        if (clazz == null || json == null) {
            return null;
        }
        checkIfValid();
        try {
            return this.configuration.getSchemaMediator().createOrUpdateUsingJsonObject(clazz, this, json, false);
        } catch (JSONException e) {
            throw new RealmException("Could not map JSON", e);
        }
    }

    public <E extends RealmModel> E createOrUpdateObjectFromJson(Class<E> clazz, JSONObject json) {
        if (clazz == null || json == null) {
            return null;
        }
        checkIfValid();
        checkHasPrimaryKey(clazz);
        try {
            return this.configuration.getSchemaMediator().createOrUpdateUsingJsonObject(clazz, this, json, true);
        } catch (JSONException e) {
            throw new RealmException("Could not map JSON", e);
        }
    }

    public <E extends RealmModel> E createObjectFromJson(Class<E> clazz, String json) {
        if (clazz == null || json == null || json.length() == 0) {
            return null;
        }
        try {
            return createObjectFromJson(clazz, new JSONObject(json));
        } catch (JSONException e) {
            throw new RealmException("Could not create Json object from string", e);
        }
    }

    public <E extends RealmModel> E createOrUpdateObjectFromJson(Class<E> clazz, String json) {
        if (clazz == null || json == null || json.length() == 0) {
            return null;
        }
        checkIfValid();
        checkHasPrimaryKey(clazz);
        try {
            return createOrUpdateObjectFromJson(clazz, new JSONObject(json));
        } catch (JSONException e) {
            throw new RealmException("Could not create Json object from string", e);
        }
    }

    @TargetApi(11)
    public <E extends RealmModel> E createObjectFromJson(Class<E> clazz, InputStream inputStream) throws IOException {
        if (clazz == null || inputStream == null) {
            return null;
        }
        checkIfValid();
        if (this.schema.getTable((Class<? extends RealmModel>) clazz).hasPrimaryKey()) {
            Scanner scanner = null;
            try {
                scanner = getFullStringScanner(inputStream);
                E createOrUpdateUsingJsonObject = this.configuration.getSchemaMediator().createOrUpdateUsingJsonObject(clazz, this, new JSONObject(scanner.next()), false);
                if (scanner == null) {
                    return createOrUpdateUsingJsonObject;
                }
                scanner.close();
                return createOrUpdateUsingJsonObject;
            } catch (JSONException e) {
                throw new RealmException("Failed to read JSON", e);
            } catch (Throwable th) {
                if (scanner != null) {
                    scanner.close();
                }
                throw th;
            }
        } else {
            JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
            try {
                return this.configuration.getSchemaMediator().createUsingJsonStream(clazz, this, reader);
            } finally {
                reader.close();
            }
        }
    }

    @TargetApi(11)
    public <E extends RealmModel> E createOrUpdateObjectFromJson(Class<E> clazz, InputStream in) throws IOException {
        if (clazz == null || in == null) {
            return null;
        }
        checkIfValid();
        checkHasPrimaryKey(clazz);
        Scanner scanner = null;
        try {
            scanner = getFullStringScanner(in);
            E createOrUpdateObjectFromJson = createOrUpdateObjectFromJson(clazz, new JSONObject(scanner.next()));
            if (scanner == null) {
                return createOrUpdateObjectFromJson;
            }
            scanner.close();
            return createOrUpdateObjectFromJson;
        } catch (JSONException e) {
            throw new RealmException("Failed to read JSON", e);
        } catch (Throwable th) {
            if (scanner != null) {
                scanner.close();
            }
            throw th;
        }
    }

    private Scanner getFullStringScanner(InputStream in) {
        return new Scanner(in, "UTF-8").useDelimiter("\\A");
    }

    public <E extends RealmModel> E createObject(Class<E> clazz) {
        checkIfValid();
        return createObjectInternal(clazz, true, Collections.emptyList());
    }

    /* access modifiers changed from: package-private */
    public <E extends RealmModel> E createObjectInternal(Class<E> clazz, boolean acceptDefaultValue, List<String> excludeFields) {
        Table table = this.schema.getTable((Class<? extends RealmModel>) clazz);
        if (table.hasPrimaryKey()) {
            throw new RealmException(String.format("'%s' has a primary key, use 'createObject(Class<E>, Object)' instead.", new Object[]{Table.tableNameToClassName(table.getName())}));
        }
        return get(clazz, table.addEmptyRow(), acceptDefaultValue, excludeFields);
    }

    public <E extends RealmModel> E createObject(Class<E> clazz, Object primaryKeyValue) {
        checkIfValid();
        return createObjectInternal(clazz, primaryKeyValue, true, Collections.emptyList());
    }

    /* access modifiers changed from: package-private */
    public <E extends RealmModel> E createObjectInternal(Class<E> clazz, Object primaryKeyValue, boolean acceptDefaultValue, List<String> excludeFields) {
        return get(clazz, this.schema.getTable((Class<? extends RealmModel>) clazz).addEmptyRowWithPrimaryKey(primaryKeyValue), acceptDefaultValue, excludeFields);
    }

    public <E extends RealmModel> E copyToRealm(E object) {
        checkNotNullObject(object);
        return copyOrUpdate(object, false, new HashMap());
    }

    public <E extends RealmModel> E copyToRealmOrUpdate(E object) {
        checkNotNullObject(object);
        checkHasPrimaryKey(object.getClass());
        return copyOrUpdate(object, true, new HashMap());
    }

    public <E extends RealmModel> List<E> copyToRealm(Iterable<E> objects) {
        if (objects == null) {
            return new ArrayList();
        }
        Map<RealmModel, RealmObjectProxy> cache = new HashMap<>();
        ArrayList<E> realmObjects = new ArrayList<>();
        for (E object : objects) {
            checkNotNullObject(object);
            realmObjects.add(copyOrUpdate(object, false, cache));
        }
        return realmObjects;
    }

    public void insert(Collection<? extends RealmModel> objects) {
        checkIfValidAndInTransaction();
        if (objects == null) {
            throw new IllegalArgumentException("Null objects cannot be inserted into Realm.");
        } else if (!objects.isEmpty()) {
            this.configuration.getSchemaMediator().insert(this, objects);
        }
    }

    public void insert(RealmModel object) {
        checkIfValidAndInTransaction();
        if (object == null) {
            throw new IllegalArgumentException("Null object cannot be inserted into Realm.");
        }
        this.configuration.getSchemaMediator().insert(this, object, new HashMap<>());
    }

    public void insertOrUpdate(Collection<? extends RealmModel> objects) {
        checkIfValidAndInTransaction();
        if (objects == null) {
            throw new IllegalArgumentException("Null objects cannot be inserted into Realm.");
        } else if (!objects.isEmpty()) {
            this.configuration.getSchemaMediator().insertOrUpdate(this, objects);
        }
    }

    public void insertOrUpdate(RealmModel object) {
        checkIfValidAndInTransaction();
        if (object == null) {
            throw new IllegalArgumentException("Null object cannot be inserted into Realm.");
        }
        this.configuration.getSchemaMediator().insertOrUpdate(this, object, new HashMap<>());
    }

    public <E extends RealmModel> List<E> copyToRealmOrUpdate(Iterable<E> objects) {
        if (objects == null) {
            return new ArrayList(0);
        }
        Map<RealmModel, RealmObjectProxy> cache = new HashMap<>();
        ArrayList<E> realmObjects = new ArrayList<>();
        for (E object : objects) {
            checkNotNullObject(object);
            realmObjects.add(copyOrUpdate(object, true, cache));
        }
        return realmObjects;
    }

    public <E extends RealmModel> List<E> copyFromRealm(Iterable<E> realmObjects) {
        return copyFromRealm(realmObjects, Integer.MAX_VALUE);
    }

    public <E extends RealmModel> List<E> copyFromRealm(Iterable<E> realmObjects, int maxDepth) {
        checkMaxDepth(maxDepth);
        if (realmObjects == null) {
            return new ArrayList(0);
        }
        ArrayList<E> unmanagedObjects = new ArrayList<>();
        Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> listCache = new HashMap<>();
        for (E object : realmObjects) {
            checkValidObjectForDetach(object);
            unmanagedObjects.add(createDetachedCopy(object, maxDepth, listCache));
        }
        return unmanagedObjects;
    }

    public <E extends RealmModel> E copyFromRealm(E realmObject) {
        return copyFromRealm(realmObject, Integer.MAX_VALUE);
    }

    public <E extends RealmModel> E copyFromRealm(E realmObject, int maxDepth) {
        checkMaxDepth(maxDepth);
        checkValidObjectForDetach(realmObject);
        return createDetachedCopy(realmObject, maxDepth, new HashMap());
    }

    public <E extends RealmModel> RealmQuery<E> where(Class<E> clazz) {
        checkIfValid();
        return RealmQuery.createQuery(this, clazz);
    }

    public void addChangeListener(RealmChangeListener<Realm> listener) {
        addListener(listener);
    }

    public void removeChangeListener(RealmChangeListener<Realm> listener) {
        removeListener(listener);
    }

    public void removeAllChangeListeners() {
        removeAllListeners();
    }

    public void executeTransaction(Transaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction should not be null");
        }
        beginTransaction();
        try {
            transaction.execute(this);
            commitTransaction();
        } catch (Throwable e) {
            if (isInTransaction()) {
                cancelTransaction();
            } else {
                RealmLog.warn("Could not cancel transaction, not currently in a transaction.", new Object[0]);
            }
            throw e;
        }
    }

    public RealmAsyncTask executeTransactionAsync(Transaction transaction) {
        return executeTransactionAsync(transaction, (Transaction.OnSuccess) null, (Transaction.OnError) null);
    }

    public RealmAsyncTask executeTransactionAsync(Transaction transaction, Transaction.OnSuccess onSuccess) {
        if (onSuccess != null) {
            return executeTransactionAsync(transaction, onSuccess, (Transaction.OnError) null);
        }
        throw new IllegalArgumentException("onSuccess callback can't be null");
    }

    public RealmAsyncTask executeTransactionAsync(Transaction transaction, Transaction.OnError onError) {
        if (onError != null) {
            return executeTransactionAsync(transaction, (Transaction.OnSuccess) null, onError);
        }
        throw new IllegalArgumentException("onError callback can't be null");
    }

    public RealmAsyncTask executeTransactionAsync(Transaction transaction, Transaction.OnSuccess onSuccess, Transaction.OnError onError) {
        checkIfValid();
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction should not be null");
        }
        final boolean canDeliverNotification = this.sharedRealm.capabilities.canDeliverNotification();
        if (!(onSuccess == null && onError == null)) {
            this.sharedRealm.capabilities.checkCanDeliverNotification("Callback cannot be delivered on current thread.");
        }
        final RealmConfiguration realmConfiguration = getConfiguration();
        final RealmNotifier realmNotifier = this.sharedRealm.realmNotifier;
        final Transaction transaction2 = transaction;
        final Transaction.OnSuccess onSuccess2 = onSuccess;
        final Transaction.OnError onError2 = onError;
        return new RealmAsyncTaskImpl(asyncTaskExecutor.submitTransaction(new Runnable() {
            public void run() {
                if (!Thread.currentThread().isInterrupted()) {
                    final SharedRealm.VersionID[] versionID = new SharedRealm.VersionID[1];
                    Throwable[] exception = new Throwable[1];
                    Realm bgRealm = Realm.getInstance(realmConfiguration);
                    bgRealm.beginTransaction();
                    try {
                        transaction2.execute(bgRealm);
                        if (!Thread.currentThread().isInterrupted()) {
                            bgRealm.commitTransaction();
                            versionID[0] = bgRealm.sharedRealm.getVersionID();
                            bgRealm.close();
                            final Throwable backgroundException = exception[0];
                            if (canDeliverNotification) {
                                if (versionID[0] != null && onSuccess2 != null) {
                                    realmNotifier.post(new Runnable() {
                                        public void run() {
                                            if (Realm.this.isClosed()) {
                                                onSuccess2.onSuccess();
                                            } else if (Realm.this.sharedRealm.getVersionID().compareTo(versionID[0]) < 0) {
                                                Realm.this.sharedRealm.realmNotifier.addTransactionCallback(new Runnable() {
                                                    public void run() {
                                                        onSuccess2.onSuccess();
                                                    }
                                                });
                                            } else {
                                                onSuccess2.onSuccess();
                                            }
                                        }
                                    });
                                } else if (backgroundException != null) {
                                    realmNotifier.post(new Runnable() {
                                        public void run() {
                                            if (onError2 != null) {
                                                onError2.onError(backgroundException);
                                                return;
                                            }
                                            throw new RealmException("Async transaction failed", backgroundException);
                                        }
                                    });
                                }
                            } else if (backgroundException != null) {
                                throw new RealmException("Async transaction failed", backgroundException);
                            }
                        }
                    } catch (Throwable e) {
                        exception[0] = e;
                    } finally {
                        bgRealm.close();
                    }
                }
            }
        }), asyncTaskExecutor);
    }

    public void delete(Class<? extends RealmModel> clazz) {
        checkIfValid();
        this.schema.getTable(clazz).clear();
    }

    private <E extends RealmModel> E copyOrUpdate(E object, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        checkIfValid();
        return this.configuration.getSchemaMediator().copyOrUpdate(this, object, update, cache);
    }

    private <E extends RealmModel> E createDetachedCopy(E object, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        checkIfValid();
        return this.configuration.getSchemaMediator().createDetachedCopy(object, maxDepth, cache);
    }

    private <E extends RealmModel> void checkNotNullObject(E object) {
        if (object == null) {
            throw new IllegalArgumentException("Null objects cannot be copied into Realm.");
        }
    }

    private void checkHasPrimaryKey(Class<? extends RealmModel> clazz) {
        if (!this.schema.getTable(clazz).hasPrimaryKey()) {
            throw new IllegalArgumentException("A RealmObject with no @PrimaryKey cannot be updated: " + clazz.toString());
        }
    }

    private void checkMaxDepth(int maxDepth) {
        if (maxDepth < 0) {
            throw new IllegalArgumentException("maxDepth must be > 0. It was: " + maxDepth);
        }
    }

    private <E extends RealmModel> void checkValidObjectForDetach(E realmObject) {
        if (realmObject == null) {
            throw new IllegalArgumentException("Null objects cannot be copied from Realm.");
        } else if (!RealmObject.isManaged(realmObject) || !RealmObject.isValid(realmObject)) {
            throw new IllegalArgumentException("Only valid managed objects can be copied from Realm.");
        } else if (realmObject instanceof DynamicRealmObject) {
            throw new IllegalArgumentException("DynamicRealmObject cannot be copied from Realm.");
        }
    }

    public static void migrateRealm(RealmConfiguration configuration) throws FileNotFoundException {
        migrateRealm(configuration, (RealmMigration) null);
    }

    private static void migrateRealm(RealmConfiguration configuration, RealmMigrationNeededException cause) throws FileNotFoundException {
        BaseRealm.migrateRealm(configuration, (RealmMigration) null, new BaseRealm.MigrationCallback() {
            public void migrationComplete() {
            }
        }, cause);
    }

    public static void migrateRealm(RealmConfiguration configuration, RealmMigration migration) throws FileNotFoundException {
        BaseRealm.migrateRealm(configuration, migration, new BaseRealm.MigrationCallback() {
            public void migrationComplete() {
            }
        }, (RealmMigrationNeededException) null);
    }

    public static boolean deleteRealm(RealmConfiguration configuration) {
        return BaseRealm.deleteRealm(configuration);
    }

    public static boolean compactRealm(RealmConfiguration configuration) {
        if (!configuration.isSyncConfiguration()) {
            return BaseRealm.compactRealm(configuration);
        }
        throw new UnsupportedOperationException("Compacting is not supported yet on synced Realms. See https://github.com/realm/realm-core/issues/2345");
    }

    /* access modifiers changed from: package-private */
    public Table getTable(Class<? extends RealmModel> clazz) {
        return this.schema.getTable(clazz);
    }

    /* access modifiers changed from: package-private */
    public ColumnIndices updateSchemaCache(ColumnIndices[] globalCacheArray) {
        long currentSchemaVersion = this.sharedRealm.getSchemaVersion();
        if (currentSchemaVersion == this.schema.columnIndices.getSchemaVersion()) {
            return null;
        }
        ColumnIndices createdGlobalCache = null;
        RealmProxyMediator mediator = getConfiguration().getSchemaMediator();
        ColumnIndices cacheForCurrentVersion = RealmCache.findColumnIndices(globalCacheArray, currentSchemaVersion);
        if (cacheForCurrentVersion == null) {
            Set<Class<? extends RealmModel>> modelClasses = mediator.getModelClasses();
            Map<Class<? extends RealmModel>, ColumnInfo> map = new HashMap<>(modelClasses.size());
            try {
                for (Class<? extends RealmModel> clazz : modelClasses) {
                    map.put(clazz, mediator.validateTable(clazz, this.sharedRealm, true));
                }
                createdGlobalCache = new ColumnIndices(currentSchemaVersion, map);
                cacheForCurrentVersion = createdGlobalCache;
            } catch (RealmMigrationNeededException e) {
                throw e;
            }
        }
        this.schema.columnIndices.copyFrom(cacheForCurrentVersion, mediator);
        return createdGlobalCache;
    }

    public static Object getDefaultModule() {
        try {
            Constructor<?> constructor = Class.forName("io.realm.DefaultRealmModule").getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            return constructor.newInstance(new Object[0]);
        } catch (ClassNotFoundException e) {
            return null;
        } catch (InvocationTargetException e2) {
            throw new RealmException("Could not create an instance of " + "io.realm.DefaultRealmModule", e2);
        } catch (InstantiationException e3) {
            throw new RealmException("Could not create an instance of " + "io.realm.DefaultRealmModule", e3);
        } catch (IllegalAccessException e4) {
            throw new RealmException("Could not create an instance of " + "io.realm.DefaultRealmModule", e4);
        }
    }

    public static int getGlobalInstanceCount(RealmConfiguration configuration) {
        final AtomicInteger globalCount = new AtomicInteger(0);
        RealmCache.invokeWithGlobalRefCount(configuration, new RealmCache.Callback() {
            public void onResult(int count) {
                globalCount.set(count);
            }
        });
        return globalCount.get();
    }

    public static int getLocalInstanceCount(RealmConfiguration configuration) {
        return RealmCache.getLocalThreadCount(configuration);
    }

    /* renamed from: io.realm.Realm$Transaction */
    public interface Transaction {

        /* renamed from: io.realm.Realm$Transaction$OnError */
        public interface OnError {
            void onError(Throwable th);
        }

        /* renamed from: io.realm.Realm$Transaction$OnSuccess */
        public interface OnSuccess {
            void onSuccess();
        }

        void execute(Realm realm);

        /* renamed from: io.realm.Realm$Transaction$Callback */
        public static class Callback {
            public void onSuccess() {
            }

            public void onError(Exception e) {
            }
        }
    }
}
