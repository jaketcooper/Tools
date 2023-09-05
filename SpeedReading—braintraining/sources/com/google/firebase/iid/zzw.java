package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Messenger;
import android.support.annotation.VisibleForTesting;
import android.support.p000v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.zzq;
import com.google.android.gms.iid.MessengerCompat;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.List;
import java.util.concurrent.ExecutionException;

public final class zzw {
    private static PendingIntent zziab;
    private static int zzidh = 0;
    private static long zzidq;
    private static int zznvi = 0;
    private static int zznvj;
    private Context zzaif;
    private Messenger zziaf;
    private Messenger zzidk;
    private MessengerCompat zzidl;
    private final SimpleArrayMap<String, zzz> zznvk = new SimpleArrayMap<>();

    public zzw(Context context) {
        this.zzaif = context.getApplicationContext();
        this.zziaf = new Messenger(new zzx(this, Looper.getMainLooper()));
    }

    private static String zza(KeyPair keyPair, String... strArr) {
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                return FirebaseInstanceId.zzn(instance.sign());
            } catch (GeneralSecurityException e) {
                Log.e("FirebaseInstanceId", "Unable to sign registration request", e);
                return null;
            }
        } catch (UnsupportedEncodingException e2) {
            Log.e("FirebaseInstanceId", "Unable to encode string", e2);
            return null;
        }
    }

    private final Bundle zzae(Bundle bundle) throws IOException {
        Bundle zzaf = zzaf(bundle);
        if (zzaf == null || !zzaf.containsKey("google.messenger")) {
            return zzaf;
        }
        Bundle zzaf2 = zzaf(bundle);
        if (zzaf2 == null || !zzaf2.containsKey("google.messenger")) {
            return zzaf2;
        }
        return null;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private final android.os.Bundle zzaf(android.os.Bundle r11) throws java.io.IOException {
        /*
            r10 = this;
            r9 = 3
            r8 = 2
            java.lang.String r0 = zzaux()
            com.google.firebase.iid.zzy r1 = new com.google.firebase.iid.zzy
            r2 = 0
            r1.<init>(r2)
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.firebase.iid.zzz> r2 = r10.zznvk
            monitor-enter(r2)
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.firebase.iid.zzz> r3 = r10.zznvk     // Catch:{ all -> 0x0059 }
            r3.put(r0, r1)     // Catch:{ all -> 0x0059 }
            monitor-exit(r2)     // Catch:{ all -> 0x0059 }
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r4 = zzidq
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x005c
            long r4 = zzidq
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x005c
            java.lang.String r0 = "FirebaseInstanceId"
            long r4 = zzidq
            long r2 = r4 - r2
            int r1 = zznvj
            r4 = 78
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "Backoff mode, next request attempt: "
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.StringBuilder r2 = r4.append(r2)
            java.lang.String r3 = " interval: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r1 = r1.toString()
            android.util.Log.w(r0, r1)
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "RETRY_LATER"
            r0.<init>(r1)
            throw r0
        L_0x0059:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0059 }
            throw r0
        L_0x005c:
            android.content.Context r2 = r10.zzaif
            int r2 = zzev(r2)
            if (r2 != 0) goto L_0x006c
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "MISSING_INSTANCEID_SERVICE"
            r0.<init>(r1)
            throw r0
        L_0x006c:
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            java.lang.String r3 = "com.google.android.gms"
            r2.setPackage(r3)
            android.content.Context r3 = r10.zzaif
            int r3 = zzev(r3)
            if (r3 != r8) goto L_0x0139
            java.lang.String r3 = "com.google.iid.TOKEN_REQUEST"
            r2.setAction(r3)
        L_0x0083:
            r2.putExtras(r11)
            android.content.Context r3 = r10.zzaif
            zzc((android.content.Context) r3, (android.content.Intent) r2)
            java.lang.String r3 = "kid"
            java.lang.String r4 = java.lang.String.valueOf(r0)
            int r4 = r4.length()
            int r4 = r4 + 5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "|ID|"
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.StringBuilder r4 = r4.append(r0)
            java.lang.String r5 = "|"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r2.putExtra(r3, r4)
            java.lang.String r3 = "X-kid"
            java.lang.String r4 = java.lang.String.valueOf(r0)
            int r4 = r4.length()
            int r4 = r4 + 5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "|ID|"
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.StringBuilder r4 = r4.append(r0)
            java.lang.String r5 = "|"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r2.putExtra(r3, r4)
            java.lang.String r3 = "FirebaseInstanceId"
            boolean r3 = android.util.Log.isLoggable(r3, r9)
            if (r3 == 0) goto L_0x010d
            java.lang.String r3 = "FirebaseInstanceId"
            android.os.Bundle r4 = r2.getExtras()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r5 = java.lang.String.valueOf(r4)
            int r5 = r5.length()
            int r5 = r5 + 8
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "Sending "
            java.lang.StringBuilder r5 = r6.append(r5)
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r3, r4)
        L_0x010d:
            java.lang.String r3 = "google.messenger"
            android.os.Messenger r4 = r10.zziaf
            r2.putExtra(r3, r4)
            android.os.Messenger r3 = r10.zzidk
            if (r3 != 0) goto L_0x011c
            com.google.android.gms.iid.MessengerCompat r3 = r10.zzidl
            if (r3 == 0) goto L_0x0156
        L_0x011c:
            android.os.Message r3 = android.os.Message.obtain()
            r3.obj = r2
            android.os.Messenger r4 = r10.zzidk     // Catch:{ RemoteException -> 0x0146 }
            if (r4 == 0) goto L_0x0140
            android.os.Messenger r4 = r10.zzidk     // Catch:{ RemoteException -> 0x0146 }
            r4.send(r3)     // Catch:{ RemoteException -> 0x0146 }
        L_0x012b:
            android.os.Bundle r1 = r1.zzchm()     // Catch:{ all -> 0x016d }
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.firebase.iid.zzz> r2 = r10.zznvk
            monitor-enter(r2)
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.firebase.iid.zzz> r3 = r10.zznvk     // Catch:{ all -> 0x016a }
            r3.remove(r0)     // Catch:{ all -> 0x016a }
            monitor-exit(r2)     // Catch:{ all -> 0x016a }
            return r1
        L_0x0139:
            java.lang.String r3 = "com.google.android.c2dm.intent.REGISTER"
            r2.setAction(r3)
            goto L_0x0083
        L_0x0140:
            com.google.android.gms.iid.MessengerCompat r4 = r10.zzidl     // Catch:{ RemoteException -> 0x0146 }
            r4.send(r3)     // Catch:{ RemoteException -> 0x0146 }
            goto L_0x012b
        L_0x0146:
            r3 = move-exception
            java.lang.String r3 = "FirebaseInstanceId"
            boolean r3 = android.util.Log.isLoggable(r3, r9)
            if (r3 == 0) goto L_0x0156
            java.lang.String r3 = "FirebaseInstanceId"
            java.lang.String r4 = "Messenger failed, fallback to startService"
            android.util.Log.d(r3, r4)
        L_0x0156:
            android.content.Context r3 = r10.zzaif
            int r3 = zzev(r3)
            if (r3 != r8) goto L_0x0164
            android.content.Context r3 = r10.zzaif
            r3.sendBroadcast(r2)
            goto L_0x012b
        L_0x0164:
            android.content.Context r3 = r10.zzaif
            r3.startService(r2)
            goto L_0x012b
        L_0x016a:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x016a }
            throw r0
        L_0x016d:
            r1 = move-exception
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.firebase.iid.zzz> r2 = r10.zznvk
            monitor-enter(r2)
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.firebase.iid.zzz> r3 = r10.zznvk     // Catch:{ all -> 0x0178 }
            r3.remove(r0)     // Catch:{ all -> 0x0178 }
            monitor-exit(r2)     // Catch:{ all -> 0x0178 }
            throw r1
        L_0x0178:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0178 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzw.zzaf(android.os.Bundle):android.os.Bundle");
    }

    private static synchronized String zzaux() {
        String num;
        synchronized (zzw.class) {
            int i = zzidh;
            zzidh = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzbl(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.firebase.iid.zzz> r2 = r5.zznvk
            monitor-enter(r2)
            if (r6 != 0) goto L_0x0025
            r0 = 0
            r1 = r0
        L_0x0007:
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.firebase.iid.zzz> r0 = r5.zznvk     // Catch:{ all -> 0x0046 }
            int r0 = r0.size()     // Catch:{ all -> 0x0046 }
            if (r1 >= r0) goto L_0x001e
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.firebase.iid.zzz> r0 = r5.zznvk     // Catch:{ all -> 0x0046 }
            java.lang.Object r0 = r0.valueAt(r1)     // Catch:{ all -> 0x0046 }
            com.google.firebase.iid.zzz r0 = (com.google.firebase.iid.zzz) r0     // Catch:{ all -> 0x0046 }
            r0.onError(r7)     // Catch:{ all -> 0x0046 }
            int r0 = r1 + 1
            r1 = r0
            goto L_0x0007
        L_0x001e:
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.firebase.iid.zzz> r0 = r5.zznvk     // Catch:{ all -> 0x0046 }
            r0.clear()     // Catch:{ all -> 0x0046 }
        L_0x0023:
            monitor-exit(r2)     // Catch:{ all -> 0x0046 }
        L_0x0024:
            return
        L_0x0025:
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.firebase.iid.zzz> r0 = r5.zznvk     // Catch:{ all -> 0x0046 }
            java.lang.Object r0 = r0.remove(r6)     // Catch:{ all -> 0x0046 }
            com.google.firebase.iid.zzz r0 = (com.google.firebase.iid.zzz) r0     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x004f
            java.lang.String r1 = "FirebaseInstanceId"
            java.lang.String r3 = "Missing callback for "
            java.lang.String r0 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0046 }
            int r4 = r0.length()     // Catch:{ all -> 0x0046 }
            if (r4 == 0) goto L_0x0049
            java.lang.String r0 = r3.concat(r0)     // Catch:{ all -> 0x0046 }
        L_0x0041:
            android.util.Log.w(r1, r0)     // Catch:{ all -> 0x0046 }
            monitor-exit(r2)     // Catch:{ all -> 0x0046 }
            goto L_0x0024
        L_0x0046:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0046 }
            throw r0
        L_0x0049:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0046 }
            r0.<init>(r3)     // Catch:{ all -> 0x0046 }
            goto L_0x0041
        L_0x004f:
            r0.onError(r7)     // Catch:{ all -> 0x0046 }
            goto L_0x0023
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzw.zzbl(java.lang.String, java.lang.String):void");
    }

    public static synchronized void zzc(Context context, Intent intent) {
        synchronized (zzw.class) {
            if (zziab == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                zziab = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", zziab);
        }
    }

    public static boolean zzeu(Context context) {
        return zzev(context) != 0;
    }

    @VisibleForTesting
    private static synchronized int zzev(Context context) {
        int i = 0;
        synchronized (zzw.class) {
            if (zznvi != 0) {
                i = zznvi;
            } else {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
                    Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
                } else {
                    if (!zzq.isAtLeastO()) {
                        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                        intent.setPackage("com.google.android.gms");
                        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
                        if (queryIntentServices != null && queryIntentServices.size() > 0) {
                            zznvi = 1;
                            i = 1;
                        }
                    }
                    Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
                    intent2.setPackage("com.google.android.gms");
                    List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
                    if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
                        Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
                        if (zzq.isAtLeastO()) {
                            zznvi = 2;
                        } else {
                            zznvi = 1;
                        }
                        i = zznvi;
                    } else {
                        zznvi = 2;
                        i = 2;
                    }
                }
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzc(Bundle bundle, KeyPair keyPair) throws IOException {
        int zzam = FirebaseInstanceId.zzam(this.zzaif, "com.google.android.gms");
        bundle.putString("gmsv", Integer.toString(zzam));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", Integer.toString(FirebaseInstanceId.zzes(this.zzaif)));
        bundle.putString("app_ver_name", FirebaseInstanceId.zzdk(this.zzaif));
        bundle.putString("cliv", "fiid-11717000");
        bundle.putString("appid", FirebaseInstanceId.zza(keyPair));
        String zzn = FirebaseInstanceId.zzn(keyPair.getPublic().getEncoded());
        bundle.putString("pub2", zzn);
        bundle.putString("sig", zza(keyPair, this.zzaif.getPackageName(), zzn));
        if (zzam < 12000000) {
            return zzae(bundle);
        }
        try {
            return (Bundle) Tasks.await(zzk.zzet(this.zzaif).zzi(1, bundle));
        } catch (InterruptedException | ExecutionException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e);
                Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 22).append("Error making request: ").append(valueOf).toString());
            }
            if (!(e.getCause() instanceof zzu) || ((zzu) e.getCause()).getErrorCode() != 4) {
                return null;
            }
            return zzae(bundle);
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    final void zzc(android.os.Message r14) {
        /*
            r13 = this;
            r10 = 0
            r9 = 2
            r2 = 0
            r8 = 1
            r7 = 3
            if (r14 != 0) goto L_0x0009
        L_0x0008:
            return
        L_0x0009:
            java.lang.Object r0 = r14.obj
            boolean r0 = r0 instanceof android.content.Intent
            if (r0 == 0) goto L_0x0244
            java.lang.Object r0 = r14.obj
            android.content.Intent r0 = (android.content.Intent) r0
            java.lang.Class<com.google.android.gms.iid.MessengerCompat> r1 = com.google.android.gms.iid.MessengerCompat.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            r0.setExtrasClassLoader(r1)
            java.lang.String r1 = "google.messenger"
            boolean r1 = r0.hasExtra(r1)
            if (r1 == 0) goto L_0x003b
            java.lang.String r1 = "google.messenger"
            android.os.Parcelable r1 = r0.getParcelableExtra(r1)
            boolean r0 = r1 instanceof com.google.android.gms.iid.MessengerCompat
            if (r0 == 0) goto L_0x0033
            r0 = r1
            com.google.android.gms.iid.MessengerCompat r0 = (com.google.android.gms.iid.MessengerCompat) r0
            r13.zzidl = r0
        L_0x0033:
            boolean r0 = r1 instanceof android.os.Messenger
            if (r0 == 0) goto L_0x003b
            android.os.Messenger r1 = (android.os.Messenger) r1
            r13.zzidk = r1
        L_0x003b:
            java.lang.Object r0 = r14.obj
            android.content.Intent r0 = (android.content.Intent) r0
            if (r0 != 0) goto L_0x0051
            java.lang.String r0 = "FirebaseInstanceId"
            boolean r0 = android.util.Log.isLoggable(r0, r7)
            if (r0 == 0) goto L_0x0008
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r1 = "Unexpected response: null"
            android.util.Log.d(r0, r1)
            goto L_0x0008
        L_0x0051:
            java.lang.String r1 = r0.getAction()
            java.lang.String r3 = "com.google.android.c2dm.intent.REGISTRATION"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0085
            java.lang.String r1 = "FirebaseInstanceId"
            boolean r1 = android.util.Log.isLoggable(r1, r7)
            if (r1 == 0) goto L_0x0008
            java.lang.String r1 = "FirebaseInstanceId"
            java.lang.String r2 = "Unexpected response "
            java.lang.String r0 = r0.getAction()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r3 = r0.length()
            if (r3 == 0) goto L_0x007f
            java.lang.String r0 = r2.concat(r0)
        L_0x007b:
            android.util.Log.d(r1, r0)
            goto L_0x0008
        L_0x007f:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            goto L_0x007b
        L_0x0085:
            java.lang.String r1 = "registration_id"
            java.lang.String r1 = r0.getStringExtra(r1)
            if (r1 != 0) goto L_0x0093
            java.lang.String r1 = "unregistered"
            java.lang.String r1 = r0.getStringExtra(r1)
        L_0x0093:
            if (r1 != 0) goto L_0x0178
            java.lang.String r1 = "error"
            java.lang.String r3 = r0.getStringExtra(r1)
            if (r3 != 0) goto L_0x00c9
            java.lang.String r1 = "FirebaseInstanceId"
            android.os.Bundle r0 = r0.getExtras()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r2 = r2 + 49
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Unexpected response, no error or registration id "
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r1, r0)
            goto L_0x0008
        L_0x00c9:
            java.lang.String r1 = "FirebaseInstanceId"
            boolean r1 = android.util.Log.isLoggable(r1, r7)
            if (r1 == 0) goto L_0x00e6
            java.lang.String r4 = "FirebaseInstanceId"
            java.lang.String r5 = "Received InstanceID error "
            java.lang.String r1 = java.lang.String.valueOf(r3)
            int r6 = r1.length()
            if (r6 == 0) goto L_0x0165
            java.lang.String r1 = r5.concat(r1)
        L_0x00e3:
            android.util.Log.d(r4, r1)
        L_0x00e6:
            java.lang.String r1 = "|"
            boolean r1 = r3.startsWith(r1)
            if (r1 == 0) goto L_0x024f
            java.lang.String r1 = "\\|"
            java.lang.String[] r4 = r3.split(r1)
            java.lang.String r1 = "ID"
            r5 = r4[r8]
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x0113
            java.lang.String r5 = "FirebaseInstanceId"
            java.lang.String r6 = "Unexpected structured response "
            java.lang.String r1 = java.lang.String.valueOf(r3)
            int r3 = r1.length()
            if (r3 == 0) goto L_0x016c
            java.lang.String r1 = r6.concat(r1)
        L_0x0110:
            android.util.Log.w(r5, r1)
        L_0x0113:
            int r1 = r4.length
            if (r1 <= r9) goto L_0x0172
            r1 = r4[r9]
            r2 = r4[r7]
            java.lang.String r3 = ":"
            boolean r3 = r2.startsWith(r3)
            if (r3 == 0) goto L_0x0126
            java.lang.String r2 = r2.substring(r8)
        L_0x0126:
            java.lang.String r3 = "error"
            r0.putExtra(r3, r2)
        L_0x012b:
            r13.zzbl(r1, r2)
            java.lang.String r1 = "Retry-After"
            long r0 = r0.getLongExtra(r1, r10)
            int r2 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r2 <= 0) goto L_0x0008
            int r0 = (int) r0
            int r0 = r0 * 1000
            zznvj = r0
            long r0 = android.os.SystemClock.elapsedRealtime()
            int r2 = zznvj
            long r2 = (long) r2
            long r0 = r0 + r2
            zzidq = r0
            java.lang.String r0 = "FirebaseInstanceId"
            int r1 = zznvj
            r2 = 52
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Explicit request from server to backoff: "
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r1 = r1.toString()
            android.util.Log.w(r0, r1)
            goto L_0x0008
        L_0x0165:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r5)
            goto L_0x00e3
        L_0x016c:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r6)
            goto L_0x0110
        L_0x0172:
            java.lang.String r1 = "UNKNOWN"
            r12 = r2
            r2 = r1
            r1 = r12
            goto L_0x0126
        L_0x0178:
            zzidq = r10
            r3 = 0
            zznvj = r3
            java.lang.String r3 = "|"
            boolean r3 = r1.startsWith(r3)
            if (r3 == 0) goto L_0x024d
            java.lang.String r3 = "\\|"
            java.lang.String[] r4 = r1.split(r3)
            java.lang.String r3 = "ID"
            r5 = r4[r8]
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x01aa
            java.lang.String r3 = "FirebaseInstanceId"
            java.lang.String r5 = "Unexpected structured response "
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r6 = r1.length()
            if (r6 == 0) goto L_0x01ed
            java.lang.String r1 = r5.concat(r1)
        L_0x01a7:
            android.util.Log.w(r3, r1)
        L_0x01aa:
            r3 = r4[r9]
            int r1 = r4.length
            r5 = 4
            if (r1 <= r5) goto L_0x01c3
            java.lang.String r1 = "SYNC"
            r5 = r4[r7]
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x01f3
            android.content.Context r1 = r13.zzaif
            com.google.firebase.iid.zzi r1 = com.google.firebase.iid.zzi.zza(r1, r2)
            r1.zzchf()
        L_0x01c3:
            int r1 = r4.length
            int r1 = r1 + -1
            r1 = r4[r1]
            java.lang.String r2 = ":"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x01d4
            java.lang.String r1 = r1.substring(r8)
        L_0x01d4:
            java.lang.String r2 = "registration_id"
            r0.putExtra(r2, r1)
            r1 = r3
        L_0x01da:
            if (r1 != 0) goto L_0x020c
            java.lang.String r0 = "FirebaseInstanceId"
            boolean r0 = android.util.Log.isLoggable(r0, r7)
            if (r0 == 0) goto L_0x0008
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r1 = "Ignoring response without a request ID"
            android.util.Log.d(r0, r1)
            goto L_0x0008
        L_0x01ed:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r5)
            goto L_0x01a7
        L_0x01f3:
            java.lang.String r1 = "RST"
            r5 = r4[r7]
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x01c3
            android.content.Context r1 = r13.zzaif
            com.google.firebase.iid.zzi r1 = com.google.firebase.iid.zzi.zza(r1, r2)
            r1.zzchd()
            java.lang.String r1 = "registration_id"
            r0.removeExtra(r1)
            r1 = r3
        L_0x020c:
            android.os.Bundle r2 = r0.getExtras()
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.firebase.iid.zzz> r3 = r13.zznvk
            monitor-enter(r3)
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.firebase.iid.zzz> r0 = r13.zznvk     // Catch:{ all -> 0x0235 }
            java.lang.Object r0 = r0.remove(r1)     // Catch:{ all -> 0x0235 }
            com.google.firebase.iid.zzz r0 = (com.google.firebase.iid.zzz) r0     // Catch:{ all -> 0x0235 }
            if (r0 != 0) goto L_0x023e
            java.lang.String r2 = "FirebaseInstanceId"
            java.lang.String r4 = "Missing callback for "
            java.lang.String r0 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0235 }
            int r1 = r0.length()     // Catch:{ all -> 0x0235 }
            if (r1 == 0) goto L_0x0238
            java.lang.String r0 = r4.concat(r0)     // Catch:{ all -> 0x0235 }
        L_0x022f:
            android.util.Log.w(r2, r0)     // Catch:{ all -> 0x0235 }
            monitor-exit(r3)     // Catch:{ all -> 0x0235 }
            goto L_0x0008
        L_0x0235:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0235 }
            throw r0
        L_0x0238:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0235 }
            r0.<init>(r4)     // Catch:{ all -> 0x0235 }
            goto L_0x022f
        L_0x023e:
            r0.zzag(r2)     // Catch:{ all -> 0x0235 }
            monitor-exit(r3)     // Catch:{ all -> 0x0235 }
            goto L_0x0008
        L_0x0244:
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r1 = "Dropping invalid message"
            android.util.Log.w(r0, r1)
            goto L_0x0008
        L_0x024d:
            r1 = r2
            goto L_0x01da
        L_0x024f:
            r1 = r2
            r2 = r3
            goto L_0x012b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzw.zzc(android.os.Message):void");
    }
}
