package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

final class zzgj implements zzgl {
    private /* synthetic */ Activity val$activity;
    private /* synthetic */ Bundle zzaxh;

    zzgj(zzgd zzgd, Activity activity, Bundle bundle) {
        this.val$activity = activity;
        this.zzaxh = bundle;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.val$activity, this.zzaxh);
    }
}
