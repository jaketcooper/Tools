package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;

final class zzchb implements Runnable {
    private /* synthetic */ Context val$context;
    private /* synthetic */ BroadcastReceiver.PendingResult zzdlr;
    private /* synthetic */ zzchj zzjbi;
    private /* synthetic */ long zzjbj;
    private /* synthetic */ Bundle zzjbk;
    private /* synthetic */ zzcgj zzjbl;

    zzchb(zzcha zzcha, zzchj zzchj, long j, Bundle bundle, Context context, zzcgj zzcgj, BroadcastReceiver.PendingResult pendingResult) {
        this.zzjbi = zzchj;
        this.zzjbj = j;
        this.zzjbk = bundle;
        this.val$context = context;
        this.zzjbl = zzcgj;
        this.zzdlr = pendingResult;
    }

    public final void run() {
        zzckm zzag = this.zzjbi.zzawh().zzag(this.zzjbi.zzawc().getAppId(), "_fot");
        long longValue = (zzag == null || !(zzag.mValue instanceof Long)) ? 0 : ((Long) zzag.mValue).longValue();
        long j = this.zzjbj;
        long j2 = (longValue <= 0 || (j < longValue && j > 0)) ? j : longValue - 1;
        if (j2 > 0) {
            this.zzjbk.putLong("click_timestamp", j2);
        }
        AppMeasurement.getInstance(this.val$context).logEventInternal("auto", "_cmp", this.zzjbk);
        this.zzjbl.zzayy().log("Install campaign recorded");
        if (this.zzdlr != null) {
            this.zzdlr.finish();
        }
    }
}
