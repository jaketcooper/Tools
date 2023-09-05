package com.google.android.gms.internal;

import android.os.Bundle;

final class zzcis implements Runnable {
    private /* synthetic */ String val$name;
    private /* synthetic */ String zziju;
    private /* synthetic */ String zzjef;
    private /* synthetic */ zzcik zzjer;
    private /* synthetic */ long zzjew;
    private /* synthetic */ Bundle zzjex;
    private /* synthetic */ boolean zzjey;
    private /* synthetic */ boolean zzjez;
    private /* synthetic */ boolean zzjfa;

    zzcis(zzcik zzcik, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.zzjer = zzcik;
        this.zzjef = str;
        this.val$name = str2;
        this.zzjew = j;
        this.zzjex = bundle;
        this.zzjey = z;
        this.zzjez = z2;
        this.zzjfa = z3;
        this.zziju = str3;
    }

    public final void run() {
        this.zzjer.zzb(this.zzjef, this.val$name, this.zzjew, this.zzjex, this.zzjey, this.zzjez, this.zzjfa, this.zziju);
    }
}
