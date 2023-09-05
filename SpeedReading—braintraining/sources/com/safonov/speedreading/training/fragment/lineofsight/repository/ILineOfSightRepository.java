package com.safonov.speedreading.training.fragment.lineofsight.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightConfig;
import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightResult;
import java.util.List;

public interface ILineOfSightRepository {

    public interface OnMultiTransactionCallback {
        void onTransactionCompleted(int[] iArr);
    }

    public interface OnSingleTransactionCallback {
        void onTransactionCompleted(int i);
    }

    void addOrFindConfig(@NonNull LineOfSightConfig lineOfSightConfig, OnSingleTransactionCallback onSingleTransactionCallback);

    void addOrFindConfigs(@NonNull LineOfSightConfig[] lineOfSightConfigArr, OnMultiTransactionCallback onMultiTransactionCallback);

    void addResult(@NonNull LineOfSightResult lineOfSightResult, int i, OnSingleTransactionCallback onSingleTransactionCallback);

    @Nullable
    LineOfSightConfig getConfig(int i);

    List<LineOfSightConfig> getConfigList();

    @Nullable
    LineOfSightResult getResult(int i);

    List<LineOfSightResult> getResultList(int i);
}
