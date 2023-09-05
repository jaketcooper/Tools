package org.solovyev.android.checkout;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

final class ChangePurchaseRequest extends Request<PendingIntent> {
    @Nonnull
    private final String mNewSku;
    @Nonnull
    private final List<String> mOldSkus;
    @Nullable
    private final String mPayload;
    @Nonnull
    private final String mProduct;

    ChangePurchaseRequest(@Nonnull String product, @Nonnull List<String> oldSkus, @Nonnull String newSku, @Nullable String payload) {
        super(RequestType.CHANGE_PURCHASE, 5);
        Check.isTrue(!oldSkus.isEmpty(), "There must be at least one old SKU to be changed");
        this.mProduct = product;
        this.mOldSkus = new ArrayList(oldSkus);
        this.mNewSku = newSku;
        this.mPayload = payload;
    }

    /* access modifiers changed from: package-private */
    public void start(@Nonnull IInAppBillingService service, @Nonnull String packageName) throws RemoteException, RequestException {
        Bundle bundle = service.getBuyIntentToReplaceSkus(this.mApiVersion, packageName, this.mOldSkus, this.mNewSku, this.mProduct, this.mPayload == null ? "" : this.mPayload);
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
