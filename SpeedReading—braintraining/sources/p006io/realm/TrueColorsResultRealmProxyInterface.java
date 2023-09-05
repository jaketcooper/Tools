package p006io.realm;

import com.safonov.speedreading.training.fragment.truecolors.repository.entity.TrueColorsConfig;

/* renamed from: io.realm.TrueColorsResultRealmProxyInterface */
public interface TrueColorsResultRealmProxyInterface {
    TrueColorsConfig realmGet$config();

    int realmGet$id();

    int realmGet$score();

    void realmSet$config(TrueColorsConfig trueColorsConfig);

    void realmSet$id(int i);

    void realmSet$score(int i);
}
