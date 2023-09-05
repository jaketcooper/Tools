package com.google.android.gms.internal;

import android.location.Location;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@zzzb
public final class zzva implements NativeMediationAdRequest {
    private final zzom zzaor;
    private final List<String> zzaos = new ArrayList();
    private final int zzbcm;
    private final boolean zzbcy;
    private final int zzcdx;
    private final Map<String, Boolean> zzcef = new HashMap();
    private final Date zzha;
    private final Set<String> zzhc;
    private final boolean zzhd;
    private final Location zzhe;

    public zzva(@Nullable Date date, int i, @Nullable Set<String> set, @Nullable Location location, boolean z, int i2, zzom zzom, List<String> list, boolean z2) {
        this.zzha = date;
        this.zzbcm = i;
        this.zzhc = set;
        this.zzhe = location;
        this.zzhd = z;
        this.zzcdx = i2;
        this.zzaor = zzom;
        this.zzbcy = z2;
        if (list != null) {
            for (String next : list) {
                if (next.startsWith("custom:")) {
                    String[] split = next.split(":", 3);
                    if (split.length == 3) {
                        if ("true".equals(split[2])) {
                            this.zzcef.put(split[1], true);
                        } else if ("false".equals(split[2])) {
                            this.zzcef.put(split[1], false);
                        }
                    }
                } else {
                    this.zzaos.add(next);
                }
            }
        }
    }

    public final float getAdVolume() {
        return zzlh.zzik().zzdh();
    }

    public final Date getBirthday() {
        return this.zzha;
    }

    public final int getGender() {
        return this.zzbcm;
    }

    public final Set<String> getKeywords() {
        return this.zzhc;
    }

    public final Location getLocation() {
        return this.zzhe;
    }

    public final NativeAdOptions getNativeAdOptions() {
        if (this.zzaor == null) {
            return null;
        }
        NativeAdOptions.Builder requestMultipleImages = new NativeAdOptions.Builder().setReturnUrlsForImageAssets(this.zzaor.zzbtj).setImageOrientation(this.zzaor.zzbtk).setRequestMultipleImages(this.zzaor.zzbtl);
        if (this.zzaor.versionCode >= 2) {
            requestMultipleImages.setAdChoicesPlacement(this.zzaor.zzbtm);
        }
        if (this.zzaor.versionCode >= 3 && this.zzaor.zzbtn != null) {
            requestMultipleImages.setVideoOptions(new VideoOptions(this.zzaor.zzbtn));
        }
        return requestMultipleImages.build();
    }

    public final boolean isAdMuted() {
        return zzlh.zzik().zzdi();
    }

    public final boolean isAppInstallAdRequested() {
        return this.zzaos != null && this.zzaos.contains("2");
    }

    public final boolean isContentAdRequested() {
        return this.zzaos != null && this.zzaos.contains("1");
    }

    public final boolean isDesignedForFamilies() {
        return this.zzbcy;
    }

    public final boolean isTesting() {
        return this.zzhd;
    }

    public final int taggedForChildDirectedTreatment() {
        return this.zzcdx;
    }

    public final boolean zzmi() {
        return this.zzaos != null && this.zzaos.contains("3");
    }

    public final Map<String, Boolean> zzmj() {
        return this.zzcef;
    }
}
