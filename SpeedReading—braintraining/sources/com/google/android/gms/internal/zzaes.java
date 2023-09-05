package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

final class zzaes implements Runnable {
    private /* synthetic */ Context val$context;
    private /* synthetic */ zzajy zzcvp;

    zzaes(zzaer zzaer, Context context, zzajy zzajy) {
        this.val$context = context;
        this.zzcvp = zzajy;
    }

    public final void run() {
        try {
            this.zzcvp.set(AdvertisingIdClient.getAdvertisingIdInfo(this.val$context));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            this.zzcvp.setException(e);
            zzaiw.zzb("Exception while getting advertising Id info", e);
        }
    }
}
