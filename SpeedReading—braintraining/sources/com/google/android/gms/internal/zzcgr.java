package com.google.android.gms.internal;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzbq;
import java.net.URL;
import java.util.Map;

@WorkerThread
final class zzcgr implements Runnable {
    private final String mPackageName;
    private final URL zzbwa;
    private final byte[] zzgdn;
    private final zzcgp zzizz;
    private final Map<String, String> zzjaa;
    private /* synthetic */ zzcgn zzjab;

    public zzcgr(zzcgn zzcgn, String str, URL url, byte[] bArr, Map<String, String> map, zzcgp zzcgp) {
        this.zzjab = zzcgn;
        zzbq.zzgi(str);
        zzbq.checkNotNull(url);
        zzbq.checkNotNull(zzcgp);
        this.zzbwa = url;
        this.zzgdn = bArr;
        this.zzizz = zzcgp;
        this.mPackageName = str;
        this.zzjaa = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x010e A[SYNTHETIC, Splitter:B:42:0x010e] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0020 A[SYNTHETIC, Splitter:B:9:0x0020] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r14 = this;
            r3 = 0
            r4 = 0
            com.google.android.gms.internal.zzcgn r0 = r14.zzjab
            r0.zzavy()
            java.net.URL r0 = r14.zzbwa     // Catch:{ IOException -> 0x0019, all -> 0x0107 }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ IOException -> 0x0019, all -> 0x0107 }
            boolean r1 = r0 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x0019, all -> 0x0107 }
            if (r1 != 0) goto L_0x003d
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0019, all -> 0x0107 }
            java.lang.String r1 = "Failed to obtain HTTP connection"
            r0.<init>(r1)     // Catch:{ IOException -> 0x0019, all -> 0x0107 }
            throw r0     // Catch:{ IOException -> 0x0019, all -> 0x0107 }
        L_0x0019:
            r9 = move-exception
            r11 = r4
            r8 = r3
            r0 = r4
            r1 = r4
        L_0x001e:
            if (r0 == 0) goto L_0x0023
            r0.close()     // Catch:{ IOException -> 0x00ef }
        L_0x0023:
            if (r1 == 0) goto L_0x0028
            r1.disconnect()
        L_0x0028:
            com.google.android.gms.internal.zzcgn r0 = r14.zzjab
            com.google.android.gms.internal.zzche r0 = r0.zzawm()
            com.google.android.gms.internal.zzcgq r5 = new com.google.android.gms.internal.zzcgq
            java.lang.String r6 = r14.mPackageName
            com.google.android.gms.internal.zzcgp r7 = r14.zzizz
            r10 = r4
            r12 = r4
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r0.zzg(r5)
        L_0x003c:
            return
        L_0x003d:
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x0019, all -> 0x0107 }
            r1 = 0
            r0.setDefaultUseCaches(r1)     // Catch:{ IOException -> 0x0019, all -> 0x0107 }
            r1 = 60000(0xea60, float:8.4078E-41)
            r0.setConnectTimeout(r1)     // Catch:{ IOException -> 0x0019, all -> 0x0107 }
            r1 = 61000(0xee48, float:8.5479E-41)
            r0.setReadTimeout(r1)     // Catch:{ IOException -> 0x0019, all -> 0x0107 }
            r1 = 0
            r0.setInstanceFollowRedirects(r1)     // Catch:{ IOException -> 0x0019, all -> 0x0107 }
            r1 = 1
            r0.setDoInput(r1)     // Catch:{ IOException -> 0x0019, all -> 0x0107 }
            java.util.Map<java.lang.String, java.lang.String> r1 = r14.zzjaa     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            if (r1 == 0) goto L_0x0087
            java.util.Map<java.lang.String, java.lang.String> r1 = r14.zzjaa     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            java.util.Set r1 = r1.entrySet()     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            java.util.Iterator r5 = r1.iterator()     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
        L_0x0065:
            boolean r1 = r5.hasNext()     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            if (r1 == 0) goto L_0x0087
            java.lang.Object r1 = r5.next()     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            java.lang.Object r2 = r1.getKey()     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            r0.addRequestProperty(r2, r1)     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            goto L_0x0065
        L_0x0081:
            r9 = move-exception
            r11 = r4
            r8 = r3
            r1 = r0
            r0 = r4
            goto L_0x001e
        L_0x0087:
            byte[] r1 = r14.zzgdn     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            if (r1 == 0) goto L_0x00c7
            com.google.android.gms.internal.zzcgn r1 = r14.zzjab     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            com.google.android.gms.internal.zzckn r1 = r1.zzawj()     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            byte[] r2 = r14.zzgdn     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            byte[] r2 = r1.zzp((byte[]) r2)     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            com.google.android.gms.internal.zzcgn r1 = r14.zzjab     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            com.google.android.gms.internal.zzcgj r1 = r1.zzawn()     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            com.google.android.gms.internal.zzcgl r1 = r1.zzayy()     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            java.lang.String r5 = "Uploading data. size"
            int r6 = r2.length     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            r1.zzj(r5, r6)     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            r1 = 1
            r0.setDoOutput(r1)     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            java.lang.String r1 = "Content-Encoding"
            java.lang.String r5 = "gzip"
            r0.addRequestProperty(r1, r5)     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            int r1 = r2.length     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            r0.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            r0.connect()     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            java.io.OutputStream r1 = r0.getOutputStream()     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            r1.write(r2)     // Catch:{ IOException -> 0x014f, all -> 0x0147 }
            r1.close()     // Catch:{ IOException -> 0x014f, all -> 0x0147 }
        L_0x00c7:
            int r3 = r0.getResponseCode()     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            java.util.Map r6 = r0.getHeaderFields()     // Catch:{ IOException -> 0x0081, all -> 0x0142 }
            com.google.android.gms.internal.zzcgn r1 = r14.zzjab     // Catch:{ IOException -> 0x0157, all -> 0x014b }
            byte[] r5 = com.google.android.gms.internal.zzcgn.zzc(r0)     // Catch:{ IOException -> 0x0157, all -> 0x014b }
            if (r0 == 0) goto L_0x00da
            r0.disconnect()
        L_0x00da:
            com.google.android.gms.internal.zzcgn r0 = r14.zzjab
            com.google.android.gms.internal.zzche r8 = r0.zzawm()
            com.google.android.gms.internal.zzcgq r0 = new com.google.android.gms.internal.zzcgq
            java.lang.String r1 = r14.mPackageName
            com.google.android.gms.internal.zzcgp r2 = r14.zzizz
            r7 = r4
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r8.zzg(r0)
            goto L_0x003c
        L_0x00ef:
            r0 = move-exception
            com.google.android.gms.internal.zzcgn r2 = r14.zzjab
            com.google.android.gms.internal.zzcgj r2 = r2.zzawn()
            com.google.android.gms.internal.zzcgl r2 = r2.zzays()
            java.lang.String r3 = "Error closing HTTP compressed POST connection output stream. appId"
            java.lang.String r5 = r14.mPackageName
            java.lang.Object r5 = com.google.android.gms.internal.zzcgj.zzjf(r5)
            r2.zze(r3, r5, r0)
            goto L_0x0023
        L_0x0107:
            r0 = move-exception
            r8 = r0
            r6 = r4
            r1 = r4
            r0 = r4
        L_0x010c:
            if (r1 == 0) goto L_0x0111
            r1.close()     // Catch:{ IOException -> 0x012b }
        L_0x0111:
            if (r0 == 0) goto L_0x0116
            r0.disconnect()
        L_0x0116:
            com.google.android.gms.internal.zzcgn r0 = r14.zzjab
            com.google.android.gms.internal.zzche r9 = r0.zzawm()
            com.google.android.gms.internal.zzcgq r0 = new com.google.android.gms.internal.zzcgq
            java.lang.String r1 = r14.mPackageName
            com.google.android.gms.internal.zzcgp r2 = r14.zzizz
            r5 = r4
            r7 = r4
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r9.zzg(r0)
            throw r8
        L_0x012b:
            r1 = move-exception
            com.google.android.gms.internal.zzcgn r2 = r14.zzjab
            com.google.android.gms.internal.zzcgj r2 = r2.zzawn()
            com.google.android.gms.internal.zzcgl r2 = r2.zzays()
            java.lang.String r5 = "Error closing HTTP compressed POST connection output stream. appId"
            java.lang.String r7 = r14.mPackageName
            java.lang.Object r7 = com.google.android.gms.internal.zzcgj.zzjf(r7)
            r2.zze(r5, r7, r1)
            goto L_0x0111
        L_0x0142:
            r1 = move-exception
            r8 = r1
            r6 = r4
            r1 = r4
            goto L_0x010c
        L_0x0147:
            r2 = move-exception
            r8 = r2
            r6 = r4
            goto L_0x010c
        L_0x014b:
            r1 = move-exception
            r8 = r1
            r1 = r4
            goto L_0x010c
        L_0x014f:
            r9 = move-exception
            r11 = r4
            r8 = r3
            r13 = r1
            r1 = r0
            r0 = r13
            goto L_0x001e
        L_0x0157:
            r9 = move-exception
            r11 = r6
            r8 = r3
            r1 = r0
            r0 = r4
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgr.run():void");
    }
}
