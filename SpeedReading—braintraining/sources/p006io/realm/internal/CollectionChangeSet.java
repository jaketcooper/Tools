package p006io.realm.internal;

import p006io.realm.OrderedCollectionChangeSet;

/* renamed from: io.realm.internal.CollectionChangeSet */
public class CollectionChangeSet implements OrderedCollectionChangeSet, NativeObject {
    public static final int MAX_ARRAY_LENGTH = 2147483639;
    public static final int TYPE_DELETION = 0;
    public static final int TYPE_INSERTION = 1;
    public static final int TYPE_MODIFICATION = 2;
    private static long finalizerPtr = nativeGetFinalizerPtr();
    private final long nativePtr;

    private static native long nativeGetFinalizerPtr();

    private static native int[] nativeGetIndices(long j, int i);

    private static native int[] nativeGetRanges(long j, int i);

    public CollectionChangeSet(long nativePtr2) {
        this.nativePtr = nativePtr2;
        Context.dummyContext.addReference(this);
    }

    public int[] getDeletions() {
        return nativeGetIndices(this.nativePtr, 0);
    }

    public int[] getInsertions() {
        return nativeGetIndices(this.nativePtr, 1);
    }

    public int[] getChanges() {
        return nativeGetIndices(this.nativePtr, 2);
    }

    public OrderedCollectionChangeSet.Range[] getDeletionRanges() {
        return longArrayToRangeArray(nativeGetRanges(this.nativePtr, 0));
    }

    public OrderedCollectionChangeSet.Range[] getInsertionRanges() {
        return longArrayToRangeArray(nativeGetRanges(this.nativePtr, 1));
    }

    public OrderedCollectionChangeSet.Range[] getChangeRanges() {
        return longArrayToRangeArray(nativeGetRanges(this.nativePtr, 2));
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public long getNativeFinalizerPtr() {
        return finalizerPtr;
    }

    private OrderedCollectionChangeSet.Range[] longArrayToRangeArray(int[] longArray) {
        if (longArray == null) {
            return new OrderedCollectionChangeSet.Range[0];
        }
        OrderedCollectionChangeSet.Range[] ranges = new OrderedCollectionChangeSet.Range[(longArray.length / 2)];
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = new OrderedCollectionChangeSet.Range(longArray[i * 2], longArray[(i * 2) + 1]);
        }
        return ranges;
    }
}
