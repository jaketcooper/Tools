package org.solovyev.android.checkout;

import android.os.Bundle;
import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONException;

final class GetPurchasesRequest extends Request<Purchases> {
    @Nullable
    private final String mContinuationToken;
    @Nonnull
    private final String mProduct;
    @Nonnull
    private final PurchaseVerifier mVerifier;

    GetPurchasesRequest(@Nonnull String product, @Nullable String continuationToken, @Nonnull PurchaseVerifier verifier) {
        super(RequestType.GET_PURCHASES);
        this.mProduct = product;
        this.mContinuationToken = continuationToken;
        this.mVerifier = verifier;
    }

    GetPurchasesRequest(@Nonnull GetPurchasesRequest request, @Nonnull String continuationToken) {
        super(RequestType.GET_PURCHASES, request);
        this.mProduct = request.mProduct;
        this.mContinuationToken = continuationToken;
        this.mVerifier = request.mVerifier;
    }

    /* access modifiers changed from: package-private */
    @Nonnull
    public String getProduct() {
        return this.mProduct;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public String getContinuationToken() {
        return this.mContinuationToken;
    }

    /* access modifiers changed from: package-private */
    public void start(@Nonnull IInAppBillingService service, @Nonnull String packageName) throws RemoteException {
        Bundle bundle = service.getPurchases(this.mApiVersion, packageName, this.mProduct, this.mContinuationToken);
        if (!handleError(bundle)) {
            try {
                String continuationToken = Purchases.getContinuationTokenFromBundle(bundle);
                List<Purchase> purchases = Purchases.getListFromBundle(bundle);
                if (purchases.isEmpty()) {
                    onSuccess(new Purchases(this.mProduct, purchases, continuationToken));
                    return;
                }
                VerificationListener listener = new VerificationListener(this, this.mProduct, continuationToken);
                this.mVerifier.verify(purchases, listener);
                if (!listener.mCalled) {
                    listener.onError(ResponseCodes.EXCEPTION, new IllegalStateException("Either onSuccess or onError methods must be called by PurchaseVerifier"));
                }
            } catch (JSONException e) {
                onError((Exception) e);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public String getCacheKey() {
        if (this.mContinuationToken != null) {
            return this.mProduct + "_" + this.mContinuationToken;
        }
        return this.mProduct;
    }

    private static class VerificationListener implements RequestListener<List<Purchase>> {
        /* access modifiers changed from: private */
        public boolean mCalled;
        @Nullable
        private final String mContinuationToken;
        @Nonnull
        private final Thread mOriginalThread = Thread.currentThread();
        @Nonnull
        private final String mProduct;
        @Nonnull
        private final Request<Purchases> mRequest;

        public VerificationListener(@Nonnull Request<Purchases> request, @Nonnull String product, @Nullable String continuationToken) {
            this.mRequest = request;
            this.mProduct = product;
            this.mContinuationToken = continuationToken;
        }

        public void onSuccess(@Nonnull List<Purchase> verifiedPurchases) {
            Check.equals(this.mOriginalThread, Thread.currentThread(), "Must be called on the same thread");
            this.mCalled = true;
            this.mRequest.onSuccess(new Purchases(this.mProduct, verifiedPurchases, this.mContinuationToken));
        }

        public void onError(int response, @Nonnull Exception e) {
            Check.equals(this.mOriginalThread, Thread.currentThread(), "Must be called on the same thread");
            this.mCalled = true;
            if (response == 10001) {
                this.mRequest.onError(e);
            } else {
                this.mRequest.onError(response);
            }
        }
    }
}
