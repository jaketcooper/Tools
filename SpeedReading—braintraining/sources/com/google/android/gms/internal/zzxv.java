package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.common.util.zzq;
import java.io.InputStream;

final class zzxv implements zzaie<zznr> {
    private /* synthetic */ String zzcfm;
    private /* synthetic */ zzxr zzciz;
    private /* synthetic */ boolean zzcjj;
    private /* synthetic */ double zzcjk;
    private /* synthetic */ boolean zzcjl;

    zzxv(zzxr zzxr, boolean z, double d, boolean z2, String str) {
        this.zzciz = zzxr;
        this.zzcjj = z;
        this.zzcjk = d;
        this.zzcjl = z2;
        this.zzcfm = str;
    }

    /* access modifiers changed from: private */
    @TargetApi(19)
    /* renamed from: zzd */
    public final zznr zze(InputStream inputStream) {
        Bitmap bitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = (int) (160.0d * this.zzcjk);
        if (!this.zzcjl) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            bitmap = BitmapFactory.decodeStream(inputStream, (Rect) null, options);
        } catch (Exception e) {
            zzafj.zzb("Error grabbing image.", e);
            bitmap = null;
        }
        if (bitmap == null) {
            this.zzciz.zzd(2, this.zzcjj);
            return null;
        }
        long uptimeMillis2 = SystemClock.uptimeMillis();
        if (zzq.zzama() && zzafj.zzpt()) {
            int width = bitmap.getWidth();
            zzafj.m11v(new StringBuilder(108).append("Decoded image w: ").append(width).append(" h:").append(bitmap.getHeight()).append(" bytes: ").append(bitmap.getAllocationByteCount()).append(" time: ").append(uptimeMillis2 - uptimeMillis).append(" on ui thread: ").append(Looper.getMainLooper().getThread() == Thread.currentThread()).toString());
        }
        return new zznr(new BitmapDrawable(Resources.getSystem(), bitmap), Uri.parse(this.zzcfm), this.zzcjk);
    }

    public final /* synthetic */ Object zznc() {
        this.zzciz.zzd(2, this.zzcjj);
        return null;
    }
}
