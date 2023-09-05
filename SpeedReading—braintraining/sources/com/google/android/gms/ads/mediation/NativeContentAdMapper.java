package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

public class NativeContentAdMapper extends NativeAdMapper {
    private String zzbrx;
    private List<NativeAd.Image> zzbry;
    private String zzbrz;
    private String zzbsb;
    private String zzbsn;
    private NativeAd.Image zzdkz;

    public final String getAdvertiser() {
        return this.zzbsn;
    }

    public final String getBody() {
        return this.zzbrz;
    }

    public final String getCallToAction() {
        return this.zzbsb;
    }

    public final String getHeadline() {
        return this.zzbrx;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzbry;
    }

    public final NativeAd.Image getLogo() {
        return this.zzdkz;
    }

    public final void setAdvertiser(String str) {
        this.zzbsn = str;
    }

    public final void setBody(String str) {
        this.zzbrz = str;
    }

    public final void setCallToAction(String str) {
        this.zzbsb = str;
    }

    public final void setHeadline(String str) {
        this.zzbrx = str;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.zzbry = list;
    }

    public final void setLogo(NativeAd.Image image) {
        this.zzdkz = image;
    }
}
