package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.stats.zza;

public final class zzcjr implements ServiceConnection, zzf, zzg {
    final /* synthetic */ zzcjd zzjfy;
    /* access modifiers changed from: private */
    public volatile boolean zzjgf;
    private volatile zzcgi zzjgg;

    protected zzcjr(zzcjd zzcjd) {
        this.zzjfy = zzcjd;
    }

    @MainThread
    public final void onConnected(@Nullable Bundle bundle) {
        zzbq.zzga("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.zzjgg = null;
                this.zzjfy.zzawm().zzg(new zzcju(this, (zzcgb) this.zzjgg.zzakc()));
            } catch (DeadObjectException | IllegalStateException e) {
                this.zzjgg = null;
                this.zzjgf = false;
            }
        }
    }

    @MainThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzbq.zzga("MeasurementServiceConnection.onConnectionFailed");
        zzcgj zzazm = this.zzjfy.zzitu.zzazm();
        if (zzazm != null) {
            zzazm.zzayu().zzj("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzjgf = false;
            this.zzjgg = null;
        }
        this.zzjfy.zzawm().zzg(new zzcjw(this));
    }

    @MainThread
    public final void onConnectionSuspended(int i) {
        zzbq.zzga("MeasurementServiceConnection.onConnectionSuspended");
        this.zzjfy.zzawn().zzayx().log("Service connection suspended");
        this.zzjfy.zzawm().zzg(new zzcjv(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008d A[SYNTHETIC, Splitter:B:39:0x008d] */
    @android.support.annotation.MainThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r5, android.os.IBinder r6) {
        /*
            r4 = this;
            r1 = 0
            java.lang.String r0 = "MeasurementServiceConnection.onServiceConnected"
            com.google.android.gms.common.internal.zzbq.zzga(r0)
            monitor-enter(r4)
            if (r6 != 0) goto L_0x001d
            r0 = 0
            r4.zzjgf = r0     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.zzcjd r0 = r4.zzjfy     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.zzcgj r0 = r0.zzawn()     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.zzcgl r0 = r0.zzays()     // Catch:{ all -> 0x0054 }
            java.lang.String r1 = "Service connected with null binder"
            r0.log(r1)     // Catch:{ all -> 0x0054 }
            monitor-exit(r4)     // Catch:{ all -> 0x0054 }
        L_0x001c:
            return
        L_0x001d:
            java.lang.String r0 = r6.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x006a }
            java.lang.String r2 = "com.google.android.gms.measurement.internal.IMeasurementService"
            boolean r2 = r2.equals(r0)     // Catch:{ RemoteException -> 0x006a }
            if (r2 == 0) goto L_0x007c
            if (r6 != 0) goto L_0x0057
            r0 = r1
        L_0x002c:
            com.google.android.gms.internal.zzcjd r1 = r4.zzjfy     // Catch:{ RemoteException -> 0x009e }
            com.google.android.gms.internal.zzcgj r1 = r1.zzawn()     // Catch:{ RemoteException -> 0x009e }
            com.google.android.gms.internal.zzcgl r1 = r1.zzayy()     // Catch:{ RemoteException -> 0x009e }
            java.lang.String r2 = "Bound to IMeasurementService interface"
            r1.log(r2)     // Catch:{ RemoteException -> 0x009e }
        L_0x003b:
            if (r0 != 0) goto L_0x008d
            r0 = 0
            r4.zzjgf = r0     // Catch:{ all -> 0x0054 }
            com.google.android.gms.common.stats.zza.zzalr()     // Catch:{ IllegalArgumentException -> 0x009c }
            com.google.android.gms.internal.zzcjd r0 = r4.zzjfy     // Catch:{ IllegalArgumentException -> 0x009c }
            android.content.Context r0 = r0.getContext()     // Catch:{ IllegalArgumentException -> 0x009c }
            com.google.android.gms.internal.zzcjd r1 = r4.zzjfy     // Catch:{ IllegalArgumentException -> 0x009c }
            com.google.android.gms.internal.zzcjr r1 = r1.zzjfr     // Catch:{ IllegalArgumentException -> 0x009c }
            r0.unbindService(r1)     // Catch:{ IllegalArgumentException -> 0x009c }
        L_0x0052:
            monitor-exit(r4)     // Catch:{ all -> 0x0054 }
            goto L_0x001c
        L_0x0054:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0054 }
            throw r0
        L_0x0057:
            java.lang.String r0 = "com.google.android.gms.measurement.internal.IMeasurementService"
            android.os.IInterface r0 = r6.queryLocalInterface(r0)     // Catch:{ RemoteException -> 0x006a }
            boolean r2 = r0 instanceof com.google.android.gms.internal.zzcgb     // Catch:{ RemoteException -> 0x006a }
            if (r2 == 0) goto L_0x0064
            com.google.android.gms.internal.zzcgb r0 = (com.google.android.gms.internal.zzcgb) r0     // Catch:{ RemoteException -> 0x006a }
            goto L_0x002c
        L_0x0064:
            com.google.android.gms.internal.zzcgd r0 = new com.google.android.gms.internal.zzcgd     // Catch:{ RemoteException -> 0x006a }
            r0.<init>(r6)     // Catch:{ RemoteException -> 0x006a }
            goto L_0x002c
        L_0x006a:
            r0 = move-exception
            r0 = r1
        L_0x006c:
            com.google.android.gms.internal.zzcjd r1 = r4.zzjfy     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.zzcgj r1 = r1.zzawn()     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.zzcgl r1 = r1.zzays()     // Catch:{ all -> 0x0054 }
            java.lang.String r2 = "Service connect failed to get IMeasurementService"
            r1.log(r2)     // Catch:{ all -> 0x0054 }
            goto L_0x003b
        L_0x007c:
            com.google.android.gms.internal.zzcjd r2 = r4.zzjfy     // Catch:{ RemoteException -> 0x006a }
            com.google.android.gms.internal.zzcgj r2 = r2.zzawn()     // Catch:{ RemoteException -> 0x006a }
            com.google.android.gms.internal.zzcgl r2 = r2.zzays()     // Catch:{ RemoteException -> 0x006a }
            java.lang.String r3 = "Got binder with a wrong descriptor"
            r2.zzj(r3, r0)     // Catch:{ RemoteException -> 0x006a }
            r0 = r1
            goto L_0x003b
        L_0x008d:
            com.google.android.gms.internal.zzcjd r1 = r4.zzjfy     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.zzche r1 = r1.zzawm()     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.zzcjs r2 = new com.google.android.gms.internal.zzcjs     // Catch:{ all -> 0x0054 }
            r2.<init>(r4, r0)     // Catch:{ all -> 0x0054 }
            r1.zzg(r2)     // Catch:{ all -> 0x0054 }
            goto L_0x0052
        L_0x009c:
            r0 = move-exception
            goto L_0x0052
        L_0x009e:
            r1 = move-exception
            goto L_0x006c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcjr.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        zzbq.zzga("MeasurementServiceConnection.onServiceDisconnected");
        this.zzjfy.zzawn().zzayx().log("Service disconnected");
        this.zzjfy.zzawm().zzg(new zzcjt(this, componentName));
    }

    @WorkerThread
    public final void zzbaj() {
        this.zzjfy.zzut();
        Context context = this.zzjfy.getContext();
        synchronized (this) {
            if (this.zzjgf) {
                this.zzjfy.zzawn().zzayy().log("Connection attempt already in progress");
            } else if (this.zzjgg != null) {
                this.zzjfy.zzawn().zzayy().log("Already awaiting connection attempt");
            } else {
                this.zzjgg = new zzcgi(context, Looper.getMainLooper(), this, this);
                this.zzjfy.zzawn().zzayy().log("Connecting to remote service");
                this.zzjgf = true;
                this.zzjgg.zzajy();
            }
        }
    }

    @WorkerThread
    public final void zzn(Intent intent) {
        this.zzjfy.zzut();
        Context context = this.zzjfy.getContext();
        zza zzalr = zza.zzalr();
        synchronized (this) {
            if (this.zzjgf) {
                this.zzjfy.zzawn().zzayy().log("Connection attempt already in progress");
                return;
            }
            this.zzjfy.zzawn().zzayy().log("Using local app measurement service");
            this.zzjgf = true;
            zzalr.zza(context, intent, this.zzjfy.zzjfr, 129);
        }
    }
}
