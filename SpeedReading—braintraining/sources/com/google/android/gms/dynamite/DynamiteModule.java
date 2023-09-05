package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class DynamiteModule {
    private static Boolean zzgug;
    private static zzk zzguh;
    private static zzm zzgui;
    private static String zzguj;
    private static final ThreadLocal<zza> zzguk = new ThreadLocal<>();
    private static final zzi zzgul = new zza();
    public static final zzd zzgum = new zzb();
    private static zzd zzgun = new zzc();
    public static final zzd zzguo = new zzd();
    public static final zzd zzgup = new zze();
    public static final zzd zzguq = new zzf();
    public static final zzd zzgur = new zzg();
    private final Context zzgus;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    static class zza {
        public Cursor zzgut;

        private zza() {
        }

        /* synthetic */ zza(zza zza) {
            this();
        }
    }

    static class zzb implements zzi {
        private final int zzguu;
        private final int zzguv = 0;

        public zzb(int i, int i2) {
            this.zzguu = i;
        }

        public final int zzab(Context context, String str) {
            return this.zzguu;
        }

        public final int zzc(Context context, String str, boolean z) {
            return 0;
        }
    }

    public static class zzc extends Exception {
        private zzc(String str) {
            super(str);
        }

        /* synthetic */ zzc(String str, zza zza) {
            this(str);
        }

        private zzc(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ zzc(String str, Throwable th, zza zza) {
            this(str, th);
        }
    }

    public interface zzd {
        zzj zza(Context context, String str, zzi zzi) throws zzc;
    }

    private DynamiteModule(Context context) {
        this.zzgus = (Context) zzbq.checkNotNull(context);
    }

    private static Context zza(Context context, String str, int i, Cursor cursor, zzm zzm) {
        try {
            return (Context) zzn.zzx(zzm.zza(zzn.zzy(context), str, i, zzn.zzy(cursor)));
        } catch (Exception e) {
            String valueOf = String.valueOf(e.toString());
            Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load DynamiteLoader: ".concat(valueOf) : new String("Failed to load DynamiteLoader: "));
            return null;
        }
    }

    public static DynamiteModule zza(Context context, zzd zzd2, String str) throws zzc {
        zzj zza2;
        zza zza3 = zzguk.get();
        zza zza4 = new zza((zza) null);
        zzguk.set(zza4);
        try {
            zza2 = zzd2.zza(context, str, zzgul);
            Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length()).append("Considering local module ").append(str).append(":").append(zza2.zzguw).append(" and remote module ").append(str).append(":").append(zza2.zzgux).toString());
            if (zza2.zzguy == 0 || ((zza2.zzguy == -1 && zza2.zzguw == 0) || (zza2.zzguy == 1 && zza2.zzgux == 0))) {
                throw new zzc(new StringBuilder(91).append("No acceptable module found. Local version is ").append(zza2.zzguw).append(" and remote version is ").append(zza2.zzgux).append(".").toString(), (zza) null);
            } else if (zza2.zzguy == -1) {
                DynamiteModule zzad = zzad(context, str);
                if (zza4.zzgut != null) {
                    zza4.zzgut.close();
                }
                zzguk.set(zza3);
                return zzad;
            } else if (zza2.zzguy == 1) {
                DynamiteModule zza5 = zza(context, str, zza2.zzgux);
                if (zza4.zzgut != null) {
                    zza4.zzgut.close();
                }
                zzguk.set(zza3);
                return zza5;
            } else {
                throw new zzc(new StringBuilder(47).append("VersionPolicy returned invalid code:").append(zza2.zzguy).toString(), (zza) null);
            }
        } catch (zzc e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
            if (zza2.zzguw == 0 || zzd2.zza(context, str, new zzb(zza2.zzguw, 0)).zzguy != -1) {
                throw new zzc("Remote load failed. No local fallback found.", e, (zza) null);
            }
            DynamiteModule zzad2 = zzad(context, str);
            if (zza4.zzgut != null) {
                zza4.zzgut.close();
            }
            zzguk.set(zza3);
            return zzad2;
        } catch (Throwable th) {
            if (zza4.zzgut != null) {
                zza4.zzgut.close();
            }
            zzguk.set(zza3);
            throw th;
        }
    }

    private static DynamiteModule zza(Context context, String str, int i) throws zzc {
        Boolean bool;
        synchronized (DynamiteModule.class) {
            bool = zzgug;
        }
        if (bool != null) {
            return bool.booleanValue() ? zzc(context, str, i) : zzb(context, str, i);
        }
        throw new zzc("Failed to determine which loading route to use.", (zza) null);
    }

    private static void zza(ClassLoader classLoader) throws zzc {
        zzm zzn;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzn = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zzn = queryLocalInterface instanceof zzm ? (zzm) queryLocalInterface : new zzn(iBinder);
            }
            zzgui = zzn;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new zzc("Failed to instantiate dynamite loader", e, (zza) null);
        }
    }

    public static int zzab(Context context, String str) {
        try {
            Class<?> loadClass = context.getApplicationContext().getClassLoader().loadClass(new StringBuilder(String.valueOf("com.google.android.gms.dynamite.descriptors.").length() + 1 + String.valueOf(str).length() + String.valueOf("ModuleDescriptor").length()).append("com.google.android.gms.dynamite.descriptors.").append(str).append(".").append("ModuleDescriptor").toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get((Object) null).equals(str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            Log.e("DynamiteModule", new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length()).append("Module descriptor id '").append(valueOf).append("' didn't match expected id '").append(str).append("'").toString());
            return 0;
        } catch (ClassNotFoundException e) {
            Log.w("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 45).append("Local module descriptor class for ").append(str).append(" not found.").toString());
            return 0;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    public static int zzac(Context context, String str) {
        return zzc(context, str, false);
    }

    private static DynamiteModule zzad(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static DynamiteModule zzb(Context context, String str, int i) throws zzc {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        zzk zzdc = zzdc(context);
        if (zzdc == null) {
            throw new zzc("Failed to create IDynamiteLoader.", (zza) null);
        }
        try {
            IObjectWrapper zza2 = zzdc.zza(zzn.zzy(context), str, i);
            if (zzn.zzx(zza2) != null) {
                return new DynamiteModule((Context) zzn.zzx(zza2));
            }
            throw new zzc("Failed to load remote module.", (zza) null);
        } catch (RemoteException e) {
            throw new zzc("Failed to load remote module.", e, (zza) null);
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:35:0x0071=Splitter:B:35:0x0071, B:25:0x0043=Splitter:B:25:0x0043} */
    public static int zzc(android.content.Context r7, java.lang.String r8, boolean r9) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r1 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r1)
            java.lang.Boolean r0 = zzgug     // Catch:{ all -> 0x0074 }
            if (r0 != 0) goto L_0x0034
            android.content.Context r0 = r7.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x009f, IllegalAccessException -> 0x00f8, NoSuchFieldException -> 0x00f6 }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x009f, IllegalAccessException -> 0x00f8, NoSuchFieldException -> 0x00f6 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r2 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r2 = r2.getName()     // Catch:{ ClassNotFoundException -> 0x009f, IllegalAccessException -> 0x00f8, NoSuchFieldException -> 0x00f6 }
            java.lang.Class r2 = r0.loadClass(r2)     // Catch:{ ClassNotFoundException -> 0x009f, IllegalAccessException -> 0x00f8, NoSuchFieldException -> 0x00f6 }
            java.lang.String r0 = "sClassLoader"
            java.lang.reflect.Field r3 = r2.getDeclaredField(r0)     // Catch:{ ClassNotFoundException -> 0x009f, IllegalAccessException -> 0x00f8, NoSuchFieldException -> 0x00f6 }
            monitor-enter(r2)     // Catch:{ ClassNotFoundException -> 0x009f, IllegalAccessException -> 0x00f8, NoSuchFieldException -> 0x00f6 }
            r0 = 0
            java.lang.Object r0 = r3.get(r0)     // Catch:{ all -> 0x009c }
            java.lang.ClassLoader r0 = (java.lang.ClassLoader) r0     // Catch:{ all -> 0x009c }
            if (r0 == 0) goto L_0x0046
            java.lang.ClassLoader r3 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x009c }
            if (r0 != r3) goto L_0x0040
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x009c }
        L_0x0031:
            monitor-exit(r2)     // Catch:{ all -> 0x009c }
        L_0x0032:
            zzgug = r0     // Catch:{ all -> 0x0074 }
        L_0x0034:
            monitor-exit(r1)     // Catch:{ all -> 0x0074 }
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00ed
            int r0 = zze(r7, r8, r9)     // Catch:{ zzc -> 0x00ca }
        L_0x003f:
            return r0
        L_0x0040:
            zza(r0)     // Catch:{ zzc -> 0x00f3 }
        L_0x0043:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x009c }
            goto L_0x0031
        L_0x0046:
            java.lang.String r0 = "com.google.android.gms"
            android.content.Context r4 = r7.getApplicationContext()     // Catch:{ all -> 0x009c }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ all -> 0x009c }
            boolean r0 = r0.equals(r4)     // Catch:{ all -> 0x009c }
            if (r0 == 0) goto L_0x0061
            r0 = 0
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x009c }
            r3.set(r0, r4)     // Catch:{ all -> 0x009c }
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x009c }
            goto L_0x0031
        L_0x0061:
            int r0 = zze(r7, r8, r9)     // Catch:{ zzc -> 0x0090 }
            java.lang.String r4 = zzguj     // Catch:{ zzc -> 0x0090 }
            if (r4 == 0) goto L_0x0071
            java.lang.String r4 = zzguj     // Catch:{ zzc -> 0x0090 }
            boolean r4 = r4.isEmpty()     // Catch:{ zzc -> 0x0090 }
            if (r4 == 0) goto L_0x0077
        L_0x0071:
            monitor-exit(r2)     // Catch:{ all -> 0x009c }
            monitor-exit(r1)     // Catch:{ all -> 0x0074 }
            goto L_0x003f
        L_0x0074:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0074 }
            throw r0
        L_0x0077:
            com.google.android.gms.dynamite.zzh r4 = new com.google.android.gms.dynamite.zzh     // Catch:{ zzc -> 0x0090 }
            java.lang.String r5 = zzguj     // Catch:{ zzc -> 0x0090 }
            java.lang.ClassLoader r6 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ zzc -> 0x0090 }
            r4.<init>(r5, r6)     // Catch:{ zzc -> 0x0090 }
            zza(r4)     // Catch:{ zzc -> 0x0090 }
            r5 = 0
            r3.set(r5, r4)     // Catch:{ zzc -> 0x0090 }
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ zzc -> 0x0090 }
            zzgug = r4     // Catch:{ zzc -> 0x0090 }
            monitor-exit(r2)     // Catch:{ all -> 0x009c }
            monitor-exit(r1)     // Catch:{ all -> 0x0074 }
            goto L_0x003f
        L_0x0090:
            r0 = move-exception
            r0 = 0
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x009c }
            r3.set(r0, r4)     // Catch:{ all -> 0x009c }
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x009c }
            goto L_0x0031
        L_0x009c:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x009c }
            throw r0     // Catch:{ ClassNotFoundException -> 0x009f, IllegalAccessException -> 0x00f8, NoSuchFieldException -> 0x00f6 }
        L_0x009f:
            r0 = move-exception
        L_0x00a0:
            java.lang.String r2 = "DynamiteModule"
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0074 }
            java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0074 }
            int r3 = r3.length()     // Catch:{ all -> 0x0074 }
            int r3 = r3 + 30
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
            r4.<init>(r3)     // Catch:{ all -> 0x0074 }
            java.lang.String r3 = "Failed to load module via V2: "
            java.lang.StringBuilder r3 = r4.append(r3)     // Catch:{ all -> 0x0074 }
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch:{ all -> 0x0074 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0074 }
            android.util.Log.w(r2, r0)     // Catch:{ all -> 0x0074 }
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0074 }
            goto L_0x0032
        L_0x00ca:
            r0 = move-exception
            java.lang.String r1 = "DynamiteModule"
            java.lang.String r2 = "Failed to retrieve remote module version: "
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r3 = r0.length()
            if (r3 == 0) goto L_0x00e7
            java.lang.String r0 = r2.concat(r0)
        L_0x00e1:
            android.util.Log.w(r1, r0)
            r0 = 0
            goto L_0x003f
        L_0x00e7:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            goto L_0x00e1
        L_0x00ed:
            int r0 = zzd(r7, r8, r9)
            goto L_0x003f
        L_0x00f3:
            r0 = move-exception
            goto L_0x0043
        L_0x00f6:
            r0 = move-exception
            goto L_0x00a0
        L_0x00f8:
            r0 = move-exception
            goto L_0x00a0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzc(android.content.Context, java.lang.String, boolean):int");
    }

    private static DynamiteModule zzc(Context context, String str, int i) throws zzc {
        zzm zzm;
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        synchronized (DynamiteModule.class) {
            zzm = zzgui;
        }
        if (zzm == null) {
            throw new zzc("DynamiteLoaderV2 was not cached.", (zza) null);
        }
        zza zza2 = zzguk.get();
        if (zza2 == null || zza2.zzgut == null) {
            throw new zzc("No result cursor", (zza) null);
        }
        Context zza3 = zza(context.getApplicationContext(), str, i, zza2.zzgut, zzm);
        if (zza3 != null) {
            return new DynamiteModule(zza3);
        }
        throw new zzc("Failed to get module context", (zza) null);
    }

    private static int zzd(Context context, String str, boolean z) {
        zzk zzdc = zzdc(context);
        if (zzdc == null) {
            return 0;
        }
        try {
            return zzdc.zza(zzn.zzy(context), str, z);
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.dynamite.zzk zzdc(android.content.Context r7) {
        /*
            r3 = 0
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r4 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r4)
            com.google.android.gms.dynamite.zzk r1 = zzguh     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x000c
            com.google.android.gms.dynamite.zzk r1 = zzguh     // Catch:{ all -> 0x0039 }
            monitor-exit(r4)     // Catch:{ all -> 0x0039 }
        L_0x000b:
            return r1
        L_0x000c:
            com.google.android.gms.common.zze r1 = com.google.android.gms.common.zze.zzafn()     // Catch:{ all -> 0x0039 }
            int r1 = r1.isGooglePlayServicesAvailable(r7)     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0019
            monitor-exit(r4)     // Catch:{ all -> 0x0039 }
            r1 = r3
            goto L_0x000b
        L_0x0019:
            java.lang.String r1 = "com.google.android.gms"
            r2 = 3
            android.content.Context r1 = r7.createPackageContext(r1, r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "com.google.android.gms.chimera.container.DynamiteLoaderImpl"
            java.lang.Class r1 = r1.loadClass(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.Object r1 = r1.newInstance()     // Catch:{ Exception -> 0x0052 }
            android.os.IBinder r1 = (android.os.IBinder) r1     // Catch:{ Exception -> 0x0052 }
            if (r1 != 0) goto L_0x003c
            r1 = r3
        L_0x0033:
            if (r1 == 0) goto L_0x006c
            zzguh = r1     // Catch:{ Exception -> 0x0052 }
            monitor-exit(r4)     // Catch:{ all -> 0x0039 }
            goto L_0x000b
        L_0x0039:
            r1 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0039 }
            throw r1
        L_0x003c:
            java.lang.String r2 = "com.google.android.gms.dynamite.IDynamiteLoader"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)     // Catch:{ Exception -> 0x0052 }
            boolean r5 = r2 instanceof com.google.android.gms.dynamite.zzk     // Catch:{ Exception -> 0x0052 }
            if (r5 == 0) goto L_0x004b
            r0 = r2
            com.google.android.gms.dynamite.zzk r0 = (com.google.android.gms.dynamite.zzk) r0     // Catch:{ Exception -> 0x0052 }
            r1 = r0
            goto L_0x0033
        L_0x004b:
            com.google.android.gms.dynamite.zzl r2 = new com.google.android.gms.dynamite.zzl     // Catch:{ Exception -> 0x0052 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0052 }
            r1 = r2
            goto L_0x0033
        L_0x0052:
            r1 = move-exception
            java.lang.String r2 = "DynamiteModule"
            java.lang.String r5 = "Failed to load IDynamiteLoader from GmsCore: "
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0039 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0039 }
            int r6 = r1.length()     // Catch:{ all -> 0x0039 }
            if (r6 == 0) goto L_0x006f
            java.lang.String r1 = r5.concat(r1)     // Catch:{ all -> 0x0039 }
        L_0x0069:
            android.util.Log.e(r2, r1)     // Catch:{ all -> 0x0039 }
        L_0x006c:
            monitor-exit(r4)     // Catch:{ all -> 0x0039 }
            r1 = r3
            goto L_0x000b
        L_0x006f:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x0039 }
            r1.<init>(r5)     // Catch:{ all -> 0x0039 }
            goto L_0x0069
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzdc(android.content.Context):com.google.android.gms.dynamite.zzk");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zze(android.content.Context r7, java.lang.String r8, boolean r9) throws com.google.android.gms.dynamite.DynamiteModule.zzc {
        /*
            r6 = 0
            if (r9 == 0) goto L_0x0073
            java.lang.String r0 = "api_force_staging"
        L_0x0005:
            java.lang.String r1 = "content://com.google.android.gms.chimera/"
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            int r2 = r2.length()     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            int r2 = r2 + 1
            java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            int r3 = r3.length()     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            int r2 = r2 + r3
            java.lang.String r3 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            int r3 = r3.length()     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            r3.<init>(r2)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            java.lang.StringBuilder r1 = r3.append(r1)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            java.lang.String r1 = "/"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            java.lang.StringBuilder r0 = r0.append(r8)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            android.net.Uri r1 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            android.content.ContentResolver r0 = r7.getContentResolver()     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            if (r1 == 0) goto L_0x0056
            boolean r0 = r1.moveToFirst()     // Catch:{ Exception -> 0x0066 }
            if (r0 != 0) goto L_0x0076
        L_0x0056:
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r2 = "Failed to retrieve remote module version."
            android.util.Log.w(r0, r2)     // Catch:{ Exception -> 0x0066 }
            com.google.android.gms.dynamite.DynamiteModule$zzc r0 = new com.google.android.gms.dynamite.DynamiteModule$zzc     // Catch:{ Exception -> 0x0066 }
            java.lang.String r2 = "Failed to connect to dynamite module ContentResolver."
            r3 = 0
            r0.<init>((java.lang.String) r2, (com.google.android.gms.dynamite.zza) r3)     // Catch:{ Exception -> 0x0066 }
            throw r0     // Catch:{ Exception -> 0x0066 }
        L_0x0066:
            r0 = move-exception
        L_0x0067:
            boolean r2 = r0 instanceof com.google.android.gms.dynamite.DynamiteModule.zzc     // Catch:{ all -> 0x006c }
            if (r2 == 0) goto L_0x00a2
            throw r0     // Catch:{ all -> 0x006c }
        L_0x006c:
            r0 = move-exception
        L_0x006d:
            if (r1 == 0) goto L_0x0072
            r1.close()
        L_0x0072:
            throw r0
        L_0x0073:
            java.lang.String r0 = "api"
            goto L_0x0005
        L_0x0076:
            r0 = 0
            int r2 = r1.getInt(r0)     // Catch:{ Exception -> 0x0066 }
            if (r2 <= 0) goto L_0x0099
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r3 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r3)     // Catch:{ Exception -> 0x0066 }
            r0 = 2
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x009f }
            zzguj = r0     // Catch:{ all -> 0x009f }
            monitor-exit(r3)     // Catch:{ all -> 0x009f }
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$zza> r0 = zzguk     // Catch:{ Exception -> 0x0066 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0066 }
            com.google.android.gms.dynamite.DynamiteModule$zza r0 = (com.google.android.gms.dynamite.DynamiteModule.zza) r0     // Catch:{ Exception -> 0x0066 }
            if (r0 == 0) goto L_0x0099
            android.database.Cursor r3 = r0.zzgut     // Catch:{ Exception -> 0x0066 }
            if (r3 != 0) goto L_0x0099
            r0.zzgut = r1     // Catch:{ Exception -> 0x0066 }
            r1 = r6
        L_0x0099:
            if (r1 == 0) goto L_0x009e
            r1.close()
        L_0x009e:
            return r2
        L_0x009f:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x009f }
            throw r0     // Catch:{ Exception -> 0x0066 }
        L_0x00a2:
            com.google.android.gms.dynamite.DynamiteModule$zzc r2 = new com.google.android.gms.dynamite.DynamiteModule$zzc     // Catch:{ all -> 0x006c }
            java.lang.String r3 = "V2 version check failed"
            r4 = 0
            r2.<init>(r3, r0, r4)     // Catch:{ all -> 0x006c }
            throw r2     // Catch:{ all -> 0x006c }
        L_0x00ab:
            r0 = move-exception
            r1 = r6
            goto L_0x006d
        L_0x00ae:
            r0 = move-exception
            r1 = r6
            goto L_0x0067
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zze(android.content.Context, java.lang.String, boolean):int");
    }

    public final Context zzapq() {
        return this.zzgus;
    }

    public final IBinder zzgx(String str) throws zzc {
        try {
            return (IBinder) this.zzgus.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String valueOf = String.valueOf(str);
            throw new zzc(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e, (zza) null);
        }
    }
}
