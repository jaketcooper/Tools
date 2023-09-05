package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.zzbs;
import java.util.Map;

@zzzb
public final class zzalp implements zzt<zzali> {
    public final /* synthetic */ void zza(Object obj, Map map) {
        zzamr zzamr;
        zzali zzali = (zzali) obj;
        if (((Boolean) zzbs.zzep().zzd(zzmq.zzblk)).booleanValue()) {
            zzamr zzrx = zzali.zzrx();
            if (zzrx == null) {
                try {
                    zzamr zzamr2 = new zzamr(zzali, Float.parseFloat((String) map.get("duration")), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                    zzali.zza(zzamr2);
                    zzamr = zzamr2;
                } catch (NullPointerException | NumberFormatException e) {
                    zzafj.zzb("Unable to parse videoMeta message.", e);
                    zzbs.zzeg().zza(e, "VideoMetaGmsgHandler.onGmsg");
                    return;
                }
            } else {
                zzamr = zzrx;
            }
            boolean equals = "1".equals(map.get("muted"));
            float parseFloat = Float.parseFloat((String) map.get("currentTime"));
            int parseInt = Integer.parseInt((String) map.get("playbackState"));
            int i = (parseInt < 0 || 3 < parseInt) ? 0 : parseInt;
            String str = (String) map.get("aspectRatio");
            float parseFloat2 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
            if (zzafj.zzae(3)) {
                zzafj.zzbw(new StringBuilder(String.valueOf(str).length() + 79).append("Video Meta GMSG: isMuted : ").append(equals).append(" , playbackState : ").append(i).append(" , aspectRatio : ").append(str).toString());
            }
            zzamr.zza(parseFloat, i, equals, parseFloat2);
        }
    }
}
