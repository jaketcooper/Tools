package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcld extends zzfhm<zzcld> {
    private static volatile zzcld[] zzjkg;
    public String name = null;
    public String zzfzs = null;
    private Float zzjgz = null;
    public Double zzjha = null;
    public Long zzjja = null;
    public Long zzjkh = null;

    public zzcld() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    public static zzcld[] zzbaz() {
        if (zzjkg == null) {
            synchronized (zzfhq.zzphu) {
                if (zzjkg == null) {
                    zzjkg = new zzcld[0];
                }
            }
        }
        return zzjkg;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcld)) {
            return false;
        }
        zzcld zzcld = (zzcld) obj;
        if (this.zzjkh == null) {
            if (zzcld.zzjkh != null) {
                return false;
            }
        } else if (!this.zzjkh.equals(zzcld.zzjkh)) {
            return false;
        }
        if (this.name == null) {
            if (zzcld.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzcld.name)) {
            return false;
        }
        if (this.zzfzs == null) {
            if (zzcld.zzfzs != null) {
                return false;
            }
        } else if (!this.zzfzs.equals(zzcld.zzfzs)) {
            return false;
        }
        if (this.zzjja == null) {
            if (zzcld.zzjja != null) {
                return false;
            }
        } else if (!this.zzjja.equals(zzcld.zzjja)) {
            return false;
        }
        if (this.zzjgz == null) {
            if (zzcld.zzjgz != null) {
                return false;
            }
        } else if (!this.zzjgz.equals(zzcld.zzjgz)) {
            return false;
        }
        if (this.zzjha == null) {
            if (zzcld.zzjha != null) {
                return false;
            }
        } else if (!this.zzjha.equals(zzcld.zzjha)) {
            return false;
        }
        return (this.zzphm == null || this.zzphm.isEmpty()) ? zzcld.zzphm == null || zzcld.zzphm.isEmpty() : this.zzphm.equals(zzcld.zzphm);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.zzjha == null ? 0 : this.zzjha.hashCode()) + (((this.zzjgz == null ? 0 : this.zzjgz.hashCode()) + (((this.zzjja == null ? 0 : this.zzjja.hashCode()) + (((this.zzfzs == null ? 0 : this.zzfzs.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + (((this.zzjkh == null ? 0 : this.zzjkh.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
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
                    this.zzjkh = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 18:
                    this.name = zzfhj.readString();
                    continue;
                case 26:
                    this.zzfzs = zzfhj.readString();
                    continue;
                case 32:
                    this.zzjja = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 45:
                    this.zzjgz = Float.valueOf(Float.intBitsToFloat(zzfhj.zzcuo()));
                    continue;
                case 49:
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
        if (this.zzjkh != null) {
            zzfhk.zzf(1, this.zzjkh.longValue());
        }
        if (this.name != null) {
            zzfhk.zzn(2, this.name);
        }
        if (this.zzfzs != null) {
            zzfhk.zzn(3, this.zzfzs);
        }
        if (this.zzjja != null) {
            zzfhk.zzf(4, this.zzjja.longValue());
        }
        if (this.zzjgz != null) {
            zzfhk.zzc(5, this.zzjgz.floatValue());
        }
        if (this.zzjha != null) {
            zzfhk.zza(6, this.zzjha.doubleValue());
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzjkh != null) {
            zzo += zzfhk.zzc(1, this.zzjkh.longValue());
        }
        if (this.name != null) {
            zzo += zzfhk.zzo(2, this.name);
        }
        if (this.zzfzs != null) {
            zzo += zzfhk.zzo(3, this.zzfzs);
        }
        if (this.zzjja != null) {
            zzo += zzfhk.zzc(4, this.zzjja.longValue());
        }
        if (this.zzjgz != null) {
            this.zzjgz.floatValue();
            zzo += zzfhk.zzkx(5) + 4;
        }
        if (this.zzjha == null) {
            return zzo;
        }
        this.zzjha.doubleValue();
        return zzo + zzfhk.zzkx(6) + 8;
    }
}
