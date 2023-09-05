package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfit extends zzfhm<zzfit> {
    private static volatile zzfit[] zzplq;
    public String zzplr = "";

    public zzfit() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    public static zzfit[] zzcyd() {
        if (zzplq == null) {
            synchronized (zzfhq.zzphu) {
                if (zzplq == null) {
                    zzplq = new zzfit[0];
                }
            }
        }
        return zzplq;
    }

    public final /* synthetic */ zzfhs zza(zzfhj zzfhj) throws IOException {
        while (true) {
            int zzctt = zzfhj.zzctt();
            switch (zzctt) {
                case 0:
                    break;
                case 10:
                    this.zzplr = zzfhj.readString();
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
        if (this.zzplr != null && !this.zzplr.equals("")) {
            zzfhk.zzn(1, this.zzplr);
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        return (this.zzplr == null || this.zzplr.equals("")) ? zzo : zzo + zzfhk.zzo(1, this.zzplr);
    }
}
