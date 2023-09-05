package org.solovyev.android.checkout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.solovyev.android.checkout.Inventory;

public abstract class BaseInventory implements Inventory {
    @Nonnull
    protected final Checkout mCheckout;
    @Nonnull
    protected final Object mLock;
    /* access modifiers changed from: private */
    public final AtomicInteger mTaskIdGenerator = new AtomicInteger();
    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    @Nonnull
    public final List<Task> mTasks = new ArrayList();

    /* access modifiers changed from: protected */
    @Nonnull
    public abstract Runnable createWorker(@Nonnull Task task);

    protected BaseInventory(@Nonnull Checkout checkout) {
        this.mCheckout = checkout;
        this.mLock = checkout.mLock;
    }

    public void cancel() {
        for (Task task : getTasksCopy()) {
            task.cancel();
        }
    }

    public void cancel(int id) {
        synchronized (this.mLock) {
            Iterator<Task> it = this.mTasks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Task task = it.next();
                if (task.mId == id) {
                    task.cancel();
                    break;
                }
            }
        }
    }

    @Nonnull
    private List<Task> getTasksCopy() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mTasks);
        }
        return arrayList;
    }

    public boolean isLoading() {
        boolean z;
        Check.isMainThread();
        synchronized (this.mLock) {
            z = !this.mTasks.isEmpty();
        }
        return z;
    }

    public int load(@Nonnull Inventory.Request request, @Nonnull Inventory.Callback callback) {
        int access$100;
        synchronized (this.mLock) {
            Task task = new Task(request, callback);
            this.mTasks.add(task);
            task.run();
            access$100 = task.mId;
        }
        return access$100;
    }

    /* access modifiers changed from: protected */
    public final <R> RequestListener<R> synchronizedListener(@Nonnull RequestListener<R> l) {
        return new SynchronizedRequestListener(l);
    }

    protected final class Task {
        @GuardedBy("mLock")
        @Nullable
        private Inventory.Callback mCallback;
        /* access modifiers changed from: private */
        public final int mId = BaseInventory.this.mTaskIdGenerator.getAndIncrement();
        @GuardedBy("mLock")
        private final Inventory.Products mProducts = new Inventory.Products();
        @Nonnull
        private final Inventory.Request mRequest;

        public Task(@Nonnull Inventory.Request request, @Nonnull Inventory.Callback callback) {
            this.mRequest = request.copy();
            this.mCallback = callback;
        }

        public boolean isCancelled() {
            boolean z;
            synchronized (BaseInventory.this.mLock) {
                z = this.mCallback == null;
            }
            return z;
        }

        /* access modifiers changed from: private */
        public void cancel() {
            synchronized (BaseInventory.this.mLock) {
                this.mCallback = null;
                BaseInventory.this.mTasks.remove(this);
            }
        }

        public void run() {
            BaseInventory.this.createWorker(this).run();
        }

        @Nonnull
        public Inventory.Request getRequest() {
            return this.mRequest;
        }

        public void onDone(@Nonnull Inventory.Products products) {
            synchronized (BaseInventory.this.mLock) {
                this.mProducts.merge(products);
                onDone();
            }
        }

        public boolean onMaybeDone(@Nonnull Inventory.Products products) {
            boolean z;
            synchronized (BaseInventory.this.mLock) {
                this.mProducts.merge(products);
                if (!existsUnsupported()) {
                    onDone();
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }

        private void onDone() {
            Check.isTrue(Thread.holdsLock(BaseInventory.this.mLock), "Must be synchronized");
            if (this.mCallback != null) {
                BaseInventory.this.mTasks.remove(this);
                this.mCallback.onLoaded(this.mProducts);
                this.mCallback = null;
            }
        }

        private boolean existsUnsupported() {
            Check.isTrue(Thread.holdsLock(BaseInventory.this.mLock), "Must be synchronized");
            Iterator<Inventory.Product> it = this.mProducts.iterator();
            while (it.hasNext()) {
                if (!it.next().supported) {
                    return true;
                }
            }
            return false;
        }
    }

    private final class SynchronizedRequestListener<R> implements RequestListener<R> {
        private final RequestListener<R> mListener;

        public SynchronizedRequestListener(RequestListener<R> listener) {
            this.mListener = listener;
        }

        public void onSuccess(@Nonnull R result) {
            synchronized (BaseInventory.this.mLock) {
                this.mListener.onSuccess(result);
            }
        }

        public void onError(int response, @Nonnull Exception e) {
            synchronized (BaseInventory.this.mLock) {
                this.mListener.onError(response, e);
            }
        }
    }
}
