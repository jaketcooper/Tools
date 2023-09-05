package com.google.android.gms.internal;

import java.io.IOException;

public final class zzckz extends zzfhm<zzckz> {
    private static volatile zzckz[] zzjiz;
    public String name = null;
    public String zzfzs = null;
    private Float zzjgz = null;
    public Double zzjha = null;
    public Long zzjja = null;

    public zzckz() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    public static zzckz[] zzbax() {
        if (zzjiz == null) {
            synchronized (zzfhq.zzphu) {
                if (zzjiz == null) {
                    zzjiz = new zzckz[0];
                }
            }
        }
        return zzjiz;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzckz)) {
            return false;
        }
        zzckz zzckz = (zzckz) obj;
        if (this.name == null) {
            if (zzckz.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzckz.name)) {
            return false;
        }
        if (this.zzfzs == null) {
            if (zzckz.zzfzs != null) {
                return false;
            }
        } else if (!this.zzfzs.equals(zzckz.zzfzs)) {
            return false;
        }
        if (this.zzjja == null) {
            if (zzckz.zzjja != null) {
                return false;
            }
        } else if (!this.zzjja.equals(zzckz.zzjja)) {
            return false;
        }
        if (this.zzjgz == null) {
            if (zzckz.zzjgz != null) {
                return false;
            }
        } else if (!this.zzjgz.equals(zzckz.zzjgz)) {
            return false;
        }
        if (this.zzjha == null) {
            if (zzckz.zzjha != null) {
                return false;
            }
        } else if (!this.zzjha.equals(zzckz.zzjha)) {
            return false;
        }
        return (this.zzphm == null || this.zzphm.isEmpty()) ? zzckz.zzphm == null || zzckz.zzphm.isEmpty() : this.zzphm.equals(zzckz.zzphm);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.zzjha == null ? 0 : this.zzjha.hashCode()) + (((this.zzjgz == null ? 0 : this.zzjgz.hashCode()) + (((this.zzjja == null ? 0 : this.zzjja.hashCode()) + (((this.zzfzs == null ? 0 : this.zzfzs.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
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
                case 18:
                    this.zzfzs = zzfhj.readString();
                    continue;
                case 24:
                    this.zzjja = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 37:
                    this.zzjgz = Float.valueOf(Float.intBitsToFloat(zzfhj.zzcuo()));
                    continue;
                case 41:
                    this.zzjha = Double.valueOf(Double.longBitsToDouble(zzfhj.zzcup()));
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
        if (this.zzfzs != null) {
            zzfhk.zzn(2, this.zzfzs);
        }
        if (this.zzjja != null) {
            zzfhk.zzf(3, this.zzjja.longValue());
        }
        if (this.zzjgz != null) {
            zzfhk.zzc(4, this.zzjgz.floatValue());
        }
        if (this.zzjha != null) {
            zzfhk.zza(5, this.zzjha.doubleValue());
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.name != null) {
            zzo += zzfhk.zzo(1, this.name);
        }
        if (this.zzfzs != null) {
            zzo += zzfhk.zzo(2, this.zzfzs);
        }
        if (this.zzjja != null) {
            zzo += zzfhk.zzc(3, this.zzjja.longValue());
        }
        if (this.zzjgz != null) {
            this.zzjgz.floatValue();
            zzo += zzfhk.zzkx(4) + 4;
        }
        if (this.zzjha == null) {
            return zzo;
        }
        this.zzjha.doubleValue();
        return zzo + zzfhk.zzkx(5) + 8;
    }
}
