package com.google.android.gms.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzfed extends zzfdo {
    private static final Logger logger = Logger.getLogger(zzfed.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzpbt = zzfgr.zzcwx();

    static abstract class zza extends zzfed {
        final byte[] buffer;
        final int limit;
        int position;
        int zzpbu;

        zza(int i) {
            super();
            if (i < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            this.buffer = new byte[Math.max(i, 20)];
            this.limit = this.buffer.length;
        }

        /* access modifiers changed from: package-private */
        public final void zzah(int i, int i2) {
            zzlg((i << 3) | i2);
        }

        /* access modifiers changed from: package-private */
        public final void zzc(byte b) {
            byte[] bArr = this.buffer;
            int i = this.position;
            this.position = i + 1;
            bArr[i] = b;
            this.zzpbu++;
        }

        public final int zzcus() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        /* access modifiers changed from: package-private */
        public final void zzdb(long j) {
            if (zzfed.zzpbt) {
                long j2 = (long) this.position;
                while ((j & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    zzfgr.zza(bArr, (long) i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                zzfgr.zza(bArr2, (long) i2, (byte) ((int) j));
                this.zzpbu = ((int) (((long) this.position) - j2)) + this.zzpbu;
                return;
            }
            while ((j & -128) != 0) {
                byte[] bArr3 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                this.zzpbu++;
                j >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i4 = this.position;
            this.position = i4 + 1;
            bArr4[i4] = (byte) ((int) j);
            this.zzpbu++;
        }

        /* access modifiers changed from: package-private */
        public final void zzdc(long j) {
            byte[] bArr = this.buffer;
            int i = this.position;
            this.position = i + 1;
            bArr[i] = (byte) ((int) (j & 255));
            byte[] bArr2 = this.buffer;
            int i2 = this.position;
            this.position = i2 + 1;
            bArr2[i2] = (byte) ((int) ((j >> 8) & 255));
            byte[] bArr3 = this.buffer;
            int i3 = this.position;
            this.position = i3 + 1;
            bArr3[i3] = (byte) ((int) ((j >> 16) & 255));
            byte[] bArr4 = this.buffer;
            int i4 = this.position;
            this.position = i4 + 1;
            bArr4[i4] = (byte) ((int) ((j >> 24) & 255));
            byte[] bArr5 = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            bArr5[i5] = (byte) ((int) (j >> 32));
            byte[] bArr6 = this.buffer;
            int i6 = this.position;
            this.position = i6 + 1;
            bArr6[i6] = (byte) ((int) (j >> 40));
            byte[] bArr7 = this.buffer;
            int i7 = this.position;
            this.position = i7 + 1;
            bArr7[i7] = (byte) ((int) (j >> 48));
            byte[] bArr8 = this.buffer;
            int i8 = this.position;
            this.position = i8 + 1;
            bArr8[i8] = (byte) ((int) (j >> 56));
            this.zzpbu += 8;
        }

        /* access modifiers changed from: package-private */
        public final void zzlg(int i) {
            if (zzfed.zzpbt) {
                long j = (long) this.position;
                while ((i & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    zzfgr.zza(bArr, (long) i2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                zzfgr.zza(bArr2, (long) i3, (byte) i);
                this.zzpbu = ((int) (((long) this.position) - j)) + this.zzpbu;
                return;
            }
            while ((i & -128) != 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr3[i4] = (byte) ((i & 127) | 128);
                this.zzpbu++;
                i >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            bArr4[i5] = (byte) i;
            this.zzpbu++;
        }

        /* access modifiers changed from: package-private */
        public final void zzlh(int i) {
            byte[] bArr = this.buffer;
            int i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = (byte) i;
            byte[] bArr2 = this.buffer;
            int i3 = this.position;
            this.position = i3 + 1;
            bArr2[i3] = (byte) (i >> 8);
            byte[] bArr3 = this.buffer;
            int i4 = this.position;
            this.position = i4 + 1;
            bArr3[i4] = (byte) (i >> 16);
            byte[] bArr4 = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            bArr4[i5] = i >> 24;
            this.zzpbu += 4;
        }
    }

    static class zzb extends zzfed {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zzb(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            } else if ((i | i2 | (bArr.length - (i + i2))) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            } else {
                this.buffer = bArr;
                this.offset = i;
                this.position = i;
                this.limit = i + i2;
            }
        }

        public void flush() {
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)}), e);
            }
        }

        public final void zza(int i, long j) throws IOException {
            zzz(i, 0);
            zzcs(j);
        }

        public final void zza(int i, zzfdp zzfdp) throws IOException {
            zzz(i, 2);
            zzam(zzfdp);
        }

        public final void zza(int i, zzffq zzffq) throws IOException {
            zzz(i, 2);
            zzd(zzffq);
        }

        public final void zzaa(int i, int i2) throws IOException {
            zzz(i, 0);
            zzkt(i2);
        }

        public final void zzab(int i, int i2) throws IOException {
            zzz(i, 0);
            zzku(i2);
        }

        public final void zzac(int i, int i2) throws IOException {
            zzz(i, 5);
            zzkw(i2);
        }

        public final void zzam(zzfdp zzfdp) throws IOException {
            zzku(zzfdp.size());
            zzfdp.zza(this);
        }

        public final void zzb(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void zzb(int i, long j) throws IOException {
            zzz(i, 1);
            zzcu(j);
        }

        public final void zzcs(long j) throws IOException {
            if (!zzfed.zzpbt || zzcus() < 10) {
                while ((j & -128) != 0) {
                    try {
                        byte[] bArr = this.buffer;
                        int i = this.position;
                        this.position = i + 1;
                        bArr[i] = (byte) ((((int) j) & 127) | 128);
                        j >>>= 7;
                    } catch (IndexOutOfBoundsException e) {
                        throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
                    }
                }
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr2[i2] = (byte) ((int) j);
                return;
            }
            while ((j & -128) != 0) {
                byte[] bArr3 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                zzfgr.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i4 = this.position;
            this.position = i4 + 1;
            zzfgr.zza(bArr4, (long) i4, (byte) ((int) j));
        }

        public final void zzcu(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final int zzcus() {
            return this.limit - this.position;
        }

        public final void zzd(zzffq zzffq) throws IOException {
            zzku(zzffq.zzhl());
            zzffq.zza(this);
        }

        public final void zzd(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzi(byte[] bArr, int i, int i2) throws IOException {
            zzku(i2);
            write(bArr, 0, i2);
        }

        public final void zzkt(int i) throws IOException {
            if (i >= 0) {
                zzku(i);
            } else {
                zzcs((long) i);
            }
        }

        public final void zzku(int i) throws IOException {
            if (!zzfed.zzpbt || zzcus() < 10) {
                while ((i & -128) != 0) {
                    try {
                        byte[] bArr = this.buffer;
                        int i2 = this.position;
                        this.position = i2 + 1;
                        bArr[i2] = (byte) ((i & 127) | 128);
                        i >>>= 7;
                    } catch (IndexOutOfBoundsException e) {
                        throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
                    }
                }
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) i;
                return;
            }
            while ((i & -128) != 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzfgr.zza(bArr3, (long) i4, (byte) ((i & 127) | 128));
                i >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            zzfgr.zza(bArr4, (long) i5, (byte) i);
        }

        public final void zzkw(int i) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr4[i5] = i >> 24;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void zzl(int i, boolean z) throws IOException {
            int i2 = 0;
            zzz(i, 0);
            if (z) {
                i2 = 1;
            }
            zzb((byte) i2);
        }

        public final void zzn(int i, String str) throws IOException {
            zzz(i, 2);
            zztd(str);
        }

        public final void zztd(String str) throws IOException {
            int i = this.position;
            try {
                int zzkz = zzkz(str.length() * 3);
                int zzkz2 = zzkz(str.length());
                if (zzkz2 == zzkz) {
                    this.position = i + zzkz2;
                    int zza = zzfgt.zza(str, this.buffer, this.position, zzcus());
                    this.position = i;
                    zzku((zza - i) - zzkz2);
                    this.position = zza;
                    return;
                }
                zzku(zzfgt.zzd(str));
                this.position = zzfgt.zza(str, this.buffer, this.position, zzcus());
            } catch (zzfgw e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            }
        }

        public final void zzz(int i, int i2) throws IOException {
            zzku((i << 3) | i2);
        }
    }

    public static class zzc extends IOException {
        zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        zzc(java.lang.String r4, java.lang.Throwable r5) {
            /*
                r3 = this;
                java.lang.String r0 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                java.lang.String r1 = java.lang.String.valueOf(r0)
                java.lang.String r0 = java.lang.String.valueOf(r4)
                int r2 = r0.length()
                if (r2 == 0) goto L_0x0018
                java.lang.String r0 = r1.concat(r0)
            L_0x0014:
                r3.<init>(r0, r5)
                return
            L_0x0018:
                java.lang.String r0 = new java.lang.String
                r0.<init>(r1)
                goto L_0x0014
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfed.zzc.<init>(java.lang.String, java.lang.Throwable):void");
        }

        zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    static final class zzd extends zza {
        private final OutputStream out;

        zzd(OutputStream outputStream, int i) {
            super(i);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.out = outputStream;
        }

        private final void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private final void zzli(int i) throws IOException {
            if (this.limit - this.position < i) {
                doFlush();
            }
        }

        public final void flush() throws IOException {
            if (this.position > 0) {
                doFlush();
            }
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.limit - this.position >= i2) {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } else {
                int i3 = this.limit - this.position;
                System.arraycopy(bArr, i, this.buffer, this.position, i3);
                int i4 = i + i3;
                i2 -= i3;
                this.position = this.limit;
                this.zzpbu = i3 + this.zzpbu;
                doFlush();
                if (i2 <= this.limit) {
                    System.arraycopy(bArr, i4, this.buffer, 0, i2);
                    this.position = i2;
                } else {
                    this.out.write(bArr, i4, i2);
                }
            }
            this.zzpbu += i2;
        }

        public final void zza(int i, long j) throws IOException {
            zzli(20);
            zzah(i, 0);
            zzdb(j);
        }

        public final void zza(int i, zzfdp zzfdp) throws IOException {
            zzz(i, 2);
            zzam(zzfdp);
        }

        public final void zza(int i, zzffq zzffq) throws IOException {
            zzz(i, 2);
            zzd(zzffq);
        }

        public final void zzaa(int i, int i2) throws IOException {
            zzli(20);
            zzah(i, 0);
            if (i2 >= 0) {
                zzlg(i2);
            } else {
                zzdb((long) i2);
            }
        }

        public final void zzab(int i, int i2) throws IOException {
            zzli(20);
            zzah(i, 0);
            zzlg(i2);
        }

        public final void zzac(int i, int i2) throws IOException {
            zzli(14);
            zzah(i, 5);
            zzlh(i2);
        }

        public final void zzam(zzfdp zzfdp) throws IOException {
            zzku(zzfdp.size());
            zzfdp.zza(this);
        }

        public final void zzb(byte b) throws IOException {
            if (this.position == this.limit) {
                doFlush();
            }
            zzc(b);
        }

        public final void zzb(int i, long j) throws IOException {
            zzli(18);
            zzah(i, 1);
            zzdc(j);
        }

        public final void zzcs(long j) throws IOException {
            zzli(10);
            zzdb(j);
        }

        public final void zzcu(long j) throws IOException {
            zzli(8);
            zzdc(j);
        }

        public final void zzd(zzffq zzffq) throws IOException {
            zzku(zzffq.zzhl());
            zzffq.zza(this);
        }

        public final void zzd(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzi(byte[] bArr, int i, int i2) throws IOException {
            zzku(i2);
            write(bArr, 0, i2);
        }

        public final void zzkt(int i) throws IOException {
            if (i >= 0) {
                zzku(i);
            } else {
                zzcs((long) i);
            }
        }

        public final void zzku(int i) throws IOException {
            zzli(10);
            zzlg(i);
        }

        public final void zzkw(int i) throws IOException {
            zzli(4);
            zzlh(i);
        }

        public final void zzl(int i, boolean z) throws IOException {
            int i2 = 0;
            zzli(11);
            zzah(i, 0);
            if (z) {
                i2 = 1;
            }
            zzc((byte) i2);
        }

        public final void zzn(int i, String str) throws IOException {
            zzz(i, 2);
            zztd(str);
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void zztd(java.lang.String r7) throws java.io.IOException {
            /*
                r6 = this;
                int r0 = r7.length()     // Catch:{ zzfgw -> 0x0064 }
                int r0 = r0 * 3
                int r1 = zzkz(r0)     // Catch:{ zzfgw -> 0x0064 }
                int r2 = r1 + r0
                int r3 = r6.limit     // Catch:{ zzfgw -> 0x0064 }
                if (r2 <= r3) goto L_0x001f
                byte[] r1 = new byte[r0]     // Catch:{ zzfgw -> 0x0064 }
                r2 = 0
                int r0 = com.google.android.gms.internal.zzfgt.zza(r7, r1, r2, r0)     // Catch:{ zzfgw -> 0x0064 }
                r6.zzku(r0)     // Catch:{ zzfgw -> 0x0064 }
                r2 = 0
                r6.zzd(r1, r2, r0)     // Catch:{ zzfgw -> 0x0064 }
            L_0x001e:
                return
            L_0x001f:
                int r0 = r0 + r1
                int r2 = r6.limit     // Catch:{ zzfgw -> 0x0064 }
                int r3 = r6.position     // Catch:{ zzfgw -> 0x0064 }
                int r2 = r2 - r3
                if (r0 <= r2) goto L_0x002a
                r6.doFlush()     // Catch:{ zzfgw -> 0x0064 }
            L_0x002a:
                int r0 = r7.length()     // Catch:{ zzfgw -> 0x0064 }
                int r0 = zzkz(r0)     // Catch:{ zzfgw -> 0x0064 }
                int r2 = r6.position     // Catch:{ zzfgw -> 0x0064 }
                if (r0 != r1) goto L_0x0069
                int r1 = r2 + r0
                r6.position = r1     // Catch:{ zzfgw -> 0x0058, ArrayIndexOutOfBoundsException -> 0x007b }
                byte[] r1 = r6.buffer     // Catch:{ zzfgw -> 0x0058, ArrayIndexOutOfBoundsException -> 0x007b }
                int r3 = r6.position     // Catch:{ zzfgw -> 0x0058, ArrayIndexOutOfBoundsException -> 0x007b }
                int r4 = r6.limit     // Catch:{ zzfgw -> 0x0058, ArrayIndexOutOfBoundsException -> 0x007b }
                int r5 = r6.position     // Catch:{ zzfgw -> 0x0058, ArrayIndexOutOfBoundsException -> 0x007b }
                int r4 = r4 - r5
                int r1 = com.google.android.gms.internal.zzfgt.zza(r7, r1, r3, r4)     // Catch:{ zzfgw -> 0x0058, ArrayIndexOutOfBoundsException -> 0x007b }
                r6.position = r2     // Catch:{ zzfgw -> 0x0058, ArrayIndexOutOfBoundsException -> 0x007b }
                int r3 = r1 - r2
                int r0 = r3 - r0
                r6.zzlg(r0)     // Catch:{ zzfgw -> 0x0058, ArrayIndexOutOfBoundsException -> 0x007b }
                r6.position = r1     // Catch:{ zzfgw -> 0x0058, ArrayIndexOutOfBoundsException -> 0x007b }
            L_0x0052:
                int r1 = r6.zzpbu     // Catch:{ zzfgw -> 0x0058, ArrayIndexOutOfBoundsException -> 0x007b }
                int r0 = r0 + r1
                r6.zzpbu = r0     // Catch:{ zzfgw -> 0x0058, ArrayIndexOutOfBoundsException -> 0x007b }
                goto L_0x001e
            L_0x0058:
                r0 = move-exception
                int r1 = r6.zzpbu     // Catch:{ zzfgw -> 0x0064 }
                int r3 = r6.position     // Catch:{ zzfgw -> 0x0064 }
                int r3 = r3 - r2
                int r1 = r1 - r3
                r6.zzpbu = r1     // Catch:{ zzfgw -> 0x0064 }
                r6.position = r2     // Catch:{ zzfgw -> 0x0064 }
                throw r0     // Catch:{ zzfgw -> 0x0064 }
            L_0x0064:
                r0 = move-exception
                r6.zza((java.lang.String) r7, (com.google.android.gms.internal.zzfgw) r0)
                goto L_0x001e
            L_0x0069:
                int r0 = com.google.android.gms.internal.zzfgt.zzd(r7)     // Catch:{ zzfgw -> 0x0058, ArrayIndexOutOfBoundsException -> 0x007b }
                r6.zzlg(r0)     // Catch:{ zzfgw -> 0x0058, ArrayIndexOutOfBoundsException -> 0x007b }
                byte[] r1 = r6.buffer     // Catch:{ zzfgw -> 0x0058, ArrayIndexOutOfBoundsException -> 0x007b }
                int r3 = r6.position     // Catch:{ zzfgw -> 0x0058, ArrayIndexOutOfBoundsException -> 0x007b }
                int r1 = com.google.android.gms.internal.zzfgt.zza(r7, r1, r3, r0)     // Catch:{ zzfgw -> 0x0058, ArrayIndexOutOfBoundsException -> 0x007b }
                r6.position = r1     // Catch:{ zzfgw -> 0x0058, ArrayIndexOutOfBoundsException -> 0x007b }
                goto L_0x0052
            L_0x007b:
                r0 = move-exception
                com.google.android.gms.internal.zzfed$zzc r1 = new com.google.android.gms.internal.zzfed$zzc     // Catch:{ zzfgw -> 0x0064 }
                r1.<init>(r0)     // Catch:{ zzfgw -> 0x0064 }
                throw r1     // Catch:{ zzfgw -> 0x0064 }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfed.zzd.zztd(java.lang.String):void");
        }

        public final void zzz(int i, int i2) throws IOException {
            zzku((i << 3) | i2);
        }
    }

    private zzfed() {
    }

    public static int zza(zzffk zzffk) {
        int zzhl = zzffk.zzhl();
        return zzhl + zzkz(zzhl);
    }

    public static int zzad(int i, int i2) {
        return zzkx(i) + zzky(i2);
    }

    public static int zzae(int i, int i2) {
        return zzkx(i) + zzkz(i2);
    }

    public static int zzaf(int i, int i2) {
        return zzkx(i) + 4;
    }

    public static int zzag(int i, int i2) {
        return zzkx(i) + zzky(i2);
    }

    public static int zzan(zzfdp zzfdp) {
        int size = zzfdp.size();
        return size + zzkz(size);
    }

    public static int zzb(int i, double d) {
        return zzkx(i) + 8;
    }

    public static int zzb(int i, zzfdp zzfdp) {
        int zzkx = zzkx(i);
        int size = zzfdp.size();
        return zzkx + size + zzkz(size);
    }

    public static int zzb(int i, zzffq zzffq) {
        return zzkx(i) + zze(zzffq);
    }

    public static zzfed zzb(OutputStream outputStream, int i) {
        return new zzd(outputStream, i);
    }

    public static zzfed zzbb(byte[] bArr) {
        return zzh(bArr, 0, bArr.length);
    }

    public static int zzbc(byte[] bArr) {
        int length = bArr.length;
        return length + zzkz(length);
    }

    public static int zzc(int i, long j) {
        return zzkx(i) + zzcw(j);
    }

    public static int zzcv(long j) {
        return zzcw(j);
    }

    public static int zzcw(long j) {
        long j2;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        int i = 2;
        if ((-34359738368L & j) != 0) {
            i = 6;
            j2 = j >>> 28;
        } else {
            j2 = j;
        }
        if ((-2097152 & j2) != 0) {
            i += 2;
            j2 >>>= 14;
        }
        return (j2 & -16384) != 0 ? i + 1 : i;
    }

    public static int zzcx(long j) {
        return zzcw(zzda(j));
    }

    public static int zzcy(long j) {
        return 8;
    }

    public static int zzcz(long j) {
        return 8;
    }

    public static int zzd(int i, long j) {
        return zzkx(i) + zzcw(j);
    }

    public static int zzda(boolean z) {
        return 1;
    }

    private static long zzda(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int zze(int i, long j) {
        return zzkx(i) + 8;
    }

    public static int zze(zzffq zzffq) {
        int zzhl = zzffq.zzhl();
        return zzhl + zzkz(zzhl);
    }

    public static int zzf(float f) {
        return 4;
    }

    @Deprecated
    public static int zzf(zzffq zzffq) {
        return zzffq.zzhl();
    }

    public static zzfed zzh(byte[] bArr, int i, int i2) {
        return new zzb(bArr, i, i2);
    }

    static int zzks(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int zzkx(int i) {
        return zzkz(i << 3);
    }

    public static int zzky(int i) {
        if (i >= 0) {
            return zzkz(i);
        }
        return 10;
    }

    public static int zzkz(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int zzla(int i) {
        return zzkz(zzlf(i));
    }

    public static int zzlb(int i) {
        return 4;
    }

    public static int zzlc(int i) {
        return 4;
    }

    public static int zzld(int i) {
        return zzky(i);
    }

    static int zzle(int i) {
        return zzkz(i) + i;
    }

    private static int zzlf(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public static int zzm(int i, boolean z) {
        return zzkx(i) + 1;
    }

    public static int zzn(double d) {
        return 8;
    }

    public static int zzo(int i, String str) {
        return zzkx(i) + zzte(str);
    }

    public static int zzte(String str) {
        int length;
        try {
            length = zzfgt.zzd(str);
        } catch (zzfgw e) {
            length = str.getBytes(zzfez.UTF_8).length;
        }
        return length + zzkz(length);
    }

    public abstract void flush() throws IOException;

    public abstract void write(byte[] bArr, int i, int i2) throws IOException;

    public final void zza(int i, double d) throws IOException {
        zzb(i, Double.doubleToRawLongBits(d));
    }

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzfdp zzfdp) throws IOException;

    public abstract void zza(int i, zzffq zzffq) throws IOException;

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzfgw zzfgw) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzfgw);
        byte[] bytes = str.getBytes(zzfez.UTF_8);
        try {
            zzku(bytes.length);
            zzd(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzc(e);
        } catch (zzc e2) {
            throw e2;
        }
    }

    public abstract void zzaa(int i, int i2) throws IOException;

    public abstract void zzab(int i, int i2) throws IOException;

    public abstract void zzac(int i, int i2) throws IOException;

    public abstract void zzam(zzfdp zzfdp) throws IOException;

    public abstract void zzb(byte b) throws IOException;

    public abstract void zzb(int i, long j) throws IOException;

    public abstract void zzcs(long j) throws IOException;

    public final void zzct(long j) throws IOException {
        zzcs(zzda(j));
    }

    public abstract void zzcu(long j) throws IOException;

    public abstract int zzcus();

    public final void zzcut() {
        if (zzcus() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void zzd(zzffq zzffq) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzi(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzkt(int i) throws IOException;

    public abstract void zzku(int i) throws IOException;

    public final void zzkv(int i) throws IOException {
        zzku(zzlf(i));
    }

    public abstract void zzkw(int i) throws IOException;

    public abstract void zzl(int i, boolean z) throws IOException;

    public abstract void zzn(int i, String str) throws IOException;

    public abstract void zztd(String str) throws IOException;

    public abstract void zzz(int i, int i2) throws IOException;
}
