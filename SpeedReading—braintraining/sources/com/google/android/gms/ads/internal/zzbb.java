package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzaeu;
import com.google.android.gms.internal.zzaev;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzoc;
import com.google.android.gms.internal.zztm;
import com.google.android.gms.internal.zztp;
import com.google.android.gms.internal.zzuf;

final class zzbb implements Runnable {
    private /* synthetic */ zzaev zzana;
    private /* synthetic */ zzba zzaqs;

    zzbb(zzba zzba, zzaev zzaev) {
        this.zzaqs = zzba;
        this.zzana = zzaev;
    }

    public final void run() {
        this.zzaqs.zzb(new zzaeu(this.zzana, (zzama) null, (zztm) null, (zzuf) null, (String) null, (zztp) null, (zzoc) null, (String) null));
    }
}
