package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzja;

final class zzji extends zzja.zza<zzacq> {
    private /* synthetic */ Context val$context;
    private /* synthetic */ zzuc zzbdr;
    private /* synthetic */ zzja zzbds;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzji(zzja zzja, Context context, zzuc zzuc) {
        super();
        this.zzbds = zzja;
        this.val$context = context;
        this.zzbdr = zzuc;
    }

    public final /* synthetic */ Object zza(zzkj zzkj) throws RemoteException {
        return zzkj.createRewardedVideoAd(zzn.zzy(this.val$context), this.zzbdr, 11717000);
    }

    public final /* synthetic */ Object zzht() throws RemoteException {
        zzacq zza = this.zzbds.zzbdm.zza(this.val$context, this.zzbdr);
        if (zza != null) {
            return zza;
        }
        zzja.zza(this.val$context, "rewarded_video");
        return new zzlu();
    }
}
