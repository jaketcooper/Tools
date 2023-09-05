package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

final class zzcjq implements Runnable {
    private /* synthetic */ zzcff zzjec;
    private /* synthetic */ boolean zzjeu;
    private /* synthetic */ zzcjd zzjfy;
    private /* synthetic */ AtomicReference zzjfz;

    zzcjq(zzcjd zzcjd, AtomicReference atomicReference, zzcff zzcff, boolean z) {
        this.zzjfy = zzcjd;
        this.zzjfz = atomicReference;
        this.zzjec = zzcff;
        this.zzjeu = z;
    }

    /* JADX INFO: finally extract failed */
    public final void run() {
        synchronized (this.zzjfz) {
            try {
                zzcgb zzd = this.zzjfy.zzjfs;
                if (zzd == null) {
                    this.zzjfy.zzawn().zzays().log("Failed to get user properties");
                    this.zzjfz.notify();
                    return;
                }
                this.zzjfz.set(zzd.zza(this.zzjec, this.zzjeu));
                this.zzjfy.zzxg();
                this.zzjfz.notify();
            } catch (RemoteException e) {
                this.zzjfy.zzawn().zzays().zzj("Failed to get user properties", e);
                this.zzjfz.notify();
            } catch (Throwable th) {
                this.zzjfz.notify();
                throw th;
            }
        }
    }
}
