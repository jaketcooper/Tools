package com.google.android.gms.internal;

import java.io.IOException;

public final class zzckq extends zzfhm<zzckq> {
    private static volatile zzckq[] zzjhq;
    public zzckt zzjhr = null;
    public zzckr zzjhs = null;
    public Boolean zzjht = null;
    public String zzjhu = null;

    public zzckq() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    public static zzckq[] zzbar() {
        if (zzjhq == null) {
            synchronized (zzfhq.zzphu) {
                if (zzjhq == null) {
                    zzjhq = new zzckq[0];
                }
            }
        }
        return zzjhq;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzckq)) {
            return false;
        }
        zzckq zzckq = (zzckq) obj;
        if (this.zzjhr == null) {
            if (zzckq.zzjhr != null) {
                return false;
            }
        } else if (!this.zzjhr.equals(zzckq.zzjhr)) {
            return false;
        }
        if (this.zzjhs == null) {
            if (zzckq.zzjhs != null) {
                return false;
            }
        } else if (!this.zzjhs.equals(zzckq.zzjhs)) {
            return false;
        }
        if (this.zzjht == null) {
            if (zzckq.zzjht != null) {
                return false;
            }
        } else if (!this.zzjht.equals(zzckq.zzjht)) {
            return false;
        }
        if (this.zzjhu == null) {
            if (zzckq.zzjhu != null) {
                return false;
            }
        } else if (!this.zzjhu.equals(zzckq.zzjhu)) {
            return false;
        }
        return (this.zzphm == null || this.zzphm.isEmpty()) ? zzckq.zzphm == null || zzckq.zzphm.isEmpty() : this.zzphm.equals(zzckq.zzphm);
    }

    public final int hashCode() {
        int i = 0;
        zzckt zzckt = this.zzjhr;
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        int hashCode2 = zzckt == null ? 0 : zzckt.hashCode();
        zzckr zzckr = this.zzjhs;
        int hashCode3 = ((this.zzjhu == null ? 0 : this.zzjhu.hashCode()) + (((this.zzjht == null ? 0 : this.zzjht.hashCode()) + (((zzckr == null ? 0 : zzckr.hashCode()) + ((hashCode2 + hashCode) * 31)) * 31)) * 31)) * 31;
        if (this.zzphm != null && !this.zzphm.isEmpty()) {
            i = this.zzphm.hashCode();
        }
        return hashCode3 + i;
    }

    public final /* synthetic */ zzfhs zza(zzfhj zzfhj) throws IOException {
        while (true) {
            int zzctt = zzfhj.zzctt();
            switch (zzctt) {
                case 0:
                    break;
                case 10:
                    if (this.zzjhr == null) {
                        this.zzjhr = new zzckt();
                    }
                    zzfhj.zza(this.zzjhr);
                    continue;
                case 18:
                    if (this.zzjhs == null) {
                        this.zzjhs = new zzckr();
                    }
                    zzfhj.zza(this.zzjhs);
                    continue;
                case 24:
                    this.zzjht = Boolean.valueOf(zzfhj.zzctz());
                    continue;
                case 34:
                    this.zzjhu = zzfhj.readString();
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
        if (this.zzjhr != null) {
            zzfhk.zza(1, (zzfhs) this.zzjhr);
        }
        if (this.zzjhs != null) {
            zzfhk.zza(2, (zzfhs) this.zzjhs);
        }
        if (this.zzjht != null) {
            zzfhk.zzl(3, this.zzjht.booleanValue());
        }
        if (this.zzjhu != null) {
            zzfhk.zzn(4, this.zzjhu);
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzjhr != null) {
            zzo += zzfhk.zzb(1, (zzfhs) this.zzjhr);
        }
        if (this.zzjhs != null) {
            zzo += zzfhk.zzb(2, (zzfhs) this.zzjhs);
        }
        if (this.zzjht != null) {
            this.zzjht.booleanValue();
            zzo += zzfhk.zzkx(3) + 1;
        }
        return this.zzjhu != null ? zzo + zzfhk.zzo(4, this.zzjhu) : zzo;
    }
}
