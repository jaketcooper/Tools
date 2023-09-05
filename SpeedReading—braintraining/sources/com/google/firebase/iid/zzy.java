package com.google.firebase.iid;

import android.os.Bundle;
import android.os.ConditionVariable;
import android.util.Log;
import java.io.IOException;

final class zzy implements zzz {
    private Bundle zznvh;
    private final ConditionVariable zznvm;
    private String zznvn;

    private zzy() {
        this.zznvm = new ConditionVariable();
    }

    /* synthetic */ zzy(zzx zzx) {
        this();
    }

    public final void onError(String str) {
        this.zznvn = str;
        this.zznvm.open();
    }

    public final void zzag(Bundle bundle) {
        this.zznvh = bundle;
        this.zznvm.open();
    }

    public final Bundle zzchm() throws IOException {
        if (!this.zznvm.block(30000)) {
            Log.w("FirebaseInstanceId", "No response");
            throw new IOException("TIMEOUT");
        } else if (this.zznvn == null) {
            return this.zznvh;
        } else {
            throw new IOException(this.zznvn);
        }
    }
}
