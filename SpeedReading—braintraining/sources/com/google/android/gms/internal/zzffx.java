package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;

final class zzffx extends zzfdp {
    /* access modifiers changed from: private */
    public static final int[] zzpdu;
    private final int zzpdv;
    /* access modifiers changed from: private */
    public final zzfdp zzpdw;
    /* access modifiers changed from: private */
    public final zzfdp zzpdx;
    private final int zzpdy;
    private final int zzpdz;

    static {
        int i = 1;
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.MAX_VALUE);
        zzpdu = new int[arrayList.size()];
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < zzpdu.length) {
                zzpdu[i5] = ((Integer) arrayList.get(i5)).intValue();
                i4 = i5 + 1;
            } else {
                return;
            }
        }
    }

    private zzffx(zzfdp zzfdp, zzfdp zzfdp2) {
        this.zzpdw = zzfdp;
        this.zzpdx = zzfdp2;
        this.zzpdy = zzfdp.size();
        this.zzpdv = this.zzpdy + zzfdp2.size();
        this.zzpdz = Math.max(zzfdp.zzctn(), zzfdp2.zzctn()) + 1;
    }

    static zzfdp zza(zzfdp zzfdp, zzfdp zzfdp2) {
        if (zzfdp2.size() == 0) {
            return zzfdp;
        }
        if (zzfdp.size() == 0) {
            return zzfdp2;
        }
        int size = zzfdp2.size() + zzfdp.size();
        if (size < 128) {
            return zzb(zzfdp, zzfdp2);
        }
        if (zzfdp instanceof zzffx) {
            zzffx zzffx = (zzffx) zzfdp;
            if (zzffx.zzpdx.size() + zzfdp2.size() < 128) {
                return new zzffx(zzffx.zzpdw, zzb(zzffx.zzpdx, zzfdp2));
            } else if (zzffx.zzpdw.zzctn() > zzffx.zzpdx.zzctn() && zzffx.zzctn() > zzfdp2.zzctn()) {
                return new zzffx(zzffx.zzpdw, new zzffx(zzffx.zzpdx, zzfdp2));
            }
        }
        return size >= zzpdu[Math.max(zzfdp.zzctn(), zzfdp2.zzctn()) + 1] ? new zzffx(zzfdp, zzfdp2) : new zzffz().zzc(zzfdp, zzfdp2);
    }

    private static zzfdp zzb(zzfdp zzfdp, zzfdp zzfdp2) {
        int size = zzfdp.size();
        int size2 = zzfdp2.size();
        byte[] bArr = new byte[(size + size2)];
        zzfdp.zza(bArr, 0, 0, size);
        zzfdp2.zza(bArr, 0, size, size2);
        return zzfdp.zzaz(bArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfdp)) {
            return false;
        }
        zzfdp zzfdp = (zzfdp) obj;
        if (this.zzpdv != zzfdp.size()) {
            return false;
        }
        if (this.zzpdv == 0) {
            return true;
        }
        int zzctp = zzctp();
        int zzctp2 = zzfdp.zzctp();
        if (zzctp != 0 && zzctp2 != 0 && zzctp != zzctp2) {
            return false;
        }
        zzfga zzfga = new zzfga(this);
        zzfga zzfga2 = new zzfga(zzfdp);
        zzfdv zzfdv = (zzfdv) zzfga2.next();
        int i = 0;
        zzfdv zzfdv2 = (zzfdv) zzfga.next();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = zzfdv2.size() - i2;
            int size2 = zzfdv.size() - i;
            int min = Math.min(size, size2);
            if (!(i2 == 0 ? zzfdv2.zza(zzfdv, i, min) : zzfdv.zza(zzfdv2, i2, min))) {
                return false;
            }
            int i4 = i3 + min;
            if (i4 < this.zzpdv) {
                if (min == size) {
                    zzfdv2 = (zzfdv) zzfga.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
                if (min == size2) {
                    zzfdv = (zzfdv) zzfga2.next();
                    i = 0;
                    i3 = i4;
                } else {
                    i += min;
                    i3 = i4;
                }
            } else if (i4 == this.zzpdv) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public final int size() {
        return this.zzpdv;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzfdo zzfdo) throws IOException {
        this.zzpdw.zza(zzfdo);
        this.zzpdx.zza(zzfdo);
    }

    /* access modifiers changed from: protected */
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        if (i + i3 <= this.zzpdy) {
            this.zzpdw.zzb(bArr, i, i2, i3);
        } else if (i >= this.zzpdy) {
            this.zzpdx.zzb(bArr, i - this.zzpdy, i2, i3);
        } else {
            int i4 = this.zzpdy - i;
            this.zzpdw.zzb(bArr, i, i2, i4);
            this.zzpdx.zzb(bArr, 0, i2 + i4, i3 - i4);
        }
    }

    public final zzfdy zzctm() {
        return zzfdy.zzi(new zzfgb(this));
    }

    /* access modifiers changed from: protected */
    public final int zzctn() {
        return this.zzpdz;
    }

    /* access modifiers changed from: protected */
    public final boolean zzcto() {
        return this.zzpdv >= zzpdu[this.zzpdz];
    }

    /* access modifiers changed from: protected */
    public final int zzg(int i, int i2, int i3) {
        if (i2 + i3 <= this.zzpdy) {
            return this.zzpdw.zzg(i, i2, i3);
        }
        if (i2 >= this.zzpdy) {
            return this.zzpdx.zzg(i, i2 - this.zzpdy, i3);
        }
        int i4 = this.zzpdy - i2;
        return this.zzpdx.zzg(this.zzpdw.zzg(i, i2, i4), 0, i3 - i4);
    }

    public final byte zzke(int i) {
        zzy(i, this.zzpdv);
        return i < this.zzpdy ? this.zzpdw.zzke(i) : this.zzpdx.zzke(i - this.zzpdy);
    }

    public final zzfdp zzx(int i, int i2) {
        int zzh = zzh(i, i2, this.zzpdv);
        if (zzh == 0) {
            return zzfdp.zzpaz;
        }
        if (zzh == this.zzpdv) {
            return this;
        }
        if (i2 <= this.zzpdy) {
            return this.zzpdw.zzx(i, i2);
        }
        if (i >= this.zzpdy) {
            return this.zzpdx.zzx(i - this.zzpdy, i2 - this.zzpdy);
        }
        zzfdp zzfdp = this.zzpdw;
        return new zzffx(zzfdp.zzx(i, zzfdp.size()), this.zzpdx.zzx(0, i2 - this.zzpdy));
    }
}
