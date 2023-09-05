package com.safonov.speedreading.training.fragment.lineofsight.repository;

import android.support.annotation.NonNull;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.RealmUtil;
import com.safonov.speedreading.training.fragment.lineofsight.repository.ILineOfSightRepository;
import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightConfig;
import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightResult;
import java.util.ArrayList;
import java.util.List;
import p006io.realm.Realm;
import p006io.realm.RealmResults;

public class LineOfSightRealmUtil extends RealmUtil implements ILineOfSightRepository {
    public LineOfSightRealmUtil(@NonNull Realm realm) {
        super(realm);
    }

    public List<LineOfSightResult> getResultList(int lineOfSightConfigId) {
        return this.realm.where(LineOfSightResult.class).equalTo("config.id", Integer.valueOf(lineOfSightConfigId)).findAll();
    }

    public LineOfSightResult getResult(int lineOfSightResultId) {
        return (LineOfSightResult) this.realm.where(LineOfSightResult.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(lineOfSightResultId)).findFirst();
    }

    public LineOfSightConfig getConfig(int lineOfSightConfigId) {
        return (LineOfSightConfig) this.realm.where(LineOfSightConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(lineOfSightConfigId)).findFirst();
    }

    public List<LineOfSightConfig> getConfigList() {
        return this.realm.where(LineOfSightConfig.class).findAll();
    }

    public void addResult(@NonNull final LineOfSightResult result, final int configId, final ILineOfSightRepository.OnSingleTransactionCallback callback) {
        final int nextId = getNextId(LineOfSightResult.class);
        this.realm.executeTransactionAsync((Realm.Transaction) new Realm.Transaction() {
            public void execute(Realm realm) {
                result.setId(nextId);
                result.setConfig((LineOfSightConfig) realm.where(LineOfSightConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst());
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

    public void addOrFindConfig(@NonNull final LineOfSightConfig config, final ILineOfSightRepository.OnSingleTransactionCallback callback) {
        RealmResults<E> findAll = this.realm.where(LineOfSightConfig.class).equalTo("rowCount", Integer.valueOf(config.getRowCount())).findAll().where().equalTo("columnCount", Integer.valueOf(config.getColumnCount())).findAll().where().equalTo(LineOfSightConfig.FIELD_TYPE, Integer.valueOf(config.getFieldType())).findAll().where().equalTo(LineOfSightConfig.FIELD_SHOW_COUNT, Integer.valueOf(config.getShowCount())).findAll().where().equalTo(LineOfSightConfig.FIELD_SHOW_DELAY, Long.valueOf(config.getShowDelay())).findAll().where().equalTo(LineOfSightConfig.FIELD_MISTAKE_PROBABILITY, Integer.valueOf(config.getMistakeProbability())).findAll();
        if (!findAll.isEmpty()) {
            callback.onTransactionCompleted(((LineOfSightConfig) findAll.first()).getId());
            return;
        }
        final int nextId = getNextId(LineOfSightConfig.class);
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

    public void addOrFindConfigs(@NonNull LineOfSightConfig[] configs, final ILineOfSightRepository.OnMultiTransactionCallback callback) {
        int nextId = getNextId(LineOfSightConfig.class);
        final int[] configIds = new int[configs.length];
        final List<LineOfSightConfig> haveToSaveConfigList = new ArrayList<>(configs.length);
        for (int i = 0; i < configs.length; i++) {
            LineOfSightConfig config = configs[i];
            RealmResults<E> findAll = this.realm.where(LineOfSightConfig.class).equalTo("rowCount", Integer.valueOf(config.getRowCount())).findAll().where().equalTo("columnCount", Integer.valueOf(config.getColumnCount())).findAll().where().equalTo(LineOfSightConfig.FIELD_TYPE, Integer.valueOf(config.getFieldType())).findAll().where().equalTo(LineOfSightConfig.FIELD_SHOW_COUNT, Integer.valueOf(config.getShowCount())).findAll().where().equalTo(LineOfSightConfig.FIELD_SHOW_DELAY, Long.valueOf(config.getShowDelay())).findAll().where().equalTo(LineOfSightConfig.FIELD_MISTAKE_PROBABILITY, Integer.valueOf(config.getMistakeProbability())).findAll();
            if (!findAll.isEmpty()) {
                configIds[i] = ((LineOfSightConfig) findAll.first()).getId();
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
