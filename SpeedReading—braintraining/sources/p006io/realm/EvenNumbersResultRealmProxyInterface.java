package p006io.realm;

import com.safonov.speedreading.training.fragment.evennumbers.repository.entity.EvenNumbersConfig;

/* renamed from: io.realm.EvenNumbersResultRealmProxyInterface */
public interface EvenNumbersResultRealmProxyInterface {
    EvenNumbersConfig realmGet$config();

    int realmGet$id();

    int realmGet$score();

    long realmGet$unixTime();

    void realmSet$config(EvenNumbersConfig evenNumbersConfig);

    void realmSet$id(int i);

    void realmSet$score(int i);

    void realmSet$unixTime(long j);
}
