package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public final class zzdt extends zzec {
    private List<Long> zzajr = null;

    public zzdt(zzda zzda, String str, String str2, zzaw zzaw, int i, int i2) {
        super(zzda, str, str2, zzaw, i, 31);
    }

    /* access modifiers changed from: protected */
    public final void zzat() throws IllegalAccessException, InvocationTargetException {
        this.zzajo.zzdr = -1L;
        this.zzajo.zzds = -1L;
        if (this.zzajr == null) {
            this.zzajr = (List) this.zzajx.invoke((Object) null, new Object[]{this.zzagk.getContext()});
        }
        if (this.zzajr != null && this.zzajr.size() == 2) {
            synchronized (this.zzajo) {
                this.zzajo.zzdr = Long.valueOf(this.zzajr.get(0).longValue());
                this.zzajo.zzds = Long.valueOf(this.zzajr.get(1).longValue());
            }
        }
    }
}
