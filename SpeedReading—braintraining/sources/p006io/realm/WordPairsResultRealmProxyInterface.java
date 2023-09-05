package p006io.realm;

import com.safonov.speedreading.training.fragment.wordpairs.repository.entity.WordPairsConfig;

/* renamed from: io.realm.WordPairsResultRealmProxyInterface */
public interface WordPairsResultRealmProxyInterface {
    WordPairsConfig realmGet$config();

    int realmGet$id();

    int realmGet$score();

    long realmGet$unixTime();

    void realmSet$config(WordPairsConfig wordPairsConfig);

    void realmSet$id(int i);

    void realmSet$score(int i);

    void realmSet$unixTime(long j);
}
