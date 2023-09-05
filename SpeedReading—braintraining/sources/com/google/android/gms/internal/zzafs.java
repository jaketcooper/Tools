package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;

final class zzafs extends zzagj {
    private /* synthetic */ Context val$context;
    private /* synthetic */ String zzcyq;
    private /* synthetic */ long zzcyr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzafs(Context context, String str, long j) {
        super((zzafm) null);
        this.val$context = context;
        this.zzcyq = str;
        this.zzcyr = j;
    }

    public final void zzdg() {
        SharedPreferences.Editor edit = this.val$context.getSharedPreferences("admob", 0).edit();
        edit.putString("app_settings_json", this.zzcyq);
        edit.putLong("app_settings_last_update_ms", this.zzcyr);
        edit.apply();
    }
}
