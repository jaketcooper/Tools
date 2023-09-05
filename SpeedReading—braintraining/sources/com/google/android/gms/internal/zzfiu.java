package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfiu extends zzfhm<zzfiu> {
    public long zzgfg = 0;
    public String zzplr = "";
    public String zzpls = "";
    public long zzplt = 0;
    public String zzplu = "";
    public long zzplv = 0;
    public String zzplw = "";
    public String zzplx = "";
    public String zzply = "";
    public String zzplz = "";
    public String zzpma = "";
    public int zzpmb = 0;
    public zzfit[] zzpmc = zzfit.zzcyd();

    public zzfiu() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    public static zzfiu zzbh(byte[] bArr) throws zzfhr {
        return (zzfiu) zzfhs.zza(new zzfiu(), bArr);
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
                case 18:
                    this.zzpls = zzfhj.readString();
                    continue;
                case 24:
                    this.zzplt = zzfhj.zzctv();
                    continue;
                case 34:
                    this.zzplu = zzfhj.readString();
                    continue;
                case 40:
                    this.zzplv = zzfhj.zzctv();
                    continue;
                case 48:
                    this.zzgfg = zzfhj.zzctv();
                    continue;
                case 58:
                    this.zzplw = zzfhj.readString();
                    continue;
                case 66:
                    this.zzplx = zzfhj.readString();
                    continue;
                case 74:
                    this.zzply = zzfhj.readString();
                    continue;
                case 82:
                    this.zzplz = zzfhj.readString();
                    continue;
                case 90:
                    this.zzpma = zzfhj.readString();
                    continue;
                case 96:
                    this.zzpmb = zzfhj.zzctw();
                    continue;
                case 106:
                    int zzb = zzfhv.zzb(zzfhj, 106);
                    int length = this.zzpmc == null ? 0 : this.zzpmc.length;
                    zzfit[] zzfitArr = new zzfit[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzpmc, 0, zzfitArr, 0, length);
                    }
                    while (length < zzfitArr.length - 1) {
                        zzfitArr[length] = new zzfit();
                        zzfhj.zza(zzfitArr[length]);
                        zzfhj.zzctt();
                        length++;
                    }
                    zzfitArr[length] = new zzfit();
                    zzfhj.zza(zzfitArr[length]);
                    this.zzpmc = zzfitArr;
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
        if (this.zzpls != null && !this.zzpls.equals("")) {
            zzfhk.zzn(2, this.zzpls);
        }
        if (this.zzplt != 0) {
            zzfhk.zzf(3, this.zzplt);
        }
        if (this.zzplu != null && !this.zzplu.equals("")) {
            zzfhk.zzn(4, this.zzplu);
        }
        if (this.zzplv != 0) {
            zzfhk.zzf(5, this.zzplv);
        }
        if (this.zzgfg != 0) {
            zzfhk.zzf(6, this.zzgfg);
        }
        if (this.zzplw != null && !this.zzplw.equals("")) {
            zzfhk.zzn(7, this.zzplw);
        }
        if (this.zzplx != null && !this.zzplx.equals("")) {
            zzfhk.zzn(8, this.zzplx);
        }
        if (this.zzply != null && !this.zzply.equals("")) {
            zzfhk.zzn(9, this.zzply);
        }
        if (this.zzplz != null && !this.zzplz.equals("")) {
            zzfhk.zzn(10, this.zzplz);
        }
        if (this.zzpma != null && !this.zzpma.equals("")) {
            zzfhk.zzn(11, this.zzpma);
        }
        if (this.zzpmb != 0) {
            zzfhk.zzaa(12, this.zzpmb);
        }
        if (this.zzpmc != null && this.zzpmc.length > 0) {
            for (zzfit zzfit : this.zzpmc) {
                if (zzfit != null) {
                    zzfhk.zza(13, (zzfhs) zzfit);
                }
            }
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzplr != null && !this.zzplr.equals("")) {
            zzo += zzfhk.zzo(1, this.zzplr);
        }
        if (this.zzpls != null && !this.zzpls.equals("")) {
            zzo += zzfhk.zzo(2, this.zzpls);
        }
        if (this.zzplt != 0) {
            zzo += zzfhk.zzc(3, this.zzplt);
        }
        if (this.zzplu != null && !this.zzplu.equals("")) {
            zzo += zzfhk.zzo(4, this.zzplu);
        }
        if (this.zzplv != 0) {
            zzo += zzfhk.zzc(5, this.zzplv);
        }
        if (this.zzgfg != 0) {
            zzo += zzfhk.zzc(6, this.zzgfg);
        }
        if (this.zzplw != null && !this.zzplw.equals("")) {
            zzo += zzfhk.zzo(7, this.zzplw);
        }
        if (this.zzplx != null && !this.zzplx.equals("")) {
            zzo += zzfhk.zzo(8, this.zzplx);
        }
        if (this.zzply != null && !this.zzply.equals("")) {
            zzo += zzfhk.zzo(9, this.zzply);
        }
        if (this.zzplz != null && !this.zzplz.equals("")) {
            zzo += zzfhk.zzo(10, this.zzplz);
        }
        if (this.zzpma != null && !this.zzpma.equals("")) {
            zzo += zzfhk.zzo(11, this.zzpma);
        }
        if (this.zzpmb != 0) {
            zzo += zzfhk.zzad(12, this.zzpmb);
        }
        if (this.zzpmc == null || this.zzpmc.length <= 0) {
            return zzo;
        }
        int i = zzo;
        for (zzfit zzfit : this.zzpmc) {
            if (zzfit != null) {
                i += zzfhk.zzb(13, (zzfhs) zzfit);
            }
        }
        return i;
    }
}
