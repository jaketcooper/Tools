package com.safonov.speedreading.training.fragment.evennumbers.repository;

import android.support.annotation.NonNull;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.RealmUtil;
import com.safonov.speedreading.training.fragment.evennumbers.repository.IEvenNumberRepository;
import com.safonov.speedreading.training.fragment.evennumbers.repository.entity.EvenNumbersConfig;
import com.safonov.speedreading.training.fragment.evennumbers.repository.entity.EvenNumbersResult;
import java.util.ArrayList;
import java.util.List;
import p006io.realm.Realm;
import p006io.realm.RealmResults;
import p006io.realm.Sort;

public class EvenNumbersRealmUtil extends RealmUtil implements IEvenNumberRepository {
    public EvenNumbersRealmUtil(@NonNull Realm realm) {
        super(realm);
    }

    public List<EvenNumbersResult> getResultList(int evenNumbersConfigId) {
        return this.realm.where(EvenNumbersResult.class).equalTo("config.id", Integer.valueOf(evenNumbersConfigId)).findAll();
    }

    public EvenNumbersResult getResult(int id) {
        return (EvenNumbersResult) this.realm.where(EvenNumbersResult.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public EvenNumbersResult getBestResult(int evenNumbersConfigId) {
        return (EvenNumbersResult) this.realm.where(EvenNumbersResult.class).equalTo("config.id", Integer.valueOf(evenNumbersConfigId)).findAll().sort("score", Sort.DESCENDING).where().findFirst();
    }

    public EvenNumbersConfig getConfig(int id) {
        return (EvenNumbersConfig) this.realm.where(EvenNumbersConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public List<EvenNumbersConfig> getConfigList() {
        return this.realm.where(EvenNumbersConfig.class).findAll();
    }

    public void addResult(@NonNull final EvenNumbersResult result, final int configId, final IEvenNumberRepository.OnSingleTransactionCallback callback) {
        final int nextId = getNextId(EvenNumbersResult.class);
        this.realm.executeTransactionAsync((Realm.Transaction) new Realm.Transaction() {
            public void execute(Realm realm) {
                result.setId(nextId);
                result.setConfig((EvenNumbersConfig) realm.where(EvenNumbersConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst());
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

    public void addOrFindConfig(@NonNull final EvenNumbersConfig config, final IEvenNumberRepository.OnSingleTransactionCallback callback) {
        RealmResults<E> findAll = this.realm.where(EvenNumbersConfig.class).equalTo("rowCount", Integer.valueOf(config.getRowCount())).findAll().where().equalTo("columnCount", Integer.valueOf(config.getColumnCount())).findAll().where().equalTo(EvenNumbersConfig.FIELD_DIGITS_PER_NUMBER, Integer.valueOf(config.getDigitsPerNumber())).findAll().where().equalTo(EvenNumbersConfig.FIELD_EVEN_NUMBERS_COUNT, Integer.valueOf(config.getEvenNumberCount())).findAll().where().equalTo("trainingDuration", Integer.valueOf(config.getTrainingDuration())).findAll();
        if (!findAll.isEmpty()) {
            callback.onTransactionCompleted(((EvenNumbersConfig) findAll.first()).getId());
            return;
        }
        final int nextId = getNextId(EvenNumbersConfig.class);
        this.realm.executeTransactionAsync((Realm.Transaction) new Realm.Transaction() {
            public void execute(Realm realm) {
                config.setId(nextId);
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

    public void addOrFindConfigs(@NonNull EvenNumbersConfig[] configs, final IEvenNumberRepository.OnMultiTransactionCallback callback) {
        int nextId = getNextId(EvenNumbersConfig.class);
        final int[] configIds = new int[configs.length];
        final List<EvenNumbersConfig> haveToSaveConfigList = new ArrayList<>(configs.length);
        for (int i = 0; i < configs.length; i++) {
            EvenNumbersConfig config = configs[i];
            RealmResults<E> findAll = this.realm.where(EvenNumbersConfig.class).equalTo("rowCount", Integer.valueOf(config.getRowCount())).findAll().where().equalTo("columnCount", Integer.valueOf(config.getColumnCount())).findAll().where().equalTo(EvenNumbersConfig.FIELD_DIGITS_PER_NUMBER, Integer.valueOf(config.getDigitsPerNumber())).findAll().where().equalTo(EvenNumbersConfig.FIELD_EVEN_NUMBERS_COUNT, Integer.valueOf(config.getEvenNumberCount())).findAll().where().equalTo("trainingDuration", Integer.valueOf(config.getTrainingDuration())).findAll();
            if (!findAll.isEmpty()) {
                configIds[i] = ((EvenNumbersConfig) findAll.first()).getId();
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
