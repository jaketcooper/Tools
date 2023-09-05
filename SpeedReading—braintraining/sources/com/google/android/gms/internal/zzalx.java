package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.zzbs;
import java.util.Map;

@zzzb
public final class zzalx implements zzt<zzali> {
    @Nullable
    private zzalt zzdhu;

    private static Integer zze(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(map.get(str)));
        } catch (NumberFormatException e) {
            String str2 = map.get(str);
            zzafj.zzco(new StringBuilder(String.valueOf(str).length() + 39 + String.valueOf(str2).length()).append("Precache invalid numeric parameter '").append(str).append("': ").append(str2).toString());
            return null;
        }
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        boolean z;
        zzali zzali = (zzali) obj;
        zzbs.zzey();
        if (!map.containsKey("abort")) {
            String str = (String) map.get("src");
            if (str != null) {
                if (this.zzdhu != null) {
                    zzafj.zzco("Threadless precache task has already started.");
                    return;
                } else if (zzals.zzc(zzali) != null) {
                    zzafj.zzco("Precache task is already running.");
                    return;
                } else if (zzali.zzbk() == null) {
                    zzafj.zzco("Precache requires a dependency provider.");
                    return;
                } else {
                    zzalh zzalh = new zzalh((String) map.get("flags"));
                    Integer zze = zze(map, "notifyBytes");
                    Integer zze2 = zze(map, "notifyMillis");
                    Integer zze3 = zze(map, "player");
                    if (zze3 == null) {
                        zze3 = 0;
                    }
                    zzalt zza = zzali.zzbk().zzanq.zza(zzali, zze3.intValue(), (String) null, zzalh);
                    if ((zze == null && zze2 == null) ? false : true) {
                        String[] split = zzalh.zzdgk.split(",");
                        int length = split.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                z = false;
                                break;
                            }
                            String str2 = split[i];
                            if (!str2.equals("1") && !str2.equals("2")) {
                                z = true;
                                break;
                            }
                            i++;
                        }
                        if (z) {
                            if (zze != null) {
                                zze.intValue();
                            } else {
                                zze2.intValue();
                            }
                            this.zzdhu = zza;
                        }
                    }
                    new zzalq(zzali, zza, str).zzmx();
                }
            } else if (zzals.zzc(zzali) == null && this.zzdhu == null) {
                zzafj.zzco("Precache must specify a source.");
                return;
            }
            Integer zze4 = zze(map, "minBufferMs");
            if (zze4 != null) {
                zze4.intValue();
            }
            Integer zze5 = zze(map, "maxBufferMs");
            if (zze5 != null) {
                zze5.intValue();
            }
            Integer zze6 = zze(map, "bufferForPlaybackMs");
            if (zze6 != null) {
                zze6.intValue();
            }
            Integer zze7 = zze(map, "bufferForPlaybackAfterRebufferMs");
            if (zze7 != null) {
                zze7.intValue();
            }
        } else if (this.zzdhu != null) {
            this.zzdhu.abort();
        } else if (!zzals.zzb(zzali)) {
            zzafj.zzco("Precache abort but no precache task running.");
        }
    }
}
