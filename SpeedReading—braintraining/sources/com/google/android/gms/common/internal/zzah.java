package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import java.util.Arrays;

public final class zzah {
    private final ComponentName mComponentName;
    private final String zzdor;
    private final String zzfya;
    private final int zzfyb;

    public zzah(ComponentName componentName, int i) {
        this.zzdor = null;
        this.zzfya = null;
        this.mComponentName = (ComponentName) zzbq.checkNotNull(componentName);
        this.zzfyb = 129;
    }

    public zzah(String str, String str2, int i) {
        this.zzdor = zzbq.zzgi(str);
        this.zzfya = zzbq.zzgi(str2);
        this.mComponentName = null;
        this.zzfyb = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzah)) {
            return false;
        }
        zzah zzah = (zzah) obj;
        return zzbg.equal(this.zzdor, zzah.zzdor) && zzbg.equal(this.zzfya, zzah.zzfya) && zzbg.equal(this.mComponentName, zzah.mComponentName) && this.zzfyb == zzah.zzfyb;
    }

    public final ComponentName getComponentName() {
        return this.mComponentName;
    }

    public final String getPackage() {
        return this.zzfya;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzdor, this.zzfya, this.mComponentName, Integer.valueOf(this.zzfyb)});
    }

    public final String toString() {
        return this.zzdor == null ? this.mComponentName.flattenToString() : this.zzdor;
    }

    public final int zzakz() {
        return this.zzfyb;
    }

    public final Intent zzala() {
        return this.zzdor != null ? new Intent(this.zzdor).setPackage(this.zzfya) : new Intent().setComponent(this.mComponentName);
    }
}
