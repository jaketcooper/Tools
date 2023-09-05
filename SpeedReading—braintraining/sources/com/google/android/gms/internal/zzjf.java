package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzja;

final class zzjf extends zzja.zza<zzkp> {
    private /* synthetic */ Context val$context;
    private /* synthetic */ zzja zzbds;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzjf(zzja zzja, Context context) {
        super();
        this.zzbds = zzja;
        this.val$context = context;
    }

    public final /* synthetic */ Object zza(zzkj zzkj) throws RemoteException {
        return zzkj.getMobileAdsSettingsManagerWithClientJarVersion(zzn.zzy(this.val$context), 11717000);
    }

    public final /* synthetic */ Object zzht() throws RemoteException {
        zzkp zzh = this.zzbds.zzbdk.zzh(this.val$context);
        if (zzh != null) {
            return zzh;
        }
        zzja.zza(this.val$context, "mobile_ads_settings");
        return new zzlr();
    }
}
