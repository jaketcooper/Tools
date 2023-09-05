package org.solovyev.android.checkout;

import javax.annotation.Nonnull;
import org.solovyev.android.checkout.BaseInventory;
import org.solovyev.android.checkout.Inventory;

class FallingBackInventory extends BaseInventory {
    /* access modifiers changed from: private */
    @Nonnull
    public final Inventory mFallbackInventory;
    /* access modifiers changed from: private */
    @Nonnull
    public final CheckoutInventory mMainInventory;

    private class Worker implements Runnable {
        /* access modifiers changed from: private */
        @Nonnull
        public final FallbackCallback mFallbackCallback = new FallbackCallback();
        @Nonnull
        private final MainCallback mMainCallback = new MainCallback();
        /* access modifiers changed from: private */
        @Nonnull
        public final BaseInventory.Task mTask;

        public Worker(@Nonnull BaseInventory.Task task) {
            this.mTask = task;
        }

        public void run() {
            this.mMainCallback.load();
        }

        private class MainCallback implements Inventory.Callback {
            private MainCallback() {
            }

            public void onLoaded(@Nonnull Inventory.Products products) {
                if (!Worker.this.mTask.onMaybeDone(products)) {
                    Worker.this.mFallbackCallback.load();
                }
            }

            public void load() {
                FallingBackInventory.this.mMainInventory.load(Worker.this.mTask.getRequest(), this);
            }
        }

        private class FallbackCallback implements Inventory.Callback {
            private FallbackCallback() {
            }

            public void onLoaded(@Nonnull Inventory.Products products) {
                Worker.this.mTask.onDone(products);
            }

            public void load() {
                FallingBackInventory.this.mFallbackInventory.load(Worker.this.mTask.getRequest(), this);
            }
        }
    }

    public FallingBackInventory(@Nonnull Checkout checkout, @Nonnull Inventory fallbackInventory) {
        super(checkout);
        this.mMainInventory = new CheckoutInventory(checkout);
        this.mFallbackInventory = fallbackInventory;
    }

    /* access modifiers changed from: protected */
    @Nonnull
    public Runnable createWorker(@Nonnull BaseInventory.Task task) {
        return new Worker(task);
    }
}
