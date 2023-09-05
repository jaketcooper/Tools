package com.safonov.speedreading.training.fragment.speedreading.repository;

import android.support.annotation.NonNull;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.RealmUtil;
import com.safonov.speedreading.training.fragment.speedreading.repository.ISpeedReadingRepository;
import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingConfig;
import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingResult;
import java.util.ArrayList;
import java.util.List;
import p006io.realm.Realm;
import p006io.realm.RealmResults;
import p006io.realm.Sort;

public class SpeedReadingRealmUtil extends RealmUtil implements ISpeedReadingRepository {
    public SpeedReadingRealmUtil(@NonNull Realm realm) {
        super(realm);
    }

    public List<SpeedReadingResult> getResultList(int configId) {
        return this.realm.where(SpeedReadingResult.class).equalTo("config.id", Integer.valueOf(configId)).findAll();
    }

    public SpeedReadingResult getResult(int id) {
        return (SpeedReadingResult) this.realm.where(SpeedReadingResult.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public SpeedReadingResult getBestResultByMaxSpeed(int configId) {
        return (SpeedReadingResult) this.realm.where(SpeedReadingResult.class).equalTo("config.id", Integer.valueOf(configId)).findAll().sort(SpeedReadingResult.FIELD_MAX_SPEED, Sort.DESCENDING).where().findFirst();
    }

    public SpeedReadingResult getBestResultByAverageSpeed(int configId) {
        return (SpeedReadingResult) this.realm.where(SpeedReadingResult.class).equalTo("config.id", Integer.valueOf(configId)).findAll().sort(SpeedReadingResult.FIELD_AVERAGE_SPEED, Sort.DESCENDING).where().findFirst();
    }

    public SpeedReadingConfig getConfig(int speedReadingConfigId) {
        return (SpeedReadingConfig) this.realm.where(SpeedReadingConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(speedReadingConfigId)).findFirst();
    }

    public List<SpeedReadingConfig> getConfigList() {
        return this.realm.where(SpeedReadingConfig.class).findAll();
    }

    public void updateConfigSpeed(final int configId, final int speed) {
        this.realm.executeTransactionAsync(new Realm.Transaction() {
            public void execute(Realm realm) {
                SpeedReadingConfig config = (SpeedReadingConfig) realm.where(SpeedReadingConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst();
                if (config != null) {
                    config.setSpeed(speed);
                }
            }
        });
    }

    public void addResult(@NonNull final SpeedReadingResult result, final int configId, final ISpeedReadingRepository.OnSingleTransactionCallback callback) {
        final int nextId = getNextId(SpeedReadingResult.class);
        this.realm.executeTransactionAsync((Realm.Transaction) new Realm.Transaction() {
            public void execute(Realm realm) {
                result.setId(nextId);
                result.setConfig((SpeedReadingConfig) realm.where(SpeedReadingConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst());
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

    public void addOrFindConfig(@NonNull final SpeedReadingConfig config, final ISpeedReadingRepository.OnSingleTransactionCallback callback) {
        RealmResults<E> findAll = this.realm.where(SpeedReadingConfig.class).equalTo("trainingShowCount", Integer.valueOf(config.getTrainingShowCount())).findAll().where().equalTo(SpeedReadingConfig.FIELD_MIN_WORD_SHOW_COUNT, Integer.valueOf(config.getMinWordShowCount())).findAll().where().equalTo(SpeedReadingConfig.FIELD_MAX_WORD_SHOW_COUNT, Integer.valueOf(config.getMaxWordShowCount())).findAll().where().equalTo(SpeedReadingConfig.FIELD_MIN_SPEED, Integer.valueOf(config.getMinSpeed())).findAll().where().equalTo(SpeedReadingConfig.FIELD_SPEED_STEP, Integer.valueOf(config.getSpeedStep())).findAll();
        if (!findAll.isEmpty()) {
            callback.onTransactionCompleted(((SpeedReadingConfig) findAll.first()).getId());
            return;
        }
        final int nextId = getNextId(SpeedReadingConfig.class);
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

    public void addOrFindConfigs(@NonNull SpeedReadingConfig[] configs, final ISpeedReadingRepository.OnMultiTransactionCallback callback) {
        int nextId = getNextId(SpeedReadingConfig.class);
        final int[] configIds = new int[configs.length];
        final List<SpeedReadingConfig> haveToSaveConfigList = new ArrayList<>(configs.length);
        for (int i = 0; i < configs.length; i++) {
            SpeedReadingConfig config = configs[i];
            RealmResults<E> findAll = this.realm.where(SpeedReadingConfig.class).equalTo("trainingShowCount", Integer.valueOf(config.getTrainingShowCount())).findAll().where().equalTo(SpeedReadingConfig.FIELD_MIN_WORD_SHOW_COUNT, Integer.valueOf(config.getMinWordShowCount())).findAll().where().equalTo(SpeedReadingConfig.FIELD_MAX_WORD_SHOW_COUNT, Integer.valueOf(config.getMaxWordShowCount())).findAll().where().equalTo(SpeedReadingConfig.FIELD_MIN_SPEED, Integer.valueOf(config.getMinSpeed())).findAll().where().equalTo(SpeedReadingConfig.FIELD_SPEED_STEP, Integer.valueOf(config.getSpeedStep())).findAll();
            if (!findAll.isEmpty()) {
                configIds[i] = ((SpeedReadingConfig) findAll.first()).getId();
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
