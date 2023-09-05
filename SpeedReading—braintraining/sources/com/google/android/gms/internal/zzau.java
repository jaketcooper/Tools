package com.google.android.gms.internal;

import java.io.IOException;

public final class zzau extends zzfhm<zzau> {
    public String zzcq;
    private String zzcr;
    private String zzcs;
    private String zzct;
    private String zzcu;

    public final /* synthetic */ zzfhs zza(zzfhj zzfhj) throws IOException {
        while (true) {
            int zzctt = zzfhj.zzctt();
            switch (zzctt) {
                case 0:
                    break;
                case 10:
                    this.zzcq = zzfhj.readString();
                    continue;
                case 18:
                    this.zzcr = zzfhj.readString();
                    continue;
                case 26:
                    this.zzcs = zzfhj.readString();
                    continue;
                case 34:
                    this.zzct = zzfhj.readString();
                    continue;
                case 42:
                    this.zzcu = zzfhj.readString();
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
        if (this.zzcq != null) {
            zzfhk.zzn(1, this.zzcq);
        }
        if (this.zzcr != null) {
            zzfhk.zzn(2, this.zzcr);
        }
        if (this.zzcs != null) {
            zzfhk.zzn(3, this.zzcs);
        }
        if (this.zzct != null) {
            zzfhk.zzn(4, this.zzct);
        }
        if (this.zzcu != null) {
            zzfhk.zzn(5, this.zzcu);
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzcq != null) {
            zzo += zzfhk.zzo(1, this.zzcq);
        }
        if (this.zzcr != null) {
            zzo += zzfhk.zzo(2, this.zzcr);
        }
        if (this.zzcs != null) {
            zzo += zzfhk.zzo(3, this.zzcs);
        }
        if (this.zzct != null) {
            zzo += zzfhk.zzo(4, this.zzct);
        }
        return this.zzcu != null ? zzo + zzfhk.zzo(5, this.zzcu) : zzo;
    }
}
