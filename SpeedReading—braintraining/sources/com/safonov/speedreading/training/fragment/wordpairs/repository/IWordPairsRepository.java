package com.safonov.speedreading.training.fragment.wordpairs.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.safonov.speedreading.training.fragment.wordpairs.repository.entity.WordPairsConfig;
import com.safonov.speedreading.training.fragment.wordpairs.repository.entity.WordPairsResult;
import java.util.List;

public interface IWordPairsRepository {

    public interface OnMultiTransactionCallback {
        void onTransactionCompleted(int[] iArr);
    }

    public interface OnSingleTransactionCallback {
        void onTransactionCompleted(int i);
    }

    void addOrFindConfig(@NonNull WordPairsConfig wordPairsConfig, OnSingleTransactionCallback onSingleTransactionCallback);

    void addOrFindConfigs(@NonNull WordPairsConfig[] wordPairsConfigArr, OnMultiTransactionCallback onMultiTransactionCallback);

    void addResult(@NonNull WordPairsResult wordPairsResult, int i, OnSingleTransactionCallback onSingleTransactionCallback);

    @Nullable
    WordPairsResult getBestResult(int i);

    @Nullable
    WordPairsConfig getConfig(int i);

    List<WordPairsConfig> getConfigList();

    @Nullable
    WordPairsResult getResult(int i);

    List<WordPairsResult> getResultList(int i);
}
