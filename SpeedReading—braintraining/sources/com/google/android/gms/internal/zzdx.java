package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class zzdx extends zzec {
    private static final Object zzajl = new Object();
    private static volatile Long zzajt = null;

    public zzdx(zzda zzda, String str, String str2, zzaw zzaw, int i, int i2) {
        super(zzda, str, str2, zzaw, i, 33);
    }

    /* access modifiers changed from: protected */
    public final void zzat() throws IllegalAccessException, InvocationTargetException {
        if (zzajt == null) {
            synchronized (zzajl) {
                if (zzajt == null) {
                    zzajt = (Long) this.zzajx.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzajo) {
            this.zzajo.zzdt = zzajt;
        }
    }
}
