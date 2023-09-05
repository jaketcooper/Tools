package p006io.realm;

import com.safonov.speedreading.training.fragment.cuptimer.repository.entity.CupTimerConfig;

/* renamed from: io.realm.CupTimerResultRealmProxyInterface */
public interface CupTimerResultRealmProxyInterface {
    CupTimerConfig realmGet$config();

    int realmGet$id();

    long realmGet$unixTime();

    void realmSet$config(CupTimerConfig cupTimerConfig);

    void realmSet$id(int i);

    void realmSet$unixTime(long j);
}
