package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcko extends zzfhm<zzcko> {
    private static volatile zzcko[] zzjhg;
    public Integer zzjhh = null;
    public zzcks[] zzjhi = zzcks.zzbas();
    public zzckp[] zzjhj = zzckp.zzbaq();

    public zzcko() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    public static zzcko[] zzbap() {
        if (zzjhg == null) {
            synchronized (zzfhq.zzphu) {
                if (zzjhg == null) {
                    zzjhg = new zzcko[0];
                }
            }
        }
        return zzjhg;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcko)) {
            return false;
        }
        zzcko zzcko = (zzcko) obj;
        if (this.zzjhh == null) {
            if (zzcko.zzjhh != null) {
                return false;
            }
        } else if (!this.zzjhh.equals(zzcko.zzjhh)) {
            return false;
        }
        if (!zzfhq.equals((Object[]) this.zzjhi, (Object[]) zzcko.zzjhi)) {
            return false;
        }
        if (!zzfhq.equals((Object[]) this.zzjhj, (Object[]) zzcko.zzjhj)) {
            return false;
        }
        return (this.zzphm == null || this.zzphm.isEmpty()) ? zzcko.zzphm == null || zzcko.zzphm.isEmpty() : this.zzphm.equals(zzcko.zzphm);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((this.zzjhh == null ? 0 : this.zzjhh.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzfhq.hashCode((Object[]) this.zzjhi)) * 31) + zzfhq.hashCode((Object[]) this.zzjhj)) * 31;
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
                    this.zzjhh = Integer.valueOf(zzfhj.zzcui());
                    continue;
                case 18:
                    int zzb = zzfhv.zzb(zzfhj, 18);
                    int length = this.zzjhi == null ? 0 : this.zzjhi.length;
                    zzcks[] zzcksArr = new zzcks[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzjhi, 0, zzcksArr, 0, length);
                    }
                    while (length < zzcksArr.length - 1) {
                        zzcksArr[length] = new zzcks();
                        zzfhj.zza(zzcksArr[length]);
                        zzfhj.zzctt();
                        length++;
                    }
                    zzcksArr[length] = new zzcks();
                    zzfhj.zza(zzcksArr[length]);
                    this.zzjhi = zzcksArr;
                    continue;
                case 26:
                    int zzb2 = zzfhv.zzb(zzfhj, 26);
                    int length2 = this.zzjhj == null ? 0 : this.zzjhj.length;
                    zzckp[] zzckpArr = new zzckp[(zzb2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzjhj, 0, zzckpArr, 0, length2);
                    }
                    while (length2 < zzckpArr.length - 1) {
                        zzckpArr[length2] = new zzckp();
                        zzfhj.zza(zzckpArr[length2]);
                        zzfhj.zzctt();
                        length2++;
                    }
                    zzckpArr[length2] = new zzckp();
                    zzfhj.zza(zzckpArr[length2]);
                    this.zzjhj = zzckpArr;
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
        if (this.zzjhh != null) {
            zzfhk.zzaa(1, this.zzjhh.intValue());
        }
        if (this.zzjhi != null && this.zzjhi.length > 0) {
            for (zzcks zzcks : this.zzjhi) {
                if (zzcks != null) {
                    zzfhk.zza(2, (zzfhs) zzcks);
                }
            }
        }
        if (this.zzjhj != null && this.zzjhj.length > 0) {
            for (zzckp zzckp : this.zzjhj) {
                if (zzckp != null) {
                    zzfhk.zza(3, (zzfhs) zzckp);
                }
            }
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzjhh != null) {
            zzo += zzfhk.zzad(1, this.zzjhh.intValue());
        }
        if (this.zzjhi != null && this.zzjhi.length > 0) {
            int i = zzo;
            for (zzcks zzcks : this.zzjhi) {
                if (zzcks != null) {
                    i += zzfhk.zzb(2, (zzfhs) zzcks);
                }
            }
            zzo = i;
        }
        if (this.zzjhj != null && this.zzjhj.length > 0) {
            for (zzckp zzckp : this.zzjhj) {
                if (zzckp != null) {
                    zzo += zzfhk.zzb(3, (zzfhs) zzckp);
                }
            }
        }
        return zzo;
    }
}
