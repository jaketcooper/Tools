package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.util.zzq;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
@TargetApi(14)
public final class zzgt extends Thread {
    private final Object mLock;
    private boolean mStarted = false;
    private final int zzaxi;
    private final int zzaxk;
    private boolean zzayj = false;
    private final zzgo zzayk;
    private final zzyz zzayl;
    private final int zzaym;
    private final int zzayn;
    private final int zzayo;
    private final int zzayp;
    private final int zzayq;
    private final int zzayr;
    private final String zzays;
    private final boolean zzayt;
    private boolean zzbk = false;

    public zzgt(zzgo zzgo, zzyz zzyz) {
        this.zzayk = zzgo;
        this.zzayl = zzyz;
        this.mLock = new Object();
        this.zzaxi = ((Integer) zzbs.zzep().zzd(zzmq.zzbib)).intValue();
        this.zzayn = ((Integer) zzbs.zzep().zzd(zzmq.zzbic)).intValue();
        this.zzaxk = ((Integer) zzbs.zzep().zzd(zzmq.zzbid)).intValue();
        this.zzayo = ((Integer) zzbs.zzep().zzd(zzmq.zzbie)).intValue();
        this.zzayp = ((Integer) zzbs.zzep().zzd(zzmq.zzbih)).intValue();
        this.zzayq = ((Integer) zzbs.zzep().zzd(zzmq.zzbij)).intValue();
        this.zzayr = ((Integer) zzbs.zzep().zzd(zzmq.zzbik)).intValue();
        this.zzaym = ((Integer) zzbs.zzep().zzd(zzmq.zzbif)).intValue();
        this.zzays = (String) zzbs.zzep().zzd(zzmq.zzbim);
        this.zzayt = ((Boolean) zzbs.zzep().zzd(zzmq.zzbio)).booleanValue();
        setName("ContentFetchTask");
    }

    private final zzgx zza(@Nullable View view, zzgn zzgn) {
        boolean z;
        int i = 0;
        if (view == null) {
            return new zzgx(this, 0, 0);
        }
        Context context = zzbs.zzef().getContext();
        if (context != null) {
            String str = (String) view.getTag(context.getResources().getIdentifier((String) zzbs.zzep().zzd(zzmq.zzbil), IdentityRealmObject.FIELD_ID, context.getPackageName()));
            if (!TextUtils.isEmpty(this.zzays) && str != null && str.equals(this.zzays)) {
                return new zzgx(this, 0, 0);
            }
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zzgx(this, 0, 0);
            }
            zzgn.zzb(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
            return new zzgx(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzama)) {
            zzgn.zzgm();
            WebView webView = (WebView) view;
            if (!zzq.zzama()) {
                z = false;
            } else {
                zzgn.zzgm();
                webView.post(new zzgv(this, zzgn, webView, globalVisibleRect));
                z = true;
            }
            return z ? new zzgx(this, 0, 1) : new zzgx(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new zzgx(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                zzgx zza = zza(viewGroup.getChildAt(i3), zzgn);
                i2 += zza.zzazb;
                i += zza.zzazc;
            }
            return new zzgx(this, i2, i);
        }
    }

    private static boolean zzgr() {
        try {
            Context context = zzbs.zzef().getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (Process.myPid() == next.pid) {
                    if (next.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode()) {
                        PowerManager powerManager = (PowerManager) context.getSystemService("power");
                        if (powerManager == null ? false : powerManager.isScreenOn()) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            zzbs.zzeg().zza(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    private final void zzgt() {
        synchronized (this.mLock) {
            this.zzayj = true;
            zzafj.zzbw(new StringBuilder(42).append("ContentFetchThread: paused, mPause = ").append(this.zzayj).toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0063, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0064, code lost:
        com.google.android.gms.internal.zzafj.zzb("Error in ContentFetchTask", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        com.google.android.gms.ads.internal.zzbs.zzeg().zza((java.lang.Throwable) r1, "ContentFetchTask.extractContent");
        com.google.android.gms.internal.zzafj.zzbw("Failed getting root view of activity. Content not extracted.");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063 A[ExcHandler: InterruptedException (r0v1 'e' java.lang.InterruptedException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r4 = this;
        L_0x0000:
            boolean r0 = zzgr()     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
            if (r0 == 0) goto L_0x0088
            com.google.android.gms.internal.zzgp r0 = com.google.android.gms.ads.internal.zzbs.zzef()     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
            android.app.Activity r1 = r0.getActivity()     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
            if (r1 != 0) goto L_0x0034
            java.lang.String r0 = "ContentFetchThread: no activity. Sleeping."
            com.google.android.gms.internal.zzafj.zzbw(r0)     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
            r4.zzgt()     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
        L_0x0018:
            int r0 = r4.zzaym     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
            int r0 = r0 * 1000
            long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
        L_0x0020:
            java.lang.Object r1 = r4.mLock
            monitor-enter(r1)
        L_0x0023:
            boolean r0 = r4.zzayj     // Catch:{ all -> 0x0094 }
            if (r0 == 0) goto L_0x0091
            java.lang.String r0 = "ContentFetchTask: waiting"
            com.google.android.gms.internal.zzafj.zzbw(r0)     // Catch:{ InterruptedException -> 0x0032 }
            java.lang.Object r0 = r4.mLock     // Catch:{ InterruptedException -> 0x0032 }
            r0.wait()     // Catch:{ InterruptedException -> 0x0032 }
            goto L_0x0023
        L_0x0032:
            r0 = move-exception
            goto L_0x0023
        L_0x0034:
            if (r1 == 0) goto L_0x0018
            r0 = 0
            android.view.Window r2 = r1.getWindow()     // Catch:{ Exception -> 0x006a, InterruptedException -> 0x0063 }
            if (r2 == 0) goto L_0x0056
            android.view.Window r2 = r1.getWindow()     // Catch:{ Exception -> 0x006a, InterruptedException -> 0x0063 }
            android.view.View r2 = r2.getDecorView()     // Catch:{ Exception -> 0x006a, InterruptedException -> 0x0063 }
            if (r2 == 0) goto L_0x0056
            android.view.Window r1 = r1.getWindow()     // Catch:{ Exception -> 0x006a, InterruptedException -> 0x0063 }
            android.view.View r1 = r1.getDecorView()     // Catch:{ Exception -> 0x006a, InterruptedException -> 0x0063 }
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r1.findViewById(r2)     // Catch:{ Exception -> 0x006a, InterruptedException -> 0x0063 }
        L_0x0056:
            if (r0 == 0) goto L_0x0018
            if (r0 == 0) goto L_0x0018
            com.google.android.gms.internal.zzgu r1 = new com.google.android.gms.internal.zzgu     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
            r1.<init>(r4, r0)     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
            r0.post(r1)     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
            goto L_0x0018
        L_0x0063:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.internal.zzafj.zzb(r1, r0)
            goto L_0x0020
        L_0x006a:
            r1 = move-exception
            com.google.android.gms.internal.zzaez r2 = com.google.android.gms.ads.internal.zzbs.zzeg()     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
            java.lang.String r3 = "ContentFetchTask.extractContent"
            r2.zza((java.lang.Throwable) r1, (java.lang.String) r3)     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
            java.lang.String r1 = "Failed getting root view of activity. Content not extracted."
            com.google.android.gms.internal.zzafj.zzbw(r1)     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
            goto L_0x0056
        L_0x007a:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.internal.zzafj.zzb(r1, r0)
            com.google.android.gms.internal.zzyz r1 = r4.zzayl
            java.lang.String r2 = "ContentFetchTask.run"
            r1.zza(r0, r2)
            goto L_0x0020
        L_0x0088:
            java.lang.String r0 = "ContentFetchTask: sleeping"
            com.google.android.gms.internal.zzafj.zzbw(r0)     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
            r4.zzgt()     // Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
            goto L_0x0018
        L_0x0091:
            monitor-exit(r1)     // Catch:{ all -> 0x0094 }
            goto L_0x0000
        L_0x0094:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0094 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgt.run():void");
    }

    public final void wakeup() {
        synchronized (this.mLock) {
            this.zzayj = false;
            this.mLock.notifyAll();
            zzafj.zzbw("ContentFetchThread: wakeup");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzgn zzgn, WebView webView, String str, boolean z) {
        zzgn.zzgl();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (this.zzayt || TextUtils.isEmpty(webView.getTitle())) {
                    zzgn.zza(optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    zzgn.zza(new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(optString).length()).append(title).append("\n").append(optString).toString(), z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                }
            }
            if (zzgn.zzgg()) {
                this.zzayk.zzb(zzgn);
            }
        } catch (JSONException e) {
            zzafj.zzbw("Json string may be malformed.");
        } catch (Throwable th) {
            zzafj.zza("Failed to get webview content.", th);
            this.zzayl.zza(th, "ContentFetchTask.processWebViewContent");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzf(View view) {
        try {
            zzgn zzgn = new zzgn(this.zzaxi, this.zzayn, this.zzaxk, this.zzayo, this.zzayp, this.zzayq, this.zzayr);
            zzgx zza = zza(view, zzgn);
            zzgn.zzgn();
            if (zza.zzazb != 0 || zza.zzazc != 0) {
                if (zza.zzazc != 0 || zzgn.zzgo() != 0) {
                    if (zza.zzazc != 0 || !this.zzayk.zza(zzgn)) {
                        this.zzayk.zzc(zzgn);
                    }
                }
            }
        } catch (Exception e) {
            zzafj.zzb("Exception in fetchContentOnUIThread", e);
            this.zzayl.zza(e, "ContentFetchTask.fetchContent");
        }
    }

    public final void zzgq() {
        synchronized (this.mLock) {
            if (this.mStarted) {
                zzafj.zzbw("Content hash thread already started, quiting...");
                return;
            }
            this.mStarted = true;
            start();
        }
    }

    public final zzgn zzgs() {
        return this.zzayk.zzgp();
    }

    public final boolean zzgu() {
        return this.zzayj;
    }
}
