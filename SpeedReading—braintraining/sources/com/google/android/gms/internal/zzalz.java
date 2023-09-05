package com.google.android.gms.internal;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzzb
public final class zzalz extends zzalt {
    private static final Set<String> zzdhv = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzdhw = new DecimalFormat("#,###");
    private File zzdhx;
    private boolean zzdhy;

    public zzalz(zzali zzali) {
        super(zzali);
        File cacheDir = this.mContext.getCacheDir();
        if (cacheDir == null) {
            zzafj.zzco("Context.getCacheDir() returned null");
            return;
        }
        this.zzdhx = new File(cacheDir, "admobVideoStreams");
        if (!this.zzdhx.isDirectory() && !this.zzdhx.mkdirs()) {
            String valueOf = String.valueOf(this.zzdhx.getAbsolutePath());
            zzafj.zzco(valueOf.length() != 0 ? "Could not create preload cache directory at ".concat(valueOf) : new String("Could not create preload cache directory at "));
            this.zzdhx = null;
        } else if (!this.zzdhx.setReadable(true, false) || !this.zzdhx.setExecutable(true, false)) {
            String valueOf2 = String.valueOf(this.zzdhx.getAbsolutePath());
            zzafj.zzco(valueOf2.length() != 0 ? "Could not set cache file permissions at ".concat(valueOf2) : new String("Could not set cache file permissions at "));
            this.zzdhx = null;
        }
    }

    private final File zzc(File file) {
        return new File(this.zzdhx, String.valueOf(file.getName()).concat(".done"));
    }

    public final void abort() {
        this.zzdhy = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0257, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        r7 = r3.getContentLength();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x025d, code lost:
        if (r7 >= 0) goto L_0x0293;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x025f, code lost:
        r2 = java.lang.String.valueOf(r28);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0269, code lost:
        if (r2.length() == 0) goto L_0x0288;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x026b, code lost:
        r2 = "Stream cache aborted, missing content-length header at ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x026f, code lost:
        com.google.android.gms.internal.zzafj.zzco(r2);
        zza(r28, r13.getAbsolutePath(), "contentLengthMissing", (java.lang.String) null);
        zzdhv.remove(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0288, code lost:
        r2 = new java.lang.String("Stream cache aborted, missing content-length header at ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x028e, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x028f, code lost:
        r3 = null;
        r4 = "error";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0293, code lost:
        r4 = zzdhw.format((long) r7);
        r15 = ((java.lang.Integer) com.google.android.gms.ads.internal.zzbs.zzep().zzd(com.google.android.gms.internal.zzmq.zzbgr)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02ae, code lost:
        if (r7 <= r15) goto L_0x0315;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x02b0, code lost:
        com.google.android.gms.internal.zzafj.zzco(new java.lang.StringBuilder((java.lang.String.valueOf(r4).length() + 33) + java.lang.String.valueOf(r28).length()).append("Content length ").append(r4).append(" exceeds limit at ").append(r28).toString());
        r2 = java.lang.String.valueOf(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02ef, code lost:
        if (r2.length() == 0) goto L_0x030a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02f1, code lost:
        r2 = "File too big for full file cache. Size: ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02f5, code lost:
        zza(r28, r13.getAbsolutePath(), "sizeExceeded", r2);
        zzdhv.remove(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x030a, code lost:
        r2 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0310, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0311, code lost:
        r3 = null;
        r4 = "error";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0315, code lost:
        com.google.android.gms.internal.zzafj.zzbw(new java.lang.StringBuilder((java.lang.String.valueOf(r4).length() + 20) + java.lang.String.valueOf(r28).length()).append("Caching ").append(r4).append(" bytes from ").append(r28).toString());
        r16 = java.nio.channels.Channels.newChannel(r3.getInputStream());
        r12 = new java.io.FileOutputStream(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:?, code lost:
        r17 = r12.getChannel();
        r18 = java.nio.ByteBuffer.allocate(1048576);
        r19 = com.google.android.gms.ads.internal.zzbs.zzei();
        r6 = 0;
        r20 = r19.currentTimeMillis();
        r0 = new com.google.android.gms.internal.zzail(((java.lang.Long) com.google.android.gms.ads.internal.zzbs.zzep().zzd(com.google.android.gms.internal.zzmq.zzbgu)).longValue());
        r24 = ((java.lang.Long) com.google.android.gms.ads.internal.zzbs.zzep().zzd(com.google.android.gms.internal.zzmq.zzbgt)).longValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0391, code lost:
        r2 = r16.read(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0399, code lost:
        if (r2 < 0) goto L_0x0452;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x039b, code lost:
        r6 = r6 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x039c, code lost:
        if (r6 <= r15) goto L_0x03cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
        r3 = java.lang.String.valueOf(java.lang.Integer.toString(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x03ae, code lost:
        if (r3.length() == 0) goto L_0x03c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x03b0, code lost:
        r3 = "File too big for full file cache. Size: ".concat(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x03bb, code lost:
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x03bc, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x03bd, code lost:
        r5 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:?, code lost:
        r3 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x03c6, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x03c7, code lost:
        r3 = null;
        r5 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:?, code lost:
        r18.flip();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x03d2, code lost:
        if (r17.write(r18) > 0) goto L_0x03ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x03d4, code lost:
        r18.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x03e3, code lost:
        if ((r19.currentTimeMillis() - r20) <= (1000 * r24)) goto L_0x041a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:?, code lost:
        r2 = java.lang.Long.toString(r24);
        r3 = new java.lang.StringBuilder(java.lang.String.valueOf(r2).length() + 29).append("Timeout exceeded. Limit: ").append(r2).append(" sec").toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0415, code lost:
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0416, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0417, code lost:
        r5 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x041e, code lost:
        if (r27.zzdhy == false) goto L_0x042f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0429, code lost:
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x042a, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x042b, code lost:
        r3 = null;
        r5 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0433, code lost:
        if (r0.tryAcquire() == false) goto L_0x0391;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0435, code lost:
        com.google.android.gms.internal.zzais.zzdbs.post(new com.google.android.gms.internal.zzalu(r27, r28, r13.getAbsolutePath(), r6, r7, false));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x044c, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x044d, code lost:
        r3 = null;
        r4 = "error";
        r5 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0452, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x045a, code lost:
        if (com.google.android.gms.internal.zzafj.zzae(3) == false) goto L_0x0498;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x045c, code lost:
        r2 = zzdhw.format((long) r6);
        com.google.android.gms.internal.zzafj.zzbw(new java.lang.StringBuilder((java.lang.String.valueOf(r2).length() + 22) + java.lang.String.valueOf(r28).length()).append("Preloaded ").append(r2).append(" bytes from ").append(r28).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0498, code lost:
        r13.setReadable(true, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x04a1, code lost:
        if (r14.isFile() == false) goto L_0x04bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x04a3, code lost:
        r14.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:?, code lost:
        r14.createNewFile();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x04c3, code lost:
        com.google.android.gms.internal.zzafj.zzc(new java.lang.StringBuilder(java.lang.String.valueOf(r28).length() + 25).append("Preload failed for URL \"").append(r28).append("\"").toString(), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x04ed, code lost:
        r2 = new java.lang.String("Could not delete partial cache file at ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x04fa, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x04fb, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0501, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0502, code lost:
        r3 = null;
        r4 = "error";
        r5 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0168, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        com.google.android.gms.ads.internal.zzbs.zzeq();
        r3 = com.google.android.gms.internal.zzajz.zzb(r28, ((java.lang.Integer) com.google.android.gms.ads.internal.zzbs.zzep().zzd(com.google.android.gms.internal.zzmq.zzbgv)).intValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0187, code lost:
        if ((r3 instanceof java.net.HttpURLConnection) == false) goto L_0x0259;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0189, code lost:
        r2 = r3.getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0193, code lost:
        if (r2 < 400) goto L_0x0259;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0195, code lost:
        r4 = "badUrl";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r3 = java.lang.String.valueOf(java.lang.Integer.toString(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01a5, code lost:
        if (r3.length() == 0) goto L_0x024f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01a7, code lost:
        r3 = "HTTP request failed. Code: ".concat(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01d9, code lost:
        throw new java.io.IOException(new java.lang.StringBuilder(java.lang.String.valueOf(r28).length() + 32).append("HTTP status code ").append(r2).append(" at ").append(r28).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01da, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01dd, code lost:
        if ((r2 instanceof java.lang.RuntimeException) != false) goto L_0x01df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01df, code lost:
        com.google.android.gms.ads.internal.zzbs.zzeg().zza(r2, "VideoStreamFullFileCache.preload");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01ef, code lost:
        if (r27.zzdhy != false) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01f1, code lost:
        com.google.android.gms.internal.zzafj.zzcn(new java.lang.StringBuilder(java.lang.String.valueOf(r28).length() + 26).append("Preload aborted for URL \"").append(r28).append("\"").toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0225, code lost:
        r2 = java.lang.String.valueOf(r13.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0233, code lost:
        if (r2.length() != 0) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0235, code lost:
        r2 = "Could not delete partial cache file at ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0239, code lost:
        com.google.android.gms.internal.zzafj.zzco(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x023c, code lost:
        zza(r28, r13.getAbsolutePath(), r4, r3);
        zzdhv.remove(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:?, code lost:
        r3 = new java.lang.String("HTTP request failed. Code: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0256, code lost:
        r2 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x04c3  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x04ed  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0501 A[ExcHandler: RuntimeException (e java.lang.RuntimeException), Splitter:B:121:0x0357] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0235  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzcr(java.lang.String r28) {
        /*
            r27 = this;
            r0 = r27
            java.io.File r2 = r0.zzdhx
            if (r2 != 0) goto L_0x0013
            r2 = 0
            java.lang.String r3 = "noCacheDir"
            r4 = 0
            r0 = r27
            r1 = r28
            r0.zza(r1, r2, r3, r4)
            r2 = 0
        L_0x0012:
            return r2
        L_0x0013:
            r0 = r27
            java.io.File r2 = r0.zzdhx
            if (r2 != 0) goto L_0x0048
            r2 = 0
            r3 = r2
        L_0x001b:
            com.google.android.gms.internal.zzmg<java.lang.Integer> r2 = com.google.android.gms.internal.zzmq.zzbgq
            com.google.android.gms.internal.zzmo r4 = com.google.android.gms.ads.internal.zzbs.zzep()
            java.lang.Object r2 = r4.zzd(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r3 <= r2) goto L_0x00b9
            r0 = r27
            java.io.File r2 = r0.zzdhx
            if (r2 != 0) goto L_0x006f
            r2 = 0
        L_0x0034:
            if (r2 != 0) goto L_0x0013
            java.lang.String r2 = "Unable to expire stream cache"
            com.google.android.gms.internal.zzafj.zzco(r2)
            r2 = 0
            java.lang.String r3 = "expireFailed"
            r4 = 0
            r0 = r27
            r1 = r28
            r0.zza(r1, r2, r3, r4)
            r2 = 0
            goto L_0x0012
        L_0x0048:
            r3 = 0
            r0 = r27
            java.io.File r2 = r0.zzdhx
            java.io.File[] r4 = r2.listFiles()
            int r5 = r4.length
            r2 = 0
            r26 = r2
            r2 = r3
            r3 = r26
        L_0x0058:
            if (r3 >= r5) goto L_0x006d
            r6 = r4[r3]
            java.lang.String r6 = r6.getName()
            java.lang.String r7 = ".done"
            boolean r6 = r6.endsWith(r7)
            if (r6 != 0) goto L_0x006a
            int r2 = r2 + 1
        L_0x006a:
            int r3 = r3 + 1
            goto L_0x0058
        L_0x006d:
            r3 = r2
            goto L_0x001b
        L_0x006f:
            r7 = 0
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r0 = r27
            java.io.File r2 = r0.zzdhx
            java.io.File[] r9 = r2.listFiles()
            int r10 = r9.length
            r2 = 0
            r8 = r2
        L_0x0080:
            if (r8 >= r10) goto L_0x009f
            r6 = r9[r8]
            java.lang.String r2 = r6.getName()
            java.lang.String r3 = ".done"
            boolean r2 = r2.endsWith(r3)
            if (r2 != 0) goto L_0x0507
            long r2 = r6.lastModified()
            int r11 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r11 >= 0) goto L_0x0507
            r4 = r6
        L_0x0099:
            int r5 = r8 + 1
            r8 = r5
            r7 = r4
            r4 = r2
            goto L_0x0080
        L_0x009f:
            r2 = 0
            if (r7 == 0) goto L_0x0034
            boolean r2 = r7.delete()
            r0 = r27
            java.io.File r3 = r0.zzc(r7)
            boolean r4 = r3.isFile()
            if (r4 == 0) goto L_0x0034
            boolean r3 = r3.delete()
            r2 = r2 & r3
            goto L_0x0034
        L_0x00b9:
            com.google.android.gms.internal.zzjk.zzhx()
            java.lang.String r2 = com.google.android.gms.internal.zzais.zzcl(r28)
            java.io.File r13 = new java.io.File
            r0 = r27
            java.io.File r3 = r0.zzdhx
            r13.<init>(r3, r2)
            r0 = r27
            java.io.File r14 = r0.zzc(r13)
            boolean r2 = r13.isFile()
            if (r2 == 0) goto L_0x0107
            boolean r2 = r14.isFile()
            if (r2 == 0) goto L_0x0107
            long r2 = r13.length()
            int r3 = (int) r2
            java.lang.String r4 = "Stream cache hit at "
            java.lang.String r2 = java.lang.String.valueOf(r28)
            int r5 = r2.length()
            if (r5 == 0) goto L_0x0101
            java.lang.String r2 = r4.concat(r2)
        L_0x00f0:
            com.google.android.gms.internal.zzafj.zzbw(r2)
            java.lang.String r2 = r13.getAbsolutePath()
            r0 = r27
            r1 = r28
            r0.zza((java.lang.String) r1, (java.lang.String) r2, (int) r3)
            r2 = 1
            goto L_0x0012
        L_0x0101:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r4)
            goto L_0x00f0
        L_0x0107:
            r0 = r27
            java.io.File r2 = r0.zzdhx
            java.lang.String r2 = r2.getAbsolutePath()
            java.lang.String r3 = java.lang.String.valueOf(r2)
            java.lang.String r2 = java.lang.String.valueOf(r28)
            int r4 = r2.length()
            if (r4 == 0) goto L_0x0155
            java.lang.String r2 = r3.concat(r2)
            r9 = r2
        L_0x0122:
            java.util.Set<java.lang.String> r3 = zzdhv
            monitor-enter(r3)
            java.util.Set<java.lang.String> r2 = zzdhv     // Catch:{ all -> 0x0152 }
            boolean r2 = r2.contains(r9)     // Catch:{ all -> 0x0152 }
            if (r2 == 0) goto L_0x0162
            java.lang.String r4 = "Stream cache already in progress at "
            java.lang.String r2 = java.lang.String.valueOf(r28)     // Catch:{ all -> 0x0152 }
            int r5 = r2.length()     // Catch:{ all -> 0x0152 }
            if (r5 == 0) goto L_0x015c
            java.lang.String r2 = r4.concat(r2)     // Catch:{ all -> 0x0152 }
        L_0x013d:
            com.google.android.gms.internal.zzafj.zzco(r2)     // Catch:{ all -> 0x0152 }
            java.lang.String r2 = r13.getAbsolutePath()     // Catch:{ all -> 0x0152 }
            java.lang.String r4 = "inProgress"
            r5 = 0
            r0 = r27
            r1 = r28
            r0.zza(r1, r2, r4, r5)     // Catch:{ all -> 0x0152 }
            r2 = 0
            monitor-exit(r3)     // Catch:{ all -> 0x0152 }
            goto L_0x0012
        L_0x0152:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0152 }
            throw r2
        L_0x0155:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r3)
            r9 = r2
            goto L_0x0122
        L_0x015c:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x0152 }
            r2.<init>(r4)     // Catch:{ all -> 0x0152 }
            goto L_0x013d
        L_0x0162:
            java.util.Set<java.lang.String> r2 = zzdhv     // Catch:{ all -> 0x0152 }
            r2.add(r9)     // Catch:{ all -> 0x0152 }
            monitor-exit(r3)     // Catch:{ all -> 0x0152 }
            r5 = 0
            java.lang.String r11 = "error"
            r10 = 0
            com.google.android.gms.ads.internal.zzbs.zzeq()     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            com.google.android.gms.internal.zzmg<java.lang.Integer> r2 = com.google.android.gms.internal.zzmq.zzbgv     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            com.google.android.gms.internal.zzmo r3 = com.google.android.gms.ads.internal.zzbs.zzep()     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            java.lang.Object r2 = r3.zzd(r2)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            int r2 = r2.intValue()     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            r0 = r28
            java.net.HttpURLConnection r3 = com.google.android.gms.internal.zzajz.zzb(r0, r2)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            boolean r2 = r3 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            if (r2 == 0) goto L_0x0259
            r0 = r3
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            r2 = r0
            int r2 = r2.getResponseCode()     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            r4 = 400(0x190, float:5.6E-43)
            if (r2 < r4) goto L_0x0259
            java.lang.String r4 = "badUrl"
            java.lang.String r6 = "HTTP request failed. Code: "
            java.lang.String r3 = java.lang.Integer.toString(r2)     // Catch:{ IOException -> 0x0256, RuntimeException -> 0x04fa }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ IOException -> 0x0256, RuntimeException -> 0x04fa }
            int r7 = r3.length()     // Catch:{ IOException -> 0x0256, RuntimeException -> 0x04fa }
            if (r7 == 0) goto L_0x024f
            java.lang.String r3 = r6.concat(r3)     // Catch:{ IOException -> 0x0256, RuntimeException -> 0x04fa }
        L_0x01ab:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ IOException -> 0x01da, RuntimeException -> 0x04fe }
            java.lang.String r7 = java.lang.String.valueOf(r28)     // Catch:{ IOException -> 0x01da, RuntimeException -> 0x04fe }
            int r7 = r7.length()     // Catch:{ IOException -> 0x01da, RuntimeException -> 0x04fe }
            int r7 = r7 + 32
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01da, RuntimeException -> 0x04fe }
            r8.<init>(r7)     // Catch:{ IOException -> 0x01da, RuntimeException -> 0x04fe }
            java.lang.String r7 = "HTTP status code "
            java.lang.StringBuilder r7 = r8.append(r7)     // Catch:{ IOException -> 0x01da, RuntimeException -> 0x04fe }
            java.lang.StringBuilder r2 = r7.append(r2)     // Catch:{ IOException -> 0x01da, RuntimeException -> 0x04fe }
            java.lang.String r7 = " at "
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ IOException -> 0x01da, RuntimeException -> 0x04fe }
            r0 = r28
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ IOException -> 0x01da, RuntimeException -> 0x04fe }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x01da, RuntimeException -> 0x04fe }
            r6.<init>(r2)     // Catch:{ IOException -> 0x01da, RuntimeException -> 0x04fe }
            throw r6     // Catch:{ IOException -> 0x01da, RuntimeException -> 0x04fe }
        L_0x01da:
            r2 = move-exception
        L_0x01db:
            boolean r6 = r2 instanceof java.lang.RuntimeException
            if (r6 == 0) goto L_0x01e8
            com.google.android.gms.internal.zzaez r6 = com.google.android.gms.ads.internal.zzbs.zzeg()
            java.lang.String r7 = "VideoStreamFullFileCache.preload"
            r6.zza((java.lang.Throwable) r2, (java.lang.String) r7)
        L_0x01e8:
            r5.close()     // Catch:{ IOException -> 0x04f4, NullPointerException -> 0x04f7 }
        L_0x01eb:
            r0 = r27
            boolean r5 = r0.zzdhy
            if (r5 == 0) goto L_0x04c3
            java.lang.String r2 = java.lang.String.valueOf(r28)
            int r2 = r2.length()
            int r2 = r2 + 26
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r2)
            java.lang.String r2 = "Preload aborted for URL \""
            java.lang.StringBuilder r2 = r5.append(r2)
            r0 = r28
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r5 = "\""
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r2 = r2.toString()
            com.google.android.gms.internal.zzafj.zzcn(r2)
        L_0x0219:
            boolean r2 = r13.exists()
            if (r2 == 0) goto L_0x023c
            boolean r2 = r13.delete()
            if (r2 != 0) goto L_0x023c
            java.lang.String r5 = "Could not delete partial cache file at "
            java.lang.String r2 = r13.getAbsolutePath()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r6 = r2.length()
            if (r6 == 0) goto L_0x04ed
            java.lang.String r2 = r5.concat(r2)
        L_0x0239:
            com.google.android.gms.internal.zzafj.zzco(r2)
        L_0x023c:
            java.lang.String r2 = r13.getAbsolutePath()
            r0 = r27
            r1 = r28
            r0.zza(r1, r2, r4, r3)
            java.util.Set<java.lang.String> r2 = zzdhv
            r2.remove(r9)
            r2 = 0
            goto L_0x0012
        L_0x024f:
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x0256, RuntimeException -> 0x04fa }
            r3.<init>(r6)     // Catch:{ IOException -> 0x0256, RuntimeException -> 0x04fa }
            goto L_0x01ab
        L_0x0256:
            r2 = move-exception
            r3 = r10
            goto L_0x01db
        L_0x0259:
            int r7 = r3.getContentLength()     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            if (r7 >= 0) goto L_0x0293
            java.lang.String r3 = "Stream cache aborted, missing content-length header at "
            java.lang.String r2 = java.lang.String.valueOf(r28)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            int r4 = r2.length()     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            if (r4 == 0) goto L_0x0288
            java.lang.String r2 = r3.concat(r2)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
        L_0x026f:
            com.google.android.gms.internal.zzafj.zzco(r2)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            java.lang.String r2 = r13.getAbsolutePath()     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            java.lang.String r3 = "contentLengthMissing"
            r4 = 0
            r0 = r27
            r1 = r28
            r0.zza(r1, r2, r3, r4)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            java.util.Set<java.lang.String> r2 = zzdhv     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            r2.remove(r9)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            r2 = 0
            goto L_0x0012
        L_0x0288:
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            goto L_0x026f
        L_0x028e:
            r2 = move-exception
            r3 = r10
            r4 = r11
            goto L_0x01db
        L_0x0293:
            java.text.DecimalFormat r2 = zzdhw     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            long r0 = (long) r7     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            r16 = r0
            r0 = r16
            java.lang.String r4 = r2.format(r0)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            com.google.android.gms.internal.zzmg<java.lang.Integer> r2 = com.google.android.gms.internal.zzmq.zzbgr     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            com.google.android.gms.internal.zzmo r6 = com.google.android.gms.ads.internal.zzbs.zzep()     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            java.lang.Object r2 = r6.zzd(r2)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            int r15 = r2.intValue()     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            if (r7 <= r15) goto L_0x0315
            java.lang.String r2 = java.lang.String.valueOf(r4)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            int r2 = r2.length()     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            int r2 = r2 + 33
            java.lang.String r3 = java.lang.String.valueOf(r28)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            int r3 = r3.length()     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            java.lang.String r2 = "Content length "
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            java.lang.String r3 = " exceeds limit at "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            r0 = r28
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            com.google.android.gms.internal.zzafj.zzco(r2)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            java.lang.String r3 = "File too big for full file cache. Size: "
            java.lang.String r2 = java.lang.String.valueOf(r4)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            int r4 = r2.length()     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            if (r4 == 0) goto L_0x030a
            java.lang.String r2 = r3.concat(r2)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
        L_0x02f5:
            java.lang.String r3 = r13.getAbsolutePath()     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            java.lang.String r4 = "sizeExceeded"
            r0 = r27
            r1 = r28
            r0.zza(r1, r3, r4, r2)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            java.util.Set<java.lang.String> r2 = zzdhv     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            r2.remove(r9)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            r2 = 0
            goto L_0x0012
        L_0x030a:
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            goto L_0x02f5
        L_0x0310:
            r2 = move-exception
            r3 = r10
            r4 = r11
            goto L_0x01db
        L_0x0315:
            java.lang.String r2 = java.lang.String.valueOf(r4)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            int r2 = r2.length()     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            int r2 = r2 + 20
            java.lang.String r6 = java.lang.String.valueOf(r28)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            int r6 = r6.length()     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            int r2 = r2 + r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            r6.<init>(r2)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            java.lang.String r2 = "Caching "
            java.lang.StringBuilder r2 = r6.append(r2)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            java.lang.String r4 = " bytes from "
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            r0 = r28
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            com.google.android.gms.internal.zzafj.zzbw(r2)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            java.io.InputStream r2 = r3.getInputStream()     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            java.nio.channels.ReadableByteChannel r16 = java.nio.channels.Channels.newChannel(r2)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            java.io.FileOutputStream r12 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            r12.<init>(r13)     // Catch:{ IOException -> 0x028e, RuntimeException -> 0x0310 }
            java.nio.channels.FileChannel r17 = r12.getChannel()     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            r2 = 1048576(0x100000, float:1.469368E-39)
            java.nio.ByteBuffer r18 = java.nio.ByteBuffer.allocate(r2)     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            com.google.android.gms.common.util.zzd r19 = com.google.android.gms.ads.internal.zzbs.zzei()     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            r6 = 0
            long r20 = r19.currentTimeMillis()     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            com.google.android.gms.internal.zzmg<java.lang.Long> r2 = com.google.android.gms.internal.zzmq.zzbgu     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            com.google.android.gms.internal.zzmo r3 = com.google.android.gms.ads.internal.zzbs.zzep()     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            java.lang.Object r2 = r3.zzd(r2)     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            long r2 = r2.longValue()     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            com.google.android.gms.internal.zzail r22 = new com.google.android.gms.internal.zzail     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            r0 = r22
            r0.<init>(r2)     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            com.google.android.gms.internal.zzmg<java.lang.Long> r2 = com.google.android.gms.internal.zzmq.zzbgt     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            com.google.android.gms.internal.zzmo r3 = com.google.android.gms.ads.internal.zzbs.zzep()     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            java.lang.Object r2 = r3.zzd(r2)     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            long r24 = r2.longValue()     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
        L_0x0391:
            r0 = r16
            r1 = r18
            int r2 = r0.read(r1)     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            if (r2 < 0) goto L_0x0452
            int r6 = r6 + r2
            if (r6 <= r15) goto L_0x03cb
            java.lang.String r4 = "sizeExceeded"
            java.lang.String r2 = "File too big for full file cache. Size: "
            java.lang.String r3 = java.lang.Integer.toString(r6)     // Catch:{ IOException -> 0x03c6, RuntimeException -> 0x042a }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ IOException -> 0x03c6, RuntimeException -> 0x042a }
            int r5 = r3.length()     // Catch:{ IOException -> 0x03c6, RuntimeException -> 0x042a }
            if (r5 == 0) goto L_0x03c0
            java.lang.String r3 = r2.concat(r3)     // Catch:{ IOException -> 0x03c6, RuntimeException -> 0x042a }
        L_0x03b4:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x03bc, RuntimeException -> 0x0416 }
            java.lang.String r5 = "stream cache file size limit exceeded"
            r2.<init>(r5)     // Catch:{ IOException -> 0x03bc, RuntimeException -> 0x0416 }
            throw r2     // Catch:{ IOException -> 0x03bc, RuntimeException -> 0x0416 }
        L_0x03bc:
            r2 = move-exception
            r5 = r12
            goto L_0x01db
        L_0x03c0:
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x03c6, RuntimeException -> 0x042a }
            r3.<init>(r2)     // Catch:{ IOException -> 0x03c6, RuntimeException -> 0x042a }
            goto L_0x03b4
        L_0x03c6:
            r2 = move-exception
            r3 = r10
            r5 = r12
            goto L_0x01db
        L_0x03cb:
            r18.flip()     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
        L_0x03ce:
            int r2 = r17.write(r18)     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            if (r2 > 0) goto L_0x03ce
            r18.clear()     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            long r2 = r19.currentTimeMillis()     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            long r2 = r2 - r20
            r4 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r24
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x041a
            java.lang.String r4 = "downloadTimeout"
            java.lang.String r2 = java.lang.Long.toString(r24)     // Catch:{ IOException -> 0x03c6, RuntimeException -> 0x042a }
            java.lang.String r3 = java.lang.String.valueOf(r2)     // Catch:{ IOException -> 0x03c6, RuntimeException -> 0x042a }
            int r3 = r3.length()     // Catch:{ IOException -> 0x03c6, RuntimeException -> 0x042a }
            int r3 = r3 + 29
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03c6, RuntimeException -> 0x042a }
            r5.<init>(r3)     // Catch:{ IOException -> 0x03c6, RuntimeException -> 0x042a }
            java.lang.String r3 = "Timeout exceeded. Limit: "
            java.lang.StringBuilder r3 = r5.append(r3)     // Catch:{ IOException -> 0x03c6, RuntimeException -> 0x042a }
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch:{ IOException -> 0x03c6, RuntimeException -> 0x042a }
            java.lang.String r3 = " sec"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IOException -> 0x03c6, RuntimeException -> 0x042a }
            java.lang.String r3 = r2.toString()     // Catch:{ IOException -> 0x03c6, RuntimeException -> 0x042a }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x03bc, RuntimeException -> 0x0416 }
            java.lang.String r5 = "stream cache time limit exceeded"
            r2.<init>(r5)     // Catch:{ IOException -> 0x03bc, RuntimeException -> 0x0416 }
            throw r2     // Catch:{ IOException -> 0x03bc, RuntimeException -> 0x0416 }
        L_0x0416:
            r2 = move-exception
            r5 = r12
            goto L_0x01db
        L_0x041a:
            r0 = r27
            boolean r2 = r0.zzdhy     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            if (r2 == 0) goto L_0x042f
            java.lang.String r4 = "externalAbort"
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x03c6, RuntimeException -> 0x042a }
            java.lang.String r3 = "abort requested"
            r2.<init>(r3)     // Catch:{ IOException -> 0x03c6, RuntimeException -> 0x042a }
            throw r2     // Catch:{ IOException -> 0x03c6, RuntimeException -> 0x042a }
        L_0x042a:
            r2 = move-exception
            r3 = r10
            r5 = r12
            goto L_0x01db
        L_0x042f:
            boolean r2 = r22.tryAcquire()     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            if (r2 == 0) goto L_0x0391
            java.lang.String r5 = r13.getAbsolutePath()     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            android.os.Handler r23 = com.google.android.gms.internal.zzais.zzdbs     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            com.google.android.gms.internal.zzalu r2 = new com.google.android.gms.internal.zzalu     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            r8 = 0
            r3 = r27
            r4 = r28
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            r0 = r23
            r0.post(r2)     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            goto L_0x0391
        L_0x044c:
            r2 = move-exception
            r3 = r10
            r4 = r11
            r5 = r12
            goto L_0x01db
        L_0x0452:
            r12.close()     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            r2 = 3
            boolean r2 = com.google.android.gms.internal.zzafj.zzae(r2)     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            if (r2 == 0) goto L_0x0498
            java.text.DecimalFormat r2 = zzdhw     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            long r4 = (long) r6     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            java.lang.String r2 = r2.format(r4)     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            java.lang.String r3 = java.lang.String.valueOf(r2)     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            int r3 = r3.length()     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            int r3 = r3 + 22
            java.lang.String r4 = java.lang.String.valueOf(r28)     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            int r4 = r4.length()     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            int r3 = r3 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            java.lang.String r3 = "Preloaded "
            java.lang.StringBuilder r3 = r4.append(r3)     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            java.lang.String r3 = " bytes from "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            r0 = r28
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            com.google.android.gms.internal.zzafj.zzbw(r2)     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
        L_0x0498:
            r2 = 1
            r3 = 0
            r13.setReadable(r2, r3)     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            boolean r2 = r14.isFile()     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            if (r2 == 0) goto L_0x04bd
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            r14.setLastModified(r2)     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
        L_0x04aa:
            java.lang.String r2 = r13.getAbsolutePath()     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            r0 = r27
            r1 = r28
            r0.zza((java.lang.String) r1, (java.lang.String) r2, (int) r6)     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            java.util.Set<java.lang.String> r2 = zzdhv     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            r2.remove(r9)     // Catch:{ IOException -> 0x044c, RuntimeException -> 0x0501 }
            r2 = 1
            goto L_0x0012
        L_0x04bd:
            r14.createNewFile()     // Catch:{ IOException -> 0x04c1, RuntimeException -> 0x0501 }
            goto L_0x04aa
        L_0x04c1:
            r2 = move-exception
            goto L_0x04aa
        L_0x04c3:
            java.lang.String r5 = java.lang.String.valueOf(r28)
            int r5 = r5.length()
            int r5 = r5 + 25
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "Preload failed for URL \""
            java.lang.StringBuilder r5 = r6.append(r5)
            r0 = r28
            java.lang.StringBuilder r5 = r5.append(r0)
            java.lang.String r6 = "\""
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.google.android.gms.internal.zzafj.zzc(r5, r2)
            goto L_0x0219
        L_0x04ed:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r5)
            goto L_0x0239
        L_0x04f4:
            r5 = move-exception
            goto L_0x01eb
        L_0x04f7:
            r5 = move-exception
            goto L_0x01eb
        L_0x04fa:
            r2 = move-exception
            r3 = r10
            goto L_0x01db
        L_0x04fe:
            r2 = move-exception
            goto L_0x01db
        L_0x0501:
            r2 = move-exception
            r3 = r10
            r4 = r11
            r5 = r12
            goto L_0x01db
        L_0x0507:
            r2 = r4
            r4 = r7
            goto L_0x0099
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzalz.zzcr(java.lang.String):boolean");
    }
}
