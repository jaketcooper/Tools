package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class zzds extends zzec {
    public zzds(zzda zzda, String str, String str2, zzaw zzaw, int i, int i2) {
        super(zzda, str, str2, zzaw, i, 3);
    }

    /* access modifiers changed from: protected */
    public final void zzat() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzajo) {
            zzcw zzcw = new zzcw((String) this.zzajx.invoke((Object) null, new Object[]{this.zzagk.getContext()}));
            synchronized (this.zzajo) {
                this.zzajo.zzcw = Long.valueOf(zzcw.zzahy);
                this.zzajo.zzer = Long.valueOf(zzcw.zzahz);
            }
        }
    }
}
