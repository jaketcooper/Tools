package com.google.android.gms.ads.internal.gmsg;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zzzb;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;

@zzzb
public final class zzc implements zzt<zzama> {
    public final /* synthetic */ void zza(Object obj, Map map) {
        zzama zzama = (zzama) obj;
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            String str2 = (String) map.get("label");
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get(AppMeasurement.Param.TIMESTAMP);
            if (TextUtils.isEmpty(str2)) {
                zzafj.zzco("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str4)) {
                zzafj.zzco("No timestamp given for CSI tick.");
            } else {
                try {
                    long parseLong = (Long.parseLong(str4) - zzbs.zzei().currentTimeMillis()) + zzbs.zzei().elapsedRealtime();
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "native:view_load";
                    }
                    zzama.zzsa().zza(str2, str3, parseLong);
                } catch (NumberFormatException e) {
                    zzafj.zzc("Malformed timestamp for CSI tick.", e);
                }
            }
        } else if ("experiment".equals(str)) {
            String str5 = (String) map.get(FirebaseAnalytics.Param.VALUE);
            if (TextUtils.isEmpty(str5)) {
                zzafj.zzco("No value given for CSI experiment.");
                return;
            }
            zznd zziy = zzama.zzsa().zziy();
            if (zziy == null) {
                zzafj.zzco("No ticker for WebView, dropping experiment ID.");
            } else {
                zziy.zzf("e", str5);
            }
        } else if ("extra".equals(str)) {
            String str6 = (String) map.get("name");
            String str7 = (String) map.get(FirebaseAnalytics.Param.VALUE);
            if (TextUtils.isEmpty(str7)) {
                zzafj.zzco("No value given for CSI extra.");
            } else if (TextUtils.isEmpty(str6)) {
                zzafj.zzco("No name given for CSI extra.");
            } else {
                zznd zziy2 = zzama.zzsa().zziy();
                if (zziy2 == null) {
                    zzafj.zzco("No ticker for WebView, dropping extra parameter.");
                } else {
                    zziy2.zzf(str6, str7);
                }
            }
        }
    }
}
