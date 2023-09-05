package com.google.android.gms.internal;

final class zzcit implements Runnable {
    private /* synthetic */ String val$name;
    private /* synthetic */ String zzjef;
    private /* synthetic */ zzcik zzjer;
    private /* synthetic */ long zzjew;
    private /* synthetic */ Object zzjfb;

    zzcit(zzcik zzcik, String str, String str2, Object obj, long j) {
        this.zzjer = zzcik;
        this.zzjef = str;
        this.val$name = str2;
        this.zzjfb = obj;
        this.zzjew = j;
    }

    public final void run() {
        this.zzjer.zza(this.zzjef, this.val$name, this.zzjfb, this.zzjew);
    }
}
