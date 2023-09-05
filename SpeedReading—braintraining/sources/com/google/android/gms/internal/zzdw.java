package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class zzdw extends zzec {
    public zzdw(zzda zzda, String str, String str2, zzaw zzaw, int i, int i2) {
        super(zzda, str, str2, zzaw, i, 51);
    }

    /* access modifiers changed from: protected */
    public final void zzat() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzajo) {
            zzcz zzcz = new zzcz((String) this.zzajx.invoke((Object) null, new Object[0]));
            this.zzajo.zzeg = zzcz.zzaid;
            this.zzajo.zzeh = zzcz.zzaie;
        }
    }
}
