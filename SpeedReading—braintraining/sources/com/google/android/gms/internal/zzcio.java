package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzcio implements Runnable {
    private /* synthetic */ String zziju;
    private /* synthetic */ String zzjef;
    private /* synthetic */ String zzjeg;
    private /* synthetic */ zzcik zzjer;
    private /* synthetic */ AtomicReference zzjet;

    zzcio(zzcik zzcik, AtomicReference atomicReference, String str, String str2, String str3) {
        this.zzjer = zzcik;
        this.zzjet = atomicReference;
        this.zziju = str;
        this.zzjef = str2;
        this.zzjeg = str3;
    }

    public final void run() {
        this.zzjer.zzitu.zzawe().zza(this.zzjet, this.zziju, this.zzjef, this.zzjeg);
    }
}
