package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfic extends zzfhm<zzfic> {
    private byte[] zzpjd = null;
    private Integer zzpjg = null;
    private byte[] zzpjh = null;

    public zzfic() {
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
                    this.zzpjg = Integer.valueOf(zzfhj.zzctw());
                    continue;
                case 18:
                    this.zzpjh = zzfhj.readBytes();
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
        if (this.zzpjg != null) {
            zzfhk.zzaa(1, this.zzpjg.intValue());
        }
        if (this.zzpjh != null) {
            zzfhk.zzc(2, this.zzpjh);
        }
        if (this.zzpjd != null) {
            zzfhk.zzc(3, this.zzpjd);
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzpjg != null) {
            zzo += zzfhk.zzad(1, this.zzpjg.intValue());
        }
        if (this.zzpjh != null) {
            zzo += zzfhk.zzd(2, this.zzpjh);
        }
        return this.zzpjd != null ? zzo + zzfhk.zzd(3, this.zzpjd) : zzo;
    }
}
