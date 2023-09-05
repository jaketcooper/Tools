package com.safonov.speedreading.training.fragment.truecolors.repository;

import android.support.annotation.NonNull;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.RealmUtil;
import com.safonov.speedreading.training.fragment.truecolors.repository.ITrueColorsRepository;
import com.safonov.speedreading.training.fragment.truecolors.repository.entity.TrueColorsConfig;
import com.safonov.speedreading.training.fragment.truecolors.repository.entity.TrueColorsResult;
import java.util.ArrayList;
import java.util.List;
import p006io.realm.Realm;
import p006io.realm.RealmResults;
import p006io.realm.Sort;

public class TrueColorsRealmUtil extends RealmUtil implements ITrueColorsRepository {
    public TrueColorsRealmUtil(@NonNull Realm realm) {
        super(realm);
    }

    public List<TrueColorsResult> getResultList(int configId) {
        return this.realm.where(TrueColorsResult.class).equalTo("config.id", Integer.valueOf(configId)).findAll();
    }

    public TrueColorsResult getResult(int id) {
        return (TrueColorsResult) this.realm.where(TrueColorsResult.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public TrueColorsResult getBestResult(int configId) {
        return (TrueColorsResult) this.realm.where(TrueColorsResult.class).equalTo("config.id", Integer.valueOf(configId)).findAll().sort("score", Sort.DESCENDING).where().findFirst();
    }

    public TrueColorsConfig getConfig(int id) {
        return (TrueColorsConfig) this.realm.where(TrueColorsConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    public List<TrueColorsConfig> getConfigList() {
        return this.realm.where(TrueColorsConfig.class).findAll();
    }

    public void addResult(@NonNull final TrueColorsResult result, final int configId, final ITrueColorsRepository.OnSingleTransactionCallback callback) {
        final int nextId = getNextId(TrueColorsResult.class);
        this.realm.executeTransactionAsync((Realm.Transaction) new Realm.Transaction() {
            public void execute(Realm realm) {
                result.setId(nextId);
                result.setConfig((TrueColorsConfig) realm.where(TrueColorsConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst());
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

    public void updateConfigShowTime(final int configId, final int showTime) {
        this.realm.executeTransactionAsync(new Realm.Transaction() {
            public void execute(Realm realm) {
                TrueColorsConfig config = (TrueColorsConfig) realm.where(TrueColorsConfig.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(configId)).findFirst();
                if (config != null) {
                    config.setShowTime(showTime);
                }
            }
        });
    }

    public void addOrFindConfig(@NonNull final TrueColorsConfig config, final ITrueColorsRepository.OnSingleTransactionCallback callback) {
        RealmResults<E> findAll = this.realm.where(TrueColorsConfig.class).equalTo(TrueColorsConfig.FIELD_SHOW_TIME, Integer.valueOf(config.getShowTime())).findAll();
        if (!findAll.isEmpty()) {
            callback.onTransactionCompleted(((TrueColorsConfig) findAll.first()).getId());
            return;
        }
        final int nextId = getNextId(TrueColorsConfig.class);
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

    public void addOrFindConfigs(@NonNull TrueColorsConfig[] configs, final ITrueColorsRepository.OnMultiTransactionCallback callback) {
        int nextId = getNextId(TrueColorsConfig.class);
        final int[] configIds = new int[configs.length];
        final List<TrueColorsConfig> haveToSaveConfigList = new ArrayList<>(configs.length);
        for (int i = 0; i < configs.length; i++) {
            TrueColorsConfig config = configs[i];
            RealmResults<E> findAll = this.realm.where(TrueColorsConfig.class).equalTo(TrueColorsConfig.FIELD_SHOW_TIME, Integer.valueOf(config.getShowTime())).findAll();
            if (!findAll.isEmpty()) {
                configIds[i] = ((TrueColorsConfig) findAll.first()).getId();
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
