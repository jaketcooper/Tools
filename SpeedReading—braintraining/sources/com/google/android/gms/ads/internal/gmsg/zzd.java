package com.google.android.gms.ads.internal.gmsg;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.internal.p004js.zza;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzagr;
import com.google.android.gms.internal.zzaik;
import com.google.android.gms.internal.zzali;
import com.google.android.gms.internal.zzalo;
import com.google.android.gms.internal.zzalp;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzamv;
import com.google.android.gms.internal.zzanl;
import com.google.android.gms.internal.zzanm;
import com.google.android.gms.internal.zzann;
import com.google.android.gms.internal.zzcs;
import com.google.android.gms.internal.zzct;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzzb;
import java.util.HashMap;
import java.util.Map;

@zzzb
public final class zzd {
    private static zzt<Object> zzbvb = new zzj();
    public static final zzt<zzama> zzbvc = zze.zzbvu;
    public static final zzt<zzama> zzbvd = zzf.zzbvu;
    public static final zzt<zzama> zzbve = zzg.zzbvu;
    public static final zzt<zzama> zzbvf = new zzl();
    public static final zzt<zzama> zzbvg = new zzm();
    public static final zzt<zzama> zzbvh = zzh.zzbvu;
    public static final zzt<Object> zzbvi = new zzn();
    public static final zzt<zzama> zzbvj = new zzo();
    public static final zzt<zzama> zzbvk = zzi.zzbvu;
    public static final zzt<zzama> zzbvl = new zzp();
    public static final zzt<zzama> zzbvm = new zzq();
    public static final zzt<zzali> zzbvn = new zzalo();
    public static final zzt<zzali> zzbvo = new zzalp();
    public static final zzt<zzama> zzbvp = new zzc();
    public static final zzad zzbvq = new zzad();
    public static final zzt<zzama> zzbvr = new zzr();
    public static final zzt<zzama> zzbvs = new zzs();
    public static final zzt<zzama> zzbvt = new zzk();

    static final /* synthetic */ void zza(zza zza, Map map) {
        Uri uri;
        String str = (String) map.get("u");
        if (str == null) {
            zzafj.zzco("URL missing from click GMSG.");
            return;
        }
        Uri parse = Uri.parse(str);
        try {
            zzcs zzss = ((zzanl) zza).zzss();
            if (zzss == null || !zzss.zzb(parse)) {
                uri = parse;
            } else {
                Context context = ((zzamv) zza).getContext();
                zzann zzann = (zzann) zza;
                if (zzann == null) {
                    throw null;
                }
                uri = zzss.zza(parse, context, (View) zzann);
            }
            parse = uri;
        } catch (zzct e) {
            String valueOf = String.valueOf(str);
            zzafj.zzco(valueOf.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf) : new String("Unable to append parameter to URL: "));
        }
        if ((((Boolean) zzbs.zzep().zzd(zzmq.zzbjg)).booleanValue() && zzbs.zzfa().zzr(((zzamv) zza).getContext())) && TextUtils.isEmpty(parse.getQueryParameter("fbs_aeid"))) {
            String zzz = zzbs.zzfa().zzz(((zzamv) zza).getContext());
            zzbs.zzec();
            parse = zzagr.zzb(parse.toString(), "fbs_aeid", zzz);
            zzbs.zzfa().zze(((zzamv) zza).getContext(), zzz);
        }
        new zzaik(((zzamv) zza).getContext(), ((zzanm) zza).zzsb().zzcp, parse.toString()).zzps();
    }

    static final /* synthetic */ void zza(zzamv zzamv, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzafj.zzco("URL missing from httpTrack GMSG.");
        } else {
            new zzaik(zzamv.getContext(), ((zzanm) zzamv).zzsb().zzcp, str).zzps();
        }
    }

    static final /* synthetic */ void zza(zzanl zzanl, Map map) {
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzcs zzss = zzanl.zzss();
            if (zzss != null) {
                zzss.zzad().zza(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException e) {
            zzafj.zzco("Could not parse touch parameters from gmsg.");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x010f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final /* synthetic */ void zzb(com.google.android.gms.internal.zzamv r16, java.util.Map r17) {
        /*
            android.content.Context r1 = r16.getContext()
            android.content.pm.PackageManager r4 = r1.getPackageManager()
            java.lang.String r1 = "data"
            r0 = r17
            java.lang.Object r1 = r0.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00cb }
            r2.<init>(r1)     // Catch:{ JSONException -> 0x00cb }
            java.lang.String r1 = "intents"
            org.json.JSONArray r5 = r2.getJSONArray(r1)     // Catch:{ JSONException -> 0x00db }
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            r1 = 0
        L_0x0023:
            int r2 = r5.length()
            if (r1 >= r2) goto L_0x0118
            org.json.JSONObject r2 = r5.getJSONObject(r1)     // Catch:{ JSONException -> 0x00eb }
            java.lang.String r3 = "id"
            java.lang.String r7 = r2.optString(r3)
            java.lang.String r3 = "u"
            java.lang.String r8 = r2.optString(r3)
            java.lang.String r3 = "i"
            java.lang.String r9 = r2.optString(r3)
            java.lang.String r3 = "m"
            java.lang.String r10 = r2.optString(r3)
            java.lang.String r3 = "p"
            java.lang.String r11 = r2.optString(r3)
            java.lang.String r3 = "c"
            java.lang.String r12 = r2.optString(r3)
            java.lang.String r3 = "f"
            r2.optString(r3)
            java.lang.String r3 = "e"
            r2.optString(r3)
            java.lang.String r3 = "intent_url"
            java.lang.String r2 = r2.optString(r3)
            r3 = 0
            boolean r13 = android.text.TextUtils.isEmpty(r2)
            if (r13 != 0) goto L_0x0106
            r13 = 0
            android.content.Intent r2 = android.content.Intent.parseUri(r2, r13)     // Catch:{ URISyntaxException -> 0x00f2 }
        L_0x006d:
            if (r2 != 0) goto L_0x00bb
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            boolean r3 = android.text.TextUtils.isEmpty(r8)
            if (r3 != 0) goto L_0x0081
            android.net.Uri r3 = android.net.Uri.parse(r8)
            r2.setData(r3)
        L_0x0081:
            boolean r3 = android.text.TextUtils.isEmpty(r9)
            if (r3 != 0) goto L_0x008a
            r2.setAction(r9)
        L_0x008a:
            boolean r3 = android.text.TextUtils.isEmpty(r10)
            if (r3 != 0) goto L_0x0093
            r2.setType(r10)
        L_0x0093:
            boolean r3 = android.text.TextUtils.isEmpty(r11)
            if (r3 != 0) goto L_0x009c
            r2.setPackage(r11)
        L_0x009c:
            boolean r3 = android.text.TextUtils.isEmpty(r12)
            if (r3 != 0) goto L_0x00bb
            java.lang.String r3 = "/"
            r8 = 2
            java.lang.String[] r3 = r12.split(r3, r8)
            int r8 = r3.length
            r9 = 2
            if (r8 != r9) goto L_0x00bb
            android.content.ComponentName r8 = new android.content.ComponentName
            r9 = 0
            r9 = r3[r9]
            r10 = 1
            r3 = r3[r10]
            r8.<init>(r9, r3)
            r2.setComponent(r8)
        L_0x00bb:
            r3 = 65536(0x10000, float:9.18355E-41)
            android.content.pm.ResolveInfo r2 = r4.resolveActivity(r2, r3)
            if (r2 == 0) goto L_0x010f
            r2 = 1
        L_0x00c4:
            r6.put(r7, r2)     // Catch:{ JSONException -> 0x0111 }
        L_0x00c7:
            int r1 = r1 + 1
            goto L_0x0023
        L_0x00cb:
            r1 = move-exception
            com.google.android.gms.ads.internal.js.zza r16 = (com.google.android.gms.ads.internal.p004js.zza) r16
            java.lang.String r1 = "openableIntents"
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            r0 = r16
            r0.zza((java.lang.String) r1, (org.json.JSONObject) r2)
        L_0x00da:
            return
        L_0x00db:
            r1 = move-exception
            com.google.android.gms.ads.internal.js.zza r16 = (com.google.android.gms.ads.internal.p004js.zza) r16
            java.lang.String r1 = "openableIntents"
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            r0 = r16
            r0.zza((java.lang.String) r1, (org.json.JSONObject) r2)
            goto L_0x00da
        L_0x00eb:
            r2 = move-exception
            java.lang.String r3 = "Error parsing the intent data."
            com.google.android.gms.internal.zzafj.zzb(r3, r2)
            goto L_0x00c7
        L_0x00f2:
            r13 = move-exception
            java.lang.String r14 = "Error parsing the url: "
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r15 = r2.length()
            if (r15 == 0) goto L_0x0109
            java.lang.String r2 = r14.concat(r2)
        L_0x0103:
            com.google.android.gms.internal.zzafj.zzb(r2, r13)
        L_0x0106:
            r2 = r3
            goto L_0x006d
        L_0x0109:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r14)
            goto L_0x0103
        L_0x010f:
            r2 = 0
            goto L_0x00c4
        L_0x0111:
            r2 = move-exception
            java.lang.String r3 = "Error constructing openable urls response."
            com.google.android.gms.internal.zzafj.zzb(r3, r2)
            goto L_0x00c7
        L_0x0118:
            com.google.android.gms.ads.internal.js.zza r16 = (com.google.android.gms.ads.internal.p004js.zza) r16
            java.lang.String r1 = "openableIntents"
            r0 = r16
            r0.zza((java.lang.String) r1, (org.json.JSONObject) r6)
            goto L_0x00da
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.gmsg.zzd.zzb(com.google.android.gms.internal.zzamv, java.util.Map):void");
    }

    static final /* synthetic */ void zzc(zzamv zzamv, Map map) {
        String str = (String) map.get("urls");
        if (TextUtils.isEmpty(str)) {
            zzafj.zzco("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str.split(",");
        HashMap hashMap = new HashMap();
        PackageManager packageManager = zzamv.getContext().getPackageManager();
        for (String str2 : split) {
            String[] split2 = str2.split(";", 2);
            hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) != null));
        }
        ((zza) zzamv).zza("openableURLs", (Map<String, ?>) hashMap);
    }
}
