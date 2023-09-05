package p006io.realm;

import com.safonov.speedreading.training.fragment.flashword.repository.entity.FlashWordsConfig;

/* renamed from: io.realm.FlashWordResultRealmProxyInterface */
public interface FlashWordResultRealmProxyInterface {
    FlashWordsConfig realmGet$config();

    int realmGet$id();

    long realmGet$unixTime();

    void realmSet$config(FlashWordsConfig flashWordsConfig);

    void realmSet$id(int i);

    void realmSet$unixTime(long j);
}
