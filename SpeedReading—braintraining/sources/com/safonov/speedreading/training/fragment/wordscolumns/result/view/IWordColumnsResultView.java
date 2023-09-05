package com.safonov.speedreading.training.fragment.wordscolumns.result.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.entity.WordsColumnsResult;
import java.util.List;

public interface IWordColumnsResultView extends MvpView {
    void setChartViewData(List<WordsColumnsResult> list);

    void updateTrainingDurationView(long j);
}
