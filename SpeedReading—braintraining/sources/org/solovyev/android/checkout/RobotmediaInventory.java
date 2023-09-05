package org.solovyev.android.checkout;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.annotation.Nonnull;
import org.solovyev.android.checkout.BaseInventory;
import org.solovyev.android.checkout.Inventory;

public final class RobotmediaInventory extends BaseInventory {
    /* access modifiers changed from: private */
    @Nonnull
    public final Executor mBackground;
    /* access modifiers changed from: private */
    @Nonnull
    public final Executor mOnLoadExecutor;

    private class Worker implements Runnable {
        /* access modifiers changed from: private */
        @Nonnull
        public final BaseInventory.Task mTask;

        public Worker(@Nonnull BaseInventory.Task task) {
            this.mTask = task;
        }

        public void run() {
            if (RobotmediaDatabase.exists(RobotmediaInventory.this.mCheckout.getContext())) {
                RobotmediaInventory.this.mBackground.execute(new Loader());
            } else {
                onLoaded(RobotmediaDatabase.toInventoryProducts(ProductTypes.ALL));
            }
        }

        private class Loader implements Runnable {
            private Loader() {
            }

            public void run() {
                Worker.this.onLoaded(new RobotmediaDatabase(RobotmediaInventory.this.mCheckout.getContext()).load(Worker.this.mTask.getRequest()));
            }
        }

        /* access modifiers changed from: private */
        public void onLoaded(@Nonnull final Inventory.Products products) {
            RobotmediaInventory.this.mOnLoadExecutor.execute(new Runnable() {
                public void run() {
                    Worker.this.mTask.onDone(products);
                }
            });
        }
    }

    public RobotmediaInventory(@Nonnull Checkout checkout, @Nonnull Executor onLoadExecutor) {
        this(checkout, Executors.newSingleThreadExecutor(), onLoadExecutor);
    }

    public RobotmediaInventory(@Nonnull Checkout checkout, @Nonnull Executor background, @Nonnull Executor onLoadExecutor) {
        super(checkout);
        this.mBackground = background;
        this.mOnLoadExecutor = onLoadExecutor;
    }

    /* access modifiers changed from: protected */
    @Nonnull
    public Runnable createWorker(BaseInventory.Task task) {
        return new Worker(task);
    }
}
