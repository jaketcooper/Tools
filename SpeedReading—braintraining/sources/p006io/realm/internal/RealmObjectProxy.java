package p006io.realm.internal;

import p006io.realm.ProxyState;
import p006io.realm.RealmModel;

/* renamed from: io.realm.internal.RealmObjectProxy */
public interface RealmObjectProxy extends RealmModel {
    void realm$injectObjectContext();

    ProxyState realmGet$proxyState();

    /* renamed from: io.realm.internal.RealmObjectProxy$CacheData */
    public static class CacheData<E extends RealmModel> {
        public int minDepth;
        public final E object;

        public CacheData(int minDepth2, E object2) {
            this.minDepth = minDepth2;
            this.object = object2;
        }
    }
}
