package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

final class zzafr extends zzagj {
    private /* synthetic */ Context val$context;
    private /* synthetic */ zzagk zzcyo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzafr(Context context, zzagk zzagk) {
        super((zzafm) null);
        this.val$context = context;
        this.zzcyo = zzagk;
    }

    public final void zzdg() {
        SharedPreferences sharedPreferences = this.val$context.getSharedPreferences("admob", 0);
        Bundle bundle = new Bundle();
        bundle.putInt("version_code", sharedPreferences.getInt("version_code", 0));
        if (this.zzcyo != null) {
            this.zzcyo.zzb(bundle);
        }
    }
}
