package com.google.android.gms.internal;

public final class zzdyx<K, V> extends zzdzd<K, V> {
    private int size = -1;

    zzdyx(K k, V v, zzdyz<K, V> zzdyz, zzdyz<K, V> zzdyz2) {
        super(k, v, zzdyz, zzdyz2);
    }

    public final int size() {
        if (this.size == -1) {
            this.size = zzbrr().size() + 1 + zzbrs().size();
        }
        return this.size;
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
        return new zzdyx(k, v, zzdyz, zzdyz2);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzdyz<K, V> zzdyz) {
        if (this.size != -1) {
            throw new IllegalStateException("Can't set left after using size");
        }
        super.zza(zzdyz);
    }

    /* access modifiers changed from: protected */
    public final int zzbro() {
        return zzdza.zzmhy;
    }

    public final boolean zzbrp() {
        return false;
    }
}
