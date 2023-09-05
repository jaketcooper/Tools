package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.dynamic.zzn;

final class zzadg implements Runnable {
    private /* synthetic */ zzis zzaox;
    private /* synthetic */ zzuf zzctt;
    private /* synthetic */ zzade zzctu;
    private /* synthetic */ zzadm zzctv;

    zzadg(zzade zzade, zzuf zzuf, zzis zzis, zzadm zzadm) {
        this.zzctu = zzade;
        this.zzctt = zzuf;
        this.zzaox = zzis;
        this.zzctv = zzadm;
    }

    public final void run() {
        try {
            this.zzctt.zza(zzn.zzy(this.zzctu.mContext), this.zzaox, (String) null, (zzads) this.zzctv, this.zzctu.zzcto);
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            String valueOf = String.valueOf(this.zzctu.zzcco);
            zzafj.zzc(valueOf.length() != 0 ? "Fail to initialize adapter ".concat(valueOf) : new String("Fail to initialize adapter "), remoteException);
            this.zzctu.zza(this.zzctu.zzcco, 0);
        }
    }
}
