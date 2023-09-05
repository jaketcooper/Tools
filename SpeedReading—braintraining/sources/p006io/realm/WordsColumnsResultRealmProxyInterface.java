package p006io.realm;

import com.safonov.speedreading.training.fragment.wordscolumns.repository.entity.WordsColumnsConfig;

/* renamed from: io.realm.WordsColumnsResultRealmProxyInterface */
public interface WordsColumnsResultRealmProxyInterface {
    WordsColumnsConfig realmGet$config();

    int realmGet$id();

    long realmGet$unixTime();

    void realmSet$config(WordsColumnsConfig wordsColumnsConfig);

    void realmSet$id(int i);

    void realmSet$unixTime(long j);
}
