package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

final class zzaha implements Callable<Boolean> {
    private /* synthetic */ Context val$context;
    private /* synthetic */ WebSettings zzczn;

    zzaha(zzagz zzagz, Context context, WebSettings webSettings) {
        this.val$context = context;
        this.zzczn = webSettings;
    }

    public final /* synthetic */ Object call() throws Exception {
        if (this.val$context.getCacheDir() != null) {
            this.zzczn.setAppCachePath(this.val$context.getCacheDir().getAbsolutePath());
            this.zzczn.setAppCacheMaxSize(0);
            this.zzczn.setAppCacheEnabled(true);
        }
        this.zzczn.setDatabasePath(this.val$context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        this.zzczn.setDatabaseEnabled(true);
        this.zzczn.setDomStorageEnabled(true);
        this.zzczn.setDisplayZoomControls(false);
        this.zzczn.setBuiltInZoomControls(true);
        this.zzczn.setSupportZoom(true);
        this.zzczn.setAllowContentAccess(false);
        return true;
    }
}
