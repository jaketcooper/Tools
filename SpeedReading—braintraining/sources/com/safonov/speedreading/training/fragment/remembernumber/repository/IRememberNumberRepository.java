package com.safonov.speedreading.training.fragment.remembernumber.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.safonov.speedreading.training.fragment.remembernumber.repository.entity.RememberNumberConfig;
import com.safonov.speedreading.training.fragment.remembernumber.repository.entity.RememberNumberResult;
import java.util.List;

public interface IRememberNumberRepository {

    public interface OnMultiTransactionCallback {
        void onTransactionCompleted(int[] iArr);
    }

    public interface OnSingleTransactionCallback {
        void onTransactionCompleted(int i);
    }

    void addOrFindConfig(@NonNull RememberNumberConfig rememberNumberConfig, OnSingleTransactionCallback onSingleTransactionCallback);

    void addOrFindConfigs(@NonNull RememberNumberConfig[] rememberNumberConfigArr, OnMultiTransactionCallback onMultiTransactionCallback);

    void addResult(@NonNull RememberNumberResult rememberNumberResult, int i, OnSingleTransactionCallback onSingleTransactionCallback);

    @Nullable
    RememberNumberResult getBestResult(int i);

    @Nullable
    RememberNumberConfig getConfig(int i);

    List<RememberNumberConfig> getConfigList();

    @Nullable
    RememberNumberResult getResult(int i);

    List<RememberNumberResult> getResultList(int i);

    void updateConfigComplexity(int i, int i2);
}
