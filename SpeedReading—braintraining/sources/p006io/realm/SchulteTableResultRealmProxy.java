package p006io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.UnixTimeRealmObject;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableConfig;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableResult;
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

/* renamed from: io.realm.SchulteTableResultRealmProxy */
public class SchulteTableResultRealmProxy extends SchulteTableResult implements RealmObjectProxy, SchulteTableResultRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private SchulteTableResultColumnInfo columnInfo;
    private ProxyState<SchulteTableResult> proxyState;

    /* renamed from: io.realm.SchulteTableResultRealmProxy$SchulteTableResultColumnInfo */
    static final class SchulteTableResultColumnInfo extends ColumnInfo implements Cloneable {
        public long configIndex;
        public long idIndex;
        public long timeIndex;
        public long unixTimeIndex;

        SchulteTableResultColumnInfo(String path, Table table) {
            Map<String, Long> indicesMap = new HashMap<>(4);
            this.idIndex = getValidColumnIndex(path, table, "SchulteTableResult", IdentityRealmObject.FIELD_ID);
            indicesMap.put(IdentityRealmObject.FIELD_ID, Long.valueOf(this.idIndex));
            this.timeIndex = getValidColumnIndex(path, table, "SchulteTableResult", SchulteTableResult.FIELD_TIME);
            indicesMap.put(SchulteTableResult.FIELD_TIME, Long.valueOf(this.timeIndex));
            this.unixTimeIndex = getValidColumnIndex(path, table, "SchulteTableResult", UnixTimeRealmObject.FIELD_UNIX_TIME);
            indicesMap.put(UnixTimeRealmObject.FIELD_UNIX_TIME, Long.valueOf(this.unixTimeIndex));
            this.configIndex = getValidColumnIndex(path, table, "SchulteTableResult", "config");
            indicesMap.put("config", Long.valueOf(this.configIndex));
            setIndicesMap(indicesMap);
        }

        public final void copyColumnInfoFrom(ColumnInfo other) {
            SchulteTableResultColumnInfo otherInfo = (SchulteTableResultColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.timeIndex = otherInfo.timeIndex;
            this.unixTimeIndex = otherInfo.unixTimeIndex;
            this.configIndex = otherInfo.configIndex;
            setIndicesMap(otherInfo.getIndicesMap());
        }

        public final SchulteTableResultColumnInfo clone() {
            return (SchulteTableResultColumnInfo) super.clone();
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add(IdentityRealmObject.FIELD_ID);
        fieldNames.add(SchulteTableResult.FIELD_TIME);
        fieldNames.add(UnixTimeRealmObject.FIELD_UNIX_TIME);
        fieldNames.add("config");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    SchulteTableResultRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext context = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (SchulteTableResultColumnInfo) context.getColumnInfo();
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

    public long realmGet$time() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getLong(this.columnInfo.timeIndex);
    }

    public void realmSet$time(long value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.timeIndex, value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.timeIndex, row.getIndex(), value, true);
        }
    }

    public long realmGet$unixTime() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getLong(this.columnInfo.unixTimeIndex);
    }

    public void realmSet$unixTime(long value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.unixTimeIndex, value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.unixTimeIndex, row.getIndex(), value, true);
        }
    }

    public SchulteTableConfig realmGet$config() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNullLink(this.columnInfo.configIndex)) {
            return null;
        }
        return (SchulteTableConfig) this.proxyState.getRealm$realm().get(SchulteTableConfig.class, this.proxyState.getRow$realm().getLink(this.columnInfo.configIndex), false, Collections.emptyList());
    }

    public void realmSet$config(SchulteTableConfig value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (value == null) {
                this.proxyState.getRow$realm().nullifyLink(this.columnInfo.configIndex);
            } else if (!RealmObject.isManaged(value) || !RealmObject.isValid(value)) {
                throw new IllegalArgumentException("'value' is not a valid managed object.");
            } else if (((RealmObjectProxy) value).realmGet$proxyState().getRealm$realm() != this.proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("'value' belongs to a different Realm.");
            } else {
                this.proxyState.getRow$realm().setLink(this.columnInfo.configIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm() && !this.proxyState.getExcludeFields$realm().contains("config")) {
            if (value != null && !RealmObject.isManaged(value)) {
                value = (SchulteTableConfig) ((Realm) this.proxyState.getRealm$realm()).copyToRealm(value);
            }
            Row row = this.proxyState.getRow$realm();
            if (value == null) {
                row.nullifyLink(this.columnInfo.configIndex);
            } else if (!RealmObject.isValid(value)) {
                throw new IllegalArgumentException("'value' is not a valid managed object.");
            } else if (((RealmObjectProxy) value).realmGet$proxyState().getRealm$realm() != this.proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("'value' belongs to a different Realm.");
            } else {
                row.getTable().setLink(this.columnInfo.configIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            }
        }
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (realmSchema.contains("SchulteTableResult")) {
            return realmSchema.get("SchulteTableResult");
        }
        RealmObjectSchema realmObjectSchema = realmSchema.create("SchulteTableResult");
        realmObjectSchema.add(new Property(IdentityRealmObject.FIELD_ID, RealmFieldType.INTEGER, true, true, true));
        realmObjectSchema.add(new Property(SchulteTableResult.FIELD_TIME, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(UnixTimeRealmObject.FIELD_UNIX_TIME, RealmFieldType.INTEGER, false, false, true));
        if (!realmSchema.contains("SchulteTableConfig")) {
            SchulteTableConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        realmObjectSchema.add(new Property("config", RealmFieldType.OBJECT, realmSchema.get("SchulteTableConfig")));
        return realmObjectSchema;
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (sharedRealm.hasTable("class_SchulteTableResult")) {
            return sharedRealm.getTable("class_SchulteTableResult");
        }
        Table table = sharedRealm.getTable("class_SchulteTableResult");
        table.addColumn(RealmFieldType.INTEGER, IdentityRealmObject.FIELD_ID, false);
        table.addColumn(RealmFieldType.INTEGER, SchulteTableResult.FIELD_TIME, false);
        table.addColumn(RealmFieldType.INTEGER, UnixTimeRealmObject.FIELD_UNIX_TIME, false);
        if (!sharedRealm.hasTable("class_SchulteTableConfig")) {
            SchulteTableConfigRealmProxy.initTable(sharedRealm);
        }
        table.addColumnLink(RealmFieldType.OBJECT, "config", sharedRealm.getTable("class_SchulteTableConfig"));
        table.addSearchIndex(table.getColumnIndex(IdentityRealmObject.FIELD_ID));
        table.setPrimaryKey(IdentityRealmObject.FIELD_ID);
        return table;
    }

    public static SchulteTableResultColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_SchulteTableResult")) {
            Table table = sharedRealm.getTable("class_SchulteTableResult");
            long columnCount = table.getColumnCount();
            if (columnCount != 4) {
                if (columnCount < 4) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 4 but was " + columnCount);
                } else if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 4 but was %1$d", Long.valueOf(columnCount));
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 4 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            SchulteTableResultColumnInfo columnInfo2 = new SchulteTableResultColumnInfo(sharedRealm.getPath(), table);
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
            } else if (!columnTypes.containsKey(SchulteTableResult.FIELD_TIME)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'time' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(SchulteTableResult.FIELD_TIME) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'long' for field 'time' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.timeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'time' does support null values in the existing Realm file. Use corresponding boxed type for field 'time' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(UnixTimeRealmObject.FIELD_UNIX_TIME)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'unixTime' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(UnixTimeRealmObject.FIELD_UNIX_TIME) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'long' for field 'unixTime' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.unixTimeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'unixTime' does support null values in the existing Realm file. Use corresponding boxed type for field 'unixTime' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey("config")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'config' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get("config") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'SchulteTableConfig' for field 'config'");
            } else if (!sharedRealm.hasTable("class_SchulteTableConfig")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_SchulteTableConfig' for field 'config'");
            } else {
                Table table_3 = sharedRealm.getTable("class_SchulteTableConfig");
                if (table.getLinkTarget(columnInfo2.configIndex).hasSameSchema(table_3)) {
                    return columnInfo2;
                }
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmObject for field 'config': '" + table.getLinkTarget(columnInfo2.configIndex).getName() + "' expected - was '" + table_3.getName() + "'");
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'SchulteTableResult' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_SchulteTableResult";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static SchulteTableResult createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update) throws JSONException {
        ArrayList arrayList = new ArrayList(1);
        SchulteTableResult obj = null;
        if (update) {
            Table table = realm.getTable(SchulteTableResult.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = -1;
            if (!json.isNull(IdentityRealmObject.FIELD_ID)) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong(IdentityRealmObject.FIELD_ID));
            }
            if (rowIndex != -1) {
                BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(SchulteTableResult.class), false, Collections.emptyList());
                    obj = new SchulteTableResultRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("config")) {
                arrayList.add("config");
            }
            if (!json.has(IdentityRealmObject.FIELD_ID)) {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            } else if (json.isNull(IdentityRealmObject.FIELD_ID)) {
                obj = (SchulteTableResultRealmProxy) realm.createObjectInternal(SchulteTableResult.class, (Object) null, true, arrayList);
            } else {
                obj = (SchulteTableResultRealmProxy) realm.createObjectInternal(SchulteTableResult.class, Integer.valueOf(json.getInt(IdentityRealmObject.FIELD_ID)), true, arrayList);
            }
        }
        if (json.has(SchulteTableResult.FIELD_TIME)) {
            if (json.isNull(SchulteTableResult.FIELD_TIME)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'time' to null.");
            }
            obj.realmSet$time(json.getLong(SchulteTableResult.FIELD_TIME));
        }
        if (json.has(UnixTimeRealmObject.FIELD_UNIX_TIME)) {
            if (json.isNull(UnixTimeRealmObject.FIELD_UNIX_TIME)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'unixTime' to null.");
            }
            obj.realmSet$unixTime(json.getLong(UnixTimeRealmObject.FIELD_UNIX_TIME));
        }
        if (json.has("config")) {
            if (json.isNull("config")) {
                obj.realmSet$config((SchulteTableConfig) null);
            } else {
                obj.realmSet$config(SchulteTableConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("config"), update));
            }
        }
        return obj;
    }

    @TargetApi(11)
    public static SchulteTableResult createUsingJsonStream(Realm realm, JsonReader reader) throws IOException {
        boolean jsonHasPrimaryKey = false;
        SchulteTableResult obj = new SchulteTableResult();
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
            } else if (name.equals(SchulteTableResult.FIELD_TIME)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'time' to null.");
                }
                obj.realmSet$time(reader.nextLong());
            } else if (name.equals(UnixTimeRealmObject.FIELD_UNIX_TIME)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'unixTime' to null.");
                }
                obj.realmSet$unixTime(reader.nextLong());
            } else if (!name.equals("config")) {
                reader.skipValue();
            } else if (reader.peek() == JsonToken.NULL) {
                reader.skipValue();
                obj.realmSet$config((SchulteTableConfig) null);
            } else {
                obj.realmSet$config(SchulteTableConfigRealmProxy.createUsingJsonStream(realm, reader));
            }
        }
        reader.endObject();
        if (jsonHasPrimaryKey) {
            return (SchulteTableResult) realm.copyToRealm(obj);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
    }

    public static SchulteTableResult copyOrUpdate(Realm realm, SchulteTableResult object, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        } else {
            BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            RealmObjectProxy cachedRealmObject = cache.get(object);
            if (cachedRealmObject != null) {
                return (SchulteTableResult) cachedRealmObject;
            }
            SchulteTableResult realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(SchulteTableResult.class);
                long rowIndex = table.findFirstLong(table.getPrimaryKey(), (long) object.realmGet$id());
                if (rowIndex != -1) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(SchulteTableResult.class), false, Collections.emptyList());
                        SchulteTableResult realmObject2 = new SchulteTableResultRealmProxy();
                        try {
                            cache.put(object, (RealmObjectProxy) realmObject2);
                            objectContext.clear();
                            realmObject = realmObject2;
                        } catch (Throwable th) {
                            th = th;
                            SchulteTableResult schulteTableResult = realmObject2;
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

    public static SchulteTableResult copy(Realm realm, SchulteTableResult newObject, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (SchulteTableResult) cachedRealmObject;
        }
        SchulteTableResult realmObject = (SchulteTableResult) realm.createObjectInternal(SchulteTableResult.class, Integer.valueOf(newObject.realmGet$id()), false, Collections.emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.realmSet$time(newObject.realmGet$time());
        realmObject.realmSet$unixTime(newObject.realmGet$unixTime());
        SchulteTableConfig configObj = newObject.realmGet$config();
        if (configObj != null) {
            SchulteTableConfig cacheconfig = (SchulteTableConfig) cache.get(configObj);
            if (cacheconfig != null) {
                realmObject.realmSet$config(cacheconfig);
            } else {
                realmObject.realmSet$config(SchulteTableConfigRealmProxy.copyOrUpdate(realm, configObj, update, cache));
            }
        } else {
            realmObject.realmSet$config((SchulteTableConfig) null);
        }
        return realmObject;
    }

    public static long insert(Realm realm, SchulteTableResult object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(SchulteTableResult.class);
        long tableNativePtr = table.getNativeTablePointer();
        SchulteTableResultColumnInfo columnInfo2 = (SchulteTableResultColumnInfo) realm.schema.getColumnInfo(SchulteTableResult.class);
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
        Table.nativeSetLong(tableNativePtr, columnInfo2.timeIndex, rowIndex, object.realmGet$time(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.unixTimeIndex, rowIndex, object.realmGet$unixTime(), false);
        SchulteTableConfig configObj = object.realmGet$config();
        if (configObj == null) {
            return rowIndex;
        }
        Long cacheconfig = cache.get(configObj);
        if (cacheconfig == null) {
            cacheconfig = Long.valueOf(SchulteTableConfigRealmProxy.insert(realm, configObj, cache));
        }
        Table.nativeSetLink(tableNativePtr, columnInfo2.configIndex, rowIndex, cacheconfig.longValue(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(SchulteTableResult.class);
        long tableNativePtr = table.getNativeTablePointer();
        SchulteTableResultColumnInfo columnInfo2 = (SchulteTableResultColumnInfo) realm.schema.getColumnInfo(SchulteTableResult.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            SchulteTableResult object = (SchulteTableResult) objects.next();
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
                    Table.nativeSetLong(tableNativePtr, columnInfo2.timeIndex, rowIndex, object.realmGet$time(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.unixTimeIndex, rowIndex, object.realmGet$unixTime(), false);
                    SchulteTableConfig configObj = object.realmGet$config();
                    if (configObj != null) {
                        Long cacheconfig = cache.get(configObj);
                        if (cacheconfig == null) {
                            cacheconfig = Long.valueOf(SchulteTableConfigRealmProxy.insert(realm, configObj, cache));
                        }
                        table.setLink(columnInfo2.configIndex, rowIndex, cacheconfig.longValue(), false);
                    }
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, SchulteTableResult object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(SchulteTableResult.class);
        long tableNativePtr = table.getNativeTablePointer();
        SchulteTableResultColumnInfo columnInfo2 = (SchulteTableResultColumnInfo) realm.schema.getColumnInfo(SchulteTableResult.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = -1;
        if (Integer.valueOf(object.realmGet$id()) != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, (long) object.realmGet$id());
        }
        if (rowIndex == -1) {
            rowIndex = table.addEmptyRowWithPrimaryKey(Integer.valueOf(object.realmGet$id()), false);
        }
        cache.put(object, Long.valueOf(rowIndex));
        Table.nativeSetLong(tableNativePtr, columnInfo2.timeIndex, rowIndex, object.realmGet$time(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.unixTimeIndex, rowIndex, object.realmGet$unixTime(), false);
        SchulteTableConfig configObj = object.realmGet$config();
        if (configObj != null) {
            Long cacheconfig = cache.get(configObj);
            if (cacheconfig == null) {
                cacheconfig = Long.valueOf(SchulteTableConfigRealmProxy.insertOrUpdate(realm, configObj, cache));
            }
            Table.nativeSetLink(tableNativePtr, columnInfo2.configIndex, rowIndex, cacheconfig.longValue(), false);
            return rowIndex;
        }
        Table.nativeNullifyLink(tableNativePtr, columnInfo2.configIndex, rowIndex);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(SchulteTableResult.class);
        long tableNativePtr = table.getNativeTablePointer();
        SchulteTableResultColumnInfo columnInfo2 = (SchulteTableResultColumnInfo) realm.schema.getColumnInfo(SchulteTableResult.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            SchulteTableResult object = (SchulteTableResult) objects.next();
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
                    Table.nativeSetLong(tableNativePtr, columnInfo2.timeIndex, rowIndex, object.realmGet$time(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.unixTimeIndex, rowIndex, object.realmGet$unixTime(), false);
                    SchulteTableConfig configObj = object.realmGet$config();
                    if (configObj != null) {
                        Long cacheconfig = cache.get(configObj);
                        if (cacheconfig == null) {
                            cacheconfig = Long.valueOf(SchulteTableConfigRealmProxy.insertOrUpdate(realm, configObj, cache));
                        }
                        Table.nativeSetLink(tableNativePtr, columnInfo2.configIndex, rowIndex, cacheconfig.longValue(), false);
                    } else {
                        Table.nativeNullifyLink(tableNativePtr, columnInfo2.configIndex, rowIndex);
                    }
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static SchulteTableResult createDetachedCopy(SchulteTableResult realmObject, int currentDepth, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        SchulteTableResult unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        RealmObjectProxy.CacheData<RealmModel> cachedObject = cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new SchulteTableResult();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.minDepth) {
            return (SchulteTableResult) cachedObject.object;
        } else {
            unmanagedObject = (SchulteTableResult) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        unmanagedObject.realmSet$id(realmObject.realmGet$id());
        unmanagedObject.realmSet$time(realmObject.realmGet$time());
        unmanagedObject.realmSet$unixTime(realmObject.realmGet$unixTime());
        unmanagedObject.realmSet$config(SchulteTableConfigRealmProxy.createDetachedCopy(realmObject.realmGet$config(), currentDepth + 1, maxDepth, cache));
        return unmanagedObject;
    }

    static SchulteTableResult update(Realm realm, SchulteTableResult realmObject, SchulteTableResult newObject, Map<RealmModel, RealmObjectProxy> cache) {
        realmObject.realmSet$time(newObject.realmGet$time());
        realmObject.realmSet$unixTime(newObject.realmGet$unixTime());
        SchulteTableConfig configObj = newObject.realmGet$config();
        if (configObj != null) {
            SchulteTableConfig cacheconfig = (SchulteTableConfig) cache.get(configObj);
            if (cacheconfig != null) {
                realmObject.realmSet$config(cacheconfig);
            } else {
                realmObject.realmSet$config(SchulteTableConfigRealmProxy.copyOrUpdate(realm, configObj, true, cache));
            }
        } else {
            realmObject.realmSet$config((SchulteTableConfig) null);
        }
        return realmObject;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("SchulteTableResult = [");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{time:");
        stringBuilder.append(realmGet$time());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{unixTime:");
        stringBuilder.append(realmGet$unixTime());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{config:");
        stringBuilder.append(realmGet$config() != null ? "SchulteTableConfig" : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
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
        SchulteTableResultRealmProxy aSchulteTableResult = (SchulteTableResultRealmProxy) o;
        String path = this.proxyState.getRealm$realm().getPath();
        String otherPath = aSchulteTableResult.proxyState.getRealm$realm().getPath();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.proxyState.getRow$realm().getTable().getName();
        String otherTableName = aSchulteTableResult.proxyState.getRow$realm().getTable().getName();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != aSchulteTableResult.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
