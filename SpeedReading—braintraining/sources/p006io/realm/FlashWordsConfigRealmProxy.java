package p006io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.training.fragment.flashword.repository.entity.FlashWordsConfig;
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

/* renamed from: io.realm.FlashWordsConfigRealmProxy */
public class FlashWordsConfigRealmProxy extends FlashWordsConfig implements RealmObjectProxy, FlashWordsConfigRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private FlashWordsConfigColumnInfo columnInfo;
    private ProxyState<FlashWordsConfig> proxyState;

    /* renamed from: io.realm.FlashWordsConfigRealmProxy$FlashWordsConfigColumnInfo */
    static final class FlashWordsConfigColumnInfo extends ColumnInfo implements Cloneable {
        public long boarTypeIndex;
        public long idIndex;
        public long speedIndex;
        public long trainingDurationIndex;

        FlashWordsConfigColumnInfo(String path, Table table) {
            Map<String, Long> indicesMap = new HashMap<>(4);
            this.idIndex = getValidColumnIndex(path, table, "FlashWordsConfig", IdentityRealmObject.FIELD_ID);
            indicesMap.put(IdentityRealmObject.FIELD_ID, Long.valueOf(this.idIndex));
            this.speedIndex = getValidColumnIndex(path, table, "FlashWordsConfig", SpeedReadingConfig.FIELD_SPEED);
            indicesMap.put(SpeedReadingConfig.FIELD_SPEED, Long.valueOf(this.speedIndex));
            this.boarTypeIndex = getValidColumnIndex(path, table, "FlashWordsConfig", FlashWordsConfig.FIELD_BOARD_TYPE);
            indicesMap.put(FlashWordsConfig.FIELD_BOARD_TYPE, Long.valueOf(this.boarTypeIndex));
            this.trainingDurationIndex = getValidColumnIndex(path, table, "FlashWordsConfig", "trainingDuration");
            indicesMap.put("trainingDuration", Long.valueOf(this.trainingDurationIndex));
            setIndicesMap(indicesMap);
        }

        public final void copyColumnInfoFrom(ColumnInfo other) {
            FlashWordsConfigColumnInfo otherInfo = (FlashWordsConfigColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.speedIndex = otherInfo.speedIndex;
            this.boarTypeIndex = otherInfo.boarTypeIndex;
            this.trainingDurationIndex = otherInfo.trainingDurationIndex;
            setIndicesMap(otherInfo.getIndicesMap());
        }

        public final FlashWordsConfigColumnInfo clone() {
            return (FlashWordsConfigColumnInfo) super.clone();
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add(IdentityRealmObject.FIELD_ID);
        fieldNames.add(SpeedReadingConfig.FIELD_SPEED);
        fieldNames.add(FlashWordsConfig.FIELD_BOARD_TYPE);
        fieldNames.add("trainingDuration");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    FlashWordsConfigRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext context = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (FlashWordsConfigColumnInfo) context.getColumnInfo();
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

    public int realmGet$boarType() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.boarTypeIndex);
    }

    public void realmSet$boarType(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.boarTypeIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.boarTypeIndex, row.getIndex(), (long) value, true);
        }
    }

    public long realmGet$trainingDuration() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getLong(this.columnInfo.trainingDurationIndex);
    }

    public void realmSet$trainingDuration(long value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.trainingDurationIndex, value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.trainingDurationIndex, row.getIndex(), value, true);
        }
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (realmSchema.contains("FlashWordsConfig")) {
            return realmSchema.get("FlashWordsConfig");
        }
        RealmObjectSchema realmObjectSchema = realmSchema.create("FlashWordsConfig");
        realmObjectSchema.add(new Property(IdentityRealmObject.FIELD_ID, RealmFieldType.INTEGER, true, true, true));
        realmObjectSchema.add(new Property(SpeedReadingConfig.FIELD_SPEED, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(FlashWordsConfig.FIELD_BOARD_TYPE, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property("trainingDuration", RealmFieldType.INTEGER, false, false, true));
        return realmObjectSchema;
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (sharedRealm.hasTable("class_FlashWordsConfig")) {
            return sharedRealm.getTable("class_FlashWordsConfig");
        }
        Table table = sharedRealm.getTable("class_FlashWordsConfig");
        table.addColumn(RealmFieldType.INTEGER, IdentityRealmObject.FIELD_ID, false);
        table.addColumn(RealmFieldType.INTEGER, SpeedReadingConfig.FIELD_SPEED, false);
        table.addColumn(RealmFieldType.INTEGER, FlashWordsConfig.FIELD_BOARD_TYPE, false);
        table.addColumn(RealmFieldType.INTEGER, "trainingDuration", false);
        table.addSearchIndex(table.getColumnIndex(IdentityRealmObject.FIELD_ID));
        table.setPrimaryKey(IdentityRealmObject.FIELD_ID);
        return table;
    }

    public static FlashWordsConfigColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_FlashWordsConfig")) {
            Table table = sharedRealm.getTable("class_FlashWordsConfig");
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
            FlashWordsConfigColumnInfo columnInfo2 = new FlashWordsConfigColumnInfo(sharedRealm.getPath(), table);
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
            } else if (!columnTypes.containsKey(SpeedReadingConfig.FIELD_SPEED)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'speed' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(SpeedReadingConfig.FIELD_SPEED) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'speed' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.speedIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'speed' does support null values in the existing Realm file. Use corresponding boxed type for field 'speed' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(FlashWordsConfig.FIELD_BOARD_TYPE)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'boarType' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(FlashWordsConfig.FIELD_BOARD_TYPE) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'boarType' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.boarTypeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'boarType' does support null values in the existing Realm file. Use corresponding boxed type for field 'boarType' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey("trainingDuration")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'trainingDuration' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get("trainingDuration") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'long' for field 'trainingDuration' in existing Realm file.");
            } else if (!table.isColumnNullable(columnInfo2.trainingDurationIndex)) {
                return columnInfo2;
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'trainingDuration' does support null values in the existing Realm file. Use corresponding boxed type for field 'trainingDuration' or migrate using RealmObjectSchema.setNullable().");
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'FlashWordsConfig' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_FlashWordsConfig";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static FlashWordsConfig createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update) throws JSONException {
        List emptyList = Collections.emptyList();
        FlashWordsConfig obj = null;
        if (update) {
            Table table = realm.getTable(FlashWordsConfig.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = -1;
            if (!json.isNull(IdentityRealmObject.FIELD_ID)) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong(IdentityRealmObject.FIELD_ID));
            }
            if (rowIndex != -1) {
                BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(FlashWordsConfig.class), false, Collections.emptyList());
                    obj = new FlashWordsConfigRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (!json.has(IdentityRealmObject.FIELD_ID)) {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            } else if (json.isNull(IdentityRealmObject.FIELD_ID)) {
                obj = (FlashWordsConfigRealmProxy) realm.createObjectInternal(FlashWordsConfig.class, (Object) null, true, emptyList);
            } else {
                obj = (FlashWordsConfigRealmProxy) realm.createObjectInternal(FlashWordsConfig.class, Integer.valueOf(json.getInt(IdentityRealmObject.FIELD_ID)), true, emptyList);
            }
        }
        if (json.has(SpeedReadingConfig.FIELD_SPEED)) {
            if (json.isNull(SpeedReadingConfig.FIELD_SPEED)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'speed' to null.");
            }
            obj.realmSet$speed(json.getInt(SpeedReadingConfig.FIELD_SPEED));
        }
        if (json.has(FlashWordsConfig.FIELD_BOARD_TYPE)) {
            if (json.isNull(FlashWordsConfig.FIELD_BOARD_TYPE)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'boarType' to null.");
            }
            obj.realmSet$boarType(json.getInt(FlashWordsConfig.FIELD_BOARD_TYPE));
        }
        if (json.has("trainingDuration")) {
            if (json.isNull("trainingDuration")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'trainingDuration' to null.");
            }
            obj.realmSet$trainingDuration(json.getLong("trainingDuration"));
        }
        return obj;
    }

    @TargetApi(11)
    public static FlashWordsConfig createUsingJsonStream(Realm realm, JsonReader reader) throws IOException {
        boolean jsonHasPrimaryKey = false;
        FlashWordsConfig obj = new FlashWordsConfig();
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
            } else if (name.equals(SpeedReadingConfig.FIELD_SPEED)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'speed' to null.");
                }
                obj.realmSet$speed(reader.nextInt());
            } else if (name.equals(FlashWordsConfig.FIELD_BOARD_TYPE)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'boarType' to null.");
                }
                obj.realmSet$boarType(reader.nextInt());
            } else if (!name.equals("trainingDuration")) {
                reader.skipValue();
            } else if (reader.peek() == JsonToken.NULL) {
                reader.skipValue();
                throw new IllegalArgumentException("Trying to set non-nullable field 'trainingDuration' to null.");
            } else {
                obj.realmSet$trainingDuration(reader.nextLong());
            }
        }
        reader.endObject();
        if (jsonHasPrimaryKey) {
            return (FlashWordsConfig) realm.copyToRealm(obj);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
    }

    public static FlashWordsConfig copyOrUpdate(Realm realm, FlashWordsConfig object, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        } else {
            BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            RealmObjectProxy cachedRealmObject = cache.get(object);
            if (cachedRealmObject != null) {
                return (FlashWordsConfig) cachedRealmObject;
            }
            FlashWordsConfig realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(FlashWordsConfig.class);
                long rowIndex = table.findFirstLong(table.getPrimaryKey(), (long) object.realmGet$id());
                if (rowIndex != -1) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(FlashWordsConfig.class), false, Collections.emptyList());
                        FlashWordsConfig realmObject2 = new FlashWordsConfigRealmProxy();
                        try {
                            cache.put(object, (RealmObjectProxy) realmObject2);
                            objectContext.clear();
                            realmObject = realmObject2;
                        } catch (Throwable th) {
                            th = th;
                            FlashWordsConfig flashWordsConfig = realmObject2;
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

    public static FlashWordsConfig copy(Realm realm, FlashWordsConfig newObject, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (FlashWordsConfig) cachedRealmObject;
        }
        FlashWordsConfig realmObject = (FlashWordsConfig) realm.createObjectInternal(FlashWordsConfig.class, Integer.valueOf(newObject.realmGet$id()), false, Collections.emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.realmSet$speed(newObject.realmGet$speed());
        realmObject.realmSet$boarType(newObject.realmGet$boarType());
        realmObject.realmSet$trainingDuration(newObject.realmGet$trainingDuration());
        return realmObject;
    }

    public static long insert(Realm realm, FlashWordsConfig object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(FlashWordsConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        FlashWordsConfigColumnInfo columnInfo2 = (FlashWordsConfigColumnInfo) realm.schema.getColumnInfo(FlashWordsConfig.class);
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
        Table.nativeSetLong(tableNativePtr, columnInfo2.speedIndex, rowIndex, (long) object.realmGet$speed(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.boarTypeIndex, rowIndex, (long) object.realmGet$boarType(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.trainingDurationIndex, rowIndex, object.realmGet$trainingDuration(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(FlashWordsConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        FlashWordsConfigColumnInfo columnInfo2 = (FlashWordsConfigColumnInfo) realm.schema.getColumnInfo(FlashWordsConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            FlashWordsConfig object = (FlashWordsConfig) objects.next();
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
                    Table.nativeSetLong(tableNativePtr, columnInfo2.speedIndex, rowIndex, (long) object.realmGet$speed(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.boarTypeIndex, rowIndex, (long) object.realmGet$boarType(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.trainingDurationIndex, rowIndex, object.realmGet$trainingDuration(), false);
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, FlashWordsConfig object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(FlashWordsConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        FlashWordsConfigColumnInfo columnInfo2 = (FlashWordsConfigColumnInfo) realm.schema.getColumnInfo(FlashWordsConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = -1;
        if (Integer.valueOf(object.realmGet$id()) != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, (long) object.realmGet$id());
        }
        if (rowIndex == -1) {
            rowIndex = table.addEmptyRowWithPrimaryKey(Integer.valueOf(object.realmGet$id()), false);
        }
        cache.put(object, Long.valueOf(rowIndex));
        Table.nativeSetLong(tableNativePtr, columnInfo2.speedIndex, rowIndex, (long) object.realmGet$speed(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.boarTypeIndex, rowIndex, (long) object.realmGet$boarType(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.trainingDurationIndex, rowIndex, object.realmGet$trainingDuration(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(FlashWordsConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        FlashWordsConfigColumnInfo columnInfo2 = (FlashWordsConfigColumnInfo) realm.schema.getColumnInfo(FlashWordsConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            FlashWordsConfig object = (FlashWordsConfig) objects.next();
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
                    Table.nativeSetLong(tableNativePtr, columnInfo2.speedIndex, rowIndex, (long) object.realmGet$speed(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.boarTypeIndex, rowIndex, (long) object.realmGet$boarType(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.trainingDurationIndex, rowIndex, object.realmGet$trainingDuration(), false);
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static FlashWordsConfig createDetachedCopy(FlashWordsConfig realmObject, int currentDepth, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        FlashWordsConfig unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        RealmObjectProxy.CacheData<RealmModel> cachedObject = cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new FlashWordsConfig();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.minDepth) {
            return (FlashWordsConfig) cachedObject.object;
        } else {
            unmanagedObject = (FlashWordsConfig) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        unmanagedObject.realmSet$id(realmObject.realmGet$id());
        unmanagedObject.realmSet$speed(realmObject.realmGet$speed());
        unmanagedObject.realmSet$boarType(realmObject.realmGet$boarType());
        unmanagedObject.realmSet$trainingDuration(realmObject.realmGet$trainingDuration());
        return unmanagedObject;
    }

    static FlashWordsConfig update(Realm realm, FlashWordsConfig realmObject, FlashWordsConfig newObject, Map<RealmModel, RealmObjectProxy> map) {
        realmObject.realmSet$speed(newObject.realmGet$speed());
        realmObject.realmSet$boarType(newObject.realmGet$boarType());
        realmObject.realmSet$trainingDuration(newObject.realmGet$trainingDuration());
        return realmObject;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        return "FlashWordsConfig = [" + "{id:" + realmGet$id() + "}" + "," + "{speed:" + realmGet$speed() + "}" + "," + "{boarType:" + realmGet$boarType() + "}" + "," + "{trainingDuration:" + realmGet$trainingDuration() + "}" + "]";
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
        FlashWordsConfigRealmProxy aFlashWordsConfig = (FlashWordsConfigRealmProxy) o;
        String path = this.proxyState.getRealm$realm().getPath();
        String otherPath = aFlashWordsConfig.proxyState.getRealm$realm().getPath();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.proxyState.getRow$realm().getTable().getName();
        String otherTableName = aFlashWordsConfig.proxyState.getRow$realm().getTable().getName();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != aFlashWordsConfig.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
