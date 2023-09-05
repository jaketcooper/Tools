package com.google.android.gms.internal;

import java.util.Comparator;

public abstract class zzdzd<K, V> implements zzdyz<K, V> {
    private final V value;
    private final K zzmia;
    private zzdyz<K, V> zzmib;
    private final zzdyz<K, V> zzmic;

    zzdzd(K k, V v, zzdyz<K, V> zzdyz, zzdyz<K, V> zzdyz2) {
        this.zzmia = k;
        this.value = v;
        this.zzmib = zzdyz == null ? zzdyy.zzbrq() : zzdyz;
        this.zzmic = zzdyz2 == null ? zzdyy.zzbrq() : zzdyz2;
    }

    private static int zzb(zzdyz zzdyz) {
        return zzdyz.zzbrp() ? zzdza.zzmhy : zzdza.zzmhx;
    }

    private final zzdzd<K, V> zzb(K k, V v, Integer num, zzdyz<K, V> zzdyz, zzdyz<K, V> zzdyz2) {
        K k2 = this.zzmia;
        V v2 = this.value;
        if (zzdyz == null) {
            zzdyz = this.zzmib;
        }
        if (zzdyz2 == null) {
            zzdyz2 = this.zzmic;
        }
        return num == zzdza.zzmhx ? new zzdzc(k2, v2, zzdyz, zzdyz2) : new zzdyx(k2, v2, zzdyz, zzdyz2);
    }

    private final zzdyz<K, V> zzbrv() {
        if (this.zzmib.isEmpty()) {
            return zzdyy.zzbrq();
        }
        if (!this.zzmib.zzbrp() && !this.zzmib.zzbrr().zzbrp()) {
            this = zzbrw();
        }
        return this.zza((Object) null, (Object) null, ((zzdzd) this.zzmib).zzbrv(), (zzdyz) null).zzbrx();
    }

    private final zzdzd<K, V> zzbrw() {
        zzdzd<K, V> zzbsa = zzbsa();
        return zzbsa.zzmic.zzbrr().zzbrp() ? zzbsa.zza((K) null, (V) null, (zzdyz<K, V>) null, ((zzdzd) zzbsa.zzmic).zzbrz()).zzbry().zzbsa() : zzbsa;
    }

    private final zzdzd<K, V> zzbrx() {
        if (this.zzmic.zzbrp() && !this.zzmib.zzbrp()) {
            this = zzbry();
        }
        if (this.zzmib.zzbrp() && ((zzdzd) this.zzmib).zzmib.zzbrp()) {
            this = this.zzbrz();
        }
        return (!this.zzmib.zzbrp() || !this.zzmic.zzbrp()) ? this : this.zzbsa();
    }

    private final zzdzd<K, V> zzbry() {
        return (zzdzd) this.zzmic.zza(null, null, zzbro(), zzb((Object) null, (Object) null, zzdza.zzmhx, (zzdyz) null, ((zzdzd) this.zzmic).zzmib), (zzdzd<K, V>) null);
    }

    private final zzdzd<K, V> zzbrz() {
        return (zzdzd) this.zzmib.zza(null, null, zzbro(), (zzdyz) null, zzb((Object) null, (Object) null, zzdza.zzmhx, ((zzdzd) this.zzmib).zzmic, (zzdyz<K, V>) null));
    }

    private final zzdzd<K, V> zzbsa() {
        return zzb((Object) null, (Object) null, zzb(this), this.zzmib.zza(null, null, zzb(this.zzmib), (zzdyz) null, (zzdyz) null), this.zzmic.zza(null, null, zzb(this.zzmic), (zzdyz) null, (zzdyz) null));
    }

    public final K getKey() {
        return this.zzmia;
    }

    public final V getValue() {
        return this.value;
    }

    public final boolean isEmpty() {
        return false;
    }

    public final /* synthetic */ zzdyz zza(Object obj, Object obj2, int i, zzdyz zzdyz, zzdyz zzdyz2) {
        return zzb((Object) null, (Object) null, i, zzdyz, zzdyz2);
    }

    public final zzdyz<K, V> zza(K k, V v, Comparator<K> comparator) {
        int compare = comparator.compare(k, this.zzmia);
        return (compare < 0 ? zza((Object) null, (Object) null, this.zzmib.zza(k, v, comparator), (zzdyz<K, V>) null) : compare == 0 ? zza(k, v, (zzdyz) null, (zzdyz) null) : zza((Object) null, (Object) null, (zzdyz) null, this.zzmic.zza(k, v, comparator))).zzbrx();
    }

    public final zzdyz<K, V> zza(K k, Comparator<K> comparator) {
        zzdzd<K, V> zza;
        if (comparator.compare(k, this.zzmia) < 0) {
            if (!this.zzmib.isEmpty() && !this.zzmib.zzbrp() && !((zzdzd) this.zzmib).zzmib.zzbrp()) {
                this = zzbrw();
            }
            zza = this.zza((Object) null, (Object) null, this.zzmib.zza(k, comparator), (zzdyz<K, V>) null);
        } else {
            if (this.zzmib.zzbrp()) {
                this = zzbrz();
            }
            if (!this.zzmic.isEmpty() && !this.zzmic.zzbrp() && !((zzdzd) this.zzmic).zzmib.zzbrp()) {
                zzdzd zzbsa = this.zzbsa();
                if (zzbsa.zzmib.zzbrr().zzbrp()) {
                    zzbsa = zzbsa.zzbrz().zzbsa();
                }
                this = zzbsa;
            }
            if (comparator.compare(k, this.zzmia) == 0) {
                if (this.zzmic.isEmpty()) {
                    return zzdyy.zzbrq();
                }
                zzdyz<K, V> zzbrt = this.zzmic.zzbrt();
                this = this.zza(zzbrt.getKey(), zzbrt.getValue(), (zzdyz) null, ((zzdzd) this.zzmic).zzbrv());
            }
            zza = this.zza((Object) null, (Object) null, (zzdyz) null, this.zzmic.zza(k, comparator));
        }
        return zza.zzbrx();
    }

    /* access modifiers changed from: protected */
    public abstract zzdzd<K, V> zza(K k, V v, zzdyz<K, V> zzdyz, zzdyz<K, V> zzdyz2);

    /* access modifiers changed from: package-private */
    public void zza(zzdyz<K, V> zzdyz) {
        this.zzmib = zzdyz;
    }

    public final void zza(zzdzb<K, V> zzdzb) {
        this.zzmib.zza(zzdzb);
        zzdzb.zzg(this.zzmia, this.value);
        this.zzmic.zza(zzdzb);
    }

    /* access modifiers changed from: protected */
    public abstract int zzbro();

    public final zzdyz<K, V> zzbrr() {
        return this.zzmib;
    }

    public final zzdyz<K, V> zzbrs() {
        return this.zzmic;
    }

    public final zzdyz<K, V> zzbrt() {
        return this.zzmib.isEmpty() ? this : this.zzmib.zzbrt();
    }

    public final zzdyz<K, V> zzbru() {
        return this.zzmic.isEmpty() ? this : this.zzmic.zzbru();
    }
}
