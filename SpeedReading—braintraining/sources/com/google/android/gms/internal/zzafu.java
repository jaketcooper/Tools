package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;

final class zzafu extends zzagj {
    private /* synthetic */ Context val$context;
    private /* synthetic */ String zzcys;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzafu(Context context, String str) {
        super((zzafm) null);
        this.val$context = context;
        this.zzcys = str;
    }

    public final void zzdg() {
        SharedPreferences.Editor edit = this.val$context.getSharedPreferences("admob", 0).edit();
        edit.putString("native_advanced_settings", this.zzcys);
        edit.apply();
    }
}
