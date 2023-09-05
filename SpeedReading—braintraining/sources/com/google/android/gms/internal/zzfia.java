package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfia extends zzfhm<zzfia> {
    private byte[] zzpjb = null;
    private byte[] zzpjc = null;
    private byte[] zzpjd = null;

    public zzfia() {
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
                    this.zzpjb = zzfhj.readBytes();
                    continue;
                case 18:
                    this.zzpjc = zzfhj.readBytes();
                    continue;
                case 26:
                    this.zzpjd = zzfhj.readBytes();
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
        if (this.zzpjb != null) {
            zzfhk.zzc(1, this.zzpjb);
        }
        if (this.zzpjc != null) {
            zzfhk.zzc(2, this.zzpjc);
        }
        if (this.zzpjd != null) {
            zzfhk.zzc(3, this.zzpjd);
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzpjb != null) {
            zzo += zzfhk.zzd(1, this.zzpjb);
        }
        if (this.zzpjc != null) {
            zzo += zzfhk.zzd(2, this.zzpjc);
        }
        return this.zzpjd != null ? zzo + zzfhk.zzd(3, this.zzpjd) : zzo;
    }
}
