package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.Map;

final class zzfgi implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private /* synthetic */ zzfgc zzper;
    private boolean zzpes;
    private Iterator<Map.Entry<K, V>> zzpet;

    private zzfgi(zzfgc zzfgc) {
        this.zzper = zzfgc;
        this.pos = -1;
    }

    /* synthetic */ zzfgi(zzfgc zzfgc, zzfgd zzfgd) {
        this(zzfgc);
    }

    private final Iterator<Map.Entry<K, V>> zzcwq() {
        if (this.zzpet == null) {
            this.zzpet = this.zzper.zzpel.entrySet().iterator();
        }
        return this.zzpet;
    }

    public final boolean hasNext() {
        return this.pos + 1 < this.zzper.zzpek.size() || zzcwq().hasNext();
    }

    public final /* synthetic */ Object next() {
        this.zzpes = true;
        int i = this.pos + 1;
        this.pos = i;
        return i < this.zzper.zzpek.size() ? (Map.Entry) this.zzper.zzpek.get(this.pos) : (Map.Entry) zzcwq().next();
    }

    public final void remove() {
        if (!this.zzpes) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzpes = false;
        this.zzper.zzcwm();
        if (this.pos < this.zzper.zzpek.size()) {
            zzfgc zzfgc = this.zzper;
            int i = this.pos;
            this.pos = i - 1;
            Object unused = zzfgc.zzls(i);
            return;
        }
        zzcwq().remove();
    }
}
