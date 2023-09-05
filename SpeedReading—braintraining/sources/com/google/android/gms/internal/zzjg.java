package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzja;

final class zzjg extends zzja.zza<zzpc> {
    private /* synthetic */ Context val$context;
    private /* synthetic */ zzja zzbds;
    private /* synthetic */ FrameLayout zzbdt;
    private /* synthetic */ FrameLayout zzbdu;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzjg(zzja zzja, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        super();
        this.zzbds = zzja;
        this.zzbdt = frameLayout;
        this.zzbdu = frameLayout2;
        this.val$context = context;
    }

    public final /* synthetic */ Object zza(zzkj zzkj) throws RemoteException {
        return zzkj.createNativeAdViewDelegate(zzn.zzy(this.zzbdt), zzn.zzy(this.zzbdu));
    }

    public final /* synthetic */ Object zzht() throws RemoteException {
        zzpc zzb = this.zzbds.zzbdl.zzb(this.val$context, this.zzbdt, this.zzbdu);
        if (zzb != null) {
            return zzb;
        }
        zzja.zza(this.val$context, "native_ad_view_delegate");
        return new zzls();
    }
}
