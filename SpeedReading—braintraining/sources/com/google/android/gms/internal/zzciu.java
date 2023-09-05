package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

final class zzciu implements Runnable {
    private /* synthetic */ zzcik zzjer;
    private /* synthetic */ AtomicReference zzjet;
    private /* synthetic */ boolean zzjeu;

    zzciu(zzcik zzcik, AtomicReference atomicReference, boolean z) {
        this.zzjer = zzcik;
        this.zzjet = atomicReference;
        this.zzjeu = z;
    }

    public final void run() {
        this.zzjer.zzawe().zza((AtomicReference<List<zzckk>>) this.zzjet, this.zzjeu);
    }
}
