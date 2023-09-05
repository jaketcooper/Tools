package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.C0555R;
import com.google.android.gms.ads.internal.zzbs;
import java.util.Map;

@zzzb
public final class zzvz extends zzwg {
    /* access modifiers changed from: private */
    public final Context mContext;
    private final Map<String, String> zzbqw;

    public zzvz(zzama zzama, Map<String, String> map) {
        super(zzama, "storePicture");
        this.zzbqw = map;
        this.mContext = zzama.zzrz();
    }

    public final void execute() {
        if (this.mContext == null) {
            zzbl("Activity context is not available");
            return;
        }
        zzbs.zzec();
        if (!zzagr.zzak(this.mContext).zzin()) {
            zzbl("Feature is not supported by the device.");
            return;
        }
        String str = this.zzbqw.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzbl("Image url cannot be empty.");
        } else if (!URLUtil.isValidUrl(str)) {
            String valueOf = String.valueOf(str);
            zzbl(valueOf.length() != 0 ? "Invalid image url: ".concat(valueOf) : new String("Invalid image url: "));
        } else {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            zzbs.zzec();
            if (!zzagr.zzce(lastPathSegment)) {
                String valueOf2 = String.valueOf(lastPathSegment);
                zzbl(valueOf2.length() != 0 ? "Image type not recognized: ".concat(valueOf2) : new String("Image type not recognized: "));
                return;
            }
            Resources resources = zzbs.zzeg().getResources();
            zzbs.zzec();
            AlertDialog.Builder zzaj = zzagr.zzaj(this.mContext);
            zzaj.setTitle(resources != null ? resources.getString(C0555R.string.f77s1) : "Save image");
            zzaj.setMessage(resources != null ? resources.getString(C0555R.string.f78s2) : "Allow Ad to store image in Picture gallery?");
            zzaj.setPositiveButton(resources != null ? resources.getString(C0555R.string.f79s3) : "Accept", new zzwa(this, str, lastPathSegment));
            zzaj.setNegativeButton(resources != null ? resources.getString(C0555R.string.f80s4) : "Decline", new zzwb(this));
            zzaj.create().show();
        }
    }
}
