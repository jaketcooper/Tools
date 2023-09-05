package com.google.android.gms.internal;

import java.io.IOException;

public final class zzckx extends zzfhm<zzckx> {
    private static volatile zzckx[] zzjir;
    public Integer zzjhh = null;
    public zzclc zzjis = null;
    public zzclc zzjit = null;
    public Boolean zzjiu = null;

    public zzckx() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    public static zzckx[] zzbav() {
        if (zzjir == null) {
            synchronized (zzfhq.zzphu) {
                if (zzjir == null) {
                    zzjir = new zzckx[0];
                }
            }
        }
        return zzjir;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzckx)) {
            return false;
        }
        zzckx zzckx = (zzckx) obj;
        if (this.zzjhh == null) {
            if (zzckx.zzjhh != null) {
                return false;
            }
        } else if (!this.zzjhh.equals(zzckx.zzjhh)) {
            return false;
        }
        if (this.zzjis == null) {
            if (zzckx.zzjis != null) {
                return false;
            }
        } else if (!this.zzjis.equals(zzckx.zzjis)) {
            return false;
        }
        if (this.zzjit == null) {
            if (zzckx.zzjit != null) {
                return false;
            }
        } else if (!this.zzjit.equals(zzckx.zzjit)) {
            return false;
        }
        if (this.zzjiu == null) {
            if (zzckx.zzjiu != null) {
                return false;
            }
        } else if (!this.zzjiu.equals(zzckx.zzjiu)) {
            return false;
        }
        return (this.zzphm == null || this.zzphm.isEmpty()) ? zzckx.zzphm == null || zzckx.zzphm.isEmpty() : this.zzphm.equals(zzckx.zzphm);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (this.zzjhh == null ? 0 : this.zzjhh.hashCode()) + ((getClass().getName().hashCode() + 527) * 31);
        zzclc zzclc = this.zzjis;
        int i2 = hashCode * 31;
        int hashCode2 = zzclc == null ? 0 : zzclc.hashCode();
        zzclc zzclc2 = this.zzjit;
        int hashCode3 = ((this.zzjiu == null ? 0 : this.zzjiu.hashCode()) + (((zzclc2 == null ? 0 : zzclc2.hashCode()) + ((hashCode2 + i2) * 31)) * 31)) * 31;
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
                case 8:
                    this.zzjhh = Integer.valueOf(zzfhj.zzcui());
                    continue;
                case 18:
                    if (this.zzjis == null) {
                        this.zzjis = new zzclc();
                    }
                    zzfhj.zza(this.zzjis);
                    continue;
                case 26:
                    if (this.zzjit == null) {
                        this.zzjit = new zzclc();
                    }
                    zzfhj.zza(this.zzjit);
                    continue;
                case 32:
                    this.zzjiu = Boolean.valueOf(zzfhj.zzctz());
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
        if (this.zzjis != null) {
            zzfhk.zza(2, (zzfhs) this.zzjis);
        }
        if (this.zzjit != null) {
            zzfhk.zza(3, (zzfhs) this.zzjit);
        }
        if (this.zzjiu != null) {
            zzfhk.zzl(4, this.zzjiu.booleanValue());
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzjhh != null) {
            zzo += zzfhk.zzad(1, this.zzjhh.intValue());
        }
        if (this.zzjis != null) {
            zzo += zzfhk.zzb(2, (zzfhs) this.zzjis);
        }
        if (this.zzjit != null) {
            zzo += zzfhk.zzb(3, (zzfhs) this.zzjit);
        }
        if (this.zzjiu == null) {
            return zzo;
        }
        this.zzjiu.booleanValue();
        return zzo + zzfhk.zzkx(4) + 1;
    }
}
