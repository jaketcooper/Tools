package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.zzbs;
import java.util.Map;

@zzzb
public final class zzwf extends zzwg implements zzt<zzama> {
    private final Context mContext;
    private final WindowManager zzavc;
    private DisplayMetrics zzawr;
    private final zzama zzbwq;
    private final zzmc zzcfu;
    private float zzcfv;
    private int zzcfw = -1;
    private int zzcfx = -1;
    private int zzcfy;
    private int zzcfz = -1;
    private int zzcga = -1;
    private int zzcgb = -1;
    private int zzcgc = -1;

    public zzwf(zzama zzama, Context context, zzmc zzmc) {
        super(zzama);
        this.zzbwq = zzama;
        this.mContext = context;
        this.zzcfu = zzmc;
        this.zzavc = (WindowManager) context.getSystemService("window");
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        this.zzawr = new DisplayMetrics();
        Display defaultDisplay = this.zzavc.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zzawr);
        this.zzcfv = this.zzawr.density;
        this.zzcfy = defaultDisplay.getRotation();
        zzjk.zzhx();
        this.zzcfw = zzais.zzb(this.zzawr, this.zzawr.widthPixels);
        zzjk.zzhx();
        this.zzcfx = zzais.zzb(this.zzawr, this.zzawr.heightPixels);
        Activity zzrz = this.zzbwq.zzrz();
        if (zzrz == null || zzrz.getWindow() == null) {
            this.zzcfz = this.zzcfw;
            this.zzcga = this.zzcfx;
        } else {
            zzbs.zzec();
            int[] zzf = zzagr.zzf(zzrz);
            zzjk.zzhx();
            this.zzcfz = zzais.zzb(this.zzawr, zzf[0]);
            zzjk.zzhx();
            this.zzcga = zzais.zzb(this.zzawr, zzf[1]);
        }
        if (this.zzbwq.zzso().zztx()) {
            this.zzcgb = this.zzcfw;
            this.zzcgc = this.zzcfx;
        } else {
            this.zzbwq.measure(0, 0);
        }
        zza(this.zzcfw, this.zzcfx, this.zzcfz, this.zzcga, this.zzcfv, this.zzcfy);
        this.zzbwq.zza("onDeviceFeaturesReceived", new zzwc(new zzwe().zzn(this.zzcfu.zzil()).zzm(this.zzcfu.zzim()).zzo(this.zzcfu.zzio()).zzp(this.zzcfu.zzin()).zzq(true)).toJson());
        int[] iArr = new int[2];
        this.zzbwq.getLocationOnScreen(iArr);
        zzjk.zzhx();
        int zzd = zzais.zzd(this.mContext, iArr[0]);
        zzjk.zzhx();
        zzc(zzd, zzais.zzd(this.mContext, iArr[1]));
        if (zzafj.zzae(2)) {
            zzafj.zzcn("Dispatching Ready Event.");
        }
        zzbm(this.zzbwq.zzsb().zzcp);
    }

    public final void zzc(int i, int i2) {
        int i3 = this.mContext instanceof Activity ? zzbs.zzec().zzh((Activity) this.mContext)[0] : 0;
        if (this.zzbwq.zzso() == null || !this.zzbwq.zzso().zztx()) {
            zzjk.zzhx();
            this.zzcgb = zzais.zzd(this.mContext, this.zzbwq.getWidth());
            zzjk.zzhx();
            this.zzcgc = zzais.zzd(this.mContext, this.zzbwq.getHeight());
        }
        zzc(i, i2 - i3, this.zzcgb, this.zzcgc);
        this.zzbwq.zzsq().zzb(i, i2);
    }
}
