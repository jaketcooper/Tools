package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.util.SimpleArrayMap;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@zzzb
public final class zznw extends zzpv implements zzoc {
    private final Object mLock = new Object();
    private final zznp zzbsf;
    @Nullable
    private zzku zzbsg;
    @Nullable
    private View zzbsh;
    private zzoa zzbsk;
    private final String zzbsp;
    private final SimpleArrayMap<String, zznr> zzbsq;
    private final SimpleArrayMap<String, String> zzbsr;

    public zznw(String str, SimpleArrayMap<String, zznr> simpleArrayMap, SimpleArrayMap<String, String> simpleArrayMap2, zznp zznp, zzku zzku, View view) {
        this.zzbsp = str;
        this.zzbsq = simpleArrayMap;
        this.zzbsr = simpleArrayMap2;
        this.zzbsf = zznp;
        this.zzbsg = zzku;
        this.zzbsh = view;
    }

    public final void destroy() {
        this.zzbsk = null;
        this.zzbsg = null;
        this.zzbsh = null;
    }

    public final List<String> getAvailableAssetNames() {
        int i = 0;
        String[] strArr = new String[(this.zzbsq.size() + this.zzbsr.size())];
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzbsq.size(); i3++) {
            strArr[i2] = this.zzbsq.keyAt(i3);
            i2++;
        }
        while (i < this.zzbsr.size()) {
            strArr[i2] = this.zzbsr.keyAt(i);
            i++;
            i2++;
        }
        return Arrays.asList(strArr);
    }

    public final String getCustomTemplateId() {
        return this.zzbsp;
    }

    public final zzku getVideoController() {
        return this.zzbsg;
    }

    public final void performClick(String str) {
        synchronized (this.mLock) {
            if (this.zzbsk == null) {
                zzaiw.m12e("Attempt to call performClick before ad initialized.");
            } else {
                this.zzbsk.zza((View) null, str, (Bundle) null, (Map<String, WeakReference<View>>) null, (View) null);
            }
        }
    }

    public final void recordImpression() {
        synchronized (this.mLock) {
            if (this.zzbsk == null) {
                zzaiw.m12e("Attempt to perform recordImpression before ad initialized.");
            } else {
                this.zzbsk.zza((View) null, (Map<String, WeakReference<View>>) null);
            }
        }
    }

    public final String zzao(String str) {
        return this.zzbsr.get(str);
    }

    public final zzoy zzap(String str) {
        return this.zzbsq.get(str);
    }

    public final void zzb(zzoa zzoa) {
        synchronized (this.mLock) {
            this.zzbsk = zzoa;
        }
    }

    public final boolean zzf(IObjectWrapper iObjectWrapper) {
        if (this.zzbsk == null) {
            zzaiw.m12e("Attempt to call renderVideoInMediaView before ad initialized.");
            return false;
        } else if (this.zzbsh == null) {
            return false;
        } else {
            zznx zznx = new zznx(this);
            this.zzbsk.zza((View) (FrameLayout) zzn.zzx(iObjectWrapper), (zzny) zznx);
            return true;
        }
    }

    public final IObjectWrapper zzjn() {
        return zzn.zzy(this.zzbsk);
    }

    public final String zzjo() {
        return "3";
    }

    public final zznp zzjp() {
        return this.zzbsf;
    }

    public final View zzjq() {
        return this.zzbsh;
    }

    public final IObjectWrapper zzju() {
        return zzn.zzy(this.zzbsk.getContext().getApplicationContext());
    }
}
