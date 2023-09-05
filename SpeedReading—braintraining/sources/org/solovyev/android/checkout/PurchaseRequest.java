package org.solovyev.android.checkout;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

final class PurchaseRequest extends Request<PendingIntent> {
    @Nullable
    private final String mPayload;
    @Nonnull
    private final String mProduct;
    @Nonnull
    private final String mSku;

    PurchaseRequest(@Nonnull String product, @Nonnull String sku, @Nullable String payload) {
        super(RequestType.PURCHASE);
        this.mProduct = product;
        this.mSku = sku;
        this.mPayload = payload;
    }

    /* access modifiers changed from: package-private */
    public void start(@Nonnull IInAppBillingService service, @Nonnull String packageName) throws RemoteException, RequestException {
        Bundle bundle = service.getBuyIntent(this.mApiVersion, packageName, this.mSku, this.mProduct, this.mPayload == null ? "" : this.mPayload);
        if (!handleError(bundle)) {
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("BUY_INTENT");
            Check.isNotNull(pendingIntent);
            onSuccess(pendingIntent);
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public String getCacheKey() {
        return null;
    }
}
