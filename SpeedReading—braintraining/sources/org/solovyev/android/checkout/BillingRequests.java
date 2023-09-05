package org.solovyev.android.checkout;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface BillingRequests {
    void cancel(int i);

    void cancelAll();

    int changeSubscription(@Nonnull List<String> list, @Nonnull String str, @Nullable String str2, @Nonnull PurchaseFlow purchaseFlow);

    int changeSubscription(@Nonnull List<Sku> list, @Nonnull Sku sku, @Nullable String str, @Nonnull PurchaseFlow purchaseFlow);

    int consume(@Nonnull String str, @Nonnull RequestListener<Object> requestListener);

    int getAllPurchases(@Nonnull String str, @Nonnull RequestListener<Purchases> requestListener);

    int getPurchases(@Nonnull String str, @Nullable String str2, @Nonnull RequestListener<Purchases> requestListener);

    int getSkus(@Nonnull String str, @Nonnull List<String> list, @Nonnull RequestListener<Skus> requestListener);

    int isBillingSupported(@Nonnull String str);

    int isBillingSupported(@Nonnull String str, int i);

    int isBillingSupported(@Nonnull String str, int i, @Nonnull RequestListener<Object> requestListener);

    int isBillingSupported(@Nonnull String str, @Nonnull RequestListener<Object> requestListener);

    int isChangeSubscriptionSupported(@Nonnull RequestListener<Object> requestListener);

    int isPurchased(@Nonnull String str, @Nonnull String str2, @Nonnull RequestListener<Boolean> requestListener);

    int purchase(@Nonnull String str, @Nonnull String str2, @Nullable String str3, @Nonnull PurchaseFlow purchaseFlow);

    int purchase(@Nonnull Sku sku, @Nullable String str, @Nonnull PurchaseFlow purchaseFlow);
}
