package p006io.realm.internal;

import java.util.Arrays;
import p006io.realm.RealmFieldType;

/* renamed from: io.realm.internal.FieldDescriptor */
public class FieldDescriptor {
    private long[] columnIndices;
    private String fieldName;
    private RealmFieldType fieldType;
    private boolean searchIndex;

    public FieldDescriptor(Table table, String fieldDescription, boolean allowLink, boolean allowList) {
        if (fieldDescription == null || fieldDescription.isEmpty()) {
            throw new IllegalArgumentException("Non-empty field name must be provided");
        } else if (fieldDescription.startsWith(".") || fieldDescription.endsWith(".")) {
            throw new IllegalArgumentException("Illegal field name. It cannot start or end with a '.': " + fieldDescription);
        } else if (fieldDescription.contains(".")) {
            String[] names = fieldDescription.split("\\.");
            long[] columnIndices2 = new long[names.length];
            int i = 0;
            while (i < names.length - 1) {
                long index = table.getColumnIndex(names[i]);
                if (index == -1) {
                    throw new IllegalArgumentException(String.format("Invalid field name: '%s' does not refer to a class.", new Object[]{names[i]}));
                }
                RealmFieldType type = table.getColumnType(index);
                if (!allowLink && type == RealmFieldType.OBJECT) {
                    throw new IllegalArgumentException(String.format("'RealmObject' field '%s' is not a supported link field here.", new Object[]{names[i]}));
                } else if (!allowList && type == RealmFieldType.LIST) {
                    throw new IllegalArgumentException(String.format("'RealmList' field '%s' is not a supported link field here.", new Object[]{names[i]}));
                } else if (type == RealmFieldType.OBJECT || type == RealmFieldType.LIST) {
                    table = table.getLinkTarget(index);
                    columnIndices2[i] = index;
                    i++;
                } else {
                    throw new IllegalArgumentException(String.format("Invalid field name: '%s' does not refer to a class.", new Object[]{names[i]}));
                }
            }
            String columnName = names[names.length - 1];
            long columnIndex = table.getColumnIndex(columnName);
            columnIndices2[names.length - 1] = columnIndex;
            if (columnIndex == -1) {
                throw new IllegalArgumentException(String.format("'%s' is not a field name in class '%s'.", new Object[]{columnName, table.getName()}));
            }
            this.fieldType = table.getColumnType(columnIndex);
            this.fieldName = columnName;
            this.columnIndices = columnIndices2;
            this.searchIndex = table.hasSearchIndex(columnIndex);
        } else {
            long fieldIndex = table.getColumnIndex(fieldDescription);
            if (fieldIndex == -1) {
                throw new IllegalArgumentException(String.format("Field '%s' does not exist.", new Object[]{fieldDescription}));
            }
            this.fieldType = table.getColumnType(fieldIndex);
            this.fieldName = fieldDescription;
            this.columnIndices = new long[]{fieldIndex};
            this.searchIndex = table.hasSearchIndex(fieldIndex);
        }
    }

    public long[] getColumnIndices() {
        return Arrays.copyOf(this.columnIndices, this.columnIndices.length);
    }

    public RealmFieldType getFieldType() {
        return this.fieldType;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public boolean hasSearchIndex() {
        return this.searchIndex;
    }
}
