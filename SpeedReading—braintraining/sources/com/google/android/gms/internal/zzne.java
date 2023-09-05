package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.ads.internal.zzae;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;

@zzzb
public final class zzne extends zznh {
    private final zzae zzbqz;
    @Nullable
    private final String zzbra;
    private final String zzbrb;

    public zzne(zzae zzae, @Nullable String str, String str2) {
        this.zzbqz = zzae;
        this.zzbra = str;
        this.zzbrb = str2;
    }

    public final String getContent() {
        return this.zzbrb;
    }

    public final void recordClick() {
        this.zzbqz.zzcm();
    }

    public final void recordImpression() {
        this.zzbqz.zzcn();
    }

    public final void zze(@Nullable IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            this.zzbqz.zzc((View) zzn.zzx(iObjectWrapper));
        }
    }

    public final String zzjd() {
        return this.zzbra;
    }
}
