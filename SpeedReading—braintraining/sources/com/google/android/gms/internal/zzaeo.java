package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;

@zzzb
public final class zzaeo {
    public static String zzb(String str, Context context) {
        String zzz;
        if (!zzbs.zzfa().zzr(context) || TextUtils.isEmpty(str) || (zzz = zzbs.zzfa().zzz(context)) == null) {
            return str;
        }
        if (((Boolean) zzbs.zzep().zzd(zzmq.zzbjh)).booleanValue()) {
            String str2 = (String) zzbs.zzep().zzd(zzmq.zzbji);
            if (!str.contains(str2)) {
                return str;
            }
            if (zzbs.zzec().zzcf(str)) {
                zzbs.zzfa().zze(context, zzz);
                return str.replace(str2, zzz);
            } else if (!zzbs.zzec().zzcg(str)) {
                return str;
            } else {
                zzbs.zzfa().zzf(context, zzz);
                return str.replace(str2, zzz);
            }
        } else if (str.contains("fbs_aeid")) {
            return str;
        } else {
            if (zzbs.zzec().zzcf(str)) {
                zzbs.zzfa().zze(context, zzz);
                zzbs.zzec();
                return zzagr.zzb(str, "fbs_aeid", zzz).toString();
            } else if (!zzbs.zzec().zzcg(str)) {
                return str;
            } else {
                zzbs.zzfa().zzf(context, zzz);
                zzbs.zzec();
                return zzagr.zzb(str, "fbs_aeid", zzz).toString();
            }
        }
    }
}
