package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.List;

final class zzags implements zzno {
    private /* synthetic */ Context val$context;
    private /* synthetic */ List zzczj;
    private /* synthetic */ zznn zzczk;

    zzags(zzagr zzagr, List list, zznn zznn, Context context) {
        this.zzczj = list;
        this.zzczk = zznn;
        this.val$context = context;
    }

    public final void zzjf() {
        for (String str : this.zzczj) {
            String valueOf = String.valueOf(str);
            zzafj.zzcn(valueOf.length() != 0 ? "Pinging url: ".concat(valueOf) : new String("Pinging url: "));
            this.zzczk.mayLaunchUrl(Uri.parse(str), (Bundle) null, (List<Bundle>) null);
        }
        this.zzczk.zzc((Activity) this.val$context);
    }
}
