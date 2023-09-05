package com.google.android.gms.internal;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import org.mozilla.universalchardet.prober.HebrewProber;

public final class zzfhk {
    private final ByteBuffer zzphl;

    private zzfhk(ByteBuffer byteBuffer) {
        this.zzphl = byteBuffer;
        this.zzphl.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzfhk(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        int length = charSequence.length();
        int i4 = 0;
        int i5 = i + i2;
        while (i4 < length && i4 + i < i5) {
            char charAt = charSequence.charAt(i4);
            if (charAt >= 128) {
                break;
            }
            bArr[i + i4] = (byte) charAt;
            i4++;
        }
        if (i4 == length) {
            return i + length;
        }
        int i6 = i + i4;
        while (i4 < length) {
            char charAt2 = charSequence.charAt(i4);
            if (charAt2 < 128 && i6 < i5) {
                i3 = i6 + 1;
                bArr[i6] = (byte) charAt2;
            } else if (charAt2 < 2048 && i6 <= i5 - 2) {
                int i7 = i6 + 1;
                bArr[i6] = (byte) ((charAt2 >>> 6) | 960);
                i3 = i7 + 1;
                bArr[i7] = (byte) ((charAt2 & '?') | 128);
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i6 <= i5 - 3) {
                int i8 = i6 + 1;
                bArr[i6] = (byte) ((charAt2 >>> 12) | 480);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i3 = i9 + 1;
                bArr[i9] = (byte) ((charAt2 & '?') | 128);
            } else if (i6 <= i5 - 4) {
                if (i4 + 1 != charSequence.length()) {
                    i4++;
                    char charAt3 = charSequence.charAt(i4);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        int i10 = i6 + 1;
                        bArr[i6] = (byte) ((codePoint >>> 18) | HebrewProber.NORMAL_NUN);
                        int i11 = i10 + 1;
                        bArr[i10] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i12 = i11 + 1;
                        bArr[i11] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i3 = i12 + 1;
                        bArr[i12] = (byte) ((codePoint & 63) | 128);
                    }
                }
                throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i4 - 1).toString());
            } else {
                throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(charAt2).append(" at index ").append(i6).toString());
            }
            i4++;
            i6 = i3;
        }
        return i6;
    }

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(zza(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (ArrayIndexOutOfBoundsException e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            zzb(charSequence, byteBuffer);
        }
    }

    public static int zzad(int i, int i2) {
        return zzkx(i) + zzky(i2);
    }

    public static int zzb(int i, zzfhs zzfhs) {
        int zzkx = zzkx(i);
        int zzhl = zzfhs.zzhl();
        return zzkx + zzhl + zzlz(zzhl);
    }

    private static void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 128) {
                byteBuffer.put((byte) charAt);
            } else if (charAt < 2048) {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & '?') | 128));
            } else if (charAt < 55296 || 57343 < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt & '?') | 128));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int codePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((codePoint >>> 18) | HebrewProber.NORMAL_NUN));
                        byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((codePoint & 63) | 128));
                    }
                }
                throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i - 1).toString());
            }
            i++;
        }
    }

    public static zzfhk zzbe(byte[] bArr) {
        return zzo(bArr, 0, bArr.length);
    }

    public static int zzbf(byte[] bArr) {
        return zzlz(bArr.length) + bArr.length;
    }

    public static int zzc(int i, long j) {
        return zzkx(i) + zzdh(j);
    }

    public static int zzd(int i, byte[] bArr) {
        return zzkx(i) + zzbf(bArr);
    }

    private static int zzd(CharSequence charSequence) {
        int i;
        int i2 = 0;
        int length = charSequence.length();
        int i3 = 0;
        while (i3 < length && charSequence.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (true) {
            if (i3 >= length) {
                i = i4;
                break;
            }
            char charAt = charSequence.charAt(i3);
            if (charAt < 2048) {
                i4 += (127 - charAt) >>> 31;
                i3++;
            } else {
                int length2 = charSequence.length();
                while (i3 < length2) {
                    char charAt2 = charSequence.charAt(i3);
                    if (charAt2 < 2048) {
                        i2 += (127 - charAt2) >>> 31;
                    } else {
                        i2 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i3) < 65536) {
                                throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i3).toString());
                            }
                            i3++;
                        }
                    }
                    i3++;
                }
                i = i4 + i2;
            }
        }
        if (i >= length) {
            return i;
        }
        throw new IllegalArgumentException(new StringBuilder(54).append("UTF-8 length does not fit in int: ").append(((long) i) + 4294967296L).toString());
    }

    private static long zzda(long j) {
        return (j << 1) ^ (j >> 63);
    }

    private final void zzdg(long j) throws IOException {
        while ((-128 & j) != 0) {
            zzlx((((int) j) & 127) | 128);
            j >>>= 7;
        }
        zzlx((int) j);
    }

    public static int zzdh(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    private final void zzdi(long j) throws IOException {
        if (this.zzphl.remaining() < 8) {
            throw new zzfhl(this.zzphl.position(), this.zzphl.limit());
        }
        this.zzphl.putLong(j);
    }

    public static int zzh(int i, long j) {
        return zzkx(i) + zzdh(zzda(j));
    }

    public static int zzkx(int i) {
        return zzlz(i << 3);
    }

    public static int zzky(int i) {
        if (i >= 0) {
            return zzlz(i);
        }
        return 10;
    }

    public static int zzlf(int i) {
        return (i << 1) ^ (i >> 31);
    }

    private final void zzlx(int i) throws IOException {
        byte b = (byte) i;
        if (!this.zzphl.hasRemaining()) {
            throw new zzfhl(this.zzphl.position(), this.zzphl.limit());
        }
        this.zzphl.put(b);
    }

    public static int zzlz(int i) {
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

    public static int zzo(int i, String str) {
        return zzkx(i) + zzte(str);
    }

    public static zzfhk zzo(byte[] bArr, int i, int i2) {
        return new zzfhk(bArr, 0, i2);
    }

    public static int zzte(String str) {
        int zzd = zzd(str);
        return zzd + zzlz(zzd);
    }

    public final void zza(int i, double d) throws IOException {
        zzz(i, 1);
        zzdi(Double.doubleToLongBits(d));
    }

    public final void zza(int i, long j) throws IOException {
        zzz(i, 0);
        zzdg(j);
    }

    public final void zza(int i, zzfhs zzfhs) throws IOException {
        zzz(i, 2);
        zzb(zzfhs);
    }

    public final void zzaa(int i, int i2) throws IOException {
        zzz(i, 0);
        if (i2 >= 0) {
            zzly(i2);
        } else {
            zzdg((long) i2);
        }
    }

    public final void zzb(int i, long j) throws IOException {
        zzz(i, 1);
        zzdi(j);
    }

    public final void zzb(zzfhs zzfhs) throws IOException {
        zzly(zzfhs.zzcxm());
        zzfhs.zza(this);
    }

    public final void zzbg(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.zzphl.remaining() >= length) {
            this.zzphl.put(bArr, 0, length);
            return;
        }
        throw new zzfhl(this.zzphl.position(), this.zzphl.limit());
    }

    public final void zzc(int i, float f) throws IOException {
        zzz(i, 5);
        int floatToIntBits = Float.floatToIntBits(f);
        if (this.zzphl.remaining() < 4) {
            throw new zzfhl(this.zzphl.position(), this.zzphl.limit());
        }
        this.zzphl.putInt(floatToIntBits);
    }

    public final void zzc(int i, byte[] bArr) throws IOException {
        zzz(i, 2);
        zzly(bArr.length);
        zzbg(bArr);
    }

    public final void zzcut() {
        if (this.zzphl.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[]{Integer.valueOf(this.zzphl.remaining())}));
        }
    }

    public final void zzf(int i, long j) throws IOException {
        zzz(i, 0);
        zzdg(j);
    }

    public final void zzg(int i, long j) throws IOException {
        zzz(i, 0);
        zzdg(zzda(j));
    }

    public final void zzl(int i, boolean z) throws IOException {
        int i2 = 0;
        zzz(i, 0);
        if (z) {
            i2 = 1;
        }
        byte b = (byte) i2;
        if (!this.zzphl.hasRemaining()) {
            throw new zzfhl(this.zzphl.position(), this.zzphl.limit());
        }
        this.zzphl.put(b);
    }

    public final void zzly(int i) throws IOException {
        while ((i & -128) != 0) {
            zzlx((i & 127) | 128);
            i >>>= 7;
        }
        zzlx(i);
    }

    public final void zzn(int i, String str) throws IOException {
        zzz(i, 2);
        try {
            int zzlz = zzlz(str.length());
            if (zzlz == zzlz(str.length() * 3)) {
                int position = this.zzphl.position();
                if (this.zzphl.remaining() < zzlz) {
                    throw new zzfhl(zzlz + position, this.zzphl.limit());
                }
                this.zzphl.position(position + zzlz);
                zza((CharSequence) str, this.zzphl);
                int position2 = this.zzphl.position();
                this.zzphl.position(position);
                zzly((position2 - position) - zzlz);
                this.zzphl.position(position2);
                return;
            }
            zzly(zzd(str));
            zza((CharSequence) str, this.zzphl);
        } catch (BufferOverflowException e) {
            zzfhl zzfhl = new zzfhl(this.zzphl.position(), this.zzphl.limit());
            zzfhl.initCause(e);
            throw zzfhl;
        }
    }

    public final void zzz(int i, int i2) throws IOException {
        zzly((i << 3) | i2);
    }
}
