package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.google.android.gms.ads.internal.zzbs;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@zzzb
@TargetApi(14)
public final class zzakk extends zzaku implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map<Integer, String> zzddi = new HashMap();
    private final zzalj zzddj;
    private final boolean zzddk;
    private int zzddl = 0;
    private int zzddm = 0;
    private MediaPlayer zzddn;
    private Uri zzddo;
    private int zzddp;
    private int zzddq;
    private int zzddr;
    private int zzdds;
    private int zzddt;
    private zzalg zzddu;
    private boolean zzddv;
    private int zzddw;
    /* access modifiers changed from: private */
    public zzakt zzddx;

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            zzddi.put(-1004, "MEDIA_ERROR_IO");
            zzddi.put(-1007, "MEDIA_ERROR_MALFORMED");
            zzddi.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
            zzddi.put(-110, "MEDIA_ERROR_TIMED_OUT");
            zzddi.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        zzddi.put(100, "MEDIA_ERROR_SERVER_DIED");
        zzddi.put(1, "MEDIA_ERROR_UNKNOWN");
        zzddi.put(1, "MEDIA_INFO_UNKNOWN");
        zzddi.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzddi.put(701, "MEDIA_INFO_BUFFERING_START");
        zzddi.put(702, "MEDIA_INFO_BUFFERING_END");
        zzddi.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        zzddi.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        zzddi.put(802, "MEDIA_INFO_METADATA_UPDATE");
        if (Build.VERSION.SDK_INT >= 19) {
            zzddi.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            zzddi.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }

    public zzakk(Context context, boolean z, boolean z2, zzalh zzalh, zzalj zzalj) {
        super(context);
        setSurfaceTextureListener(this);
        this.zzddj = zzalj;
        this.zzddv = z;
        this.zzddk = z2;
        this.zzddj.zza(this);
    }

    private final void zza(float f) {
        if (this.zzddn != null) {
            try {
                this.zzddn.setVolume(f, f);
            } catch (IllegalStateException e) {
            }
        } else {
            zzafj.zzco("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    private final void zzaa(boolean z) {
        zzafj.m11v("AdMediaPlayerView release");
        if (this.zzddu != null) {
            this.zzddu.zzrs();
            this.zzddu = null;
        }
        if (this.zzddn != null) {
            this.zzddn.reset();
            this.zzddn.release();
            this.zzddn = null;
            zzaf(0);
            if (z) {
                this.zzddm = 0;
                this.zzddm = 0;
            }
        }
    }

    private final void zzaf(int i) {
        if (i == 3) {
            this.zzddj.zzse();
            this.zzdee.zzse();
        } else if (this.zzddl == 3) {
            this.zzddj.zzsf();
            this.zzdee.zzsf();
        }
        this.zzddl = i;
    }

    private final void zzra() {
        SurfaceTexture surfaceTexture;
        zzafj.m11v("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture2 = getSurfaceTexture();
        if (this.zzddo != null && surfaceTexture2 != null) {
            zzaa(false);
            try {
                zzbs.zzeu();
                this.zzddn = new MediaPlayer();
                this.zzddn.setOnBufferingUpdateListener(this);
                this.zzddn.setOnCompletionListener(this);
                this.zzddn.setOnErrorListener(this);
                this.zzddn.setOnInfoListener(this);
                this.zzddn.setOnPreparedListener(this);
                this.zzddn.setOnVideoSizeChangedListener(this);
                this.zzddr = 0;
                if (this.zzddv) {
                    this.zzddu = new zzalg(getContext());
                    this.zzddu.zza(surfaceTexture2, getWidth(), getHeight());
                    this.zzddu.start();
                    surfaceTexture = this.zzddu.zzrt();
                    if (surfaceTexture == null) {
                        this.zzddu.zzrs();
                        this.zzddu = null;
                    }
                    this.zzddn.setDataSource(getContext(), this.zzddo);
                    zzbs.zzev();
                    this.zzddn.setSurface(new Surface(surfaceTexture));
                    this.zzddn.setAudioStreamType(3);
                    this.zzddn.setScreenOnWhilePlaying(true);
                    this.zzddn.prepareAsync();
                    zzaf(1);
                }
                surfaceTexture = surfaceTexture2;
                this.zzddn.setDataSource(getContext(), this.zzddo);
                zzbs.zzev();
                this.zzddn.setSurface(new Surface(surfaceTexture));
                this.zzddn.setAudioStreamType(3);
                this.zzddn.setScreenOnWhilePlaying(true);
                this.zzddn.prepareAsync();
                zzaf(1);
            } catch (IOException | IllegalArgumentException | IllegalStateException e) {
                String valueOf = String.valueOf(this.zzddo);
                zzafj.zzc(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed to initialize MediaPlayer at ").append(valueOf).toString(), e);
                onError(this.zzddn, 1, 0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0034 A[LOOP:0: B:9:0x0034->B:14:0x004f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzrb() {
        /*
            r8 = this;
            boolean r0 = r8.zzddk
            if (r0 != 0) goto L_0x0005
        L_0x0004:
            return
        L_0x0005:
            boolean r0 = r8.zzrc()
            if (r0 == 0) goto L_0x0004
            android.media.MediaPlayer r0 = r8.zzddn
            int r0 = r0.getCurrentPosition()
            if (r0 <= 0) goto L_0x0004
            int r0 = r8.zzddm
            r1 = 3
            if (r0 == r1) goto L_0x0004
            java.lang.String r0 = "AdMediaPlayerView nudging MediaPlayer"
            com.google.android.gms.internal.zzafj.m11v(r0)
            r0 = 0
            r8.zza((float) r0)
            android.media.MediaPlayer r0 = r8.zzddn
            r0.start()
            android.media.MediaPlayer r0 = r8.zzddn
            int r0 = r0.getCurrentPosition()
            com.google.android.gms.common.util.zzd r1 = com.google.android.gms.ads.internal.zzbs.zzei()
            long r2 = r1.currentTimeMillis()
        L_0x0034:
            boolean r1 = r8.zzrc()
            if (r1 == 0) goto L_0x0051
            android.media.MediaPlayer r1 = r8.zzddn
            int r1 = r1.getCurrentPosition()
            if (r1 != r0) goto L_0x0051
            com.google.android.gms.common.util.zzd r1 = com.google.android.gms.ads.internal.zzbs.zzei()
            long r4 = r1.currentTimeMillis()
            long r4 = r4 - r2
            r6 = 250(0xfa, double:1.235E-321)
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x0034
        L_0x0051:
            android.media.MediaPlayer r0 = r8.zzddn
            r0.pause()
            r8.zzrd()
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzakk.zzrb():void");
    }

    private final boolean zzrc() {
        return (this.zzddn == null || this.zzddl == -1 || this.zzddl == 0 || this.zzddl == 1) ? false : true;
    }

    public final int getCurrentPosition() {
        if (zzrc()) {
            return this.zzddn.getCurrentPosition();
        }
        return 0;
    }

    public final int getDuration() {
        if (zzrc()) {
            return this.zzddn.getDuration();
        }
        return -1;
    }

    public final int getVideoHeight() {
        if (this.zzddn != null) {
            return this.zzddn.getVideoHeight();
        }
        return 0;
    }

    public final int getVideoWidth() {
        if (this.zzddn != null) {
            return this.zzddn.getVideoWidth();
        }
        return 0;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.zzddr = i;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        zzafj.m11v("AdMediaPlayerView completion");
        zzaf(5);
        this.zzddm = 5;
        zzagr.zzczc.post(new zzakm(this));
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzddi.get(Integer.valueOf(i));
        String str2 = zzddi.get(Integer.valueOf(i2));
        zzafj.zzco(new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length()).append("AdMediaPlayerView MediaPlayer error: ").append(str).append(":").append(str2).toString());
        zzaf(-1);
        this.zzddm = -1;
        zzagr.zzczc.post(new zzakn(this, str, str2));
        return true;
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzddi.get(Integer.valueOf(i));
        String str2 = zzddi.get(Integer.valueOf(i2));
        zzafj.m11v(new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length()).append("AdMediaPlayerView MediaPlayer info: ").append(str).append(":").append(str2).toString());
        return true;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.zzddp, i);
        int defaultSize2 = getDefaultSize(this.zzddq, i2);
        if (this.zzddp > 0 && this.zzddq > 0 && this.zzddu == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            defaultSize2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.zzddp * defaultSize2 < this.zzddq * size) {
                    defaultSize = (this.zzddp * defaultSize2) / this.zzddq;
                } else if (this.zzddp * defaultSize2 > this.zzddq * size) {
                    defaultSize2 = (this.zzddq * size) / this.zzddp;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                int i3 = (this.zzddq * size) / this.zzddp;
                if (mode2 != Integer.MIN_VALUE || i3 <= defaultSize2) {
                    defaultSize2 = i3;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.zzddp * defaultSize2) / this.zzddq;
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i4 = this.zzddp;
                int i5 = this.zzddq;
                if (mode2 != Integer.MIN_VALUE || i5 <= defaultSize2) {
                    defaultSize2 = i5;
                    defaultSize = i4;
                } else {
                    defaultSize = (this.zzddp * defaultSize2) / this.zzddq;
                }
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize2 = (this.zzddq * size) / this.zzddp;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        if (this.zzddu != null) {
            this.zzddu.zzh(defaultSize, defaultSize2);
        }
        if (Build.VERSION.SDK_INT == 16) {
            if ((this.zzdds > 0 && this.zzdds != defaultSize) || (this.zzddt > 0 && this.zzddt != defaultSize2)) {
                zzrb();
            }
            this.zzdds = defaultSize;
            this.zzddt = defaultSize2;
        }
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        zzafj.m11v("AdMediaPlayerView prepared");
        zzaf(2);
        this.zzddj.zzrf();
        zzagr.zzczc.post(new zzakl(this));
        this.zzddp = mediaPlayer.getVideoWidth();
        this.zzddq = mediaPlayer.getVideoHeight();
        if (this.zzddw != 0) {
            seekTo(this.zzddw);
        }
        zzrb();
        int i = this.zzddp;
        zzafj.zzcn(new StringBuilder(62).append("AdMediaPlayerView stream dimensions: ").append(i).append(" x ").append(this.zzddq).toString());
        if (this.zzddm == 3) {
            play();
        }
        zzrd();
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzafj.m11v("AdMediaPlayerView surface created");
        zzra();
        zzagr.zzczc.post(new zzako(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzafj.m11v("AdMediaPlayerView surface destroyed");
        if (this.zzddn != null && this.zzddw == 0) {
            this.zzddw = this.zzddn.getCurrentPosition();
        }
        if (this.zzddu != null) {
            this.zzddu.zzrs();
        }
        zzagr.zzczc.post(new zzakq(this));
        zzaa(true);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = true;
        zzafj.m11v("AdMediaPlayerView surface changed");
        boolean z2 = this.zzddm == 3;
        if (!(this.zzddp == i && this.zzddq == i2)) {
            z = false;
        }
        if (this.zzddn != null && z2 && z) {
            if (this.zzddw != 0) {
                seekTo(this.zzddw);
            }
            play();
        }
        if (this.zzddu != null) {
            this.zzddu.zzh(i, i2);
        }
        zzagr.zzczc.post(new zzakp(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzddj.zzb(this);
        this.zzded.zza(surfaceTexture, this.zzddx);
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        zzafj.m11v(new StringBuilder(57).append("AdMediaPlayerView size changed: ").append(i).append(" x ").append(i2).toString());
        this.zzddp = mediaPlayer.getVideoWidth();
        this.zzddq = mediaPlayer.getVideoHeight();
        if (this.zzddp != 0 && this.zzddq != 0) {
            requestLayout();
        }
    }

    public final void pause() {
        zzafj.m11v("AdMediaPlayerView pause");
        if (zzrc() && this.zzddn.isPlaying()) {
            this.zzddn.pause();
            zzaf(4);
            zzagr.zzczc.post(new zzaks(this));
        }
        this.zzddm = 4;
    }

    public final void play() {
        zzafj.m11v("AdMediaPlayerView play");
        if (zzrc()) {
            this.zzddn.start();
            zzaf(3);
            this.zzded.zzrg();
            zzagr.zzczc.post(new zzakr(this));
        }
        this.zzddm = 3;
    }

    public final void seekTo(int i) {
        zzafj.m11v(new StringBuilder(34).append("AdMediaPlayerView seek ").append(i).toString());
        if (zzrc()) {
            this.zzddn.seekTo(i);
            this.zzddw = 0;
            return;
        }
        this.zzddw = i;
    }

    public final void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        zzhu zzd = zzhu.zzd(parse);
        if (zzd != null) {
            parse = Uri.parse(zzd.url);
        }
        this.zzddo = parse;
        this.zzddw = 0;
        zzra();
        requestLayout();
        invalidate();
    }

    public final void stop() {
        zzafj.m11v("AdMediaPlayerView stop");
        if (this.zzddn != null) {
            this.zzddn.stop();
            this.zzddn.release();
            this.zzddn = null;
            zzaf(0);
            this.zzddm = 0;
        }
        this.zzddj.onStop();
    }

    public final String toString() {
        String name = getClass().getName();
        String hexString = Integer.toHexString(hashCode());
        return new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length()).append(name).append("@").append(hexString).toString();
    }

    public final void zza(float f, float f2) {
        if (this.zzddu != null) {
            this.zzddu.zzb(f, f2);
        }
    }

    public final void zza(zzakt zzakt) {
        this.zzddx = zzakt;
    }

    public final String zzqz() {
        String valueOf = String.valueOf(this.zzddv ? " spherical" : "");
        return valueOf.length() != 0 ? "MediaPlayer".concat(valueOf) : new String("MediaPlayer");
    }

    public final void zzrd() {
        zza(this.zzdee.getVolume());
    }
}
