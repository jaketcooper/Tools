package p006io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.training.fragment.truecolors.repository.entity.TrueColorsConfig;
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

/* renamed from: io.realm.TrueColorsConfigRealmProxy */
public class TrueColorsConfigRealmProxy extends TrueColorsConfig implements RealmObjectProxy, TrueColorsConfigRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private TrueColorsConfigColumnInfo columnInfo;
    private ProxyState<TrueColorsConfig> proxyState;

    /* renamed from: io.realm.TrueColorsConfigRealmProxy$TrueColorsConfigColumnInfo */
    static final class TrueColorsConfigColumnInfo extends ColumnInfo implements Cloneable {
        public long idIndex;
        public long showTimeIndex;

        TrueColorsConfigColumnInfo(String path, Table table) {
            Map<String, Long> indicesMap = new HashMap<>(2);
            this.idIndex = getValidColumnIndex(path, table, "TrueColorsConfig", IdentityRealmObject.FIELD_ID);
            indicesMap.put(IdentityRealmObject.FIELD_ID, Long.valueOf(this.idIndex));
            this.showTimeIndex = getValidColumnIndex(path, table, "TrueColorsConfig", TrueColorsConfig.FIELD_SHOW_TIME);
            indicesMap.put(TrueColorsConfig.FIELD_SHOW_TIME, Long.valueOf(this.showTimeIndex));
            setIndicesMap(indicesMap);
        }

        public final void copyColumnInfoFrom(ColumnInfo other) {
            TrueColorsConfigColumnInfo otherInfo = (TrueColorsConfigColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.showTimeIndex = otherInfo.showTimeIndex;
            setIndicesMap(otherInfo.getIndicesMap());
        }

        public final TrueColorsConfigColumnInfo clone() {
            return (TrueColorsConfigColumnInfo) super.clone();
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add(IdentityRealmObject.FIELD_ID);
        fieldNames.add(TrueColorsConfig.FIELD_SHOW_TIME);
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    TrueColorsConfigRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext context = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (TrueColorsConfigColumnInfo) context.getColumnInfo();
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

    public int realmGet$showTime() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.showTimeIndex);
    }

    public void realmSet$showTime(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.showTimeIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.showTimeIndex, row.getIndex(), (long) value, true);
        }
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (realmSchema.contains("TrueColorsConfig")) {
            return realmSchema.get("TrueColorsConfig");
        }
        RealmObjectSchema realmObjectSchema = realmSchema.create("TrueColorsConfig");
        realmObjectSchema.add(new Property(IdentityRealmObject.FIELD_ID, RealmFieldType.INTEGER, true, true, true));
        realmObjectSchema.add(new Property(TrueColorsConfig.FIELD_SHOW_TIME, RealmFieldType.INTEGER, false, false, true));
        return realmObjectSchema;
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (sharedRealm.hasTable("class_TrueColorsConfig")) {
            return sharedRealm.getTable("class_TrueColorsConfig");
        }
        Table table = sharedRealm.getTable("class_TrueColorsConfig");
        table.addColumn(RealmFieldType.INTEGER, IdentityRealmObject.FIELD_ID, false);
        table.addColumn(RealmFieldType.INTEGER, TrueColorsConfig.FIELD_SHOW_TIME, false);
        table.addSearchIndex(table.getColumnIndex(IdentityRealmObject.FIELD_ID));
        table.setPrimaryKey(IdentityRealmObject.FIELD_ID);
        return table;
    }

    public static TrueColorsConfigColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_TrueColorsConfig")) {
            Table table = sharedRealm.getTable("class_TrueColorsConfig");
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
            TrueColorsConfigColumnInfo columnInfo2 = new TrueColorsConfigColumnInfo(sharedRealm.getPath(), table);
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
            } else if (!columnTypes.containsKey(TrueColorsConfig.FIELD_SHOW_TIME)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'showTime' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(TrueColorsConfig.FIELD_SHOW_TIME) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'showTime' in existing Realm file.");
            } else if (!table.isColumnNullable(columnInfo2.showTimeIndex)) {
                return columnInfo2;
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'showTime' does support null values in the existing Realm file. Use corresponding boxed type for field 'showTime' or migrate using RealmObjectSchema.setNullable().");
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'TrueColorsConfig' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_TrueColorsConfig";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static TrueColorsConfig createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update) throws JSONException {
        List emptyList = Collections.emptyList();
        TrueColorsConfig obj = null;
        if (update) {
            Table table = realm.getTable(TrueColorsConfig.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = -1;
            if (!json.isNull(IdentityRealmObject.FIELD_ID)) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong(IdentityRealmObject.FIELD_ID));
            }
            if (rowIndex != -1) {
                BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(TrueColorsConfig.class), false, Collections.emptyList());
                    obj = new TrueColorsConfigRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (!json.has(IdentityRealmObject.FIELD_ID)) {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            } else if (json.isNull(IdentityRealmObject.FIELD_ID)) {
                obj = (TrueColorsConfigRealmProxy) realm.createObjectInternal(TrueColorsConfig.class, (Object) null, true, emptyList);
            } else {
                obj = (TrueColorsConfigRealmProxy) realm.createObjectInternal(TrueColorsConfig.class, Integer.valueOf(json.getInt(IdentityRealmObject.FIELD_ID)), true, emptyList);
            }
        }
        if (json.has(TrueColorsConfig.FIELD_SHOW_TIME)) {
            if (json.isNull(TrueColorsConfig.FIELD_SHOW_TIME)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'showTime' to null.");
            }
            obj.realmSet$showTime(json.getInt(TrueColorsConfig.FIELD_SHOW_TIME));
        }
        return obj;
    }

    @TargetApi(11)
    public static TrueColorsConfig createUsingJsonStream(Realm realm, JsonReader reader) throws IOException {
        boolean jsonHasPrimaryKey = false;
        TrueColorsConfig obj = new TrueColorsConfig();
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
            } else if (!name.equals(TrueColorsConfig.FIELD_SHOW_TIME)) {
                reader.skipValue();
            } else if (reader.peek() == JsonToken.NULL) {
                reader.skipValue();
                throw new IllegalArgumentException("Trying to set non-nullable field 'showTime' to null.");
            } else {
                obj.realmSet$showTime(reader.nextInt());
            }
        }
        reader.endObject();
        if (jsonHasPrimaryKey) {
            return (TrueColorsConfig) realm.copyToRealm(obj);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
    }

    public static TrueColorsConfig copyOrUpdate(Realm realm, TrueColorsConfig object, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        } else {
            BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            RealmObjectProxy cachedRealmObject = cache.get(object);
            if (cachedRealmObject != null) {
                return (TrueColorsConfig) cachedRealmObject;
            }
            TrueColorsConfig realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(TrueColorsConfig.class);
                long rowIndex = table.findFirstLong(table.getPrimaryKey(), (long) object.realmGet$id());
                if (rowIndex != -1) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(TrueColorsConfig.class), false, Collections.emptyList());
                        TrueColorsConfig realmObject2 = new TrueColorsConfigRealmProxy();
                        try {
                            cache.put(object, (RealmObjectProxy) realmObject2);
                            objectContext.clear();
                            realmObject = realmObject2;
                        } catch (Throwable th) {
                            th = th;
                            TrueColorsConfig trueColorsConfig = realmObject2;
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

    public static TrueColorsConfig copy(Realm realm, TrueColorsConfig newObject, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (TrueColorsConfig) cachedRealmObject;
        }
        TrueColorsConfig realmObject = (TrueColorsConfig) realm.createObjectInternal(TrueColorsConfig.class, Integer.valueOf(newObject.realmGet$id()), false, Collections.emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.realmSet$showTime(newObject.realmGet$showTime());
        return realmObject;
    }

    public static long insert(Realm realm, TrueColorsConfig object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(TrueColorsConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        TrueColorsConfigColumnInfo columnInfo2 = (TrueColorsConfigColumnInfo) realm.schema.getColumnInfo(TrueColorsConfig.class);
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
        Table.nativeSetLong(tableNativePtr, columnInfo2.showTimeIndex, rowIndex, (long) object.realmGet$showTime(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(TrueColorsConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        TrueColorsConfigColumnInfo columnInfo2 = (TrueColorsConfigColumnInfo) realm.schema.getColumnInfo(TrueColorsConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            TrueColorsConfig object = (TrueColorsConfig) objects.next();
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
                    Table.nativeSetLong(tableNativePtr, columnInfo2.showTimeIndex, rowIndex, (long) object.realmGet$showTime(), false);
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, TrueColorsConfig object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(TrueColorsConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        TrueColorsConfigColumnInfo columnInfo2 = (TrueColorsConfigColumnInfo) realm.schema.getColumnInfo(TrueColorsConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = -1;
        if (Integer.valueOf(object.realmGet$id()) != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, (long) object.realmGet$id());
        }
        if (rowIndex == -1) {
            rowIndex = table.addEmptyRowWithPrimaryKey(Integer.valueOf(object.realmGet$id()), false);
        }
        cache.put(object, Long.valueOf(rowIndex));
        Table.nativeSetLong(tableNativePtr, columnInfo2.showTimeIndex, rowIndex, (long) object.realmGet$showTime(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(TrueColorsConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        TrueColorsConfigColumnInfo columnInfo2 = (TrueColorsConfigColumnInfo) realm.schema.getColumnInfo(TrueColorsConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            TrueColorsConfig object = (TrueColorsConfig) objects.next();
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
                    Table.nativeSetLong(tableNativePtr, columnInfo2.showTimeIndex, rowIndex, (long) object.realmGet$showTime(), false);
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static TrueColorsConfig createDetachedCopy(TrueColorsConfig realmObject, int currentDepth, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        TrueColorsConfig unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        RealmObjectProxy.CacheData<RealmModel> cachedObject = cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new TrueColorsConfig();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.minDepth) {
            return (TrueColorsConfig) cachedObject.object;
        } else {
            unmanagedObject = (TrueColorsConfig) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        unmanagedObject.realmSet$id(realmObject.realmGet$id());
        unmanagedObject.realmSet$showTime(realmObject.realmGet$showTime());
        return unmanagedObject;
    }

    static TrueColorsConfig update(Realm realm, TrueColorsConfig realmObject, TrueColorsConfig newObject, Map<RealmModel, RealmObjectProxy> map) {
        realmObject.realmSet$showTime(newObject.realmGet$showTime());
        return realmObject;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        return "TrueColorsConfig = [" + "{id:" + realmGet$id() + "}" + "," + "{showTime:" + realmGet$showTime() + "}" + "]";
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
        TrueColorsConfigRealmProxy aTrueColorsConfig = (TrueColorsConfigRealmProxy) o;
        String path = this.proxyState.getRealm$realm().getPath();
        String otherPath = aTrueColorsConfig.proxyState.getRealm$realm().getPath();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.proxyState.getRow$realm().getTable().getName();
        String otherTableName = aTrueColorsConfig.proxyState.getRow$realm().getTable().getName();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != aTrueColorsConfig.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
