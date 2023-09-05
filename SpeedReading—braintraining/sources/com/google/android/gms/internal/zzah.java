package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

final class zzah {
    final String key;
    final String zza;
    final long zzb;
    long zzbx;
    final long zzc;
    final long zzd;
    final long zze;
    final Map<String, String> zzf;

    zzah(String str, zzc zzc2) {
        this(str, zzc2.zza, zzc2.zzb, zzc2.zzc, zzc2.zzd, zzc2.zze, zzc2.zzf);
        this.zzbx = (long) zzc2.data.length;
    }

    private zzah(String str, String str2, long j, long j2, long j3, long j4, Map<String, String> map) {
        this.key = str;
        this.zza = "".equals(str2) ? null : str2;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = j3;
        this.zze = j4;
        this.zzf = map;
    }

    static zzah zzc(zzai zzai) throws IOException {
        if (zzag.zzb((InputStream) zzai) == 538247942) {
            return new zzah(zzag.zza(zzai), zzag.zza(zzai), zzag.zzc(zzai), zzag.zzc(zzai), zzag.zzc(zzai), zzag.zzc(zzai), zzag.zzb(zzai));
        }
        throw new IOException();
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(OutputStream outputStream) {
        try {
            zzag.zza(outputStream, 538247942);
            zzag.zza(outputStream, this.key);
            zzag.zza(outputStream, this.zza == null ? "" : this.zza);
            zzag.zza(outputStream, this.zzb);
            zzag.zza(outputStream, this.zzc);
            zzag.zza(outputStream, this.zzd);
            zzag.zza(outputStream, this.zze);
            Map<String, String> map = this.zzf;
            if (map != null) {
                zzag.zza(outputStream, map.size());
                for (Map.Entry next : map.entrySet()) {
                    zzag.zza(outputStream, (String) next.getKey());
                    zzag.zza(outputStream, (String) next.getValue());
                }
            } else {
                zzag.zza(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (IOException e) {
            zzab.zzb("%s", e.toString());
            return false;
        }
    }
}
