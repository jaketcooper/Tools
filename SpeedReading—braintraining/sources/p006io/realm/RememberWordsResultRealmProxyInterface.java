package p006io.realm;

import com.safonov.speedreading.training.fragment.rememberwords.repository.entity.RememberWordsConfig;

/* renamed from: io.realm.RememberWordsResultRealmProxyInterface */
public interface RememberWordsResultRealmProxyInterface {
    RememberWordsConfig realmGet$config();

    int realmGet$id();

    int realmGet$score();

    void realmSet$config(RememberWordsConfig rememberWordsConfig);

    void realmSet$id(int i);

    void realmSet$score(int i);
}
