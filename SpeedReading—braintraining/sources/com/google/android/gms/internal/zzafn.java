package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;

final class zzafn extends zzagj {
    private /* synthetic */ Context val$context;
    private /* synthetic */ String zzcym;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzafn(Context context, String str) {
        super((zzafm) null);
        this.val$context = context;
        this.zzcym = str;
    }

    public final void zzdg() {
        SharedPreferences.Editor edit = this.val$context.getSharedPreferences("admob", 0).edit();
        edit.putString("content_vertical_hashes", this.zzcym);
        edit.apply();
    }
}
