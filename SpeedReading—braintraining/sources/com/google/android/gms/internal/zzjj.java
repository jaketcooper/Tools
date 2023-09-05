package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzja;

final class zzjj extends zzja.zza<zzwj> {
    private /* synthetic */ Activity val$activity;
    private /* synthetic */ zzja zzbds;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzjj(zzja zzja, Activity activity) {
        super();
        this.zzbds = zzja;
        this.val$activity = activity;
    }

    public final /* synthetic */ Object zza(zzkj zzkj) throws RemoteException {
        return zzkj.createAdOverlay(zzn.zzy(this.val$activity));
    }

    public final /* synthetic */ Object zzht() throws RemoteException {
        zzwj zze = this.zzbds.zzbdn.zze(this.val$activity);
        if (zze != null) {
            return zze;
        }
        zzja.zza(this.val$activity, "ad_overlay");
        return null;
    }
}
