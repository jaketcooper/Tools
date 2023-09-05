package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfhx extends zzfhm<zzfhx> {
    public String zzcuw = null;

    public zzfhx() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    public final /* synthetic */ zzfhs zza(zzfhj zzfhj) throws IOException {
        while (true) {
            int zzctt = zzfhj.zzctt();
            switch (zzctt) {
                case 0:
                    break;
                case 10:
                    this.zzcuw = zzfhj.readString();
                    continue;
                default:
                    if (!super.zza(zzfhj, zzctt)) {
                        break;
                    } else {
                        continue;
                    }
            }
        }
        return this;
    }

    public final void zza(zzfhk zzfhk) throws IOException {
        if (this.zzcuw != null) {
            zzfhk.zzn(1, this.zzcuw);
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        return this.zzcuw != null ? zzo + zzfhk.zzo(1, this.zzcuw) : zzo;
    }
}
