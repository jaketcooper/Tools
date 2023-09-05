package p006io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightConfig;
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

/* renamed from: io.realm.LineOfSightConfigRealmProxy */
public class LineOfSightConfigRealmProxy extends LineOfSightConfig implements RealmObjectProxy, LineOfSightConfigRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private LineOfSightConfigColumnInfo columnInfo;
    private ProxyState<LineOfSightConfig> proxyState;

    /* renamed from: io.realm.LineOfSightConfigRealmProxy$LineOfSightConfigColumnInfo */
    static final class LineOfSightConfigColumnInfo extends ColumnInfo implements Cloneable {
        public long columnCountIndex;
        public long fieldTypeIndex;
        public long idIndex;
        public long mistakeProbabilityIndex;
        public long rowCountIndex;
        public long showCountIndex;
        public long showDelayIndex;

        LineOfSightConfigColumnInfo(String path, Table table) {
            Map<String, Long> indicesMap = new HashMap<>(7);
            this.idIndex = getValidColumnIndex(path, table, "LineOfSightConfig", IdentityRealmObject.FIELD_ID);
            indicesMap.put(IdentityRealmObject.FIELD_ID, Long.valueOf(this.idIndex));
            this.rowCountIndex = getValidColumnIndex(path, table, "LineOfSightConfig", "rowCount");
            indicesMap.put("rowCount", Long.valueOf(this.rowCountIndex));
            this.columnCountIndex = getValidColumnIndex(path, table, "LineOfSightConfig", "columnCount");
            indicesMap.put("columnCount", Long.valueOf(this.columnCountIndex));
            this.fieldTypeIndex = getValidColumnIndex(path, table, "LineOfSightConfig", LineOfSightConfig.FIELD_TYPE);
            indicesMap.put(LineOfSightConfig.FIELD_TYPE, Long.valueOf(this.fieldTypeIndex));
            this.showCountIndex = getValidColumnIndex(path, table, "LineOfSightConfig", LineOfSightConfig.FIELD_SHOW_COUNT);
            indicesMap.put(LineOfSightConfig.FIELD_SHOW_COUNT, Long.valueOf(this.showCountIndex));
            this.showDelayIndex = getValidColumnIndex(path, table, "LineOfSightConfig", LineOfSightConfig.FIELD_SHOW_DELAY);
            indicesMap.put(LineOfSightConfig.FIELD_SHOW_DELAY, Long.valueOf(this.showDelayIndex));
            this.mistakeProbabilityIndex = getValidColumnIndex(path, table, "LineOfSightConfig", LineOfSightConfig.FIELD_MISTAKE_PROBABILITY);
            indicesMap.put(LineOfSightConfig.FIELD_MISTAKE_PROBABILITY, Long.valueOf(this.mistakeProbabilityIndex));
            setIndicesMap(indicesMap);
        }

        public final void copyColumnInfoFrom(ColumnInfo other) {
            LineOfSightConfigColumnInfo otherInfo = (LineOfSightConfigColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.rowCountIndex = otherInfo.rowCountIndex;
            this.columnCountIndex = otherInfo.columnCountIndex;
            this.fieldTypeIndex = otherInfo.fieldTypeIndex;
            this.showCountIndex = otherInfo.showCountIndex;
            this.showDelayIndex = otherInfo.showDelayIndex;
            this.mistakeProbabilityIndex = otherInfo.mistakeProbabilityIndex;
            setIndicesMap(otherInfo.getIndicesMap());
        }

        public final LineOfSightConfigColumnInfo clone() {
            return (LineOfSightConfigColumnInfo) super.clone();
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add(IdentityRealmObject.FIELD_ID);
        fieldNames.add("rowCount");
        fieldNames.add("columnCount");
        fieldNames.add(LineOfSightConfig.FIELD_TYPE);
        fieldNames.add(LineOfSightConfig.FIELD_SHOW_COUNT);
        fieldNames.add(LineOfSightConfig.FIELD_SHOW_DELAY);
        fieldNames.add(LineOfSightConfig.FIELD_MISTAKE_PROBABILITY);
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    LineOfSightConfigRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext context = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (LineOfSightConfigColumnInfo) context.getColumnInfo();
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

    public int realmGet$rowCount() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.rowCountIndex);
    }

    public void realmSet$rowCount(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.rowCountIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.rowCountIndex, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$columnCount() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.columnCountIndex);
    }

    public void realmSet$columnCount(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.columnCountIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.columnCountIndex, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$fieldType() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.fieldTypeIndex);
    }

    public void realmSet$fieldType(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.fieldTypeIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.fieldTypeIndex, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$showCount() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.showCountIndex);
    }

    public void realmSet$showCount(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.showCountIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.showCountIndex, row.getIndex(), (long) value, true);
        }
    }

    public long realmGet$showDelay() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getLong(this.columnInfo.showDelayIndex);
    }

    public void realmSet$showDelay(long value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.showDelayIndex, value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.showDelayIndex, row.getIndex(), value, true);
        }
    }

    public int realmGet$mistakeProbability() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.mistakeProbabilityIndex);
    }

    public void realmSet$mistakeProbability(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.mistakeProbabilityIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.mistakeProbabilityIndex, row.getIndex(), (long) value, true);
        }
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (realmSchema.contains("LineOfSightConfig")) {
            return realmSchema.get("LineOfSightConfig");
        }
        RealmObjectSchema realmObjectSchema = realmSchema.create("LineOfSightConfig");
        realmObjectSchema.add(new Property(IdentityRealmObject.FIELD_ID, RealmFieldType.INTEGER, true, true, true));
        realmObjectSchema.add(new Property("rowCount", RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property("columnCount", RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(LineOfSightConfig.FIELD_TYPE, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(LineOfSightConfig.FIELD_SHOW_COUNT, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(LineOfSightConfig.FIELD_SHOW_DELAY, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(LineOfSightConfig.FIELD_MISTAKE_PROBABILITY, RealmFieldType.INTEGER, false, false, true));
        return realmObjectSchema;
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (sharedRealm.hasTable("class_LineOfSightConfig")) {
            return sharedRealm.getTable("class_LineOfSightConfig");
        }
        Table table = sharedRealm.getTable("class_LineOfSightConfig");
        table.addColumn(RealmFieldType.INTEGER, IdentityRealmObject.FIELD_ID, false);
        table.addColumn(RealmFieldType.INTEGER, "rowCount", false);
        table.addColumn(RealmFieldType.INTEGER, "columnCount", false);
        table.addColumn(RealmFieldType.INTEGER, LineOfSightConfig.FIELD_TYPE, false);
        table.addColumn(RealmFieldType.INTEGER, LineOfSightConfig.FIELD_SHOW_COUNT, false);
        table.addColumn(RealmFieldType.INTEGER, LineOfSightConfig.FIELD_SHOW_DELAY, false);
        table.addColumn(RealmFieldType.INTEGER, LineOfSightConfig.FIELD_MISTAKE_PROBABILITY, false);
        table.addSearchIndex(table.getColumnIndex(IdentityRealmObject.FIELD_ID));
        table.setPrimaryKey(IdentityRealmObject.FIELD_ID);
        return table;
    }

    public static LineOfSightConfigColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_LineOfSightConfig")) {
            Table table = sharedRealm.getTable("class_LineOfSightConfig");
            long columnCount = table.getColumnCount();
            if (columnCount != 7) {
                if (columnCount < 7) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 7 but was " + columnCount);
                } else if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 7 but was %1$d", Long.valueOf(columnCount));
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 7 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            LineOfSightConfigColumnInfo columnInfo2 = new LineOfSightConfigColumnInfo(sharedRealm.getPath(), table);
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
            } else if (!columnTypes.containsKey("rowCount")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'rowCount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get("rowCount") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'rowCount' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.rowCountIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'rowCount' does support null values in the existing Realm file. Use corresponding boxed type for field 'rowCount' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey("columnCount")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'columnCount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get("columnCount") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'columnCount' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.columnCountIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'columnCount' does support null values in the existing Realm file. Use corresponding boxed type for field 'columnCount' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(LineOfSightConfig.FIELD_TYPE)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'fieldType' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(LineOfSightConfig.FIELD_TYPE) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'fieldType' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.fieldTypeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'fieldType' does support null values in the existing Realm file. Use corresponding boxed type for field 'fieldType' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(LineOfSightConfig.FIELD_SHOW_COUNT)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'showCount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(LineOfSightConfig.FIELD_SHOW_COUNT) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'showCount' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.showCountIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'showCount' does support null values in the existing Realm file. Use corresponding boxed type for field 'showCount' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(LineOfSightConfig.FIELD_SHOW_DELAY)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'showDelay' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(LineOfSightConfig.FIELD_SHOW_DELAY) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'long' for field 'showDelay' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.showDelayIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'showDelay' does support null values in the existing Realm file. Use corresponding boxed type for field 'showDelay' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(LineOfSightConfig.FIELD_MISTAKE_PROBABILITY)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'mistakeProbability' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(LineOfSightConfig.FIELD_MISTAKE_PROBABILITY) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'mistakeProbability' in existing Realm file.");
            } else if (!table.isColumnNullable(columnInfo2.mistakeProbabilityIndex)) {
                return columnInfo2;
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'mistakeProbability' does support null values in the existing Realm file. Use corresponding boxed type for field 'mistakeProbability' or migrate using RealmObjectSchema.setNullable().");
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'LineOfSightConfig' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_LineOfSightConfig";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static LineOfSightConfig createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update) throws JSONException {
        List emptyList = Collections.emptyList();
        LineOfSightConfig obj = null;
        if (update) {
            Table table = realm.getTable(LineOfSightConfig.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = -1;
            if (!json.isNull(IdentityRealmObject.FIELD_ID)) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong(IdentityRealmObject.FIELD_ID));
            }
            if (rowIndex != -1) {
                BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(LineOfSightConfig.class), false, Collections.emptyList());
                    obj = new LineOfSightConfigRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (!json.has(IdentityRealmObject.FIELD_ID)) {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            } else if (json.isNull(IdentityRealmObject.FIELD_ID)) {
                obj = (LineOfSightConfigRealmProxy) realm.createObjectInternal(LineOfSightConfig.class, (Object) null, true, emptyList);
            } else {
                obj = (LineOfSightConfigRealmProxy) realm.createObjectInternal(LineOfSightConfig.class, Integer.valueOf(json.getInt(IdentityRealmObject.FIELD_ID)), true, emptyList);
            }
        }
        if (json.has("rowCount")) {
            if (json.isNull("rowCount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'rowCount' to null.");
            }
            obj.realmSet$rowCount(json.getInt("rowCount"));
        }
        if (json.has("columnCount")) {
            if (json.isNull("columnCount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'columnCount' to null.");
            }
            obj.realmSet$columnCount(json.getInt("columnCount"));
        }
        if (json.has(LineOfSightConfig.FIELD_TYPE)) {
            if (json.isNull(LineOfSightConfig.FIELD_TYPE)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'fieldType' to null.");
            }
            obj.realmSet$fieldType(json.getInt(LineOfSightConfig.FIELD_TYPE));
        }
        if (json.has(LineOfSightConfig.FIELD_SHOW_COUNT)) {
            if (json.isNull(LineOfSightConfig.FIELD_SHOW_COUNT)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'showCount' to null.");
            }
            obj.realmSet$showCount(json.getInt(LineOfSightConfig.FIELD_SHOW_COUNT));
        }
        if (json.has(LineOfSightConfig.FIELD_SHOW_DELAY)) {
            if (json.isNull(LineOfSightConfig.FIELD_SHOW_DELAY)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'showDelay' to null.");
            }
            obj.realmSet$showDelay(json.getLong(LineOfSightConfig.FIELD_SHOW_DELAY));
        }
        if (json.has(LineOfSightConfig.FIELD_MISTAKE_PROBABILITY)) {
            if (json.isNull(LineOfSightConfig.FIELD_MISTAKE_PROBABILITY)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'mistakeProbability' to null.");
            }
            obj.realmSet$mistakeProbability(json.getInt(LineOfSightConfig.FIELD_MISTAKE_PROBABILITY));
        }
        return obj;
    }

    @TargetApi(11)
    public static LineOfSightConfig createUsingJsonStream(Realm realm, JsonReader reader) throws IOException {
        boolean jsonHasPrimaryKey = false;
        LineOfSightConfig obj = new LineOfSightConfig();
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
            } else if (name.equals("rowCount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'rowCount' to null.");
                }
                obj.realmSet$rowCount(reader.nextInt());
            } else if (name.equals("columnCount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'columnCount' to null.");
                }
                obj.realmSet$columnCount(reader.nextInt());
            } else if (name.equals(LineOfSightConfig.FIELD_TYPE)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'fieldType' to null.");
                }
                obj.realmSet$fieldType(reader.nextInt());
            } else if (name.equals(LineOfSightConfig.FIELD_SHOW_COUNT)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'showCount' to null.");
                }
                obj.realmSet$showCount(reader.nextInt());
            } else if (name.equals(LineOfSightConfig.FIELD_SHOW_DELAY)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'showDelay' to null.");
                }
                obj.realmSet$showDelay(reader.nextLong());
            } else if (!name.equals(LineOfSightConfig.FIELD_MISTAKE_PROBABILITY)) {
                reader.skipValue();
            } else if (reader.peek() == JsonToken.NULL) {
                reader.skipValue();
                throw new IllegalArgumentException("Trying to set non-nullable field 'mistakeProbability' to null.");
            } else {
                obj.realmSet$mistakeProbability(reader.nextInt());
            }
        }
        reader.endObject();
        if (jsonHasPrimaryKey) {
            return (LineOfSightConfig) realm.copyToRealm(obj);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
    }

    public static LineOfSightConfig copyOrUpdate(Realm realm, LineOfSightConfig object, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        } else {
            BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            RealmObjectProxy cachedRealmObject = cache.get(object);
            if (cachedRealmObject != null) {
                return (LineOfSightConfig) cachedRealmObject;
            }
            LineOfSightConfig realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(LineOfSightConfig.class);
                long rowIndex = table.findFirstLong(table.getPrimaryKey(), (long) object.realmGet$id());
                if (rowIndex != -1) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(LineOfSightConfig.class), false, Collections.emptyList());
                        LineOfSightConfig realmObject2 = new LineOfSightConfigRealmProxy();
                        try {
                            cache.put(object, (RealmObjectProxy) realmObject2);
                            objectContext.clear();
                            realmObject = realmObject2;
                        } catch (Throwable th) {
                            th = th;
                            LineOfSightConfig lineOfSightConfig = realmObject2;
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

    public static LineOfSightConfig copy(Realm realm, LineOfSightConfig newObject, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (LineOfSightConfig) cachedRealmObject;
        }
        LineOfSightConfig realmObject = (LineOfSightConfig) realm.createObjectInternal(LineOfSightConfig.class, Integer.valueOf(newObject.realmGet$id()), false, Collections.emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.realmSet$rowCount(newObject.realmGet$rowCount());
        realmObject.realmSet$columnCount(newObject.realmGet$columnCount());
        realmObject.realmSet$fieldType(newObject.realmGet$fieldType());
        realmObject.realmSet$showCount(newObject.realmGet$showCount());
        realmObject.realmSet$showDelay(newObject.realmGet$showDelay());
        realmObject.realmSet$mistakeProbability(newObject.realmGet$mistakeProbability());
        return realmObject;
    }

    public static long insert(Realm realm, LineOfSightConfig object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(LineOfSightConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        LineOfSightConfigColumnInfo columnInfo2 = (LineOfSightConfigColumnInfo) realm.schema.getColumnInfo(LineOfSightConfig.class);
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
        Table.nativeSetLong(tableNativePtr, columnInfo2.rowCountIndex, rowIndex, (long) object.realmGet$rowCount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.columnCountIndex, rowIndex, (long) object.realmGet$columnCount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.fieldTypeIndex, rowIndex, (long) object.realmGet$fieldType(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.showCountIndex, rowIndex, (long) object.realmGet$showCount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.showDelayIndex, rowIndex, object.realmGet$showDelay(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.mistakeProbabilityIndex, rowIndex, (long) object.realmGet$mistakeProbability(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(LineOfSightConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        LineOfSightConfigColumnInfo columnInfo2 = (LineOfSightConfigColumnInfo) realm.schema.getColumnInfo(LineOfSightConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            LineOfSightConfig object = (LineOfSightConfig) objects.next();
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
                    Table.nativeSetLong(tableNativePtr, columnInfo2.rowCountIndex, rowIndex, (long) object.realmGet$rowCount(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.columnCountIndex, rowIndex, (long) object.realmGet$columnCount(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.fieldTypeIndex, rowIndex, (long) object.realmGet$fieldType(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.showCountIndex, rowIndex, (long) object.realmGet$showCount(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.showDelayIndex, rowIndex, object.realmGet$showDelay(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.mistakeProbabilityIndex, rowIndex, (long) object.realmGet$mistakeProbability(), false);
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, LineOfSightConfig object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(LineOfSightConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        LineOfSightConfigColumnInfo columnInfo2 = (LineOfSightConfigColumnInfo) realm.schema.getColumnInfo(LineOfSightConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = -1;
        if (Integer.valueOf(object.realmGet$id()) != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, (long) object.realmGet$id());
        }
        if (rowIndex == -1) {
            rowIndex = table.addEmptyRowWithPrimaryKey(Integer.valueOf(object.realmGet$id()), false);
        }
        cache.put(object, Long.valueOf(rowIndex));
        Table.nativeSetLong(tableNativePtr, columnInfo2.rowCountIndex, rowIndex, (long) object.realmGet$rowCount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.columnCountIndex, rowIndex, (long) object.realmGet$columnCount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.fieldTypeIndex, rowIndex, (long) object.realmGet$fieldType(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.showCountIndex, rowIndex, (long) object.realmGet$showCount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.showDelayIndex, rowIndex, object.realmGet$showDelay(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.mistakeProbabilityIndex, rowIndex, (long) object.realmGet$mistakeProbability(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(LineOfSightConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        LineOfSightConfigColumnInfo columnInfo2 = (LineOfSightConfigColumnInfo) realm.schema.getColumnInfo(LineOfSightConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            LineOfSightConfig object = (LineOfSightConfig) objects.next();
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
                    Table.nativeSetLong(tableNativePtr, columnInfo2.rowCountIndex, rowIndex, (long) object.realmGet$rowCount(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.columnCountIndex, rowIndex, (long) object.realmGet$columnCount(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.fieldTypeIndex, rowIndex, (long) object.realmGet$fieldType(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.showCountIndex, rowIndex, (long) object.realmGet$showCount(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.showDelayIndex, rowIndex, object.realmGet$showDelay(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.mistakeProbabilityIndex, rowIndex, (long) object.realmGet$mistakeProbability(), false);
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static LineOfSightConfig createDetachedCopy(LineOfSightConfig realmObject, int currentDepth, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        LineOfSightConfig unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        RealmObjectProxy.CacheData<RealmModel> cachedObject = cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new LineOfSightConfig();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.minDepth) {
            return (LineOfSightConfig) cachedObject.object;
        } else {
            unmanagedObject = (LineOfSightConfig) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        unmanagedObject.realmSet$id(realmObject.realmGet$id());
        unmanagedObject.realmSet$rowCount(realmObject.realmGet$rowCount());
        unmanagedObject.realmSet$columnCount(realmObject.realmGet$columnCount());
        unmanagedObject.realmSet$fieldType(realmObject.realmGet$fieldType());
        unmanagedObject.realmSet$showCount(realmObject.realmGet$showCount());
        unmanagedObject.realmSet$showDelay(realmObject.realmGet$showDelay());
        unmanagedObject.realmSet$mistakeProbability(realmObject.realmGet$mistakeProbability());
        return unmanagedObject;
    }

    static LineOfSightConfig update(Realm realm, LineOfSightConfig realmObject, LineOfSightConfig newObject, Map<RealmModel, RealmObjectProxy> map) {
        realmObject.realmSet$rowCount(newObject.realmGet$rowCount());
        realmObject.realmSet$columnCount(newObject.realmGet$columnCount());
        realmObject.realmSet$fieldType(newObject.realmGet$fieldType());
        realmObject.realmSet$showCount(newObject.realmGet$showCount());
        realmObject.realmSet$showDelay(newObject.realmGet$showDelay());
        realmObject.realmSet$mistakeProbability(newObject.realmGet$mistakeProbability());
        return realmObject;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        return "LineOfSightConfig = [" + "{id:" + realmGet$id() + "}" + "," + "{rowCount:" + realmGet$rowCount() + "}" + "," + "{columnCount:" + realmGet$columnCount() + "}" + "," + "{fieldType:" + realmGet$fieldType() + "}" + "," + "{showCount:" + realmGet$showCount() + "}" + "," + "{showDelay:" + realmGet$showDelay() + "}" + "," + "{mistakeProbability:" + realmGet$mistakeProbability() + "}" + "]";
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
        LineOfSightConfigRealmProxy aLineOfSightConfig = (LineOfSightConfigRealmProxy) o;
        String path = this.proxyState.getRealm$realm().getPath();
        String otherPath = aLineOfSightConfig.proxyState.getRealm$realm().getPath();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.proxyState.getRow$realm().getTable().getName();
        String otherTableName = aLineOfSightConfig.proxyState.getRow$realm().getTable().getName();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != aLineOfSightConfig.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
