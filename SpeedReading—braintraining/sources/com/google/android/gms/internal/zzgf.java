package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;

final class zzgf implements zzgl {
    private /* synthetic */ Activity val$activity;

    zzgf(zzgd zzgd, Activity activity) {
        this.val$activity = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.val$activity);
    }
}
