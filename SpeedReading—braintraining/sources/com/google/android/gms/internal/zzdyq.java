package com.google.android.gms.internal;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

public abstract class zzdyq<K, V> implements Iterable<Map.Entry<K, V>> {
    public abstract boolean containsKey(K k);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdyq)) {
            return false;
        }
        zzdyq zzdyq = (zzdyq) obj;
        if (!getComparator().equals(zzdyq.getComparator())) {
            return false;
        }
        if (size() != zzdyq.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = zzdyq.iterator();
        while (it.hasNext()) {
            if (!((Map.Entry) it.next()).equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract V get(K k);

    public abstract Comparator<K> getComparator();

    public int hashCode() {
        int hashCode = getComparator().hashCode();
        Iterator it = iterator();
        while (true) {
            int i = hashCode;
            if (!it.hasNext()) {
                return i;
            }
            hashCode = ((Map.Entry) it.next()).hashCode() + (i * 31);
        }
    }

    public abstract int indexOf(K k);

    public abstract boolean isEmpty();

    public abstract Iterator<Map.Entry<K, V>> iterator();

    public abstract int size();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("{");
        Iterator it = iterator();
        boolean z = true;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append("(");
            sb.append(entry.getKey());
            sb.append("=>");
            sb.append(entry.getValue());
            sb.append(")");
        }
        sb.append("};");
        return sb.toString();
    }

    public abstract void zza(zzdzb<K, V> zzdzb);

    public abstract zzdyq<K, V> zzbe(K k);

    public abstract Iterator<Map.Entry<K, V>> zzbf(K k);

    public abstract K zzbg(K k);

    public abstract K zzbri();

    public abstract K zzbrj();

    public abstract Iterator<Map.Entry<K, V>> zzbrk();

    public abstract zzdyq<K, V> zzf(K k, V v);
}
