package org.solovyev.android.checkout;

import javax.annotation.Nonnull;
import org.solovyev.android.checkout.Cache;

enum RequestType {
    BILLING_SUPPORTED("supported", 86400000),
    GET_PURCHASES("purchases", 1200000),
    GET_SKU_DETAILS("skus", 86400000),
    PURCHASE("purchase", 0),
    CHANGE_PURCHASE("change", 0),
    CONSUME_PURCHASE("consume", 0);
    
    @Nonnull
    final String cacheKeyName;
    final long expiresIn;

    private RequestType(@Nonnull String cacheKeyName2, long expiresIn2) {
        this.cacheKeyName = cacheKeyName2;
        this.expiresIn = expiresIn2;
    }

    @Nonnull
    static String getCacheKeyName(int keyType) {
        return values()[keyType].cacheKeyName;
    }

    /* access modifiers changed from: package-private */
    @Nonnull
    public Cache.Key getCacheKey(@Nonnull String key) {
        return new Cache.Key(getCacheKeyType(), key);
    }

    /* access modifiers changed from: package-private */
    public int getCacheKeyType() {
        return ordinal();
    }
}
