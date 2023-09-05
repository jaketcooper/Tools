package com.google.android.gms.ads;

import android.content.Context;
import android.support.p000v4.provider.FontsContractCompat;
import com.google.android.gms.internal.zzais;
import com.google.android.gms.internal.zziw;
import com.google.android.gms.internal.zzjk;
import com.safonov.speedreading.training.fragment.truecolors.training.presenter.TrueColorsPresenter;

public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final int FULL_WIDTH = -1;
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(TrueColorsPresenter.ANSWER_DURATION, 250, "300x250_as");
    public static final AdSize SEARCH = new AdSize(-3, 0, "search_v2");
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
    public static final AdSize zzakv = new AdSize(50, 50, "50x50_mb");
    private final int zzakw;
    private final int zzakx;
    private final String zzaky;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AdSize(int r6, int r7) {
        /*
            r5 = this;
            r0 = -1
            if (r6 != r0) goto L_0x0048
            java.lang.String r0 = "FULL"
            r1 = r0
        L_0x0006:
            r0 = -2
            if (r7 != r0) goto L_0x004e
            java.lang.String r0 = "AUTO"
        L_0x000b:
            java.lang.String r2 = "_as"
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            int r3 = r3 + 1
            java.lang.String r4 = java.lang.String.valueOf(r0)
            int r4 = r4.length()
            int r3 = r3 + r4
            java.lang.String r4 = java.lang.String.valueOf(r2)
            int r4 = r4.length()
            int r3 = r3 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.StringBuilder r1 = r4.append(r1)
            java.lang.String r3 = "x"
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            r5.<init>(r6, r7, r0)
            return
        L_0x0048:
            java.lang.String r0 = java.lang.String.valueOf(r6)
            r1 = r0
            goto L_0x0006
        L_0x004e:
            java.lang.String r0 = java.lang.String.valueOf(r7)
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.AdSize.<init>(int, int):void");
    }

    AdSize(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            throw new IllegalArgumentException(new StringBuilder(37).append("Invalid width for AdSize: ").append(i).toString());
        } else if (i2 >= 0 || i2 == -2 || i2 == -4) {
            this.zzakw = i;
            this.zzakx = i2;
            this.zzaky = str;
        } else {
            throw new IllegalArgumentException(new StringBuilder(38).append("Invalid height for AdSize: ").append(i2).toString());
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.zzakw == adSize.zzakw && this.zzakx == adSize.zzakx && this.zzaky.equals(adSize.zzaky);
    }

    public final int getHeight() {
        return this.zzakx;
    }

    public final int getHeightInPixels(Context context) {
        switch (this.zzakx) {
            case -4:
            case FontsContractCompat.FontRequestCallback.FAIL_REASON_FONT_LOAD_ERROR:
                return -1;
            case -2:
                return zziw.zzc(context.getResources().getDisplayMetrics());
            default:
                zzjk.zzhx();
                return zzais.zzc(context, this.zzakx);
        }
    }

    public final int getWidth() {
        return this.zzakw;
    }

    public final int getWidthInPixels(Context context) {
        switch (this.zzakw) {
            case -4:
            case FontsContractCompat.FontRequestCallback.FAIL_REASON_FONT_LOAD_ERROR:
                return -1;
            case -1:
                return zziw.zzb(context.getResources().getDisplayMetrics());
            default:
                zzjk.zzhx();
                return zzais.zzc(context, this.zzakw);
        }
    }

    public final int hashCode() {
        return this.zzaky.hashCode();
    }

    public final boolean isAutoHeight() {
        return this.zzakx == -2;
    }

    public final boolean isFluid() {
        return this.zzakw == -3 && this.zzakx == -4;
    }

    public final boolean isFullWidth() {
        return this.zzakw == -1;
    }

    public final String toString() {
        return this.zzaky;
    }
}
