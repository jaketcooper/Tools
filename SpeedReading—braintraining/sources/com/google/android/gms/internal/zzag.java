package com.google.android.gms.internal;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class zzag implements zzb {
    private final Map<String, zzah> zzbt;
    private long zzbu;
    private final File zzbv;
    private final int zzbw;

    public zzag(File file) {
        this(file, 5242880);
    }

    private zzag(File file, int i) {
        this.zzbt = new LinkedHashMap(16, 0.75f, true);
        this.zzbu = 0;
        this.zzbv = file;
        this.zzbw = 5242880;
    }

    private final synchronized void remove(String str) {
        boolean delete = zze(str).delete();
        removeEntry(str);
        if (!delete) {
            zzab.zzb("Could not delete cache entry for key=%s, filename=%s", str, zzd(str));
        }
    }

    private final void removeEntry(String str) {
        zzah remove = this.zzbt.remove(str);
        if (remove != null) {
            this.zzbu -= remove.zzbx;
        }
    }

    private static int zza(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private static InputStream zza(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    static String zza(zzai zzai) throws IOException {
        return new String(zza(zzai, zzc(zzai)), "UTF-8");
    }

    static void zza(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write(i >>> 24);
    }

    static void zza(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) j));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void zza(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        zza(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private final void zza(String str, zzah zzah) {
        if (!this.zzbt.containsKey(str)) {
            this.zzbu += zzah.zzbx;
        } else {
            this.zzbu = (zzah.zzbx - this.zzbt.get(str).zzbx) + this.zzbu;
        }
        this.zzbt.put(str, zzah);
    }

    private static byte[] zza(zzai zzai, long j) throws IOException {
        long zzn = zzai.zzn();
        if (j < 0 || j > zzn || ((long) ((int) j)) != j) {
            throw new IOException(new StringBuilder(73).append("streamToBytes length=").append(j).append(", maxLength=").append(zzn).toString());
        }
        byte[] bArr = new byte[((int) j)];
        new DataInputStream(zzai).readFully(bArr);
        return bArr;
    }

    static int zzb(InputStream inputStream) throws IOException {
        return zza(inputStream) | 0 | (zza(inputStream) << 8) | (zza(inputStream) << 16) | (zza(inputStream) << 24);
    }

    static Map<String, String> zzb(zzai zzai) throws IOException {
        int zzb = zzb((InputStream) zzai);
        Map<String, String> emptyMap = zzb == 0 ? Collections.emptyMap() : new HashMap<>(zzb);
        for (int i = 0; i < zzb; i++) {
            emptyMap.put(zza(zzai).intern(), zza(zzai).intern());
        }
        return emptyMap;
    }

    static long zzc(InputStream inputStream) throws IOException {
        return 0 | (((long) zza(inputStream)) & 255) | ((((long) zza(inputStream)) & 255) << 8) | ((((long) zza(inputStream)) & 255) << 16) | ((((long) zza(inputStream)) & 255) << 24) | ((((long) zza(inputStream)) & 255) << 32) | ((((long) zza(inputStream)) & 255) << 40) | ((((long) zza(inputStream)) & 255) << 48) | ((((long) zza(inputStream)) & 255) << 56);
    }

    private static String zzd(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private final File zze(String str) {
        return new File(this.zzbv, zzd(str));
    }

    public final synchronized void initialize() {
        zzai zzai;
        if (this.zzbv.exists()) {
            File[] listFiles = this.zzbv.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    try {
                        long length = file.length();
                        zzai = new zzai(new BufferedInputStream(zza(file)), length);
                        zzah zzc = zzah.zzc(zzai);
                        zzc.zzbx = length;
                        zza(zzc.key, zzc);
                        zzai.close();
                    } catch (IOException e) {
                        file.delete();
                    } catch (Throwable th) {
                        zzai.close();
                        throw th;
                    }
                }
            }
        } else if (!this.zzbv.mkdirs()) {
            zzab.zzc("Unable to create cache dir %s", this.zzbv.getAbsolutePath());
        }
    }

    public final synchronized zzc zza(String str) {
        zzc zzc;
        zzai zzai;
        zzah zzah = this.zzbt.get(str);
        if (zzah == null) {
            zzc = null;
        } else {
            File zze = zze(str);
            try {
                zzai = new zzai(new BufferedInputStream(zza(zze)), zze.length());
                zzah zzc2 = zzah.zzc(zzai);
                if (!TextUtils.equals(str, zzc2.key)) {
                    zzab.zzb("%s: key=%s, found=%s", zze.getAbsolutePath(), str, zzc2.key);
                    removeEntry(str);
                    zzai.close();
                    zzc = null;
                } else {
                    byte[] zza = zza(zzai, zzai.zzn());
                    zzc zzc3 = new zzc();
                    zzc3.data = zza;
                    zzc3.zza = zzah.zza;
                    zzc3.zzb = zzah.zzb;
                    zzc3.zzc = zzah.zzc;
                    zzc3.zzd = zzah.zzd;
                    zzc3.zze = zzah.zze;
                    zzc3.zzf = zzah.zzf;
                    zzai.close();
                    zzc = zzc3;
                }
            } catch (IOException e) {
                zzab.zzb("%s: %s", zze.getAbsolutePath(), e.toString());
                remove(str);
                zzc = null;
            } catch (Throwable th) {
                zzai.close();
                throw th;
            }
        }
        return zzc;
    }

    public final synchronized void zza(String str, zzc zzc) {
        int i;
        int i2 = 0;
        synchronized (this) {
            int length = zzc.data.length;
            if (this.zzbu + ((long) length) >= ((long) this.zzbw)) {
                if (zzab.DEBUG) {
                    zzab.zza("Pruning old cache entries.", new Object[0]);
                }
                long j = this.zzbu;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Iterator<Map.Entry<String, zzah>> it = this.zzbt.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        i = i2;
                        break;
                    }
                    zzah zzah = (zzah) it.next().getValue();
                    if (zze(zzah.key).delete()) {
                        this.zzbu -= zzah.zzbx;
                    } else {
                        zzab.zzb("Could not delete cache entry for key=%s, filename=%s", zzah.key, zzd(zzah.key));
                    }
                    it.remove();
                    i = i2 + 1;
                    if (((float) (this.zzbu + ((long) length))) < ((float) this.zzbw) * 0.9f) {
                        break;
                    }
                    i2 = i;
                }
                if (zzab.DEBUG) {
                    zzab.zza("pruned %d files, %d bytes, %d ms", Integer.valueOf(i), Long.valueOf(this.zzbu - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                }
            }
            File zze = zze(str);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(zze));
                zzah zzah2 = new zzah(str, zzc);
                if (!zzah2.zza(bufferedOutputStream)) {
                    bufferedOutputStream.close();
                    zzab.zzb("Failed to write header for %s", zze.getAbsolutePath());
                    throw new IOException();
                }
                bufferedOutputStream.write(zzc.data);
                bufferedOutputStream.close();
                zza(str, zzah2);
            } catch (IOException e) {
                if (!zze.delete()) {
                    zzab.zzb("Could not clean up file %s", zze.getAbsolutePath());
                }
            }
        }
    }
}
