package com.safonov.speedreading.training.fragment.wordscolumns.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.RealmUtil;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.IWordsColumnsRepository;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.entity.WordsColumnsConfig;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.entity.WordsColumnsResult;
import java.util.ArrayList;
import java.util.List;
import p006io.realm.Realm;
import p006io.realm.RealmResults;

public class WordsColumnsRealmUtil extends RealmUtil implements IWordsColumnsRepository {
    public WordsColumnsRealmUtil(@NonNull Realm realm) {
        super(realm);
    }

    @Nullable
    public WordsColumnsResult getResult(int id) {
        return (WordsColumnsResult) this.realm.where(WordsColumnsResult.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public List<WordsColumnsResult> getResultList() {
        return this.realm.where(WordsColumnsResult.class).findAll();
    }

    @Nullable
    public WordsColumnsConfig getConfig(int id) {
        return (WordsColumnsConfig) this.realm.where(WordsColumnsConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public List<WordsColumnsConfig> getConfigList() {
        return this.realm.where(WordsColumnsConfig.class).findAll();
    }

    public void updateConfigSpeed(final int configId, final int speed) {
        this.realm.executeTransactionAsync(new Realm.Transaction() {
            public void execute(Realm realm) {
                WordsColumnsConfig config = (WordsColumnsConfig) realm.where(WordsColumnsConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst();
                if (config != null) {
                    config.setSpeed(speed);
                }
            }
        });
    }

    public void addResult(@NonNull final WordsColumnsResult result, final int configId, final IWordsColumnsRepository.OnSingleTransactionCallback callback) {
        final int nextId = getNextId(WordsColumnsResult.class);
        this.realm.executeTransactionAsync((Realm.Transaction) new Realm.Transaction() {
            public void execute(Realm realm) {
                result.setId(nextId);
                result.setConfig((WordsColumnsConfig) realm.where(WordsColumnsConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst());
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

    public void addOrFindConfig(@NonNull final WordsColumnsConfig config, final IWordsColumnsRepository.OnSingleTransactionCallback callback) {
        RealmResults<E> findAll = this.realm.where(WordsColumnsConfig.class).equalTo("rowCount", Integer.valueOf(config.getRowCount())).findAll().where().equalTo("columnCount", Integer.valueOf(config.getColumnCount())).findAll().where().equalTo(WordsColumnsConfig.FIELD_WORDS_PER_ITEM, Integer.valueOf(config.getWordsPerItem())).findAll().where().equalTo("trainingDuration", Long.valueOf(config.getTrainingDuration())).findAll();
        if (!findAll.isEmpty()) {
            callback.onTransactionCompleted(((WordsColumnsConfig) findAll.first()).getId());
            return;
        }
        final int nextId = getNextId(WordsColumnsConfig.class);
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

    public void addOrFindConfigs(@NonNull WordsColumnsConfig[] configs, final IWordsColumnsRepository.OnMultiTransactionCallback callback) {
        int nextId = getNextId(WordsColumnsConfig.class);
        final int[] configIds = new int[configs.length];
        final List<WordsColumnsConfig> haveToSaveConfigList = new ArrayList<>(configs.length);
        for (int i = 0; i < configs.length; i++) {
            WordsColumnsConfig config = configs[i];
            RealmResults<E> findAll = this.realm.where(WordsColumnsConfig.class).equalTo("rowCount", Integer.valueOf(config.getRowCount())).findAll().where().equalTo("columnCount", Integer.valueOf(config.getColumnCount())).findAll().where().equalTo(WordsColumnsConfig.FIELD_WORDS_PER_ITEM, Integer.valueOf(config.getWordsPerItem())).findAll().where().equalTo("trainingDuration", Long.valueOf(config.getTrainingDuration())).findAll();
            if (!findAll.isEmpty()) {
                configIds[i] = ((WordsColumnsConfig) findAll.first()).getId();
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
