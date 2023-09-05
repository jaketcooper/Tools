package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.p000v4.app.FragmentActivity;
import com.google.android.gms.common.internal.zzbq;

public final class zzch {
    private final Object zzfrs;

    public zzch(Activity activity) {
        zzbq.checkNotNull(activity, "Activity must not be null");
        this.zzfrs = activity;
    }

    public final boolean zzaiy() {
        return this.zzfrs instanceof FragmentActivity;
    }

    public final boolean zzaiz() {
        return this.zzfrs instanceof Activity;
    }

    public final Activity zzaja() {
        return (Activity) this.zzfrs;
    }

    public final FragmentActivity zzajb() {
        return (FragmentActivity) this.zzfrs;
    }
}
