package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

@zzzb
public final class zznz extends zzoe {
    private Object mLock;
    @Nullable
    private zzuo zzbst;
    @Nullable
    private zzur zzbsu;
    private final zzob zzbsv;
    @Nullable
    private zzoa zzbsw;
    private boolean zzbsx;

    private zznz(Context context, zzob zzob, zzcs zzcs, zzoc zzoc) {
        super(context, zzob, (zzyg) null, zzcs, (JSONObject) null, zzoc, (zzaiy) null, (String) null);
        this.zzbsx = false;
        this.mLock = new Object();
        this.zzbsv = zzob;
    }

    public zznz(Context context, zzob zzob, zzcs zzcs, zzuo zzuo, zzoc zzoc) {
        this(context, zzob, zzcs, zzoc);
        this.zzbst = zzuo;
    }

    public zznz(Context context, zzob zzob, zzcs zzcs, zzur zzur, zzoc zzoc) {
        this(context, zzob, zzcs, zzoc);
        this.zzbsu = zzur;
    }

    @Nullable
    public final View zza(View.OnClickListener onClickListener, boolean z) {
        IObjectWrapper iObjectWrapper;
        synchronized (this.mLock) {
            if (this.zzbsw != null) {
                View zza = this.zzbsw.zza(onClickListener, z);
                return zza;
            }
            try {
                if (this.zzbst != null) {
                    iObjectWrapper = this.zzbst.zzme();
                } else {
                    if (this.zzbsu != null) {
                        iObjectWrapper = this.zzbsu.zzme();
                    }
                    iObjectWrapper = null;
                }
            } catch (RemoteException e) {
                zzafj.zzc("Failed to call getAdChoicesContent", e);
            }
            if (iObjectWrapper == null) {
                return null;
            }
            View view = (View) zzn.zzx(iObjectWrapper);
            return view;
        }
    }

    public final void zza(View view, Map<String, WeakReference<View>> map) {
        zzbq.zzga("recordImpression must be called on the main UI thread.");
        synchronized (this.mLock) {
            this.zzbtb = true;
            if (this.zzbsw != null) {
                this.zzbsw.zza(view, map);
                this.zzbsv.recordImpression();
            } else {
                try {
                    if (this.zzbst != null && !this.zzbst.getOverrideImpressionRecording()) {
                        this.zzbst.recordImpression();
                        this.zzbsv.recordImpression();
                    } else if (this.zzbsu != null && !this.zzbsu.getOverrideImpressionRecording()) {
                        this.zzbsu.recordImpression();
                        this.zzbsv.recordImpression();
                    }
                } catch (RemoteException e) {
                    zzafj.zzc("Failed to call recordImpression", e);
                }
            }
        }
    }

    public final void zza(View view, Map<String, WeakReference<View>> map, Bundle bundle, View view2) {
        zzbq.zzga("performClick must be called on the main UI thread.");
        synchronized (this.mLock) {
            if (this.zzbsw != null) {
                this.zzbsw.zza(view, map, bundle, view2);
                this.zzbsv.onAdClicked();
            } else {
                try {
                    if (this.zzbst != null && !this.zzbst.getOverrideClickHandling()) {
                        this.zzbst.zzh(zzn.zzy(view));
                        this.zzbsv.onAdClicked();
                    }
                    if (this.zzbsu != null && !this.zzbsu.getOverrideClickHandling()) {
                        this.zzbsu.zzh(zzn.zzy(view));
                        this.zzbsv.onAdClicked();
                    }
                } catch (RemoteException e) {
                    zzafj.zzc("Failed to call performClick", e);
                }
            }
        }
    }

    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        synchronized (this.mLock) {
            this.zzbsx = true;
            try {
                if (this.zzbst != null) {
                    this.zzbst.zzi(zzn.zzy(view));
                } else if (this.zzbsu != null) {
                    this.zzbsu.zzi(zzn.zzy(view));
                }
            } catch (RemoteException e) {
                zzafj.zzc("Failed to call prepareAd", e);
            }
            this.zzbsx = false;
        }
    }

    public final void zzb(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.mLock) {
            try {
                if (this.zzbst != null) {
                    this.zzbst.zzj(zzn.zzy(view));
                } else if (this.zzbsu != null) {
                    this.zzbsu.zzj(zzn.zzy(view));
                }
            } catch (RemoteException e) {
                zzafj.zzc("Failed to call untrackView", e);
            }
        }
    }

    public final void zzc(@Nullable zzoa zzoa) {
        synchronized (this.mLock) {
            this.zzbsw = zzoa;
        }
    }

    public final boolean zzjw() {
        boolean zzjw;
        synchronized (this.mLock) {
            zzjw = this.zzbsw != null ? this.zzbsw.zzjw() : this.zzbsv.zzcq();
        }
        return zzjw;
    }

    public final boolean zzjx() {
        boolean zzjx;
        synchronized (this.mLock) {
            zzjx = this.zzbsw != null ? this.zzbsw.zzjx() : this.zzbsv.zzcr();
        }
        return zzjx;
    }

    public final boolean zzjy() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzbsx;
        }
        return z;
    }

    public final zzoa zzjz() {
        zzoa zzoa;
        synchronized (this.mLock) {
            zzoa = this.zzbsw;
        }
        return zzoa;
    }

    @Nullable
    public final zzama zzka() {
        return null;
    }

    public final void zzkb() {
    }

    public final void zzkc() {
    }
}
