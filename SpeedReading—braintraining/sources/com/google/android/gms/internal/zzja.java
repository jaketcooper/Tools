package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import android.widget.FrameLayout;
import java.util.HashMap;

@zzzb
public class zzja {
    private final Object mLock = new Object();
    private zzkj zzbdh;
    /* access modifiers changed from: private */
    public final zzir zzbdi;
    /* access modifiers changed from: private */
    public final zziq zzbdj;
    /* access modifiers changed from: private */
    public final zzlk zzbdk;
    /* access modifiers changed from: private */
    public final zzqn zzbdl;
    /* access modifiers changed from: private */
    public final zzacz zzbdm;
    /* access modifiers changed from: private */
    public final zzwi zzbdn;
    /* access modifiers changed from: private */
    public final zzqo zzbdo;

    @VisibleForTesting
    abstract class zza<T> {
        zza() {
        }

        /* access modifiers changed from: protected */
        @Nullable
        public abstract T zza(zzkj zzkj) throws RemoteException;

        /* access modifiers changed from: protected */
        @Nullable
        public abstract T zzht() throws RemoteException;

        /* access modifiers changed from: protected */
        @Nullable
        public final T zzhu() {
            zzkj zza = zzja.this.zzhs();
            if (zza == null) {
                zzaiw.zzco("ClientApi class cannot be loaded.");
                return null;
            }
            try {
                return zza(zza);
            } catch (RemoteException e) {
                zzaiw.zzc("Cannot invoke local loader using ClientApi class", e);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        @Nullable
        public final T zzhv() {
            try {
                return zzht();
            } catch (RemoteException e) {
                zzaiw.zzc("Cannot invoke remote loader", e);
                return null;
            }
        }
    }

    public zzja(zzir zzir, zziq zziq, zzlk zzlk, zzqn zzqn, zzacz zzacz, zzwi zzwi, zzqo zzqo) {
        this.zzbdi = zzir;
        this.zzbdj = zziq;
        this.zzbdk = zzlk;
        this.zzbdl = zzqn;
        this.zzbdm = zzacz;
        this.zzbdn = zzwi;
        this.zzbdo = zzqo;
    }

    @VisibleForTesting
    static <T> T zza(Context context, boolean z, zza<T> zza2) {
        boolean z2 = true;
        if (!z) {
            zzjk.zzhx();
            if (!zzais.zzbd(context)) {
                zzaiw.zzbw("Google Play Services is not available");
                z = true;
            }
        }
        zzjk.zzhx();
        int zzav = zzais.zzav(context);
        zzjk.zzhx();
        if (zzav <= zzais.zzau(context)) {
            z2 = z;
        }
        if (z2) {
            T zzhu = zza2.zzhu();
            return zzhu == null ? zza2.zzhv() : zzhu;
        }
        T zzhv = zza2.zzhv();
        return zzhv == null ? zza2.zzhu() : zzhv;
    }

    /* access modifiers changed from: private */
    public static void zza(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzjk.zzhx().zza(context, (String) null, "gmob-apps", bundle, true);
    }

    @Nullable
    private static zzkj zzhr() {
        try {
            Object newInstance = zzja.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").newInstance();
            if (newInstance instanceof IBinder) {
                return zzkk.asInterface((IBinder) newInstance);
            }
            zzaiw.zzco("ClientApi class is not an instance of IBinder");
            return null;
        } catch (Exception e) {
            zzaiw.zzc("Failed to instantiate ClientApi class.", e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    @Nullable
    public final zzkj zzhs() {
        zzkj zzkj;
        synchronized (this.mLock) {
            if (this.zzbdh == null) {
                this.zzbdh = zzhr();
            }
            zzkj = this.zzbdh;
        }
        return zzkj;
    }

    public final zzpc zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzpc) zza(context, false, new zzjg(this, frameLayout, frameLayout2, context));
    }

    public final zzph zza(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        return (zzph) zza(view.getContext(), false, new zzjh(this, view, hashMap, hashMap2));
    }

    public final zzjw zzb(Context context, String str, zzuc zzuc) {
        return (zzjw) zza(context, false, new zzje(this, context, str, zzuc));
    }

    @Nullable
    public final zzwj zzb(Activity activity) {
        boolean z = false;
        Intent intent = activity.getIntent();
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzaiw.m12e("useClientJar flag not found in activity intent extras.");
        } else {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return (zzwj) zza((Context) activity, z, new zzjj(this, activity));
    }
}
