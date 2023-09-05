package com.google.android.gms.internal;

import java.util.concurrent.Callable;

public final class zzdo implements Callable {
    private final zzda zzagk;
    private final zzaw zzajo;

    public zzdo(zzda zzda, zzaw zzaw) {
        this.zzagk = zzda;
        this.zzajo = zzaw;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzav */
    public final Void call() throws Exception {
        if (this.zzagk.zzan() != null) {
            this.zzagk.zzan().get();
        }
        zzaw zzam = this.zzagk.zzam();
        if (zzam == null) {
            return null;
        }
        try {
            synchronized (this.zzajo) {
                zzfhs.zza(this.zzajo, zzfhs.zzc(zzam));
            }
            return null;
        } catch (zzfhr e) {
            return null;
        }
    }
}
