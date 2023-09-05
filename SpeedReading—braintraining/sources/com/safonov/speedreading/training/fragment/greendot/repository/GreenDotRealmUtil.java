package com.safonov.speedreading.training.fragment.greendot.repository;

import android.support.annotation.NonNull;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.RealmUtil;
import com.safonov.speedreading.training.fragment.greendot.repository.IGreenDotRepository;
import com.safonov.speedreading.training.fragment.greendot.repository.entity.GreenDotConfig;
import com.safonov.speedreading.training.fragment.greendot.repository.entity.GreenDotResult;
import java.util.ArrayList;
import java.util.List;
import p006io.realm.Realm;
import p006io.realm.RealmResults;

public class GreenDotRealmUtil extends RealmUtil implements IGreenDotRepository {
    public GreenDotRealmUtil(@NonNull Realm realm) {
        super(realm);
    }

    public GreenDotResult getResult(int id) {
        return (GreenDotResult) this.realm.where(GreenDotResult.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public List<GreenDotResult> getResultList() {
        return this.realm.where(GreenDotResult.class).findAll();
    }

    public GreenDotConfig getConfig(int id) {
        return (GreenDotConfig) this.realm.where(GreenDotConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public List<GreenDotConfig> getConfigList() {
        return this.realm.where(GreenDotConfig.class).findAll();
    }

    public void addResult(@NonNull final GreenDotResult result, final int configId, final IGreenDotRepository.OnSingleTransactionCallback callback) {
        final int nextId = getNextId(GreenDotResult.class);
        this.realm.executeTransactionAsync((Realm.Transaction) new Realm.Transaction() {
            public void execute(Realm realm) {
                result.setId(nextId);
                result.setConfig((GreenDotConfig) realm.where(GreenDotConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst());
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

    public void addOrFindConfig(@NonNull final GreenDotConfig config, final IGreenDotRepository.OnSingleTransactionCallback callback) {
        RealmResults<E> findAll = this.realm.where(GreenDotConfig.class).equalTo("duration", Long.valueOf(config.getDuration())).findAll();
        if (!findAll.isEmpty()) {
            callback.onTransactionCompleted(((GreenDotConfig) findAll.first()).getId());
            return;
        }
        final int nextId = getNextId(GreenDotConfig.class);
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

    public void addOrFindConfigs(@NonNull GreenDotConfig[] configs, final IGreenDotRepository.OnMultiTransactionCallback callback) {
        int nextId = getNextId(GreenDotConfig.class);
        final int[] configIds = new int[configs.length];
        final List<GreenDotConfig> haveToSaveConfigList = new ArrayList<>(configs.length);
        for (int i = 0; i < configs.length; i++) {
            GreenDotConfig config = configs[i];
            RealmResults<E> findAll = this.realm.where(GreenDotConfig.class).equalTo("duration", Long.valueOf(config.getDuration())).findAll();
            if (!findAll.isEmpty()) {
                configIds[i] = ((GreenDotConfig) findAll.first()).getId();
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
