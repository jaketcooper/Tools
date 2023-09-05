package com.google.android.gms.internal;

import java.util.Comparator;

public interface zzdyz<K, V> {
    K getKey();

    V getValue();

    boolean isEmpty();

    int size();

    zzdyz<K, V> zza(K k, V v, Integer num, zzdyz<K, V> zzdyz, zzdyz<K, V> zzdyz2);

    zzdyz<K, V> zza(K k, V v, Comparator<K> comparator);

    zzdyz<K, V> zza(K k, Comparator<K> comparator);

    void zza(zzdzb<K, V> zzdzb);

    boolean zzbrp();

    zzdyz<K, V> zzbrr();

    zzdyz<K, V> zzbrs();

    zzdyz<K, V> zzbrt();

    zzdyz<K, V> zzbru();
}
