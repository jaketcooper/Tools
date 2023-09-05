package p006io.realm;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import p006io.realm.internal.Table;

/* renamed from: io.realm.RealmObjectSchema */
public class RealmObjectSchema {
    private static final Map<Class<?>, FieldMetaData> SUPPORTED_LINKED_FIELDS = new HashMap();
    private static final Map<Class<?>, FieldMetaData> SUPPORTED_SIMPLE_FIELDS = new HashMap();
    private final Map<String, Long> columnIndices;
    private final long nativePtr;
    private final BaseRealm realm;
    final Table table;

    /* renamed from: io.realm.RealmObjectSchema$Function */
    public interface Function {
        void apply(DynamicRealmObject dynamicRealmObject);
    }

    static native void nativeAddProperty(long j, long j2);

    static native void nativeClose(long j);

    static native long nativeCreateRealmObjectSchema(String str);

    static native String nativeGetClassName(long j);

    static native long[] nativeGetProperties(long j);

    static {
        SUPPORTED_SIMPLE_FIELDS.put(String.class, new FieldMetaData(RealmFieldType.STRING, true));
        SUPPORTED_SIMPLE_FIELDS.put(Short.TYPE, new FieldMetaData(RealmFieldType.INTEGER, false));
        SUPPORTED_SIMPLE_FIELDS.put(Short.class, new FieldMetaData(RealmFieldType.INTEGER, true));
        SUPPORTED_SIMPLE_FIELDS.put(Integer.TYPE, new FieldMetaData(RealmFieldType.INTEGER, false));
        SUPPORTED_SIMPLE_FIELDS.put(Integer.class, new FieldMetaData(RealmFieldType.INTEGER, true));
        SUPPORTED_SIMPLE_FIELDS.put(Long.TYPE, new FieldMetaData(RealmFieldType.INTEGER, false));
        SUPPORTED_SIMPLE_FIELDS.put(Long.class, new FieldMetaData(RealmFieldType.INTEGER, true));
        SUPPORTED_SIMPLE_FIELDS.put(Float.TYPE, new FieldMetaData(RealmFieldType.FLOAT, false));
        SUPPORTED_SIMPLE_FIELDS.put(Float.class, new FieldMetaData(RealmFieldType.FLOAT, true));
        SUPPORTED_SIMPLE_FIELDS.put(Double.TYPE, new FieldMetaData(RealmFieldType.DOUBLE, false));
        SUPPORTED_SIMPLE_FIELDS.put(Double.class, new FieldMetaData(RealmFieldType.DOUBLE, true));
        SUPPORTED_SIMPLE_FIELDS.put(Boolean.TYPE, new FieldMetaData(RealmFieldType.BOOLEAN, false));
        SUPPORTED_SIMPLE_FIELDS.put(Boolean.class, new FieldMetaData(RealmFieldType.BOOLEAN, true));
        SUPPORTED_SIMPLE_FIELDS.put(Byte.TYPE, new FieldMetaData(RealmFieldType.INTEGER, false));
        SUPPORTED_SIMPLE_FIELDS.put(Byte.class, new FieldMetaData(RealmFieldType.INTEGER, true));
        SUPPORTED_SIMPLE_FIELDS.put(byte[].class, new FieldMetaData(RealmFieldType.BINARY, true));
        SUPPORTED_SIMPLE_FIELDS.put(Date.class, new FieldMetaData(RealmFieldType.DATE, true));
        SUPPORTED_LINKED_FIELDS.put(RealmObject.class, new FieldMetaData(RealmFieldType.OBJECT, false));
        SUPPORTED_LINKED_FIELDS.put(RealmList.class, new FieldMetaData(RealmFieldType.LIST, false));
    }

    RealmObjectSchema(BaseRealm realm2, Table table2, Map<String, Long> columnIndices2) {
        this.realm = realm2;
        this.table = table2;
        this.columnIndices = columnIndices2;
        this.nativePtr = 0;
    }

    RealmObjectSchema(String className) {
        this.realm = null;
        this.table = null;
        this.columnIndices = null;
        this.nativePtr = nativeCreateRealmObjectSchema(className);
    }

    protected RealmObjectSchema(long nativePtr2) {
        this.realm = null;
        this.table = null;
        this.columnIndices = null;
        this.nativePtr = nativePtr2;
    }

    public void close() {
        if (this.nativePtr != 0) {
            for (Property property : getProperties()) {
                property.close();
            }
            nativeClose(this.nativePtr);
        }
    }

    /* access modifiers changed from: protected */
    public long getNativePtr() {
        return this.nativePtr;
    }

    public String getClassName() {
        if (this.realm == null) {
            return nativeGetClassName(this.nativePtr);
        }
        return this.table.getName().substring(Table.TABLE_PREFIX.length());
    }

    public RealmObjectSchema setClassName(String className) {
        this.realm.checkNotInSync();
        checkEmpty(className);
        String internalTableName = Table.TABLE_PREFIX + className;
        if (internalTableName.length() > 56) {
            throw new IllegalArgumentException("Class name is too long. Limit is 56 characters: '" + className + "' (" + Integer.toString(className.length()) + ")");
        } else if (this.realm.sharedRealm.hasTable(internalTableName)) {
            throw new IllegalArgumentException("Class already exists: " + className);
        } else {
            String oldTableName = null;
            String pkField = null;
            if (this.table.hasPrimaryKey()) {
                oldTableName = this.table.getName();
                pkField = getPrimaryKey();
                this.table.setPrimaryKey((String) null);
            }
            this.realm.sharedRealm.renameTable(this.table.getName(), internalTableName);
            if (pkField != null && !pkField.isEmpty()) {
                try {
                    this.table.setPrimaryKey(pkField);
                } catch (Exception e) {
                    this.realm.sharedRealm.renameTable(this.table.getName(), oldTableName);
                    throw e;
                }
            }
            return this;
        }
    }

    public RealmObjectSchema addField(String fieldName, Class<?> fieldType, FieldAttribute... attributes) {
        FieldMetaData metadata = SUPPORTED_SIMPLE_FIELDS.get(fieldType);
        if (metadata != null) {
            checkNewFieldName(fieldName);
            boolean nullable = metadata.defaultNullable;
            if (containsAttribute(attributes, FieldAttribute.REQUIRED)) {
                nullable = false;
            }
            long columnIndex = this.table.addColumn(metadata.realmType, fieldName, nullable);
            try {
                addModifiers(fieldName, attributes);
                return this;
            } catch (Exception e) {
                this.table.removeColumn(columnIndex);
                throw e;
            }
        } else if (SUPPORTED_LINKED_FIELDS.containsKey(fieldType)) {
            throw new IllegalArgumentException("Use addRealmObjectField() instead to add fields that link to other RealmObjects: " + fieldName);
        } else {
            throw new IllegalArgumentException(String.format("Realm doesn't support this field type: %s(%s)", new Object[]{fieldName, fieldType}));
        }
    }

    public RealmObjectSchema addRealmObjectField(String fieldName, RealmObjectSchema objectSchema) {
        checkLegalName(fieldName);
        checkFieldNameIsAvailable(fieldName);
        this.table.addColumnLink(RealmFieldType.OBJECT, fieldName, this.realm.sharedRealm.getTable(Table.TABLE_PREFIX + objectSchema.getClassName()));
        return this;
    }

    public RealmObjectSchema addRealmListField(String fieldName, RealmObjectSchema objectSchema) {
        checkLegalName(fieldName);
        checkFieldNameIsAvailable(fieldName);
        this.table.addColumnLink(RealmFieldType.LIST, fieldName, this.realm.sharedRealm.getTable(Table.TABLE_PREFIX + objectSchema.getClassName()));
        return this;
    }

    /* access modifiers changed from: protected */
    public RealmObjectSchema add(Property property) {
        if (this.realm == null || this.nativePtr != 0) {
            nativeAddProperty(this.nativePtr, property.getNativePtr());
            return this;
        }
        throw new IllegalArgumentException("Don't use this method.");
    }

    private Set<Property> getProperties() {
        if (this.realm == null) {
            long[] ptrs = nativeGetProperties(this.nativePtr);
            Set<Property> properties = new LinkedHashSet<>(ptrs.length);
            for (long property : ptrs) {
                properties.add(new Property(property));
            }
            return properties;
        }
        throw new IllegalArgumentException("Not possible");
    }

    public RealmObjectSchema removeField(String fieldName) {
        this.realm.checkNotInSync();
        checkLegalName(fieldName);
        if (!hasField(fieldName)) {
            throw new IllegalStateException(fieldName + " does not exist.");
        }
        long columnIndex = getColumnIndex(fieldName);
        if (this.table.getPrimaryKey() == columnIndex) {
            this.table.setPrimaryKey((String) null);
        }
        this.table.removeColumn(columnIndex);
        return this;
    }

    public RealmObjectSchema renameField(String currentFieldName, String newFieldName) {
        this.realm.checkNotInSync();
        checkLegalName(currentFieldName);
        checkFieldExists(currentFieldName);
        checkLegalName(newFieldName);
        checkFieldNameIsAvailable(newFieldName);
        this.table.renameColumn(getColumnIndex(currentFieldName), newFieldName);
        return this;
    }

    public boolean hasField(String fieldName) {
        return this.table.getColumnIndex(fieldName) != -1;
    }

    public RealmObjectSchema addIndex(String fieldName) {
        checkLegalName(fieldName);
        checkFieldExists(fieldName);
        long columnIndex = getColumnIndex(fieldName);
        if (this.table.hasSearchIndex(columnIndex)) {
            throw new IllegalStateException(fieldName + " already has an index.");
        }
        this.table.addSearchIndex(columnIndex);
        return this;
    }

    public boolean hasIndex(String fieldName) {
        checkLegalName(fieldName);
        checkFieldExists(fieldName);
        return this.table.hasSearchIndex(this.table.getColumnIndex(fieldName));
    }

    public RealmObjectSchema removeIndex(String fieldName) {
        this.realm.checkNotInSync();
        checkLegalName(fieldName);
        checkFieldExists(fieldName);
        long columnIndex = getColumnIndex(fieldName);
        if (!this.table.hasSearchIndex(columnIndex)) {
            throw new IllegalStateException("Field is not indexed: " + fieldName);
        }
        this.table.removeSearchIndex(columnIndex);
        return this;
    }

    public RealmObjectSchema addPrimaryKey(String fieldName) {
        checkLegalName(fieldName);
        checkFieldExists(fieldName);
        if (this.table.hasPrimaryKey()) {
            throw new IllegalStateException("A primary key is already defined");
        }
        this.table.setPrimaryKey(fieldName);
        long columnIndex = getColumnIndex(fieldName);
        if (!this.table.hasSearchIndex(columnIndex)) {
            this.table.addSearchIndex(columnIndex);
        }
        return this;
    }

    public RealmObjectSchema removePrimaryKey() {
        this.realm.checkNotInSync();
        if (!this.table.hasPrimaryKey()) {
            throw new IllegalStateException(getClassName() + " doesn't have a primary key.");
        }
        long columnIndex = this.table.getPrimaryKey();
        if (this.table.hasSearchIndex(columnIndex)) {
            this.table.removeSearchIndex(columnIndex);
        }
        this.table.setPrimaryKey("");
        return this;
    }

    public RealmObjectSchema setRequired(String fieldName, boolean required) {
        long columnIndex = this.table.getColumnIndex(fieldName);
        boolean currentColumnRequired = isRequired(fieldName);
        RealmFieldType type = this.table.getColumnType(columnIndex);
        if (type == RealmFieldType.OBJECT) {
            throw new IllegalArgumentException("Cannot modify the required state for RealmObject references: " + fieldName);
        } else if (type == RealmFieldType.LIST) {
            throw new IllegalArgumentException("Cannot modify the required state for RealmList references: " + fieldName);
        } else if (required && currentColumnRequired) {
            throw new IllegalStateException("Field is already required: " + fieldName);
        } else if (required || currentColumnRequired) {
            if (required) {
                this.table.convertColumnToNotNullable(columnIndex);
            } else {
                this.table.convertColumnToNullable(columnIndex);
            }
            return this;
        } else {
            throw new IllegalStateException("Field is already nullable: " + fieldName);
        }
    }

    public RealmObjectSchema setNullable(String fieldName, boolean nullable) {
        setRequired(fieldName, !nullable);
        return this;
    }

    public boolean isRequired(String fieldName) {
        return !this.table.isColumnNullable(getColumnIndex(fieldName));
    }

    public boolean isNullable(String fieldName) {
        return this.table.isColumnNullable(getColumnIndex(fieldName));
    }

    public boolean isPrimaryKey(String fieldName) {
        return getColumnIndex(fieldName) == this.table.getPrimaryKey();
    }

    public boolean hasPrimaryKey() {
        return this.table.hasPrimaryKey();
    }

    public String getPrimaryKey() {
        if (this.table.hasPrimaryKey()) {
            return this.table.getColumnName(this.table.getPrimaryKey());
        }
        throw new IllegalStateException(getClassName() + " doesn't have a primary key.");
    }

    public Set<String> getFieldNames() {
        int columnCount = (int) this.table.getColumnCount();
        Set<String> columnNames = new LinkedHashSet<>(columnCount);
        for (int i = 0; i < columnCount; i++) {
            columnNames.add(this.table.getColumnName((long) i));
        }
        return columnNames;
    }

    public RealmObjectSchema transform(Function function) {
        if (function != null) {
            long size = this.table.size();
            for (long i = 0; i < size; i++) {
                function.apply(new DynamicRealmObject(this.realm, this.table.getCheckedRow(i)));
            }
        }
        return this;
    }

    private void addModifiers(String fieldName, FieldAttribute[] attributes) {
        if (attributes != null) {
            try {
                if (attributes.length > 0) {
                    if (containsAttribute(attributes, FieldAttribute.INDEXED)) {
                        addIndex(fieldName);
                    }
                    if (containsAttribute(attributes, FieldAttribute.PRIMARY_KEY)) {
                        addPrimaryKey(fieldName);
                    }
                }
            } catch (Exception e) {
                long columnIndex = getColumnIndex(fieldName);
                if (0 != 0) {
                    this.table.removeSearchIndex(columnIndex);
                }
                throw e;
            }
        }
    }

    private boolean containsAttribute(FieldAttribute[] attributeList, FieldAttribute attribute) {
        if (attributeList == null || attributeList.length == 0) {
            return false;
        }
        for (FieldAttribute fieldAttribute : attributeList) {
            if (fieldAttribute == attribute) {
                return true;
            }
        }
        return false;
    }

    private void checkNewFieldName(String fieldName) {
        checkLegalName(fieldName);
        checkFieldNameIsAvailable(fieldName);
    }

    private void checkLegalName(String fieldName) {
        if (fieldName == null || fieldName.isEmpty()) {
            throw new IllegalArgumentException("Field name can not be null or empty");
        } else if (fieldName.contains(".")) {
            throw new IllegalArgumentException("Field name can not contain '.'");
        }
    }

    private void checkFieldNameIsAvailable(String fieldName) {
        if (this.table.getColumnIndex(fieldName) != -1) {
            throw new IllegalArgumentException("Field already exists in '" + getClassName() + "': " + fieldName);
        }
    }

    private void checkFieldExists(String fieldName) {
        if (this.table.getColumnIndex(fieldName) == -1) {
            throw new IllegalArgumentException("Field name doesn't exist on object '" + getClassName() + "': " + fieldName);
        }
    }

    private long getColumnIndex(String fieldName) {
        long columnIndex = this.table.getColumnIndex(fieldName);
        if (columnIndex != -1) {
            return columnIndex;
        }
        throw new IllegalArgumentException(String.format("Field name '%s' does not exist on schema for '%s", new Object[]{fieldName, getClassName()}));
    }

    private void checkEmpty(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Null or empty class names are not allowed");
        }
    }

    /* access modifiers changed from: package-private */
    public long[] getColumnIndices(String fieldDescription, RealmFieldType... validColumnTypes) {
        if (fieldDescription == null || fieldDescription.equals("")) {
            throw new IllegalArgumentException("Non-empty fieldname must be provided");
        } else if (fieldDescription.startsWith(".") || fieldDescription.endsWith(".")) {
            throw new IllegalArgumentException("Illegal field name. It cannot start or end with a '.': " + fieldDescription);
        } else {
            Table table2 = this.table;
            boolean checkColumnType = validColumnTypes != null && validColumnTypes.length > 0;
            if (fieldDescription.contains(".")) {
                String[] names = fieldDescription.split("\\.");
                long[] columnIndices2 = new long[names.length];
                int i = 0;
                while (i < names.length - 1) {
                    long index = table2.getColumnIndex(names[i]);
                    if (index < 0) {
                        throw new IllegalArgumentException("Invalid query: " + names[i] + " does not refer to a class.");
                    }
                    RealmFieldType type = table2.getColumnType(index);
                    if (type == RealmFieldType.OBJECT || type == RealmFieldType.LIST) {
                        table2 = table2.getLinkTarget(index);
                        columnIndices2[i] = index;
                        i++;
                    } else {
                        throw new IllegalArgumentException("Invalid query: " + names[i] + " does not refer to a class.");
                    }
                }
                String columnName = names[names.length - 1];
                long columnIndex = table2.getColumnIndex(columnName);
                columnIndices2[names.length - 1] = columnIndex;
                if (columnIndex < 0) {
                    throw new IllegalArgumentException(columnName + " is not a field name in class " + table2.getName());
                } else if (!checkColumnType) {
                    return columnIndices2;
                } else {
                    if (isValidType(table2.getColumnType(columnIndex), validColumnTypes)) {
                        return columnIndices2;
                    }
                    throw new IllegalArgumentException(String.format("Field '%s': type mismatch.", new Object[]{names[names.length - 1]}));
                }
            } else {
                Long fieldIndex = getFieldIndex(fieldDescription);
                if (fieldIndex == null) {
                    throw new IllegalArgumentException(String.format("Field '%s' does not exist.", new Object[]{fieldDescription}));
                }
                RealmFieldType tableColumnType = table2.getColumnType(fieldIndex.longValue());
                if (!checkColumnType || isValidType(tableColumnType, validColumnTypes)) {
                    return new long[]{fieldIndex.longValue()};
                }
                throw new IllegalArgumentException(String.format("Field '%s': type mismatch. Was %s, expected %s.", new Object[]{fieldDescription, tableColumnType, Arrays.toString(validColumnTypes)}));
            }
        }
    }

    private boolean isValidType(RealmFieldType columnType, RealmFieldType[] validColumnTypes) {
        for (RealmFieldType realmFieldType : validColumnTypes) {
            if (realmFieldType == columnType) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Long getFieldIndex(String fieldName) {
        return this.columnIndices.get(fieldName);
    }

    /* access modifiers changed from: package-private */
    public long getAndCheckFieldIndex(String fieldName) {
        Long index = this.columnIndices.get(fieldName);
        if (index != null) {
            return index.longValue();
        }
        throw new IllegalArgumentException("Field does not exist: " + fieldName);
    }

    public RealmFieldType getFieldType(String fieldName) {
        return this.table.getColumnType(getColumnIndex(fieldName));
    }

    /* renamed from: io.realm.RealmObjectSchema$FieldMetaData */
    private static class FieldMetaData {
        public final boolean defaultNullable;
        public final RealmFieldType realmType;

        public FieldMetaData(RealmFieldType realmType2, boolean defaultNullable2) {
            this.realmType = realmType2;
            this.defaultNullable = defaultNullable2;
        }
    }

    /* renamed from: io.realm.RealmObjectSchema$DynamicColumnMap */
    static final class DynamicColumnMap implements Map<String, Long> {
        private final Table table;

        public DynamicColumnMap(Table table2) {
            this.table = table2;
        }

        public Long get(Object key) {
            long ret = this.table.getColumnIndex((String) key);
            if (ret < 0) {
                return null;
            }
            return Long.valueOf(ret);
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public boolean containsKey(Object key) {
            throw new UnsupportedOperationException();
        }

        public boolean containsValue(Object value) {
            throw new UnsupportedOperationException();
        }

        public Set<Map.Entry<String, Long>> entrySet() {
            throw new UnsupportedOperationException();
        }

        public boolean isEmpty() {
            throw new UnsupportedOperationException();
        }

        public Set<String> keySet() {
            throw new UnsupportedOperationException();
        }

        public Long put(String key, Long value) {
            throw new UnsupportedOperationException();
        }

        public void putAll(Map<? extends String, ? extends Long> map) {
            throw new UnsupportedOperationException();
        }

        public Long remove(Object key) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            throw new UnsupportedOperationException();
        }

        public Collection<Long> values() {
            throw new UnsupportedOperationException();
        }
    }
}
