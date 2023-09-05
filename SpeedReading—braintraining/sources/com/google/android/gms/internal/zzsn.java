package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzbq;
import java.util.Iterator;
import java.util.LinkedList;

@zzzb
final class zzsn {
    /* access modifiers changed from: private */
    public final String zzaou;
    private final LinkedList<zzso> zzbxz = new LinkedList<>();
    /* access modifiers changed from: private */
    public zzis zzbya;
    private final int zzbyb;
    private boolean zzbyc;

    zzsn(zzis zzis, String str, int i) {
        zzbq.checkNotNull(zzis);
        zzbq.checkNotNull(str);
        this.zzbya = zzis;
        this.zzaou = str;
        this.zzbyb = i;
    }

    /* access modifiers changed from: package-private */
    public final String getAdUnitId() {
        return this.zzaou;
    }

    /* access modifiers changed from: package-private */
    public final int getNetworkType() {
        return this.zzbyb;
    }

    /* access modifiers changed from: package-private */
    public final int size() {
        return this.zzbxz.size();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzri zzri, zzis zzis) {
        this.zzbxz.add(new zzso(this, zzri, zzis));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb(zzri zzri) {
        zzso zzso = new zzso(this, zzri);
        this.zzbxz.add(zzso);
        return zzso.load();
    }

    /* access modifiers changed from: package-private */
    public final zzis zzkr() {
        return this.zzbya;
    }

    /* access modifiers changed from: package-private */
    public final int zzks() {
        int i = 0;
        Iterator it = this.zzbxz.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = ((zzso) it.next()).zzbyh ? i2 + 1 : i2;
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzkt() {
        int i = 0;
        Iterator it = this.zzbxz.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = ((zzso) it.next()).load() ? i2 + 1 : i2;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzku() {
        this.zzbyc = true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzkv() {
        return this.zzbyc;
    }

    /* access modifiers changed from: package-private */
    public final zzso zzm(@Nullable zzis zzis) {
        if (zzis != null) {
            this.zzbya = zzis;
        }
        return this.zzbxz.remove();
    }
}
