package org.solovyev.android.checkout;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.solovyev.android.checkout.Cache;

class MapCache implements Cache {
    @Nonnull
    private final Map<Cache.Key, Cache.Entry> mMap = new HashMap();

    MapCache() {
    }

    @Nullable
    public Cache.Entry get(@Nonnull Cache.Key key) {
        return this.mMap.get(key);
    }

    public void put(@Nonnull Cache.Key key, @Nonnull Cache.Entry entry) {
        this.mMap.put(key, entry);
    }

    public void init() {
    }

    public void remove(@Nonnull Cache.Key key) {
        this.mMap.remove(key);
    }

    public void removeAll(int type) {
        Iterator<Map.Entry<Cache.Key, Cache.Entry>> iterator = this.mMap.entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getKey().type == type) {
                iterator.remove();
            }
        }
    }

    public void clear() {
        this.mMap.clear();
    }
}
