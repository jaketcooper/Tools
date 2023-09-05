package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.stats.zza;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.zze;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class zzcjd extends zzcii {
    /* access modifiers changed from: private */
    public final zzcjr zzjfr;
    /* access modifiers changed from: private */
    public zzcgb zzjfs;
    private volatile Boolean zzjft;
    private final zzcfp zzjfu;
    private final zzckh zzjfv;
    private final List<Runnable> zzjfw = new ArrayList();
    private final zzcfp zzjfx;

    protected zzcjd(zzchj zzchj) {
        super(zzchj);
        this.zzjfv = new zzckh(zzchj.zzwh());
        this.zzjfr = new zzcjr(this);
        this.zzjfu = new zzcje(this, zzchj);
        this.zzjfx = new zzcjj(this, zzchj);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void onServiceDisconnected(ComponentName componentName) {
        zzut();
        if (this.zzjfs != null) {
            this.zzjfs = null;
            zzawn().zzayy().zzj("Disconnected from device MeasurementService", componentName);
            zzut();
            zzxr();
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzbai() {
        zzut();
        zzawn().zzayy().zzj("Processing queued up service tasks", Integer.valueOf(this.zzjfw.size()));
        for (Runnable run : this.zzjfw) {
            try {
                run.run();
            } catch (Throwable th) {
                zzawn().zzays().zzj("Task exception while flushing queue", th);
            }
        }
        this.zzjfw.clear();
        this.zzjfx.cancel();
    }

    @Nullable
    @WorkerThread
    private final zzcff zzbq(boolean z) {
        return zzawc().zzjb(z ? zzawn().zzayz() : null);
    }

    @WorkerThread
    private final void zzj(Runnable runnable) throws IllegalStateException {
        zzut();
        if (isConnected()) {
            runnable.run();
        } else if (((long) this.zzjfw.size()) >= 1000) {
            zzawn().zzays().log("Discarding data. Max runnable queue size reached");
        } else {
            this.zzjfw.add(runnable);
            this.zzjfx.zzr(60000);
            zzxr();
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzxg() {
        zzut();
        this.zzjfv.start();
        this.zzjfu.zzr(zzcfz.zziyy.get().longValue());
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzxh() {
        zzut();
        if (isConnected()) {
            zzawn().zzayy().log("Inactivity, disconnecting from the service");
            disconnect();
        }
    }

    @WorkerThread
    public final void disconnect() {
        zzut();
        zzwu();
        try {
            zza.zzalr();
            getContext().unbindService(this.zzjfr);
        } catch (IllegalArgumentException | IllegalStateException e) {
        }
        this.zzjfs = null;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public final boolean isConnected() {
        zzut();
        zzwu();
        return this.zzjfs != null;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void resetAnalyticsData() {
        zzut();
        zzwu();
        zzcff zzbq = zzbq(false);
        zzawg().resetAnalyticsData();
        zzj(new zzcjf(this, zzbq));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzcgb zzcgb) {
        zzut();
        zzbq.checkNotNull(zzcgb);
        this.zzjfs = zzcgb;
        zzxg();
        zzbai();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(zzcgb zzcgb, zzbej zzbej, zzcff zzcff) {
        zzut();
        zzwu();
        int i = 100;
        for (int i2 = 0; i2 < 1001 && i == 100; i2++) {
            ArrayList arrayList = new ArrayList();
            List<zzbej> zzec = zzawg().zzec(100);
            if (zzec != null) {
                arrayList.addAll(zzec);
                i = zzec.size();
            } else {
                i = 0;
            }
            if (zzbej != null && i < 100) {
                arrayList.add(zzbej);
            }
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                zzbej zzbej2 = (zzbej) obj;
                if (zzbej2 instanceof zzcfx) {
                    try {
                        zzcgb.zza((zzcfx) zzbej2, zzcff);
                    } catch (RemoteException e) {
                        zzawn().zzays().zzj("Failed to send event to the service", e);
                    }
                } else if (zzbej2 instanceof zzckk) {
                    try {
                        zzcgb.zza((zzckk) zzbej2, zzcff);
                    } catch (RemoteException e2) {
                        zzawn().zzays().zzj("Failed to send attribute to the service", e2);
                    }
                } else if (zzbej2 instanceof zzcfi) {
                    try {
                        zzcgb.zza((zzcfi) zzbej2, zzcff);
                    } catch (RemoteException e3) {
                        zzawn().zzays().zzj("Failed to send conditional property to the service", e3);
                    }
                } else {
                    zzawn().zzays().log("Discarding data. Unrecognized parcel type.");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AppMeasurement.zzb zzb) {
        zzut();
        zzwu();
        zzj(new zzcji(this, zzb));
    }

    @WorkerThread
    public final void zza(AtomicReference<String> atomicReference) {
        zzut();
        zzwu();
        zzj(new zzcjg(this, atomicReference, zzbq(false)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzcfi>> atomicReference, String str, String str2, String str3) {
        zzut();
        zzwu();
        zzj(new zzcjn(this, atomicReference, str, str2, str3, zzbq(false)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzckk>> atomicReference, String str, String str2, String str3, boolean z) {
        zzut();
        zzwu();
        zzj(new zzcjo(this, atomicReference, str, str2, str3, z, zzbq(false)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzckk>> atomicReference, boolean z) {
        zzut();
        zzwu();
        zzj(new zzcjq(this, atomicReference, zzbq(false), z));
    }

    public final /* bridge */ /* synthetic */ void zzavx() {
        super.zzavx();
    }

    public final /* bridge */ /* synthetic */ void zzavy() {
        super.zzavy();
    }

    public final /* bridge */ /* synthetic */ zzcfa zzavz() {
        return super.zzavz();
    }

    public final /* bridge */ /* synthetic */ zzcfh zzawa() {
        return super.zzawa();
    }

    public final /* bridge */ /* synthetic */ zzcik zzawb() {
        return super.zzawb();
    }

    public final /* bridge */ /* synthetic */ zzcge zzawc() {
        return super.zzawc();
    }

    public final /* bridge */ /* synthetic */ zzcfr zzawd() {
        return super.zzawd();
    }

    public final /* bridge */ /* synthetic */ zzcjd zzawe() {
        return super.zzawe();
    }

    public final /* bridge */ /* synthetic */ zzciz zzawf() {
        return super.zzawf();
    }

    public final /* bridge */ /* synthetic */ zzcgf zzawg() {
        return super.zzawg();
    }

    public final /* bridge */ /* synthetic */ zzcfl zzawh() {
        return super.zzawh();
    }

    public final /* bridge */ /* synthetic */ zzcgh zzawi() {
        return super.zzawi();
    }

    public final /* bridge */ /* synthetic */ zzckn zzawj() {
        return super.zzawj();
    }

    public final /* bridge */ /* synthetic */ zzchd zzawk() {
        return super.zzawk();
    }

    public final /* bridge */ /* synthetic */ zzckc zzawl() {
        return super.zzawl();
    }

    public final /* bridge */ /* synthetic */ zzche zzawm() {
        return super.zzawm();
    }

    public final /* bridge */ /* synthetic */ zzcgj zzawn() {
        return super.zzawn();
    }

    public final /* bridge */ /* synthetic */ zzcgu zzawo() {
        return super.zzawo();
    }

    public final /* bridge */ /* synthetic */ zzcfk zzawp() {
        return super.zzawp();
    }

    /* access modifiers changed from: protected */
    public final boolean zzaxo() {
        return false;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzb(zzckk zzckk) {
        zzut();
        zzwu();
        zzj(new zzcjp(this, zzawg().zza(zzckk), zzckk, zzbq(true)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzbaf() {
        zzut();
        zzwu();
        zzj(new zzcjk(this, zzbq(true)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzbag() {
        zzut();
        zzwu();
        zzj(new zzcjh(this, zzbq(true)));
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzbah() {
        return this.zzjft;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzc(zzcfx zzcfx, String str) {
        zzbq.checkNotNull(zzcfx);
        zzut();
        zzwu();
        zzj(new zzcjl(this, true, zzawg().zza(zzcfx), zzcfx, zzbq(true), str));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzf(zzcfi zzcfi) {
        zzbq.checkNotNull(zzcfi);
        zzut();
        zzwu();
        zzj(new zzcjm(this, true, zzawg().zzc(zzcfi), new zzcfi(zzcfi), zzbq(true), zzcfi));
    }

    public final /* bridge */ /* synthetic */ void zzut() {
        super.zzut();
    }

    public final /* bridge */ /* synthetic */ zzd zzwh() {
        return super.zzwh();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzxr() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        zzut();
        zzwu();
        if (!isConnected()) {
            if (this.zzjft == null) {
                zzut();
                zzwu();
                Boolean zzazd = zzawo().zzazd();
                if (zzazd == null || !zzazd.booleanValue()) {
                    if (zzawc().zzayq() != 1) {
                        zzawn().zzayy().log("Checking service availability");
                        int isGooglePlayServicesAvailable = zze.zzafn().isGooglePlayServicesAvailable(zzawj().getContext());
                        switch (isGooglePlayServicesAvailable) {
                            case 0:
                                zzawn().zzayy().log("Service available");
                                z = true;
                                z2 = true;
                                break;
                            case 1:
                                zzawn().zzayy().log("Service missing");
                                z = true;
                                z2 = false;
                                break;
                            case 2:
                                zzawn().zzayx().log("Service container out of date");
                                zzckn zzawj = zzawj();
                                zze.zzafn();
                                if (zze.zzcd(zzawj.getContext()) >= 11400) {
                                    Boolean zzazd2 = zzawo().zzazd();
                                    z2 = zzazd2 == null || zzazd2.booleanValue();
                                    z = false;
                                    break;
                                } else {
                                    z = true;
                                    z2 = false;
                                    break;
                                }
                                break;
                            case 3:
                                zzawn().zzayu().log("Service disabled");
                                z = false;
                                z2 = false;
                                break;
                            case 9:
                                zzawn().zzayu().log("Service invalid");
                                z = false;
                                z2 = false;
                                break;
                            case 18:
                                zzawn().zzayu().log("Service updating");
                                z = true;
                                z2 = true;
                                break;
                            default:
                                zzawn().zzayu().zzj("Unexpected service status", Integer.valueOf(isGooglePlayServicesAvailable));
                                z = false;
                                z2 = false;
                                break;
                        }
                    } else {
                        z = true;
                        z2 = true;
                    }
                    if (z) {
                        zzawo().zzbl(z2);
                    }
                } else {
                    z2 = true;
                }
                this.zzjft = Boolean.valueOf(z2);
            }
            if (this.zzjft.booleanValue()) {
                this.zzjfr.zzbaj();
                return;
            }
            List<ResolveInfo> queryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
            if (queryIntentServices == null || queryIntentServices.size() <= 0) {
                z3 = false;
            }
            if (z3) {
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                intent.setComponent(new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
                this.zzjfr.zzn(intent);
                return;
            }
            zzawn().zzays().log("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
        }
    }
}
