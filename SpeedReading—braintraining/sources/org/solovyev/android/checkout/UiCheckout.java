package org.solovyev.android.checkout;

import android.content.Intent;
import android.util.SparseArray;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.solovyev.android.checkout.Checkout;

public abstract class UiCheckout extends Checkout {
    static final int DEFAULT_REQUEST_CODE = 51966;
    @Nonnull
    private final SparseArray<PurchaseFlow> mFlows = new SparseArray<>();

    /* access modifiers changed from: protected */
    @Nonnull
    public abstract IntentStarter makeIntentStarter();

    protected UiCheckout(@Nonnull Object tag, @Nonnull Billing billing) {
        super(tag, billing);
    }

    public void stop() {
        this.mFlows.clear();
        super.stop();
    }

    public void createPurchaseFlow(@Nonnull RequestListener<Purchase> listener) {
        createPurchaseFlow(DEFAULT_REQUEST_CODE, listener);
    }

    public void createPurchaseFlow(int requestCode, @Nonnull RequestListener<Purchase> listener) {
        createPurchaseFlow(requestCode, listener, false);
    }

    public void destroyPurchaseFlow() {
        destroyPurchaseFlow(DEFAULT_REQUEST_CODE);
    }

    public void destroyPurchaseFlow(int requestCode) {
        PurchaseFlow flow = this.mFlows.get(requestCode);
        if (flow != null) {
            this.mFlows.delete(requestCode);
            flow.cancel();
        }
    }

    @Nonnull
    public PurchaseFlow getPurchaseFlow() {
        return getPurchaseFlow(DEFAULT_REQUEST_CODE);
    }

    @Nonnull
    public PurchaseFlow getPurchaseFlow(int requestCode) {
        PurchaseFlow flow = this.mFlows.get(requestCode);
        if (flow != null) {
            return flow;
        }
        throw new IllegalArgumentException("Purchase flow doesn't exist. Have you forgotten to create it?");
    }

    @Nonnull
    public PurchaseFlow createOneShotPurchaseFlow(@Nonnull RequestListener<Purchase> listener) {
        return createOneShotPurchaseFlow(DEFAULT_REQUEST_CODE, listener);
    }

    @Nonnull
    public PurchaseFlow createOneShotPurchaseFlow(int requestCode, @Nonnull RequestListener<Purchase> listener) {
        return createPurchaseFlow(requestCode, listener, true);
    }

    @Nonnull
    private PurchaseFlow createPurchaseFlow(int requestCode, @Nonnull RequestListener<Purchase> listener, boolean oneShot) {
        if (this.mFlows.get(requestCode) != null) {
            throw new IllegalArgumentException("Purchase flow associated with requestCode=" + requestCode + " already exists");
        }
        if (oneShot) {
            listener = new OneShotRequestListener(listener, requestCode);
        }
        PurchaseFlow flow = this.mBilling.createPurchaseFlow(makeIntentStarter(), requestCode, listener);
        this.mFlows.append(requestCode, flow);
        return flow;
    }

    public void startPurchaseFlow(final String product, final String sku, @Nullable final String payload, RequestListener<Purchase> listener) {
        createOneShotPurchaseFlow(listener);
        whenReady(new Checkout.EmptyListener() {
            public void onReady(@Nonnull BillingRequests requests) {
                requests.purchase(product, sku, payload, UiCheckout.this.getPurchaseFlow());
            }
        });
    }

    public void startPurchaseFlow(Sku sku, @Nullable String payload, RequestListener<Purchase> listener) {
        startPurchaseFlow(sku.f185id.product, sku.f185id.code, payload, listener);
    }

    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        PurchaseFlow flow = this.mFlows.get(requestCode);
        if (flow == null) {
            Billing.warning("Purchase flow doesn't exist for requestCode=" + requestCode + ". Have you forgotten to create it?");
            return false;
        }
        flow.onActivityResult(requestCode, resultCode, data);
        return true;
    }

    private class OneShotRequestListener extends RequestListenerWrapper<Purchase> {
        private final int mRequestCode;

        public OneShotRequestListener(RequestListener<Purchase> listener, int requestCode) {
            super(listener);
            this.mRequestCode = requestCode;
        }

        public void onError(int response, @Nonnull Exception e) {
            UiCheckout.this.destroyPurchaseFlow(this.mRequestCode);
            super.onError(response, e);
        }

        public void onCancel() {
            UiCheckout.this.destroyPurchaseFlow(this.mRequestCode);
        }

        public void onSuccess(@Nonnull Purchase result) {
            UiCheckout.this.destroyPurchaseFlow(this.mRequestCode);
            super.onSuccess(result);
        }
    }
}
