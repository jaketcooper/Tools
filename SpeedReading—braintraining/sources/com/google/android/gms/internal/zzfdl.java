package com.google.android.gms.internal;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzfdl<E> extends AbstractList<E> implements zzffd<E> {
    private boolean zzpav = true;

    zzfdl() {
    }

    public void add(int i, E e) {
        zzctj();
        super.add(i, e);
    }

    public boolean add(E e) {
        zzctj();
        return super.add(e);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        zzctj();
        return super.addAll(i, collection);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zzctj();
        return super.addAll(collection);
    }

    public void clear() {
        zzctj();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public E remove(int i) {
        zzctj();
        return super.remove(i);
    }

    public boolean remove(Object obj) {
        zzctj();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        zzctj();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        zzctj();
        return super.retainAll(collection);
    }

    public E set(int i, E e) {
        zzctj();
        return super.set(i, e);
    }

    public final void zzbin() {
        this.zzpav = false;
    }

    public final boolean zzcti() {
        return this.zzpav;
    }

    /* access modifiers changed from: protected */
    public final void zzctj() {
        if (!this.zzpav) {
            throw new UnsupportedOperationException();
        }
    }
}
