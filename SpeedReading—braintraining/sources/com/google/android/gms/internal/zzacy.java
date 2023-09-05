package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;

@zzzb
public final class zzacy implements RewardItem {
    private final zzacn zzctk;

    public zzacy(zzacn zzacn) {
        this.zzctk = zzacn;
    }

    public final int getAmount() {
        if (this.zzctk == null) {
            return 0;
        }
        try {
            return this.zzctk.getAmount();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }

    public final String getType() {
        if (this.zzctk == null) {
            return null;
        }
        try {
            return this.zzctk.getType();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not forward getType to RewardItem", e);
            return null;
        }
    }
}
