package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.util.zzq;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzk implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final zzk zzflv = new zzk();
    private boolean zzdqd = false;
    private final AtomicBoolean zzflw = new AtomicBoolean();
    private final AtomicBoolean zzflx = new AtomicBoolean();
    private final ArrayList<zzl> zzfly = new ArrayList<>();

    private zzk() {
    }

    public static void zza(Application application) {
        synchronized (zzflv) {
            if (!zzflv.zzdqd) {
                application.registerActivityLifecycleCallbacks(zzflv);
                application.registerComponentCallbacks(zzflv);
                zzflv.zzdqd = true;
            }
        }
    }

    public static zzk zzagq() {
        return zzflv;
    }

    private final void zzbe(boolean z) {
        synchronized (zzflv) {
            ArrayList arrayList = this.zzfly;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((zzl) obj).zzbe(z);
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.zzflw.compareAndSet(true, false);
        this.zzflx.set(true);
        if (compareAndSet) {
            zzbe(false);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.zzflw.compareAndSet(true, false);
        this.zzflx.set(true);
        if (compareAndSet) {
            zzbe(false);
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i) {
        if (i == 20 && this.zzflw.compareAndSet(false, true)) {
            this.zzflx.set(true);
            zzbe(true);
        }
    }

    public final void zza(zzl zzl) {
        synchronized (zzflv) {
            this.zzfly.add(zzl);
        }
    }

    public final boolean zzagr() {
        return this.zzflw.get();
    }

    @TargetApi(16)
    public final boolean zzbd(boolean z) {
        if (!this.zzflx.get()) {
            if (!zzq.zzalx()) {
                return true;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.zzflx.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.zzflw.set(true);
            }
        }
        return this.zzflw.get();
    }
}
