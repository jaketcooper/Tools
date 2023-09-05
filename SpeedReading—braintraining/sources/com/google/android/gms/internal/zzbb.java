package com.google.android.gms.internal;

import java.io.IOException;

public final class zzbb extends zzfhm<zzbb> {
    public Long zzfz = null;
    private String zzgh = null;
    private byte[] zzgi = null;

    public zzbb() {
        this.zzpaw = -1;
    }

    public final /* synthetic */ zzfhs zza(zzfhj zzfhj) throws IOException {
        while (true) {
            int zzctt = zzfhj.zzctt();
            switch (zzctt) {
                case 0:
                    break;
                case 8:
                    this.zzfz = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 26:
                    this.zzgh = zzfhj.readString();
                    continue;
                case 34:
                    this.zzgi = zzfhj.readBytes();
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
        if (this.zzfz != null) {
            zzfhk.zzf(1, this.zzfz.longValue());
        }
        if (this.zzgh != null) {
            zzfhk.zzn(3, this.zzgh);
        }
        if (this.zzgi != null) {
            zzfhk.zzc(4, this.zzgi);
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzfz != null) {
            zzo += zzfhk.zzc(1, this.zzfz.longValue());
        }
        if (this.zzgh != null) {
            zzo += zzfhk.zzo(3, this.zzgh);
        }
        return this.zzgi != null ? zzo + zzfhk.zzd(4, this.zzgi) : zzo;
    }
}
