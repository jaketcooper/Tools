package com.google.android.gms.internal;

import android.webkit.ValueCallback;
import android.webkit.WebView;

final class zzgv implements Runnable {
    final /* synthetic */ zzgt zzayv;
    private ValueCallback<String> zzayw = new zzgw(this);
    final /* synthetic */ zzgn zzayx;
    final /* synthetic */ WebView zzayy;
    final /* synthetic */ boolean zzayz;

    zzgv(zzgt zzgt, zzgn zzgn, WebView webView, boolean z) {
        this.zzayv = zzgt;
        this.zzayx = zzgn;
        this.zzayy = webView;
        this.zzayz = z;
    }

    public final void run() {
        if (this.zzayy.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzayy.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzayw);
            } catch (Throwable th) {
                this.zzayw.onReceiveValue("");
            }
        }
    }
}
