package com.google.android.gms.internal;

import java.util.concurrent.ExecutionException;

final /* synthetic */ class zzajh implements Runnable {
    private final zzajd zzdce;
    private final zzajp zzdcf;

    zzajh(zzajd zzajd, zzajp zzajp) {
        this.zzdce = zzajd;
        this.zzdcf = zzajp;
    }

    public final void run() {
        zzajd zzajd = this.zzdce;
        try {
            zzajd.onSuccess(this.zzdcf.get());
            return;
        } catch (ExecutionException e) {
            e = e.getCause();
        } catch (InterruptedException e2) {
            e = e2;
            Thread.currentThread().interrupt();
        } catch (Exception e3) {
            e = e3;
        }
        zzajd.zzb(e);
    }
}
