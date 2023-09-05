package p006io.realm.internal.android;

import android.os.Handler;
import android.os.Looper;
import p006io.realm.internal.Capabilities;
import p006io.realm.internal.Keep;
import p006io.realm.internal.RealmNotifier;
import p006io.realm.internal.SharedRealm;

@Keep
/* renamed from: io.realm.internal.android.AndroidRealmNotifier */
public class AndroidRealmNotifier extends RealmNotifier {
    private Handler handler;

    public AndroidRealmNotifier(SharedRealm sharedRealm, Capabilities capabilities) {
        super(sharedRealm);
        if (capabilities.canDeliverNotification()) {
            this.handler = new Handler(Looper.myLooper());
        } else {
            this.handler = null;
        }
    }

    public boolean post(Runnable runnable) {
        return this.handler != null && this.handler.post(runnable);
    }
}
