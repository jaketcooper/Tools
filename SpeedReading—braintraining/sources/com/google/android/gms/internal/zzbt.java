package com.google.android.gms.internal;

import android.support.p000v4.media.session.PlaybackStateCompat;
import com.google.android.gms.ads.internal.zzbs;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class zzbt {
    private static boolean zzyp = false;
    /* access modifiers changed from: private */
    public static MessageDigest zzyq = null;
    private static final Object zzyr = new Object();
    private static final Object zzys = new Object();
    static CountDownLatch zzyt = new CountDownLatch(1);

    static String zza(zzaw zzaw, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] zza;
        byte[] zzc = zzfhs.zzc(zzaw);
        if (((Boolean) zzbs.zzep().zzd(zzmq.zzbmc)).booleanValue()) {
            zza = zza(zzc, str);
        } else if (zzbw.zzyu == null) {
            throw new GeneralSecurityException();
        } else {
            byte[] zzd = zzbw.zzyu.zzd(zzc, str != null ? str.getBytes() : new byte[0]);
            zzbc zzbc = new zzbc();
            zzbc.zzgj = new byte[][]{zzd};
            zzbc.zzgl = 2;
            zza = zzfhs.zzc(zzbc);
        }
        return zzbr.zza(zza, true);
    }

    private static Vector<byte[]> zza(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector<>();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > 255 ? i3 + 255 : bArr.length));
                i2++;
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        }
        return vector;
    }

    private static byte[] zza(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Vector<byte[]> zza = zza(bArr, 255);
        if (zza == null || zza.size() == 0) {
            return zza(zzfhs.zzc(zzb((long) PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM)), str, true);
        }
        zzbc zzbc = new zzbc();
        zzbc.zzgj = new byte[zza.size()][];
        Iterator<byte[]> it = zza.iterator();
        int i = 0;
        while (it.hasNext()) {
            zzbc.zzgj[i] = zza(it.next(), str, false);
            i++;
        }
        zzbc.zzge = zzb(bArr);
        return zzfhs.zzc(zzbc);
    }

    private static byte[] zza(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] array;
        int i = z ? 239 : 255;
        if (bArr.length > i) {
            bArr = zzfhs.zzc(zzb((long) PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM));
        }
        if (bArr.length < i) {
            byte[] bArr2 = new byte[(i - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            array = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            array = ByteBuffer.allocate(256).put(zzb(array)).put(array).array();
        }
        byte[] bArr3 = new byte[256];
        new zzbx().zza(array, bArr3);
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzfby(str.getBytes("UTF-8")).zzax(bArr3);
        }
        return bArr3;
    }

    private static zzaw zzb(long j) {
        zzaw zzaw = new zzaw();
        zzaw.zzdn = Long.valueOf(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
        return zzaw;
    }

    public static byte[] zzb(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        synchronized (zzyr) {
            MessageDigest zzy = zzy();
            if (zzy == null) {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
            zzy.reset();
            zzy.update(bArr);
            digest = zzyq.digest();
        }
        return digest;
    }

    static void zzx() {
        synchronized (zzys) {
            if (!zzyp) {
                zzyp = true;
                new Thread(new zzbv()).start();
            }
        }
    }

    private static MessageDigest zzy() {
        zzx();
        boolean z = false;
        try {
            z = zzyt.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        if (z && zzyq != null) {
            return zzyq;
        }
        return null;
    }
}
