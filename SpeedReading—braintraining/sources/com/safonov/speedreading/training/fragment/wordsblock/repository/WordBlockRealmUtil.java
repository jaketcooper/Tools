package com.safonov.speedreading.training.fragment.wordsblock.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.RealmUtil;
import com.safonov.speedreading.training.fragment.wordsblock.repository.IWordBlockRepository;
import com.safonov.speedreading.training.fragment.wordsblock.repository.entity.WordBlockConfig;
import com.safonov.speedreading.training.fragment.wordsblock.repository.entity.WordBlockResult;
import java.util.ArrayList;
import java.util.List;
import p006io.realm.Realm;
import p006io.realm.RealmResults;

public class WordBlockRealmUtil extends RealmUtil implements IWordBlockRepository {
    public WordBlockRealmUtil(@NonNull Realm realm) {
        super(realm);
    }

    @Nullable
    public WordBlockResult getResult(int id) {
        return (WordBlockResult) this.realm.where(WordBlockResult.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public List<WordBlockResult> getResultList() {
        return this.realm.where(WordBlockResult.class).findAll();
    }

    @Nullable
    public WordBlockConfig getConfig(int id) {
        return (WordBlockConfig) this.realm.where(WordBlockConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public List<WordBlockConfig> getConfigList() {
        return this.realm.where(WordBlockConfig.class).findAll();
    }

    public void updateConfig(final int configId, final int speed, final int wordCount) {
        this.realm.executeTransactionAsync(new Realm.Transaction() {
            public void execute(Realm realm) {
                WordBlockConfig config = (WordBlockConfig) realm.where(WordBlockConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst();
                if (config != null) {
                    config.setSpeed(speed);
                    config.setWordCount(wordCount);
                }
            }
        });
    }

    public void addResult(@NonNull final WordBlockResult result, final int configId, final IWordBlockRepository.OnSingleTransactionCallback callback) {
        final int nextId = getNextId(WordBlockResult.class);
        this.realm.executeTransactionAsync((Realm.Transaction) new Realm.Transaction() {
            public void execute(Realm realm) {
                result.setId(nextId);
                result.setConfig((WordBlockConfig) realm.where(WordBlockConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst());
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

    public void addOrFindConfig(@NonNull final WordBlockConfig config, final IWordBlockRepository.OnSingleTransactionCallback callback) {
        RealmResults<E> findAll = this.realm.where(WordBlockConfig.class).equalTo("trainingDuration", Long.valueOf(config.getTrainingDuration())).findAll();
        if (!findAll.isEmpty()) {
            callback.onTransactionCompleted(((WordBlockConfig) findAll.first()).getId());
            return;
        }
        final int nextId = getNextId(WordBlockConfig.class);
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

    public void addOrFindConfigs(@NonNull WordBlockConfig[] configs, final IWordBlockRepository.OnMultiTransactionCallback callback) {
        int nextId = getNextId(WordBlockConfig.class);
        final int[] configIds = new int[configs.length];
        final List<WordBlockConfig> haveToSaveConfigList = new ArrayList<>(configs.length);
        for (int i = 0; i < configs.length; i++) {
            WordBlockConfig config = configs[i];
            RealmResults<E> findAll = this.realm.where(WordBlockConfig.class).equalTo("trainingDuration", Long.valueOf(config.getTrainingDuration())).findAll();
            if (!findAll.isEmpty()) {
                configIds[i] = ((WordBlockConfig) findAll.first()).getId();
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
