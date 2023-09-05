package p006io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.UnixTimeRealmObject;
import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingConfig;
import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingResult;
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

/* renamed from: io.realm.SpeedReadingResultRealmProxy */
public class SpeedReadingResultRealmProxy extends SpeedReadingResult implements RealmObjectProxy, SpeedReadingResultRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private SpeedReadingResultColumnInfo columnInfo;
    private ProxyState<SpeedReadingResult> proxyState;

    /* renamed from: io.realm.SpeedReadingResultRealmProxy$SpeedReadingResultColumnInfo */
    static final class SpeedReadingResultColumnInfo extends ColumnInfo implements Cloneable {
        public long averageSpeedIndex;
        public long configIndex;
        public long idIndex;
        public long maxSpeedIndex;
        public long unixTimeIndex;

        SpeedReadingResultColumnInfo(String path, Table table) {
            Map<String, Long> indicesMap = new HashMap<>(5);
            this.idIndex = getValidColumnIndex(path, table, "SpeedReadingResult", IdentityRealmObject.FIELD_ID);
            indicesMap.put(IdentityRealmObject.FIELD_ID, Long.valueOf(this.idIndex));
            this.maxSpeedIndex = getValidColumnIndex(path, table, "SpeedReadingResult", SpeedReadingResult.FIELD_MAX_SPEED);
            indicesMap.put(SpeedReadingResult.FIELD_MAX_SPEED, Long.valueOf(this.maxSpeedIndex));
            this.averageSpeedIndex = getValidColumnIndex(path, table, "SpeedReadingResult", SpeedReadingResult.FIELD_AVERAGE_SPEED);
            indicesMap.put(SpeedReadingResult.FIELD_AVERAGE_SPEED, Long.valueOf(this.averageSpeedIndex));
            this.unixTimeIndex = getValidColumnIndex(path, table, "SpeedReadingResult", UnixTimeRealmObject.FIELD_UNIX_TIME);
            indicesMap.put(UnixTimeRealmObject.FIELD_UNIX_TIME, Long.valueOf(this.unixTimeIndex));
            this.configIndex = getValidColumnIndex(path, table, "SpeedReadingResult", "config");
            indicesMap.put("config", Long.valueOf(this.configIndex));
            setIndicesMap(indicesMap);
        }

        public final void copyColumnInfoFrom(ColumnInfo other) {
            SpeedReadingResultColumnInfo otherInfo = (SpeedReadingResultColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.maxSpeedIndex = otherInfo.maxSpeedIndex;
            this.averageSpeedIndex = otherInfo.averageSpeedIndex;
            this.unixTimeIndex = otherInfo.unixTimeIndex;
            this.configIndex = otherInfo.configIndex;
            setIndicesMap(otherInfo.getIndicesMap());
        }

        public final SpeedReadingResultColumnInfo clone() {
            return (SpeedReadingResultColumnInfo) super.clone();
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add(IdentityRealmObject.FIELD_ID);
        fieldNames.add(SpeedReadingResult.FIELD_MAX_SPEED);
        fieldNames.add(SpeedReadingResult.FIELD_AVERAGE_SPEED);
        fieldNames.add(UnixTimeRealmObject.FIELD_UNIX_TIME);
        fieldNames.add("config");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    SpeedReadingResultRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext context = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (SpeedReadingResultColumnInfo) context.getColumnInfo();
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

    public int realmGet$maxSpeed() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.maxSpeedIndex);
    }

    public void realmSet$maxSpeed(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.maxSpeedIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.maxSpeedIndex, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$averageSpeed() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.averageSpeedIndex);
    }

    public void realmSet$averageSpeed(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.averageSpeedIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.averageSpeedIndex, row.getIndex(), (long) value, true);
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

    public SpeedReadingConfig realmGet$config() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNullLink(this.columnInfo.configIndex)) {
            return null;
        }
        return (SpeedReadingConfig) this.proxyState.getRealm$realm().get(SpeedReadingConfig.class, this.proxyState.getRow$realm().getLink(this.columnInfo.configIndex), false, Collections.emptyList());
    }

    public void realmSet$config(SpeedReadingConfig value) {
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
                value = (SpeedReadingConfig) ((Realm) this.proxyState.getRealm$realm()).copyToRealm(value);
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
        if (realmSchema.contains("SpeedReadingResult")) {
            return realmSchema.get("SpeedReadingResult");
        }
        RealmObjectSchema realmObjectSchema = realmSchema.create("SpeedReadingResult");
        realmObjectSchema.add(new Property(IdentityRealmObject.FIELD_ID, RealmFieldType.INTEGER, true, true, true));
        realmObjectSchema.add(new Property(SpeedReadingResult.FIELD_MAX_SPEED, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(SpeedReadingResult.FIELD_AVERAGE_SPEED, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(UnixTimeRealmObject.FIELD_UNIX_TIME, RealmFieldType.INTEGER, false, false, true));
        if (!realmSchema.contains("SpeedReadingConfig")) {
            SpeedReadingConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        realmObjectSchema.add(new Property("config", RealmFieldType.OBJECT, realmSchema.get("SpeedReadingConfig")));
        return realmObjectSchema;
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (sharedRealm.hasTable("class_SpeedReadingResult")) {
            return sharedRealm.getTable("class_SpeedReadingResult");
        }
        Table table = sharedRealm.getTable("class_SpeedReadingResult");
        table.addColumn(RealmFieldType.INTEGER, IdentityRealmObject.FIELD_ID, false);
        table.addColumn(RealmFieldType.INTEGER, SpeedReadingResult.FIELD_MAX_SPEED, false);
        table.addColumn(RealmFieldType.INTEGER, SpeedReadingResult.FIELD_AVERAGE_SPEED, false);
        table.addColumn(RealmFieldType.INTEGER, UnixTimeRealmObject.FIELD_UNIX_TIME, false);
        if (!sharedRealm.hasTable("class_SpeedReadingConfig")) {
            SpeedReadingConfigRealmProxy.initTable(sharedRealm);
        }
        table.addColumnLink(RealmFieldType.OBJECT, "config", sharedRealm.getTable("class_SpeedReadingConfig"));
        table.addSearchIndex(table.getColumnIndex(IdentityRealmObject.FIELD_ID));
        table.setPrimaryKey(IdentityRealmObject.FIELD_ID);
        return table;
    }

    public static SpeedReadingResultColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_SpeedReadingResult")) {
            Table table = sharedRealm.getTable("class_SpeedReadingResult");
            long columnCount = table.getColumnCount();
            if (columnCount != 5) {
                if (columnCount < 5) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 5 but was " + columnCount);
                } else if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 5 but was %1$d", Long.valueOf(columnCount));
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 5 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            SpeedReadingResultColumnInfo columnInfo2 = new SpeedReadingResultColumnInfo(sharedRealm.getPath(), table);
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
            } else if (!columnTypes.containsKey(SpeedReadingResult.FIELD_MAX_SPEED)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'maxSpeed' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(SpeedReadingResult.FIELD_MAX_SPEED) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'maxSpeed' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.maxSpeedIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'maxSpeed' does support null values in the existing Realm file. Use corresponding boxed type for field 'maxSpeed' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(SpeedReadingResult.FIELD_AVERAGE_SPEED)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'averageSpeed' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(SpeedReadingResult.FIELD_AVERAGE_SPEED) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'averageSpeed' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.averageSpeedIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'averageSpeed' does support null values in the existing Realm file. Use corresponding boxed type for field 'averageSpeed' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(UnixTimeRealmObject.FIELD_UNIX_TIME)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'unixTime' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(UnixTimeRealmObject.FIELD_UNIX_TIME) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'long' for field 'unixTime' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.unixTimeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'unixTime' does support null values in the existing Realm file. Use corresponding boxed type for field 'unixTime' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey("config")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'config' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get("config") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'SpeedReadingConfig' for field 'config'");
            } else if (!sharedRealm.hasTable("class_SpeedReadingConfig")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_SpeedReadingConfig' for field 'config'");
            } else {
                Table table_4 = sharedRealm.getTable("class_SpeedReadingConfig");
                if (table.getLinkTarget(columnInfo2.configIndex).hasSameSchema(table_4)) {
                    return columnInfo2;
                }
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmObject for field 'config': '" + table.getLinkTarget(columnInfo2.configIndex).getName() + "' expected - was '" + table_4.getName() + "'");
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'SpeedReadingResult' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_SpeedReadingResult";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static SpeedReadingResult createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update) throws JSONException {
        ArrayList arrayList = new ArrayList(1);
        SpeedReadingResult obj = null;
        if (update) {
            Table table = realm.getTable(SpeedReadingResult.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = -1;
            if (!json.isNull(IdentityRealmObject.FIELD_ID)) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong(IdentityRealmObject.FIELD_ID));
            }
            if (rowIndex != -1) {
                BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(SpeedReadingResult.class), false, Collections.emptyList());
                    obj = new SpeedReadingResultRealmProxy();
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
                obj = (SpeedReadingResultRealmProxy) realm.createObjectInternal(SpeedReadingResult.class, (Object) null, true, arrayList);
            } else {
                obj = (SpeedReadingResultRealmProxy) realm.createObjectInternal(SpeedReadingResult.class, Integer.valueOf(json.getInt(IdentityRealmObject.FIELD_ID)), true, arrayList);
            }
        }
        if (json.has(SpeedReadingResult.FIELD_MAX_SPEED)) {
            if (json.isNull(SpeedReadingResult.FIELD_MAX_SPEED)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'maxSpeed' to null.");
            }
            obj.realmSet$maxSpeed(json.getInt(SpeedReadingResult.FIELD_MAX_SPEED));
        }
        if (json.has(SpeedReadingResult.FIELD_AVERAGE_SPEED)) {
            if (json.isNull(SpeedReadingResult.FIELD_AVERAGE_SPEED)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'averageSpeed' to null.");
            }
            obj.realmSet$averageSpeed(json.getInt(SpeedReadingResult.FIELD_AVERAGE_SPEED));
        }
        if (json.has(UnixTimeRealmObject.FIELD_UNIX_TIME)) {
            if (json.isNull(UnixTimeRealmObject.FIELD_UNIX_TIME)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'unixTime' to null.");
            }
            obj.realmSet$unixTime(json.getLong(UnixTimeRealmObject.FIELD_UNIX_TIME));
        }
        if (json.has("config")) {
            if (json.isNull("config")) {
                obj.realmSet$config((SpeedReadingConfig) null);
            } else {
                obj.realmSet$config(SpeedReadingConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("config"), update));
            }
        }
        return obj;
    }

    @TargetApi(11)
    public static SpeedReadingResult createUsingJsonStream(Realm realm, JsonReader reader) throws IOException {
        boolean jsonHasPrimaryKey = false;
        SpeedReadingResult obj = new SpeedReadingResult();
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
            } else if (name.equals(SpeedReadingResult.FIELD_MAX_SPEED)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'maxSpeed' to null.");
                }
                obj.realmSet$maxSpeed(reader.nextInt());
            } else if (name.equals(SpeedReadingResult.FIELD_AVERAGE_SPEED)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'averageSpeed' to null.");
                }
                obj.realmSet$averageSpeed(reader.nextInt());
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
                obj.realmSet$config((SpeedReadingConfig) null);
            } else {
                obj.realmSet$config(SpeedReadingConfigRealmProxy.createUsingJsonStream(realm, reader));
            }
        }
        reader.endObject();
        if (jsonHasPrimaryKey) {
            return (SpeedReadingResult) realm.copyToRealm(obj);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
    }

    public static SpeedReadingResult copyOrUpdate(Realm realm, SpeedReadingResult object, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        } else {
            BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            RealmObjectProxy cachedRealmObject = cache.get(object);
            if (cachedRealmObject != null) {
                return (SpeedReadingResult) cachedRealmObject;
            }
            SpeedReadingResult realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(SpeedReadingResult.class);
                long rowIndex = table.findFirstLong(table.getPrimaryKey(), (long) object.realmGet$id());
                if (rowIndex != -1) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(SpeedReadingResult.class), false, Collections.emptyList());
                        SpeedReadingResult realmObject2 = new SpeedReadingResultRealmProxy();
                        try {
                            cache.put(object, (RealmObjectProxy) realmObject2);
                            objectContext.clear();
                            realmObject = realmObject2;
                        } catch (Throwable th) {
                            th = th;
                            SpeedReadingResult speedReadingResult = realmObject2;
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

    public static SpeedReadingResult copy(Realm realm, SpeedReadingResult newObject, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (SpeedReadingResult) cachedRealmObject;
        }
        SpeedReadingResult realmObject = (SpeedReadingResult) realm.createObjectInternal(SpeedReadingResult.class, Integer.valueOf(newObject.realmGet$id()), false, Collections.emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.realmSet$maxSpeed(newObject.realmGet$maxSpeed());
        realmObject.realmSet$averageSpeed(newObject.realmGet$averageSpeed());
        realmObject.realmSet$unixTime(newObject.realmGet$unixTime());
        SpeedReadingConfig configObj = newObject.realmGet$config();
        if (configObj != null) {
            SpeedReadingConfig cacheconfig = (SpeedReadingConfig) cache.get(configObj);
            if (cacheconfig != null) {
                realmObject.realmSet$config(cacheconfig);
            } else {
                realmObject.realmSet$config(SpeedReadingConfigRealmProxy.copyOrUpdate(realm, configObj, update, cache));
            }
        } else {
            realmObject.realmSet$config((SpeedReadingConfig) null);
        }
        return realmObject;
    }

    public static long insert(Realm realm, SpeedReadingResult object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(SpeedReadingResult.class);
        long tableNativePtr = table.getNativeTablePointer();
        SpeedReadingResultColumnInfo columnInfo2 = (SpeedReadingResultColumnInfo) realm.schema.getColumnInfo(SpeedReadingResult.class);
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
        Table.nativeSetLong(tableNativePtr, columnInfo2.maxSpeedIndex, rowIndex, (long) object.realmGet$maxSpeed(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.averageSpeedIndex, rowIndex, (long) object.realmGet$averageSpeed(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.unixTimeIndex, rowIndex, object.realmGet$unixTime(), false);
        SpeedReadingConfig configObj = object.realmGet$config();
        if (configObj == null) {
            return rowIndex;
        }
        Long cacheconfig = cache.get(configObj);
        if (cacheconfig == null) {
            cacheconfig = Long.valueOf(SpeedReadingConfigRealmProxy.insert(realm, configObj, cache));
        }
        Table.nativeSetLink(tableNativePtr, columnInfo2.configIndex, rowIndex, cacheconfig.longValue(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(SpeedReadingResult.class);
        long tableNativePtr = table.getNativeTablePointer();
        SpeedReadingResultColumnInfo columnInfo2 = (SpeedReadingResultColumnInfo) realm.schema.getColumnInfo(SpeedReadingResult.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            SpeedReadingResult object = (SpeedReadingResult) objects.next();
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
                    Table.nativeSetLong(tableNativePtr, columnInfo2.maxSpeedIndex, rowIndex, (long) object.realmGet$maxSpeed(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.averageSpeedIndex, rowIndex, (long) object.realmGet$averageSpeed(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.unixTimeIndex, rowIndex, object.realmGet$unixTime(), false);
                    SpeedReadingConfig configObj = object.realmGet$config();
                    if (configObj != null) {
                        Long cacheconfig = cache.get(configObj);
                        if (cacheconfig == null) {
                            cacheconfig = Long.valueOf(SpeedReadingConfigRealmProxy.insert(realm, configObj, cache));
                        }
                        table.setLink(columnInfo2.configIndex, rowIndex, cacheconfig.longValue(), false);
                    }
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, SpeedReadingResult object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(SpeedReadingResult.class);
        long tableNativePtr = table.getNativeTablePointer();
        SpeedReadingResultColumnInfo columnInfo2 = (SpeedReadingResultColumnInfo) realm.schema.getColumnInfo(SpeedReadingResult.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = -1;
        if (Integer.valueOf(object.realmGet$id()) != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, (long) object.realmGet$id());
        }
        if (rowIndex == -1) {
            rowIndex = table.addEmptyRowWithPrimaryKey(Integer.valueOf(object.realmGet$id()), false);
        }
        cache.put(object, Long.valueOf(rowIndex));
        Table.nativeSetLong(tableNativePtr, columnInfo2.maxSpeedIndex, rowIndex, (long) object.realmGet$maxSpeed(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.averageSpeedIndex, rowIndex, (long) object.realmGet$averageSpeed(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.unixTimeIndex, rowIndex, object.realmGet$unixTime(), false);
        SpeedReadingConfig configObj = object.realmGet$config();
        if (configObj != null) {
            Long cacheconfig = cache.get(configObj);
            if (cacheconfig == null) {
                cacheconfig = Long.valueOf(SpeedReadingConfigRealmProxy.insertOrUpdate(realm, configObj, cache));
            }
            Table.nativeSetLink(tableNativePtr, columnInfo2.configIndex, rowIndex, cacheconfig.longValue(), false);
            return rowIndex;
        }
        Table.nativeNullifyLink(tableNativePtr, columnInfo2.configIndex, rowIndex);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(SpeedReadingResult.class);
        long tableNativePtr = table.getNativeTablePointer();
        SpeedReadingResultColumnInfo columnInfo2 = (SpeedReadingResultColumnInfo) realm.schema.getColumnInfo(SpeedReadingResult.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            SpeedReadingResult object = (SpeedReadingResult) objects.next();
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
                    Table.nativeSetLong(tableNativePtr, columnInfo2.maxSpeedIndex, rowIndex, (long) object.realmGet$maxSpeed(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.averageSpeedIndex, rowIndex, (long) object.realmGet$averageSpeed(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.unixTimeIndex, rowIndex, object.realmGet$unixTime(), false);
                    SpeedReadingConfig configObj = object.realmGet$config();
                    if (configObj != null) {
                        Long cacheconfig = cache.get(configObj);
                        if (cacheconfig == null) {
                            cacheconfig = Long.valueOf(SpeedReadingConfigRealmProxy.insertOrUpdate(realm, configObj, cache));
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

    public static SpeedReadingResult createDetachedCopy(SpeedReadingResult realmObject, int currentDepth, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        SpeedReadingResult unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        RealmObjectProxy.CacheData<RealmModel> cachedObject = cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new SpeedReadingResult();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.minDepth) {
            return (SpeedReadingResult) cachedObject.object;
        } else {
            unmanagedObject = (SpeedReadingResult) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        unmanagedObject.realmSet$id(realmObject.realmGet$id());
        unmanagedObject.realmSet$maxSpeed(realmObject.realmGet$maxSpeed());
        unmanagedObject.realmSet$averageSpeed(realmObject.realmGet$averageSpeed());
        unmanagedObject.realmSet$unixTime(realmObject.realmGet$unixTime());
        unmanagedObject.realmSet$config(SpeedReadingConfigRealmProxy.createDetachedCopy(realmObject.realmGet$config(), currentDepth + 1, maxDepth, cache));
        return unmanagedObject;
    }

    static SpeedReadingResult update(Realm realm, SpeedReadingResult realmObject, SpeedReadingResult newObject, Map<RealmModel, RealmObjectProxy> cache) {
        realmObject.realmSet$maxSpeed(newObject.realmGet$maxSpeed());
        realmObject.realmSet$averageSpeed(newObject.realmGet$averageSpeed());
        realmObject.realmSet$unixTime(newObject.realmGet$unixTime());
        SpeedReadingConfig configObj = newObject.realmGet$config();
        if (configObj != null) {
            SpeedReadingConfig cacheconfig = (SpeedReadingConfig) cache.get(configObj);
            if (cacheconfig != null) {
                realmObject.realmSet$config(cacheconfig);
            } else {
                realmObject.realmSet$config(SpeedReadingConfigRealmProxy.copyOrUpdate(realm, configObj, true, cache));
            }
        } else {
            realmObject.realmSet$config((SpeedReadingConfig) null);
        }
        return realmObject;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("SpeedReadingResult = [");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{maxSpeed:");
        stringBuilder.append(realmGet$maxSpeed());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{averageSpeed:");
        stringBuilder.append(realmGet$averageSpeed());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{unixTime:");
        stringBuilder.append(realmGet$unixTime());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{config:");
        stringBuilder.append(realmGet$config() != null ? "SpeedReadingConfig" : "null");
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
        SpeedReadingResultRealmProxy aSpeedReadingResult = (SpeedReadingResultRealmProxy) o;
        String path = this.proxyState.getRealm$realm().getPath();
        String otherPath = aSpeedReadingResult.proxyState.getRealm$realm().getPath();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.proxyState.getRow$realm().getTable().getName();
        String otherTableName = aSpeedReadingResult.proxyState.getRow$realm().getTable().getName();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != aSpeedReadingResult.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
