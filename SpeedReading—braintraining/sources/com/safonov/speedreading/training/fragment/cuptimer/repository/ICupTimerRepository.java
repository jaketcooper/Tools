package com.safonov.speedreading.training.fragment.cuptimer.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.safonov.speedreading.training.fragment.cuptimer.repository.entity.CupTimerConfig;
import com.safonov.speedreading.training.fragment.cuptimer.repository.entity.CupTimerResult;
import java.util.List;

public interface ICupTimerRepository {

    public interface OnMultiTransactionCallback {
        void onTransactionCompleted(int[] iArr);
    }

    public interface OnSingleTransactionCallback {
        void onTransactionCompleted(int i);
    }

    void addOrFindConfig(@NonNull CupTimerConfig cupTimerConfig, OnSingleTransactionCallback onSingleTransactionCallback);

    void addOrFindConfigs(@NonNull CupTimerConfig[] cupTimerConfigArr, OnMultiTransactionCallback onMultiTransactionCallback);

    void addResult(@NonNull CupTimerResult cupTimerResult, int i, OnSingleTransactionCallback onSingleTransactionCallback);

    @Nullable
    CupTimerConfig getConfig(int i);

    List<CupTimerConfig> getConfigList();

    @Nullable
    CupTimerResult getResult(int i);

    List<CupTimerResult> getResultList();
}
