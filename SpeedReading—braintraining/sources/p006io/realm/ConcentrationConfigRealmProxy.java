package p006io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.training.fragment.concentration.repository.entity.ConcentrationConfig;
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

/* renamed from: io.realm.ConcentrationConfigRealmProxy */
public class ConcentrationConfigRealmProxy extends ConcentrationConfig implements RealmObjectProxy, ConcentrationConfigRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private ConcentrationConfigColumnInfo columnInfo;
    private ProxyState<ConcentrationConfig> proxyState;

    /* renamed from: io.realm.ConcentrationConfigRealmProxy$ConcentrationConfigColumnInfo */
    static final class ConcentrationConfigColumnInfo extends ColumnInfo implements Cloneable {
        public long circlesCountCustomIndex;
        public long circlesCountIndex;
        public long circlesRadiusIndex;
        public long circlesSizeCustomIndex;
        public long circlesSpeedCustomIndex;
        public long circlesSpeedIndex;
        public long complexityIndex;
        public long grayTimeIndex;
        public long idIndex;

        ConcentrationConfigColumnInfo(String path, Table table) {
            Map<String, Long> indicesMap = new HashMap<>(9);
            this.idIndex = getValidColumnIndex(path, table, "ConcentrationConfig", IdentityRealmObject.FIELD_ID);
            indicesMap.put(IdentityRealmObject.FIELD_ID, Long.valueOf(this.idIndex));
            this.grayTimeIndex = getValidColumnIndex(path, table, "ConcentrationConfig", ConcentrationConfig.FIELD_GRAY_TIME);
            indicesMap.put(ConcentrationConfig.FIELD_GRAY_TIME, Long.valueOf(this.grayTimeIndex));
            this.complexityIndex = getValidColumnIndex(path, table, "ConcentrationConfig", "complexity");
            indicesMap.put("complexity", Long.valueOf(this.complexityIndex));
            this.circlesCountIndex = getValidColumnIndex(path, table, "ConcentrationConfig", ConcentrationConfig.FIELD_CIRCLES_COUNT);
            indicesMap.put(ConcentrationConfig.FIELD_CIRCLES_COUNT, Long.valueOf(this.circlesCountIndex));
            this.circlesRadiusIndex = getValidColumnIndex(path, table, "ConcentrationConfig", ConcentrationConfig.FIELD_CIRCLES_RADIUS);
            indicesMap.put(ConcentrationConfig.FIELD_CIRCLES_RADIUS, Long.valueOf(this.circlesRadiusIndex));
            this.circlesSpeedIndex = getValidColumnIndex(path, table, "ConcentrationConfig", ConcentrationConfig.FIELD_CIRCLES_SPEED);
            indicesMap.put(ConcentrationConfig.FIELD_CIRCLES_SPEED, Long.valueOf(this.circlesSpeedIndex));
            this.circlesSpeedCustomIndex = getValidColumnIndex(path, table, "ConcentrationConfig", "circlesSpeedCustom");
            indicesMap.put("circlesSpeedCustom", Long.valueOf(this.circlesSpeedCustomIndex));
            this.circlesSizeCustomIndex = getValidColumnIndex(path, table, "ConcentrationConfig", "circlesSizeCustom");
            indicesMap.put("circlesSizeCustom", Long.valueOf(this.circlesSizeCustomIndex));
            this.circlesCountCustomIndex = getValidColumnIndex(path, table, "ConcentrationConfig", "circlesCountCustom");
            indicesMap.put("circlesCountCustom", Long.valueOf(this.circlesCountCustomIndex));
            setIndicesMap(indicesMap);
        }

        public final void copyColumnInfoFrom(ColumnInfo other) {
            ConcentrationConfigColumnInfo otherInfo = (ConcentrationConfigColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.grayTimeIndex = otherInfo.grayTimeIndex;
            this.complexityIndex = otherInfo.complexityIndex;
            this.circlesCountIndex = otherInfo.circlesCountIndex;
            this.circlesRadiusIndex = otherInfo.circlesRadiusIndex;
            this.circlesSpeedIndex = otherInfo.circlesSpeedIndex;
            this.circlesSpeedCustomIndex = otherInfo.circlesSpeedCustomIndex;
            this.circlesSizeCustomIndex = otherInfo.circlesSizeCustomIndex;
            this.circlesCountCustomIndex = otherInfo.circlesCountCustomIndex;
            setIndicesMap(otherInfo.getIndicesMap());
        }

        public final ConcentrationConfigColumnInfo clone() {
            return (ConcentrationConfigColumnInfo) super.clone();
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add(IdentityRealmObject.FIELD_ID);
        fieldNames.add(ConcentrationConfig.FIELD_GRAY_TIME);
        fieldNames.add("complexity");
        fieldNames.add(ConcentrationConfig.FIELD_CIRCLES_COUNT);
        fieldNames.add(ConcentrationConfig.FIELD_CIRCLES_RADIUS);
        fieldNames.add(ConcentrationConfig.FIELD_CIRCLES_SPEED);
        fieldNames.add("circlesSpeedCustom");
        fieldNames.add("circlesSizeCustom");
        fieldNames.add("circlesCountCustom");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ConcentrationConfigRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext context = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (ConcentrationConfigColumnInfo) context.getColumnInfo();
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

    public int realmGet$grayTime() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.grayTimeIndex);
    }

    public void realmSet$grayTime(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.grayTimeIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.grayTimeIndex, row.getIndex(), (long) value, true);
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

    public int realmGet$circlesCount() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.circlesCountIndex);
    }

    public void realmSet$circlesCount(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.circlesCountIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.circlesCountIndex, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$circlesRadius() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.circlesRadiusIndex);
    }

    public void realmSet$circlesRadius(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.circlesRadiusIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.circlesRadiusIndex, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$circlesSpeed() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.circlesSpeedIndex);
    }

    public void realmSet$circlesSpeed(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.circlesSpeedIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.circlesSpeedIndex, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$circlesSpeedCustom() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.circlesSpeedCustomIndex);
    }

    public void realmSet$circlesSpeedCustom(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.circlesSpeedCustomIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.circlesSpeedCustomIndex, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$circlesSizeCustom() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.circlesSizeCustomIndex);
    }

    public void realmSet$circlesSizeCustom(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.circlesSizeCustomIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.circlesSizeCustomIndex, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$circlesCountCustom() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.circlesCountCustomIndex);
    }

    public void realmSet$circlesCountCustom(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.circlesCountCustomIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.circlesCountCustomIndex, row.getIndex(), (long) value, true);
        }
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (realmSchema.contains("ConcentrationConfig")) {
            return realmSchema.get("ConcentrationConfig");
        }
        RealmObjectSchema realmObjectSchema = realmSchema.create("ConcentrationConfig");
        realmObjectSchema.add(new Property(IdentityRealmObject.FIELD_ID, RealmFieldType.INTEGER, true, true, true));
        realmObjectSchema.add(new Property(ConcentrationConfig.FIELD_GRAY_TIME, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property("complexity", RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(ConcentrationConfig.FIELD_CIRCLES_COUNT, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(ConcentrationConfig.FIELD_CIRCLES_RADIUS, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(ConcentrationConfig.FIELD_CIRCLES_SPEED, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property("circlesSpeedCustom", RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property("circlesSizeCustom", RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property("circlesCountCustom", RealmFieldType.INTEGER, false, false, true));
        return realmObjectSchema;
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (sharedRealm.hasTable("class_ConcentrationConfig")) {
            return sharedRealm.getTable("class_ConcentrationConfig");
        }
        Table table = sharedRealm.getTable("class_ConcentrationConfig");
        table.addColumn(RealmFieldType.INTEGER, IdentityRealmObject.FIELD_ID, false);
        table.addColumn(RealmFieldType.INTEGER, ConcentrationConfig.FIELD_GRAY_TIME, false);
        table.addColumn(RealmFieldType.INTEGER, "complexity", false);
        table.addColumn(RealmFieldType.INTEGER, ConcentrationConfig.FIELD_CIRCLES_COUNT, false);
        table.addColumn(RealmFieldType.INTEGER, ConcentrationConfig.FIELD_CIRCLES_RADIUS, false);
        table.addColumn(RealmFieldType.INTEGER, ConcentrationConfig.FIELD_CIRCLES_SPEED, false);
        table.addColumn(RealmFieldType.INTEGER, "circlesSpeedCustom", false);
        table.addColumn(RealmFieldType.INTEGER, "circlesSizeCustom", false);
        table.addColumn(RealmFieldType.INTEGER, "circlesCountCustom", false);
        table.addSearchIndex(table.getColumnIndex(IdentityRealmObject.FIELD_ID));
        table.setPrimaryKey(IdentityRealmObject.FIELD_ID);
        return table;
    }

    public static ConcentrationConfigColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_ConcentrationConfig")) {
            Table table = sharedRealm.getTable("class_ConcentrationConfig");
            long columnCount = table.getColumnCount();
            if (columnCount != 9) {
                if (columnCount < 9) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 9 but was " + columnCount);
                } else if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 9 but was %1$d", Long.valueOf(columnCount));
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 9 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            ConcentrationConfigColumnInfo columnInfo2 = new ConcentrationConfigColumnInfo(sharedRealm.getPath(), table);
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
            } else if (!columnTypes.containsKey(ConcentrationConfig.FIELD_GRAY_TIME)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'grayTime' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(ConcentrationConfig.FIELD_GRAY_TIME) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'grayTime' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.grayTimeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'grayTime' does support null values in the existing Realm file. Use corresponding boxed type for field 'grayTime' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey("complexity")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'complexity' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get("complexity") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'complexity' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.complexityIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'complexity' does support null values in the existing Realm file. Use corresponding boxed type for field 'complexity' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(ConcentrationConfig.FIELD_CIRCLES_COUNT)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'circlesCount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(ConcentrationConfig.FIELD_CIRCLES_COUNT) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'circlesCount' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.circlesCountIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'circlesCount' does support null values in the existing Realm file. Use corresponding boxed type for field 'circlesCount' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(ConcentrationConfig.FIELD_CIRCLES_RADIUS)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'circlesRadius' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(ConcentrationConfig.FIELD_CIRCLES_RADIUS) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'circlesRadius' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.circlesRadiusIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'circlesRadius' does support null values in the existing Realm file. Use corresponding boxed type for field 'circlesRadius' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(ConcentrationConfig.FIELD_CIRCLES_SPEED)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'circlesSpeed' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(ConcentrationConfig.FIELD_CIRCLES_SPEED) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'circlesSpeed' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.circlesSpeedIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'circlesSpeed' does support null values in the existing Realm file. Use corresponding boxed type for field 'circlesSpeed' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey("circlesSpeedCustom")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'circlesSpeedCustom' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get("circlesSpeedCustom") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'circlesSpeedCustom' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.circlesSpeedCustomIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'circlesSpeedCustom' does support null values in the existing Realm file. Use corresponding boxed type for field 'circlesSpeedCustom' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey("circlesSizeCustom")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'circlesSizeCustom' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get("circlesSizeCustom") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'circlesSizeCustom' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.circlesSizeCustomIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'circlesSizeCustom' does support null values in the existing Realm file. Use corresponding boxed type for field 'circlesSizeCustom' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey("circlesCountCustom")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'circlesCountCustom' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get("circlesCountCustom") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'circlesCountCustom' in existing Realm file.");
            } else if (!table.isColumnNullable(columnInfo2.circlesCountCustomIndex)) {
                return columnInfo2;
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'circlesCountCustom' does support null values in the existing Realm file. Use corresponding boxed type for field 'circlesCountCustom' or migrate using RealmObjectSchema.setNullable().");
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'ConcentrationConfig' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_ConcentrationConfig";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static ConcentrationConfig createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update) throws JSONException {
        List emptyList = Collections.emptyList();
        ConcentrationConfig obj = null;
        if (update) {
            Table table = realm.getTable(ConcentrationConfig.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = -1;
            if (!json.isNull(IdentityRealmObject.FIELD_ID)) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong(IdentityRealmObject.FIELD_ID));
            }
            if (rowIndex != -1) {
                BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(ConcentrationConfig.class), false, Collections.emptyList());
                    obj = new ConcentrationConfigRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (!json.has(IdentityRealmObject.FIELD_ID)) {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            } else if (json.isNull(IdentityRealmObject.FIELD_ID)) {
                obj = (ConcentrationConfigRealmProxy) realm.createObjectInternal(ConcentrationConfig.class, (Object) null, true, emptyList);
            } else {
                obj = (ConcentrationConfigRealmProxy) realm.createObjectInternal(ConcentrationConfig.class, Integer.valueOf(json.getInt(IdentityRealmObject.FIELD_ID)), true, emptyList);
            }
        }
        if (json.has(ConcentrationConfig.FIELD_GRAY_TIME)) {
            if (json.isNull(ConcentrationConfig.FIELD_GRAY_TIME)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'grayTime' to null.");
            }
            obj.realmSet$grayTime(json.getInt(ConcentrationConfig.FIELD_GRAY_TIME));
        }
        if (json.has("complexity")) {
            if (json.isNull("complexity")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'complexity' to null.");
            }
            obj.realmSet$complexity(json.getInt("complexity"));
        }
        if (json.has(ConcentrationConfig.FIELD_CIRCLES_COUNT)) {
            if (json.isNull(ConcentrationConfig.FIELD_CIRCLES_COUNT)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'circlesCount' to null.");
            }
            obj.realmSet$circlesCount(json.getInt(ConcentrationConfig.FIELD_CIRCLES_COUNT));
        }
        if (json.has(ConcentrationConfig.FIELD_CIRCLES_RADIUS)) {
            if (json.isNull(ConcentrationConfig.FIELD_CIRCLES_RADIUS)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'circlesRadius' to null.");
            }
            obj.realmSet$circlesRadius(json.getInt(ConcentrationConfig.FIELD_CIRCLES_RADIUS));
        }
        if (json.has(ConcentrationConfig.FIELD_CIRCLES_SPEED)) {
            if (json.isNull(ConcentrationConfig.FIELD_CIRCLES_SPEED)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'circlesSpeed' to null.");
            }
            obj.realmSet$circlesSpeed(json.getInt(ConcentrationConfig.FIELD_CIRCLES_SPEED));
        }
        if (json.has("circlesSpeedCustom")) {
            if (json.isNull("circlesSpeedCustom")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'circlesSpeedCustom' to null.");
            }
            obj.realmSet$circlesSpeedCustom(json.getInt("circlesSpeedCustom"));
        }
        if (json.has("circlesSizeCustom")) {
            if (json.isNull("circlesSizeCustom")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'circlesSizeCustom' to null.");
            }
            obj.realmSet$circlesSizeCustom(json.getInt("circlesSizeCustom"));
        }
        if (json.has("circlesCountCustom")) {
            if (json.isNull("circlesCountCustom")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'circlesCountCustom' to null.");
            }
            obj.realmSet$circlesCountCustom(json.getInt("circlesCountCustom"));
        }
        return obj;
    }

    @TargetApi(11)
    public static ConcentrationConfig createUsingJsonStream(Realm realm, JsonReader reader) throws IOException {
        boolean jsonHasPrimaryKey = false;
        ConcentrationConfig obj = new ConcentrationConfig();
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
            } else if (name.equals(ConcentrationConfig.FIELD_GRAY_TIME)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'grayTime' to null.");
                }
                obj.realmSet$grayTime(reader.nextInt());
            } else if (name.equals("complexity")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'complexity' to null.");
                }
                obj.realmSet$complexity(reader.nextInt());
            } else if (name.equals(ConcentrationConfig.FIELD_CIRCLES_COUNT)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'circlesCount' to null.");
                }
                obj.realmSet$circlesCount(reader.nextInt());
            } else if (name.equals(ConcentrationConfig.FIELD_CIRCLES_RADIUS)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'circlesRadius' to null.");
                }
                obj.realmSet$circlesRadius(reader.nextInt());
            } else if (name.equals(ConcentrationConfig.FIELD_CIRCLES_SPEED)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'circlesSpeed' to null.");
                }
                obj.realmSet$circlesSpeed(reader.nextInt());
            } else if (name.equals("circlesSpeedCustom")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'circlesSpeedCustom' to null.");
                }
                obj.realmSet$circlesSpeedCustom(reader.nextInt());
            } else if (name.equals("circlesSizeCustom")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'circlesSizeCustom' to null.");
                }
                obj.realmSet$circlesSizeCustom(reader.nextInt());
            } else if (!name.equals("circlesCountCustom")) {
                reader.skipValue();
            } else if (reader.peek() == JsonToken.NULL) {
                reader.skipValue();
                throw new IllegalArgumentException("Trying to set non-nullable field 'circlesCountCustom' to null.");
            } else {
                obj.realmSet$circlesCountCustom(reader.nextInt());
            }
        }
        reader.endObject();
        if (jsonHasPrimaryKey) {
            return (ConcentrationConfig) realm.copyToRealm(obj);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
    }

    public static ConcentrationConfig copyOrUpdate(Realm realm, ConcentrationConfig object, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        } else {
            BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            RealmObjectProxy cachedRealmObject = cache.get(object);
            if (cachedRealmObject != null) {
                return (ConcentrationConfig) cachedRealmObject;
            }
            ConcentrationConfig realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(ConcentrationConfig.class);
                long rowIndex = table.findFirstLong(table.getPrimaryKey(), (long) object.realmGet$id());
                if (rowIndex != -1) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(ConcentrationConfig.class), false, Collections.emptyList());
                        ConcentrationConfig realmObject2 = new ConcentrationConfigRealmProxy();
                        try {
                            cache.put(object, (RealmObjectProxy) realmObject2);
                            objectContext.clear();
                            realmObject = realmObject2;
                        } catch (Throwable th) {
                            th = th;
                            ConcentrationConfig concentrationConfig = realmObject2;
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

    public static ConcentrationConfig copy(Realm realm, ConcentrationConfig newObject, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (ConcentrationConfig) cachedRealmObject;
        }
        ConcentrationConfig realmObject = (ConcentrationConfig) realm.createObjectInternal(ConcentrationConfig.class, Integer.valueOf(newObject.realmGet$id()), false, Collections.emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.realmSet$grayTime(newObject.realmGet$grayTime());
        realmObject.realmSet$complexity(newObject.realmGet$complexity());
        realmObject.realmSet$circlesCount(newObject.realmGet$circlesCount());
        realmObject.realmSet$circlesRadius(newObject.realmGet$circlesRadius());
        realmObject.realmSet$circlesSpeed(newObject.realmGet$circlesSpeed());
        realmObject.realmSet$circlesSpeedCustom(newObject.realmGet$circlesSpeedCustom());
        realmObject.realmSet$circlesSizeCustom(newObject.realmGet$circlesSizeCustom());
        realmObject.realmSet$circlesCountCustom(newObject.realmGet$circlesCountCustom());
        return realmObject;
    }

    public static long insert(Realm realm, ConcentrationConfig object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(ConcentrationConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        ConcentrationConfigColumnInfo columnInfo2 = (ConcentrationConfigColumnInfo) realm.schema.getColumnInfo(ConcentrationConfig.class);
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
        Table.nativeSetLong(tableNativePtr, columnInfo2.grayTimeIndex, rowIndex, (long) object.realmGet$grayTime(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.complexityIndex, rowIndex, (long) object.realmGet$complexity(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.circlesCountIndex, rowIndex, (long) object.realmGet$circlesCount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.circlesRadiusIndex, rowIndex, (long) object.realmGet$circlesRadius(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.circlesSpeedIndex, rowIndex, (long) object.realmGet$circlesSpeed(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.circlesSpeedCustomIndex, rowIndex, (long) object.realmGet$circlesSpeedCustom(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.circlesSizeCustomIndex, rowIndex, (long) object.realmGet$circlesSizeCustom(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.circlesCountCustomIndex, rowIndex, (long) object.realmGet$circlesCountCustom(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(ConcentrationConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        ConcentrationConfigColumnInfo columnInfo2 = (ConcentrationConfigColumnInfo) realm.schema.getColumnInfo(ConcentrationConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            ConcentrationConfig object = (ConcentrationConfig) objects.next();
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
                    Table.nativeSetLong(tableNativePtr, columnInfo2.grayTimeIndex, rowIndex, (long) object.realmGet$grayTime(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.complexityIndex, rowIndex, (long) object.realmGet$complexity(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.circlesCountIndex, rowIndex, (long) object.realmGet$circlesCount(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.circlesRadiusIndex, rowIndex, (long) object.realmGet$circlesRadius(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.circlesSpeedIndex, rowIndex, (long) object.realmGet$circlesSpeed(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.circlesSpeedCustomIndex, rowIndex, (long) object.realmGet$circlesSpeedCustom(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.circlesSizeCustomIndex, rowIndex, (long) object.realmGet$circlesSizeCustom(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.circlesCountCustomIndex, rowIndex, (long) object.realmGet$circlesCountCustom(), false);
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, ConcentrationConfig object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(ConcentrationConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        ConcentrationConfigColumnInfo columnInfo2 = (ConcentrationConfigColumnInfo) realm.schema.getColumnInfo(ConcentrationConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = -1;
        if (Integer.valueOf(object.realmGet$id()) != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, (long) object.realmGet$id());
        }
        if (rowIndex == -1) {
            rowIndex = table.addEmptyRowWithPrimaryKey(Integer.valueOf(object.realmGet$id()), false);
        }
        cache.put(object, Long.valueOf(rowIndex));
        Table.nativeSetLong(tableNativePtr, columnInfo2.grayTimeIndex, rowIndex, (long) object.realmGet$grayTime(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.complexityIndex, rowIndex, (long) object.realmGet$complexity(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.circlesCountIndex, rowIndex, (long) object.realmGet$circlesCount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.circlesRadiusIndex, rowIndex, (long) object.realmGet$circlesRadius(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.circlesSpeedIndex, rowIndex, (long) object.realmGet$circlesSpeed(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.circlesSpeedCustomIndex, rowIndex, (long) object.realmGet$circlesSpeedCustom(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.circlesSizeCustomIndex, rowIndex, (long) object.realmGet$circlesSizeCustom(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.circlesCountCustomIndex, rowIndex, (long) object.realmGet$circlesCountCustom(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(ConcentrationConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        ConcentrationConfigColumnInfo columnInfo2 = (ConcentrationConfigColumnInfo) realm.schema.getColumnInfo(ConcentrationConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            ConcentrationConfig object = (ConcentrationConfig) objects.next();
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
                    Table.nativeSetLong(tableNativePtr, columnInfo2.grayTimeIndex, rowIndex, (long) object.realmGet$grayTime(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.complexityIndex, rowIndex, (long) object.realmGet$complexity(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.circlesCountIndex, rowIndex, (long) object.realmGet$circlesCount(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.circlesRadiusIndex, rowIndex, (long) object.realmGet$circlesRadius(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.circlesSpeedIndex, rowIndex, (long) object.realmGet$circlesSpeed(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.circlesSpeedCustomIndex, rowIndex, (long) object.realmGet$circlesSpeedCustom(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.circlesSizeCustomIndex, rowIndex, (long) object.realmGet$circlesSizeCustom(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.circlesCountCustomIndex, rowIndex, (long) object.realmGet$circlesCountCustom(), false);
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static ConcentrationConfig createDetachedCopy(ConcentrationConfig realmObject, int currentDepth, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        ConcentrationConfig unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        RealmObjectProxy.CacheData<RealmModel> cachedObject = cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new ConcentrationConfig();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.minDepth) {
            return (ConcentrationConfig) cachedObject.object;
        } else {
            unmanagedObject = (ConcentrationConfig) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        unmanagedObject.realmSet$id(realmObject.realmGet$id());
        unmanagedObject.realmSet$grayTime(realmObject.realmGet$grayTime());
        unmanagedObject.realmSet$complexity(realmObject.realmGet$complexity());
        unmanagedObject.realmSet$circlesCount(realmObject.realmGet$circlesCount());
        unmanagedObject.realmSet$circlesRadius(realmObject.realmGet$circlesRadius());
        unmanagedObject.realmSet$circlesSpeed(realmObject.realmGet$circlesSpeed());
        unmanagedObject.realmSet$circlesSpeedCustom(realmObject.realmGet$circlesSpeedCustom());
        unmanagedObject.realmSet$circlesSizeCustom(realmObject.realmGet$circlesSizeCustom());
        unmanagedObject.realmSet$circlesCountCustom(realmObject.realmGet$circlesCountCustom());
        return unmanagedObject;
    }

    static ConcentrationConfig update(Realm realm, ConcentrationConfig realmObject, ConcentrationConfig newObject, Map<RealmModel, RealmObjectProxy> map) {
        realmObject.realmSet$grayTime(newObject.realmGet$grayTime());
        realmObject.realmSet$complexity(newObject.realmGet$complexity());
        realmObject.realmSet$circlesCount(newObject.realmGet$circlesCount());
        realmObject.realmSet$circlesRadius(newObject.realmGet$circlesRadius());
        realmObject.realmSet$circlesSpeed(newObject.realmGet$circlesSpeed());
        realmObject.realmSet$circlesSpeedCustom(newObject.realmGet$circlesSpeedCustom());
        realmObject.realmSet$circlesSizeCustom(newObject.realmGet$circlesSizeCustom());
        realmObject.realmSet$circlesCountCustom(newObject.realmGet$circlesCountCustom());
        return realmObject;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        return "ConcentrationConfig = [" + "{id:" + realmGet$id() + "}" + "," + "{grayTime:" + realmGet$grayTime() + "}" + "," + "{complexity:" + realmGet$complexity() + "}" + "," + "{circlesCount:" + realmGet$circlesCount() + "}" + "," + "{circlesRadius:" + realmGet$circlesRadius() + "}" + "," + "{circlesSpeed:" + realmGet$circlesSpeed() + "}" + "," + "{circlesSpeedCustom:" + realmGet$circlesSpeedCustom() + "}" + "," + "{circlesSizeCustom:" + realmGet$circlesSizeCustom() + "}" + "," + "{circlesCountCustom:" + realmGet$circlesCountCustom() + "}" + "]";
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
        ConcentrationConfigRealmProxy aConcentrationConfig = (ConcentrationConfigRealmProxy) o;
        String path = this.proxyState.getRealm$realm().getPath();
        String otherPath = aConcentrationConfig.proxyState.getRealm$realm().getPath();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.proxyState.getRow$realm().getTable().getName();
        String otherTableName = aConcentrationConfig.proxyState.getRow$realm().getTable().getName();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != aConcentrationConfig.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
