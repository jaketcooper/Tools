package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.zze;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzda {
    private static final String TAG = zzda.class.getSimpleName();
    private volatile boolean zzahk = false;
    protected Context zzaif;
    private Context zzaig;
    private ExecutorService zzaih;
    private DexClassLoader zzaii;
    private zzcu zzaij;
    private byte[] zzaik;
    private volatile AdvertisingIdClient zzail = null;
    private Future zzaim = null;
    /* access modifiers changed from: private */
    public volatile zzaw zzain = null;
    private Future zzaio = null;
    private zzcm zzaip;
    private boolean zzaiq = false;
    private boolean zzair = false;
    private Map<Pair<String, String>, zzea> zzais;
    private boolean zzait = false;
    /* access modifiers changed from: private */
    public boolean zzaiu = true;
    private boolean zzaiv = false;

    final class zza extends BroadcastReceiver {
        private zza() {
        }

        /* synthetic */ zza(zzda zzda, zzdb zzdb) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                boolean unused = zzda.this.zzaiu = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                boolean unused2 = zzda.this.zzaiu = false;
            }
        }
    }

    private zzda(Context context) {
        this.zzaif = context;
        this.zzaig = context.getApplicationContext();
        this.zzais = new HashMap();
    }

    public static zzda zza(Context context, String str, String str2, boolean z) {
        File file;
        File file2;
        boolean z2 = true;
        zzda zzda = new zzda(context);
        try {
            zzda.zzaih = Executors.newCachedThreadPool();
            zzda.zzahk = z;
            if (z) {
                zzda.zzaim = zzda.zzaih.submit(new zzdb(zzda));
            }
            zzda.zzaih.execute(new zzdd(zzda));
            try {
                zze zzafn = zze.zzafn();
                zzda.zzaiq = zze.zzcd(zzda.zzaif) > 0;
                if (zzafn.isGooglePlayServicesAvailable(zzda.zzaif) != 0) {
                    z2 = false;
                }
                zzda.zzair = z2;
            } catch (Throwable th) {
            }
            zzda.zza(0, true);
            if (zzdf.zzas()) {
                if (((Boolean) zzbs.zzep().zzd(zzmq.zzbmd)).booleanValue()) {
                    throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
                }
            }
            zzda.zzaij = new zzcu((SecureRandom) null);
            zzda.zzaik = zzda.zzaij.zzk(str);
            File cacheDir = zzda.zzaif.getCacheDir();
            if (cacheDir == null && (cacheDir = zzda.zzaif.getDir("dex", 0)) == null) {
                throw new zzcx();
            }
            file = cacheDir;
            file2 = new File(String.format("%s/%s.jar", new Object[]{file, "1501670890290"}));
            if (!file2.exists()) {
                byte[] zzb = zzda.zzaij.zzb(zzda.zzaik, str2);
                file2.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                fileOutputStream.write(zzb, 0, zzb.length);
                fileOutputStream.close();
            }
            zzda.zzb(file, "1501670890290");
            zzda.zzaii = new DexClassLoader(file2.getAbsolutePath(), file.getAbsolutePath(), (String) null, zzda.zzaif.getClassLoader());
            zzb(file2);
            zzda.zza(file, "1501670890290");
            zzl(String.format("%s/%s.dex", new Object[]{file, "1501670890290"}));
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzblx)).booleanValue() && !zzda.zzaiv && zzda.zzaig != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                zzda.zzaig.registerReceiver(new zza(zzda, (zzdb) null), intentFilter);
                zzda.zzaiv = true;
            }
            zzda.zzaip = new zzcm(zzda);
            zzda.zzait = true;
            return zzda;
        } catch (zzcv e) {
            throw new zzcx(e);
        } catch (FileNotFoundException e2) {
            throw new zzcx(e2);
        } catch (IOException e3) {
            throw new zzcx(e3);
        } catch (zzcv e4) {
            throw new zzcx(e4);
        } catch (NullPointerException e5) {
            throw new zzcx(e5);
        } catch (zzcx e6) {
        } catch (Throwable th2) {
            zzb(file2);
            zzda.zza(file, "1501670890290");
            zzl(String.format("%s/%s.dex", new Object[]{file, "1501670890290"}));
            throw th2;
        }
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009b A[SYNTHETIC, Splitter:B:27:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a0 A[SYNTHETIC, Splitter:B:30:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ac A[SYNTHETIC, Splitter:B:36:0x00ac] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b1 A[SYNTHETIC, Splitter:B:39:0x00b1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.io.File r12, java.lang.String r13) {
        /*
            r11 = this;
            r1 = 0
            r7 = 2
            r6 = 1
            r5 = 0
            java.io.File r3 = new java.io.File
            java.lang.String r0 = "%s/%s.tmp"
            java.lang.Object[] r2 = new java.lang.Object[r7]
            r2[r5] = r12
            r2[r6] = r13
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r3.<init>(r0)
            boolean r0 = r3.exists()
            if (r0 == 0) goto L_0x001c
        L_0x001b:
            return
        L_0x001c:
            java.io.File r4 = new java.io.File
            java.lang.String r0 = "%s/%s.dex"
            java.lang.Object[] r2 = new java.lang.Object[r7]
            r2[r5] = r12
            r2[r6] = r13
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r4.<init>(r0)
            boolean r0 = r4.exists()
            if (r0 == 0) goto L_0x001b
            long r6 = r4.length()
            r8 = 0
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x001b
            int r0 = (int) r6
            byte[] r0 = new byte[r0]
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00de, NoSuchAlgorithmException -> 0x0097, zzcv -> 0x00d4, all -> 0x00a8 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x00de, NoSuchAlgorithmException -> 0x0097, zzcv -> 0x00d4, all -> 0x00a8 }
            int r5 = r2.read(r0)     // Catch:{ IOException -> 0x00e1, NoSuchAlgorithmException -> 0x00cd, zzcv -> 0x00d7, all -> 0x00c6 }
            if (r5 > 0) goto L_0x0052
            r2.close()     // Catch:{ IOException -> 0x00b8 }
        L_0x004e:
            zzb(r4)
            goto L_0x001b
        L_0x0052:
            com.google.android.gms.internal.zzba r5 = new com.google.android.gms.internal.zzba     // Catch:{ IOException -> 0x00e1, NoSuchAlgorithmException -> 0x00cd, zzcv -> 0x00d7, all -> 0x00c6 }
            r5.<init>()     // Catch:{ IOException -> 0x00e1, NoSuchAlgorithmException -> 0x00cd, zzcv -> 0x00d7, all -> 0x00c6 }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ IOException -> 0x00e1, NoSuchAlgorithmException -> 0x00cd, zzcv -> 0x00d7, all -> 0x00c6 }
            byte[] r6 = r6.getBytes()     // Catch:{ IOException -> 0x00e1, NoSuchAlgorithmException -> 0x00cd, zzcv -> 0x00d7, all -> 0x00c6 }
            r5.zzgg = r6     // Catch:{ IOException -> 0x00e1, NoSuchAlgorithmException -> 0x00cd, zzcv -> 0x00d7, all -> 0x00c6 }
            byte[] r6 = r13.getBytes()     // Catch:{ IOException -> 0x00e1, NoSuchAlgorithmException -> 0x00cd, zzcv -> 0x00d7, all -> 0x00c6 }
            r5.zzgf = r6     // Catch:{ IOException -> 0x00e1, NoSuchAlgorithmException -> 0x00cd, zzcv -> 0x00d7, all -> 0x00c6 }
            com.google.android.gms.internal.zzcu r6 = r11.zzaij     // Catch:{ IOException -> 0x00e1, NoSuchAlgorithmException -> 0x00cd, zzcv -> 0x00d7, all -> 0x00c6 }
            byte[] r7 = r11.zzaik     // Catch:{ IOException -> 0x00e1, NoSuchAlgorithmException -> 0x00cd, zzcv -> 0x00d7, all -> 0x00c6 }
            java.lang.String r0 = r6.zzc(r7, r0)     // Catch:{ IOException -> 0x00e1, NoSuchAlgorithmException -> 0x00cd, zzcv -> 0x00d7, all -> 0x00c6 }
            byte[] r0 = r0.getBytes()     // Catch:{ IOException -> 0x00e1, NoSuchAlgorithmException -> 0x00cd, zzcv -> 0x00d7, all -> 0x00c6 }
            r5.data = r0     // Catch:{ IOException -> 0x00e1, NoSuchAlgorithmException -> 0x00cd, zzcv -> 0x00d7, all -> 0x00c6 }
            byte[] r0 = com.google.android.gms.internal.zzbt.zzb((byte[]) r0)     // Catch:{ IOException -> 0x00e1, NoSuchAlgorithmException -> 0x00cd, zzcv -> 0x00d7, all -> 0x00c6 }
            r5.zzge = r0     // Catch:{ IOException -> 0x00e1, NoSuchAlgorithmException -> 0x00cd, zzcv -> 0x00d7, all -> 0x00c6 }
            r3.createNewFile()     // Catch:{ IOException -> 0x00e1, NoSuchAlgorithmException -> 0x00cd, zzcv -> 0x00d7, all -> 0x00c6 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00e1, NoSuchAlgorithmException -> 0x00cd, zzcv -> 0x00d7, all -> 0x00c6 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x00e1, NoSuchAlgorithmException -> 0x00cd, zzcv -> 0x00d7, all -> 0x00c6 }
            byte[] r1 = com.google.android.gms.internal.zzfhs.zzc(r5)     // Catch:{ IOException -> 0x00e5, NoSuchAlgorithmException -> 0x00d1, zzcv -> 0x00db, all -> 0x00c8 }
            r3 = 0
            int r5 = r1.length     // Catch:{ IOException -> 0x00e5, NoSuchAlgorithmException -> 0x00d1, zzcv -> 0x00db, all -> 0x00c8 }
            r0.write(r1, r3, r5)     // Catch:{ IOException -> 0x00e5, NoSuchAlgorithmException -> 0x00d1, zzcv -> 0x00db, all -> 0x00c8 }
            r0.close()     // Catch:{ IOException -> 0x00e5, NoSuchAlgorithmException -> 0x00d1, zzcv -> 0x00db, all -> 0x00c8 }
            r2.close()     // Catch:{ IOException -> 0x00ba }
        L_0x0090:
            r0.close()     // Catch:{ IOException -> 0x00bc }
        L_0x0093:
            zzb(r4)
            goto L_0x001b
        L_0x0097:
            r0 = move-exception
            r0 = r1
        L_0x0099:
            if (r1 == 0) goto L_0x009e
            r1.close()     // Catch:{ IOException -> 0x00be }
        L_0x009e:
            if (r0 == 0) goto L_0x00a3
            r0.close()     // Catch:{ IOException -> 0x00c0 }
        L_0x00a3:
            zzb(r4)
            goto L_0x001b
        L_0x00a8:
            r0 = move-exception
            r2 = r1
        L_0x00aa:
            if (r2 == 0) goto L_0x00af
            r2.close()     // Catch:{ IOException -> 0x00c2 }
        L_0x00af:
            if (r1 == 0) goto L_0x00b4
            r1.close()     // Catch:{ IOException -> 0x00c4 }
        L_0x00b4:
            zzb(r4)
            throw r0
        L_0x00b8:
            r0 = move-exception
            goto L_0x004e
        L_0x00ba:
            r1 = move-exception
            goto L_0x0090
        L_0x00bc:
            r0 = move-exception
            goto L_0x0093
        L_0x00be:
            r1 = move-exception
            goto L_0x009e
        L_0x00c0:
            r0 = move-exception
            goto L_0x00a3
        L_0x00c2:
            r2 = move-exception
            goto L_0x00af
        L_0x00c4:
            r1 = move-exception
            goto L_0x00b4
        L_0x00c6:
            r0 = move-exception
            goto L_0x00aa
        L_0x00c8:
            r1 = move-exception
            r10 = r1
            r1 = r0
            r0 = r10
            goto L_0x00aa
        L_0x00cd:
            r0 = move-exception
            r0 = r1
            r1 = r2
            goto L_0x0099
        L_0x00d1:
            r1 = move-exception
            r1 = r2
            goto L_0x0099
        L_0x00d4:
            r0 = move-exception
            r0 = r1
            goto L_0x0099
        L_0x00d7:
            r0 = move-exception
            r0 = r1
            r1 = r2
            goto L_0x0099
        L_0x00db:
            r1 = move-exception
            r1 = r2
            goto L_0x0099
        L_0x00de:
            r0 = move-exception
            r0 = r1
            goto L_0x0099
        L_0x00e1:
            r0 = move-exception
            r0 = r1
            r1 = r2
            goto L_0x0099
        L_0x00e5:
            r1 = move-exception
            r1 = r2
            goto L_0x0099
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzda.zza(java.io.File, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public static boolean zza(int i, zzaw zzaw) {
        if (i < 4) {
            if (zzaw == null) {
                return true;
            }
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzbmg)).booleanValue() && (zzaw.zzcq == null || zzaw.zzcq.equals("0000000000000000000000000000000000000000000000000000000000000000"))) {
                return true;
            }
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzbmh)).booleanValue() && (zzaw.zzfb == null || zzaw.zzfb.zzfz == null || zzaw.zzfb.zzfz.longValue() == -2)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void zzao() {
        try {
            if (this.zzail == null && this.zzaig != null) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zzaig);
                advertisingIdClient.start();
                this.zzail = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException e) {
            this.zzail = null;
        }
    }

    @VisibleForTesting
    private final zzaw zzap() {
        try {
            return zzcaj.zzn(this.zzaif, this.zzaif.getPackageName(), Integer.toString(this.zzaif.getPackageManager().getPackageInfo(this.zzaif.getPackageName(), 0).versionCode));
        } catch (Throwable th) {
            return null;
        }
    }

    private static void zzb(File file) {
        if (!file.exists()) {
            Log.d(TAG, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}));
            return;
        }
        file.delete();
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c9 A[SYNTHETIC, Splitter:B:42:0x00c9] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ce A[SYNTHETIC, Splitter:B:45:0x00ce] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d8 A[SYNTHETIC, Splitter:B:51:0x00d8] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00dd A[SYNTHETIC, Splitter:B:54:0x00dd] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzb(java.io.File r13, java.lang.String r14) {
        /*
            r12 = this;
            r3 = 0
            r7 = 2
            r1 = 1
            r2 = 0
            java.io.File r5 = new java.io.File
            java.lang.String r0 = "%s/%s.tmp"
            java.lang.Object[] r4 = new java.lang.Object[r7]
            r4[r2] = r13
            r4[r1] = r14
            java.lang.String r0 = java.lang.String.format(r0, r4)
            r5.<init>(r0)
            boolean r0 = r5.exists()
            if (r0 != 0) goto L_0x001d
            r0 = r2
        L_0x001c:
            return r0
        L_0x001d:
            java.io.File r6 = new java.io.File
            java.lang.String r0 = "%s/%s.dex"
            java.lang.Object[] r4 = new java.lang.Object[r7]
            r4[r2] = r13
            r4[r1] = r14
            java.lang.String r0 = java.lang.String.format(r0, r4)
            r6.<init>(r0)
            boolean r0 = r6.exists()
            if (r0 == 0) goto L_0x0036
            r0 = r2
            goto L_0x001c
        L_0x0036:
            long r8 = r5.length()     // Catch:{ IOException -> 0x010a, NoSuchAlgorithmException -> 0x00c4, zzcv -> 0x00ff, all -> 0x00d4 }
            r10 = 0
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 > 0) goto L_0x0045
            zzb(r5)     // Catch:{ IOException -> 0x010a, NoSuchAlgorithmException -> 0x00c4, zzcv -> 0x00ff, all -> 0x00d4 }
            r0 = r2
            goto L_0x001c
        L_0x0045:
            int r0 = (int) r8     // Catch:{ IOException -> 0x010a, NoSuchAlgorithmException -> 0x00c4, zzcv -> 0x00ff, all -> 0x00d4 }
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x010a, NoSuchAlgorithmException -> 0x00c4, zzcv -> 0x00ff, all -> 0x00d4 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x010a, NoSuchAlgorithmException -> 0x00c4, zzcv -> 0x00ff, all -> 0x00d4 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x010a, NoSuchAlgorithmException -> 0x00c4, zzcv -> 0x00ff, all -> 0x00d4 }
            int r7 = r4.read(r0)     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            if (r7 > 0) goto L_0x0062
            java.lang.String r0 = TAG     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            java.lang.String r1 = "Cannot read the cache data."
            android.util.Log.d(r0, r1)     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            zzb(r5)     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            r4.close()     // Catch:{ IOException -> 0x00e1 }
        L_0x0060:
            r0 = r2
            goto L_0x001c
        L_0x0062:
            com.google.android.gms.internal.zzba r7 = new com.google.android.gms.internal.zzba     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            r7.<init>()     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            com.google.android.gms.internal.zzfhs r0 = com.google.android.gms.internal.zzfhs.zza(r7, r0)     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            com.google.android.gms.internal.zzba r0 = (com.google.android.gms.internal.zzba) r0     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            java.lang.String r7 = new java.lang.String     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            byte[] r8 = r0.zzgf     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            r7.<init>(r8)     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            boolean r7 = r14.equals(r7)     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            if (r7 == 0) goto L_0x0096
            byte[] r7 = r0.zzge     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            byte[] r8 = r0.data     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            byte[] r8 = com.google.android.gms.internal.zzbt.zzb((byte[]) r8)     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            boolean r7 = java.util.Arrays.equals(r7, r8)     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            if (r7 == 0) goto L_0x0096
            byte[] r7 = r0.zzgg     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            java.lang.String r8 = android.os.Build.VERSION.SDK     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            byte[] r8 = r8.getBytes()     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            boolean r7 = java.util.Arrays.equals(r7, r8)     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            if (r7 != 0) goto L_0x009f
        L_0x0096:
            zzb(r5)     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            r4.close()     // Catch:{ IOException -> 0x00e4 }
        L_0x009c:
            r0 = r2
            goto L_0x001c
        L_0x009f:
            com.google.android.gms.internal.zzcu r5 = r12.zzaij     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            byte[] r7 = r12.zzaik     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            java.lang.String r8 = new java.lang.String     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            byte[] r0 = r0.data     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            r8.<init>(r0)     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            byte[] r5 = r5.zzb(r7, r8)     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            r6.createNewFile()     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            r0.<init>(r6)     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x00f8, zzcv -> 0x0103, all -> 0x00f2 }
            r3 = 0
            int r6 = r5.length     // Catch:{ IOException -> 0x0112, NoSuchAlgorithmException -> 0x00fc, zzcv -> 0x0107, all -> 0x00f4 }
            r0.write(r5, r3, r6)     // Catch:{ IOException -> 0x0112, NoSuchAlgorithmException -> 0x00fc, zzcv -> 0x0107, all -> 0x00f4 }
            r4.close()     // Catch:{ IOException -> 0x00e6 }
        L_0x00be:
            r0.close()     // Catch:{ IOException -> 0x00e8 }
        L_0x00c1:
            r0 = r1
            goto L_0x001c
        L_0x00c4:
            r0 = move-exception
            r0 = r3
            r1 = r3
        L_0x00c7:
            if (r1 == 0) goto L_0x00cc
            r1.close()     // Catch:{ IOException -> 0x00ea }
        L_0x00cc:
            if (r0 == 0) goto L_0x00d1
            r0.close()     // Catch:{ IOException -> 0x00ec }
        L_0x00d1:
            r0 = r2
            goto L_0x001c
        L_0x00d4:
            r0 = move-exception
            r4 = r3
        L_0x00d6:
            if (r4 == 0) goto L_0x00db
            r4.close()     // Catch:{ IOException -> 0x00ee }
        L_0x00db:
            if (r3 == 0) goto L_0x00e0
            r3.close()     // Catch:{ IOException -> 0x00f0 }
        L_0x00e0:
            throw r0
        L_0x00e1:
            r0 = move-exception
            goto L_0x0060
        L_0x00e4:
            r0 = move-exception
            goto L_0x009c
        L_0x00e6:
            r2 = move-exception
            goto L_0x00be
        L_0x00e8:
            r0 = move-exception
            goto L_0x00c1
        L_0x00ea:
            r1 = move-exception
            goto L_0x00cc
        L_0x00ec:
            r0 = move-exception
            goto L_0x00d1
        L_0x00ee:
            r1 = move-exception
            goto L_0x00db
        L_0x00f0:
            r1 = move-exception
            goto L_0x00e0
        L_0x00f2:
            r0 = move-exception
            goto L_0x00d6
        L_0x00f4:
            r1 = move-exception
            r3 = r0
            r0 = r1
            goto L_0x00d6
        L_0x00f8:
            r0 = move-exception
            r0 = r3
            r1 = r4
            goto L_0x00c7
        L_0x00fc:
            r1 = move-exception
            r1 = r4
            goto L_0x00c7
        L_0x00ff:
            r0 = move-exception
            r0 = r3
            r1 = r3
            goto L_0x00c7
        L_0x0103:
            r0 = move-exception
            r0 = r3
            r1 = r4
            goto L_0x00c7
        L_0x0107:
            r1 = move-exception
            r1 = r4
            goto L_0x00c7
        L_0x010a:
            r0 = move-exception
            r0 = r3
            r1 = r3
            goto L_0x00c7
        L_0x010e:
            r0 = move-exception
            r0 = r3
            r1 = r4
            goto L_0x00c7
        L_0x0112:
            r1 = move-exception
            r1 = r4
            goto L_0x00c7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzda.zzb(java.io.File, java.lang.String):boolean");
    }

    private static void zzl(String str) {
        zzb(new File(str));
    }

    public final Context getApplicationContext() {
        return this.zzaig;
    }

    public final Context getContext() {
        return this.zzaif;
    }

    public final boolean isInitialized() {
        return this.zzait;
    }

    public final Method zza(String str, String str2) {
        zzea zzea = this.zzais.get(new Pair(str, str2));
        if (zzea == null) {
            return null;
        }
        return zzea.zzay();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zza(int i, boolean z) {
        if (this.zzair) {
            Future<?> submit = this.zzaih.submit(new zzdc(this, i, z));
            if (i == 0) {
                this.zzaio = submit;
            }
        }
    }

    public final boolean zza(String str, String str2, Class<?>... clsArr) {
        if (this.zzais.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.zzais.put(new Pair(str, str2), new zzea(this, str, str2, clsArr));
        return true;
    }

    public final int zzaa() {
        if (this.zzaip != null) {
            return zzcm.zzaa();
        }
        return Integer.MIN_VALUE;
    }

    public final ExecutorService zzae() {
        return this.zzaih;
    }

    public final DexClassLoader zzaf() {
        return this.zzaii;
    }

    public final zzcu zzag() {
        return this.zzaij;
    }

    public final byte[] zzah() {
        return this.zzaik;
    }

    public final boolean zzai() {
        return this.zzaiq;
    }

    public final zzcm zzaj() {
        return this.zzaip;
    }

    public final boolean zzak() {
        return this.zzair;
    }

    public final boolean zzal() {
        return this.zzaiu;
    }

    public final zzaw zzam() {
        return this.zzain;
    }

    public final Future zzan() {
        return this.zzaio;
    }

    public final AdvertisingIdClient zzaq() {
        if (!this.zzahk) {
            return null;
        }
        if (this.zzail != null) {
            return this.zzail;
        }
        if (this.zzaim != null) {
            try {
                this.zzaim.get(2000, TimeUnit.MILLISECONDS);
                this.zzaim = null;
            } catch (InterruptedException | ExecutionException e) {
            } catch (TimeoutException e2) {
                this.zzaim.cancel(true);
            }
        }
        return this.zzail;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzaw zzb(int i, boolean z) {
        if (i > 0 && z) {
            try {
                Thread.sleep((long) (i * 1000));
            } catch (InterruptedException e) {
            }
        }
        return zzap();
    }
}
