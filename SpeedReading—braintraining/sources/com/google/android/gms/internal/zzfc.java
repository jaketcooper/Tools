package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.measurement.AppMeasurement;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zzfc implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private final Context mApplicationContext;
    private Object mLock = new Object();
    private boolean zzarc = false;
    private zzail zzaui;
    private final WeakReference<zzaeu> zzauy;
    private WeakReference<ViewTreeObserver> zzauz;
    private final zzgm zzava;
    protected final zzfa zzavb;
    private final WindowManager zzavc;
    private final PowerManager zzavd;
    private final KeyguardManager zzave;
    private final DisplayMetrics zzavf;
    @Nullable
    private zzfj zzavg;
    private boolean zzavh;
    private boolean zzavi = false;
    private boolean zzavj;
    private boolean zzavk;
    private boolean zzavl;
    @Nullable
    private BroadcastReceiver zzavm;
    private final HashSet<Object> zzavn = new HashSet<>();
    private final HashSet<zzfx> zzavo = new HashSet<>();
    private final Rect zzavp = new Rect();
    private final zzff zzavq;
    private float zzavr;

    public zzfc(Context context, zziw zziw, zzaeu zzaeu, zzaiy zzaiy, zzgm zzgm) {
        this.zzauy = new WeakReference<>(zzaeu);
        this.zzava = zzgm;
        this.zzauz = new WeakReference<>((Object) null);
        this.zzavj = true;
        this.zzavl = false;
        this.zzaui = new zzail(200);
        this.zzavb = new zzfa(UUID.randomUUID().toString(), zzaiy, zziw.zzbda, zzaeu.zzcvq, zzaeu.zzfr(), zziw.zzbdd);
        this.zzavc = (WindowManager) context.getSystemService("window");
        this.zzavd = (PowerManager) context.getApplicationContext().getSystemService("power");
        this.zzave = (KeyguardManager) context.getSystemService("keyguard");
        this.mApplicationContext = context;
        this.zzavq = new zzff(this, new Handler());
        this.mApplicationContext.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.zzavq);
        this.zzavf = context.getResources().getDisplayMetrics();
        Display defaultDisplay = this.zzavc.getDefaultDisplay();
        this.zzavp.right = defaultDisplay.getWidth();
        this.zzavp.bottom = defaultDisplay.getHeight();
        zzft();
    }

    private final boolean isScreenOn() {
        return Build.VERSION.SDK_INT >= 20 ? this.zzavd.isInteractive() : this.zzavd.isScreenOn();
    }

    private static int zza(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    private final JSONObject zza(@Nullable View view, @Nullable Boolean bool) throws JSONException {
        if (view == null) {
            return zzfy().put("isAttachedToWindow", false).put("isScreenOn", isScreenOn()).put("isVisible", false);
        }
        boolean isAttachedToWindow = zzbs.zzee().isAttachedToWindow(view);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            view.getLocationInWindow(iArr2);
        } catch (Exception e) {
            zzafj.zzb("Failure getting view location.", e);
        }
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect2, (Point) null);
        Rect rect3 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect3);
        Rect rect4 = new Rect();
        view.getHitRect(rect4);
        JSONObject zzfy = zzfy();
        zzfy.put("windowVisibility", view.getWindowVisibility()).put("isAttachedToWindow", isAttachedToWindow).put("viewBox", new JSONObject().put("top", zza(this.zzavp.top, this.zzavf)).put("bottom", zza(this.zzavp.bottom, this.zzavf)).put("left", zza(this.zzavp.left, this.zzavf)).put("right", zza(this.zzavp.right, this.zzavf))).put("adBox", new JSONObject().put("top", zza(rect.top, this.zzavf)).put("bottom", zza(rect.bottom, this.zzavf)).put("left", zza(rect.left, this.zzavf)).put("right", zza(rect.right, this.zzavf))).put("globalVisibleBox", new JSONObject().put("top", zza(rect2.top, this.zzavf)).put("bottom", zza(rect2.bottom, this.zzavf)).put("left", zza(rect2.left, this.zzavf)).put("right", zza(rect2.right, this.zzavf))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", zza(rect3.top, this.zzavf)).put("bottom", zza(rect3.bottom, this.zzavf)).put("left", zza(rect3.left, this.zzavf)).put("right", zza(rect3.right, this.zzavf))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put("top", zza(rect4.top, this.zzavf)).put("bottom", zza(rect4.bottom, this.zzavf)).put("left", zza(rect4.left, this.zzavf)).put("right", zza(rect4.right, this.zzavf))).put("screenDensity", (double) this.zzavf.density);
        if (bool == null) {
            bool = Boolean.valueOf(zzbs.zzec().zza(view, this.zzavd, this.zzave));
        }
        zzfy.put("isVisible", bool.booleanValue());
        return zzfy;
    }

    private final void zza(JSONObject jSONObject, boolean z) {
        try {
            JSONObject zzb = zzb(jSONObject);
            ArrayList arrayList = new ArrayList(this.zzavo);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((zzfx) obj).zzb(zzb, z);
            }
        } catch (Throwable th) {
            zzafj.zzb("Skipping active view message.", th);
        }
    }

    private static JSONObject zzb(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }

    private final void zzfv() {
        if (this.zzavg != null) {
            this.zzavg.zza(this);
        }
    }

    private final void zzfx() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.zzauz.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    private final JSONObject zzfy() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject put = jSONObject.put("afmaVersion", this.zzavb.zzfo()).put("activeViewJSON", this.zzavb.zzfp()).put(AppMeasurement.Param.TIMESTAMP, zzbs.zzei().elapsedRealtime()).put("adFormat", this.zzavb.zzfn()).put("hashCode", this.zzavb.zzfq()).put("isMraid", this.zzavb.zzfr()).put("isStopped", this.zzavi).put("isPaused", this.zzarc).put("isNative", this.zzavb.zzfs()).put("isScreenOn", isScreenOn());
        zzbs.zzec();
        JSONObject put2 = put.put("appMuted", zzagr.zzdi());
        zzbs.zzec();
        put2.put("appVolume", (double) zzagr.zzdh()).put("deviceVolume", (double) this.zzavr);
        return jSONObject;
    }

    public final void onGlobalLayout() {
        zzl(2);
    }

    public final void onScrollChanged() {
        zzl(1);
    }

    public final void pause() {
        synchronized (this.mLock) {
            this.zzarc = true;
            zzl(3);
        }
    }

    public final void resume() {
        synchronized (this.mLock) {
            this.zzarc = false;
            zzl(3);
        }
    }

    public final void stop() {
        synchronized (this.mLock) {
            this.zzavi = true;
            zzl(3);
        }
    }

    public final void zza(zzfj zzfj) {
        synchronized (this.mLock) {
            this.zzavg = zzfj;
        }
    }

    public final void zza(zzfx zzfx) {
        if (this.zzavo.isEmpty()) {
            synchronized (this.mLock) {
                if (this.zzavm == null) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    this.zzavm = new zzfd(this);
                    this.mApplicationContext.registerReceiver(this.zzavm, intentFilter);
                }
            }
            zzl(3);
        }
        this.zzavo.add(zzfx);
        try {
            zzfx.zzb(zzb(zza(this.zzava.zzfz(), (Boolean) null)), false);
        } catch (JSONException e) {
            zzafj.zzb("Skipping measurement update for new client.", e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzfx zzfx, Map<String, String> map) {
        String valueOf = String.valueOf(this.zzavb.zzfq());
        zzafj.zzbw(valueOf.length() != 0 ? "Received request to untrack: ".concat(valueOf) : new String("Received request to untrack: "));
        zzb(zzfx);
    }

    public final void zzb(zzfx zzfx) {
        this.zzavo.remove(zzfx);
        zzfx.zzgd();
        if (this.zzavo.isEmpty()) {
            synchronized (this.mLock) {
                zzfx();
                synchronized (this.mLock) {
                    if (this.zzavm != null) {
                        try {
                            this.mApplicationContext.unregisterReceiver(this.zzavm);
                        } catch (IllegalStateException e) {
                            zzafj.zzb("Failed trying to unregister the receiver", e);
                        } catch (Exception e2) {
                            zzbs.zzeg().zza((Throwable) e2, "ActiveViewUnit.stopScreenStatusMonitoring");
                        }
                        this.zzavm = null;
                    }
                }
                this.mApplicationContext.getContentResolver().unregisterContentObserver(this.zzavq);
                this.zzavj = false;
                zzfv();
                ArrayList arrayList = new ArrayList(this.zzavo);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    zzb((zzfx) obj);
                }
            }
            return;
        }
        return;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzd(@Nullable Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.zzavb.zzfq());
    }

    /* access modifiers changed from: package-private */
    public final void zze(Map<String, String> map) {
        zzl(3);
    }

    /* access modifiers changed from: package-private */
    public final void zzf(Map<String, String> map) {
        if (map.containsKey("isVisible")) {
            if (!"1".equals(map.get("isVisible"))) {
                "true".equals(map.get("isVisible"));
            }
            Iterator<Object> it = this.zzavn.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void zzft() {
        zzbs.zzec();
        this.zzavr = zzagr.zzap(this.mApplicationContext);
    }

    public final void zzfu() {
        synchronized (this.mLock) {
            if (this.zzavj) {
                this.zzavk = true;
                try {
                    JSONObject zzfy = zzfy();
                    zzfy.put("doneReasonCode", "u");
                    zza(zzfy, true);
                } catch (JSONException e) {
                    zzafj.zzb("JSON failure while processing active view data.", e);
                } catch (RuntimeException e2) {
                    zzafj.zzb("Failure while processing active view data.", e2);
                }
                String valueOf = String.valueOf(this.zzavb.zzfq());
                zzafj.zzbw(valueOf.length() != 0 ? "Untracking ad unit: ".concat(valueOf) : new String("Untracking ad unit: "));
            }
        }
    }

    public final boolean zzfw() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzavj;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00cb, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00cc, code lost:
        com.google.android.gms.internal.zzafj.zza("Active view update failed.", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzl(int r8) {
        /*
            r7 = this;
            r2 = 0
            r1 = 1
            java.lang.Object r4 = r7.mLock
            monitor-enter(r4)
            java.util.HashSet<com.google.android.gms.internal.zzfx> r0 = r7.zzavo     // Catch:{ all -> 0x005d }
            java.util.Iterator r3 = r0.iterator()     // Catch:{ all -> 0x005d }
        L_0x000b:
            boolean r0 = r3.hasNext()     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0026
            java.lang.Object r0 = r3.next()     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.zzfx r0 = (com.google.android.gms.internal.zzfx) r0     // Catch:{ all -> 0x005d }
            boolean r0 = r0.zzgc()     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x000b
            r0 = r1
        L_0x001e:
            if (r0 == 0) goto L_0x0024
            boolean r0 = r7.zzavj     // Catch:{ all -> 0x005d }
            if (r0 != 0) goto L_0x0028
        L_0x0024:
            monitor-exit(r4)     // Catch:{ all -> 0x005d }
        L_0x0025:
            return
        L_0x0026:
            r0 = r2
            goto L_0x001e
        L_0x0028:
            com.google.android.gms.internal.zzgm r0 = r7.zzava     // Catch:{ all -> 0x005d }
            android.view.View r5 = r0.zzfz()     // Catch:{ all -> 0x005d }
            if (r5 == 0) goto L_0x0060
            com.google.android.gms.internal.zzagr r0 = com.google.android.gms.ads.internal.zzbs.zzec()     // Catch:{ all -> 0x005d }
            android.os.PowerManager r3 = r7.zzavd     // Catch:{ all -> 0x005d }
            android.app.KeyguardManager r6 = r7.zzave     // Catch:{ all -> 0x005d }
            boolean r0 = r0.zza((android.view.View) r5, (android.os.PowerManager) r3, (android.app.KeyguardManager) r6)     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0060
            r3 = r1
        L_0x003f:
            if (r5 == 0) goto L_0x0062
            if (r3 == 0) goto L_0x0062
            android.graphics.Rect r0 = new android.graphics.Rect     // Catch:{ all -> 0x005d }
            r0.<init>()     // Catch:{ all -> 0x005d }
            r6 = 0
            boolean r0 = r5.getGlobalVisibleRect(r0, r6)     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0062
            r0 = r1
        L_0x0050:
            com.google.android.gms.internal.zzgm r2 = r7.zzava     // Catch:{ all -> 0x005d }
            boolean r2 = r2.zzga()     // Catch:{ all -> 0x005d }
            if (r2 == 0) goto L_0x0064
            r7.zzfu()     // Catch:{ all -> 0x005d }
            monitor-exit(r4)     // Catch:{ all -> 0x005d }
            goto L_0x0025
        L_0x005d:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x005d }
            throw r0
        L_0x0060:
            r3 = r2
            goto L_0x003f
        L_0x0062:
            r0 = r2
            goto L_0x0050
        L_0x0064:
            if (r8 != r1) goto L_0x0074
            com.google.android.gms.internal.zzail r2 = r7.zzaui     // Catch:{ all -> 0x005d }
            boolean r2 = r2.tryAcquire()     // Catch:{ all -> 0x005d }
            if (r2 != 0) goto L_0x0074
            boolean r2 = r7.zzavl     // Catch:{ all -> 0x005d }
            if (r0 != r2) goto L_0x0074
            monitor-exit(r4)     // Catch:{ all -> 0x005d }
            goto L_0x0025
        L_0x0074:
            if (r0 != 0) goto L_0x007e
            boolean r2 = r7.zzavl     // Catch:{ all -> 0x005d }
            if (r2 != 0) goto L_0x007e
            if (r8 != r1) goto L_0x007e
            monitor-exit(r4)     // Catch:{ all -> 0x005d }
            goto L_0x0025
        L_0x007e:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r3)     // Catch:{ JSONException -> 0x00d2, RuntimeException -> 0x00cb }
            org.json.JSONObject r1 = r7.zza((android.view.View) r5, (java.lang.Boolean) r1)     // Catch:{ JSONException -> 0x00d2, RuntimeException -> 0x00cb }
            r2 = 0
            r7.zza((org.json.JSONObject) r1, (boolean) r2)     // Catch:{ JSONException -> 0x00d2, RuntimeException -> 0x00cb }
            r7.zzavl = r0     // Catch:{ JSONException -> 0x00d2, RuntimeException -> 0x00cb }
        L_0x008c:
            com.google.android.gms.internal.zzgm r0 = r7.zzava     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.zzgm r0 = r0.zzgb()     // Catch:{ all -> 0x005d }
            android.view.View r1 = r0.zzfz()     // Catch:{ all -> 0x005d }
            if (r1 == 0) goto L_0x00c5
            java.lang.ref.WeakReference<android.view.ViewTreeObserver> r0 = r7.zzauz     // Catch:{ all -> 0x005d }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x005d }
            android.view.ViewTreeObserver r0 = (android.view.ViewTreeObserver) r0     // Catch:{ all -> 0x005d }
            android.view.ViewTreeObserver r1 = r1.getViewTreeObserver()     // Catch:{ all -> 0x005d }
            if (r1 == r0) goto L_0x00c5
            r7.zzfx()     // Catch:{ all -> 0x005d }
            boolean r2 = r7.zzavh     // Catch:{ all -> 0x005d }
            if (r2 == 0) goto L_0x00b5
            if (r0 == 0) goto L_0x00be
            boolean r0 = r0.isAlive()     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x00be
        L_0x00b5:
            r0 = 1
            r7.zzavh = r0     // Catch:{ all -> 0x005d }
            r1.addOnScrollChangedListener(r7)     // Catch:{ all -> 0x005d }
            r1.addOnGlobalLayoutListener(r7)     // Catch:{ all -> 0x005d }
        L_0x00be:
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x005d }
            r0.<init>(r1)     // Catch:{ all -> 0x005d }
            r7.zzauz = r0     // Catch:{ all -> 0x005d }
        L_0x00c5:
            r7.zzfv()     // Catch:{ all -> 0x005d }
            monitor-exit(r4)     // Catch:{ all -> 0x005d }
            goto L_0x0025
        L_0x00cb:
            r0 = move-exception
        L_0x00cc:
            java.lang.String r1 = "Active view update failed."
            com.google.android.gms.internal.zzafj.zza(r1, r0)     // Catch:{ all -> 0x005d }
            goto L_0x008c
        L_0x00d2:
            r0 = move-exception
            goto L_0x00cc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfc.zzl(int):void");
    }
}
