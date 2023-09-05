package com.safonov.speedreading.training.fragment.cuptimer.repository;

import android.support.annotation.NonNull;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.RealmUtil;
import com.safonov.speedreading.training.fragment.cuptimer.repository.ICupTimerRepository;
import com.safonov.speedreading.training.fragment.cuptimer.repository.entity.CupTimerConfig;
import com.safonov.speedreading.training.fragment.cuptimer.repository.entity.CupTimerResult;
import java.util.ArrayList;
import java.util.List;
import p006io.realm.Realm;
import p006io.realm.RealmResults;

public class CupTimerRealmUtil extends RealmUtil implements ICupTimerRepository {
    public CupTimerRealmUtil(@NonNull Realm realm) {
        super(realm);
    }

    public CupTimerResult getResult(int id) {
        return (CupTimerResult) this.realm.where(CupTimerResult.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public List<CupTimerResult> getResultList() {
        return this.realm.where(CupTimerResult.class).findAll();
    }

    public CupTimerConfig getConfig(int id) {
        return (CupTimerConfig) this.realm.where(CupTimerConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public List<CupTimerConfig> getConfigList() {
        return this.realm.where(CupTimerConfig.class).findAll();
    }

    public void addResult(@NonNull final CupTimerResult result, final int configId, final ICupTimerRepository.OnSingleTransactionCallback callback) {
        final int nextId = getNextId(CupTimerResult.class);
        this.realm.executeTransactionAsync((Realm.Transaction) new Realm.Transaction() {
            public void execute(Realm realm) {
                result.setId(nextId);
                result.setConfig((CupTimerConfig) realm.where(CupTimerConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst());
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

    public void addOrFindConfig(@NonNull final CupTimerConfig config, final ICupTimerRepository.OnSingleTransactionCallback callback) {
        RealmResults<E> findAll = this.realm.where(CupTimerConfig.class).equalTo("duration", Long.valueOf(config.getDuration())).findAll().where().equalTo("type", Integer.valueOf(config.getType())).findAll();
        if (!findAll.isEmpty()) {
            callback.onTransactionCompleted(((CupTimerConfig) findAll.first()).getId());
            return;
        }
        final int nextId = getNextId(CupTimerConfig.class);
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

    public void addOrFindConfigs(@NonNull CupTimerConfig[] configs, final ICupTimerRepository.OnMultiTransactionCallback callback) {
        int nextId = getNextId(CupTimerConfig.class);
        final int[] configIds = new int[configs.length];
        final List<CupTimerConfig> haveToSaveConfigList = new ArrayList<>(configs.length);
        for (int i = 0; i < configs.length; i++) {
            CupTimerConfig config = configs[i];
            RealmResults<E> findAll = this.realm.where(CupTimerConfig.class).equalTo("duration", Long.valueOf(config.getDuration())).findAll().where().equalTo("type", Integer.valueOf(config.getType())).findAll();
            if (!findAll.isEmpty()) {
                configIds[i] = ((CupTimerConfig) findAll.first()).getId();
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
