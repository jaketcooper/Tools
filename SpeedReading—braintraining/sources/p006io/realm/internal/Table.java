package p006io.realm.internal;

import java.util.Date;
import p006io.realm.RealmFieldType;
import p006io.realm.exceptions.RealmException;
import p006io.realm.exceptions.RealmPrimaryKeyConstraintException;

/* renamed from: io.realm.internal.Table */
public class Table implements TableSchema, NativeObject {
    public static final long INFINITE = -1;
    public static final boolean NOT_NULLABLE = false;
    public static final int NO_MATCH = -1;
    private static final long NO_PRIMARY_KEY = -2;
    public static final boolean NULLABLE = true;
    private static final long PRIMARY_KEY_CLASS_COLUMN_INDEX = 0;
    private static final String PRIMARY_KEY_CLASS_COLUMN_NAME = "pk_table";
    private static final long PRIMARY_KEY_FIELD_COLUMN_INDEX = 1;
    private static final String PRIMARY_KEY_FIELD_COLUMN_NAME = "pk_property";
    private static final String PRIMARY_KEY_TABLE_NAME = "pk";
    public static final int TABLE_MAX_LENGTH = 56;
    public static final String TABLE_PREFIX = Util.getTablePrefix();
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private long cachedPrimaryKeyColumnIndex;
    final Context context;
    private long nativePtr;
    private final SharedRealm sharedRealm;

    private native long nativeAddColumn(long j, int i, String str, boolean z);

    private native long nativeAddColumnLink(long j, int i, String str, long j2);

    public static native long nativeAddEmptyRow(long j, long j2);

    private native void nativeAddSearchIndex(long j, long j2);

    private native double nativeAverageDouble(long j, long j2);

    private native double nativeAverageFloat(long j, long j2);

    private native double nativeAverageInt(long j, long j2);

    private native void nativeClear(long j);

    private native void nativeConvertColumnToNotNullable(long j, long j2);

    private native void nativeConvertColumnToNullable(long j, long j2);

    private native long nativeCountDouble(long j, long j2, double d);

    private native long nativeCountFloat(long j, long j2, float f);

    private native long nativeCountLong(long j, long j2, long j3);

    private native long nativeCountString(long j, long j2, String str);

    private native long nativeFindFirstBool(long j, long j2, boolean z);

    private native long nativeFindFirstDouble(long j, long j2, double d);

    private native long nativeFindFirstFloat(long j, long j2, float f);

    public static native long nativeFindFirstInt(long j, long j2, long j3);

    public static native long nativeFindFirstNull(long j, long j2);

    public static native long nativeFindFirstString(long j, long j2, String str);

    private native long nativeFindFirstTimestamp(long j, long j2, long j3);

    private native boolean nativeGetBoolean(long j, long j2, long j3);

    private native byte[] nativeGetByteArray(long j, long j2, long j3);

    private native long nativeGetColumnCount(long j);

    private native long nativeGetColumnIndex(long j, String str);

    private native String nativeGetColumnName(long j, long j2);

    private native int nativeGetColumnType(long j, long j2);

    private native double nativeGetDouble(long j, long j2, long j3);

    private static native long nativeGetFinalizerPtr();

    private native float nativeGetFloat(long j, long j2, long j3);

    private native long nativeGetLink(long j, long j2, long j3);

    private native long nativeGetLinkTarget(long j, long j2);

    public static native long nativeGetLinkView(long j, long j2, long j3);

    private native long nativeGetLong(long j, long j2, long j3);

    private native String nativeGetName(long j);

    private native long nativeGetSortedViewMulti(long j, long[] jArr, boolean[] zArr);

    private native String nativeGetString(long j, long j2, long j3);

    private native long nativeGetTimestamp(long j, long j2, long j3);

    private native boolean nativeHasSameSchema(long j, long j2);

    private native boolean nativeHasSearchIndex(long j, long j2);

    private native boolean nativeIsColumnNullable(long j, long j2);

    private native boolean nativeIsNull(long j, long j2, long j3);

    private native boolean nativeIsNullLink(long j, long j2, long j3);

    private native boolean nativeIsValid(long j);

    private native long nativeLowerBoundInt(long j, long j2, long j3);

    private native double nativeMaximumDouble(long j, long j2);

    private native float nativeMaximumFloat(long j, long j2);

    private native long nativeMaximumInt(long j, long j2);

    private native long nativeMaximumTimestamp(long j, long j2);

    private static native boolean nativeMigratePrimaryKeyTableIfNeeded(long j, long j2);

    private native double nativeMinimumDouble(long j, long j2);

    private native float nativeMinimumFloat(long j, long j2);

    private native long nativeMinimumInt(long j, long j2);

    private native long nativeMinimumTimestamp(long j, long j2);

    private native void nativeMoveLastOver(long j, long j2);

    public static native void nativeNullifyLink(long j, long j2, long j3);

    private native void nativePivot(long j, long j2, long j3, int i, long j4);

    private static native boolean nativePrimaryKeyTableNeedsMigration(long j);

    private native void nativeRemove(long j, long j2);

    private native void nativeRemoveColumn(long j, long j2);

    private native void nativeRemoveLast(long j);

    private native void nativeRemoveSearchIndex(long j, long j2);

    private native void nativeRenameColumn(long j, long j2, String str);

    public static native void nativeSetBoolean(long j, long j2, long j3, boolean z, boolean z2);

    public static native void nativeSetByteArray(long j, long j2, long j3, byte[] bArr, boolean z);

    public static native void nativeSetDouble(long j, long j2, long j3, double d, boolean z);

    public static native void nativeSetFloat(long j, long j2, long j3, float f, boolean z);

    public static native void nativeSetLink(long j, long j2, long j3, long j4, boolean z);

    public static native void nativeSetLong(long j, long j2, long j3, long j4, boolean z);

    public static native void nativeSetLongUnique(long j, long j2, long j3, long j4);

    public static native void nativeSetNull(long j, long j2, long j3, boolean z);

    public static native void nativeSetNullUnique(long j, long j2, long j3);

    private native long nativeSetPrimaryKey(long j, long j2, String str);

    public static native void nativeSetString(long j, long j2, long j3, String str, boolean z);

    public static native void nativeSetStringUnique(long j, long j2, long j3, String str);

    public static native void nativeSetTimestamp(long j, long j2, long j3, long j4, boolean z);

    private native long nativeSize(long j);

    private native double nativeSumDouble(long j, long j2);

    private native double nativeSumFloat(long j, long j2);

    private native long nativeSumInt(long j, long j2);

    private native String nativeToJson(long j);

    private native long nativeUpperBoundInt(long j, long j2, long j3);

    private native long nativeVersion(long j);

    private native long nativeWhere(long j);

    /* access modifiers changed from: protected */
    public native long createNative();

    /* access modifiers changed from: package-private */
    public native long nativeGetRowPtr(long j, long j2);

    /* renamed from: io.realm.internal.Table$PivotType */
    enum PivotType {
        COUNT(0),
        SUM(1),
        AVG(2),
        MIN(3),
        MAX(4);
        
        final int value;

        private PivotType(int value2) {
            this.value = value2;
        }
    }

    public Table() {
        this.cachedPrimaryKeyColumnIndex = -1;
        this.context = new Context();
        this.nativePtr = createNative();
        if (this.nativePtr == 0) {
            throw new OutOfMemoryError("Out of native memory.");
        }
        this.sharedRealm = null;
        this.context.addReference(this);
    }

    Table(Table parent, long nativePointer) {
        this(parent.sharedRealm, nativePointer);
    }

    Table(SharedRealm sharedRealm2, long nativePointer) {
        this.cachedPrimaryKeyColumnIndex = -1;
        this.context = sharedRealm2.context;
        this.sharedRealm = sharedRealm2;
        this.nativePtr = nativePointer;
        this.context.addReference(this);
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    public Table getTable() {
        return this;
    }

    public long getNativeTablePointer() {
        return this.nativePtr;
    }

    public boolean isValid() {
        return this.nativePtr != 0 && nativeIsValid(this.nativePtr);
    }

    private void verifyColumnName(String name) {
        if (name.length() > 63) {
            throw new IllegalArgumentException("Column names are currently limited to max 63 characters.");
        }
    }

    public long addColumn(RealmFieldType type, String name, boolean isNullable) {
        verifyColumnName(name);
        return nativeAddColumn(this.nativePtr, type.getNativeValue(), name, isNullable);
    }

    public long addColumn(RealmFieldType type, String name) {
        return addColumn(type, name, false);
    }

    public long addColumnLink(RealmFieldType type, String name, Table table) {
        verifyColumnName(name);
        return nativeAddColumnLink(this.nativePtr, type.getNativeValue(), name, table.nativePtr);
    }

    public void removeColumn(long columnIndex) {
        long oldPkColumnIndex = getPrimaryKey();
        nativeRemoveColumn(this.nativePtr, columnIndex);
        if (oldPkColumnIndex < 0) {
            return;
        }
        if (oldPkColumnIndex == columnIndex) {
            setPrimaryKey((String) null);
        } else if (oldPkColumnIndex > columnIndex) {
            invalidateCachedPrimaryKeyIndex();
        }
    }

    public void renameColumn(long columnIndex, String newName) {
        verifyColumnName(newName);
        String oldName = nativeGetColumnName(this.nativePtr, columnIndex);
        long oldPkColumnIndex = getPrimaryKey();
        nativeRenameColumn(this.nativePtr, columnIndex, newName);
        if (oldPkColumnIndex == columnIndex) {
            try {
                String className = tableNameToClassName(getName());
                Table pkTable = getPrimaryKeyTable();
                if (pkTable == null) {
                    throw new IllegalStateException("Table is not created from a SharedRealm, primary key is not available");
                }
                long pkRowIndex = pkTable.findFirstString(0, className);
                if (pkRowIndex != -1) {
                    nativeSetString(pkTable.nativePtr, 1, pkRowIndex, newName, false);
                    return;
                }
                throw new IllegalStateException("Non-existent PrimaryKey column cannot be renamed");
            } catch (Exception e) {
                nativeRenameColumn(this.nativePtr, columnIndex, oldName);
                throw e;
            }
        }
    }

    public boolean isColumnNullable(long columnIndex) {
        return nativeIsColumnNullable(this.nativePtr, columnIndex);
    }

    public void convertColumnToNullable(long columnIndex) {
        nativeConvertColumnToNullable(this.nativePtr, columnIndex);
    }

    public void convertColumnToNotNullable(long columnIndex) {
        nativeConvertColumnToNotNullable(this.nativePtr, columnIndex);
    }

    public long size() {
        return nativeSize(this.nativePtr);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        checkImmutable();
        nativeClear(this.nativePtr);
    }

    public long getColumnCount() {
        return nativeGetColumnCount(this.nativePtr);
    }

    public String getColumnName(long columnIndex) {
        return nativeGetColumnName(this.nativePtr, columnIndex);
    }

    public long getColumnIndex(String columnName) {
        if (columnName != null) {
            return nativeGetColumnIndex(this.nativePtr, columnName);
        }
        throw new IllegalArgumentException("Column name can not be null.");
    }

    public RealmFieldType getColumnType(long columnIndex) {
        return RealmFieldType.fromNativeValue(nativeGetColumnType(this.nativePtr, columnIndex));
    }

    public void remove(long rowIndex) {
        checkImmutable();
        nativeRemove(this.nativePtr, rowIndex);
    }

    public void removeFirst() {
        checkImmutable();
        remove(0);
    }

    public void removeLast() {
        checkImmutable();
        nativeRemoveLast(this.nativePtr);
    }

    public void moveLastOver(long rowIndex) {
        checkImmutable();
        nativeMoveLastOver(this.nativePtr, rowIndex);
    }

    public long addEmptyRow() {
        checkImmutable();
        return nativeAddEmptyRow(this.nativePtr, 1);
    }

    public long addEmptyRowWithPrimaryKey(Object primaryKeyValue) {
        return addEmptyRowWithPrimaryKey(primaryKeyValue, true);
    }

    public long addEmptyRowWithPrimaryKey(Object primaryKeyValue, boolean validation) {
        if (validation) {
            checkImmutable();
            checkHasPrimaryKey();
        }
        long primaryKeyColumnIndex = getPrimaryKey();
        RealmFieldType type = getColumnType(primaryKeyColumnIndex);
        if (primaryKeyValue == null) {
            switch (type) {
                case STRING:
                case INTEGER:
                    if (validation && findFirstNull(primaryKeyColumnIndex) != -1) {
                        throwDuplicatePrimaryKeyException("null");
                    }
                    long rowIndex = nativeAddEmptyRow(this.nativePtr, 1);
                    if (type == RealmFieldType.STRING) {
                        nativeSetStringUnique(this.nativePtr, primaryKeyColumnIndex, rowIndex, (String) null);
                        return rowIndex;
                    }
                    nativeSetNullUnique(this.nativePtr, primaryKeyColumnIndex, rowIndex);
                    return rowIndex;
                default:
                    throw new RealmException("Cannot check for duplicate rows for unsupported primary key type: " + type);
            }
        } else {
            switch (type) {
                case STRING:
                    if (!(primaryKeyValue instanceof String)) {
                        throw new IllegalArgumentException("Primary key value is not a String: " + primaryKeyValue);
                    }
                    if (validation && findFirstString(primaryKeyColumnIndex, (String) primaryKeyValue) != -1) {
                        throwDuplicatePrimaryKeyException(primaryKeyValue);
                    }
                    long rowIndex2 = nativeAddEmptyRow(this.nativePtr, 1);
                    nativeSetStringUnique(this.nativePtr, primaryKeyColumnIndex, rowIndex2, (String) primaryKeyValue);
                    return rowIndex2;
                case INTEGER:
                    try {
                        long pkValue = Long.parseLong(primaryKeyValue.toString());
                        if (validation && findFirstLong(primaryKeyColumnIndex, pkValue) != -1) {
                            throwDuplicatePrimaryKeyException(Long.valueOf(pkValue));
                        }
                        long rowIndex3 = nativeAddEmptyRow(this.nativePtr, 1);
                        nativeSetLongUnique(this.nativePtr, primaryKeyColumnIndex, rowIndex3, pkValue);
                        return rowIndex3;
                    } catch (RuntimeException e) {
                        throw new IllegalArgumentException("Primary key value is not a long: " + primaryKeyValue);
                    }
                default:
                    throw new RealmException("Cannot check for duplicate rows for unsupported primary key type: " + type);
            }
        }
    }

    public long addEmptyRows(long rows) {
        checkImmutable();
        if (rows < 1) {
            throw new IllegalArgumentException("'rows' must be > 0.");
        } else if (!hasPrimaryKey()) {
            return nativeAddEmptyRow(this.nativePtr, rows);
        } else {
            if (rows <= 1) {
                return addEmptyRow();
            }
            throw new RealmException("Multiple empty rows cannot be created if a primary key is defined for the table.");
        }
    }

    /* access modifiers changed from: protected */
    public long add(Object... values) {
        String providedType;
        long rowIndex = addEmptyRow();
        checkImmutable();
        int columns = (int) getColumnCount();
        if (columns != values.length) {
            throw new IllegalArgumentException("The number of value parameters (" + String.valueOf(values.length) + ") does not match the number of columns in the table (" + String.valueOf(columns) + ").");
        }
        RealmFieldType[] colTypes = new RealmFieldType[columns];
        for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
            Object value = values[columnIndex];
            RealmFieldType colType = getColumnType((long) columnIndex);
            colTypes[columnIndex] = colType;
            if (!colType.isValid(value)) {
                if (value == null) {
                    providedType = "null";
                } else {
                    providedType = value.getClass().toString();
                }
                throw new IllegalArgumentException("Invalid argument no " + String.valueOf(columnIndex + 1) + ". Expected a value compatible with column type " + colType + ", but got " + providedType + ".");
            }
        }
        for (long columnIndex2 = 0; columnIndex2 < ((long) columns); columnIndex2++) {
            Object value2 = values[(int) columnIndex2];
            switch (colTypes[(int) columnIndex2]) {
                case STRING:
                    if (value2 != null) {
                        checkStringValueIsLegal(columnIndex2, rowIndex, (String) value2);
                        nativeSetString(this.nativePtr, columnIndex2, rowIndex, (String) value2, false);
                        break;
                    } else {
                        checkDuplicatedNullForPrimaryKeyValue(columnIndex2, rowIndex);
                        nativeSetNull(this.nativePtr, columnIndex2, rowIndex, false);
                        break;
                    }
                case INTEGER:
                    if (value2 != null) {
                        long intValue = ((Number) value2).longValue();
                        checkIntValueIsLegal(columnIndex2, rowIndex, intValue);
                        nativeSetLong(this.nativePtr, columnIndex2, rowIndex, intValue, false);
                        break;
                    } else {
                        checkDuplicatedNullForPrimaryKeyValue(columnIndex2, rowIndex);
                        nativeSetNull(this.nativePtr, columnIndex2, rowIndex, false);
                        break;
                    }
                case BOOLEAN:
                    nativeSetBoolean(this.nativePtr, columnIndex2, rowIndex, ((Boolean) value2).booleanValue(), false);
                    break;
                case FLOAT:
                    nativeSetFloat(this.nativePtr, columnIndex2, rowIndex, ((Float) value2).floatValue(), false);
                    break;
                case DOUBLE:
                    nativeSetDouble(this.nativePtr, columnIndex2, rowIndex, ((Double) value2).doubleValue(), false);
                    break;
                case DATE:
                    if (value2 != null) {
                        nativeSetTimestamp(this.nativePtr, columnIndex2, rowIndex, ((Date) value2).getTime(), false);
                        break;
                    } else {
                        throw new IllegalArgumentException("Null Date is not allowed.");
                    }
                case BINARY:
                    if (value2 != null) {
                        nativeSetByteArray(this.nativePtr, columnIndex2, rowIndex, (byte[]) value2, false);
                        break;
                    } else {
                        throw new IllegalArgumentException("Null Array is not allowed");
                    }
                default:
                    throw new RuntimeException("Unexpected columnType: " + String.valueOf(colTypes[(int) columnIndex2]));
            }
        }
        return rowIndex;
    }

    private boolean isPrimaryKeyColumn(long columnIndex) {
        return columnIndex == getPrimaryKey();
    }

    public long getPrimaryKey() {
        if (this.cachedPrimaryKeyColumnIndex >= 0 || this.cachedPrimaryKeyColumnIndex == NO_PRIMARY_KEY) {
            return this.cachedPrimaryKeyColumnIndex;
        }
        Table pkTable = getPrimaryKeyTable();
        if (pkTable == null) {
            return NO_PRIMARY_KEY;
        }
        long rowIndex = pkTable.findFirstString(0, tableNameToClassName(getName()));
        if (rowIndex != -1) {
            this.cachedPrimaryKeyColumnIndex = getColumnIndex(pkTable.getUncheckedRow(rowIndex).getString(1));
        } else {
            this.cachedPrimaryKeyColumnIndex = NO_PRIMARY_KEY;
        }
        return this.cachedPrimaryKeyColumnIndex;
    }

    private boolean isPrimaryKey(long columnIndex) {
        return columnIndex >= 0 && columnIndex == getPrimaryKey();
    }

    public boolean hasPrimaryKey() {
        return getPrimaryKey() >= 0;
    }

    /* access modifiers changed from: package-private */
    public void checkStringValueIsLegal(long columnIndex, long rowToUpdate, String value) {
        if (isPrimaryKey(columnIndex)) {
            long rowIndex = findFirstString(columnIndex, value);
            if (rowIndex != rowToUpdate && rowIndex != -1) {
                throwDuplicatePrimaryKeyException(value);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void checkIntValueIsLegal(long columnIndex, long rowToUpdate, long value) {
        if (isPrimaryKeyColumn(columnIndex)) {
            long rowIndex = findFirstLong(columnIndex, value);
            if (rowIndex != rowToUpdate && rowIndex != -1) {
                throwDuplicatePrimaryKeyException(Long.valueOf(value));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void checkDuplicatedNullForPrimaryKeyValue(long columnIndex, long rowToUpdate) {
        if (isPrimaryKeyColumn(columnIndex)) {
            switch (getColumnType(columnIndex)) {
                case STRING:
                case INTEGER:
                    long rowIndex = findFirstNull(columnIndex);
                    if (rowIndex != rowToUpdate && rowIndex != -1) {
                        throwDuplicatePrimaryKeyException("null");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static void throwDuplicatePrimaryKeyException(Object value) {
        throw new RealmPrimaryKeyConstraintException("Value already exists: " + value);
    }

    public long getLong(long columnIndex, long rowIndex) {
        return nativeGetLong(this.nativePtr, columnIndex, rowIndex);
    }

    public boolean getBoolean(long columnIndex, long rowIndex) {
        return nativeGetBoolean(this.nativePtr, columnIndex, rowIndex);
    }

    public float getFloat(long columnIndex, long rowIndex) {
        return nativeGetFloat(this.nativePtr, columnIndex, rowIndex);
    }

    public double getDouble(long columnIndex, long rowIndex) {
        return nativeGetDouble(this.nativePtr, columnIndex, rowIndex);
    }

    public Date getDate(long columnIndex, long rowIndex) {
        return new Date(nativeGetTimestamp(this.nativePtr, columnIndex, rowIndex));
    }

    public String getString(long columnIndex, long rowIndex) {
        return nativeGetString(this.nativePtr, columnIndex, rowIndex);
    }

    public byte[] getBinaryByteArray(long columnIndex, long rowIndex) {
        return nativeGetByteArray(this.nativePtr, columnIndex, rowIndex);
    }

    public long getLink(long columnIndex, long rowIndex) {
        return nativeGetLink(this.nativePtr, columnIndex, rowIndex);
    }

    public Table getLinkTarget(long columnIndex) {
        return new Table(this.sharedRealm, nativeGetLinkTarget(this.nativePtr, columnIndex));
    }

    public boolean isNull(long columnIndex, long rowIndex) {
        return nativeIsNull(this.nativePtr, columnIndex, rowIndex);
    }

    public UncheckedRow getUncheckedRow(long index) {
        return UncheckedRow.getByRowIndex(this.context, this, index);
    }

    public UncheckedRow getUncheckedRowByPointer(long nativeRowPointer) {
        return UncheckedRow.getByRowPointer(this.context, this, nativeRowPointer);
    }

    public CheckedRow getCheckedRow(long index) {
        return CheckedRow.get(this.context, this, index);
    }

    public void setLong(long columnIndex, long rowIndex, long value, boolean isDefault) {
        checkImmutable();
        checkIntValueIsLegal(columnIndex, rowIndex, value);
        nativeSetLong(this.nativePtr, columnIndex, rowIndex, value, isDefault);
    }

    public void setBoolean(long columnIndex, long rowIndex, boolean value, boolean isDefault) {
        checkImmutable();
        nativeSetBoolean(this.nativePtr, columnIndex, rowIndex, value, isDefault);
    }

    public void setFloat(long columnIndex, long rowIndex, float value, boolean isDefault) {
        checkImmutable();
        nativeSetFloat(this.nativePtr, columnIndex, rowIndex, value, isDefault);
    }

    public void setDouble(long columnIndex, long rowIndex, double value, boolean isDefault) {
        checkImmutable();
        nativeSetDouble(this.nativePtr, columnIndex, rowIndex, value, isDefault);
    }

    public void setDate(long columnIndex, long rowIndex, Date date, boolean isDefault) {
        if (date == null) {
            throw new IllegalArgumentException("Null Date is not allowed.");
        }
        checkImmutable();
        nativeSetTimestamp(this.nativePtr, columnIndex, rowIndex, date.getTime(), isDefault);
    }

    public void setString(long columnIndex, long rowIndex, String value, boolean isDefault) {
        checkImmutable();
        if (value == null) {
            checkDuplicatedNullForPrimaryKeyValue(columnIndex, rowIndex);
            nativeSetNull(this.nativePtr, columnIndex, rowIndex, isDefault);
            return;
        }
        checkStringValueIsLegal(columnIndex, rowIndex, value);
        nativeSetString(this.nativePtr, columnIndex, rowIndex, value, isDefault);
    }

    public void setBinaryByteArray(long columnIndex, long rowIndex, byte[] data, boolean isDefault) {
        checkImmutable();
        nativeSetByteArray(this.nativePtr, columnIndex, rowIndex, data, isDefault);
    }

    public void setLink(long columnIndex, long rowIndex, long value, boolean isDefault) {
        checkImmutable();
        nativeSetLink(this.nativePtr, columnIndex, rowIndex, value, isDefault);
    }

    public void setNull(long columnIndex, long rowIndex, boolean isDefault) {
        checkImmutable();
        checkDuplicatedNullForPrimaryKeyValue(columnIndex, rowIndex);
        nativeSetNull(this.nativePtr, columnIndex, rowIndex, isDefault);
    }

    public void addSearchIndex(long columnIndex) {
        checkImmutable();
        nativeAddSearchIndex(this.nativePtr, columnIndex);
    }

    public void removeSearchIndex(long columnIndex) {
        checkImmutable();
        nativeRemoveSearchIndex(this.nativePtr, columnIndex);
    }

    public void setPrimaryKey(String columnName) {
        Table pkTable = getPrimaryKeyTable();
        if (pkTable == null) {
            throw new RealmException("Primary keys are only supported if Table is part of a Group");
        }
        this.cachedPrimaryKeyColumnIndex = nativeSetPrimaryKey(pkTable.nativePtr, this.nativePtr, columnName);
    }

    public void setPrimaryKey(long columnIndex) {
        setPrimaryKey(nativeGetColumnName(this.nativePtr, columnIndex));
    }

    private Table getPrimaryKeyTable() {
        if (this.sharedRealm == null) {
            return null;
        }
        Table pkTable = this.sharedRealm.getTable(PRIMARY_KEY_TABLE_NAME);
        if (pkTable.getColumnCount() != 0) {
            return pkTable;
        }
        checkImmutable();
        pkTable.addSearchIndex(pkTable.addColumn(RealmFieldType.STRING, PRIMARY_KEY_CLASS_COLUMN_NAME));
        pkTable.addColumn(RealmFieldType.STRING, PRIMARY_KEY_FIELD_COLUMN_NAME);
        return pkTable;
    }

    private void invalidateCachedPrimaryKeyIndex() {
        this.cachedPrimaryKeyColumnIndex = -1;
    }

    public static boolean migratePrimaryKeyTableIfNeeded(SharedRealm sharedRealm2) {
        if (sharedRealm2 == null || !sharedRealm2.isInTransaction()) {
            throwImmutable();
        }
        if (!sharedRealm2.hasTable(PRIMARY_KEY_TABLE_NAME)) {
            return false;
        }
        return nativeMigratePrimaryKeyTableIfNeeded(sharedRealm2.getGroupNative(), sharedRealm2.getTable(PRIMARY_KEY_TABLE_NAME).nativePtr);
    }

    public static boolean primaryKeyTableNeedsMigration(SharedRealm sharedRealm2) {
        if (!sharedRealm2.hasTable(PRIMARY_KEY_TABLE_NAME)) {
            return false;
        }
        return nativePrimaryKeyTableNeedsMigration(sharedRealm2.getTable(PRIMARY_KEY_TABLE_NAME).nativePtr);
    }

    public boolean hasSearchIndex(long columnIndex) {
        return nativeHasSearchIndex(this.nativePtr, columnIndex);
    }

    public boolean isNullLink(long columnIndex, long rowIndex) {
        return nativeIsNullLink(this.nativePtr, columnIndex, rowIndex);
    }

    public void nullifyLink(long columnIndex, long rowIndex) {
        nativeNullifyLink(this.nativePtr, columnIndex, rowIndex);
    }

    /* access modifiers changed from: package-private */
    public boolean isImmutable() {
        return this.sharedRealm != null && !this.sharedRealm.isInTransaction();
    }

    /* access modifiers changed from: package-private */
    public void checkImmutable() {
        if (isImmutable()) {
            throwImmutable();
        }
    }

    private void checkHasPrimaryKey() {
        if (!hasPrimaryKey()) {
            throw new IllegalStateException(getName() + " has no primary key defined");
        }
    }

    public long sumLong(long columnIndex) {
        return nativeSumInt(this.nativePtr, columnIndex);
    }

    public Long maximumLong(long columnIndex) {
        return Long.valueOf(nativeMaximumInt(this.nativePtr, columnIndex));
    }

    public Long minimumLong(long columnIndex) {
        return Long.valueOf(nativeMinimumInt(this.nativePtr, columnIndex));
    }

    public double averageLong(long columnIndex) {
        return nativeAverageInt(this.nativePtr, columnIndex);
    }

    public double sumFloat(long columnIndex) {
        return nativeSumFloat(this.nativePtr, columnIndex);
    }

    public Float maximumFloat(long columnIndex) {
        return Float.valueOf(nativeMaximumFloat(this.nativePtr, columnIndex));
    }

    public Float minimumFloat(long columnIndex) {
        return Float.valueOf(nativeMinimumFloat(this.nativePtr, columnIndex));
    }

    public double averageFloat(long columnIndex) {
        return nativeAverageFloat(this.nativePtr, columnIndex);
    }

    public double sumDouble(long columnIndex) {
        return nativeSumDouble(this.nativePtr, columnIndex);
    }

    public Double maximumDouble(long columnIndex) {
        return Double.valueOf(nativeMaximumDouble(this.nativePtr, columnIndex));
    }

    public Double minimumDouble(long columnIndex) {
        return Double.valueOf(nativeMinimumDouble(this.nativePtr, columnIndex));
    }

    public double averageDouble(long columnIndex) {
        return nativeAverageDouble(this.nativePtr, columnIndex);
    }

    public Date maximumDate(long columnIndex) {
        return new Date(nativeMaximumTimestamp(this.nativePtr, columnIndex));
    }

    public Date minimumDate(long columnIndex) {
        return new Date(nativeMinimumTimestamp(this.nativePtr, columnIndex));
    }

    public long count(long columnIndex, long value) {
        return nativeCountLong(this.nativePtr, columnIndex, value);
    }

    public long count(long columnIndex, float value) {
        return nativeCountFloat(this.nativePtr, columnIndex, value);
    }

    public long count(long columnIndex, double value) {
        return nativeCountDouble(this.nativePtr, columnIndex, value);
    }

    public long count(long columnIndex, String value) {
        return nativeCountString(this.nativePtr, columnIndex, value);
    }

    public TableQuery where() {
        return new TableQuery(this.context, this, nativeWhere(this.nativePtr));
    }

    public long findFirstLong(long columnIndex, long value) {
        return nativeFindFirstInt(this.nativePtr, columnIndex, value);
    }

    public long findFirstBoolean(long columnIndex, boolean value) {
        return nativeFindFirstBool(this.nativePtr, columnIndex, value);
    }

    public long findFirstFloat(long columnIndex, float value) {
        return nativeFindFirstFloat(this.nativePtr, columnIndex, value);
    }

    public long findFirstDouble(long columnIndex, double value) {
        return nativeFindFirstDouble(this.nativePtr, columnIndex, value);
    }

    public long findFirstDate(long columnIndex, Date date) {
        if (date == null) {
            throw new IllegalArgumentException("null is not supported");
        }
        return nativeFindFirstTimestamp(this.nativePtr, columnIndex, date.getTime());
    }

    public long findFirstString(long columnIndex, String value) {
        if (value != null) {
            return nativeFindFirstString(this.nativePtr, columnIndex, value);
        }
        throw new IllegalArgumentException("null is not supported");
    }

    public long findFirstNull(long columnIndex) {
        return nativeFindFirstNull(this.nativePtr, columnIndex);
    }

    public long lowerBoundLong(long columnIndex, long value) {
        return nativeLowerBoundInt(this.nativePtr, columnIndex, value);
    }

    public long upperBoundLong(long columnIndex, long value) {
        return nativeUpperBoundInt(this.nativePtr, columnIndex, value);
    }

    public Table pivot(long stringCol, long intCol, PivotType pivotType) {
        if (!getColumnType(stringCol).equals(RealmFieldType.STRING)) {
            throw new UnsupportedOperationException("Group by column must be of type String");
        } else if (!getColumnType(intCol).equals(RealmFieldType.INTEGER)) {
            throw new UnsupportedOperationException("Aggregation column must be of type Int");
        } else {
            Table result = new Table();
            nativePivot(this.nativePtr, stringCol, intCol, pivotType.value, result.nativePtr);
            return result;
        }
    }

    public String getName() {
        return nativeGetName(this.nativePtr);
    }

    public String toJson() {
        return nativeToJson(this.nativePtr);
    }

    public String toString() {
        long columnCount = getColumnCount();
        String name = getName();
        StringBuilder stringBuilder = new StringBuilder("The Table ");
        if (name != null && !name.isEmpty()) {
            stringBuilder.append(getName());
            stringBuilder.append(" ");
        }
        if (hasPrimaryKey()) {
            stringBuilder.append("has '").append(getColumnName(getPrimaryKey())).append("' field as a PrimaryKey, and ");
        }
        stringBuilder.append("contains ");
        stringBuilder.append(columnCount);
        stringBuilder.append(" columns: ");
        for (int i = 0; ((long) i) < columnCount; i++) {
            if (i != 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(getColumnName((long) i));
        }
        stringBuilder.append(".");
        stringBuilder.append(" And ");
        stringBuilder.append(size());
        stringBuilder.append(" rows.");
        return stringBuilder.toString();
    }

    private static void throwImmutable() {
        throw new IllegalStateException("Changing Realm data can only be done from inside a transaction.");
    }

    public boolean hasSameSchema(Table table) {
        if (table != null) {
            return nativeHasSameSchema(this.nativePtr, table.nativePtr);
        }
        throw new IllegalArgumentException("The argument cannot be null");
    }

    public static boolean isModelTable(String tableName) {
        return tableName.startsWith(TABLE_PREFIX);
    }

    public long getVersion() {
        return nativeVersion(this.nativePtr);
    }

    public static String tableNameToClassName(String tableName) {
        return !tableName.startsWith(TABLE_PREFIX) ? tableName : tableName.substring(TABLE_PREFIX.length());
    }
}
