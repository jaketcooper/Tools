package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcks extends zzfhm<zzcks> {
    private static volatile zzcks[] zzjia;
    public Integer zzjhl = null;
    public String zzjib = null;
    public zzckq zzjic = null;

    public zzcks() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    public static zzcks[] zzbas() {
        if (zzjia == null) {
            synchronized (zzfhq.zzphu) {
                if (zzjia == null) {
                    zzjia = new zzcks[0];
                }
            }
        }
        return zzjia;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcks)) {
            return false;
        }
        zzcks zzcks = (zzcks) obj;
        if (this.zzjhl == null) {
            if (zzcks.zzjhl != null) {
                return false;
            }
        } else if (!this.zzjhl.equals(zzcks.zzjhl)) {
            return false;
        }
        if (this.zzjib == null) {
            if (zzcks.zzjib != null) {
                return false;
            }
        } else if (!this.zzjib.equals(zzcks.zzjib)) {
            return false;
        }
        if (this.zzjic == null) {
            if (zzcks.zzjic != null) {
                return false;
            }
        } else if (!this.zzjic.equals(zzcks.zzjic)) {
            return false;
        }
        return (this.zzphm == null || this.zzphm.isEmpty()) ? zzcks.zzphm == null || zzcks.zzphm.isEmpty() : this.zzphm.equals(zzcks.zzphm);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (this.zzjib == null ? 0 : this.zzjib.hashCode()) + (((this.zzjhl == null ? 0 : this.zzjhl.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31);
        zzckq zzckq = this.zzjic;
        int hashCode2 = ((zzckq == null ? 0 : zzckq.hashCode()) + (hashCode * 31)) * 31;
        if (this.zzphm != null && !this.zzphm.isEmpty()) {
            i = this.zzphm.hashCode();
        }
        return hashCode2 + i;
    }

    public final /* synthetic */ zzfhs zza(zzfhj zzfhj) throws IOException {
        while (true) {
            int zzctt = zzfhj.zzctt();
            switch (zzctt) {
                case 0:
                    break;
                case 8:
                    this.zzjhl = Integer.valueOf(zzfhj.zzcui());
                    continue;
                case 18:
                    this.zzjib = zzfhj.readString();
                    continue;
                case 26:
                    if (this.zzjic == null) {
                        this.zzjic = new zzckq();
                    }
                    zzfhj.zza(this.zzjic);
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
        if (this.zzjhl != null) {
            zzfhk.zzaa(1, this.zzjhl.intValue());
        }
        if (this.zzjib != null) {
            zzfhk.zzn(2, this.zzjib);
        }
        if (this.zzjic != null) {
            zzfhk.zza(3, (zzfhs) this.zzjic);
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzjhl != null) {
            zzo += zzfhk.zzad(1, this.zzjhl.intValue());
        }
        if (this.zzjib != null) {
            zzo += zzfhk.zzo(2, this.zzjib);
        }
        return this.zzjic != null ? zzo + zzfhk.zzb(3, (zzfhs) this.zzjic) : zzo;
    }
}
