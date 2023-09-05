package com.google.android.gms.internal;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.zzbs;

final class zzop implements Runnable {
    private /* synthetic */ zzoe zzbty;
    private /* synthetic */ zzoo zzbtz;

    zzop(zzoo zzoo, zzoe zzoe) {
        this.zzbtz = zzoo;
        this.zzbty = zzoe;
    }

    public final void run() {
        zzama zzama;
        if (this.zzbtz.zzbtr) {
            if (this.zzbtz.zzbtq == null) {
                View unused = this.zzbtz.zzbtq = new View(this.zzbtz.zzbtp.getContext());
                this.zzbtz.zzbtq.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
            }
            if (this.zzbtz.zzbtp != this.zzbtz.zzbtq.getParent()) {
                this.zzbtz.zzbtp.addView(this.zzbtz.zzbtq);
            }
        }
        try {
            zzama = this.zzbty.zzka();
        } catch (Exception e) {
            zzbs.zzee();
            if (zzagw.zzqd()) {
                zzafj.zzco("Privileged processes cannot create HTML overlays.");
                zzama = null;
            } else {
                zzafj.zzb("Error obtaining overlay.", e);
                zzama = null;
            }
        }
        if (!(zzama == null || this.zzbtz.zzaln == null)) {
            FrameLayout frameLayout = this.zzbtz.zzaln;
            if (zzama == null) {
                throw null;
            }
            frameLayout.addView((View) zzama);
        }
        this.zzbtz.zza(this.zzbty);
    }
}
