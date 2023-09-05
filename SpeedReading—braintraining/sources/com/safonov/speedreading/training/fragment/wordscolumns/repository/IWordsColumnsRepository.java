package com.safonov.speedreading.training.fragment.wordscolumns.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.entity.WordsColumnsConfig;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.entity.WordsColumnsResult;
import java.util.List;

public interface IWordsColumnsRepository {

    public interface OnMultiTransactionCallback {
        void onTransactionCompleted(int[] iArr);
    }

    public interface OnSingleTransactionCallback {
        void onTransactionCompleted(int i);
    }

    void addOrFindConfig(@NonNull WordsColumnsConfig wordsColumnsConfig, OnSingleTransactionCallback onSingleTransactionCallback);

    void addOrFindConfigs(@NonNull WordsColumnsConfig[] wordsColumnsConfigArr, OnMultiTransactionCallback onMultiTransactionCallback);

    void addResult(@NonNull WordsColumnsResult wordsColumnsResult, int i, OnSingleTransactionCallback onSingleTransactionCallback);

    @Nullable
    WordsColumnsConfig getConfig(int i);

    List<WordsColumnsConfig> getConfigList();

    @Nullable
    WordsColumnsResult getResult(int i);

    List<WordsColumnsResult> getResultList();

    void updateConfigSpeed(int i, int i2);
}
