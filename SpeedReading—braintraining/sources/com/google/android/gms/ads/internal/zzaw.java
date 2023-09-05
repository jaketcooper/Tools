package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzahj;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zzkq;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzzb;

@zzzb
public final class zzaw extends zzkq {
    private static final Object sLock = new Object();
    @Nullable
    private static zzaw zzaqg;
    /* access modifiers changed from: private */
    public final Context mContext;
    private final Object mLock = new Object();
    private boolean zzaqh;
    private zzaiy zzaqi;

    private zzaw(Context context, zzaiy zzaiy) {
        this.mContext = context;
        this.zzaqi = zzaiy;
        this.zzaqh = false;
    }

    public static zzaw zza(Context context, zzaiy zzaiy) {
        zzaw zzaw;
        synchronized (sLock) {
            if (zzaqg == null) {
                zzaqg = new zzaw(context.getApplicationContext(), zzaiy);
            }
            zzaw = zzaqg;
        }
        return zzaw;
    }

    public final void initialize() {
        synchronized (sLock) {
            if (this.zzaqh) {
                zzafj.zzco("Mobile ads is initialized already.");
                return;
            }
            this.zzaqh = true;
            zzmq.initialize(this.mContext);
            zzbs.zzeg().zzd(this.mContext, this.zzaqi);
            zzbs.zzeh().initialize(this.mContext);
        }
    }

    public final void setAppMuted(boolean z) {
        zzbs.zzfc().setAppMuted(z);
    }

    public final void setAppVolume(float f) {
        zzbs.zzfc().setAppVolume(f);
    }

    public final void zza(String str, IObjectWrapper iObjectWrapper) {
        zzax zzax;
        boolean z;
        if (!TextUtils.isEmpty(str)) {
            zzmq.initialize(this.mContext);
            boolean booleanValue = ((Boolean) zzbs.zzep().zzd(zzmq.zzbnq)).booleanValue() | ((Boolean) zzbs.zzep().zzd(zzmq.zzbjo)).booleanValue();
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzbjo)).booleanValue()) {
                zzax = new zzax(this, (Runnable) zzn.zzx(iObjectWrapper));
                z = true;
            } else {
                zzax = null;
                z = booleanValue;
            }
            if (z) {
                zzbs.zzej().zza(this.mContext, this.zzaqi, str, zzax);
            }
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzafj.m12e("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) zzn.zzx(iObjectWrapper);
        if (context == null) {
            zzafj.m12e("Context is null. Failed to open debug menu.");
            return;
        }
        zzahj zzahj = new zzahj(context);
        zzahj.setAdUnitId(str);
        zzahj.zzci(this.zzaqi.zzcp);
        zzahj.showDialog();
    }

    public final float zzdh() {
        return zzbs.zzfc().zzdh();
    }

    public final boolean zzdi() {
        return zzbs.zzfc().zzdi();
    }

    public final void zzt(String str) {
        zzmq.initialize(this.mContext);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzbnq)).booleanValue()) {
                zzbs.zzej().zza(this.mContext, this.zzaqi, str, (Runnable) null);
            }
        }
    }
}
