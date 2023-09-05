package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement;
import com.safonov.speedreading.training.fragment.schultetable.training.view.SchulteTableFragment;

public final class zzcgj extends zzcii {
    private final String zzfyo = zzcfz.zzixs.get();
    private final long zzius = 11717;
    private final char zzizi;
    private final zzcgl zzizj;
    private final zzcgl zzizk;
    private final zzcgl zzizl;
    private final zzcgl zzizm;
    private final zzcgl zzizn;
    private final zzcgl zzizo;
    private final zzcgl zzizp;
    private final zzcgl zzizq;
    private final zzcgl zzizr;

    zzcgj(zzchj zzchj) {
        super(zzchj);
        if (zzawp().zzye()) {
            this.zzizi = 'C';
        } else {
            this.zzizi = 'c';
        }
        this.zzizj = new zzcgl(this, 6, false, false);
        this.zzizk = new zzcgl(this, 6, true, false);
        this.zzizl = new zzcgl(this, 6, false, true);
        this.zzizm = new zzcgl(this, 5, false, false);
        this.zzizn = new zzcgl(this, 5, true, false);
        this.zzizo = new zzcgl(this, 5, false, true);
        this.zzizp = new zzcgl(this, 4, false, false);
        this.zzizq = new zzcgl(this, 3, false, false);
        this.zzizr = new zzcgl(this, 2, false, false);
    }

    private static String zza(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            str = "";
        }
        String zzb = zzb(z, obj);
        String zzb2 = zzb(z, obj2);
        String zzb3 = zzb(z, obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(zzb)) {
            sb.append(str2);
            sb.append(zzb);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzb2)) {
            sb.append(str2);
            sb.append(zzb2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzb3)) {
            sb.append(str2);
            sb.append(zzb3);
        }
        return sb.toString();
    }

    private static String zzb(boolean z, Object obj) {
        StackTraceElement stackTraceElement;
        String className;
        if (obj == null) {
            return "";
        }
        Object valueOf = obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
        if (valueOf instanceof Long) {
            if (!z) {
                return String.valueOf(valueOf);
            }
            if (Math.abs(((Long) valueOf).longValue()) < 100) {
                return String.valueOf(valueOf);
            }
            String str = String.valueOf(valueOf).charAt(0) == '-' ? SchulteTableFragment.NON_INITIALIZATION_VALUE : "";
            String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
            return new StringBuilder(String.valueOf(str).length() + 43 + String.valueOf(str).length()).append(str).append(Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1)))).append("...").append(str).append(Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d)).toString();
        } else if (valueOf instanceof Boolean) {
            return String.valueOf(valueOf);
        } else {
            if (!(valueOf instanceof Throwable)) {
                return valueOf instanceof zzcgm ? ((zzcgm) valueOf).zzgvj : z ? SchulteTableFragment.NON_INITIALIZATION_VALUE : String.valueOf(valueOf);
            }
            Throwable th = (Throwable) valueOf;
            StringBuilder sb = new StringBuilder(z ? th.getClass().getName() : th.toString());
            String zzjg = zzjg(AppMeasurement.class.getCanonicalName());
            String zzjg2 = zzjg(zzchj.class.getCanonicalName());
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                stackTraceElement = stackTrace[i];
                if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null) {
                    String zzjg3 = zzjg(className);
                    if (zzjg3.equals(zzjg) || zzjg3.equals(zzjg2)) {
                        sb.append(": ");
                        sb.append(stackTraceElement);
                    }
                }
                i++;
            }
            sb.append(": ");
            sb.append(stackTraceElement);
            return sb.toString();
        }
    }

    protected static Object zzjf(String str) {
        if (str == null) {
            return null;
        }
        return new zzcgm(str);
    }

    private static String zzjg(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: protected */
    public final void zza(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && zzae(i)) {
            zzk(i, zza(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            zzbq.checkNotNull(str);
            zzche zzazn = this.zzitu.zzazn();
            if (zzazn == null) {
                zzk(6, "Scheduler not set. Not logging error/warn");
            } else if (!zzazn.isInitialized()) {
                zzk(6, "Scheduler not initialized. Not logging error/warn");
            } else {
                int i2 = i < 0 ? 0 : i;
                if (i2 >= 9) {
                    i2 = 8;
                }
                char charAt = "01VDIWEA?".charAt(i2);
                char c = this.zzizi;
                long j = this.zzius;
                String zza = zza(true, str, obj, obj2, obj3);
                String sb = new StringBuilder(String.valueOf("2").length() + 23 + String.valueOf(zza).length()).append("2").append(charAt).append(c).append(j).append(":").append(zza).toString();
                if (sb.length() > 1024) {
                    sb = str.substring(0, 1024);
                }
                zzazn.zzg(new zzcgk(this, sb));
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzae(int i) {
        return Log.isLoggable(this.zzfyo, i);
    }

    public final /* bridge */ /* synthetic */ void zzavx() {
        super.zzavx();
    }

    public final /* bridge */ /* synthetic */ void zzavy() {
        super.zzavy();
    }

    public final /* bridge */ /* synthetic */ zzcfa zzavz() {
        return super.zzavz();
    }

    public final /* bridge */ /* synthetic */ zzcfh zzawa() {
        return super.zzawa();
    }

    public final /* bridge */ /* synthetic */ zzcik zzawb() {
        return super.zzawb();
    }

    public final /* bridge */ /* synthetic */ zzcge zzawc() {
        return super.zzawc();
    }

    public final /* bridge */ /* synthetic */ zzcfr zzawd() {
        return super.zzawd();
    }

    public final /* bridge */ /* synthetic */ zzcjd zzawe() {
        return super.zzawe();
    }

    public final /* bridge */ /* synthetic */ zzciz zzawf() {
        return super.zzawf();
    }

    public final /* bridge */ /* synthetic */ zzcgf zzawg() {
        return super.zzawg();
    }

    public final /* bridge */ /* synthetic */ zzcfl zzawh() {
        return super.zzawh();
    }

    public final /* bridge */ /* synthetic */ zzcgh zzawi() {
        return super.zzawi();
    }

    public final /* bridge */ /* synthetic */ zzckn zzawj() {
        return super.zzawj();
    }

    public final /* bridge */ /* synthetic */ zzchd zzawk() {
        return super.zzawk();
    }

    public final /* bridge */ /* synthetic */ zzckc zzawl() {
        return super.zzawl();
    }

    public final /* bridge */ /* synthetic */ zzche zzawm() {
        return super.zzawm();
    }

    public final /* bridge */ /* synthetic */ zzcgj zzawn() {
        return super.zzawn();
    }

    public final /* bridge */ /* synthetic */ zzcgu zzawo() {
        return super.zzawo();
    }

    public final /* bridge */ /* synthetic */ zzcfk zzawp() {
        return super.zzawp();
    }

    /* access modifiers changed from: protected */
    public final boolean zzaxo() {
        return false;
    }

    public final zzcgl zzays() {
        return this.zzizj;
    }

    public final zzcgl zzayt() {
        return this.zzizk;
    }

    public final zzcgl zzayu() {
        return this.zzizm;
    }

    public final zzcgl zzayv() {
        return this.zzizo;
    }

    public final zzcgl zzayw() {
        return this.zzizp;
    }

    public final zzcgl zzayx() {
        return this.zzizq;
    }

    public final zzcgl zzayy() {
        return this.zzizr;
    }

    public final String zzayz() {
        Pair<String, Long> zzzs = zzawo().zzjaf.zzzs();
        if (zzzs == null || zzzs == zzcgu.zzjae) {
            return null;
        }
        String valueOf = String.valueOf(zzzs.second);
        String str = (String) zzzs.first;
        return new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length()).append(valueOf).append(":").append(str).toString();
    }

    /* access modifiers changed from: protected */
    public final void zzk(int i, String str) {
        Log.println(i, this.zzfyo, str);
    }

    public final /* bridge */ /* synthetic */ void zzut() {
        super.zzut();
    }

    public final /* bridge */ /* synthetic */ zzd zzwh() {
        return super.zzwh();
    }
}
