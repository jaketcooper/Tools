package com.safonov.speedreading.training.fragment.schultetable.repository;

import android.support.annotation.NonNull;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.RealmUtil;
import com.safonov.speedreading.training.fragment.schultetable.repository.ISchulteTableRepository;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableConfig;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableResult;
import java.util.ArrayList;
import java.util.List;
import p006io.realm.Realm;
import p006io.realm.RealmResults;
import p006io.realm.Sort;

public class SchulteTableRealmUtil extends RealmUtil implements ISchulteTableRepository {
    public SchulteTableRealmUtil(@NonNull Realm realm) {
        super(realm);
    }

    public List<SchulteTableResult> getResultList(int schulteTableConfigId) {
        return this.realm.where(SchulteTableResult.class).equalTo("config.id", Integer.valueOf(schulteTableConfigId)).findAll();
    }

    public SchulteTableResult getResult(int id) {
        return (SchulteTableResult) this.realm.where(SchulteTableResult.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public SchulteTableResult getBestResult(int schulteTableConfigId) {
        return (SchulteTableResult) this.realm.where(SchulteTableResult.class).equalTo("config.id", Integer.valueOf(schulteTableConfigId)).findAll().sort(SchulteTableResult.FIELD_TIME, Sort.ASCENDING).where().findFirst();
    }

    public SchulteTableConfig getConfig(int id) {
        return (SchulteTableConfig) this.realm.where(SchulteTableConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public List<SchulteTableConfig> getConfigList() {
        return this.realm.where(SchulteTableConfig.class).findAll();
    }

    public void addResult(@NonNull final SchulteTableResult result, final int configId, final ISchulteTableRepository.OnSingleTransactionCallback callback) {
        final int nextId = getNextId(SchulteTableResult.class);
        this.realm.executeTransactionAsync((Realm.Transaction) new Realm.Transaction() {
            public void execute(Realm realm) {
                result.setId(nextId);
                result.setConfig((SchulteTableConfig) realm.where(SchulteTableConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst());
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

    public void addOrFindConfig(@NonNull final SchulteTableConfig config, final ISchulteTableRepository.OnSingleTransactionCallback callback) {
        RealmResults<E> findAll = this.realm.where(SchulteTableConfig.class).equalTo("rowCount", Integer.valueOf(config.getRowCount())).findAll().where().equalTo("columnCount", Integer.valueOf(config.getColumnCount())).findAll().where().equalTo(SchulteTableConfig.FIELD_FULLSCREEN, Boolean.valueOf(config.isFullscreen())).findAll();
        if (!findAll.isEmpty()) {
            callback.onTransactionCompleted(((SchulteTableConfig) findAll.first()).getId());
            return;
        }
        final int nextId = getNextId(SchulteTableConfig.class);
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

    public void addOrFindConfigs(@NonNull SchulteTableConfig[] configs, final ISchulteTableRepository.OnMultiTransactionCallback callback) {
        int nextId = getNextId(SchulteTableConfig.class);
        final int[] configIds = new int[configs.length];
        final List<SchulteTableConfig> haveToSaveConfigList = new ArrayList<>(configs.length);
        for (int i = 0; i < configs.length; i++) {
            SchulteTableConfig config = configs[i];
            RealmResults<E> findAll = this.realm.where(SchulteTableConfig.class).equalTo("rowCount", Integer.valueOf(config.getRowCount())).findAll().where().equalTo("columnCount", Integer.valueOf(config.getColumnCount())).findAll().where().equalTo(SchulteTableConfig.FIELD_FULLSCREEN, Boolean.valueOf(config.isFullscreen())).findAll();
            if (!findAll.isEmpty()) {
                configIds[i] = ((SchulteTableConfig) findAll.first()).getId();
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
