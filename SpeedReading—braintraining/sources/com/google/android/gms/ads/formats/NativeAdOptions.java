package com.google.android.gms.ads.formats;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.internal.zzzb;

@zzzb
public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int ORIENTATION_ANY = 0;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;
    private final boolean zzali;
    private final int zzalj;
    private final boolean zzalk;
    private final int zzall;
    private final VideoOptions zzalm;

    public @interface AdChoicesPlacement {
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zzali = false;
        /* access modifiers changed from: private */
        public int zzalj = -1;
        /* access modifiers changed from: private */
        public boolean zzalk = false;
        /* access modifiers changed from: private */
        public int zzall = 1;
        /* access modifiers changed from: private */
        public VideoOptions zzalm;

        public final NativeAdOptions build() {
            return new NativeAdOptions(this);
        }

        public final Builder setAdChoicesPlacement(@AdChoicesPlacement int i) {
            this.zzall = i;
            return this;
        }

        public final Builder setImageOrientation(int i) {
            this.zzalj = i;
            return this;
        }

        public final Builder setRequestMultipleImages(boolean z) {
            this.zzalk = z;
            return this;
        }

        public final Builder setReturnUrlsForImageAssets(boolean z) {
            this.zzali = z;
            return this;
        }

        public final Builder setVideoOptions(VideoOptions videoOptions) {
            this.zzalm = videoOptions;
            return this;
        }
    }

    private NativeAdOptions(Builder builder) {
        this.zzali = builder.zzali;
        this.zzalj = builder.zzalj;
        this.zzalk = builder.zzalk;
        this.zzall = builder.zzall;
        this.zzalm = builder.zzalm;
    }

    public final int getAdChoicesPlacement() {
        return this.zzall;
    }

    public final int getImageOrientation() {
        return this.zzalj;
    }

    @Nullable
    public final VideoOptions getVideoOptions() {
        return this.zzalm;
    }

    public final boolean shouldRequestMultipleImages() {
        return this.zzalk;
    }

    public final boolean shouldReturnUrlsForImageAssets() {
        return this.zzali;
    }
}
