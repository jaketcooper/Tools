package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

@zzzb
@TargetApi(19)
public final class zzxk extends zzxh {
    private Object zzcie = new Object();
    private PopupWindow zzcif;
    private boolean zzcig = false;

    zzxk(Context context, zzaev zzaev, zzama zzama, zzxg zzxg) {
        super(context, zzaev, zzama, zzxg);
    }

    private final void zzmz() {
        synchronized (this.zzcie) {
            this.zzcig = true;
            if ((this.mContext instanceof Activity) && ((Activity) this.mContext).isDestroyed()) {
                this.zzcif = null;
            }
            if (this.zzcif != null) {
                if (this.zzcif.isShowing()) {
                    this.zzcif.dismiss();
                }
                this.zzcif = null;
            }
        }
    }

    public final void cancel() {
        zzmz();
        super.cancel();
    }

    /* access modifiers changed from: protected */
    public final void zzmy() {
        Window window = this.mContext instanceof Activity ? ((Activity) this.mContext).getWindow() : null;
        if (window != null && window.getDecorView() != null && !((Activity) this.mContext).isDestroyed()) {
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            zzama zzama = this.zzbwq;
            if (zzama == null) {
                throw null;
            }
            frameLayout.addView((View) zzama, -1, -1);
            synchronized (this.zzcie) {
                if (!this.zzcig) {
                    this.zzcif = new PopupWindow(frameLayout, 1, 1, false);
                    this.zzcif.setOutsideTouchable(true);
                    this.zzcif.setClippingEnabled(false);
                    zzafj.zzbw("Displaying the 1x1 popup off the screen.");
                    try {
                        this.zzcif.showAtLocation(window.getDecorView(), 0, -1, -1);
                    } catch (Exception e) {
                        this.zzcif = null;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzx(int i) {
        zzmz();
        super.zzx(i);
    }
}
