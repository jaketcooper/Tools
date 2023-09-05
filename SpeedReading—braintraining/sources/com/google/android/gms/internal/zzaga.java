package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;

final class zzaga extends zzagj {
    private /* synthetic */ Context val$context;
    private /* synthetic */ int zzcyu;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaga(Context context, int i) {
        super((zzafm) null);
        this.val$context = context;
        this.zzcyu = i;
    }

    public final void zzdg() {
        SharedPreferences.Editor edit = this.val$context.getSharedPreferences("admob", 0).edit();
        edit.putInt("request_in_session_count", this.zzcyu);
        edit.apply();
    }
}
