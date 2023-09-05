package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfhm;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class zzfhn<M extends zzfhm<M>, T> {
    public final int tag;
    private int type;
    protected final Class<T> zznbf;
    private zzfem<?, ?> zzpci;
    protected final boolean zzphn;

    private zzfhn(int i, Class<T> cls, int i2, boolean z) {
        this(11, cls, (zzfem<?, ?>) null, i2, false);
    }

    private zzfhn(int i, Class<T> cls, zzfem<?, ?> zzfem, int i2, boolean z) {
        this.type = i;
        this.zznbf = cls;
        this.tag = i2;
        this.zzphn = false;
        this.zzpci = null;
    }

    public static <M extends zzfhm<M>, T extends zzfhs> zzfhn<M, T> zza(int i, Class<T> cls, long j) {
        return new zzfhn<>(11, cls, (int) j, false);
    }

    private final Object zzan(zzfhj zzfhj) {
        Class<?> componentType = this.zzphn ? this.zznbf.getComponentType() : this.zznbf;
        try {
            switch (this.type) {
                case 10:
                    zzfhs zzfhs = (zzfhs) componentType.newInstance();
                    zzfhj.zza(zzfhs, this.tag >>> 3);
                    return zzfhs;
                case 11:
                    zzfhs zzfhs2 = (zzfhs) componentType.newInstance();
                    zzfhj.zza(zzfhs2);
                    return zzfhs2;
                default:
                    throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
            }
        } catch (InstantiationException e) {
            String valueOf = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Error creating instance of class ").append(valueOf).toString(), e);
        } catch (IllegalAccessException e2) {
            String valueOf2 = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 33).append("Error creating instance of class ").append(valueOf2).toString(), e2);
        } catch (IOException e3) {
            throw new IllegalArgumentException("Error reading extension field", e3);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfhn)) {
            return false;
        }
        zzfhn zzfhn = (zzfhn) obj;
        return this.type == zzfhn.type && this.zznbf == zzfhn.zznbf && this.tag == zzfhn.tag && this.zzphn == zzfhn.zzphn;
    }

    public final int hashCode() {
        return (this.zzphn ? 1 : 0) + ((((((this.type + 1147) * 31) + this.zznbf.hashCode()) * 31) + this.tag) * 31);
    }

    /* access modifiers changed from: protected */
    public final void zza(Object obj, zzfhk zzfhk) {
        try {
            zzfhk.zzly(this.tag);
            switch (this.type) {
                case 10:
                    ((zzfhs) obj).zza(zzfhk);
                    zzfhk.zzz(this.tag >>> 3, 4);
                    return;
                case 11:
                    zzfhk.zzb((zzfhs) obj);
                    return;
                default:
                    throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    /* access modifiers changed from: package-private */
    public final T zzbp(List<zzfhu> list) {
        if (list == null) {
            return null;
        }
        if (this.zzphn) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                zzfhu zzfhu = list.get(i);
                if (zzfhu.zzjkv.length != 0) {
                    arrayList.add(zzan(zzfhj.zzbd(zzfhu.zzjkv)));
                }
            }
            int size = arrayList.size();
            if (size == 0) {
                return null;
            }
            T cast = this.zznbf.cast(Array.newInstance(this.zznbf.getComponentType(), size));
            for (int i2 = 0; i2 < size; i2++) {
                Array.set(cast, i2, arrayList.get(i2));
            }
            return cast;
        } else if (list.isEmpty()) {
            return null;
        } else {
            return this.zznbf.cast(zzan(zzfhj.zzbd(list.get(list.size() - 1).zzjkv)));
        }
    }

    /* access modifiers changed from: protected */
    public final int zzcl(Object obj) {
        int i = this.tag >>> 3;
        switch (this.type) {
            case 10:
                return (zzfhk.zzkx(i) << 1) + ((zzfhs) obj).zzhl();
            case 11:
                return zzfhk.zzb(i, (zzfhs) obj);
            default:
                throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
        }
    }
}
