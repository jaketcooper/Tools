package org.solovyev.android.checkout;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import org.solovyev.android.checkout.Cache;

@ThreadSafe
final class ConcurrentCache implements Cache {
    @Nonnull
    private static final String TAG = "Cache";
    @GuardedBy("this")
    @Nullable
    private final Cache mCache;

    ConcurrentCache(@Nullable Cache cache) {
        this.mCache = cache;
    }

    public boolean hasCache() {
        return this.mCache != null;
    }

    @Nullable
    public Cache.Entry get(@Nonnull Cache.Key key) {
        if (this.mCache == null) {
            return null;
        }
        synchronized (this) {
            Cache.Entry entry = this.mCache.get(key);
            if (entry == null) {
                Billing.debug(TAG, "Key=" + key + " is not in the cache");
                return null;
            }
            long now = System.currentTimeMillis();
            if (now >= entry.expiresAt) {
                Billing.debug(TAG, "Key=" + key + " is in the cache but was expired at " + entry.expiresAt + ", now is " + now);
                this.mCache.remove(key);
                return null;
            }
            Billing.debug(TAG, "Key=" + key + " is in the cache");
            return entry;
        }
    }

    public void put(@Nonnull Cache.Key key, @Nonnull Cache.Entry entry) {
        if (this.mCache != null) {
            synchronized (this) {
                Billing.debug(TAG, "Adding entry with key=" + key + " to the cache");
                this.mCache.put(key, entry);
            }
        }
    }

    public void putIfNotExist(@Nonnull Cache.Key key, @Nonnull Cache.Entry entry) {
        if (this.mCache != null) {
            synchronized (this) {
                if (this.mCache.get(key) == null) {
                    Billing.debug(TAG, "Adding entry with key=" + key + " to the cache");
                    this.mCache.put(key, entry);
                } else {
                    Billing.debug(TAG, "Entry with key=" + key + " is already in the cache, won't add");
                }
            }
        }
    }

    public void init() {
        if (this.mCache != null) {
            synchronized (this) {
                Billing.debug(TAG, "Initializing cache");
                this.mCache.init();
            }
        }
    }

    public void remove(@Nonnull Cache.Key key) {
        if (this.mCache != null) {
            synchronized (this) {
                Billing.debug(TAG, "Removing entry with key=" + key + " from the cache");
                this.mCache.remove(key);
            }
        }
    }

    public void removeAll(int type) {
        if (this.mCache != null) {
            synchronized (this) {
                Billing.debug(TAG, "Removing all entries with type=" + type + " from the cache");
                this.mCache.removeAll(type);
            }
        }
    }

    public void clear() {
        if (this.mCache != null) {
            synchronized (this) {
                Billing.debug(TAG, "Clearing the cache");
                this.mCache.clear();
            }
        }
    }
}
