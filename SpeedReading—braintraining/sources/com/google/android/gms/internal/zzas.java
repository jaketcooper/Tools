package com.google.android.gms.internal;

import java.io.IOException;

public final class zzas extends zzfhm<zzas> {
    private String stackTrace = null;
    public String zzch = null;
    public Long zzci = null;
    private String zzcj = null;
    private String zzck = null;
    private Long zzcl = null;
    private Long zzcm = null;
    private String zzcn = null;
    private Long zzco = null;
    private String zzcp = null;

    public zzas() {
        this.zzpaw = -1;
    }

    public final /* synthetic */ zzfhs zza(zzfhj zzfhj) throws IOException {
        while (true) {
            int zzctt = zzfhj.zzctt();
            switch (zzctt) {
                case 0:
                    break;
                case 10:
                    this.zzch = zzfhj.readString();
                    continue;
                case 16:
                    this.zzci = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 26:
                    this.stackTrace = zzfhj.readString();
                    continue;
                case 34:
                    this.zzcj = zzfhj.readString();
                    continue;
                case 42:
                    this.zzck = zzfhj.readString();
                    continue;
                case 48:
                    this.zzcl = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 56:
                    this.zzcm = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 66:
                    this.zzcn = zzfhj.readString();
                    continue;
                case 72:
                    this.zzco = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 82:
                    this.zzcp = zzfhj.readString();
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
        if (this.zzch != null) {
            zzfhk.zzn(1, this.zzch);
        }
        if (this.zzci != null) {
            zzfhk.zzf(2, this.zzci.longValue());
        }
        if (this.stackTrace != null) {
            zzfhk.zzn(3, this.stackTrace);
        }
        if (this.zzcj != null) {
            zzfhk.zzn(4, this.zzcj);
        }
        if (this.zzck != null) {
            zzfhk.zzn(5, this.zzck);
        }
        if (this.zzcl != null) {
            zzfhk.zzf(6, this.zzcl.longValue());
        }
        if (this.zzcm != null) {
            zzfhk.zzf(7, this.zzcm.longValue());
        }
        if (this.zzcn != null) {
            zzfhk.zzn(8, this.zzcn);
        }
        if (this.zzco != null) {
            zzfhk.zzf(9, this.zzco.longValue());
        }
        if (this.zzcp != null) {
            zzfhk.zzn(10, this.zzcp);
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzch != null) {
            zzo += zzfhk.zzo(1, this.zzch);
        }
        if (this.zzci != null) {
            zzo += zzfhk.zzc(2, this.zzci.longValue());
        }
        if (this.stackTrace != null) {
            zzo += zzfhk.zzo(3, this.stackTrace);
        }
        if (this.zzcj != null) {
            zzo += zzfhk.zzo(4, this.zzcj);
        }
        if (this.zzck != null) {
            zzo += zzfhk.zzo(5, this.zzck);
        }
        if (this.zzcl != null) {
            zzo += zzfhk.zzc(6, this.zzcl.longValue());
        }
        if (this.zzcm != null) {
            zzo += zzfhk.zzc(7, this.zzcm.longValue());
        }
        if (this.zzcn != null) {
            zzo += zzfhk.zzo(8, this.zzcn);
        }
        if (this.zzco != null) {
            zzo += zzfhk.zzc(9, this.zzco.longValue());
        }
        return this.zzcp != null ? zzo + zzfhk.zzo(10, this.zzcp) : zzo;
    }
}
