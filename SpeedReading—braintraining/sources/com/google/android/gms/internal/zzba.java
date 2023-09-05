package com.google.android.gms.internal;

import java.io.IOException;

public final class zzba extends zzfhm<zzba> {
    public byte[] data = null;
    public byte[] zzge = null;
    public byte[] zzgf = null;
    public byte[] zzgg = null;

    public zzba() {
        this.zzpaw = -1;
    }

    public final /* synthetic */ zzfhs zza(zzfhj zzfhj) throws IOException {
        while (true) {
            int zzctt = zzfhj.zzctt();
            switch (zzctt) {
                case 0:
                    break;
                case 10:
                    this.data = zzfhj.readBytes();
                    continue;
                case 18:
                    this.zzge = zzfhj.readBytes();
                    continue;
                case 26:
                    this.zzgf = zzfhj.readBytes();
                    continue;
                case 34:
                    this.zzgg = zzfhj.readBytes();
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
        if (this.data != null) {
            zzfhk.zzc(1, this.data);
        }
        if (this.zzge != null) {
            zzfhk.zzc(2, this.zzge);
        }
        if (this.zzgf != null) {
            zzfhk.zzc(3, this.zzgf);
        }
        if (this.zzgg != null) {
            zzfhk.zzc(4, this.zzgg);
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.data != null) {
            zzo += zzfhk.zzd(1, this.data);
        }
        if (this.zzge != null) {
            zzo += zzfhk.zzd(2, this.zzge);
        }
        if (this.zzgf != null) {
            zzo += zzfhk.zzd(3, this.zzgf);
        }
        return this.zzgg != null ? zzo + zzfhk.zzd(4, this.zzgg) : zzo;
    }
}
