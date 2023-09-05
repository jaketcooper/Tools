package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.Nullable;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.zzbs;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzzb
@TargetApi(11)
public class zzanh extends zzamb {
    public zzanh(zzama zzama, boolean z) {
        super(zzama, z);
    }

    /* access modifiers changed from: protected */
    public final WebResourceResponse zza(WebView webView, String str, @Nullable Map<String, String> map) {
        if (!(webView instanceof zzama)) {
            zzafj.zzco("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzama zzama = (zzama) webView;
        if (this.zzanv != null) {
            this.zzanv.zza(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            return super.shouldInterceptRequest(webView, str);
        }
        if (zzama.zzsq() != null) {
            zzama.zzsq().zzmp();
        }
        String str2 = zzama.zzso().zztx() ? (String) zzbs.zzep().zzd(zzmq.zzbhw) : zzama.zzst() ? (String) zzbs.zzep().zzd(zzmq.zzbhv) : (String) zzbs.zzep().zzd(zzmq.zzbhu);
        try {
            Context context = zzama.getContext();
            String str3 = zzama.zzsb().zzcp;
            HashMap hashMap = new HashMap();
            hashMap.put("User-Agent", zzbs.zzec().zzp(context, str3));
            hashMap.put("Cache-Control", "max-stale=3600");
            String str4 = (String) new zzahy(context).zzb(str2, hashMap).get(60, TimeUnit.SECONDS);
            if (str4 == null) {
                return null;
            }
            return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str4.getBytes("UTF-8")));
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzafj.zzco(valueOf.length() != 0 ? "Could not fetch MRAID JS. ".concat(valueOf) : new String("Could not fetch MRAID JS. "));
            return null;
        }
    }
}
