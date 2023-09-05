package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzdyo<K, V> extends zzdyq<K, V> {
    /* access modifiers changed from: private */
    public final K[] zzmhk;
    /* access modifiers changed from: private */
    public final V[] zzmhl;
    private final Comparator<K> zzmhm;

    public zzdyo(Comparator<K> comparator) {
        this.zzmhk = new Object[0];
        this.zzmhl = new Object[0];
        this.zzmhm = comparator;
    }

    private zzdyo(Comparator<K> comparator, K[] kArr, V[] vArr) {
        this.zzmhk = kArr;
        this.zzmhl = vArr;
        this.zzmhm = comparator;
    }

    public static <A, B, C> zzdyo<A, C> zza(List<A> list, Map<B, C> map, zzdyt<A, B> zzdyt, Comparator<A> comparator) {
        Collections.sort(list, comparator);
        int size = list.size();
        Object[] objArr = new Object[size];
        Object[] objArr2 = new Object[size];
        int i = 0;
        for (A next : list) {
            objArr[i] = next;
            objArr2[i] = map.get(zzdyt.zzbj(next));
            i++;
        }
        return new zzdyo<>(comparator, objArr, objArr2);
    }

    private static <T> T[] zza(T[] tArr, int i) {
        int length = tArr.length - 1;
        T[] tArr2 = new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, i);
        System.arraycopy(tArr, i + 1, tArr2, i, length - i);
        return tArr2;
    }

    private static <T> T[] zza(T[] tArr, int i, T t) {
        int length = tArr.length + 1;
        T[] tArr2 = new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, i);
        tArr2[i] = t;
        System.arraycopy(tArr, i, tArr2, i + 1, (length - i) - 1);
        return tArr2;
    }

    private static <T> T[] zzb(T[] tArr, int i, T t) {
        int length = tArr.length;
        T[] tArr2 = new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, length);
        tArr2[i] = t;
        return tArr2;
    }

    private final int zzbh(K k) {
        int i = 0;
        while (i < this.zzmhk.length && this.zzmhm.compare(this.zzmhk[i], k) < 0) {
            i++;
        }
        return i;
    }

    private final int zzbi(K k) {
        int i = 0;
        K[] kArr = this.zzmhk;
        int length = kArr.length;
        int i2 = 0;
        while (i2 < length) {
            if (this.zzmhm.compare(k, kArr[i2]) == 0) {
                return i;
            }
            i2++;
            i++;
        }
        return -1;
    }

    private final Iterator<Map.Entry<K, V>> zzj(int i, boolean z) {
        return new zzdyp(this, i, z);
    }

    public final boolean containsKey(K k) {
        return zzbi(k) != -1;
    }

    public final V get(K k) {
        int zzbi = zzbi(k);
        if (zzbi != -1) {
            return this.zzmhl[zzbi];
        }
        return null;
    }

    public final Comparator<K> getComparator() {
        return this.zzmhm;
    }

    public final int indexOf(K k) {
        return zzbi(k);
    }

    public final boolean isEmpty() {
        return this.zzmhk.length == 0;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return zzj(0, false);
    }

    public final int size() {
        return this.zzmhk.length;
    }

    public final void zza(zzdzb<K, V> zzdzb) {
        for (int i = 0; i < this.zzmhk.length; i++) {
            zzdzb.zzg(this.zzmhk[i], this.zzmhl[i]);
        }
    }

    public final zzdyq<K, V> zzbe(K k) {
        int zzbi = zzbi(k);
        if (zzbi == -1) {
            return this;
        }
        return new zzdyo(this.zzmhm, zza(this.zzmhk, zzbi), zza(this.zzmhl, zzbi));
    }

    public final Iterator<Map.Entry<K, V>> zzbf(K k) {
        return zzj(zzbh(k), false);
    }

    public final K zzbg(K k) {
        int zzbi = zzbi(k);
        if (zzbi == -1) {
            throw new IllegalArgumentException("Can't find predecessor of nonexistent key");
        } else if (zzbi > 0) {
            return this.zzmhk[zzbi - 1];
        } else {
            return null;
        }
    }

    public final K zzbri() {
        if (this.zzmhk.length > 0) {
            return this.zzmhk[0];
        }
        return null;
    }

    public final K zzbrj() {
        if (this.zzmhk.length > 0) {
            return this.zzmhk[this.zzmhk.length - 1];
        }
        return null;
    }

    public final Iterator<Map.Entry<K, V>> zzbrk() {
        return zzj(this.zzmhk.length - 1, true);
    }

    public final zzdyq<K, V> zzf(K k, V v) {
        int zzbi = zzbi(k);
        if (zzbi != -1) {
            if (this.zzmhk[zzbi] == k && this.zzmhl[zzbi] == v) {
                return this;
            }
            return new zzdyo(this.zzmhm, zzb(this.zzmhk, zzbi, k), zzb(this.zzmhl, zzbi, v));
        } else if (this.zzmhk.length > 25) {
            HashMap hashMap = new HashMap(this.zzmhk.length + 1);
            for (int i = 0; i < this.zzmhk.length; i++) {
                hashMap.put(this.zzmhk[i], this.zzmhl[i]);
            }
            hashMap.put(k, v);
            return zzdze.zzb(hashMap, this.zzmhm);
        } else {
            int zzbh = zzbh(k);
            return new zzdyo(this.zzmhm, zza(this.zzmhk, zzbh, k), zza(this.zzmhl, zzbh, v));
        }
    }
}
