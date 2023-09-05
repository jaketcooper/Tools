package com.safonov.speedreading.training.fragment.flashword.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.RealmUtil;
import com.safonov.speedreading.training.fragment.flashword.repository.IFlashWordRepository;
import com.safonov.speedreading.training.fragment.flashword.repository.entity.FlashWordResult;
import com.safonov.speedreading.training.fragment.flashword.repository.entity.FlashWordsConfig;
import java.util.ArrayList;
import java.util.List;
import p006io.realm.Realm;
import p006io.realm.RealmResults;

public class FlashWordRealmUtil extends RealmUtil implements IFlashWordRepository {
    public FlashWordRealmUtil(@NonNull Realm realm) {
        super(realm);
    }

    @Nullable
    public FlashWordResult getResult(int id) {
        return (FlashWordResult) this.realm.where(FlashWordResult.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public List<FlashWordResult> getResultList() {
        return this.realm.where(FlashWordResult.class).findAll();
    }

    @Nullable
    public FlashWordsConfig getConfig(int id) {
        return (FlashWordsConfig) this.realm.where(FlashWordsConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public List<FlashWordsConfig> getConfigList() {
        return this.realm.where(FlashWordsConfig.class).findAll();
    }

    public void updateConfig(final int configId, final int speed) {
        this.realm.executeTransactionAsync(new Realm.Transaction() {
            public void execute(Realm realm) {
                FlashWordsConfig config = (FlashWordsConfig) realm.where(FlashWordsConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst();
                if (config != null) {
                    config.setSpeed(speed);
                }
            }
        });
    }

    public void addResult(@NonNull final FlashWordResult result, final int configId, final IFlashWordRepository.OnSingleTransactionCallback callback) {
        final int nextId = getNextId(FlashWordResult.class);
        this.realm.executeTransactionAsync((Realm.Transaction) new Realm.Transaction() {
            public void execute(Realm realm) {
                result.setId(nextId);
                result.setConfig((FlashWordsConfig) realm.where(FlashWordsConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst());
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

    public void addOrFindConfig(@NonNull final FlashWordsConfig config, final IFlashWordRepository.OnSingleTransactionCallback callback) {
        RealmResults<E> findAll = this.realm.where(FlashWordsConfig.class).equalTo("trainingDuration", Long.valueOf(config.getTrainingDuration())).equalTo(FlashWordsConfig.FIELD_BOARD_TYPE, Integer.valueOf(config.getBoarType())).findAll();
        if (!findAll.isEmpty()) {
            callback.onTransactionCompleted(((FlashWordsConfig) findAll.first()).getId());
            return;
        }
        final int nextId = getNextId(FlashWordsConfig.class);
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

    public void addOrFindConfigs(@NonNull FlashWordsConfig[] configs, final IFlashWordRepository.OnMultiTransactionCallback callback) {
        int nextId = getNextId(FlashWordsConfig.class);
        final int[] configIds = new int[configs.length];
        final List<FlashWordsConfig> haveToSaveConfigList = new ArrayList<>(configs.length);
        for (int i = 0; i < configs.length; i++) {
            FlashWordsConfig config = configs[i];
            RealmResults<E> findAll = this.realm.where(FlashWordsConfig.class).equalTo("trainingDuration", Long.valueOf(config.getTrainingDuration())).equalTo(FlashWordsConfig.FIELD_BOARD_TYPE, Integer.valueOf(config.getBoarType())).findAll();
            if (!findAll.isEmpty()) {
                configIds[i] = ((FlashWordsConfig) findAll.first()).getId();
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
