package com.google.ads;

import android.content.Context;
import com.safonov.speedreading.training.fragment.truecolors.training.presenter.TrueColorsPresenter;

@Deprecated
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "mb");
    public static final int FULL_WIDTH = -1;
    public static final AdSize IAB_BANNER = new AdSize(468, 60, "as");
    public static final AdSize IAB_LEADERBOARD = new AdSize(728, 90, "as");
    public static final AdSize IAB_MRECT = new AdSize(TrueColorsPresenter.ANSWER_DURATION, 250, "as");
    public static final AdSize IAB_WIDE_SKYSCRAPER = new AdSize(160, 600, "as");
    public static final int LANDSCAPE_AD_HEIGHT = 32;
    public static final int LARGE_AD_HEIGHT = 90;
    public static final int PORTRAIT_AD_HEIGHT = 50;
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "mb");
    private final com.google.android.gms.ads.AdSize zzcg;

    public AdSize(int i, int i2) {
        this(new com.google.android.gms.ads.AdSize(i, i2));
    }

    private AdSize(int i, int i2, String str) {
        this(new com.google.android.gms.ads.AdSize(i, i2));
    }

    public AdSize(com.google.android.gms.ads.AdSize adSize) {
        this.zzcg = adSize;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AdSize)) {
            return false;
        }
        return this.zzcg.equals(((AdSize) obj).zzcg);
    }

    public final AdSize findBestSize(AdSize... adSizeArr) {
        float f;
        AdSize adSize;
        AdSize adSize2 = null;
        if (adSizeArr != null) {
            float f2 = 0.0f;
            int width = getWidth();
            int height = getHeight();
            int length = adSizeArr.length;
            int i = 0;
            while (i < length) {
                AdSize adSize3 = adSizeArr[i];
                int width2 = adSize3.getWidth();
                int height2 = adSize3.getHeight();
                if (isSizeAppropriate(width2, height2)) {
                    f = ((float) (width2 * height2)) / ((float) (width * height));
                    if (f > 1.0f) {
                        f = 1.0f / f;
                    }
                    if (f > f2) {
                        adSize = adSize3;
                        i++;
                        adSize2 = adSize;
                        f2 = f;
                    }
                }
                f = f2;
                adSize = adSize2;
                i++;
                adSize2 = adSize;
                f2 = f;
            }
        }
        return adSize2;
    }

    public final int getHeight() {
        return this.zzcg.getHeight();
    }

    public final int getHeightInPixels(Context context) {
        return this.zzcg.getHeightInPixels(context);
    }

    public final int getWidth() {
        return this.zzcg.getWidth();
    }

    public final int getWidthInPixels(Context context) {
        return this.zzcg.getWidthInPixels(context);
    }

    public final int hashCode() {
        return this.zzcg.hashCode();
    }

    public final boolean isAutoHeight() {
        return this.zzcg.isAutoHeight();
    }

    public final boolean isCustomAdSize() {
        return false;
    }

    public final boolean isFullWidth() {
        return this.zzcg.isFullWidth();
    }

    public final boolean isSizeAppropriate(int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        return ((float) i) <= ((float) width) * 1.25f && ((float) i) >= ((float) width) * 0.8f && ((float) i2) <= ((float) height) * 1.25f && ((float) i2) >= ((float) height) * 0.8f;
    }

    public final String toString() {
        return this.zzcg.toString();
    }
}
