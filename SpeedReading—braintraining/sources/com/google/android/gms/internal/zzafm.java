package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;

final class zzafm extends zzagj {
    private /* synthetic */ Context val$context;
    private /* synthetic */ boolean zzcyl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzafm(Context context, boolean z) {
        super((zzafm) null);
        this.val$context = context;
        this.zzcyl = z;
    }

    public final void zzdg() {
        SharedPreferences.Editor edit = this.val$context.getSharedPreferences("admob", 0).edit();
        edit.putBoolean("use_https", this.zzcyl);
        edit.apply();
    }
}
