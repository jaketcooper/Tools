package com.safonov.speedreading.training.fragment.remembernumber.repository;

import android.support.annotation.NonNull;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.RealmUtil;
import com.safonov.speedreading.training.fragment.remembernumber.repository.IRememberNumberRepository;
import com.safonov.speedreading.training.fragment.remembernumber.repository.entity.RememberNumberConfig;
import com.safonov.speedreading.training.fragment.remembernumber.repository.entity.RememberNumberResult;
import java.util.ArrayList;
import java.util.List;
import p006io.realm.Realm;
import p006io.realm.RealmResults;
import p006io.realm.Sort;

public class RememberNumberRealmUtil extends RealmUtil implements IRememberNumberRepository {
    public RememberNumberRealmUtil(@NonNull Realm realm) {
        super(realm);
    }

    public List<RememberNumberResult> getResultList(int configId) {
        return this.realm.where(RememberNumberResult.class).equalTo("config.id", Integer.valueOf(configId)).findAll();
    }

    public RememberNumberResult getResult(int id) {
        return (RememberNumberResult) this.realm.where(RememberNumberResult.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public RememberNumberResult getBestResult(int configId) {
        return (RememberNumberResult) this.realm.where(RememberNumberResult.class).equalTo("config.id", Integer.valueOf(configId)).findAll().sort("score", Sort.DESCENDING).where().findFirst();
    }

    public RememberNumberConfig getConfig(int id) {
        return (RememberNumberConfig) this.realm.where(RememberNumberConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public List<RememberNumberConfig> getConfigList() {
        return this.realm.where(RememberNumberConfig.class).findAll();
    }

    public void addResult(@NonNull final RememberNumberResult result, final int configId, final IRememberNumberRepository.OnSingleTransactionCallback callback) {
        final int nextId = getNextId(RememberNumberResult.class);
        this.realm.executeTransactionAsync((Realm.Transaction) new Realm.Transaction() {
            public void execute(Realm realm) {
                result.setId(nextId);
                result.setConfig((RememberNumberConfig) realm.where(RememberNumberConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst());
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
                RememberNumberConfig config = (RememberNumberConfig) realm.where(RememberNumberConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst();
                if (config != null) {
                    config.setComplexity(complexity);
                }
            }
        });
    }

    public void addOrFindConfig(@NonNull final RememberNumberConfig config, final IRememberNumberRepository.OnSingleTransactionCallback callback) {
        RealmResults<E> findAll = this.realm.where(RememberNumberConfig.class).equalTo("trainingShowCount", Integer.valueOf(config.getTrainingShowCount())).findAll().where().equalTo(RememberNumberConfig.FIELD_MIN_COMPLEXITY, Integer.valueOf(config.getMinComplexity())).findAll().where().equalTo(RememberNumberConfig.FIELD_MAX_COMPLEXITY, Integer.valueOf(config.getMaxComplexity())).findAll().where().equalTo(RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_UP, Integer.valueOf(config.getAnswersToComplexityUp())).findAll().where().equalTo(RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_DOWN, Integer.valueOf(config.getAnswersToComplexityDown())).findAll();
        if (!findAll.isEmpty()) {
            callback.onTransactionCompleted(((RememberNumberConfig) findAll.first()).getId());
            return;
        }
        final int nextId = getNextId(RememberNumberConfig.class);
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

    public void addOrFindConfigs(@NonNull RememberNumberConfig[] configs, final IRememberNumberRepository.OnMultiTransactionCallback callback) {
        int nextId = getNextId(RememberNumberConfig.class);
        final int[] configIds = new int[configs.length];
        final List<RememberNumberConfig> haveToSaveConfigList = new ArrayList<>(configs.length);
        for (int i = 0; i < configs.length; i++) {
            RememberNumberConfig config = configs[i];
            RealmResults<E> findAll = this.realm.where(RememberNumberConfig.class).equalTo("trainingShowCount", Integer.valueOf(config.getTrainingShowCount())).findAll().where().equalTo(RememberNumberConfig.FIELD_MIN_COMPLEXITY, Integer.valueOf(config.getMinComplexity())).findAll().where().equalTo(RememberNumberConfig.FIELD_MAX_COMPLEXITY, Integer.valueOf(config.getMaxComplexity())).findAll().where().equalTo(RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_UP, Integer.valueOf(config.getAnswersToComplexityUp())).findAll().where().equalTo(RememberNumberConfig.FIELD_ANSWERS_TO_COMPLEXITY_DOWN, Integer.valueOf(config.getAnswersToComplexityDown())).findAll();
            if (!findAll.isEmpty()) {
                configIds[i] = ((RememberNumberConfig) findAll.first()).getId();
            } else {
                config.setId(nextId);
                haveToSaveConfigList.add(config);
                configIds[i] = nextId;
                nextId++;
            }
        }
        if (!haveToSaveConfigList.isEmpty()) {
            this.realm.executeTransactionAsync((Realm.Transaction) new Realm.Transaction() {
                public void execute(Realm realm) {
                    realm.copyToRealm(haveToSaveConfigList);
                }
            }, (Realm.Transaction.OnSuccess) new Realm.Transaction.OnSuccess() {
                public void onSuccess() {
                    if (callback != null) {
                        callback.onTransactionCompleted(configIds);
                    }
                }
            });
        } else if (callback != null) {
            callback.onTransactionCompleted(configIds);
        }
    }
}
