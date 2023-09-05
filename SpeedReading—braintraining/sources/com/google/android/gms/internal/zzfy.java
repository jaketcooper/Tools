package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzbs;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

@zzzb
@TargetApi(14)
public final class zzfy implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final long zzawk = ((Long) zzbs.zzep().zzd(zzmq.zzbkz)).longValue();
    private final Context mApplicationContext;
    private zzail zzaui = new zzail(zzawk);
    private final WindowManager zzavc;
    private final PowerManager zzavd;
    private final KeyguardManager zzave;
    private boolean zzavl = false;
    @Nullable
    private BroadcastReceiver zzavm;
    private Application zzawl;
    private WeakReference<ViewTreeObserver> zzawm;
    private WeakReference<View> zzawn;
    private zzgd zzawo;
    private int zzawp = -1;
    private HashSet<zzgc> zzawq = new HashSet<>();
    private DisplayMetrics zzawr;

    public zzfy(Context context, View view) {
        this.mApplicationContext = context.getApplicationContext();
        this.zzavc = (WindowManager) context.getSystemService("window");
        this.zzavd = (PowerManager) this.mApplicationContext.getSystemService("power");
        this.zzave = (KeyguardManager) context.getSystemService("keyguard");
        if (this.mApplicationContext instanceof Application) {
            this.zzawl = (Application) this.mApplicationContext;
            this.zzawo = new zzgd((Application) this.mApplicationContext, this);
        }
        this.zzawr = context.getResources().getDisplayMetrics();
        View view2 = this.zzawn != null ? (View) this.zzawn.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zze(view2);
        }
        this.zzawn = new WeakReference<>(view);
        if (view != null) {
            if (zzbs.zzee().isAttachedToWindow(view)) {
                zzd(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    private final Rect zza(Rect rect) {
        return new Rect(zzn(rect.left), zzn(rect.top), zzn(rect.right), zzn(rect.bottom));
    }

    private final void zza(Activity activity, int i) {
        Window window;
        if (this.zzawn != null && (window = activity.getWindow()) != null) {
            View peekDecorView = window.peekDecorView();
            View view = (View) this.zzawn.get();
            if (view != null && peekDecorView != null && view.getRootView() == peekDecorView.getRootView()) {
                this.zzawp = i;
            }
        }
    }

    private final void zzd(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzawm = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzavm == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzavm = new zzga(this);
            this.mApplicationContext.registerReceiver(this.zzavm, intentFilter);
        }
        if (this.zzawl != null) {
            try {
                this.zzawl.registerActivityLifecycleCallbacks(this.zzawo);
            } catch (Exception e) {
                zzafj.zzb("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private final void zze(View view) {
        try {
            if (this.zzawm != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.zzawm.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzawm = null;
            }
        } catch (Exception e) {
            zzafj.zzb("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
            zzafj.zzb("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.zzavm != null) {
            try {
                this.mApplicationContext.unregisterReceiver(this.zzavm);
            } catch (IllegalStateException e3) {
                zzafj.zzb("Failed trying to unregister the receiver", e3);
            } catch (Exception e4) {
                zzbs.zzeg().zza((Throwable) e4, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zzavm = null;
        }
        if (this.zzawl != null) {
            try {
                this.zzawl.unregisterActivityLifecycleCallbacks(this.zzawo);
            } catch (Exception e5) {
                zzafj.zzb("Error registering activity lifecycle callbacks.", e5);
            }
        }
    }

    private final void zzge() {
        zzbs.zzec();
        zzagr.zzczc.post(new zzfz(this));
    }

    /* access modifiers changed from: private */
    public final void zzm(int i) {
        if (this.zzawq.size() != 0 && this.zzawn != null) {
            View view = (View) this.zzawn.get();
            boolean z = i == 1;
            boolean z2 = view == null;
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            boolean z3 = false;
            Rect rect3 = new Rect();
            boolean z4 = false;
            Rect rect4 = new Rect();
            Rect rect5 = new Rect();
            rect5.right = this.zzavc.getDefaultDisplay().getWidth();
            rect5.bottom = this.zzavc.getDefaultDisplay().getHeight();
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            if (view != null) {
                z3 = view.getGlobalVisibleRect(rect2);
                z4 = view.getLocalVisibleRect(rect3);
                view.getHitRect(rect4);
                try {
                    view.getLocationOnScreen(iArr);
                    view.getLocationInWindow(iArr2);
                } catch (Exception e) {
                    zzafj.zzb("Failure getting view location.", e);
                }
                rect.left = iArr[0];
                rect.top = iArr[1];
                rect.right = rect.left + view.getWidth();
                rect.bottom = rect.top + view.getHeight();
            }
            int windowVisibility = view != null ? view.getWindowVisibility() : 8;
            if (this.zzawp != -1) {
                windowVisibility = this.zzawp;
            }
            boolean z5 = !z2 && zzbs.zzec().zza(view, this.zzavd, this.zzave) && z3 && z4 && windowVisibility == 0;
            if (z && !this.zzaui.tryAcquire() && z5 == this.zzavl) {
                return;
            }
            if (z5 || this.zzavl || i != 1) {
                zzgb zzgb = new zzgb(zzbs.zzei().elapsedRealtime(), this.zzavd.isScreenOn(), view != null ? zzbs.zzee().isAttachedToWindow(view) : false, view != null ? view.getWindowVisibility() : 8, zza(rect5), zza(rect), zza(rect2), z3, zza(rect3), z4, zza(rect4), this.zzawr.density, z5);
                Iterator<zzgc> it = this.zzawq.iterator();
                while (it.hasNext()) {
                    it.next().zza(zzgb);
                }
                this.zzavl = z5;
            }
        }
    }

    private final int zzn(int i) {
        return (int) (((float) i) / this.zzawr.density);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzm(3);
        zzge();
    }

    public final void onActivityDestroyed(Activity activity) {
        zzm(3);
        zzge();
    }

    public final void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzm(3);
        zzge();
    }

    public final void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzm(3);
        zzge();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzm(3);
        zzge();
    }

    public final void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzm(3);
        zzge();
    }

    public final void onActivityStopped(Activity activity) {
        zzm(3);
        zzge();
    }

    public final void onGlobalLayout() {
        zzm(2);
        zzge();
    }

    public final void onScrollChanged() {
        zzm(1);
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzawp = -1;
        zzd(view);
        zzm(3);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zzawp = -1;
        zzm(3);
        zzge();
        zze(view);
    }

    public final void zza(zzgc zzgc) {
        this.zzawq.add(zzgc);
        zzm(3);
    }

    public final void zzb(zzgc zzgc) {
        this.zzawq.remove(zzgc);
    }

    public final void zzgf() {
        zzm(4);
    }
}
