package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;

final class zzagf extends zzagj {
    private /* synthetic */ Context val$context;
    private /* synthetic */ boolean zzcyw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzagf(Context context, boolean z) {
        super((zzafm) null);
        this.val$context = context;
        this.zzcyw = z;
    }

    public final void zzdg() {
        SharedPreferences.Editor edit = this.val$context.getSharedPreferences("admob", 0).edit();
        edit.putBoolean("content_url_opted_out", this.zzcyw);
        edit.apply();
    }
}
