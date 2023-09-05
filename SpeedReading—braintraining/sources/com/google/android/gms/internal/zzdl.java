package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class zzdl extends zzec {
    private static final Object zzajl = new Object();
    private static volatile Long zzec = null;

    public zzdl(zzda zzda, String str, String str2, zzaw zzaw, int i, int i2) {
        super(zzda, str, str2, zzaw, i, 44);
    }

    /* access modifiers changed from: protected */
    public final void zzat() throws IllegalAccessException, InvocationTargetException {
        if (zzec == null) {
            synchronized (zzajl) {
                if (zzec == null) {
                    zzec = (Long) this.zzajx.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzajo) {
            this.zzajo.zzec = zzec;
        }
    }
}
