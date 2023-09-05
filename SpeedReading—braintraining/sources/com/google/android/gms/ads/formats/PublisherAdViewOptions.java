package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.zzbej;
import com.google.android.gms.internal.zzbem;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzzb;

@zzzb
public final class PublisherAdViewOptions extends zzbej {
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzc();
    private final boolean zzals;
    @Nullable
    private final zzkg zzalt;
    @Nullable
    private AppEventListener zzalu;

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zzals = false;
        /* access modifiers changed from: private */
        public AppEventListener zzalu;

        public final PublisherAdViewOptions build() {
            return new PublisherAdViewOptions(this);
        }

        public final Builder setAppEventListener(AppEventListener appEventListener) {
            this.zzalu = appEventListener;
            return this;
        }

        public final Builder setManualImpressionsEnabled(boolean z) {
            this.zzals = z;
            return this;
        }
    }

    private PublisherAdViewOptions(Builder builder) {
        this.zzals = builder.zzals;
        this.zzalu = builder.zzalu;
        this.zzalt = this.zzalu != null ? new zziy(this.zzalu) : null;
    }

    PublisherAdViewOptions(boolean z, @Nullable IBinder iBinder) {
        this.zzals = z;
        this.zzalt = iBinder != null ? zzkh.zzg(iBinder) : null;
    }

    @Nullable
    public final AppEventListener getAppEventListener() {
        return this.zzalu;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzals;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zza(parcel, 1, getManualImpressionsEnabled());
        zzbem.zza(parcel, 2, this.zzalt == null ? null : this.zzalt.asBinder(), false);
        zzbem.zzai(parcel, zze);
    }

    @Nullable
    public final zzkg zzbi() {
        return this.zzalt;
    }
}
