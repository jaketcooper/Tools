package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;

final class zzgk implements zzgl {
    private /* synthetic */ Activity val$activity;

    zzgk(zzgd zzgd, Activity activity) {
        this.val$activity = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.val$activity);
    }
}
