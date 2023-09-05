package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;

final class zzafq extends zzagj {
    private /* synthetic */ Context val$context;
    private /* synthetic */ int zzcyp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzafq(Context context, int i) {
        super((zzafm) null);
        this.val$context = context;
        this.zzcyp = i;
    }

    public final void zzdg() {
        SharedPreferences.Editor edit = this.val$context.getSharedPreferences("admob", 0).edit();
        edit.putInt("version_code", this.zzcyp);
        edit.apply();
    }
}
