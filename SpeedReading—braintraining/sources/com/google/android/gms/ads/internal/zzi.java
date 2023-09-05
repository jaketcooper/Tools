package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.gmsg.zzx;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzaeh;
import com.google.android.gms.internal.zzaeu;
import com.google.android.gms.internal.zzaev;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzagr;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzamm;
import com.google.android.gms.internal.zzanp;
import com.google.android.gms.internal.zzfb;
import com.google.android.gms.internal.zziw;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zznj;
import com.google.android.gms.internal.zzoc;
import com.google.android.gms.internal.zztm;
import com.google.android.gms.internal.zztp;
import com.google.android.gms.internal.zzuc;
import com.google.android.gms.internal.zzuf;
import com.google.android.gms.internal.zzwh;
import com.google.android.gms.internal.zzxf;
import com.google.android.gms.internal.zzzb;

@zzzb
public class zzi extends zzd implements zzae, zzwh {
    private boolean zzane;

    public zzi(Context context, zziw zziw, String str, zzuc zzuc, zzaiy zzaiy, zzv zzv) {
        super(context, zziw, str, zzuc, zzaiy, zzv);
    }

    /* access modifiers changed from: protected */
    public zzama zza(zzaev zzaev, @Nullable zzw zzw, @Nullable zzaeh zzaeh) throws zzamm {
        View nextView = this.zzamt.zzate.getNextView();
        if (nextView instanceof zzama) {
            ((zzama) nextView).destroy();
        }
        if (nextView != null) {
            this.zzamt.zzate.removeView(nextView);
        }
        zzama zza = zzbs.zzed().zza(this.zzamt.zzaif, zzanp.zzc(this.zzamt.zzath), this.zzamt.zzath.zzbda, false, false, this.zzamt.zzatc, this.zzamt.zzatd, this.zzamo, this, this.zzamw, zzaev.zzcwc);
        if (this.zzamt.zzath.zzbdc == null) {
            if (zza == null) {
                throw null;
            }
            zzb((View) zza);
        }
        zza.zzsq().zza(this, this, this, this, false, (zzx) null, zzw, this, zzaeh);
        zza(zza);
        zza.zzcu(zzaev.zzcpe.zzcmb);
        return zza;
    }

    public final void zza(int i, int i2, int i3, int i4) {
        zzbr();
    }

    /* access modifiers changed from: protected */
    public void zza(zzaev zzaev, zznd zznd) {
        if (zzaev.errorCode != -2) {
            zzagr.zzczc.post(new zzk(this, zzaev));
            return;
        }
        if (zzaev.zzath != null) {
            this.zzamt.zzath = zzaev.zzath;
        }
        if (!zzaev.zzcwe.zzcng || zzaev.zzcwe.zzbdf) {
            zzagr.zzczc.post(new zzl(this, zzaev, this.zzamw.zzans.zza(this.zzamt.zzaif, this.zzamt.zzatd, zzaev.zzcwe), zznd));
            return;
        }
        this.zzamt.zzaue = 0;
        zzbt zzbt = this.zzamt;
        zzbs.zzeb();
        zzbt.zzatg = zzxf.zza(this.zzamt.zzaif, this, zzaev, this.zzamt.zzatc, (zzama) null, this.zzanb, this, zznd);
    }

    /* access modifiers changed from: protected */
    public final void zza(zzama zzama) {
        zzama.zza("/trackActiveViewUnit", (zzt<? super zzama>) new zzj(this));
    }

    public final void zza(zznj zznj) {
        zzbq.zzga("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzamt.zzaty = zznj;
    }

    /* access modifiers changed from: protected */
    public boolean zza(@Nullable zzaeu zzaeu, zzaeu zzaeu2) {
        if (this.zzamt.zzfg() && this.zzamt.zzate != null) {
            this.zzamt.zzate.zzfj().zzcj(zzaeu2.zzcnl);
        }
        try {
            if (zzaeu2.zzchj != null && !zzaeu2.zzcng && zzaeu2.zzcwd) {
                if (((Boolean) zzbs.zzep().zzd(zzmq.zzbqb)).booleanValue()) {
                    String str = zzaeu2.zzclo.zzbcj;
                    if ((str == null || "com.google.ads.mediation.AbstractAdViewAdapter".equals(str)) && !zzaeu2.zzclo.extras.containsKey("sdk_less_server_data")) {
                        try {
                            zzaeu2.zzchj.zztc();
                        } catch (Throwable th) {
                            zzafj.m11v("Could not render test Ad label.");
                        }
                    }
                }
            }
        } catch (RuntimeException e) {
            zzafj.m11v("Could not render test AdLabel.");
        }
        return super.zza(zzaeu, zzaeu2);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzama zzama) {
        if (this.zzamt.zzati != null) {
            zzfb zzfb = this.zzamv;
            zziw zziw = this.zzamt.zzath;
            zzaeu zzaeu = this.zzamt.zzati;
            if (zzama == null) {
                throw null;
            }
            zzfb.zza(zziw, zzaeu, (View) zzama, zzama);
            this.zzane = false;
            return;
        }
        this.zzane = true;
        zzafj.zzco("Request to enable ActiveView before adState is available.");
    }

    /* access modifiers changed from: protected */
    public void zzbs() {
        super.zzbs();
        if (this.zzane) {
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzbnd)).booleanValue()) {
                zzb(this.zzamt.zzati.zzchj);
            }
        }
    }

    public final void zzc(View view) {
        this.zzamt.zzaud = view;
        zzb(new zzaeu(this.zzamt.zzatj, (zzama) null, (zztm) null, (zzuf) null, (String) null, (zztp) null, (zzoc) null, (String) null));
    }

    public final void zzcm() {
        onAdClicked();
    }

    public final void zzcn() {
        recordImpression();
        zzbo();
    }

    public final void zzco() {
        zzbp();
    }
}
