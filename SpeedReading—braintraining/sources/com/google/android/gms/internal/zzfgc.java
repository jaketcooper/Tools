package com.google.android.gms.internal;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzfgc<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzkra;
    private final int zzpej;
    /* access modifiers changed from: private */
    public List<zzfgh> zzpek;
    /* access modifiers changed from: private */
    public Map<K, V> zzpel;
    private volatile zzfgj zzpem;
    private Map<K, V> zzpen;

    private zzfgc(int i) {
        this.zzpej = i;
        this.zzpek = Collections.emptyList();
        this.zzpel = Collections.emptyMap();
        this.zzpen = Collections.emptyMap();
    }

    /* synthetic */ zzfgc(int i, zzfgd zzfgd) {
        this(i);
    }

    private final int zza(K k) {
        int size = this.zzpek.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzpek.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        int i2 = size;
        while (i <= i2) {
            int i3 = (i + i2) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zzpek.get(i3).getKey());
            if (compareTo2 < 0) {
                i2 = i3 - 1;
            } else if (compareTo2 <= 0) {
                return i3;
            } else {
                i = i3 + 1;
            }
        }
        return -(i + 1);
    }

    /* access modifiers changed from: private */
    public final void zzcwm() {
        if (this.zzkra) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzcwn() {
        zzcwm();
        if (this.zzpel.isEmpty() && !(this.zzpel instanceof TreeMap)) {
            this.zzpel = new TreeMap();
            this.zzpen = ((TreeMap) this.zzpel).descendingMap();
        }
        return (SortedMap) this.zzpel;
    }

    static <FieldDescriptorType extends zzfel<FieldDescriptorType>> zzfgc<FieldDescriptorType, Object> zzlq(int i) {
        return new zzfgd(i);
    }

    /* access modifiers changed from: private */
    public final V zzls(int i) {
        zzcwm();
        V value = this.zzpek.remove(i).getValue();
        if (!this.zzpel.isEmpty()) {
            Iterator it = zzcwn().entrySet().iterator();
            this.zzpek.add(new zzfgh(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    public void clear() {
        zzcwm();
        if (!this.zzpek.isEmpty()) {
            this.zzpek.clear();
        }
        if (!this.zzpel.isEmpty()) {
            this.zzpel.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzpel.containsKey(comparable);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzpem == null) {
            this.zzpem = new zzfgj(this, (zzfgd) null);
        }
        return this.zzpem;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfgc)) {
            return super.equals(obj);
        }
        zzfgc zzfgc = (zzfgc) obj;
        int size = size();
        if (size != zzfgc.size()) {
            return false;
        }
        int zzcwk = zzcwk();
        if (zzcwk != zzfgc.zzcwk()) {
            return entrySet().equals(zzfgc.entrySet());
        }
        for (int i = 0; i < zzcwk; i++) {
            if (!zzlr(i).equals(zzfgc.zzlr(i))) {
                return false;
            }
        }
        if (zzcwk != size) {
            return this.zzpel.equals(zzfgc.zzpel);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        return zza >= 0 ? this.zzpek.get(zza).getValue() : this.zzpel.get(comparable);
    }

    public int hashCode() {
        int zzcwk = zzcwk();
        int i = 0;
        for (int i2 = 0; i2 < zzcwk; i2++) {
            i += this.zzpek.get(i2).hashCode();
        }
        return this.zzpel.size() > 0 ? this.zzpel.hashCode() + i : i;
    }

    public final boolean isImmutable() {
        return this.zzkra;
    }

    public V remove(Object obj) {
        zzcwm();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return zzls(zza);
        }
        if (this.zzpel.isEmpty()) {
            return null;
        }
        return this.zzpel.remove(comparable);
    }

    public int size() {
        return this.zzpek.size() + this.zzpel.size();
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zzcwm();
        int zza = zza(k);
        if (zza >= 0) {
            return this.zzpek.get(zza).setValue(v);
        }
        zzcwm();
        if (this.zzpek.isEmpty() && !(this.zzpek instanceof ArrayList)) {
            this.zzpek = new ArrayList(this.zzpej);
        }
        int i = -(zza + 1);
        if (i >= this.zzpej) {
            return zzcwn().put(k, v);
        }
        if (this.zzpek.size() == this.zzpej) {
            zzfgh remove = this.zzpek.remove(this.zzpej - 1);
            zzcwn().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzpek.add(i, new zzfgh(this, k, v));
        return null;
    }

    public void zzbin() {
        if (!this.zzkra) {
            this.zzpel = this.zzpel.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzpel);
            this.zzpen = this.zzpen.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzpen);
            this.zzkra = true;
        }
    }

    public final int zzcwk() {
        return this.zzpek.size();
    }

    public final Iterable<Map.Entry<K, V>> zzcwl() {
        return this.zzpel.isEmpty() ? zzfge.zzcwo() : this.zzpel.entrySet();
    }

    public final Map.Entry<K, V> zzlr(int i) {
        return this.zzpek.get(i);
    }
}
