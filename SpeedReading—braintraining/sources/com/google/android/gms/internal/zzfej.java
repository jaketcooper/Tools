package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfel;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzfej<FieldDescriptorType extends zzfel<FieldDescriptorType>> {
    private static final zzfej zzpcd = new zzfej(true);
    private boolean zzkra;
    private final zzfgc<FieldDescriptorType, Object> zzpcb = zzfgc.zzlq(16);
    private boolean zzpcc = false;

    private zzfej() {
    }

    private zzfej(boolean z) {
        if (!this.zzkra) {
            this.zzpcb.zzbin();
            this.zzkra = true;
        }
    }

    static int zza(zzfgz zzfgz, int i, Object obj) {
        int i2;
        int zzld;
        int zzkx = zzfed.zzkx(i);
        if (zzfgz == zzfgz.GROUP) {
            zzfez.zzg((zzffq) obj);
            i2 = zzkx << 1;
        } else {
            i2 = zzkx;
        }
        switch (zzfek.zzpcf[zzfgz.ordinal()]) {
            case 1:
                zzld = zzfed.zzn(((Double) obj).doubleValue());
                break;
            case 2:
                zzld = zzfed.zzf(((Float) obj).floatValue());
                break;
            case 3:
                zzld = zzfed.zzcv(((Long) obj).longValue());
                break;
            case 4:
                zzld = zzfed.zzcw(((Long) obj).longValue());
                break;
            case 5:
                zzld = zzfed.zzky(((Integer) obj).intValue());
                break;
            case 6:
                zzld = zzfed.zzcy(((Long) obj).longValue());
                break;
            case 7:
                zzld = zzfed.zzlb(((Integer) obj).intValue());
                break;
            case 8:
                zzld = zzfed.zzda(((Boolean) obj).booleanValue());
                break;
            case 9:
                zzld = zzfed.zzf((zzffq) obj);
                break;
            case 10:
                if (!(obj instanceof zzffg)) {
                    zzld = zzfed.zze((zzffq) obj);
                    break;
                } else {
                    zzld = zzfed.zza((zzffg) obj);
                    break;
                }
            case 11:
                if (!(obj instanceof zzfdp)) {
                    zzld = zzfed.zzte((String) obj);
                    break;
                } else {
                    zzld = zzfed.zzan((zzfdp) obj);
                    break;
                }
            case 12:
                if (!(obj instanceof zzfdp)) {
                    zzld = zzfed.zzbc((byte[]) obj);
                    break;
                } else {
                    zzld = zzfed.zzan((zzfdp) obj);
                    break;
                }
            case 13:
                zzld = zzfed.zzkz(((Integer) obj).intValue());
                break;
            case 14:
                zzld = zzfed.zzlc(((Integer) obj).intValue());
                break;
            case 15:
                zzld = zzfed.zzcz(((Long) obj).longValue());
                break;
            case 16:
                zzld = zzfed.zzla(((Integer) obj).intValue());
                break;
            case 17:
                zzld = zzfed.zzcx(((Long) obj).longValue());
                break;
            case 18:
                if (!(obj instanceof zzffa)) {
                    zzld = zzfed.zzld(((Integer) obj).intValue());
                    break;
                } else {
                    zzld = zzfed.zzld(((zzffa) obj).zzhn());
                    break;
                }
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return i2 + zzld;
    }

    public static Object zza(zzfdy zzfdy, zzfgz zzfgz, boolean z) throws IOException {
        zzfhf zzfhf = zzfhf.STRICT;
        switch (zzfgy.zzpcf[zzfgz.ordinal()]) {
            case 1:
                return Double.valueOf(zzfdy.readDouble());
            case 2:
                return Float.valueOf(zzfdy.readFloat());
            case 3:
                return Long.valueOf(zzfdy.zzctv());
            case 4:
                return Long.valueOf(zzfdy.zzctu());
            case 5:
                return Integer.valueOf(zzfdy.zzctw());
            case 6:
                return Long.valueOf(zzfdy.zzctx());
            case 7:
                return Integer.valueOf(zzfdy.zzcty());
            case 8:
                return Boolean.valueOf(zzfdy.zzctz());
            case 9:
                return zzfdy.zzcub();
            case 10:
                return Integer.valueOf(zzfdy.zzcuc());
            case 11:
                return Integer.valueOf(zzfdy.zzcue());
            case 12:
                return Long.valueOf(zzfdy.zzcuf());
            case 13:
                return Integer.valueOf(zzfdy.zzcug());
            case 14:
                return Long.valueOf(zzfdy.zzcuh());
            case 15:
                return zzfhf.zzb(zzfdy);
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    static void zza(zzfed zzfed, zzfgz zzfgz, int i, Object obj) throws IOException {
        int i2 = 0;
        if (zzfgz == zzfgz.GROUP) {
            zzfez.zzg((zzffq) obj);
            zzfed.zzz(i, 3);
            ((zzffq) obj).zza(zzfed);
            zzfed.zzz(i, 4);
            return;
        }
        zzfed.zzz(i, zzfgz.zzcxe());
        switch (zzfek.zzpcf[zzfgz.ordinal()]) {
            case 1:
                zzfed.zzcu(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                return;
            case 2:
                zzfed.zzkw(Float.floatToRawIntBits(((Float) obj).floatValue()));
                return;
            case 3:
                zzfed.zzcs(((Long) obj).longValue());
                return;
            case 4:
                zzfed.zzcs(((Long) obj).longValue());
                return;
            case 5:
                zzfed.zzkt(((Integer) obj).intValue());
                return;
            case 6:
                zzfed.zzcu(((Long) obj).longValue());
                return;
            case 7:
                zzfed.zzkw(((Integer) obj).intValue());
                return;
            case 8:
                if (((Boolean) obj).booleanValue()) {
                    i2 = 1;
                }
                zzfed.zzb((byte) i2);
                return;
            case 9:
                ((zzffq) obj).zza(zzfed);
                return;
            case 10:
                zzfed.zzd((zzffq) obj);
                return;
            case 11:
                if (obj instanceof zzfdp) {
                    zzfed.zzam((zzfdp) obj);
                    return;
                } else {
                    zzfed.zztd((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzfdp) {
                    zzfed.zzam((zzfdp) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzfed.zzi(bArr, 0, bArr.length);
                return;
            case 13:
                zzfed.zzku(((Integer) obj).intValue());
                return;
            case 14:
                zzfed.zzkw(((Integer) obj).intValue());
                return;
            case 15:
                zzfed.zzcu(((Long) obj).longValue());
                return;
            case 16:
                zzfed.zzkv(((Integer) obj).intValue());
                return;
            case 17:
                zzfed.zzct(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzffa) {
                    zzfed.zzkt(((zzffa) obj).zzhn());
                    return;
                } else {
                    zzfed.zzkt(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.util.ArrayList} */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zza(FieldDescriptorType r7, java.lang.Object r8) {
        /*
            r6 = this;
            boolean r0 = r7.zzcvd()
            if (r0 == 0) goto L_0x0034
            boolean r0 = r8 instanceof java.util.List
            if (r0 != 0) goto L_0x0012
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Wrong object type used with protocol message reflection."
            r0.<init>(r1)
            throw r0
        L_0x0012:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r8 = (java.util.List) r8
            r1.addAll(r8)
            r0 = r1
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r3 = r0.size()
            r2 = 0
        L_0x0024:
            if (r2 >= r3) goto L_0x003c
            java.lang.Object r4 = r0.get(r2)
            int r2 = r2 + 1
            com.google.android.gms.internal.zzfgz r5 = r7.zzcvc()
            zza((com.google.android.gms.internal.zzfgz) r5, (java.lang.Object) r4)
            goto L_0x0024
        L_0x0034:
            com.google.android.gms.internal.zzfgz r0 = r7.zzcvc()
            zza((com.google.android.gms.internal.zzfgz) r0, (java.lang.Object) r8)
            r1 = r8
        L_0x003c:
            boolean r0 = r1 instanceof com.google.android.gms.internal.zzffg
            if (r0 == 0) goto L_0x0043
            r0 = 1
            r6.zzpcc = r0
        L_0x0043:
            com.google.android.gms.internal.zzfgc<FieldDescriptorType, java.lang.Object> r0 = r6.zzpcb
            r0.put(r7, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfej.zza(com.google.android.gms.internal.zzfel, java.lang.Object):void");
    }

    private static void zza(zzfgz zzfgz, Object obj) {
        boolean z = false;
        zzfez.checkNotNull(obj);
        switch (zzfek.zzpce[zzfgz.zzcxd().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if ((obj instanceof zzfdp) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
            case 8:
                if ((obj instanceof Integer) || (obj instanceof zzffa)) {
                    z = true;
                    break;
                }
            case 9:
                if ((obj instanceof zzffq) || (obj instanceof zzffg)) {
                    z = true;
                    break;
                }
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public static <T extends zzfel<T>> zzfej<T> zzcvb() {
        return new zzfej<>();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzfej zzfej = new zzfej();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzpcb.zzcwk()) {
                break;
            }
            Map.Entry<FieldDescriptorType, Object> zzlr = this.zzpcb.zzlr(i2);
            zzfej.zza((zzfel) zzlr.getKey(), zzlr.getValue());
            i = i2 + 1;
        }
        for (Map.Entry next : this.zzpcb.zzcwl()) {
            zzfej.zza((zzfel) next.getKey(), next.getValue());
        }
        zzfej.zzpcc = this.zzpcc;
        return zzfej;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfej)) {
            return false;
        }
        return this.zzpcb.equals(((zzfej) obj).zzpcb);
    }

    public final int hashCode() {
        return this.zzpcb.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        return this.zzpcc ? new zzffj(this.zzpcb.entrySet().iterator()) : this.zzpcb.entrySet().iterator();
    }
}
