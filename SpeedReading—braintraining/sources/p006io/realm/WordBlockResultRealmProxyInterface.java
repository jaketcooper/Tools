package p006io.realm;

import com.safonov.speedreading.training.fragment.wordsblock.repository.entity.WordBlockConfig;

/* renamed from: io.realm.WordBlockResultRealmProxyInterface */
public interface WordBlockResultRealmProxyInterface {
    WordBlockConfig realmGet$config();

    int realmGet$id();

    long realmGet$unixTime();

    void realmSet$config(WordBlockConfig wordBlockConfig);

    void realmSet$id(int i);

    void realmSet$unixTime(long j);
}
