package p006io.realm;

import android.content.Context;
import android.os.Looper;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import p006io.realm.RealmCache;
import p006io.realm.exceptions.RealmMigrationNeededException;
import p006io.realm.internal.CheckedRow;
import p006io.realm.internal.ColumnInfo;
import p006io.realm.internal.InvalidRow;
import p006io.realm.internal.ObjectServerFacade;
import p006io.realm.internal.RealmObjectProxy;
import p006io.realm.internal.Row;
import p006io.realm.internal.SharedRealm;
import p006io.realm.internal.Table;
import p006io.realm.internal.UncheckedRow;
import p006io.realm.internal.Util;
import p006io.realm.internal.async.RealmThreadPoolExecutor;
import p006io.realm.log.RealmLog;
import rx.Observable;

/* renamed from: io.realm.BaseRealm */
abstract class BaseRealm implements Closeable {
    private static final String CLOSED_REALM_MESSAGE = "This Realm instance has already been closed, making it unusable.";
    private static final String INCORRECT_THREAD_CLOSE_MESSAGE = "Realm access from incorrect thread. Realm instance can only be closed on the thread it was created.";
    private static final String INCORRECT_THREAD_MESSAGE = "Realm access from incorrect thread. Realm objects can only be accessed on the thread they were created.";
    static final String LISTENER_NOT_ALLOWED_MESSAGE = "Listeners cannot be used on current thread.";
    private static final String NOT_IN_TRANSACTION_MESSAGE = "Changing Realm data can only be done from inside a transaction.";
    protected static final long UNVERSIONED = -1;
    static volatile Context applicationContext;
    static final RealmThreadPoolExecutor asyncTaskExecutor = RealmThreadPoolExecutor.newDefaultExecutor();
    public static final ThreadLocalRealmObjectContext objectContext = new ThreadLocalRealmObjectContext();
    protected RealmConfiguration configuration;
    RealmSchema schema;
    protected SharedRealm sharedRealm;
    final long threadId = Thread.currentThread().getId();

    /* renamed from: io.realm.BaseRealm$MigrationCallback */
    protected interface MigrationCallback {
        void migrationComplete();
    }

    public abstract Observable asObservable();

    protected BaseRealm(RealmConfiguration configuration2) {
        this.configuration = configuration2;
        this.sharedRealm = SharedRealm.getInstance(configuration2, !(this instanceof Realm) ? null : new SharedRealm.SchemaVersionListener() {
            public void onSchemaVersionChanged(long currentVersion) {
                RealmCache.updateSchemaCache((Realm) BaseRealm.this);
            }
        }, true);
        this.schema = new RealmSchema(this);
    }

    public void setAutoRefresh(boolean autoRefresh) {
        checkIfValid();
        this.sharedRealm.setAutoRefresh(autoRefresh);
    }

    public boolean isAutoRefresh() {
        return this.sharedRealm.isAutoRefresh();
    }

    public boolean isInTransaction() {
        checkIfValid();
        return this.sharedRealm.isInTransaction();
    }

    /* access modifiers changed from: protected */
    public <T extends BaseRealm> void addListener(RealmChangeListener<T> listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Listener should not be null");
        }
        checkIfValid();
        this.sharedRealm.capabilities.checkCanDeliverNotification(LISTENER_NOT_ALLOWED_MESSAGE);
        this.sharedRealm.realmNotifier.addChangeListener(this, listener);
    }

    /* access modifiers changed from: protected */
    public <T extends BaseRealm> void removeListener(RealmChangeListener<T> listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Listener should not be null");
        }
        checkIfValid();
        this.sharedRealm.capabilities.checkCanDeliverNotification(LISTENER_NOT_ALLOWED_MESSAGE);
        this.sharedRealm.realmNotifier.removeChangeListener(this, listener);
    }

    /* access modifiers changed from: protected */
    public void removeAllListeners() {
        checkIfValid();
        this.sharedRealm.capabilities.checkCanDeliverNotification("removeListener cannot be called on current thread.");
        this.sharedRealm.realmNotifier.removeChangeListeners(this);
    }

    public void writeCopyTo(File destination) {
        writeEncryptedCopyTo(destination, (byte[]) null);
    }

    public void writeEncryptedCopyTo(File destination, byte[] key) {
        if (destination == null) {
            throw new IllegalArgumentException("The destination argument cannot be null");
        }
        checkIfValid();
        this.sharedRealm.writeCopy(destination, key);
    }

    public boolean waitForChange() {
        checkIfValid();
        if (isInTransaction()) {
            throw new IllegalStateException("Cannot wait for changes inside of a transaction.");
        } else if (Looper.myLooper() != null) {
            throw new IllegalStateException("Cannot wait for changes inside a Looper thread. Use RealmChangeListeners instead.");
        } else {
            boolean hasChanged = this.sharedRealm.waitForChange();
            if (hasChanged) {
                this.sharedRealm.refresh();
            }
            return hasChanged;
        }
    }

    public void stopWaitForChange() {
        RealmCache.invokeWithLock(new RealmCache.Callback0() {
            public void onCall() {
                if (BaseRealm.this.sharedRealm == null || BaseRealm.this.sharedRealm.isClosed()) {
                    throw new IllegalStateException(BaseRealm.CLOSED_REALM_MESSAGE);
                }
                BaseRealm.this.sharedRealm.stopWaitForChange();
            }
        });
    }

    public void beginTransaction() {
        checkIfValid();
        this.sharedRealm.beginTransaction();
    }

    public void commitTransaction() {
        checkIfValid();
        this.sharedRealm.commitTransaction();
        if (!isClosed()) {
            ObjectServerFacade.getFacade(this.configuration.isSyncConfiguration()).notifyCommit(this.configuration, this.sharedRealm.getLastSnapshotVersion());
        }
    }

    public void cancelTransaction() {
        checkIfValid();
        this.sharedRealm.cancelTransaction();
    }

    /* access modifiers changed from: protected */
    public void checkIfValid() {
        if (this.sharedRealm == null || this.sharedRealm.isClosed()) {
            throw new IllegalStateException(CLOSED_REALM_MESSAGE);
        } else if (this.threadId != Thread.currentThread().getId()) {
            throw new IllegalStateException(INCORRECT_THREAD_MESSAGE);
        }
    }

    /* access modifiers changed from: protected */
    public void checkIfInTransaction() {
        if (!this.sharedRealm.isInTransaction()) {
            throw new IllegalStateException(NOT_IN_TRANSACTION_MESSAGE);
        }
    }

    /* access modifiers changed from: protected */
    public void checkIfValidAndInTransaction() {
        if (!isInTransaction()) {
            throw new IllegalStateException(NOT_IN_TRANSACTION_MESSAGE);
        }
    }

    /* access modifiers changed from: package-private */
    public void checkNotInSync() {
        if (this.configuration.isSyncConfiguration()) {
            throw new IllegalArgumentException("You cannot perform changes to a schema. Please update app and restart.");
        }
    }

    public String getPath() {
        return this.configuration.getPath();
    }

    public RealmConfiguration getConfiguration() {
        return this.configuration;
    }

    public long getVersion() {
        return this.sharedRealm.getSchemaVersion();
    }

    public void close() {
        if (this.threadId != Thread.currentThread().getId()) {
            throw new IllegalStateException(INCORRECT_THREAD_CLOSE_MESSAGE);
        }
        RealmCache.release(this);
    }

    /* access modifiers changed from: package-private */
    public void doClose() {
        if (this.sharedRealm != null) {
            this.sharedRealm.close();
            this.sharedRealm = null;
        }
        if (this.schema != null) {
            this.schema.close();
        }
    }

    public boolean isClosed() {
        if (this.threadId == Thread.currentThread().getId()) {
            return this.sharedRealm == null || this.sharedRealm.isClosed();
        }
        throw new IllegalStateException(INCORRECT_THREAD_MESSAGE);
    }

    public boolean isEmpty() {
        checkIfValid();
        return this.sharedRealm.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public void setVersion(long version) {
        this.sharedRealm.setSchemaVersion(version);
    }

    public RealmSchema getSchema() {
        return this.schema;
    }

    /* access modifiers changed from: package-private */
    public <E extends RealmModel> E get(Class<E> clazz, String dynamicClassName, UncheckedRow row) {
        boolean isDynamicRealmObject;
        E result;
        if (dynamicClassName != null) {
            isDynamicRealmObject = true;
        } else {
            isDynamicRealmObject = false;
        }
        if (isDynamicRealmObject) {
            result = new DynamicRealmObject(this, CheckedRow.getFromRow(row));
        } else {
            result = this.configuration.getSchemaMediator().newInstance(clazz, this, row, this.schema.getColumnInfo(clazz), false, Collections.emptyList());
        }
        ((RealmObjectProxy) result).realmGet$proxyState().setTableVersion$realm();
        return result;
    }

    /* access modifiers changed from: package-private */
    public <E extends RealmModel> E get(Class<E> clazz, long rowIndex, boolean acceptDefaultValue, List<String> excludeFields) {
        UncheckedRow row = this.schema.getTable((Class<? extends RealmModel>) clazz).getUncheckedRow(rowIndex);
        E result = this.configuration.getSchemaMediator().newInstance(clazz, this, row, this.schema.getColumnInfo(clazz), acceptDefaultValue, excludeFields);
        ((RealmObjectProxy) result).realmGet$proxyState().setTableVersion$realm();
        return result;
    }

    /* access modifiers changed from: package-private */
    public <E extends RealmModel> E get(Class<E> clazz, String dynamicClassName, long rowIndex) {
        E result;
        boolean isDynamicRealmObject = dynamicClassName != null;
        Table table = isDynamicRealmObject ? this.schema.getTable(dynamicClassName) : this.schema.getTable((Class<? extends RealmModel>) clazz);
        if (isDynamicRealmObject) {
            result = new DynamicRealmObject(this, rowIndex != -1 ? table.getCheckedRow(rowIndex) : InvalidRow.INSTANCE);
        } else {
            result = this.configuration.getSchemaMediator().newInstance(clazz, this, rowIndex != -1 ? table.getUncheckedRow(rowIndex) : InvalidRow.INSTANCE, this.schema.getColumnInfo(clazz), false, Collections.emptyList());
        }
        RealmObjectProxy proxy = (RealmObjectProxy) result;
        if (rowIndex != -1) {
            proxy.realmGet$proxyState().setTableVersion$realm();
        }
        return result;
    }

    public void deleteAll() {
        checkIfValid();
        for (RealmObjectSchema objectSchema : this.schema.getAll()) {
            this.schema.getTable(objectSchema.getClassName()).clear();
        }
    }

    static boolean deleteRealm(final RealmConfiguration configuration2) {
        final AtomicBoolean realmDeleted = new AtomicBoolean(true);
        RealmCache.invokeWithGlobalRefCount(configuration2, new RealmCache.Callback() {
            public void onResult(int count) {
                if (count != 0) {
                    throw new IllegalStateException("It's not allowed to delete the file associated with an open Realm. Remember to close() all the instances of the Realm before deleting its file: " + configuration2.getPath());
                }
                realmDeleted.set(Util.deleteRealm(configuration2.getPath(), configuration2.getRealmDirectory(), configuration2.getRealmFileName()));
            }
        });
        return realmDeleted.get();
    }

    static boolean compactRealm(RealmConfiguration configuration2) {
        SharedRealm sharedRealm2 = SharedRealm.getInstance(configuration2);
        Boolean result = Boolean.valueOf(sharedRealm2.compact());
        sharedRealm2.close();
        return result.booleanValue();
    }

    protected static void migrateRealm(final RealmConfiguration configuration2, final RealmMigration migration, final MigrationCallback callback, RealmMigrationNeededException cause) throws FileNotFoundException {
        if (configuration2 == null) {
            throw new IllegalArgumentException("RealmConfiguration must be provided");
        } else if (!configuration2.isSyncConfiguration()) {
            if (migration == null && configuration2.getMigration() == null) {
                throw new RealmMigrationNeededException(configuration2.getPath(), "RealmMigration must be provided", cause);
            }
            final AtomicBoolean fileNotFound = new AtomicBoolean(false);
            RealmCache.invokeWithGlobalRefCount(configuration2, new RealmCache.Callback() {
                public void onResult(int count) {
                    if (count != 0) {
                        throw new IllegalStateException("Cannot migrate a Realm file that is already open: " + configuration2.getPath());
                    } else if (!new File(configuration2.getPath()).exists()) {
                        fileNotFound.set(true);
                    } else {
                        RealmMigration realmMigration = migration == null ? configuration2.getMigration() : migration;
                        DynamicRealm realm = null;
                        try {
                            realm = DynamicRealm.getInstance(configuration2);
                            realm.beginTransaction();
                            realmMigration.migrate(realm, realm.getVersion(), configuration2.getSchemaVersion());
                            realm.setVersion(configuration2.getSchemaVersion());
                            realm.commitTransaction();
                            if (realm != null) {
                                realm.close();
                                callback.migrationComplete();
                            }
                        } catch (RuntimeException e) {
                            if (realm != null) {
                                realm.cancelTransaction();
                            }
                            throw e;
                        } catch (Throwable th) {
                            if (realm != null) {
                                realm.close();
                                callback.migrationComplete();
                            }
                            throw th;
                        }
                    }
                }
            });
            if (fileNotFound.get()) {
                throw new FileNotFoundException("Cannot migrate a Realm file which doesn't exist: " + configuration2.getPath());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        if (this.sharedRealm != null && !this.sharedRealm.isClosed()) {
            RealmLog.warn("Remember to call close() on all Realm instances. Realm %s is being finalized without being closed, this can lead to running out of native memory.", this.configuration.getPath());
        }
        super.finalize();
    }

    /* renamed from: io.realm.BaseRealm$RealmObjectContext */
    public static final class RealmObjectContext {
        private boolean acceptDefaultValue;
        private ColumnInfo columnInfo;
        private List<String> excludeFields;
        private BaseRealm realm;
        private Row row;

        public void set(BaseRealm realm2, Row row2, ColumnInfo columnInfo2, boolean acceptDefaultValue2, List<String> excludeFields2) {
            this.realm = realm2;
            this.row = row2;
            this.columnInfo = columnInfo2;
            this.acceptDefaultValue = acceptDefaultValue2;
            this.excludeFields = excludeFields2;
        }

        public BaseRealm getRealm() {
            return this.realm;
        }

        public Row getRow() {
            return this.row;
        }

        public ColumnInfo getColumnInfo() {
            return this.columnInfo;
        }

        public boolean getAcceptDefaultValue() {
            return this.acceptDefaultValue;
        }

        public List<String> getExcludeFields() {
            return this.excludeFields;
        }

        public void clear() {
            this.realm = null;
            this.row = null;
            this.columnInfo = null;
            this.acceptDefaultValue = false;
            this.excludeFields = null;
        }
    }

    /* renamed from: io.realm.BaseRealm$ThreadLocalRealmObjectContext */
    static final class ThreadLocalRealmObjectContext extends ThreadLocal<RealmObjectContext> {
        ThreadLocalRealmObjectContext() {
        }

        /* access modifiers changed from: protected */
        public RealmObjectContext initialValue() {
            return new RealmObjectContext();
        }
    }
}
