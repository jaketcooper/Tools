package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfif extends zzfhm<zzfif> {
    public String zzpjr = null;
    public Long zzpjs = null;
    public Boolean zzpjt = null;

    public zzfif() {
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
                    this.zzpjr = zzfhj.readString();
                    continue;
                case 16:
                    this.zzpjs = Long.valueOf(zzfhj.zzctv());
                    continue;
                case 24:
                    this.zzpjt = Boolean.valueOf(zzfhj.zzctz());
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
        if (this.zzpjr != null) {
            zzfhk.zzn(1, this.zzpjr);
        }
        if (this.zzpjs != null) {
            zzfhk.zzf(2, this.zzpjs.longValue());
        }
        if (this.zzpjt != null) {
            zzfhk.zzl(3, this.zzpjt.booleanValue());
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzpjr != null) {
            zzo += zzfhk.zzo(1, this.zzpjr);
        }
        if (this.zzpjs != null) {
            zzo += zzfhk.zzc(2, this.zzpjs.longValue());
        }
        if (this.zzpjt == null) {
            return zzo;
        }
        this.zzpjt.booleanValue();
        return zzo + zzfhk.zzkx(3) + 1;
    }
}
