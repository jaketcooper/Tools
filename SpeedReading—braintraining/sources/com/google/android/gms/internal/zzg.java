package com.google.android.gms.internal;

import com.safonov.speedreading.training.fragment.cuptimer.training.presenter.CupTimerPresenter;

public final class zzg implements zzx {
    private int zzn;
    private int zzo;
    private final int zzp;
    private final float zzq;

    public zzg() {
        this(CupTimerPresenter.NOTIFICATION_SHOWING_TIME, 1, 1.0f);
    }

    private zzg(int i, int i2, float f) {
        this.zzn = CupTimerPresenter.NOTIFICATION_SHOWING_TIME;
        this.zzp = 1;
        this.zzq = 1.0f;
    }

    public final int zza() {
        return this.zzn;
    }

    public final void zza(zzaa zzaa) throws zzaa {
        this.zzo++;
        this.zzn = (int) (((float) this.zzn) + (((float) this.zzn) * this.zzq));
        if (!(this.zzo <= this.zzp)) {
            throw zzaa;
        }
    }

    public final int zzb() {
        return this.zzo;
    }
}
