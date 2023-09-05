package com.google.android.gms.ads.internal.gmsg;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzamv;
import com.google.android.gms.internal.zzamw;
import com.google.android.gms.internal.zzanj;
import com.google.android.gms.internal.zzanl;
import com.google.android.gms.internal.zzann;
import com.google.android.gms.internal.zzcs;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzvw;
import com.google.android.gms.internal.zzzb;
import java.util.Map;

@zzzb
public final class zzab<T extends zzamv & zzamw & zzanj & zzanl & zzann> implements zzt<T> {
    private final Context mContext;
    private zzaiy zzaqi;
    private zzin zzbbt;
    private zzb zzbva;
    private zzw zzbwk;
    private zzvw zzbwl;
    private final zzcs zzbwn;
    private zzq zzbwo;
    private zzn zzbwp;
    private zzama zzbwq = null;

    public zzab(Context context, zzaiy zzaiy, zzcs zzcs, zzq zzq, zzin zzin, zzb zzb, zzn zzn, zzw zzw, zzvw zzvw) {
        this.mContext = context;
        this.zzaqi = zzaiy;
        this.zzbwn = zzcs;
        this.zzbwo = zzq;
        this.zzbbt = zzin;
        this.zzbva = zzb;
        this.zzbwk = zzw;
        this.zzbwl = zzvw;
        this.zzbwp = zzn;
    }

    private static boolean zzj(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zzk(Map<String, String> map) {
        String str = map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return zzbs.zzee().zzqa();
            }
            if ("l".equalsIgnoreCase(str)) {
                return zzbs.zzee().zzpz();
            }
            if ("c".equalsIgnoreCase(str)) {
                return zzbs.zzee().zzqb();
            }
        }
        return -1;
    }

    private final void zzk(boolean z) {
        if (this.zzbwl != null) {
            this.zzbwl.zzl(z);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0122 A[SYNTHETIC, Splitter:B:46:0x0122] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(java.lang.Object r10, java.util.Map r11) {
        /*
            r9 = this;
            r5 = 1
            r4 = 0
            r6 = 0
            com.google.android.gms.internal.zzamv r10 = (com.google.android.gms.internal.zzamv) r10
            java.lang.String r1 = "u"
            java.lang.Object r1 = r11.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            android.content.Context r2 = r10.getContext()
            java.lang.String r3 = com.google.android.gms.internal.zzaeo.zzb(r1, r2)
            java.lang.String r1 = "a"
            java.lang.Object r1 = r11.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x0025
            java.lang.String r1 = "Action missing from an open GMSG."
            com.google.android.gms.internal.zzafj.zzco(r1)
        L_0x0024:
            return
        L_0x0025:
            com.google.android.gms.ads.internal.zzw r2 = r9.zzbwk
            if (r2 == 0) goto L_0x0037
            com.google.android.gms.ads.internal.zzw r2 = r9.zzbwk
            boolean r2 = r2.zzcu()
            if (r2 != 0) goto L_0x0037
            com.google.android.gms.ads.internal.zzw r1 = r9.zzbwk
            r1.zzs(r3)
            goto L_0x0024
        L_0x0037:
            java.lang.String r2 = "expand"
            boolean r2 = r2.equalsIgnoreCase(r1)
            if (r2 == 0) goto L_0x005f
            r1 = r10
            com.google.android.gms.internal.zzamw r1 = (com.google.android.gms.internal.zzamw) r1
            boolean r1 = r1.zzst()
            if (r1 == 0) goto L_0x004e
            java.lang.String r1 = "Cannot expand WebView that is already expanded."
            com.google.android.gms.internal.zzafj.zzco(r1)
            goto L_0x0024
        L_0x004e:
            r9.zzk((boolean) r4)
            com.google.android.gms.internal.zzanj r10 = (com.google.android.gms.internal.zzanj) r10
            boolean r1 = zzj(r11)
            int r2 = zzk((java.util.Map<java.lang.String, java.lang.String>) r11)
            r10.zza(r1, r2)
            goto L_0x0024
        L_0x005f:
            java.lang.String r2 = "webapp"
            boolean r2 = r2.equalsIgnoreCase(r1)
            if (r2 == 0) goto L_0x0098
            r9.zzk((boolean) r4)
            if (r3 == 0) goto L_0x007a
            com.google.android.gms.internal.zzanj r10 = (com.google.android.gms.internal.zzanj) r10
            boolean r1 = zzj(r11)
            int r2 = zzk((java.util.Map<java.lang.String, java.lang.String>) r11)
            r10.zza(r1, r2, r3)
            goto L_0x0024
        L_0x007a:
            com.google.android.gms.internal.zzanj r10 = (com.google.android.gms.internal.zzanj) r10
            boolean r3 = zzj(r11)
            int r4 = zzk((java.util.Map<java.lang.String, java.lang.String>) r11)
            java.lang.String r1 = "html"
            java.lang.Object r1 = r11.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "baseurl"
            java.lang.Object r2 = r11.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            r10.zza(r3, r4, r1, r2)
            goto L_0x0024
        L_0x0098:
            java.lang.String r2 = "app"
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x00f5
            java.lang.String r2 = "true"
            java.lang.String r1 = "system_browser"
            java.lang.Object r1 = r11.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x00f5
            r9.zzk((boolean) r5)
            r10.getContext()
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 == 0) goto L_0x00c3
            java.lang.String r1 = "Destination url cannot be empty."
            com.google.android.gms.internal.zzafj.zzco(r1)
            goto L_0x0024
        L_0x00c3:
            com.google.android.gms.ads.internal.gmsg.zzac r2 = new com.google.android.gms.ads.internal.gmsg.zzac
            android.content.Context r3 = r10.getContext()
            r1 = r10
            com.google.android.gms.internal.zzanl r1 = (com.google.android.gms.internal.zzanl) r1
            com.google.android.gms.internal.zzcs r4 = r1.zzss()
            r1 = r10
            com.google.android.gms.internal.zzann r1 = (com.google.android.gms.internal.zzann) r1
            if (r1 != 0) goto L_0x00d6
            throw r6
        L_0x00d6:
            android.view.View r1 = (android.view.View) r1
            r2.<init>(r3, r4, r1)
            android.content.Intent r1 = r2.zzl(r11)
            com.google.android.gms.internal.zzanj r10 = (com.google.android.gms.internal.zzanj) r10     // Catch:{ ActivityNotFoundException -> 0x00eb }
            com.google.android.gms.ads.internal.overlay.zzc r2 = new com.google.android.gms.ads.internal.overlay.zzc     // Catch:{ ActivityNotFoundException -> 0x00eb }
            r2.<init>(r1)     // Catch:{ ActivityNotFoundException -> 0x00eb }
            r10.zza(r2)     // Catch:{ ActivityNotFoundException -> 0x00eb }
            goto L_0x0024
        L_0x00eb:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            com.google.android.gms.internal.zzafj.zzco(r1)
            goto L_0x0024
        L_0x00f5:
            r9.zzk((boolean) r5)
            java.lang.String r1 = "intent_url"
            java.lang.Object r1 = r11.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0171
            r2 = 0
            android.content.Intent r1 = android.content.Intent.parseUri(r1, r2)     // Catch:{ URISyntaxException -> 0x015d }
            r5 = r1
        L_0x010c:
            if (r5 == 0) goto L_0x014f
            android.net.Uri r1 = r5.getData()
            if (r1 == 0) goto L_0x014f
            android.net.Uri r2 = r5.getData()
            java.lang.String r4 = r2.toString()
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 != 0) goto L_0x019d
            com.google.android.gms.ads.internal.zzbs.zzec()     // Catch:{ Exception -> 0x0138 }
            android.content.Context r7 = r10.getContext()     // Catch:{ Exception -> 0x0138 }
            r0 = r10
            com.google.android.gms.internal.zzanl r0 = (com.google.android.gms.internal.zzanl) r0     // Catch:{ Exception -> 0x0138 }
            r1 = r0
            com.google.android.gms.internal.zzcs r8 = r1.zzss()     // Catch:{ Exception -> 0x0138 }
            r0 = r10
            com.google.android.gms.internal.zzann r0 = (com.google.android.gms.internal.zzann) r0     // Catch:{ Exception -> 0x0138 }
            r1 = r0
            if (r1 != 0) goto L_0x0179
            throw r6     // Catch:{ Exception -> 0x0138 }
        L_0x0138:
            r1 = move-exception
            java.lang.String r7 = "Error occurred while adding signals."
            com.google.android.gms.internal.zzafj.zzb(r7, r1)
            com.google.android.gms.internal.zzaez r7 = com.google.android.gms.ads.internal.zzbs.zzeg()
            java.lang.String r8 = "OpenGmsgHandler.onGmsg"
            r7.zza((java.lang.Throwable) r1, (java.lang.String) r8)
            r1 = r4
        L_0x0148:
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch:{ Exception -> 0x0180 }
        L_0x014c:
            r5.setData(r1)
        L_0x014f:
            if (r5 == 0) goto L_0x01a5
            com.google.android.gms.internal.zzanj r10 = (com.google.android.gms.internal.zzanj) r10
            com.google.android.gms.ads.internal.overlay.zzc r1 = new com.google.android.gms.ads.internal.overlay.zzc
            r1.<init>(r5)
            r10.zza(r1)
            goto L_0x0024
        L_0x015d:
            r2 = move-exception
            java.lang.String r4 = "Error parsing the url: "
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r5 = r1.length()
            if (r5 == 0) goto L_0x0173
            java.lang.String r1 = r4.concat(r1)
        L_0x016e:
            com.google.android.gms.internal.zzafj.zzb(r1, r2)
        L_0x0171:
            r5 = r6
            goto L_0x010c
        L_0x0173:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r4)
            goto L_0x016e
        L_0x0179:
            android.view.View r1 = (android.view.View) r1     // Catch:{ Exception -> 0x0138 }
            java.lang.String r1 = com.google.android.gms.internal.zzagr.zza((android.content.Context) r7, (com.google.android.gms.internal.zzcs) r8, (java.lang.String) r4, (android.view.View) r1)     // Catch:{ Exception -> 0x0138 }
            goto L_0x0148
        L_0x0180:
            r4 = move-exception
            java.lang.String r7 = "Error parsing the uri: "
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r8 = r1.length()
            if (r8 == 0) goto L_0x019f
            java.lang.String r1 = r7.concat(r1)
        L_0x0191:
            com.google.android.gms.internal.zzafj.zzb(r1, r4)
            com.google.android.gms.internal.zzaez r1 = com.google.android.gms.ads.internal.zzbs.zzeg()
            java.lang.String r7 = "OpenGmsgHandler.onGmsg"
            r1.zza((java.lang.Throwable) r4, (java.lang.String) r7)
        L_0x019d:
            r1 = r2
            goto L_0x014c
        L_0x019f:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r7)
            goto L_0x0191
        L_0x01a5:
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 != 0) goto L_0x01c5
            com.google.android.gms.ads.internal.zzbs.zzec()
            android.content.Context r2 = r10.getContext()
            r1 = r10
            com.google.android.gms.internal.zzanl r1 = (com.google.android.gms.internal.zzanl) r1
            com.google.android.gms.internal.zzcs r4 = r1.zzss()
            r1 = r10
            com.google.android.gms.internal.zzann r1 = (com.google.android.gms.internal.zzann) r1
            if (r1 != 0) goto L_0x01bf
            throw r6
        L_0x01bf:
            android.view.View r1 = (android.view.View) r1
            java.lang.String r3 = com.google.android.gms.internal.zzagr.zza((android.content.Context) r2, (com.google.android.gms.internal.zzcs) r4, (java.lang.String) r3, (android.view.View) r1)
        L_0x01c5:
            com.google.android.gms.internal.zzanj r10 = (com.google.android.gms.internal.zzanj) r10
            com.google.android.gms.ads.internal.overlay.zzc r1 = new com.google.android.gms.ads.internal.overlay.zzc
            java.lang.String r2 = "i"
            java.lang.Object r2 = r11.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r4 = "m"
            java.lang.Object r4 = r11.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = "p"
            java.lang.Object r5 = r11.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = "c"
            java.lang.Object r6 = r11.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = "f"
            java.lang.Object r7 = r11.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = "e"
            java.lang.Object r8 = r11.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r10.zza(r1)
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.gmsg.zzab.zza(java.lang.Object, java.util.Map):void");
    }
}
