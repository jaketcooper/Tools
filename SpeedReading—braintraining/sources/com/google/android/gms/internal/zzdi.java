package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class zzdi extends zzec {
    private static volatile String zzajk = null;
    private static final Object zzajl = new Object();

    public zzdi(zzda zzda, String str, String str2, zzaw zzaw, int i, int i2) {
        super(zzda, str, str2, zzaw, i, 29);
    }

    /* access modifiers changed from: protected */
    public final void zzat() throws IllegalAccessException, InvocationTargetException {
        this.zzajo.zzdq = "E";
        if (zzajk == null) {
            synchronized (zzajl) {
                if (zzajk == null) {
                    zzajk = (String) this.zzajx.invoke((Object) null, new Object[]{this.zzagk.getContext()});
                }
            }
        }
        synchronized (this.zzajo) {
            this.zzajo.zzdq = zzbr.zza(zzajk.getBytes(), true);
        }
    }
}
