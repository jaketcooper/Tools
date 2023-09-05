package p006io.realm;

import com.safonov.speedreading.training.fragment.concentration.repository.entity.ConcentrationConfig;

/* renamed from: io.realm.ConcentrationResultRealmProxyInterface */
public interface ConcentrationResultRealmProxyInterface {
    ConcentrationConfig realmGet$config();

    int realmGet$id();

    int realmGet$score();

    void realmSet$config(ConcentrationConfig concentrationConfig);

    void realmSet$id(int i);

    void realmSet$score(int i);
}
