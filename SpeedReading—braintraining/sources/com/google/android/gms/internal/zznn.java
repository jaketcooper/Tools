package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsCallback;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import java.util.List;

@zzzb
public final class zznn implements zzfln {
    @Nullable
    private CustomTabsSession zzbrd;
    @Nullable
    private CustomTabsClient zzbre;
    @Nullable
    private CustomTabsServiceConnection zzbrf;
    @Nullable
    private zzno zzbrg;

    public static boolean zzi(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (queryIntentActivities == null || resolveActivity == null) {
            return false;
        }
        for (int i = 0; i < queryIntentActivities.size(); i++) {
            if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i).activityInfo.name)) {
                return resolveActivity.activityInfo.packageName.equals(zzfll.zzfh(context));
            }
        }
        return false;
    }

    public final boolean mayLaunchUrl(Uri uri, Bundle bundle, List<Bundle> list) {
        if (this.zzbre == null) {
            return false;
        }
        if (this.zzbre == null) {
            this.zzbrd = null;
        } else if (this.zzbrd == null) {
            this.zzbrd = this.zzbre.newSession((CustomTabsCallback) null);
        }
        CustomTabsSession customTabsSession = this.zzbrd;
        if (customTabsSession != null) {
            return customTabsSession.mayLaunchUrl(uri, (Bundle) null, (List) null);
        }
        return false;
    }

    public final void zza(CustomTabsClient customTabsClient) {
        this.zzbre = customTabsClient;
        this.zzbre.warmup(0);
        if (this.zzbrg != null) {
            this.zzbrg.zzjf();
        }
    }

    public final void zza(zzno zzno) {
        this.zzbrg = zzno;
    }

    public final void zzc(Activity activity) {
        if (this.zzbrf != null) {
            activity.unbindService(this.zzbrf);
            this.zzbre = null;
            this.zzbrd = null;
            this.zzbrf = null;
        }
    }

    public final void zzd(Activity activity) {
        String zzfh;
        if (this.zzbre == null && (zzfh = zzfll.zzfh(activity)) != null) {
            this.zzbrf = new zzflm(this);
            CustomTabsClient.bindCustomTabsService(activity, zzfh, this.zzbrf);
        }
    }

    public final void zzje() {
        this.zzbre = null;
        this.zzbrd = null;
    }
}
