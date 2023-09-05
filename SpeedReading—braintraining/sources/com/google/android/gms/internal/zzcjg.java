package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

final class zzcjg implements Runnable {
    private /* synthetic */ zzcff zzjec;
    private /* synthetic */ zzcjd zzjfy;
    private /* synthetic */ AtomicReference zzjfz;

    zzcjg(zzcjd zzcjd, AtomicReference atomicReference, zzcff zzcff) {
        this.zzjfy = zzcjd;
        this.zzjfz = atomicReference;
        this.zzjec = zzcff;
    }

    /* JADX INFO: finally extract failed */
    public final void run() {
        synchronized (this.zzjfz) {
            try {
                zzcgb zzd = this.zzjfy.zzjfs;
                if (zzd == null) {
                    this.zzjfy.zzawn().zzays().log("Failed to get app instance id");
                    this.zzjfz.notify();
                    return;
                }
                this.zzjfz.set(zzd.zzc(this.zzjec));
                String str = (String) this.zzjfz.get();
                if (str != null) {
                    this.zzjfy.zzawb().zzjk(str);
                    this.zzjfy.zzawo().zzjam.zzjl(str);
                }
                this.zzjfy.zzxg();
                this.zzjfz.notify();
            } catch (RemoteException e) {
                this.zzjfy.zzawn().zzays().zzj("Failed to get app instance id", e);
                this.zzjfz.notify();
            } catch (Throwable th) {
                this.zzjfz.notify();
                throw th;
            }
        }
    }
}
