package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public abstract class zzdsf implements zzdoo {
    private final zzdsa zzlus;

    private zzdsf(zzdsa zzdsa) {
        this.zzlus = zzdsa;
    }

    private static void zza(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) ((int) (255 & j));
            i2++;
            j >>= 8;
        }
    }

    private final byte[] zza(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) {
        byte[] zza = zza(bArr, byteBuffer);
        if (bArr2.length < 32) {
            throw new IllegalArgumentException("The key length in bytes must be 32.");
        }
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long zzc = zzc(bArr2, 0, 0) & 67108863;
        long zzc2 = zzc(bArr2, 3, 2) & 67108611;
        long zzc3 = zzc(bArr2, 6, 4) & 67092735;
        long zzc4 = zzc(bArr2, 9, 6) & 66076671;
        long zzc5 = zzc(bArr2, 12, 8) & 1048575;
        long j6 = 5 * zzc2;
        long j7 = 5 * zzc3;
        long j8 = 5 * zzc4;
        long j9 = 5 * zzc5;
        byte[] bArr3 = new byte[17];
        for (int i = 0; i < zza.length; i += 16) {
            int min = Math.min(16, zza.length - i);
            System.arraycopy(zza, i, bArr3, 0, min);
            bArr3[min] = 1;
            if (min != 16) {
                Arrays.fill(bArr3, min + 1, 17, (byte) 0);
            }
            long zzc6 = j + zzc(bArr3, 0, 0);
            long zzc7 = j2 + zzc(bArr3, 3, 2);
            long zzc8 = j3 + zzc(bArr3, 6, 4);
            long zzc9 = j4 + zzc(bArr3, 9, 6);
            long zzc10 = j5 + (zzc(bArr3, 12, 8) | ((long) (bArr3[16] << 24)));
            long j10 = (zzc6 * zzc) + (zzc7 * j9) + (zzc8 * j8) + (zzc9 * j7) + (zzc10 * j6);
            long j11 = (zzc6 * zzc2) + (zzc7 * zzc) + (zzc8 * j9) + (zzc9 * j8) + (zzc10 * j7);
            long j12 = (zzc6 * zzc3) + (zzc7 * zzc2) + (zzc8 * zzc) + (zzc9 * j9) + (zzc10 * j8);
            long j13 = zzc8 * zzc3;
            long j14 = zzc9 * zzc2;
            long j15 = zzc10 * zzc;
            long j16 = j15 + j14 + j13 + (zzc7 * zzc4) + (zzc6 * zzc5);
            long j17 = j10 & 67108863;
            long j18 = (j10 >> 26) + j11;
            long j19 = j18 & 67108863;
            long j20 = j12 + (j18 >> 26);
            j3 = 67108863 & j20;
            long j21 = (zzc6 * zzc4) + (zzc7 * zzc3) + (zzc8 * zzc2) + (zzc9 * zzc) + (zzc10 * j9) + (j20 >> 26);
            long j22 = j21 >> 26;
            j4 = j21 & 67108863;
            long j23 = j16 + j22;
            long j24 = j23 >> 26;
            j5 = j23 & 67108863;
            long j25 = j17 + (j24 * 5);
            j = 67108863 & j25;
            j2 = j19 + (j25 >> 26);
        }
        long j26 = (j2 >> 26) + j3;
        long j27 = j26 >> 26;
        long j28 = j26 & 67108863;
        long j29 = j4 + j27;
        long j30 = j29 >> 26;
        long j31 = j29 & 67108863;
        long j32 = j5 + j30;
        long j33 = j32 >> 26;
        long j34 = j32 & 67108863;
        long j35 = (j33 * 5) + j;
        long j36 = j35 >> 26;
        long j37 = j35 & 67108863;
        long j38 = (j2 & 67108863) + j36;
        long j39 = 5 + j37;
        long j40 = (j39 >> 26) + j38;
        long j41 = (j40 >> 26) + j28;
        long j42 = (j41 >> 26) + j31;
        long j43 = ((j42 >> 26) + j34) - 67108864;
        long j44 = j43 >> 63;
        long j45 = j37 & j44;
        long j46 = j38 & j44;
        long j47 = j28 & j44;
        long j48 = j31 & j44;
        long j49 = j34 & j44;
        long j50 = j44 ^ -1;
        long j51 = j46 | (j40 & 67108863 & j50);
        long j52 = j47 | (j41 & 67108863 & j50);
        long j53 = j48 | (j42 & 67108863 & j50);
        long j54 = (j49 | (j43 & j50)) << 8;
        long zze = zze(bArr2, 16);
        long j55 = zze + ((j45 | (j39 & 67108863 & j50) | (j51 << 26)) & 4294967295L);
        long j56 = 4294967295L & j55;
        long zze2 = (j55 >> 32) + (((j51 >> 6) | (j52 << 20)) & 4294967295L) + zze(bArr2, 20);
        long j57 = 4294967295L & zze2;
        long zze3 = (((j52 >> 12) | (j53 << 14)) & 4294967295L) + zze(bArr2, 24) + (zze2 >> 32);
        long j58 = 4294967295L & zze3;
        byte[] bArr4 = new byte[16];
        zza(bArr4, j56, 0);
        zza(bArr4, j57, 4);
        zza(bArr4, j58, 8);
        zza(bArr4, ((zze3 >> 32) + ((j54 | (j53 >> 18)) & 4294967295L) + zze(bArr2, 28)) & 4294967295L, 12);
        return bArr4;
    }

    public static zzdsf zzaj(byte[] bArr) {
        return new zzdsh(zzdsa.zzah(bArr));
    }

    private static long zzc(byte[] bArr, int i, int i2) {
        return (zze(bArr, i) >> i2) & 67108863;
    }

    private static long zze(byte[] bArr, int i) {
        return ((long) ((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24))) & 4294967295L;
    }

    /* access modifiers changed from: private */
    public static int zzga(int i) {
        return (((i + 16) - 1) / 16) << 4;
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] zza(byte[] bArr, ByteBuffer byteBuffer);

    public final byte[] zzd(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ByteBuffer allocate = ByteBuffer.allocate(this.zzlus.zzbos() + bArr.length + 16);
        if (allocate.remaining() < bArr.length + this.zzlus.zzbos() + 16) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        int position = allocate.position();
        this.zzlus.zza(allocate, bArr);
        allocate.position(position);
        byte[] bArr3 = new byte[this.zzlus.zzbos()];
        allocate.get(bArr3);
        byte[] zzfz = new zzdse(this.zzlus, bArr3, 0).zzfz(32);
        allocate.limit(allocate.limit() - 16);
        byte[] zza = zza(allocate, bArr2, zzfz);
        allocate.limit(allocate.limit() + 16);
        allocate.put(zza);
        return allocate.array();
    }
}
