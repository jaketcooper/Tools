package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

public final class zzeur {
    private String zzdzn;

    public zzeur(@Nullable String str) {
        this.zzdzn = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzeur)) {
            return false;
        }
        return zzbg.equal(this.zzdzn, ((zzeur) obj).zzdzn);
    }

    @Nullable
    public final String getToken() {
        return this.zzdzn;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzdzn});
    }

    public final String toString() {
        return zzbg.zzw(this).zzg("token", this.zzdzn).toString();
    }
}
