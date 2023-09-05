package com.google.android.gms.internal;

@zzzb
public final class zzjk {
    private static final Object sLock = new Object();
    private static zzjk zzbdy;
    private final String mSessionId = zzais.zzqu();
    private final zzais zzbdz = new zzais();
    private final zzja zzbea = new zzja(new zzir(), new zziq(), new zzlk(), new zzqn(), new zzacz(), new zzwi(), new zzqo());

    static {
        zzjk zzjk = new zzjk();
        synchronized (sLock) {
            zzbdy = zzjk;
        }
    }

    protected zzjk() {
    }

    private static zzjk zzhw() {
        zzjk zzjk;
        synchronized (sLock) {
            zzjk = zzbdy;
        }
        return zzjk;
    }

    public static zzais zzhx() {
        return zzhw().zzbdz;
    }

    public static zzja zzhy() {
        return zzhw().zzbea;
    }

    public static String zzhz() {
        return zzhw().mSessionId;
    }
}
