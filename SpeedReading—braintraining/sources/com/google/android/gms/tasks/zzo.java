package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

final class zzo implements Runnable {
    private /* synthetic */ Callable val$callable;
    private /* synthetic */ zzn zzksi;

    zzo(zzn zzn, Callable callable) {
        this.zzksi = zzn;
        this.val$callable = callable;
    }

    public final void run() {
        try {
            this.zzksi.setResult(this.val$callable.call());
        } catch (Exception e) {
            this.zzksi.setException(e);
        }
    }
}
