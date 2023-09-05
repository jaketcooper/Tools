package p006io.realm.internal;

import java.util.Arrays;
import java.util.List;
import p006io.realm.RealmFieldType;
import p006io.realm.Sort;

@KeepMember
/* renamed from: io.realm.internal.SortDescriptor */
public class SortDescriptor {
    static final List<RealmFieldType> validFieldTypesForDistinct = Arrays.asList(new RealmFieldType[]{RealmFieldType.BOOLEAN, RealmFieldType.INTEGER, RealmFieldType.STRING, RealmFieldType.DATE});
    static final List<RealmFieldType> validFieldTypesForSort = Arrays.asList(new RealmFieldType[]{RealmFieldType.BOOLEAN, RealmFieldType.INTEGER, RealmFieldType.FLOAT, RealmFieldType.DOUBLE, RealmFieldType.STRING, RealmFieldType.DATE});
    private final boolean[] ascendings;
    private final long[][] columnIndices;
    private final Table table;

    SortDescriptor(Table table2, long[] columnIndices2) {
        this(table2, new long[][]{columnIndices2}, (Sort[]) null);
    }

    private SortDescriptor(Table table2, long[][] columnIndices2, Sort[] sortOrders) {
        if (sortOrders != null) {
            this.ascendings = new boolean[sortOrders.length];
            for (int i = 0; i < sortOrders.length; i++) {
                this.ascendings[i] = sortOrders[i].getValue();
            }
        } else {
            this.ascendings = null;
        }
        this.columnIndices = columnIndices2;
        this.table = table2;
    }

    public static SortDescriptor getInstanceForSort(Table table2, String fieldDescription, Sort sortOrder) {
        return getInstanceForSort(table2, new String[]{fieldDescription}, new Sort[]{sortOrder});
    }

    public static SortDescriptor getInstanceForSort(Table table2, String[] fieldDescriptions, Sort[] sortOrders) {
        if (fieldDescriptions == null || fieldDescriptions.length == 0) {
            throw new IllegalArgumentException("You must provide at least one field name.");
        } else if (sortOrders == null || sortOrders.length == 0) {
            throw new IllegalArgumentException("You must provide at least one sort order.");
        } else if (fieldDescriptions.length != sortOrders.length) {
            throw new IllegalArgumentException("Number of fields and sort orders do not match.");
        } else {
            long[][] columnIndices2 = new long[fieldDescriptions.length][];
            for (int i = 0; i < fieldDescriptions.length; i++) {
                FieldDescriptor descriptor = new FieldDescriptor(table2, fieldDescriptions[i], true, false);
                checkFieldTypeForSort(descriptor, fieldDescriptions[i]);
                columnIndices2[i] = descriptor.getColumnIndices();
            }
            return new SortDescriptor(table2, columnIndices2, sortOrders);
        }
    }

    public static SortDescriptor getInstanceForDistinct(Table table2, String fieldDescription) {
        return getInstanceForDistinct(table2, new String[]{fieldDescription});
    }

    public static SortDescriptor getInstanceForDistinct(Table table2, String[] fieldDescriptions) {
        if (fieldDescriptions == null || fieldDescriptions.length == 0) {
            throw new IllegalArgumentException("You must provide at least one field name.");
        }
        long[][] columnIndices2 = new long[fieldDescriptions.length][];
        for (int i = 0; i < fieldDescriptions.length; i++) {
            FieldDescriptor descriptor = new FieldDescriptor(table2, fieldDescriptions[i], false, false);
            checkFieldTypeForDistinct(descriptor, fieldDescriptions[i]);
            columnIndices2[i] = descriptor.getColumnIndices();
        }
        return new SortDescriptor(table2, columnIndices2, (Sort[]) null);
    }

    private static void checkFieldTypeForSort(FieldDescriptor descriptor, String fieldDescriptions) {
        if (!validFieldTypesForSort.contains(descriptor.getFieldType())) {
            throw new IllegalArgumentException(String.format("Sort is not supported on '%s' field '%s' in '%s'.", new Object[]{descriptor.toString(), descriptor.getFieldName(), fieldDescriptions}));
        }
    }

    private static void checkFieldTypeForDistinct(FieldDescriptor descriptor, String fieldDescriptions) {
        if (!validFieldTypesForDistinct.contains(descriptor.getFieldType())) {
            throw new IllegalArgumentException(String.format("Distinct is not supported on '%s' field '%s' in '%s'.", new Object[]{descriptor.getFieldType().toString(), descriptor.getFieldName(), fieldDescriptions}));
        } else if (!descriptor.hasSearchIndex()) {
            throw new IllegalArgumentException(String.format("Field '%s' in '%s' must be indexed in order to use it for distinct queries.", new Object[]{descriptor.getFieldName(), fieldDescriptions}));
        }
    }

    /* access modifiers changed from: package-private */
    @KeepMember
    public long[][] getColumnIndices() {
        return this.columnIndices;
    }

    /* access modifiers changed from: package-private */
    @KeepMember
    public boolean[] getAscendings() {
        return this.ascendings;
    }

    @KeepMember
    private long getTablePtr() {
        return this.table.getNativePtr();
    }
}
