package p006io.realm.internal.async;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import p006io.realm.RealmAsyncTask;

/* renamed from: io.realm.internal.async.RealmAsyncTaskImpl */
public final class RealmAsyncTaskImpl implements RealmAsyncTask {
    private volatile boolean isCancelled = false;
    private final Future<?> pendingTask;
    private final ThreadPoolExecutor service;

    public RealmAsyncTaskImpl(Future<?> pendingTask2, ThreadPoolExecutor service2) {
        this.pendingTask = pendingTask2;
        this.service = service2;
    }

    public void cancel() {
        this.pendingTask.cancel(true);
        this.isCancelled = true;
        this.service.getQueue().remove(this.pendingTask);
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }
}
