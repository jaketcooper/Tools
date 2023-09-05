package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.api.Releasable;
import java.lang.ref.WeakReference;
import java.util.Map;

@zzzb
public abstract class zzalt implements Releasable {
    protected Context mContext;
    private String zzcxh;
    private WeakReference<zzali> zzdhn;

    public zzalt(zzali zzali) {
        this.mContext = zzali.getContext();
        this.zzcxh = zzbs.zzec().zzp(this.mContext, zzali.zzsb().zzcp);
        this.zzdhn = new WeakReference<>(zzali);
    }

    /* access modifiers changed from: private */
    public final void zza(String str, Map<String, String> map) {
        zzali zzali = (zzali) this.zzdhn.get();
        if (zzali != null) {
            zzali.zza(str, map);
        }
    }

    /* access modifiers changed from: private */
    public static String zzcs(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1396664534:
                if (str.equals("badUrl")) {
                    c = 6;
                    break;
                }
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    c = 2;
                    break;
                }
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    c = 7;
                    break;
                }
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    c = 3;
                    break;
                }
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    c = 1;
                    break;
                }
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    c = 8;
                    break;
                }
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    c = 9;
                    break;
                }
                break;
            case 96784904:
                if (str.equals("error")) {
                    c = 0;
                    break;
                }
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    c = 5;
                    break;
                }
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
                return "internal";
            case 4:
            case 5:
                return "io";
            case 6:
            case 7:
                return "network";
            case 8:
            case 9:
                return "policy";
            default:
                return "internal";
        }
    }

    public abstract void abort();

    public void release() {
    }

    /* access modifiers changed from: protected */
    public final void zza(String str, String str2, int i) {
        zzais.zzdbs.post(new zzalv(this, str, str2, i));
    }

    public final void zza(String str, String str2, String str3, @Nullable String str4) {
        zzais.zzdbs.post(new zzalw(this, str, str2, str3, str4));
    }

    public abstract boolean zzcr(String str);
}
