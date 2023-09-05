package com.google.android.gms.internal;

import java.util.Iterator;

final class zzdzh implements Iterable<zzdzj> {
    /* access modifiers changed from: private */
    public final int length;
    /* access modifiers changed from: private */
    public long value;

    public zzdzh(int i) {
        int i2 = i + 1;
        this.length = (int) Math.floor(Math.log((double) i2) / Math.log(2.0d));
        this.value = ((long) i2) & (((long) Math.pow(2.0d, (double) this.length)) - 1);
    }

    public final Iterator<zzdzj> iterator() {
        return new zzdzi(this);
    }
}
