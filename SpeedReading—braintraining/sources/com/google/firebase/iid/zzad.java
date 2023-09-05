package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

public final class zzad implements Runnable {
    private final long zznvu;
    private final PowerManager.WakeLock zznvv = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "fiid-sync");
    private FirebaseInstanceId zznvw;

    zzad(FirebaseInstanceId firebaseInstanceId, long j) {
        this.zznvw = firebaseInstanceId;
        this.zznvu = j;
        this.zznvv.setReferenceCounted(false);
    }

    private final boolean zzchp() {
        zzac zzcgy = this.zznvw.zzcgy();
        if (zzcgy != null && !zzcgy.zzqz(zzi.zzida)) {
            return true;
        }
        try {
            String zzcgz = this.zznvw.zzcgz();
            if (zzcgz == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            if (zzcgy != null && (zzcgy == null || zzcgz.equals(zzcgy.zzlax))) {
                return true;
            }
            Context context = getContext();
            Intent intent = new Intent("com.google.firebase.iid.TOKEN_REFRESH");
            Intent intent2 = new Intent("com.google.firebase.INSTANCE_ID_EVENT");
            intent2.setClass(context, FirebaseInstanceIdReceiver.class);
            intent2.putExtra("wrapped_intent", intent);
            context.sendBroadcast(intent2);
            return true;
        } catch (IOException | SecurityException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.e("FirebaseInstanceId", valueOf.length() != 0 ? "Token retrieval failed: ".concat(valueOf) : new String("Token retrieval failed: "));
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (zzra(r2) != false) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzchq() {
        /*
            r3 = this;
            com.google.firebase.iid.zzj r0 = com.google.firebase.iid.FirebaseInstanceId.zzcha()
        L_0x0004:
            com.google.firebase.iid.FirebaseInstanceId r1 = r3.zznvw
            monitor-enter(r1)
            java.lang.String r2 = r0.zzchg()     // Catch:{ all -> 0x0020 }
            if (r2 != 0) goto L_0x0017
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r2 = "topic sync succeeded"
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x0020 }
            r0 = 1
            monitor-exit(r1)     // Catch:{ all -> 0x0020 }
        L_0x0016:
            return r0
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x0020 }
            boolean r1 = r3.zzra(r2)
            if (r1 != 0) goto L_0x0023
            r0 = 0
            goto L_0x0016
        L_0x0020:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0020 }
            throw r0
        L_0x0023:
            r0.zzqt(r2)
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzad.zzchq():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzra(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            java.lang.String r2 = "!"
            java.lang.String[] r2 = r7.split(r2)
            int r3 = r2.length
            r4 = 2
            if (r3 != r4) goto L_0x001b
            r3 = r2[r1]
            r4 = r2[r0]
            r2 = -1
            int r5 = r3.hashCode()     // Catch:{ IOException -> 0x0043 }
            switch(r5) {
                case 83: goto L_0x001c;
                case 84: goto L_0x0018;
                case 85: goto L_0x0026;
                default: goto L_0x0018;
            }     // Catch:{ IOException -> 0x0043 }
        L_0x0018:
            switch(r2) {
                case 0: goto L_0x0030;
                case 1: goto L_0x005f;
                default: goto L_0x001b;
            }     // Catch:{ IOException -> 0x0043 }
        L_0x001b:
            return r0
        L_0x001c:
            java.lang.String r5 = "S"
            boolean r3 = r3.equals(r5)     // Catch:{ IOException -> 0x0043 }
            if (r3 == 0) goto L_0x0018
            r2 = r1
            goto L_0x0018
        L_0x0026:
            java.lang.String r5 = "U"
            boolean r3 = r3.equals(r5)     // Catch:{ IOException -> 0x0043 }
            if (r3 == 0) goto L_0x0018
            r2 = r0
            goto L_0x0018
        L_0x0030:
            com.google.firebase.iid.FirebaseInstanceId r2 = r6.zznvw     // Catch:{ IOException -> 0x0043 }
            r2.zzqr(r4)     // Catch:{ IOException -> 0x0043 }
            boolean r2 = com.google.firebase.iid.FirebaseInstanceId.zzchb()     // Catch:{ IOException -> 0x0043 }
            if (r2 == 0) goto L_0x001b
            java.lang.String r2 = "FirebaseInstanceId"
            java.lang.String r3 = "subscribe operation succeeded"
            android.util.Log.d(r2, r3)     // Catch:{ IOException -> 0x0043 }
            goto L_0x001b
        L_0x0043:
            r0 = move-exception
            java.lang.String r2 = "FirebaseInstanceId"
            java.lang.String r3 = "Topic sync failed: "
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r4 = r0.length()
            if (r4 == 0) goto L_0x0072
            java.lang.String r0 = r3.concat(r0)
        L_0x005a:
            android.util.Log.e(r2, r0)
            r0 = r1
            goto L_0x001b
        L_0x005f:
            com.google.firebase.iid.FirebaseInstanceId r2 = r6.zznvw     // Catch:{ IOException -> 0x0043 }
            r2.zzqs(r4)     // Catch:{ IOException -> 0x0043 }
            boolean r2 = com.google.firebase.iid.FirebaseInstanceId.zzchb()     // Catch:{ IOException -> 0x0043 }
            if (r2 == 0) goto L_0x001b
            java.lang.String r2 = "FirebaseInstanceId"
            java.lang.String r3 = "unsubscribe operation succeeded"
            android.util.Log.d(r2, r3)     // Catch:{ IOException -> 0x0043 }
            goto L_0x001b
        L_0x0072:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
            goto L_0x005a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzad.zzra(java.lang.String):boolean");
    }

    /* access modifiers changed from: package-private */
    public final Context getContext() {
        return this.zznvw.getApp().getApplicationContext();
    }

    public final void run() {
        this.zznvv.acquire();
        try {
            this.zznvw.zzco(true);
            if (!zzw.zzeu(getContext())) {
                this.zznvw.zzco(false);
            } else if (!zzchr()) {
                new zzae(this).zzchs();
                this.zznvv.release();
            } else {
                if (!zzchp() || !zzchq()) {
                    this.zznvw.zzcb(this.zznvu);
                } else {
                    this.zznvw.zzco(false);
                }
                this.zznvv.release();
            }
        } finally {
            this.zznvv.release();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzchr() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService("connectivity");
        return (connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null || !connectivityManager.getActiveNetworkInfo().isConnected()) ? false : true;
    }
}
