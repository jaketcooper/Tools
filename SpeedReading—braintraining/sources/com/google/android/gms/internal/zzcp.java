package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.gms.ads.internal.zzbs;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zzcp implements zzco {
    protected MotionEvent zzagq;
    protected LinkedList<MotionEvent> zzagr = new LinkedList<>();
    protected long zzags = 0;
    protected long zzagt = 0;
    protected long zzagu = 0;
    protected long zzagv = 0;
    protected long zzagw = 0;
    protected long zzagx = 0;
    protected long zzagy = 0;
    protected double zzagz;
    private double zzaha;
    private double zzahb;
    protected float zzahc;
    protected float zzahd;
    protected float zzahe;
    protected float zzahf;
    private boolean zzahg = false;
    protected boolean zzahh = false;
    protected DisplayMetrics zzahi;

    protected zzcp(Context context) {
        try {
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzbmc)).booleanValue()) {
                zzbt.zzx();
            } else {
                zzbw.zzz();
            }
            this.zzahi = context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
        }
    }

    private final String zza(Context context, String str, boolean z, View view, byte[] bArr) {
        zzaw zza;
        if (z) {
            try {
                zza = zza(context, view);
                this.zzahg = true;
            } catch (UnsupportedEncodingException | GeneralSecurityException e) {
                return Integer.toString(7);
            } catch (Throwable th) {
                return Integer.toString(3);
            }
        } else {
            zza = zza(context, (zzat) null);
        }
        return (zza == null || zza.zzhl() == 0) ? Integer.toString(5) : zzbt.zza(zza, str);
    }

    /* access modifiers changed from: protected */
    public abstract long zza(StackTraceElement[] stackTraceElementArr) throws zzcx;

    /* access modifiers changed from: protected */
    public abstract zzaw zza(Context context, View view);

    /* access modifiers changed from: protected */
    public abstract zzaw zza(Context context, zzat zzat);

    public final String zza(Context context) {
        if (zzdf.zzas()) {
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzbme)).booleanValue()) {
                throw new IllegalStateException("The caller must not be called from the UI thread.");
            }
        }
        return zza(context, (String) null, false, (View) null, (byte[]) null);
    }

    public final String zza(Context context, String str, View view) {
        return zza(context, str, true, view, (byte[]) null);
    }

    public final void zza(int i, int i2, int i3) {
        if (this.zzagq != null) {
            this.zzagq.recycle();
        }
        if (this.zzahi != null) {
            this.zzagq = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.zzahi.density, ((float) i2) * this.zzahi.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.zzagq = null;
        }
        this.zzahh = false;
    }

    public final void zza(MotionEvent motionEvent) {
        if (this.zzahg) {
            this.zzagv = 0;
            this.zzagu = 0;
            this.zzagt = 0;
            this.zzags = 0;
            this.zzagw = 0;
            this.zzagy = 0;
            this.zzagx = 0;
            Iterator it = this.zzagr.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.zzagr.clear();
            this.zzagq = null;
            this.zzahg = false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.zzagz = Utils.DOUBLE_EPSILON;
                this.zzaha = (double) motionEvent.getRawX();
                this.zzahb = (double) motionEvent.getRawY();
                break;
            case 1:
            case 2:
                double rawX = (double) motionEvent.getRawX();
                double rawY = (double) motionEvent.getRawY();
                double d = rawX - this.zzaha;
                double d2 = rawY - this.zzahb;
                this.zzagz = Math.sqrt((d * d) + (d2 * d2)) + this.zzagz;
                this.zzaha = rawX;
                this.zzahb = rawY;
                break;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((Boolean) zzbs.zzep().zzd(zzmq.zzblz)).booleanValue()) {
                    this.zzahc = motionEvent.getX();
                    this.zzahd = motionEvent.getY();
                    this.zzahe = motionEvent.getRawX();
                    this.zzahf = motionEvent.getRawY();
                }
                this.zzags++;
                break;
            case 1:
                this.zzagq = MotionEvent.obtain(motionEvent);
                this.zzagr.add(this.zzagq);
                if (this.zzagr.size() > 6) {
                    this.zzagr.remove().recycle();
                }
                this.zzagu++;
                try {
                    this.zzagw = zza(new Throwable().getStackTrace());
                    break;
                } catch (zzcx e) {
                    break;
                }
            case 2:
                this.zzagt += (long) (motionEvent.getHistorySize() + 1);
                try {
                    zzde zzb = zzb(motionEvent);
                    if ((zzb == null || zzb.zzff == null || zzb.zzajd == null) ? false : true) {
                        this.zzagx += zzb.zzff.longValue() + zzb.zzajd.longValue();
                    }
                    if ((this.zzahi == null || zzb == null || zzb.zzfd == null || zzb.zzaje == null) ? false : true) {
                        this.zzagy = zzb.zzaje.longValue() + zzb.zzfd.longValue() + this.zzagy;
                        break;
                    }
                } catch (zzcx e2) {
                    break;
                }
                break;
            case 3:
                this.zzagv++;
                break;
        }
        this.zzahh = true;
    }

    /* access modifiers changed from: protected */
    public abstract zzde zzb(MotionEvent motionEvent) throws zzcx;
}
