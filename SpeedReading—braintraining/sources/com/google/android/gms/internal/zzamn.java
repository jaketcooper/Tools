package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.C0555R;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;
import org.json.JSONObject;

@zzzb
final class zzamn extends FrameLayout implements zzama {
    private static final int zzcgi = Color.argb(0, 0, 0, 0);
    private final zzama zzdjb;
    private final zzakz zzdjc;

    public zzamn(zzama zzama) {
        super(zzama.getContext());
        this.zzdjb = zzama;
        this.zzdjc = new zzakz(zzama.zzsl(), this, this);
        zzamb zzsq = this.zzdjb.zzsq();
        if (zzsq != null) {
            zzsq.zzbwq = this;
        }
        zzama zzama2 = this.zzdjb;
        if (zzama2 == null) {
            throw null;
        }
        addView((View) zzama2);
    }

    public final void destroy() {
        this.zzdjb.destroy();
    }

    public final View.OnClickListener getOnClickListener() {
        return this.zzdjb.getOnClickListener();
    }

    public final String getRequestId() {
        return this.zzdjb.getRequestId();
    }

    public final int getRequestedOrientation() {
        return this.zzdjb.getRequestedOrientation();
    }

    public final WebView getWebView() {
        return this.zzdjb.getWebView();
    }

    public final boolean isDestroyed() {
        return this.zzdjb.isDestroyed();
    }

    public final void loadData(String str, String str2, String str3) {
        this.zzdjb.loadData(str, str2, str3);
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zzdjb.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public final void loadUrl(String str) {
        this.zzdjb.loadUrl(str);
    }

    public final void onPause() {
        this.zzdjc.onPause();
        this.zzdjb.onPause();
    }

    public final void onResume() {
        this.zzdjb.onResume();
    }

    public final void setContext(Context context) {
        this.zzdjb.setContext(context);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzdjb.setOnClickListener(onClickListener);
    }

    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zzdjb.setOnTouchListener(onTouchListener);
    }

    public final void setRequestedOrientation(int i) {
        this.zzdjb.setRequestedOrientation(i);
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zzdjb.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zzdjb.setWebViewClient(webViewClient);
    }

    public final void stopLoading() {
        this.zzdjb.stopLoading();
    }

    public final void zza(zzc zzc) {
        this.zzdjb.zza(zzc);
    }

    public final void zza(zzamr zzamr) {
        this.zzdjb.zza(zzamr);
    }

    public final void zza(zzanp zzanp) {
        this.zzdjb.zza(zzanp);
    }

    public final void zza(zzgb zzgb) {
        this.zzdjb.zza(zzgb);
    }

    public final void zza(String str, zzt<? super zzama> zzt) {
        this.zzdjb.zza(str, zzt);
    }

    public final void zza(String str, Map<String, ?> map) {
        this.zzdjb.zza(str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        this.zzdjb.zza(str, jSONObject);
    }

    public final void zza(boolean z, int i) {
        this.zzdjb.zza(z, i);
    }

    public final void zza(boolean z, int i, String str) {
        this.zzdjb.zza(z, i, str);
    }

    public final void zza(boolean z, int i, String str, String str2) {
        this.zzdjb.zza(z, i, str, str2);
    }

    public final void zzab(boolean z) {
        this.zzdjb.zzab(z);
    }

    public final void zzac(boolean z) {
        this.zzdjb.zzac(z);
    }

    public final void zzad(boolean z) {
        this.zzdjb.zzad(z);
    }

    public final void zzae(boolean z) {
        this.zzdjb.zzae(z);
    }

    public final void zzaf(boolean z) {
        this.zzdjb.zzaf(z);
    }

    public final void zzag(int i) {
        this.zzdjb.zzag(i);
    }

    public final void zzb(zzd zzd) {
        this.zzdjb.zzb(zzd);
    }

    public final void zzb(@Nullable zzny zzny) {
        this.zzdjb.zzb(zzny);
    }

    public final void zzb(String str, zzt<? super zzama> zzt) {
        this.zzdjb.zzb(str, zzt);
    }

    public final void zzb(String str, JSONObject jSONObject) {
        this.zzdjb.zzb(str, jSONObject);
    }

    public final zzv zzbk() {
        return this.zzdjb.zzbk();
    }

    public final void zzc(zzd zzd) {
        this.zzdjb.zzc(zzd);
    }

    public final void zzck() {
        this.zzdjb.zzck();
    }

    public final void zzcl() {
        this.zzdjb.zzcl();
    }

    public final void zzct(String str) {
        this.zzdjb.zzct(str);
    }

    public final void zzcu(String str) {
        this.zzdjb.zzcu(str);
    }

    public final void zzmt() {
        this.zzdjb.zzmt();
    }

    public final void zzmu() {
        this.zzdjb.zzmu();
    }

    public final zzakz zzrw() {
        return this.zzdjc;
    }

    public final zzamr zzrx() {
        return this.zzdjb.zzrx();
    }

    public final zznb zzry() {
        return this.zzdjb.zzry();
    }

    public final Activity zzrz() {
        return this.zzdjb.zzrz();
    }

    public final zznc zzsa() {
        return this.zzdjb.zzsa();
    }

    public final zzaiy zzsb() {
        return this.zzdjb.zzsb();
    }

    public final int zzsc() {
        return getMeasuredHeight();
    }

    public final int zzsd() {
        return getMeasuredWidth();
    }

    public final void zzsj() {
        this.zzdjb.zzsj();
    }

    public final void zzsk() {
        this.zzdjb.zzsk();
    }

    public final Context zzsl() {
        return this.zzdjb.zzsl();
    }

    public final zzd zzsm() {
        return this.zzdjb.zzsm();
    }

    public final zzd zzsn() {
        return this.zzdjb.zzsn();
    }

    public final zzanp zzso() {
        return this.zzdjb.zzso();
    }

    public final String zzsp() {
        return this.zzdjb.zzsp();
    }

    public final zzamb zzsq() {
        return this.zzdjb.zzsq();
    }

    public final boolean zzsr() {
        return this.zzdjb.zzsr();
    }

    public final zzcs zzss() {
        return this.zzdjb.zzss();
    }

    public final boolean zzst() {
        return this.zzdjb.zzst();
    }

    public final void zzsu() {
        this.zzdjc.onDestroy();
        this.zzdjb.zzsu();
    }

    public final boolean zzsv() {
        return this.zzdjb.zzsv();
    }

    public final boolean zzsw() {
        return this.zzdjb.zzsw();
    }

    public final boolean zzsx() {
        return this.zzdjb.zzsx();
    }

    public final void zzsy() {
        this.zzdjb.zzsy();
    }

    public final void zzsz() {
        this.zzdjb.zzsz();
    }

    @Nullable
    public final zzny zzta() {
        return this.zzdjb.zzta();
    }

    public final void zztb() {
        setBackgroundColor(zzcgi);
        this.zzdjb.setBackgroundColor(zzcgi);
    }

    public final void zztc() {
        TextView textView = new TextView(getContext());
        Resources resources = zzbs.zzeg().getResources();
        textView.setText(resources != null ? resources.getString(C0555R.string.f83s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }
}
