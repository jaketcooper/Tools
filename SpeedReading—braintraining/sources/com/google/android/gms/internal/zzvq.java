package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.zzq;

@zzzb
public final class zzvq implements MediationInterstitialAdapter {
    private Uri mUri;
    /* access modifiers changed from: private */
    public Activity zzcem;
    /* access modifiers changed from: private */
    public MediationInterstitialListener zzcen;

    public final void onDestroy() {
        zzaiw.zzbw("Destroying AdMobCustomTabsAdapter adapter.");
    }

    public final void onPause() {
        zzaiw.zzbw("Pausing AdMobCustomTabsAdapter adapter.");
    }

    public final void onResume() {
        zzaiw.zzbw("Resuming AdMobCustomTabsAdapter adapter.");
    }

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzcen = mediationInterstitialListener;
        if (this.zzcen == null) {
            zzaiw.zzco("Listener not set for mediation. Returning.");
        } else if (!(context instanceof Activity)) {
            zzaiw.zzco("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.zzcen.onAdFailedToLoad(this, 0);
        } else {
            if (!(zzq.zzalw() && zznn.zzi(context))) {
                zzaiw.zzco("Default browser does not support custom tabs. Bailing out.");
                this.zzcen.onAdFailedToLoad(this, 0);
                return;
            }
            String string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                zzaiw.zzco("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.zzcen.onAdFailedToLoad(this, 0);
                return;
            }
            this.zzcem = (Activity) context;
            this.mUri = Uri.parse(string);
            this.zzcen.onAdLoaded(this);
        }
    }

    public final void showInterstitial() {
        CustomTabsIntent build = new CustomTabsIntent.Builder().build();
        build.intent.setData(this.mUri);
        zzagr.zzczc.post(new zzvs(this, new AdOverlayInfoParcel(new zzc(build.intent), (zzin) null, new zzvr(this), (com.google.android.gms.ads.internal.overlay.zzq) null, new zzaiy(0, 0, false))));
        zzbs.zzeg().zzpi();
    }
}
