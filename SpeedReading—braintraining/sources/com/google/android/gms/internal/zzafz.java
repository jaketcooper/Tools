package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

final class zzafz extends zzagj {
    private /* synthetic */ Context val$context;
    private /* synthetic */ zzagk zzcyo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzafz(Context context, zzagk zzagk) {
        super((zzafm) null);
        this.val$context = context;
        this.zzcyo = zzagk;
    }

    public final void zzdg() {
        SharedPreferences sharedPreferences = this.val$context.getSharedPreferences("admob", 0);
        Bundle bundle = new Bundle();
        bundle.putLong("app_last_background_time_ms", sharedPreferences.getLong("app_last_background_time_ms", 0));
        if (this.zzcyo != null) {
            this.zzcyo.zzb(bundle);
        }
    }
}
