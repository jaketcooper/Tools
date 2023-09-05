package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzcip implements Runnable {
    private /* synthetic */ String zziju;
    private /* synthetic */ String zzjef;
    private /* synthetic */ String zzjeg;
    private /* synthetic */ zzcik zzjer;
    private /* synthetic */ AtomicReference zzjet;
    private /* synthetic */ boolean zzjeu;

    zzcip(zzcik zzcik, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.zzjer = zzcik;
        this.zzjet = atomicReference;
        this.zziju = str;
        this.zzjef = str2;
        this.zzjeg = str3;
        this.zzjeu = z;
    }

    public final void run() {
        this.zzjer.zzitu.zzawe().zza(this.zzjet, this.zziju, this.zzjef, this.zzjeg, this.zzjeu);
    }
}
