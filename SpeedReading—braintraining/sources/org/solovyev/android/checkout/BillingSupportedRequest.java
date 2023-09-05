package org.solovyev.android.checkout;

import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

final class BillingSupportedRequest extends Request<Object> {
    @Nonnull
    private final String mProduct;

    BillingSupportedRequest(@Nonnull String product) {
        this(product, 3);
    }

    BillingSupportedRequest(@Nonnull String product, int apiVersion) {
        super(RequestType.BILLING_SUPPORTED, apiVersion);
        this.mProduct = product;
    }

    public void start(@Nonnull IInAppBillingService service, @Nonnull String packageName) throws RemoteException {
        if (!handleError(service.isBillingSupported(this.mApiVersion, packageName, this.mProduct))) {
            onSuccess(new Object());
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public String getCacheKey() {
        if (this.mApiVersion == 3) {
            return this.mProduct;
        }
        return this.mProduct + "_" + this.mApiVersion;
    }
}
