package com.google.android.gms.internal;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzfgr {
    private static final Logger logger = Logger.getLogger(zzfgr.class.getName());
    private static final Unsafe zzlos = zzcwz();
    private static final boolean zzpbt = zzcxa();
    private static final Class<?> zzpfc = zzth("libcore.io.Memory");
    private static final boolean zzpfd = (zzth("org.robolectric.Robolectric") != null);
    private static final boolean zzpfe = zzj(Long.TYPE);
    private static final boolean zzpff = zzj(Integer.TYPE);
    private static final zzd zzpfg = (zzlos == null ? null : zzcxc() ? zzpfe ? new zzb(zzlos) : zzpff ? new zza(zzlos) : null : new zzc(zzlos));
    private static final boolean zzpfh = zzcxb();
    private static final long zzpfi = ((long) zzh(byte[].class));
    private static final long zzpfj = ((long) zzh(boolean[].class));
    private static final long zzpfk = ((long) zzi(boolean[].class));
    private static final long zzpfl = ((long) zzh(int[].class));
    private static final long zzpfm = ((long) zzi(int[].class));
    private static final long zzpfn = ((long) zzh(long[].class));
    private static final long zzpfo = ((long) zzi(long[].class));
    private static final long zzpfp = ((long) zzh(float[].class));
    private static final long zzpfq = ((long) zzi(float[].class));
    private static final long zzpfr = ((long) zzh(double[].class));
    private static final long zzpfs = ((long) zzi(double[].class));
    private static final long zzpft = ((long) zzh(Object[].class));
    private static final long zzpfu = ((long) zzi(Object[].class));
    private static final long zzpfv;
    /* access modifiers changed from: private */
    public static final boolean zzpfw;

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzfgr.zzpfw) {
                zzfgr.zza(obj, j, b);
            } else {
                zzfgr.zzb(obj, j, b);
            }
        }

        public final byte zzf(Object obj, long j) {
            return zzfgr.zzpfw ? zzfgr.zzb(obj, j) : zzfgr.zzc(obj, j);
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzfgr.zzpfw) {
                zzfgr.zza(obj, j, b);
            } else {
                zzfgr.zzb(obj, j, b);
            }
        }

        public final byte zzf(Object obj, long j) {
            return zzfgr.zzpfw ? zzfgr.zzb(obj, j) : zzfgr.zzc(obj, j);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzpfx.putByte(obj, j, b);
        }

        public final byte zzf(Object obj, long j) {
            return this.zzpfx.getByte(obj, j);
        }
    }

    static abstract class zzd {
        Unsafe zzpfx;

        zzd(Unsafe unsafe) {
            this.zzpfx = unsafe;
        }

        public abstract void zze(Object obj, long j, byte b);

        public abstract byte zzf(Object obj, long j);
    }

    static {
        Field zza2;
        boolean z = true;
        if (!zzcxc() || (zza2 = zza((Class<?>) Buffer.class, "effectiveDirectAddress")) == null) {
            zza2 = zza((Class<?>) Buffer.class, "address");
        }
        zzpfv = (zza2 == null || zzpfg == null) ? -1 : zzpfg.zzpfx.objectFieldOffset(zza2);
        if (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) {
            z = false;
        }
        zzpfw = z;
    }

    private zzfgr() {
    }

    private static int zza(Object obj, long j) {
        return zzpfg.zzpfx.getInt(obj, j);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        int i = ((((int) j) ^ -1) & 3) << 3;
        zza(obj, j & -4, (zza(obj, j & -4) & ((255 << i) ^ -1)) | ((b & 255) << i));
    }

    private static void zza(Object obj, long j, int i) {
        zzpfg.zzpfx.putInt(obj, j, i);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzpfg.zze(bArr, zzpfi + j, b);
    }

    /* access modifiers changed from: private */
    public static byte zzb(Object obj, long j) {
        return (byte) (zza(obj, -4 & j) >>> ((int) (((-1 ^ j) & 3) << 3)));
    }

    static byte zzb(byte[] bArr, long j) {
        return zzpfg.zzf(bArr, zzpfi + j);
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        int i = (((int) j) & 3) << 3;
        zza(obj, j & -4, (zza(obj, j & -4) & ((255 << i) ^ -1)) | ((b & 255) << i));
    }

    /* access modifiers changed from: private */
    public static byte zzc(Object obj, long j) {
        return (byte) (zza(obj, -4 & j) >>> ((int) ((3 & j) << 3)));
    }

    static boolean zzcwx() {
        return zzpbt;
    }

    static boolean zzcwy() {
        return zzpfh;
    }

    private static Unsafe zzcwz() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzfgs());
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean zzcxa() {
        if (zzlos == null) {
            return false;
        }
        try {
            Class<?> cls = zzlos.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (zzcxc()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", new StringBuilder(String.valueOf(valueOf).length() + 71).append("platform method missing - proto runtime falling back to safer methods: ").append(valueOf).toString());
            return false;
        }
    }

    private static boolean zzcxb() {
        if (zzlos == null) {
            return false;
        }
        try {
            Class<?> cls = zzlos.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (zzcxc()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", new StringBuilder(String.valueOf(valueOf).length() + 71).append("platform method missing - proto runtime falling back to safer methods: ").append(valueOf).toString());
            return false;
        }
    }

    private static boolean zzcxc() {
        return zzpfc != null && !zzpfd;
    }

    private static int zzh(Class<?> cls) {
        if (zzpbt) {
            return zzpfg.zzpfx.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzi(Class<?> cls) {
        if (zzpbt) {
            return zzpfg.zzpfx.arrayIndexScale(cls);
        }
        return -1;
    }

    private static boolean zzj(Class<?> cls) {
        if (!zzcxc()) {
            return false;
        }
        try {
            Class<?> cls2 = zzpfc;
            cls2.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls2.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls2.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls2.getMethod("peekByte", new Class[]{cls});
            cls2.getMethod("pokeByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            cls2.getMethod("peekByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static <T> Class<T> zzth(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable th) {
            return null;
        }
    }
}
