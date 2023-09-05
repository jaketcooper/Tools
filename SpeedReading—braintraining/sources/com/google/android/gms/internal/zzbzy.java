package com.google.android.gms.internal;

public final class zzbzy {
    private static zzbzy zzhgk;
    private final zzbzt zzhgl = new zzbzt();
    private final zzbzu zzhgm = new zzbzu();

    static {
        zzbzy zzbzy = new zzbzy();
        synchronized (zzbzy.class) {
            zzhgk = zzbzy;
        }
    }

    private zzbzy() {
    }

    private static zzbzy zzaqp() {
        zzbzy zzbzy;
        synchronized (zzbzy.class) {
            zzbzy = zzhgk;
        }
        return zzbzy;
    }

    public static zzbzt zzaqq() {
        return zzaqp().zzhgl;
    }

    public static zzbzu zzaqr() {
        return zzaqp().zzhgm;
    }
}
