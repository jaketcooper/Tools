package com.google.android.gms.internal;

import java.io.IOException;

public final class zzax extends zzfhm<zzax> {
    private static volatile zzax[] zzfc;
    public Long zzdh = null;
    public Long zzdi = null;
    public Long zzfd = null;
    public Long zzfe = null;
    public Long zzff = null;
    public Long zzfg = null;
    public Integer zzfh;
    public Long zzfi = null;
    public Long zzfj = null;
    public Long zzfk = null;
    public Integer zzfl;
    public Long zzfm = null;
    public Long zzfn = null;
    public Long zzfo = null;
    public Long zzfp = null;
    public Long zzfq = null;
    public Long zzfr = null;
    public Long zzfs = null;
    public Long zzft = null;
    public Long zzfu = null;
    public Long zzfv = null;

    public zzax() {
        this.zzpaw = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final zzax zza(zzfhj zzfhj) throws IOException {
        while (true) {
            int zzctt = zzfhj.zzctt();
            switch (zzctt) {
                case 0:
                    break;
                case 8:
                    this.zzdh = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 16:
                    this.zzdi = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 24:
                    this.zzfd = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 32:
                    this.zzfe = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 40:
                    this.zzff = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 48:
                    this.zzfg = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 56:
                    int position = zzfhj.getPosition();
                    try {
                        this.zzfh = Integer.valueOf(zzav.zzd(zzfhj.zzcui()));
                        continue;
                    } catch (IllegalArgumentException e) {
                        zzfhj.zzlw(position);
                        zza(zzfhj, zzctt);
                        break;
                    }
                case 64:
                    this.zzfi = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 72:
                    this.zzfj = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 80:
                    this.zzfk = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 88:
                    int position2 = zzfhj.getPosition();
                    try {
                        this.zzfl = Integer.valueOf(zzav.zzd(zzfhj.zzcui()));
                        continue;
                    } catch (IllegalArgumentException e2) {
                        zzfhj.zzlw(position2);
                        zza(zzfhj, zzctt);
                        break;
                    }
                case 96:
                    this.zzfm = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 104:
                    this.zzfn = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 112:
                    this.zzfo = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 120:
                    this.zzfp = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 128:
                    this.zzfq = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 136:
                    this.zzfr = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 144:
                    this.zzfs = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 152:
                    this.zzft = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 160:
                    this.zzfu = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 168:
                    this.zzfv = Long.valueOf(zzfhj.zzcun());
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

    public static zzax[] zzp() {
        if (zzfc == null) {
            synchronized (zzfhq.zzphu) {
                if (zzfc == null) {
                    zzfc = new zzax[0];
                }
            }
        }
        return zzfc;
    }

    public final void zza(zzfhk zzfhk) throws IOException {
        if (this.zzdh != null) {
            zzfhk.zzf(1, this.zzdh.longValue());
        }
        if (this.zzdi != null) {
            zzfhk.zzf(2, this.zzdi.longValue());
        }
        if (this.zzfd != null) {
            zzfhk.zzf(3, this.zzfd.longValue());
        }
        if (this.zzfe != null) {
            zzfhk.zzf(4, this.zzfe.longValue());
        }
        if (this.zzff != null) {
            zzfhk.zzf(5, this.zzff.longValue());
        }
        if (this.zzfg != null) {
            zzfhk.zzf(6, this.zzfg.longValue());
        }
        if (this.zzfh != null) {
            zzfhk.zzaa(7, this.zzfh.intValue());
        }
        if (this.zzfi != null) {
            zzfhk.zzf(8, this.zzfi.longValue());
        }
        if (this.zzfj != null) {
            zzfhk.zzf(9, this.zzfj.longValue());
        }
        if (this.zzfk != null) {
            zzfhk.zzf(10, this.zzfk.longValue());
        }
        if (this.zzfl != null) {
            zzfhk.zzaa(11, this.zzfl.intValue());
        }
        if (this.zzfm != null) {
            zzfhk.zzf(12, this.zzfm.longValue());
        }
        if (this.zzfn != null) {
            zzfhk.zzf(13, this.zzfn.longValue());
        }
        if (this.zzfo != null) {
            zzfhk.zzf(14, this.zzfo.longValue());
        }
        if (this.zzfp != null) {
            zzfhk.zzf(15, this.zzfp.longValue());
        }
        if (this.zzfq != null) {
            zzfhk.zzf(16, this.zzfq.longValue());
        }
        if (this.zzfr != null) {
            zzfhk.zzf(17, this.zzfr.longValue());
        }
        if (this.zzfs != null) {
            zzfhk.zzf(18, this.zzfs.longValue());
        }
        if (this.zzft != null) {
            zzfhk.zzf(19, this.zzft.longValue());
        }
        if (this.zzfu != null) {
            zzfhk.zzf(20, this.zzfu.longValue());
        }
        if (this.zzfv != null) {
            zzfhk.zzf(21, this.zzfv.longValue());
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzdh != null) {
            zzo += zzfhk.zzc(1, this.zzdh.longValue());
        }
        if (this.zzdi != null) {
            zzo += zzfhk.zzc(2, this.zzdi.longValue());
        }
        if (this.zzfd != null) {
            zzo += zzfhk.zzc(3, this.zzfd.longValue());
        }
        if (this.zzfe != null) {
            zzo += zzfhk.zzc(4, this.zzfe.longValue());
        }
        if (this.zzff != null) {
            zzo += zzfhk.zzc(5, this.zzff.longValue());
        }
        if (this.zzfg != null) {
            zzo += zzfhk.zzc(6, this.zzfg.longValue());
        }
        if (this.zzfh != null) {
            zzo += zzfhk.zzad(7, this.zzfh.intValue());
        }
        if (this.zzfi != null) {
            zzo += zzfhk.zzc(8, this.zzfi.longValue());
        }
        if (this.zzfj != null) {
            zzo += zzfhk.zzc(9, this.zzfj.longValue());
        }
        if (this.zzfk != null) {
            zzo += zzfhk.zzc(10, this.zzfk.longValue());
        }
        if (this.zzfl != null) {
            zzo += zzfhk.zzad(11, this.zzfl.intValue());
        }
        if (this.zzfm != null) {
            zzo += zzfhk.zzc(12, this.zzfm.longValue());
        }
        if (this.zzfn != null) {
            zzo += zzfhk.zzc(13, this.zzfn.longValue());
        }
        if (this.zzfo != null) {
            zzo += zzfhk.zzc(14, this.zzfo.longValue());
        }
        if (this.zzfp != null) {
            zzo += zzfhk.zzc(15, this.zzfp.longValue());
        }
        if (this.zzfq != null) {
            zzo += zzfhk.zzc(16, this.zzfq.longValue());
        }
        if (this.zzfr != null) {
            zzo += zzfhk.zzc(17, this.zzfr.longValue());
        }
        if (this.zzfs != null) {
            zzo += zzfhk.zzc(18, this.zzfs.longValue());
        }
        if (this.zzft != null) {
            zzo += zzfhk.zzc(19, this.zzft.longValue());
        }
        if (this.zzfu != null) {
            zzo += zzfhk.zzc(20, this.zzfu.longValue());
        }
        return this.zzfv != null ? zzo + zzfhk.zzc(21, this.zzfv.longValue()) : zzo;
    }
}
