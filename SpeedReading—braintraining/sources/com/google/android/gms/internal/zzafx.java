package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;

final class zzafx extends zzagj {
    private /* synthetic */ Context val$context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzafx(Context context) {
        super((zzafm) null);
        this.val$context = context;
    }

    public final void zzdg() {
        SharedPreferences.Editor edit = this.val$context.getSharedPreferences("admob", 0).edit();
        edit.remove("native_advanced_settings");
        edit.apply();
    }
}
