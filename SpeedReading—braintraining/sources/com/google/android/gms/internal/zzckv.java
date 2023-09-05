package com.google.android.gms.internal;

import java.io.IOException;

public final class zzckv extends zzfhm<zzckv> {
    public String zzivh = null;
    public Long zzjil = null;
    private Integer zzjim = null;
    public zzckw[] zzjin = zzckw.zzbau();
    public zzcku[] zzjio = zzcku.zzbat();
    public zzcko[] zzjip = zzcko.zzbap();

    public zzckv() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzckv)) {
            return false;
        }
        zzckv zzckv = (zzckv) obj;
        if (this.zzjil == null) {
            if (zzckv.zzjil != null) {
                return false;
            }
        } else if (!this.zzjil.equals(zzckv.zzjil)) {
            return false;
        }
        if (this.zzivh == null) {
            if (zzckv.zzivh != null) {
                return false;
            }
        } else if (!this.zzivh.equals(zzckv.zzivh)) {
            return false;
        }
        if (this.zzjim == null) {
            if (zzckv.zzjim != null) {
                return false;
            }
        } else if (!this.zzjim.equals(zzckv.zzjim)) {
            return false;
        }
        if (!zzfhq.equals((Object[]) this.zzjin, (Object[]) zzckv.zzjin)) {
            return false;
        }
        if (!zzfhq.equals((Object[]) this.zzjio, (Object[]) zzckv.zzjio)) {
            return false;
        }
        if (!zzfhq.equals((Object[]) this.zzjip, (Object[]) zzckv.zzjip)) {
            return false;
        }
        return (this.zzphm == null || this.zzphm.isEmpty()) ? zzckv.zzphm == null || zzckv.zzphm.isEmpty() : this.zzphm.equals(zzckv.zzphm);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((this.zzjim == null ? 0 : this.zzjim.hashCode()) + (((this.zzivh == null ? 0 : this.zzivh.hashCode()) + (((this.zzjil == null ? 0 : this.zzjil.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31) + zzfhq.hashCode((Object[]) this.zzjin)) * 31) + zzfhq.hashCode((Object[]) this.zzjio)) * 31) + zzfhq.hashCode((Object[]) this.zzjip)) * 31;
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
                case 8:
                    this.zzjil = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 18:
                    this.zzivh = zzfhj.readString();
                    continue;
                case 24:
                    this.zzjim = Integer.valueOf(zzfhj.zzcui());
                    continue;
                case 34:
                    int zzb = zzfhv.zzb(zzfhj, 34);
                    int length = this.zzjin == null ? 0 : this.zzjin.length;
                    zzckw[] zzckwArr = new zzckw[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzjin, 0, zzckwArr, 0, length);
                    }
                    while (length < zzckwArr.length - 1) {
                        zzckwArr[length] = new zzckw();
                        zzfhj.zza(zzckwArr[length]);
                        zzfhj.zzctt();
                        length++;
                    }
                    zzckwArr[length] = new zzckw();
                    zzfhj.zza(zzckwArr[length]);
                    this.zzjin = zzckwArr;
                    continue;
                case 42:
                    int zzb2 = zzfhv.zzb(zzfhj, 42);
                    int length2 = this.zzjio == null ? 0 : this.zzjio.length;
                    zzcku[] zzckuArr = new zzcku[(zzb2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzjio, 0, zzckuArr, 0, length2);
                    }
                    while (length2 < zzckuArr.length - 1) {
                        zzckuArr[length2] = new zzcku();
                        zzfhj.zza(zzckuArr[length2]);
                        zzfhj.zzctt();
                        length2++;
                    }
                    zzckuArr[length2] = new zzcku();
                    zzfhj.zza(zzckuArr[length2]);
                    this.zzjio = zzckuArr;
                    continue;
                case 50:
                    int zzb3 = zzfhv.zzb(zzfhj, 50);
                    int length3 = this.zzjip == null ? 0 : this.zzjip.length;
                    zzcko[] zzckoArr = new zzcko[(zzb3 + length3)];
                    if (length3 != 0) {
                        System.arraycopy(this.zzjip, 0, zzckoArr, 0, length3);
                    }
                    while (length3 < zzckoArr.length - 1) {
                        zzckoArr[length3] = new zzcko();
                        zzfhj.zza(zzckoArr[length3]);
                        zzfhj.zzctt();
                        length3++;
                    }
                    zzckoArr[length3] = new zzcko();
                    zzfhj.zza(zzckoArr[length3]);
                    this.zzjip = zzckoArr;
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
        if (this.zzjil != null) {
            zzfhk.zzf(1, this.zzjil.longValue());
        }
        if (this.zzivh != null) {
            zzfhk.zzn(2, this.zzivh);
        }
        if (this.zzjim != null) {
            zzfhk.zzaa(3, this.zzjim.intValue());
        }
        if (this.zzjin != null && this.zzjin.length > 0) {
            for (zzckw zzckw : this.zzjin) {
                if (zzckw != null) {
                    zzfhk.zza(4, (zzfhs) zzckw);
                }
            }
        }
        if (this.zzjio != null && this.zzjio.length > 0) {
            for (zzcku zzcku : this.zzjio) {
                if (zzcku != null) {
                    zzfhk.zza(5, (zzfhs) zzcku);
                }
            }
        }
        if (this.zzjip != null && this.zzjip.length > 0) {
            for (zzcko zzcko : this.zzjip) {
                if (zzcko != null) {
                    zzfhk.zza(6, (zzfhs) zzcko);
                }
            }
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzjil != null) {
            zzo += zzfhk.zzc(1, this.zzjil.longValue());
        }
        if (this.zzivh != null) {
            zzo += zzfhk.zzo(2, this.zzivh);
        }
        if (this.zzjim != null) {
            zzo += zzfhk.zzad(3, this.zzjim.intValue());
        }
        if (this.zzjin != null && this.zzjin.length > 0) {
            int i = zzo;
            for (zzckw zzckw : this.zzjin) {
                if (zzckw != null) {
                    i += zzfhk.zzb(4, (zzfhs) zzckw);
                }
            }
            zzo = i;
        }
        if (this.zzjio != null && this.zzjio.length > 0) {
            int i2 = zzo;
            for (zzcku zzcku : this.zzjio) {
                if (zzcku != null) {
                    i2 += zzfhk.zzb(5, (zzfhs) zzcku);
                }
            }
            zzo = i2;
        }
        if (this.zzjip != null && this.zzjip.length > 0) {
            for (zzcko zzcko : this.zzjip) {
                if (zzcko != null) {
                    zzo += zzfhk.zzb(6, (zzfhs) zzcko);
                }
            }
        }
        return zzo;
    }
}
