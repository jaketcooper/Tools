package com.safonov.speedreading.training.fragment.wordpairs.repository;

import android.support.annotation.NonNull;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.RealmUtil;
import com.safonov.speedreading.training.fragment.wordpairs.repository.IWordPairsRepository;
import com.safonov.speedreading.training.fragment.wordpairs.repository.entity.WordPairsConfig;
import com.safonov.speedreading.training.fragment.wordpairs.repository.entity.WordPairsResult;
import java.util.ArrayList;
import java.util.List;
import p006io.realm.Realm;
import p006io.realm.RealmResults;
import p006io.realm.Sort;

public class WordPairsRealmUtil extends RealmUtil implements IWordPairsRepository {
    public WordPairsRealmUtil(@NonNull Realm realm) {
        super(realm);
    }

    public List<WordPairsResult> getResultList(int wordPairsConfigId) {
        return this.realm.where(WordPairsResult.class).equalTo("config.id", Integer.valueOf(wordPairsConfigId)).findAll();
    }

    public WordPairsResult getResult(int id) {
        return (WordPairsResult) this.realm.where(WordPairsResult.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public WordPairsResult getBestResult(int wordPairsConfigId) {
        return (WordPairsResult) this.realm.where(WordPairsResult.class).equalTo("config.id", Integer.valueOf(wordPairsConfigId)).findAll().sort("score", Sort.DESCENDING).where().findFirst();
    }

    public WordPairsConfig getConfig(int id) {
        return (WordPairsConfig) this.realm.where(WordPairsConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public List<WordPairsConfig> getConfigList() {
        return this.realm.where(WordPairsConfig.class).findAll();
    }

    public void addResult(@NonNull final WordPairsResult result, final int configId, final IWordPairsRepository.OnSingleTransactionCallback callback) {
        final int nextId = getNextId(WordPairsResult.class);
        this.realm.executeTransactionAsync((Realm.Transaction) new Realm.Transaction() {
            public void execute(Realm realm) {
                result.setId(nextId);
                result.setConfig((WordPairsConfig) realm.where(WordPairsConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst());
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

    public void addOrFindConfig(@NonNull final WordPairsConfig config, final IWordPairsRepository.OnSingleTransactionCallback callback) {
        RealmResults<E> findAll = this.realm.where(WordPairsConfig.class).equalTo("rowCount", Integer.valueOf(config.getRowCount())).findAll().where().equalTo("columnCount", Integer.valueOf(config.getColumnCount())).findAll().where().equalTo("trainingDuration", Integer.valueOf(config.getTrainingDuration())).findAll().where().equalTo(WordPairsConfig.FIELD_DIFFERENT_WORD_PAIRS_COUNT, Integer.valueOf(config.getDifferentWordPairsCount())).findAll();
        if (!findAll.isEmpty()) {
            callback.onTransactionCompleted(((WordPairsConfig) findAll.first()).getId());
            return;
        }
        final int nextId = getNextId(WordPairsConfig.class);
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

    public void addOrFindConfigs(@NonNull WordPairsConfig[] configs, final IWordPairsRepository.OnMultiTransactionCallback callback) {
        int nextId = getNextId(WordPairsConfig.class);
        final int[] configIds = new int[configs.length];
        final List<WordPairsConfig> haveToSaveConfigList = new ArrayList<>(configs.length);
        for (int i = 0; i < configs.length; i++) {
            WordPairsConfig config = configs[i];
            RealmResults<E> findAll = this.realm.where(WordPairsConfig.class).equalTo("rowCount", Integer.valueOf(config.getRowCount())).findAll().where().equalTo("columnCount", Integer.valueOf(config.getColumnCount())).findAll().where().equalTo("trainingDuration", Integer.valueOf(config.getTrainingDuration())).findAll().where().equalTo(WordPairsConfig.FIELD_DIFFERENT_WORD_PAIRS_COUNT, Integer.valueOf(config.getDifferentWordPairsCount())).findAll();
            if (!findAll.isEmpty()) {
                configIds[i] = ((WordPairsConfig) findAll.first()).getId();
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
