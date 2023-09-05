package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import java.util.concurrent.TimeUnit;

@zzzb
public final class zzalj {
    private final Context mContext;
    private final zzaiy zzaqi;
    private final String zzcqb;
    @Nullable
    private final zznd zzdeh;
    private boolean zzdel;
    @Nullable
    private final zznb zzdgr;
    private final zzahu zzdgs = new zzahx().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzql();
    private final long[] zzdgt;
    private final String[] zzdgu;
    private boolean zzdgv = false;
    private boolean zzdgw = false;
    private boolean zzdgx = false;
    private boolean zzdgy = false;
    private zzaku zzdgz;
    private boolean zzdha;
    private boolean zzdhb;
    private long zzdhc = -1;

    public zzalj(Context context, zzaiy zzaiy, String str, @Nullable zznd zznd, @Nullable zznb zznb) {
        this.mContext = context;
        this.zzaqi = zzaiy;
        this.zzcqb = str;
        this.zzdeh = zznd;
        this.zzdgr = zznb;
        String str2 = (String) zzbs.zzep().zzd(zzmq.zzbgx);
        if (str2 == null) {
            this.zzdgu = new String[0];
            this.zzdgt = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.zzdgu = new String[split.length];
        this.zzdgt = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzdgt[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzafj.zzc("Unable to parse frame hash target time number.", e);
                this.zzdgt[i] = -1;
            }
        }
    }

    public final void onStop() {
        if (((Boolean) zzbs.zzep().zzd(zzmq.zzbgw)).booleanValue() && !this.zzdha) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.zzcqb);
            bundle.putString("player", this.zzdgz.zzqz());
            for (zzahw next : this.zzdgs.getBuckets()) {
                String valueOf = String.valueOf("fps_c_");
                String valueOf2 = String.valueOf(next.name);
                bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Integer.toString(next.count));
                String valueOf3 = String.valueOf("fps_p_");
                String valueOf4 = String.valueOf(next.name);
                bundle.putString(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), Double.toString(next.zzdam));
            }
            for (int i = 0; i < this.zzdgt.length; i++) {
                String str = this.zzdgu[i];
                if (str != null) {
                    String valueOf5 = String.valueOf(Long.valueOf(this.zzdgt[i]));
                    bundle.putString(new StringBuilder(String.valueOf("fh_").length() + String.valueOf(valueOf5).length()).append("fh_").append(valueOf5).toString(), str);
                }
            }
            zzbs.zzec().zza(this.mContext, this.zzaqi.zzcp, "gmob-apps", bundle, true);
            this.zzdha = true;
        }
    }

    public final void zza(zzaku zzaku) {
        zzmw.zza(this.zzdeh, this.zzdgr, "vpc2");
        this.zzdgv = true;
        if (this.zzdeh != null) {
            this.zzdeh.zzf("vpn", zzaku.zzqz());
        }
        this.zzdgz = zzaku;
    }

    public final void zzb(zzaku zzaku) {
        long j;
        if (this.zzdgx && !this.zzdgy) {
            zzmw.zza(this.zzdeh, this.zzdgr, "vff2");
            this.zzdgy = true;
        }
        long nanoTime = zzbs.zzei().nanoTime();
        if (this.zzdel && this.zzdhb && this.zzdhc != -1) {
            this.zzdgs.zza(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (nanoTime - this.zzdhc)));
        }
        this.zzdhb = this.zzdel;
        this.zzdhc = nanoTime;
        long longValue = ((Long) zzbs.zzep().zzd(zzmq.zzbgy)).longValue();
        long currentPosition = (long) zzaku.getCurrentPosition();
        int i = 0;
        while (i < this.zzdgu.length) {
            if (this.zzdgu[i] != null || longValue <= Math.abs(currentPosition - this.zzdgt[i])) {
                i++;
            } else {
                String[] strArr = this.zzdgu;
                Bitmap bitmap = zzaku.getBitmap(8, 8);
                long j2 = 0;
                long j3 = 63;
                int i2 = 0;
                while (i2 < 8) {
                    int i3 = 0;
                    long j4 = j2;
                    while (true) {
                        j = j3;
                        if (i3 >= 8) {
                            break;
                        }
                        int pixel = bitmap.getPixel(i3, i2);
                        j4 |= (Color.green(pixel) + (Color.blue(pixel) + Color.red(pixel)) > 128 ? 1 : 0) << ((int) j);
                        i3++;
                        j3 = j - 1;
                    }
                    i2++;
                    j3 = j;
                    j2 = j4;
                }
                strArr[i] = String.format("%016X", new Object[]{Long.valueOf(j2)});
                return;
            }
        }
    }

    public final void zzrf() {
        if (this.zzdgv && !this.zzdgw) {
            zzmw.zza(this.zzdeh, this.zzdgr, "vfr2");
            this.zzdgw = true;
        }
    }

    public final void zzse() {
        this.zzdel = true;
        if (this.zzdgw && !this.zzdgx) {
            zzmw.zza(this.zzdeh, this.zzdgr, "vfp2");
            this.zzdgx = true;
        }
    }

    public final void zzsf() {
        this.zzdel = false;
    }
}
