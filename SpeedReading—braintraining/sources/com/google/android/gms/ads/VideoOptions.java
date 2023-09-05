package com.google.android.gms.ads;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.zzma;
import com.google.android.gms.internal.zzzb;

@zzzb
public final class VideoOptions {
    private final boolean zzalf;
    private final boolean zzalg;
    private final boolean zzalh;

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zzalf = true;
        /* access modifiers changed from: private */
        public boolean zzalg = false;
        /* access modifiers changed from: private */
        public boolean zzalh = false;

        public final VideoOptions build() {
            return new VideoOptions(this);
        }

        @KeepForSdk
        public final Builder setClickToExpandRequested(boolean z) {
            this.zzalh = z;
            return this;
        }

        @KeepForSdk
        public final Builder setCustomControlsRequested(boolean z) {
            this.zzalg = z;
            return this;
        }

        public final Builder setStartMuted(boolean z) {
            this.zzalf = z;
            return this;
        }
    }

    private VideoOptions(Builder builder) {
        this.zzalf = builder.zzalf;
        this.zzalg = builder.zzalg;
        this.zzalh = builder.zzalh;
    }

    public VideoOptions(zzma zzma) {
        this.zzalf = zzma.zzbfk;
        this.zzalg = zzma.zzbfl;
        this.zzalh = zzma.zzbfm;
    }

    @KeepForSdk
    public final boolean getClickToExpandRequested() {
        return this.zzalh;
    }

    @KeepForSdk
    public final boolean getCustomControlsRequested() {
        return this.zzalg;
    }

    public final boolean getStartMuted() {
        return this.zzalf;
    }
}
