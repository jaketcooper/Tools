package com.google.android.gms.internal;

import android.util.DisplayMetrics;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

public final class zzdz extends zzec {
    private final View zzaju;

    public zzdz(zzda zzda, String str, String str2, zzaw zzaw, int i, int i2, View view) {
        super(zzda, str, str2, zzaw, i, 57);
        this.zzaju = view;
    }

    /* access modifiers changed from: protected */
    public final void zzat() throws IllegalAccessException, InvocationTargetException {
        if (this.zzaju != null) {
            DisplayMetrics displayMetrics = this.zzagk.getContext().getResources().getDisplayMetrics();
            zzdg zzdg = new zzdg((String) this.zzajx.invoke((Object) null, new Object[]{this.zzaju, displayMetrics}));
            zzay zzay = new zzay();
            zzay.zzfw = zzdg.zzajj;
            zzay.zzfx = zzdg.zzfx;
            zzay.zzfy = zzdg.zzfy;
            this.zzajo.zzeo = zzay;
        }
    }
}
