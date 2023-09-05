package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.support.p000v4.p002os.EnvironmentCompat;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@zzzb
public class zzyv implements zzyz {
    private static final Object sLock = new Object();
    private static zzyz zzckp = null;
    private final Context mContext;
    private final ExecutorService zzaih = Executors.newCachedThreadPool();
    private final zzaiy zzaqi;
    private final Object zzckq = new Object();
    private final WeakHashMap<Thread, Boolean> zzckr = new WeakHashMap<>();

    protected zzyv(Context context) {
        this.mContext = context;
        this.zzaqi = zzaiy.zzqv();
        Thread thread = Looper.getMainLooper().getThread();
        if (thread != null) {
            synchronized (this.zzckq) {
                this.zzckr.put(thread, true);
            }
            thread.setUncaughtExceptionHandler(new zzyx(this, thread.getUncaughtExceptionHandler()));
        }
        Thread.setDefaultUncaughtExceptionHandler(new zzyw(this, Thread.getDefaultUncaughtExceptionHandler()));
    }

    public static zzyz zzk(Context context) {
        synchronized (sLock) {
            if (zzckp == null) {
                zzckp = new zzza();
            }
        }
        return zzckp;
    }

    private final void zzn(List<String> list) {
        for (String zzyy : list) {
            this.zzaih.submit(new zzyy(this, new zzaix(), zzyy));
        }
    }

    /* access modifiers changed from: protected */
    public Uri.Builder zza(String str, String str2, String str3, int i) {
        boolean z = false;
        try {
            z = zzbgc.zzcy(this.mContext).zzamj();
        } catch (Throwable th) {
            zzaiw.zzb("Error fetching instant app info", th);
        }
        String str4 = EnvironmentCompat.MEDIA_UNKNOWN;
        try {
            str4 = this.mContext.getApplicationContext().getPackageName();
        } catch (Throwable th2) {
            zzaiw.zzco("Cannot obtain package name, proceeding.");
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter(IdentityRealmObject.FIELD_ID, "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
        String str5 = Build.MANUFACTURER;
        String str6 = Build.MODEL;
        if (!str6.startsWith(str5)) {
            str6 = new StringBuilder(String.valueOf(str5).length() + 1 + String.valueOf(str6).length()).append(str5).append(" ").append(str6).toString();
        }
        return appendQueryParameter.appendQueryParameter("device", str6).appendQueryParameter("js", this.zzaqi.zzcp).appendQueryParameter("appid", str4).appendQueryParameter("exceptiontype", str).appendQueryParameter("stacktrace", str2).appendQueryParameter("exceptionkey", str3).appendQueryParameter("cl", "173624900").appendQueryParameter("rc", "dev").appendQueryParameter("session_id", zzjk.zzhz()).appendQueryParameter("sampling_rate", Integer.toString(i));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.Thread r11, java.lang.Throwable r12) {
        /*
            r10 = this;
            r1 = 1
            r3 = 0
            if (r12 == 0) goto L_0x0083
            r2 = r3
            r0 = r3
            r5 = r12
        L_0x0007:
            if (r5 == 0) goto L_0x003a
            java.lang.StackTraceElement[] r6 = r5.getStackTrace()
            int r7 = r6.length
            r4 = r3
        L_0x000f:
            if (r4 >= r7) goto L_0x0034
            r8 = r6[r4]
            java.lang.String r9 = r8.getClassName()
            boolean r9 = com.google.android.gms.internal.zzais.zzcm(r9)
            if (r9 == 0) goto L_0x001e
            r0 = r1
        L_0x001e:
            java.lang.Class r9 = r10.getClass()
            java.lang.String r9 = r9.getName()
            java.lang.String r8 = r8.getClassName()
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x0031
            r2 = r1
        L_0x0031:
            int r4 = r4 + 1
            goto L_0x000f
        L_0x0034:
            java.lang.Throwable r4 = r5.getCause()
            r5 = r4
            goto L_0x0007
        L_0x003a:
            if (r0 == 0) goto L_0x0083
            if (r2 != 0) goto L_0x0083
            r0 = r1
        L_0x003f:
            if (r0 == 0) goto L_0x0082
            java.lang.String r2 = ""
            java.lang.Throwable r0 = com.google.android.gms.internal.zzais.zzc(r12)
            if (r0 == 0) goto L_0x0082
            java.lang.Class r0 = r12.getClass()
            java.lang.String r4 = r0.getName()
            java.io.StringWriter r0 = new java.io.StringWriter
            r0.<init>()
            java.io.PrintWriter r5 = new java.io.PrintWriter
            r5.<init>(r0)
            com.google.android.gms.internal.zzdtf.zza((java.lang.Throwable) r12, (java.io.PrintWriter) r5)
            java.lang.String r5 = r0.toString()
            double r6 = java.lang.Math.random()
            r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x0085
            r0 = r1
        L_0x006d:
            if (r0 == 0) goto L_0x0082
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.net.Uri$Builder r1 = r10.zza(r4, r5, r2, r1)
            java.lang.String r1 = r1.toString()
            r0.add(r1)
            r10.zzn(r0)
        L_0x0082:
            return
        L_0x0083:
            r0 = r3
            goto L_0x003f
        L_0x0085:
            r0 = r3
            goto L_0x006d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzyv.zza(java.lang.Thread, java.lang.Throwable):void");
    }

    public final void zza(Throwable th, String str) {
        if (zzais.zzc(th) != null) {
            String name = th.getClass().getName();
            StringWriter stringWriter = new StringWriter();
            zzdtf.zza(th, new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            if (Math.random() < 1.0d) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(zza(name, stringWriter2, str, 1).toString());
                zzn(arrayList);
            }
        }
    }
}
