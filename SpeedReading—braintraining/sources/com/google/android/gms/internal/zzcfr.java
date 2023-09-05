package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.util.zzd;
import com.safonov.speedreading.training.fragment.schultetable.training.view.SchulteTableFragment;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class zzcfr extends zzcii {
    private long zziwu;
    private String zziwv;
    private Boolean zziww;

    zzcfr(zzchj zzchj) {
        super(zzchj);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
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
        Calendar instance = Calendar.getInstance();
        this.zziwu = TimeUnit.MINUTES.convert((long) (instance.get(16) + instance.get(15)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String lowerCase = locale.getLanguage().toLowerCase(Locale.ENGLISH);
        String lowerCase2 = locale.getCountry().toLowerCase(Locale.ENGLISH);
        this.zziwv = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length()).append(lowerCase).append(SchulteTableFragment.NON_INITIALIZATION_VALUE).append(lowerCase2).toString();
        return false;
    }

    public final long zzayj() {
        zzwu();
        return this.zziwu;
    }

    public final String zzayk() {
        zzwu();
        return this.zziwv;
    }

    public final boolean zzdt(Context context) {
        if (this.zziww == null) {
            this.zziww = false;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageManager.getPackageInfo("com.google.android.gms", 128);
                    this.zziww = true;
                }
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        return this.zziww.booleanValue();
    }

    public final /* bridge */ /* synthetic */ void zzut() {
        super.zzut();
    }

    public final /* bridge */ /* synthetic */ zzd zzwh() {
        return super.zzwh();
    }
}
