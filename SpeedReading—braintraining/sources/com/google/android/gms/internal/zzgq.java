package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
final class zzgq implements Application.ActivityLifecycleCallbacks {
    @Nullable
    private Activity mActivity;
    private Context mContext;
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    private boolean zzaqh = false;
    /* access modifiers changed from: private */
    public boolean zzayc = true;
    /* access modifiers changed from: private */
    public boolean zzayd = false;
    /* access modifiers changed from: private */
    public final List<zzgs> zzaye = new ArrayList();
    private final List<zzhf> zzayf = new ArrayList();
    private Runnable zzayg;
    private long zzayh;

    zzgq() {
    }

    private final void setActivity(Activity activity) {
        synchronized (this.mLock) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.mActivity = activity;
            }
        }
    }

    @Nullable
    public final Activity getActivity() {
        return this.mActivity;
    }

    @Nullable
    public final Context getContext() {
        return this.mContext;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityDestroyed(android.app.Activity r6) {
        /*
            r5 = this;
            java.lang.Object r1 = r5.mLock
            monitor-enter(r1)
            android.app.Activity r0 = r5.mActivity     // Catch:{ all -> 0x0040 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r1)     // Catch:{ all -> 0x0040 }
        L_0x0008:
            return
        L_0x0009:
            android.app.Activity r0 = r5.mActivity     // Catch:{ all -> 0x0040 }
            boolean r0 = r0.equals(r6)     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x0014
            r0 = 0
            r5.mActivity = r0     // Catch:{ all -> 0x0040 }
        L_0x0014:
            java.util.List<com.google.android.gms.internal.zzhf> r0 = r5.zzayf     // Catch:{ all -> 0x0040 }
            java.util.Iterator r2 = r0.iterator()     // Catch:{ all -> 0x0040 }
        L_0x001a:
            boolean r0 = r2.hasNext()     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x0043
            java.lang.Object r0 = r2.next()     // Catch:{ all -> 0x0040 }
            com.google.android.gms.internal.zzhf r0 = (com.google.android.gms.internal.zzhf) r0     // Catch:{ all -> 0x0040 }
            boolean r0 = r0.zza(r6)     // Catch:{ Exception -> 0x0030 }
            if (r0 == 0) goto L_0x001a
            r2.remove()     // Catch:{ Exception -> 0x0030 }
            goto L_0x001a
        L_0x0030:
            r0 = move-exception
            com.google.android.gms.internal.zzaez r3 = com.google.android.gms.ads.internal.zzbs.zzeg()     // Catch:{ all -> 0x0040 }
            java.lang.String r4 = "AppActivityTracker.ActivityListener.onActivityDestroyed"
            r3.zza((java.lang.Throwable) r0, (java.lang.String) r4)     // Catch:{ all -> 0x0040 }
            java.lang.String r3 = "onActivityStateChangedListener threw exception."
            com.google.android.gms.internal.zzafj.zzb(r3, r0)     // Catch:{ all -> 0x0040 }
            goto L_0x001a
        L_0x0040:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0040 }
            throw r0
        L_0x0043:
            monitor-exit(r1)     // Catch:{ all -> 0x0040 }
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgq.onActivityDestroyed(android.app.Activity):void");
    }

    public final void onActivityPaused(Activity activity) {
        setActivity(activity);
        synchronized (this.mLock) {
            Iterator<zzhf> it = this.zzayf.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        this.zzayd = true;
        if (this.zzayg != null) {
            zzagr.zzczc.removeCallbacks(this.zzayg);
        }
        Handler handler = zzagr.zzczc;
        zzgr zzgr = new zzgr(this);
        this.zzayg = zzgr;
        handler.postDelayed(zzgr, this.zzayh);
    }

    public final void onActivityResumed(Activity activity) {
        boolean z = false;
        setActivity(activity);
        this.zzayd = false;
        if (!this.zzayc) {
            z = true;
        }
        this.zzayc = true;
        if (this.zzayg != null) {
            zzagr.zzczc.removeCallbacks(this.zzayg);
        }
        synchronized (this.mLock) {
            Iterator<zzhf> it = this.zzayf.iterator();
            while (it.hasNext()) {
                it.next();
            }
            if (z) {
                for (zzgs zzg : this.zzaye) {
                    try {
                        zzg.zzg(true);
                    } catch (Exception e) {
                        zzafj.zzb("OnForegroundStateChangedListener threw exception.", e);
                    }
                }
            } else {
                zzafj.zzbw("App is still foreground.");
            }
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        setActivity(activity);
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void zza(Application application, Context context) {
        if (!this.zzaqh) {
            application.registerActivityLifecycleCallbacks(this);
            if (context instanceof Activity) {
                setActivity((Activity) context);
            }
            this.mContext = application;
            this.zzayh = ((Long) zzbs.zzep().zzd(zzmq.zzbjr)).longValue();
            this.zzaqh = true;
        }
    }

    public final void zza(zzgs zzgs) {
        synchronized (this.mLock) {
            this.zzaye.add(zzgs);
        }
    }
}
