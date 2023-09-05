package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class zzdyv<T> implements Iterable<T> {
    private final zzdyq<T, Void> zzmhu;

    private zzdyv(zzdyq<T, Void> zzdyq) {
        this.zzmhu = zzdyq;
    }

    public zzdyv(List<T> list, Comparator<T> comparator) {
        this.zzmhu = zzdyr.zzb(list, Collections.emptyMap(), zzdyr.zzbrl(), comparator);
    }

    public final boolean contains(T t) {
        return this.zzmhu.containsKey(t);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdyv)) {
            return false;
        }
        return this.zzmhu.equals(((zzdyv) obj).zzmhu);
    }

    public final int hashCode() {
        return this.zzmhu.hashCode();
    }

    public final int indexOf(T t) {
        return this.zzmhu.indexOf(t);
    }

    public final boolean isEmpty() {
        return this.zzmhu.isEmpty();
    }

    public final Iterator<T> iterator() {
        return new zzdyw(this.zzmhu.iterator());
    }

    public final int size() {
        return this.zzmhu.size();
    }

    public final Iterator<T> zzbf(T t) {
        return new zzdyw(this.zzmhu.zzbf(t));
    }

    public final zzdyv<T> zzbk(T t) {
        zzdyq<T, Void> zzbe = this.zzmhu.zzbe(t);
        return zzbe == this.zzmhu ? this : new zzdyv<>(zzbe);
    }

    public final zzdyv<T> zzbl(T t) {
        return new zzdyv<>(this.zzmhu.zzf(t, null));
    }

    public final T zzbm(T t) {
        return this.zzmhu.zzbg(t);
    }

    public final Iterator<T> zzbrk() {
        return new zzdyw(this.zzmhu.zzbrk());
    }

    public final T zzbrm() {
        return this.zzmhu.zzbri();
    }

    public final T zzbrn() {
        return this.zzmhu.zzbrj();
    }
}
