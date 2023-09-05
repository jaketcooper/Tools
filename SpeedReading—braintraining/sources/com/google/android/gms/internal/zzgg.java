package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;

final class zzgg implements zzgl {
    private /* synthetic */ Activity val$activity;

    zzgg(zzgd zzgd, Activity activity) {
        this.val$activity = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityResumed(this.val$activity);
    }
}
