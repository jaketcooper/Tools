package p006io.realm.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/* renamed from: io.realm.internal.NativeObjectReference */
final class NativeObjectReference extends PhantomReference<NativeObject> {
    private static ReferencePool referencePool = new ReferencePool();
    private final Context context;
    private final long nativeFinalizerPtr;
    private final long nativePtr;
    /* access modifiers changed from: private */
    public NativeObjectReference next;
    /* access modifiers changed from: private */
    public NativeObjectReference prev;

    private static native void nativeCleanUp(long j, long j2);

    /* renamed from: io.realm.internal.NativeObjectReference$ReferencePool */
    private static class ReferencePool {
        NativeObjectReference head;

        private ReferencePool() {
        }

        /* access modifiers changed from: package-private */
        public synchronized void add(NativeObjectReference ref) {
            NativeObjectReference unused = ref.prev = null;
            NativeObjectReference unused2 = ref.next = this.head;
            if (this.head != null) {
                NativeObjectReference unused3 = this.head.prev = ref;
            }
            this.head = ref;
        }

        /* access modifiers changed from: package-private */
        public synchronized void remove(NativeObjectReference ref) {
            NativeObjectReference next = ref.next;
            NativeObjectReference prev = ref.prev;
            NativeObjectReference unused = ref.next = null;
            NativeObjectReference unused2 = ref.prev = null;
            if (prev != null) {
                NativeObjectReference unused3 = prev.next = next;
            } else {
                this.head = next;
            }
            if (next != null) {
                NativeObjectReference unused4 = next.prev = prev;
            }
        }
    }

    NativeObjectReference(Context context2, NativeObject referent, ReferenceQueue<? super NativeObject> referenceQueue) {
        super(referent, referenceQueue);
        this.nativePtr = referent.getNativePtr();
        this.nativeFinalizerPtr = referent.getNativeFinalizerPtr();
        this.context = context2;
        referencePool.add(this);
    }

    /* access modifiers changed from: package-private */
    public void cleanup() {
        synchronized (this.context) {
            nativeCleanUp(this.nativeFinalizerPtr, this.nativePtr);
        }
        referencePool.remove(this);
    }
}
