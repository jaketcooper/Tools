package com.google.android.gms.internal;

import android.os.Build;
import android.os.ConditionVariable;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class zzcm {
    /* access modifiers changed from: private */
    public static final ConditionVariable zzagl = new ConditionVariable();
    protected static volatile zzig zzagm = null;
    private static volatile Random zzago = null;
    /* access modifiers changed from: private */
    public zzda zzagk;
    protected volatile Boolean zzagn;

    public zzcm(zzda zzda) {
        this.zzagk = zzda;
        zzda.zzae().execute(new zzcn(this));
    }

    public static int zzaa() {
        try {
            return Build.VERSION.SDK_INT >= 21 ? ThreadLocalRandom.current().nextInt() : zzab().nextInt();
        } catch (RuntimeException e) {
            return zzab().nextInt();
        }
    }

    private static Random zzab() {
        if (zzago == null) {
            synchronized (zzcm.class) {
                if (zzago == null) {
                    zzago = new Random();
                }
            }
        }
        return zzago;
    }

    public final void zza(int i, int i2, long j) throws IOException {
        try {
            zzagl.block();
            if (this.zzagn.booleanValue() && zzagm != null) {
                zzas zzas = new zzas();
                zzas.zzch = this.zzagk.zzaif.getPackageName();
                zzas.zzci = Long.valueOf(j);
                zzii zzd = zzagm.zzd(zzfhs.zzc(zzas));
                zzd.zzp(i2);
                zzd.zzq(i);
                zzd.zzbf();
            }
        } catch (Exception e) {
        }
    }
}
