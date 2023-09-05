package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.internal.zzbq;

@zzzb
public final class zzmc {
    private final Context mContext;

    public zzmc(Context context) {
        zzbq.checkNotNull(context, "Context can not be null");
        this.mContext = context;
    }

    private final boolean zza(Intent intent) {
        zzbq.checkNotNull(intent, "Intent can not be null");
        return !this.mContext.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    public final boolean zzil() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return zza(intent);
    }

    public final boolean zzim() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return zza(intent);
    }

    public final boolean zzin() {
        return ((Boolean) zzain.zza(this.mContext, new zzmd())).booleanValue() && zzbgc.zzcy(this.mContext).checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(14)
    public final boolean zzio() {
        return zza(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }
}
