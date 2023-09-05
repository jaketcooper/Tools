package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

final class zzage extends zzagj {
    private /* synthetic */ Context val$context;
    private /* synthetic */ zzagk zzcyo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzage(Context context, zzagk zzagk) {
        super((zzafm) null);
        this.val$context = context;
        this.zzcyo = zzagk;
    }

    public final void zzdg() {
        SharedPreferences sharedPreferences = this.val$context.getSharedPreferences("admob", 0);
        Bundle bundle = new Bundle();
        bundle.putInt("webview_cache_version", sharedPreferences.getInt("webview_cache_version", 0));
        if (this.zzcyo != null) {
            this.zzcyo.zzb(bundle);
        }
    }
}
