package com.google.android.gms.internal;

import android.graphics.Point;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@zzzb
public final class zzor extends zzpi implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    static final String[] zzbto = {NativeAppInstallAd.ASSET_MEDIA_VIDEO, NativeContentAd.ASSET_MEDIA_VIDEO};
    private final Object mLock = new Object();
    @Nullable
    private zzoa zzbsk;
    @Nullable
    private View zzbtt;
    private Point zzbtv = new Point();
    private Point zzbtw = new Point();
    @Nullable
    private WeakReference<zzfy> zzbtx = new WeakReference<>((Object) null);
    private final WeakReference<View> zzbub;
    private final Map<String, WeakReference<View>> zzbuc = new HashMap();
    private final Map<String, WeakReference<View>> zzbud = new HashMap();
    private final Map<String, WeakReference<View>> zzbue = new HashMap();

    public zzor(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        zzbs.zzez();
        zzakg.zza(view, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzbs.zzez();
        zzakg.zza(view, (ViewTreeObserver.OnScrollChangedListener) this);
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        this.zzbub = new WeakReference<>(view);
        zzh(hashMap);
        this.zzbue.putAll(this.zzbuc);
        zzi(hashMap2);
        this.zzbue.putAll(this.zzbud);
        zzmq.initialize(view.getContext());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.zzoe r7) {
        /*
            r6 = this;
            java.lang.Object r2 = r6.mLock
            monitor-enter(r2)
            java.lang.String[] r3 = zzbto     // Catch:{ all -> 0x0039 }
            int r4 = r3.length     // Catch:{ all -> 0x0039 }
            r0 = 0
            r1 = r0
        L_0x0008:
            if (r1 >= r4) goto L_0x0029
            r0 = r3[r1]     // Catch:{ all -> 0x0039 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r5 = r6.zzbue     // Catch:{ all -> 0x0039 }
            java.lang.Object r0 = r5.get(r0)     // Catch:{ all -> 0x0039 }
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0025
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0039 }
            android.view.View r0 = (android.view.View) r0     // Catch:{ all -> 0x0039 }
        L_0x001c:
            boolean r1 = r0 instanceof android.widget.FrameLayout     // Catch:{ all -> 0x0039 }
            if (r1 != 0) goto L_0x002b
            r7.zzkc()     // Catch:{ all -> 0x0039 }
            monitor-exit(r2)     // Catch:{ all -> 0x0039 }
        L_0x0024:
            return
        L_0x0025:
            int r0 = r1 + 1
            r1 = r0
            goto L_0x0008
        L_0x0029:
            r0 = 0
            goto L_0x001c
        L_0x002b:
            com.google.android.gms.internal.zzot r1 = new com.google.android.gms.internal.zzot     // Catch:{ all -> 0x0039 }
            r1.<init>(r6, r0)     // Catch:{ all -> 0x0039 }
            boolean r3 = r7 instanceof com.google.android.gms.internal.zznz     // Catch:{ all -> 0x0039 }
            if (r3 == 0) goto L_0x003c
            r7.zzb((android.view.View) r0, (com.google.android.gms.internal.zzny) r1)     // Catch:{ all -> 0x0039 }
        L_0x0037:
            monitor-exit(r2)     // Catch:{ all -> 0x0039 }
            goto L_0x0024
        L_0x0039:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0039 }
            throw r0
        L_0x003c:
            r7.zza((android.view.View) r0, (com.google.android.gms.internal.zzny) r1)     // Catch:{ all -> 0x0039 }
            goto L_0x0037
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzor.zza(com.google.android.gms.internal.zzoe):void");
    }

    /* access modifiers changed from: private */
    public final boolean zza(String[] strArr) {
        for (String str : strArr) {
            if (this.zzbuc.get(str) != null) {
                return true;
            }
        }
        for (String str2 : strArr) {
            if (this.zzbud.get(str2) != null) {
                return false;
            }
        }
        return false;
    }

    private final void zzg(@Nullable View view) {
        synchronized (this.mLock) {
            if (this.zzbsk != null) {
                zzoa zzjz = this.zzbsk instanceof zznz ? ((zznz) this.zzbsk).zzjz() : this.zzbsk;
                if (zzjz != null) {
                    zzjz.zzg(view);
                }
            }
        }
    }

    private final void zzh(Map<String, View> map) {
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            View view = (View) next.getValue();
            if (view != null) {
                this.zzbuc.put(str, new WeakReference(view));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str)) {
                    view.setOnTouchListener(this);
                    view.setClickable(true);
                    view.setOnClickListener(this);
                }
            }
        }
    }

    private final void zzi(Map<String, View> map) {
        for (Map.Entry next : map.entrySet()) {
            View view = (View) next.getValue();
            if (view != null) {
                this.zzbud.put((String) next.getKey(), new WeakReference(view));
                view.setOnTouchListener(this);
            }
        }
    }

    private final int zzt(int i) {
        int zzd;
        synchronized (this.mLock) {
            zzjk.zzhx();
            zzd = zzais.zzd(this.zzbsk.getContext(), i);
        }
        return zzd;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r8) {
        /*
            r7 = this;
            java.lang.Object r6 = r7.mLock
            monitor-enter(r6)
            com.google.android.gms.internal.zzoa r0 = r7.zzbsk     // Catch:{ all -> 0x0015 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r6)     // Catch:{ all -> 0x0015 }
        L_0x0008:
            return
        L_0x0009:
            java.lang.ref.WeakReference<android.view.View> r0 = r7.zzbub     // Catch:{ all -> 0x0015 }
            java.lang.Object r5 = r0.get()     // Catch:{ all -> 0x0015 }
            android.view.View r5 = (android.view.View) r5     // Catch:{ all -> 0x0015 }
            if (r5 != 0) goto L_0x0018
            monitor-exit(r6)     // Catch:{ all -> 0x0015 }
            goto L_0x0008
        L_0x0015:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0015 }
            throw r0
        L_0x0018:
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x0015 }
            r3.<init>()     // Catch:{ all -> 0x0015 }
            java.lang.String r0 = "x"
            android.graphics.Point r1 = r7.zzbtv     // Catch:{ all -> 0x0015 }
            int r1 = r1.x     // Catch:{ all -> 0x0015 }
            int r1 = r7.zzt(r1)     // Catch:{ all -> 0x0015 }
            float r1 = (float) r1     // Catch:{ all -> 0x0015 }
            r3.putFloat(r0, r1)     // Catch:{ all -> 0x0015 }
            java.lang.String r0 = "y"
            android.graphics.Point r1 = r7.zzbtv     // Catch:{ all -> 0x0015 }
            int r1 = r1.y     // Catch:{ all -> 0x0015 }
            int r1 = r7.zzt(r1)     // Catch:{ all -> 0x0015 }
            float r1 = (float) r1     // Catch:{ all -> 0x0015 }
            r3.putFloat(r0, r1)     // Catch:{ all -> 0x0015 }
            java.lang.String r0 = "start_x"
            android.graphics.Point r1 = r7.zzbtw     // Catch:{ all -> 0x0015 }
            int r1 = r1.x     // Catch:{ all -> 0x0015 }
            int r1 = r7.zzt(r1)     // Catch:{ all -> 0x0015 }
            float r1 = (float) r1     // Catch:{ all -> 0x0015 }
            r3.putFloat(r0, r1)     // Catch:{ all -> 0x0015 }
            java.lang.String r0 = "start_y"
            android.graphics.Point r1 = r7.zzbtw     // Catch:{ all -> 0x0015 }
            int r1 = r1.y     // Catch:{ all -> 0x0015 }
            int r1 = r7.zzt(r1)     // Catch:{ all -> 0x0015 }
            float r1 = (float) r1     // Catch:{ all -> 0x0015 }
            r3.putFloat(r0, r1)     // Catch:{ all -> 0x0015 }
            android.view.View r0 = r7.zzbtt     // Catch:{ all -> 0x0015 }
            if (r0 == 0) goto L_0x008e
            android.view.View r0 = r7.zzbtt     // Catch:{ all -> 0x0015 }
            boolean r0 = r0.equals(r8)     // Catch:{ all -> 0x0015 }
            if (r0 == 0) goto L_0x008e
            com.google.android.gms.internal.zzoa r0 = r7.zzbsk     // Catch:{ all -> 0x0015 }
            boolean r0 = r0 instanceof com.google.android.gms.internal.zznz     // Catch:{ all -> 0x0015 }
            if (r0 == 0) goto L_0x0083
            com.google.android.gms.internal.zzoa r0 = r7.zzbsk     // Catch:{ all -> 0x0015 }
            com.google.android.gms.internal.zznz r0 = (com.google.android.gms.internal.zznz) r0     // Catch:{ all -> 0x0015 }
            com.google.android.gms.internal.zzoa r0 = r0.zzjz()     // Catch:{ all -> 0x0015 }
            if (r0 == 0) goto L_0x0081
            com.google.android.gms.internal.zzoa r0 = r7.zzbsk     // Catch:{ all -> 0x0015 }
            com.google.android.gms.internal.zznz r0 = (com.google.android.gms.internal.zznz) r0     // Catch:{ all -> 0x0015 }
            com.google.android.gms.internal.zzoa r0 = r0.zzjz()     // Catch:{ all -> 0x0015 }
            java.lang.String r2 = "1007"
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r7.zzbue     // Catch:{ all -> 0x0015 }
            r1 = r8
            r0.zza(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0015 }
        L_0x0081:
            monitor-exit(r6)     // Catch:{ all -> 0x0015 }
            goto L_0x0008
        L_0x0083:
            com.google.android.gms.internal.zzoa r0 = r7.zzbsk     // Catch:{ all -> 0x0015 }
            java.lang.String r2 = "1007"
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r7.zzbue     // Catch:{ all -> 0x0015 }
            r1 = r8
            r0.zza(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0015 }
            goto L_0x0081
        L_0x008e:
            com.google.android.gms.internal.zzoa r0 = r7.zzbsk     // Catch:{ all -> 0x0015 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r1 = r7.zzbue     // Catch:{ all -> 0x0015 }
            r0.zza(r8, r1, r3, r5)     // Catch:{ all -> 0x0015 }
            goto L_0x0081
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzor.onClick(android.view.View):void");
    }

    public final void onGlobalLayout() {
        View view;
        synchronized (this.mLock) {
            if (!(this.zzbsk == null || (view = (View) this.zzbub.get()) == null)) {
                this.zzbsk.zzc(view, this.zzbue);
            }
        }
    }

    public final void onScrollChanged() {
        View view;
        synchronized (this.mLock) {
            if (!(this.zzbsk == null || (view = (View) this.zzbub.get()) == null)) {
                this.zzbsk.zzc(view, this.zzbue);
            }
        }
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.mLock) {
            if (this.zzbsk != null) {
                View view2 = (View) this.zzbub.get();
                if (view2 != null) {
                    int[] iArr = new int[2];
                    view2.getLocationOnScreen(iArr);
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
        }
        return false;
    }

    public final void unregisterNativeAd() {
        synchronized (this.mLock) {
            this.zzbtt = null;
            this.zzbsk = null;
            this.zzbtv = null;
            this.zzbtw = null;
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper) {
        synchronized (this.mLock) {
            zzg((View) null);
            Object zzx = zzn.zzx(iObjectWrapper);
            if (!(zzx instanceof zzoe)) {
                zzafj.zzco("Not an instance of native engine. This is most likely a transient error");
                return;
            }
            zzoe zzoe = (zzoe) zzx;
            if (!zzoe.zzjx()) {
                zzafj.m12e("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
                return;
            }
            View view = (View) this.zzbub.get();
            if (!(this.zzbsk == null || view == null)) {
                if (((Boolean) zzbs.zzep().zzd(zzmq.zzbmx)).booleanValue()) {
                    this.zzbsk.zzb(view, this.zzbue);
                }
            }
            synchronized (this.mLock) {
                if (this.zzbsk instanceof zzoe) {
                    zzoe zzoe2 = (zzoe) this.zzbsk;
                    View view2 = (View) this.zzbub.get();
                    if (!(zzoe2 == null || zzoe2.getContext() == null || view2 == null || !zzbs.zzfa().zzt(view2.getContext()))) {
                        zzaek zzke = zzoe2.zzke();
                        if (zzke != null) {
                            zzke.zzu(false);
                        }
                        zzfy zzfy = (zzfy) this.zzbtx.get();
                        if (!(zzfy == null || zzke == null)) {
                            zzfy.zzb(zzke);
                        }
                    }
                }
            }
            if (!(this.zzbsk instanceof zznz) || !((zznz) this.zzbsk).zzjy()) {
                this.zzbsk = zzoe;
                if (zzoe instanceof zznz) {
                    ((zznz) zzoe).zzc((zzoa) null);
                }
            } else {
                ((zznz) this.zzbsk).zzc(zzoe);
            }
            WeakReference weakReference = this.zzbue.get(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW);
            if (weakReference == null) {
                zzafj.zzco("Ad choices asset view is not provided.");
            } else {
                View view3 = (View) weakReference.get();
                ViewGroup viewGroup = view3 instanceof ViewGroup ? (ViewGroup) view3 : null;
                if (viewGroup != null) {
                    this.zzbtt = zzoe.zza((View.OnClickListener) this, true);
                    if (this.zzbtt != null) {
                        this.zzbue.put(NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE, new WeakReference(this.zzbtt));
                        this.zzbuc.put(NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE, new WeakReference(this.zzbtt));
                        viewGroup.removeAllViews();
                        viewGroup.addView(this.zzbtt);
                    }
                }
            }
            zzoe.zza(view, this.zzbuc, this.zzbud, (View.OnTouchListener) this, (View.OnClickListener) this);
            zzagr.zzczc.post(new zzos(this, zzoe));
            zzg(view);
            synchronized (this.mLock) {
                if (this.zzbsk instanceof zzoe) {
                    zzoe zzoe3 = (zzoe) this.zzbsk;
                    View view4 = (View) this.zzbub.get();
                    if (!(zzoe3 == null || zzoe3.getContext() == null || view4 == null || !zzbs.zzfa().zzt(view4.getContext()))) {
                        zzfy zzfy2 = (zzfy) this.zzbtx.get();
                        if (zzfy2 == null) {
                            zzfy2 = new zzfy(view4.getContext(), view4);
                            this.zzbtx = new WeakReference<>(zzfy2);
                        }
                        zzfy2.zza((zzgc) zzoe3.zzke());
                    }
                }
            }
        }
    }
}
