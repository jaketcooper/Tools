package p006io.realm.internal;

import java.util.Date;
import p006io.realm.RealmFieldType;

/* renamed from: io.realm.internal.UncheckedRow */
public class UncheckedRow implements NativeObject, Row {
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    final Context context;
    private final long nativePtr;
    private final Table parent;

    private static native long nativeGetFinalizerPtr();

    /* access modifiers changed from: protected */
    public native boolean nativeGetBoolean(long j, long j2);

    /* access modifiers changed from: protected */
    public native byte[] nativeGetByteArray(long j, long j2);

    /* access modifiers changed from: protected */
    public native long nativeGetColumnCount(long j);

    /* access modifiers changed from: protected */
    public native long nativeGetColumnIndex(long j, String str);

    /* access modifiers changed from: protected */
    public native String nativeGetColumnName(long j, long j2);

    /* access modifiers changed from: protected */
    public native int nativeGetColumnType(long j, long j2);

    /* access modifiers changed from: protected */
    public native double nativeGetDouble(long j, long j2);

    /* access modifiers changed from: protected */
    public native float nativeGetFloat(long j, long j2);

    /* access modifiers changed from: protected */
    public native long nativeGetIndex(long j);

    /* access modifiers changed from: protected */
    public native long nativeGetLink(long j, long j2);

    /* access modifiers changed from: protected */
    public native long nativeGetLinkView(long j, long j2);

    /* access modifiers changed from: protected */
    public native long nativeGetLong(long j, long j2);

    /* access modifiers changed from: protected */
    public native String nativeGetString(long j, long j2);

    /* access modifiers changed from: protected */
    public native long nativeGetTimestamp(long j, long j2);

    /* access modifiers changed from: protected */
    public native boolean nativeHasColumn(long j, String str);

    /* access modifiers changed from: protected */
    public native boolean nativeIsAttached(long j);

    /* access modifiers changed from: protected */
    public native boolean nativeIsNull(long j, long j2);

    /* access modifiers changed from: protected */
    public native boolean nativeIsNullLink(long j, long j2);

    /* access modifiers changed from: protected */
    public native void nativeNullifyLink(long j, long j2);

    /* access modifiers changed from: protected */
    public native void nativeSetBoolean(long j, long j2, boolean z);

    /* access modifiers changed from: protected */
    public native void nativeSetByteArray(long j, long j2, byte[] bArr);

    /* access modifiers changed from: protected */
    public native void nativeSetDouble(long j, long j2, double d);

    /* access modifiers changed from: protected */
    public native void nativeSetFloat(long j, long j2, float f);

    /* access modifiers changed from: protected */
    public native void nativeSetLink(long j, long j2, long j3);

    /* access modifiers changed from: protected */
    public native void nativeSetLong(long j, long j2, long j3);

    /* access modifiers changed from: protected */
    public native void nativeSetNull(long j, long j2);

    /* access modifiers changed from: protected */
    public native void nativeSetString(long j, long j2, String str);

    /* access modifiers changed from: protected */
    public native void nativeSetTimestamp(long j, long j2, long j3);

    UncheckedRow(Context context2, Table parent2, long nativePtr2) {
        this.context = context2;
        this.parent = parent2;
        this.nativePtr = nativePtr2;
        context2.addReference(this);
    }

    UncheckedRow(UncheckedRow row) {
        this.context = row.context;
        this.parent = row.parent;
        this.nativePtr = row.nativePtr;
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    static UncheckedRow getByRowIndex(Context context2, Table table, long index) {
        return new UncheckedRow(context2, table, table.nativeGetRowPtr(table.getNativePtr(), index));
    }

    static UncheckedRow getByRowPointer(Context context2, Table table, long nativeRowPointer) {
        return new UncheckedRow(context2, table, nativeRowPointer);
    }

    static UncheckedRow getByRowIndex(Context context2, LinkView linkView, long index) {
        return new UncheckedRow(context2, linkView.getTargetTable(), linkView.nativeGetRow(linkView.getNativePtr(), index));
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

    public Table getTable() {
        return this.parent;
    }

    public long getIndex() {
        return nativeGetIndex(this.nativePtr);
    }

    public long getLong(long columnIndex) {
        return nativeGetLong(this.nativePtr, columnIndex);
    }

    public boolean getBoolean(long columnIndex) {
        return nativeGetBoolean(this.nativePtr, columnIndex);
    }

    public float getFloat(long columnIndex) {
        return nativeGetFloat(this.nativePtr, columnIndex);
    }

    public double getDouble(long columnIndex) {
        return nativeGetDouble(this.nativePtr, columnIndex);
    }

    public Date getDate(long columnIndex) {
        return new Date(nativeGetTimestamp(this.nativePtr, columnIndex));
    }

    public String getString(long columnIndex) {
        return nativeGetString(this.nativePtr, columnIndex);
    }

    public byte[] getBinaryByteArray(long columnIndex) {
        return nativeGetByteArray(this.nativePtr, columnIndex);
    }

    public long getLink(long columnIndex) {
        return nativeGetLink(this.nativePtr, columnIndex);
    }

    public boolean isNullLink(long columnIndex) {
        return nativeIsNullLink(this.nativePtr, columnIndex);
    }

    public LinkView getLinkList(long columnIndex) {
        return new LinkView(this.context, this.parent, columnIndex, nativeGetLinkView(this.nativePtr, columnIndex));
    }

    public void setLong(long columnIndex, long value) {
        this.parent.checkImmutable();
        getTable().checkIntValueIsLegal(columnIndex, getIndex(), value);
        nativeSetLong(this.nativePtr, columnIndex, value);
    }

    public void setBoolean(long columnIndex, boolean value) {
        this.parent.checkImmutable();
        nativeSetBoolean(this.nativePtr, columnIndex, value);
    }

    public void setFloat(long columnIndex, float value) {
        this.parent.checkImmutable();
        nativeSetFloat(this.nativePtr, columnIndex, value);
    }

    public void setDouble(long columnIndex, double value) {
        this.parent.checkImmutable();
        nativeSetDouble(this.nativePtr, columnIndex, value);
    }

    public void setDate(long columnIndex, Date date) {
        this.parent.checkImmutable();
        if (date == null) {
            throw new IllegalArgumentException("Null Date is not allowed.");
        }
        nativeSetTimestamp(this.nativePtr, columnIndex, date.getTime());
    }

    public void setString(long columnIndex, String value) {
        this.parent.checkImmutable();
        if (value == null) {
            getTable().checkDuplicatedNullForPrimaryKeyValue(columnIndex, getIndex());
            nativeSetNull(this.nativePtr, columnIndex);
            return;
        }
        getTable().checkStringValueIsLegal(columnIndex, getIndex(), value);
        nativeSetString(this.nativePtr, columnIndex, value);
    }

    public void setBinaryByteArray(long columnIndex, byte[] data) {
        this.parent.checkImmutable();
        nativeSetByteArray(this.nativePtr, columnIndex, data);
    }

    public void setLink(long columnIndex, long value) {
        this.parent.checkImmutable();
        nativeSetLink(this.nativePtr, columnIndex, value);
    }

    public void nullifyLink(long columnIndex) {
        this.parent.checkImmutable();
        nativeNullifyLink(this.nativePtr, columnIndex);
    }

    public boolean isNull(long columnIndex) {
        return nativeIsNull(this.nativePtr, columnIndex);
    }

    public void setNull(long columnIndex) {
        this.parent.checkImmutable();
        getTable().checkDuplicatedNullForPrimaryKeyValue(columnIndex, getIndex());
        nativeSetNull(this.nativePtr, columnIndex);
    }

    public CheckedRow convertToChecked() {
        return CheckedRow.getFromRow(this);
    }

    public boolean isAttached() {
        return this.nativePtr != 0 && nativeIsAttached(this.nativePtr);
    }

    public boolean hasColumn(String fieldName) {
        return nativeHasColumn(this.nativePtr, fieldName);
    }
}
