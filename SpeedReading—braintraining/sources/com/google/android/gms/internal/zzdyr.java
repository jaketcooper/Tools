package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public final class zzdyr {
    private static final zzdyt zzmhr = new zzdys();

    public static <K, V> zzdyq<K, V> zza(Comparator<K> comparator) {
        return new zzdyo(comparator);
    }

    public static <A, B> zzdyq<A, B> zza(Map<A, B> map, Comparator<A> comparator) {
        return map.size() < 25 ? zzdyo.zza(new ArrayList(map.keySet()), map, zzmhr, comparator) : zzdze.zzb(map, comparator);
    }

    public static <A, B, C> zzdyq<A, C> zzb(List<A> list, Map<B, C> map, zzdyt<A, B> zzdyt, Comparator<A> comparator) {
        return list.size() < 25 ? zzdyo.zza(list, map, zzdyt, comparator) : zzdzg.zzc(list, map, zzdyt, comparator);
    }

    public static <A> zzdyt<A, A> zzbrl() {
        return zzmhr;
    }
}
