package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

final class zzaip implements Callable<String> {
    private /* synthetic */ Context val$context;
    private /* synthetic */ Context zzdbj;

    zzaip(zzaio zzaio, Context context, Context context2) {
        this.zzdbj = context;
        this.val$context = context2;
    }

    public final /* synthetic */ Object call() throws Exception {
        SharedPreferences sharedPreferences;
        boolean z = false;
        if (this.zzdbj != null) {
            zzafj.m11v("Attempting to read user agent from Google Play Services.");
            sharedPreferences = this.zzdbj.getSharedPreferences("admob_user_agent", 0);
        } else {
            zzafj.m11v("Attempting to read user agent from local cache.");
            sharedPreferences = this.val$context.getSharedPreferences("admob_user_agent", 0);
            z = true;
        }
        String string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty(string)) {
            zzafj.m11v("Reading user agent from WebSettings");
            string = WebSettings.getDefaultUserAgent(this.val$context);
            if (z) {
                sharedPreferences.edit().putString("user_agent", string).apply();
                zzafj.m11v("Persisting user agent.");
            }
        }
        return string;
    }
}
