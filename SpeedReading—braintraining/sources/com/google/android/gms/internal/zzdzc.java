package com.google.android.gms.internal;

public final class zzdzc<K, V> extends zzdzd<K, V> {
    zzdzc(K k, V v) {
        super(k, v, zzdyy.zzbrq(), zzdyy.zzbrq());
    }

    zzdzc(K k, V v, zzdyz<K, V> zzdyz, zzdyz<K, V> zzdyz2) {
        super(k, v, zzdyz, zzdyz2);
    }

    public final int size() {
        return zzbrr().size() + 1 + zzbrs().size();
    }

    /* access modifiers changed from: protected */
    public final zzdzd<K, V> zza(K k, V v, zzdyz<K, V> zzdyz, zzdyz<K, V> zzdyz2) {
        if (k == null) {
            k = getKey();
        }
        if (v == null) {
            v = getValue();
        }
        if (zzdyz == null) {
            zzdyz = zzbrr();
        }
        if (zzdyz2 == null) {
            zzdyz2 = zzbrs();
        }
        return new zzdzc(k, v, zzdyz, zzdyz2);
    }

    /* access modifiers changed from: protected */
    public final int zzbro() {
        return zzdza.zzmhx;
    }

    public final boolean zzbrp() {
        return true;
    }
}
