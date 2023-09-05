package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.util.List;

@zzzb
public final class zznu extends zzpr implements zzod {
    private Bundle mExtras;
    private Object mLock = new Object();
    private String zzbrx;
    private List<zznr> zzbry;
    private String zzbrz;
    private String zzbsb;
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
    private zzoy zzbsm;
    private String zzbsn;

    public zznu(String str, List<zznr> list, String str2, zzoy zzoy, String str3, String str4, @Nullable zznp zznp, Bundle bundle, zzku zzku, View view, IObjectWrapper iObjectWrapper, String str5) {
        this.zzbrx = str;
        this.zzbry = list;
        this.zzbrz = str2;
        this.zzbsm = zzoy;
        this.zzbsb = str3;
        this.zzbsn = str4;
        this.zzbsf = zznp;
        this.mExtras = bundle;
        this.zzbsg = zzku;
        this.zzbsh = view;
        this.zzbsi = iObjectWrapper;
        this.zzbsj = str5;
    }

    public final void destroy() {
        zzagr.zzczc.post(new zznv(this));
        this.zzbrx = null;
        this.zzbry = null;
        this.zzbrz = null;
        this.zzbsm = null;
        this.zzbsb = null;
        this.zzbsn = null;
        this.zzbsf = null;
        this.mExtras = null;
        this.mLock = null;
        this.zzbsg = null;
        this.zzbsh = null;
    }

    public final String getAdvertiser() {
        return this.zzbsn;
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

    public final zzku getVideoController() {
        return this.zzbsg;
    }

    public final void performClick(Bundle bundle) {
        synchronized (this.mLock) {
            if (this.zzbsk == null) {
                zzafj.m12e("Attempt to perform click before content ad initialized.");
            } else {
                this.zzbsk.performClick(bundle);
            }
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        boolean recordImpression;
        synchronized (this.mLock) {
            if (this.zzbsk == null) {
                zzafj.m12e("Attempt to record impression before content ad initialized.");
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

    public final IObjectWrapper zzjn() {
        return zzn.zzy(this.zzbsk);
    }

    public final String zzjo() {
        return "1";
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

    public final zzoy zzjt() {
        return this.zzbsm;
    }
}
