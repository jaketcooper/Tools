package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

public final class zzdze<K, V> extends zzdyq<K, V> {
    private Comparator<K> zzmhm;
    private zzdyz<K, V> zzmid;

    private zzdze(zzdyz<K, V> zzdyz, Comparator<K> comparator) {
        this.zzmid = zzdyz;
        this.zzmhm = comparator;
    }

    public static <A, B> zzdze<A, B> zzb(Map<A, B> map, Comparator<A> comparator) {
        return zzdzg.zzc(new ArrayList(map.keySet()), map, zzdyr.zzbrl(), comparator);
    }

    private final zzdyz<K, V> zzbn(K k) {
        zzdyz<K, V> zzdyz = this.zzmid;
        while (!zzdyz.isEmpty()) {
            int compare = this.zzmhm.compare(k, zzdyz.getKey());
            if (compare < 0) {
                zzdyz = zzdyz.zzbrr();
            } else if (compare == 0) {
                return zzdyz;
            } else {
                zzdyz = zzdyz.zzbrs();
            }
        }
        return null;
    }

    public final boolean containsKey(K k) {
        return zzbn(k) != null;
    }

    public final V get(K k) {
        zzdyz zzbn = zzbn(k);
        if (zzbn != null) {
            return zzbn.getValue();
        }
        return null;
    }

    public final Comparator<K> getComparator() {
        return this.zzmhm;
    }

    public final int indexOf(K k) {
        int i = 0;
        zzdyz<K, V> zzdyz = this.zzmid;
        while (!zzdyz.isEmpty()) {
            int compare = this.zzmhm.compare(k, zzdyz.getKey());
            if (compare == 0) {
                return zzdyz.zzbrr().size() + i;
            }
            if (compare < 0) {
                zzdyz = zzdyz.zzbrr();
            } else {
                i += zzdyz.zzbrr().size() + 1;
                zzdyz = zzdyz.zzbrs();
            }
        }
        return -1;
    }

    public final boolean isEmpty() {
        return this.zzmid.isEmpty();
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzdyu(this.zzmid, null, this.zzmhm, false);
    }

    public final int size() {
        return this.zzmid.size();
    }

    public final void zza(zzdzb<K, V> zzdzb) {
        this.zzmid.zza(zzdzb);
    }

    public final zzdyq<K, V> zzbe(K k) {
        return !containsKey(k) ? this : new zzdze(this.zzmid.zza(k, this.zzmhm).zza(null, null, zzdza.zzmhy, (zzdyz) null, (zzdyz) null), this.zzmhm);
    }

    public final Iterator<Map.Entry<K, V>> zzbf(K k) {
        return new zzdyu(this.zzmid, k, this.zzmhm, false);
    }

    public final K zzbg(K k) {
        zzdyz<K, V> zzdyz = this.zzmid;
        zzdyz<K, V> zzdyz2 = null;
        while (!zzdyz.isEmpty()) {
            int compare = this.zzmhm.compare(k, zzdyz.getKey());
            if (compare == 0) {
                if (!zzdyz.zzbrr().isEmpty()) {
                    zzdyz<K, V> zzbrr = zzdyz.zzbrr();
                    while (!zzbrr.zzbrs().isEmpty()) {
                        zzbrr = zzbrr.zzbrs();
                    }
                    return zzbrr.getKey();
                } else if (zzdyz2 != null) {
                    return zzdyz2.getKey();
                } else {
                    return null;
                }
            } else if (compare < 0) {
                zzdyz = zzdyz.zzbrr();
            } else {
                zzdyz<K, V> zzdyz3 = zzdyz;
                zzdyz = zzdyz.zzbrs();
                zzdyz2 = zzdyz3;
            }
        }
        String valueOf = String.valueOf(k);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Couldn't find predecessor key of non-present key: ").append(valueOf).toString());
    }

    public final K zzbri() {
        return this.zzmid.zzbrt().getKey();
    }

    public final K zzbrj() {
        return this.zzmid.zzbru().getKey();
    }

    public final Iterator<Map.Entry<K, V>> zzbrk() {
        return new zzdyu(this.zzmid, null, this.zzmhm, true);
    }

    public final zzdyq<K, V> zzf(K k, V v) {
        return new zzdze(this.zzmid.zza(k, v, this.zzmhm).zza(null, null, zzdza.zzmhy, (zzdyz) null, (zzdyz) null), this.zzmhm);
    }
}
