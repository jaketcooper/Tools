package com.safonov.speedreading.training.fragment.flashword.result.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.training.fragment.flashword.repository.entity.FlashWordResult;
import java.util.List;

public interface IFlashWordsResultView extends MvpView {
    void setChartViewData(List<FlashWordResult> list);

    void updateTrainingDurationView(long j);
}
