package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzdzg<A, B, C> {
    private final Map<B, C> values;
    private final List<A> zzmie;
    private final zzdyt<A, B> zzmif;
    private zzdzd<A, C> zzmig;
    private zzdzd<A, C> zzmih;

    private zzdzg(List<A> list, Map<B, C> map, zzdyt<A, B> zzdyt) {
        this.zzmie = list;
        this.values = map;
        this.zzmif = zzdyt;
    }

    private final C zzbo(A a) {
        return this.values.get(this.zzmif.zzbj(a));
    }

    public static <A, B, C> zzdze<A, C> zzc(List<A> list, Map<B, C> map, zzdyt<A, B> zzdyt, Comparator<A> comparator) {
        zzdzg zzdzg = new zzdzg(list, map, zzdyt);
        Collections.sort(list, comparator);
        Iterator<zzdzj> it = new zzdzh(list.size()).iterator();
        int size = list.size();
        while (it.hasNext()) {
            zzdzj next = it.next();
            size -= next.zzmil;
            if (next.zzmik) {
                zzdzg.zzf(zzdza.zzmhy, next.zzmil, size);
            } else {
                zzdzg.zzf(zzdza.zzmhy, next.zzmil, size);
                size -= next.zzmil;
                zzdzg.zzf(zzdza.zzmhx, next.zzmil, size);
            }
        }
        return new zzdze<>(zzdzg.zzmig == null ? zzdyy.zzbrq() : zzdzg.zzmig, comparator);
    }

    private final void zzf(int i, int i2, int i3) {
        zzdyz zzu = zzu(i3 + 1, i2 - 1);
        A a = this.zzmie.get(i3);
        zzdzd<A, C> zzdzc = i == zzdza.zzmhx ? new zzdzc<>(a, zzbo(a), (zzdyz) null, zzu) : new zzdyx<>(a, zzbo(a), (zzdyz) null, zzu);
        if (this.zzmig == null) {
            this.zzmig = zzdzc;
            this.zzmih = zzdzc;
            return;
        }
        this.zzmih.zza(zzdzc);
        this.zzmih = zzdzc;
    }

    private final zzdyz<A, C> zzu(int i, int i2) {
        if (i2 == 0) {
            return zzdyy.zzbrq();
        }
        if (i2 == 1) {
            A a = this.zzmie.get(i);
            return new zzdyx(a, zzbo(a), (zzdyz) null, (zzdyz) null);
        }
        int i3 = i2 / 2;
        int i4 = i + i3;
        zzdyz zzu = zzu(i, i3);
        zzdyz zzu2 = zzu(i4 + 1, i3);
        A a2 = this.zzmie.get(i4);
        return new zzdyx(a2, zzbo(a2), zzu, zzu2);
    }
}
