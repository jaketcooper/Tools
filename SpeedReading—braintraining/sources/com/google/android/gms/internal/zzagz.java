package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import java.util.Set;

@TargetApi(11)
public class zzagz extends zzagy {
    public final boolean zza(DownloadManager.Request request) {
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        return true;
    }

    public boolean zza(Context context, WebSettings webSettings) {
        super.zza(context, webSettings);
        return ((Boolean) zzain.zza(context, new zzaha(this, context, webSettings))).booleanValue();
    }

    public final boolean zza(Window window) {
        window.setFlags(16777216, 16777216);
        return true;
    }

    public zzamb zzb(zzama zzama, boolean z) {
        return new zzanf(zzama, z);
    }

    public final Set<String> zzg(Uri uri) {
        return uri.getQueryParameterNames();
    }

    public WebChromeClient zzj(zzama zzama) {
        return new zzamx(zzama);
    }

    public final boolean zzs(View view) {
        view.setLayerType(0, (Paint) null);
        return true;
    }

    public final boolean zzt(View view) {
        view.setLayerType(1, (Paint) null);
        return true;
    }
}
