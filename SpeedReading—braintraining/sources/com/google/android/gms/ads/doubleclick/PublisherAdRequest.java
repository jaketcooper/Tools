package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzlc;
import com.google.android.gms.internal.zzld;
import java.util.Date;
import java.util.List;
import java.util.Set;

public final class PublisherAdRequest {
    public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    private final zzlc zzakt;

    public static final class Builder {
        /* access modifiers changed from: private */
        public final zzld zzaku = new zzld();

        public final Builder addCategoryExclusion(String str) {
            this.zzaku.zzai(str);
            return this;
        }

        public final Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.zzaku.zzb(cls, bundle);
            return this;
        }

        public final Builder addCustomTargeting(String str, String str2) {
            this.zzaku.zzd(str, str2);
            return this;
        }

        public final Builder addCustomTargeting(String str, List<String> list) {
            if (list != null) {
                this.zzaku.zzd(str, TextUtils.join(",", list));
            }
            return this;
        }

        public final Builder addKeyword(String str) {
            this.zzaku.zzac(str);
            return this;
        }

        public final Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zzaku.zza(networkExtras);
            return this;
        }

        public final Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.zzaku.zza(cls, bundle);
            return this;
        }

        public final Builder addTestDevice(String str) {
            this.zzaku.zzad(str);
            return this;
        }

        public final PublisherAdRequest build() {
            return new PublisherAdRequest(this);
        }

        public final Builder setBirthday(Date date) {
            this.zzaku.zza(date);
            return this;
        }

        public final Builder setContentUrl(String str) {
            zzbq.checkNotNull(str, "Content URL must be non-null.");
            zzbq.zzh(str, "Content URL must be non-empty.");
            zzbq.zzb(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", 512, Integer.valueOf(str.length()));
            this.zzaku.zzaf(str);
            return this;
        }

        public final Builder setGender(int i) {
            this.zzaku.zzr(i);
            return this;
        }

        public final Builder setIsDesignedForFamilies(boolean z) {
            this.zzaku.zzj(z);
            return this;
        }

        public final Builder setLocation(Location location) {
            this.zzaku.zzb(location);
            return this;
        }

        @Deprecated
        public final Builder setManualImpressionsEnabled(boolean z) {
            this.zzaku.setManualImpressionsEnabled(z);
            return this;
        }

        public final Builder setPublisherProvidedId(String str) {
            this.zzaku.zzag(str);
            return this;
        }

        public final Builder setRequestAgent(String str) {
            this.zzaku.zzah(str);
            return this;
        }

        public final Builder tagForChildDirectedTreatment(boolean z) {
            this.zzaku.zzi(z);
            return this;
        }
    }

    private PublisherAdRequest(Builder builder) {
        this.zzakt = new zzlc(builder.zzaku);
    }

    public static void updateCorrelator() {
    }

    public final Date getBirthday() {
        return this.zzakt.getBirthday();
    }

    public final String getContentUrl() {
        return this.zzakt.getContentUrl();
    }

    public final <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.zzakt.getCustomEventExtrasBundle(cls);
    }

    public final Bundle getCustomTargeting() {
        return this.zzakt.getCustomTargeting();
    }

    public final int getGender() {
        return this.zzakt.getGender();
    }

    public final Set<String> getKeywords() {
        return this.zzakt.getKeywords();
    }

    public final Location getLocation() {
        return this.zzakt.getLocation();
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzakt.getManualImpressionsEnabled();
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.zzakt.getNetworkExtras(cls);
    }

    public final <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.zzakt.getNetworkExtrasBundle(cls);
    }

    public final String getPublisherProvidedId() {
        return this.zzakt.getPublisherProvidedId();
    }

    public final boolean isTestDevice(Context context) {
        return this.zzakt.isTestDevice(context);
    }

    public final zzlc zzbb() {
        return this.zzakt;
    }
}
