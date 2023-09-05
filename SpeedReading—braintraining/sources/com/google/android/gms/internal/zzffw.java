package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

final class zzffw<E> extends zzfdl<E> {
    private static final zzffw<Object> zzpds;
    private final List<E> zzpdt;

    static {
        zzffw<Object> zzffw = new zzffw<>();
        zzpds = zzffw;
        zzffw.zzbin();
    }

    zzffw() {
        this(new ArrayList(10));
    }

    private zzffw(List<E> list) {
        this.zzpdt = list;
    }

    public static <E> zzffw<E> zzcwg() {
        return zzpds;
    }

    public final void add(int i, E e) {
        zzctj();
        this.zzpdt.add(i, e);
        this.modCount++;
    }

    public final E get(int i) {
        return this.zzpdt.get(i);
    }

    public final E remove(int i) {
        zzctj();
        E remove = this.zzpdt.remove(i);
        this.modCount++;
        return remove;
    }

    public final E set(int i, E e) {
        zzctj();
        E e2 = this.zzpdt.set(i, e);
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.zzpdt.size();
    }

    public final /* synthetic */ zzffd zzlo(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzpdt);
        return new zzffw(arrayList);
    }
}
