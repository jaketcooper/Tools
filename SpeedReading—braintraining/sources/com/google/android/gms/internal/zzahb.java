package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.net.http.SslError;
import android.webkit.WebChromeClient;

@TargetApi(14)
public class zzahb extends zzagz {
    public final String zza(SslError sslError) {
        return sslError.getUrl();
    }

    public final WebChromeClient zzj(zzama zzama) {
        return new zzang(zzama);
    }

    public int zzqe() {
        return 1;
    }
}
