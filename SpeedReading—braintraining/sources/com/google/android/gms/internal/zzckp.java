package com.google.android.gms.internal;

import java.io.IOException;

public final class zzckp extends zzfhm<zzckp> {
    private static volatile zzckp[] zzjhk;
    public Integer zzjhl = null;
    public String zzjhm = null;
    public zzckq[] zzjhn = zzckq.zzbar();
    private Boolean zzjho = null;
    public zzckr zzjhp = null;

    public zzckp() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    public static zzckp[] zzbaq() {
        if (zzjhk == null) {
            synchronized (zzfhq.zzphu) {
                if (zzjhk == null) {
                    zzjhk = new zzckp[0];
                }
            }
        }
        return zzjhk;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzckp)) {
            return false;
        }
        zzckp zzckp = (zzckp) obj;
        if (this.zzjhl == null) {
            if (zzckp.zzjhl != null) {
                return false;
            }
        } else if (!this.zzjhl.equals(zzckp.zzjhl)) {
            return false;
        }
        if (this.zzjhm == null) {
            if (zzckp.zzjhm != null) {
                return false;
            }
        } else if (!this.zzjhm.equals(zzckp.zzjhm)) {
            return false;
        }
        if (!zzfhq.equals((Object[]) this.zzjhn, (Object[]) zzckp.zzjhn)) {
            return false;
        }
        if (this.zzjho == null) {
            if (zzckp.zzjho != null) {
                return false;
            }
        } else if (!this.zzjho.equals(zzckp.zzjho)) {
            return false;
        }
        if (this.zzjhp == null) {
            if (zzckp.zzjhp != null) {
                return false;
            }
        } else if (!this.zzjhp.equals(zzckp.zzjhp)) {
            return false;
        }
        return (this.zzphm == null || this.zzphm.isEmpty()) ? zzckp.zzphm == null || zzckp.zzphm.isEmpty() : this.zzphm.equals(zzckp.zzphm);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (this.zzjho == null ? 0 : this.zzjho.hashCode()) + (((((this.zzjhm == null ? 0 : this.zzjhm.hashCode()) + (((this.zzjhl == null ? 0 : this.zzjhl.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + zzfhq.hashCode((Object[]) this.zzjhn)) * 31);
        zzckr zzckr = this.zzjhp;
        int hashCode2 = ((zzckr == null ? 0 : zzckr.hashCode()) + (hashCode * 31)) * 31;
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
                    this.zzjhm = zzfhj.readString();
                    continue;
                case 26:
                    int zzb = zzfhv.zzb(zzfhj, 26);
                    int length = this.zzjhn == null ? 0 : this.zzjhn.length;
                    zzckq[] zzckqArr = new zzckq[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzjhn, 0, zzckqArr, 0, length);
                    }
                    while (length < zzckqArr.length - 1) {
                        zzckqArr[length] = new zzckq();
                        zzfhj.zza(zzckqArr[length]);
                        zzfhj.zzctt();
                        length++;
                    }
                    zzckqArr[length] = new zzckq();
                    zzfhj.zza(zzckqArr[length]);
                    this.zzjhn = zzckqArr;
                    continue;
                case 32:
                    this.zzjho = Boolean.valueOf(zzfhj.zzctz());
                    continue;
                case 42:
                    if (this.zzjhp == null) {
                        this.zzjhp = new zzckr();
                    }
                    zzfhj.zza(this.zzjhp);
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
        if (this.zzjhm != null) {
            zzfhk.zzn(2, this.zzjhm);
        }
        if (this.zzjhn != null && this.zzjhn.length > 0) {
            for (zzckq zzckq : this.zzjhn) {
                if (zzckq != null) {
                    zzfhk.zza(3, (zzfhs) zzckq);
                }
            }
        }
        if (this.zzjho != null) {
            zzfhk.zzl(4, this.zzjho.booleanValue());
        }
        if (this.zzjhp != null) {
            zzfhk.zza(5, (zzfhs) this.zzjhp);
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzjhl != null) {
            zzo += zzfhk.zzad(1, this.zzjhl.intValue());
        }
        if (this.zzjhm != null) {
            zzo += zzfhk.zzo(2, this.zzjhm);
        }
        if (this.zzjhn != null && this.zzjhn.length > 0) {
            int i = zzo;
            for (zzckq zzckq : this.zzjhn) {
                if (zzckq != null) {
                    i += zzfhk.zzb(3, (zzfhs) zzckq);
                }
            }
            zzo = i;
        }
        if (this.zzjho != null) {
            this.zzjho.booleanValue();
            zzo += zzfhk.zzkx(4) + 1;
        }
        return this.zzjhp != null ? zzo + zzfhk.zzb(5, (zzfhs) this.zzjhp) : zzo;
    }
}
