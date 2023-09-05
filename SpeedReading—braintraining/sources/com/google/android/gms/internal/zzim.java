package com.google.android.gms.internal;

import java.io.IOException;

public final class zzim extends zzfhm<zzim> {
    public Integer zzbbq = null;
    public Integer zzbbr = null;
    public Integer zzbbs = null;

    public zzim() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    public final /* synthetic */ zzfhs zza(zzfhj zzfhj) throws IOException {
        while (true) {
            int zzctt = zzfhj.zzctt();
            switch (zzctt) {
                case 0:
                    break;
                case 8:
                    this.zzbbq = Integer.valueOf(zzfhj.zzcui());
                    continue;
                case 16:
                    this.zzbbr = Integer.valueOf(zzfhj.zzcui());
                    continue;
                case 24:
                    this.zzbbs = Integer.valueOf(zzfhj.zzcui());
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
        if (this.zzbbq != null) {
            zzfhk.zzaa(1, this.zzbbq.intValue());
        }
        if (this.zzbbr != null) {
            zzfhk.zzaa(2, this.zzbbr.intValue());
        }
        if (this.zzbbs != null) {
            zzfhk.zzaa(3, this.zzbbs.intValue());
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzbbq != null) {
            zzo += zzfhk.zzad(1, this.zzbbq.intValue());
        }
        if (this.zzbbr != null) {
            zzo += zzfhk.zzad(2, this.zzbbr.intValue());
        }
        return this.zzbbs != null ? zzo + zzfhk.zzad(3, this.zzbbs.intValue()) : zzo;
    }
}
