package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;

@zzzb
@TargetApi(14)
public abstract class zzaku extends TextureView implements zzalm {
    protected final zzalb zzded = new zzalb();
    protected final zzall zzdee;

    public zzaku(Context context) {
        super(context);
        this.zzdee = new zzall(context, this);
    }

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void pause();

    public abstract void play();

    public abstract void seekTo(int i);

    public abstract void setVideoPath(String str);

    public abstract void stop();

    public abstract void zza(float f, float f2);

    public abstract void zza(zzakt zzakt);

    public abstract String zzqz();

    public abstract void zzrd();
}
