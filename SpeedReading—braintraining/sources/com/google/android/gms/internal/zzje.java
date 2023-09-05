package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzja;

final class zzje extends zzja.zza<zzjw> {
    private /* synthetic */ Context val$context;
    private /* synthetic */ String zzbdq;
    private /* synthetic */ zzuc zzbdr;
    private /* synthetic */ zzja zzbds;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzje(zzja zzja, Context context, String str, zzuc zzuc) {
        super();
        this.zzbds = zzja;
        this.val$context = context;
        this.zzbdq = str;
        this.zzbdr = zzuc;
    }

    public final /* synthetic */ Object zza(zzkj zzkj) throws RemoteException {
        return zzkj.createAdLoaderBuilder(zzn.zzy(this.val$context), this.zzbdq, this.zzbdr, 11717000);
    }

    public final /* synthetic */ Object zzht() throws RemoteException {
        zzjw zza = this.zzbds.zzbdj.zza(this.val$context, this.zzbdq, this.zzbdr);
        if (zza != null) {
            return zza;
        }
        zzja.zza(this.val$context, "native_ad");
        return new zzll();
    }
}
