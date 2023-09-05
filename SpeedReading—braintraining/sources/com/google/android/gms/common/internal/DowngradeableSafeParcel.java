package com.google.android.gms.common.internal;

import com.google.android.gms.internal.zzbej;

public abstract class DowngradeableSafeParcel extends zzbej implements ReflectedParcelable {
    private static final Object zzfxd = new Object();
    private static ClassLoader zzfxe = null;
    private static Integer zzfxf = null;
    private boolean zzfxg = false;

    private static ClassLoader zzaku() {
        synchronized (zzfxd) {
        }
        return null;
    }

    protected static Integer zzakv() {
        synchronized (zzfxd) {
        }
        return null;
    }

    protected static boolean zzgd(String str) {
        zzaku();
        return true;
    }
}
