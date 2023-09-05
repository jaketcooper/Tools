package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.ads.AdRequest;

public final class zzii {
    private final byte[] zzbbf;
    private int zzbbg;
    private int zzbbh;
    private int[] zzbbi;
    private /* synthetic */ zzig zzbbj;

    private zzii(zzig zzig, byte[] bArr) {
        this.zzbbj = zzig;
        this.zzbbf = bArr;
    }

    public final zzii zzb(int[] iArr) {
        this.zzbbi = iArr;
        return this;
    }

    public final synchronized void zzbf() {
        try {
            if (this.zzbbj.zzbbe) {
                this.zzbbj.zzbbd.zzc(this.zzbbf);
                this.zzbbj.zzbbd.zzg(this.zzbbg);
                this.zzbbj.zzbbd.zzh(this.zzbbh);
                this.zzbbj.zzbbd.zza(this.zzbbi);
                this.zzbbj.zzbbd.zzbf();
            }
        } catch (RemoteException e) {
            if (zzafj.zzpt()) {
                Log.v(AdRequest.LOGTAG, "Clearcut log failed", e);
            }
        }
    }

    public final zzii zzp(int i) {
        this.zzbbg = i;
        return this;
    }

    public final zzii zzq(int i) {
        this.zzbbh = i;
        return this;
    }
}
