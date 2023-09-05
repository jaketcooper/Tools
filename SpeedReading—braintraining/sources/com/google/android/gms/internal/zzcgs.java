package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzbq;

class zzcgs extends BroadcastReceiver {
    private static String zzdvi = zzcgs.class.getName();
    private boolean mRegistered;
    private boolean zzdvj;
    /* access modifiers changed from: private */
    public final zzchj zzitu;

    zzcgs(zzchj zzchj) {
        zzbq.checkNotNull(zzchj);
        this.zzitu = zzchj;
    }

    @MainThread
    public void onReceive(Context context, Intent intent) {
        this.zzitu.zzwu();
        String action = intent.getAction();
        this.zzitu.zzawn().zzayy().zzj("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zzzh = this.zzitu.zzazq().zzzh();
            if (this.zzdvj != zzzh) {
                this.zzdvj = zzzh;
                this.zzitu.zzawm().zzg(new zzcgt(this, zzzh));
                return;
            }
            return;
        }
        this.zzitu.zzawn().zzayu().zzj("NetworkBroadcastReceiver received unknown action", action);
    }

    @WorkerThread
    public final void unregister() {
        this.zzitu.zzwu();
        this.zzitu.zzawm().zzut();
        this.zzitu.zzawm().zzut();
        if (this.mRegistered) {
            this.zzitu.zzawn().zzayy().log("Unregistering connectivity change receiver");
            this.mRegistered = false;
            this.zzdvj = false;
            try {
                this.zzitu.getContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zzitu.zzawn().zzays().zzj("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    @WorkerThread
    public final void zzze() {
        this.zzitu.zzwu();
        this.zzitu.zzawm().zzut();
        if (!this.mRegistered) {
            this.zzitu.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.zzdvj = this.zzitu.zzazq().zzzh();
            this.zzitu.zzawn().zzayy().zzj("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzdvj));
            this.mRegistered = true;
        }
    }
}
