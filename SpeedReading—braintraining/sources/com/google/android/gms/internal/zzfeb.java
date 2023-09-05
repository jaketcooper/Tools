package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class zzfeb extends zzfdy {
    private final byte[] buffer;
    private int pos;
    private int zzpbl;
    private int zzpbn;
    private int zzpbo;
    private final InputStream zzpbp;
    private int zzpbq;
    private int zzpbr;
    private zzfec zzpbs;

    private zzfeb(InputStream inputStream, int i) {
        super();
        this.zzpbo = Integer.MAX_VALUE;
        this.zzpbs = null;
        zzfez.zzc(inputStream, "input");
        this.zzpbp = inputStream;
        this.buffer = new byte[i];
        this.zzpbq = 0;
        this.pos = 0;
        this.zzpbr = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b2, code lost:
        if (((long) r4[r3]) < 0) goto L_0x00b4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzcun() throws java.io.IOException {
        /*
            r10 = this;
            r8 = 0
            int r0 = r10.pos
            int r1 = r10.zzpbq
            if (r1 == r0) goto L_0x00b4
            byte[] r4 = r10.buffer
            int r1 = r0 + 1
            byte r0 = r4[r0]
            if (r0 < 0) goto L_0x0014
            r10.pos = r1
            long r0 = (long) r0
        L_0x0013:
            return r0
        L_0x0014:
            int r2 = r10.zzpbq
            int r2 = r2 - r1
            r3 = 9
            if (r2 < r3) goto L_0x00b4
            int r2 = r1 + 1
            byte r1 = r4[r1]
            int r1 = r1 << 7
            r0 = r0 ^ r1
            if (r0 >= 0) goto L_0x002a
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            long r0 = (long) r0
        L_0x0027:
            r10.pos = r2
            goto L_0x0013
        L_0x002a:
            int r3 = r2 + 1
            byte r1 = r4[r2]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0038
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            long r0 = (long) r0
            r2 = r3
            goto L_0x0027
        L_0x0038:
            int r2 = r3 + 1
            byte r1 = r4[r3]
            int r1 = r1 << 21
            r0 = r0 ^ r1
            if (r0 >= 0) goto L_0x0047
            r1 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            long r0 = (long) r0
            goto L_0x0027
        L_0x0047:
            long r0 = (long) r0
            int r3 = r2 + 1
            byte r2 = r4[r2]
            long r6 = (long) r2
            r2 = 28
            long r6 = r6 << r2
            long r0 = r0 ^ r6
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 < 0) goto L_0x005b
            r4 = 266354560(0xfe03f80, double:1.315966377E-315)
            long r0 = r0 ^ r4
            r2 = r3
            goto L_0x0027
        L_0x005b:
            int r2 = r3 + 1
            byte r3 = r4[r3]
            long r6 = (long) r3
            r3 = 35
            long r6 = r6 << r3
            long r0 = r0 ^ r6
            int r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x006f
            r4 = -34093383808(0xfffffff80fe03f80, double:NaN)
            long r0 = r0 ^ r4
            goto L_0x0027
        L_0x006f:
            int r3 = r2 + 1
            byte r2 = r4[r2]
            long r6 = (long) r2
            r2 = 42
            long r6 = r6 << r2
            long r0 = r0 ^ r6
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 < 0) goto L_0x0084
            r4 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            long r0 = r0 ^ r4
            r2 = r3
            goto L_0x0027
        L_0x0084:
            int r2 = r3 + 1
            byte r3 = r4[r3]
            long r6 = (long) r3
            r3 = 49
            long r6 = r6 << r3
            long r0 = r0 ^ r6
            int r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x0098
            r4 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            long r0 = r0 ^ r4
            goto L_0x0027
        L_0x0098:
            int r3 = r2 + 1
            byte r2 = r4[r2]
            long r6 = (long) r2
            r2 = 56
            long r6 = r6 << r2
            long r0 = r0 ^ r6
            r6 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r0 = r0 ^ r6
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x00ba
            int r2 = r3 + 1
            byte r3 = r4[r3]
            long r4 = (long) r3
            int r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x0027
        L_0x00b4:
            long r0 = r10.zzcuj()
            goto L_0x0013
        L_0x00ba:
            r2 = r3
            goto L_0x0027
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfeb.zzcun():long");
    }

    private final int zzcuo() throws IOException {
        int i = this.pos;
        if (this.zzpbq - i < 4) {
            zzkn(4);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzcup() throws IOException {
        int i = this.pos;
        if (this.zzpbq - i < 8) {
            zzkn(8);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private final void zzcuq() {
        this.zzpbq += this.zzpbl;
        int i = this.zzpbr + this.zzpbq;
        if (i > this.zzpbo) {
            this.zzpbl = i - this.zzpbo;
            this.zzpbq -= this.zzpbl;
            return;
        }
        this.zzpbl = 0;
    }

    private final byte zzcur() throws IOException {
        if (this.pos == this.zzpbq) {
            zzkn(1);
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    private final void zzkn(int i) throws IOException {
        if (zzko(i)) {
            return;
        }
        if (i > (this.zzpbh - this.zzpbr) - this.pos) {
            throw zzffe.zzcvz();
        }
        throw zzffe.zzcvs();
    }

    private final boolean zzko(int i) throws IOException {
        while (this.pos + i > this.zzpbq) {
            if (i > (this.zzpbh - this.zzpbr) - this.pos || this.zzpbr + this.pos + i > this.zzpbo) {
                return false;
            }
            int i2 = this.pos;
            if (i2 > 0) {
                if (this.zzpbq > i2) {
                    System.arraycopy(this.buffer, i2, this.buffer, 0, this.zzpbq - i2);
                }
                this.zzpbr += i2;
                this.zzpbq -= i2;
                this.pos = 0;
            }
            int read = this.zzpbp.read(this.buffer, this.zzpbq, Math.min(this.buffer.length - this.zzpbq, (this.zzpbh - this.zzpbr) - this.zzpbq));
            if (read == 0 || read < -1 || read > this.buffer.length) {
                throw new IllegalStateException(new StringBuilder(102).append("InputStream#read(byte[]) returned invalid result: ").append(read).append("\nThe InputStream implementation is buggy.").toString());
            } else if (read <= 0) {
                return false;
            } else {
                this.zzpbq = read + this.zzpbq;
                zzcuq();
                if (this.zzpbq >= i) {
                    return true;
                }
            }
        }
        throw new IllegalStateException(new StringBuilder(77).append("refillBuffer() called when ").append(i).append(" bytes were already available in buffer").toString());
    }

    private final byte[] zzkp(int i) throws IOException {
        byte[] zzkq = zzkq(i);
        if (zzkq != null) {
            return zzkq;
        }
        int i2 = this.pos;
        int i3 = this.zzpbq - this.pos;
        this.zzpbr += this.zzpbq;
        this.pos = 0;
        this.zzpbq = 0;
        List<byte[]> zzkr = zzkr(i - i3);
        byte[] bArr = new byte[i];
        System.arraycopy(this.buffer, i2, bArr, 0, i3);
        Iterator<byte[]> it = zzkr.iterator();
        while (true) {
            int i4 = i3;
            if (!it.hasNext()) {
                return bArr;
            }
            byte[] next = it.next();
            System.arraycopy(next, 0, bArr, i4, next.length);
            i3 = next.length + i4;
        }
    }

    private final byte[] zzkq(int i) throws IOException {
        if (i == 0) {
            return zzfez.EMPTY_BYTE_ARRAY;
        }
        if (i < 0) {
            throw zzffe.zzcvt();
        }
        int i2 = this.zzpbr + this.pos + i;
        if (i2 - this.zzpbh > 0) {
            throw zzffe.zzcvz();
        } else if (i2 > this.zzpbo) {
            zzkl((this.zzpbo - this.zzpbr) - this.pos);
            throw zzffe.zzcvs();
        } else {
            int i3 = this.zzpbq - this.pos;
            int i4 = i - i3;
            if (i4 >= 4096 && i4 > this.zzpbp.available()) {
                return null;
            }
            byte[] bArr = new byte[i];
            System.arraycopy(this.buffer, this.pos, bArr, 0, i3);
            this.zzpbr += this.zzpbq;
            this.pos = 0;
            this.zzpbq = 0;
            while (i3 < bArr.length) {
                int read = this.zzpbp.read(bArr, i3, i - i3);
                if (read == -1) {
                    throw zzffe.zzcvs();
                }
                this.zzpbr += read;
                i3 += read;
            }
            return bArr;
        }
    }

    private final List<byte[]> zzkr(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            byte[] bArr = new byte[Math.min(i, 4096)];
            int i2 = 0;
            while (i2 < bArr.length) {
                int read = this.zzpbp.read(bArr, i2, bArr.length - i2);
                if (read == -1) {
                    throw zzffe.zzcvs();
                }
                this.zzpbr += read;
                i2 += read;
            }
            i -= bArr.length;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzcup());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzcuo());
    }

    public final String readString() throws IOException {
        int zzcui = zzcui();
        if (zzcui > 0 && zzcui <= this.zzpbq - this.pos) {
            String str = new String(this.buffer, this.pos, zzcui, zzfez.UTF_8);
            this.pos = zzcui + this.pos;
            return str;
        } else if (zzcui == 0) {
            return "";
        } else {
            if (zzcui > this.zzpbq) {
                return new String(zzkp(zzcui), zzfez.UTF_8);
            }
            zzkn(zzcui);
            String str2 = new String(this.buffer, this.pos, zzcui, zzfez.UTF_8);
            this.pos = zzcui + this.pos;
            return str2;
        }
    }

    public final <T extends zzfem<T, ?>> T zza(T t, zzfei zzfei) throws IOException {
        int zzcui = zzcui();
        if (this.zzpbf >= this.zzpbg) {
            throw zzffe.zzcvy();
        }
        int zzkj = zzkj(zzcui);
        this.zzpbf++;
        T zza = zzfem.zza(t, (zzfdy) this, zzfei);
        zzkg(0);
        this.zzpbf--;
        zzkk(zzkj);
        return zza;
    }

    public final void zza(zzffr zzffr, zzfei zzfei) throws IOException {
        int zzcui = zzcui();
        if (this.zzpbf >= this.zzpbg) {
            throw zzffe.zzcvy();
        }
        int zzkj = zzkj(zzcui);
        this.zzpbf++;
        zzffr.zzb(this, zzfei);
        zzkg(0);
        this.zzpbf--;
        zzkk(zzkj);
    }

    public final int zzctt() throws IOException {
        if (zzcul()) {
            this.zzpbn = 0;
            return 0;
        }
        this.zzpbn = zzcui();
        if ((this.zzpbn >>> 3) != 0) {
            return this.zzpbn;
        }
        throw zzffe.zzcvv();
    }

    public final long zzctu() throws IOException {
        return zzcun();
    }

    public final long zzctv() throws IOException {
        return zzcun();
    }

    public final int zzctw() throws IOException {
        return zzcui();
    }

    public final long zzctx() throws IOException {
        return zzcup();
    }

    public final int zzcty() throws IOException {
        return zzcuo();
    }

    public final boolean zzctz() throws IOException {
        return zzcun() != 0;
    }

    public final String zzcua() throws IOException {
        byte[] zzkp;
        int zzcui = zzcui();
        int i = this.pos;
        if (zzcui <= this.zzpbq - i && zzcui > 0) {
            zzkp = this.buffer;
            this.pos = i + zzcui;
        } else if (zzcui == 0) {
            return "";
        } else {
            if (zzcui <= this.zzpbq) {
                zzkn(zzcui);
                byte[] bArr = this.buffer;
                this.pos = zzcui;
                zzkp = bArr;
                i = 0;
            } else {
                zzkp = zzkp(zzcui);
                i = 0;
            }
        }
        if (zzfgt.zzk(zzkp, i, i + zzcui)) {
            return new String(zzkp, i, zzcui, zzfez.UTF_8);
        }
        throw zzffe.zzcwa();
    }

    public final zzfdp zzcub() throws IOException {
        int zzcui = zzcui();
        if (zzcui <= this.zzpbq - this.pos && zzcui > 0) {
            zzfdp zze = zzfdp.zze(this.buffer, this.pos, zzcui);
            this.pos = zzcui + this.pos;
            return zze;
        } else if (zzcui == 0) {
            return zzfdp.zzpaz;
        } else {
            byte[] zzkq = zzkq(zzcui);
            if (zzkq != null) {
                return zzfdp.zzaz(zzkq);
            }
            int i = this.pos;
            int i2 = this.zzpbq - this.pos;
            this.zzpbr += this.zzpbq;
            this.pos = 0;
            this.zzpbq = 0;
            List<byte[]> zzkr = zzkr(zzcui - i2);
            ArrayList arrayList = new ArrayList(zzkr.size() + 1);
            arrayList.add(zzfdp.zze(this.buffer, i, i2));
            for (byte[] zzaz : zzkr) {
                arrayList.add(zzfdp.zzaz(zzaz));
            }
            return zzfdp.zzf(arrayList);
        }
    }

    public final int zzcuc() throws IOException {
        return zzcui();
    }

    public final int zzcud() throws IOException {
        return zzcui();
    }

    public final int zzcue() throws IOException {
        return zzcuo();
    }

    public final long zzcuf() throws IOException {
        return zzcup();
    }

    public final int zzcug() throws IOException {
        return zzkm(zzcui());
    }

    public final long zzcuh() throws IOException {
        return zzcr(zzcun());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006a, code lost:
        if (r3[r2] < 0) goto L_0x006c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzcui() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.zzpbq
            if (r1 == r0) goto L_0x006c
            byte[] r3 = r5.buffer
            int r2 = r0 + 1
            byte r0 = r3[r0]
            if (r0 < 0) goto L_0x0011
            r5.pos = r2
        L_0x0010:
            return r0
        L_0x0011:
            int r1 = r5.zzpbq
            int r1 = r1 - r2
            r4 = 9
            if (r1 < r4) goto L_0x006c
            int r1 = r2 + 1
            byte r2 = r3[r2]
            int r2 = r2 << 7
            r0 = r0 ^ r2
            if (r0 >= 0) goto L_0x0026
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
        L_0x0023:
            r5.pos = r1
            goto L_0x0010
        L_0x0026:
            int r2 = r1 + 1
            byte r1 = r3[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0033
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            r1 = r2
            goto L_0x0023
        L_0x0033:
            int r1 = r2 + 1
            byte r2 = r3[r2]
            int r2 = r2 << 21
            r0 = r0 ^ r2
            if (r0 >= 0) goto L_0x0041
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0023
        L_0x0041:
            int r2 = r1 + 1
            byte r1 = r3[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x0072
            int r1 = r2 + 1
            byte r2 = r3[r2]
            if (r2 >= 0) goto L_0x0023
            int r2 = r1 + 1
            byte r1 = r3[r1]
            if (r1 >= 0) goto L_0x0072
            int r1 = r2 + 1
            byte r2 = r3[r2]
            if (r2 >= 0) goto L_0x0023
            int r2 = r1 + 1
            byte r1 = r3[r1]
            if (r1 >= 0) goto L_0x0072
            int r1 = r2 + 1
            byte r2 = r3[r2]
            if (r2 >= 0) goto L_0x0023
        L_0x006c:
            long r0 = r5.zzcuj()
            int r0 = (int) r0
            goto L_0x0010
        L_0x0072:
            r1 = r2
            goto L_0x0023
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfeb.zzcui():int");
    }

    /* access modifiers changed from: package-private */
    public final long zzcuj() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzcur = zzcur();
            j |= ((long) (zzcur & Byte.MAX_VALUE)) << i;
            if ((zzcur & 128) == 0) {
                return j;
            }
        }
        throw zzffe.zzcvu();
    }

    public final int zzcuk() {
        if (this.zzpbo == Integer.MAX_VALUE) {
            return -1;
        }
        return this.zzpbo - (this.zzpbr + this.pos);
    }

    public final boolean zzcul() throws IOException {
        return this.pos == this.zzpbq && !zzko(1);
    }

    public final int zzcum() {
        return this.zzpbr + this.pos;
    }

    public final void zzkg(int i) throws zzffe {
        if (this.zzpbn != i) {
            throw zzffe.zzcvw();
        }
    }

    public final boolean zzkh(int i) throws IOException {
        int zzctt;
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.zzpbq - this.pos >= 10) {
                    while (i2 < 10) {
                        byte[] bArr = this.buffer;
                        int i3 = this.pos;
                        this.pos = i3 + 1;
                        if (bArr[i3] >= 0) {
                            return true;
                        }
                        i2++;
                    }
                    throw zzffe.zzcvu();
                }
                while (i2 < 10) {
                    if (zzcur() >= 0) {
                        return true;
                    }
                    i2++;
                }
                throw zzffe.zzcvu();
            case 1:
                zzkl(8);
                return true;
            case 2:
                zzkl(zzcui());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzkl(4);
                return true;
            default:
                throw zzffe.zzcvx();
        }
        do {
            zzctt = zzctt();
            if (zzctt == 0 || !zzkh(zzctt)) {
                zzkg(((i >>> 3) << 3) | 4);
                return true;
            }
            zzctt = zzctt();
            zzkg(((i >>> 3) << 3) | 4);
            return true;
        } while (!zzkh(zzctt));
        zzkg(((i >>> 3) << 3) | 4);
        return true;
    }

    public final int zzkj(int i) throws zzffe {
        if (i < 0) {
            throw zzffe.zzcvt();
        }
        int i2 = this.zzpbr + this.pos + i;
        int i3 = this.zzpbo;
        if (i2 > i3) {
            throw zzffe.zzcvs();
        }
        this.zzpbo = i2;
        zzcuq();
        return i3;
    }

    public final void zzkk(int i) {
        this.zzpbo = i;
        zzcuq();
    }

    public final void zzkl(int i) throws IOException {
        if (i <= this.zzpbq - this.pos && i >= 0) {
            this.pos += i;
        } else if (i < 0) {
            throw zzffe.zzcvt();
        } else if (this.zzpbr + this.pos + i > this.zzpbo) {
            zzkl((this.zzpbo - this.zzpbr) - this.pos);
            throw zzffe.zzcvs();
        } else {
            int i2 = this.zzpbq - this.pos;
            this.pos = this.zzpbq;
            zzkn(1);
            while (i - i2 > this.zzpbq) {
                i2 += this.zzpbq;
                this.pos = this.zzpbq;
                zzkn(1);
            }
            this.pos = i - i2;
        }
    }
}
