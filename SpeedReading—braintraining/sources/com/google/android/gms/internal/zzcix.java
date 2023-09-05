package com.google.android.gms.internal;

final class zzcix implements Runnable {
    private /* synthetic */ zzcik zzjer;

    zzcix(zzcik zzcik) {
        this.zzjer = zzcik;
    }

    public final void run() {
        zzcik zzcik = this.zzjer;
        zzcik.zzut();
        zzcik.zzwu();
        zzcik.zzawn().zzayx().log("Resetting analytics data (FE)");
        zzcik.zzawe().resetAnalyticsData();
    }
}
