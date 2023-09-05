package p006io.realm;

import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightConfig;

/* renamed from: io.realm.LineOfSightResultRealmProxyInterface */
public interface LineOfSightResultRealmProxyInterface {
    LineOfSightConfig realmGet$config();

    int realmGet$foundMistakeCount();

    int realmGet$id();

    int realmGet$mistakeCount();

    long realmGet$unixTime();

    void realmSet$config(LineOfSightConfig lineOfSightConfig);

    void realmSet$foundMistakeCount(int i);

    void realmSet$id(int i);

    void realmSet$mistakeCount(int i);

    void realmSet$unixTime(long j);
}
