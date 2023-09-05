package com.safonov.speedreading.training.fragment.concentration.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.RealmUtil;
import com.safonov.speedreading.training.fragment.concentration.repository.IConcentrationRepository;
import com.safonov.speedreading.training.fragment.concentration.repository.entity.ConcentrationConfig;
import com.safonov.speedreading.training.fragment.concentration.repository.entity.ConcentrationResult;
import java.util.ArrayList;
import java.util.List;
import p006io.realm.Realm;
import p006io.realm.RealmResults;
import p006io.realm.Sort;

public class ConcentrationRealmUtil extends RealmUtil implements IConcentrationRepository {
    public ConcentrationRealmUtil(@NonNull Realm realm) {
        super(realm);
    }

    @Nullable
    public ConcentrationResult getResult(int id) {
        return (ConcentrationResult) this.realm.where(ConcentrationResult.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public List<ConcentrationResult> getResultList(int configId) {
        return this.realm.where(ConcentrationResult.class).equalTo("config.id", Integer.valueOf(configId)).findAll();
    }

    @Nullable
    public ConcentrationResult getBestResult(int configId) {
        return (ConcentrationResult) this.realm.where(ConcentrationResult.class).equalTo("config.id", Integer.valueOf(configId)).findAll().sort("score", Sort.DESCENDING).where().findFirst();
    }

    @Nullable
    public ConcentrationConfig getConfig(int id) {
        return (ConcentrationConfig) this.realm.where(ConcentrationConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public List<ConcentrationConfig> getConfigList() {
        return this.realm.where(ConcentrationConfig.class).findAll();
    }

    public void updateConfigComplexity(final int configId, final int complexity) {
        this.realm.executeTransactionAsync(new Realm.Transaction() {
            public void execute(Realm realm) {
                ConcentrationConfig config = (ConcentrationConfig) realm.where(ConcentrationConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst();
                if (config != null) {
                    config.setComplexity(complexity);
                }
            }
        });
    }

    public void updateConfig(int configId, int circlesCount, int circlesRadius, int circlesSpeed) {
        final int i = configId;
        final int i2 = circlesCount;
        final int i3 = circlesRadius;
        final int i4 = circlesSpeed;
        this.realm.executeTransaction(new Realm.Transaction() {
            public void execute(Realm realm) {
                ConcentrationConfig config = (ConcentrationConfig) realm.where(ConcentrationConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(i)).findFirst();
                if (config != null) {
                    config.setCirclesCount(i2);
                    config.setCirclesRadius(i3);
                    config.setCirclesSpeed(i4);
                }
            }
        });
    }

    public void updateConfigCustom(int configId, int circlesCount, int circlesRadius, int circlesSpeed) {
        final int i = configId;
        final int i2 = circlesCount;
        final int i3 = circlesRadius;
        final int i4 = circlesSpeed;
        this.realm.executeTransaction(new Realm.Transaction() {
            public void execute(Realm realm) {
                ConcentrationConfig config = (ConcentrationConfig) realm.where(ConcentrationConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(i)).findFirst();
                if (config != null) {
                    config.setCirclesCountCustom(i2);
                    config.setCirclesSizeCustom(i3);
                    config.setCirclesSpeedCustom(i4);
                }
            }
        });
    }

    public void addResult(@NonNull final ConcentrationResult result, final int configId, final IConcentrationRepository.OnSingleTransactionCallback callback) {
        final int nextId = getNextId(ConcentrationResult.class);
        this.realm.executeTransactionAsync((Realm.Transaction) new Realm.Transaction() {
            public void execute(Realm realm) {
                result.setId(nextId);
                result.setConfig((ConcentrationConfig) realm.where(ConcentrationConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst());
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

    public void addOrFindConfig(@NonNull final ConcentrationConfig config, final IConcentrationRepository.OnSingleTransactionCallback callback) {
        RealmResults<E> findAll = this.realm.where(ConcentrationConfig.class).findAll();
        if (!findAll.isEmpty()) {
            callback.onTransactionCompleted(((ConcentrationConfig) findAll.first()).getId());
            Log.d("concentration config r", "" + ((ConcentrationConfig) findAll.first()).getId());
            return;
        }
        Log.d("concentration config r", "Нет конфига");
        final int nextId = getNextId(ConcentrationConfig.class);
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

    public void addOrFindConfigs(@NonNull ConcentrationConfig[] configs, final IConcentrationRepository.OnMultiTransactionCallback callback) {
        int nextId = getNextId(ConcentrationConfig.class);
        final int[] configIds = new int[configs.length];
        final List<ConcentrationConfig> haveToSaveConfigList = new ArrayList<>(configs.length);
        for (int i = 0; i < configs.length; i++) {
            ConcentrationConfig config = configs[i];
            RealmResults<E> findAll = this.realm.where(ConcentrationConfig.class).equalTo(ConcentrationConfig.FIELD_CIRCLES_COUNT, Integer.valueOf(config.getCirclesCount())).findAll().where().equalTo(ConcentrationConfig.FIELD_CIRCLES_RADIUS, Integer.valueOf(config.getCirclesRadius())).findAll().where().equalTo(ConcentrationConfig.FIELD_GRAY_TIME, Integer.valueOf(config.getGrayTime())).findAll().where().equalTo(ConcentrationConfig.FIELD_CIRCLES_SPEED, Integer.valueOf(config.getCirclesSpeed())).findAll();
            if (!findAll.isEmpty()) {
                configIds[i] = ((ConcentrationConfig) findAll.first()).getId();
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
