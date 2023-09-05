package com.google.android.gms.ads;

import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzaiw;
import com.google.android.gms.internal.zzku;
import com.google.android.gms.internal.zzlz;
import com.google.android.gms.internal.zzzb;

@zzzb
public final class VideoController {
    @KeepForSdk
    public static final int PLAYBACK_STATE_ENDED = 3;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PAUSED = 2;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PLAYING = 1;
    @KeepForSdk
    public static final int PLAYBACK_STATE_READY = 5;
    @KeepForSdk
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object mLock = new Object();
    @Nullable
    private zzku zzald;
    @Nullable
    private VideoLifecycleCallbacks zzale;

    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    public final float getAspectRatio() {
        float f = 0.0f;
        synchronized (this.mLock) {
            if (this.zzald != null) {
                try {
                    f = this.zzald.getAspectRatio();
                } catch (RemoteException e) {
                    zzaiw.zzb("Unable to call getAspectRatio on video controller.", e);
                }
            }
        }
        return f;
    }

    @KeepForSdk
    public final int getPlaybackState() {
        int i = 0;
        synchronized (this.mLock) {
            if (this.zzald != null) {
                try {
                    i = this.zzald.getPlaybackState();
                } catch (RemoteException e) {
                    zzaiw.zzb("Unable to call getPlaybackState on video controller.", e);
                }
            }
        }
        return i;
    }

    @Nullable
    public final VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.mLock) {
            videoLifecycleCallbacks = this.zzale;
        }
        return videoLifecycleCallbacks;
    }

    public final boolean hasVideoContent() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzald != null;
        }
        return z;
    }

    @KeepForSdk
    public final boolean isClickToExpandEnabled() {
        boolean z = false;
        synchronized (this.mLock) {
            if (this.zzald != null) {
                try {
                    z = this.zzald.isClickToExpandEnabled();
                } catch (RemoteException e) {
                    zzaiw.zzb("Unable to call isClickToExpandEnabled.", e);
                }
            }
        }
        return z;
    }

    @KeepForSdk
    public final boolean isCustomControlsEnabled() {
        boolean z = false;
        synchronized (this.mLock) {
            if (this.zzald != null) {
                try {
                    z = this.zzald.isCustomControlsEnabled();
                } catch (RemoteException e) {
                    zzaiw.zzb("Unable to call isUsingCustomPlayerControls.", e);
                }
            }
        }
        return z;
    }

    @KeepForSdk
    public final boolean isMuted() {
        boolean z = true;
        synchronized (this.mLock) {
            if (this.zzald != null) {
                try {
                    z = this.zzald.isMuted();
                } catch (RemoteException e) {
                    zzaiw.zzb("Unable to call isMuted on video controller.", e);
                }
            }
        }
        return z;
    }

    @KeepForSdk
    public final void mute(boolean z) {
        synchronized (this.mLock) {
            if (this.zzald != null) {
                try {
                    this.zzald.mute(z);
                } catch (RemoteException e) {
                    zzaiw.zzb("Unable to call mute on video controller.", e);
                }
                return;
            }
            return;
        }
    }

    @KeepForSdk
    public final void pause() {
        synchronized (this.mLock) {
            if (this.zzald != null) {
                try {
                    this.zzald.pause();
                } catch (RemoteException e) {
                    zzaiw.zzb("Unable to call pause on video controller.", e);
                }
                return;
            }
            return;
        }
    }

    @KeepForSdk
    public final void play() {
        synchronized (this.mLock) {
            if (this.zzald != null) {
                try {
                    this.zzald.play();
                } catch (RemoteException e) {
                    zzaiw.zzb("Unable to call play on video controller.", e);
                }
                return;
            }
            return;
        }
    }

    public final void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        zzbq.checkNotNull(videoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.mLock) {
            this.zzale = videoLifecycleCallbacks;
            if (this.zzald != null) {
                try {
                    this.zzald.zza(new zzlz(videoLifecycleCallbacks));
                } catch (RemoteException e) {
                    zzaiw.zzb("Unable to call setVideoLifecycleCallbacks on video controller.", e);
                }
                return;
            }
            return;
        }
    }

    public final void zza(zzku zzku) {
        synchronized (this.mLock) {
            this.zzald = zzku;
            if (this.zzale != null) {
                setVideoLifecycleCallbacks(this.zzale);
            }
        }
    }

    public final zzku zzbe() {
        zzku zzku;
        synchronized (this.mLock) {
            zzku = this.zzald;
        }
        return zzku;
    }
}
