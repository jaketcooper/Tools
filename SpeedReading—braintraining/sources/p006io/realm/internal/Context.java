package p006io.realm.internal;

import java.lang.ref.ReferenceQueue;

/* renamed from: io.realm.internal.Context */
public class Context {
    static final Context dummyContext = new Context();
    private static final Thread finalizingThread = new Thread(new FinalizerRunnable(referenceQueue));
    private static final ReferenceQueue<NativeObject> referenceQueue = new ReferenceQueue<>();

    static {
        finalizingThread.setName("RealmFinalizingDaemon");
        finalizingThread.start();
    }

    /* access modifiers changed from: package-private */
    public void addReference(NativeObject referent) {
        new NativeObjectReference(this, referent, referenceQueue);
    }
}
