package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;

final class zzafy extends zzagj {
    private /* synthetic */ Context val$context;
    private /* synthetic */ long zzcyt;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzafy(Context context, long j) {
        super((zzafm) null);
        this.val$context = context;
        this.zzcyt = j;
    }

    public final void zzdg() {
        SharedPreferences.Editor edit = this.val$context.getSharedPreferences("admob", 0).edit();
        edit.putLong("app_last_background_time_ms", this.zzcyt);
        edit.apply();
    }
}
