package com.safonov.speedreading.training.fragment.passcource.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.safonov.speedreading.training.fragment.passcource.repository.etity.PassCourseResult;
import java.util.List;

public interface IPassCourseRepository {

    public interface OnTransactionCallback {
        void onTransactionCompleted(int i);
    }

    void addResult(@NonNull PassCourseResult passCourseResult, OnTransactionCallback onTransactionCallback);

    @Nullable
    PassCourseResult getBestResult();

    @Nullable
    PassCourseResult getResult(int i);

    @NonNull
    List<PassCourseResult> getResultList();
}
