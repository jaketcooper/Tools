package com.google.android.gms.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Map;

public final class zzchd extends zzcii {
    private static int zzjbm = 65535;
    private static int zzjbn = 2;
    private final Map<String, Map<String, String>> zzjbo = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zzjbp = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zzjbq = new ArrayMap();
    private final Map<String, zzckv> zzjbr = new ArrayMap();
    private final Map<String, Map<String, Integer>> zzjbs = new ArrayMap();
    private final Map<String, String> zzjbt = new ArrayMap();

    zzchd(zzchj zzchj) {
        super(zzchj);
    }

    private static Map<String, String> zza(zzckv zzckv) {
        ArrayMap arrayMap = new ArrayMap();
        if (!(zzckv == null || zzckv.zzjin == null)) {
            for (zzckw zzckw : zzckv.zzjin) {
                if (zzckw != null) {
                    arrayMap.put(zzckw.key, zzckw.value);
                }
            }
        }
        return arrayMap;
    }

    private final void zza(String str, zzckv zzckv) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (!(zzckv == null || zzckv.zzjio == null)) {
            for (zzcku zzcku : zzckv.zzjio) {
                if (TextUtils.isEmpty(zzcku.name)) {
                    zzawn().zzayu().log("EventConfig contained null event name");
                } else {
                    String zzil = AppMeasurement.Event.zzil(zzcku.name);
                    if (!TextUtils.isEmpty(zzil)) {
                        zzcku.name = zzil;
                    }
                    arrayMap.put(zzcku.name, zzcku.zzjii);
                    arrayMap2.put(zzcku.name, zzcku.zzjij);
                    if (zzcku.zzjik != null) {
                        if (zzcku.zzjik.intValue() < zzjbn || zzcku.zzjik.intValue() > zzjbm) {
                            zzawn().zzayu().zze("Invalid sampling rate. Event name, sample rate", zzcku.name, zzcku.zzjik);
                        } else {
                            arrayMap3.put(zzcku.name, zzcku.zzjik);
                        }
                    }
                }
            }
        }
        this.zzjbp.put(str, arrayMap);
        this.zzjbq.put(str, arrayMap2);
        this.zzjbs.put(str, arrayMap3);
    }

    @WorkerThread
    private final zzckv zzc(String str, byte[] bArr) {
        if (bArr == null) {
            return new zzckv();
        }
        zzfhj zzn = zzfhj.zzn(bArr, 0, bArr.length);
        zzckv zzckv = new zzckv();
        try {
            zzckv.zza(zzn);
            zzawn().zzayy().zze("Parsed config. version, gmp_app_id", zzckv.zzjil, zzckv.zzivh);
            return zzckv;
        } catch (IOException e) {
            zzawn().zzayu().zze("Unable to merge remote config. appId", zzcgj.zzjf(str), e);
            return new zzckv();
        }
    }

    @WorkerThread
    private final void zzjm(String str) {
        zzwu();
        zzut();
        zzbq.zzgi(str);
        if (this.zzjbr.get(str) == null) {
            byte[] zziy = zzawh().zziy(str);
            if (zziy == null) {
                this.zzjbo.put(str, (Object) null);
                this.zzjbp.put(str, (Object) null);
                this.zzjbq.put(str, (Object) null);
                this.zzjbr.put(str, (Object) null);
                this.zzjbt.put(str, (Object) null);
                this.zzjbs.put(str, (Object) null);
                return;
            }
            zzckv zzc = zzc(str, zziy);
            this.zzjbo.put(str, zza(zzc));
            zza(str, zzc);
            this.zzjbr.put(str, zzc);
            this.zzjbt.put(str, (Object) null);
        }
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzam(String str, String str2) {
        zzut();
        zzjm(str);
        Map map = this.zzjbo.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzan(String str, String str2) {
        zzut();
        zzjm(str);
        if (zzawj().zzkg(str) && zzckn.zzkd(str2)) {
            return true;
        }
        if (zzawj().zzkh(str) && zzckn.zzju(str2)) {
            return true;
        }
        Map map = this.zzjbp.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzao(String str, String str2) {
        zzut();
        zzjm(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2)) {
            return true;
        }
        Map map = this.zzjbq.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final int zzap(String str, String str2) {
        zzut();
        zzjm(str);
        Map map = this.zzjbs.get(str);
        if (map == null) {
            return 1;
        }
        Integer num = (Integer) map.get(str2);
        if (num == null) {
            return 1;
        }
        return num.intValue();
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

    /* access modifiers changed from: protected */
    @WorkerThread
    public final boolean zzb(String str, byte[] bArr, String str2) {
        zzwu();
        zzut();
        zzbq.zzgi(str);
        zzckv zzc = zzc(str, bArr);
        if (zzc == null) {
            return false;
        }
        zza(str, zzc);
        this.zzjbr.put(str, zzc);
        this.zzjbt.put(str, str2);
        this.zzjbo.put(str, zza(zzc));
        zzcfh zzawa = zzawa();
        zzcko[] zzckoArr = zzc.zzjip;
        zzbq.checkNotNull(zzckoArr);
        for (zzcko zzcko : zzckoArr) {
            for (zzckp zzckp : zzcko.zzjhj) {
                String zzil = AppMeasurement.Event.zzil(zzckp.zzjhm);
                if (zzil != null) {
                    zzckp.zzjhm = zzil;
                }
                for (zzckq zzckq : zzckp.zzjhn) {
                    String zzil2 = AppMeasurement.Param.zzil(zzckq.zzjhu);
                    if (zzil2 != null) {
                        zzckq.zzjhu = zzil2;
                    }
                }
            }
            for (zzcks zzcks : zzcko.zzjhi) {
                String zzil3 = AppMeasurement.UserProperty.zzil(zzcks.zzjib);
                if (zzil3 != null) {
                    zzcks.zzjib = zzil3;
                }
            }
        }
        zzawa.zzawh().zza(str, zzckoArr);
        try {
            zzc.zzjip = null;
            byte[] bArr2 = new byte[zzc.zzhl()];
            zzc.zza(zzfhk.zzo(bArr2, 0, bArr2.length));
            bArr = bArr2;
        } catch (IOException e) {
            zzawn().zzayu().zze("Unable to serialize reduced-size config. Storing full config instead. appId", zzcgj.zzjf(str), e);
        }
        zzcfl zzawh = zzawh();
        zzbq.zzgi(str);
        zzawh.zzut();
        zzawh.zzwu();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) zzawh.getWritableDatabase().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                zzawh.zzawn().zzays().zzj("Failed to update remote config (got 0). appId", zzcgj.zzjf(str));
            }
        } catch (SQLiteException e2) {
            zzawh.zzawn().zzays().zze("Error storing remote config. appId", zzcgj.zzjf(str), e2);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final zzckv zzjn(String str) {
        zzwu();
        zzut();
        zzbq.zzgi(str);
        zzjm(str);
        return this.zzjbr.get(str);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final String zzjo(String str) {
        zzut();
        return this.zzjbt.get(str);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzjp(String str) {
        zzut();
        this.zzjbt.put(str, (Object) null);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzjq(String str) {
        zzut();
        this.zzjbr.remove(str);
    }

    public final /* bridge */ /* synthetic */ void zzut() {
        super.zzut();
    }

    public final /* bridge */ /* synthetic */ zzd zzwh() {
        return super.zzwh();
    }
}
