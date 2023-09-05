package p006io.realm;

/* renamed from: io.realm.OrderedCollectionChangeSet */
public interface OrderedCollectionChangeSet {
    Range[] getChangeRanges();

    int[] getChanges();

    Range[] getDeletionRanges();

    int[] getDeletions();

    Range[] getInsertionRanges();

    int[] getInsertions();

    /* renamed from: io.realm.OrderedCollectionChangeSet$Range */
    public static class Range {
        public final int length;
        public final int startIndex;

        public Range(int startIndex2, int length2) {
            this.startIndex = startIndex2;
            this.length = length2;
        }
    }
}
