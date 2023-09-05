package com.google.android.gms.internal;

import java.util.Iterator;

final class zzdzi implements Iterator<zzdzj> {
    private int zzmii = (this.zzmij.length - 1);
    private /* synthetic */ zzdzh zzmij;

    zzdzi(zzdzh zzdzh) {
        this.zzmij = zzdzh;
    }

    public final boolean hasNext() {
        return this.zzmii >= 0;
    }

    public final /* synthetic */ Object next() {
        boolean z = true;
        zzdzj zzdzj = new zzdzj();
        if ((this.zzmij.value & ((long) (1 << this.zzmii))) != 0) {
            z = false;
        }
        zzdzj.zzmik = z;
        zzdzj.zzmil = (int) Math.pow(2.0d, (double) this.zzmii);
        this.zzmii--;
        return zzdzj;
    }

    public final void remove() {
    }
}
