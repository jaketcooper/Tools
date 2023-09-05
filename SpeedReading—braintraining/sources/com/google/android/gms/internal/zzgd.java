package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

final class zzgd implements Application.ActivityLifecycleCallbacks {
    private final Application zzawl;
    private final WeakReference<Application.ActivityLifecycleCallbacks> zzaxf;
    private boolean zzaxg = false;

    public zzgd(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzaxf = new WeakReference<>(activityLifecycleCallbacks);
        this.zzawl = application;
    }

    private final void zza(zzgl zzgl) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.zzaxf.get();
            if (activityLifecycleCallbacks != null) {
                zzgl.zza(activityLifecycleCallbacks);
            } else if (!this.zzaxg) {
                this.zzawl.unregisterActivityLifecycleCallbacks(this);
                this.zzaxg = true;
            }
        } catch (Exception e) {
            zzafj.zzb("Error while dispatching lifecycle callback.", e);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzge(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzgk(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzgh(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzgg(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzgj(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzgf(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzgi(this, activity));
    }
}
