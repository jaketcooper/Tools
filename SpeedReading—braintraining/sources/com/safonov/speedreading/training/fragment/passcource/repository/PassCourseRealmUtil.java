package com.safonov.speedreading.training.fragment.passcource.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.RealmUtil;
import com.safonov.speedreading.training.fragment.passcource.repository.IPassCourseRepository;
import com.safonov.speedreading.training.fragment.passcource.repository.etity.PassCourseResult;
import java.util.List;
import p006io.realm.Realm;
import p006io.realm.RealmModel;
import p006io.realm.Sort;

public class PassCourseRealmUtil extends RealmUtil implements IPassCourseRepository {
    public PassCourseRealmUtil(@NonNull Realm realm) {
        super(realm);
    }

    public PassCourseResult getResult(int id) {
        return (PassCourseResult) this.realm.where(PassCourseResult.class).equalTo(IdentityRealmObject.FIELD_ID, Integer.valueOf(id)).findFirst();
    }

    @Nullable
    public PassCourseResult getBestResult() {
        return (PassCourseResult) this.realm.where(PassCourseResult.class).findAll().sort("score", Sort.DESCENDING).first((RealmModel) null);
    }

    @NonNull
    public List<PassCourseResult> getResultList() {
        return this.realm.where(PassCourseResult.class).findAll();
    }

    public void addResult(@NonNull final PassCourseResult result, final IPassCourseRepository.OnTransactionCallback callback) {
        final int nextId = getNextId(PassCourseResult.class);
        result.setId(nextId);
        this.realm.executeTransactionAsync((Realm.Transaction) new Realm.Transaction() {
            public void execute(Realm realm) {
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
}
