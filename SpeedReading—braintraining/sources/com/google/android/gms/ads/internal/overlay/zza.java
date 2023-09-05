package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzagr;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzzb;

@zzzb
public final class zza {
    private static boolean zza(Context context, Intent intent, zzq zzq) {
        try {
            String valueOf = String.valueOf(intent.toURI());
            zzafj.m11v(valueOf.length() != 0 ? "Launching an intent: ".concat(valueOf) : new String("Launching an intent: "));
            zzbs.zzec();
            zzagr.zza(context, intent);
            if (zzq != null) {
                zzq.zzbn();
            }
            return true;
        } catch (ActivityNotFoundException e) {
            zzafj.zzco(e.getMessage());
            return false;
        }
    }

    public static boolean zza(Context context, zzc zzc, zzq zzq) {
        int i;
        if (zzc == null) {
            zzafj.zzco("No intent data for launcher overlay.");
            return false;
        }
        zzmq.initialize(context);
        if (zzc.intent != null) {
            return zza(context, zzc.intent, zzq);
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(zzc.url)) {
            zzafj.zzco("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(zzc.mimeType)) {
            intent.setDataAndType(Uri.parse(zzc.url), zzc.mimeType);
        } else {
            intent.setData(Uri.parse(zzc.url));
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzc.packageName)) {
            intent.setPackage(zzc.packageName);
        }
        if (!TextUtils.isEmpty(zzc.zzcgf)) {
            String[] split = zzc.zzcgf.split("/", 2);
            if (split.length < 2) {
                String valueOf = String.valueOf(zzc.zzcgf);
                zzafj.zzco(valueOf.length() != 0 ? "Could not parse component name from open GMSG: ".concat(valueOf) : new String("Could not parse component name from open GMSG: "));
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        String str = zzc.zzcgg;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                zzafj.zzco("Could not parse intent flags.");
                i = 0;
            }
            intent.addFlags(i);
        }
        if (((Boolean) zzbs.zzep().zzd(zzmq.zzboy)).booleanValue()) {
            intent.addFlags(268435456);
            intent.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzbox)).booleanValue()) {
                zzbs.zzec();
                zzagr.zzb(context, intent);
            }
        }
        return zza(context, intent, zzq);
    }
}
