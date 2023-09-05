package com.google.android.gms.internal;

import java.io.IOException;
import org.mozilla.universalchardet.prober.CharsetProber;

public final class zzil extends zzfhm<zzil> {
    public String zzbbn = null;
    public zzik zzbbo = null;
    public zzij zzbbp = null;

    public zzil() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    public final /* synthetic */ zzfhs zza(zzfhj zzfhj) throws IOException {
        while (true) {
            int zzctt = zzfhj.zzctt();
            switch (zzctt) {
                case 0:
                    break;
                case 82:
                    this.zzbbn = zzfhj.readString();
                    continue;
                case CharsetProber.ASCII_Z /*122*/:
                    if (this.zzbbo == null) {
                        this.zzbbo = new zzik();
                    }
                    zzfhj.zza(this.zzbbo);
                    continue;
                case 146:
                    if (this.zzbbp == null) {
                        this.zzbbp = new zzij();
                    }
                    zzfhj.zza(this.zzbbp);
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
        if (this.zzbbn != null) {
            zzfhk.zzn(10, this.zzbbn);
        }
        if (this.zzbbo != null) {
            zzfhk.zza(15, (zzfhs) this.zzbbo);
        }
        if (this.zzbbp != null) {
            zzfhk.zza(18, (zzfhs) this.zzbbp);
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzbbn != null) {
            zzo += zzfhk.zzo(10, this.zzbbn);
        }
        if (this.zzbbo != null) {
            zzo += zzfhk.zzb(15, (zzfhs) this.zzbbo);
        }
        return this.zzbbp != null ? zzo + zzfhk.zzb(18, (zzfhs) this.zzbbp) : zzo;
    }
}
