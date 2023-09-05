package p006io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingConfig;
import com.safonov.speedreading.training.fragment.wordsblock.repository.entity.WordBlockConfig;
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

/* renamed from: io.realm.WordBlockConfigRealmProxy */
public class WordBlockConfigRealmProxy extends WordBlockConfig implements RealmObjectProxy, WordBlockConfigRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private WordBlockConfigColumnInfo columnInfo;
    private ProxyState<WordBlockConfig> proxyState;

    /* renamed from: io.realm.WordBlockConfigRealmProxy$WordBlockConfigColumnInfo */
    static final class WordBlockConfigColumnInfo extends ColumnInfo implements Cloneable {
        public long idIndex;
        public long speedIndex;
        public long trainingDurationIndex;
        public long wordCountIndex;

        WordBlockConfigColumnInfo(String path, Table table) {
            Map<String, Long> indicesMap = new HashMap<>(4);
            this.idIndex = getValidColumnIndex(path, table, "WordBlockConfig", IdentityRealmObject.FIELD_ID);
            indicesMap.put(IdentityRealmObject.FIELD_ID, Long.valueOf(this.idIndex));
            this.trainingDurationIndex = getValidColumnIndex(path, table, "WordBlockConfig", "trainingDuration");
            indicesMap.put("trainingDuration", Long.valueOf(this.trainingDurationIndex));
            this.wordCountIndex = getValidColumnIndex(path, table, "WordBlockConfig", "wordCount");
            indicesMap.put("wordCount", Long.valueOf(this.wordCountIndex));
            this.speedIndex = getValidColumnIndex(path, table, "WordBlockConfig", SpeedReadingConfig.FIELD_SPEED);
            indicesMap.put(SpeedReadingConfig.FIELD_SPEED, Long.valueOf(this.speedIndex));
            setIndicesMap(indicesMap);
        }

        public final void copyColumnInfoFrom(ColumnInfo other) {
            WordBlockConfigColumnInfo otherInfo = (WordBlockConfigColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.trainingDurationIndex = otherInfo.trainingDurationIndex;
            this.wordCountIndex = otherInfo.wordCountIndex;
            this.speedIndex = otherInfo.speedIndex;
            setIndicesMap(otherInfo.getIndicesMap());
        }

        public final WordBlockConfigColumnInfo clone() {
            return (WordBlockConfigColumnInfo) super.clone();
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add(IdentityRealmObject.FIELD_ID);
        fieldNames.add("trainingDuration");
        fieldNames.add("wordCount");
        fieldNames.add(SpeedReadingConfig.FIELD_SPEED);
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    WordBlockConfigRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext context = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (WordBlockConfigColumnInfo) context.getColumnInfo();
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

    public int realmGet$wordCount() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.wordCountIndex);
    }

    public void realmSet$wordCount(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.wordCountIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.wordCountIndex, row.getIndex(), (long) value, true);
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

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (realmSchema.contains("WordBlockConfig")) {
            return realmSchema.get("WordBlockConfig");
        }
        RealmObjectSchema realmObjectSchema = realmSchema.create("WordBlockConfig");
        realmObjectSchema.add(new Property(IdentityRealmObject.FIELD_ID, RealmFieldType.INTEGER, true, true, true));
        realmObjectSchema.add(new Property("trainingDuration", RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property("wordCount", RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(SpeedReadingConfig.FIELD_SPEED, RealmFieldType.INTEGER, false, false, true));
        return realmObjectSchema;
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (sharedRealm.hasTable("class_WordBlockConfig")) {
            return sharedRealm.getTable("class_WordBlockConfig");
        }
        Table table = sharedRealm.getTable("class_WordBlockConfig");
        table.addColumn(RealmFieldType.INTEGER, IdentityRealmObject.FIELD_ID, false);
        table.addColumn(RealmFieldType.INTEGER, "trainingDuration", false);
        table.addColumn(RealmFieldType.INTEGER, "wordCount", false);
        table.addColumn(RealmFieldType.INTEGER, SpeedReadingConfig.FIELD_SPEED, false);
        table.addSearchIndex(table.getColumnIndex(IdentityRealmObject.FIELD_ID));
        table.setPrimaryKey(IdentityRealmObject.FIELD_ID);
        return table;
    }

    public static WordBlockConfigColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_WordBlockConfig")) {
            Table table = sharedRealm.getTable("class_WordBlockConfig");
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
            WordBlockConfigColumnInfo columnInfo2 = new WordBlockConfigColumnInfo(sharedRealm.getPath(), table);
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
            } else if (!columnTypes.containsKey("trainingDuration")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'trainingDuration' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get("trainingDuration") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'long' for field 'trainingDuration' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.trainingDurationIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'trainingDuration' does support null values in the existing Realm file. Use corresponding boxed type for field 'trainingDuration' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey("wordCount")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'wordCount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get("wordCount") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'wordCount' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.wordCountIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'wordCount' does support null values in the existing Realm file. Use corresponding boxed type for field 'wordCount' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(SpeedReadingConfig.FIELD_SPEED)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'speed' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(SpeedReadingConfig.FIELD_SPEED) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'speed' in existing Realm file.");
            } else if (!table.isColumnNullable(columnInfo2.speedIndex)) {
                return columnInfo2;
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'speed' does support null values in the existing Realm file. Use corresponding boxed type for field 'speed' or migrate using RealmObjectSchema.setNullable().");
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'WordBlockConfig' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_WordBlockConfig";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static WordBlockConfig createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update) throws JSONException {
        List emptyList = Collections.emptyList();
        WordBlockConfig obj = null;
        if (update) {
            Table table = realm.getTable(WordBlockConfig.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = -1;
            if (!json.isNull(IdentityRealmObject.FIELD_ID)) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong(IdentityRealmObject.FIELD_ID));
            }
            if (rowIndex != -1) {
                BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(WordBlockConfig.class), false, Collections.emptyList());
                    obj = new WordBlockConfigRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (!json.has(IdentityRealmObject.FIELD_ID)) {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            } else if (json.isNull(IdentityRealmObject.FIELD_ID)) {
                obj = (WordBlockConfigRealmProxy) realm.createObjectInternal(WordBlockConfig.class, (Object) null, true, emptyList);
            } else {
                obj = (WordBlockConfigRealmProxy) realm.createObjectInternal(WordBlockConfig.class, Integer.valueOf(json.getInt(IdentityRealmObject.FIELD_ID)), true, emptyList);
            }
        }
        if (json.has("trainingDuration")) {
            if (json.isNull("trainingDuration")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'trainingDuration' to null.");
            }
            obj.realmSet$trainingDuration(json.getLong("trainingDuration"));
        }
        if (json.has("wordCount")) {
            if (json.isNull("wordCount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'wordCount' to null.");
            }
            obj.realmSet$wordCount(json.getInt("wordCount"));
        }
        if (json.has(SpeedReadingConfig.FIELD_SPEED)) {
            if (json.isNull(SpeedReadingConfig.FIELD_SPEED)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'speed' to null.");
            }
            obj.realmSet$speed(json.getInt(SpeedReadingConfig.FIELD_SPEED));
        }
        return obj;
    }

    @TargetApi(11)
    public static WordBlockConfig createUsingJsonStream(Realm realm, JsonReader reader) throws IOException {
        boolean jsonHasPrimaryKey = false;
        WordBlockConfig obj = new WordBlockConfig();
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
            } else if (name.equals("trainingDuration")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'trainingDuration' to null.");
                }
                obj.realmSet$trainingDuration(reader.nextLong());
            } else if (name.equals("wordCount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'wordCount' to null.");
                }
                obj.realmSet$wordCount(reader.nextInt());
            } else if (!name.equals(SpeedReadingConfig.FIELD_SPEED)) {
                reader.skipValue();
            } else if (reader.peek() == JsonToken.NULL) {
                reader.skipValue();
                throw new IllegalArgumentException("Trying to set non-nullable field 'speed' to null.");
            } else {
                obj.realmSet$speed(reader.nextInt());
            }
        }
        reader.endObject();
        if (jsonHasPrimaryKey) {
            return (WordBlockConfig) realm.copyToRealm(obj);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
    }

    public static WordBlockConfig copyOrUpdate(Realm realm, WordBlockConfig object, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        } else {
            BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            RealmObjectProxy cachedRealmObject = cache.get(object);
            if (cachedRealmObject != null) {
                return (WordBlockConfig) cachedRealmObject;
            }
            WordBlockConfig realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(WordBlockConfig.class);
                long rowIndex = table.findFirstLong(table.getPrimaryKey(), (long) object.realmGet$id());
                if (rowIndex != -1) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(WordBlockConfig.class), false, Collections.emptyList());
                        WordBlockConfig realmObject2 = new WordBlockConfigRealmProxy();
                        try {
                            cache.put(object, (RealmObjectProxy) realmObject2);
                            objectContext.clear();
                            realmObject = realmObject2;
                        } catch (Throwable th) {
                            th = th;
                            WordBlockConfig wordBlockConfig = realmObject2;
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

    public static WordBlockConfig copy(Realm realm, WordBlockConfig newObject, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (WordBlockConfig) cachedRealmObject;
        }
        WordBlockConfig realmObject = (WordBlockConfig) realm.createObjectInternal(WordBlockConfig.class, Integer.valueOf(newObject.realmGet$id()), false, Collections.emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.realmSet$trainingDuration(newObject.realmGet$trainingDuration());
        realmObject.realmSet$wordCount(newObject.realmGet$wordCount());
        realmObject.realmSet$speed(newObject.realmGet$speed());
        return realmObject;
    }

    public static long insert(Realm realm, WordBlockConfig object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(WordBlockConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        WordBlockConfigColumnInfo columnInfo2 = (WordBlockConfigColumnInfo) realm.schema.getColumnInfo(WordBlockConfig.class);
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
        Table.nativeSetLong(tableNativePtr, columnInfo2.trainingDurationIndex, rowIndex, object.realmGet$trainingDuration(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.wordCountIndex, rowIndex, (long) object.realmGet$wordCount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.speedIndex, rowIndex, (long) object.realmGet$speed(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(WordBlockConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        WordBlockConfigColumnInfo columnInfo2 = (WordBlockConfigColumnInfo) realm.schema.getColumnInfo(WordBlockConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            WordBlockConfig object = (WordBlockConfig) objects.next();
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
                    Table.nativeSetLong(tableNativePtr, columnInfo2.trainingDurationIndex, rowIndex, object.realmGet$trainingDuration(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.wordCountIndex, rowIndex, (long) object.realmGet$wordCount(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.speedIndex, rowIndex, (long) object.realmGet$speed(), false);
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, WordBlockConfig object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(WordBlockConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        WordBlockConfigColumnInfo columnInfo2 = (WordBlockConfigColumnInfo) realm.schema.getColumnInfo(WordBlockConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = -1;
        if (Integer.valueOf(object.realmGet$id()) != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, (long) object.realmGet$id());
        }
        if (rowIndex == -1) {
            rowIndex = table.addEmptyRowWithPrimaryKey(Integer.valueOf(object.realmGet$id()), false);
        }
        cache.put(object, Long.valueOf(rowIndex));
        Table.nativeSetLong(tableNativePtr, columnInfo2.trainingDurationIndex, rowIndex, object.realmGet$trainingDuration(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.wordCountIndex, rowIndex, (long) object.realmGet$wordCount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.speedIndex, rowIndex, (long) object.realmGet$speed(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(WordBlockConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        WordBlockConfigColumnInfo columnInfo2 = (WordBlockConfigColumnInfo) realm.schema.getColumnInfo(WordBlockConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            WordBlockConfig object = (WordBlockConfig) objects.next();
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
                    Table.nativeSetLong(tableNativePtr, columnInfo2.trainingDurationIndex, rowIndex, object.realmGet$trainingDuration(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.wordCountIndex, rowIndex, (long) object.realmGet$wordCount(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.speedIndex, rowIndex, (long) object.realmGet$speed(), false);
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static WordBlockConfig createDetachedCopy(WordBlockConfig realmObject, int currentDepth, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        WordBlockConfig unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        RealmObjectProxy.CacheData<RealmModel> cachedObject = cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new WordBlockConfig();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.minDepth) {
            return (WordBlockConfig) cachedObject.object;
        } else {
            unmanagedObject = (WordBlockConfig) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        unmanagedObject.realmSet$id(realmObject.realmGet$id());
        unmanagedObject.realmSet$trainingDuration(realmObject.realmGet$trainingDuration());
        unmanagedObject.realmSet$wordCount(realmObject.realmGet$wordCount());
        unmanagedObject.realmSet$speed(realmObject.realmGet$speed());
        return unmanagedObject;
    }

    static WordBlockConfig update(Realm realm, WordBlockConfig realmObject, WordBlockConfig newObject, Map<RealmModel, RealmObjectProxy> map) {
        realmObject.realmSet$trainingDuration(newObject.realmGet$trainingDuration());
        realmObject.realmSet$wordCount(newObject.realmGet$wordCount());
        realmObject.realmSet$speed(newObject.realmGet$speed());
        return realmObject;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        return "WordBlockConfig = [" + "{id:" + realmGet$id() + "}" + "," + "{trainingDuration:" + realmGet$trainingDuration() + "}" + "," + "{wordCount:" + realmGet$wordCount() + "}" + "," + "{speed:" + realmGet$speed() + "}" + "]";
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
        WordBlockConfigRealmProxy aWordBlockConfig = (WordBlockConfigRealmProxy) o;
        String path = this.proxyState.getRealm$realm().getPath();
        String otherPath = aWordBlockConfig.proxyState.getRealm$realm().getPath();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.proxyState.getRow$realm().getTable().getName();
        String otherTableName = aWordBlockConfig.proxyState.getRow$realm().getTable().getName();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != aWordBlockConfig.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
