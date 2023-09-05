package p006io.realm.internal.android;

import android.os.Looper;
import p006io.realm.internal.Capabilities;

/* renamed from: io.realm.internal.android.AndroidCapabilities */
public class AndroidCapabilities implements Capabilities {
    private final boolean hasLooper;
    private final boolean isIntentServiceThread;

    public AndroidCapabilities() {
        this.hasLooper = Looper.myLooper() != null;
        this.isIntentServiceThread = isIntentServiceThread();
    }

    public boolean canDeliverNotification() {
        return this.hasLooper && !this.isIntentServiceThread;
    }

    public void checkCanDeliverNotification(String exceptionMessage) {
        if (!this.hasLooper) {
            throw new IllegalStateException(exceptionMessage == null ? "" : exceptionMessage + " " + "Realm cannot be automatically updated on a thread without a looper.");
        } else if (this.isIntentServiceThread) {
            throw new IllegalStateException(exceptionMessage == null ? "" : exceptionMessage + " " + "Realm cannot be automatically updated on an IntentService thread.");
        }
    }

    private static boolean isIntentServiceThread() {
        String threadName = Thread.currentThread().getName();
        return threadName != null && threadName.startsWith("IntentService[");
    }
}
