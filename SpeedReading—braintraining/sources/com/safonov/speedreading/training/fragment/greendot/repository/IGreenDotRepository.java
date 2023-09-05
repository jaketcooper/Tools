package com.safonov.speedreading.training.fragment.greendot.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.safonov.speedreading.training.fragment.greendot.repository.entity.GreenDotConfig;
import com.safonov.speedreading.training.fragment.greendot.repository.entity.GreenDotResult;
import java.util.List;

public interface IGreenDotRepository {

    public interface OnMultiTransactionCallback {
        void onTransactionCompleted(int[] iArr);
    }

    public interface OnSingleTransactionCallback {
        void onTransactionCompleted(int i);
    }

    void addOrFindConfig(@NonNull GreenDotConfig greenDotConfig, OnSingleTransactionCallback onSingleTransactionCallback);

    void addOrFindConfigs(@NonNull GreenDotConfig[] greenDotConfigArr, OnMultiTransactionCallback onMultiTransactionCallback);

    void addResult(@NonNull GreenDotResult greenDotResult, int i, OnSingleTransactionCallback onSingleTransactionCallback);

    @Nullable
    GreenDotConfig getConfig(int i);

    List<GreenDotConfig> getConfigList();

    @Nullable
    GreenDotResult getResult(int i);

    List<GreenDotResult> getResultList();
}
