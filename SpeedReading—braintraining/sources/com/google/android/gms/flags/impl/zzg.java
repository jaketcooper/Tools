package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zzg implements Callable<Long> {
    private /* synthetic */ SharedPreferences zzhgn;
    private /* synthetic */ String zzhgo;
    private /* synthetic */ Long zzhgr;

    zzg(SharedPreferences sharedPreferences, String str, Long l) {
        this.zzhgn = sharedPreferences;
        this.zzhgo = str;
        this.zzhgr = l;
    }

    public final /* synthetic */ Object call() throws Exception {
        return Long.valueOf(this.zzhgn.getLong(this.zzhgo, this.zzhgr.longValue()));
    }
}
