package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzt<T> {
    final int what;
    final TaskCompletionSource<T> zzgpg = new TaskCompletionSource<>();
    final int zzidh;
    final Bundle zznvh;

    zzt(int i, int i2, Bundle bundle) {
        this.zzidh = i;
        this.what = i2;
        this.zznvh = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void finish(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            Log.d("MessengerIpcClient", new StringBuilder(String.valueOf(valueOf).length() + 16 + String.valueOf(valueOf2).length()).append("Finishing ").append(valueOf).append(" with ").append(valueOf2).toString());
        }
        this.zzgpg.setResult(t);
    }

    public String toString() {
        int i = this.what;
        int i2 = this.zzidh;
        return new StringBuilder(55).append("Request { what=").append(i).append(" id=").append(i2).append(" oneWay=").append(zzchl()).append("}").toString();
    }

    /* access modifiers changed from: package-private */
    public abstract void zzad(Bundle bundle);

    /* access modifiers changed from: package-private */
    public final void zzb(zzu zzu) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(zzu);
            Log.d("MessengerIpcClient", new StringBuilder(String.valueOf(valueOf).length() + 14 + String.valueOf(valueOf2).length()).append("Failing ").append(valueOf).append(" with ").append(valueOf2).toString());
        }
        this.zzgpg.setException(zzu);
    }

    /* access modifiers changed from: package-private */
    public abstract boolean zzchl();
}
