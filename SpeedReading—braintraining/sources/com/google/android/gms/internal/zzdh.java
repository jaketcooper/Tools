package com.google.android.gms.internal;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

public final class zzdh extends zzec {
    public zzdh(zzda zzda, String str, String str2, zzaw zzaw, int i, int i2) {
        super(zzda, str, str2, zzaw, i, 49);
    }

    /* access modifiers changed from: protected */
    public final void zzat() throws IllegalAccessException, InvocationTargetException {
        this.zzajo.zzef = 2;
        try {
            this.zzajo.zzef = Integer.valueOf(((Boolean) this.zzajx.invoke((Object) null, new Object[]{this.zzagk.getApplicationContext()})).booleanValue() ? 1 : 0);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
