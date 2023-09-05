package com.safonov.speedreading.training.fragment.rememberwords.repository;

import android.support.annotation.NonNull;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.RealmUtil;
import com.safonov.speedreading.training.fragment.rememberwords.repository.IRememberWordsRepository;
import com.safonov.speedreading.training.fragment.rememberwords.repository.entity.RememberWordsConfig;
import com.safonov.speedreading.training.fragment.rememberwords.repository.entity.RememberWordsResult;
import java.util.ArrayList;
import java.util.List;
import p006io.realm.Realm;
import p006io.realm.RealmResults;
import p006io.realm.Sort;

public class RememberWordsRealmUtil extends RealmUtil implements IRememberWordsRepository {
    public RememberWordsRealmUtil(@NonNull Realm realm) {
        super(realm);
    }

    public List<RememberWordsResult> getResultList(int configId) {
        return this.realm.where(RememberWordsResult.class).equalTo("config.id", Integer.valueOf(configId)).findAll();
    }

    public RememberWordsResult getResult(int id) {
        return (RememberWordsResult) this.realm.where(RememberWordsResult.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public RememberWordsResult getBestResult(int configId) {
        return (RememberWordsResult) this.realm.where(RememberWordsResult.class).equalTo("config.id", Integer.valueOf(configId)).findAll().sort("score", Sort.DESCENDING).where().findFirst();
    }

    public RememberWordsConfig getConfig(int id) {
        return (RememberWordsConfig) this.realm.where(RememberWordsConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public List<RememberWordsConfig> getConfigList() {
        return this.realm.where(RememberWordsConfig.class).findAll();
    }

    public void updateConfigWordsCount(final int configId, final int wordsCount) {
        this.realm.executeTransactionAsync(new Realm.Transaction() {
            public void execute(Realm realm) {
                RememberWordsConfig config = (RememberWordsConfig) realm.where(RememberWordsConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst();
                if (config != null) {
                    config.setStartWordsCount(wordsCount);
                }
            }
        });
    }

    public void addResult(@NonNull final RememberWordsResult result, final int configId, final IRememberWordsRepository.OnSingleTransactionCallback callback) {
        final int nextId = getNextId(RememberWordsResult.class);
        this.realm.executeTransactionAsync((Realm.Transaction) new Realm.Transaction() {
            public void execute(Realm realm) {
                result.setId(nextId);
                result.setConfig((RememberWordsConfig) realm.where(RememberWordsConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst());
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

    public void addOrFindConfig(@NonNull final RememberWordsConfig config, final IRememberWordsRepository.OnSingleTransactionCallback callback) {
        RealmResults<E> findAll = this.realm.where(RememberWordsConfig.class).findAll();
        if (!findAll.isEmpty()) {
            callback.onTransactionCompleted(((RememberWordsConfig) findAll.first()).getId());
            return;
        }
        final int nextId = getNextId(RememberWordsConfig.class);
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

    public void addOrFindConfigs(@NonNull RememberWordsConfig[] configs, final IRememberWordsRepository.OnMultiTransactionCallback callback) {
        int nextId = getNextId(RememberWordsConfig.class);
        final int[] configIds = new int[configs.length];
        final List<RememberWordsConfig> haveToSaveConfigList = new ArrayList<>(configs.length);
        for (int i = 0; i < configs.length; i++) {
            RememberWordsConfig config = configs[i];
            RealmResults<E> findAll = this.realm.where(RememberWordsConfig.class).equalTo(RememberWordsConfig.FIELD_START_WORDS_COUNT, Integer.valueOf(config.getStartWordsCount())).findAll();
            if (!findAll.isEmpty()) {
                configIds[i] = ((RememberWordsConfig) findAll.first()).getId();
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
