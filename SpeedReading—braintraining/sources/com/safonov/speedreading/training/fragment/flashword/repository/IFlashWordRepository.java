package com.safonov.speedreading.training.fragment.flashword.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.safonov.speedreading.training.fragment.flashword.repository.entity.FlashWordResult;
import com.safonov.speedreading.training.fragment.flashword.repository.entity.FlashWordsConfig;
import java.util.List;

public interface IFlashWordRepository {

    public interface OnMultiTransactionCallback {
        void onTransactionCompleted(int[] iArr);
    }

    public interface OnSingleTransactionCallback {
        void onTransactionCompleted(int i);
    }

    void addOrFindConfig(@NonNull FlashWordsConfig flashWordsConfig, OnSingleTransactionCallback onSingleTransactionCallback);

    void addOrFindConfigs(@NonNull FlashWordsConfig[] flashWordsConfigArr, OnMultiTransactionCallback onMultiTransactionCallback);

    void addResult(@NonNull FlashWordResult flashWordResult, int i, OnSingleTransactionCallback onSingleTransactionCallback);

    @Nullable
    FlashWordsConfig getConfig(int i);

    List<FlashWordsConfig> getConfigList();

    @Nullable
    FlashWordResult getResult(int i);

    List<FlashWordResult> getResultList();

    void updateConfig(int i, int i2);
}
