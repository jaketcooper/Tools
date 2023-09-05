package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;

final class zzagc extends zzagj {
    private /* synthetic */ Context val$context;
    private /* synthetic */ long zzcyv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzagc(Context context, long j) {
        super((zzafm) null);
        this.val$context = context;
        this.zzcyv = j;
    }

    public final void zzdg() {
        SharedPreferences.Editor edit = this.val$context.getSharedPreferences("admob", 0).edit();
        edit.putLong("first_ad_req_time_ms", this.zzcyv);
        edit.apply();
    }
}
