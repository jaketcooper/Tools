package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.util.List;

@zzzb
public final class zzns extends zzpn implements zzod {
    private Bundle mExtras;
    private Object mLock = new Object();
    private String zzbrx;
    private List<zznr> zzbry;
    private String zzbrz;
    private zzoy zzbsa;
    private String zzbsb;
    private double zzbsc;
    private String zzbsd;
    private String zzbse;
    @Nullable
    private zznp zzbsf;
    @Nullable
    private zzku zzbsg;
    @Nullable
    private View zzbsh;
    @Nullable
    private IObjectWrapper zzbsi;
    @Nullable
    private String zzbsj;
    /* access modifiers changed from: private */
    public zzoa zzbsk;

    public zzns(String str, List<zznr> list, String str2, zzoy zzoy, String str3, double d, String str4, String str5, @Nullable zznp zznp, Bundle bundle, zzku zzku, View view, IObjectWrapper iObjectWrapper, String str6) {
        this.zzbrx = str;
        this.zzbry = list;
        this.zzbrz = str2;
        this.zzbsa = zzoy;
        this.zzbsb = str3;
        this.zzbsc = d;
        this.zzbsd = str4;
        this.zzbse = str5;
        this.zzbsf = zznp;
        this.mExtras = bundle;
        this.zzbsg = zzku;
        this.zzbsh = view;
        this.zzbsi = iObjectWrapper;
        this.zzbsj = str6;
    }

    public final void destroy() {
        zzagr.zzczc.post(new zznt(this));
        this.zzbrx = null;
        this.zzbry = null;
        this.zzbrz = null;
        this.zzbsa = null;
        this.zzbsb = null;
        this.zzbsc = Utils.DOUBLE_EPSILON;
        this.zzbsd = null;
        this.zzbse = null;
        this.zzbsf = null;
        this.mExtras = null;
        this.mLock = null;
        this.zzbsg = null;
        this.zzbsh = null;
    }

    public final String getBody() {
        return this.zzbrz;
    }

    public final String getCallToAction() {
        return this.zzbsb;
    }

    public final String getCustomTemplateId() {
        return "";
    }

    public final Bundle getExtras() {
        return this.mExtras;
    }

    public final String getHeadline() {
        return this.zzbrx;
    }

    public final List getImages() {
        return this.zzbry;
    }

    @Nullable
    public final String getMediationAdapterClassName() {
        return this.zzbsj;
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

    public final zzku getVideoController() {
        return this.zzbsg;
    }

    public final void performClick(Bundle bundle) {
        synchronized (this.mLock) {
            if (this.zzbsk == null) {
                zzafj.m12e("Attempt to perform click before app install ad initialized.");
            } else {
                this.zzbsk.performClick(bundle);
            }
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        boolean recordImpression;
        synchronized (this.mLock) {
            if (this.zzbsk == null) {
                zzafj.m12e("Attempt to record impression before app install ad initialized.");
                recordImpression = false;
            } else {
                recordImpression = this.zzbsk.recordImpression(bundle);
            }
        }
        return recordImpression;
    }

    public final void reportTouchEvent(Bundle bundle) {
        synchronized (this.mLock) {
            if (this.zzbsk == null) {
                zzafj.m12e("Attempt to perform click before app install ad initialized.");
            } else {
                this.zzbsk.reportTouchEvent(bundle);
            }
        }
    }

    public final void zzb(zzoa zzoa) {
        synchronized (this.mLock) {
            this.zzbsk = zzoa;
        }
    }

    public final zzoy zzjm() {
        return this.zzbsa;
    }

    public final IObjectWrapper zzjn() {
        return zzn.zzy(this.zzbsk);
    }

    public final String zzjo() {
        return "2";
    }

    public final zznp zzjp() {
        return this.zzbsf;
    }

    public final View zzjq() {
        return this.zzbsh;
    }

    public final IObjectWrapper zzjr() {
        return this.zzbsi;
    }

    public final zzou zzjs() {
        return this.zzbsf;
    }
}
