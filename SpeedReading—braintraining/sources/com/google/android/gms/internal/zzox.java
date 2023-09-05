package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;

@zzzb
public final class zzox extends NativeAd.AdChoicesInfo {
    private final List<NativeAd.Image> zzbrm = new ArrayList();
    private final zzou zzbug;
    private String zzbuh;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.google.android.gms.internal.zzpa} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: com.google.android.gms.internal.zzpa} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.google.android.gms.internal.zzpa} */
    /* JADX WARNING: type inference failed for: r2v5, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzox(com.google.android.gms.internal.zzou r6) {
        /*
            r5 = this;
            r5.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzbrm = r1
            r5.zzbug = r6
            com.google.android.gms.internal.zzou r1 = r5.zzbug     // Catch:{ RemoteException -> 0x0050 }
            java.lang.String r1 = r1.getText()     // Catch:{ RemoteException -> 0x0050 }
            r5.zzbuh = r1     // Catch:{ RemoteException -> 0x0050 }
        L_0x0014:
            java.util.List r1 = r6.zzjg()     // Catch:{ RemoteException -> 0x0049 }
            java.util.Iterator r3 = r1.iterator()     // Catch:{ RemoteException -> 0x0049 }
        L_0x001c:
            boolean r1 = r3.hasNext()     // Catch:{ RemoteException -> 0x0049 }
            if (r1 == 0) goto L_0x004f
            java.lang.Object r1 = r3.next()     // Catch:{ RemoteException -> 0x0049 }
            boolean r2 = r1 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x0049 }
            if (r2 == 0) goto L_0x0062
            android.os.IBinder r1 = (android.os.IBinder) r1     // Catch:{ RemoteException -> 0x0049 }
            if (r1 == 0) goto L_0x0062
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)     // Catch:{ RemoteException -> 0x0049 }
            boolean r4 = r2 instanceof com.google.android.gms.internal.zzoy     // Catch:{ RemoteException -> 0x0049 }
            if (r4 == 0) goto L_0x005b
            r0 = r2
            com.google.android.gms.internal.zzoy r0 = (com.google.android.gms.internal.zzoy) r0     // Catch:{ RemoteException -> 0x0049 }
            r1 = r0
        L_0x003c:
            if (r1 == 0) goto L_0x001c
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r2 = r5.zzbrm     // Catch:{ RemoteException -> 0x0049 }
            com.google.android.gms.internal.zzpb r4 = new com.google.android.gms.internal.zzpb     // Catch:{ RemoteException -> 0x0049 }
            r4.<init>(r1)     // Catch:{ RemoteException -> 0x0049 }
            r2.add(r4)     // Catch:{ RemoteException -> 0x0049 }
            goto L_0x001c
        L_0x0049:
            r1 = move-exception
            java.lang.String r2 = "Error while obtaining image."
            com.google.android.gms.internal.zzaiw.zzb(r2, r1)
        L_0x004f:
            return
        L_0x0050:
            r1 = move-exception
            java.lang.String r2 = "Error while obtaining attribution text."
            com.google.android.gms.internal.zzaiw.zzb(r2, r1)
            java.lang.String r1 = ""
            r5.zzbuh = r1
            goto L_0x0014
        L_0x005b:
            com.google.android.gms.internal.zzpa r2 = new com.google.android.gms.internal.zzpa     // Catch:{ RemoteException -> 0x0049 }
            r2.<init>(r1)     // Catch:{ RemoteException -> 0x0049 }
            r1 = r2
            goto L_0x003c
        L_0x0062:
            r1 = 0
            goto L_0x003c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzox.<init>(com.google.android.gms.internal.zzou):void");
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzbrm;
    }

    public final CharSequence getText() {
        return this.zzbuh;
    }
}
