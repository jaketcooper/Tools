package p006io.realm;

import com.safonov.speedreading.training.fragment.math.repository.entity.MathConfig;

/* renamed from: io.realm.MathResultRealmProxyInterface */
public interface MathResultRealmProxyInterface {
    MathConfig realmGet$config();

    int realmGet$id();

    int realmGet$score();

    void realmSet$config(MathConfig mathConfig);

    void realmSet$id(int i);

    void realmSet$score(int i);
}
