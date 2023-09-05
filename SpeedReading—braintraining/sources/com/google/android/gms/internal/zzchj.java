package com.google.android.gms.internal;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Pair;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.gms.common.api.internal.zzcc;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.common.zzo;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.safonov.speedreading.purchase.view.PurchaseActivity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public class zzchj {
    private static volatile zzchj zzjck;
    private final Context mContext;
    private final zzd zzasd;
    private boolean zzdqd = false;
    private final zzcfk zzjcl;
    private final zzcgu zzjcm;
    private final zzcgj zzjcn;
    private final zzche zzjco;
    private final zzckc zzjcp;
    private final zzchd zzjcq;
    private final AppMeasurement zzjcr;
    private final FirebaseAnalytics zzjcs;
    private final zzckn zzjct;
    private final zzcgh zzjcu;
    private final zzcfl zzjcv;
    private final zzcgf zzjcw;
    private final zzcgn zzjcx;
    private final zzciz zzjcy;
    private final zzcjd zzjcz;
    private final zzcfr zzjda;
    private final zzcik zzjdb;
    private final zzcge zzjdc;
    private final zzcgs zzjdd;
    private final zzcki zzjde;
    private final zzcfh zzjdf;
    private final zzcfa zzjdg;
    private boolean zzjdh;
    private Boolean zzjdi;
    private long zzjdj;
    private FileLock zzjdk;
    private FileChannel zzjdl;
    private List<Long> zzjdm;
    private List<Runnable> zzjdn;
    private int zzjdo;
    private int zzjdp;
    private long zzjdq;
    private long zzjdr;
    private boolean zzjds;
    private boolean zzjdt;
    private boolean zzjdu;
    private final long zzjdv;

    class zza implements zzcfn {
        List<zzcky> zzaof;
        zzclb zzjdx;
        List<Long> zzjdy;
        private long zzjdz;

        private zza() {
        }

        /* synthetic */ zza(zzchj zzchj, zzchk zzchk) {
            this();
        }

        private static long zza(zzcky zzcky) {
            return ((zzcky.zzjix.longValue() / 1000) / 60) / 60;
        }

        public final boolean zza(long j, zzcky zzcky) {
            zzbq.checkNotNull(zzcky);
            if (this.zzaof == null) {
                this.zzaof = new ArrayList();
            }
            if (this.zzjdy == null) {
                this.zzjdy = new ArrayList();
            }
            if (this.zzaof.size() > 0 && zza(this.zzaof.get(0)) != zza(zzcky)) {
                return false;
            }
            long zzhl = this.zzjdz + ((long) zzcky.zzhl());
            if (zzhl >= ((long) Math.max(0, zzcfz.zziya.get().intValue()))) {
                return false;
            }
            this.zzjdz = zzhl;
            this.zzaof.add(zzcky);
            this.zzjdy.add(Long.valueOf(j));
            return this.zzaof.size() < Math.max(1, zzcfz.zziyb.get().intValue());
        }

        public final void zzb(zzclb zzclb) {
            zzbq.checkNotNull(zzclb);
            this.zzjdx = zzclb;
        }
    }

    private zzchj(zzcij zzcij) {
        zzbq.checkNotNull(zzcij);
        this.mContext = zzcij.mContext;
        this.zzjdq = -1;
        this.zzasd = zzh.zzalv();
        this.zzjdv = this.zzasd.currentTimeMillis();
        this.zzjcl = new zzcfk(this);
        zzcgu zzcgu = new zzcgu(this);
        zzcgu.initialize();
        this.zzjcm = zzcgu;
        zzcgj zzcgj = new zzcgj(this);
        zzcgj.initialize();
        this.zzjcn = zzcgj;
        zzckn zzckn = new zzckn(this);
        zzckn.initialize();
        this.zzjct = zzckn;
        zzcgh zzcgh = new zzcgh(this);
        zzcgh.initialize();
        this.zzjcu = zzcgh;
        zzcfr zzcfr = new zzcfr(this);
        zzcfr.initialize();
        this.zzjda = zzcfr;
        zzcge zzcge = new zzcge(this);
        zzcge.initialize();
        this.zzjdc = zzcge;
        zzcfl zzcfl = new zzcfl(this);
        zzcfl.initialize();
        this.zzjcv = zzcfl;
        zzcgf zzcgf = new zzcgf(this);
        zzcgf.initialize();
        this.zzjcw = zzcgf;
        zzcfh zzcfh = new zzcfh(this);
        zzcfh.initialize();
        this.zzjdf = zzcfh;
        this.zzjdg = new zzcfa(this);
        zzcgn zzcgn = new zzcgn(this);
        zzcgn.initialize();
        this.zzjcx = zzcgn;
        zzciz zzciz = new zzciz(this);
        zzciz.initialize();
        this.zzjcy = zzciz;
        zzcjd zzcjd = new zzcjd(this);
        zzcjd.initialize();
        this.zzjcz = zzcjd;
        zzcik zzcik = new zzcik(this);
        zzcik.initialize();
        this.zzjdb = zzcik;
        zzcki zzcki = new zzcki(this);
        zzcki.initialize();
        this.zzjde = zzcki;
        this.zzjdd = new zzcgs(this);
        this.zzjcr = new AppMeasurement(this);
        this.zzjcs = new FirebaseAnalytics(this);
        zzckc zzckc = new zzckc(this);
        zzckc.initialize();
        this.zzjcp = zzckc;
        zzchd zzchd = new zzchd(this);
        zzchd.initialize();
        this.zzjcq = zzchd;
        zzche zzche = new zzche(this);
        zzche.initialize();
        this.zzjco = zzche;
        if (this.mContext.getApplicationContext() instanceof Application) {
            zzcik zzawb = zzawb();
            if (zzawb.getContext().getApplicationContext() instanceof Application) {
                Application application = (Application) zzawb.getContext().getApplicationContext();
                if (zzawb.zzjem == null) {
                    zzawb.zzjem = new zzciy(zzawb, (zzcil) null);
                }
                application.unregisterActivityLifecycleCallbacks(zzawb.zzjem);
                application.registerActivityLifecycleCallbacks(zzawb.zzjem);
                zzawb.zzawn().zzayy().log("Registered activity lifecycle callback");
            }
        } else {
            zzawn().zzayu().log("Application context is not an Application");
        }
        this.zzjco.zzg(new zzchk(this));
    }

    @WorkerThread
    private final int zza(FileChannel fileChannel) {
        zzawm().zzut();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzawn().zzays().log("Bad chanel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read == 4) {
                allocate.flip();
                return allocate.getInt();
            } else if (read == -1) {
                return 0;
            } else {
                zzawn().zzayu().zzj("Unexpected data length. Bytes read", Integer.valueOf(read));
                return 0;
            }
        } catch (IOException e) {
            zzawn().zzays().zzj("Failed to read from channel", e);
            return 0;
        }
    }

    private final zzcff zza(Context context, String str, String str2, boolean z, boolean z2) {
        String str3;
        String str4 = "Unknown";
        String str5 = "Unknown";
        int i = Integer.MIN_VALUE;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            zzawn().zzays().log("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str4 = packageManager.getInstallerPackageName(str);
        } catch (IllegalArgumentException e) {
            zzawn().zzays().zzj("Error retrieving installer package name. appId", zzcgj.zzjf(str));
        }
        if (str4 == null) {
            str4 = "manual_install";
        } else if (zzo.GOOGLE_PLAY_STORE_PACKAGE.equals(str4)) {
            str4 = "";
        }
        try {
            PackageInfo packageInfo = zzbgc.zzcy(context).getPackageInfo(str, 0);
            if (packageInfo != null) {
                CharSequence zzgp = zzbgc.zzcy(context).zzgp(str);
                str3 = !TextUtils.isEmpty(zzgp) ? zzgp.toString() : "Unknown";
                try {
                    str5 = packageInfo.versionName;
                    i = packageInfo.versionCode;
                } catch (PackageManager.NameNotFoundException e2) {
                    zzawn().zzays().zze("Error retrieving newly installed package info. appId, appName", zzcgj.zzjf(str), str3);
                    return null;
                }
            }
            return new zzcff(str, str2, str5, (long) i, str4, 11717, zzawj().zzaf(context, str), (String) null, z, false, "", 0, 0, 0, z2);
        } catch (PackageManager.NameNotFoundException e3) {
            str3 = "Unknown";
            zzawn().zzays().zze("Error retrieving newly installed package info. appId, appName", zzcgj.zzjf(str), str3);
            return null;
        }
    }

    private static void zza(zzcih zzcih) {
        if (zzcih == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static void zza(zzcii zzcii) {
        if (zzcii == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzcii.isInitialized()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    @WorkerThread
    private final boolean zza(int i, FileChannel fileChannel) {
        zzawm().zzut();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzawn().zzays().log("Bad chanel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() == 4) {
                return true;
            }
            zzawn().zzays().zzj("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            return true;
        } catch (IOException e) {
            zzawn().zzays().zzj("Failed to write to channel", e);
            return false;
        }
    }

    private static boolean zza(zzcky zzcky, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return false;
        }
        for (zzckz zzckz : zzcky.zzjiw) {
            if (str.equals(zzckz.name)) {
                return ((obj instanceof Long) && obj.equals(zzckz.zzjja)) || ((obj instanceof String) && obj.equals(zzckz.zzfzs)) || ((obj instanceof Double) && obj.equals(zzckz.zzjha));
            }
        }
        return false;
    }

    private final boolean zza(String str, zzcfx zzcfx) {
        long longValue;
        zzckm zzckm;
        String string = zzcfx.zzixi.getString(FirebaseAnalytics.Param.CURRENCY);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(zzcfx.name)) {
            double doubleValue = zzcfx.zzixi.getDouble(FirebaseAnalytics.Param.VALUE).doubleValue() * 1000000.0d;
            if (doubleValue == Utils.DOUBLE_EPSILON) {
                doubleValue = ((double) zzcfx.zzixi.getLong(FirebaseAnalytics.Param.VALUE).longValue()) * 1000000.0d;
            }
            if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d) {
                zzawn().zzayu().zze("Data lost. Currency value is too big. appId", zzcgj.zzjf(str), Double.valueOf(doubleValue));
                return false;
            }
            longValue = Math.round(doubleValue);
        } else {
            longValue = zzcfx.zzixi.getLong(FirebaseAnalytics.Param.VALUE).longValue();
        }
        if (!TextUtils.isEmpty(string)) {
            String upperCase = string.toUpperCase(Locale.US);
            if (upperCase.matches("[A-Z]{3}")) {
                String valueOf = String.valueOf("_ltv_");
                String valueOf2 = String.valueOf(upperCase);
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                zzckm zzag = zzawh().zzag(str, concat);
                if (zzag == null || !(zzag.mValue instanceof Long)) {
                    zzcfl zzawh = zzawh();
                    int zzb = this.zzjcl.zzb(str, zzcfz.zziyw) - 1;
                    zzbq.zzgi(str);
                    zzawh.zzut();
                    zzawh.zzwu();
                    try {
                        zzawh.getWritableDatabase().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(zzb)});
                    } catch (SQLiteException e) {
                        zzawh.zzawn().zzays().zze("Error pruning currencies. appId", zzcgj.zzjf(str), e);
                    }
                    zzckm = new zzckm(str, zzcfx.zzivu, concat, this.zzasd.currentTimeMillis(), Long.valueOf(longValue));
                } else {
                    zzckm = new zzckm(str, zzcfx.zzivu, concat, this.zzasd.currentTimeMillis(), Long.valueOf(longValue + ((Long) zzag.mValue).longValue()));
                }
                if (!zzawh().zza(zzckm)) {
                    zzawn().zzays().zzd("Too many unique user properties are set. Ignoring user property. appId", zzcgj.zzjf(str), zzawi().zzje(zzckm.mName), zzckm.mValue);
                    zzawj().zza(str, 9, (String) null, (String) null, 0);
                }
            }
        }
        return true;
    }

    private final zzckx[] zza(String str, zzcld[] zzcldArr, zzcky[] zzckyArr) {
        zzbq.zzgi(str);
        return zzawa().zza(str, zzckyArr, zzcldArr);
    }

    static void zzavx() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzazl() {
        zzcgl zzayw;
        String concat;
        zzawm().zzut();
        this.zzjct.zzazl();
        this.zzjcm.zzazl();
        this.zzjdc.zzazl();
        zzawn().zzayw().zzj("App measurement is starting up, version", 11717L);
        zzawn().zzayw().log("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String appId = this.zzjdc.getAppId();
        if (zzawj().zzke(appId)) {
            zzayw = zzawn().zzayw();
            concat = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
        } else {
            zzayw = zzawn().zzayw();
            String valueOf = String.valueOf(appId);
            concat = valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
        }
        zzayw.log(concat);
        zzawn().zzayx().log("Debug-level message logging enabled");
        if (this.zzjdo != this.zzjdp) {
            zzawn().zzays().zze("Not all components initialized", Integer.valueOf(this.zzjdo), Integer.valueOf(this.zzjdp));
        }
        this.zzdqd = true;
    }

    private final zzcgs zzazr() {
        if (this.zzjdd != null) {
            return this.zzjdd;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzcki zzazs() {
        zza((zzcii) this.zzjde);
        return this.zzjde;
    }

    @WorkerThread
    private final boolean zzazt() {
        zzawm().zzut();
        try {
            this.zzjdl = new RandomAccessFile(new File(this.mContext.getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzjdk = this.zzjdl.tryLock();
            if (this.zzjdk != null) {
                zzawn().zzayy().log("Storage concurrent access okay");
                return true;
            }
            zzawn().zzays().log("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            zzawn().zzays().zzj("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            zzawn().zzays().zzj("Failed to access storage lock file", e2);
        }
    }

    private final long zzazv() {
        long currentTimeMillis = this.zzasd.currentTimeMillis();
        zzcgu zzawo = zzawo();
        zzawo.zzwu();
        zzawo.zzut();
        long j = zzawo.zzjak.get();
        if (j == 0) {
            j = 1 + ((long) zzawo.zzawj().zzbao().nextInt(86400000));
            zzawo.zzjak.set(j);
        }
        return ((((j + currentTimeMillis) / 1000) / 60) / 60) / 24;
    }

    private final boolean zzazx() {
        zzawm().zzut();
        zzwu();
        return zzawh().zzaxz() || !TextUtils.isEmpty(zzawh().zzaxu());
    }

    @WorkerThread
    private final void zzazy() {
        long max;
        long j;
        zzawm().zzut();
        zzwu();
        if (zzbab()) {
            if (this.zzjdr > 0) {
                long abs = 3600000 - Math.abs(this.zzasd.elapsedRealtime() - this.zzjdr);
                if (abs > 0) {
                    zzawn().zzayy().zzj("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                    zzazr().unregister();
                    zzazs().cancel();
                    return;
                }
                this.zzjdr = 0;
            }
            if (!zzazk() || !zzazx()) {
                zzawn().zzayy().log("Nothing to upload or uploading impossible");
                zzazr().unregister();
                zzazs().cancel();
                return;
            }
            long currentTimeMillis = this.zzasd.currentTimeMillis();
            long max2 = Math.max(0, zzcfz.zziys.get().longValue());
            boolean z = zzawh().zzaya() || zzawh().zzaxv();
            if (z) {
                String zzaxs = this.zzjcl.zzaxs();
                max = (TextUtils.isEmpty(zzaxs) || ".none.".equals(zzaxs)) ? Math.max(0, zzcfz.zziym.get().longValue()) : Math.max(0, zzcfz.zziyn.get().longValue());
            } else {
                max = Math.max(0, zzcfz.zziyl.get().longValue());
            }
            long j2 = zzawo().zzjag.get();
            long j3 = zzawo().zzjah.get();
            long max3 = Math.max(zzawh().zzaxx(), zzawh().zzaxy());
            if (max3 == 0) {
                j = 0;
            } else {
                long abs2 = currentTimeMillis - Math.abs(max3 - currentTimeMillis);
                long abs3 = currentTimeMillis - Math.abs(j3 - currentTimeMillis);
                long max4 = Math.max(currentTimeMillis - Math.abs(j2 - currentTimeMillis), abs3);
                j = abs2 + max2;
                if (z && max4 > 0) {
                    j = Math.min(abs2, max4) + max;
                }
                if (!zzawj().zzf(max4, max)) {
                    j = max4 + max;
                }
                if (abs3 != 0 && abs3 >= abs2) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= Math.min(20, Math.max(0, zzcfz.zziyu.get().intValue()))) {
                            j = 0;
                            break;
                        }
                        j += (1 << i2) * Math.max(0, zzcfz.zziyt.get().longValue());
                        if (j > abs3) {
                            break;
                        }
                        i = i2 + 1;
                    }
                }
            }
            if (j == 0) {
                zzawn().zzayy().log("Next upload time is 0");
                zzazr().unregister();
                zzazs().cancel();
            } else if (!zzazq().zzzh()) {
                zzawn().zzayy().log("No network");
                zzazr().zzze();
                zzazs().cancel();
            } else {
                long j4 = zzawo().zzjai.get();
                long max5 = Math.max(0, zzcfz.zziyj.get().longValue());
                long max6 = !zzawj().zzf(j4, max5) ? Math.max(j, max5 + j4) : j;
                zzazr().unregister();
                long currentTimeMillis2 = max6 - this.zzasd.currentTimeMillis();
                if (currentTimeMillis2 <= 0) {
                    currentTimeMillis2 = Math.max(0, zzcfz.zziyo.get().longValue());
                    zzawo().zzjag.set(this.zzasd.currentTimeMillis());
                }
                zzawn().zzayy().zzj("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
                zzazs().zzr(currentTimeMillis2);
            }
        }
    }

    @WorkerThread
    private final void zzb(zzcfe zzcfe) {
        ArrayMap arrayMap;
        zzawm().zzut();
        if (TextUtils.isEmpty(zzcfe.getGmpAppId())) {
            zzb(zzcfe.getAppId(), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
            return;
        }
        String gmpAppId = zzcfe.getGmpAppId();
        String appInstanceId = zzcfe.getAppInstanceId();
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder encodedAuthority = builder.scheme(zzcfz.zzixw.get()).encodedAuthority(zzcfz.zzixx.get());
        String valueOf = String.valueOf(gmpAppId);
        encodedAuthority.path(valueOf.length() != 0 ? "config/app/".concat(valueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", appInstanceId).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", "11717");
        String uri = builder.build().toString();
        try {
            URL url = new URL(uri);
            zzawn().zzayy().zzj("Fetching remote configuration", zzcfe.getAppId());
            zzckv zzjn = zzawk().zzjn(zzcfe.getAppId());
            String zzjo = zzawk().zzjo(zzcfe.getAppId());
            if (zzjn == null || TextUtils.isEmpty(zzjo)) {
                arrayMap = null;
            } else {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put("If-Modified-Since", zzjo);
                arrayMap = arrayMap2;
            }
            this.zzjds = true;
            zzcgn zzazq = zzazq();
            String appId = zzcfe.getAppId();
            zzchn zzchn = new zzchn(this);
            zzazq.zzut();
            zzazq.zzwu();
            zzbq.checkNotNull(url);
            zzbq.checkNotNull(zzchn);
            zzazq.zzawm().zzh(new zzcgr(zzazq, appId, url, (byte[]) null, arrayMap, zzchn));
        } catch (MalformedURLException e) {
            zzawn().zzays().zze("Failed to parse config URL. Not fetching. appId", zzcgj.zzjf(zzcfe.getAppId()), uri);
        }
    }

    @WorkerThread
    private final boolean zzbab() {
        zzawm().zzut();
        zzwu();
        return this.zzjdh;
    }

    @WorkerThread
    private final void zzbac() {
        zzawm().zzut();
        if (this.zzjds || this.zzjdt || this.zzjdu) {
            zzawn().zzayy().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzjds), Boolean.valueOf(this.zzjdt), Boolean.valueOf(this.zzjdu));
            return;
        }
        zzawn().zzayy().log("Stopping uploading service(s)");
        if (this.zzjdn != null) {
            for (Runnable run : this.zzjdn) {
                run.run();
            }
            this.zzjdn.clear();
        }
    }

    @WorkerThread
    private final void zzc(zzcfx zzcfx, zzcff zzcff) {
        zzcft zzba;
        zzcfs zzcfs;
        zzclb zzclb;
        boolean z;
        zzcfe zziw;
        zzbq.checkNotNull(zzcff);
        zzbq.zzgi(zzcff.packageName);
        long nanoTime = System.nanoTime();
        zzawm().zzut();
        zzwu();
        String str = zzcff.packageName;
        zzawj();
        if (zzckn.zzd(zzcfx, zzcff)) {
            if (!zzcff.zzivm) {
                zzg(zzcff);
            } else if (zzawk().zzan(str, zzcfx.name)) {
                zzawn().zzayu().zze("Dropping blacklisted event. appId", zzcgj.zzjf(str), zzawi().zzjc(zzcfx.name));
                boolean z2 = zzawj().zzkg(str) || zzawj().zzkh(str);
                if (!z2 && !"_err".equals(zzcfx.name)) {
                    zzawj().zza(str, 11, "_ev", zzcfx.name, 0);
                }
                if (z2 && (zziw = zzawh().zziw(str)) != null) {
                    if (Math.abs(this.zzasd.currentTimeMillis() - Math.max(zziw.zzaxc(), zziw.zzaxb())) > zzcfz.zziyr.get().longValue()) {
                        zzawn().zzayx().log("Fetching config for blacklisted app");
                        zzb(zziw);
                    }
                }
            } else {
                if (zzawn().zzae(2)) {
                    zzawn().zzayy().zzj("Logging event", zzawi().zzb(zzcfx));
                }
                zzawh().beginTransaction();
                try {
                    zzg(zzcff);
                    if (("_iap".equals(zzcfx.name) || FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(zzcfx.name)) && !zza(str, zzcfx)) {
                        zzawh().setTransactionSuccessful();
                        zzawh().endTransaction();
                        return;
                    }
                    boolean zzju = zzckn.zzju(zzcfx.name);
                    boolean equals = "_err".equals(zzcfx.name);
                    zzcfm zza2 = zzawh().zza(zzazv(), str, true, zzju, false, equals, false);
                    long intValue = zza2.zziwn - ((long) zzcfz.zziyc.get().intValue());
                    if (intValue > 0) {
                        if (intValue % 1000 == 1) {
                            zzawn().zzays().zze("Data loss. Too many events logged. appId, count", zzcgj.zzjf(str), Long.valueOf(zza2.zziwn));
                        }
                        zzawh().setTransactionSuccessful();
                        zzawh().endTransaction();
                        return;
                    }
                    if (zzju) {
                        long intValue2 = zza2.zziwm - ((long) zzcfz.zziye.get().intValue());
                        if (intValue2 > 0) {
                            if (intValue2 % 1000 == 1) {
                                zzawn().zzays().zze("Data loss. Too many public events logged. appId, count", zzcgj.zzjf(str), Long.valueOf(zza2.zziwm));
                            }
                            zzawj().zza(str, 16, "_ev", zzcfx.name, 0);
                            zzawh().setTransactionSuccessful();
                            zzawh().endTransaction();
                            return;
                        }
                    }
                    if (equals) {
                        long max = zza2.zziwp - ((long) Math.max(0, Math.min(PurchaseActivity.ONE_CURRENCY_UNIT, this.zzjcl.zzb(zzcff.packageName, zzcfz.zziyd))));
                        if (max > 0) {
                            if (max == 1) {
                                zzawn().zzays().zze("Too many error events logged. appId, count", zzcgj.zzjf(str), Long.valueOf(zza2.zziwp));
                            }
                            zzawh().setTransactionSuccessful();
                            zzawh().endTransaction();
                            return;
                        }
                    }
                    Bundle zzaym = zzcfx.zzixi.zzaym();
                    zzawj().zza(zzaym, "_o", (Object) zzcfx.zzivu);
                    if (zzawj().zzke(str)) {
                        zzawj().zza(zzaym, "_dbg", (Object) 1L);
                        zzawj().zza(zzaym, "_r", (Object) 1L);
                    }
                    long zzix = zzawh().zzix(str);
                    if (zzix > 0) {
                        zzawn().zzayu().zze("Data lost. Too many events stored on disk, deleted. appId", zzcgj.zzjf(str), Long.valueOf(zzix));
                    }
                    zzcfs zzcfs2 = new zzcfs(this, zzcfx.zzivu, str, zzcfx.name, zzcfx.zzixj, 0, zzaym);
                    zzcft zzae = zzawh().zzae(str, zzcfs2.mName);
                    if (zzae != null) {
                        zzcfs zza3 = zzcfs2.zza(this, zzae.zzixb);
                        zzba = zzae.zzba(zza3.zzfgb);
                        zzcfs = zza3;
                    } else if (zzawh().zzja(str) < 500 || !zzju) {
                        zzba = new zzcft(str, zzcfs2.mName, 0, 0, zzcfs2.zzfgb, 0, (Long) null, (Long) null, (Boolean) null);
                        zzcfs = zzcfs2;
                    } else {
                        zzawn().zzays().zzd("Too many event names used, ignoring event. appId, name, supported count", zzcgj.zzjf(str), zzawi().zzjc(zzcfs2.mName), 500);
                        zzawj().zza(str, 8, (String) null, (String) null, 0);
                        zzawh().endTransaction();
                        return;
                    }
                    zzawh().zza(zzba);
                    zzawm().zzut();
                    zzwu();
                    zzbq.checkNotNull(zzcfs);
                    zzbq.checkNotNull(zzcff);
                    zzbq.zzgi(zzcfs.mAppId);
                    zzbq.checkArgument(zzcfs.mAppId.equals(zzcff.packageName));
                    zzclb = new zzclb();
                    zzclb.zzjjd = 1;
                    zzclb.zzjjl = "android";
                    zzclb.zzch = zzcff.packageName;
                    zzclb.zzivi = zzcff.zzivi;
                    zzclb.zzida = zzcff.zzida;
                    zzclb.zzjjy = zzcff.zzivo == -2147483648L ? null : Integer.valueOf((int) zzcff.zzivo);
                    zzclb.zzjjp = Long.valueOf(zzcff.zzivj);
                    zzclb.zzivh = zzcff.zzivh;
                    zzclb.zzjju = zzcff.zzivk == 0 ? null : Long.valueOf(zzcff.zzivk);
                    Pair<String, Boolean> zzjh = zzawo().zzjh(zzcff.packageName);
                    if (zzjh == null || TextUtils.isEmpty((CharSequence) zzjh.first)) {
                        if (!zzawd().zzdt(this.mContext)) {
                            String string = Settings.Secure.getString(this.mContext.getContentResolver(), "android_id");
                            if (string == null) {
                                zzawn().zzayu().zzj("null secure ID. appId", zzcgj.zzjf(zzclb.zzch));
                                string = "null";
                            } else if (string.isEmpty()) {
                                zzawn().zzayu().zzj("empty secure ID. appId", zzcgj.zzjf(zzclb.zzch));
                            }
                            zzclb.zzjkb = string;
                        }
                    } else if (zzcff.zzivt) {
                        zzclb.zzjjr = (String) zzjh.first;
                        zzclb.zzjjs = (Boolean) zzjh.second;
                    }
                    zzawd().zzwu();
                    zzclb.zzjjm = Build.MODEL;
                    zzawd().zzwu();
                    zzclb.zzcv = Build.VERSION.RELEASE;
                    zzclb.zzjjo = Integer.valueOf((int) zzawd().zzayj());
                    zzclb.zzjjn = zzawd().zzayk();
                    zzclb.zzjjq = null;
                    zzclb.zzjjg = null;
                    zzclb.zzjjh = null;
                    zzclb.zzjji = null;
                    zzclb.zzfib = Long.valueOf(zzcff.zzivq);
                    if (isEnabled() && zzcfk.zzaxt()) {
                        zzawc();
                        zzclb.zzjkd = null;
                    }
                    zzcfe zziw2 = zzawh().zziw(zzcff.packageName);
                    if (zziw2 == null) {
                        zziw2 = new zzcfe(this, zzcff.packageName);
                        zziw2.zzim(zzawc().zzayo());
                        zziw2.zzip(zzcff.zzivp);
                        zziw2.zzin(zzcff.zzivh);
                        zziw2.zzio(zzawo().zzji(zzcff.packageName));
                        zziw2.zzap(0);
                        zziw2.zzak(0);
                        zziw2.zzal(0);
                        zziw2.setAppVersion(zzcff.zzida);
                        zziw2.zzam(zzcff.zzivo);
                        zziw2.zziq(zzcff.zzivi);
                        zziw2.zzan(zzcff.zzivj);
                        zziw2.zzao(zzcff.zzivk);
                        zziw2.setMeasurementEnabled(zzcff.zzivm);
                        zziw2.zzay(zzcff.zzivq);
                        zzawh().zza(zziw2);
                    }
                    zzclb.zzjjt = zziw2.getAppInstanceId();
                    zzclb.zzivp = zziw2.zzaws();
                    List<zzckm> zziv = zzawh().zziv(zzcff.packageName);
                    zzclb.zzjjf = new zzcld[zziv.size()];
                    for (int i = 0; i < zziv.size(); i++) {
                        zzcld zzcld = new zzcld();
                        zzclb.zzjjf[i] = zzcld;
                        zzcld.name = zziv.get(i).mName;
                        zzcld.zzjkh = Long.valueOf(zziv.get(i).zzjhb);
                        zzawj().zza(zzcld, zziv.get(i).mValue);
                    }
                    long zza4 = zzawh().zza(zzclb);
                    zzcfl zzawh = zzawh();
                    if (zzcfs.zziwy != null) {
                        Iterator<String> it = zzcfs.zziwy.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if ("_r".equals(it.next())) {
                                    z = true;
                                    break;
                                }
                            } else {
                                boolean zzao = zzawk().zzao(zzcfs.mAppId, zzcfs.mName);
                                zzcfm zza5 = zzawh().zza(zzazv(), zzcfs.mAppId, false, false, false, false, false);
                                if (zzao) {
                                    if (zza5.zziwq < ((long) this.zzjcl.zzis(zzcfs.mAppId))) {
                                        z = true;
                                    }
                                }
                            }
                        }
                    }
                    z = false;
                    if (zzawh.zza(zzcfs, zza4, z)) {
                        this.zzjdr = 0;
                    }
                    zzawh().setTransactionSuccessful();
                    if (zzawn().zzae(2)) {
                        zzawn().zzayy().zzj("Event recorded", zzawi().zza(zzcfs));
                    }
                    zzawh().endTransaction();
                    zzazy();
                    zzawn().zzayy().zzj("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                } catch (IOException e) {
                    zzawn().zzays().zze("Data loss. Failed to insert raw event metadata. appId", zzcgj.zzjf(zzclb.zzch), e);
                } catch (Throwable th) {
                    zzawh().endTransaction();
                    throw th;
                }
            }
        }
    }

    public static zzchj zzdu(Context context) {
        zzbq.checkNotNull(context);
        zzbq.checkNotNull(context.getApplicationContext());
        if (zzjck == null) {
            synchronized (zzchj.class) {
                if (zzjck == null) {
                    zzjck = new zzchj(new zzcij(context));
                }
            }
        }
        return zzjck;
    }

    @WorkerThread
    private final void zzg(zzcff zzcff) {
        boolean z = true;
        zzawm().zzut();
        zzwu();
        zzbq.checkNotNull(zzcff);
        zzbq.zzgi(zzcff.packageName);
        zzcfe zziw = zzawh().zziw(zzcff.packageName);
        String zzji = zzawo().zzji(zzcff.packageName);
        boolean z2 = false;
        if (zziw == null) {
            zzcfe zzcfe = new zzcfe(this, zzcff.packageName);
            zzcfe.zzim(zzawc().zzayo());
            zzcfe.zzio(zzji);
            zziw = zzcfe;
            z2 = true;
        } else if (!zzji.equals(zziw.zzawr())) {
            zziw.zzio(zzji);
            zziw.zzim(zzawc().zzayo());
            z2 = true;
        }
        if (!TextUtils.isEmpty(zzcff.zzivh) && !zzcff.zzivh.equals(zziw.getGmpAppId())) {
            zziw.zzin(zzcff.zzivh);
            z2 = true;
        }
        if (!TextUtils.isEmpty(zzcff.zzivp) && !zzcff.zzivp.equals(zziw.zzaws())) {
            zziw.zzip(zzcff.zzivp);
            z2 = true;
        }
        if (!(zzcff.zzivj == 0 || zzcff.zzivj == zziw.zzawx())) {
            zziw.zzan(zzcff.zzivj);
            z2 = true;
        }
        if (!TextUtils.isEmpty(zzcff.zzida) && !zzcff.zzida.equals(zziw.zzuy())) {
            zziw.setAppVersion(zzcff.zzida);
            z2 = true;
        }
        if (zzcff.zzivo != zziw.zzawv()) {
            zziw.zzam(zzcff.zzivo);
            z2 = true;
        }
        if (zzcff.zzivi != null && !zzcff.zzivi.equals(zziw.zzaww())) {
            zziw.zziq(zzcff.zzivi);
            z2 = true;
        }
        if (zzcff.zzivk != zziw.zzawy()) {
            zziw.zzao(zzcff.zzivk);
            z2 = true;
        }
        if (zzcff.zzivm != zziw.zzawz()) {
            zziw.setMeasurementEnabled(zzcff.zzivm);
            z2 = true;
        }
        if (!TextUtils.isEmpty(zzcff.zzivl) && !zzcff.zzivl.equals(zziw.zzaxk())) {
            zziw.zzir(zzcff.zzivl);
            z2 = true;
        }
        if (zzcff.zzivq != zziw.zzaxm()) {
            zziw.zzay(zzcff.zzivq);
            z2 = true;
        }
        if (zzcff.zzivt != zziw.zzaxn()) {
            zziw.zzbk(zzcff.zzivt);
        } else {
            z = z2;
        }
        if (z) {
            zzawh().zza(zziw);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:141:0x038f, code lost:
        if (com.google.android.gms.internal.zzckn.zzki(r0.zzaof.get(r13).name) != false) goto L_0x0391;
     */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0356 A[Catch:{ IOException -> 0x02bb, all -> 0x01be }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x035a A[Catch:{ IOException -> 0x02bb, all -> 0x01be }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0093 A[Catch:{ IOException -> 0x02bb, all -> 0x01be }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0096 A[Catch:{ IOException -> 0x02bb, all -> 0x01be }] */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0aaa A[Catch:{ IOException -> 0x02bb, all -> 0x01be }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzh(java.lang.String r31, long r32) {
        /*
            r30 = this;
            com.google.android.gms.internal.zzcfl r2 = r30.zzawh()
            r2.beginTransaction()
            com.google.android.gms.internal.zzchj$zza r21 = new com.google.android.gms.internal.zzchj$zza     // Catch:{ all -> 0x01be }
            r2 = 0
            r0 = r21
            r1 = r30
            r0.<init>(r1, r2)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcfl r14 = r30.zzawh()     // Catch:{ all -> 0x01be }
            r4 = 0
            r0 = r30
            long r0 = r0.zzjdq     // Catch:{ all -> 0x01be }
            r16 = r0
            com.google.android.gms.common.internal.zzbq.checkNotNull(r21)     // Catch:{ all -> 0x01be }
            r14.zzut()     // Catch:{ all -> 0x01be }
            r14.zzwu()     // Catch:{ all -> 0x01be }
            r3 = 0
            android.database.sqlite.SQLiteDatabase r2 = r14.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0abf }
            r5 = 0
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ SQLiteException -> 0x0abf }
            if (r5 == 0) goto L_0x01c7
            r6 = -1
            int r5 = (r16 > r6 ? 1 : (r16 == r6 ? 0 : -1))
            if (r5 == 0) goto L_0x0160
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0abf }
            r6 = 0
            java.lang.String r7 = java.lang.String.valueOf(r16)     // Catch:{ SQLiteException -> 0x0abf }
            r5[r6] = r7     // Catch:{ SQLiteException -> 0x0abf }
            r6 = 1
            java.lang.String r7 = java.lang.String.valueOf(r32)     // Catch:{ SQLiteException -> 0x0abf }
            r5[r6] = r7     // Catch:{ SQLiteException -> 0x0abf }
            r6 = r5
        L_0x0049:
            r8 = -1
            int r5 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1))
            if (r5 == 0) goto L_0x016d
            java.lang.String r5 = "rowid <= ? and "
        L_0x0051:
            java.lang.String r7 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0abf }
            int r7 = r7.length()     // Catch:{ SQLiteException -> 0x0abf }
            int r7 = r7 + 148
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0abf }
            r8.<init>(r7)     // Catch:{ SQLiteException -> 0x0abf }
            java.lang.String r7 = "select app_id, metadata_fingerprint from raw_events where "
            java.lang.StringBuilder r7 = r8.append(r7)     // Catch:{ SQLiteException -> 0x0abf }
            java.lang.StringBuilder r5 = r7.append(r5)     // Catch:{ SQLiteException -> 0x0abf }
            java.lang.String r7 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            java.lang.StringBuilder r5 = r5.append(r7)     // Catch:{ SQLiteException -> 0x0abf }
            java.lang.String r5 = r5.toString()     // Catch:{ SQLiteException -> 0x0abf }
            android.database.Cursor r3 = r2.rawQuery(r5, r6)     // Catch:{ SQLiteException -> 0x0abf }
            boolean r5 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0abf }
            if (r5 != 0) goto L_0x0171
            if (r3 == 0) goto L_0x0083
            r3.close()     // Catch:{ all -> 0x01be }
        L_0x0083:
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            if (r2 == 0) goto L_0x0093
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x01be }
            if (r2 == 0) goto L_0x035a
        L_0x0093:
            r2 = 1
        L_0x0094:
            if (r2 != 0) goto L_0x0aaa
            r17 = 0
            r0 = r21
            com.google.android.gms.internal.zzclb r0 = r0.zzjdx     // Catch:{ all -> 0x01be }
            r22 = r0
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            int r2 = r2.size()     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky[] r2 = new com.google.android.gms.internal.zzcky[r2]     // Catch:{ all -> 0x01be }
            r0 = r22
            r0.zzjje = r2     // Catch:{ all -> 0x01be }
            r12 = 0
            r2 = 0
            r13 = r2
        L_0x00af:
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            int r2 = r2.size()     // Catch:{ all -> 0x01be }
            if (r13 >= r2) goto L_0x0613
            com.google.android.gms.internal.zzchd r3 = r30.zzawk()     // Catch:{ all -> 0x01be }
            r0 = r21
            com.google.android.gms.internal.zzclb r2 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r4 = r2.zzch     // Catch:{ all -> 0x01be }
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky r2 = (com.google.android.gms.internal.zzcky) r2     // Catch:{ all -> 0x01be }
            java.lang.String r2 = r2.name     // Catch:{ all -> 0x01be }
            boolean r2 = r3.zzan(r4, r2)     // Catch:{ all -> 0x01be }
            if (r2 == 0) goto L_0x0360
            com.google.android.gms.internal.zzcgj r2 = r30.zzawn()     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcgl r3 = r2.zzayu()     // Catch:{ all -> 0x01be }
            java.lang.String r4 = "Dropping blacklisted raw event. appId"
            r0 = r21
            com.google.android.gms.internal.zzclb r2 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r2 = r2.zzch     // Catch:{ all -> 0x01be }
            java.lang.Object r5 = com.google.android.gms.internal.zzcgj.zzjf(r2)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcgh r6 = r30.zzawi()     // Catch:{ all -> 0x01be }
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky r2 = (com.google.android.gms.internal.zzcky) r2     // Catch:{ all -> 0x01be }
            java.lang.String r2 = r2.name     // Catch:{ all -> 0x01be }
            java.lang.String r2 = r6.zzjc(r2)     // Catch:{ all -> 0x01be }
            r3.zze(r4, r5, r2)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzckn r2 = r30.zzawj()     // Catch:{ all -> 0x01be }
            r0 = r21
            com.google.android.gms.internal.zzclb r3 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r3 = r3.zzch     // Catch:{ all -> 0x01be }
            boolean r2 = r2.zzkg(r3)     // Catch:{ all -> 0x01be }
            if (r2 != 0) goto L_0x0120
            com.google.android.gms.internal.zzckn r2 = r30.zzawj()     // Catch:{ all -> 0x01be }
            r0 = r21
            com.google.android.gms.internal.zzclb r3 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r3 = r3.zzch     // Catch:{ all -> 0x01be }
            boolean r2 = r2.zzkh(r3)     // Catch:{ all -> 0x01be }
            if (r2 == 0) goto L_0x035d
        L_0x0120:
            r2 = 1
        L_0x0121:
            if (r2 != 0) goto L_0x0adb
            java.lang.String r3 = "_err"
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky r2 = (com.google.android.gms.internal.zzcky) r2     // Catch:{ all -> 0x01be }
            java.lang.String r2 = r2.name     // Catch:{ all -> 0x01be }
            boolean r2 = r3.equals(r2)     // Catch:{ all -> 0x01be }
            if (r2 != 0) goto L_0x0adb
            com.google.android.gms.internal.zzckn r2 = r30.zzawj()     // Catch:{ all -> 0x01be }
            r0 = r21
            com.google.android.gms.internal.zzclb r3 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r3 = r3.zzch     // Catch:{ all -> 0x01be }
            r4 = 11
            java.lang.String r5 = "_ev"
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r6 = r0.zzaof     // Catch:{ all -> 0x01be }
            java.lang.Object r6 = r6.get(r13)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky r6 = (com.google.android.gms.internal.zzcky) r6     // Catch:{ all -> 0x01be }
            java.lang.String r6 = r6.name     // Catch:{ all -> 0x01be }
            r7 = 0
            r2.zza((java.lang.String) r3, (int) r4, (java.lang.String) r5, (java.lang.String) r6, (int) r7)     // Catch:{ all -> 0x01be }
            r2 = r12
            r3 = r17
        L_0x0158:
            int r4 = r13 + 1
            r13 = r4
            r12 = r2
            r17 = r3
            goto L_0x00af
        L_0x0160:
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0abf }
            r6 = 0
            java.lang.String r7 = java.lang.String.valueOf(r32)     // Catch:{ SQLiteException -> 0x0abf }
            r5[r6] = r7     // Catch:{ SQLiteException -> 0x0abf }
            r6 = r5
            goto L_0x0049
        L_0x016d:
            java.lang.String r5 = ""
            goto L_0x0051
        L_0x0171:
            r5 = 0
            java.lang.String r4 = r3.getString(r5)     // Catch:{ SQLiteException -> 0x0abf }
            r5 = 1
            java.lang.String r5 = r3.getString(r5)     // Catch:{ SQLiteException -> 0x0abf }
            r3.close()     // Catch:{ SQLiteException -> 0x0abf }
            r13 = r5
            r11 = r3
            r12 = r4
        L_0x0181:
            java.lang.String r3 = "raw_events_metadata"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r5 = 0
            java.lang.String r6 = "metadata"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            java.lang.String r5 = "app_id = ? and metadata_fingerprint = ?"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r7 = 0
            r6[r7] = r12     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r7 = 1
            r6[r7] = r13     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "2"
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            boolean r3 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            if (r3 != 0) goto L_0x0231
            com.google.android.gms.internal.zzcgj r2 = r14.zzawn()     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            com.google.android.gms.internal.zzcgl r2 = r2.zzays()     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            java.lang.String r3 = "Raw event metadata record is missing. appId"
            java.lang.Object r4 = com.google.android.gms.internal.zzcgj.zzjf(r12)     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r2.zzj(r3, r4)     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            if (r11 == 0) goto L_0x0083
            r11.close()     // Catch:{ all -> 0x01be }
            goto L_0x0083
        L_0x01be:
            r2 = move-exception
            com.google.android.gms.internal.zzcfl r3 = r30.zzawh()
            r3.endTransaction()
            throw r2
        L_0x01c7:
            r6 = -1
            int r5 = (r16 > r6 ? 1 : (r16 == r6 ? 0 : -1))
            if (r5 == 0) goto L_0x0218
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0abf }
            r6 = 0
            r7 = 0
            r5[r6] = r7     // Catch:{ SQLiteException -> 0x0abf }
            r6 = 1
            java.lang.String r7 = java.lang.String.valueOf(r16)     // Catch:{ SQLiteException -> 0x0abf }
            r5[r6] = r7     // Catch:{ SQLiteException -> 0x0abf }
            r6 = r5
        L_0x01dc:
            r8 = -1
            int r5 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1))
            if (r5 == 0) goto L_0x0221
            java.lang.String r5 = " and rowid <= ?"
        L_0x01e4:
            java.lang.String r7 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0abf }
            int r7 = r7.length()     // Catch:{ SQLiteException -> 0x0abf }
            int r7 = r7 + 84
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0abf }
            r8.<init>(r7)     // Catch:{ SQLiteException -> 0x0abf }
            java.lang.String r7 = "select metadata_fingerprint from raw_events where app_id = ?"
            java.lang.StringBuilder r7 = r8.append(r7)     // Catch:{ SQLiteException -> 0x0abf }
            java.lang.StringBuilder r5 = r7.append(r5)     // Catch:{ SQLiteException -> 0x0abf }
            java.lang.String r7 = " order by rowid limit 1;"
            java.lang.StringBuilder r5 = r5.append(r7)     // Catch:{ SQLiteException -> 0x0abf }
            java.lang.String r5 = r5.toString()     // Catch:{ SQLiteException -> 0x0abf }
            android.database.Cursor r3 = r2.rawQuery(r5, r6)     // Catch:{ SQLiteException -> 0x0abf }
            boolean r5 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0abf }
            if (r5 != 0) goto L_0x0224
            if (r3 == 0) goto L_0x0083
            r3.close()     // Catch:{ all -> 0x01be }
            goto L_0x0083
        L_0x0218:
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0abf }
            r6 = 0
            r7 = 0
            r5[r6] = r7     // Catch:{ SQLiteException -> 0x0abf }
            r6 = r5
            goto L_0x01dc
        L_0x0221:
            java.lang.String r5 = ""
            goto L_0x01e4
        L_0x0224:
            r5 = 0
            java.lang.String r5 = r3.getString(r5)     // Catch:{ SQLiteException -> 0x0abf }
            r3.close()     // Catch:{ SQLiteException -> 0x0abf }
            r13 = r5
            r11 = r3
            r12 = r4
            goto L_0x0181
        L_0x0231:
            r3 = 0
            byte[] r3 = r11.getBlob(r3)     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r4 = 0
            int r5 = r3.length     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            com.google.android.gms.internal.zzfhj r3 = com.google.android.gms.internal.zzfhj.zzn(r3, r4, r5)     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            com.google.android.gms.internal.zzclb r4 = new com.google.android.gms.internal.zzclb     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r4.<init>()     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r4.zza((com.google.android.gms.internal.zzfhj) r3)     // Catch:{ IOException -> 0x02bb }
            boolean r3 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            if (r3 == 0) goto L_0x025b
            com.google.android.gms.internal.zzcgj r3 = r14.zzawn()     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            com.google.android.gms.internal.zzcgl r3 = r3.zzayu()     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            java.lang.String r5 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r6 = com.google.android.gms.internal.zzcgj.zzjf(r12)     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r3.zzj(r5, r6)     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
        L_0x025b:
            r11.close()     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r0 = r21
            r0.zzb(r4)     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r4 = -1
            int r3 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x02d4
            java.lang.String r5 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            r3 = 3
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r3 = 0
            r6[r3] = r12     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r3 = 1
            r6[r3] = r13     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r3 = 2
            java.lang.String r4 = java.lang.String.valueOf(r16)     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r6[r3] = r4     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
        L_0x027b:
            java.lang.String r3 = "raw_events"
            r4 = 4
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r7 = 0
            java.lang.String r8 = "rowid"
            r4[r7] = r8     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r7 = 1
            java.lang.String r8 = "name"
            r4[r7] = r8     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r7 = 2
            java.lang.String r8 = "timestamp"
            r4[r7] = r8     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r7 = 3
            java.lang.String r8 = "data"
            r4[r7] = r8     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            r10 = 0
            android.database.Cursor r3 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            boolean r2 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0ac2 }
            if (r2 != 0) goto L_0x02fb
            com.google.android.gms.internal.zzcgj r2 = r14.zzawn()     // Catch:{ SQLiteException -> 0x0ac2 }
            com.google.android.gms.internal.zzcgl r2 = r2.zzayu()     // Catch:{ SQLiteException -> 0x0ac2 }
            java.lang.String r4 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r5 = com.google.android.gms.internal.zzcgj.zzjf(r12)     // Catch:{ SQLiteException -> 0x0ac2 }
            r2.zzj(r4, r5)     // Catch:{ SQLiteException -> 0x0ac2 }
            if (r3 == 0) goto L_0x0083
            r3.close()     // Catch:{ all -> 0x01be }
            goto L_0x0083
        L_0x02bb:
            r2 = move-exception
            com.google.android.gms.internal.zzcgj r3 = r14.zzawn()     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            com.google.android.gms.internal.zzcgl r3 = r3.zzays()     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            java.lang.String r4 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r5 = com.google.android.gms.internal.zzcgj.zzjf(r12)     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r3.zze(r4, r5, r2)     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            if (r11 == 0) goto L_0x0083
            r11.close()     // Catch:{ all -> 0x01be }
            goto L_0x0083
        L_0x02d4:
            java.lang.String r5 = "app_id = ? and metadata_fingerprint = ?"
            r3 = 2
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r3 = 0
            r6[r3] = r12     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            r3 = 1
            r6[r3] = r13     // Catch:{ SQLiteException -> 0x02e0, all -> 0x0abb }
            goto L_0x027b
        L_0x02e0:
            r2 = move-exception
            r3 = r11
            r4 = r12
        L_0x02e3:
            com.google.android.gms.internal.zzcgj r5 = r14.zzawn()     // Catch:{ all -> 0x0353 }
            com.google.android.gms.internal.zzcgl r5 = r5.zzays()     // Catch:{ all -> 0x0353 }
            java.lang.String r6 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r4 = com.google.android.gms.internal.zzcgj.zzjf(r4)     // Catch:{ all -> 0x0353 }
            r5.zze(r6, r4, r2)     // Catch:{ all -> 0x0353 }
            if (r3 == 0) goto L_0x0083
            r3.close()     // Catch:{ all -> 0x01be }
            goto L_0x0083
        L_0x02fb:
            r2 = 0
            long r4 = r3.getLong(r2)     // Catch:{ SQLiteException -> 0x0ac2 }
            r2 = 3
            byte[] r2 = r3.getBlob(r2)     // Catch:{ SQLiteException -> 0x0ac2 }
            r6 = 0
            int r7 = r2.length     // Catch:{ SQLiteException -> 0x0ac2 }
            com.google.android.gms.internal.zzfhj r2 = com.google.android.gms.internal.zzfhj.zzn(r2, r6, r7)     // Catch:{ SQLiteException -> 0x0ac2 }
            com.google.android.gms.internal.zzcky r6 = new com.google.android.gms.internal.zzcky     // Catch:{ SQLiteException -> 0x0ac2 }
            r6.<init>()     // Catch:{ SQLiteException -> 0x0ac2 }
            r6.zza((com.google.android.gms.internal.zzfhj) r2)     // Catch:{ IOException -> 0x0334 }
            r2 = 1
            java.lang.String r2 = r3.getString(r2)     // Catch:{ SQLiteException -> 0x0ac2 }
            r6.name = r2     // Catch:{ SQLiteException -> 0x0ac2 }
            r2 = 2
            long r8 = r3.getLong(r2)     // Catch:{ SQLiteException -> 0x0ac2 }
            java.lang.Long r2 = java.lang.Long.valueOf(r8)     // Catch:{ SQLiteException -> 0x0ac2 }
            r6.zzjix = r2     // Catch:{ SQLiteException -> 0x0ac2 }
            r0 = r21
            boolean r2 = r0.zza(r4, r6)     // Catch:{ SQLiteException -> 0x0ac2 }
            if (r2 != 0) goto L_0x0346
            if (r3 == 0) goto L_0x0083
            r3.close()     // Catch:{ all -> 0x01be }
            goto L_0x0083
        L_0x0334:
            r2 = move-exception
            com.google.android.gms.internal.zzcgj r4 = r14.zzawn()     // Catch:{ SQLiteException -> 0x0ac2 }
            com.google.android.gms.internal.zzcgl r4 = r4.zzays()     // Catch:{ SQLiteException -> 0x0ac2 }
            java.lang.String r5 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r6 = com.google.android.gms.internal.zzcgj.zzjf(r12)     // Catch:{ SQLiteException -> 0x0ac2 }
            r4.zze(r5, r6, r2)     // Catch:{ SQLiteException -> 0x0ac2 }
        L_0x0346:
            boolean r2 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x0ac2 }
            if (r2 != 0) goto L_0x02fb
            if (r3 == 0) goto L_0x0083
            r3.close()     // Catch:{ all -> 0x01be }
            goto L_0x0083
        L_0x0353:
            r2 = move-exception
        L_0x0354:
            if (r3 == 0) goto L_0x0359
            r3.close()     // Catch:{ all -> 0x01be }
        L_0x0359:
            throw r2     // Catch:{ all -> 0x01be }
        L_0x035a:
            r2 = 0
            goto L_0x0094
        L_0x035d:
            r2 = 0
            goto L_0x0121
        L_0x0360:
            com.google.android.gms.internal.zzchd r3 = r30.zzawk()     // Catch:{ all -> 0x01be }
            r0 = r21
            com.google.android.gms.internal.zzclb r2 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r4 = r2.zzch     // Catch:{ all -> 0x01be }
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky r2 = (com.google.android.gms.internal.zzcky) r2     // Catch:{ all -> 0x01be }
            java.lang.String r2 = r2.name     // Catch:{ all -> 0x01be }
            boolean r14 = r3.zzao(r4, r2)     // Catch:{ all -> 0x01be }
            if (r14 != 0) goto L_0x0391
            r30.zzawj()     // Catch:{ all -> 0x01be }
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky r2 = (com.google.android.gms.internal.zzcky) r2     // Catch:{ all -> 0x01be }
            java.lang.String r2 = r2.name     // Catch:{ all -> 0x01be }
            boolean r2 = com.google.android.gms.internal.zzckn.zzki(r2)     // Catch:{ all -> 0x01be }
            if (r2 == 0) goto L_0x0610
        L_0x0391:
            r3 = 0
            r4 = 0
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky r2 = (com.google.android.gms.internal.zzcky) r2     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzckz[] r2 = r2.zzjiw     // Catch:{ all -> 0x01be }
            if (r2 != 0) goto L_0x03b0
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky r2 = (com.google.android.gms.internal.zzcky) r2     // Catch:{ all -> 0x01be }
            r5 = 0
            com.google.android.gms.internal.zzckz[] r5 = new com.google.android.gms.internal.zzckz[r5]     // Catch:{ all -> 0x01be }
            r2.zzjiw = r5     // Catch:{ all -> 0x01be }
        L_0x03b0:
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky r2 = (com.google.android.gms.internal.zzcky) r2     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzckz[] r6 = r2.zzjiw     // Catch:{ all -> 0x01be }
            int r7 = r6.length     // Catch:{ all -> 0x01be }
            r2 = 0
            r5 = r2
        L_0x03bf:
            if (r5 >= r7) goto L_0x03f1
            r2 = r6[r5]     // Catch:{ all -> 0x01be }
            java.lang.String r8 = "_c"
            java.lang.String r9 = r2.name     // Catch:{ all -> 0x01be }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x01be }
            if (r8 == 0) goto L_0x03dd
            r8 = 1
            java.lang.Long r3 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x01be }
            r2.zzjja = r3     // Catch:{ all -> 0x01be }
            r2 = 1
            r3 = r2
            r2 = r4
        L_0x03d8:
            int r4 = r5 + 1
            r5 = r4
            r4 = r2
            goto L_0x03bf
        L_0x03dd:
            java.lang.String r8 = "_r"
            java.lang.String r9 = r2.name     // Catch:{ all -> 0x01be }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x01be }
            if (r8 == 0) goto L_0x0ad8
            r8 = 1
            java.lang.Long r4 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x01be }
            r2.zzjja = r4     // Catch:{ all -> 0x01be }
            r2 = 1
            goto L_0x03d8
        L_0x03f1:
            if (r3 != 0) goto L_0x0459
            if (r14 == 0) goto L_0x0459
            com.google.android.gms.internal.zzcgj r2 = r30.zzawn()     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcgl r3 = r2.zzayy()     // Catch:{ all -> 0x01be }
            java.lang.String r5 = "Marking event as conversion"
            com.google.android.gms.internal.zzcgh r6 = r30.zzawi()     // Catch:{ all -> 0x01be }
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky r2 = (com.google.android.gms.internal.zzcky) r2     // Catch:{ all -> 0x01be }
            java.lang.String r2 = r2.name     // Catch:{ all -> 0x01be }
            java.lang.String r2 = r6.zzjc(r2)     // Catch:{ all -> 0x01be }
            r3.zzj(r5, r2)     // Catch:{ all -> 0x01be }
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky r2 = (com.google.android.gms.internal.zzcky) r2     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzckz[] r3 = r2.zzjiw     // Catch:{ all -> 0x01be }
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky r2 = (com.google.android.gms.internal.zzcky) r2     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzckz[] r2 = r2.zzjiw     // Catch:{ all -> 0x01be }
            int r2 = r2.length     // Catch:{ all -> 0x01be }
            int r2 = r2 + 1
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r3, r2)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzckz[] r2 = (com.google.android.gms.internal.zzckz[]) r2     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzckz r3 = new com.google.android.gms.internal.zzckz     // Catch:{ all -> 0x01be }
            r3.<init>()     // Catch:{ all -> 0x01be }
            java.lang.String r5 = "_c"
            r3.name = r5     // Catch:{ all -> 0x01be }
            r6 = 1
            java.lang.Long r5 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x01be }
            r3.zzjja = r5     // Catch:{ all -> 0x01be }
            int r5 = r2.length     // Catch:{ all -> 0x01be }
            int r5 = r5 + -1
            r2[r5] = r3     // Catch:{ all -> 0x01be }
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r3 = r0.zzaof     // Catch:{ all -> 0x01be }
            java.lang.Object r3 = r3.get(r13)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky r3 = (com.google.android.gms.internal.zzcky) r3     // Catch:{ all -> 0x01be }
            r3.zzjiw = r2     // Catch:{ all -> 0x01be }
        L_0x0459:
            if (r4 != 0) goto L_0x04bf
            com.google.android.gms.internal.zzcgj r2 = r30.zzawn()     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcgl r3 = r2.zzayy()     // Catch:{ all -> 0x01be }
            java.lang.String r4 = "Marking event as real-time"
            com.google.android.gms.internal.zzcgh r5 = r30.zzawi()     // Catch:{ all -> 0x01be }
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky r2 = (com.google.android.gms.internal.zzcky) r2     // Catch:{ all -> 0x01be }
            java.lang.String r2 = r2.name     // Catch:{ all -> 0x01be }
            java.lang.String r2 = r5.zzjc(r2)     // Catch:{ all -> 0x01be }
            r3.zzj(r4, r2)     // Catch:{ all -> 0x01be }
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky r2 = (com.google.android.gms.internal.zzcky) r2     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzckz[] r3 = r2.zzjiw     // Catch:{ all -> 0x01be }
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky r2 = (com.google.android.gms.internal.zzcky) r2     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzckz[] r2 = r2.zzjiw     // Catch:{ all -> 0x01be }
            int r2 = r2.length     // Catch:{ all -> 0x01be }
            int r2 = r2 + 1
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r3, r2)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzckz[] r2 = (com.google.android.gms.internal.zzckz[]) r2     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzckz r3 = new com.google.android.gms.internal.zzckz     // Catch:{ all -> 0x01be }
            r3.<init>()     // Catch:{ all -> 0x01be }
            java.lang.String r4 = "_r"
            r3.name = r4     // Catch:{ all -> 0x01be }
            r4 = 1
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x01be }
            r3.zzjja = r4     // Catch:{ all -> 0x01be }
            int r4 = r2.length     // Catch:{ all -> 0x01be }
            int r4 = r4 + -1
            r2[r4] = r3     // Catch:{ all -> 0x01be }
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r3 = r0.zzaof     // Catch:{ all -> 0x01be }
            java.lang.Object r3 = r3.get(r13)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky r3 = (com.google.android.gms.internal.zzcky) r3     // Catch:{ all -> 0x01be }
            r3.zzjiw = r2     // Catch:{ all -> 0x01be }
        L_0x04bf:
            r2 = 1
            com.google.android.gms.internal.zzcfl r3 = r30.zzawh()     // Catch:{ all -> 0x01be }
            long r4 = r30.zzazv()     // Catch:{ all -> 0x01be }
            r0 = r21
            com.google.android.gms.internal.zzclb r6 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r6 = r6.zzch     // Catch:{ all -> 0x01be }
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 1
            com.google.android.gms.internal.zzcfm r3 = r3.zza(r4, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x01be }
            long r4 = r3.zziwq     // Catch:{ all -> 0x01be }
            r0 = r30
            com.google.android.gms.internal.zzcfk r3 = r0.zzjcl     // Catch:{ all -> 0x01be }
            r0 = r21
            com.google.android.gms.internal.zzclb r6 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r6 = r6.zzch     // Catch:{ all -> 0x01be }
            int r3 = r3.zzis(r6)     // Catch:{ all -> 0x01be }
            long r6 = (long) r3     // Catch:{ all -> 0x01be }
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x0ad4
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky r2 = (com.google.android.gms.internal.zzcky) r2     // Catch:{ all -> 0x01be }
            r3 = 0
        L_0x04f7:
            com.google.android.gms.internal.zzckz[] r4 = r2.zzjiw     // Catch:{ all -> 0x01be }
            int r4 = r4.length     // Catch:{ all -> 0x01be }
            if (r3 >= r4) goto L_0x0528
            java.lang.String r4 = "_r"
            com.google.android.gms.internal.zzckz[] r5 = r2.zzjiw     // Catch:{ all -> 0x01be }
            r5 = r5[r3]     // Catch:{ all -> 0x01be }
            java.lang.String r5 = r5.name     // Catch:{ all -> 0x01be }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x01be }
            if (r4 == 0) goto L_0x05a7
            com.google.android.gms.internal.zzckz[] r4 = r2.zzjiw     // Catch:{ all -> 0x01be }
            int r4 = r4.length     // Catch:{ all -> 0x01be }
            int r4 = r4 + -1
            com.google.android.gms.internal.zzckz[] r4 = new com.google.android.gms.internal.zzckz[r4]     // Catch:{ all -> 0x01be }
            if (r3 <= 0) goto L_0x051a
            com.google.android.gms.internal.zzckz[] r5 = r2.zzjiw     // Catch:{ all -> 0x01be }
            r6 = 0
            r7 = 0
            java.lang.System.arraycopy(r5, r6, r4, r7, r3)     // Catch:{ all -> 0x01be }
        L_0x051a:
            int r5 = r4.length     // Catch:{ all -> 0x01be }
            if (r3 >= r5) goto L_0x0526
            com.google.android.gms.internal.zzckz[] r5 = r2.zzjiw     // Catch:{ all -> 0x01be }
            int r6 = r3 + 1
            int r7 = r4.length     // Catch:{ all -> 0x01be }
            int r7 = r7 - r3
            java.lang.System.arraycopy(r5, r6, r4, r3, r7)     // Catch:{ all -> 0x01be }
        L_0x0526:
            r2.zzjiw = r4     // Catch:{ all -> 0x01be }
        L_0x0528:
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky r2 = (com.google.android.gms.internal.zzcky) r2     // Catch:{ all -> 0x01be }
            java.lang.String r2 = r2.name     // Catch:{ all -> 0x01be }
            boolean r2 = com.google.android.gms.internal.zzckn.zzju(r2)     // Catch:{ all -> 0x01be }
            if (r2 == 0) goto L_0x0610
            if (r14 == 0) goto L_0x0610
            com.google.android.gms.internal.zzcfl r3 = r30.zzawh()     // Catch:{ all -> 0x01be }
            long r4 = r30.zzazv()     // Catch:{ all -> 0x01be }
            r0 = r21
            com.google.android.gms.internal.zzclb r2 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r6 = r2.zzch     // Catch:{ all -> 0x01be }
            r7 = 0
            r8 = 0
            r9 = 1
            r10 = 0
            r11 = 0
            com.google.android.gms.internal.zzcfm r2 = r3.zza(r4, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x01be }
            long r2 = r2.zziwo     // Catch:{ all -> 0x01be }
            r0 = r30
            com.google.android.gms.internal.zzcfk r4 = r0.zzjcl     // Catch:{ all -> 0x01be }
            r0 = r21
            com.google.android.gms.internal.zzclb r5 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r5 = r5.zzch     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcga<java.lang.Integer> r6 = com.google.android.gms.internal.zzcfz.zziyf     // Catch:{ all -> 0x01be }
            int r4 = r4.zzb(r5, r6)     // Catch:{ all -> 0x01be }
            long r4 = (long) r4     // Catch:{ all -> 0x01be }
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x0610
            com.google.android.gms.internal.zzcgj r2 = r30.zzawn()     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcgl r2 = r2.zzayu()     // Catch:{ all -> 0x01be }
            java.lang.String r3 = "Too many conversions. Not logging as conversion. appId"
            r0 = r21
            com.google.android.gms.internal.zzclb r4 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r4 = r4.zzch     // Catch:{ all -> 0x01be }
            java.lang.Object r4 = com.google.android.gms.internal.zzcgj.zzjf(r4)     // Catch:{ all -> 0x01be }
            r2.zzj(r3, r4)     // Catch:{ all -> 0x01be }
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky r2 = (com.google.android.gms.internal.zzcky) r2     // Catch:{ all -> 0x01be }
            r5 = 0
            r4 = 0
            com.google.android.gms.internal.zzckz[] r7 = r2.zzjiw     // Catch:{ all -> 0x01be }
            int r8 = r7.length     // Catch:{ all -> 0x01be }
            r3 = 0
            r6 = r3
        L_0x0592:
            if (r6 >= r8) goto L_0x05bc
            r3 = r7[r6]     // Catch:{ all -> 0x01be }
            java.lang.String r9 = "_c"
            java.lang.String r10 = r3.name     // Catch:{ all -> 0x01be }
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x01be }
            if (r9 == 0) goto L_0x05ab
            r4 = r5
        L_0x05a1:
            int r5 = r6 + 1
            r6 = r5
            r5 = r4
            r4 = r3
            goto L_0x0592
        L_0x05a7:
            int r3 = r3 + 1
            goto L_0x04f7
        L_0x05ab:
            java.lang.String r9 = "_err"
            java.lang.String r3 = r3.name     // Catch:{ all -> 0x01be }
            boolean r3 = r9.equals(r3)     // Catch:{ all -> 0x01be }
            if (r3 == 0) goto L_0x0ad0
            r3 = 1
            r29 = r4
            r4 = r3
            r3 = r29
            goto L_0x05a1
        L_0x05bc:
            if (r5 == 0) goto L_0x05e8
            if (r4 == 0) goto L_0x05e8
            com.google.android.gms.internal.zzckz[] r3 = r2.zzjiw     // Catch:{ all -> 0x01be }
            r5 = 1
            com.google.android.gms.internal.zzckz[] r5 = new com.google.android.gms.internal.zzckz[r5]     // Catch:{ all -> 0x01be }
            r6 = 0
            r5[r6] = r4     // Catch:{ all -> 0x01be }
            java.lang.Object[] r3 = com.google.android.gms.common.util.zza.zza((T[]) r3, (T[]) r5)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzckz[] r3 = (com.google.android.gms.internal.zzckz[]) r3     // Catch:{ all -> 0x01be }
            r2.zzjiw = r3     // Catch:{ all -> 0x01be }
            r4 = r17
        L_0x05d2:
            r0 = r22
            com.google.android.gms.internal.zzcky[] r5 = r0.zzjje     // Catch:{ all -> 0x01be }
            int r3 = r12 + 1
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky r2 = (com.google.android.gms.internal.zzcky) r2     // Catch:{ all -> 0x01be }
            r5[r12] = r2     // Catch:{ all -> 0x01be }
            r2 = r3
            r3 = r4
            goto L_0x0158
        L_0x05e8:
            if (r4 == 0) goto L_0x05f9
            java.lang.String r2 = "_err"
            r4.name = r2     // Catch:{ all -> 0x01be }
            r2 = 10
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x01be }
            r4.zzjja = r2     // Catch:{ all -> 0x01be }
            r4 = r17
            goto L_0x05d2
        L_0x05f9:
            com.google.android.gms.internal.zzcgj r2 = r30.zzawn()     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcgl r2 = r2.zzays()     // Catch:{ all -> 0x01be }
            java.lang.String r3 = "Did not find conversion parameter. appId"
            r0 = r21
            com.google.android.gms.internal.zzclb r4 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r4 = r4.zzch     // Catch:{ all -> 0x01be }
            java.lang.Object r4 = com.google.android.gms.internal.zzcgj.zzjf(r4)     // Catch:{ all -> 0x01be }
            r2.zzj(r3, r4)     // Catch:{ all -> 0x01be }
        L_0x0610:
            r4 = r17
            goto L_0x05d2
        L_0x0613:
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzcky> r2 = r0.zzaof     // Catch:{ all -> 0x01be }
            int r2 = r2.size()     // Catch:{ all -> 0x01be }
            if (r12 >= r2) goto L_0x062b
            r0 = r22
            com.google.android.gms.internal.zzcky[] r2 = r0.zzjje     // Catch:{ all -> 0x01be }
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r12)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky[] r2 = (com.google.android.gms.internal.zzcky[]) r2     // Catch:{ all -> 0x01be }
            r0 = r22
            r0.zzjje = r2     // Catch:{ all -> 0x01be }
        L_0x062b:
            r0 = r21
            com.google.android.gms.internal.zzclb r2 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r2 = r2.zzch     // Catch:{ all -> 0x01be }
            r0 = r21
            com.google.android.gms.internal.zzclb r3 = r0.zzjdx     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcld[] r3 = r3.zzjjf     // Catch:{ all -> 0x01be }
            r0 = r22
            com.google.android.gms.internal.zzcky[] r4 = r0.zzjje     // Catch:{ all -> 0x01be }
            r0 = r30
            com.google.android.gms.internal.zzckx[] r2 = r0.zza((java.lang.String) r2, (com.google.android.gms.internal.zzcld[]) r3, (com.google.android.gms.internal.zzcky[]) r4)     // Catch:{ all -> 0x01be }
            r0 = r22
            r0.zzjjx = r2     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcga<java.lang.Boolean> r2 = com.google.android.gms.internal.zzcfz.zzixr     // Catch:{ all -> 0x01be }
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x01be }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x01be }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x01be }
            if (r2 == 0) goto L_0x091d
            r0 = r30
            com.google.android.gms.internal.zzcfk r2 = r0.zzjcl     // Catch:{ all -> 0x01be }
            r0 = r21
            com.google.android.gms.internal.zzclb r3 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r3 = r3.zzch     // Catch:{ all -> 0x01be }
            java.lang.String r4 = "1"
            com.google.android.gms.internal.zzchd r2 = r2.zzawk()     // Catch:{ all -> 0x01be }
            java.lang.String r5 = "measurement.event_sampling_enabled"
            java.lang.String r2 = r2.zzam(r3, r5)     // Catch:{ all -> 0x01be }
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x01be }
            if (r2 == 0) goto L_0x091d
            java.util.HashMap r23 = new java.util.HashMap     // Catch:{ all -> 0x01be }
            r23.<init>()     // Catch:{ all -> 0x01be }
            r0 = r22
            com.google.android.gms.internal.zzcky[] r2 = r0.zzjje     // Catch:{ all -> 0x01be }
            int r2 = r2.length     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky[] r0 = new com.google.android.gms.internal.zzcky[r2]     // Catch:{ all -> 0x01be }
            r24 = r0
            r18 = 0
            com.google.android.gms.internal.zzckn r2 = r30.zzawj()     // Catch:{ all -> 0x01be }
            java.security.SecureRandom r25 = r2.zzbao()     // Catch:{ all -> 0x01be }
            r0 = r22
            com.google.android.gms.internal.zzcky[] r0 = r0.zzjje     // Catch:{ all -> 0x01be }
            r26 = r0
            r0 = r26
            int r0 = r0.length     // Catch:{ all -> 0x01be }
            r27 = r0
            r2 = 0
            r20 = r2
        L_0x0695:
            r0 = r20
            r1 = r27
            if (r0 >= r1) goto L_0x08e4
            r28 = r26[r20]     // Catch:{ all -> 0x01be }
            r0 = r28
            java.lang.String r2 = r0.name     // Catch:{ all -> 0x01be }
            java.lang.String r3 = "_ep"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x01be }
            if (r2 == 0) goto L_0x0725
            r30.zzawj()     // Catch:{ all -> 0x01be }
            java.lang.String r2 = "_en"
            r0 = r28
            java.lang.Object r2 = com.google.android.gms.internal.zzckn.zza((com.google.android.gms.internal.zzcky) r0, (java.lang.String) r2)     // Catch:{ all -> 0x01be }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x01be }
            r0 = r23
            java.lang.Object r3 = r0.get(r2)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcft r3 = (com.google.android.gms.internal.zzcft) r3     // Catch:{ all -> 0x01be }
            if (r3 != 0) goto L_0x06d3
            com.google.android.gms.internal.zzcfl r3 = r30.zzawh()     // Catch:{ all -> 0x01be }
            r0 = r21
            com.google.android.gms.internal.zzclb r4 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r4 = r4.zzch     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcft r3 = r3.zzae(r4, r2)     // Catch:{ all -> 0x01be }
            r0 = r23
            r0.put(r2, r3)     // Catch:{ all -> 0x01be }
        L_0x06d3:
            java.lang.Long r2 = r3.zzixd     // Catch:{ all -> 0x01be }
            if (r2 != 0) goto L_0x08e0
            java.lang.Long r2 = r3.zzixe     // Catch:{ all -> 0x01be }
            long r4 = r2.longValue()     // Catch:{ all -> 0x01be }
            r6 = 1
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 <= 0) goto L_0x06f6
            r30.zzawj()     // Catch:{ all -> 0x01be }
            r0 = r28
            com.google.android.gms.internal.zzckz[] r2 = r0.zzjiw     // Catch:{ all -> 0x01be }
            java.lang.String r4 = "_sr"
            java.lang.Long r5 = r3.zzixe     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzckz[] r2 = com.google.android.gms.internal.zzckn.zza((com.google.android.gms.internal.zzckz[]) r2, (java.lang.String) r4, (java.lang.Object) r5)     // Catch:{ all -> 0x01be }
            r0 = r28
            r0.zzjiw = r2     // Catch:{ all -> 0x01be }
        L_0x06f6:
            java.lang.Boolean r2 = r3.zzixf     // Catch:{ all -> 0x01be }
            if (r2 == 0) goto L_0x0719
            java.lang.Boolean r2 = r3.zzixf     // Catch:{ all -> 0x01be }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x01be }
            if (r2 == 0) goto L_0x0719
            r30.zzawj()     // Catch:{ all -> 0x01be }
            r0 = r28
            com.google.android.gms.internal.zzckz[] r2 = r0.zzjiw     // Catch:{ all -> 0x01be }
            java.lang.String r3 = "_efs"
            r4 = 1
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzckz[] r2 = com.google.android.gms.internal.zzckn.zza((com.google.android.gms.internal.zzckz[]) r2, (java.lang.String) r3, (java.lang.Object) r4)     // Catch:{ all -> 0x01be }
            r0 = r28
            r0.zzjiw = r2     // Catch:{ all -> 0x01be }
        L_0x0719:
            int r2 = r18 + 1
            r24[r18] = r28     // Catch:{ all -> 0x01be }
        L_0x071d:
            int r3 = r20 + 1
            r20 = r3
            r18 = r2
            goto L_0x0695
        L_0x0725:
            r2 = 1
            java.lang.String r3 = "_dbg"
            r4 = 1
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x01be }
            r0 = r28
            boolean r3 = zza((com.google.android.gms.internal.zzcky) r0, (java.lang.String) r3, (java.lang.Object) r4)     // Catch:{ all -> 0x01be }
            if (r3 != 0) goto L_0x0acc
            com.google.android.gms.internal.zzchd r2 = r30.zzawk()     // Catch:{ all -> 0x01be }
            r0 = r21
            com.google.android.gms.internal.zzclb r3 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r3 = r3.zzch     // Catch:{ all -> 0x01be }
            r0 = r28
            java.lang.String r4 = r0.name     // Catch:{ all -> 0x01be }
            int r2 = r2.zzap(r3, r4)     // Catch:{ all -> 0x01be }
            r19 = r2
        L_0x074a:
            if (r19 > 0) goto L_0x0766
            com.google.android.gms.internal.zzcgj r2 = r30.zzawn()     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcgl r2 = r2.zzayu()     // Catch:{ all -> 0x01be }
            java.lang.String r3 = "Sample rate must be positive. event, rate"
            r0 = r28
            java.lang.String r4 = r0.name     // Catch:{ all -> 0x01be }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r19)     // Catch:{ all -> 0x01be }
            r2.zze(r3, r4, r5)     // Catch:{ all -> 0x01be }
            int r2 = r18 + 1
            r24[r18] = r28     // Catch:{ all -> 0x01be }
            goto L_0x071d
        L_0x0766:
            r0 = r28
            java.lang.String r2 = r0.name     // Catch:{ all -> 0x01be }
            r0 = r23
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcft r2 = (com.google.android.gms.internal.zzcft) r2     // Catch:{ all -> 0x01be }
            if (r2 != 0) goto L_0x0ac9
            com.google.android.gms.internal.zzcfl r2 = r30.zzawh()     // Catch:{ all -> 0x01be }
            r0 = r21
            com.google.android.gms.internal.zzclb r3 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r3 = r3.zzch     // Catch:{ all -> 0x01be }
            r0 = r28
            java.lang.String r4 = r0.name     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcft r3 = r2.zzae(r3, r4)     // Catch:{ all -> 0x01be }
            if (r3 != 0) goto L_0x07c0
            com.google.android.gms.internal.zzcgj r2 = r30.zzawn()     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcgl r2 = r2.zzayu()     // Catch:{ all -> 0x01be }
            java.lang.String r3 = "Event being bundled has no eventAggregate. appId, eventName"
            r0 = r21
            com.google.android.gms.internal.zzclb r4 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r4 = r4.zzch     // Catch:{ all -> 0x01be }
            r0 = r28
            java.lang.String r5 = r0.name     // Catch:{ all -> 0x01be }
            r2.zze(r3, r4, r5)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcft r3 = new com.google.android.gms.internal.zzcft     // Catch:{ all -> 0x01be }
            r0 = r21
            com.google.android.gms.internal.zzclb r2 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r4 = r2.zzch     // Catch:{ all -> 0x01be }
            r0 = r28
            java.lang.String r5 = r0.name     // Catch:{ all -> 0x01be }
            r6 = 1
            r8 = 1
            r0 = r28
            java.lang.Long r2 = r0.zzjix     // Catch:{ all -> 0x01be }
            long r10 = r2.longValue()     // Catch:{ all -> 0x01be }
            r12 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r3.<init>(r4, r5, r6, r8, r10, r12, r14, r15, r16)     // Catch:{ all -> 0x01be }
        L_0x07c0:
            r30.zzawj()     // Catch:{ all -> 0x01be }
            java.lang.String r2 = "_eid"
            r0 = r28
            java.lang.Object r2 = com.google.android.gms.internal.zzckn.zza((com.google.android.gms.internal.zzcky) r0, (java.lang.String) r2)     // Catch:{ all -> 0x01be }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x01be }
            if (r2 == 0) goto L_0x0801
            r4 = 1
        L_0x07d0:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x01be }
            r5 = 1
            r0 = r19
            if (r0 != r5) goto L_0x0803
            int r2 = r18 + 1
            r24[r18] = r28     // Catch:{ all -> 0x01be }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x01be }
            if (r4 == 0) goto L_0x071d
            java.lang.Long r4 = r3.zzixd     // Catch:{ all -> 0x01be }
            if (r4 != 0) goto L_0x07ef
            java.lang.Long r4 = r3.zzixe     // Catch:{ all -> 0x01be }
            if (r4 != 0) goto L_0x07ef
            java.lang.Boolean r4 = r3.zzixf     // Catch:{ all -> 0x01be }
            if (r4 == 0) goto L_0x071d
        L_0x07ef:
            r4 = 0
            r5 = 0
            r6 = 0
            com.google.android.gms.internal.zzcft r3 = r3.zza(r4, r5, r6)     // Catch:{ all -> 0x01be }
            r0 = r28
            java.lang.String r4 = r0.name     // Catch:{ all -> 0x01be }
            r0 = r23
            r0.put(r4, r3)     // Catch:{ all -> 0x01be }
            goto L_0x071d
        L_0x0801:
            r4 = 0
            goto L_0x07d0
        L_0x0803:
            r0 = r25
            r1 = r19
            int r5 = r0.nextInt(r1)     // Catch:{ all -> 0x01be }
            if (r5 != 0) goto L_0x0853
            r30.zzawj()     // Catch:{ all -> 0x01be }
            r0 = r28
            com.google.android.gms.internal.zzckz[] r2 = r0.zzjiw     // Catch:{ all -> 0x01be }
            java.lang.String r5 = "_sr"
            r0 = r19
            long r6 = (long) r0     // Catch:{ all -> 0x01be }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzckz[] r2 = com.google.android.gms.internal.zzckn.zza((com.google.android.gms.internal.zzckz[]) r2, (java.lang.String) r5, (java.lang.Object) r6)     // Catch:{ all -> 0x01be }
            r0 = r28
            r0.zzjiw = r2     // Catch:{ all -> 0x01be }
            int r2 = r18 + 1
            r24[r18] = r28     // Catch:{ all -> 0x01be }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x01be }
            if (r4 == 0) goto L_0x083c
            r4 = 0
            r0 = r19
            long r6 = (long) r0     // Catch:{ all -> 0x01be }
            java.lang.Long r5 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x01be }
            r6 = 0
            com.google.android.gms.internal.zzcft r3 = r3.zza(r4, r5, r6)     // Catch:{ all -> 0x01be }
        L_0x083c:
            r0 = r28
            java.lang.String r4 = r0.name     // Catch:{ all -> 0x01be }
            r0 = r28
            java.lang.Long r5 = r0.zzjix     // Catch:{ all -> 0x01be }
            long r6 = r5.longValue()     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcft r3 = r3.zzbb(r6)     // Catch:{ all -> 0x01be }
            r0 = r23
            r0.put(r4, r3)     // Catch:{ all -> 0x01be }
            goto L_0x071d
        L_0x0853:
            long r6 = r3.zzixc     // Catch:{ all -> 0x01be }
            r0 = r28
            java.lang.Long r5 = r0.zzjix     // Catch:{ all -> 0x01be }
            long r8 = r5.longValue()     // Catch:{ all -> 0x01be }
            long r6 = r8 - r6
            long r6 = java.lang.Math.abs(r6)     // Catch:{ all -> 0x01be }
            r8 = 86400000(0x5265c00, double:4.2687272E-316)
            int r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r5 < 0) goto L_0x08cb
            r30.zzawj()     // Catch:{ all -> 0x01be }
            r0 = r28
            com.google.android.gms.internal.zzckz[] r2 = r0.zzjiw     // Catch:{ all -> 0x01be }
            java.lang.String r5 = "_efs"
            r6 = 1
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzckz[] r2 = com.google.android.gms.internal.zzckn.zza((com.google.android.gms.internal.zzckz[]) r2, (java.lang.String) r5, (java.lang.Object) r6)     // Catch:{ all -> 0x01be }
            r0 = r28
            r0.zzjiw = r2     // Catch:{ all -> 0x01be }
            r30.zzawj()     // Catch:{ all -> 0x01be }
            r0 = r28
            com.google.android.gms.internal.zzckz[] r2 = r0.zzjiw     // Catch:{ all -> 0x01be }
            java.lang.String r5 = "_sr"
            r0 = r19
            long r6 = (long) r0     // Catch:{ all -> 0x01be }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzckz[] r2 = com.google.android.gms.internal.zzckn.zza((com.google.android.gms.internal.zzckz[]) r2, (java.lang.String) r5, (java.lang.Object) r6)     // Catch:{ all -> 0x01be }
            r0 = r28
            r0.zzjiw = r2     // Catch:{ all -> 0x01be }
            int r2 = r18 + 1
            r24[r18] = r28     // Catch:{ all -> 0x01be }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x01be }
            if (r4 == 0) goto L_0x08b4
            r4 = 0
            r0 = r19
            long r6 = (long) r0     // Catch:{ all -> 0x01be }
            java.lang.Long r5 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x01be }
            r6 = 1
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcft r3 = r3.zza(r4, r5, r6)     // Catch:{ all -> 0x01be }
        L_0x08b4:
            r0 = r28
            java.lang.String r4 = r0.name     // Catch:{ all -> 0x01be }
            r0 = r28
            java.lang.Long r5 = r0.zzjix     // Catch:{ all -> 0x01be }
            long r6 = r5.longValue()     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcft r3 = r3.zzbb(r6)     // Catch:{ all -> 0x01be }
            r0 = r23
            r0.put(r4, r3)     // Catch:{ all -> 0x01be }
            goto L_0x071d
        L_0x08cb:
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x01be }
            if (r4 == 0) goto L_0x08e0
            r0 = r28
            java.lang.String r4 = r0.name     // Catch:{ all -> 0x01be }
            r5 = 0
            r6 = 0
            com.google.android.gms.internal.zzcft r2 = r3.zza(r2, r5, r6)     // Catch:{ all -> 0x01be }
            r0 = r23
            r0.put(r4, r2)     // Catch:{ all -> 0x01be }
        L_0x08e0:
            r2 = r18
            goto L_0x071d
        L_0x08e4:
            r0 = r22
            com.google.android.gms.internal.zzcky[] r2 = r0.zzjje     // Catch:{ all -> 0x01be }
            int r2 = r2.length     // Catch:{ all -> 0x01be }
            r0 = r18
            if (r0 >= r2) goto L_0x08fb
            r0 = r24
            r1 = r18
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r0, r1)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcky[] r2 = (com.google.android.gms.internal.zzcky[]) r2     // Catch:{ all -> 0x01be }
            r0 = r22
            r0.zzjje = r2     // Catch:{ all -> 0x01be }
        L_0x08fb:
            java.util.Set r2 = r23.entrySet()     // Catch:{ all -> 0x01be }
            java.util.Iterator r3 = r2.iterator()     // Catch:{ all -> 0x01be }
        L_0x0903:
            boolean r2 = r3.hasNext()     // Catch:{ all -> 0x01be }
            if (r2 == 0) goto L_0x091d
            java.lang.Object r2 = r3.next()     // Catch:{ all -> 0x01be }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcfl r4 = r30.zzawh()     // Catch:{ all -> 0x01be }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcft r2 = (com.google.android.gms.internal.zzcft) r2     // Catch:{ all -> 0x01be }
            r4.zza((com.google.android.gms.internal.zzcft) r2)     // Catch:{ all -> 0x01be }
            goto L_0x0903
        L_0x091d:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x01be }
            r0 = r22
            r0.zzjjh = r2     // Catch:{ all -> 0x01be }
            r2 = -9223372036854775808
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x01be }
            r0 = r22
            r0.zzjji = r2     // Catch:{ all -> 0x01be }
            r2 = 0
        L_0x0935:
            r0 = r22
            com.google.android.gms.internal.zzcky[] r3 = r0.zzjje     // Catch:{ all -> 0x01be }
            int r3 = r3.length     // Catch:{ all -> 0x01be }
            if (r2 >= r3) goto L_0x0975
            r0 = r22
            com.google.android.gms.internal.zzcky[] r3 = r0.zzjje     // Catch:{ all -> 0x01be }
            r3 = r3[r2]     // Catch:{ all -> 0x01be }
            java.lang.Long r4 = r3.zzjix     // Catch:{ all -> 0x01be }
            long r4 = r4.longValue()     // Catch:{ all -> 0x01be }
            r0 = r22
            java.lang.Long r6 = r0.zzjjh     // Catch:{ all -> 0x01be }
            long r6 = r6.longValue()     // Catch:{ all -> 0x01be }
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x095a
            java.lang.Long r4 = r3.zzjix     // Catch:{ all -> 0x01be }
            r0 = r22
            r0.zzjjh = r4     // Catch:{ all -> 0x01be }
        L_0x095a:
            java.lang.Long r4 = r3.zzjix     // Catch:{ all -> 0x01be }
            long r4 = r4.longValue()     // Catch:{ all -> 0x01be }
            r0 = r22
            java.lang.Long r6 = r0.zzjji     // Catch:{ all -> 0x01be }
            long r6 = r6.longValue()     // Catch:{ all -> 0x01be }
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x0972
            java.lang.Long r3 = r3.zzjix     // Catch:{ all -> 0x01be }
            r0 = r22
            r0.zzjji = r3     // Catch:{ all -> 0x01be }
        L_0x0972:
            int r2 = r2 + 1
            goto L_0x0935
        L_0x0975:
            r0 = r21
            com.google.android.gms.internal.zzclb r2 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r6 = r2.zzch     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcfl r2 = r30.zzawh()     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcfe r7 = r2.zziw(r6)     // Catch:{ all -> 0x01be }
            if (r7 != 0) goto L_0x0a09
            com.google.android.gms.internal.zzcgj r2 = r30.zzawn()     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcgl r2 = r2.zzays()     // Catch:{ all -> 0x01be }
            java.lang.String r3 = "Bundling raw events w/o app info. appId"
            r0 = r21
            com.google.android.gms.internal.zzclb r4 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r4 = r4.zzch     // Catch:{ all -> 0x01be }
            java.lang.Object r4 = com.google.android.gms.internal.zzcgj.zzjf(r4)     // Catch:{ all -> 0x01be }
            r2.zzj(r3, r4)     // Catch:{ all -> 0x01be }
        L_0x099c:
            r0 = r22
            com.google.android.gms.internal.zzcky[] r2 = r0.zzjje     // Catch:{ all -> 0x01be }
            int r2 = r2.length     // Catch:{ all -> 0x01be }
            if (r2 <= 0) goto L_0x09d8
            com.google.android.gms.internal.zzchd r2 = r30.zzawk()     // Catch:{ all -> 0x01be }
            r0 = r21
            com.google.android.gms.internal.zzclb r3 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r3 = r3.zzch     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzckv r2 = r2.zzjn(r3)     // Catch:{ all -> 0x01be }
            if (r2 == 0) goto L_0x09b7
            java.lang.Long r3 = r2.zzjil     // Catch:{ all -> 0x01be }
            if (r3 != 0) goto L_0x0a8e
        L_0x09b7:
            r0 = r21
            com.google.android.gms.internal.zzclb r2 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r2 = r2.zzivh     // Catch:{ all -> 0x01be }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x01be }
            if (r2 == 0) goto L_0x0a75
            r2 = -1
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x01be }
            r0 = r22
            r0.zzjkc = r2     // Catch:{ all -> 0x01be }
        L_0x09cd:
            com.google.android.gms.internal.zzcfl r2 = r30.zzawh()     // Catch:{ all -> 0x01be }
            r0 = r22
            r1 = r17
            r2.zza((com.google.android.gms.internal.zzclb) r0, (boolean) r1)     // Catch:{ all -> 0x01be }
        L_0x09d8:
            com.google.android.gms.internal.zzcfl r2 = r30.zzawh()     // Catch:{ all -> 0x01be }
            r0 = r21
            java.util.List<java.lang.Long> r3 = r0.zzjdy     // Catch:{ all -> 0x01be }
            r2.zzag(r3)     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcfl r3 = r30.zzawh()     // Catch:{ all -> 0x01be }
            android.database.sqlite.SQLiteDatabase r2 = r3.getWritableDatabase()     // Catch:{ all -> 0x01be }
            java.lang.String r4 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0a96 }
            r7 = 0
            r5[r7] = r6     // Catch:{ SQLiteException -> 0x0a96 }
            r7 = 1
            r5[r7] = r6     // Catch:{ SQLiteException -> 0x0a96 }
            r2.execSQL(r4, r5)     // Catch:{ SQLiteException -> 0x0a96 }
        L_0x09f9:
            com.google.android.gms.internal.zzcfl r2 = r30.zzawh()     // Catch:{ all -> 0x01be }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcfl r2 = r30.zzawh()
            r2.endTransaction()
            r2 = 1
        L_0x0a08:
            return r2
        L_0x0a09:
            r0 = r22
            com.google.android.gms.internal.zzcky[] r2 = r0.zzjje     // Catch:{ all -> 0x01be }
            int r2 = r2.length     // Catch:{ all -> 0x01be }
            if (r2 <= 0) goto L_0x099c
            long r2 = r7.zzawu()     // Catch:{ all -> 0x01be }
            r4 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0a71
            java.lang.Long r4 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x01be }
        L_0x0a1e:
            r0 = r22
            r0.zzjjk = r4     // Catch:{ all -> 0x01be }
            long r4 = r7.zzawt()     // Catch:{ all -> 0x01be }
            r8 = 0
            int r8 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r8 != 0) goto L_0x0ac6
        L_0x0a2c:
            r4 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0a73
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x01be }
        L_0x0a36:
            r0 = r22
            r0.zzjjj = r2     // Catch:{ all -> 0x01be }
            r7.zzaxd()     // Catch:{ all -> 0x01be }
            long r2 = r7.zzaxa()     // Catch:{ all -> 0x01be }
            int r2 = (int) r2     // Catch:{ all -> 0x01be }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x01be }
            r0 = r22
            r0.zzjjv = r2     // Catch:{ all -> 0x01be }
            r0 = r22
            java.lang.Long r2 = r0.zzjjh     // Catch:{ all -> 0x01be }
            long r2 = r2.longValue()     // Catch:{ all -> 0x01be }
            r7.zzak(r2)     // Catch:{ all -> 0x01be }
            r0 = r22
            java.lang.Long r2 = r0.zzjji     // Catch:{ all -> 0x01be }
            long r2 = r2.longValue()     // Catch:{ all -> 0x01be }
            r7.zzal(r2)     // Catch:{ all -> 0x01be }
            java.lang.String r2 = r7.zzaxl()     // Catch:{ all -> 0x01be }
            r0 = r22
            r0.zzivl = r2     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcfl r2 = r30.zzawh()     // Catch:{ all -> 0x01be }
            r2.zza((com.google.android.gms.internal.zzcfe) r7)     // Catch:{ all -> 0x01be }
            goto L_0x099c
        L_0x0a71:
            r4 = 0
            goto L_0x0a1e
        L_0x0a73:
            r2 = 0
            goto L_0x0a36
        L_0x0a75:
            com.google.android.gms.internal.zzcgj r2 = r30.zzawn()     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcgl r2 = r2.zzayu()     // Catch:{ all -> 0x01be }
            java.lang.String r3 = "Did not find measurement config or missing version info. appId"
            r0 = r21
            com.google.android.gms.internal.zzclb r4 = r0.zzjdx     // Catch:{ all -> 0x01be }
            java.lang.String r4 = r4.zzch     // Catch:{ all -> 0x01be }
            java.lang.Object r4 = com.google.android.gms.internal.zzcgj.zzjf(r4)     // Catch:{ all -> 0x01be }
            r2.zzj(r3, r4)     // Catch:{ all -> 0x01be }
            goto L_0x09cd
        L_0x0a8e:
            java.lang.Long r2 = r2.zzjil     // Catch:{ all -> 0x01be }
            r0 = r22
            r0.zzjkc = r2     // Catch:{ all -> 0x01be }
            goto L_0x09cd
        L_0x0a96:
            r2 = move-exception
            com.google.android.gms.internal.zzcgj r3 = r3.zzawn()     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcgl r3 = r3.zzays()     // Catch:{ all -> 0x01be }
            java.lang.String r4 = "Failed to remove unused event metadata. appId"
            java.lang.Object r5 = com.google.android.gms.internal.zzcgj.zzjf(r6)     // Catch:{ all -> 0x01be }
            r3.zze(r4, r5, r2)     // Catch:{ all -> 0x01be }
            goto L_0x09f9
        L_0x0aaa:
            com.google.android.gms.internal.zzcfl r2 = r30.zzawh()     // Catch:{ all -> 0x01be }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x01be }
            com.google.android.gms.internal.zzcfl r2 = r30.zzawh()
            r2.endTransaction()
            r2 = 0
            goto L_0x0a08
        L_0x0abb:
            r2 = move-exception
            r3 = r11
            goto L_0x0354
        L_0x0abf:
            r2 = move-exception
            goto L_0x02e3
        L_0x0ac2:
            r2 = move-exception
            r4 = r12
            goto L_0x02e3
        L_0x0ac6:
            r2 = r4
            goto L_0x0a2c
        L_0x0ac9:
            r3 = r2
            goto L_0x07c0
        L_0x0acc:
            r19 = r2
            goto L_0x074a
        L_0x0ad0:
            r3 = r4
            r4 = r5
            goto L_0x05a1
        L_0x0ad4:
            r17 = r2
            goto L_0x0528
        L_0x0ad8:
            r2 = r4
            goto L_0x03d8
        L_0x0adb:
            r2 = r12
            r3 = r17
            goto L_0x0158
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzchj.zzh(java.lang.String, long):boolean");
    }

    @WorkerThread
    private final zzcff zzjr(String str) {
        zzcfe zziw = zzawh().zziw(str);
        if (zziw == null || TextUtils.isEmpty(zziw.zzuy())) {
            zzawn().zzayx().zzj("No app data available; dropping", str);
            return null;
        }
        try {
            String str2 = zzbgc.zzcy(this.mContext).getPackageInfo(str, 0).versionName;
            if (zziw.zzuy() != null && !zziw.zzuy().equals(str2)) {
                zzawn().zzayu().zzj("App version does not match; dropping. appId", zzcgj.zzjf(str));
                return null;
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
        return new zzcff(str, zziw.getGmpAppId(), zziw.zzuy(), zziw.zzawv(), zziw.zzaww(), zziw.zzawx(), zziw.zzawy(), (String) null, zziw.zzawz(), false, zziw.zzaws(), zziw.zzaxm(), 0, 0, zziw.zzaxn());
    }

    public final Context getContext() {
        return this.mContext;
    }

    @WorkerThread
    public final boolean isEnabled() {
        boolean z = false;
        zzawm().zzut();
        zzwu();
        if (this.zzjcl.zzaxp()) {
            return false;
        }
        Boolean zzit = this.zzjcl.zzit("firebase_analytics_collection_enabled");
        if (zzit != null) {
            z = zzit.booleanValue();
        } else if (!zzcc.zzaix()) {
            z = true;
        }
        return zzawo().zzbm(z);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void start() {
        zzawm().zzut();
        zzawh().zzaxw();
        if (zzawo().zzjag.get() == 0) {
            zzawo().zzjag.set(this.zzasd.currentTimeMillis());
        }
        if (Long.valueOf(zzawo().zzjal.get()).longValue() == 0) {
            zzawn().zzayy().zzj("Persisting first open", Long.valueOf(this.zzjdv));
            zzawo().zzjal.set(this.zzjdv);
        }
        if (zzazk()) {
            if (!TextUtils.isEmpty(zzawc().getGmpAppId())) {
                String zzazb = zzawo().zzazb();
                if (zzazb == null) {
                    zzawo().zzjj(zzawc().getGmpAppId());
                } else if (!zzazb.equals(zzawc().getGmpAppId())) {
                    zzawn().zzayw().log("Rechecking which service to use due to a GMP App Id change");
                    zzawo().zzaze();
                    this.zzjcz.disconnect();
                    this.zzjcz.zzxr();
                    zzawo().zzjj(zzawc().getGmpAppId());
                    zzawo().zzjal.set(this.zzjdv);
                    zzawo().zzjam.zzjl((String) null);
                }
            }
            zzawb().zzjk(zzawo().zzjam.zzazg());
            if (!TextUtils.isEmpty(zzawc().getGmpAppId())) {
                zzcik zzawb = zzawb();
                zzawb.zzut();
                zzawb.zzwu();
                if (zzawb.zzitu.zzazk()) {
                    zzawb.zzawe().zzbag();
                    String zzazf = zzawb.zzawo().zzazf();
                    if (!TextUtils.isEmpty(zzazf)) {
                        zzawb.zzawd().zzwu();
                        if (!zzazf.equals(Build.VERSION.RELEASE)) {
                            Bundle bundle = new Bundle();
                            bundle.putString("_po", zzazf);
                            zzawb.zzc("auto", "_ou", bundle);
                        }
                    }
                }
                zzawe().zza((AtomicReference<String>) new AtomicReference());
            }
        } else if (isEnabled()) {
            if (!zzawj().zzdu("android.permission.INTERNET")) {
                zzawn().zzays().log("App is missing INTERNET permission");
            }
            if (!zzawj().zzdu("android.permission.ACCESS_NETWORK_STATE")) {
                zzawn().zzays().log("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!zzbgc.zzcy(this.mContext).zzamj()) {
                if (!zzcha.zzbi(this.mContext)) {
                    zzawn().zzays().log("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzcjx.zzk(this.mContext, false)) {
                    zzawn().zzays().log("AppMeasurementService not registered/enabled");
                }
            }
            zzawn().zzays().log("Uploading is not possible. App measurement disabled");
        }
        zzazy();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(int i, Throwable th, byte[] bArr) {
        zzcfl zzawh;
        zzawm().zzut();
        zzwu();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzjdt = false;
                zzbac();
                throw th2;
            }
        }
        List<Long> list = this.zzjdm;
        this.zzjdm = null;
        if ((i == 200 || i == 204) && th == null) {
            try {
                zzawo().zzjag.set(this.zzasd.currentTimeMillis());
                zzawo().zzjah.set(0);
                zzazy();
                zzawn().zzayy().zze("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzawh().beginTransaction();
                try {
                    for (Long longValue : list) {
                        zzawh = zzawh();
                        long longValue2 = longValue.longValue();
                        zzawh.zzut();
                        zzawh.zzwu();
                        if (zzawh.getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(longValue2)}) != 1) {
                            throw new SQLiteException("Deleted fewer rows from queue than expected");
                        }
                    }
                    zzawh().setTransactionSuccessful();
                    zzawh().endTransaction();
                    if (!zzazq().zzzh() || !zzazx()) {
                        this.zzjdq = -1;
                        zzazy();
                    } else {
                        zzazw();
                    }
                    this.zzjdr = 0;
                } catch (SQLiteException e) {
                    zzawh.zzawn().zzays().zzj("Failed to delete a bundle in a queue table", e);
                    throw e;
                } catch (Throwable th3) {
                    zzawh().endTransaction();
                    throw th3;
                }
            } catch (SQLiteException e2) {
                zzawn().zzays().zzj("Database error while trying to delete uploaded bundles", e2);
                this.zzjdr = this.zzasd.elapsedRealtime();
                zzawn().zzayy().zzj("Disable upload, time", Long.valueOf(this.zzjdr));
            }
        } else {
            zzawn().zzayy().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            zzawo().zzjah.set(this.zzasd.currentTimeMillis());
            if (i == 503 || i == 429) {
                zzawo().zzjai.set(this.zzasd.currentTimeMillis());
            }
            zzazy();
        }
        this.zzjdt = false;
        zzbac();
    }

    @WorkerThread
    public final byte[] zza(@NonNull zzcfx zzcfx, @Size(min = 1) String str) {
        long j;
        zzwu();
        zzawm().zzut();
        zzavx();
        zzbq.checkNotNull(zzcfx);
        zzbq.zzgi(str);
        zzcla zzcla = new zzcla();
        zzawh().beginTransaction();
        try {
            zzcfe zziw = zzawh().zziw(str);
            if (zziw == null) {
                zzawn().zzayx().zzj("Log and bundle not available. package_name", str);
                return new byte[0];
            } else if (!zziw.zzawz()) {
                zzawn().zzayx().zzj("Log and bundle disabled. package_name", str);
                byte[] bArr = new byte[0];
                zzawh().endTransaction();
                return bArr;
            } else {
                if (("_iap".equals(zzcfx.name) || FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(zzcfx.name)) && !zza(str, zzcfx)) {
                    zzawn().zzayu().zzj("Failed to handle purchase event at single event bundle creation. appId", zzcgj.zzjf(str));
                }
                zzclb zzclb = new zzclb();
                zzcla.zzjjb = new zzclb[]{zzclb};
                zzclb.zzjjd = 1;
                zzclb.zzjjl = "android";
                zzclb.zzch = zziw.getAppId();
                zzclb.zzivi = zziw.zzaww();
                zzclb.zzida = zziw.zzuy();
                long zzawv = zziw.zzawv();
                zzclb.zzjjy = zzawv == -2147483648L ? null : Integer.valueOf((int) zzawv);
                zzclb.zzjjp = Long.valueOf(zziw.zzawx());
                zzclb.zzivh = zziw.getGmpAppId();
                zzclb.zzjju = Long.valueOf(zziw.zzawy());
                if (isEnabled() && zzcfk.zzaxt() && this.zzjcl.zziu(zzclb.zzch)) {
                    zzawc();
                    zzclb.zzjkd = null;
                }
                Pair<String, Boolean> zzjh = zzawo().zzjh(zziw.getAppId());
                if (zziw.zzaxn() && zzjh != null && !TextUtils.isEmpty((CharSequence) zzjh.first)) {
                    zzclb.zzjjr = (String) zzjh.first;
                    zzclb.zzjjs = (Boolean) zzjh.second;
                }
                zzawd().zzwu();
                zzclb.zzjjm = Build.MODEL;
                zzawd().zzwu();
                zzclb.zzcv = Build.VERSION.RELEASE;
                zzclb.zzjjo = Integer.valueOf((int) zzawd().zzayj());
                zzclb.zzjjn = zzawd().zzayk();
                zzclb.zzjjt = zziw.getAppInstanceId();
                zzclb.zzivp = zziw.zzaws();
                List<zzckm> zziv = zzawh().zziv(zziw.getAppId());
                zzclb.zzjjf = new zzcld[zziv.size()];
                for (int i = 0; i < zziv.size(); i++) {
                    zzcld zzcld = new zzcld();
                    zzclb.zzjjf[i] = zzcld;
                    zzcld.name = zziv.get(i).mName;
                    zzcld.zzjkh = Long.valueOf(zziv.get(i).zzjhb);
                    zzawj().zza(zzcld, zziv.get(i).mValue);
                }
                Bundle zzaym = zzcfx.zzixi.zzaym();
                if ("_iap".equals(zzcfx.name)) {
                    zzaym.putLong("_c", 1);
                    zzawn().zzayx().log("Marking in-app purchase as real-time");
                    zzaym.putLong("_r", 1);
                }
                zzaym.putString("_o", zzcfx.zzivu);
                if (zzawj().zzke(zzclb.zzch)) {
                    zzawj().zza(zzaym, "_dbg", (Object) 1L);
                    zzawj().zza(zzaym, "_r", (Object) 1L);
                }
                zzcft zzae = zzawh().zzae(str, zzcfx.name);
                if (zzae == null) {
                    zzawh().zza(new zzcft(str, zzcfx.name, 1, 0, zzcfx.zzixj, 0, (Long) null, (Long) null, (Boolean) null));
                    j = 0;
                } else {
                    j = zzae.zzixb;
                    zzawh().zza(zzae.zzba(zzcfx.zzixj).zzayl());
                }
                zzcfs zzcfs = new zzcfs(this, zzcfx.zzivu, str, zzcfx.name, zzcfx.zzixj, j, zzaym);
                zzcky zzcky = new zzcky();
                zzclb.zzjje = new zzcky[]{zzcky};
                zzcky.zzjix = Long.valueOf(zzcfs.zzfgb);
                zzcky.name = zzcfs.mName;
                zzcky.zzjiy = Long.valueOf(zzcfs.zziwx);
                zzcky.zzjiw = new zzckz[zzcfs.zziwy.size()];
                Iterator<String> it = zzcfs.zziwy.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    String next = it.next();
                    zzckz zzckz = new zzckz();
                    zzcky.zzjiw[i2] = zzckz;
                    zzckz.name = next;
                    zzawj().zza(zzckz, zzcfs.zziwy.get(next));
                    i2++;
                }
                zzclb.zzjjx = zza(zziw.getAppId(), zzclb.zzjjf, zzclb.zzjje);
                zzclb.zzjjh = zzcky.zzjix;
                zzclb.zzjji = zzcky.zzjix;
                long zzawu = zziw.zzawu();
                zzclb.zzjjk = zzawu != 0 ? Long.valueOf(zzawu) : null;
                long zzawt = zziw.zzawt();
                if (zzawt != 0) {
                    zzawu = zzawt;
                }
                zzclb.zzjjj = zzawu != 0 ? Long.valueOf(zzawu) : null;
                zziw.zzaxd();
                zzclb.zzjjv = Integer.valueOf((int) zziw.zzaxa());
                zzclb.zzjjq = 11717L;
                zzclb.zzjjg = Long.valueOf(this.zzasd.currentTimeMillis());
                zzclb.zzjjw = Boolean.TRUE;
                zziw.zzak(zzclb.zzjjh.longValue());
                zziw.zzal(zzclb.zzjji.longValue());
                zzawh().zza(zziw);
                zzawh().setTransactionSuccessful();
                zzawh().endTransaction();
                try {
                    byte[] bArr2 = new byte[zzcla.zzhl()];
                    zzfhk zzo = zzfhk.zzo(bArr2, 0, bArr2.length);
                    zzcla.zza(zzo);
                    zzo.zzcut();
                    return zzawj().zzp(bArr2);
                } catch (IOException e) {
                    zzawn().zzays().zze("Data loss. Failed to bundle and serialize. appId", zzcgj.zzjf(str), e);
                    return null;
                }
            }
        } finally {
            zzawh().endTransaction();
        }
    }

    public final zzcfa zzavz() {
        zza((zzcih) this.zzjdg);
        return this.zzjdg;
    }

    public final zzcfh zzawa() {
        zza((zzcii) this.zzjdf);
        return this.zzjdf;
    }

    public final zzcik zzawb() {
        zza((zzcii) this.zzjdb);
        return this.zzjdb;
    }

    public final zzcge zzawc() {
        zza((zzcii) this.zzjdc);
        return this.zzjdc;
    }

    public final zzcfr zzawd() {
        zza((zzcii) this.zzjda);
        return this.zzjda;
    }

    public final zzcjd zzawe() {
        zza((zzcii) this.zzjcz);
        return this.zzjcz;
    }

    public final zzciz zzawf() {
        zza((zzcii) this.zzjcy);
        return this.zzjcy;
    }

    public final zzcgf zzawg() {
        zza((zzcii) this.zzjcw);
        return this.zzjcw;
    }

    public final zzcfl zzawh() {
        zza((zzcii) this.zzjcv);
        return this.zzjcv;
    }

    public final zzcgh zzawi() {
        zza((zzcih) this.zzjcu);
        return this.zzjcu;
    }

    public final zzckn zzawj() {
        zza((zzcih) this.zzjct);
        return this.zzjct;
    }

    public final zzchd zzawk() {
        zza((zzcii) this.zzjcq);
        return this.zzjcq;
    }

    public final zzckc zzawl() {
        zza((zzcii) this.zzjcp);
        return this.zzjcp;
    }

    public final zzche zzawm() {
        zza((zzcii) this.zzjco);
        return this.zzjco;
    }

    public final zzcgj zzawn() {
        zza((zzcii) this.zzjcn);
        return this.zzjcn;
    }

    public final zzcgu zzawo() {
        zza((zzcih) this.zzjcm);
        return this.zzjcm;
    }

    public final zzcfk zzawp() {
        return this.zzjcl;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final boolean zzazk() {
        boolean z = false;
        zzwu();
        zzawm().zzut();
        if (this.zzjdi == null || this.zzjdj == 0 || (this.zzjdi != null && !this.zzjdi.booleanValue() && Math.abs(this.zzasd.elapsedRealtime() - this.zzjdj) > 1000)) {
            this.zzjdj = this.zzasd.elapsedRealtime();
            if (zzawj().zzdu("android.permission.INTERNET") && zzawj().zzdu("android.permission.ACCESS_NETWORK_STATE") && (zzbgc.zzcy(this.mContext).zzamj() || (zzcha.zzbi(this.mContext) && zzcjx.zzk(this.mContext, false)))) {
                z = true;
            }
            this.zzjdi = Boolean.valueOf(z);
            if (this.zzjdi.booleanValue()) {
                this.zzjdi = Boolean.valueOf(zzawj().zzkb(zzawc().getGmpAppId()));
            }
        }
        return this.zzjdi.booleanValue();
    }

    public final zzcgj zzazm() {
        if (this.zzjcn == null || !this.zzjcn.isInitialized()) {
            return null;
        }
        return this.zzjcn;
    }

    /* access modifiers changed from: package-private */
    public final zzche zzazn() {
        return this.zzjco;
    }

    public final AppMeasurement zzazo() {
        return this.zzjcr;
    }

    public final FirebaseAnalytics zzazp() {
        return this.zzjcs;
    }

    public final zzcgn zzazq() {
        zza((zzcii) this.zzjcx);
        return this.zzjcx;
    }

    /* access modifiers changed from: package-private */
    public final long zzazu() {
        Long valueOf = Long.valueOf(zzawo().zzjal.get());
        return valueOf.longValue() == 0 ? this.zzjdv : Math.min(this.zzjdv, valueOf.longValue());
    }

    @WorkerThread
    public final void zzazw() {
        String zzaxu;
        zzcfe zziw;
        String str;
        List<Pair<zzclb, Long>> list;
        String str2;
        zzawm().zzut();
        zzwu();
        this.zzjdu = true;
        try {
            Boolean zzbah = zzawe().zzbah();
            if (zzbah == null) {
                zzawn().zzayu().log("Upload data called on the client side before use of service was decided");
                this.zzjdu = false;
                zzbac();
            } else if (zzbah.booleanValue()) {
                zzawn().zzays().log("Upload called in the client side when service should be used");
                this.zzjdu = false;
                zzbac();
            } else if (this.zzjdr > 0) {
                zzazy();
                this.zzjdu = false;
                zzbac();
            } else {
                zzawm().zzut();
                if (this.zzjdm != null) {
                    zzawn().zzayy().log("Uploading requested multiple times");
                    this.zzjdu = false;
                    zzbac();
                } else if (!zzazq().zzzh()) {
                    zzawn().zzayy().log("Network not connected, ignoring upload request");
                    zzazy();
                    this.zzjdu = false;
                    zzbac();
                } else {
                    long currentTimeMillis = this.zzasd.currentTimeMillis();
                    zzh((String) null, currentTimeMillis - zzcfk.zzaxr());
                    long j = zzawo().zzjag.get();
                    if (j != 0) {
                        zzawn().zzayx().zzj("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - j)));
                    }
                    zzaxu = zzawh().zzaxu();
                    if (!TextUtils.isEmpty(zzaxu)) {
                        if (this.zzjdq == -1) {
                            this.zzjdq = zzawh().zzayb();
                        }
                        List<Pair<zzclb, Long>> zzl = zzawh().zzl(zzaxu, this.zzjcl.zzb(zzaxu, zzcfz.zzixy), Math.max(0, this.zzjcl.zzb(zzaxu, zzcfz.zzixz)));
                        if (!zzl.isEmpty()) {
                            Iterator<Pair<zzclb, Long>> it = zzl.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    str = null;
                                    break;
                                }
                                zzclb zzclb = (zzclb) it.next().first;
                                if (!TextUtils.isEmpty(zzclb.zzjjr)) {
                                    str = zzclb.zzjjr;
                                    break;
                                }
                            }
                            if (str != null) {
                                int i = 0;
                                while (true) {
                                    if (i >= zzl.size()) {
                                        break;
                                    }
                                    zzclb zzclb2 = (zzclb) zzl.get(i).first;
                                    if (!TextUtils.isEmpty(zzclb2.zzjjr) && !zzclb2.zzjjr.equals(str)) {
                                        list = zzl.subList(0, i);
                                        break;
                                    }
                                    i++;
                                }
                            }
                            list = zzl;
                            zzcla zzcla = new zzcla();
                            zzcla.zzjjb = new zzclb[list.size()];
                            ArrayList arrayList = new ArrayList(list.size());
                            boolean z = zzcfk.zzaxt() && this.zzjcl.zziu(zzaxu);
                            for (int i2 = 0; i2 < zzcla.zzjjb.length; i2++) {
                                zzcla.zzjjb[i2] = (zzclb) list.get(i2).first;
                                arrayList.add((Long) list.get(i2).second);
                                zzcla.zzjjb[i2].zzjjq = 11717L;
                                zzcla.zzjjb[i2].zzjjg = Long.valueOf(currentTimeMillis);
                                zzcla.zzjjb[i2].zzjjw = false;
                                if (!z) {
                                    zzcla.zzjjb[i2].zzjkd = null;
                                }
                            }
                            String zza2 = zzawn().zzae(2) ? zzawi().zza(zzcla) : null;
                            byte[] zzb = zzawj().zzb(zzcla);
                            str2 = zzcfz.zziyi.get();
                            URL url = new URL(str2);
                            zzbq.checkArgument(!arrayList.isEmpty());
                            if (this.zzjdm != null) {
                                zzawn().zzays().log("Set uploading progress before finishing the previous upload");
                            } else {
                                this.zzjdm = new ArrayList(arrayList);
                            }
                            zzawo().zzjah.set(currentTimeMillis);
                            String str3 = "?";
                            if (zzcla.zzjjb.length > 0) {
                                str3 = zzcla.zzjjb[0].zzch;
                            }
                            zzawn().zzayy().zzd("Uploading data. app, uncompressed size, data", str3, Integer.valueOf(zzb.length), zza2);
                            this.zzjdt = true;
                            zzcgn zzazq = zzazq();
                            zzchm zzchm = new zzchm(this);
                            zzazq.zzut();
                            zzazq.zzwu();
                            zzbq.checkNotNull(url);
                            zzbq.checkNotNull(zzb);
                            zzbq.checkNotNull(zzchm);
                            zzazq.zzawm().zzh(new zzcgr(zzazq, zzaxu, url, zzb, (Map<String, String>) null, zzchm));
                        }
                    } else {
                        this.zzjdq = -1;
                        String zzaz = zzawh().zzaz(currentTimeMillis - zzcfk.zzaxr());
                        if (!TextUtils.isEmpty(zzaz) && (zziw = zzawh().zziw(zzaz)) != null) {
                            zzb(zziw);
                        }
                    }
                    this.zzjdu = false;
                    zzbac();
                }
            }
        } catch (MalformedURLException e) {
            zzawn().zzays().zze("Failed to parse upload URL. Not uploading. appId", zzcgj.zzjf(zzaxu), str2);
        } catch (Throwable th) {
            this.zzjdu = false;
            zzbac();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzazz() {
        this.zzjdp++;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(zzcfi zzcfi, zzcff zzcff) {
        boolean z = true;
        zzbq.checkNotNull(zzcfi);
        zzbq.zzgi(zzcfi.packageName);
        zzbq.checkNotNull(zzcfi.zzivu);
        zzbq.checkNotNull(zzcfi.zzivv);
        zzbq.zzgi(zzcfi.zzivv.name);
        zzawm().zzut();
        zzwu();
        if (!TextUtils.isEmpty(zzcff.zzivh)) {
            if (!zzcff.zzivm) {
                zzg(zzcff);
                return;
            }
            zzcfi zzcfi2 = new zzcfi(zzcfi);
            zzcfi2.zzivx = false;
            zzawh().beginTransaction();
            try {
                zzcfi zzah = zzawh().zzah(zzcfi2.packageName, zzcfi2.zzivv.name);
                if (zzah != null && !zzah.zzivu.equals(zzcfi2.zzivu)) {
                    zzawn().zzayu().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", zzawi().zzje(zzcfi2.zzivv.name), zzcfi2.zzivu, zzah.zzivu);
                }
                if (zzah != null && zzah.zzivx) {
                    zzcfi2.zzivu = zzah.zzivu;
                    zzcfi2.zzivw = zzah.zzivw;
                    zzcfi2.zziwa = zzah.zziwa;
                    zzcfi2.zzivy = zzah.zzivy;
                    zzcfi2.zziwb = zzah.zziwb;
                    zzcfi2.zzivx = zzah.zzivx;
                    zzcfi2.zzivv = new zzckk(zzcfi2.zzivv.name, zzah.zzivv.zzjgx, zzcfi2.zzivv.getValue(), zzah.zzivv.zzivu);
                    z = false;
                } else if (TextUtils.isEmpty(zzcfi2.zzivy)) {
                    zzcfi2.zzivv = new zzckk(zzcfi2.zzivv.name, zzcfi2.zzivw, zzcfi2.zzivv.getValue(), zzcfi2.zzivv.zzivu);
                    zzcfi2.zzivx = true;
                } else {
                    z = false;
                }
                if (zzcfi2.zzivx) {
                    zzckk zzckk = zzcfi2.zzivv;
                    zzckm zzckm = new zzckm(zzcfi2.packageName, zzcfi2.zzivu, zzckk.name, zzckk.zzjgx, zzckk.getValue());
                    if (zzawh().zza(zzckm)) {
                        zzawn().zzayx().zzd("User property updated immediately", zzcfi2.packageName, zzawi().zzje(zzckm.mName), zzckm.mValue);
                    } else {
                        zzawn().zzays().zzd("(2)Too many active user properties, ignoring", zzcgj.zzjf(zzcfi2.packageName), zzawi().zzje(zzckm.mName), zzckm.mValue);
                    }
                    if (z && zzcfi2.zziwb != null) {
                        zzc(new zzcfx(zzcfi2.zziwb, zzcfi2.zzivw), zzcff);
                    }
                }
                if (zzawh().zza(zzcfi2)) {
                    zzawn().zzayx().zzd("Conditional property added", zzcfi2.packageName, zzawi().zzje(zzcfi2.zzivv.name), zzcfi2.zzivv.getValue());
                } else {
                    zzawn().zzays().zzd("Too many conditional properties, ignoring", zzcgj.zzjf(zzcfi2.packageName), zzawi().zzje(zzcfi2.zzivv.name), zzcfi2.zzivv.getValue());
                }
                zzawh().setTransactionSuccessful();
            } finally {
                zzawh().endTransaction();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(zzcfx zzcfx, zzcff zzcff) {
        List<zzcfi> zzc;
        List<zzcfi> zzc2;
        List<zzcfi> zzc3;
        zzbq.checkNotNull(zzcff);
        zzbq.zzgi(zzcff.packageName);
        zzawm().zzut();
        zzwu();
        String str = zzcff.packageName;
        long j = zzcfx.zzixj;
        zzawj();
        if (zzckn.zzd(zzcfx, zzcff)) {
            if (!zzcff.zzivm) {
                zzg(zzcff);
                return;
            }
            zzawh().beginTransaction();
            try {
                zzcfl zzawh = zzawh();
                zzbq.zzgi(str);
                zzawh.zzut();
                zzawh.zzwu();
                if (j < 0) {
                    zzawh.zzawn().zzayu().zze("Invalid time querying timed out conditional properties", zzcgj.zzjf(str), Long.valueOf(j));
                    zzc = Collections.emptyList();
                } else {
                    zzc = zzawh.zzc("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzcfi next : zzc) {
                    if (next != null) {
                        zzawn().zzayx().zzd("User property timed out", next.packageName, zzawi().zzje(next.zzivv.name), next.zzivv.getValue());
                        if (next.zzivz != null) {
                            zzc(new zzcfx(next.zzivz, j), zzcff);
                        }
                        zzawh().zzai(str, next.zzivv.name);
                    }
                }
                zzcfl zzawh2 = zzawh();
                zzbq.zzgi(str);
                zzawh2.zzut();
                zzawh2.zzwu();
                if (j < 0) {
                    zzawh2.zzawn().zzayu().zze("Invalid time querying expired conditional properties", zzcgj.zzjf(str), Long.valueOf(j));
                    zzc2 = Collections.emptyList();
                } else {
                    zzc2 = zzawh2.zzc("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(zzc2.size());
                for (zzcfi next2 : zzc2) {
                    if (next2 != null) {
                        zzawn().zzayx().zzd("User property expired", next2.packageName, zzawi().zzje(next2.zzivv.name), next2.zzivv.getValue());
                        zzawh().zzaf(str, next2.zzivv.name);
                        if (next2.zziwd != null) {
                            arrayList.add(next2.zziwd);
                        }
                        zzawh().zzai(str, next2.zzivv.name);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    zzc(new zzcfx((zzcfx) obj, j), zzcff);
                }
                zzcfl zzawh3 = zzawh();
                String str2 = zzcfx.name;
                zzbq.zzgi(str);
                zzbq.zzgi(str2);
                zzawh3.zzut();
                zzawh3.zzwu();
                if (j < 0) {
                    zzawh3.zzawn().zzayu().zzd("Invalid time querying triggered conditional properties", zzcgj.zzjf(str), zzawh3.zzawi().zzjc(str2), Long.valueOf(j));
                    zzc3 = Collections.emptyList();
                } else {
                    zzc3 = zzawh3.zzc("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(zzc3.size());
                for (zzcfi next3 : zzc3) {
                    if (next3 != null) {
                        zzckk zzckk = next3.zzivv;
                        zzckm zzckm = new zzckm(next3.packageName, next3.zzivu, zzckk.name, j, zzckk.getValue());
                        if (zzawh().zza(zzckm)) {
                            zzawn().zzayx().zzd("User property triggered", next3.packageName, zzawi().zzje(zzckm.mName), zzckm.mValue);
                        } else {
                            zzawn().zzays().zzd("Too many active user properties, ignoring", zzcgj.zzjf(next3.packageName), zzawi().zzje(zzckm.mName), zzckm.mValue);
                        }
                        if (next3.zziwb != null) {
                            arrayList3.add(next3.zziwb);
                        }
                        next3.zzivv = new zzckk(zzckm);
                        next3.zzivx = true;
                        zzawh().zza(next3);
                    }
                }
                zzc(zzcfx, zzcff);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList4.get(i2);
                    i2++;
                    zzc(new zzcfx((zzcfx) obj2, j), zzcff);
                }
                zzawh().setTransactionSuccessful();
            } finally {
                zzawh().endTransaction();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(zzcfx zzcfx, String str) {
        zzcfe zziw = zzawh().zziw(str);
        if (zziw == null || TextUtils.isEmpty(zziw.zzuy())) {
            zzawn().zzayx().zzj("No app data available; dropping event", str);
            return;
        }
        try {
            String str2 = zzbgc.zzcy(this.mContext).getPackageInfo(str, 0).versionName;
            if (zziw.zzuy() != null && !zziw.zzuy().equals(str2)) {
                zzawn().zzayu().zzj("App version does not match; dropping event. appId", zzcgj.zzjf(str));
                return;
            }
        } catch (PackageManager.NameNotFoundException e) {
            if (!"_ui".equals(zzcfx.name)) {
                zzawn().zzayu().zzj("Could not find package. appId", zzcgj.zzjf(str));
            }
        }
        zzcfx zzcfx2 = zzcfx;
        zzb(zzcfx2, new zzcff(str, zziw.getGmpAppId(), zziw.zzuy(), zziw.zzawv(), zziw.zzaww(), zziw.zzawx(), zziw.zzawy(), (String) null, zziw.zzawz(), false, zziw.zzaws(), zziw.zzaxm(), 0, 0, zziw.zzaxn()));
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzcii zzcii) {
        this.zzjdo++;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(zzckk zzckk, zzcff zzcff) {
        int i = 0;
        zzawm().zzut();
        zzwu();
        if (!TextUtils.isEmpty(zzcff.zzivh)) {
            if (!zzcff.zzivm) {
                zzg(zzcff);
                return;
            }
            int zzjy = zzawj().zzjy(zzckk.name);
            if (zzjy != 0) {
                zzawj();
                String zza2 = zzckn.zza(zzckk.name, 24, true);
                if (zzckk.name != null) {
                    i = zzckk.name.length();
                }
                zzawj().zza(zzcff.packageName, zzjy, "_ev", zza2, i);
                return;
            }
            int zzl = zzawj().zzl(zzckk.name, zzckk.getValue());
            if (zzl != 0) {
                zzawj();
                String zza3 = zzckn.zza(zzckk.name, 24, true);
                Object value = zzckk.getValue();
                if (value != null && ((value instanceof String) || (value instanceof CharSequence))) {
                    i = String.valueOf(value).length();
                }
                zzawj().zza(zzcff.packageName, zzl, "_ev", zza3, i);
                return;
            }
            Object zzm = zzawj().zzm(zzckk.name, zzckk.getValue());
            if (zzm != null) {
                zzckm zzckm = new zzckm(zzcff.packageName, zzckk.zzivu, zzckk.name, zzckk.zzjgx, zzm);
                zzawn().zzayx().zze("Setting user property", zzawi().zzje(zzckm.mName), zzm);
                zzawh().beginTransaction();
                try {
                    zzg(zzcff);
                    boolean zza4 = zzawh().zza(zzckm);
                    zzawh().setTransactionSuccessful();
                    if (zza4) {
                        zzawn().zzayx().zze("User property set", zzawi().zzje(zzckm.mName), zzckm.mValue);
                    } else {
                        zzawn().zzays().zze("Too many unique user properties are set. Ignoring user property", zzawi().zzje(zzckm.mName), zzckm.mValue);
                        zzawj().zza(zzcff.packageName, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zzawh().endTransaction();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        boolean z = true;
        zzawm().zzut();
        zzwu();
        zzbq.zzgi(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzjds = false;
                zzbac();
                throw th2;
            }
        }
        zzawn().zzayy().zzj("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        zzawh().beginTransaction();
        zzcfe zziw = zzawh().zziw(str);
        boolean z2 = (i == 200 || i == 204 || i == 304) && th == null;
        if (zziw == null) {
            zzawn().zzayu().zzj("App does not exist in onConfigFetched. appId", zzcgj.zzjf(str));
        } else if (z2 || i == 404) {
            List list = map != null ? map.get("Last-Modified") : null;
            String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
            if (i == 404 || i == 304) {
                if (zzawk().zzjn(str) == null && !zzawk().zzb(str, (byte[]) null, (String) null)) {
                    zzawh().endTransaction();
                    this.zzjds = false;
                    zzbac();
                    return;
                }
            } else if (!zzawk().zzb(str, bArr, str2)) {
                zzawh().endTransaction();
                this.zzjds = false;
                zzbac();
                return;
            }
            zziw.zzaq(this.zzasd.currentTimeMillis());
            zzawh().zza(zziw);
            if (i == 404) {
                zzawn().zzayv().zzj("Config not found. Using empty config. appId", str);
            } else {
                zzawn().zzayy().zze("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            }
            if (!zzazq().zzzh() || !zzazx()) {
                zzazy();
            } else {
                zzazw();
            }
        } else {
            zziw.zzar(this.zzasd.currentTimeMillis());
            zzawh().zza(zziw);
            zzawn().zzayy().zze("Fetching config failed. code, error", Integer.valueOf(i), th);
            zzawk().zzjp(str);
            zzawo().zzjah.set(this.zzasd.currentTimeMillis());
            if (!(i == 503 || i == 429)) {
                z = false;
            }
            if (z) {
                zzawo().zzjai.set(this.zzasd.currentTimeMillis());
            }
            zzazy();
        }
        zzawh().setTransactionSuccessful();
        zzawh().endTransaction();
        this.zzjds = false;
        zzbac();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzbaa() {
        zzawm().zzut();
        zzwu();
        if (!this.zzjdh) {
            zzawn().zzayw().log("This instance being marked as an uploader");
            zzawm().zzut();
            zzwu();
            if (zzbab() && zzazt()) {
                int zza2 = zza(this.zzjdl);
                int zzayp = zzawc().zzayp();
                zzawm().zzut();
                if (zza2 > zzayp) {
                    zzawn().zzays().zze("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzayp));
                } else if (zza2 < zzayp) {
                    if (zza(zzayp, this.zzjdl)) {
                        zzawn().zzayy().zze("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzayp));
                    } else {
                        zzawn().zzays().zze("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzayp));
                    }
                }
            }
            this.zzjdh = true;
            zzazy();
        }
    }

    public final void zzbn(boolean z) {
        zzazy();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzc(zzcfi zzcfi, zzcff zzcff) {
        zzbq.checkNotNull(zzcfi);
        zzbq.zzgi(zzcfi.packageName);
        zzbq.checkNotNull(zzcfi.zzivv);
        zzbq.zzgi(zzcfi.zzivv.name);
        zzawm().zzut();
        zzwu();
        if (!TextUtils.isEmpty(zzcff.zzivh)) {
            if (!zzcff.zzivm) {
                zzg(zzcff);
                return;
            }
            zzawh().beginTransaction();
            try {
                zzg(zzcff);
                zzcfi zzah = zzawh().zzah(zzcfi.packageName, zzcfi.zzivv.name);
                if (zzah != null) {
                    zzawn().zzayx().zze("Removing conditional user property", zzcfi.packageName, zzawi().zzje(zzcfi.zzivv.name));
                    zzawh().zzai(zzcfi.packageName, zzcfi.zzivv.name);
                    if (zzah.zzivx) {
                        zzawh().zzaf(zzcfi.packageName, zzcfi.zzivv.name);
                    }
                    if (zzcfi.zziwd != null) {
                        Bundle bundle = null;
                        if (zzcfi.zziwd.zzixi != null) {
                            bundle = zzcfi.zziwd.zzixi.zzaym();
                        }
                        zzc(zzawj().zza(zzcfi.zziwd.name, bundle, zzah.zzivu, zzcfi.zziwd.zzixj, true, false), zzcff);
                    }
                } else {
                    zzawn().zzayu().zze("Conditional user property doesn't exist", zzcgj.zzjf(zzcfi.packageName), zzawi().zzje(zzcfi.zzivv.name));
                }
                zzawh().setTransactionSuccessful();
            } finally {
                zzawh().endTransaction();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzc(zzckk zzckk, zzcff zzcff) {
        zzawm().zzut();
        zzwu();
        if (!TextUtils.isEmpty(zzcff.zzivh)) {
            if (!zzcff.zzivm) {
                zzg(zzcff);
                return;
            }
            zzawn().zzayx().zzj("Removing user property", zzawi().zzje(zzckk.name));
            zzawh().beginTransaction();
            try {
                zzg(zzcff);
                zzawh().zzaf(zzcff.packageName, zzckk.name);
                zzawh().setTransactionSuccessful();
                zzawn().zzayx().zzj("User property removed", zzawi().zzje(zzckk.name));
            } finally {
                zzawh().endTransaction();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzd(zzcff zzcff) {
        zzawh().zziw(zzcff.packageName);
        zzcfl zzawh = zzawh();
        String str = zzcff.packageName;
        zzbq.zzgi(str);
        zzawh.zzut();
        zzawh.zzwu();
        try {
            SQLiteDatabase writableDatabase = zzawh.getWritableDatabase();
            String[] strArr = {str};
            int delete = writableDatabase.delete("audience_filter_values", "app_id=?", strArr) + writableDatabase.delete("apps", "app_id=?", strArr) + 0 + writableDatabase.delete("events", "app_id=?", strArr) + writableDatabase.delete("user_attributes", "app_id=?", strArr) + writableDatabase.delete("conditional_properties", "app_id=?", strArr) + writableDatabase.delete("raw_events", "app_id=?", strArr) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr) + writableDatabase.delete("queue", "app_id=?", strArr);
            if (delete > 0) {
                zzawh.zzawn().zzayy().zze("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzawh.zzawn().zzays().zze("Error resetting analytics data. appId, error", zzcgj.zzjf(str), e);
        }
        zzf(zza(this.mContext, zzcff.packageName, zzcff.zzivh, zzcff.zzivm, zzcff.zzivt));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzd(zzcfi zzcfi) {
        zzcff zzjr = zzjr(zzcfi.packageName);
        if (zzjr != null) {
            zzb(zzcfi, zzjr);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zze(zzcff zzcff) {
        zzawm().zzut();
        zzwu();
        zzbq.zzgi(zzcff.packageName);
        zzg(zzcff);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zze(zzcfi zzcfi) {
        zzcff zzjr = zzjr(zzcfi.packageName);
        if (zzjr != null) {
            zzc(zzcfi, zzjr);
        }
    }

    @WorkerThread
    public final void zzf(zzcff zzcff) {
        int i;
        zzcfe zziw;
        ApplicationInfo applicationInfo;
        zzcfl zzawh;
        String appId;
        zzawm().zzut();
        zzwu();
        zzbq.checkNotNull(zzcff);
        zzbq.zzgi(zzcff.packageName);
        if (!TextUtils.isEmpty(zzcff.zzivh)) {
            zzcfe zziw2 = zzawh().zziw(zzcff.packageName);
            if (zziw2 != null && TextUtils.isEmpty(zziw2.getGmpAppId()) && !TextUtils.isEmpty(zzcff.zzivh)) {
                zziw2.zzaq(0);
                zzawh().zza(zziw2);
                zzawk().zzjq(zzcff.packageName);
            }
            if (!zzcff.zzivm) {
                zzg(zzcff);
                return;
            }
            long j = zzcff.zzivr;
            if (j == 0) {
                j = this.zzasd.currentTimeMillis();
            }
            int i2 = zzcff.zzivs;
            if (i2 == 0 || i2 == 1) {
                i = i2;
            } else {
                zzawn().zzayu().zze("Incorrect app type, assuming installed app. appId, appType", zzcgj.zzjf(zzcff.packageName), Integer.valueOf(i2));
                i = 0;
            }
            zzawh().beginTransaction();
            try {
                zziw = zzawh().zziw(zzcff.packageName);
                if (!(zziw == null || zziw.getGmpAppId() == null || zziw.getGmpAppId().equals(zzcff.zzivh))) {
                    zzawn().zzayu().zzj("New GMP App Id passed in. Removing cached database data. appId", zzcgj.zzjf(zziw.getAppId()));
                    zzawh = zzawh();
                    appId = zziw.getAppId();
                    zzawh.zzwu();
                    zzawh.zzut();
                    zzbq.zzgi(appId);
                    SQLiteDatabase writableDatabase = zzawh.getWritableDatabase();
                    String[] strArr = {appId};
                    int delete = writableDatabase.delete("audience_filter_values", "app_id=?", strArr) + writableDatabase.delete("events", "app_id=?", strArr) + 0 + writableDatabase.delete("user_attributes", "app_id=?", strArr) + writableDatabase.delete("conditional_properties", "app_id=?", strArr) + writableDatabase.delete("apps", "app_id=?", strArr) + writableDatabase.delete("raw_events", "app_id=?", strArr) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr) + writableDatabase.delete("event_filters", "app_id=?", strArr) + writableDatabase.delete("property_filters", "app_id=?", strArr);
                    if (delete > 0) {
                        zzawh.zzawn().zzayy().zze("Deleted application data. app, records", appId, Integer.valueOf(delete));
                    }
                    zziw = null;
                }
            } catch (SQLiteException e) {
                zzawh.zzawn().zzays().zze("Error deleting application data. appId, error", zzcgj.zzjf(appId), e);
            } catch (Throwable th) {
                zzawh().endTransaction();
                throw th;
            }
            if (zziw != null) {
                if (zziw.zzuy() != null && !zziw.zzuy().equals(zzcff.zzida)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_pv", zziw.zzuy());
                    zzb(new zzcfx("_au", new zzcfu(bundle), "auto", j), zzcff);
                }
            }
            zzg(zzcff);
            zzcft zzcft = null;
            if (i == 0) {
                zzcft = zzawh().zzae(zzcff.packageName, "_f");
            } else if (i == 1) {
                zzcft = zzawh().zzae(zzcff.packageName, "_v");
            }
            if (zzcft == null) {
                long j2 = (1 + (j / 3600000)) * 3600000;
                if (i == 0) {
                    zzb(new zzckk("_fot", j, Long.valueOf(j2), "auto"), zzcff);
                    zzawm().zzut();
                    zzwu();
                    Bundle bundle2 = new Bundle();
                    bundle2.putLong("_c", 1);
                    bundle2.putLong("_r", 1);
                    bundle2.putLong("_uwa", 0);
                    bundle2.putLong("_pfo", 0);
                    bundle2.putLong("_sys", 0);
                    bundle2.putLong("_sysu", 0);
                    if (this.mContext.getPackageManager() == null) {
                        zzawn().zzays().zzj("PackageManager is null, first open report might be inaccurate. appId", zzcgj.zzjf(zzcff.packageName));
                    } else {
                        PackageInfo packageInfo = null;
                        try {
                            packageInfo = zzbgc.zzcy(this.mContext).getPackageInfo(zzcff.packageName, 0);
                        } catch (PackageManager.NameNotFoundException e2) {
                            zzawn().zzays().zze("Package info is null, first open report might be inaccurate. appId", zzcgj.zzjf(zzcff.packageName), e2);
                        }
                        if (packageInfo != null) {
                            if (packageInfo.firstInstallTime != 0) {
                                boolean z = false;
                                if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                    bundle2.putLong("_uwa", 1);
                                } else {
                                    z = true;
                                }
                                zzb(new zzckk("_fi", j, Long.valueOf(z ? 1 : 0), "auto"), zzcff);
                            }
                        }
                        try {
                            applicationInfo = zzbgc.zzcy(this.mContext).getApplicationInfo(zzcff.packageName, 0);
                        } catch (PackageManager.NameNotFoundException e3) {
                            zzawn().zzays().zze("Application info is null, first open report might be inaccurate. appId", zzcgj.zzjf(zzcff.packageName), e3);
                            applicationInfo = null;
                        }
                        if (applicationInfo != null) {
                            if ((applicationInfo.flags & 1) != 0) {
                                bundle2.putLong("_sys", 1);
                            }
                            if ((applicationInfo.flags & 128) != 0) {
                                bundle2.putLong("_sysu", 1);
                            }
                        }
                    }
                    zzcfl zzawh2 = zzawh();
                    String str = zzcff.packageName;
                    zzbq.zzgi(str);
                    zzawh2.zzut();
                    zzawh2.zzwu();
                    long zzal = zzawh2.zzal(str, "first_open_count");
                    if (zzal >= 0) {
                        bundle2.putLong("_pfo", zzal);
                    }
                    zzb(new zzcfx("_f", new zzcfu(bundle2), "auto", j), zzcff);
                } else if (i == 1) {
                    zzb(new zzckk("_fvt", j, Long.valueOf(j2), "auto"), zzcff);
                    zzawm().zzut();
                    zzwu();
                    Bundle bundle3 = new Bundle();
                    bundle3.putLong("_c", 1);
                    bundle3.putLong("_r", 1);
                    zzb(new zzcfx("_v", new zzcfu(bundle3), "auto", j), zzcff);
                }
                Bundle bundle4 = new Bundle();
                bundle4.putLong("_et", 1);
                zzb(new zzcfx("_e", new zzcfu(bundle4), "auto", j), zzcff);
            } else if (zzcff.zzivn) {
                zzb(new zzcfx("_cd", new zzcfu(new Bundle()), "auto", j), zzcff);
            }
            zzawh().setTransactionSuccessful();
            zzawh().endTransaction();
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzi(Runnable runnable) {
        zzawm().zzut();
        if (this.zzjdn == null) {
            this.zzjdn = new ArrayList();
        }
        this.zzjdn.add(runnable);
    }

    public final String zzjs(String str) {
        try {
            return (String) zzawm().zzc(new zzchl(this, str)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzawn().zzays().zze("Failed to get app instance id. appId", zzcgj.zzjf(str), e);
            return null;
        }
    }

    public final zzd zzwh() {
        return this.zzasd;
    }

    /* access modifiers changed from: package-private */
    public final void zzwu() {
        if (!this.zzdqd) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }
}
