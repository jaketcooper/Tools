package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;

@zzzb
public final class zzpb extends NativeAd.Image {
    private final Drawable mDrawable;
    private final Uri mUri;
    private final double zzbrw;
    private final zzoy zzbui;

    public zzpb(zzoy zzoy) {
        Drawable drawable;
        Uri uri = null;
        this.zzbui = zzoy;
        try {
            IObjectWrapper zzjl = this.zzbui.zzjl();
            if (zzjl != null) {
                drawable = (Drawable) zzn.zzx(zzjl);
                this.mDrawable = drawable;
                uri = this.zzbui.getUri();
                this.mUri = uri;
                double d = 1.0d;
                d = this.zzbui.getScale();
                this.zzbrw = d;
            }
        } catch (RemoteException e) {
            zzaiw.zzb("Failed to get drawable.", e);
        }
        drawable = null;
        this.mDrawable = drawable;
        try {
            uri = this.zzbui.getUri();
        } catch (RemoteException e2) {
            zzaiw.zzb("Failed to get uri.", e2);
        }
        this.mUri = uri;
        double d2 = 1.0d;
        try {
            d2 = this.zzbui.getScale();
        } catch (RemoteException e3) {
            zzaiw.zzb("Failed to get scale.", e3);
        }
        this.zzbrw = d2;
    }

    public final Drawable getDrawable() {
        return this.mDrawable;
    }

    public final double getScale() {
        return this.zzbrw;
    }

    public final Uri getUri() {
        return this.mUri;
    }
}
