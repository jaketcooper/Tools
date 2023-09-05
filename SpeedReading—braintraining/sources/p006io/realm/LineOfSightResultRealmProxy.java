package p006io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.UnixTimeRealmObject;
import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightConfig;
import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightResult;
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

/* renamed from: io.realm.LineOfSightResultRealmProxy */
public class LineOfSightResultRealmProxy extends LineOfSightResult implements RealmObjectProxy, LineOfSightResultRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private LineOfSightResultColumnInfo columnInfo;
    private ProxyState<LineOfSightResult> proxyState;

    /* renamed from: io.realm.LineOfSightResultRealmProxy$LineOfSightResultColumnInfo */
    static final class LineOfSightResultColumnInfo extends ColumnInfo implements Cloneable {
        public long configIndex;
        public long foundMistakeCountIndex;
        public long idIndex;
        public long mistakeCountIndex;
        public long unixTimeIndex;

        LineOfSightResultColumnInfo(String path, Table table) {
            Map<String, Long> indicesMap = new HashMap<>(5);
            this.idIndex = getValidColumnIndex(path, table, "LineOfSightResult", IdentityRealmObject.FIELD_ID);
            indicesMap.put(IdentityRealmObject.FIELD_ID, Long.valueOf(this.idIndex));
            this.mistakeCountIndex = getValidColumnIndex(path, table, "LineOfSightResult", LineOfSightResult.FIELD_MISTAKE_COUNT);
            indicesMap.put(LineOfSightResult.FIELD_MISTAKE_COUNT, Long.valueOf(this.mistakeCountIndex));
            this.foundMistakeCountIndex = getValidColumnIndex(path, table, "LineOfSightResult", LineOfSightResult.FIELD_FOUND_MISTAKE_COUNT);
            indicesMap.put(LineOfSightResult.FIELD_FOUND_MISTAKE_COUNT, Long.valueOf(this.foundMistakeCountIndex));
            this.unixTimeIndex = getValidColumnIndex(path, table, "LineOfSightResult", UnixTimeRealmObject.FIELD_UNIX_TIME);
            indicesMap.put(UnixTimeRealmObject.FIELD_UNIX_TIME, Long.valueOf(this.unixTimeIndex));
            this.configIndex = getValidColumnIndex(path, table, "LineOfSightResult", "config");
            indicesMap.put("config", Long.valueOf(this.configIndex));
            setIndicesMap(indicesMap);
        }

        public final void copyColumnInfoFrom(ColumnInfo other) {
            LineOfSightResultColumnInfo otherInfo = (LineOfSightResultColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.mistakeCountIndex = otherInfo.mistakeCountIndex;
            this.foundMistakeCountIndex = otherInfo.foundMistakeCountIndex;
            this.unixTimeIndex = otherInfo.unixTimeIndex;
            this.configIndex = otherInfo.configIndex;
            setIndicesMap(otherInfo.getIndicesMap());
        }

        public final LineOfSightResultColumnInfo clone() {
            return (LineOfSightResultColumnInfo) super.clone();
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add(IdentityRealmObject.FIELD_ID);
        fieldNames.add(LineOfSightResult.FIELD_MISTAKE_COUNT);
        fieldNames.add(LineOfSightResult.FIELD_FOUND_MISTAKE_COUNT);
        fieldNames.add(UnixTimeRealmObject.FIELD_UNIX_TIME);
        fieldNames.add("config");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    LineOfSightResultRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext context = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (LineOfSightResultColumnInfo) context.getColumnInfo();
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

    public int realmGet$mistakeCount() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.mistakeCountIndex);
    }

    public void realmSet$mistakeCount(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.mistakeCountIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.mistakeCountIndex, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$foundMistakeCount() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.foundMistakeCountIndex);
    }

    public void realmSet$foundMistakeCount(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.foundMistakeCountIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.foundMistakeCountIndex, row.getIndex(), (long) value, true);
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

    public LineOfSightConfig realmGet$config() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNullLink(this.columnInfo.configIndex)) {
            return null;
        }
        return (LineOfSightConfig) this.proxyState.getRealm$realm().get(LineOfSightConfig.class, this.proxyState.getRow$realm().getLink(this.columnInfo.configIndex), false, Collections.emptyList());
    }

    public void realmSet$config(LineOfSightConfig value) {
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
                value = (LineOfSightConfig) ((Realm) this.proxyState.getRealm$realm()).copyToRealm(value);
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
        if (realmSchema.contains("LineOfSightResult")) {
            return realmSchema.get("LineOfSightResult");
        }
        RealmObjectSchema realmObjectSchema = realmSchema.create("LineOfSightResult");
        realmObjectSchema.add(new Property(IdentityRealmObject.FIELD_ID, RealmFieldType.INTEGER, true, true, true));
        realmObjectSchema.add(new Property(LineOfSightResult.FIELD_MISTAKE_COUNT, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(LineOfSightResult.FIELD_FOUND_MISTAKE_COUNT, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(UnixTimeRealmObject.FIELD_UNIX_TIME, RealmFieldType.INTEGER, false, false, true));
        if (!realmSchema.contains("LineOfSightConfig")) {
            LineOfSightConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        realmObjectSchema.add(new Property("config", RealmFieldType.OBJECT, realmSchema.get("LineOfSightConfig")));
        return realmObjectSchema;
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (sharedRealm.hasTable("class_LineOfSightResult")) {
            return sharedRealm.getTable("class_LineOfSightResult");
        }
        Table table = sharedRealm.getTable("class_LineOfSightResult");
        table.addColumn(RealmFieldType.INTEGER, IdentityRealmObject.FIELD_ID, false);
        table.addColumn(RealmFieldType.INTEGER, LineOfSightResult.FIELD_MISTAKE_COUNT, false);
        table.addColumn(RealmFieldType.INTEGER, LineOfSightResult.FIELD_FOUND_MISTAKE_COUNT, false);
        table.addColumn(RealmFieldType.INTEGER, UnixTimeRealmObject.FIELD_UNIX_TIME, false);
        if (!sharedRealm.hasTable("class_LineOfSightConfig")) {
            LineOfSightConfigRealmProxy.initTable(sharedRealm);
        }
        table.addColumnLink(RealmFieldType.OBJECT, "config", sharedRealm.getTable("class_LineOfSightConfig"));
        table.addSearchIndex(table.getColumnIndex(IdentityRealmObject.FIELD_ID));
        table.setPrimaryKey(IdentityRealmObject.FIELD_ID);
        return table;
    }

    public static LineOfSightResultColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_LineOfSightResult")) {
            Table table = sharedRealm.getTable("class_LineOfSightResult");
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
            LineOfSightResultColumnInfo columnInfo2 = new LineOfSightResultColumnInfo(sharedRealm.getPath(), table);
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
            } else if (!columnTypes.containsKey(LineOfSightResult.FIELD_MISTAKE_COUNT)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'mistakeCount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(LineOfSightResult.FIELD_MISTAKE_COUNT) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'mistakeCount' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.mistakeCountIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'mistakeCount' does support null values in the existing Realm file. Use corresponding boxed type for field 'mistakeCount' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(LineOfSightResult.FIELD_FOUND_MISTAKE_COUNT)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'foundMistakeCount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(LineOfSightResult.FIELD_FOUND_MISTAKE_COUNT) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'foundMistakeCount' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.foundMistakeCountIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'foundMistakeCount' does support null values in the existing Realm file. Use corresponding boxed type for field 'foundMistakeCount' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(UnixTimeRealmObject.FIELD_UNIX_TIME)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'unixTime' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(UnixTimeRealmObject.FIELD_UNIX_TIME) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'long' for field 'unixTime' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.unixTimeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'unixTime' does support null values in the existing Realm file. Use corresponding boxed type for field 'unixTime' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey("config")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'config' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get("config") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'LineOfSightConfig' for field 'config'");
            } else if (!sharedRealm.hasTable("class_LineOfSightConfig")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_LineOfSightConfig' for field 'config'");
            } else {
                Table table_4 = sharedRealm.getTable("class_LineOfSightConfig");
                if (table.getLinkTarget(columnInfo2.configIndex).hasSameSchema(table_4)) {
                    return columnInfo2;
                }
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmObject for field 'config': '" + table.getLinkTarget(columnInfo2.configIndex).getName() + "' expected - was '" + table_4.getName() + "'");
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'LineOfSightResult' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_LineOfSightResult";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static LineOfSightResult createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update) throws JSONException {
        ArrayList arrayList = new ArrayList(1);
        LineOfSightResult obj = null;
        if (update) {
            Table table = realm.getTable(LineOfSightResult.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = -1;
            if (!json.isNull(IdentityRealmObject.FIELD_ID)) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong(IdentityRealmObject.FIELD_ID));
            }
            if (rowIndex != -1) {
                BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(LineOfSightResult.class), false, Collections.emptyList());
                    obj = new LineOfSightResultRealmProxy();
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
                obj = (LineOfSightResultRealmProxy) realm.createObjectInternal(LineOfSightResult.class, (Object) null, true, arrayList);
            } else {
                obj = (LineOfSightResultRealmProxy) realm.createObjectInternal(LineOfSightResult.class, Integer.valueOf(json.getInt(IdentityRealmObject.FIELD_ID)), true, arrayList);
            }
        }
        if (json.has(LineOfSightResult.FIELD_MISTAKE_COUNT)) {
            if (json.isNull(LineOfSightResult.FIELD_MISTAKE_COUNT)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'mistakeCount' to null.");
            }
            obj.realmSet$mistakeCount(json.getInt(LineOfSightResult.FIELD_MISTAKE_COUNT));
        }
        if (json.has(LineOfSightResult.FIELD_FOUND_MISTAKE_COUNT)) {
            if (json.isNull(LineOfSightResult.FIELD_FOUND_MISTAKE_COUNT)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'foundMistakeCount' to null.");
            }
            obj.realmSet$foundMistakeCount(json.getInt(LineOfSightResult.FIELD_FOUND_MISTAKE_COUNT));
        }
        if (json.has(UnixTimeRealmObject.FIELD_UNIX_TIME)) {
            if (json.isNull(UnixTimeRealmObject.FIELD_UNIX_TIME)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'unixTime' to null.");
            }
            obj.realmSet$unixTime(json.getLong(UnixTimeRealmObject.FIELD_UNIX_TIME));
        }
        if (json.has("config")) {
            if (json.isNull("config")) {
                obj.realmSet$config((LineOfSightConfig) null);
            } else {
                obj.realmSet$config(LineOfSightConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("config"), update));
            }
        }
        return obj;
    }

    @TargetApi(11)
    public static LineOfSightResult createUsingJsonStream(Realm realm, JsonReader reader) throws IOException {
        boolean jsonHasPrimaryKey = false;
        LineOfSightResult obj = new LineOfSightResult();
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
            } else if (name.equals(LineOfSightResult.FIELD_MISTAKE_COUNT)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'mistakeCount' to null.");
                }
                obj.realmSet$mistakeCount(reader.nextInt());
            } else if (name.equals(LineOfSightResult.FIELD_FOUND_MISTAKE_COUNT)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'foundMistakeCount' to null.");
                }
                obj.realmSet$foundMistakeCount(reader.nextInt());
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
                obj.realmSet$config((LineOfSightConfig) null);
            } else {
                obj.realmSet$config(LineOfSightConfigRealmProxy.createUsingJsonStream(realm, reader));
            }
        }
        reader.endObject();
        if (jsonHasPrimaryKey) {
            return (LineOfSightResult) realm.copyToRealm(obj);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
    }

    public static LineOfSightResult copyOrUpdate(Realm realm, LineOfSightResult object, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        } else {
            BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            RealmObjectProxy cachedRealmObject = cache.get(object);
            if (cachedRealmObject != null) {
                return (LineOfSightResult) cachedRealmObject;
            }
            LineOfSightResult realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(LineOfSightResult.class);
                long rowIndex = table.findFirstLong(table.getPrimaryKey(), (long) object.realmGet$id());
                if (rowIndex != -1) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(LineOfSightResult.class), false, Collections.emptyList());
                        LineOfSightResult realmObject2 = new LineOfSightResultRealmProxy();
                        try {
                            cache.put(object, (RealmObjectProxy) realmObject2);
                            objectContext.clear();
                            realmObject = realmObject2;
                        } catch (Throwable th) {
                            th = th;
                            LineOfSightResult lineOfSightResult = realmObject2;
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

    public static LineOfSightResult copy(Realm realm, LineOfSightResult newObject, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (LineOfSightResult) cachedRealmObject;
        }
        LineOfSightResult realmObject = (LineOfSightResult) realm.createObjectInternal(LineOfSightResult.class, Integer.valueOf(newObject.realmGet$id()), false, Collections.emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.realmSet$mistakeCount(newObject.realmGet$mistakeCount());
        realmObject.realmSet$foundMistakeCount(newObject.realmGet$foundMistakeCount());
        realmObject.realmSet$unixTime(newObject.realmGet$unixTime());
        LineOfSightConfig configObj = newObject.realmGet$config();
        if (configObj != null) {
            LineOfSightConfig cacheconfig = (LineOfSightConfig) cache.get(configObj);
            if (cacheconfig != null) {
                realmObject.realmSet$config(cacheconfig);
            } else {
                realmObject.realmSet$config(LineOfSightConfigRealmProxy.copyOrUpdate(realm, configObj, update, cache));
            }
        } else {
            realmObject.realmSet$config((LineOfSightConfig) null);
        }
        return realmObject;
    }

    public static long insert(Realm realm, LineOfSightResult object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(LineOfSightResult.class);
        long tableNativePtr = table.getNativeTablePointer();
        LineOfSightResultColumnInfo columnInfo2 = (LineOfSightResultColumnInfo) realm.schema.getColumnInfo(LineOfSightResult.class);
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
        Table.nativeSetLong(tableNativePtr, columnInfo2.mistakeCountIndex, rowIndex, (long) object.realmGet$mistakeCount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.foundMistakeCountIndex, rowIndex, (long) object.realmGet$foundMistakeCount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.unixTimeIndex, rowIndex, object.realmGet$unixTime(), false);
        LineOfSightConfig configObj = object.realmGet$config();
        if (configObj == null) {
            return rowIndex;
        }
        Long cacheconfig = cache.get(configObj);
        if (cacheconfig == null) {
            cacheconfig = Long.valueOf(LineOfSightConfigRealmProxy.insert(realm, configObj, cache));
        }
        Table.nativeSetLink(tableNativePtr, columnInfo2.configIndex, rowIndex, cacheconfig.longValue(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(LineOfSightResult.class);
        long tableNativePtr = table.getNativeTablePointer();
        LineOfSightResultColumnInfo columnInfo2 = (LineOfSightResultColumnInfo) realm.schema.getColumnInfo(LineOfSightResult.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            LineOfSightResult object = (LineOfSightResult) objects.next();
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
                    Table.nativeSetLong(tableNativePtr, columnInfo2.mistakeCountIndex, rowIndex, (long) object.realmGet$mistakeCount(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.foundMistakeCountIndex, rowIndex, (long) object.realmGet$foundMistakeCount(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.unixTimeIndex, rowIndex, object.realmGet$unixTime(), false);
                    LineOfSightConfig configObj = object.realmGet$config();
                    if (configObj != null) {
                        Long cacheconfig = cache.get(configObj);
                        if (cacheconfig == null) {
                            cacheconfig = Long.valueOf(LineOfSightConfigRealmProxy.insert(realm, configObj, cache));
                        }
                        table.setLink(columnInfo2.configIndex, rowIndex, cacheconfig.longValue(), false);
                    }
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, LineOfSightResult object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(LineOfSightResult.class);
        long tableNativePtr = table.getNativeTablePointer();
        LineOfSightResultColumnInfo columnInfo2 = (LineOfSightResultColumnInfo) realm.schema.getColumnInfo(LineOfSightResult.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = -1;
        if (Integer.valueOf(object.realmGet$id()) != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, (long) object.realmGet$id());
        }
        if (rowIndex == -1) {
            rowIndex = table.addEmptyRowWithPrimaryKey(Integer.valueOf(object.realmGet$id()), false);
        }
        cache.put(object, Long.valueOf(rowIndex));
        Table.nativeSetLong(tableNativePtr, columnInfo2.mistakeCountIndex, rowIndex, (long) object.realmGet$mistakeCount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.foundMistakeCountIndex, rowIndex, (long) object.realmGet$foundMistakeCount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.unixTimeIndex, rowIndex, object.realmGet$unixTime(), false);
        LineOfSightConfig configObj = object.realmGet$config();
        if (configObj != null) {
            Long cacheconfig = cache.get(configObj);
            if (cacheconfig == null) {
                cacheconfig = Long.valueOf(LineOfSightConfigRealmProxy.insertOrUpdate(realm, configObj, cache));
            }
            Table.nativeSetLink(tableNativePtr, columnInfo2.configIndex, rowIndex, cacheconfig.longValue(), false);
            return rowIndex;
        }
        Table.nativeNullifyLink(tableNativePtr, columnInfo2.configIndex, rowIndex);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(LineOfSightResult.class);
        long tableNativePtr = table.getNativeTablePointer();
        LineOfSightResultColumnInfo columnInfo2 = (LineOfSightResultColumnInfo) realm.schema.getColumnInfo(LineOfSightResult.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            LineOfSightResult object = (LineOfSightResult) objects.next();
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
                    Table.nativeSetLong(tableNativePtr, columnInfo2.mistakeCountIndex, rowIndex, (long) object.realmGet$mistakeCount(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.foundMistakeCountIndex, rowIndex, (long) object.realmGet$foundMistakeCount(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.unixTimeIndex, rowIndex, object.realmGet$unixTime(), false);
                    LineOfSightConfig configObj = object.realmGet$config();
                    if (configObj != null) {
                        Long cacheconfig = cache.get(configObj);
                        if (cacheconfig == null) {
                            cacheconfig = Long.valueOf(LineOfSightConfigRealmProxy.insertOrUpdate(realm, configObj, cache));
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

    public static LineOfSightResult createDetachedCopy(LineOfSightResult realmObject, int currentDepth, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        LineOfSightResult unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        RealmObjectProxy.CacheData<RealmModel> cachedObject = cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new LineOfSightResult();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.minDepth) {
            return (LineOfSightResult) cachedObject.object;
        } else {
            unmanagedObject = (LineOfSightResult) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        unmanagedObject.realmSet$id(realmObject.realmGet$id());
        unmanagedObject.realmSet$mistakeCount(realmObject.realmGet$mistakeCount());
        unmanagedObject.realmSet$foundMistakeCount(realmObject.realmGet$foundMistakeCount());
        unmanagedObject.realmSet$unixTime(realmObject.realmGet$unixTime());
        unmanagedObject.realmSet$config(LineOfSightConfigRealmProxy.createDetachedCopy(realmObject.realmGet$config(), currentDepth + 1, maxDepth, cache));
        return unmanagedObject;
    }

    static LineOfSightResult update(Realm realm, LineOfSightResult realmObject, LineOfSightResult newObject, Map<RealmModel, RealmObjectProxy> cache) {
        realmObject.realmSet$mistakeCount(newObject.realmGet$mistakeCount());
        realmObject.realmSet$foundMistakeCount(newObject.realmGet$foundMistakeCount());
        realmObject.realmSet$unixTime(newObject.realmGet$unixTime());
        LineOfSightConfig configObj = newObject.realmGet$config();
        if (configObj != null) {
            LineOfSightConfig cacheconfig = (LineOfSightConfig) cache.get(configObj);
            if (cacheconfig != null) {
                realmObject.realmSet$config(cacheconfig);
            } else {
                realmObject.realmSet$config(LineOfSightConfigRealmProxy.copyOrUpdate(realm, configObj, true, cache));
            }
        } else {
            realmObject.realmSet$config((LineOfSightConfig) null);
        }
        return realmObject;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("LineOfSightResult = [");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mistakeCount:");
        stringBuilder.append(realmGet$mistakeCount());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{foundMistakeCount:");
        stringBuilder.append(realmGet$foundMistakeCount());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{unixTime:");
        stringBuilder.append(realmGet$unixTime());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{config:");
        stringBuilder.append(realmGet$config() != null ? "LineOfSightConfig" : "null");
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
        LineOfSightResultRealmProxy aLineOfSightResult = (LineOfSightResultRealmProxy) o;
        String path = this.proxyState.getRealm$realm().getPath();
        String otherPath = aLineOfSightResult.proxyState.getRealm$realm().getPath();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.proxyState.getRow$realm().getTable().getName();
        String otherTableName = aLineOfSightResult.proxyState.getRow$realm().getTable().getName();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != aLineOfSightResult.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
