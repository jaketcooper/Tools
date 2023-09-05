package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.p000v4.util.SimpleArrayMap;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.internal.zzacv;
import com.google.android.gms.internal.zzaeu;
import com.google.android.gms.internal.zzaev;
import com.google.android.gms.internal.zzaew;
import com.google.android.gms.internal.zzaff;
import com.google.android.gms.internal.zzafh;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzahi;
import com.google.android.gms.internal.zzail;
import com.google.android.gms.internal.zzais;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zzamb;
import com.google.android.gms.internal.zzcs;
import com.google.android.gms.internal.zziw;
import com.google.android.gms.internal.zzjk;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjq;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkm;
import com.google.android.gms.internal.zzla;
import com.google.android.gms.internal.zzma;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zznj;
import com.google.android.gms.internal.zzom;
import com.google.android.gms.internal.zzpy;
import com.google.android.gms.internal.zzqb;
import com.google.android.gms.internal.zzqe;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.internal.zzqk;
import com.google.android.gms.internal.zzzb;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@zzzb
public final class zzbt implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    public final Context zzaif;
    boolean zzapr;
    final String zzata;
    public String zzatb;
    final zzcs zzatc;
    public final zzaiy zzatd;
    @Nullable
    zzbu zzate;
    @Nullable
    public zzafh zzatf;
    @Nullable
    public zzahi zzatg;
    public zziw zzath;
    @Nullable
    public zzaeu zzati;
    public zzaev zzatj;
    @Nullable
    public zzaew zzatk;
    @Nullable
    zzjn zzatl;
    @Nullable
    zzjq zzatm;
    @Nullable
    zzkg zzatn;
    @Nullable
    zzkm zzato;
    @Nullable
    zzpy zzatp;
    @Nullable
    zzqb zzatq;
    SimpleArrayMap<String, zzqe> zzatr;
    SimpleArrayMap<String, zzqh> zzats;
    zzom zzatt;
    @Nullable
    zzma zzatu;
    @Nullable
    zzla zzatv;
    @Nullable
    zzqk zzatw;
    @Nullable
    List<Integer> zzatx;
    @Nullable
    zznj zzaty;
    @Nullable
    zzacv zzatz;
    @Nullable
    public String zzaua;
    @Nullable
    List<String> zzaub;
    @Nullable
    public zzaff zzauc;
    @Nullable
    View zzaud;
    public int zzaue;
    private HashSet<zzaew> zzauf;
    private int zzaug;
    private int zzauh;
    private zzail zzaui;
    private boolean zzauj;
    private boolean zzauk;
    private boolean zzaul;

    public zzbt(Context context, zziw zziw, String str, zzaiy zzaiy) {
        this(context, zziw, str, zzaiy, (zzcs) null);
    }

    private zzbt(Context context, zziw zziw, String str, zzaiy zzaiy, zzcs zzcs) {
        this.zzauc = null;
        this.zzaud = null;
        this.zzaue = 0;
        this.zzapr = false;
        this.zzauf = null;
        this.zzaug = -1;
        this.zzauh = -1;
        this.zzauj = true;
        this.zzauk = true;
        this.zzaul = false;
        zzmq.initialize(context);
        if (zzbs.zzeg().zzow() != null) {
            List<String> zzir = zzmq.zzir();
            if (zzaiy.zzdbz != 0) {
                zzir.add(Integer.toString(zzaiy.zzdbz));
            }
            zzbs.zzeg().zzow().zzf(zzir);
        }
        this.zzata = UUID.randomUUID().toString();
        if (zziw.zzbdb || zziw.zzbdd) {
            this.zzate = null;
        } else {
            this.zzate = new zzbu(context, str, zzaiy.zzcp, this, this);
            this.zzate.setMinimumWidth(zziw.widthPixels);
            this.zzate.setMinimumHeight(zziw.heightPixels);
            this.zzate.setVisibility(4);
        }
        this.zzath = zziw;
        this.zzatb = str;
        this.zzaif = context;
        this.zzatd = zzaiy;
        this.zzatc = new zzcs(new zzaf(this));
        this.zzaui = new zzail(200);
        this.zzats = new SimpleArrayMap<>();
    }

    private final void zze(boolean z) {
        View findViewById;
        boolean z2 = true;
        if (this.zzate != null && this.zzati != null && this.zzati.zzchj != null && this.zzati.zzchj.zzsq() != null) {
            if (!z || this.zzaui.tryAcquire()) {
                if (this.zzati.zzchj.zzsq().zzfr()) {
                    int[] iArr = new int[2];
                    this.zzate.getLocationOnScreen(iArr);
                    zzjk.zzhx();
                    int zzd = zzais.zzd(this.zzaif, iArr[0]);
                    zzjk.zzhx();
                    int zzd2 = zzais.zzd(this.zzaif, iArr[1]);
                    if (!(zzd == this.zzaug && zzd2 == this.zzauh)) {
                        this.zzaug = zzd;
                        this.zzauh = zzd2;
                        zzamb zzsq = this.zzati.zzchj.zzsq();
                        int i = this.zzaug;
                        int i2 = this.zzauh;
                        if (z) {
                            z2 = false;
                        }
                        zzsq.zza(i, i2, z2);
                    }
                }
                if (this.zzate != null && (findViewById = this.zzate.getRootView().findViewById(16908290)) != null) {
                    Rect rect = new Rect();
                    Rect rect2 = new Rect();
                    this.zzate.getGlobalVisibleRect(rect);
                    findViewById.getGlobalVisibleRect(rect2);
                    if (rect.top != rect2.top) {
                        this.zzauj = false;
                    }
                    if (rect.bottom != rect2.bottom) {
                        this.zzauk = false;
                    }
                }
            }
        }
    }

    public final void onGlobalLayout() {
        zze(false);
    }

    public final void onScrollChanged() {
        zze(true);
        this.zzaul = true;
    }

    public final void zza(HashSet<zzaew> hashSet) {
        this.zzauf = hashSet;
    }

    public final void zzf(boolean z) {
        if (!(this.zzaue != 0 || this.zzati == null || this.zzati.zzchj == null)) {
            this.zzati.zzchj.stopLoading();
        }
        if (this.zzatf != null) {
            this.zzatf.cancel();
        }
        if (this.zzatg != null) {
            this.zzatg.cancel();
        }
        if (z) {
            this.zzati = null;
        }
    }

    public final HashSet<zzaew> zzfd() {
        return this.zzauf;
    }

    public final void zzfe() {
        if (this.zzati != null && this.zzati.zzchj != null) {
            this.zzati.zzchj.destroy();
        }
    }

    public final void zzff() {
        if (this.zzati != null && this.zzati.zzcde != null) {
            try {
                this.zzati.zzcde.destroy();
            } catch (RemoteException e) {
                zzafj.zzco("Could not destroy mediation adapter.");
            }
        }
    }

    public final boolean zzfg() {
        return this.zzaue == 0;
    }

    public final boolean zzfh() {
        return this.zzaue == 1;
    }

    public final String zzfi() {
        return (!this.zzauj || !this.zzauk) ? this.zzauj ? this.zzaul ? "top-scrollable" : "top-locked" : this.zzauk ? this.zzaul ? "bottom-scrollable" : "bottom-locked" : "" : "";
    }
}
