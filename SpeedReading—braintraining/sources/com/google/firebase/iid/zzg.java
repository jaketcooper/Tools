package com.google.firebase.iid;

import android.util.Log;

final class zzg implements Runnable {
    private /* synthetic */ zzd zznug;
    private /* synthetic */ zzf zznuh;

    zzg(zzf zzf, zzd zzd) {
        this.zznuh = zzf;
        this.zznug = zzd;
    }

    public final void run() {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "bg processing of the intent starting now");
        }
        this.zznuh.zznuf.handleIntent(this.zznug.intent);
        this.zznug.finish();
    }
}
