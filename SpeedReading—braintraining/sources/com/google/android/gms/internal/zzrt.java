package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzrt implements zzsh {
    private /* synthetic */ String val$name;
    private /* synthetic */ String zzbxl;

    zzrt(zzrs zzrs, String str, String str2) {
        this.val$name = str;
        this.zzbxl = str2;
    }

    public final void zzb(zzsi zzsi) throws RemoteException {
        if (zzsi.zzbxq != null) {
            zzsi.zzbxq.onAppEvent(this.val$name, this.zzbxl);
        }
    }
}
