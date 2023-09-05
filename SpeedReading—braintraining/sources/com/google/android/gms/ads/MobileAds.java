package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.internal.zzlh;
import com.google.android.gms.internal.zzlj;

public class MobileAds {

    public static final class Settings {
        private final zzlj zzalc = new zzlj();

        @Deprecated
        public final String getTrackingId() {
            return null;
        }

        @Deprecated
        public final boolean isGoogleAnalyticsEnabled() {
            return false;
        }

        @Deprecated
        public final Settings setGoogleAnalyticsEnabled(boolean z) {
            return this;
        }

        @Deprecated
        public final Settings setTrackingId(String str) {
            return this;
        }

        /* access modifiers changed from: package-private */
        public final zzlj zzbd() {
            return this.zzalc;
        }
    }

    private MobileAds() {
    }

    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return zzlh.zzik().getRewardedVideoAdInstance(context);
    }

    public static void initialize(Context context) {
        initialize(context, (String) null, (Settings) null);
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void initialize(Context context, String str) {
        initialize(context, str, (Settings) null);
    }

    @RequiresPermission("android.permission.INTERNET")
    @Deprecated
    public static void initialize(Context context, String str, Settings settings) {
        zzlh.zzik().zza(context, str, settings == null ? null : settings.zzbd());
    }

    public static void openDebugMenu(Context context, String str) {
        zzlh.zzik().openDebugMenu(context, str);
    }

    public static void setAppMuted(boolean z) {
        zzlh.zzik().setAppMuted(z);
    }

    public static void setAppVolume(float f) {
        zzlh.zzik().setAppVolume(f);
    }
}
