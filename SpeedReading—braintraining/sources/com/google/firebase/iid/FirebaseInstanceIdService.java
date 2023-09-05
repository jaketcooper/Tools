package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.WorkerThread;
import android.util.Log;

public class FirebaseInstanceIdService extends zzb {
    public final void handleIntent(Intent intent) {
        if ("com.google.firebase.iid.TOKEN_REFRESH".equals(intent.getAction())) {
            onTokenRefresh();
            return;
        }
        zzi zza = zzi.zza((Context) this, intent.getStringExtra("subtype"), (Bundle) null);
        String stringExtra = intent.getStringExtra("CMD");
        if (Log.isLoggable("InstanceID", 3)) {
            String str = zza.zzicy;
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("InstanceID", new StringBuilder(String.valueOf(str).length() + 22 + String.valueOf(stringExtra).length() + String.valueOf(valueOf).length()).append("Received command [").append(str).append("]: ").append(stringExtra).append(" ").append(valueOf).toString());
        }
        if ("gcm.googleapis.com/refresh".equals(intent.getStringExtra("from"))) {
            zza.zzchf();
        } else if ("RST".equals(stringExtra)) {
            zza.zzchd();
        } else if ("RST_FULL".equals(stringExtra)) {
            zza.zzche();
        } else if ("SYNC".equals(stringExtra)) {
            zza.zzchf();
        }
    }

    @WorkerThread
    public void onTokenRefresh() {
    }

    /* access modifiers changed from: protected */
    public final Intent zzp(Intent intent) {
        return zzaa.zzchn().zznvr.poll();
    }
}
