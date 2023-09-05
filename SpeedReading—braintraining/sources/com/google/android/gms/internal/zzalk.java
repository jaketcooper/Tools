package com.google.android.gms.internal;

@zzzb
final class zzalk implements Runnable {
    private boolean zzayd = false;
    private zzakw zzdhd;

    zzalk(zzakw zzakw) {
        this.zzdhd = zzakw;
    }

    private final void zzsg() {
        zzagr.zzczc.removeCallbacks(this);
        zzagr.zzczc.postDelayed(this, 250);
    }

    public final void pause() {
        this.zzayd = true;
    }

    public final void resume() {
        this.zzayd = false;
        zzsg();
    }

    public final void run() {
        if (!this.zzayd) {
            this.zzdhd.zzro();
            zzsg();
        }
    }
}
