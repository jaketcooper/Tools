package com.google.android.gms.internal;

final class zznt implements Runnable {
    private /* synthetic */ zzns zzbsl;

    zznt(zzns zzns) {
        this.zzbsl = zzns;
    }

    public final void run() {
        if (this.zzbsl.zzbsk != null) {
            this.zzbsl.zzbsk.zzkc();
            this.zzbsl.zzbsk.zzkb();
        }
        zzoa unused = this.zzbsl.zzbsk = null;
    }
}
