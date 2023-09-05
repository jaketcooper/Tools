package com.google.android.gms.internal;

import java.io.IOException;

public final class zzik extends zzfhm<zzik> {
    public String zzbbl = null;
    public zzim zzbbm = null;

    public zzik() {
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
                    this.zzbbl = zzfhj.readString();
                    continue;
                case 34:
                    if (this.zzbbm == null) {
                        this.zzbbm = new zzim();
                    }
                    zzfhj.zza(this.zzbbm);
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
        if (this.zzbbl != null) {
            zzfhk.zzn(1, this.zzbbl);
        }
        if (this.zzbbm != null) {
            zzfhk.zza(4, (zzfhs) this.zzbbm);
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzbbl != null) {
            zzo += zzfhk.zzo(1, this.zzbbl);
        }
        return this.zzbbm != null ? zzo + zzfhk.zzb(4, (zzfhs) this.zzbbm) : zzo;
    }
}
