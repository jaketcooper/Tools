package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzamt implements Runnable {
    private /* synthetic */ zzamr zzdkl;
    private /* synthetic */ int zzdkm;
    private /* synthetic */ int zzdkn;
    private /* synthetic */ boolean zzdko;
    private /* synthetic */ boolean zzdkp;

    zzamt(zzamr zzamr, int i, int i2, boolean z, boolean z2) {
        this.zzdkl = zzamr;
        this.zzdkm = i;
        this.zzdkn = i2;
        this.zzdko = z;
        this.zzdkp = z2;
    }

    public final void run() {
        boolean z = false;
        synchronized (this.zzdkl.lock) {
            boolean z2 = this.zzdkm != this.zzdkn;
            boolean z3 = !this.zzdkl.zzdkh && this.zzdkn == 1;
            boolean z4 = z2 && this.zzdkn == 1;
            boolean z5 = z2 && this.zzdkn == 2;
            boolean z6 = z2 && this.zzdkn == 3;
            boolean z7 = this.zzdko != this.zzdkp;
            zzamr zzamr = this.zzdkl;
            if (this.zzdkl.zzdkh || z3) {
                z = true;
            }
            boolean unused = zzamr.zzdkh = z;
            if (this.zzdkl.zzcdw != null) {
                if (z3) {
                    try {
                        this.zzdkl.zzcdw.onVideoStart();
                    } catch (RemoteException e) {
                        zzafj.zzc("Unable to call onVideoStart()", e);
                    }
                }
                if (z4) {
                    try {
                        this.zzdkl.zzcdw.onVideoPlay();
                    } catch (RemoteException e2) {
                        zzafj.zzc("Unable to call onVideoPlay()", e2);
                    }
                }
                if (z5) {
                    try {
                        this.zzdkl.zzcdw.onVideoPause();
                    } catch (RemoteException e3) {
                        zzafj.zzc("Unable to call onVideoPause()", e3);
                    }
                }
                if (z6) {
                    try {
                        this.zzdkl.zzcdw.onVideoEnd();
                    } catch (RemoteException e4) {
                        zzafj.zzc("Unable to call onVideoEnd()", e4);
                    }
                }
                if (z7) {
                    try {
                        this.zzdkl.zzcdw.onVideoMute(this.zzdkp);
                    } catch (RemoteException e5) {
                        zzafj.zzc("Unable to call onVideoMute()", e5);
                    }
                }
            }
        }
    }
}
