package com.google.firebase.iid;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FirebaseInstanceId {
    private static Map<String, FirebaseInstanceId> zzicu = new ArrayMap();
    private static final long zznuj = TimeUnit.HOURS.toSeconds(8);
    private static zzj zznuk;
    private static ScheduledThreadPoolExecutor zznul;
    private final FirebaseApp zzmfu;
    private final zzi zznum;
    private final String zznun;
    private boolean zznuo = false;

    private FirebaseInstanceId(FirebaseApp firebaseApp, zzi zzi) {
        this.zzmfu = firebaseApp;
        this.zznum = zzi;
        String gcmSenderId = this.zzmfu.getOptions().getGcmSenderId();
        if (gcmSenderId == null) {
            gcmSenderId = this.zzmfu.getOptions().getApplicationId();
            if (gcmSenderId.startsWith("1:")) {
                String[] split = gcmSenderId.split(":");
                if (split.length < 2) {
                    gcmSenderId = null;
                } else {
                    gcmSenderId = split[1];
                    if (gcmSenderId.isEmpty()) {
                        gcmSenderId = null;
                    }
                }
            }
        }
        this.zznun = gcmSenderId;
        if (this.zznun == null) {
            throw new IllegalStateException("IID failing to initialize, FirebaseApp is missing project ID");
        }
        zzac zzcgy = zzcgy();
        if (zzcgy == null || zzcgy.zzqz(zzi.zzida) || zznuk.zzchg() != null) {
            startSync();
        }
    }

    public static FirebaseInstanceId getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(@NonNull FirebaseApp firebaseApp) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            firebaseInstanceId = zzicu.get(firebaseApp.getOptions().getApplicationId());
            if (firebaseInstanceId == null) {
                zzi zza = zzi.zza(firebaseApp.getApplicationContext(), (Bundle) null);
                if (zznuk == null) {
                    zznuk = new zzj(zzi.zzchc());
                }
                firebaseInstanceId = new FirebaseInstanceId(firebaseApp, zza);
                zzicu.put(firebaseApp.getOptions().getApplicationId(), firebaseInstanceId);
            }
        }
        return firebaseInstanceId;
    }

    static String zza(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) ((digest[0] & 15) + 112);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    private final void zzac(Bundle bundle) {
        bundle.putString("gmp_app_id", this.zzmfu.getOptions().getApplicationId());
    }

    static int zzam(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Failed to find package ").append(valueOf).toString());
            return 0;
        }
    }

    static void zzb(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (zznul == null) {
                zznul = new ScheduledThreadPoolExecutor(1);
            }
            zznul.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    static zzj zzcha() {
        return zznuk;
    }

    static boolean zzchb() {
        return Log.isLoggable("FirebaseInstanceId", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3));
    }

    static String zzdk(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return null;
        }
    }

    static int zzes(Context context) {
        return zzam(context, context.getPackageName());
    }

    static String zzn(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    @WorkerThread
    public void deleteInstanceId() throws IOException {
        this.zznum.zza("*", "*", (Bundle) null);
        this.zznum.zzauu();
    }

    @WorkerThread
    public void deleteToken(String str, String str2) throws IOException {
        Bundle bundle = new Bundle();
        zzac(bundle);
        this.zznum.zza(str, str2, bundle);
    }

    /* access modifiers changed from: package-private */
    public final FirebaseApp getApp() {
        return this.zzmfu;
    }

    public long getCreationTime() {
        return this.zznum.getCreationTime();
    }

    @WorkerThread
    public String getId() {
        return zza(this.zznum.zzaut());
    }

    @Nullable
    public String getToken() {
        zzac zzcgy = zzcgy();
        if (zzcgy == null || zzcgy.zzqz(zzi.zzida)) {
            startSync();
        }
        if (zzcgy != null) {
            return zzcgy.zzlax;
        }
        return null;
    }

    @WorkerThread
    public String getToken(String str, String str2) throws IOException {
        Bundle bundle = new Bundle();
        zzac(bundle);
        return this.zznum.getToken(str, str2, bundle);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void startSync() {
        if (!this.zznuo) {
            zzcb(0);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzcb(long j) {
        zzb(new zzad(this, Math.min(Math.max(30, j << 1), zznuj)), j);
        this.zznuo = true;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final zzac zzcgy() {
        return zzi.zzchc().zzo("", this.zznun, "*");
    }

    /* access modifiers changed from: package-private */
    public final String zzcgz() throws IOException {
        return getToken(this.zznun, "*");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzco(boolean z) {
        this.zznuo = z;
    }

    public final synchronized void zzqq(String str) {
        zznuk.zzqq(str);
        startSync();
    }

    /* access modifiers changed from: package-private */
    public final void zzqr(String str) throws IOException {
        zzac zzcgy = zzcgy();
        if (zzcgy == null || zzcgy.zzqz(zzi.zzida)) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString("gcm.topic", valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        String str2 = zzcgy.zzlax;
        String valueOf3 = String.valueOf("/topics/");
        String valueOf4 = String.valueOf(str);
        String concat = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
        zzac(bundle);
        this.zznum.zzb(str2, concat, bundle);
    }

    /* access modifiers changed from: package-private */
    public final void zzqs(String str) throws IOException {
        zzac zzcgy = zzcgy();
        if (zzcgy == null || zzcgy.zzqz(zzi.zzida)) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString("gcm.topic", valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        zzi zzi = this.zznum;
        String str2 = zzcgy.zzlax;
        String valueOf3 = String.valueOf("/topics/");
        String valueOf4 = String.valueOf(str);
        zzi.zza(str2, valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), bundle);
    }
}
