package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class zzk {
    private static zzk zznuu;
    /* access modifiers changed from: private */
    public final Context zzaif;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zznuv;
    private zzm zznuw = new zzm(this);
    private int zznux = 1;

    @VisibleForTesting
    private zzk(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zznuv = scheduledExecutorService;
        this.zzaif = context.getApplicationContext();
    }

    private final synchronized <T> Task<T> zza(zzt<T> zzt) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(zzt);
            Log.d("MessengerIpcClient", new StringBuilder(String.valueOf(valueOf).length() + 9).append("Queueing ").append(valueOf).toString());
        }
        if (!this.zznuw.zzb(zzt)) {
            this.zznuw = new zzm(this);
            this.zznuw.zzb(zzt);
        }
        return zzt.zzgpg.getTask();
    }

    private final synchronized int zzchh() {
        int i;
        i = this.zznux;
        this.zznux = i + 1;
        return i;
    }

    public static synchronized zzk zzet(Context context) {
        zzk zzk;
        synchronized (zzk.class) {
            if (zznuu == null) {
                zznuu = new zzk(context, Executors.newSingleThreadScheduledExecutor());
            }
            zzk = zznuu;
        }
        return zzk;
    }

    public final Task<Void> zzh(int i, Bundle bundle) {
        return zza(new zzs(zzchh(), 2, bundle));
    }

    public final Task<Bundle> zzi(int i, Bundle bundle) {
        return zza(new zzv(zzchh(), 1, bundle));
    }
}
