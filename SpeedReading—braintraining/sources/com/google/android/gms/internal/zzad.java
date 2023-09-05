package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class zzad implements zzk {
    private static boolean DEBUG = zzab.DEBUG;
    private zzam zzbm;
    private zzae zzbn;

    public zzad(zzam zzam) {
        this(zzam, new zzae(4096));
    }

    private zzad(zzam zzam, zzae zzae) {
        this.zzbm = zzam;
        this.zzbn = zzae;
    }

    private static Map<String, String> zza(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }

    private static void zza(String str, zzp<?> zzp, zzaa zzaa) throws zzaa {
        zzx zzj = zzp.zzj();
        int zzi = zzp.zzi();
        try {
            zzj.zza(zzaa);
            zzp.zzb(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(zzi)}));
        } catch (zzaa e) {
            zzp.zzb(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(zzi)}));
            throw e;
        }
    }

    private final byte[] zza(HttpEntity httpEntity) throws IOException, zzy {
        zzap zzap = new zzap(this.zzbn, (int) httpEntity.getContentLength());
        byte[] bArr = null;
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new zzy();
            }
            bArr = this.zzbn.zzb(1024);
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    break;
                }
                zzap.write(bArr, 0, read);
            }
            byte[] byteArray = zzap.toByteArray();
            try {
            } catch (IOException e) {
                zzab.zza("Error occurred when calling consumingContent", new Object[0]);
            }
            return byteArray;
        } finally {
            try {
                httpEntity.consumeContent();
            } catch (IOException e2) {
                zzab.zza("Error occurred when calling consumingContent", new Object[0]);
            }
            this.zzbn.zza(bArr);
            zzap.close();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ea, code lost:
        zza("socket", r19, new com.google.android.gms.internal.zzz());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x010e, code lost:
        zza("connection", r19, new com.google.android.gms.internal.zzz());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x011c, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x011d, code lost:
        r3 = r2;
        r2 = java.lang.String.valueOf(r19.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x012e, code lost:
        if (r2.length() != 0) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0130, code lost:
        r2 = "Bad URL ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0137, code lost:
        throw new java.lang.RuntimeException(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0138, code lost:
        r2 = new java.lang.String("Bad URL ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x013e, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x013f, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0142, code lost:
        r4 = r3.getStatusLine().getStatusCode();
        com.google.android.gms.internal.zzab.zzc("Unexpected response code %d for %s", java.lang.Integer.valueOf(r4), r19.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0160, code lost:
        if (r5 != null) goto L_0x0162;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0162, code lost:
        r3 = new com.google.android.gms.internal.zzn(r4, r5, r6, false, android.os.SystemClock.elapsedRealtime() - r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0170, code lost:
        if (r4 == 401) goto L_0x0176;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0176, code lost:
        zza("auth", r19, new com.google.android.gms.internal.zza(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0189, code lost:
        throw new com.google.android.gms.internal.zzo(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x018c, code lost:
        if (r4 < 400) goto L_0x0198;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0197, code lost:
        throw new com.google.android.gms.internal.zzf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x019a, code lost:
        if (r4 < 500) goto L_0x01a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01a5, code lost:
        throw new com.google.android.gms.internal.zzy(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01ab, code lost:
        throw new com.google.android.gms.internal.zzy(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01ac, code lost:
        zza("network", r19, new com.google.android.gms.internal.zzm());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01be, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01bf, code lost:
        r3 = r15;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e9 A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), Splitter:B:2:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x010d A[ExcHandler: ConnectTimeoutException (e org.apache.http.conn.ConnectTimeoutException), Splitter:B:2:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x011c A[ExcHandler: MalformedURLException (r2v15 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0184 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzn zza(com.google.android.gms.internal.zzp<?> r19) throws com.google.android.gms.internal.zzaa {
        /*
            r18 = this;
            long r16 = android.os.SystemClock.elapsedRealtime()
        L_0x0004:
            r3 = 0
            r14 = 0
            java.util.Map r6 = java.util.Collections.emptyMap()
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x013e }
            r2.<init>()     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x013e }
            com.google.android.gms.internal.zzc r4 = r19.zze()     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x013e }
            if (r4 == 0) goto L_0x0038
            java.lang.String r5 = r4.zza     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x013e }
            if (r5 == 0) goto L_0x0020
            java.lang.String r5 = "If-None-Match"
            java.lang.String r7 = r4.zza     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x013e }
            r2.put(r5, r7)     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x013e }
        L_0x0020:
            long r8 = r4.zzc     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x013e }
            r10 = 0
            int r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r5 <= 0) goto L_0x0038
            java.util.Date r5 = new java.util.Date     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x013e }
            long r8 = r4.zzc     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x013e }
            r5.<init>(r8)     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x013e }
            java.lang.String r4 = "If-Modified-Since"
            java.lang.String r5 = org.apache.http.impl.cookie.DateUtils.formatDate(r5)     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x013e }
            r2.put(r4, r5)     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x013e }
        L_0x0038:
            r0 = r18
            com.google.android.gms.internal.zzam r4 = r0.zzbm     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x013e }
            r0 = r19
            org.apache.http.HttpResponse r15 = r4.zza(r0, r2)     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x013e }
            org.apache.http.StatusLine r3 = r15.getStatusLine()     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01ba }
            int r4 = r3.getStatusCode()     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01ba }
            org.apache.http.Header[] r2 = r15.getAllHeaders()     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01ba }
            java.util.Map r6 = zza((org.apache.http.Header[]) r2)     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01ba }
            r2 = 304(0x130, float:4.26E-43)
            if (r4 != r2) goto L_0x0085
            com.google.android.gms.internal.zzc r2 = r19.zze()     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01ba }
            if (r2 != 0) goto L_0x006c
            com.google.android.gms.internal.zzn r3 = new com.google.android.gms.internal.zzn     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01ba }
            r4 = 304(0x130, float:4.26E-43)
            r5 = 0
            r7 = 1
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01ba }
            long r8 = r8 - r16
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01ba }
        L_0x006b:
            return r3
        L_0x006c:
            java.util.Map<java.lang.String, java.lang.String> r3 = r2.zzf     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01ba }
            r3.putAll(r6)     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01ba }
            com.google.android.gms.internal.zzn r7 = new com.google.android.gms.internal.zzn     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01ba }
            r8 = 304(0x130, float:4.26E-43)
            byte[] r9 = r2.data     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01ba }
            java.util.Map<java.lang.String, java.lang.String> r10 = r2.zzf     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01ba }
            r11 = 1
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01ba }
            long r12 = r2 - r16
            r7.<init>(r8, r9, r10, r11, r12)     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01ba }
            r3 = r7
            goto L_0x006b
        L_0x0085:
            org.apache.http.HttpEntity r2 = r15.getEntity()     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01ba }
            if (r2 == 0) goto L_0x00f8
            org.apache.http.HttpEntity r2 = r15.getEntity()     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01ba }
            r0 = r18
            byte[] r5 = r0.zza((org.apache.http.HttpEntity) r2)     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01ba }
        L_0x0095:
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
            long r8 = r8 - r16
            boolean r2 = DEBUG     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
            if (r2 != 0) goto L_0x00a5
            r10 = 3000(0xbb8, double:1.482E-320)
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 <= 0) goto L_0x00db
        L_0x00a5:
            java.lang.String r7 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]"
            r2 = 5
            java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
            r2 = 0
            r10[r2] = r19     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
            r2 = 1
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
            r10[r2] = r8     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
            r8 = 2
            if (r5 == 0) goto L_0x00fc
            int r2 = r5.length     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
        L_0x00bc:
            r10[r8] = r2     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
            r2 = 3
            int r3 = r3.getStatusCode()     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
            r10[r2] = r3     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
            r2 = 4
            com.google.android.gms.internal.zzx r3 = r19.zzj()     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
            int r3 = r3.zzb()     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
            r10[r2] = r3     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
            com.google.android.gms.internal.zzab.zzb(r7, r10)     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
        L_0x00db:
            r2 = 200(0xc8, float:2.8E-43)
            if (r4 < r2) goto L_0x00e3
            r2 = 299(0x12b, float:4.19E-43)
            if (r4 <= r2) goto L_0x00ff
        L_0x00e3:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
            r2.<init>()     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
            throw r2     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
        L_0x00e9:
            r2 = move-exception
            java.lang.String r2 = "socket"
            com.google.android.gms.internal.zzz r3 = new com.google.android.gms.internal.zzz
            r3.<init>()
            r0 = r19
            zza(r2, r0, r3)
            goto L_0x0004
        L_0x00f8:
            r2 = 0
            byte[] r5 = new byte[r2]     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01ba }
            goto L_0x0095
        L_0x00fc:
            java.lang.String r2 = "null"
            goto L_0x00bc
        L_0x00ff:
            com.google.android.gms.internal.zzn r3 = new com.google.android.gms.internal.zzn     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
            r7 = 0
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
            long r8 = r8 - r16
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ SocketTimeoutException -> 0x00e9, ConnectTimeoutException -> 0x010d, MalformedURLException -> 0x011c, IOException -> 0x01be }
            goto L_0x006b
        L_0x010d:
            r2 = move-exception
            java.lang.String r2 = "connection"
            com.google.android.gms.internal.zzz r3 = new com.google.android.gms.internal.zzz
            r3.<init>()
            r0 = r19
            zza(r2, r0, r3)
            goto L_0x0004
        L_0x011c:
            r2 = move-exception
            r3 = r2
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.String r5 = "Bad URL "
            java.lang.String r2 = r19.getUrl()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r6 = r2.length()
            if (r6 == 0) goto L_0x0138
            java.lang.String r2 = r5.concat(r2)
        L_0x0134:
            r4.<init>(r2, r3)
            throw r4
        L_0x0138:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r5)
            goto L_0x0134
        L_0x013e:
            r2 = move-exception
            r5 = r14
        L_0x0140:
            if (r3 == 0) goto L_0x0184
            org.apache.http.StatusLine r2 = r3.getStatusLine()
            int r4 = r2.getStatusCode()
            java.lang.String r2 = "Unexpected response code %d for %s"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r7 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
            r3[r7] = r8
            r7 = 1
            java.lang.String r8 = r19.getUrl()
            r3[r7] = r8
            com.google.android.gms.internal.zzab.zzc(r2, r3)
            if (r5 == 0) goto L_0x01ac
            com.google.android.gms.internal.zzn r3 = new com.google.android.gms.internal.zzn
            r7 = 0
            long r8 = android.os.SystemClock.elapsedRealtime()
            long r8 = r8 - r16
            r3.<init>(r4, r5, r6, r7, r8)
            r2 = 401(0x191, float:5.62E-43)
            if (r4 == r2) goto L_0x0176
            r2 = 403(0x193, float:5.65E-43)
            if (r4 != r2) goto L_0x018a
        L_0x0176:
            java.lang.String r2 = "auth"
            com.google.android.gms.internal.zza r4 = new com.google.android.gms.internal.zza
            r4.<init>(r3)
            r0 = r19
            zza(r2, r0, r4)
            goto L_0x0004
        L_0x0184:
            com.google.android.gms.internal.zzo r3 = new com.google.android.gms.internal.zzo
            r3.<init>(r2)
            throw r3
        L_0x018a:
            r2 = 400(0x190, float:5.6E-43)
            if (r4 < r2) goto L_0x0198
            r2 = 499(0x1f3, float:6.99E-43)
            if (r4 > r2) goto L_0x0198
            com.google.android.gms.internal.zzf r2 = new com.google.android.gms.internal.zzf
            r2.<init>(r3)
            throw r2
        L_0x0198:
            r2 = 500(0x1f4, float:7.0E-43)
            if (r4 < r2) goto L_0x01a6
            r2 = 599(0x257, float:8.4E-43)
            if (r4 > r2) goto L_0x01a6
            com.google.android.gms.internal.zzy r2 = new com.google.android.gms.internal.zzy
            r2.<init>(r3)
            throw r2
        L_0x01a6:
            com.google.android.gms.internal.zzy r2 = new com.google.android.gms.internal.zzy
            r2.<init>(r3)
            throw r2
        L_0x01ac:
            java.lang.String r2 = "network"
            com.google.android.gms.internal.zzm r3 = new com.google.android.gms.internal.zzm
            r3.<init>()
            r0 = r19
            zza(r2, r0, r3)
            goto L_0x0004
        L_0x01ba:
            r2 = move-exception
            r5 = r14
            r3 = r15
            goto L_0x0140
        L_0x01be:
            r2 = move-exception
            r3 = r15
            goto L_0x0140
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzad.zza(com.google.android.gms.internal.zzp):com.google.android.gms.internal.zzn");
    }
}
