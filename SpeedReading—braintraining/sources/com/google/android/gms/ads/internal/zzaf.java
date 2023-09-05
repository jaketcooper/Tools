package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzagl;
import com.google.android.gms.internal.zzais;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zzco;
import com.google.android.gms.internal.zzcr;
import com.google.android.gms.internal.zzjk;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzzb;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@zzzb
public final class zzaf implements zzco, Runnable {
    private Context zzaif;
    private final List<Object[]> zzaof;
    private final AtomicReference<zzco> zzaog;
    private zzaiy zzaoh;
    private CountDownLatch zzaoi;

    private zzaf(Context context, zzaiy zzaiy) {
        this.zzaof = new Vector();
        this.zzaog = new AtomicReference<>();
        this.zzaoi = new CountDownLatch(1);
        this.zzaif = context;
        this.zzaoh = zzaiy;
        zzjk.zzhx();
        if (zzais.zzqt()) {
            zzagl.zza(this);
        } else {
            run();
        }
    }

    public zzaf(zzbt zzbt) {
        this(zzbt.zzaif, zzbt.zzatd);
    }

    private final boolean zzcx() {
        try {
            this.zzaoi.await();
            return true;
        } catch (InterruptedException e) {
            zzafj.zzc("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    private final void zzcy() {
        if (!this.zzaof.isEmpty()) {
            for (Object[] next : this.zzaof) {
                if (next.length == 1) {
                    this.zzaog.get().zza((MotionEvent) next[0]);
                } else if (next.length == 3) {
                    this.zzaog.get().zza(((Integer) next[0]).intValue(), ((Integer) next[1]).intValue(), ((Integer) next[2]).intValue());
                }
            }
            this.zzaof.clear();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0013, code lost:
        r0 = r2.getApplicationContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.Context zze(android.content.Context r2) {
        /*
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r0 = com.google.android.gms.internal.zzmq.zzbgj
            com.google.android.gms.internal.zzmo r1 = com.google.android.gms.ads.internal.zzbs.zzep()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0013
        L_0x0012:
            return r2
        L_0x0013:
            android.content.Context r0 = r2.getApplicationContext()
            if (r0 == 0) goto L_0x0012
            r2 = r0
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzaf.zze(android.content.Context):android.content.Context");
    }

    public final void run() {
        try {
            this.zzaog.set(zzcr.zza(this.zzaoh.zzcp, zze(this.zzaif), !((Boolean) zzbs.zzep().zzd(zzmq.zzbjv)).booleanValue() && (this.zzaoh.zzdcb)));
        } finally {
            this.zzaoi.countDown();
            this.zzaif = null;
            this.zzaoh = null;
        }
    }

    public final String zza(Context context) {
        zzco zzco;
        if (!zzcx() || (zzco = this.zzaog.get()) == null) {
            return "";
        }
        zzcy();
        return zzco.zza(zze(context));
    }

    public final String zza(Context context, String str, View view) {
        zzco zzco;
        if (!zzcx() || (zzco = this.zzaog.get()) == null) {
            return "";
        }
        zzcy();
        return zzco.zza(zze(context), str, view);
    }

    public final void zza(int i, int i2, int i3) {
        zzco zzco = this.zzaog.get();
        if (zzco != null) {
            zzcy();
            zzco.zza(i, i2, i3);
            return;
        }
        this.zzaof.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final void zza(MotionEvent motionEvent) {
        zzco zzco = this.zzaog.get();
        if (zzco != null) {
            zzcy();
            zzco.zza(motionEvent);
            return;
        }
        this.zzaof.add(new Object[]{motionEvent});
    }
}
