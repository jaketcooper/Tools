package com.google.android.gms.ads.internal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zziw;
import com.google.android.gms.internal.zzzb;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

@zzzb
public final class zzp {
    private static String bundleToString(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            sb.append(obj == null ? "null" : obj instanceof Bundle ? bundleToString((Bundle) obj) : obj.toString());
        }
        return sb.toString();
    }

    public static Object[] zza(String str, zzis zzis, String str2, int i, @Nullable zziw zziw) {
        HashSet hashSet = new HashSet(Arrays.asList(str.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        if (hashSet.contains("formatString")) {
            arrayList.add((Object) null);
        }
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(zzis.zzbbv));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(bundleToString(zzis.extras));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(zzis.zzbbw));
        }
        if (hashSet.contains("keywords")) {
            if (zzis.zzbbx != null) {
                arrayList.add(zzis.zzbbx.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(zzis.zzbby));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(zzis.zzbbz));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(zzis.zzbca));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(zzis.zzbcb);
        }
        if (hashSet.contains(FirebaseAnalytics.Param.LOCATION)) {
            if (zzis.zzbcd != null) {
                arrayList.add(zzis.zzbcd.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(zzis.zzbce);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(bundleToString(zzis.zzbcf));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(bundleToString(zzis.zzbcg));
        }
        if (hashSet.contains("categoryExclusions")) {
            if (zzis.zzbch != null) {
                arrayList.add(zzis.zzbch.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(zzis.zzbci);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(zzis.zzbcj);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(zzis.zzbck));
        }
        return arrayList.toArray();
    }
}
