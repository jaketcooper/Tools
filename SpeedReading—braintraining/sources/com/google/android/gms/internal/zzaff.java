package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzbs;

@zzzb
public final class zzaff {
    private final Object mLock;
    private final zzaez zzasa;
    private final String zzcwh;
    private int zzcyf;
    private int zzcyg;

    private zzaff(zzaez zzaez, String str) {
        this.mLock = new Object();
        this.zzasa = zzaez;
        this.zzcwh = str;
    }

    public zzaff(String str) {
        this(zzbs.zzeg(), str);
    }

    public final Bundle toBundle() {
        Bundle bundle;
        synchronized (this.mLock) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.zzcyf);
            bundle.putInt("pmnll", this.zzcyg);
        }
        return bundle;
    }

    public final void zze(int i, int i2) {
        synchronized (this.mLock) {
            this.zzcyf = i;
            this.zzcyg = i2;
            this.zzasa.zza(this.zzcwh, this);
        }
    }
}
