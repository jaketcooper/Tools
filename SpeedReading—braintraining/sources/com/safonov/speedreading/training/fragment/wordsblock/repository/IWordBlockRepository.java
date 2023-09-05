package com.safonov.speedreading.training.fragment.wordsblock.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.safonov.speedreading.training.fragment.wordsblock.repository.entity.WordBlockConfig;
import com.safonov.speedreading.training.fragment.wordsblock.repository.entity.WordBlockResult;
import java.util.List;

public interface IWordBlockRepository {

    public interface OnMultiTransactionCallback {
        void onTransactionCompleted(int[] iArr);
    }

    public interface OnSingleTransactionCallback {
        void onTransactionCompleted(int i);
    }

    void addOrFindConfig(@NonNull WordBlockConfig wordBlockConfig, OnSingleTransactionCallback onSingleTransactionCallback);

    void addOrFindConfigs(@NonNull WordBlockConfig[] wordBlockConfigArr, OnMultiTransactionCallback onMultiTransactionCallback);

    void addResult(@NonNull WordBlockResult wordBlockResult, int i, OnSingleTransactionCallback onSingleTransactionCallback);

    @Nullable
    WordBlockConfig getConfig(int i);

    List<WordBlockConfig> getConfigList();

    @Nullable
    WordBlockResult getResult(int i);

    List<WordBlockResult> getResultList();

    void updateConfig(int i, int i2, int i3);
}
