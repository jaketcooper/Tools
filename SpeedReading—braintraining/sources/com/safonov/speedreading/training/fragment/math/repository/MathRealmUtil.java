package com.safonov.speedreading.training.fragment.math.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.RealmUtil;
import com.safonov.speedreading.training.fragment.math.repository.IMathRepository;
import com.safonov.speedreading.training.fragment.math.repository.entity.MathConfig;
import com.safonov.speedreading.training.fragment.math.repository.entity.MathResult;
import java.util.List;
import p006io.realm.Realm;
import p006io.realm.RealmResults;
import p006io.realm.Sort;

public class MathRealmUtil extends RealmUtil implements IMathRepository {
    public MathRealmUtil(@NonNull Realm realm) {
        super(realm);
    }

    @Nullable
    public MathResult getResult(int id) {
        return (MathResult) this.realm.where(MathResult.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    @Nullable
    public MathResult getBestResult(int configId) {
        return (MathResult) this.realm.where(MathResult.class).equalTo("config.id", Integer.valueOf(configId)).findAll().sort("score", Sort.DESCENDING).where().findFirst();
    }

    public List<MathResult> getResultList(int configId) {
        return this.realm.where(MathResult.class).equalTo("config.id", Integer.valueOf(configId)).findAll();
    }

    @Nullable
    public MathConfig getConfig(int id) {
        return (MathConfig) this.realm.where(MathConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public List<MathConfig> getConfigList() {
        return this.realm.where(MathConfig.class).findAll();
    }

    public void addResult(@NonNull final MathResult result, final int configId, final IMathRepository.OnSingleTransactionCallback callback) {
        final int nextId = getNextId(MathResult.class);
        this.realm.executeTransactionAsync((Realm.Transaction) new Realm.Transaction() {
            public void execute(Realm realm) {
                result.setId(nextId);
                result.setConfig((MathConfig) realm.where(MathConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst());
                realm.copyToRealm(result);
            }
        }, (Realm.Transaction.OnSuccess) new Realm.Transaction.OnSuccess() {
            public void onSuccess() {
                if (callback != null) {
                    callback.onTransactionCompleted(nextId);
                }
            }
        });
    }

    public void updateConfigComplexity(final int configId, final int complexity) {
        this.realm.executeTransactionAsync(new Realm.Transaction() {
            public void execute(Realm realm) {
                MathConfig config = (MathConfig) realm.where(MathConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst();
                if (config != null) {
                    config.setComplexity(complexity);
                }
            }
        });
    }

    public void addOrFindConfig(@NonNull final MathConfig config, final IMathRepository.OnSingleTransactionCallback callback) {
        RealmResults<E> findAll = this.realm.where(MathConfig.class).equalTo("duration", Long.valueOf(config.getDuration())).findAll();
        if (!findAll.isEmpty()) {
            callback.onTransactionCompleted(((MathConfig) findAll.first()).getId());
            return;
        }
        final int nextId = getNextId(MathConfig.class);
        config.setId(nextId);
        this.realm.executeTransactionAsync((Realm.Transaction) new Realm.Transaction() {
            public void execute(Realm realm) {
                realm.copyToRealm(config);
            }
        }, (Realm.Transaction.OnSuccess) new Realm.Transaction.OnSuccess() {
            public void onSuccess() {
                if (callback != null) {
                    callback.onTransactionCompleted(nextId);
                }
            }
        });
    }

    public void addOrFindConfigs(@NonNull MathConfig[] configs, IMathRepository.OnMultiTransactionCallback callback) {
    }
}
