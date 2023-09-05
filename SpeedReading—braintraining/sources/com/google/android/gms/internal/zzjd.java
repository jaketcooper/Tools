package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzja;

final class zzjd extends zzja.zza<zzkb> {
    private /* synthetic */ Context val$context;
    private /* synthetic */ zziw zzbdp;
    private /* synthetic */ String zzbdq;
    private /* synthetic */ zzuc zzbdr;
    private /* synthetic */ zzja zzbds;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzjd(zzja zzja, Context context, zziw zziw, String str, zzuc zzuc) {
        super();
        this.zzbds = zzja;
        this.val$context = context;
        this.zzbdp = zziw;
        this.zzbdq = str;
        this.zzbdr = zzuc;
    }

    public final /* synthetic */ Object zza(zzkj zzkj) throws RemoteException {
        return zzkj.createInterstitialAdManager(zzn.zzy(this.val$context), this.zzbdp, this.zzbdq, this.zzbdr, 11717000);
    }

    public final /* synthetic */ Object zzht() throws RemoteException {
        zzkb zza = this.zzbds.zzbdi.zza(this.val$context, this.zzbdp, this.zzbdq, this.zzbdr, 2);
        if (zza != null) {
            return zza;
        }
        zzja.zza(this.val$context, "interstitial");
        return new zzlp();
    }
}
