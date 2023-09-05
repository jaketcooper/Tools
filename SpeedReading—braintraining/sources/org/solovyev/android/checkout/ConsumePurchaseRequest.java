package org.solovyev.android.checkout;

import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

final class ConsumePurchaseRequest extends Request<Object> {
    @Nonnull
    private final String mToken;

    ConsumePurchaseRequest(@Nonnull String token) {
        super(RequestType.CONSUME_PURCHASE);
        this.mToken = token;
    }

    /* access modifiers changed from: package-private */
    public void start(@Nonnull IInAppBillingService service, @Nonnull String packageName) throws RemoteException, RequestException {
        if (!handleError(service.consumePurchase(this.mApiVersion, packageName, this.mToken))) {
            Billing.waitGooglePlay();
            onSuccess(new Object());
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public String getCacheKey() {
        return null;
    }
}
