package p006io.realm;

import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableConfig;

/* renamed from: io.realm.SchulteTableResultRealmProxyInterface */
public interface SchulteTableResultRealmProxyInterface {
    SchulteTableConfig realmGet$config();

    int realmGet$id();

    long realmGet$time();

    long realmGet$unixTime();

    void realmSet$config(SchulteTableConfig schulteTableConfig);

    void realmSet$id(int i);

    void realmSet$time(long j);

    void realmSet$unixTime(long j);
}
