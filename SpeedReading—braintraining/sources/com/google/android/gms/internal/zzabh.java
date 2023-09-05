package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.zzbs;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zzabh extends zzaai {
    private static final Object sLock = new Object();
    private static zzabh zzcpt;
    private final Context mContext;
    private final zzabg zzcpu;

    private zzabh(Context context, zzabg zzabg) {
        this.mContext = context;
        this.zzcpu = zzabg;
    }

    private static zzaad zza(Context context, zzabg zzabg, zzzz zzzz) {
        String string;
        zzafj.zzbw("Starting ad request from service using: google.afma.request.getAdDictionary");
        zznd zznd = new zznd(((Boolean) zzbs.zzep().zzd(zzmq.zzbhx)).booleanValue(), "load_ad", zzzz.zzath.zzbda);
        if (zzzz.versionCode > 10 && zzzz.zzcme != -1) {
            zznd.zza(zznd.zzc(zzzz.zzcme), "cts");
        }
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        zznb zziz = zznd.zziz();
        zzajp<V> zza = zzajg.zza(zzabg.zzcpq.zzj(context), ((Long) zzbs.zzep().zzd(zzmq.zzbod)).longValue(), TimeUnit.MILLISECONDS, newSingleThreadScheduledExecutor);
        zzajp<V> zza2 = zzajg.zza(zzabg.zzcpp.zzq(context), ((Long) zzbs.zzep().zzd(zzmq.zzbln)).longValue(), TimeUnit.MILLISECONDS, newSingleThreadScheduledExecutor);
        zzajp<String> zzbx = zzabg.zzcpk.zzbx(zzzz.zzclp.packageName);
        zzajp<String> zza3 = zzabg.zzcpr.zza(zzzz.zzclq, zzzz.zzclp);
        Future<zzabu> zzp = zzbs.zzem().zzp(context);
        zzajp zzi = zzajg.zzi(null);
        Bundle bundle = zzzz.zzclo.extras;
        boolean z = (bundle == null || bundle.getString("_ad") == null) ? false : true;
        if (zzzz.zzcmk && !z) {
            zzi = zzabg.zzcpn.zza(zzzz.applicationInfo);
        }
        zzajp zza4 = zzajg.zza(zzi, ((Long) zzbs.zzep().zzd(zzmq.zzbnm)).longValue(), TimeUnit.MILLISECONDS, newSingleThreadScheduledExecutor);
        Future zza5 = ((Boolean) zzbs.zzep().zzd(zzmq.zzbjt)).booleanValue() ? zzajg.zza(zzabg.zzcpr.zzac(context), ((Long) zzbs.zzep().zzd(zzmq.zzbju)).longValue(), TimeUnit.MILLISECONDS, newSingleThreadScheduledExecutor) : zzajg.zzi(null);
        Bundle bundle2 = (zzzz.versionCode < 4 || zzzz.zzclv == null) ? null : zzzz.zzclv;
        ((Boolean) zzbs.zzep().zzd(zzmq.zzbin)).booleanValue();
        zzbs.zzec();
        if (zzagr.zzd(context, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE") && ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() == null) {
            zzafj.zzbw("Device is offline.");
        }
        String uuid = zzzz.versionCode >= 7 ? zzzz.zzcmb : UUID.randomUUID().toString();
        new zzabn(context, uuid, zzzz.applicationInfo.packageName);
        if (zzzz.zzclo.extras != null && (string = zzzz.zzclo.extras.getString("_ad")) != null) {
            return zzabm.zza(context, zzzz, string);
        }
        List<String> zze = zzabg.zzcpl.zze(zzzz.zzcmc);
        Bundle bundle3 = (Bundle) zzajg.zza(zza, null, ((Long) zzbs.zzep().zzd(zzmq.zzbod)).longValue(), TimeUnit.MILLISECONDS);
        zzace zzace = (zzace) zzajg.zza(zza2, null);
        Location location = (Location) zzajg.zza(zza4, null);
        AdvertisingIdClient.Info info = (AdvertisingIdClient.Info) zzajg.zza(zza5, null);
        String str = (String) zzajg.zza(zza3, null);
        String str2 = (String) zzajg.zza(zzbx, null);
        zzabu zzabu = (zzabu) zzajg.zza(zzp, null);
        if (zzabu == null) {
            zzafj.zzco("Error fetching device info. This is not recoverable.");
            return new zzaad(0);
        }
        zzabf zzabf = new zzabf();
        zzabf.zzcpe = zzzz;
        zzabf.zzcpf = zzabu;
        zzabf.zzcpb = zzace;
        zzabf.zzbcd = location;
        zzabf.zzcpa = bundle3;
        zzabf.zzclq = str;
        zzabf.zzcpd = info;
        if (zze == null) {
            zzabf.zzcmc.clear();
        }
        zzabf.zzcmc = zze;
        zzabf.zzclv = bundle2;
        zzabf.zzcpc = str2;
        zzabf.zzcpg = zzabg.zzcpj.zzf(context);
        zzabf.zzcph = zzabg.zzcph;
        JSONObject zza6 = zzabm.zza(context, zzabf);
        if (zza6 == null) {
            return new zzaad(0);
        }
        if (zzzz.versionCode < 7) {
            try {
                zza6.put("request_id", uuid);
            } catch (JSONException e) {
            }
        }
        zza6.toString();
        zznd.zza(zziz, "arc");
        zznd.zziz();
        zzajp<V> zza7 = zzajg.zza(zzajg.zza(zzabg.zzcps.zznk().zzg(zza6), zzabi.zzcpv, (Executor) Executors.newSingleThreadScheduledExecutor()), 10, TimeUnit.SECONDS, newSingleThreadScheduledExecutor);
        zzajp<Void> zznt = zzabg.zzcpm.zznt();
        if (zznt != null) {
            zzaje.zza(zznt, "AdRequestServiceImpl.loadAd.flags");
        }
        zzabt zzabt = (zzabt) zzajg.zza(zza7, null);
        if (zzabt == null) {
            return new zzaad(0);
        }
        if (zzabt.getErrorCode() != -2) {
            return new zzaad(zzabt.getErrorCode());
        }
        zznd.zzjc();
        zzaad zzaad = null;
        if (!TextUtils.isEmpty(zzabt.zznq())) {
            zzaad = zzabm.zza(context, zzzz, zzabt.zznq());
        }
        if (zzaad == null && !TextUtils.isEmpty(zzabt.getUrl())) {
            zzaad = zza(zzzz, context, zzzz.zzatd.zzcp, zzabt.getUrl(), str2, zzabt, zznd, zzabg);
        }
        if (zzaad == null) {
            zzaad = new zzaad(0);
        }
        zznd.zza(zziz, "tts");
        zzaad.zzcnt = zznd.zzja();
        return zzaad;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:109:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a4, code lost:
        r3 = r7.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r5 = new java.io.InputStreamReader(r2.getInputStream());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        com.google.android.gms.ads.internal.zzbs.zzec();
        r6 = com.google.android.gms.internal.zzagr.zza(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        com.google.android.gms.common.util.zzn.closeQuietly(r5);
        zza(r3, r12, r6, r9);
        r8.zza(r3, r12, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c2, code lost:
        if (r19 == null) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c4, code lost:
        r19.zza(r4, "ufe");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d1, code lost:
        r3 = r8.zza(r10, r18.zznr());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0113, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0114, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        com.google.android.gms.common.util.zzn.closeQuietly(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0118, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01aa, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01ab, code lost:
        r4 = r5;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:63:0x0115=Splitter:B:63:0x0115, B:54:0x010a=Splitter:B:54:0x010a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.zzaad zza(com.google.android.gms.internal.zzzz r13, android.content.Context r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, com.google.android.gms.internal.zzabt r18, com.google.android.gms.internal.zznd r19, com.google.android.gms.internal.zzabg r20) {
        /*
            if (r19 == 0) goto L_0x00de
            com.google.android.gms.internal.zznb r2 = r19.zziz()
            r4 = r2
        L_0x0007:
            com.google.android.gms.internal.zzabr r8 = new com.google.android.gms.internal.zzabr     // Catch:{ IOException -> 0x00e9 }
            java.lang.String r2 = r18.zznn()     // Catch:{ IOException -> 0x00e9 }
            r8.<init>(r13, r2)     // Catch:{ IOException -> 0x00e9 }
            java.lang.String r3 = "AdRequestServiceImpl: Sending request: "
            java.lang.String r2 = java.lang.String.valueOf(r16)     // Catch:{ IOException -> 0x00e9 }
            int r5 = r2.length()     // Catch:{ IOException -> 0x00e9 }
            if (r5 == 0) goto L_0x00e2
            java.lang.String r2 = r3.concat(r2)     // Catch:{ IOException -> 0x00e9 }
        L_0x0020:
            com.google.android.gms.internal.zzafj.zzbw(r2)     // Catch:{ IOException -> 0x00e9 }
            java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x00e9 }
            r0 = r16
            r3.<init>(r0)     // Catch:{ IOException -> 0x00e9 }
            r2 = 0
            com.google.android.gms.common.util.zzd r5 = com.google.android.gms.ads.internal.zzbs.zzei()     // Catch:{ IOException -> 0x00e9 }
            long r10 = r5.elapsedRealtime()     // Catch:{ IOException -> 0x00e9 }
            r7 = r3
            r3 = r2
        L_0x0035:
            java.net.URLConnection r2 = r7.openConnection()     // Catch:{ IOException -> 0x00e9 }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00e9 }
            com.google.android.gms.internal.zzagr r5 = com.google.android.gms.ads.internal.zzbs.zzec()     // Catch:{ all -> 0x010e }
            r6 = 0
            r5.zza((android.content.Context) r14, (java.lang.String) r15, (boolean) r6, (java.net.HttpURLConnection) r2)     // Catch:{ all -> 0x010e }
            boolean r5 = android.text.TextUtils.isEmpty(r17)     // Catch:{ all -> 0x010e }
            if (r5 != 0) goto L_0x0056
            boolean r5 = r18.zznp()     // Catch:{ all -> 0x010e }
            if (r5 == 0) goto L_0x0056
            java.lang.String r5 = "x-afma-drt-cookie"
            r0 = r17
            r2.addRequestProperty(r5, r0)     // Catch:{ all -> 0x010e }
        L_0x0056:
            java.lang.String r5 = r13.zzcml     // Catch:{ all -> 0x010e }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x010e }
            if (r6 != 0) goto L_0x0068
            java.lang.String r6 = "Sending webview cookie in ad request header."
            com.google.android.gms.internal.zzafj.zzbw(r6)     // Catch:{ all -> 0x010e }
            java.lang.String r6 = "Cookie"
            r2.addRequestProperty(r6, r5)     // Catch:{ all -> 0x010e }
        L_0x0068:
            if (r18 == 0) goto L_0x0094
            java.lang.String r5 = r18.zzno()     // Catch:{ all -> 0x010e }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x010e }
            if (r5 != 0) goto L_0x0094
            r5 = 1
            r2.setDoOutput(r5)     // Catch:{ all -> 0x010e }
            java.lang.String r5 = r18.zzno()     // Catch:{ all -> 0x010e }
            byte[] r9 = r5.getBytes()     // Catch:{ all -> 0x010e }
            int r5 = r9.length     // Catch:{ all -> 0x010e }
            r2.setFixedLengthStreamingMode(r5)     // Catch:{ all -> 0x010e }
            r6 = 0
            java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0108 }
            java.io.OutputStream r12 = r2.getOutputStream()     // Catch:{ all -> 0x0108 }
            r5.<init>(r12)     // Catch:{ all -> 0x0108 }
            r5.write(r9)     // Catch:{ all -> 0x01ae }
            com.google.android.gms.common.util.zzn.closeQuietly(r5)     // Catch:{ all -> 0x010e }
        L_0x0094:
            int r9 = r2.getResponseCode()     // Catch:{ all -> 0x010e }
            java.util.Map r12 = r2.getHeaderFields()     // Catch:{ all -> 0x010e }
            r5 = 200(0xc8, float:2.8E-43)
            if (r9 < r5) goto L_0x0119
            r5 = 300(0x12c, float:4.2E-43)
            if (r9 >= r5) goto L_0x0119
            java.lang.String r3 = r7.toString()     // Catch:{ all -> 0x010e }
            r6 = 0
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ all -> 0x0113 }
            java.io.InputStream r7 = r2.getInputStream()     // Catch:{ all -> 0x0113 }
            r5.<init>(r7)     // Catch:{ all -> 0x0113 }
            com.google.android.gms.ads.internal.zzbs.zzec()     // Catch:{ all -> 0x01aa }
            java.lang.String r6 = com.google.android.gms.internal.zzagr.zza((java.io.InputStreamReader) r5)     // Catch:{ all -> 0x01aa }
            com.google.android.gms.common.util.zzn.closeQuietly(r5)     // Catch:{ all -> 0x010e }
            zza(r3, r12, r6, r9)     // Catch:{ all -> 0x010e }
            r8.zza(r3, r12, r6)     // Catch:{ all -> 0x010e }
            if (r19 == 0) goto L_0x00d1
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ all -> 0x010e }
            r5 = 0
            java.lang.String r6 = "ufe"
            r3[r5] = r6     // Catch:{ all -> 0x010e }
            r0 = r19
            r0.zza(r4, r3)     // Catch:{ all -> 0x010e }
        L_0x00d1:
            boolean r3 = r18.zznr()     // Catch:{ all -> 0x010e }
            com.google.android.gms.internal.zzaad r3 = r8.zza((long) r10, (boolean) r3)     // Catch:{ all -> 0x010e }
            r2.disconnect()     // Catch:{ IOException -> 0x00e9 }
            r2 = r3
        L_0x00dd:
            return r2
        L_0x00de:
            r2 = 0
            r4 = r2
            goto L_0x0007
        L_0x00e2:
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x00e9 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x00e9 }
            goto L_0x0020
        L_0x00e9:
            r2 = move-exception
            java.lang.String r3 = "Error while connecting to ad server: "
            java.lang.String r2 = r2.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r4 = r2.length()
            if (r4 == 0) goto L_0x01a3
            java.lang.String r2 = r3.concat(r2)
        L_0x00fe:
            com.google.android.gms.internal.zzafj.zzco(r2)
            com.google.android.gms.internal.zzaad r2 = new com.google.android.gms.internal.zzaad
            r3 = 2
            r2.<init>(r3)
            goto L_0x00dd
        L_0x0108:
            r3 = move-exception
            r4 = r6
        L_0x010a:
            com.google.android.gms.common.util.zzn.closeQuietly(r4)     // Catch:{ all -> 0x010e }
            throw r3     // Catch:{ all -> 0x010e }
        L_0x010e:
            r3 = move-exception
            r2.disconnect()     // Catch:{ IOException -> 0x00e9 }
            throw r3     // Catch:{ IOException -> 0x00e9 }
        L_0x0113:
            r3 = move-exception
            r4 = r6
        L_0x0115:
            com.google.android.gms.common.util.zzn.closeQuietly(r4)     // Catch:{ all -> 0x010e }
            throw r3     // Catch:{ all -> 0x010e }
        L_0x0119:
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x010e }
            r6 = 0
            zza(r5, r12, r6, r9)     // Catch:{ all -> 0x010e }
            r5 = 300(0x12c, float:4.2E-43)
            if (r9 < r5) goto L_0x016f
            r5 = 400(0x190, float:5.6E-43)
            if (r9 >= r5) goto L_0x016f
            java.lang.String r5 = "Location"
            java.lang.String r5 = r2.getHeaderField(r5)     // Catch:{ all -> 0x010e }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x010e }
            if (r6 == 0) goto L_0x0145
            java.lang.String r3 = "No location header to follow redirect."
            com.google.android.gms.internal.zzafj.zzco(r3)     // Catch:{ all -> 0x010e }
            com.google.android.gms.internal.zzaad r3 = new com.google.android.gms.internal.zzaad     // Catch:{ all -> 0x010e }
            r4 = 0
            r3.<init>(r4)     // Catch:{ all -> 0x010e }
            r2.disconnect()     // Catch:{ IOException -> 0x00e9 }
            r2 = r3
            goto L_0x00dd
        L_0x0145:
            java.net.URL r6 = new java.net.URL     // Catch:{ all -> 0x010e }
            r6.<init>(r5)     // Catch:{ all -> 0x010e }
            int r5 = r3 + 1
            com.google.android.gms.internal.zzmg<java.lang.Integer> r3 = com.google.android.gms.internal.zzmq.zzbpm     // Catch:{ all -> 0x010e }
            com.google.android.gms.internal.zzmo r7 = com.google.android.gms.ads.internal.zzbs.zzep()     // Catch:{ all -> 0x010e }
            java.lang.Object r3 = r7.zzd(r3)     // Catch:{ all -> 0x010e }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x010e }
            int r3 = r3.intValue()     // Catch:{ all -> 0x010e }
            if (r5 <= r3) goto L_0x0193
            java.lang.String r3 = "Too many redirects."
            com.google.android.gms.internal.zzafj.zzco(r3)     // Catch:{ all -> 0x010e }
            com.google.android.gms.internal.zzaad r3 = new com.google.android.gms.internal.zzaad     // Catch:{ all -> 0x010e }
            r4 = 0
            r3.<init>(r4)     // Catch:{ all -> 0x010e }
            r2.disconnect()     // Catch:{ IOException -> 0x00e9 }
            r2 = r3
            goto L_0x00dd
        L_0x016f:
            r3 = 46
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            r4.<init>(r3)     // Catch:{ all -> 0x010e }
            java.lang.String r3 = "Received error HTTP response code: "
            java.lang.StringBuilder r3 = r4.append(r3)     // Catch:{ all -> 0x010e }
            java.lang.StringBuilder r3 = r3.append(r9)     // Catch:{ all -> 0x010e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x010e }
            com.google.android.gms.internal.zzafj.zzco(r3)     // Catch:{ all -> 0x010e }
            com.google.android.gms.internal.zzaad r3 = new com.google.android.gms.internal.zzaad     // Catch:{ all -> 0x010e }
            r4 = 0
            r3.<init>(r4)     // Catch:{ all -> 0x010e }
            r2.disconnect()     // Catch:{ IOException -> 0x00e9 }
            r2 = r3
            goto L_0x00dd
        L_0x0193:
            r8.zzn(r12)     // Catch:{ all -> 0x010e }
            r2.disconnect()     // Catch:{ IOException -> 0x00e9 }
            if (r20 == 0) goto L_0x019f
            r3 = r5
            r7 = r6
            goto L_0x0035
        L_0x019f:
            r3 = r5
            r7 = r6
            goto L_0x0035
        L_0x01a3:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r3)
            goto L_0x00fe
        L_0x01aa:
            r3 = move-exception
            r4 = r5
            goto L_0x0115
        L_0x01ae:
            r3 = move-exception
            r4 = r5
            goto L_0x010a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzabh.zza(com.google.android.gms.internal.zzzz, android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.zzabt, com.google.android.gms.internal.zznd, com.google.android.gms.internal.zzabg):com.google.android.gms.internal.zzaad");
    }

    public static zzabh zza(Context context, zzabg zzabg) {
        zzabh zzabh;
        synchronized (sLock) {
            if (zzcpt == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzmq.initialize(context);
                zzcpt = new zzabh(context, zzabg);
            }
            zzabh = zzcpt;
        }
        return zzabh;
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (zzafj.zzae(2)) {
            zzafj.m11v(new StringBuilder(String.valueOf(str).length() + 39).append("Http Response: {\n  URL:\n    ").append(str).append("\n  Headers:").toString());
            if (map != null) {
                for (String next : map.keySet()) {
                    zzafj.m11v(new StringBuilder(String.valueOf(next).length() + 5).append("    ").append(next).append(":").toString());
                    for (String valueOf : map.get(next)) {
                        String valueOf2 = String.valueOf(valueOf);
                        zzafj.m11v(valueOf2.length() != 0 ? "      ".concat(valueOf2) : new String("      "));
                    }
                }
            }
            zzafj.m11v("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    zzafj.m11v(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                zzafj.m11v("    null");
            }
            zzafj.m11v(new StringBuilder(34).append("  Response Code:\n    ").append(i).append("\n}").toString());
        }
    }

    public final void zza(zzaas zzaas, zzaan zzaan) {
        zzafj.m11v("Nonagon code path entered in octagon");
        throw new IllegalArgumentException();
    }

    public final void zza(zzzz zzzz, zzaak zzaak) {
        zzbs.zzeg().zzd(this.mContext, zzzz.zzatd);
        zzajp<Void> zza = zzagl.zza(new zzabj(this, zzzz, zzaak));
        zzbs.zzet().zzqm();
        zzbs.zzet().getHandler().postDelayed(new zzabk(this, zza), 60000);
    }

    public final zzaad zzb(zzzz zzzz) {
        return zza(this.mContext, this.zzcpu, zzzz);
    }
}
