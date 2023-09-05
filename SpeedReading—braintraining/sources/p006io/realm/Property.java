package p006io.realm;

/* renamed from: io.realm.Property */
class Property {
    public static final boolean INDEXED = true;
    public static final boolean PRIMARY_KEY = true;
    public static final boolean REQUIRED = true;
    private final long nativePtr;

    private static native void nativeClose(long j);

    private static native long nativeCreateProperty(String str, int i, String str2);

    private static native long nativeCreateProperty(String str, int i, boolean z, boolean z2, boolean z3);

    public Property(String name, RealmFieldType type, boolean isPrimary, boolean isIndexed, boolean isRequired) {
        this.nativePtr = nativeCreateProperty(name, type.getNativeValue(), isPrimary, isIndexed, !isRequired);
    }

    public Property(String name, RealmFieldType type, RealmObjectSchema linkedTo) {
        this.nativePtr = nativeCreateProperty(name, type.getNativeValue(), linkedTo.getClassName());
    }

    protected Property(long nativePtr2) {
        this.nativePtr = nativePtr2;
    }

    /* access modifiers changed from: protected */
    public long getNativePtr() {
        return this.nativePtr;
    }

    public void close() {
        if (this.nativePtr != 0) {
            nativeClose(this.nativePtr);
        }
    }
}
