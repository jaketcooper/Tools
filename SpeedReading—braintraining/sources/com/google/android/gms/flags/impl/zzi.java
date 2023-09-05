package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zzi implements Callable<String> {
    private /* synthetic */ SharedPreferences zzhgn;
    private /* synthetic */ String zzhgo;
    private /* synthetic */ String zzhgs;

    zzi(SharedPreferences sharedPreferences, String str, String str2) {
        this.zzhgn = sharedPreferences;
        this.zzhgo = str;
        this.zzhgs = str2;
    }

    public final /* synthetic */ Object call() throws Exception {
        return this.zzhgn.getString(this.zzhgo, this.zzhgs);
    }
}
