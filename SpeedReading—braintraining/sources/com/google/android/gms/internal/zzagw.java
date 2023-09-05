package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import com.google.android.gms.ads.internal.zzbs;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@zzzb
@TargetApi(8)
public class zzagw {
    private zzagw() {
    }

    public static boolean zzh(zzama zzama) {
        if (zzama == null) {
            return false;
        }
        zzama.onPause();
        return true;
    }

    public static boolean zzi(zzama zzama) {
        if (zzama == null) {
            return false;
        }
        zzama.onResume();
        return true;
    }

    public static boolean zzqd() {
        int myUid = Process.myUid();
        return myUid == 0 || myUid == 1000;
    }

    public String getDefaultUserAgent(Context context) {
        return "";
    }

    public boolean isAttachedToWindow(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public void setBackground(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    public Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public String zza(SslError sslError) {
        return "";
    }

    public void zza(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public boolean zza(DownloadManager.Request request) {
        return false;
    }

    public boolean zza(Context context, WebSettings webSettings) {
        return false;
    }

    public boolean zza(Window window) {
        return false;
    }

    public void zzaw(Context context) {
        zzbs.zzeg().zzpn();
    }

    public CookieManager zzax(Context context) {
        if (zzqd()) {
            return null;
        }
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzafj.zzb("Failed to obtain CookieManager.", th);
            zzbs.zzeg().zza(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public zzamb zzb(zzama zzama, boolean z) {
        return new zzamb(zzama, z);
    }

    public void zzb(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            zza(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public Set<String> zzg(Uri uri) {
        if (uri.isOpaque()) {
            return Collections.emptySet();
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            linkedHashSet.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
            i = indexOf + 1;
        } while (i < encodedQuery.length());
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public WebChromeClient zzj(zzama zzama) {
        return null;
    }

    public int zzpz() {
        return 0;
    }

    public int zzqa() {
        return 1;
    }

    public int zzqb() {
        return 5;
    }

    public ViewGroup.LayoutParams zzqc() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public int zzqe() {
        return 0;
    }

    public boolean zzs(View view) {
        return false;
    }

    public boolean zzt(View view) {
        return false;
    }
}
