package p006io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.training.fragment.rememberwords.repository.entity.RememberWordsConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p006io.realm.BaseRealm;
import p006io.realm.exceptions.RealmException;
import p006io.realm.exceptions.RealmMigrationNeededException;
import p006io.realm.internal.ColumnInfo;
import p006io.realm.internal.RealmObjectProxy;
import p006io.realm.internal.Row;
import p006io.realm.internal.SharedRealm;
import p006io.realm.internal.Table;
import p006io.realm.log.RealmLog;

/* renamed from: io.realm.RememberWordsConfigRealmProxy */
public class RememberWordsConfigRealmProxy extends RememberWordsConfig implements RealmObjectProxy, RememberWordsConfigRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private RememberWordsConfigColumnInfo columnInfo;
    private ProxyState<RememberWordsConfig> proxyState;

    /* renamed from: io.realm.RememberWordsConfigRealmProxy$RememberWordsConfigColumnInfo */
    static final class RememberWordsConfigColumnInfo extends ColumnInfo implements Cloneable {
        public long idIndex;
        public long startWordsCountIndex;

        RememberWordsConfigColumnInfo(String path, Table table) {
            Map<String, Long> indicesMap = new HashMap<>(2);
            this.idIndex = getValidColumnIndex(path, table, "RememberWordsConfig", IdentityRealmObject.FIELD_ID);
            indicesMap.put(IdentityRealmObject.FIELD_ID, Long.valueOf(this.idIndex));
            this.startWordsCountIndex = getValidColumnIndex(path, table, "RememberWordsConfig", RememberWordsConfig.FIELD_START_WORDS_COUNT);
            indicesMap.put(RememberWordsConfig.FIELD_START_WORDS_COUNT, Long.valueOf(this.startWordsCountIndex));
            setIndicesMap(indicesMap);
        }

        public final void copyColumnInfoFrom(ColumnInfo other) {
            RememberWordsConfigColumnInfo otherInfo = (RememberWordsConfigColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.startWordsCountIndex = otherInfo.startWordsCountIndex;
            setIndicesMap(otherInfo.getIndicesMap());
        }

        public final RememberWordsConfigColumnInfo clone() {
            return (RememberWordsConfigColumnInfo) super.clone();
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add(IdentityRealmObject.FIELD_ID);
        fieldNames.add(RememberWordsConfig.FIELD_START_WORDS_COUNT);
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    RememberWordsConfigRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext context = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (RememberWordsConfigColumnInfo) context.getColumnInfo();
            this.proxyState = new ProxyState<>(this);
            this.proxyState.setRealm$realm(context.getRealm());
            this.proxyState.setRow$realm(context.getRow());
            this.proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(context.getExcludeFields());
        }
    }

    public int realmGet$id() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.idIndex);
    }

    public void realmSet$id(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            throw new RealmException("Primary key field 'id' cannot be changed after object was created.");
        }
    }

    public int realmGet$startWordsCount() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.startWordsCountIndex);
    }

    public void realmSet$startWordsCount(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.startWordsCountIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.startWordsCountIndex, row.getIndex(), (long) value, true);
        }
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (realmSchema.contains("RememberWordsConfig")) {
            return realmSchema.get("RememberWordsConfig");
        }
        RealmObjectSchema realmObjectSchema = realmSchema.create("RememberWordsConfig");
        realmObjectSchema.add(new Property(IdentityRealmObject.FIELD_ID, RealmFieldType.INTEGER, true, true, true));
        realmObjectSchema.add(new Property(RememberWordsConfig.FIELD_START_WORDS_COUNT, RealmFieldType.INTEGER, false, false, true));
        return realmObjectSchema;
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (sharedRealm.hasTable("class_RememberWordsConfig")) {
            return sharedRealm.getTable("class_RememberWordsConfig");
        }
        Table table = sharedRealm.getTable("class_RememberWordsConfig");
        table.addColumn(RealmFieldType.INTEGER, IdentityRealmObject.FIELD_ID, false);
        table.addColumn(RealmFieldType.INTEGER, RememberWordsConfig.FIELD_START_WORDS_COUNT, false);
        table.addSearchIndex(table.getColumnIndex(IdentityRealmObject.FIELD_ID));
        table.setPrimaryKey(IdentityRealmObject.FIELD_ID);
        return table;
    }

    public static RememberWordsConfigColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_RememberWordsConfig")) {
            Table table = sharedRealm.getTable("class_RememberWordsConfig");
            long columnCount = table.getColumnCount();
            if (columnCount != 2) {
                if (columnCount < 2) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 2 but was " + columnCount);
                } else if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 2 but was %1$d", Long.valueOf(columnCount));
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 2 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            RememberWordsConfigColumnInfo columnInfo2 = new RememberWordsConfigColumnInfo(sharedRealm.getPath(), table);
            if (!table.hasPrimaryKey()) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. @PrimaryKey was added.");
            } else if (table.getPrimaryKey() != columnInfo2.idIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field id");
            } else if (!columnTypes.containsKey(IdentityRealmObject.FIELD_ID)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(IdentityRealmObject.FIELD_ID) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'id' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.idIndex) && table.findFirstNull(columnInfo2.idIndex) != -1) {
                throw new IllegalStateException("Cannot migrate an object with null value in field 'id'. Either maintain the same type for primary key field 'id', or remove the object with null value before migration.");
            } else if (!table.hasSearchIndex(table.getColumnIndex(IdentityRealmObject.FIELD_ID))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            } else if (!columnTypes.containsKey(RememberWordsConfig.FIELD_START_WORDS_COUNT)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'startWordsCount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(RememberWordsConfig.FIELD_START_WORDS_COUNT) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'startWordsCount' in existing Realm file.");
            } else if (!table.isColumnNullable(columnInfo2.startWordsCountIndex)) {
                return columnInfo2;
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'startWordsCount' does support null values in the existing Realm file. Use corresponding boxed type for field 'startWordsCount' or migrate using RealmObjectSchema.setNullable().");
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'RememberWordsConfig' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_RememberWordsConfig";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static RememberWordsConfig createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update) throws JSONException {
        List emptyList = Collections.emptyList();
        RememberWordsConfig obj = null;
        if (update) {
            Table table = realm.getTable(RememberWordsConfig.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = -1;
            if (!json.isNull(IdentityRealmObject.FIELD_ID)) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong(IdentityRealmObject.FIELD_ID));
            }
            if (rowIndex != -1) {
                BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(RememberWordsConfig.class), false, Collections.emptyList());
                    obj = new RememberWordsConfigRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (!json.has(IdentityRealmObject.FIELD_ID)) {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            } else if (json.isNull(IdentityRealmObject.FIELD_ID)) {
                obj = (RememberWordsConfigRealmProxy) realm.createObjectInternal(RememberWordsConfig.class, (Object) null, true, emptyList);
            } else {
                obj = (RememberWordsConfigRealmProxy) realm.createObjectInternal(RememberWordsConfig.class, Integer.valueOf(json.getInt(IdentityRealmObject.FIELD_ID)), true, emptyList);
            }
        }
        if (json.has(RememberWordsConfig.FIELD_START_WORDS_COUNT)) {
            if (json.isNull(RememberWordsConfig.FIELD_START_WORDS_COUNT)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'startWordsCount' to null.");
            }
            obj.realmSet$startWordsCount(json.getInt(RememberWordsConfig.FIELD_START_WORDS_COUNT));
        }
        return obj;
    }

    @TargetApi(11)
    public static RememberWordsConfig createUsingJsonStream(Realm realm, JsonReader reader) throws IOException {
        boolean jsonHasPrimaryKey = false;
        RememberWordsConfig obj = new RememberWordsConfig();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals(IdentityRealmObject.FIELD_ID)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
                obj.realmSet$id(reader.nextInt());
                jsonHasPrimaryKey = true;
            } else if (!name.equals(RememberWordsConfig.FIELD_START_WORDS_COUNT)) {
                reader.skipValue();
            } else if (reader.peek() == JsonToken.NULL) {
                reader.skipValue();
                throw new IllegalArgumentException("Trying to set non-nullable field 'startWordsCount' to null.");
            } else {
                obj.realmSet$startWordsCount(reader.nextInt());
            }
        }
        reader.endObject();
        if (jsonHasPrimaryKey) {
            return (RememberWordsConfig) realm.copyToRealm(obj);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
    }

    public static RememberWordsConfig copyOrUpdate(Realm realm, RememberWordsConfig object, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        } else {
            BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            RealmObjectProxy cachedRealmObject = cache.get(object);
            if (cachedRealmObject != null) {
                return (RememberWordsConfig) cachedRealmObject;
            }
            RememberWordsConfig realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(RememberWordsConfig.class);
                long rowIndex = table.findFirstLong(table.getPrimaryKey(), (long) object.realmGet$id());
                if (rowIndex != -1) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(RememberWordsConfig.class), false, Collections.emptyList());
                        RememberWordsConfig realmObject2 = new RememberWordsConfigRealmProxy();
                        try {
                            cache.put(object, (RealmObjectProxy) realmObject2);
                            objectContext.clear();
                            realmObject = realmObject2;
                        } catch (Throwable th) {
                            th = th;
                            RememberWordsConfig rememberWordsConfig = realmObject2;
                            objectContext.clear();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        objectContext.clear();
                        throw th;
                    }
                } else {
                    canUpdate = false;
                }
            }
            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            }
            return copy(realm, object, update, cache);
        }
    }

    public static RememberWordsConfig copy(Realm realm, RememberWordsConfig newObject, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (RememberWordsConfig) cachedRealmObject;
        }
        RememberWordsConfig realmObject = (RememberWordsConfig) realm.createObjectInternal(RememberWordsConfig.class, Integer.valueOf(newObject.realmGet$id()), false, Collections.emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.realmSet$startWordsCount(newObject.realmGet$startWordsCount());
        return realmObject;
    }

    public static long insert(Realm realm, RememberWordsConfig object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(RememberWordsConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        RememberWordsConfigColumnInfo columnInfo2 = (RememberWordsConfigColumnInfo) realm.schema.getColumnInfo(RememberWordsConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = -1;
        Integer primaryKeyValue = Integer.valueOf(object.realmGet$id());
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, (long) object.realmGet$id());
        }
        if (rowIndex == -1) {
            rowIndex = table.addEmptyRowWithPrimaryKey(Integer.valueOf(object.realmGet$id()), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, Long.valueOf(rowIndex));
        Table.nativeSetLong(tableNativePtr, columnInfo2.startWordsCountIndex, rowIndex, (long) object.realmGet$startWordsCount(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(RememberWordsConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        RememberWordsConfigColumnInfo columnInfo2 = (RememberWordsConfigColumnInfo) realm.schema.getColumnInfo(RememberWordsConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            RememberWordsConfig object = (RememberWordsConfig) objects.next();
            if (!cache.containsKey(object)) {
                if (!(object instanceof RealmObjectProxy) || ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() == null || !((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    long rowIndex = -1;
                    Integer primaryKeyValue = Integer.valueOf(object.realmGet$id());
                    if (primaryKeyValue != null) {
                        rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, (long) object.realmGet$id());
                    }
                    if (rowIndex == -1) {
                        rowIndex = table.addEmptyRowWithPrimaryKey(Integer.valueOf(object.realmGet$id()), false);
                    } else {
                        Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                    }
                    cache.put(object, Long.valueOf(rowIndex));
                    Table.nativeSetLong(tableNativePtr, columnInfo2.startWordsCountIndex, rowIndex, (long) object.realmGet$startWordsCount(), false);
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, RememberWordsConfig object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(RememberWordsConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        RememberWordsConfigColumnInfo columnInfo2 = (RememberWordsConfigColumnInfo) realm.schema.getColumnInfo(RememberWordsConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = -1;
        if (Integer.valueOf(object.realmGet$id()) != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, (long) object.realmGet$id());
        }
        if (rowIndex == -1) {
            rowIndex = table.addEmptyRowWithPrimaryKey(Integer.valueOf(object.realmGet$id()), false);
        }
        cache.put(object, Long.valueOf(rowIndex));
        Table.nativeSetLong(tableNativePtr, columnInfo2.startWordsCountIndex, rowIndex, (long) object.realmGet$startWordsCount(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(RememberWordsConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        RememberWordsConfigColumnInfo columnInfo2 = (RememberWordsConfigColumnInfo) realm.schema.getColumnInfo(RememberWordsConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            RememberWordsConfig object = (RememberWordsConfig) objects.next();
            if (!cache.containsKey(object)) {
                if (!(object instanceof RealmObjectProxy) || ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() == null || !((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    long rowIndex = -1;
                    if (Integer.valueOf(object.realmGet$id()) != null) {
                        rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, (long) object.realmGet$id());
                    }
                    if (rowIndex == -1) {
                        rowIndex = table.addEmptyRowWithPrimaryKey(Integer.valueOf(object.realmGet$id()), false);
                    }
                    cache.put(object, Long.valueOf(rowIndex));
                    Table.nativeSetLong(tableNativePtr, columnInfo2.startWordsCountIndex, rowIndex, (long) object.realmGet$startWordsCount(), false);
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static RememberWordsConfig createDetachedCopy(RememberWordsConfig realmObject, int currentDepth, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        RememberWordsConfig unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        RealmObjectProxy.CacheData<RealmModel> cachedObject = cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new RememberWordsConfig();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.minDepth) {
            return (RememberWordsConfig) cachedObject.object;
        } else {
            unmanagedObject = (RememberWordsConfig) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        unmanagedObject.realmSet$id(realmObject.realmGet$id());
        unmanagedObject.realmSet$startWordsCount(realmObject.realmGet$startWordsCount());
        return unmanagedObject;
    }

    static RememberWordsConfig update(Realm realm, RememberWordsConfig realmObject, RememberWordsConfig newObject, Map<RealmModel, RealmObjectProxy> map) {
        realmObject.realmSet$startWordsCount(newObject.realmGet$startWordsCount());
        return realmObject;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        return "RememberWordsConfig = [" + "{id:" + realmGet$id() + "}" + "," + "{startWordsCount:" + realmGet$startWordsCount() + "}" + "]";
    }

    public ProxyState realmGet$proxyState() {
        return this.proxyState;
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        String realmName = this.proxyState.getRealm$realm().getPath();
        String tableName = this.proxyState.getRow$realm().getTable().getName();
        long rowIndex = this.proxyState.getRow$realm().getIndex();
        if (realmName != null) {
            i = realmName.hashCode();
        } else {
            i = 0;
        }
        int i3 = (i + 527) * 31;
        if (tableName != null) {
            i2 = tableName.hashCode();
        }
        return ((i3 + i2) * 31) + ((int) ((rowIndex >>> 32) ^ rowIndex));
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RememberWordsConfigRealmProxy aRememberWordsConfig = (RememberWordsConfigRealmProxy) o;
        String path = this.proxyState.getRealm$realm().getPath();
        String otherPath = aRememberWordsConfig.proxyState.getRealm$realm().getPath();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRememberWordsConfig.proxyState.getRow$realm().getTable().getName();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != aRememberWordsConfig.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
