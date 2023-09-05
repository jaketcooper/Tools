package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.p004js.zza;
import com.google.android.gms.ads.internal.zzbl;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;
import org.json.JSONObject;

@zzzb
public interface zzama extends zza, zzbl, zzali, zzamv, zzamw, zzanj, zzanl, zzanm, zzann, zzgc {
    void destroy();

    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    @Nullable
    View.OnClickListener getOnClickListener();

    ViewParent getParent();

    String getRequestId();

    int getRequestedOrientation();

    WebView getWebView();

    int getWidth();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, @Nullable String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    void setBackgroundColor(int i);

    void setContext(Context context);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void stopLoading();

    void zza(zzamr zzamr);

    void zza(zzanp zzanp);

    void zza(String str, zzt<? super zzama> zzt);

    void zza(String str, Map<String, ?> map);

    void zza(String str, JSONObject jSONObject);

    void zzac(boolean z);

    void zzad(boolean z);

    void zzae(boolean z);

    void zzaf(boolean z);

    void zzag(int i);

    void zzb(zzd zzd);

    void zzb(zzny zzny);

    void zzb(String str, zzt<? super zzama> zzt);

    void zzb(String str, JSONObject jSONObject);

    zzv zzbk();

    void zzc(zzd zzd);

    void zzct(String str);

    void zzcu(String str);

    void zzmt();

    @Nullable
    zzamr zzrx();

    @Nullable
    zznb zzry();

    Activity zzrz();

    zznc zzsa();

    zzaiy zzsb();

    void zzsj();

    void zzsk();

    Context zzsl();

    zzd zzsm();

    zzd zzsn();

    zzanp zzso();

    String zzsp();

    @Nullable
    zzamb zzsq();

    boolean zzsr();

    zzcs zzss();

    boolean zzst();

    void zzsu();

    boolean zzsv();

    boolean zzsw();

    boolean zzsx();

    void zzsy();

    void zzsz();

    zzny zzta();

    void zztb();

    void zztc();
}
