package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzcu {
    private static Cipher zzahv = null;
    private static final Object zzahw = new Object();
    private static final Object zzahx = new Object();
    private final SecureRandom zzahu = null;

    public zzcu(SecureRandom secureRandom) {
    }

    private static Cipher getCipher() throws NoSuchAlgorithmException, NoSuchPaddingException {
        Cipher cipher;
        synchronized (zzahx) {
            if (zzahv == null) {
                zzahv = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            cipher = zzahv;
        }
        return cipher;
    }

    public final byte[] zzb(byte[] bArr, String str) throws zzcv {
        byte[] doFinal;
        if (bArr.length != 16) {
            throw new zzcv(this);
        }
        try {
            byte[] zza = zzbr.zza(str, false);
            if (zza.length <= 16) {
                throw new zzcv(this);
            }
            ByteBuffer allocate = ByteBuffer.allocate(zza.length);
            allocate.put(zza);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[(zza.length - 16)];
            allocate.get(bArr2);
            allocate.get(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (zzahw) {
                getCipher().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                doFinal = getCipher().doFinal(bArr3);
            }
            return doFinal;
        } catch (NoSuchAlgorithmException e) {
            throw new zzcv(this, e);
        } catch (InvalidKeyException e2) {
            throw new zzcv(this, e2);
        } catch (IllegalBlockSizeException e3) {
            throw new zzcv(this, e3);
        } catch (NoSuchPaddingException e4) {
            throw new zzcv(this, e4);
        } catch (BadPaddingException e5) {
            throw new zzcv(this, e5);
        } catch (InvalidAlgorithmParameterException e6) {
            throw new zzcv(this, e6);
        } catch (IllegalArgumentException e7) {
            throw new zzcv(this, e7);
        }
    }

    public final String zzc(byte[] bArr, byte[] bArr2) throws zzcv {
        byte[] doFinal;
        byte[] iv;
        if (bArr.length != 16) {
            throw new zzcv(this);
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (zzahw) {
                getCipher().init(1, secretKeySpec, (SecureRandom) null);
                doFinal = getCipher().doFinal(bArr2);
                iv = getCipher().getIV();
            }
            int length = doFinal.length + iv.length;
            ByteBuffer allocate = ByteBuffer.allocate(length);
            allocate.put(iv).put(doFinal);
            allocate.flip();
            byte[] bArr3 = new byte[length];
            allocate.get(bArr3);
            return zzbr.zza(bArr3, false);
        } catch (NoSuchAlgorithmException e) {
            throw new zzcv(this, e);
        } catch (InvalidKeyException e2) {
            throw new zzcv(this, e2);
        } catch (IllegalBlockSizeException e3) {
            throw new zzcv(this, e3);
        } catch (NoSuchPaddingException e4) {
            throw new zzcv(this, e4);
        } catch (BadPaddingException e5) {
            throw new zzcv(this, e5);
        }
    }

    public final byte[] zzk(String str) throws zzcv {
        try {
            byte[] zza = zzbr.zza(str, false);
            if (zza.length != 32) {
                throw new zzcv(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(zza, 4, 16).get(bArr);
            for (int i = 0; i < 16; i++) {
                bArr[i] = (byte) (bArr[i] ^ 68);
            }
            return bArr;
        } catch (IllegalArgumentException e) {
            throw new zzcv(this, e);
        }
    }
}
