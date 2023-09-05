package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;

final class zzgh implements zzgl {
    private /* synthetic */ Activity val$activity;

    zzgh(zzgd zzgd, Activity activity) {
        this.val$activity = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.val$activity);
    }
}
