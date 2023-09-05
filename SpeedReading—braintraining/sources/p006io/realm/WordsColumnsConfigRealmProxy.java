package p006io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingConfig;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.entity.WordsColumnsConfig;
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

/* renamed from: io.realm.WordsColumnsConfigRealmProxy */
public class WordsColumnsConfigRealmProxy extends WordsColumnsConfig implements RealmObjectProxy, WordsColumnsConfigRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private WordsColumnsConfigColumnInfo columnInfo;
    private ProxyState<WordsColumnsConfig> proxyState;

    /* renamed from: io.realm.WordsColumnsConfigRealmProxy$WordsColumnsConfigColumnInfo */
    static final class WordsColumnsConfigColumnInfo extends ColumnInfo implements Cloneable {
        public long columnCountIndex;
        public long idIndex;
        public long rowCountIndex;
        public long speedIndex;
        public long trainingDurationIndex;
        public long wordsPerItemIndex;

        WordsColumnsConfigColumnInfo(String path, Table table) {
            Map<String, Long> indicesMap = new HashMap<>(6);
            this.idIndex = getValidColumnIndex(path, table, "WordsColumnsConfig", IdentityRealmObject.FIELD_ID);
            indicesMap.put(IdentityRealmObject.FIELD_ID, Long.valueOf(this.idIndex));
            this.rowCountIndex = getValidColumnIndex(path, table, "WordsColumnsConfig", "rowCount");
            indicesMap.put("rowCount", Long.valueOf(this.rowCountIndex));
            this.columnCountIndex = getValidColumnIndex(path, table, "WordsColumnsConfig", "columnCount");
            indicesMap.put("columnCount", Long.valueOf(this.columnCountIndex));
            this.wordsPerItemIndex = getValidColumnIndex(path, table, "WordsColumnsConfig", WordsColumnsConfig.FIELD_WORDS_PER_ITEM);
            indicesMap.put(WordsColumnsConfig.FIELD_WORDS_PER_ITEM, Long.valueOf(this.wordsPerItemIndex));
            this.speedIndex = getValidColumnIndex(path, table, "WordsColumnsConfig", SpeedReadingConfig.FIELD_SPEED);
            indicesMap.put(SpeedReadingConfig.FIELD_SPEED, Long.valueOf(this.speedIndex));
            this.trainingDurationIndex = getValidColumnIndex(path, table, "WordsColumnsConfig", "trainingDuration");
            indicesMap.put("trainingDuration", Long.valueOf(this.trainingDurationIndex));
            setIndicesMap(indicesMap);
        }

        public final void copyColumnInfoFrom(ColumnInfo other) {
            WordsColumnsConfigColumnInfo otherInfo = (WordsColumnsConfigColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.rowCountIndex = otherInfo.rowCountIndex;
            this.columnCountIndex = otherInfo.columnCountIndex;
            this.wordsPerItemIndex = otherInfo.wordsPerItemIndex;
            this.speedIndex = otherInfo.speedIndex;
            this.trainingDurationIndex = otherInfo.trainingDurationIndex;
            setIndicesMap(otherInfo.getIndicesMap());
        }

        public final WordsColumnsConfigColumnInfo clone() {
            return (WordsColumnsConfigColumnInfo) super.clone();
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add(IdentityRealmObject.FIELD_ID);
        fieldNames.add("rowCount");
        fieldNames.add("columnCount");
        fieldNames.add(WordsColumnsConfig.FIELD_WORDS_PER_ITEM);
        fieldNames.add(SpeedReadingConfig.FIELD_SPEED);
        fieldNames.add("trainingDuration");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    WordsColumnsConfigRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext context = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (WordsColumnsConfigColumnInfo) context.getColumnInfo();
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

    public int realmGet$wordsPerItem() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.wordsPerItemIndex);
    }

    public void realmSet$wordsPerItem(int value) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.wordsPerItemIndex, (long) value);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row = this.proxyState.getRow$realm();
            row.getTable().setLong(this.columnInfo.wordsPerItemIndex, row.getIndex(), (long) value, true);
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
        if (realmSchema.contains("WordsColumnsConfig")) {
            return realmSchema.get("WordsColumnsConfig");
        }
        RealmObjectSchema realmObjectSchema = realmSchema.create("WordsColumnsConfig");
        realmObjectSchema.add(new Property(IdentityRealmObject.FIELD_ID, RealmFieldType.INTEGER, true, true, true));
        realmObjectSchema.add(new Property("rowCount", RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property("columnCount", RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(WordsColumnsConfig.FIELD_WORDS_PER_ITEM, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property(SpeedReadingConfig.FIELD_SPEED, RealmFieldType.INTEGER, false, false, true));
        realmObjectSchema.add(new Property("trainingDuration", RealmFieldType.INTEGER, false, false, true));
        return realmObjectSchema;
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (sharedRealm.hasTable("class_WordsColumnsConfig")) {
            return sharedRealm.getTable("class_WordsColumnsConfig");
        }
        Table table = sharedRealm.getTable("class_WordsColumnsConfig");
        table.addColumn(RealmFieldType.INTEGER, IdentityRealmObject.FIELD_ID, false);
        table.addColumn(RealmFieldType.INTEGER, "rowCount", false);
        table.addColumn(RealmFieldType.INTEGER, "columnCount", false);
        table.addColumn(RealmFieldType.INTEGER, WordsColumnsConfig.FIELD_WORDS_PER_ITEM, false);
        table.addColumn(RealmFieldType.INTEGER, SpeedReadingConfig.FIELD_SPEED, false);
        table.addColumn(RealmFieldType.INTEGER, "trainingDuration", false);
        table.addSearchIndex(table.getColumnIndex(IdentityRealmObject.FIELD_ID));
        table.setPrimaryKey(IdentityRealmObject.FIELD_ID);
        return table;
    }

    public static WordsColumnsConfigColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_WordsColumnsConfig")) {
            Table table = sharedRealm.getTable("class_WordsColumnsConfig");
            long columnCount = table.getColumnCount();
            if (columnCount != 6) {
                if (columnCount < 6) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 6 but was " + columnCount);
                } else if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 6 but was %1$d", Long.valueOf(columnCount));
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 6 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            WordsColumnsConfigColumnInfo columnInfo2 = new WordsColumnsConfigColumnInfo(sharedRealm.getPath(), table);
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
            } else if (!columnTypes.containsKey(WordsColumnsConfig.FIELD_WORDS_PER_ITEM)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'wordsPerItem' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(WordsColumnsConfig.FIELD_WORDS_PER_ITEM) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'wordsPerItem' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.wordsPerItemIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'wordsPerItem' does support null values in the existing Realm file. Use corresponding boxed type for field 'wordsPerItem' or migrate using RealmObjectSchema.setNullable().");
            } else if (!columnTypes.containsKey(SpeedReadingConfig.FIELD_SPEED)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'speed' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (columnTypes.get(SpeedReadingConfig.FIELD_SPEED) != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'speed' in existing Realm file.");
            } else if (table.isColumnNullable(columnInfo2.speedIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'speed' does support null values in the existing Realm file. Use corresponding boxed type for field 'speed' or migrate using RealmObjectSchema.setNullable().");
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
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'WordsColumnsConfig' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_WordsColumnsConfig";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static WordsColumnsConfig createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update) throws JSONException {
        List emptyList = Collections.emptyList();
        WordsColumnsConfig obj = null;
        if (update) {
            Table table = realm.getTable(WordsColumnsConfig.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = -1;
            if (!json.isNull(IdentityRealmObject.FIELD_ID)) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong(IdentityRealmObject.FIELD_ID));
            }
            if (rowIndex != -1) {
                BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(WordsColumnsConfig.class), false, Collections.emptyList());
                    obj = new WordsColumnsConfigRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (!json.has(IdentityRealmObject.FIELD_ID)) {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            } else if (json.isNull(IdentityRealmObject.FIELD_ID)) {
                obj = (WordsColumnsConfigRealmProxy) realm.createObjectInternal(WordsColumnsConfig.class, (Object) null, true, emptyList);
            } else {
                obj = (WordsColumnsConfigRealmProxy) realm.createObjectInternal(WordsColumnsConfig.class, Integer.valueOf(json.getInt(IdentityRealmObject.FIELD_ID)), true, emptyList);
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
        if (json.has(WordsColumnsConfig.FIELD_WORDS_PER_ITEM)) {
            if (json.isNull(WordsColumnsConfig.FIELD_WORDS_PER_ITEM)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'wordsPerItem' to null.");
            }
            obj.realmSet$wordsPerItem(json.getInt(WordsColumnsConfig.FIELD_WORDS_PER_ITEM));
        }
        if (json.has(SpeedReadingConfig.FIELD_SPEED)) {
            if (json.isNull(SpeedReadingConfig.FIELD_SPEED)) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'speed' to null.");
            }
            obj.realmSet$speed(json.getInt(SpeedReadingConfig.FIELD_SPEED));
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
    public static WordsColumnsConfig createUsingJsonStream(Realm realm, JsonReader reader) throws IOException {
        boolean jsonHasPrimaryKey = false;
        WordsColumnsConfig obj = new WordsColumnsConfig();
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
            } else if (name.equals(WordsColumnsConfig.FIELD_WORDS_PER_ITEM)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'wordsPerItem' to null.");
                }
                obj.realmSet$wordsPerItem(reader.nextInt());
            } else if (name.equals(SpeedReadingConfig.FIELD_SPEED)) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'speed' to null.");
                }
                obj.realmSet$speed(reader.nextInt());
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
            return (WordsColumnsConfig) realm.copyToRealm(obj);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
    }

    public static WordsColumnsConfig copyOrUpdate(Realm realm, WordsColumnsConfig object, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        } else {
            BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            RealmObjectProxy cachedRealmObject = cache.get(object);
            if (cachedRealmObject != null) {
                return (WordsColumnsConfig) cachedRealmObject;
            }
            WordsColumnsConfig realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(WordsColumnsConfig.class);
                long rowIndex = table.findFirstLong(table.getPrimaryKey(), (long) object.realmGet$id());
                if (rowIndex != -1) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(WordsColumnsConfig.class), false, Collections.emptyList());
                        WordsColumnsConfig realmObject2 = new WordsColumnsConfigRealmProxy();
                        try {
                            cache.put(object, (RealmObjectProxy) realmObject2);
                            objectContext.clear();
                            realmObject = realmObject2;
                        } catch (Throwable th) {
                            th = th;
                            WordsColumnsConfig wordsColumnsConfig = realmObject2;
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

    public static WordsColumnsConfig copy(Realm realm, WordsColumnsConfig newObject, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (WordsColumnsConfig) cachedRealmObject;
        }
        WordsColumnsConfig realmObject = (WordsColumnsConfig) realm.createObjectInternal(WordsColumnsConfig.class, Integer.valueOf(newObject.realmGet$id()), false, Collections.emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.realmSet$rowCount(newObject.realmGet$rowCount());
        realmObject.realmSet$columnCount(newObject.realmGet$columnCount());
        realmObject.realmSet$wordsPerItem(newObject.realmGet$wordsPerItem());
        realmObject.realmSet$speed(newObject.realmGet$speed());
        realmObject.realmSet$trainingDuration(newObject.realmGet$trainingDuration());
        return realmObject;
    }

    public static long insert(Realm realm, WordsColumnsConfig object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(WordsColumnsConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        WordsColumnsConfigColumnInfo columnInfo2 = (WordsColumnsConfigColumnInfo) realm.schema.getColumnInfo(WordsColumnsConfig.class);
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
        Table.nativeSetLong(tableNativePtr, columnInfo2.wordsPerItemIndex, rowIndex, (long) object.realmGet$wordsPerItem(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.speedIndex, rowIndex, (long) object.realmGet$speed(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.trainingDurationIndex, rowIndex, object.realmGet$trainingDuration(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(WordsColumnsConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        WordsColumnsConfigColumnInfo columnInfo2 = (WordsColumnsConfigColumnInfo) realm.schema.getColumnInfo(WordsColumnsConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            WordsColumnsConfig object = (WordsColumnsConfig) objects.next();
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
                    Table.nativeSetLong(tableNativePtr, columnInfo2.wordsPerItemIndex, rowIndex, (long) object.realmGet$wordsPerItem(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.speedIndex, rowIndex, (long) object.realmGet$speed(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.trainingDurationIndex, rowIndex, object.realmGet$trainingDuration(), false);
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, WordsColumnsConfig object, Map<RealmModel, Long> cache) {
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(WordsColumnsConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        WordsColumnsConfigColumnInfo columnInfo2 = (WordsColumnsConfigColumnInfo) realm.schema.getColumnInfo(WordsColumnsConfig.class);
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
        Table.nativeSetLong(tableNativePtr, columnInfo2.wordsPerItemIndex, rowIndex, (long) object.realmGet$wordsPerItem(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.speedIndex, rowIndex, (long) object.realmGet$speed(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo2.trainingDurationIndex, rowIndex, object.realmGet$trainingDuration(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel, Long> cache) {
        Table table = realm.getTable(WordsColumnsConfig.class);
        long tableNativePtr = table.getNativeTablePointer();
        WordsColumnsConfigColumnInfo columnInfo2 = (WordsColumnsConfigColumnInfo) realm.schema.getColumnInfo(WordsColumnsConfig.class);
        long pkColumnIndex = table.getPrimaryKey();
        while (objects.hasNext()) {
            WordsColumnsConfig object = (WordsColumnsConfig) objects.next();
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
                    Table.nativeSetLong(tableNativePtr, columnInfo2.wordsPerItemIndex, rowIndex, (long) object.realmGet$wordsPerItem(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.speedIndex, rowIndex, (long) object.realmGet$speed(), false);
                    Table.nativeSetLong(tableNativePtr, columnInfo2.trainingDurationIndex, rowIndex, object.realmGet$trainingDuration(), false);
                } else {
                    cache.put(object, Long.valueOf(((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static WordsColumnsConfig createDetachedCopy(WordsColumnsConfig realmObject, int currentDepth, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        WordsColumnsConfig unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        RealmObjectProxy.CacheData<RealmModel> cachedObject = cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new WordsColumnsConfig();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.minDepth) {
            return (WordsColumnsConfig) cachedObject.object;
        } else {
            unmanagedObject = (WordsColumnsConfig) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        unmanagedObject.realmSet$id(realmObject.realmGet$id());
        unmanagedObject.realmSet$rowCount(realmObject.realmGet$rowCount());
        unmanagedObject.realmSet$columnCount(realmObject.realmGet$columnCount());
        unmanagedObject.realmSet$wordsPerItem(realmObject.realmGet$wordsPerItem());
        unmanagedObject.realmSet$speed(realmObject.realmGet$speed());
        unmanagedObject.realmSet$trainingDuration(realmObject.realmGet$trainingDuration());
        return unmanagedObject;
    }

    static WordsColumnsConfig update(Realm realm, WordsColumnsConfig realmObject, WordsColumnsConfig newObject, Map<RealmModel, RealmObjectProxy> map) {
        realmObject.realmSet$rowCount(newObject.realmGet$rowCount());
        realmObject.realmSet$columnCount(newObject.realmGet$columnCount());
        realmObject.realmSet$wordsPerItem(newObject.realmGet$wordsPerItem());
        realmObject.realmSet$speed(newObject.realmGet$speed());
        realmObject.realmSet$trainingDuration(newObject.realmGet$trainingDuration());
        return realmObject;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        return "WordsColumnsConfig = [" + "{id:" + realmGet$id() + "}" + "," + "{rowCount:" + realmGet$rowCount() + "}" + "," + "{columnCount:" + realmGet$columnCount() + "}" + "," + "{wordsPerItem:" + realmGet$wordsPerItem() + "}" + "," + "{speed:" + realmGet$speed() + "}" + "," + "{trainingDuration:" + realmGet$trainingDuration() + "}" + "]";
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
        WordsColumnsConfigRealmProxy aWordsColumnsConfig = (WordsColumnsConfigRealmProxy) o;
        String path = this.proxyState.getRealm$realm().getPath();
        String otherPath = aWordsColumnsConfig.proxyState.getRealm$realm().getPath();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.proxyState.getRow$realm().getTable().getName();
        String otherTableName = aWordsColumnsConfig.proxyState.getRow$realm().getTable().getName();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != aWordsColumnsConfig.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
