package p006io.realm.internal;

import p006io.realm.RealmFieldType;

/* renamed from: io.realm.internal.CheckedRow */
public class CheckedRow extends UncheckedRow {
    private UncheckedRow originalRow;

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
    public native void nativeSetString(long j, long j2, String str);

    /* access modifiers changed from: protected */
    public native void nativeSetTimestamp(long j, long j2, long j3);

    private CheckedRow(Context context, Table parent, long nativePtr) {
        super(context, parent, nativePtr);
    }

    private CheckedRow(UncheckedRow row) {
        super(row);
        this.originalRow = row;
    }

    public static CheckedRow get(Context context, Table table, long index) {
        return new CheckedRow(context, table, table.nativeGetRowPtr(table.getNativePtr(), index));
    }

    public static CheckedRow get(Context context, LinkView linkView, long index) {
        return new CheckedRow(context, linkView.getTargetTable(), linkView.nativeGetRow(linkView.getNativePtr(), index));
    }

    public static CheckedRow getFromRow(UncheckedRow row) {
        return new CheckedRow(row);
    }

    public boolean isNullLink(long columnIndex) {
        RealmFieldType columnType = getColumnType(columnIndex);
        if (columnType == RealmFieldType.OBJECT || columnType == RealmFieldType.LIST) {
            return super.isNullLink(columnIndex);
        }
        return false;
    }

    public boolean isNull(long columnIndex) {
        return super.isNull(columnIndex);
    }

    public void setNull(long columnIndex) {
        if (getColumnType(columnIndex) == RealmFieldType.BINARY) {
            super.setBinaryByteArray(columnIndex, (byte[]) null);
        } else {
            super.setNull(columnIndex);
        }
    }
}
