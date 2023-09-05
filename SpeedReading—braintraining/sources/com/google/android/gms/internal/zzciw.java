package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzciw implements Runnable {
    private /* synthetic */ zzcik zzjer;
    private /* synthetic */ AtomicReference zzjet;

    zzciw(zzcik zzcik, AtomicReference atomicReference) {
        this.zzjer = zzcik;
        this.zzjet = atomicReference;
    }

    public final void run() {
        this.zzjer.zzawe().zza((AtomicReference<String>) this.zzjet);
    }
}
