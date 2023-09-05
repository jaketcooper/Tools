package p006io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableConfig;
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

/* renamed from: io.realm.SchulteTableConfigRealmProxy */
public class SchulteTableConfigRealmProxy extends SchulteTableConfig implements RealmObjectProxy, SchulteTableConfigRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private SchulteTableConfigColumnInfo columnInfo;
    private ProxyState<SchulteTableConfig> proxyState;

    /* renamed from: io.realm.SchulteTableConfigRealmProxy$SchulteTableConfigColumnInfo */
    static final class SchulteTableConfigColumnInfo extends ColumnInfo implements Cloneable {
        public long columnCountIndex;
        public long idIndex;
        public long isFullscreenIndex;
        public long rowCountIndex;

        SchulteTableConfigColumnInfo(String path, Table table) {
            Map<String, Long> indicesMap = new HashMap<>(4);
            this.idIndex = getValidColumnIndex(path, table, "SchulteTableConfig", IdentityRealmObject.FIELD_ID);
            indicesMap.put(IdentityRealmObject.FIELD_ID, Long.valueOf(this.idIndex));
            this.isFullscreenIndex = getValidColumnIndex(path, table, "SchulteTableConfig", SchulteTableConfig.FIELD_FULLSCREEN);
            indicesMap.put(SchulteTableConfig.FIELD_FULLSCREEN, Long.valueOf(this.isFullscreenIndex));
            this.rowCountIndex = getValidColumnIndex(path, table, "SchulteTableConfig", "rowCount");
            indicesMap.put("rowCount", Long.valueOf(this.rowCountIndex));
            this.columnCountIndex = getValidColumnIndex(path, table, "SchulteTableConfig", "columnCount");
            indicesMap.put("columnCount", Long.valueOf(this.columnCountIndex));
            setIndicesMap(indicesMap);
        }

        public final void copyColumnInfoFrom(ColumnInfo other) {
            SchulteTableConfigColumnInfo otherInfo = (SchulteTableConfigColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.isFullscreenIndex = otherInfo.isFullscreenIndex;
            this.rowCountIndex = otherInfo.rowCountIndex;
            this.columnCountIndex = otherInfo.columnCountIndex;
            setIndicesMap(otherInfo.getIndicesMap());
        }

        public final SchulteTableConfigColumnInfo clone() {
            return (SchulteTableConfigColumnInfo) super.clone();
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add(IdentityRealmObject.FIELD_ID);
        fieldNames.add(SchulteTableConfig.FIELD_FULLSCREEN);
        fieldNames.add("rowCount");
        fieldNames.add("columnCount");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    SchulteTableConfigRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext context = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (SchulteTableConfigColumnInfo) context.getColumnInfo();
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

    public boolean realmGet$isFullscreen() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.isFullscreenIndex);
    }

    public void realmSet$isFullscreen(boolean value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.isFullscreenIndex, value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setBoolean(this.columnInfo.isFullscreenIndex, row.getIndex(), value, true);
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

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (realmSchema.contains("SchulteTableConfig")) {
            return realmSchema.get("SchulteTableConfig");
        }
        RealmObjectSchema realmObjectSchema = realmSchema.create("SchulteTableConfig");
        realmObjectSchema.add(new Property(IdentityRealmObject.FIELD_ID, RealmFieldType.INTEGER, true, true, true));
        realmObjectSchema.add(new Property(SchulteTableConfig.FIELD_FULLSCREEN, RealmFieldType.BOOLEAN, false, false, true));
        realmObjectSchema.add(new Property("rowCount", RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property("columnCount", RealmFieldType.INTEGER, false, false, true));
        return realmObjectSchema;
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (sharedRealm.hasTable("class_SchulteTableConfig")) {
            return sharedRealm.getTable("class_SchulteTableConfig");
        }
        Table table = sharedRealm.getTable("class_SchulteTableConfig");
        table.addColumn(RealmFieldType.INTEGER, IdentityRealmObject.FIELD_ID, false);
        table.addColumn(RealmFieldType.BOOLEAN, SchulteTableConfig.FIELD_FULLSCREEN, false);
        table.addColumn(RealmFieldType.INTEGER, "rowCount", false);
        table.addColumn(RealmFieldType.INTEGER, "columnCount", false);
        table.addSearchIndex(table.getColumnIndex(IdentityRealmObject.FIELD_ID));
        table.setPrimaryKey(IdentityRealmObject.FIELD_ID);
        return table;
    }

    public static SchulteTableConfigColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_SchulteTableConfig")) {
            Table table = sharedRealm.getTable("class_SchulteTableConfig");
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
            SchulteTableConfigColumnInfo columnInfo2 = new SchulteTableConfigColumnInfo(sharedRealm.getPath(), table);
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
            } else if (!columnTypes.containsKey(SchulteTableConfig.FIELD_FULLSCREEN)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isFullscreen' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(SchulteTableConfig.FIELD_FULLSCREEN) != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'isFullscreen' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.isFullscreenIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'isFullscreen' does support null values in the existing Realm file. Use corresponding boxed type for field 'isFullscreen' or migrate using RealmObjectSchema.setNullable().");
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
            } else if (!table.isColumnNullable(columnInfo2.columnCountIndex)) {
                return columnInfo2;
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'columnCount' does support null values in the existing Realm file. Use corresponding boxed type for field 'columnCount' or migrate using RealmObjectSchema.setNullable().");
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'SchulteTableConfig' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_SchulteTableConfig";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static SchulteTableConfig createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update) throws JSONException {
        List emptyList = Collections.emptyList();
        SchulteTableConfig obj = null;
        if (update) {
            Table table = realm.getTable(SchulteTableConfig.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = -1;
            if (!json.isNull(IdentityRealmObject.FIELD_ID)) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong(IdentityRealmObject.FIELD_ID));
            }
            if (rowIndex != -1) {
                BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(SchulteTableConfig.class), false, Collections.emptyList());
                    obj = new SchulteTableConfigRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (!json.has(IdentityRealmObject.FIELD_ID)) {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            } else if (json.isNull(IdentityRealmObject.FIELD_ID)) {
                obj = (SchulteTableConfigRealmProxy) realm.createObjectInternal(SchulteTableConfig.class, (Object) null, true, emptyList);
            } else {
                obj = (SchulteTableConfigRealmProxy) realm.createObjectInternal(SchulteTableConfig.class, Integer.valueOf(json.getInt(IdentityRealmObject.FIELD_ID)), true, emptyList);
            }
        }
        if (json.has(SchulteTableConfig.FIELD_FULLSCREEN)) {
            if (json.isNull(SchulteTableConfig.FIELD_FULLSCREEN)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isFullscreen' to null.");
            }
            obj.realmSet$isFullscreen(json.getBoolean(SchulteTableConfig.FIELD_FULLSCREEN));
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
        return obj;
    }

    @TargetApi(11)
    public static SchulteTableConfig createUsingJsonStream(Realm realm, JsonReader reader) throws IOException {
        boolean jsonHasPrimaryKey = false;
        SchulteTableConfig obj = new SchulteTableConfig();
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
            } else if (name.equals(SchulteTableConfig.FIELD_FULLSCREEN)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isFullscreen' to null.");
                }
                obj.realmSet$isFullscreen(reader.nextBoolean());
            } else if (name.equals("rowCount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'rowCount' to null.");
                }
                obj.realmSet$rowCount(reader.nextInt());
            } else if (!name.equals("columnCount")) {
                reader.skipValue();
            } else if (reader.peek() == JsonToken.NULL) {
                reader.skipValue();
                throw new IllegalArgumentException("Trying to set non-nullable field 'columnCount' to null.");
            } else {
                obj.realmSet$columnCount(reader.nextInt());
            }
        }
        reader.endObject();
        if (jsonHasPrimaryKey) {
            return (SchulteTableConfig) realm.copyToRealm(obj);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
    }

    public static SchulteTableConfig copyOrUpdate(Realm realm, SchulteTableConfig object, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        } else {
            BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            RealmObjectProxy cachedRealmObject = cache.get(object);
            if (cachedRealmObject != null) {
                return (SchulteTableConfig) cachedRealmObject;
            }
            SchulteTableConfig realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(SchulteTableConfig.class);
                long rowIndex = table.findFirstLong(table.getPrimaryKey(), (long) object.realmGet$id());
                if (rowIndex != -1) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(SchulteTableConfig.class), false, Collections.emptyList());
                        SchulteTableConfig realmObject2 = new SchulteTableConfigRealmProxy();
                        try {
                            cache.put(object, (RealmObjectProxy) realmObject2);
                            objectContext.clear();
                            realmObject = realmObject2;
                        } catch (Throwable th) {
                            th = th;
                            SchulteTableConfig schulteTableConfig = realmObject2;
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

    public static SchulteTableConfig copy(Realm realm, SchulteTableConfig newObject, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (SchulteTableConfig) cachedRealmObject;
        }
        SchulteTableConfig realmObject = (SchulteTableConfig) realm.createObjectInternal(SchulteTableConfig.class, Integer.valueOf(newObject.realmGet$id()), false, Collections.emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.realmSet$isFullscreen(newObject.realmGet$isFullscreen());
        realmObject.realmSet$rowCount(newObject.realmGet$rowCount());
        realmObject.realmSet$columnCount(newObject.realmGet$columnCount());
        return realmObject;
    }

    public static long insert(Realm realm, SchulteTableConfig object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(SchulteTableConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        SchulteTableConfigColumnInfo columnInfo2 = (SchulteTableConfigColumnInfo) realm.schema.getColumnInfo(SchulteTableConfig.class);
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
        Table.nativeSetBoolean(tableNativePtr, columnInfo2.isFullscreenIndex, rowIndex, object.realmGet$isFullscreen(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.rowCountIndex, rowIndex, (long) object.realmGet$rowCount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.columnCountIndex, rowIndex, (long) object.realmGet$columnCount(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(SchulteTableConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        SchulteTableConfigColumnInfo columnInfo2 = (SchulteTableConfigColumnInfo) realm.schema.getColumnInfo(SchulteTableConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            SchulteTableConfig object = (SchulteTableConfig) objects.next();
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
                    Table.nativeSetBoolean(tableNativePtr, columnInfo2.isFullscreenIndex, rowIndex, object.realmGet$isFullscreen(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.rowCountIndex, rowIndex, (long) object.realmGet$rowCount(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.columnCountIndex, rowIndex, (long) object.realmGet$columnCount(), false);
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, SchulteTableConfig object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(SchulteTableConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        SchulteTableConfigColumnInfo columnInfo2 = (SchulteTableConfigColumnInfo) realm.schema.getColumnInfo(SchulteTableConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = -1;
        if (Integer.valueOf(object.realmGet$id()) != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, (long) object.realmGet$id());
        }
        if (rowIndex == -1) {
            rowIndex = table.addEmptyRowWithPrimaryKey(Integer.valueOf(object.realmGet$id()), false);
        }
        cache.put(object, Long.valueOf(rowIndex));
        Table.nativeSetBoolean(tableNativePtr, columnInfo2.isFullscreenIndex, rowIndex, object.realmGet$isFullscreen(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.rowCountIndex, rowIndex, (long) object.realmGet$rowCount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.columnCountIndex, rowIndex, (long) object.realmGet$columnCount(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(SchulteTableConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        SchulteTableConfigColumnInfo columnInfo2 = (SchulteTableConfigColumnInfo) realm.schema.getColumnInfo(SchulteTableConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            SchulteTableConfig object = (SchulteTableConfig) objects.next();
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
                    Table.nativeSetBoolean(tableNativePtr, columnInfo2.isFullscreenIndex, rowIndex, object.realmGet$isFullscreen(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.rowCountIndex, rowIndex, (long) object.realmGet$rowCount(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.columnCountIndex, rowIndex, (long) object.realmGet$columnCount(), false);
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static SchulteTableConfig createDetachedCopy(SchulteTableConfig realmObject, int currentDepth, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        SchulteTableConfig unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        RealmObjectProxy.CacheData<RealmModel> cachedObject = cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new SchulteTableConfig();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.minDepth) {
            return (SchulteTableConfig) cachedObject.object;
        } else {
            unmanagedObject = (SchulteTableConfig) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        unmanagedObject.realmSet$id(realmObject.realmGet$id());
        unmanagedObject.realmSet$isFullscreen(realmObject.realmGet$isFullscreen());
        unmanagedObject.realmSet$rowCount(realmObject.realmGet$rowCount());
        unmanagedObject.realmSet$columnCount(realmObject.realmGet$columnCount());
        return unmanagedObject;
    }

    static SchulteTableConfig update(Realm realm, SchulteTableConfig realmObject, SchulteTableConfig newObject, Map<RealmModel, RealmObjectProxy> map) {
        realmObject.realmSet$isFullscreen(newObject.realmGet$isFullscreen());
        realmObject.realmSet$rowCount(newObject.realmGet$rowCount());
        realmObject.realmSet$columnCount(newObject.realmGet$columnCount());
        return realmObject;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        return "SchulteTableConfig = [" + "{id:" + realmGet$id() + "}" + "," + "{isFullscreen:" + realmGet$isFullscreen() + "}" + "," + "{rowCount:" + realmGet$rowCount() + "}" + "," + "{columnCount:" + realmGet$columnCount() + "}" + "]";
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
        SchulteTableConfigRealmProxy aSchulteTableConfig = (SchulteTableConfigRealmProxy) o;
        String path = this.proxyState.getRealm$realm().getPath();
        String otherPath = aSchulteTableConfig.proxyState.getRealm$realm().getPath();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.proxyState.getRow$realm().getTable().getName();
        String otherTableName = aSchulteTableConfig.proxyState.getRow$realm().getTable().getName();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != aSchulteTableConfig.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
