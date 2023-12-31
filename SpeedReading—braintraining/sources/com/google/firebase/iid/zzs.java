package com.google.firebase.iid;

import android.os.Bundle;

final class zzs extends zzt<Void> {
    zzs(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    /* access modifiers changed from: package-private */
    public final void zzad(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            finish(null);
        } else {
            zzb(new zzu(4, "Invalid response to one way request"));
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzchl() {
        return true;
    }
}
