package p006io.realm;

import com.safonov.speedreading.training.fragment.remembernumber.repository.entity.RememberNumberConfig;

/* renamed from: io.realm.RememberNumberResultRealmProxyInterface */
public interface RememberNumberResultRealmProxyInterface {
    RememberNumberConfig realmGet$config();

    int realmGet$id();

    int realmGet$score();

    long realmGet$unixTime();

    void realmSet$config(RememberNumberConfig rememberNumberConfig);

    void realmSet$id(int i);

    void realmSet$score(int i);

    void realmSet$unixTime(long j);
}
