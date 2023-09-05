package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzak;
import com.google.android.gms.ads.internal.zzbs;

final class zzso {
    zzak zzbyd;
    @Nullable
    zzis zzbye;
    zzrj zzbyf;
    long zzbyg;
    boolean zzbyh;
    boolean zzbyi;
    private /* synthetic */ zzsn zzbyj;

    zzso(zzsn zzsn, zzri zzri) {
        this.zzbyj = zzsn;
        this.zzbyd = zzri.zzav(zzsn.zzaou);
        this.zzbyf = new zzrj();
        zzrj zzrj = this.zzbyf;
        zzak zzak = this.zzbyd;
        zzak.zza((zzjq) new zzrk(zzrj));
        zzak.zza((zzkg) new zzrs(zzrj));
        zzak.zza((zznj) new zzru(zzrj));
        zzak.zza((zzjn) new zzrw(zzrj));
        zzak.zza((zzacv) new zzry(zzrj));
    }

    zzso(zzsn zzsn, zzri zzri, zzis zzis) {
        this(zzsn, zzri);
        this.zzbye = zzis;
    }

    /* access modifiers changed from: package-private */
    public final boolean load() {
        if (this.zzbyh) {
            return false;
        }
        this.zzbyi = this.zzbyd.zzb(zzsl.zzj(this.zzbye != null ? this.zzbye : this.zzbyj.zzbya));
        this.zzbyh = true;
        this.zzbyg = zzbs.zzei().currentTimeMillis();
        return true;
    }
}
