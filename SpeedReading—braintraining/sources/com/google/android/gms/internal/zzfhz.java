package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfhz extends zzfhm<zzfhz> {
    private byte[] body = null;
    private zzfia zzpix = null;
    public zzfhy[] zzpiy = zzfhy.zzcxn();
    private byte[] zzpiz = null;
    private Integer zzpja = null;

    public zzfhz() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    public final /* synthetic */ zzfhs zza(zzfhj zzfhj) throws IOException {
        while (true) {
            int zzctt = zzfhj.zzctt();
            switch (zzctt) {
                case 0:
                    break;
                case 10:
                    if (this.zzpix == null) {
                        this.zzpix = new zzfia();
                    }
                    zzfhj.zza(this.zzpix);
                    continue;
                case 18:
                    int zzb = zzfhv.zzb(zzfhj, 18);
                    int length = this.zzpiy == null ? 0 : this.zzpiy.length;
                    zzfhy[] zzfhyArr = new zzfhy[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzpiy, 0, zzfhyArr, 0, length);
                    }
                    while (length < zzfhyArr.length - 1) {
                        zzfhyArr[length] = new zzfhy();
                        zzfhj.zza(zzfhyArr[length]);
                        zzfhj.zzctt();
                        length++;
                    }
                    zzfhyArr[length] = new zzfhy();
                    zzfhj.zza(zzfhyArr[length]);
                    this.zzpiy = zzfhyArr;
                    continue;
                case 26:
                    this.body = zzfhj.readBytes();
                    continue;
                case 34:
                    this.zzpiz = zzfhj.readBytes();
                    continue;
                case 40:
                    this.zzpja = Integer.valueOf(zzfhj.zzctw());
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
        if (this.zzpix != null) {
            zzfhk.zza(1, (zzfhs) this.zzpix);
        }
        if (this.zzpiy != null && this.zzpiy.length > 0) {
            for (zzfhy zzfhy : this.zzpiy) {
                if (zzfhy != null) {
                    zzfhk.zza(2, (zzfhs) zzfhy);
                }
            }
        }
        if (this.body != null) {
            zzfhk.zzc(3, this.body);
        }
        if (this.zzpiz != null) {
            zzfhk.zzc(4, this.zzpiz);
        }
        if (this.zzpja != null) {
            zzfhk.zzaa(5, this.zzpja.intValue());
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzpix != null) {
            zzo += zzfhk.zzb(1, (zzfhs) this.zzpix);
        }
        if (this.zzpiy != null && this.zzpiy.length > 0) {
            int i = zzo;
            for (zzfhy zzfhy : this.zzpiy) {
                if (zzfhy != null) {
                    i += zzfhk.zzb(2, (zzfhs) zzfhy);
                }
            }
            zzo = i;
        }
        if (this.body != null) {
            zzo += zzfhk.zzd(3, this.body);
        }
        if (this.zzpiz != null) {
            zzo += zzfhk.zzd(4, this.zzpiz);
        }
        return this.zzpja != null ? zzo + zzfhk.zzad(5, this.zzpja.intValue()) : zzo;
    }
}
