package org.solovyev.android.checkout;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.solovyev.android.checkout.Cache;

final class SafeCache implements Cache {
    @Nonnull
    private final Cache mCache;

    SafeCache(@Nonnull Cache cache) {
        this.mCache = cache;
    }

    @Nullable
    public Cache.Entry get(@Nonnull Cache.Key key) {
        try {
            return this.mCache.get(key);
        } catch (Exception e) {
            Billing.error(e);
            return null;
        }
    }

    public void put(@Nonnull Cache.Key key, @Nonnull Cache.Entry entry) {
        try {
            this.mCache.put(key, entry);
        } catch (Exception e) {
            Billing.error(e);
        }
    }

    public void init() {
        try {
            this.mCache.init();
        } catch (Exception e) {
            Billing.error(e);
        }
    }

    public void remove(@Nonnull Cache.Key key) {
        try {
            this.mCache.remove(key);
        } catch (Exception e) {
            Billing.error(e);
        }
    }

    public void removeAll(int type) {
        try {
            this.mCache.removeAll(type);
        } catch (Exception e) {
            Billing.error(e);
        }
    }

    public void clear() {
        try {
            this.mCache.clear();
        } catch (Exception e) {
            Billing.error(e);
        }
    }
}
