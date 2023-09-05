package com.google.android.gms.internal;

import java.util.concurrent.ExecutionException;

final /* synthetic */ class zzajm implements Runnable {
    private final zzajy zzbxh;
    private final zzajp zzdcf;

    zzajm(zzajy zzajy, zzajp zzajp) {
        this.zzbxh = zzajy;
        this.zzdcf = zzajp;
    }

    public final void run() {
        zzajy zzajy = this.zzbxh;
        try {
            zzajy.set(this.zzdcf.get());
        } catch (ExecutionException e) {
            zzajy.setException(e.getCause());
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            zzajy.setException(e2);
        } catch (Exception e3) {
            zzajy.setException(e3);
        }
    }
}
