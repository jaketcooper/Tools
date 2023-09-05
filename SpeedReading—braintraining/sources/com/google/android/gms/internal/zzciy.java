package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.text.TextUtils;
import com.safonov.speedreading.application.realm.IdentityRealmObject;

@TargetApi(14)
@MainThread
final class zzciy implements Application.ActivityLifecycleCallbacks {
    private /* synthetic */ zzcik zzjer;

    private zzciy(zzcik zzcik) {
        this.zzjer = zzcik;
    }

    /* synthetic */ zzciy(zzcik zzcik, zzcil zzcil) {
        this(zzcik);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Bundle bundle2;
        Uri data;
        try {
            this.zzjer.zzawn().zzayy().log("onActivityCreated");
            Intent intent = activity.getIntent();
            if (!(intent == null || (data = intent.getData()) == null || !data.isHierarchical())) {
                if (bundle == null) {
                    Bundle zzp = this.zzjer.zzawj().zzp(data);
                    this.zzjer.zzawj();
                    String str = zzckn.zzo(intent) ? "gs" : "auto";
                    if (zzp != null) {
                        this.zzjer.zzc(str, "_cmp", zzp);
                    }
                }
                String queryParameter = data.getQueryParameter("referrer");
                if (!TextUtils.isEmpty(queryParameter)) {
                    if (!(queryParameter.contains("gclid") && (queryParameter.contains("utm_campaign") || queryParameter.contains("utm_source") || queryParameter.contains("utm_medium") || queryParameter.contains("utm_term") || queryParameter.contains("utm_content")))) {
                        this.zzjer.zzawn().zzayx().log("Activity created with data 'referrer' param without gclid and at least one utm field");
                        return;
                    }
                    this.zzjer.zzawn().zzayx().zzj("Activity created with referrer", queryParameter);
                    if (!TextUtils.isEmpty(queryParameter)) {
                        this.zzjer.zzb("auto", "_ldl", queryParameter);
                    }
                } else {
                    return;
                }
            }
        } catch (Throwable th) {
            this.zzjer.zzawn().zzays().zzj("Throwable caught in onActivityCreated", th);
        }
        zzciz zzawf = this.zzjer.zzawf();
        if (bundle != null && (bundle2 = bundle.getBundle("com.google.firebase.analytics.screen_service")) != null) {
            zzcjc zzq = zzawf.zzq(activity);
            zzq.zziub = bundle2.getLong(IdentityRealmObject.FIELD_ID);
            zzq.zzitz = bundle2.getString("name");
            zzq.zziua = bundle2.getString("referrer_name");
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zzjer.zzawf().onActivityDestroyed(activity);
    }

    @MainThread
    public final void onActivityPaused(Activity activity) {
        this.zzjer.zzawf().onActivityPaused(activity);
        zzckc zzawl = this.zzjer.zzawl();
        zzawl.zzawm().zzg(new zzckg(zzawl, zzawl.zzwh().elapsedRealtime()));
    }

    @MainThread
    public final void onActivityResumed(Activity activity) {
        this.zzjer.zzawf().onActivityResumed(activity);
        zzckc zzawl = this.zzjer.zzawl();
        zzawl.zzawm().zzg(new zzckf(zzawl, zzawl.zzwh().elapsedRealtime()));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zzjer.zzawf().onActivitySaveInstanceState(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
