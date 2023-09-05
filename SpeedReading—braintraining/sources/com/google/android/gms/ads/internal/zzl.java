package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzaeh;
import com.google.android.gms.internal.zzaev;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzagr;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzamm;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zzne;
import com.google.android.gms.internal.zzxf;

final class zzl implements Runnable {
    final /* synthetic */ zzaev zzana;
    final /* synthetic */ zzi zzanf;
    final /* synthetic */ zzaeh zzang;
    private /* synthetic */ zznd zzanh;

    zzl(zzi zzi, zzaev zzaev, zzaeh zzaeh, zznd zznd) {
        this.zzanf = zzi;
        this.zzana = zzaev;
        this.zzang = zzaeh;
        this.zzanh = zznd;
    }

    public final void run() {
        if (this.zzana.zzcwe.zzcnp && this.zzanf.zzamt.zzaty != null) {
            String str = null;
            if (this.zzana.zzcwe.zzchl != null) {
                zzbs.zzec();
                str = zzagr.zzcc(this.zzana.zzcwe.zzchl);
            }
            zzne zzne = new zzne(this.zzanf, str, this.zzana.zzcwe.body);
            this.zzanf.zzamt.zzaue = 1;
            try {
                this.zzanf.zzamr = false;
                this.zzanf.zzamt.zzaty.zza(zzne);
                return;
            } catch (RemoteException e) {
                zzafj.zzc("Could not call the onCustomRenderedAdLoadedListener.", e);
                this.zzanf.zzamr = true;
            }
        }
        zzw zzw = new zzw(this.zzanf.zzamt.zzaif, this.zzang, this.zzana.zzcwe.zzcnz);
        try {
            zzama zza = this.zzanf.zza(this.zzana, zzw, this.zzang);
            zza.setOnTouchListener(new zzn(this, zzw));
            zza.setOnClickListener(new zzo(this, zzw));
            this.zzanf.zzamt.zzaue = 0;
            zzbt zzbt = this.zzanf.zzamt;
            zzbs.zzeb();
            zzbt.zzatg = zzxf.zza(this.zzanf.zzamt.zzaif, this.zzanf, this.zzana, this.zzanf.zzamt.zzatc, zza, this.zzanf.zzanb, this.zzanf, this.zzanh);
        } catch (zzamm e2) {
            zzafj.zzb("Could not obtain webview.", e2);
            zzagr.zzczc.post(new zzm(this));
        }
    }
}
