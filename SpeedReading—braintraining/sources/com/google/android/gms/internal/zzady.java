package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzq;
import com.google.android.gms.common.zze;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zzady implements zzaeh {
    private final Context mContext;
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    private final zzaee zzcrj;
    /* access modifiers changed from: private */
    public final zzfhw zzcul;
    private final LinkedHashMap<String, zzfie> zzcum;
    private final zzaej zzcun;
    @VisibleForTesting
    boolean zzcuo;
    private HashSet<String> zzcup = new HashSet<>();
    private boolean zzcuq = false;
    private boolean zzcur = false;
    private boolean zzcus = false;

    public zzady(Context context, zzaiy zzaiy, zzaee zzaee, String str, zzaej zzaej) {
        zzbq.checkNotNull(zzaee, "SafeBrowsing config is not present.");
        this.mContext = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzcum = new LinkedHashMap<>();
        this.zzcun = zzaej;
        this.zzcrj = zzaee;
        for (String lowerCase : this.zzcrj.zzcva) {
            this.zzcup.add(lowerCase.toLowerCase(Locale.ENGLISH));
        }
        this.zzcup.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzfhw zzfhw = new zzfhw();
        zzfhw.zzpig = 8;
        zzfhw.url = str;
        zzfhw.zzpii = str;
        zzfhw.zzpik = new zzfhx();
        zzfhw.zzpik.zzcuw = this.zzcrj.zzcuw;
        zzfif zzfif = new zzfif();
        zzfif.zzpjr = zzaiy.zzcp;
        zzfif.zzpjt = Boolean.valueOf(zzbgc.zzcy(this.mContext).zzamj());
        zze.zzafn();
        long zzcd = (long) zze.zzcd(this.mContext);
        if (zzcd > 0) {
            zzfif.zzpjs = Long.valueOf(zzcd);
        }
        zzfhw.zzpiu = zzfif;
        this.zzcul = zzfhw;
    }

    @Nullable
    private final zzfie zzbv(String str) {
        zzfie zzfie;
        synchronized (this.mLock) {
            zzfie = this.zzcum.get(str);
        }
        return zzfie;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void send() {
        boolean z = true;
        if ((!this.zzcuo || !this.zzcrj.zzcvc) && ((!this.zzcus || !this.zzcrj.zzcvb) && (this.zzcuo || !this.zzcrj.zzcuz))) {
            z = false;
        }
        if (z) {
            synchronized (this.mLock) {
                this.zzcul.zzpil = new zzfie[this.zzcum.size()];
                this.zzcum.values().toArray(this.zzcul.zzpil);
                if (zzaeg.isEnabled()) {
                    String str = this.zzcul.url;
                    String str2 = this.zzcul.zzpim;
                    StringBuilder sb = new StringBuilder(new StringBuilder(String.valueOf(str).length() + 53 + String.valueOf(str2).length()).append("Sending SB report\n  url: ").append(str).append("\n  clickUrl: ").append(str2).append("\n  resources: \n").toString());
                    for (zzfie zzfie : this.zzcul.zzpil) {
                        sb.append("    [");
                        sb.append(zzfie.zzpjq.length);
                        sb.append("] ");
                        sb.append(zzfie.url);
                    }
                    zzaeg.zzbw(sb.toString());
                }
                zzajp<String> zza = new zzahy(this.mContext).zza(1, this.zzcrj.zzcux, (Map<String, String>) null, zzfhs.zzc(this.zzcul));
                if (zzaeg.isEnabled()) {
                    zza.zza(new zzaeb(this), zzagl.zzcyx);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10, int r11) {
        /*
            r8 = this;
            r1 = 3
            java.lang.Object r2 = r8.mLock
            monitor-enter(r2)
            if (r11 != r1) goto L_0x0009
            r0 = 1
            r8.zzcus = r0     // Catch:{ all -> 0x00ac }
        L_0x0009:
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.zzfie> r0 = r8.zzcum     // Catch:{ all -> 0x00ac }
            boolean r0 = r0.containsKey(r9)     // Catch:{ all -> 0x00ac }
            if (r0 == 0) goto L_0x0023
            if (r11 != r1) goto L_0x0021
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.zzfie> r0 = r8.zzcum     // Catch:{ all -> 0x00ac }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x00ac }
            com.google.android.gms.internal.zzfie r0 = (com.google.android.gms.internal.zzfie) r0     // Catch:{ all -> 0x00ac }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x00ac }
            r0.zzpjp = r1     // Catch:{ all -> 0x00ac }
        L_0x0021:
            monitor-exit(r2)     // Catch:{ all -> 0x00ac }
        L_0x0022:
            return
        L_0x0023:
            com.google.android.gms.internal.zzfie r3 = new com.google.android.gms.internal.zzfie     // Catch:{ all -> 0x00ac }
            r3.<init>()     // Catch:{ all -> 0x00ac }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x00ac }
            r3.zzpjp = r0     // Catch:{ all -> 0x00ac }
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.zzfie> r0 = r8.zzcum     // Catch:{ all -> 0x00ac }
            int r0 = r0.size()     // Catch:{ all -> 0x00ac }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00ac }
            r3.zzjhl = r0     // Catch:{ all -> 0x00ac }
            r3.url = r9     // Catch:{ all -> 0x00ac }
            com.google.android.gms.internal.zzfhz r0 = new com.google.android.gms.internal.zzfhz     // Catch:{ all -> 0x00ac }
            r0.<init>()     // Catch:{ all -> 0x00ac }
            r3.zzpjk = r0     // Catch:{ all -> 0x00ac }
            java.util.HashSet<java.lang.String> r0 = r8.zzcup     // Catch:{ all -> 0x00ac }
            int r0 = r0.size()     // Catch:{ all -> 0x00ac }
            if (r0 <= 0) goto L_0x00c2
            if (r10 == 0) goto L_0x00c2
            java.util.LinkedList r4 = new java.util.LinkedList     // Catch:{ all -> 0x00ac }
            r4.<init>()     // Catch:{ all -> 0x00ac }
            java.util.Set r0 = r10.entrySet()     // Catch:{ all -> 0x00ac }
            java.util.Iterator r5 = r0.iterator()     // Catch:{ all -> 0x00ac }
        L_0x005a:
            boolean r0 = r5.hasNext()     // Catch:{ all -> 0x00ac }
            if (r0 == 0) goto L_0x00b5
            java.lang.Object r0 = r5.next()     // Catch:{ all -> 0x00ac }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x00ac }
            java.lang.Object r1 = r0.getKey()     // Catch:{ UnsupportedEncodingException -> 0x00a5 }
            if (r1 == 0) goto L_0x00af
            java.lang.Object r1 = r0.getKey()     // Catch:{ UnsupportedEncodingException -> 0x00a5 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ UnsupportedEncodingException -> 0x00a5 }
        L_0x0072:
            java.lang.Object r6 = r0.getValue()     // Catch:{ UnsupportedEncodingException -> 0x00a5 }
            if (r6 == 0) goto L_0x00b2
            java.lang.Object r0 = r0.getValue()     // Catch:{ UnsupportedEncodingException -> 0x00a5 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ UnsupportedEncodingException -> 0x00a5 }
        L_0x007e:
            java.util.Locale r6 = java.util.Locale.ENGLISH     // Catch:{ UnsupportedEncodingException -> 0x00a5 }
            java.lang.String r6 = r1.toLowerCase(r6)     // Catch:{ UnsupportedEncodingException -> 0x00a5 }
            java.util.HashSet<java.lang.String> r7 = r8.zzcup     // Catch:{ UnsupportedEncodingException -> 0x00a5 }
            boolean r6 = r7.contains(r6)     // Catch:{ UnsupportedEncodingException -> 0x00a5 }
            if (r6 == 0) goto L_0x005a
            com.google.android.gms.internal.zzfhy r6 = new com.google.android.gms.internal.zzfhy     // Catch:{ UnsupportedEncodingException -> 0x00a5 }
            r6.<init>()     // Catch:{ UnsupportedEncodingException -> 0x00a5 }
            java.lang.String r7 = "UTF-8"
            byte[] r1 = r1.getBytes(r7)     // Catch:{ UnsupportedEncodingException -> 0x00a5 }
            r6.zzpiw = r1     // Catch:{ UnsupportedEncodingException -> 0x00a5 }
            java.lang.String r1 = "UTF-8"
            byte[] r0 = r0.getBytes(r1)     // Catch:{ UnsupportedEncodingException -> 0x00a5 }
            r6.zzodc = r0     // Catch:{ UnsupportedEncodingException -> 0x00a5 }
            r4.add(r6)     // Catch:{ UnsupportedEncodingException -> 0x00a5 }
            goto L_0x005a
        L_0x00a5:
            r0 = move-exception
            java.lang.String r0 = "Cannot convert string to bytes, skip header."
            com.google.android.gms.internal.zzaeg.zzbw(r0)     // Catch:{ all -> 0x00ac }
            goto L_0x005a
        L_0x00ac:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00ac }
            throw r0
        L_0x00af:
            java.lang.String r1 = ""
            goto L_0x0072
        L_0x00b2:
            java.lang.String r0 = ""
            goto L_0x007e
        L_0x00b5:
            int r0 = r4.size()     // Catch:{ all -> 0x00ac }
            com.google.android.gms.internal.zzfhy[] r0 = new com.google.android.gms.internal.zzfhy[r0]     // Catch:{ all -> 0x00ac }
            r4.toArray(r0)     // Catch:{ all -> 0x00ac }
            com.google.android.gms.internal.zzfhz r1 = r3.zzpjk     // Catch:{ all -> 0x00ac }
            r1.zzpiy = r0     // Catch:{ all -> 0x00ac }
        L_0x00c2:
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.zzfie> r0 = r8.zzcum     // Catch:{ all -> 0x00ac }
            r0.put(r9, r3)     // Catch:{ all -> 0x00ac }
            monitor-exit(r2)     // Catch:{ all -> 0x00ac }
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzady.zza(java.lang.String, java.util.Map, int):void");
    }

    public final void zzbu(String str) {
        synchronized (this.mLock) {
            this.zzcul.zzpim = str;
        }
    }

    public final void zzl(View view) {
        if (this.zzcrj.zzcuy && !this.zzcur) {
            zzbs.zzec();
            Bitmap zzn = zzagr.zzn(view);
            if (zzn == null) {
                zzaeg.zzbw("Failed to capture the webview bitmap.");
                return;
            }
            this.zzcur = true;
            zzagr.zzb(new zzadz(this, zzn));
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzo(@Nullable Map<String, String> map) throws JSONException {
        if (map != null) {
            for (String next : map.keySet()) {
                JSONArray optJSONArray = new JSONObject(map.get(next)).optJSONArray("matches");
                if (optJSONArray != null) {
                    synchronized (this.mLock) {
                        int length = optJSONArray.length();
                        zzfie zzbv = zzbv(next);
                        if (zzbv == null) {
                            String valueOf = String.valueOf(next);
                            zzaeg.zzbw(valueOf.length() != 0 ? "Cannot find the corresponding resource object for ".concat(valueOf) : new String("Cannot find the corresponding resource object for "));
                        } else {
                            zzbv.zzpjq = new String[length];
                            for (int i = 0; i < length; i++) {
                                zzbv.zzpjq[i] = optJSONArray.getJSONObject(i).getString("threat_type");
                            }
                            this.zzcuo = (length > 0) | this.zzcuo;
                        }
                    }
                }
            }
        }
    }

    public final zzaee zzoe() {
        return this.zzcrj;
    }

    public final boolean zzof() {
        return zzq.zzama() && this.zzcrj.zzcuy && !this.zzcur;
    }

    public final void zzog() {
        this.zzcuq = true;
    }

    public final void zzoh() {
        synchronized (this.mLock) {
            zzajp<Map<String, String>> zza = this.zzcun.zza(this.mContext, this.zzcum.keySet());
            zza.zza(new zzaea(this, zza), zzagl.zzcyx);
        }
    }
}
