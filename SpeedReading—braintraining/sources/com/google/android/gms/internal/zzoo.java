package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.util.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@zzzb
public final class zzoo extends zzpd implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static String[] zzbto = {NativeAppInstallAd.ASSET_MEDIA_VIDEO, NativeContentAd.ASSET_MEDIA_VIDEO};
    private final Object mLock = new Object();
    @Nullable
    FrameLayout zzaln;
    @Nullable
    private zzoa zzbsk;
    /* access modifiers changed from: private */
    public final FrameLayout zzbtp;
    /* access modifiers changed from: private */
    public View zzbtq;
    /* access modifiers changed from: private */
    public final boolean zzbtr;
    private Map<String, WeakReference<View>> zzbts = new HashMap();
    @Nullable
    private View zzbtt;
    private boolean zzbtu = false;
    private Point zzbtv = new Point();
    private Point zzbtw = new Point();
    private WeakReference<zzfy> zzbtx = new WeakReference<>((Object) null);

    @TargetApi(21)
    public zzoo(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.zzbtp = frameLayout;
        this.zzaln = frameLayout2;
        zzbs.zzez();
        zzakg.zza((View) this.zzbtp, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzbs.zzez();
        zzakg.zza((View) this.zzbtp, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzbtp.setOnTouchListener(this);
        this.zzbtp.setOnClickListener(this);
        if (frameLayout2 != null && zzq.zzamc()) {
            frameLayout2.setElevation(Float.MAX_VALUE);
        }
        zzmq.initialize(this.zzbtp.getContext());
        this.zzbtr = ((Boolean) zzbs.zzep().zzd(zzmq.zzbne)).booleanValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.zzoe r7) {
        /*
            r6 = this;
            java.lang.Object r2 = r6.mLock
            monitor-enter(r2)
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r0 = r6.zzbts     // Catch:{ all -> 0x0042 }
            r7.zzg((java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>>) r0)     // Catch:{ all -> 0x0042 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r0 = r6.zzbts     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0032
            java.lang.String[] r3 = zzbto     // Catch:{ all -> 0x0042 }
            int r4 = r3.length     // Catch:{ all -> 0x0042 }
            r0 = 0
            r1 = r0
        L_0x0011:
            if (r1 >= r4) goto L_0x0032
            r0 = r3[r1]     // Catch:{ all -> 0x0042 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r5 = r6.zzbts     // Catch:{ all -> 0x0042 }
            java.lang.Object r0 = r5.get(r0)     // Catch:{ all -> 0x0042 }
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x002e
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0042 }
            android.view.View r0 = (android.view.View) r0     // Catch:{ all -> 0x0042 }
        L_0x0025:
            boolean r1 = r0 instanceof android.widget.FrameLayout     // Catch:{ all -> 0x0042 }
            if (r1 != 0) goto L_0x0034
            r7.zzkc()     // Catch:{ all -> 0x0042 }
            monitor-exit(r2)     // Catch:{ all -> 0x0042 }
        L_0x002d:
            return
        L_0x002e:
            int r0 = r1 + 1
            r1 = r0
            goto L_0x0011
        L_0x0032:
            r0 = 0
            goto L_0x0025
        L_0x0034:
            com.google.android.gms.internal.zzoq r1 = new com.google.android.gms.internal.zzoq     // Catch:{ all -> 0x0042 }
            r1.<init>(r6, r0)     // Catch:{ all -> 0x0042 }
            boolean r3 = r7 instanceof com.google.android.gms.internal.zznz     // Catch:{ all -> 0x0042 }
            if (r3 == 0) goto L_0x0045
            r7.zzb((android.view.View) r0, (com.google.android.gms.internal.zzny) r1)     // Catch:{ all -> 0x0042 }
        L_0x0040:
            monitor-exit(r2)     // Catch:{ all -> 0x0042 }
            goto L_0x002d
        L_0x0042:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0042 }
            throw r0
        L_0x0045:
            r7.zza((android.view.View) r0, (com.google.android.gms.internal.zzny) r1)     // Catch:{ all -> 0x0042 }
            goto L_0x0040
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzoo.zza(com.google.android.gms.internal.zzoe):void");
    }

    private final void zzg(@Nullable View view) {
        if (this.zzbsk != null) {
            zzoa zzjz = this.zzbsk instanceof zznz ? ((zznz) this.zzbsk).zzjz() : this.zzbsk;
            if (zzjz != null) {
                zzjz.zzg(view);
            }
        }
    }

    private final void zzkf() {
        synchronized (this.mLock) {
            if (!this.zzbtr && this.zzbtu) {
                int measuredWidth = this.zzbtp.getMeasuredWidth();
                int measuredHeight = this.zzbtp.getMeasuredHeight();
                if (!(measuredWidth == 0 || measuredHeight == 0 || this.zzaln == null)) {
                    this.zzaln.setLayoutParams(new FrameLayout.LayoutParams(measuredWidth, measuredHeight));
                    this.zzbtu = false;
                }
            }
        }
    }

    private final int zzt(int i) {
        zzjk.zzhx();
        return zzais.zzd(this.zzbsk.getContext(), i);
    }

    public final void destroy() {
        synchronized (this.mLock) {
            if (this.zzaln != null) {
                this.zzaln.removeAllViews();
            }
            this.zzaln = null;
            this.zzbts = null;
            this.zzbtt = null;
            this.zzbsk = null;
            this.zzbtv = null;
            this.zzbtw = null;
            this.zzbtx = null;
            this.zzbtq = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r8) {
        /*
            r7 = this;
            java.lang.Object r6 = r7.mLock
            monitor-enter(r6)
            com.google.android.gms.internal.zzoa r0 = r7.zzbsk     // Catch:{ all -> 0x0076 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r6)     // Catch:{ all -> 0x0076 }
        L_0x0008:
            return
        L_0x0009:
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x0076 }
            r3.<init>()     // Catch:{ all -> 0x0076 }
            java.lang.String r0 = "x"
            android.graphics.Point r1 = r7.zzbtv     // Catch:{ all -> 0x0076 }
            int r1 = r1.x     // Catch:{ all -> 0x0076 }
            int r1 = r7.zzt(r1)     // Catch:{ all -> 0x0076 }
            float r1 = (float) r1     // Catch:{ all -> 0x0076 }
            r3.putFloat(r0, r1)     // Catch:{ all -> 0x0076 }
            java.lang.String r0 = "y"
            android.graphics.Point r1 = r7.zzbtv     // Catch:{ all -> 0x0076 }
            int r1 = r1.y     // Catch:{ all -> 0x0076 }
            int r1 = r7.zzt(r1)     // Catch:{ all -> 0x0076 }
            float r1 = (float) r1     // Catch:{ all -> 0x0076 }
            r3.putFloat(r0, r1)     // Catch:{ all -> 0x0076 }
            java.lang.String r0 = "start_x"
            android.graphics.Point r1 = r7.zzbtw     // Catch:{ all -> 0x0076 }
            int r1 = r1.x     // Catch:{ all -> 0x0076 }
            int r1 = r7.zzt(r1)     // Catch:{ all -> 0x0076 }
            float r1 = (float) r1     // Catch:{ all -> 0x0076 }
            r3.putFloat(r0, r1)     // Catch:{ all -> 0x0076 }
            java.lang.String r0 = "start_y"
            android.graphics.Point r1 = r7.zzbtw     // Catch:{ all -> 0x0076 }
            int r1 = r1.y     // Catch:{ all -> 0x0076 }
            int r1 = r7.zzt(r1)     // Catch:{ all -> 0x0076 }
            float r1 = (float) r1     // Catch:{ all -> 0x0076 }
            r3.putFloat(r0, r1)     // Catch:{ all -> 0x0076 }
            android.view.View r0 = r7.zzbtt     // Catch:{ all -> 0x0076 }
            if (r0 == 0) goto L_0x0086
            android.view.View r0 = r7.zzbtt     // Catch:{ all -> 0x0076 }
            boolean r0 = r0.equals(r8)     // Catch:{ all -> 0x0076 }
            if (r0 == 0) goto L_0x0086
            com.google.android.gms.internal.zzoa r0 = r7.zzbsk     // Catch:{ all -> 0x0076 }
            boolean r0 = r0 instanceof com.google.android.gms.internal.zznz     // Catch:{ all -> 0x0076 }
            if (r0 == 0) goto L_0x0079
            com.google.android.gms.internal.zzoa r0 = r7.zzbsk     // Catch:{ all -> 0x0076 }
            com.google.android.gms.internal.zznz r0 = (com.google.android.gms.internal.zznz) r0     // Catch:{ all -> 0x0076 }
            com.google.android.gms.internal.zzoa r0 = r0.zzjz()     // Catch:{ all -> 0x0076 }
            if (r0 == 0) goto L_0x0074
            com.google.android.gms.internal.zzoa r0 = r7.zzbsk     // Catch:{ all -> 0x0076 }
            com.google.android.gms.internal.zznz r0 = (com.google.android.gms.internal.zznz) r0     // Catch:{ all -> 0x0076 }
            com.google.android.gms.internal.zzoa r0 = r0.zzjz()     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = "1007"
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r7.zzbts     // Catch:{ all -> 0x0076 }
            android.widget.FrameLayout r5 = r7.zzbtp     // Catch:{ all -> 0x0076 }
            r1 = r8
            r0.zza(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0076 }
        L_0x0074:
            monitor-exit(r6)     // Catch:{ all -> 0x0076 }
            goto L_0x0008
        L_0x0076:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0076 }
            throw r0
        L_0x0079:
            com.google.android.gms.internal.zzoa r0 = r7.zzbsk     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = "1007"
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r7.zzbts     // Catch:{ all -> 0x0076 }
            android.widget.FrameLayout r5 = r7.zzbtp     // Catch:{ all -> 0x0076 }
            r1 = r8
            r0.zza(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0076 }
            goto L_0x0074
        L_0x0086:
            com.google.android.gms.internal.zzoa r0 = r7.zzbsk     // Catch:{ all -> 0x0076 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r1 = r7.zzbts     // Catch:{ all -> 0x0076 }
            android.widget.FrameLayout r2 = r7.zzbtp     // Catch:{ all -> 0x0076 }
            r0.zza(r8, r1, r3, r2)     // Catch:{ all -> 0x0076 }
            goto L_0x0074
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzoo.onClick(android.view.View):void");
    }

    public final void onGlobalLayout() {
        synchronized (this.mLock) {
            zzkf();
            if (this.zzbsk != null) {
                this.zzbsk.zzc(this.zzbtp, this.zzbts);
            }
        }
    }

    public final void onScrollChanged() {
        synchronized (this.mLock) {
            if (this.zzbsk != null) {
                this.zzbsk.zzc(this.zzbtp, this.zzbts);
            }
            zzkf();
        }
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.mLock) {
            if (this.zzbsk != null) {
                int[] iArr = new int[2];
                this.zzbtp.getLocationOnScreen(iArr);
                Point point = new Point((int) (motionEvent.getRawX() - ((float) iArr[0])), (int) (motionEvent.getRawY() - ((float) iArr[1])));
                this.zzbtv = point;
                if (motionEvent.getAction() == 0) {
                    this.zzbtw = point;
                }
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setLocation((float) point.x, (float) point.y);
                this.zzbsk.zzd(obtain);
                obtain.recycle();
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.dynamic.IObjectWrapper r11) {
        /*
            r10 = this;
            r3 = 1
            r5 = 0
            r4 = 0
            java.lang.Object r7 = r10.mLock
            monitor-enter(r7)
            r1 = 0
            r10.zzg(r1)     // Catch:{ all -> 0x00af }
            java.lang.Object r1 = com.google.android.gms.dynamic.zzn.zzx(r11)     // Catch:{ all -> 0x00af }
            boolean r2 = r1 instanceof com.google.android.gms.internal.zzoe     // Catch:{ all -> 0x00af }
            if (r2 != 0) goto L_0x0019
            java.lang.String r1 = "Not an instance of native engine. This is most likely a transient error"
            com.google.android.gms.internal.zzafj.zzco(r1)     // Catch:{ all -> 0x00af }
            monitor-exit(r7)     // Catch:{ all -> 0x00af }
        L_0x0018:
            return
        L_0x0019:
            boolean r2 = r10.zzbtr     // Catch:{ all -> 0x00af }
            if (r2 != 0) goto L_0x0032
            android.widget.FrameLayout r2 = r10.zzaln     // Catch:{ all -> 0x00af }
            if (r2 == 0) goto L_0x0032
            android.widget.FrameLayout r2 = r10.zzaln     // Catch:{ all -> 0x00af }
            android.widget.FrameLayout$LayoutParams r6 = new android.widget.FrameLayout$LayoutParams     // Catch:{ all -> 0x00af }
            r8 = 0
            r9 = 0
            r6.<init>(r8, r9)     // Catch:{ all -> 0x00af }
            r2.setLayoutParams(r6)     // Catch:{ all -> 0x00af }
            android.widget.FrameLayout r2 = r10.zzbtp     // Catch:{ all -> 0x00af }
            r2.requestLayout()     // Catch:{ all -> 0x00af }
        L_0x0032:
            r2 = 1
            r10.zzbtu = r2     // Catch:{ all -> 0x00af }
            com.google.android.gms.internal.zzoe r1 = (com.google.android.gms.internal.zzoe) r1     // Catch:{ all -> 0x00af }
            com.google.android.gms.internal.zzoa r2 = r10.zzbsk     // Catch:{ all -> 0x00af }
            if (r2 == 0) goto L_0x0056
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r2 = com.google.android.gms.internal.zzmq.zzbmx     // Catch:{ all -> 0x00af }
            com.google.android.gms.internal.zzmo r6 = com.google.android.gms.ads.internal.zzbs.zzep()     // Catch:{ all -> 0x00af }
            java.lang.Object r2 = r6.zzd(r2)     // Catch:{ all -> 0x00af }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x00af }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x00af }
            if (r2 == 0) goto L_0x0056
            com.google.android.gms.internal.zzoa r2 = r10.zzbsk     // Catch:{ all -> 0x00af }
            android.widget.FrameLayout r6 = r10.zzbtp     // Catch:{ all -> 0x00af }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r8 = r10.zzbts     // Catch:{ all -> 0x00af }
            r2.zzb(r6, r8)     // Catch:{ all -> 0x00af }
        L_0x0056:
            com.google.android.gms.internal.zzoa r2 = r10.zzbsk     // Catch:{ all -> 0x00af }
            boolean r2 = r2 instanceof com.google.android.gms.internal.zzoe     // Catch:{ all -> 0x00af }
            if (r2 == 0) goto L_0x0091
            com.google.android.gms.internal.zzoa r2 = r10.zzbsk     // Catch:{ all -> 0x00af }
            com.google.android.gms.internal.zzoe r2 = (com.google.android.gms.internal.zzoe) r2     // Catch:{ all -> 0x00af }
            if (r2 == 0) goto L_0x0091
            android.content.Context r6 = r2.getContext()     // Catch:{ all -> 0x00af }
            if (r6 == 0) goto L_0x0091
            com.google.android.gms.internal.zzael r6 = com.google.android.gms.ads.internal.zzbs.zzfa()     // Catch:{ all -> 0x00af }
            android.widget.FrameLayout r8 = r10.zzbtp     // Catch:{ all -> 0x00af }
            android.content.Context r8 = r8.getContext()     // Catch:{ all -> 0x00af }
            boolean r6 = r6.zzt(r8)     // Catch:{ all -> 0x00af }
            if (r6 == 0) goto L_0x0091
            com.google.android.gms.internal.zzaek r6 = r2.zzke()     // Catch:{ all -> 0x00af }
            if (r6 == 0) goto L_0x0082
            r2 = 0
            r6.zzu(r2)     // Catch:{ all -> 0x00af }
        L_0x0082:
            java.lang.ref.WeakReference<com.google.android.gms.internal.zzfy> r2 = r10.zzbtx     // Catch:{ all -> 0x00af }
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x00af }
            com.google.android.gms.internal.zzfy r2 = (com.google.android.gms.internal.zzfy) r2     // Catch:{ all -> 0x00af }
            if (r2 == 0) goto L_0x0091
            if (r6 == 0) goto L_0x0091
            r2.zzb(r6)     // Catch:{ all -> 0x00af }
        L_0x0091:
            com.google.android.gms.internal.zzoa r2 = r10.zzbsk     // Catch:{ all -> 0x00af }
            boolean r2 = r2 instanceof com.google.android.gms.internal.zznz     // Catch:{ all -> 0x00af }
            if (r2 == 0) goto L_0x00b2
            com.google.android.gms.internal.zzoa r2 = r10.zzbsk     // Catch:{ all -> 0x00af }
            com.google.android.gms.internal.zznz r2 = (com.google.android.gms.internal.zznz) r2     // Catch:{ all -> 0x00af }
            boolean r2 = r2.zzjy()     // Catch:{ all -> 0x00af }
            if (r2 == 0) goto L_0x00b2
            com.google.android.gms.internal.zzoa r2 = r10.zzbsk     // Catch:{ all -> 0x00af }
            com.google.android.gms.internal.zznz r2 = (com.google.android.gms.internal.zznz) r2     // Catch:{ all -> 0x00af }
            r2.zzc(r1)     // Catch:{ all -> 0x00af }
        L_0x00a8:
            android.widget.FrameLayout r2 = r10.zzaln     // Catch:{ all -> 0x00af }
            if (r2 != 0) goto L_0x00c1
            monitor-exit(r7)     // Catch:{ all -> 0x00af }
            goto L_0x0018
        L_0x00af:
            r1 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00af }
            throw r1
        L_0x00b2:
            r10.zzbsk = r1     // Catch:{ all -> 0x00af }
            boolean r2 = r1 instanceof com.google.android.gms.internal.zznz     // Catch:{ all -> 0x00af }
            if (r2 == 0) goto L_0x00a8
            r0 = r1
            com.google.android.gms.internal.zznz r0 = (com.google.android.gms.internal.zznz) r0     // Catch:{ all -> 0x00af }
            r2 = r0
            r6 = 0
            r2.zzc(r6)     // Catch:{ all -> 0x00af }
            goto L_0x00a8
        L_0x00c1:
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r2 = com.google.android.gms.internal.zzmq.zzbmx     // Catch:{ all -> 0x00af }
            com.google.android.gms.internal.zzmo r6 = com.google.android.gms.ads.internal.zzbs.zzep()     // Catch:{ all -> 0x00af }
            java.lang.Object r2 = r6.zzd(r2)     // Catch:{ all -> 0x00af }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x00af }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x00af }
            if (r2 == 0) goto L_0x00d9
            android.widget.FrameLayout r2 = r10.zzaln     // Catch:{ all -> 0x00af }
            r6 = 0
            r2.setClickable(r6)     // Catch:{ all -> 0x00af }
        L_0x00d9:
            android.widget.FrameLayout r2 = r10.zzaln     // Catch:{ all -> 0x00af }
            r2.removeAllViews()     // Catch:{ all -> 0x00af }
            boolean r6 = r1.zzjw()     // Catch:{ all -> 0x00af }
            if (r6 == 0) goto L_0x0101
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r2 = r10.zzbts     // Catch:{ all -> 0x00af }
            if (r2 == 0) goto L_0x0101
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r2 = r10.zzbts     // Catch:{ all -> 0x00af }
            java.lang.String r8 = "1098"
            java.lang.Object r2 = r2.get(r8)     // Catch:{ all -> 0x00af }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x00af }
            if (r2 == 0) goto L_0x018f
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x00af }
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x00af }
        L_0x00fa:
            boolean r8 = r2 instanceof android.view.ViewGroup     // Catch:{ all -> 0x00af }
            if (r8 == 0) goto L_0x0101
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2     // Catch:{ all -> 0x00af }
            r5 = r2
        L_0x0101:
            if (r6 == 0) goto L_0x0192
            if (r5 == 0) goto L_0x0192
            r2 = r3
        L_0x0106:
            android.view.View r3 = r1.zza((android.view.View.OnClickListener) r10, (boolean) r2)     // Catch:{ all -> 0x00af }
            r10.zzbtt = r3     // Catch:{ all -> 0x00af }
            android.view.View r3 = r10.zzbtt     // Catch:{ all -> 0x00af }
            if (r3 == 0) goto L_0x012c
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r10.zzbts     // Catch:{ all -> 0x00af }
            if (r3 == 0) goto L_0x0122
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r10.zzbts     // Catch:{ all -> 0x00af }
            java.lang.String r4 = "1007"
            java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x00af }
            android.view.View r8 = r10.zzbtt     // Catch:{ all -> 0x00af }
            r6.<init>(r8)     // Catch:{ all -> 0x00af }
            r3.put(r4, r6)     // Catch:{ all -> 0x00af }
        L_0x0122:
            if (r2 == 0) goto L_0x0195
            r5.removeAllViews()     // Catch:{ all -> 0x00af }
            android.view.View r2 = r10.zzbtt     // Catch:{ all -> 0x00af }
            r5.addView(r2)     // Catch:{ all -> 0x00af }
        L_0x012c:
            android.widget.FrameLayout r2 = r10.zzbtp     // Catch:{ all -> 0x00af }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r10.zzbts     // Catch:{ all -> 0x00af }
            r4 = 0
            r5 = r10
            r6 = r10
            r1.zza((android.view.View) r2, (java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>>) r3, (java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>>) r4, (android.view.View.OnTouchListener) r5, (android.view.View.OnClickListener) r6)     // Catch:{ all -> 0x00af }
            android.os.Handler r2 = com.google.android.gms.internal.zzagr.zzczc     // Catch:{ all -> 0x00af }
            com.google.android.gms.internal.zzop r3 = new com.google.android.gms.internal.zzop     // Catch:{ all -> 0x00af }
            r3.<init>(r10, r1)     // Catch:{ all -> 0x00af }
            r2.post(r3)     // Catch:{ all -> 0x00af }
            android.widget.FrameLayout r1 = r10.zzbtp     // Catch:{ all -> 0x00af }
            r10.zzg(r1)     // Catch:{ all -> 0x00af }
            com.google.android.gms.internal.zzoa r1 = r10.zzbsk     // Catch:{ all -> 0x00af }
            boolean r1 = r1 instanceof com.google.android.gms.internal.zzoe     // Catch:{ all -> 0x00af }
            if (r1 == 0) goto L_0x018c
            com.google.android.gms.internal.zzoa r1 = r10.zzbsk     // Catch:{ all -> 0x00af }
            com.google.android.gms.internal.zzoe r1 = (com.google.android.gms.internal.zzoe) r1     // Catch:{ all -> 0x00af }
            if (r1 == 0) goto L_0x018c
            android.content.Context r2 = r1.getContext()     // Catch:{ all -> 0x00af }
            if (r2 == 0) goto L_0x018c
            com.google.android.gms.internal.zzael r2 = com.google.android.gms.ads.internal.zzbs.zzfa()     // Catch:{ all -> 0x00af }
            android.widget.FrameLayout r3 = r10.zzbtp     // Catch:{ all -> 0x00af }
            android.content.Context r3 = r3.getContext()     // Catch:{ all -> 0x00af }
            boolean r2 = r2.zzt(r3)     // Catch:{ all -> 0x00af }
            if (r2 == 0) goto L_0x018c
            java.lang.ref.WeakReference<com.google.android.gms.internal.zzfy> r2 = r10.zzbtx     // Catch:{ all -> 0x00af }
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x00af }
            com.google.android.gms.internal.zzfy r2 = (com.google.android.gms.internal.zzfy) r2     // Catch:{ all -> 0x00af }
            if (r2 != 0) goto L_0x0185
            com.google.android.gms.internal.zzfy r2 = new com.google.android.gms.internal.zzfy     // Catch:{ all -> 0x00af }
            android.widget.FrameLayout r3 = r10.zzbtp     // Catch:{ all -> 0x00af }
            android.content.Context r3 = r3.getContext()     // Catch:{ all -> 0x00af }
            android.widget.FrameLayout r4 = r10.zzbtp     // Catch:{ all -> 0x00af }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x00af }
            java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x00af }
            r3.<init>(r2)     // Catch:{ all -> 0x00af }
            r10.zzbtx = r3     // Catch:{ all -> 0x00af }
        L_0x0185:
            com.google.android.gms.internal.zzaek r1 = r1.zzke()     // Catch:{ all -> 0x00af }
            r2.zza((com.google.android.gms.internal.zzgc) r1)     // Catch:{ all -> 0x00af }
        L_0x018c:
            monitor-exit(r7)     // Catch:{ all -> 0x00af }
            goto L_0x0018
        L_0x018f:
            r2 = r5
            goto L_0x00fa
        L_0x0192:
            r2 = r4
            goto L_0x0106
        L_0x0195:
            android.content.Context r2 = r1.getContext()     // Catch:{ all -> 0x00af }
            com.google.android.gms.ads.formats.AdChoicesView r3 = new com.google.android.gms.ads.formats.AdChoicesView     // Catch:{ all -> 0x00af }
            r3.<init>(r2)     // Catch:{ all -> 0x00af }
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams     // Catch:{ all -> 0x00af }
            r4 = -1
            r5 = -1
            r2.<init>(r4, r5)     // Catch:{ all -> 0x00af }
            r3.setLayoutParams(r2)     // Catch:{ all -> 0x00af }
            android.view.View r2 = r10.zzbtt     // Catch:{ all -> 0x00af }
            r3.addView(r2)     // Catch:{ all -> 0x00af }
            android.widget.FrameLayout r2 = r10.zzaln     // Catch:{ all -> 0x00af }
            if (r2 == 0) goto L_0x012c
            android.widget.FrameLayout r2 = r10.zzaln     // Catch:{ all -> 0x00af }
            r2.addView(r3)     // Catch:{ all -> 0x00af }
            goto L_0x012c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzoo.zza(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final IObjectWrapper zzak(String str) {
        View view = null;
        synchronized (this.mLock) {
            if (this.zzbts == null) {
                return null;
            }
            WeakReference weakReference = this.zzbts.get(str);
            if (weakReference != null) {
                view = (View) weakReference.get();
            }
            IObjectWrapper zzy = zzn.zzy(view);
            return zzy;
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper, int i) {
        zzfy zzfy;
        if (!(!zzbs.zzfa().zzt(this.zzbtp.getContext()) || this.zzbtx == null || (zzfy = (zzfy) this.zzbtx.get()) == null)) {
            zzfy.zzgf();
        }
        zzkf();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(java.lang.String r5, com.google.android.gms.dynamic.IObjectWrapper r6) {
        /*
            r4 = this;
            java.lang.Object r0 = com.google.android.gms.dynamic.zzn.zzx(r6)
            android.view.View r0 = (android.view.View) r0
            java.lang.Object r1 = r4.mLock
            monitor-enter(r1)
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r2 = r4.zzbts     // Catch:{ all -> 0x0018 }
            if (r2 != 0) goto L_0x000f
            monitor-exit(r1)     // Catch:{ all -> 0x0018 }
        L_0x000e:
            return
        L_0x000f:
            if (r0 != 0) goto L_0x001b
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r0 = r4.zzbts     // Catch:{ all -> 0x0018 }
            r0.remove(r5)     // Catch:{ all -> 0x0018 }
        L_0x0016:
            monitor-exit(r1)     // Catch:{ all -> 0x0018 }
            goto L_0x000e
        L_0x0018:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0018 }
            throw r0
        L_0x001b:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r2 = r4.zzbts     // Catch:{ all -> 0x0018 }
            java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0018 }
            r3.<init>(r0)     // Catch:{ all -> 0x0018 }
            r2.put(r5, r3)     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = "1098"
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x0018 }
            if (r2 == 0) goto L_0x002f
            monitor-exit(r1)     // Catch:{ all -> 0x0018 }
            goto L_0x000e
        L_0x002f:
            r0.setOnTouchListener(r4)     // Catch:{ all -> 0x0018 }
            r2 = 1
            r0.setClickable(r2)     // Catch:{ all -> 0x0018 }
            r0.setOnClickListener(r4)     // Catch:{ all -> 0x0018 }
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzoo.zzb(java.lang.String, com.google.android.gms.dynamic.IObjectWrapper):void");
    }
}
