package com.safonov.speedreading.training.fragment.wordsblock.result.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.training.fragment.wordsblock.repository.entity.WordBlockResult;
import java.util.List;

public interface IWordBlockResultView extends MvpView {
    void setChartViewData(List<WordBlockResult> list);

    void updateTrainingDurationView(long j);
}
