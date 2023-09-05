package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.C0555R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbf;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzca;

@Deprecated
public final class zzcc {
    private static final Object sLock = new Object();
    private static zzcc zzfro;
    private final String mAppId;
    private final Status zzfrp;
    private final boolean zzfrq;
    private final boolean zzfrr;

    private zzcc(Context context) {
        boolean z = true;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(C0555R.string.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            boolean z2 = resources.getInteger(identifier) != 0;
            this.zzfrr = z2 ? false : z;
            z = z2;
        } else {
            this.zzfrr = false;
        }
        this.zzfrq = z;
        String zzcm = zzbf.zzcm(context);
        zzcm = zzcm == null ? new zzca(context).getString("google_app_id") : zzcm;
        if (TextUtils.isEmpty(zzcm)) {
            this.zzfrp = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.mAppId = null;
            return;
        }
        this.mAppId = zzcm;
        this.zzfrp = Status.zzfky;
    }

    public static String zzaiw() {
        return zzfv("getGoogleAppId").mAppId;
    }

    public static boolean zzaix() {
        return zzfv("isMeasurementExplicitlyDisabled").zzfrr;
    }

    public static Status zzci(Context context) {
        Status status;
        zzbq.checkNotNull(context, "Context must not be null.");
        synchronized (sLock) {
            if (zzfro == null) {
                zzfro = new zzcc(context);
            }
            status = zzfro.zzfrp;
        }
        return status;
    }

    private static zzcc zzfv(String str) {
        zzcc zzcc;
        synchronized (sLock) {
            if (zzfro == null) {
                throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 34).append("Initialize must be called before ").append(str).append(".").toString());
            }
            zzcc = zzfro;
        }
        return zzcc;
    }
}
