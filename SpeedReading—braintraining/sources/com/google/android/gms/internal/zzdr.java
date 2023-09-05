package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class zzdr extends zzec {
    private static final Object zzajl = new Object();
    private static volatile String zzcv = null;

    public zzdr(zzda zzda, String str, String str2, zzaw zzaw, int i, int i2) {
        super(zzda, str, str2, zzaw, i, 1);
    }

    /* access modifiers changed from: protected */
    public final void zzat() throws IllegalAccessException, InvocationTargetException {
        this.zzajo.zzcv = "E";
        if (zzcv == null) {
            synchronized (zzajl) {
                if (zzcv == null) {
                    zzcv = (String) this.zzajx.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzajo) {
            this.zzajo.zzcv = zzcv;
        }
    }
}
