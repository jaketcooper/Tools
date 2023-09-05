package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class zzdy extends zzec {
    public zzdy(zzda zzda, String str, String str2, zzaw zzaw, int i, int i2) {
        super(zzda, str, str2, zzaw, i, 48);
    }

    /* access modifiers changed from: protected */
    public final void zzat() throws IllegalAccessException, InvocationTargetException {
        this.zzajo.zzee = 2;
        boolean booleanValue = ((Boolean) this.zzajx.invoke((Object) null, new Object[]{this.zzagk.getApplicationContext()})).booleanValue();
        synchronized (this.zzajo) {
            if (booleanValue) {
                this.zzajo.zzee = 1;
            } else {
                this.zzajo.zzee = 0;
            }
        }
    }
}
