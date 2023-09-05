package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;

@zzzb
public final class zzalq extends zzafh {
    final zzali zzdew;
    final zzalt zzdhj;
    private final String zzdhk;

    zzalq(zzali zzali, zzalt zzalt, String str) {
        this.zzdew = zzali;
        this.zzdhj = zzalt;
        this.zzdhk = str;
        zzbs.zzey().zza(this);
    }

    public final void onStop() {
        this.zzdhj.abort();
    }

    public final void zzdg() {
        try {
            this.zzdhj.zzcr(this.zzdhk);
        } finally {
            zzagr.zzczc.post(new zzalr(this));
        }
    }
}
