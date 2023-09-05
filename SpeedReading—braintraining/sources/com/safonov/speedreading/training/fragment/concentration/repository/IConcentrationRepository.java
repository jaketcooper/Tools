package com.safonov.speedreading.training.fragment.concentration.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.safonov.speedreading.training.fragment.concentration.repository.entity.ConcentrationConfig;
import com.safonov.speedreading.training.fragment.concentration.repository.entity.ConcentrationResult;
import java.util.List;

public interface IConcentrationRepository {

    public interface OnMultiTransactionCallback {
        void onTransactionCompleted(int[] iArr);
    }

    public interface OnSingleTransactionCallback {
        void onTransactionCompleted(int i);
    }

    void addOrFindConfig(@NonNull ConcentrationConfig concentrationConfig, OnSingleTransactionCallback onSingleTransactionCallback);

    void addOrFindConfigs(@NonNull ConcentrationConfig[] concentrationConfigArr, OnMultiTransactionCallback onMultiTransactionCallback);

    void addResult(@NonNull ConcentrationResult concentrationResult, int i, OnSingleTransactionCallback onSingleTransactionCallback);

    @Nullable
    ConcentrationResult getBestResult(int i);

    @Nullable
    ConcentrationConfig getConfig(int i);

    List<ConcentrationConfig> getConfigList();

    @Nullable
    ConcentrationResult getResult(int i);

    List<ConcentrationResult> getResultList(int i);

    void updateConfig(int i, int i2, int i3, int i4);

    void updateConfigComplexity(int i, int i2);

    void updateConfigCustom(int i, int i2, int i3, int i4);
}
