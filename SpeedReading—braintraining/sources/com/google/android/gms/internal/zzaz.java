package com.google.android.gms.internal;

import java.io.IOException;

public final class zzaz extends zzfhm<zzaz> {
    private Long zzfz = null;
    private Integer zzga = null;
    private Boolean zzgb = null;
    private int[] zzgc = zzfhv.zzphz;
    private Long zzgd = null;

    public zzaz() {
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
                case 16:
                    this.zzga = Integer.valueOf(zzfhj.zzcui());
                    continue;
                case 24:
                    this.zzgb = Boolean.valueOf(zzfhj.zzctz());
                    continue;
                case 32:
                    int zzb = zzfhv.zzb(zzfhj, 32);
                    int length = this.zzgc == null ? 0 : this.zzgc.length;
                    int[] iArr = new int[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzgc, 0, iArr, 0, length);
                    }
                    while (length < iArr.length - 1) {
                        iArr[length] = zzfhj.zzcui();
                        zzfhj.zzctt();
                        length++;
                    }
                    iArr[length] = zzfhj.zzcui();
                    this.zzgc = iArr;
                    continue;
                case 34:
                    int zzkj = zzfhj.zzkj(zzfhj.zzcui());
                    int position = zzfhj.getPosition();
                    int i = 0;
                    while (zzfhj.zzcuk() > 0) {
                        zzfhj.zzcui();
                        i++;
                    }
                    zzfhj.zzlw(position);
                    int length2 = this.zzgc == null ? 0 : this.zzgc.length;
                    int[] iArr2 = new int[(i + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzgc, 0, iArr2, 0, length2);
                    }
                    while (length2 < iArr2.length) {
                        iArr2[length2] = zzfhj.zzcui();
                        length2++;
                    }
                    this.zzgc = iArr2;
                    zzfhj.zzkk(zzkj);
                    continue;
                case 40:
                    this.zzgd = Long.valueOf(zzfhj.zzcun());
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
        if (this.zzga != null) {
            zzfhk.zzaa(2, this.zzga.intValue());
        }
        if (this.zzgb != null) {
            zzfhk.zzl(3, this.zzgb.booleanValue());
        }
        if (this.zzgc != null && this.zzgc.length > 0) {
            for (int zzaa : this.zzgc) {
                zzfhk.zzaa(4, zzaa);
            }
        }
        if (this.zzgd != null) {
            zzfhk.zza(5, this.zzgd.longValue());
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzfz != null) {
            zzo += zzfhk.zzc(1, this.zzfz.longValue());
        }
        if (this.zzga != null) {
            zzo += zzfhk.zzad(2, this.zzga.intValue());
        }
        if (this.zzgb != null) {
            this.zzgb.booleanValue();
            zzo += zzfhk.zzkx(3) + 1;
        }
        if (this.zzgc != null && this.zzgc.length > 0) {
            int i = 0;
            for (int zzky : this.zzgc) {
                i += zzfhk.zzky(zzky);
            }
            zzo = zzo + i + (this.zzgc.length * 1);
        }
        if (this.zzgd == null) {
            return zzo;
        }
        return zzo + zzfhk.zzkx(5) + zzfhk.zzdh(this.zzgd.longValue());
    }
}
