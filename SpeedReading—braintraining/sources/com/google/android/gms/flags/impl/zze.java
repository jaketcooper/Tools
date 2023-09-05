package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zze implements Callable<Integer> {
    private /* synthetic */ SharedPreferences zzhgn;
    private /* synthetic */ String zzhgo;
    private /* synthetic */ Integer zzhgq;

    zze(SharedPreferences sharedPreferences, String str, Integer num) {
        this.zzhgn = sharedPreferences;
        this.zzhgo = str;
        this.zzhgq = num;
    }

    public final /* synthetic */ Object call() throws Exception {
        return Integer.valueOf(this.zzhgn.getInt(this.zzhgo, this.zzhgq.intValue()));
    }
}
