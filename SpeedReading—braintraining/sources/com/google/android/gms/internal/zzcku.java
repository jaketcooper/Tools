package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcku extends zzfhm<zzcku> {
    private static volatile zzcku[] zzjih;
    public String name = null;
    public Boolean zzjii = null;
    public Boolean zzjij = null;
    public Integer zzjik = null;

    public zzcku() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    public static zzcku[] zzbat() {
        if (zzjih == null) {
            synchronized (zzfhq.zzphu) {
                if (zzjih == null) {
                    zzjih = new zzcku[0];
                }
            }
        }
        return zzjih;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcku)) {
            return false;
        }
        zzcku zzcku = (zzcku) obj;
        if (this.name == null) {
            if (zzcku.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzcku.name)) {
            return false;
        }
        if (this.zzjii == null) {
            if (zzcku.zzjii != null) {
                return false;
            }
        } else if (!this.zzjii.equals(zzcku.zzjii)) {
            return false;
        }
        if (this.zzjij == null) {
            if (zzcku.zzjij != null) {
                return false;
            }
        } else if (!this.zzjij.equals(zzcku.zzjij)) {
            return false;
        }
        if (this.zzjik == null) {
            if (zzcku.zzjik != null) {
                return false;
            }
        } else if (!this.zzjik.equals(zzcku.zzjik)) {
            return false;
        }
        return (this.zzphm == null || this.zzphm.isEmpty()) ? zzcku.zzphm == null || zzcku.zzphm.isEmpty() : this.zzphm.equals(zzcku.zzphm);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.zzjik == null ? 0 : this.zzjik.hashCode()) + (((this.zzjij == null ? 0 : this.zzjij.hashCode()) + (((this.zzjii == null ? 0 : this.zzjii.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
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
                    this.name = zzfhj.readString();
                    continue;
                case 16:
                    this.zzjii = Boolean.valueOf(zzfhj.zzctz());
                    continue;
                case 24:
                    this.zzjij = Boolean.valueOf(zzfhj.zzctz());
                    continue;
                case 32:
                    this.zzjik = Integer.valueOf(zzfhj.zzcui());
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
        if (this.name != null) {
            zzfhk.zzn(1, this.name);
        }
        if (this.zzjii != null) {
            zzfhk.zzl(2, this.zzjii.booleanValue());
        }
        if (this.zzjij != null) {
            zzfhk.zzl(3, this.zzjij.booleanValue());
        }
        if (this.zzjik != null) {
            zzfhk.zzaa(4, this.zzjik.intValue());
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.name != null) {
            zzo += zzfhk.zzo(1, this.name);
        }
        if (this.zzjii != null) {
            this.zzjii.booleanValue();
            zzo += zzfhk.zzkx(2) + 1;
        }
        if (this.zzjij != null) {
            this.zzjij.booleanValue();
            zzo += zzfhk.zzkx(3) + 1;
        }
        return this.zzjik != null ? zzo + zzfhk.zzad(4, this.zzjik.intValue()) : zzo;
    }
}
