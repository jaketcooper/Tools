package com.google.android.gms.ads.formats;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzaiw;
import com.google.android.gms.internal.zzjk;
import com.google.android.gms.internal.zzph;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public final class NativeAdViewHolder {
    public static WeakHashMap<View, NativeAdViewHolder> zzalq = new WeakHashMap<>();
    private zzph zzalp;
    private WeakReference<View> zzalr;

    public NativeAdViewHolder(View view, Map<String, View> map, Map<String, View> map2) {
        zzbq.checkNotNull(view, "ContainerView must not be null");
        if (view instanceof NativeAdView) {
            zzaiw.m12e("The provided containerView is of type NativeAdView. NativeAdView objects should not be used with NativeAdViewHolder.");
        } else if (zzalq.get(view) != null) {
            zzaiw.m12e("The provided containerView is already in use with another NativeAdViewHolder.");
        } else {
            zzalq.put(view, this);
            this.zzalr = new WeakReference<>(view);
            this.zzalp = zzjk.zzhy().zza(view, zzb(map), zzb(map2));
        }
    }

    private static HashMap<String, View> zzb(Map<String, View> map) {
        return map == null ? new HashMap<>() : new HashMap<>(map);
    }

    public final void setNativeAd(NativeAd nativeAd) {
        View view = this.zzalr != null ? (View) this.zzalr.get() : null;
        if (view == null) {
            zzaiw.zzco("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!zzalq.containsKey(view)) {
            zzalq.put(view, this);
        }
        if (this.zzalp != null) {
            try {
                this.zzalp.zza((IObjectWrapper) nativeAd.zzbg());
            } catch (RemoteException e) {
                zzaiw.zzb("Unable to call setNativeAd on delegate", e);
            }
        }
    }

    public final void unregisterNativeAd() {
        if (this.zzalp != null) {
            try {
                this.zzalp.unregisterNativeAd();
            } catch (RemoteException e) {
                zzaiw.zzb("Unable to call unregisterNativeAd on delegate", e);
            }
        }
        View view = this.zzalr != null ? (View) this.zzalr.get() : null;
        if (view != null) {
            zzalq.remove(view);
        }
    }
}
