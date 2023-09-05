package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.C0555R;

public final class zzca {
    private final Resources zzfzj;
    private final String zzfzk = this.zzfzj.getResourcePackageName(C0555R.string.common_google_play_services_unknown_issue);

    public zzca(Context context) {
        zzbq.checkNotNull(context);
        this.zzfzj = context.getResources();
    }

    public final String getString(String str) {
        int identifier = this.zzfzj.getIdentifier(str, "string", this.zzfzk);
        if (identifier == 0) {
            return null;
        }
        return this.zzfzj.getString(identifier);
    }
}
