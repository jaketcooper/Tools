package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.dynamic.zzn;
import java.util.List;
import java.util.WeakHashMap;

@zzzb
public final class zzpx implements NativeCustomTemplateAd {
    private static WeakHashMap<IBinder, zzpx> zzbup = new WeakHashMap<>();
    private final VideoController zzbeq = new VideoController();
    private final zzpu zzbuq;
    private final MediaView zzbur;

    private zzpx(zzpu zzpu) {
        Context context;
        MediaView mediaView = null;
        this.zzbuq = zzpu;
        try {
            context = (Context) zzn.zzx(zzpu.zzju());
        } catch (RemoteException | NullPointerException e) {
            zzaiw.zzb("Unable to inflate MediaView.", e);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                mediaView = !this.zzbuq.zzf(zzn.zzy(mediaView2)) ? null : mediaView2;
            } catch (RemoteException e2) {
                zzaiw.zzb("Unable to render video in MediaView.", e2);
            }
        }
        this.zzbur = mediaView;
    }

    public static zzpx zza(zzpu zzpu) {
        zzpx zzpx;
        synchronized (zzbup) {
            zzpx = zzbup.get(zzpu.asBinder());
            if (zzpx == null) {
                zzpx = new zzpx(zzpu);
                zzbup.put(zzpu.asBinder(), zzpx);
            }
        }
        return zzpx;
    }

    public final void destroy() {
        try {
            this.zzbuq.destroy();
        } catch (RemoteException e) {
            zzaiw.zzb("Failed to destroy ad.", e);
        }
    }

    public final List<String> getAvailableAssetNames() {
        try {
            return this.zzbuq.getAvailableAssetNames();
        } catch (RemoteException e) {
            zzaiw.zzb("Failed to get available asset names.", e);
            return null;
        }
    }

    public final String getCustomTemplateId() {
        try {
            return this.zzbuq.getCustomTemplateId();
        } catch (RemoteException e) {
            zzaiw.zzb("Failed to get custom template id.", e);
            return null;
        }
    }

    public final NativeAd.Image getImage(String str) {
        try {
            zzoy zzap = this.zzbuq.zzap(str);
            if (zzap != null) {
                return new zzpb(zzap);
            }
        } catch (RemoteException e) {
            zzaiw.zzb("Failed to get image.", e);
        }
        return null;
    }

    public final CharSequence getText(String str) {
        try {
            return this.zzbuq.zzao(str);
        } catch (RemoteException e) {
            zzaiw.zzb("Failed to get string.", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            zzku videoController = this.zzbuq.getVideoController();
            if (videoController != null) {
                this.zzbeq.zza(videoController);
            }
        } catch (RemoteException e) {
            zzaiw.zzb("Exception occurred while getting video controller", e);
        }
        return this.zzbeq;
    }

    public final MediaView getVideoMediaView() {
        return this.zzbur;
    }

    public final void performClick(String str) {
        try {
            this.zzbuq.performClick(str);
        } catch (RemoteException e) {
            zzaiw.zzb("Failed to perform click.", e);
        }
    }

    public final void recordImpression() {
        try {
            this.zzbuq.recordImpression();
        } catch (RemoteException e) {
            zzaiw.zzb("Failed to record impression.", e);
        }
    }

    public final zzpu zzkg() {
        return this.zzbuq;
    }
}
