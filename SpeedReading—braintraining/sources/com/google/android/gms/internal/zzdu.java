package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class zzdu extends zzec {
    public zzdu(zzda zzda, String str, String str2, zzaw zzaw, int i, int i2) {
        super(zzda, str, str2, zzaw, i, 61);
    }

    /* access modifiers changed from: protected */
    public final void zzat() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzajx.invoke((Object) null, new Object[]{this.zzagk.getContext(), Boolean.valueOf(this.zzagk.zzal())})).longValue();
        synchronized (this.zzajo) {
            this.zzajo.zzes = Long.valueOf(longValue);
        }
    }
}
