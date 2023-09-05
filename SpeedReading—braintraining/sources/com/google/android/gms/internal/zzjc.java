package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzja;
import com.google.firebase.analytics.FirebaseAnalytics;

final class zzjc extends zzja.zza<zzkb> {
    private /* synthetic */ Context val$context;
    private /* synthetic */ zziw zzbdp;
    private /* synthetic */ String zzbdq;
    private /* synthetic */ zzja zzbds;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzjc(zzja zzja, Context context, zziw zziw, String str) {
        super();
        this.zzbds = zzja;
        this.val$context = context;
        this.zzbdp = zziw;
        this.zzbdq = str;
    }

    public final /* synthetic */ Object zza(zzkj zzkj) throws RemoteException {
        return zzkj.createSearchAdManager(zzn.zzy(this.val$context), this.zzbdp, this.zzbdq, 11717000);
    }

    public final /* synthetic */ Object zzht() throws RemoteException {
        zzkb zza = this.zzbds.zzbdi.zza(this.val$context, this.zzbdp, this.zzbdq, (zzuc) null, 3);
        if (zza != null) {
            return zza;
        }
        zzja.zza(this.val$context, FirebaseAnalytics.Event.SEARCH);
        return new zzlp();
    }
}
