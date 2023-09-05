package p006io.realm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import p006io.realm.RealmObjectSchema;
import p006io.realm.internal.ColumnIndices;
import p006io.realm.internal.ColumnInfo;
import p006io.realm.internal.Table;
import p006io.realm.internal.Util;

/* renamed from: io.realm.RealmSchema */
public class RealmSchema {
    private static final String EMPTY_STRING_MSG = "Null or empty class names are not allowed";
    private static final String TABLE_PREFIX = Table.TABLE_PREFIX;
    private final Map<Class<? extends RealmModel>, RealmObjectSchema> classToSchema;
    private final Map<Class<? extends RealmModel>, Table> classToTable;
    ColumnIndices columnIndices;
    private final Map<String, RealmObjectSchema> dynamicClassToSchema;
    private final Map<String, Table> dynamicClassToTable;
    private long nativePtr;
    private final BaseRealm realm;

    static native void nativeClose(long j);

    static native long nativeCreateFromList(long[] jArr);

    static native long[] nativeGetAll(long j);

    RealmSchema(BaseRealm realm2) {
        this.dynamicClassToTable = new HashMap();
        this.classToTable = new HashMap();
        this.classToSchema = new HashMap();
        this.dynamicClassToSchema = new HashMap();
        this.realm = realm2;
        this.nativePtr = 0;
    }

    RealmSchema() {
        this.dynamicClassToTable = new HashMap();
        this.classToTable = new HashMap();
        this.classToSchema = new HashMap();
        this.dynamicClassToSchema = new HashMap();
        this.realm = null;
        this.nativePtr = 0;
    }

    RealmSchema(ArrayList<RealmObjectSchema> realmObjectSchemas) {
        this.dynamicClassToTable = new HashMap();
        this.classToTable = new HashMap();
        this.classToSchema = new HashMap();
        this.dynamicClassToSchema = new HashMap();
        long[] list = new long[realmObjectSchemas.size()];
        for (int i = 0; i < realmObjectSchemas.size(); i++) {
            list[i] = realmObjectSchemas.get(i).getNativePtr();
        }
        this.nativePtr = nativeCreateFromList(list);
        this.realm = null;
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public void close() {
        if (this.nativePtr != 0) {
            for (RealmObjectSchema schema : getAll()) {
                schema.close();
            }
            nativeClose(this.nativePtr);
        }
    }

    public RealmObjectSchema get(String className) {
        checkEmpty(className, EMPTY_STRING_MSG);
        if (this.realm != null) {
            String internalClassName = TABLE_PREFIX + className;
            if (!this.realm.sharedRealm.hasTable(internalClassName)) {
                return null;
            }
            Table table = this.realm.sharedRealm.getTable(internalClassName);
            return new RealmObjectSchema(this.realm, table, new RealmObjectSchema.DynamicColumnMap(table));
        } else if (contains(className)) {
            return this.dynamicClassToSchema.get(className);
        } else {
            return null;
        }
    }

    public Set<RealmObjectSchema> getAll() {
        if (this.realm == null) {
            long[] ptrs = nativeGetAll(this.nativePtr);
            Set<RealmObjectSchema> schemas = new LinkedHashSet<>(ptrs.length);
            for (long realmObjectSchema : ptrs) {
                schemas.add(new RealmObjectSchema(realmObjectSchema));
            }
            return schemas;
        }
        int tableCount = (int) this.realm.sharedRealm.size();
        Set<RealmObjectSchema> schemas2 = new LinkedHashSet<>(tableCount);
        for (int i = 0; i < tableCount; i++) {
            String tableName = this.realm.sharedRealm.getTableName(i);
            if (Table.isModelTable(tableName)) {
                Table table = this.realm.sharedRealm.getTable(tableName);
                schemas2.add(new RealmObjectSchema(this.realm, table, new RealmObjectSchema.DynamicColumnMap(table)));
            }
        }
        return schemas2;
    }

    public RealmObjectSchema create(String className) {
        checkEmpty(className, EMPTY_STRING_MSG);
        if (this.realm == null) {
            RealmObjectSchema realmObjectSchema = new RealmObjectSchema(className);
            this.dynamicClassToSchema.put(className, realmObjectSchema);
            return realmObjectSchema;
        }
        String internalTableName = TABLE_PREFIX + className;
        if (internalTableName.length() > 56) {
            throw new IllegalArgumentException("Class name is too long. Limit is 56 characters: " + className.length());
        } else if (this.realm.sharedRealm.hasTable(internalTableName)) {
            throw new IllegalArgumentException("Class already exists: " + className);
        } else {
            Table table = this.realm.sharedRealm.getTable(internalTableName);
            return new RealmObjectSchema(this.realm, table, new RealmObjectSchema.DynamicColumnMap(table));
        }
    }

    public void remove(String className) {
        this.realm.checkNotInSync();
        checkEmpty(className, EMPTY_STRING_MSG);
        String internalTableName = TABLE_PREFIX + className;
        checkHasTable(className, "Cannot remove class because it is not in this Realm: " + className);
        Table table = getTable(className);
        if (table.hasPrimaryKey()) {
            table.setPrimaryKey((String) null);
        }
        this.realm.sharedRealm.removeTable(internalTableName);
    }

    public RealmObjectSchema rename(String oldClassName, String newClassName) {
        this.realm.checkNotInSync();
        checkEmpty(oldClassName, "Class names cannot be empty or null");
        checkEmpty(newClassName, "Class names cannot be empty or null");
        String oldInternalName = TABLE_PREFIX + oldClassName;
        String newInternalName = TABLE_PREFIX + newClassName;
        checkHasTable(oldClassName, "Cannot rename class because it doesn't exist in this Realm: " + oldClassName);
        if (this.realm.sharedRealm.hasTable(newInternalName)) {
            throw new IllegalArgumentException(oldClassName + " cannot be renamed because the new class already exists: " + newClassName);
        }
        Table oldTable = getTable(oldClassName);
        String pkField = null;
        if (oldTable.hasPrimaryKey()) {
            pkField = oldTable.getColumnName(oldTable.getPrimaryKey());
            oldTable.setPrimaryKey((String) null);
        }
        this.realm.sharedRealm.renameTable(oldInternalName, newInternalName);
        Table table = this.realm.sharedRealm.getTable(newInternalName);
        if (pkField != null) {
            table.setPrimaryKey(pkField);
        }
        return new RealmObjectSchema(this.realm, table, new RealmObjectSchema.DynamicColumnMap(table));
    }

    public boolean contains(String className) {
        if (this.realm == null) {
            return this.dynamicClassToSchema.containsKey(className);
        }
        return this.realm.sharedRealm.hasTable(Table.TABLE_PREFIX + className);
    }

    private void checkEmpty(String str, String error) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException(error);
        }
    }

    private void checkHasTable(String className, String errorMsg) {
        if (!this.realm.sharedRealm.hasTable(TABLE_PREFIX + className)) {
            throw new IllegalArgumentException(errorMsg);
        }
    }

    /* access modifiers changed from: package-private */
    public ColumnInfo getColumnInfo(Class<? extends RealmModel> clazz) {
        ColumnInfo columnInfo = this.columnIndices.getColumnInfo(clazz);
        if (columnInfo != null) {
            return columnInfo;
        }
        throw new IllegalStateException("No validated schema information found for " + this.realm.configuration.getSchemaMediator().getTableName(clazz));
    }

    /* access modifiers changed from: package-private */
    public Table getTable(String className) {
        String className2 = Table.TABLE_PREFIX + className;
        Table table = this.dynamicClassToTable.get(className2);
        if (table != null) {
            return table;
        }
        if (!this.realm.sharedRealm.hasTable(className2)) {
            throw new IllegalArgumentException("The class " + className2 + " doesn't exist in this Realm.");
        }
        Table table2 = this.realm.sharedRealm.getTable(className2);
        this.dynamicClassToTable.put(className2, table2);
        return table2;
    }

    /* access modifiers changed from: package-private */
    public Table getTable(Class<? extends RealmModel> clazz) {
        Table table = this.classToTable.get(clazz);
        if (table == null) {
            Class<? extends RealmModel> originalClass = Util.getOriginalModelClass(clazz);
            if (isProxyClass(originalClass, clazz)) {
                table = this.classToTable.get(originalClass);
            }
            if (table == null) {
                table = this.realm.sharedRealm.getTable(this.realm.configuration.getSchemaMediator().getTableName(originalClass));
                this.classToTable.put(originalClass, table);
            }
            if (isProxyClass(originalClass, clazz)) {
                this.classToTable.put(clazz, table);
            }
        }
        return table;
    }

    /* access modifiers changed from: package-private */
    public RealmObjectSchema getSchemaForClass(Class<? extends RealmModel> clazz) {
        RealmObjectSchema classSchema = this.classToSchema.get(clazz);
        if (classSchema == null) {
            Class<? extends RealmModel> originalClass = Util.getOriginalModelClass(clazz);
            if (isProxyClass(originalClass, clazz)) {
                classSchema = this.classToSchema.get(originalClass);
            }
            if (classSchema == null) {
                classSchema = new RealmObjectSchema(this.realm, getTable(clazz), this.columnIndices.getColumnInfo(originalClass).getIndicesMap());
                this.classToSchema.put(originalClass, classSchema);
            }
            if (isProxyClass(originalClass, clazz)) {
                this.classToSchema.put(clazz, classSchema);
            }
        }
        return classSchema;
    }

    private static boolean isProxyClass(Class<? extends RealmModel> modelClass, Class<? extends RealmModel> testee) {
        return modelClass != testee;
    }

    /* access modifiers changed from: package-private */
    public RealmObjectSchema getSchemaForClass(String className) {
        String className2 = Table.TABLE_PREFIX + className;
        RealmObjectSchema dynamicSchema = this.dynamicClassToSchema.get(className2);
        if (dynamicSchema != null) {
            return dynamicSchema;
        }
        if (!this.realm.sharedRealm.hasTable(className2)) {
            throw new IllegalArgumentException("The class " + className2 + " doesn't exist in this Realm.");
        }
        Table table = this.realm.sharedRealm.getTable(className2);
        RealmObjectSchema dynamicSchema2 = new RealmObjectSchema(this.realm, table, new RealmObjectSchema.DynamicColumnMap(table));
        this.dynamicClassToSchema.put(className2, dynamicSchema2);
        return dynamicSchema2;
    }

    static String getSchemaForTable(Table table) {
        return table.getName().substring(Table.TABLE_PREFIX.length());
    }
}
