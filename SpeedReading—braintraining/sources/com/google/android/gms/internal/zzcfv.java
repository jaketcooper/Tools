package com.google.android.gms.internal;

import java.util.Iterator;

final class zzcfv implements Iterator<String> {
    private Iterator<String> zzixg = this.zzixh.zzdyg.keySet().iterator();
    private /* synthetic */ zzcfu zzixh;

    zzcfv(zzcfu zzcfu) {
        this.zzixh = zzcfu;
    }

    public final boolean hasNext() {
        return this.zzixg.hasNext();
    }

    public final /* synthetic */ Object next() {
        return this.zzixg.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
