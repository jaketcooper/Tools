package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

@zzzb
public final class zzpt extends NativeContentAd {
    private final VideoController zzbeq = new VideoController();
    private final List<NativeAd.Image> zzbuk = new ArrayList();
    private final NativeAd.AdChoicesInfo zzbum;
    private final zzpq zzbun;
    private final zzpb zzbuo;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: com.google.android.gms.internal.zzpa} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: com.google.android.gms.internal.zzpa} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: com.google.android.gms.internal.zzpa} */
    /* JADX WARNING: type inference failed for: r2v9, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzpt(com.google.android.gms.internal.zzpq r7) {
        /*
            r6 = this;
            r3 = 0
            r6.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r6.zzbuk = r1
            com.google.android.gms.ads.VideoController r1 = new com.google.android.gms.ads.VideoController
            r1.<init>()
            r6.zzbeq = r1
            r6.zzbun = r7
            com.google.android.gms.internal.zzpq r1 = r6.zzbun     // Catch:{ RemoteException -> 0x004d }
            java.util.List r1 = r1.getImages()     // Catch:{ RemoteException -> 0x004d }
            if (r1 == 0) goto L_0x0053
            java.util.Iterator r4 = r1.iterator()     // Catch:{ RemoteException -> 0x004d }
        L_0x0020:
            boolean r1 = r4.hasNext()     // Catch:{ RemoteException -> 0x004d }
            if (r1 == 0) goto L_0x0053
            java.lang.Object r1 = r4.next()     // Catch:{ RemoteException -> 0x004d }
            boolean r2 = r1 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x004d }
            if (r2 == 0) goto L_0x0080
            android.os.IBinder r1 = (android.os.IBinder) r1     // Catch:{ RemoteException -> 0x004d }
            if (r1 == 0) goto L_0x0080
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)     // Catch:{ RemoteException -> 0x004d }
            boolean r5 = r2 instanceof com.google.android.gms.internal.zzoy     // Catch:{ RemoteException -> 0x004d }
            if (r5 == 0) goto L_0x0079
            r0 = r2
            com.google.android.gms.internal.zzoy r0 = (com.google.android.gms.internal.zzoy) r0     // Catch:{ RemoteException -> 0x004d }
            r1 = r0
        L_0x0040:
            if (r1 == 0) goto L_0x0020
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r2 = r6.zzbuk     // Catch:{ RemoteException -> 0x004d }
            com.google.android.gms.internal.zzpb r5 = new com.google.android.gms.internal.zzpb     // Catch:{ RemoteException -> 0x004d }
            r5.<init>(r1)     // Catch:{ RemoteException -> 0x004d }
            r2.add(r5)     // Catch:{ RemoteException -> 0x004d }
            goto L_0x0020
        L_0x004d:
            r1 = move-exception
            java.lang.String r2 = "Failed to get image."
            com.google.android.gms.internal.zzaiw.zzb(r2, r1)
        L_0x0053:
            com.google.android.gms.internal.zzpq r1 = r6.zzbun     // Catch:{ RemoteException -> 0x0084 }
            com.google.android.gms.internal.zzoy r2 = r1.zzjt()     // Catch:{ RemoteException -> 0x0084 }
            if (r2 == 0) goto L_0x0082
            com.google.android.gms.internal.zzpb r1 = new com.google.android.gms.internal.zzpb     // Catch:{ RemoteException -> 0x0084 }
            r1.<init>(r2)     // Catch:{ RemoteException -> 0x0084 }
        L_0x0060:
            r6.zzbuo = r1
            com.google.android.gms.internal.zzpq r1 = r6.zzbun     // Catch:{ RemoteException -> 0x008c }
            com.google.android.gms.internal.zzou r1 = r1.zzjs()     // Catch:{ RemoteException -> 0x008c }
            if (r1 == 0) goto L_0x0076
            com.google.android.gms.internal.zzox r1 = new com.google.android.gms.internal.zzox     // Catch:{ RemoteException -> 0x008c }
            com.google.android.gms.internal.zzpq r2 = r6.zzbun     // Catch:{ RemoteException -> 0x008c }
            com.google.android.gms.internal.zzou r2 = r2.zzjs()     // Catch:{ RemoteException -> 0x008c }
            r1.<init>(r2)     // Catch:{ RemoteException -> 0x008c }
            r3 = r1
        L_0x0076:
            r6.zzbum = r3
            return
        L_0x0079:
            com.google.android.gms.internal.zzpa r2 = new com.google.android.gms.internal.zzpa     // Catch:{ RemoteException -> 0x004d }
            r2.<init>(r1)     // Catch:{ RemoteException -> 0x004d }
            r1 = r2
            goto L_0x0040
        L_0x0080:
            r1 = r3
            goto L_0x0040
        L_0x0082:
            r1 = r3
            goto L_0x0060
        L_0x0084:
            r1 = move-exception
            java.lang.String r2 = "Failed to get image."
            com.google.android.gms.internal.zzaiw.zzb(r2, r1)
            r1 = r3
            goto L_0x0060
        L_0x008c:
            r1 = move-exception
            java.lang.String r2 = "Failed to get attribution info."
            com.google.android.gms.internal.zzaiw.zzb(r2, r1)
            goto L_0x0076
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpt.<init>(com.google.android.gms.internal.zzpq):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: zzjn */
    public final IObjectWrapper zzbg() {
        try {
            return this.zzbun.zzjn();
        } catch (RemoteException e) {
            zzaiw.zzb("Failed to retrieve native ad engine.", e);
            return null;
        }
    }

    public final void destroy() {
        try {
            this.zzbun.destroy();
        } catch (RemoteException e) {
            zzaiw.zzb("Failed to destroy", e);
        }
    }

    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzbum;
    }

    public final CharSequence getAdvertiser() {
        try {
            return this.zzbun.getAdvertiser();
        } catch (RemoteException e) {
            zzaiw.zzb("Failed to get attribution.", e);
            return null;
        }
    }

    public final CharSequence getBody() {
        try {
            return this.zzbun.getBody();
        } catch (RemoteException e) {
            zzaiw.zzb("Failed to get body.", e);
            return null;
        }
    }

    public final CharSequence getCallToAction() {
        try {
            return this.zzbun.getCallToAction();
        } catch (RemoteException e) {
            zzaiw.zzb("Failed to get call to action.", e);
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            return this.zzbun.getExtras();
        } catch (RemoteException e) {
            zzaiw.zzc("Failed to get extras", e);
            return null;
        }
    }

    public final CharSequence getHeadline() {
        try {
            return this.zzbun.getHeadline();
        } catch (RemoteException e) {
            zzaiw.zzb("Failed to get headline.", e);
            return null;
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzbuk;
    }

    public final NativeAd.Image getLogo() {
        return this.zzbuo;
    }

    public final CharSequence getMediationAdapterClassName() {
        try {
            return this.zzbun.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzaiw.zzb("Failed to get mediation adapter class name.", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zzbun.getVideoController() != null) {
                this.zzbeq.zza(this.zzbun.getVideoController());
            }
        } catch (RemoteException e) {
            zzaiw.zzb("Exception occurred while getting video controller", e);
        }
        return this.zzbeq;
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zzbun.performClick(bundle);
        } catch (RemoteException e) {
            zzaiw.zzb("Failed to perform click.", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzbun.recordImpression(bundle);
        } catch (RemoteException e) {
            zzaiw.zzb("Failed to record impression.", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzbun.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzaiw.zzb("Failed to report touch event.", e);
        }
    }
}
