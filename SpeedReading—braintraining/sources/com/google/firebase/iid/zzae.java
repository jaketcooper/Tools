package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

final class zzae extends BroadcastReceiver {
    private zzad zznvx;

    public zzae(zzad zzad) {
        this.zznvx = zzad;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.zznvx != null && this.zznvx.zzchr()) {
            if (FirebaseInstanceId.zzchb()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.zzb(this.zznvx, 0);
            this.zznvx.getContext().unregisterReceiver(this);
            this.zznvx = null;
        }
    }

    public final void zzchs() {
        if (FirebaseInstanceId.zzchb()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.zznvx.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }
}
