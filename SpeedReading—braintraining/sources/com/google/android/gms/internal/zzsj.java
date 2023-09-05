package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzbs;
import java.util.Random;

final class zzsj extends zzjr {
    private final zzjq zzbxu;

    zzsj(zzjq zzjq) {
        this.zzbxu = zzjq;
    }

    public final void onAdClicked() throws RemoteException {
        this.zzbxu.onAdClicked();
    }

    public final void onAdClosed() throws RemoteException {
        if (zzss.zzlg()) {
            int intValue = ((Integer) zzbs.zzep().zzd(zzmq.zzbko)).intValue();
            int intValue2 = ((Integer) zzbs.zzep().zzd(zzmq.zzbkp)).intValue();
            if (intValue <= 0 || intValue2 < 0) {
                zzbs.zzer().zzkp();
            } else {
                zzagr.zzczc.postDelayed(zzsk.zzbxv, (long) (new Random().nextInt(intValue2 + 1) + intValue));
            }
        }
        this.zzbxu.onAdClosed();
    }

    public final void onAdFailedToLoad(int i) throws RemoteException {
        this.zzbxu.onAdFailedToLoad(i);
    }

    public final void onAdImpression() throws RemoteException {
        this.zzbxu.onAdImpression();
    }

    public final void onAdLeftApplication() throws RemoteException {
        this.zzbxu.onAdLeftApplication();
    }

    public final void onAdLoaded() throws RemoteException {
        this.zzbxu.onAdLoaded();
    }

    public final void onAdOpened() throws RemoteException {
        this.zzbxu.onAdOpened();
    }
}
