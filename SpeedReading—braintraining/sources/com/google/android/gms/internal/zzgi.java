package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;

final class zzgi implements zzgl {
    private /* synthetic */ Activity val$activity;

    zzgi(zzgd zzgd, Activity activity) {
        this.val$activity = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStopped(this.val$activity);
    }
}
