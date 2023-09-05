package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

final class zzcjo implements Runnable {
    private /* synthetic */ String zziju;
    private /* synthetic */ zzcff zzjec;
    private /* synthetic */ String zzjef;
    private /* synthetic */ String zzjeg;
    private /* synthetic */ boolean zzjeu;
    private /* synthetic */ zzcjd zzjfy;
    private /* synthetic */ AtomicReference zzjfz;

    zzcjo(zzcjd zzcjd, AtomicReference atomicReference, String str, String str2, String str3, boolean z, zzcff zzcff) {
        this.zzjfy = zzcjd;
        this.zzjfz = atomicReference;
        this.zziju = str;
        this.zzjef = str2;
        this.zzjeg = str3;
        this.zzjeu = z;
        this.zzjec = zzcff;
    }

    /* JADX INFO: finally extract failed */
    public final void run() {
        synchronized (this.zzjfz) {
            try {
                zzcgb zzd = this.zzjfy.zzjfs;
                if (zzd == null) {
                    this.zzjfy.zzawn().zzays().zzd("Failed to get user properties", zzcgj.zzjf(this.zziju), this.zzjef, this.zzjeg);
                    this.zzjfz.set(Collections.emptyList());
                    this.zzjfz.notify();
                    return;
                }
                if (TextUtils.isEmpty(this.zziju)) {
                    this.zzjfz.set(zzd.zza(this.zzjef, this.zzjeg, this.zzjeu, this.zzjec));
                } else {
                    this.zzjfz.set(zzd.zza(this.zziju, this.zzjef, this.zzjeg, this.zzjeu));
                }
                this.zzjfy.zzxg();
                this.zzjfz.notify();
            } catch (RemoteException e) {
                this.zzjfy.zzawn().zzays().zzd("Failed to get user properties", zzcgj.zzjf(this.zziju), this.zzjef, e);
                this.zzjfz.set(Collections.emptyList());
                this.zzjfz.notify();
            } catch (Throwable th) {
                this.zzjfz.notify();
                throw th;
            }
        }
    }
}
