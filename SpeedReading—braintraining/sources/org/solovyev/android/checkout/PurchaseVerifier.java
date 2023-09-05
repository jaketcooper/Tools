package org.solovyev.android.checkout;

import java.util.List;
import javax.annotation.Nonnull;

public interface PurchaseVerifier {
    void verify(@Nonnull List<Purchase> list, @Nonnull RequestListener<List<Purchase>> requestListener);
}
