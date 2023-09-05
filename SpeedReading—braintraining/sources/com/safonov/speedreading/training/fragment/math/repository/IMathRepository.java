package com.safonov.speedreading.training.fragment.math.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.safonov.speedreading.training.fragment.math.repository.entity.MathConfig;
import com.safonov.speedreading.training.fragment.math.repository.entity.MathResult;
import java.util.List;

public interface IMathRepository {

    public interface OnMultiTransactionCallback {
        void onTransactionCompleted(int[] iArr);
    }

    public interface OnSingleTransactionCallback {
        void onTransactionCompleted(int i);
    }

    void addOrFindConfig(@NonNull MathConfig mathConfig, OnSingleTransactionCallback onSingleTransactionCallback);

    void addOrFindConfigs(@NonNull MathConfig[] mathConfigArr, OnMultiTransactionCallback onMultiTransactionCallback);

    void addResult(@NonNull MathResult mathResult, int i, OnSingleTransactionCallback onSingleTransactionCallback);

    @Nullable
    MathResult getBestResult(int i);

    @Nullable
    MathConfig getConfig(int i);

    List<MathConfig> getConfigList();

    @Nullable
    MathResult getResult(int i);

    List<MathResult> getResultList(int i);

    void updateConfigComplexity(int i, int i2);
}
