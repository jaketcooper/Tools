package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;

final class zzafo extends zzagj {
    private /* synthetic */ Context val$context;
    private /* synthetic */ boolean zzcyn;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzafo(Context context, boolean z) {
        super((zzafm) null);
        this.val$context = context;
        this.zzcyn = z;
    }

    public final void zzdg() {
        SharedPreferences.Editor edit = this.val$context.getSharedPreferences("admob", 0).edit();
        edit.putBoolean("auto_collect_location", this.zzcyn);
        edit.apply();
    }
}
