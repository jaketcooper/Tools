package com.google.android.gms.internal;

import java.lang.Comparable;
import java.util.Comparator;

public final class zzdzk<A extends Comparable<A>> implements Comparator<A> {
    private static zzdzk zzmim = new zzdzk();

    private zzdzk() {
    }

    public static <T extends Comparable<T>> zzdzk<T> zze(Class<T> cls) {
        return zzmim;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((Comparable) obj).compareTo((Comparable) obj2);
    }
}
