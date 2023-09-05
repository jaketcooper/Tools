package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.gmsg.zzd;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.zzba;
import com.google.android.gms.ads.internal.zzbl;
import com.google.android.gms.ads.internal.zzbs;
import java.lang.ref.WeakReference;

@zzzb
public final class zzxy {
    private final Context mContext;
    private final Object mLock = new Object();
    private final zznd zzamo;
    private int zzaug = -1;
    private int zzauh = -1;
    private zzail zzaui;
    private final zzcs zzbta;
    private final zzaev zzchv;
    /* access modifiers changed from: private */
    public final zzba zzcjq;
    private ViewTreeObserver.OnGlobalLayoutListener zzcjr;
    private ViewTreeObserver.OnScrollChangedListener zzcjs;

    public zzxy(Context context, zzcs zzcs, zzaev zzaev, zznd zznd, zzba zzba) {
        this.mContext = context;
        this.zzbta = zzcs;
        this.zzchv = zzaev;
        this.zzamo = zznd;
        this.zzcjq = zzba;
        this.zzaui = new zzail(200);
    }

    /* access modifiers changed from: private */
    public final ViewTreeObserver.OnGlobalLayoutListener zza(WeakReference<zzama> weakReference) {
        if (this.zzcjr == null) {
            this.zzcjr = new zzye(this, weakReference);
        }
        return this.zzcjr;
    }

    /* access modifiers changed from: private */
    public final void zza(WeakReference<zzama> weakReference, boolean z) {
        zzama zzama;
        if (weakReference != null && (zzama = (zzama) weakReference.get()) != null) {
            if (zzama == null) {
                throw null;
            } else if (((View) zzama) == null) {
            } else {
                if (z && !this.zzaui.tryAcquire()) {
                    return;
                }
                if (zzama == null) {
                    throw null;
                }
                int[] iArr = new int[2];
                ((View) zzama).getLocationOnScreen(iArr);
                zzjk.zzhx();
                int zzd = zzais.zzd(this.mContext, iArr[0]);
                zzjk.zzhx();
                int zzd2 = zzais.zzd(this.mContext, iArr[1]);
                synchronized (this.mLock) {
                    if (!(this.zzaug == zzd && this.zzauh == zzd2)) {
                        this.zzaug = zzd;
                        this.zzauh = zzd2;
                        zzama.zzsq().zza(this.zzaug, this.zzauh, !z);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final ViewTreeObserver.OnScrollChangedListener zzb(WeakReference<zzama> weakReference) {
        if (this.zzcjs == null) {
            this.zzcjs = new zzyf(this, weakReference);
        }
        return this.zzcjs;
    }

    /* access modifiers changed from: private */
    public final void zzf(zzama zzama) {
        zzamb zzsq = zzama.zzsq();
        zzsq.zza("/video", (zzt<? super zzama>) zzd.zzbvn);
        zzsq.zza("/videoMeta", (zzt<? super zzama>) zzd.zzbvo);
        zzsq.zza("/precache", (zzt<? super zzama>) new zzalx());
        zzsq.zza("/delayPageLoaded", (zzt<? super zzama>) zzd.zzbvr);
        zzsq.zza("/instrument", (zzt<? super zzama>) zzd.zzbvp);
        zzsq.zza("/log", (zzt<? super zzama>) zzd.zzbvi);
        zzsq.zza("/videoClicked", (zzt<? super zzama>) zzd.zzbvj);
        zzsq.zza("/trackActiveViewUnit", (zzt<? super zzama>) new zzyc(this));
        zzsq.zza("/untrackActiveViewUnit", (zzt<? super zzama>) new zzyd(this));
    }

    /* access modifiers changed from: package-private */
    public final zzama zznd() throws zzamm {
        return zzbs.zzed().zza(this.mContext, zzanp.zztw(), "native-video", false, false, this.zzbta, this.zzchv.zzcpe.zzatd, this.zzamo, (zzbl) null, this.zzcjq.zzbk(), this.zzchv.zzcwc);
    }
}
