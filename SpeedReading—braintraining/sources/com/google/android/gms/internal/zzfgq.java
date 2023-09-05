package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class zzfgq {
    private static final zzfgq zzpez = new zzfgq(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzpav;
    private int zzpch;
    private int[] zzpfa;
    private Object[] zzpfb;

    private zzfgq() {
        this(0, new int[8], new Object[8], true);
    }

    private zzfgq(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzpch = -1;
        this.count = i;
        this.zzpfa = iArr;
        this.zzpfb = objArr;
        this.zzpav = z;
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private final com.google.android.gms.internal.zzfgq zza(com.google.android.gms.internal.zzfdy r2) throws java.io.IOException {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r2.zzctt()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.zzb((int) r0, (com.google.android.gms.internal.zzfdy) r2)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfgq.zza(com.google.android.gms.internal.zzfdy):com.google.android.gms.internal.zzfgq");
    }

    static zzfgq zzb(zzfgq zzfgq, zzfgq zzfgq2) {
        int i = zzfgq.count + zzfgq2.count;
        int[] copyOf = Arrays.copyOf(zzfgq.zzpfa, i);
        System.arraycopy(zzfgq2.zzpfa, 0, copyOf, zzfgq.count, zzfgq2.count);
        Object[] copyOf2 = Arrays.copyOf(zzfgq.zzpfb, i);
        System.arraycopy(zzfgq2.zzpfb, 0, copyOf2, zzfgq.count, zzfgq2.count);
        return new zzfgq(i, copyOf, copyOf2, true);
    }

    private void zzb(int i, Object obj) {
        if (this.count == this.zzpfa.length) {
            int i2 = (this.count < 4 ? 8 : this.count >> 1) + this.count;
            this.zzpfa = Arrays.copyOf(this.zzpfa, i2);
            this.zzpfb = Arrays.copyOf(this.zzpfb, i2);
        }
        this.zzpfa[this.count] = i;
        this.zzpfb[this.count] = obj;
        this.count++;
    }

    public static zzfgq zzcwv() {
        return zzpez;
    }

    static zzfgq zzcww() {
        return new zzfgq();
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof zzfgq)) {
            return false;
        }
        zzfgq zzfgq = (zzfgq) obj;
        if (this.count == zzfgq.count) {
            int[] iArr = this.zzpfa;
            int[] iArr2 = zzfgq.zzpfa;
            int i = this.count;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.zzpfb;
                Object[] objArr2 = zzfgq.zzpfb;
                int i3 = this.count;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.count + 527) * 31) + Arrays.hashCode(this.zzpfa)) * 31) + Arrays.deepHashCode(this.zzpfb);
    }

    public final void zza(zzfed zzfed) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.count) {
                int i3 = this.zzpfa[i2];
                int i4 = i3 >>> 3;
                switch (i3 & 7) {
                    case 0:
                        zzfed.zza(i4, ((Long) this.zzpfb[i2]).longValue());
                        break;
                    case 1:
                        zzfed.zzb(i4, ((Long) this.zzpfb[i2]).longValue());
                        break;
                    case 2:
                        zzfed.zza(i4, (zzfdp) this.zzpfb[i2]);
                        break;
                    case 3:
                        zzfed.zzz(i4, 3);
                        ((zzfgq) this.zzpfb[i2]).zza(zzfed);
                        zzfed.zzz(i4, 4);
                        break;
                    case 5:
                        zzfed.zzac(i4, ((Integer) this.zzpfb[i2]).intValue());
                        break;
                    default:
                        throw zzffe.zzcvx();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb(int i, zzfdy zzfdy) throws IOException {
        if (!this.zzpav) {
            throw new UnsupportedOperationException();
        }
        int i2 = i >>> 3;
        switch (i & 7) {
            case 0:
                zzb(i, (Object) Long.valueOf(zzfdy.zzctv()));
                return true;
            case 1:
                zzb(i, (Object) Long.valueOf(zzfdy.zzctx()));
                return true;
            case 2:
                zzb(i, (Object) zzfdy.zzcub());
                return true;
            case 3:
                zzfgq zzfgq = new zzfgq();
                zzfgq.zza(zzfdy);
                zzfdy.zzkg((i2 << 3) | 4);
                zzb(i, (Object) zzfgq);
                return true;
            case 4:
                return false;
            case 5:
                zzb(i, (Object) Integer.valueOf(zzfdy.zzcty()));
                return true;
            default:
                throw zzffe.zzcvx();
        }
    }

    public final void zzbin() {
        this.zzpav = false;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzfft.zzb(sb, i, String.valueOf(this.zzpfa[i2] >>> 3), this.zzpfb[i2]);
        }
    }

    public final int zzhl() {
        int zzhl;
        int i = this.zzpch;
        if (i == -1) {
            i = 0;
            for (int i2 = 0; i2 < this.count; i2++) {
                int i3 = this.zzpfa[i2];
                int i4 = i3 >>> 3;
                switch (i3 & 7) {
                    case 0:
                        zzhl = zzfed.zzd(i4, ((Long) this.zzpfb[i2]).longValue());
                        break;
                    case 1:
                        zzhl = zzfed.zze(i4, ((Long) this.zzpfb[i2]).longValue());
                        break;
                    case 2:
                        zzhl = zzfed.zzb(i4, (zzfdp) this.zzpfb[i2]);
                        break;
                    case 3:
                        zzhl = ((zzfgq) this.zzpfb[i2]).zzhl() + (zzfed.zzkx(i4) << 1);
                        break;
                    case 5:
                        zzhl = zzfed.zzaf(i4, ((Integer) this.zzpfb[i2]).intValue());
                        break;
                    default:
                        throw new IllegalStateException(zzffe.zzcvx());
                }
                i += zzhl;
            }
            this.zzpch = i;
        }
        return i;
    }
}
