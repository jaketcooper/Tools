package com.google.android.gms.internal;

import android.content.ComponentName;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

public final class zzflm extends CustomTabsServiceConnection {
    private WeakReference<zzfln> zzqvz;

    public zzflm(zzfln zzfln) {
        this.zzqvz = new WeakReference<>(zzfln);
    }

    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzfln zzfln = (zzfln) this.zzqvz.get();
        if (zzfln != null) {
            zzfln.zza(customTabsClient);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zzfln zzfln = (zzfln) this.zzqvz.get();
        if (zzfln != null) {
            zzfln.zzje();
        }
    }
}
