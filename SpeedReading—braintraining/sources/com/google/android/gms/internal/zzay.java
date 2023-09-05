package com.google.android.gms.internal;

import java.io.IOException;

public final class zzay extends zzfhm<zzay> {
    private Long zzej = null;
    private Long zzek = null;
    public Long zzfw = null;
    public Long zzfx = null;
    public Long zzfy = null;

    public zzay() {
        this.zzpaw = -1;
    }

    public final /* synthetic */ zzfhs zza(zzfhj zzfhj) throws IOException {
        while (true) {
            int zzctt = zzfhj.zzctt();
            switch (zzctt) {
                case 0:
                    break;
                case 8:
                    this.zzej = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 16:
                    this.zzek = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 24:
                    this.zzfw = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 32:
                    this.zzfx = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 40:
                    this.zzfy = Long.valueOf(zzfhj.zzcun());
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
        if (this.zzej != null) {
            zzfhk.zzf(1, this.zzej.longValue());
        }
        if (this.zzek != null) {
            zzfhk.zzf(2, this.zzek.longValue());
        }
        if (this.zzfw != null) {
            zzfhk.zzf(3, this.zzfw.longValue());
        }
        if (this.zzfx != null) {
            zzfhk.zzf(4, this.zzfx.longValue());
        }
        if (this.zzfy != null) {
            zzfhk.zzf(5, this.zzfy.longValue());
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzej != null) {
            zzo += zzfhk.zzc(1, this.zzej.longValue());
        }
        if (this.zzek != null) {
            zzo += zzfhk.zzc(2, this.zzek.longValue());
        }
        if (this.zzfw != null) {
            zzo += zzfhk.zzc(3, this.zzfw.longValue());
        }
        if (this.zzfx != null) {
            zzo += zzfhk.zzc(4, this.zzfx.longValue());
        }
        return this.zzfy != null ? zzo + zzfhk.zzc(5, this.zzfy.longValue()) : zzo;
    }
}
