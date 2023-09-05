package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class zzfll {
    private static String zzqvy;

    public static String zzfh(Context context) {
        if (zzqvy != null) {
            return zzqvy;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        String str = resolveActivity != null ? resolveActivity.activityInfo.packageName : null;
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo next : queryIntentActivities) {
            Intent intent2 = new Intent();
            intent2.setAction("android.support.customtabs.action.CustomTabsService");
            intent2.setPackage(next.activityInfo.packageName);
            if (packageManager.resolveService(intent2, 0) != null) {
                arrayList.add(next.activityInfo.packageName);
            }
        }
        if (arrayList.isEmpty()) {
            zzqvy = null;
        } else if (arrayList.size() == 1) {
            zzqvy = (String) arrayList.get(0);
        } else if (!TextUtils.isEmpty(str) && !zzi(context, intent) && arrayList.contains(str)) {
            zzqvy = str;
        } else if (arrayList.contains("com.android.chrome")) {
            zzqvy = "com.android.chrome";
        } else if (arrayList.contains("com.chrome.beta")) {
            zzqvy = "com.chrome.beta";
        } else if (arrayList.contains("com.chrome.dev")) {
            zzqvy = "com.chrome.dev";
        } else if (arrayList.contains("com.google.android.apps.chrome")) {
            zzqvy = "com.google.android.apps.chrome";
        }
        return zzqvy;
    }

    private static boolean zzi(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
            if (queryIntentActivities == null || queryIntentActivities.size() == 0) {
                return false;
            }
            for (ResolveInfo next : queryIntentActivities) {
                IntentFilter intentFilter = next.filter;
                if (intentFilter != null && intentFilter.countDataAuthorities() != 0 && intentFilter.countDataPaths() != 0 && next.activityInfo != null) {
                    return true;
                }
            }
            return false;
        } catch (RuntimeException e) {
            Log.e("CustomTabsHelper", "Runtime exception while getting specialized handlers");
        }
    }
}
