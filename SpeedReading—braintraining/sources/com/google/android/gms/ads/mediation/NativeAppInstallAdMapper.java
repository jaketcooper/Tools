package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

public class NativeAppInstallAdMapper extends NativeAdMapper {
    private String zzbrx;
    private List<NativeAd.Image> zzbry;
    private String zzbrz;
    private String zzbsb;
    private double zzbsc;
    private String zzbsd;
    private String zzbse;
    private NativeAd.Image zzdky;

    public final String getBody() {
        return this.zzbrz;
    }

    public final String getCallToAction() {
        return this.zzbsb;
    }

    public final String getHeadline() {
        return this.zzbrx;
    }

    public final NativeAd.Image getIcon() {
        return this.zzdky;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzbry;
    }

    public final String getPrice() {
        return this.zzbse;
    }

    public final double getStarRating() {
        return this.zzbsc;
    }

    public final String getStore() {
        return this.zzbsd;
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

    public final void setIcon(NativeAd.Image image) {
        this.zzdky = image;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.zzbry = list;
    }

    public final void setPrice(String str) {
        this.zzbse = str;
    }

    public final void setStarRating(double d) {
        this.zzbsc = d;
    }

    public final void setStore(String str) {
        this.zzbsd = str;
    }
}
