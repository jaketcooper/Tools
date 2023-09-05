package com.safonov.speedreading.training.fragment.evennumbers.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.safonov.speedreading.training.fragment.evennumbers.repository.entity.EvenNumbersConfig;
import com.safonov.speedreading.training.fragment.evennumbers.repository.entity.EvenNumbersResult;
import java.util.List;

public interface IEvenNumberRepository {

    public interface OnMultiTransactionCallback {
        void onTransactionCompleted(int[] iArr);
    }

    public interface OnSingleTransactionCallback {
        void onTransactionCompleted(int i);
    }

    void addOrFindConfig(@NonNull EvenNumbersConfig evenNumbersConfig, OnSingleTransactionCallback onSingleTransactionCallback);

    void addOrFindConfigs(@NonNull EvenNumbersConfig[] evenNumbersConfigArr, OnMultiTransactionCallback onMultiTransactionCallback);

    void addResult(@NonNull EvenNumbersResult evenNumbersResult, int i, OnSingleTransactionCallback onSingleTransactionCallback);

    @Nullable
    EvenNumbersResult getBestResult(int i);

    @Nullable
    EvenNumbersConfig getConfig(int i);

    List<EvenNumbersConfig> getConfigList();

    @Nullable
    EvenNumbersResult getResult(int i);

    List<EvenNumbersResult> getResultList(int i);
}
