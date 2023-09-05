package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

@zzzb
public final class zzano extends MutableContextWrapper {
    private Context mApplicationContext;
    private Activity zzdbn;
    private Context zzdku;

    public zzano(Context context) {
        super(context);
        setBaseContext(context);
    }

    public final Object getSystemService(String str) {
        return this.zzdku.getSystemService(str);
    }

    public final void setBaseContext(Context context) {
        this.mApplicationContext = context.getApplicationContext();
        this.zzdbn = context instanceof Activity ? (Activity) context : null;
        this.zzdku = context;
        super.setBaseContext(this.mApplicationContext);
    }

    public final void startActivity(Intent intent) {
        if (this.zzdbn != null) {
            this.zzdbn.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.mApplicationContext.startActivity(intent);
    }

    public final Activity zzrz() {
        return this.zzdbn;
    }

    public final Context zzsl() {
        return this.zzdku;
    }
}
