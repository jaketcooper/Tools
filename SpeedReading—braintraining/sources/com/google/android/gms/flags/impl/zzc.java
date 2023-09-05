package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zzc implements Callable<Boolean> {
    private /* synthetic */ SharedPreferences zzhgn;
    private /* synthetic */ String zzhgo;
    private /* synthetic */ Boolean zzhgp;

    zzc(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.zzhgn = sharedPreferences;
        this.zzhgo = str;
        this.zzhgp = bool;
    }

    public final /* synthetic */ Object call() throws Exception {
        return Boolean.valueOf(this.zzhgn.getBoolean(this.zzhgo, this.zzhgp.booleanValue()));
    }
}
