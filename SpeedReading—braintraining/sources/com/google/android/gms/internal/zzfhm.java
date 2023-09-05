package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfhm;
import java.io.IOException;

public abstract class zzfhm<M extends zzfhm<M>> extends zzfhs {
    protected zzfho zzphm;

    public final <T> T zza(zzfhn<M, T> zzfhn) {
        zzfhp zzma;
        if (this.zzphm == null || (zzma = this.zzphm.zzma(zzfhn.tag >>> 3)) == null) {
            return null;
        }
        return zzma.zzb(zzfhn);
    }

    public void zza(zzfhk zzfhk) throws IOException {
        if (this.zzphm != null) {
            for (int i = 0; i < this.zzphm.size(); i++) {
                this.zzphm.zzmb(i).zza(zzfhk);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzfhj zzfhj, int i) throws IOException {
        int position = zzfhj.getPosition();
        if (!zzfhj.zzkh(i)) {
            return false;
        }
        int i2 = i >>> 3;
        zzfhu zzfhu = new zzfhu(i, zzfhj.zzal(position, zzfhj.getPosition() - position));
        zzfhp zzfhp = null;
        if (this.zzphm == null) {
            this.zzphm = new zzfho();
        } else {
            zzfhp = this.zzphm.zzma(i2);
        }
        if (zzfhp == null) {
            zzfhp = new zzfhp();
            this.zzphm.zza(i2, zzfhp);
        }
        zzfhp.zza(zzfhu);
        return true;
    }

    /* renamed from: zzcxf */
    public M clone() throws CloneNotSupportedException {
        M m = (zzfhm) super.clone();
        zzfhq.zza(this, (zzfhm) m);
        return m;
    }

    public /* synthetic */ zzfhs zzcxg() throws CloneNotSupportedException {
        return (zzfhm) clone();
    }

    /* access modifiers changed from: protected */
    public int zzo() {
        if (this.zzphm == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzphm.size(); i2++) {
            i += this.zzphm.zzmb(i2).zzo();
        }
        return i;
    }
}
