package com.safonov.speedreading.training.fragment.truecolors.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.safonov.speedreading.training.fragment.truecolors.repository.entity.TrueColorsConfig;
import com.safonov.speedreading.training.fragment.truecolors.repository.entity.TrueColorsResult;
import java.util.List;

public interface ITrueColorsRepository {

    public interface OnMultiTransactionCallback {
        void onTransactionCompleted(int[] iArr);
    }

    public interface OnSingleTransactionCallback {
        void onTransactionCompleted(int i);
    }

    void addOrFindConfig(@NonNull TrueColorsConfig trueColorsConfig, OnSingleTransactionCallback onSingleTransactionCallback);

    void addOrFindConfigs(@NonNull TrueColorsConfig[] trueColorsConfigArr, OnMultiTransactionCallback onMultiTransactionCallback);

    void addResult(@NonNull TrueColorsResult trueColorsResult, int i, OnSingleTransactionCallback onSingleTransactionCallback);

    @Nullable
    TrueColorsResult getBestResult(int i);

    @Nullable
    TrueColorsConfig getConfig(int i);

    List<TrueColorsConfig> getConfigList();

    @Nullable
    TrueColorsResult getResult(int i);

    List<TrueColorsResult> getResultList(int i);

    void updateConfigShowTime(int i, int i2);
}
