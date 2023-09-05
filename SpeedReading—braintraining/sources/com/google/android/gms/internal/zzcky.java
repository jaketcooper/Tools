package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcky extends zzfhm<zzcky> {
    private static volatile zzcky[] zzjiv;
    public Integer count = null;
    public String name = null;
    public zzckz[] zzjiw = zzckz.zzbax();
    public Long zzjix = null;
    public Long zzjiy = null;

    public zzcky() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    public static zzcky[] zzbaw() {
        if (zzjiv == null) {
            synchronized (zzfhq.zzphu) {
                if (zzjiv == null) {
                    zzjiv = new zzcky[0];
                }
            }
        }
        return zzjiv;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcky)) {
            return false;
        }
        zzcky zzcky = (zzcky) obj;
        if (!zzfhq.equals((Object[]) this.zzjiw, (Object[]) zzcky.zzjiw)) {
            return false;
        }
        if (this.name == null) {
            if (zzcky.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzcky.name)) {
            return false;
        }
        if (this.zzjix == null) {
            if (zzcky.zzjix != null) {
                return false;
            }
        } else if (!this.zzjix.equals(zzcky.zzjix)) {
            return false;
        }
        if (this.zzjiy == null) {
            if (zzcky.zzjiy != null) {
                return false;
            }
        } else if (!this.zzjiy.equals(zzcky.zzjiy)) {
            return false;
        }
        if (this.count == null) {
            if (zzcky.count != null) {
                return false;
            }
        } else if (!this.count.equals(zzcky.count)) {
            return false;
        }
        return (this.zzphm == null || this.zzphm.isEmpty()) ? zzcky.zzphm == null || zzcky.zzphm.isEmpty() : this.zzphm.equals(zzcky.zzphm);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.count == null ? 0 : this.count.hashCode()) + (((this.zzjiy == null ? 0 : this.zzjiy.hashCode()) + (((this.zzjix == null ? 0 : this.zzjix.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzfhq.hashCode((Object[]) this.zzjiw)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.zzphm != null && !this.zzphm.isEmpty()) {
            i = this.zzphm.hashCode();
        }
        return hashCode + i;
    }

    public final /* synthetic */ zzfhs zza(zzfhj zzfhj) throws IOException {
        while (true) {
            int zzctt = zzfhj.zzctt();
            switch (zzctt) {
                case 0:
                    break;
                case 10:
                    int zzb = zzfhv.zzb(zzfhj, 10);
                    int length = this.zzjiw == null ? 0 : this.zzjiw.length;
                    zzckz[] zzckzArr = new zzckz[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzjiw, 0, zzckzArr, 0, length);
                    }
                    while (length < zzckzArr.length - 1) {
                        zzckzArr[length] = new zzckz();
                        zzfhj.zza(zzckzArr[length]);
                        zzfhj.zzctt();
                        length++;
                    }
                    zzckzArr[length] = new zzckz();
                    zzfhj.zza(zzckzArr[length]);
                    this.zzjiw = zzckzArr;
                    continue;
                case 18:
                    this.name = zzfhj.readString();
                    continue;
                case 24:
                    this.zzjix = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 32:
                    this.zzjiy = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 40:
                    this.count = Integer.valueOf(zzfhj.zzcui());
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
        if (this.zzjiw != null && this.zzjiw.length > 0) {
            for (zzckz zzckz : this.zzjiw) {
                if (zzckz != null) {
                    zzfhk.zza(1, (zzfhs) zzckz);
                }
            }
        }
        if (this.name != null) {
            zzfhk.zzn(2, this.name);
        }
        if (this.zzjix != null) {
            zzfhk.zzf(3, this.zzjix.longValue());
        }
        if (this.zzjiy != null) {
            zzfhk.zzf(4, this.zzjiy.longValue());
        }
        if (this.count != null) {
            zzfhk.zzaa(5, this.count.intValue());
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzjiw != null && this.zzjiw.length > 0) {
            for (zzckz zzckz : this.zzjiw) {
                if (zzckz != null) {
                    zzo += zzfhk.zzb(1, (zzfhs) zzckz);
                }
            }
        }
        if (this.name != null) {
            zzo += zzfhk.zzo(2, this.name);
        }
        if (this.zzjix != null) {
            zzo += zzfhk.zzc(3, this.zzjix.longValue());
        }
        if (this.zzjiy != null) {
            zzo += zzfhk.zzc(4, this.zzjiy.longValue());
        }
        return this.count != null ? zzo + zzfhk.zzad(5, this.count.intValue()) : zzo;
    }
}
