package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement;

public final class zzcgh extends zzcii {
    private static String[] zzizf = new String[AppMeasurement.Event.zzitv.length];
    private static String[] zzizg = new String[AppMeasurement.Param.zzitx.length];
    private static String[] zzizh = new String[AppMeasurement.UserProperty.zziuc.length];

    zzcgh(zzchj zzchj) {
        super(zzchj);
    }

    @Nullable
    private static String zza(String str, String[] strArr, String[] strArr2, String[] strArr3) {
        boolean z = true;
        int i = 0;
        zzbq.checkNotNull(strArr);
        zzbq.checkNotNull(strArr2);
        zzbq.checkNotNull(strArr3);
        zzbq.checkArgument(strArr.length == strArr2.length);
        if (strArr.length != strArr3.length) {
            z = false;
        }
        zzbq.checkArgument(z);
        while (true) {
            if (i >= strArr.length) {
                break;
            } else if (zzckn.zzas(str, strArr[i])) {
                synchronized (strArr3) {
                    if (strArr3[i] == null) {
                        strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                    }
                    str = strArr3[i];
                }
            } else {
                i++;
            }
        }
        return str;
    }

    private static void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private final void zza(StringBuilder sb, int i, zzckq zzckq) {
        if (zzckq != null) {
            zza(sb, i);
            sb.append("filter {\n");
            zza(sb, i, "complement", (Object) zzckq.zzjht);
            zza(sb, i, "param_name", (Object) zzjd(zzckq.zzjhu));
            int i2 = i + 1;
            zzckt zzckt = zzckq.zzjhr;
            if (zzckt != null) {
                zza(sb, i2);
                sb.append("string_filter");
                sb.append(" {\n");
                if (zzckt.zzjid != null) {
                    String str = "UNKNOWN_MATCH_TYPE";
                    switch (zzckt.zzjid.intValue()) {
                        case 1:
                            str = "REGEXP";
                            break;
                        case 2:
                            str = "BEGINS_WITH";
                            break;
                        case 3:
                            str = "ENDS_WITH";
                            break;
                        case 4:
                            str = "PARTIAL";
                            break;
                        case 5:
                            str = "EXACT";
                            break;
                        case 6:
                            str = "IN_LIST";
                            break;
                    }
                    zza(sb, i2, "match_type", (Object) str);
                }
                zza(sb, i2, "expression", (Object) zzckt.zzjie);
                zza(sb, i2, "case_sensitive", (Object) zzckt.zzjif);
                if (zzckt.zzjig.length > 0) {
                    zza(sb, i2 + 1);
                    sb.append("expression_list {\n");
                    for (String append : zzckt.zzjig) {
                        zza(sb, i2 + 2);
                        sb.append(append);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                zza(sb, i2);
                sb.append("}\n");
            }
            zza(sb, i + 1, "number_filter", zzckq.zzjhs);
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private final void zza(StringBuilder sb, int i, String str, zzckr zzckr) {
        if (zzckr != null) {
            zza(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzckr.zzjhv != null) {
                String str2 = "UNKNOWN_COMPARISON_TYPE";
                switch (zzckr.zzjhv.intValue()) {
                    case 1:
                        str2 = "LESS_THAN";
                        break;
                    case 2:
                        str2 = "GREATER_THAN";
                        break;
                    case 3:
                        str2 = "EQUAL";
                        break;
                    case 4:
                        str2 = "BETWEEN";
                        break;
                }
                zza(sb, i, "comparison_type", (Object) str2);
            }
            zza(sb, i, "match_as_float", (Object) zzckr.zzjhw);
            zza(sb, i, "comparison_value", (Object) zzckr.zzjhx);
            zza(sb, i, "min_comparison_value", (Object) zzckr.zzjhy);
            zza(sb, i, "max_comparison_value", (Object) zzckr.zzjhz);
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, zzclc zzclc) {
        int i2 = 0;
        if (zzclc != null) {
            int i3 = i + 1;
            zza(sb, i3);
            sb.append(str);
            sb.append(" {\n");
            if (zzclc.zzjkf != null) {
                zza(sb, i3 + 1);
                sb.append("results: ");
                long[] jArr = zzclc.zzjkf;
                int length = jArr.length;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length) {
                    Long valueOf = Long.valueOf(jArr[i4]);
                    int i6 = i5 + 1;
                    if (i5 != 0) {
                        sb.append(", ");
                    }
                    sb.append(valueOf);
                    i4++;
                    i5 = i6;
                }
                sb.append(10);
            }
            if (zzclc.zzjke != null) {
                zza(sb, i3 + 1);
                sb.append("status: ");
                long[] jArr2 = zzclc.zzjke;
                int length2 = jArr2.length;
                int i7 = 0;
                while (i2 < length2) {
                    Long valueOf2 = Long.valueOf(jArr2[i2]);
                    int i8 = i7 + 1;
                    if (i7 != 0) {
                        sb.append(", ");
                    }
                    sb.append(valueOf2);
                    i2++;
                    i7 = i8;
                }
                sb.append(10);
            }
            zza(sb, i3);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            zza(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    private final void zza(StringBuilder sb, int i, zzckx[] zzckxArr) {
        if (zzckxArr != null) {
            for (zzckx zzckx : zzckxArr) {
                if (zzckx != null) {
                    zza(sb, 2);
                    sb.append("audience_membership {\n");
                    zza(sb, 2, "audience_id", (Object) zzckx.zzjhh);
                    zza(sb, 2, "new_audience", (Object) zzckx.zzjiu);
                    zza(sb, 2, "current_data", zzckx.zzjis);
                    zza(sb, 2, "previous_data", zzckx.zzjit);
                    zza(sb, 2);
                    sb.append("}\n");
                }
            }
        }
    }

    private final void zza(StringBuilder sb, int i, zzcky[] zzckyArr) {
        if (zzckyArr != null) {
            for (zzcky zzcky : zzckyArr) {
                if (zzcky != null) {
                    zza(sb, 2);
                    sb.append("event {\n");
                    zza(sb, 2, "name", (Object) zzjc(zzcky.name));
                    zza(sb, 2, "timestamp_millis", (Object) zzcky.zzjix);
                    zza(sb, 2, "previous_timestamp_millis", (Object) zzcky.zzjiy);
                    zza(sb, 2, "count", (Object) zzcky.count);
                    zzckz[] zzckzArr = zzcky.zzjiw;
                    if (zzckzArr != null) {
                        for (zzckz zzckz : zzckzArr) {
                            if (zzckz != null) {
                                zza(sb, 3);
                                sb.append("param {\n");
                                zza(sb, 3, "name", (Object) zzjd(zzckz.name));
                                zza(sb, 3, "string_value", (Object) zzckz.zzfzs);
                                zza(sb, 3, "int_value", (Object) zzckz.zzjja);
                                zza(sb, 3, "double_value", (Object) zzckz.zzjha);
                                zza(sb, 3);
                                sb.append("}\n");
                            }
                        }
                    }
                    zza(sb, 2);
                    sb.append("}\n");
                }
            }
        }
    }

    private final void zza(StringBuilder sb, int i, zzcld[] zzcldArr) {
        if (zzcldArr != null) {
            for (zzcld zzcld : zzcldArr) {
                if (zzcld != null) {
                    zza(sb, 2);
                    sb.append("user_property {\n");
                    zza(sb, 2, "set_timestamp_millis", (Object) zzcld.zzjkh);
                    zza(sb, 2, "name", (Object) zzje(zzcld.name));
                    zza(sb, 2, "string_value", (Object) zzcld.zzfzs);
                    zza(sb, 2, "int_value", (Object) zzcld.zzjja);
                    zza(sb, 2, "double_value", (Object) zzcld.zzjha);
                    zza(sb, 2);
                    sb.append("}\n");
                }
            }
        }
    }

    private final boolean zzayr() {
        return this.zzitu.zzawn().zzae(3);
    }

    @Nullable
    private final String zzb(zzcfu zzcfu) {
        if (zzcfu == null) {
            return null;
        }
        return !zzayr() ? zzcfu.toString() : zzx(zzcfu.zzaym());
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zza(zzcfs zzcfs) {
        if (zzcfs == null) {
            return null;
        }
        if (!zzayr()) {
            return zzcfs.toString();
        }
        return "Event{appId='" + zzcfs.mAppId + "', name='" + zzjc(zzcfs.mName) + "', params=" + zzb(zzcfs.zziwy) + "}";
    }

    /* access modifiers changed from: protected */
    public final String zza(zzckp zzckp) {
        if (zzckp == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        zza(sb, 0, "filter_id", (Object) zzckp.zzjhl);
        zza(sb, 0, "event_name", (Object) zzjc(zzckp.zzjhm));
        zza(sb, 1, "event_count_filter", zzckp.zzjhp);
        sb.append("  filters {\n");
        for (zzckq zza : zzckp.zzjhn) {
            zza(sb, 2, zza);
        }
        zza(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final String zza(zzcks zzcks) {
        if (zzcks == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        zza(sb, 0, "filter_id", (Object) zzcks.zzjhl);
        zza(sb, 0, "property_name", (Object) zzje(zzcks.zzjib));
        zza(sb, 1, zzcks.zzjic);
        sb.append("}\n");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final String zza(zzcla zzcla) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (zzcla.zzjjb != null) {
            for (zzclb zzclb : zzcla.zzjjb) {
                if (!(zzclb == null || zzclb == null)) {
                    zza(sb, 1);
                    sb.append("bundle {\n");
                    zza(sb, 1, "protocol_version", (Object) zzclb.zzjjd);
                    zza(sb, 1, "platform", (Object) zzclb.zzjjl);
                    zza(sb, 1, "gmp_version", (Object) zzclb.zzjjp);
                    zza(sb, 1, "uploading_gmp_version", (Object) zzclb.zzjjq);
                    zza(sb, 1, "config_version", (Object) zzclb.zzjkc);
                    zza(sb, 1, "gmp_app_id", (Object) zzclb.zzivh);
                    zza(sb, 1, "app_id", (Object) zzclb.zzch);
                    zza(sb, 1, "app_version", (Object) zzclb.zzida);
                    zza(sb, 1, "app_version_major", (Object) zzclb.zzjjy);
                    zza(sb, 1, "firebase_instance_id", (Object) zzclb.zzivp);
                    zza(sb, 1, "dev_cert_hash", (Object) zzclb.zzjju);
                    zza(sb, 1, "app_store", (Object) zzclb.zzivi);
                    zza(sb, 1, "upload_timestamp_millis", (Object) zzclb.zzjjg);
                    zza(sb, 1, "start_timestamp_millis", (Object) zzclb.zzjjh);
                    zza(sb, 1, "end_timestamp_millis", (Object) zzclb.zzjji);
                    zza(sb, 1, "previous_bundle_start_timestamp_millis", (Object) zzclb.zzjjj);
                    zza(sb, 1, "previous_bundle_end_timestamp_millis", (Object) zzclb.zzjjk);
                    zza(sb, 1, "app_instance_id", (Object) zzclb.zzjjt);
                    zza(sb, 1, "resettable_device_id", (Object) zzclb.zzjjr);
                    zza(sb, 1, "device_id", (Object) zzclb.zzjkb);
                    zza(sb, 1, "limited_ad_tracking", (Object) zzclb.zzjjs);
                    zza(sb, 1, "os_version", (Object) zzclb.zzcv);
                    zza(sb, 1, "device_model", (Object) zzclb.zzjjm);
                    zza(sb, 1, "user_default_language", (Object) zzclb.zzjjn);
                    zza(sb, 1, "time_zone_offset_minutes", (Object) zzclb.zzjjo);
                    zza(sb, 1, "bundle_sequential_index", (Object) zzclb.zzjjv);
                    zza(sb, 1, "service_upload", (Object) zzclb.zzjjw);
                    zza(sb, 1, "health_monitor", (Object) zzclb.zzivl);
                    if (zzclb.zzfib.longValue() != 0) {
                        zza(sb, 1, "android_id", (Object) zzclb.zzfib);
                    }
                    zza(sb, 1, zzclb.zzjjf);
                    zza(sb, 1, zzclb.zzjjx);
                    zza(sb, 1, zzclb.zzjje);
                    zza(sb, 1);
                    sb.append("}\n");
                }
            }
        }
        sb.append("}\n");
        return sb.toString();
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
    @Nullable
    public final String zzb(zzcfx zzcfx) {
        if (zzcfx == null) {
            return null;
        }
        if (!zzayr()) {
            return zzcfx.toString();
        }
        return "origin=" + zzcfx.zzivu + ",name=" + zzjc(zzcfx.name) + ",params=" + zzb(zzcfx.zzixi);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzjc(String str) {
        if (str == null) {
            return null;
        }
        return zzayr() ? zza(str, AppMeasurement.Event.zzitw, AppMeasurement.Event.zzitv, zzizf) : str;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzjd(String str) {
        if (str == null) {
            return null;
        }
        return zzayr() ? zza(str, AppMeasurement.Param.zzity, AppMeasurement.Param.zzitx, zzizg) : str;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzje(String str) {
        if (str == null) {
            return null;
        }
        if (!zzayr()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return zza(str, AppMeasurement.UserProperty.zziud, AppMeasurement.UserProperty.zziuc, zzizh);
        }
        return "experiment_id" + "(" + str + ")";
    }

    public final /* bridge */ /* synthetic */ void zzut() {
        super.zzut();
    }

    public final /* bridge */ /* synthetic */ zzd zzwh() {
        return super.zzwh();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzx(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!zzayr()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        for (String str : bundle.keySet()) {
            if (sb.length() != 0) {
                sb.append(", ");
            } else {
                sb.append("Bundle[{");
            }
            sb.append(zzjd(str));
            sb.append("=");
            sb.append(bundle.get(str));
        }
        sb.append("}]");
        return sb.toString();
    }
}
