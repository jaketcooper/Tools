package com.google.android.gms.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zzabr {
    private int mOrientation = -1;
    private zzaaf zzanw;
    private String zzbrz;
    private boolean zzccu = false;
    private final zzzz zzcdj;
    private List<String> zzciu;
    private String zzcqi;
    private String zzcqj;
    private List<String> zzcqk;
    private String zzcql;
    private String zzcqm;
    private String zzcqn;
    private List<String> zzcqo;
    private long zzcqp = -1;
    private boolean zzcqq = false;
    private final long zzcqr = -1;
    private long zzcqs = -1;
    private boolean zzcqt = false;
    private boolean zzcqu = false;
    private boolean zzcqv = false;
    private boolean zzcqw = true;
    private boolean zzcqx = true;
    private String zzcqy = "";
    private boolean zzcqz = false;
    private zzadw zzcra;
    private List<String> zzcrb;
    private List<String> zzcrc;
    private boolean zzcrd = false;
    private boolean zzcre = false;
    private String zzcrf;
    private List<String> zzcrg;
    private boolean zzcrh;
    private String zzcri;
    private zzaee zzcrj;
    private boolean zzcrk;
    private boolean zzcrl;

    public zzabr(zzzz zzzz, String str) {
        this.zzcqj = str;
        this.zzcdj = zzzz;
    }

    private static String zza(Map<String, List<String>> map, String str) {
        List list = map.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (String) list.get(0);
    }

    private static long zzb(Map<String, List<String>> map, String str) {
        List list = map.get(str);
        if (list != null && !list.isEmpty()) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                zzafj.zzco(new StringBuilder(String.valueOf(str).length() + 36 + String.valueOf(str2).length()).append("Could not parse float from ").append(str).append(" header: ").append(str2).toString());
            }
        }
        return -1;
    }

    private static List<String> zzc(Map<String, List<String>> map, String str) {
        String str2;
        List list = map.get(str);
        if (list == null || list.isEmpty() || (str2 = (String) list.get(0)) == null) {
            return null;
        }
        return Arrays.asList(str2.trim().split("\\s+"));
    }

    private static boolean zzd(Map<String, List<String>> map, String str) {
        List list = map.get(str);
        if (list == null || list.isEmpty()) {
            return false;
        }
        return Boolean.valueOf((String) list.get(0)).booleanValue();
    }

    public final zzaad zza(long j, boolean z) {
        return new zzaad(this.zzcdj, this.zzcqj, this.zzbrz, this.zzcqk, this.zzcqo, this.zzcqp, this.zzcqq, -1, this.zzciu, this.zzcqs, this.mOrientation, this.zzcqi, j, this.zzcqm, this.zzcqn, this.zzcqt, this.zzcqu, this.zzcqv, this.zzcqw, false, this.zzcqy, this.zzcqz, this.zzccu, this.zzcra, this.zzcrb, this.zzcrc, this.zzcrd, this.zzanw, this.zzcre, this.zzcrf, this.zzcrg, this.zzcrh, this.zzcri, this.zzcrj, this.zzcql, this.zzcqx, this.zzcrk, this.zzcrl, z ? 2 : 1);
    }

    public final void zza(String str, Map<String, List<String>> map, String str2) {
        this.zzbrz = str2;
        zzn(map);
    }

    public final void zzn(Map<String, List<String>> map) {
        this.zzcqi = zza(map, "X-Afma-Ad-Size");
        this.zzcri = zza(map, "X-Afma-Ad-Slot-Size");
        List<String> zzc = zzc(map, "X-Afma-Click-Tracking-Urls");
        if (zzc != null) {
            this.zzcqk = zzc;
        }
        this.zzcql = zza(map, "X-Afma-Debug-Signals");
        List list = map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.zzcqm = (String) list.get(0);
        }
        List<String> zzc2 = zzc(map, "X-Afma-Tracking-Urls");
        if (zzc2 != null) {
            this.zzcqo = zzc2;
        }
        long zzb = zzb(map, "X-Afma-Interstitial-Timeout");
        if (zzb != -1) {
            this.zzcqp = zzb;
        }
        this.zzcqq |= zzd(map, "X-Afma-Mediation");
        List<String> zzc3 = zzc(map, "X-Afma-Manual-Tracking-Urls");
        if (zzc3 != null) {
            this.zzciu = zzc3;
        }
        long zzb2 = zzb(map, "X-Afma-Refresh-Rate");
        if (zzb2 != -1) {
            this.zzcqs = zzb2;
        }
        List list2 = map.get("X-Afma-Orientation");
        if (list2 != null && !list2.isEmpty()) {
            String str = (String) list2.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.mOrientation = zzbs.zzee().zzqa();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.mOrientation = zzbs.zzee().zzpz();
            }
        }
        this.zzcqn = zza(map, "X-Afma-ActiveView");
        List list3 = map.get("X-Afma-Use-HTTPS");
        if (list3 != null && !list3.isEmpty()) {
            this.zzcqv = Boolean.valueOf((String) list3.get(0)).booleanValue();
        }
        this.zzcqt |= zzd(map, "X-Afma-Custom-Rendering-Allowed");
        this.zzcqu = "native".equals(zza(map, "X-Afma-Ad-Format"));
        List list4 = map.get("X-Afma-Content-Url-Opted-Out");
        if (list4 != null && !list4.isEmpty()) {
            this.zzcqw = Boolean.valueOf((String) list4.get(0)).booleanValue();
        }
        List list5 = map.get("X-Afma-Content-Vertical-Opted-Out");
        if (list5 != null && !list5.isEmpty()) {
            this.zzcqx = Boolean.valueOf((String) list5.get(0)).booleanValue();
        }
        List list6 = map.get("X-Afma-Gws-Query-Id");
        if (list6 != null && !list6.isEmpty()) {
            this.zzcqy = (String) list6.get(0);
        }
        String zza = zza(map, "X-Afma-Fluid");
        if (zza != null && zza.equals("height")) {
            this.zzcqz = true;
        }
        this.zzccu = "native_express".equals(zza(map, "X-Afma-Ad-Format"));
        this.zzcra = zzadw.zzbt(zza(map, "X-Afma-Rewards"));
        if (this.zzcrb == null) {
            this.zzcrb = zzc(map, "X-Afma-Reward-Video-Start-Urls");
        }
        if (this.zzcrc == null) {
            this.zzcrc = zzc(map, "X-Afma-Reward-Video-Complete-Urls");
        }
        this.zzcrd |= zzd(map, "X-Afma-Use-Displayed-Impression");
        this.zzcre |= zzd(map, "X-Afma-Auto-Collect-Location");
        this.zzcrf = zza(map, "Set-Cookie");
        String zza2 = zza(map, "X-Afma-Auto-Protection-Configuration");
        if (zza2 == null || TextUtils.isEmpty(zza2)) {
            Uri.Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204").buildUpon();
            buildUpon.appendQueryParameter(IdentityRealmObject.FIELD_ID, "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(this.zzcqm)) {
                buildUpon.appendQueryParameter("debugDialog", this.zzcqm);
            }
            boolean booleanValue = ((Boolean) zzbs.zzep().zzd(zzmq.zzbgg)).booleanValue();
            String builder = buildUpon.toString();
            this.zzanw = new zzaaf(booleanValue, Arrays.asList(new String[]{new StringBuilder(String.valueOf(builder).length() + 18 + String.valueOf("navigationURL").length()).append(builder).append("&").append("navigationURL").append("={NAVIGATION_URL}").toString()}));
        } else {
            try {
                this.zzanw = zzaaf.zzl(new JSONObject(zza2));
            } catch (JSONException e) {
                zzafj.zzc("Error parsing configuration JSON", e);
                this.zzanw = new zzaaf();
            }
        }
        List<String> zzc4 = zzc(map, "X-Afma-Remote-Ping-Urls");
        if (zzc4 != null) {
            this.zzcrg = zzc4;
        }
        String zza3 = zza(map, "X-Afma-Safe-Browsing");
        if (!TextUtils.isEmpty(zza3)) {
            try {
                this.zzcrj = zzaee.zzo(new JSONObject(zza3));
            } catch (JSONException e2) {
                zzafj.zzc("Error parsing safe browsing header", e2);
            }
        }
        this.zzcrh |= zzd(map, "X-Afma-Render-In-Browser");
        String zza4 = zza(map, "X-Afma-Pool");
        if (!TextUtils.isEmpty(zza4)) {
            try {
                this.zzcrk = new JSONObject(zza4).getBoolean("never_pool");
            } catch (JSONException e3) {
                zzafj.zzc("Error parsing interstitial pool header", e3);
            }
        }
        this.zzcrl = zzd(map, "X-Afma-Custom-Close-Blocked");
    }
}
