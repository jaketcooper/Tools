package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableResult;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zzabm {
    private static final SimpleDateFormat zzcqa = new SimpleDateFormat("yyyyMMdd", Locale.US);

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0154 A[Catch:{ JSONException -> 0x0256 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.zzaad zza(android.content.Context r50, com.google.android.gms.internal.zzzz r51, java.lang.String r52) {
        /*
            org.json.JSONObject r28 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0256 }
            r0 = r28
            r1 = r52
            r0.<init>(r1)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "ad_base_url"
            r5 = 0
            r0 = r28
            java.lang.String r6 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "ad_url"
            r5 = 0
            r0 = r28
            java.lang.String r7 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "ad_size"
            r5 = 0
            r0 = r28
            java.lang.String r19 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "ad_slot_size"
            r0 = r28
            r1 = r19
            java.lang.String r43 = r0.optString(r4, r1)     // Catch:{ JSONException -> 0x0256 }
            if (r51 == 0) goto L_0x00df
            r0 = r51
            int r4 = r0.zzclu     // Catch:{ JSONException -> 0x0256 }
            if (r4 == 0) goto L_0x00df
            r27 = 1
        L_0x0038:
            java.lang.String r4 = "ad_json"
            r5 = 0
            r0 = r28
            java.lang.String r5 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x0256 }
            if (r5 != 0) goto L_0x004c
            java.lang.String r4 = "ad_html"
            r5 = 0
            r0 = r28
            java.lang.String r5 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x0256 }
        L_0x004c:
            if (r5 != 0) goto L_0x0057
            java.lang.String r4 = "body"
            r5 = 0
            r0 = r28
            java.lang.String r5 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x0256 }
        L_0x0057:
            if (r5 != 0) goto L_0x0067
            java.lang.String r4 = "ads"
            r0 = r28
            boolean r4 = r0.has(r4)     // Catch:{ JSONException -> 0x0256 }
            if (r4 == 0) goto L_0x0067
            java.lang.String r5 = r28.toString()     // Catch:{ JSONException -> 0x0256 }
        L_0x0067:
            r20 = -1
            java.lang.String r4 = "debug_dialog"
            r8 = 0
            r0 = r28
            java.lang.String r22 = r0.optString(r4, r8)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "debug_signals"
            r8 = 0
            r0 = r28
            java.lang.String r45 = r0.optString(r4, r8)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "interstitial_timeout"
            r0 = r28
            boolean r4 = r0.has(r4)     // Catch:{ JSONException -> 0x0256 }
            if (r4 == 0) goto L_0x00e3
            java.lang.String r4 = "interstitial_timeout"
            r0 = r28
            double r8 = r0.getDouble(r4)     // Catch:{ JSONException -> 0x0256 }
            r10 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r8 = r8 * r10
            long r12 = (long) r8     // Catch:{ JSONException -> 0x0256 }
        L_0x0094:
            java.lang.String r4 = "orientation"
            r8 = 0
            r0 = r28
            java.lang.String r4 = r0.optString(r4, r8)     // Catch:{ JSONException -> 0x0256 }
            r18 = -1
            java.lang.String r8 = "portrait"
            boolean r8 = r8.equals(r4)     // Catch:{ JSONException -> 0x0256 }
            if (r8 == 0) goto L_0x00e6
            com.google.android.gms.internal.zzagw r4 = com.google.android.gms.ads.internal.zzbs.zzee()     // Catch:{ JSONException -> 0x0256 }
            int r18 = r4.zzqa()     // Catch:{ JSONException -> 0x0256 }
        L_0x00af:
            r4 = 0
            boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x0256 }
            if (r8 == 0) goto L_0x028b
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x0256 }
            if (r8 != 0) goto L_0x028b
            r0 = r51
            com.google.android.gms.internal.zzaiy r4 = r0.zzatd     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r6 = r4.zzcp     // Catch:{ JSONException -> 0x0256 }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r4 = r51
            r5 = r50
            com.google.android.gms.internal.zzaad r4 = com.google.android.gms.internal.zzabh.zza(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r6 = r4.zzchl     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r7 = r4.body     // Catch:{ JSONException -> 0x0256 }
            long r0 = r4.zzcnk     // Catch:{ JSONException -> 0x0256 }
            r20 = r0
        L_0x00d6:
            if (r7 != 0) goto L_0x00f7
            com.google.android.gms.internal.zzaad r4 = new com.google.android.gms.internal.zzaad     // Catch:{ JSONException -> 0x0256 }
            r5 = 0
            r4.<init>(r5)     // Catch:{ JSONException -> 0x0256 }
        L_0x00de:
            return r4
        L_0x00df:
            r27 = 0
            goto L_0x0038
        L_0x00e3:
            r12 = -1
            goto L_0x0094
        L_0x00e6:
            java.lang.String r8 = "landscape"
            boolean r4 = r8.equals(r4)     // Catch:{ JSONException -> 0x0256 }
            if (r4 == 0) goto L_0x00af
            com.google.android.gms.internal.zzagw r4 = com.google.android.gms.ads.internal.zzbs.zzee()     // Catch:{ JSONException -> 0x0256 }
            int r18 = r4.zzpz()     // Catch:{ JSONException -> 0x0256 }
            goto L_0x00af
        L_0x00f7:
            java.lang.String r5 = "click_urls"
            r0 = r28
            org.json.JSONArray r5 = r0.optJSONArray(r5)     // Catch:{ JSONException -> 0x0256 }
            if (r4 != 0) goto L_0x0276
            r8 = 0
        L_0x0102:
            if (r5 == 0) goto L_0x0108
            java.util.List r8 = zza((org.json.JSONArray) r5, (java.util.List<java.lang.String>) r8)     // Catch:{ JSONException -> 0x0256 }
        L_0x0108:
            java.lang.String r5 = "impression_urls"
            r0 = r28
            org.json.JSONArray r5 = r0.optJSONArray(r5)     // Catch:{ JSONException -> 0x0256 }
            if (r4 != 0) goto L_0x027a
            r9 = 0
        L_0x0113:
            if (r5 == 0) goto L_0x0119
            java.util.List r9 = zza((org.json.JSONArray) r5, (java.util.List<java.lang.String>) r9)     // Catch:{ JSONException -> 0x0256 }
        L_0x0119:
            java.lang.String r5 = "manual_impression_urls"
            r0 = r28
            org.json.JSONArray r5 = r0.optJSONArray(r5)     // Catch:{ JSONException -> 0x0256 }
            if (r4 != 0) goto L_0x027e
            r15 = 0
        L_0x0124:
            if (r5 == 0) goto L_0x012a
            java.util.List r15 = zza((org.json.JSONArray) r5, (java.util.List<java.lang.String>) r15)     // Catch:{ JSONException -> 0x0256 }
        L_0x012a:
            if (r4 == 0) goto L_0x0288
            int r5 = r4.orientation     // Catch:{ JSONException -> 0x0256 }
            r10 = -1
            if (r5 == r10) goto L_0x0135
            int r0 = r4.orientation     // Catch:{ JSONException -> 0x0256 }
            r18 = r0
        L_0x0135:
            long r10 = r4.zzcnf     // Catch:{ JSONException -> 0x0256 }
            r16 = 0
            int r5 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r5 <= 0) goto L_0x0288
            long r10 = r4.zzcnf     // Catch:{ JSONException -> 0x0256 }
        L_0x013f:
            java.lang.String r4 = "active_view"
            r0 = r28
            java.lang.String r25 = r0.optString(r4)     // Catch:{ JSONException -> 0x0256 }
            r24 = 0
            java.lang.String r4 = "ad_is_javascript"
            r5 = 0
            r0 = r28
            boolean r23 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x0256 }
            if (r23 == 0) goto L_0x015d
            java.lang.String r4 = "ad_passback_url"
            r5 = 0
            r0 = r28
            java.lang.String r24 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x0256 }
        L_0x015d:
            java.lang.String r4 = "mediation"
            r5 = 0
            r0 = r28
            boolean r12 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "custom_render_allowed"
            r5 = 0
            r0 = r28
            boolean r26 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "content_url_opted_out"
            r5 = 1
            r0 = r28
            boolean r29 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "content_vertical_opted_out"
            r5 = 1
            r0 = r28
            boolean r46 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "prefetch"
            r5 = 0
            r0 = r28
            boolean r30 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "refresh_interval_milliseconds"
            r16 = -1
            r0 = r28
            r1 = r16
            long r16 = r0.optLong(r4, r1)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "mediation_config_cache_time_milliseconds"
            r32 = -1
            r0 = r28
            r1 = r32
            long r13 = r0.optLong(r4, r1)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "gws_query_id"
            java.lang.String r5 = ""
            r0 = r28
            java.lang.String r31 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "height"
            java.lang.String r5 = "fluid"
            java.lang.String r32 = ""
            r0 = r28
            r1 = r32
            java.lang.String r5 = r0.optString(r5, r1)     // Catch:{ JSONException -> 0x0256 }
            boolean r32 = r4.equals(r5)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "native_express"
            r5 = 0
            r0 = r28
            boolean r33 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "video_start_urls"
            r0 = r28
            org.json.JSONArray r4 = r0.optJSONArray(r4)     // Catch:{ JSONException -> 0x0256 }
            r5 = 0
            java.util.List r35 = zza((org.json.JSONArray) r4, (java.util.List<java.lang.String>) r5)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "video_complete_urls"
            r0 = r28
            org.json.JSONArray r4 = r0.optJSONArray(r4)     // Catch:{ JSONException -> 0x0256 }
            r5 = 0
            java.util.List r36 = zza((org.json.JSONArray) r4, (java.util.List<java.lang.String>) r5)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "rewards"
            r0 = r28
            org.json.JSONArray r4 = r0.optJSONArray(r4)     // Catch:{ JSONException -> 0x0256 }
            com.google.android.gms.internal.zzadw r34 = com.google.android.gms.internal.zzadw.zza(r4)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "use_displayed_impression"
            r5 = 0
            r0 = r28
            boolean r37 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "auto_protection_configuration"
            r0 = r28
            org.json.JSONObject r4 = r0.optJSONObject(r4)     // Catch:{ JSONException -> 0x0256 }
            com.google.android.gms.internal.zzaaf r38 = com.google.android.gms.internal.zzaaf.zzl(r4)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "set_cookie"
            java.lang.String r5 = ""
            r0 = r28
            java.lang.String r40 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "remote_ping_urls"
            r0 = r28
            org.json.JSONArray r4 = r0.optJSONArray(r4)     // Catch:{ JSONException -> 0x0256 }
            r5 = 0
            java.util.List r41 = zza((org.json.JSONArray) r4, (java.util.List<java.lang.String>) r5)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "safe_browsing"
            r0 = r28
            org.json.JSONObject r4 = r0.optJSONObject(r4)     // Catch:{ JSONException -> 0x0256 }
            com.google.android.gms.internal.zzaee r44 = com.google.android.gms.internal.zzaee.zzo(r4)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "render_in_browser"
            r0 = r51
            boolean r5 = r0.zzcbz     // Catch:{ JSONException -> 0x0256 }
            r0 = r28
            boolean r42 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x0256 }
            java.lang.String r4 = "custom_close_blocked"
            r0 = r28
            boolean r48 = r0.optBoolean(r4)     // Catch:{ JSONException -> 0x0256 }
            com.google.android.gms.internal.zzaad r4 = new com.google.android.gms.internal.zzaad     // Catch:{ JSONException -> 0x0256 }
            r0 = r51
            boolean r0 = r0.zzclw     // Catch:{ JSONException -> 0x0256 }
            r28 = r0
            r0 = r51
            boolean r0 = r0.zzcmk     // Catch:{ JSONException -> 0x0256 }
            r39 = r0
            r0 = r51
            boolean r0 = r0.zzcmw     // Catch:{ JSONException -> 0x0256 }
            r47 = r0
            r49 = 0
            r5 = r51
            r4.<init>(r5, r6, r7, r8, r9, r10, r12, r13, r15, r16, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49)     // Catch:{ JSONException -> 0x0256 }
            goto L_0x00de
        L_0x0256:
            r4 = move-exception
            java.lang.String r5 = "Could not parse the inline ad response: "
            java.lang.String r4 = r4.getMessage()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r6 = r4.length()
            if (r6 == 0) goto L_0x0282
            java.lang.String r4 = r5.concat(r4)
        L_0x026b:
            com.google.android.gms.internal.zzafj.zzco(r4)
            com.google.android.gms.internal.zzaad r4 = new com.google.android.gms.internal.zzaad
            r5 = 0
            r4.<init>(r5)
            goto L_0x00de
        L_0x0276:
            java.util.List<java.lang.String> r8 = r4.zzcbv     // Catch:{ JSONException -> 0x0256 }
            goto L_0x0102
        L_0x027a:
            java.util.List<java.lang.String> r9 = r4.zzcbw     // Catch:{ JSONException -> 0x0256 }
            goto L_0x0113
        L_0x027e:
            java.util.List<java.lang.String> r15 = r4.zzcni     // Catch:{ JSONException -> 0x0256 }
            goto L_0x0124
        L_0x0282:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r5)
            goto L_0x026b
        L_0x0288:
            r10 = r12
            goto L_0x013f
        L_0x028b:
            r7 = r5
            goto L_0x00d6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzabm.zza(android.content.Context, com.google.android.gms.internal.zzzz, java.lang.String):com.google.android.gms.internal.zzaad");
    }

    @Nullable
    private static List<String> zza(@Nullable JSONArray jSONArray, @Nullable List<String> list) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        if (list == null) {
            list = new LinkedList<>();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            list.add(jSONArray.getString(i));
        }
        return list;
    }

    @Nullable
    public static JSONObject zza(Context context, zzabf zzabf) {
        String str;
        zzzz zzzz = zzabf.zzcpe;
        Location location = zzabf.zzbcd;
        zzabu zzabu = zzabf.zzcpf;
        Bundle bundle = zzabf.zzclv;
        JSONObject jSONObject = zzabf.zzcpg;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("extra_caps", zzbs.zzep().zzd(zzmq.zzbmo));
            if (zzabf.zzcmc.size() > 0) {
                hashMap.put("eid", TextUtils.join(",", zzabf.zzcmc));
            }
            if (zzzz.zzcln != null) {
                hashMap.put("ad_pos", zzzz.zzcln);
            }
            zzis zzis = zzzz.zzclo;
            String zzpr = zzafg.zzpr();
            if (zzpr != null) {
                hashMap.put("abf", zzpr);
            }
            if (zzis.zzbbv != -1) {
                hashMap.put("cust_age", zzcqa.format(new Date(zzis.zzbbv)));
            }
            if (zzis.extras != null) {
                hashMap.put("extras", zzis.extras);
            }
            if (zzis.zzbbw != -1) {
                hashMap.put("cust_gender", Integer.valueOf(zzis.zzbbw));
            }
            if (zzis.zzbbx != null) {
                hashMap.put("kw", zzis.zzbbx);
            }
            if (zzis.zzbbz != -1) {
                hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(zzis.zzbbz));
            }
            if (zzis.zzbby) {
                if (((Boolean) zzbs.zzep().zzd(zzmq.zzbqa)).booleanValue()) {
                    hashMap.put("test_request", true);
                } else {
                    hashMap.put("adtest", "on");
                }
            }
            if (zzis.versionCode >= 2) {
                if (zzis.zzbca) {
                    hashMap.put("d_imp_hdr", 1);
                }
                if (!TextUtils.isEmpty(zzis.zzbcb)) {
                    hashMap.put("ppid", zzis.zzbcb);
                }
            }
            if (zzis.versionCode >= 3 && zzis.zzbce != null) {
                hashMap.put("url", zzis.zzbce);
            }
            if (zzis.versionCode >= 5) {
                if (zzis.zzbcg != null) {
                    hashMap.put("custom_targeting", zzis.zzbcg);
                }
                if (zzis.zzbch != null) {
                    hashMap.put("category_exclusions", zzis.zzbch);
                }
                if (zzis.zzbci != null) {
                    hashMap.put("request_agent", zzis.zzbci);
                }
            }
            if (zzis.versionCode >= 6 && zzis.zzbcj != null) {
                hashMap.put("request_pkg", zzis.zzbcj);
            }
            if (zzis.versionCode >= 7) {
                hashMap.put("is_designed_for_families", Boolean.valueOf(zzis.zzbck));
            }
            if (zzzz.zzath.zzbdc != null) {
                boolean z = false;
                boolean z2 = false;
                for (zziw zziw : zzzz.zzath.zzbdc) {
                    if (!zziw.zzbde && !z2) {
                        hashMap.put("format", zziw.zzbda);
                        z2 = true;
                    }
                    if (zziw.zzbde && !z) {
                        hashMap.put("fluid", "height");
                        z = true;
                    }
                    if (z2 && z) {
                        break;
                    }
                }
            } else {
                hashMap.put("format", zzzz.zzath.zzbda);
                if (zzzz.zzath.zzbde) {
                    hashMap.put("fluid", "height");
                }
            }
            if (zzzz.zzath.width == -1) {
                hashMap.put("smart_w", "full");
            }
            if (zzzz.zzath.height == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (zzzz.zzath.zzbdc != null) {
                StringBuilder sb = new StringBuilder();
                boolean z3 = false;
                for (zziw zziw2 : zzzz.zzath.zzbdc) {
                    if (zziw2.zzbde) {
                        z3 = true;
                    } else {
                        if (sb.length() != 0) {
                            sb.append("|");
                        }
                        sb.append(zziw2.width == -1 ? (int) (((float) zziw2.widthPixels) / zzabu.zzaxd) : zziw2.width);
                        sb.append("x");
                        sb.append(zziw2.height == -2 ? (int) (((float) zziw2.heightPixels) / zzabu.zzaxd) : zziw2.height);
                    }
                }
                if (z3) {
                    if (sb.length() != 0) {
                        sb.insert(0, "|");
                    }
                    sb.insert(0, "320x50");
                }
                hashMap.put("sz", sb);
            }
            if (zzzz.zzclu != 0) {
                hashMap.put("native_version", Integer.valueOf(zzzz.zzclu));
                hashMap.put("native_templates", zzzz.zzaub);
                zzom zzom = zzzz.zzatt;
                if (zzom != null) {
                    switch (zzom.zzbtk) {
                        case 0:
                            str = "any";
                            break;
                        case 1:
                            str = "portrait";
                            break;
                        case 2:
                            str = "landscape";
                            break;
                        default:
                            str = "not_set";
                            break;
                    }
                } else {
                    str = "any";
                }
                hashMap.put("native_image_orientation", str);
                if (!zzzz.zzcmd.isEmpty()) {
                    hashMap.put("native_custom_templates", zzzz.zzcmd);
                }
                if (zzzz.versionCode >= 24) {
                    hashMap.put("max_num_ads", Integer.valueOf(zzzz.zzcmz));
                }
                if (!TextUtils.isEmpty(zzzz.zzcmx)) {
                    try {
                        hashMap.put("native_advanced_settings", new JSONArray(zzzz.zzcmx));
                    } catch (JSONException e) {
                        zzafj.zzc("Problem creating json from native advanced settings", e);
                    }
                }
            }
            if (zzzz.zzatx != null && zzzz.zzatx.size() > 0) {
                for (Integer next : zzzz.zzatx) {
                    if (next.intValue() == 2) {
                        hashMap.put("iba", true);
                    } else if (next.intValue() == 1) {
                        hashMap.put("ina", true);
                    }
                }
            }
            if (zzzz.zzath.zzbdf) {
                hashMap.put("ene", true);
            }
            if (zzzz.zzatv != null) {
                hashMap.put("is_icon_ad", true);
                hashMap.put("icon_ad_expansion_behavior", Integer.valueOf(zzzz.zzatv.zzbee));
            }
            hashMap.put("slotname", zzzz.zzatb);
            hashMap.put("pn", zzzz.applicationInfo.packageName);
            if (zzzz.zzclp != null) {
                hashMap.put("vc", Integer.valueOf(zzzz.zzclp.versionCode));
            }
            hashMap.put("ms", zzabf.zzclq);
            hashMap.put("seq_num", zzzz.zzclr);
            hashMap.put("session_id", zzzz.zzcls);
            hashMap.put("js", zzzz.zzatd.zzcp);
            zzace zzace = zzabf.zzcpb;
            Bundle bundle2 = zzzz.zzcmp;
            Bundle bundle3 = zzabf.zzcpa;
            hashMap.put("am", Integer.valueOf(zzabu.zzcrt));
            hashMap.put("cog", zzt(zzabu.zzcru));
            hashMap.put("coh", zzt(zzabu.zzcrv));
            if (!TextUtils.isEmpty(zzabu.zzcrw)) {
                hashMap.put("carrier", zzabu.zzcrw);
            }
            hashMap.put("gl", zzabu.zzcrx);
            if (zzabu.zzcry) {
                hashMap.put("simulator", 1);
            }
            if (zzabu.zzcrz) {
                hashMap.put("is_sidewinder", 1);
            }
            hashMap.put("ma", zzt(zzabu.zzcsa));
            hashMap.put("sp", zzt(zzabu.zzcsb));
            hashMap.put("hl", zzabu.zzcsc);
            if (!TextUtils.isEmpty(zzabu.zzcsd)) {
                hashMap.put("mv", zzabu.zzcsd);
            }
            hashMap.put("muv", Integer.valueOf(zzabu.zzcsf));
            if (zzabu.zzcsg != -2) {
                hashMap.put("cnt", Integer.valueOf(zzabu.zzcsg));
            }
            hashMap.put("gnt", Integer.valueOf(zzabu.zzcsh));
            hashMap.put("pt", Integer.valueOf(zzabu.zzcsi));
            hashMap.put("rm", Integer.valueOf(zzabu.zzcsj));
            hashMap.put("riv", Integer.valueOf(zzabu.zzcsk));
            Bundle bundle4 = new Bundle();
            bundle4.putString("build_build", zzabu.zzcsp);
            bundle4.putString("build_device", zzabu.zzcsq);
            Bundle bundle5 = new Bundle();
            bundle5.putBoolean("is_charging", zzabu.zzcsm);
            bundle5.putDouble("battery_level", zzabu.zzcsl);
            bundle4.putBundle("battery", bundle5);
            Bundle bundle6 = new Bundle();
            bundle6.putInt("active_network_state", zzabu.zzcso);
            bundle6.putBoolean("active_network_metered", zzabu.zzcsn);
            if (zzace != null) {
                Bundle bundle7 = new Bundle();
                bundle7.putInt("predicted_latency_micros", zzace.zzcsz);
                bundle7.putLong("predicted_down_throughput_bps", zzace.zzcta);
                bundle7.putLong("predicted_up_throughput_bps", zzace.zzctb);
                bundle6.putBundle("predictions", bundle7);
            }
            bundle4.putBundle("network", bundle6);
            Bundle bundle8 = new Bundle();
            bundle8.putBoolean("is_browser_custom_tabs_capable", zzabu.zzcsr);
            bundle4.putBundle("browser", bundle8);
            if (bundle2 != null) {
                Bundle bundle9 = new Bundle();
                bundle9.putString("runtime_free", Long.toString(bundle2.getLong("runtime_free_memory", -1)));
                bundle9.putString("runtime_max", Long.toString(bundle2.getLong("runtime_max_memory", -1)));
                bundle9.putString("runtime_total", Long.toString(bundle2.getLong("runtime_total_memory", -1)));
                bundle9.putString("web_view_count", Integer.toString(bundle2.getInt("web_view_count", 0)));
                Debug.MemoryInfo memoryInfo = (Debug.MemoryInfo) bundle2.getParcelable("debug_memory_info");
                if (memoryInfo != null) {
                    bundle9.putString("debug_info_dalvik_private_dirty", Integer.toString(memoryInfo.dalvikPrivateDirty));
                    bundle9.putString("debug_info_dalvik_pss", Integer.toString(memoryInfo.dalvikPss));
                    bundle9.putString("debug_info_dalvik_shared_dirty", Integer.toString(memoryInfo.dalvikSharedDirty));
                    bundle9.putString("debug_info_native_private_dirty", Integer.toString(memoryInfo.nativePrivateDirty));
                    bundle9.putString("debug_info_native_pss", Integer.toString(memoryInfo.nativePss));
                    bundle9.putString("debug_info_native_shared_dirty", Integer.toString(memoryInfo.nativeSharedDirty));
                    bundle9.putString("debug_info_other_private_dirty", Integer.toString(memoryInfo.otherPrivateDirty));
                    bundle9.putString("debug_info_other_pss", Integer.toString(memoryInfo.otherPss));
                    bundle9.putString("debug_info_other_shared_dirty", Integer.toString(memoryInfo.otherSharedDirty));
                }
                bundle4.putBundle("android_mem_info", bundle9);
            }
            Bundle bundle10 = new Bundle();
            bundle10.putBundle("parental_controls", bundle3);
            if (!TextUtils.isEmpty(zzabu.zzcse)) {
                bundle10.putString("package_version", zzabu.zzcse);
            }
            bundle4.putBundle("play_store", bundle10);
            hashMap.put("device", bundle4);
            Bundle bundle11 = new Bundle();
            bundle11.putString("doritos", zzabf.zzcpc);
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzbjt)).booleanValue()) {
                String str2 = null;
                boolean z4 = false;
                if (zzabf.zzcpd != null) {
                    str2 = zzabf.zzcpd.getId();
                    z4 = zzabf.zzcpd.isLimitAdTrackingEnabled();
                }
                if (!TextUtils.isEmpty(str2)) {
                    bundle11.putString("rdid", str2);
                    bundle11.putBoolean("is_lat", z4);
                    bundle11.putString("idtype", "adid");
                } else {
                    zzjk.zzhx();
                    bundle11.putString("pdid", zzais.zzbc(context));
                    bundle11.putString("pdidtype", "ssaid");
                }
            }
            hashMap.put("pii", bundle11);
            hashMap.put("platform", Build.MANUFACTURER);
            hashMap.put("submodel", Build.MODEL);
            if (location != null) {
                zza((HashMap<String, Object>) hashMap, location);
            } else if (zzzz.zzclo.versionCode >= 2 && zzzz.zzclo.zzbcd != null) {
                zza((HashMap<String, Object>) hashMap, zzzz.zzclo.zzbcd);
            }
            if (zzzz.versionCode >= 2) {
                hashMap.put("quality_signals", zzzz.zzclt);
            }
            if (zzzz.versionCode >= 4 && zzzz.zzclw) {
                hashMap.put("forceHttps", Boolean.valueOf(zzzz.zzclw));
            }
            if (bundle != null) {
                hashMap.put("content_info", bundle);
            }
            if (zzzz.versionCode >= 5) {
                hashMap.put("u_sd", Float.valueOf(zzzz.zzaxd));
                hashMap.put("sh", Integer.valueOf(zzzz.zzcly));
                hashMap.put("sw", Integer.valueOf(zzzz.zzclx));
            } else {
                hashMap.put("u_sd", Float.valueOf(zzabu.zzaxd));
                hashMap.put("sh", Integer.valueOf(zzabu.zzcly));
                hashMap.put("sw", Integer.valueOf(zzabu.zzclx));
            }
            if (zzzz.versionCode >= 6) {
                if (!TextUtils.isEmpty(zzzz.zzclz)) {
                    try {
                        hashMap.put("view_hierarchy", new JSONObject(zzzz.zzclz));
                    } catch (JSONException e2) {
                        zzafj.zzc("Problem serializing view hierarchy to JSON", e2);
                    }
                }
                hashMap.put("correlation_id", Long.valueOf(zzzz.zzcma));
            }
            if (zzzz.versionCode >= 7) {
                hashMap.put("request_id", zzzz.zzcmb);
            }
            if (zzzz.versionCode >= 12 && !TextUtils.isEmpty(zzzz.zzcmf)) {
                hashMap.put("anchor", zzzz.zzcmf);
            }
            if (zzzz.versionCode >= 13) {
                hashMap.put("android_app_volume", Float.valueOf(zzzz.zzcmg));
            }
            if (zzzz.versionCode >= 18) {
                hashMap.put("android_app_muted", Boolean.valueOf(zzzz.zzcmm));
            }
            if (zzzz.versionCode >= 14 && zzzz.zzcmh > 0) {
                hashMap.put("target_api", Integer.valueOf(zzzz.zzcmh));
            }
            if (zzzz.versionCode >= 15) {
                hashMap.put("scroll_index", Integer.valueOf(zzzz.zzcmi == -1 ? -1 : zzzz.zzcmi));
            }
            if (zzzz.versionCode >= 16) {
                hashMap.put("_activity_context", Boolean.valueOf(zzzz.zzcmj));
            }
            if (zzzz.versionCode >= 18) {
                if (!TextUtils.isEmpty(zzzz.zzcmn)) {
                    try {
                        hashMap.put("app_settings", new JSONObject(zzzz.zzcmn));
                    } catch (JSONException e3) {
                        zzafj.zzc("Problem creating json from app settings", e3);
                    }
                }
                hashMap.put("render_in_browser", Boolean.valueOf(zzzz.zzcbz));
            }
            if (zzzz.versionCode >= 18) {
                hashMap.put("android_num_video_cache_tasks", Integer.valueOf(zzzz.zzcmo));
            }
            zzaiy zzaiy = zzzz.zzatd;
            boolean z5 = zzzz.zzcna;
            boolean z6 = zzabf.zzcph;
            Bundle bundle12 = new Bundle();
            Bundle bundle13 = new Bundle();
            bundle13.putString("cl", "173624900");
            bundle13.putString("rapid_rc", "dev");
            bundle13.putString("rapid_rollup", "HEAD");
            bundle12.putBundle("build_meta", bundle13);
            bundle12.putString("mf", Boolean.toString(((Boolean) zzbs.zzep().zzd(zzmq.zzbmq)).booleanValue()));
            bundle12.putBoolean("instant_app", z5);
            bundle12.putBoolean("lite", zzaiy.zzdcc);
            bundle12.putBoolean("local_service", z6);
            hashMap.put("sdk_env", bundle12);
            hashMap.put("cache_state", jSONObject);
            if (zzzz.versionCode >= 19) {
                hashMap.put("gct", zzzz.zzcmq);
            }
            if (zzzz.versionCode >= 21 && zzzz.zzcmr) {
                hashMap.put("de", "1");
            }
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzbkg)).booleanValue()) {
                String str3 = zzzz.zzath.zzbda;
                boolean z7 = str3.equals("interstitial_mb") || str3.equals("reward_mb");
                Bundle bundle14 = zzzz.zzcms;
                boolean z8 = bundle14 != null;
                if (z7 && z8) {
                    Bundle bundle15 = new Bundle();
                    bundle15.putBundle("interstitial_pool", bundle14);
                    hashMap.put("counters", bundle15);
                }
            }
            if (zzzz.zzcmt != null) {
                hashMap.put("gmp_app_id", zzzz.zzcmt);
            }
            if (zzzz.zzcmu == null) {
                hashMap.put("fbs_aiid", "");
            } else if ("TIME_OUT".equals(zzzz.zzcmu)) {
                hashMap.put("sai_timeout", zzbs.zzep().zzd(zzmq.zzbjj));
            } else {
                hashMap.put("fbs_aiid", zzzz.zzcmu);
            }
            if (zzzz.zzcmv != null) {
                hashMap.put("fbs_aeid", zzzz.zzcmv);
            }
            if (zzzz.versionCode >= 24) {
                hashMap.put("disable_ml", Boolean.valueOf(zzzz.zzcnb));
            }
            String str4 = (String) zzbs.zzep().zzd(zzmq.zzbhh);
            if (str4 != null && !str4.isEmpty()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzbs.zzep().zzd(zzmq.zzbhi)).intValue()) {
                    HashMap hashMap2 = new HashMap();
                    for (String str5 : str4.split(",")) {
                        hashMap2.put(str5, zzaiq.zzck(str5));
                    }
                    hashMap.put("video_decoders", hashMap2);
                }
            }
            if (zzafj.zzae(2)) {
                String valueOf = String.valueOf(zzbs.zzec().zzp((Map<String, ?>) hashMap).toString(2));
                zzafj.m11v(valueOf.length() != 0 ? "Ad Request JSON: ".concat(valueOf) : new String("Ad Request JSON: "));
            }
            return zzbs.zzec().zzp((Map<String, ?>) hashMap);
        } catch (JSONException e4) {
            String valueOf2 = String.valueOf(e4.getMessage());
            zzafj.zzco(valueOf2.length() != 0 ? "Problem serializing ad request to JSON: ".concat(valueOf2) : new String("Problem serializing ad request to JSON: "));
            return null;
        }
    }

    private static void zza(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put(SchulteTableResult.FIELD_TIME, valueOf2);
        hashMap.put("uule", hashMap2);
    }

    public static JSONObject zzb(zzaad zzaad) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (zzaad.zzchl != null) {
            jSONObject.put("ad_base_url", zzaad.zzchl);
        }
        if (zzaad.zzcnj != null) {
            jSONObject.put("ad_size", zzaad.zzcnj);
        }
        jSONObject.put("native", zzaad.zzbdd);
        if (zzaad.zzbdd) {
            jSONObject.put("ad_json", zzaad.body);
        } else {
            jSONObject.put("ad_html", zzaad.body);
        }
        if (zzaad.zzcnl != null) {
            jSONObject.put("debug_dialog", zzaad.zzcnl);
        }
        if (zzaad.zzcoc != null) {
            jSONObject.put("debug_signals", zzaad.zzcoc);
        }
        if (zzaad.zzcnf != -1) {
            jSONObject.put("interstitial_timeout", ((double) zzaad.zzcnf) / 1000.0d);
        }
        if (zzaad.orientation == zzbs.zzee().zzqa()) {
            jSONObject.put("orientation", "portrait");
        } else if (zzaad.orientation == zzbs.zzee().zzpz()) {
            jSONObject.put("orientation", "landscape");
        }
        if (zzaad.zzcbv != null) {
            jSONObject.put("click_urls", zzo(zzaad.zzcbv));
        }
        if (zzaad.zzcbw != null) {
            jSONObject.put("impression_urls", zzo(zzaad.zzcbw));
        }
        if (zzaad.zzcni != null) {
            jSONObject.put("manual_impression_urls", zzo(zzaad.zzcni));
        }
        if (zzaad.zzcno != null) {
            jSONObject.put("active_view", zzaad.zzcno);
        }
        jSONObject.put("ad_is_javascript", zzaad.zzcnm);
        if (zzaad.zzcnn != null) {
            jSONObject.put("ad_passback_url", zzaad.zzcnn);
        }
        jSONObject.put("mediation", zzaad.zzcng);
        jSONObject.put("custom_render_allowed", zzaad.zzcnp);
        jSONObject.put("content_url_opted_out", zzaad.zzcnq);
        jSONObject.put("content_vertical_opted_out", zzaad.zzcod);
        jSONObject.put("prefetch", zzaad.zzcnr);
        if (zzaad.zzccb != -1) {
            jSONObject.put("refresh_interval_milliseconds", zzaad.zzccb);
        }
        if (zzaad.zzcnh != -1) {
            jSONObject.put("mediation_config_cache_time_milliseconds", zzaad.zzcnh);
        }
        if (!TextUtils.isEmpty(zzaad.zzcnu)) {
            jSONObject.put("gws_query_id", zzaad.zzcnu);
        }
        jSONObject.put("fluid", zzaad.zzbde ? "height" : "");
        jSONObject.put("native_express", zzaad.zzbdf);
        if (zzaad.zzcnw != null) {
            jSONObject.put("video_start_urls", zzo(zzaad.zzcnw));
        }
        if (zzaad.zzcnx != null) {
            jSONObject.put("video_complete_urls", zzo(zzaad.zzcnx));
        }
        if (zzaad.zzcnv != null) {
            zzadw zzadw = zzaad.zzcnv;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("rb_type", zzadw.type);
            jSONObject2.put("rb_amount", zzadw.zzcuk);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("rewards", jSONArray);
        }
        jSONObject.put("use_displayed_impression", zzaad.zzcny);
        jSONObject.put("auto_protection_configuration", zzaad.zzcnz);
        jSONObject.put("render_in_browser", zzaad.zzcbz);
        return jSONObject;
    }

    @Nullable
    private static JSONArray zzo(List<String> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    private static Integer zzt(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }
}
