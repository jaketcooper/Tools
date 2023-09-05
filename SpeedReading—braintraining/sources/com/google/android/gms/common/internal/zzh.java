package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

final class zzh extends Handler {
    private /* synthetic */ zzd zzfwq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzh(zzd zzd, Looper looper) {
        super(looper);
        this.zzfwq = zzd;
    }

    private static void zza(Message message) {
        ((zzi) message.obj).unregister();
    }

    private static boolean zzb(Message message) {
        return message.what == 2 || message.what == 1 || message.what == 7;
    }

    public final void handleMessage(Message message) {
        PendingIntent pendingIntent = null;
        if (this.zzfwq.zzfwn.get() != message.arg1) {
            if (zzb(message)) {
                zza(message);
            }
        } else if ((message.what == 1 || message.what == 7 || message.what == 4 || message.what == 5) && !this.zzfwq.isConnecting()) {
            zza(message);
        } else if (message.what == 4) {
            ConnectionResult unused = this.zzfwq.zzfwl = new ConnectionResult(message.arg2);
            if (!this.zzfwq.zzakf() || this.zzfwq.zzfwm) {
                ConnectionResult zzd = this.zzfwq.zzfwl != null ? this.zzfwq.zzfwl : new ConnectionResult(8);
                this.zzfwq.zzfwc.zzf(zzd);
                this.zzfwq.onConnectionFailed(zzd);
                return;
            }
            this.zzfwq.zza(3, null);
        } else if (message.what == 5) {
            ConnectionResult zzd2 = this.zzfwq.zzfwl != null ? this.zzfwq.zzfwl : new ConnectionResult(8);
            this.zzfwq.zzfwc.zzf(zzd2);
            this.zzfwq.onConnectionFailed(zzd2);
        } else if (message.what == 3) {
            if (message.obj instanceof PendingIntent) {
                pendingIntent = (PendingIntent) message.obj;
            }
            ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
            this.zzfwq.zzfwc.zzf(connectionResult);
            this.zzfwq.onConnectionFailed(connectionResult);
        } else if (message.what == 6) {
            this.zzfwq.zza(5, null);
            if (this.zzfwq.zzfwh != null) {
                this.zzfwq.zzfwh.onConnectionSuspended(message.arg2);
            }
            this.zzfwq.onConnectionSuspended(message.arg2);
            boolean unused2 = this.zzfwq.zza(5, 1, null);
        } else if (message.what == 2 && !this.zzfwq.isConnected()) {
            zza(message);
        } else if (zzb(message)) {
            ((zzi) message.obj).zzakh();
        } else {
            Log.wtf("GmsClient", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), new Exception());
        }
    }
}
