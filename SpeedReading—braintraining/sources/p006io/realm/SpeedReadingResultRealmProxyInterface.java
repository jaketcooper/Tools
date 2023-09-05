package p006io.realm;

import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingConfig;

/* renamed from: io.realm.SpeedReadingResultRealmProxyInterface */
public interface SpeedReadingResultRealmProxyInterface {
    int realmGet$averageSpeed();

    SpeedReadingConfig realmGet$config();

    int realmGet$id();

    int realmGet$maxSpeed();

    long realmGet$unixTime();

    void realmSet$averageSpeed(int i);

    void realmSet$config(SpeedReadingConfig speedReadingConfig);

    void realmSet$id(int i);

    void realmSet$maxSpeed(int i);

    void realmSet$unixTime(long j);
}
