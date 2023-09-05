package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;

@zzzb
public final class zziy extends zzkh {
    private final AppEventListener zzalu;

    public zziy(AppEventListener appEventListener) {
        this.zzalu = appEventListener;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzalu;
    }

    public final void onAppEvent(String str, String str2) {
        this.zzalu.onAppEvent(str, str2);
    }
}
