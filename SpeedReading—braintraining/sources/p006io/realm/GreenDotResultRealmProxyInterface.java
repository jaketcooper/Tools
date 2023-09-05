package p006io.realm;

import com.safonov.speedreading.training.fragment.greendot.repository.entity.GreenDotConfig;

/* renamed from: io.realm.GreenDotResultRealmProxyInterface */
public interface GreenDotResultRealmProxyInterface {
    GreenDotConfig realmGet$config();

    int realmGet$id();

    long realmGet$unixTime();

    void realmSet$config(GreenDotConfig greenDotConfig);

    void realmSet$id(int i);

    void realmSet$unixTime(long j);
}
