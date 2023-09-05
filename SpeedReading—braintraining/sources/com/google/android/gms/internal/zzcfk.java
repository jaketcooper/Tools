package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzs;
import java.lang.reflect.InvocationTargetException;

public final class zzcfk extends zzcih {
    private Boolean zzdsn;

    zzcfk(zzchj zzchj) {
        super(zzchj);
    }

    public static long zzaxq() {
        return zzcfz.zziyv.get().longValue();
    }

    public static long zzaxr() {
        return zzcfz.zzixv.get().longValue();
    }

    public static boolean zzaxt() {
        return zzcfz.zzixq.get().booleanValue();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final long zza(String str, zzcga<Long> zzcga) {
        if (str == null) {
            return zzcga.get().longValue();
        }
        String zzam = zzawk().zzam(str, zzcga.getKey());
        if (TextUtils.isEmpty(zzam)) {
            return zzcga.get().longValue();
        }
        try {
            return zzcga.get(Long.valueOf(Long.valueOf(zzam).longValue())).longValue();
        } catch (NumberFormatException e) {
            return zzcga.get().longValue();
        }
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

    public final boolean zzaxp() {
        Boolean zzit = zzit("firebase_analytics_collection_deactivated");
        return zzit != null && zzit.booleanValue();
    }

    public final String zzaxs() {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{"debug.firebase.analytics.app", ""});
        } catch (ClassNotFoundException e) {
            zzawn().zzays().zzj("Could not find SystemProperties class", e);
        } catch (NoSuchMethodException e2) {
            zzawn().zzays().zzj("Could not find SystemProperties.get() method", e2);
        } catch (IllegalAccessException e3) {
            zzawn().zzays().zzj("Could not access SystemProperties.get()", e3);
        } catch (InvocationTargetException e4) {
            zzawn().zzays().zzj("SystemProperties.get() threw an exception", e4);
        }
        return "";
    }

    public final int zzb(String str, zzcga<Integer> zzcga) {
        if (str == null) {
            return zzcga.get().intValue();
        }
        String zzam = zzawk().zzam(str, zzcga.getKey());
        if (TextUtils.isEmpty(zzam)) {
            return zzcga.get().intValue();
        }
        try {
            return zzcga.get(Integer.valueOf(Integer.valueOf(zzam).intValue())).intValue();
        } catch (NumberFormatException e) {
            return zzcga.get().intValue();
        }
    }

    public final int zzis(@Size(min = 1) String str) {
        return zzb(str, zzcfz.zziyg);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final Boolean zzit(@Size(min = 1) String str) {
        zzbq.zzgi(str);
        try {
            if (getContext().getPackageManager() == null) {
                zzawn().zzays().log("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = zzbgc.zzcy(getContext()).getApplicationInfo(getContext().getPackageName(), 128);
            if (applicationInfo == null) {
                zzawn().zzays().log("Failed to load metadata: ApplicationInfo is null");
                return null;
            } else if (applicationInfo.metaData == null) {
                zzawn().zzays().log("Failed to load metadata: Metadata bundle is null");
                return null;
            } else if (applicationInfo.metaData.containsKey(str)) {
                return Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
            } else {
                return null;
            }
        } catch (PackageManager.NameNotFoundException e) {
            zzawn().zzays().zzj("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public final boolean zziu(String str) {
        return "1".equals(zzawk().zzam(str, "gaia_collection_enabled"));
    }

    public final /* bridge */ /* synthetic */ void zzut() {
        super.zzut();
    }

    public final /* bridge */ /* synthetic */ zzd zzwh() {
        return super.zzwh();
    }

    public final boolean zzye() {
        if (this.zzdsn == null) {
            synchronized (this) {
                if (this.zzdsn == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String zzamd = zzs.zzamd();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzdsn = Boolean.valueOf(str != null && str.equals(zzamd));
                    }
                    if (this.zzdsn == null) {
                        this.zzdsn = Boolean.TRUE;
                        zzawn().zzays().log("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzdsn.booleanValue();
    }
}
