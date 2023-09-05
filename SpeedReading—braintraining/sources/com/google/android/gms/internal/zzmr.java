package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;
import java.util.concurrent.Callable;

final class zzmr implements Callable<Void> {
    private /* synthetic */ Context val$context;

    zzmr(Context context) {
        this.val$context = context;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzbs.zzep().initialize(this.val$context);
        return null;
    }
}
