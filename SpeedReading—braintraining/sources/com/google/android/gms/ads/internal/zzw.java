package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.internal.zzaaf;
import com.google.android.gms.internal.zzaeh;
import com.google.android.gms.internal.zzagr;
import com.google.android.gms.internal.zzzb;
import java.util.Map;

@zzzb
public final class zzw {
    private final Context mContext;
    private boolean zzanu;
    private zzaeh zzanv;
    private zzaaf zzanw;

    public zzw(Context context, zzaeh zzaeh, zzaaf zzaaf) {
        this.mContext = context;
        this.zzanv = zzaeh;
        this.zzanw = zzaaf;
        if (this.zzanw == null) {
            this.zzanw = new zzaaf();
        }
    }

    private final boolean zzct() {
        return (this.zzanv != null && this.zzanv.zzoe().zzcvb) || this.zzanw.zzcog;
    }

    public final void recordClick() {
        this.zzanu = true;
    }

    public final boolean zzcu() {
        return !zzct() || this.zzanu;
    }

    public final void zzs(@Nullable String str) {
        if (zzct()) {
            if (str == null) {
                str = "";
            }
            if (this.zzanv != null) {
                this.zzanv.zza(str, (Map<String, String>) null, 3);
            } else if (this.zzanw.zzcog && this.zzanw.zzcoh != null) {
                for (String next : this.zzanw.zzcoh) {
                    if (!TextUtils.isEmpty(next)) {
                        String replace = next.replace("{NAVIGATION_URL}", Uri.encode(str));
                        zzbs.zzec();
                        zzagr.zze(this.mContext, "", replace);
                    }
                }
            }
        }
    }
}
