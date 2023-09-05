package com.safonov.speedreading.training.fragment.rememberwords.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.safonov.speedreading.training.fragment.rememberwords.repository.entity.RememberWordsConfig;
import com.safonov.speedreading.training.fragment.rememberwords.repository.entity.RememberWordsResult;
import java.util.List;

public interface IRememberWordsRepository {

    public interface OnMultiTransactionCallback {
        void onTransactionCompleted(int[] iArr);
    }

    public interface OnSingleTransactionCallback {
        void onTransactionCompleted(int i);
    }

    void addOrFindConfig(@NonNull RememberWordsConfig rememberWordsConfig, OnSingleTransactionCallback onSingleTransactionCallback);

    void addOrFindConfigs(@NonNull RememberWordsConfig[] rememberWordsConfigArr, OnMultiTransactionCallback onMultiTransactionCallback);

    void addResult(@NonNull RememberWordsResult rememberWordsResult, int i, OnSingleTransactionCallback onSingleTransactionCallback);

    @Nullable
    RememberWordsResult getBestResult(int i);

    @Nullable
    RememberWordsConfig getConfig(int i);

    List<RememberWordsConfig> getConfigList();

    @Nullable
    RememberWordsResult getResult(int i);

    List<RememberWordsResult> getResultList(int i);

    void updateConfigWordsCount(int i, int i2);
}
