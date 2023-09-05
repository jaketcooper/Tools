package com.google.android.gms.internal;

import java.util.Comparator;

public final class zzdyy<K, V> implements zzdyz<K, V> {
    private static final zzdyy zzmhw = new zzdyy();

    private zzdyy() {
    }

    public static <K, V> zzdyy<K, V> zzbrq() {
        return zzmhw;
    }

    public final K getKey() {
        return null;
    }

    public final V getValue() {
        return null;
    }

    public final boolean isEmpty() {
        return true;
    }

    public final int size() {
        return 0;
    }

    public final zzdyz<K, V> zza(K k, V v, Integer num, zzdyz<K, V> zzdyz, zzdyz<K, V> zzdyz2) {
        return this;
    }

    public final zzdyz<K, V> zza(K k, V v, Comparator<K> comparator) {
        return new zzdzc(k, v);
    }

    public final zzdyz<K, V> zza(K k, Comparator<K> comparator) {
        return this;
    }

    public final void zza(zzdzb<K, V> zzdzb) {
    }

    public final boolean zzbrp() {
        return false;
    }

    public final zzdyz<K, V> zzbrr() {
        return this;
    }

    public final zzdyz<K, V> zzbrs() {
        return this;
    }

    public final zzdyz<K, V> zzbrt() {
        return this;
    }

    public final zzdyz<K, V> zzbru() {
        return this;
    }
}
