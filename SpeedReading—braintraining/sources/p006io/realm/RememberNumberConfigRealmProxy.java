package p006io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.training.fragment.remembernumber.repository.entity.RememberNumberConfig;
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

/* renamed from: io.realm.RememberNumberConfigRealmProxy */
public class RememberNumberConfigRealmProxy extends RememberNumberConfig implements RealmObjectProxy, RememberNumberConfigRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private RememberNumberConfigColumnInfo columnInfo;
    private ProxyState<RememberNumberConfig> proxyState;

    /* renamed from: io.realm.RememberNumberConfigRealmProxy$RememberNumberConfigColumnInfo */
    static final class RememberNumberConfigColumnInfo extends ColumnInfo implements Cloneable {
        public long answersToComplexityDownIndex;
        public long answersToComplexityUpIndex;
        public long complexityIndex;
        public long idIndex;
        public long maxComplexityIndex;
        public long minComplexityIndex;
        public long trainingShowCountIndex;

        RememberNumberConfigColumnInfo(String path, Table table) {
            Map<String, Long> indicesMap = new HashMap<>(7);
            this.idIndex = getValidColumnIndex(path, table, "RememberNumberConfig", IdentityRealmObject.FIELD_ID);
            indicesMap.put(IdentityRealmObject.FIELD_ID, Long.valueOf(this.idIndex));
            this.trainingShowCountIndex = getValidColumnIndex(path, table, "RememberNumberConfig", "trainingShowCount");
            indicesMap.put("trainingShowCount", Long.valueOf(this.trainingShowCountIndex));
            this.minComplexityIndex = getValidColumnIndex(path, table, "RememberNumberConfig", RememberNumberConfig.FIELD_MIN_COMPLEXITY);
            indicesMap.put(RememberNumberConfig.FIELD_MIN_COMPLEXITY, Long.valueOf(this.minComplexityIndex));
            this.maxComplexityIndex = getValidColumnIndex(path, table, "RememberNumberConfig", RememberNumberConfig.FIELD_MAX_COMPLEXITY);
            indicesMap.put(RememberNumberConfig.FIELD_MAX_COMPLEXITY, Long.valueOf(this.maxComplexityIndex));
            this.complexityIndex = getValidColumnIndex(path, table, "RememberNumberConfig", "complexity");
            indicesMap.put("complexity", Long.valueOf(this.complexityIndex));
            this.answersToComplexityUpIndex = getValidColumnIndex(path, table, "RememberNumberConfig", RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_UP);
            indicesMap.put(RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_UP, Long.valueOf(this.answersToComplexityUpIndex));
            this.answersToComplexityDownIndex = getValidColumnIndex(path, table, "RememberNumberConfig", RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_DOWN);
            indicesMap.put(RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_DOWN, Long.valueOf(this.answersToComplexityDownIndex));
            setIndicesMap(indicesMap);
        }

        public final void copyColumnInfoFrom(ColumnInfo other) {
            RememberNumberConfigColumnInfo otherInfo = (RememberNumberConfigColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.trainingShowCountIndex = otherInfo.trainingShowCountIndex;
            this.minComplexityIndex = otherInfo.minComplexityIndex;
            this.maxComplexityIndex = otherInfo.maxComplexityIndex;
            this.complexityIndex = otherInfo.complexityIndex;
            this.answersToComplexityUpIndex = otherInfo.answersToComplexityUpIndex;
            this.answersToComplexityDownIndex = otherInfo.answersToComplexityDownIndex;
            setIndicesMap(otherInfo.getIndicesMap());
        }

        public final RememberNumberConfigColumnInfo clone() {
            return (RememberNumberConfigColumnInfo) super.clone();
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add(IdentityRealmObject.FIELD_ID);
        fieldNames.add("trainingShowCount");
        fieldNames.add(RememberNumberConfig.FIELD_MIN_COMPLEXITY);
        fieldNames.add(RememberNumberConfig.FIELD_MAX_COMPLEXITY);
        fieldNames.add("complexity");
        fieldNames.add(RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_UP);
        fieldNames.add(RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_DOWN);
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    RememberNumberConfigRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext context = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (RememberNumberConfigColumnInfo) context.getColumnInfo();
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

    public int realmGet$minComplexity() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.minComplexityIndex);
    }

    public void realmSet$minComplexity(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.minComplexityIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.minComplexityIndex, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$maxComplexity() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.maxComplexityIndex);
    }

    public void realmSet$maxComplexity(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.maxComplexityIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.maxComplexityIndex, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$complexity() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.complexityIndex);
    }

    public void realmSet$complexity(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.complexityIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.complexityIndex, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$answersToComplexityUp() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.answersToComplexityUpIndex);
    }

    public void realmSet$answersToComplexityUp(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.answersToComplexityUpIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.answersToComplexityUpIndex, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$answersToComplexityDown() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.answersToComplexityDownIndex);
    }

    public void realmSet$answersToComplexityDown(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.answersToComplexityDownIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.answersToComplexityDownIndex, row.getIndex(), (long) value, true);
        }
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (realmSchema.contains("RememberNumberConfig")) {
            return realmSchema.get("RememberNumberConfig");
        }
        RealmObjectSchema realmObjectSchema = realmSchema.create("RememberNumberConfig");
        realmObjectSchema.add(new Property(IdentityRealmObject.FIELD_ID, RealmFieldType.INTEGER, true, true, true));
        realmObjectSchema.add(new Property("trainingShowCount", RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(RememberNumberConfig.FIELD_MIN_COMPLEXITY, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(RememberNumberConfig.FIELD_MAX_COMPLEXITY, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property("complexity", RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_UP, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_DOWN, RealmFieldType.INTEGER, false, false, true));
        return realmObjectSchema;
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (sharedRealm.hasTable("class_RememberNumberConfig")) {
            return sharedRealm.getTable("class_RememberNumberConfig");
        }
        Table table = sharedRealm.getTable("class_RememberNumberConfig");
        table.addColumn(RealmFieldType.INTEGER, IdentityRealmObject.FIELD_ID, false);
        table.addColumn(RealmFieldType.INTEGER, "trainingShowCount", false);
        table.addColumn(RealmFieldType.INTEGER, RememberNumberConfig.FIELD_MIN_COMPLEXITY, false);
        table.addColumn(RealmFieldType.INTEGER, RememberNumberConfig.FIELD_MAX_COMPLEXITY, false);
        table.addColumn(RealmFieldType.INTEGER, "complexity", false);
        table.addColumn(RealmFieldType.INTEGER, RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_UP, false);
        table.addColumn(RealmFieldType.INTEGER, RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_DOWN, false);
        table.addSearchIndex(table.getColumnIndex(IdentityRealmObject.FIELD_ID));
        table.setPrimaryKey(IdentityRealmObject.FIELD_ID);
        return table;
    }

    public static RememberNumberConfigColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_RememberNumberConfig")) {
            Table table = sharedRealm.getTable("class_RememberNumberConfig");
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
            RememberNumberConfigColumnInfo columnInfo2 = new RememberNumberConfigColumnInfo(sharedRealm.getPath(), table);
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
            } else if (!columnTypes.containsKey(RememberNumberConfig.FIELD_MIN_COMPLEXITY)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'minComplexity' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(RememberNumberConfig.FIELD_MIN_COMPLEXITY) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'minComplexity' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.minComplexityIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'minComplexity' does support null values in the existing Realm file. Use corresponding boxed type for field 'minComplexity' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(RememberNumberConfig.FIELD_MAX_COMPLEXITY)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'maxComplexity' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(RememberNumberConfig.FIELD_MAX_COMPLEXITY) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'maxComplexity' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.maxComplexityIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'maxComplexity' does support null values in the existing Realm file. Use corresponding boxed type for field 'maxComplexity' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey("complexity")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'complexity' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get("complexity") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'complexity' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.complexityIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'complexity' does support null values in the existing Realm file. Use corresponding boxed type for field 'complexity' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_UP)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'answersToComplexityUp' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_UP) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'answersToComplexityUp' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.answersToComplexityUpIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'answersToComplexityUp' does support null values in the existing Realm file. Use corresponding boxed type for field 'answersToComplexityUp' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_DOWN)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'answersToComplexityDown' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_DOWN) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'answersToComplexityDown' in existing Realm file.");
            } else if (!table.isColumnNullable(columnInfo2.answersToComplexityDownIndex)) {
                return columnInfo2;
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'answersToComplexityDown' does support null values in the existing Realm file. Use corresponding boxed type for field 'answersToComplexityDown' or migrate using RealmObjectSchema.setNullable().");
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'RememberNumberConfig' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_RememberNumberConfig";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static RememberNumberConfig createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update) throws JSONException {
        List emptyList = Collections.emptyList();
        RememberNumberConfig obj = null;
        if (update) {
            Table table = realm.getTable(RememberNumberConfig.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = -1;
            if (!json.isNull(IdentityRealmObject.FIELD_ID)) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong(IdentityRealmObject.FIELD_ID));
            }
            if (rowIndex != -1) {
                BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(RememberNumberConfig.class), false, Collections.emptyList());
                    obj = new RememberNumberConfigRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (!json.has(IdentityRealmObject.FIELD_ID)) {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            } else if (json.isNull(IdentityRealmObject.FIELD_ID)) {
                obj = (RememberNumberConfigRealmProxy) realm.createObjectInternal(RememberNumberConfig.class, (Object) null, true, emptyList);
            } else {
                obj = (RememberNumberConfigRealmProxy) realm.createObjectInternal(RememberNumberConfig.class, Integer.valueOf(json.getInt(IdentityRealmObject.FIELD_ID)), true, emptyList);
            }
        }
        if (json.has("trainingShowCount")) {
            if (json.isNull("trainingShowCount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'trainingShowCount' to null.");
            }
            obj.realmSet$trainingShowCount(json.getInt("trainingShowCount"));
        }
        if (json.has(RememberNumberConfig.FIELD_MIN_COMPLEXITY)) {
            if (json.isNull(RememberNumberConfig.FIELD_MIN_COMPLEXITY)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'minComplexity' to null.");
            }
            obj.realmSet$minComplexity(json.getInt(RememberNumberConfig.FIELD_MIN_COMPLEXITY));
        }
        if (json.has(RememberNumberConfig.FIELD_MAX_COMPLEXITY)) {
            if (json.isNull(RememberNumberConfig.FIELD_MAX_COMPLEXITY)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'maxComplexity' to null.");
            }
            obj.realmSet$maxComplexity(json.getInt(RememberNumberConfig.FIELD_MAX_COMPLEXITY));
        }
        if (json.has("complexity")) {
            if (json.isNull("complexity")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'complexity' to null.");
            }
            obj.realmSet$complexity(json.getInt("complexity"));
        }
        if (json.has(RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_UP)) {
            if (json.isNull(RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_UP)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'answersToComplexityUp' to null.");
            }
            obj.realmSet$answersToComplexityUp(json.getInt(RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_UP));
        }
        if (json.has(RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_DOWN)) {
            if (json.isNull(RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_DOWN)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'answersToComplexityDown' to null.");
            }
            obj.realmSet$answersToComplexityDown(json.getInt(RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_DOWN));
        }
        return obj;
    }

    @TargetApi(11)
    public static RememberNumberConfig createUsingJsonStream(Realm realm, JsonReader reader) throws IOException {
        boolean jsonHasPrimaryKey = false;
        RememberNumberConfig obj = new RememberNumberConfig();
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
            } else if (name.equals(RememberNumberConfig.FIELD_MIN_COMPLEXITY)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'minComplexity' to null.");
                }
                obj.realmSet$minComplexity(reader.nextInt());
            } else if (name.equals(RememberNumberConfig.FIELD_MAX_COMPLEXITY)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'maxComplexity' to null.");
                }
                obj.realmSet$maxComplexity(reader.nextInt());
            } else if (name.equals("complexity")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'complexity' to null.");
                }
                obj.realmSet$complexity(reader.nextInt());
            } else if (name.equals(RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_UP)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'answersToComplexityUp' to null.");
                }
                obj.realmSet$answersToComplexityUp(reader.nextInt());
            } else if (!name.equals(RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_DOWN)) {
                reader.skipValue();
            } else if (reader.peek() == JsonToken.NULL) {
                reader.skipValue();
                throw new IllegalArgumentException("Trying to set non-nullable field 'answersToComplexityDown' to null.");
            } else {
                obj.realmSet$answersToComplexityDown(reader.nextInt());
            }
        }
        reader.endObject();
        if (jsonHasPrimaryKey) {
            return (RememberNumberConfig) realm.copyToRealm(obj);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
    }

    public static RememberNumberConfig copyOrUpdate(Realm realm, RememberNumberConfig object, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        } else {
            BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            RealmObjectProxy cachedRealmObject = cache.get(object);
            if (cachedRealmObject != null) {
                return (RememberNumberConfig) cachedRealmObject;
            }
            RememberNumberConfig realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(RememberNumberConfig.class);
                long rowIndex = table.findFirstLong(table.getPrimaryKey(), (long) object.realmGet$id());
                if (rowIndex != -1) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(RememberNumberConfig.class), false, Collections.emptyList());
                        RememberNumberConfig realmObject2 = new RememberNumberConfigRealmProxy();
                        try {
                            cache.put(object, (RealmObjectProxy) realmObject2);
                            objectContext.clear();
                            realmObject = realmObject2;
                        } catch (Throwable th) {
                            th = th;
                            RememberNumberConfig rememberNumberConfig = realmObject2;
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

    public static RememberNumberConfig copy(Realm realm, RememberNumberConfig newObject, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (RememberNumberConfig) cachedRealmObject;
        }
        RememberNumberConfig realmObject = (RememberNumberConfig) realm.createObjectInternal(RememberNumberConfig.class, Integer.valueOf(newObject.realmGet$id()), false, Collections.emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.realmSet$trainingShowCount(newObject.realmGet$trainingShowCount());
        realmObject.realmSet$minComplexity(newObject.realmGet$minComplexity());
        realmObject.realmSet$maxComplexity(newObject.realmGet$maxComplexity());
        realmObject.realmSet$complexity(newObject.realmGet$complexity());
        realmObject.realmSet$answersToComplexityUp(newObject.realmGet$answersToComplexityUp());
        realmObject.realmSet$answersToComplexityDown(newObject.realmGet$answersToComplexityDown());
        return realmObject;
    }

    public static long insert(Realm realm, RememberNumberConfig object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(RememberNumberConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        RememberNumberConfigColumnInfo columnInfo2 = (RememberNumberConfigColumnInfo) realm.schema.getColumnInfo(RememberNumberConfig.class);
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
        Table.nativeSetLong(tableNativePtr, columnInfo2.minComplexityIndex, rowIndex, (long) object.realmGet$minComplexity(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.maxComplexityIndex, rowIndex, (long) object.realmGet$maxComplexity(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.complexityIndex, rowIndex, (long) object.realmGet$complexity(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.answersToComplexityUpIndex, rowIndex, (long) object.realmGet$answersToComplexityUp(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.answersToComplexityDownIndex, rowIndex, (long) object.realmGet$answersToComplexityDown(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(RememberNumberConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        RememberNumberConfigColumnInfo columnInfo2 = (RememberNumberConfigColumnInfo) realm.schema.getColumnInfo(RememberNumberConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            RememberNumberConfig object = (RememberNumberConfig) objects.next();
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
                    Table.nativeSetLong(tableNativePtr, columnInfo2.minComplexityIndex, rowIndex, (long) object.realmGet$minComplexity(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.maxComplexityIndex, rowIndex, (long) object.realmGet$maxComplexity(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.complexityIndex, rowIndex, (long) object.realmGet$complexity(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.answersToComplexityUpIndex, rowIndex, (long) object.realmGet$answersToComplexityUp(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.answersToComplexityDownIndex, rowIndex, (long) object.realmGet$answersToComplexityDown(), false);
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, RememberNumberConfig object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(RememberNumberConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        RememberNumberConfigColumnInfo columnInfo2 = (RememberNumberConfigColumnInfo) realm.schema.getColumnInfo(RememberNumberConfig.class);
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
        Table.nativeSetLong(tableNativePtr, columnInfo2.minComplexityIndex, rowIndex, (long) object.realmGet$minComplexity(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.maxComplexityIndex, rowIndex, (long) object.realmGet$maxComplexity(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.complexityIndex, rowIndex, (long) object.realmGet$complexity(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.answersToComplexityUpIndex, rowIndex, (long) object.realmGet$answersToComplexityUp(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.answersToComplexityDownIndex, rowIndex, (long) object.realmGet$answersToComplexityDown(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(RememberNumberConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        RememberNumberConfigColumnInfo columnInfo2 = (RememberNumberConfigColumnInfo) realm.schema.getColumnInfo(RememberNumberConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            RememberNumberConfig object = (RememberNumberConfig) objects.next();
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
                    Table.nativeSetLong(tableNativePtr, columnInfo2.minComplexityIndex, rowIndex, (long) object.realmGet$minComplexity(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.maxComplexityIndex, rowIndex, (long) object.realmGet$maxComplexity(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.complexityIndex, rowIndex, (long) object.realmGet$complexity(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.answersToComplexityUpIndex, rowIndex, (long) object.realmGet$answersToComplexityUp(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.answersToComplexityDownIndex, rowIndex, (long) object.realmGet$answersToComplexityDown(), false);
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static RememberNumberConfig createDetachedCopy(RememberNumberConfig realmObject, int currentDepth, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        RememberNumberConfig unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        RealmObjectProxy.CacheData<RealmModel> cachedObject = cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new RememberNumberConfig();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.minDepth) {
            return (RememberNumberConfig) cachedObject.object;
        } else {
            unmanagedObject = (RememberNumberConfig) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        unmanagedObject.realmSet$id(realmObject.realmGet$id());
        unmanagedObject.realmSet$trainingShowCount(realmObject.realmGet$trainingShowCount());
        unmanagedObject.realmSet$minComplexity(realmObject.realmGet$minComplexity());
        unmanagedObject.realmSet$maxComplexity(realmObject.realmGet$maxComplexity());
        unmanagedObject.realmSet$complexity(realmObject.realmGet$complexity());
        unmanagedObject.realmSet$answersToComplexityUp(realmObject.realmGet$answersToComplexityUp());
        unmanagedObject.realmSet$answersToComplexityDown(realmObject.realmGet$answersToComplexityDown());
        return unmanagedObject;
    }

    static RememberNumberConfig update(Realm realm, RememberNumberConfig realmObject, RememberNumberConfig newObject, Map<RealmModel, RealmObjectProxy> map) {
        realmObject.realmSet$trainingShowCount(newObject.realmGet$trainingShowCount());
        realmObject.realmSet$minComplexity(newObject.realmGet$minComplexity());
        realmObject.realmSet$maxComplexity(newObject.realmGet$maxComplexity());
        realmObject.realmSet$complexity(newObject.realmGet$complexity());
        realmObject.realmSet$answersToComplexityUp(newObject.realmGet$answersToComplexityUp());
        realmObject.realmSet$answersToComplexityDown(newObject.realmGet$answersToComplexityDown());
        return realmObject;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        return "RememberNumberConfig = [" + "{id:" + realmGet$id() + "}" + "," + "{trainingShowCount:" + realmGet$trainingShowCount() + "}" + "," + "{minComplexity:" + realmGet$minComplexity() + "}" + "," + "{maxComplexity:" + realmGet$maxComplexity() + "}" + "," + "{complexity:" + realmGet$complexity() + "}" + "," + "{answersToComplexityUp:" + realmGet$answersToComplexityUp() + "}" + "," + "{answersToComplexityDown:" + realmGet$answersToComplexityDown() + "}" + "]";
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
        RememberNumberConfigRealmProxy aRememberNumberConfig = (RememberNumberConfigRealmProxy) o;
        String path = this.proxyState.getRealm$realm().getPath();
        String otherPath = aRememberNumberConfig.proxyState.getRealm$realm().getPath();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRememberNumberConfig.proxyState.getRow$realm().getTable().getName();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != aRememberNumberConfig.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
