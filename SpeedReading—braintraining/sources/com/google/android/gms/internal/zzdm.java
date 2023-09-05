package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class zzdm extends zzec {
    private long startTime;

    public zzdm(zzda zzda, String str, String str2, zzaw zzaw, long j, int i, int i2) {
        super(zzda, str, str2, zzaw, i, 25);
        this.startTime = j;
    }

    /* access modifiers changed from: protected */
    public final void zzat() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzajx.invoke((Object) null, new Object[0])).longValue();
        synchronized (this.zzajo) {
            this.zzajo.zzfa = Long.valueOf(longValue);
            if (this.startTime != 0) {
                this.zzajo.zzdk = Long.valueOf(longValue - this.startTime);
                this.zzajo.zzdp = Long.valueOf(this.startTime);
            }
        }
    }
}
