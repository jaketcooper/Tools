package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.atomic.AtomicBoolean;

@zzzb
public abstract class zzwz implements zzahi<Void>, zzamf {
    protected final Context mContext;
    protected final zzama zzbwq;
    private zzxg zzchu;
    private zzaev zzchv;
    protected zzaad zzchw;
    private Runnable zzchx;
    private Object zzchy = new Object();
    /* access modifiers changed from: private */
    public AtomicBoolean zzchz = new AtomicBoolean(true);

    protected zzwz(Context context, zzaev zzaev, zzama zzama, zzxg zzxg) {
        this.mContext = context;
        this.zzchv = zzaev;
        this.zzchw = this.zzchv.zzcwe;
        this.zzbwq = zzama;
        this.zzchu = zzxg;
    }

    public void cancel() {
        if (this.zzchz.getAndSet(false)) {
            this.zzbwq.stopLoading();
            zzbs.zzee();
            zzagw.zzh(this.zzbwq);
            zzx(-1);
            zzagr.zzczc.removeCallbacks(this.zzchx);
        }
    }

    public final void zza(zzama zzama, boolean z) {
        int i = 0;
        zzafj.zzbw("WebView finished loading.");
        if (this.zzchz.getAndSet(false)) {
            if (z) {
                i = -2;
            }
            zzx(i);
            zzagr.zzczc.removeCallbacks(this.zzchx);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzmw();

    public final /* synthetic */ Object zzmx() {
        zzbq.zzga("Webview render task needs to be called on UI thread.");
        this.zzchx = new zzxa(this);
        zzagr.zzczc.postDelayed(this.zzchx, ((Long) zzbs.zzep().zzd(zzmq.zzblt)).longValue());
        zzmw();
        return null;
    }

    /* access modifiers changed from: protected */
    public void zzx(int i) {
        if (i != -2) {
            this.zzchw = new zzaad(i, this.zzchw.zzccb);
        }
        this.zzbwq.zzsk();
        zzxg zzxg = this.zzchu;
        zzzz zzzz = this.zzchv.zzcpe;
        zzxg zzxg2 = zzxg;
        zzxg2.zzb(new zzaeu(zzzz.zzclo, this.zzbwq, this.zzchw.zzcbv, i, this.zzchw.zzcbw, this.zzchw.zzcni, this.zzchw.orientation, this.zzchw.zzccb, zzzz.zzclr, this.zzchw.zzcng, (zztm) null, (zzuf) null, (String) null, (zztn) null, (zztp) null, this.zzchw.zzcnh, this.zzchv.zzath, this.zzchw.zzcnf, this.zzchv.zzcvw, this.zzchw.zzcnk, this.zzchw.zzcnl, this.zzchv.zzcvq, (zzoc) null, this.zzchw.zzcnv, this.zzchw.zzcnw, this.zzchw.zzcnx, this.zzchw.zzcny, this.zzchw.zzcnz, (String) null, this.zzchw.zzcby, this.zzchw.zzcoc, this.zzchv.zzcwc, this.zzchv.zzcwe.zzapy, this.zzchv.zzcwd));
    }
}
