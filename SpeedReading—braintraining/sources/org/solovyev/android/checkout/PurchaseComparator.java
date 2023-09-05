package org.solovyev.android.checkout;

import java.util.Comparator;
import javax.annotation.Nonnull;

final class PurchaseComparator implements Comparator<Purchase> {
    @Nonnull
    private static final Comparator<Purchase> EARLIEST_FIRST = new PurchaseComparator(true);
    @Nonnull
    private static final Comparator<Purchase> LATEST_FIRST = new PurchaseComparator(false);
    private final int mAsc;

    private PurchaseComparator(boolean asc) {
        this.mAsc = asc ? 1 : -1;
    }

    @Nonnull
    static Comparator<Purchase> earliestFirst() {
        return EARLIEST_FIRST;
    }

    @Nonnull
    static Comparator<Purchase> latestFirst() {
        return LATEST_FIRST;
    }

    public static int compare(long l, long r) {
        if (l < r) {
            return -1;
        }
        return l == r ? 0 : 1;
    }

    public int compare(@Nonnull Purchase l, @Nonnull Purchase r) {
        return this.mAsc * compare(l.time, r.time);
    }
}
