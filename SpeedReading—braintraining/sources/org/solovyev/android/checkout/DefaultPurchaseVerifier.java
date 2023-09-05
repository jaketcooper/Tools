package org.solovyev.android.checkout;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;

class DefaultPurchaseVerifier implements PurchaseVerifier {
    @Nonnull
    private final String mPublicKey;

    public DefaultPurchaseVerifier(@Nonnull String publicKey) {
        this.mPublicKey = publicKey;
    }

    public void verify(@Nonnull List<Purchase> purchases, @Nonnull RequestListener<List<Purchase>> listener) {
        List<Purchase> verifiedPurchases = new ArrayList<>(purchases.size());
        for (Purchase purchase : purchases) {
            if (Security.verifyPurchase(this.mPublicKey, purchase.data, purchase.signature)) {
                verifiedPurchases.add(purchase);
            } else if (TextUtils.isEmpty(purchase.signature)) {
                Billing.error("Cannot verify purchase: " + purchase + ". Signature is empty");
            } else {
                Billing.error("Cannot verify purchase: " + purchase + ". Wrong signature");
            }
        }
        listener.onSuccess(verifiedPurchases);
    }
}
