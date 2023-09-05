package com.google.android.gms.ads.internal.gmsg;

import android.content.Context;
import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzagl;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zzzb;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
@zzzb
@KeepName
public class HttpClient implements zzt<com.google.android.gms.ads.internal.p004js.zza> {
    private final Context mContext;
    private final zzaiy zzaov;

    @zzzb
    static class zza {
        private final String mValue;
        private final String zzbfo;

        public zza(String str, String str2) {
            this.zzbfo = str;
            this.mValue = str2;
        }

        public final String getKey() {
            return this.zzbfo;
        }

        public final String getValue() {
            return this.mValue;
        }
    }

    @zzzb
    static class zzb {
        private final String zzbvz;
        private final URL zzbwa;
        private final ArrayList<zza> zzbwb;
        private final String zzbwc;

        zzb(String str, URL url, ArrayList<zza> arrayList, String str2) {
            this.zzbvz = str;
            this.zzbwa = url;
            this.zzbwb = arrayList;
            this.zzbwc = str2;
        }

        public final String zzkh() {
            return this.zzbvz;
        }

        public final URL zzki() {
            return this.zzbwa;
        }

        public final ArrayList<zza> zzkj() {
            return this.zzbwb;
        }

        public final String zzkk() {
            return this.zzbwc;
        }
    }

    @zzzb
    class zzc {
        private final zzd zzbwd;
        private final boolean zzbwe;
        private final String zzbwf;

        public zzc(HttpClient httpClient, boolean z, zzd zzd, String str) {
            this.zzbwe = z;
            this.zzbwd = zzd;
            this.zzbwf = str;
        }

        public final String getReason() {
            return this.zzbwf;
        }

        public final boolean isSuccess() {
            return this.zzbwe;
        }

        public final zzd zzkl() {
            return this.zzbwd;
        }
    }

    @zzzb
    static class zzd {
        private final String zzbrz;
        private final String zzbvz;
        private final int zzbwg;
        private final List<zza> zzbwh;

        zzd(String str, int i, List<zza> list, String str2) {
            this.zzbvz = str;
            this.zzbwg = i;
            this.zzbwh = list;
            this.zzbrz = str2;
        }

        public final String getBody() {
            return this.zzbrz;
        }

        public final int getResponseCode() {
            return this.zzbwg;
        }

        public final String zzkh() {
            return this.zzbvz;
        }

        public final Iterable<zza> zzkm() {
            return this.zzbwh;
        }
    }

    public HttpClient(Context context, zzaiy zzaiy) {
        this.mContext = context;
        this.zzaov = zzaiy;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.ads.internal.gmsg.HttpClient.zzc zza(com.google.android.gms.ads.internal.gmsg.HttpClient.zzb r10) {
        /*
            r9 = this;
            r1 = 0
            r2 = 0
            java.net.URL r0 = r10.zzki()     // Catch:{ Exception -> 0x00fa, all -> 0x00f5 }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x00fa, all -> 0x00f5 }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x00fa, all -> 0x00f5 }
            com.google.android.gms.internal.zzagr r1 = com.google.android.gms.ads.internal.zzbs.zzec()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            android.content.Context r3 = r9.mContext     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            com.google.android.gms.internal.zzaiy r4 = r9.zzaov     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            java.lang.String r4 = r4.zzcp     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            r5 = 0
            r1.zza((android.content.Context) r3, (java.lang.String) r4, (boolean) r5, (java.net.HttpURLConnection) r0)     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            java.util.ArrayList r1 = r10.zzkj()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            int r4 = r1.size()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            r3 = r2
        L_0x0025:
            if (r3 >= r4) goto L_0x004e
            java.lang.Object r2 = r1.get(r3)     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            int r3 = r3 + 1
            com.google.android.gms.ads.internal.gmsg.HttpClient$zza r2 = (com.google.android.gms.ads.internal.gmsg.HttpClient.zza) r2     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            java.lang.String r5 = r2.getKey()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            java.lang.String r2 = r2.getValue()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            r0.addRequestProperty(r5, r2)     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            goto L_0x0025
        L_0x003b:
            r1 = move-exception
            r2 = r0
        L_0x003d:
            com.google.android.gms.ads.internal.gmsg.HttpClient$zzc r0 = new com.google.android.gms.ads.internal.gmsg.HttpClient$zzc     // Catch:{ all -> 0x00f7 }
            r3 = 0
            r4 = 0
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00f7 }
            r0.<init>(r9, r3, r4, r1)     // Catch:{ all -> 0x00f7 }
            if (r2 == 0) goto L_0x004d
            r2.disconnect()
        L_0x004d:
            return r0
        L_0x004e:
            java.lang.String r1 = r10.zzkk()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            if (r1 != 0) goto L_0x0077
            r1 = 1
            r0.setDoOutput(r1)     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            java.lang.String r1 = r10.zzkk()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            byte[] r1 = r1.getBytes()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            int r2 = r1.length     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            r0.setFixedLengthStreamingMode(r2)     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            java.io.OutputStream r3 = r0.getOutputStream()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            r2.<init>(r3)     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            r2.write(r1)     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            r2.close()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
        L_0x0077:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            r4.<init>()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            java.util.Map r1 = r0.getHeaderFields()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            if (r1 == 0) goto L_0x00c9
            java.util.Map r1 = r0.getHeaderFields()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            java.util.Set r1 = r1.entrySet()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            java.util.Iterator r5 = r1.iterator()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
        L_0x008e:
            boolean r1 = r5.hasNext()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            if (r1 == 0) goto L_0x00c9
            java.lang.Object r1 = r5.next()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            java.lang.Object r2 = r1.getValue()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            java.util.List r2 = (java.util.List) r2     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            java.util.Iterator r6 = r2.iterator()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
        L_0x00a4:
            boolean r2 = r6.hasNext()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            if (r2 == 0) goto L_0x008e
            java.lang.Object r2 = r6.next()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            com.google.android.gms.ads.internal.gmsg.HttpClient$zza r7 = new com.google.android.gms.ads.internal.gmsg.HttpClient$zza     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            java.lang.Object r3 = r1.getKey()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            r7.<init>(r3, r2)     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            r4.add(r7)     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            goto L_0x00a4
        L_0x00bf:
            r1 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
        L_0x00c3:
            if (r1 == 0) goto L_0x00c8
            r1.disconnect()
        L_0x00c8:
            throw r0
        L_0x00c9:
            com.google.android.gms.ads.internal.gmsg.HttpClient$zzd r2 = new com.google.android.gms.ads.internal.gmsg.HttpClient$zzd     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            java.lang.String r1 = r10.zzkh()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            int r3 = r0.getResponseCode()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            com.google.android.gms.ads.internal.zzbs.zzec()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            java.io.InputStream r6 = r0.getInputStream()     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            r5.<init>(r6)     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            java.lang.String r5 = com.google.android.gms.internal.zzagr.zza((java.io.InputStreamReader) r5)     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            r2.<init>(r1, r3, r4, r5)     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            com.google.android.gms.ads.internal.gmsg.HttpClient$zzc r1 = new com.google.android.gms.ads.internal.gmsg.HttpClient$zzc     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            r3 = 1
            r4 = 0
            r1.<init>(r9, r3, r2, r4)     // Catch:{ Exception -> 0x003b, all -> 0x00bf }
            if (r0 == 0) goto L_0x00f2
            r0.disconnect()
        L_0x00f2:
            r0 = r1
            goto L_0x004d
        L_0x00f5:
            r0 = move-exception
            goto L_0x00c3
        L_0x00f7:
            r0 = move-exception
            r1 = r2
            goto L_0x00c3
        L_0x00fa:
            r0 = move-exception
            r2 = r1
            r1 = r0
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.gmsg.HttpClient.zza(com.google.android.gms.ads.internal.gmsg.HttpClient$zzb):com.google.android.gms.ads.internal.gmsg.HttpClient$zzc");
    }

    private static JSONObject zza(zzd zzd2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", zzd2.zzkh());
            if (zzd2.getBody() != null) {
                jSONObject.put("body", zzd2.getBody());
            }
            JSONArray jSONArray = new JSONArray();
            for (zza next : zzd2.zzkm()) {
                jSONArray.put(new JSONObject().put("key", next.getKey()).put(FirebaseAnalytics.Param.VALUE, next.getValue()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", zzd2.getResponseCode());
        } catch (JSONException e) {
            zzafj.zzb("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    private static zzb zzd(JSONObject jSONObject) {
        URL url;
        String optString = jSONObject.optString("http_request_id");
        String optString2 = jSONObject.optString("url");
        String optString3 = jSONObject.optString("post_body", (String) null);
        try {
            url = new URL(optString2);
        } catch (MalformedURLException e) {
            zzafj.zzb("Error constructing http request.", e);
            url = null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new zza(optJSONObject.optString("key"), optJSONObject.optString(FirebaseAnalytics.Param.VALUE)));
            }
        }
        return new zzb(optString, url, arrayList, optString3);
    }

    @Keep
    @KeepName
    public JSONObject send(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            String optString = jSONObject.optString("http_request_id");
            zzc zza2 = zza(zzd(jSONObject));
            if (zza2.isSuccess()) {
                jSONObject2.put("response", zza(zza2.zzkl()));
                jSONObject2.put("success", true);
            } else {
                jSONObject2.put("response", new JSONObject().put("http_request_id", optString));
                jSONObject2.put("success", false);
                jSONObject2.put("reason", zza2.getReason());
            }
        } catch (Exception e) {
            zzafj.zzb("Error executing http request.", e);
            try {
                jSONObject2.put("response", new JSONObject().put("http_request_id", ""));
                jSONObject2.put("success", false);
                jSONObject2.put("reason", e.toString());
            } catch (JSONException e2) {
                zzafj.zzb("Error executing http request.", e2);
            }
        }
        return jSONObject2;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzagl.zza(new zzu(this, map, (com.google.android.gms.ads.internal.p004js.zza) obj));
    }
}
