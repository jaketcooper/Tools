package com.google.android.gms.internal;

import android.content.Context;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@zzzb
public final class zzmt {
    private Context mContext;
    private String zzaus;
    private String zzbqf;
    private BlockingQueue<zznd> zzbqh;
    private ExecutorService zzbqi;
    private LinkedHashMap<String, String> zzbqj = new LinkedHashMap<>();
    private Map<String, zzmx> zzbqk = new HashMap();
    private AtomicBoolean zzbql;
    private File zzbqm;

    public zzmt(Context context, String str, String str2, Map<String, String> map) {
        File externalStorageDirectory;
        this.mContext = context;
        this.zzaus = str;
        this.zzbqf = str2;
        this.zzbql = new AtomicBoolean(false);
        this.zzbql.set(((Boolean) zzbs.zzep().zzd(zzmq.zzbhz)).booleanValue());
        if (this.zzbql.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.zzbqm = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry next : map.entrySet()) {
            this.zzbqj.put((String) next.getKey(), (String) next.getValue());
        }
        this.zzbqh = new ArrayBlockingQueue(30);
        this.zzbqi = Executors.newSingleThreadExecutor();
        this.zzbqi.execute(new zzmu(this));
        this.zzbqk.put("action", zzmx.zzbqp);
        this.zzbqk.put("ad_format", zzmx.zzbqp);
        this.zzbqk.put("e", zzmx.zzbqq);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a0 A[SYNTHETIC, Splitter:B:30:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b1 A[SYNTHETIC, Splitter:B:37:0x00b1] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0000 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zziv() {
        /*
            r5 = this;
        L_0x0000:
            java.util.concurrent.BlockingQueue<com.google.android.gms.internal.zznd> r0 = r5.zzbqh     // Catch:{ InterruptedException -> 0x004a }
            java.lang.Object r0 = r0.take()     // Catch:{ InterruptedException -> 0x004a }
            com.google.android.gms.internal.zznd r0 = (com.google.android.gms.internal.zznd) r0     // Catch:{ InterruptedException -> 0x004a }
            java.lang.String r2 = r0.zzja()     // Catch:{ InterruptedException -> 0x004a }
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x0000
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r1 = r5.zzbqj
            java.util.Map r0 = r0.zzjb()
            java.util.Map r0 = r5.zza(r1, r0)
            java.lang.String r1 = r5.zzbqf
            android.net.Uri r1 = android.net.Uri.parse(r1)
            android.net.Uri$Builder r3 = r1.buildUpon()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r4 = r0.iterator()
        L_0x002e:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0051
            java.lang.Object r0 = r4.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r3.appendQueryParameter(r1, r0)
            goto L_0x002e
        L_0x004a:
            r0 = move-exception
            java.lang.String r1 = "CsiReporter:reporter interrupted"
            com.google.android.gms.internal.zzafj.zzc(r1, r0)
            return
        L_0x0051:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            android.net.Uri r1 = r3.build()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.lang.String r1 = "&it="
            java.lang.StringBuilder r1 = r0.append(r1)
            r1.append(r2)
            java.lang.String r0 = r0.toString()
            java.util.concurrent.atomic.AtomicBoolean r1 = r5.zzbql
            boolean r1 = r1.get()
            if (r1 == 0) goto L_0x00c3
            java.io.File r3 = r5.zzbqm
            if (r3 == 0) goto L_0x00bc
            r2 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0097, all -> 0x00ad }
            r4 = 1
            r1.<init>(r3, r4)     // Catch:{ IOException -> 0x0097, all -> 0x00ad }
            byte[] r0 = r0.getBytes()     // Catch:{ IOException -> 0x00d1 }
            r1.write(r0)     // Catch:{ IOException -> 0x00d1 }
            r0 = 10
            r1.write(r0)     // Catch:{ IOException -> 0x00d1 }
            r1.close()     // Catch:{ IOException -> 0x008f }
            goto L_0x0000
        L_0x008f:
            r0 = move-exception
            java.lang.String r1 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.internal.zzafj.zzc(r1, r0)
            goto L_0x0000
        L_0x0097:
            r0 = move-exception
            r1 = r2
        L_0x0099:
            java.lang.String r2 = "CsiReporter: Cannot write to file: sdk_csi_data.txt."
            com.google.android.gms.internal.zzafj.zzc(r2, r0)     // Catch:{ all -> 0x00cf }
            if (r1 == 0) goto L_0x0000
            r1.close()     // Catch:{ IOException -> 0x00a5 }
            goto L_0x0000
        L_0x00a5:
            r0 = move-exception
            java.lang.String r1 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.internal.zzafj.zzc(r1, r0)
            goto L_0x0000
        L_0x00ad:
            r0 = move-exception
            r1 = r2
        L_0x00af:
            if (r1 == 0) goto L_0x00b4
            r1.close()     // Catch:{ IOException -> 0x00b5 }
        L_0x00b4:
            throw r0
        L_0x00b5:
            r1 = move-exception
            java.lang.String r2 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.internal.zzafj.zzc(r2, r1)
            goto L_0x00b4
        L_0x00bc:
            java.lang.String r0 = "CsiReporter: File doesn't exists. Cannot write CSI data to file."
            com.google.android.gms.internal.zzafj.zzco(r0)
            goto L_0x0000
        L_0x00c3:
            com.google.android.gms.ads.internal.zzbs.zzec()
            android.content.Context r1 = r5.mContext
            java.lang.String r2 = r5.zzaus
            com.google.android.gms.internal.zzagr.zze(r1, r2, r0)
            goto L_0x0000
        L_0x00cf:
            r0 = move-exception
            goto L_0x00af
        L_0x00d1:
            r0 = move-exception
            goto L_0x0099
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzmt.zziv():void");
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> zza(Map<String, String> map, @Nullable Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry next : map2.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) linkedHashMap.get(str);
            linkedHashMap.put(str, zzal(str).zze(str2, (String) next.getValue()));
        }
        return linkedHashMap;
    }

    public final boolean zza(zznd zznd) {
        return this.zzbqh.offer(zznd);
    }

    public final zzmx zzal(String str) {
        zzmx zzmx = this.zzbqk.get(str);
        return zzmx != null ? zzmx : zzmx.zzbqo;
    }

    public final void zzf(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.zzbqj.put("e", TextUtils.join(",", list));
        }
    }
}
