package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.internal.zzw;

@zzzb
@TargetApi(11)
public class zzamx extends WebChromeClient {
    private final zzama zzbwq;

    public zzamx(zzama zzama) {
        this.zzbwq = zzama;
    }

    private static Context zza(WebView webView) {
        if (!(webView instanceof zzama)) {
            return webView.getContext();
        }
        zzama zzama = (zzama) webView;
        Activity zzrz = zzama.zzrz();
        return zzrz == null ? zzama.getContext() : zzrz;
    }

    private final boolean zza(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        zzw zztd;
        try {
            if (this.zzbwq == null || this.zzbwq.zzsq() == null || this.zzbwq.zzsq().zztd() == null || (zztd = this.zzbwq.zzsq().zztd()) == null || zztd.zzcu()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(str2);
                if (z) {
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setOrientation(1);
                    TextView textView = new TextView(context);
                    textView.setText(str3);
                    EditText editText = new EditText(context);
                    editText.setText(str4);
                    linearLayout.addView(textView);
                    linearLayout.addView(editText);
                    builder.setView(linearLayout).setPositiveButton(17039370, new zzand(jsPromptResult, editText)).setNegativeButton(17039360, new zzanc(jsPromptResult)).setOnCancelListener(new zzanb(jsPromptResult)).create().show();
                    return true;
                }
                builder.setMessage(str3).setPositiveButton(17039370, new zzana(jsResult)).setNegativeButton(17039360, new zzamz(jsResult)).setOnCancelListener(new zzamy(jsResult)).create().show();
                return true;
            }
            zztd.zzs(new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(str3).length()).append("window.").append(str).append("('").append(str3).append("')").toString());
            return false;
        } catch (WindowManager.BadTokenException e) {
            zzafj.zzc("Fail to display Dialog.", e);
            return true;
        }
    }

    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzama)) {
            zzafj.zzco("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        zzd zzsm = ((zzama) webView).zzsm();
        if (zzsm == null) {
            zzafj.zzco("Tried to close an AdWebView not associated with an overlay.");
        } else {
            zzsm.close();
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        String sourceId = consoleMessage.sourceId();
        String sb = new StringBuilder(String.valueOf(message).length() + 19 + String.valueOf(sourceId).length()).append("JS: ").append(message).append(" (").append(sourceId).append(":").append(consoleMessage.lineNumber()).append(")").toString();
        if (sb.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (zzane.zzdkt[consoleMessage.messageLevel().ordinal()]) {
            case 1:
                zzafj.m12e(sb);
                break;
            case 2:
                zzafj.zzco(sb);
                break;
            case 3:
            case 4:
                zzafj.zzcn(sb);
                break;
            case 5:
                zzafj.zzbw(sb);
                break;
            default:
                zzafj.zzcn(sb);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView webView2 = new WebView(webView.getContext());
        webView2.setWebViewClient(this.zzbwq.zzsq());
        ((WebView.WebViewTransport) message.obj).setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j != 0) {
            if (j2 == 0) {
                j = Math.min(Math.min(PlaybackStateCompat.ACTION_PREPARE_FROM_URI, j4) + j, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            } else if (j2 <= Math.min(PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED - j, j4)) {
                j += j2;
            }
            j2 = j;
        } else if (j2 > j4 || j2 > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            j2 = 0;
        }
        quotaUpdater.updateQuota(j2);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        boolean z;
        if (callback != null) {
            zzbs.zzec();
            if (!zzagr.zzd(this.zzbwq.getContext(), this.zzbwq.getContext().getPackageName(), "android.permission.ACCESS_FINE_LOCATION")) {
                zzbs.zzec();
                if (!zzagr.zzd(this.zzbwq.getContext(), this.zzbwq.getContext().getPackageName(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z = false;
                    callback.invoke(str, z, true);
                }
            }
            z = true;
            callback.invoke(str, z, true);
        }
    }

    public final void onHideCustomView() {
        zzd zzsm = this.zzbwq.zzsm();
        if (zzsm == null) {
            zzafj.zzco("Could not get ad overlay when hiding custom view.");
        } else {
            zzsm.zzmm();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "alert", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "onBeforeUnload", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "confirm", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zza(webView), "prompt", str, str2, str3, (JsResult) null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        long j3 = PlaybackStateCompat.ACTION_PREPARE_FROM_URI + j;
        if (5242880 - j2 < j3) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j3);
        }
    }

    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        zza(view, -1, customViewCallback);
    }

    /* access modifiers changed from: protected */
    public final void zza(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        zzd zzsm = this.zzbwq.zzsm();
        if (zzsm == null) {
            zzafj.zzco("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        zzsm.zza(view, customViewCallback);
        zzsm.setRequestedOrientation(i);
    }
}
