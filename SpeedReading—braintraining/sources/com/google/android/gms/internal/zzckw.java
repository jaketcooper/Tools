package com.google.android.gms.internal;

import java.io.IOException;

public final class zzckw extends zzfhm<zzckw> {
    private static volatile zzckw[] zzjiq;
    public String key = null;
    public String value = null;

    public zzckw() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    public static zzckw[] zzbau() {
        if (zzjiq == null) {
            synchronized (zzfhq.zzphu) {
                if (zzjiq == null) {
                    zzjiq = new zzckw[0];
                }
            }
        }
        return zzjiq;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzckw)) {
            return false;
        }
        zzckw zzckw = (zzckw) obj;
        if (this.key == null) {
            if (zzckw.key != null) {
                return false;
            }
        } else if (!this.key.equals(zzckw.key)) {
            return false;
        }
        if (this.value == null) {
            if (zzckw.value != null) {
                return false;
            }
        } else if (!this.value.equals(zzckw.value)) {
            return false;
        }
        return (this.zzphm == null || this.zzphm.isEmpty()) ? zzckw.zzphm == null || zzckw.zzphm.isEmpty() : this.zzphm.equals(zzckw.zzphm);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.value == null ? 0 : this.value.hashCode()) + (((this.key == null ? 0 : this.key.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
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
                    this.key = zzfhj.readString();
                    continue;
                case 18:
                    this.value = zzfhj.readString();
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
        if (this.key != null) {
            zzfhk.zzn(1, this.key);
        }
        if (this.value != null) {
            zzfhk.zzn(2, this.value);
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.key != null) {
            zzo += zzfhk.zzo(1, this.key);
        }
        return this.value != null ? zzo + zzfhk.zzo(2, this.value) : zzo;
    }
}
