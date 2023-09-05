package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.zzbs;

@zzzb
public final class zzair {
    private final View mView;
    private boolean zzbap;
    private Activity zzdbn;
    private boolean zzdbo;
    private boolean zzdbp;
    private ViewTreeObserver.OnGlobalLayoutListener zzdbq;
    private ViewTreeObserver.OnScrollChangedListener zzdbr;

    public zzair(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.zzdbn = activity;
        this.mView = view;
        this.zzdbq = onGlobalLayoutListener;
        this.zzdbr = onScrollChangedListener;
    }

    private final void zzqq() {
        if (!this.zzdbo) {
            if (this.zzdbq != null) {
                if (this.zzdbn != null) {
                    zzbs.zzec();
                    zzagr.zza(this.zzdbn, this.zzdbq);
                }
                zzbs.zzez();
                zzakg.zza(this.mView, this.zzdbq);
            }
            if (this.zzdbr != null) {
                if (this.zzdbn != null) {
                    zzbs.zzec();
                    zzagr.zza(this.zzdbn, this.zzdbr);
                }
                zzbs.zzez();
                zzakg.zza(this.mView, this.zzdbr);
            }
            this.zzdbo = true;
        }
    }

    private final void zzqr() {
        if (this.zzdbn != null && this.zzdbo) {
            if (!(this.zzdbq == null || this.zzdbn == null)) {
                zzbs.zzee().zzb(this.zzdbn, this.zzdbq);
            }
            if (!(this.zzdbr == null || this.zzdbn == null)) {
                zzbs.zzec();
                zzagr.zzb(this.zzdbn, this.zzdbr);
            }
            this.zzdbo = false;
        }
    }

    public final void onAttachedToWindow() {
        this.zzdbp = true;
        if (this.zzbap) {
            zzqq();
        }
    }

    public final void onDetachedFromWindow() {
        this.zzdbp = false;
        zzqr();
    }

    public final void zzi(Activity activity) {
        this.zzdbn = activity;
    }

    public final void zzqo() {
        this.zzbap = true;
        if (this.zzdbp) {
            zzqq();
        }
    }

    public final void zzqp() {
        this.zzbap = false;
        zzqr();
    }
}
