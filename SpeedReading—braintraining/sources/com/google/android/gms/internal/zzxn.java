package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzba;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzzb
public final class zzxn extends zzafh {
    private final Object mLock;
    /* access modifiers changed from: private */
    public final zzxg zzchu;
    private final zzaev zzchv;
    private final zzaad zzchw;
    private final zzxr zzcil;
    private Future<zzaeu> zzcim;

    public zzxn(Context context, zzba zzba, zzaev zzaev, zzcs zzcs, zzxg zzxg, zznd zznd) {
        this(zzaev, zzxg, new zzxr(context, zzba, new zzahy(context), zzcs, zzaev, zznd));
    }

    private zzxn(zzaev zzaev, zzxg zzxg, zzxr zzxr) {
        this.mLock = new Object();
        this.zzchv = zzaev;
        this.zzchw = zzaev.zzcwe;
        this.zzchu = zzxg;
        this.zzcil = zzxr;
    }

    public final void onStop() {
        synchronized (this.mLock) {
            if (this.zzcim != null) {
                this.zzcim.cancel(true);
            }
        }
    }

    public final void zzdg() {
        zzaeu zzaeu;
        int i = -2;
        try {
            synchronized (this.mLock) {
                this.zzcim = zzagl.zza((ExecutorService) zzagl.zzcyx, this.zzcil);
            }
            zzaeu = this.zzcim.get(60000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            zzafj.zzco("Timed out waiting for native ad.");
            i = 2;
            this.zzcim.cancel(true);
            zzaeu = null;
        } catch (ExecutionException e2) {
            i = 0;
            zzaeu = null;
        } catch (InterruptedException e3) {
            i = 0;
            zzaeu = null;
        } catch (CancellationException e4) {
            i = 0;
            zzaeu = null;
        }
        if (zzaeu == null) {
            zzaeu = new zzaeu(this.zzchv.zzcpe.zzclo, (zzama) null, (List<String>) null, i, (List<String>) null, (List<String>) null, this.zzchw.orientation, this.zzchw.zzccb, this.zzchv.zzcpe.zzclr, false, (zztm) null, (zzuf) null, (String) null, (zztn) null, (zztp) null, this.zzchw.zzcnh, this.zzchv.zzath, this.zzchw.zzcnf, this.zzchv.zzcvw, this.zzchw.zzcnk, this.zzchw.zzcnl, this.zzchv.zzcvq, (zzoc) null, (zzadw) null, (List<String>) null, (List<String>) null, this.zzchv.zzcwe.zzcny, this.zzchv.zzcwe.zzcnz, (String) null, (List<String>) null, this.zzchw.zzcoc, this.zzchv.zzcwc, this.zzchv.zzcwe.zzapy, false);
        }
        zzagr.zzczc.post(new zzxo(this, zzaeu));
    }
}
