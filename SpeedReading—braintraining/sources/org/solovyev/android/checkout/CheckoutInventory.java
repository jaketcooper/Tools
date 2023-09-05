package org.solovyev.android.checkout;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.GuardedBy;
import org.solovyev.android.checkout.BaseInventory;
import org.solovyev.android.checkout.Checkout;
import org.solovyev.android.checkout.Inventory;

final class CheckoutInventory extends BaseInventory {

    private class Worker implements Checkout.Listener, Runnable {
        @GuardedBy("mLock")
        private int mCount;
        @GuardedBy("mLock")
        private final Inventory.Products mProducts = new Inventory.Products();
        @Nonnull
        private final BaseInventory.Task mTask;

        public Worker(@Nonnull BaseInventory.Task task) {
            this.mTask = task;
        }

        public void run() {
            this.mCount = ProductTypes.ALL.size() * 3;
            CheckoutInventory.this.mCheckout.whenReady(this);
        }

        public void onReady(@Nonnull BillingRequests requests) {
        }

        public void onReady(@Nonnull BillingRequests requests, @Nonnull String productId, boolean billingSupported) {
            Inventory.Product product = new Inventory.Product(productId, billingSupported);
            synchronized (CheckoutInventory.this.mLock) {
                countDown();
                this.mProducts.add(product);
                if (this.mTask.isCancelled() || !product.supported || !this.mTask.getRequest().shouldLoadPurchases(productId)) {
                    countDown(1);
                } else {
                    loadPurchases(requests, product);
                }
                if (this.mTask.isCancelled() || !product.supported || !this.mTask.getRequest().shouldLoadSkus(productId)) {
                    countDown(1);
                } else {
                    loadSkus(requests, product);
                }
            }
        }

        /* access modifiers changed from: private */
        public void countDown() {
            Check.isTrue(Thread.holdsLock(CheckoutInventory.this.mLock), "Must be synchronized");
            countDown(1);
        }

        private void countDown(int count) {
            Check.isTrue(Thread.holdsLock(CheckoutInventory.this.mLock), "Must be synchronized");
            this.mCount -= count;
            Check.isTrue(this.mCount >= 0, "Can't be negative");
            if (this.mCount == 0) {
                this.mTask.onDone(this.mProducts);
            }
        }

        private void loadPurchases(@Nonnull BillingRequests requests, @Nonnull final Inventory.Product product) {
            requests.getAllPurchases(product.f182id, CheckoutInventory.this.synchronizedListener(new RequestListener<Purchases>() {
                public void onSuccess(@Nonnull Purchases purchases) {
                    product.setPurchases(purchases.list);
                    Worker.this.countDown();
                }

                public void onError(int response, @Nonnull Exception e) {
                    Worker.this.countDown();
                }
            }));
        }

        private void loadSkus(@Nonnull BillingRequests requests, @Nonnull final Inventory.Product product) {
            List<String> skuIds = this.mTask.getRequest().getSkus(product.f182id);
            if (skuIds.isEmpty()) {
                Billing.warning("There are no SKUs for \"" + product.f182id + "\" product. No SKU information will be loaded");
                synchronized (CheckoutInventory.this.mLock) {
                    countDown();
                }
                return;
            }
            requests.getSkus(product.f182id, skuIds, CheckoutInventory.this.synchronizedListener(new RequestListener<Skus>() {
                public void onSuccess(@Nonnull Skus skus) {
                    product.setSkus(skus.list);
                    Worker.this.countDown();
                }

                public void onError(int response, @Nonnull Exception e) {
                    Worker.this.countDown();
                }
            }));
        }
    }

    CheckoutInventory(@Nonnull Checkout checkout) {
        super(checkout);
    }

    /* access modifiers changed from: protected */
    @Nonnull
    public Runnable createWorker(BaseInventory.Task task) {
        return new Worker(task);
    }
}
