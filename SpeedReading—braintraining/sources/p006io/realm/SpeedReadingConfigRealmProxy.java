package p006io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingConfig;
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

/* renamed from: io.realm.SpeedReadingConfigRealmProxy */
public class SpeedReadingConfigRealmProxy extends SpeedReadingConfig implements RealmObjectProxy, SpeedReadingConfigRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private SpeedReadingConfigColumnInfo columnInfo;
    private ProxyState<SpeedReadingConfig> proxyState;

    /* renamed from: io.realm.SpeedReadingConfigRealmProxy$SpeedReadingConfigColumnInfo */
    static final class SpeedReadingConfigColumnInfo extends ColumnInfo implements Cloneable {
        public long idIndex;
        public long maxWordShowCountIndex;
        public long minSpeedIndex;
        public long minWordShowCountIndex;
        public long speedIndex;
        public long speedStepIndex;
        public long trainingShowCountIndex;

        SpeedReadingConfigColumnInfo(String path, Table table) {
            Map<String, Long> indicesMap = new HashMap<>(7);
            this.idIndex = getValidColumnIndex(path, table, "SpeedReadingConfig", IdentityRealmObject.FIELD_ID);
            indicesMap.put(IdentityRealmObject.FIELD_ID, Long.valueOf(this.idIndex));
            this.trainingShowCountIndex = getValidColumnIndex(path, table, "SpeedReadingConfig", "trainingShowCount");
            indicesMap.put("trainingShowCount", Long.valueOf(this.trainingShowCountIndex));
            this.minWordShowCountIndex = getValidColumnIndex(path, table, "SpeedReadingConfig", SpeedReadingConfig.FIELD_MIN_WORD_SHOW_COUNT);
            indicesMap.put(SpeedReadingConfig.FIELD_MIN_WORD_SHOW_COUNT, Long.valueOf(this.minWordShowCountIndex));
            this.maxWordShowCountIndex = getValidColumnIndex(path, table, "SpeedReadingConfig", SpeedReadingConfig.FIELD_MAX_WORD_SHOW_COUNT);
            indicesMap.put(SpeedReadingConfig.FIELD_MAX_WORD_SHOW_COUNT, Long.valueOf(this.maxWordShowCountIndex));
            this.speedIndex = getValidColumnIndex(path, table, "SpeedReadingConfig", SpeedReadingConfig.FIELD_SPEED);
            indicesMap.put(SpeedReadingConfig.FIELD_SPEED, Long.valueOf(this.speedIndex));
            this.minSpeedIndex = getValidColumnIndex(path, table, "SpeedReadingConfig", SpeedReadingConfig.FIELD_MIN_SPEED);
            indicesMap.put(SpeedReadingConfig.FIELD_MIN_SPEED, Long.valueOf(this.minSpeedIndex));
            this.speedStepIndex = getValidColumnIndex(path, table, "SpeedReadingConfig", SpeedReadingConfig.FIELD_SPEED_STEP);
            indicesMap.put(SpeedReadingConfig.FIELD_SPEED_STEP, Long.valueOf(this.speedStepIndex));
            setIndicesMap(indicesMap);
        }

        public final void copyColumnInfoFrom(ColumnInfo other) {
            SpeedReadingConfigColumnInfo otherInfo = (SpeedReadingConfigColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.trainingShowCountIndex = otherInfo.trainingShowCountIndex;
            this.minWordShowCountIndex = otherInfo.minWordShowCountIndex;
            this.maxWordShowCountIndex = otherInfo.maxWordShowCountIndex;
            this.speedIndex = otherInfo.speedIndex;
            this.minSpeedIndex = otherInfo.minSpeedIndex;
            this.speedStepIndex = otherInfo.speedStepIndex;
            setIndicesMap(otherInfo.getIndicesMap());
        }

        public final SpeedReadingConfigColumnInfo clone() {
            return (SpeedReadingConfigColumnInfo) super.clone();
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add(IdentityRealmObject.FIELD_ID);
        fieldNames.add("trainingShowCount");
        fieldNames.add(SpeedReadingConfig.FIELD_MIN_WORD_SHOW_COUNT);
        fieldNames.add(SpeedReadingConfig.FIELD_MAX_WORD_SHOW_COUNT);
        fieldNames.add(SpeedReadingConfig.FIELD_SPEED);
        fieldNames.add(SpeedReadingConfig.FIELD_MIN_SPEED);
        fieldNames.add(SpeedReadingConfig.FIELD_SPEED_STEP);
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    SpeedReadingConfigRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext context = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (SpeedReadingConfigColumnInfo) context.getColumnInfo();
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

    public int realmGet$trainingShowCount() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.trainingShowCountIndex);
    }

    public void realmSet$trainingShowCount(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.trainingShowCountIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.trainingShowCountIndex, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$minWordShowCount() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.minWordShowCountIndex);
    }

    public void realmSet$minWordShowCount(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.minWordShowCountIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.minWordShowCountIndex, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$maxWordShowCount() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.maxWordShowCountIndex);
    }

    public void realmSet$maxWordShowCount(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.maxWordShowCountIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.maxWordShowCountIndex, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$speed() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.speedIndex);
    }

    public void realmSet$speed(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.speedIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.speedIndex, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$minSpeed() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.minSpeedIndex);
    }

    public void realmSet$minSpeed(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.minSpeedIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.minSpeedIndex, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$speedStep() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.speedStepIndex);
    }

    public void realmSet$speedStep(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.speedStepIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.speedStepIndex, row.getIndex(), (long) value, true);
        }
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (realmSchema.contains("SpeedReadingConfig")) {
            return realmSchema.get("SpeedReadingConfig");
        }
        RealmObjectSchema realmObjectSchema = realmSchema.create("SpeedReadingConfig");
        realmObjectSchema.add(new Property(IdentityRealmObject.FIELD_ID, RealmFieldType.INTEGER, true, true, true));
        realmObjectSchema.add(new Property("trainingShowCount", RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(SpeedReadingConfig.FIELD_MIN_WORD_SHOW_COUNT, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(SpeedReadingConfig.FIELD_MAX_WORD_SHOW_COUNT, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(SpeedReadingConfig.FIELD_SPEED, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(SpeedReadingConfig.FIELD_MIN_SPEED, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(SpeedReadingConfig.FIELD_SPEED_STEP, RealmFieldType.INTEGER, false, false, true));
        return realmObjectSchema;
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (sharedRealm.hasTable("class_SpeedReadingConfig")) {
            return sharedRealm.getTable("class_SpeedReadingConfig");
        }
        Table table = sharedRealm.getTable("class_SpeedReadingConfig");
        table.addColumn(RealmFieldType.INTEGER, IdentityRealmObject.FIELD_ID, false);
        table.addColumn(RealmFieldType.INTEGER, "trainingShowCount", false);
        table.addColumn(RealmFieldType.INTEGER, SpeedReadingConfig.FIELD_MIN_WORD_SHOW_COUNT, false);
        table.addColumn(RealmFieldType.INTEGER, SpeedReadingConfig.FIELD_MAX_WORD_SHOW_COUNT, false);
        table.addColumn(RealmFieldType.INTEGER, SpeedReadingConfig.FIELD_SPEED, false);
        table.addColumn(RealmFieldType.INTEGER, SpeedReadingConfig.FIELD_MIN_SPEED, false);
        table.addColumn(RealmFieldType.INTEGER, SpeedReadingConfig.FIELD_SPEED_STEP, false);
        table.addSearchIndex(table.getColumnIndex(IdentityRealmObject.FIELD_ID));
        table.setPrimaryKey(IdentityRealmObject.FIELD_ID);
        return table;
    }

    public static SpeedReadingConfigColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_SpeedReadingConfig")) {
            Table table = sharedRealm.getTable("class_SpeedReadingConfig");
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
            SpeedReadingConfigColumnInfo columnInfo2 = new SpeedReadingConfigColumnInfo(sharedRealm.getPath(), table);
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
            } else if (!columnTypes.containsKey("trainingShowCount")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'trainingShowCount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get("trainingShowCount") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'trainingShowCount' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.trainingShowCountIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'trainingShowCount' does support null values in the existing Realm file. Use corresponding boxed type for field 'trainingShowCount' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(SpeedReadingConfig.FIELD_MIN_WORD_SHOW_COUNT)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'minWordShowCount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(SpeedReadingConfig.FIELD_MIN_WORD_SHOW_COUNT) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'minWordShowCount' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.minWordShowCountIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'minWordShowCount' does support null values in the existing Realm file. Use corresponding boxed type for field 'minWordShowCount' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(SpeedReadingConfig.FIELD_MAX_WORD_SHOW_COUNT)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'maxWordShowCount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(SpeedReadingConfig.FIELD_MAX_WORD_SHOW_COUNT) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'maxWordShowCount' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.maxWordShowCountIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'maxWordShowCount' does support null values in the existing Realm file. Use corresponding boxed type for field 'maxWordShowCount' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(SpeedReadingConfig.FIELD_SPEED)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'speed' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(SpeedReadingConfig.FIELD_SPEED) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'speed' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.speedIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'speed' does support null values in the existing Realm file. Use corresponding boxed type for field 'speed' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(SpeedReadingConfig.FIELD_MIN_SPEED)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'minSpeed' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(SpeedReadingConfig.FIELD_MIN_SPEED) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'minSpeed' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.minSpeedIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'minSpeed' does support null values in the existing Realm file. Use corresponding boxed type for field 'minSpeed' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(SpeedReadingConfig.FIELD_SPEED_STEP)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'speedStep' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(SpeedReadingConfig.FIELD_SPEED_STEP) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'speedStep' in existing Realm file.");
            } else if (!table.isColumnNullable(columnInfo2.speedStepIndex)) {
                return columnInfo2;
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'speedStep' does support null values in the existing Realm file. Use corresponding boxed type for field 'speedStep' or migrate using RealmObjectSchema.setNullable().");
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'SpeedReadingConfig' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_SpeedReadingConfig";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static SpeedReadingConfig createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update) throws JSONException {
        List emptyList = Collections.emptyList();
        SpeedReadingConfig obj = null;
        if (update) {
            Table table = realm.getTable(SpeedReadingConfig.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = -1;
            if (!json.isNull(IdentityRealmObject.FIELD_ID)) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong(IdentityRealmObject.FIELD_ID));
            }
            if (rowIndex != -1) {
                BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(SpeedReadingConfig.class), false, Collections.emptyList());
                    obj = new SpeedReadingConfigRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (!json.has(IdentityRealmObject.FIELD_ID)) {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            } else if (json.isNull(IdentityRealmObject.FIELD_ID)) {
                obj = (SpeedReadingConfigRealmProxy) realm.createObjectInternal(SpeedReadingConfig.class, (Object) null, true, emptyList);
            } else {
                obj = (SpeedReadingConfigRealmProxy) realm.createObjectInternal(SpeedReadingConfig.class, Integer.valueOf(json.getInt(IdentityRealmObject.FIELD_ID)), true, emptyList);
            }
        }
        if (json.has("trainingShowCount")) {
            if (json.isNull("trainingShowCount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'trainingShowCount' to null.");
            }
            obj.realmSet$trainingShowCount(json.getInt("trainingShowCount"));
        }
        if (json.has(SpeedReadingConfig.FIELD_MIN_WORD_SHOW_COUNT)) {
            if (json.isNull(SpeedReadingConfig.FIELD_MIN_WORD_SHOW_COUNT)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'minWordShowCount' to null.");
            }
            obj.realmSet$minWordShowCount(json.getInt(SpeedReadingConfig.FIELD_MIN_WORD_SHOW_COUNT));
        }
        if (json.has(SpeedReadingConfig.FIELD_MAX_WORD_SHOW_COUNT)) {
            if (json.isNull(SpeedReadingConfig.FIELD_MAX_WORD_SHOW_COUNT)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'maxWordShowCount' to null.");
            }
            obj.realmSet$maxWordShowCount(json.getInt(SpeedReadingConfig.FIELD_MAX_WORD_SHOW_COUNT));
        }
        if (json.has(SpeedReadingConfig.FIELD_SPEED)) {
            if (json.isNull(SpeedReadingConfig.FIELD_SPEED)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'speed' to null.");
            }
            obj.realmSet$speed(json.getInt(SpeedReadingConfig.FIELD_SPEED));
        }
        if (json.has(SpeedReadingConfig.FIELD_MIN_SPEED)) {
            if (json.isNull(SpeedReadingConfig.FIELD_MIN_SPEED)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'minSpeed' to null.");
            }
            obj.realmSet$minSpeed(json.getInt(SpeedReadingConfig.FIELD_MIN_SPEED));
        }
        if (json.has(SpeedReadingConfig.FIELD_SPEED_STEP)) {
            if (json.isNull(SpeedReadingConfig.FIELD_SPEED_STEP)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'speedStep' to null.");
            }
            obj.realmSet$speedStep(json.getInt(SpeedReadingConfig.FIELD_SPEED_STEP));
        }
        return obj;
    }

    @TargetApi(11)
    public static SpeedReadingConfig createUsingJsonStream(Realm realm, JsonReader reader) throws IOException {
        boolean jsonHasPrimaryKey = false;
        SpeedReadingConfig obj = new SpeedReadingConfig();
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
            } else if (name.equals("trainingShowCount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'trainingShowCount' to null.");
                }
                obj.realmSet$trainingShowCount(reader.nextInt());
            } else if (name.equals(SpeedReadingConfig.FIELD_MIN_WORD_SHOW_COUNT)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'minWordShowCount' to null.");
                }
                obj.realmSet$minWordShowCount(reader.nextInt());
            } else if (name.equals(SpeedReadingConfig.FIELD_MAX_WORD_SHOW_COUNT)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'maxWordShowCount' to null.");
                }
                obj.realmSet$maxWordShowCount(reader.nextInt());
            } else if (name.equals(SpeedReadingConfig.FIELD_SPEED)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'speed' to null.");
                }
                obj.realmSet$speed(reader.nextInt());
            } else if (name.equals(SpeedReadingConfig.FIELD_MIN_SPEED)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'minSpeed' to null.");
                }
                obj.realmSet$minSpeed(reader.nextInt());
            } else if (!name.equals(SpeedReadingConfig.FIELD_SPEED_STEP)) {
                reader.skipValue();
            } else if (reader.peek() == JsonToken.NULL) {
                reader.skipValue();
                throw new IllegalArgumentException("Trying to set non-nullable field 'speedStep' to null.");
            } else {
                obj.realmSet$speedStep(reader.nextInt());
            }
        }
        reader.endObject();
        if (jsonHasPrimaryKey) {
            return (SpeedReadingConfig) realm.copyToRealm(obj);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
    }

    public static SpeedReadingConfig copyOrUpdate(Realm realm, SpeedReadingConfig object, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        } else {
            BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            RealmObjectProxy cachedRealmObject = cache.get(object);
            if (cachedRealmObject != null) {
                return (SpeedReadingConfig) cachedRealmObject;
            }
            SpeedReadingConfig realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(SpeedReadingConfig.class);
                long rowIndex = table.findFirstLong(table.getPrimaryKey(), (long) object.realmGet$id());
                if (rowIndex != -1) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(SpeedReadingConfig.class), false, Collections.emptyList());
                        SpeedReadingConfig realmObject2 = new SpeedReadingConfigRealmProxy();
                        try {
                            cache.put(object, (RealmObjectProxy) realmObject2);
                            objectContext.clear();
                            realmObject = realmObject2;
                        } catch (Throwable th) {
                            th = th;
                            SpeedReadingConfig speedReadingConfig = realmObject2;
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

    public static SpeedReadingConfig copy(Realm realm, SpeedReadingConfig newObject, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (SpeedReadingConfig) cachedRealmObject;
        }
        SpeedReadingConfig realmObject = (SpeedReadingConfig) realm.createObjectInternal(SpeedReadingConfig.class, Integer.valueOf(newObject.realmGet$id()), false, Collections.emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.realmSet$trainingShowCount(newObject.realmGet$trainingShowCount());
        realmObject.realmSet$minWordShowCount(newObject.realmGet$minWordShowCount());
        realmObject.realmSet$maxWordShowCount(newObject.realmGet$maxWordShowCount());
        realmObject.realmSet$speed(newObject.realmGet$speed());
        realmObject.realmSet$minSpeed(newObject.realmGet$minSpeed());
        realmObject.realmSet$speedStep(newObject.realmGet$speedStep());
        return realmObject;
    }

    public static long insert(Realm realm, SpeedReadingConfig object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(SpeedReadingConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        SpeedReadingConfigColumnInfo columnInfo2 = (SpeedReadingConfigColumnInfo) realm.schema.getColumnInfo(SpeedReadingConfig.class);
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
        Table.nativeSetLong(tableNativePtr, columnInfo2.trainingShowCountIndex, rowIndex, (long) object.realmGet$trainingShowCount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.minWordShowCountIndex, rowIndex, (long) object.realmGet$minWordShowCount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.maxWordShowCountIndex, rowIndex, (long) object.realmGet$maxWordShowCount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.speedIndex, rowIndex, (long) object.realmGet$speed(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.minSpeedIndex, rowIndex, (long) object.realmGet$minSpeed(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.speedStepIndex, rowIndex, (long) object.realmGet$speedStep(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(SpeedReadingConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        SpeedReadingConfigColumnInfo columnInfo2 = (SpeedReadingConfigColumnInfo) realm.schema.getColumnInfo(SpeedReadingConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            SpeedReadingConfig object = (SpeedReadingConfig) objects.next();
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
                    Table.nativeSetLong(tableNativePtr, columnInfo2.trainingShowCountIndex, rowIndex, (long) object.realmGet$trainingShowCount(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.minWordShowCountIndex, rowIndex, (long) object.realmGet$minWordShowCount(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.maxWordShowCountIndex, rowIndex, (long) object.realmGet$maxWordShowCount(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.speedIndex, rowIndex, (long) object.realmGet$speed(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.minSpeedIndex, rowIndex, (long) object.realmGet$minSpeed(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.speedStepIndex, rowIndex, (long) object.realmGet$speedStep(), false);
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, SpeedReadingConfig object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(SpeedReadingConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        SpeedReadingConfigColumnInfo columnInfo2 = (SpeedReadingConfigColumnInfo) realm.schema.getColumnInfo(SpeedReadingConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = -1;
        if (Integer.valueOf(object.realmGet$id()) != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, (long) object.realmGet$id());
        }
        if (rowIndex == -1) {
            rowIndex = table.addEmptyRowWithPrimaryKey(Integer.valueOf(object.realmGet$id()), false);
        }
        cache.put(object, Long.valueOf(rowIndex));
        Table.nativeSetLong(tableNativePtr, columnInfo2.trainingShowCountIndex, rowIndex, (long) object.realmGet$trainingShowCount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.minWordShowCountIndex, rowIndex, (long) object.realmGet$minWordShowCount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.maxWordShowCountIndex, rowIndex, (long) object.realmGet$maxWordShowCount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.speedIndex, rowIndex, (long) object.realmGet$speed(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.minSpeedIndex, rowIndex, (long) object.realmGet$minSpeed(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.speedStepIndex, rowIndex, (long) object.realmGet$speedStep(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(SpeedReadingConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        SpeedReadingConfigColumnInfo columnInfo2 = (SpeedReadingConfigColumnInfo) realm.schema.getColumnInfo(SpeedReadingConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            SpeedReadingConfig object = (SpeedReadingConfig) objects.next();
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
                    Table.nativeSetLong(tableNativePtr, columnInfo2.trainingShowCountIndex, rowIndex, (long) object.realmGet$trainingShowCount(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.minWordShowCountIndex, rowIndex, (long) object.realmGet$minWordShowCount(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.maxWordShowCountIndex, rowIndex, (long) object.realmGet$maxWordShowCount(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.speedIndex, rowIndex, (long) object.realmGet$speed(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.minSpeedIndex, rowIndex, (long) object.realmGet$minSpeed(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.speedStepIndex, rowIndex, (long) object.realmGet$speedStep(), false);
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static SpeedReadingConfig createDetachedCopy(SpeedReadingConfig realmObject, int currentDepth, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        SpeedReadingConfig unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        RealmObjectProxy.CacheData<RealmModel> cachedObject = cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new SpeedReadingConfig();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.minDepth) {
            return (SpeedReadingConfig) cachedObject.object;
        } else {
            unmanagedObject = (SpeedReadingConfig) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        unmanagedObject.realmSet$id(realmObject.realmGet$id());
        unmanagedObject.realmSet$trainingShowCount(realmObject.realmGet$trainingShowCount());
        unmanagedObject.realmSet$minWordShowCount(realmObject.realmGet$minWordShowCount());
        unmanagedObject.realmSet$maxWordShowCount(realmObject.realmGet$maxWordShowCount());
        unmanagedObject.realmSet$speed(realmObject.realmGet$speed());
        unmanagedObject.realmSet$minSpeed(realmObject.realmGet$minSpeed());
        unmanagedObject.realmSet$speedStep(realmObject.realmGet$speedStep());
        return unmanagedObject;
    }

    static SpeedReadingConfig update(Realm realm, SpeedReadingConfig realmObject, SpeedReadingConfig newObject, Map<RealmModel, RealmObjectProxy> map) {
        realmObject.realmSet$trainingShowCount(newObject.realmGet$trainingShowCount());
        realmObject.realmSet$minWordShowCount(newObject.realmGet$minWordShowCount());
        realmObject.realmSet$maxWordShowCount(newObject.realmGet$maxWordShowCount());
        realmObject.realmSet$speed(newObject.realmGet$speed());
        realmObject.realmSet$minSpeed(newObject.realmGet$minSpeed());
        realmObject.realmSet$speedStep(newObject.realmGet$speedStep());
        return realmObject;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        return "SpeedReadingConfig = [" + "{id:" + realmGet$id() + "}" + "," + "{trainingShowCount:" + realmGet$trainingShowCount() + "}" + "," + "{minWordShowCount:" + realmGet$minWordShowCount() + "}" + "," + "{maxWordShowCount:" + realmGet$maxWordShowCount() + "}" + "," + "{speed:" + realmGet$speed() + "}" + "," + "{minSpeed:" + realmGet$minSpeed() + "}" + "," + "{speedStep:" + realmGet$speedStep() + "}" + "]";
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
        SpeedReadingConfigRealmProxy aSpeedReadingConfig = (SpeedReadingConfigRealmProxy) o;
        String path = this.proxyState.getRealm$realm().getPath();
        String otherPath = aSpeedReadingConfig.proxyState.getRealm$realm().getPath();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.proxyState.getRow$realm().getTable().getName();
        String otherTableName = aSpeedReadingConfig.proxyState.getRow$realm().getTable().getName();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != aSpeedReadingConfig.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
