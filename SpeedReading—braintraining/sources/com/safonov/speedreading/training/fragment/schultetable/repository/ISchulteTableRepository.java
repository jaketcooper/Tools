package com.safonov.speedreading.training.fragment.schultetable.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableConfig;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableResult;
import java.util.List;

public interface ISchulteTableRepository {

    public interface OnMultiTransactionCallback {
        void onTransactionCompleted(int[] iArr);
    }

    public interface OnSingleTransactionCallback {
        void onTransactionCompleted(int i);
    }

    void addOrFindConfig(@NonNull SchulteTableConfig schulteTableConfig, OnSingleTransactionCallback onSingleTransactionCallback);

    void addOrFindConfigs(@NonNull SchulteTableConfig[] schulteTableConfigArr, OnMultiTransactionCallback onMultiTransactionCallback);

    void addResult(@NonNull SchulteTableResult schulteTableResult, int i, OnSingleTransactionCallback onSingleTransactionCallback);

    @Nullable
    SchulteTableResult getBestResult(int i);

    @Nullable
    SchulteTableConfig getConfig(int i);

    List<SchulteTableConfig> getConfigList();

    @Nullable
    SchulteTableResult getResult(int i);

    @NonNull
    List<SchulteTableResult> getResultList(int i);
}
