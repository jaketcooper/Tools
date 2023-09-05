package com.safonov.speedreading.training.fragment.speedreading.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingConfig;
import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingResult;
import java.util.List;

public interface ISpeedReadingRepository {

    public interface OnMultiTransactionCallback {
        void onTransactionCompleted(int[] iArr);
    }

    public interface OnSingleTransactionCallback {
        void onTransactionCompleted(int i);
    }

    void addOrFindConfig(@NonNull SpeedReadingConfig speedReadingConfig, OnSingleTransactionCallback onSingleTransactionCallback);

    void addOrFindConfigs(@NonNull SpeedReadingConfig[] speedReadingConfigArr, OnMultiTransactionCallback onMultiTransactionCallback);

    void addResult(@NonNull SpeedReadingResult speedReadingResult, int i, OnSingleTransactionCallback onSingleTransactionCallback);

    @Nullable
    SpeedReadingResult getBestResultByAverageSpeed(int i);

    @Nullable
    SpeedReadingResult getBestResultByMaxSpeed(int i);

    @Nullable
    SpeedReadingConfig getConfig(int i);

    List<SpeedReadingConfig> getConfigList();

    @Nullable
    SpeedReadingResult getResult(int i);

    List<SpeedReadingResult> getResultList(int i);

    void updateConfigSpeed(int i, int i2);
}
