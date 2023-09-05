package com.google.android.gms.internal;

import java.io.IOException;

public final class zzffm<K, V> {
    private final V value;
    private final K zzmia;
    private final zzffo<K, V> zzpdn;

    private zzffm(zzfgz zzfgz, K k, zzfgz zzfgz2, V v) {
        this.zzpdn = new zzffo<>(zzfgz, k, zzfgz2, v);
        this.zzmia = k;
        this.value = v;
    }

    private static <K, V> int zza(zzffo<K, V> zzffo, K k, V v) {
        return zzfej.zza(zzffo.zzpdo, 1, (Object) k) + zzfej.zza(zzffo.zzpdq, 2, (Object) v);
    }

    public static <K, V> zzffm<K, V> zza(zzfgz zzfgz, K k, zzfgz zzfgz2, V v) {
        return new zzffm<>(zzfgz, k, zzfgz2, v);
    }

    private static <T> T zza(zzfdy zzfdy, zzfei zzfei, zzfgz zzfgz, T t) throws IOException {
        switch (zzffn.zzpcf[zzfgz.ordinal()]) {
            case 1:
                zzffr zzcvh = ((zzffq) t).zzcvh();
                zzfdy.zza(zzcvh, zzfei);
                return zzcvh.zzcvm();
            case 2:
                return Integer.valueOf(zzfdy.zzcud());
            case 3:
                throw new RuntimeException("Groups are not allowed in maps.");
            default:
                return zzfej.zza(zzfdy, zzfgz, true);
        }
    }

    public final void zza(zzfed zzfed, int i, K k, V v) throws IOException {
        zzfed.zzz(i, 2);
        zzfed.zzku(zza(this.zzpdn, k, v));
        zzffo<K, V> zzffo = this.zzpdn;
        zzfej.zza(zzfed, zzffo.zzpdo, 1, k);
        zzfej.zza(zzfed, zzffo.zzpdq, 2, v);
    }

    public final void zza(zzffp<K, V> zzffp, zzfdy zzfdy, zzfei zzfei) throws IOException {
        int zzkj = zzfdy.zzkj(zzfdy.zzcui());
        K k = this.zzpdn.zzpdp;
        V v = this.zzpdn.zzjuv;
        while (true) {
            int zzctt = zzfdy.zzctt();
            if (zzctt == 0) {
                break;
            } else if (zzctt == (this.zzpdn.zzpdo.zzcxe() | 8)) {
                k = zza(zzfdy, zzfei, this.zzpdn.zzpdo, k);
            } else if (zzctt == (this.zzpdn.zzpdq.zzcxe() | 16)) {
                v = zza(zzfdy, zzfei, this.zzpdn.zzpdq, v);
            } else if (!zzfdy.zzkh(zzctt)) {
                break;
            }
        }
        zzfdy.zzkg(0);
        zzfdy.zzkk(zzkj);
        zzffp.put(k, v);
    }

    public final int zzb(int i, K k, V v) {
        return zzfed.zzkx(i) + zzfed.zzle(zza(this.zzpdn, k, v));
    }
}
