package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ViewSwitcher;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzahj;
import com.google.android.gms.internal.zzair;
import com.google.android.gms.internal.zzama;
import java.util.ArrayList;

public final class zzbu extends ViewSwitcher {
    private final zzahj zzaum;
    @Nullable
    private final zzair zzaun;
    private boolean zzauo = true;

    public zzbu(Context context, String str, String str2, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        super(context);
        this.zzaum = new zzahj(context);
        this.zzaum.setAdUnitId(str);
        this.zzaum.zzci(str2);
        if (context instanceof Activity) {
            this.zzaun = new zzair((Activity) context, this, onGlobalLayoutListener, onScrollChangedListener);
        } else {
            this.zzaun = new zzair((Activity) null, this, onGlobalLayoutListener, onScrollChangedListener);
        }
        this.zzaun.zzqo();
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.zzaun != null) {
            this.zzaun.onAttachedToWindow();
        }
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.zzaun != null) {
            this.zzaun.onDetachedFromWindow();
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.zzauo) {
            return false;
        }
        this.zzaum.zze(motionEvent);
        return false;
    }

    public final void removeAllViews() {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && (childAt instanceof zzama)) {
                arrayList.add((zzama) childAt);
            }
        }
        super.removeAllViews();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ((zzama) obj).destroy();
        }
    }

    public final zzahj zzfj() {
        return this.zzaum;
    }

    public final void zzfk() {
        zzafj.m11v("Disable position monitoring on adFrame.");
        if (this.zzaun != null) {
            this.zzaun.zzqp();
        }
    }

    public final void zzfl() {
        zzafj.m11v("Enable debug gesture detector on adFrame.");
        this.zzauo = true;
    }

    public final void zzfm() {
        zzafj.m11v("Disable debug gesture detector on adFrame.");
        this.zzauo = false;
    }
}
