package com.google.android.gms.internal;

import java.io.IOException;

public final class zzclc extends zzfhm<zzclc> {
    public long[] zzjke = zzfhv.zzpia;
    public long[] zzjkf = zzfhv.zzpia;

    public zzclc() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzclc)) {
            return false;
        }
        zzclc zzclc = (zzclc) obj;
        if (!zzfhq.equals(this.zzjke, zzclc.zzjke)) {
            return false;
        }
        if (!zzfhq.equals(this.zzjkf, zzclc.zzjkf)) {
            return false;
        }
        return (this.zzphm == null || this.zzphm.isEmpty()) ? zzclc.zzphm == null || zzclc.zzphm.isEmpty() : this.zzphm.equals(zzclc.zzphm);
    }

    public final int hashCode() {
        return ((this.zzphm == null || this.zzphm.isEmpty()) ? 0 : this.zzphm.hashCode()) + ((((((getClass().getName().hashCode() + 527) * 31) + zzfhq.hashCode(this.zzjke)) * 31) + zzfhq.hashCode(this.zzjkf)) * 31);
    }

    public final /* synthetic */ zzfhs zza(zzfhj zzfhj) throws IOException {
        while (true) {
            int zzctt = zzfhj.zzctt();
            switch (zzctt) {
                case 0:
                    break;
                case 8:
                    int zzb = zzfhv.zzb(zzfhj, 8);
                    int length = this.zzjke == null ? 0 : this.zzjke.length;
                    long[] jArr = new long[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzjke, 0, jArr, 0, length);
                    }
                    while (length < jArr.length - 1) {
                        jArr[length] = zzfhj.zzcun();
                        zzfhj.zzctt();
                        length++;
                    }
                    jArr[length] = zzfhj.zzcun();
                    this.zzjke = jArr;
                    continue;
                case 10:
                    int zzkj = zzfhj.zzkj(zzfhj.zzcui());
                    int position = zzfhj.getPosition();
                    int i = 0;
                    while (zzfhj.zzcuk() > 0) {
                        zzfhj.zzcun();
                        i++;
                    }
                    zzfhj.zzlw(position);
                    int length2 = this.zzjke == null ? 0 : this.zzjke.length;
                    long[] jArr2 = new long[(i + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzjke, 0, jArr2, 0, length2);
                    }
                    while (length2 < jArr2.length) {
                        jArr2[length2] = zzfhj.zzcun();
                        length2++;
                    }
                    this.zzjke = jArr2;
                    zzfhj.zzkk(zzkj);
                    continue;
                case 16:
                    int zzb2 = zzfhv.zzb(zzfhj, 16);
                    int length3 = this.zzjkf == null ? 0 : this.zzjkf.length;
                    long[] jArr3 = new long[(zzb2 + length3)];
                    if (length3 != 0) {
                        System.arraycopy(this.zzjkf, 0, jArr3, 0, length3);
                    }
                    while (length3 < jArr3.length - 1) {
                        jArr3[length3] = zzfhj.zzcun();
                        zzfhj.zzctt();
                        length3++;
                    }
                    jArr3[length3] = zzfhj.zzcun();
                    this.zzjkf = jArr3;
                    continue;
                case 18:
                    int zzkj2 = zzfhj.zzkj(zzfhj.zzcui());
                    int position2 = zzfhj.getPosition();
                    int i2 = 0;
                    while (zzfhj.zzcuk() > 0) {
                        zzfhj.zzcun();
                        i2++;
                    }
                    zzfhj.zzlw(position2);
                    int length4 = this.zzjkf == null ? 0 : this.zzjkf.length;
                    long[] jArr4 = new long[(i2 + length4)];
                    if (length4 != 0) {
                        System.arraycopy(this.zzjkf, 0, jArr4, 0, length4);
                    }
                    while (length4 < jArr4.length) {
                        jArr4[length4] = zzfhj.zzcun();
                        length4++;
                    }
                    this.zzjkf = jArr4;
                    zzfhj.zzkk(zzkj2);
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
        if (this.zzjke != null && this.zzjke.length > 0) {
            for (long zza : this.zzjke) {
                zzfhk.zza(1, zza);
            }
        }
        if (this.zzjkf != null && this.zzjkf.length > 0) {
            for (long zza2 : this.zzjkf) {
                zzfhk.zza(2, zza2);
            }
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int i;
        int zzo = super.zzo();
        if (this.zzjke == null || this.zzjke.length <= 0) {
            i = zzo;
        } else {
            int i2 = 0;
            for (long zzdh : this.zzjke) {
                i2 += zzfhk.zzdh(zzdh);
            }
            i = zzo + i2 + (this.zzjke.length * 1);
        }
        if (this.zzjkf == null || this.zzjkf.length <= 0) {
            return i;
        }
        int i3 = 0;
        for (long zzdh2 : this.zzjkf) {
            i3 += zzfhk.zzdh(zzdh2);
        }
        return i + i3 + (this.zzjkf.length * 1);
    }
}
