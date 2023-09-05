package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcla extends zzfhm<zzcla> {
    public zzclb[] zzjjb = zzclb.zzbay();

    public zzcla() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcla)) {
            return false;
        }
        zzcla zzcla = (zzcla) obj;
        if (!zzfhq.equals((Object[]) this.zzjjb, (Object[]) zzcla.zzjjb)) {
            return false;
        }
        return (this.zzphm == null || this.zzphm.isEmpty()) ? zzcla.zzphm == null || zzcla.zzphm.isEmpty() : this.zzphm.equals(zzcla.zzphm);
    }

    public final int hashCode() {
        return ((this.zzphm == null || this.zzphm.isEmpty()) ? 0 : this.zzphm.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzfhq.hashCode((Object[]) this.zzjjb)) * 31);
    }

    public final /* synthetic */ zzfhs zza(zzfhj zzfhj) throws IOException {
        while (true) {
            int zzctt = zzfhj.zzctt();
            switch (zzctt) {
                case 0:
                    break;
                case 10:
                    int zzb = zzfhv.zzb(zzfhj, 10);
                    int length = this.zzjjb == null ? 0 : this.zzjjb.length;
                    zzclb[] zzclbArr = new zzclb[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzjjb, 0, zzclbArr, 0, length);
                    }
                    while (length < zzclbArr.length - 1) {
                        zzclbArr[length] = new zzclb();
                        zzfhj.zza(zzclbArr[length]);
                        zzfhj.zzctt();
                        length++;
                    }
                    zzclbArr[length] = new zzclb();
                    zzfhj.zza(zzclbArr[length]);
                    this.zzjjb = zzclbArr;
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
        if (this.zzjjb != null && this.zzjjb.length > 0) {
            for (zzclb zzclb : this.zzjjb) {
                if (zzclb != null) {
                    zzfhk.zza(1, (zzfhs) zzclb);
                }
            }
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzjjb != null && this.zzjjb.length > 0) {
            for (zzclb zzclb : this.zzjjb) {
                if (zzclb != null) {
                    zzo += zzfhk.zzb(1, (zzfhs) zzclb);
                }
            }
        }
        return zzo;
    }
}
