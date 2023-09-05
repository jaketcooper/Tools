package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import java.util.WeakHashMap;

@zzzb
public final class zzyu extends zzyv {
    private static final Object sLock = new Object();
    private static zzyz zzckp = null;
    private final Context mContext;
    private final String mPackageName;
    private final Object zzckq = new Object();
    private final WeakHashMap<Thread, Boolean> zzckr = new WeakHashMap<>();

    private zzyu(Context context, String str, zzaiy zzaiy) {
        super(context);
        this.mContext = context;
        this.mPackageName = str;
    }

    public static zzyz zzc(Context context, zzaiy zzaiy) {
        String packageName;
        synchronized (sLock) {
            if (zzckp == null) {
                if (((Boolean) zzbs.zzep().zzd(zzmq.zzbgd)).booleanValue()) {
                    try {
                        packageName = context.getApplicationContext().getPackageName();
                    } catch (Throwable th) {
                        zzafj.zzco("Cannot obtain package name, proceeding.");
                    }
                    zzckp = new zzyu(context.getApplicationContext(), packageName, zzaiy);
                } else {
                    zzckp = new zzza();
                }
            }
        }
        return zzckp;
    }

    /* access modifiers changed from: protected */
    public final Uri.Builder zza(String str, String str2, String str3, int i) {
        Uri.Builder zza = super.zza(str, str2, str3, i);
        zza.appendQueryParameter("eids", TextUtils.join(",", zzmq.zziq()));
        zza.appendQueryParameter("pb_tm", String.valueOf(zzbs.zzep().zzd(zzmq.zzbpz)));
        return zza;
    }
}
