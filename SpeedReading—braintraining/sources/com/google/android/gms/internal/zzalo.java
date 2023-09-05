package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.zzbs;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@zzzb
public final class zzalo implements zzt<zzali> {
    private boolean zzdhi;

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            zzjk.zzhx();
            return zzais.zzc(context, Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            zzafj.zzco(new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str2).length()).append("Could not parse ").append(str).append(" in a video GMSG: ").append(str2).toString());
            return i;
        }
    }

    private static void zza(zzakw zzakw, Map<String, String> map) {
        String str = map.get("minBufferMs");
        String str2 = map.get("maxBufferMs");
        String str3 = map.get("bufferForPlaybackMs");
        String str4 = map.get("bufferForPlaybackAfterRebufferMs");
        if (str != null) {
            try {
                Integer.parseInt(str);
            } catch (NumberFormatException e) {
                zzafj.zzco(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", new Object[]{str, str2}));
                return;
            }
        }
        if (str2 != null) {
            Integer.parseInt(str2);
        }
        if (str3 != null) {
            Integer.parseInt(str3);
        }
        if (str4 != null) {
            Integer.parseInt(str4);
        }
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        int i;
        int i2;
        zzali zzali = (zzali) obj;
        String str = (String) map.get("action");
        if (str == null) {
            zzafj.zzco("Action missing from video GMSG.");
            return;
        }
        if (zzafj.zzae(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String jSONObject2 = jSONObject.toString();
            zzafj.zzbw(new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(jSONObject2).length()).append("Video GMSG: ").append(str).append(" ").append(jSONObject2).toString());
        }
        if ("background".equals(str)) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzafj.zzco("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                zzali.setBackgroundColor(Color.parseColor(str2));
            } catch (IllegalArgumentException e) {
                zzafj.zzco("Invalid color parameter in video GMSG.");
            }
        } else if ("decoderProps".equals(str)) {
            String str3 = (String) map.get("mimeTypes");
            if (str3 == null) {
                zzafj.zzco("No MIME types specified for decoder properties inspection.");
                zzakw.zza(zzali, "missingMimeTypes");
            } else if (Build.VERSION.SDK_INT < 16) {
                zzafj.zzco("Video decoder properties available on API versions >= 16.");
                zzakw.zza(zzali, "deficientApiVersion");
            } else {
                HashMap hashMap = new HashMap();
                for (String str4 : str3.split(",")) {
                    hashMap.put(str4, zzaiq.zzck(str4.trim()));
                }
                zzakw.zza(zzali, (Map<String, List<Map<String, Object>>>) hashMap);
            }
        } else {
            zzakz zzrw = zzali.zzrw();
            if (zzrw == null) {
                zzafj.zzco("Could not get underlay container for a video GMSG.");
                return;
            }
            boolean equals = "new".equals(str);
            boolean equals2 = "position".equals(str);
            if (equals || equals2) {
                Context context = zzali.getContext();
                int zza = zza(context, map, "x", 0);
                int zza2 = zza(context, map, "y", 0);
                int zza3 = zza(context, map, "w", -1);
                int zza4 = zza(context, map, "h", -1);
                if (((Boolean) zzbs.zzep().zzd(zzmq.zzbnc)).booleanValue()) {
                    i = Math.min(zza3, zzali.zzsd() - zza);
                    zza4 = Math.min(zza4, zzali.zzsc() - zza2);
                } else {
                    i = zza3;
                }
                try {
                    i2 = Integer.parseInt((String) map.get("player"));
                } catch (NumberFormatException e2) {
                    i2 = 0;
                }
                boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
                if (!equals || zzrw.zzrr() != null) {
                    zzrw.zze(zza, zza2, i, zza4);
                    return;
                }
                zzrw.zza(zza, zza2, i, zza4, i2, parseBoolean, new zzalh((String) map.get("flags")));
                zzakw zzrr = zzrw.zzrr();
                if (zzrr != null) {
                    zza(zzrr, (Map<String, String>) map);
                    return;
                }
                return;
            }
            zzakw zzrr2 = zzrw.zzrr();
            if (zzrr2 == null) {
                zzakw.zza(zzali);
            } else if ("click".equals(str)) {
                Context context2 = zzali.getContext();
                int zza5 = zza(context2, map, "x", 0);
                int zza6 = zza(context2, map, "y", 0);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) zza5, (float) zza6, 0);
                zzrr2.zzf(obtain);
                obtain.recycle();
            } else if ("currentTime".equals(str)) {
                String str5 = (String) map.get(SchulteTableResult.FIELD_TIME);
                if (str5 == null) {
                    zzafj.zzco("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    zzrr2.seekTo((int) (Float.parseFloat(str5) * 1000.0f));
                } catch (NumberFormatException e3) {
                    String valueOf = String.valueOf(str5);
                    zzafj.zzco(valueOf.length() != 0 ? "Could not parse time parameter from currentTime video GMSG: ".concat(valueOf) : new String("Could not parse time parameter from currentTime video GMSG: "));
                }
            } else if ("hide".equals(str)) {
                zzrr2.setVisibility(4);
            } else if ("load".equals(str)) {
                zzrr2.zzrk();
            } else if ("loadControl".equals(str)) {
                zza(zzrr2, (Map<String, String>) map);
            } else if ("muted".equals(str)) {
                if (Boolean.parseBoolean((String) map.get("muted"))) {
                    zzrr2.zzrl();
                } else {
                    zzrr2.zzrm();
                }
            } else if ("pause".equals(str)) {
                zzrr2.pause();
            } else if ("play".equals(str)) {
                zzrr2.play();
            } else if ("show".equals(str)) {
                zzrr2.setVisibility(0);
            } else if ("src".equals(str)) {
                zzrr2.zzcp((String) map.get("src"));
            } else if ("touchMove".equals(str)) {
                Context context3 = zzali.getContext();
                zzrr2.zza((float) zza(context3, map, "dx", 0), (float) zza(context3, map, "dy", 0));
                if (!this.zzdhi) {
                    zzali.zzmu();
                    this.zzdhi = true;
                }
            } else if ("volume".equals(str)) {
                String str6 = (String) map.get("volume");
                if (str6 == null) {
                    zzafj.zzco("Level parameter missing from volume video GMSG.");
                    return;
                }
                try {
                    zzrr2.zzb(Float.parseFloat(str6));
                } catch (NumberFormatException e4) {
                    String valueOf2 = String.valueOf(str6);
                    zzafj.zzco(valueOf2.length() != 0 ? "Could not parse volume parameter from volume video GMSG: ".concat(valueOf2) : new String("Could not parse volume parameter from volume video GMSG: "));
                }
            } else if ("watermark".equals(str)) {
                zzrr2.zzrn();
            } else {
                String valueOf3 = String.valueOf(str);
                zzafj.zzco(valueOf3.length() != 0 ? "Unknown video action: ".concat(valueOf3) : new String("Unknown video action: "));
            }
        }
    }
}
