package com.safonov.speedreading.training.fragment.cuptimer.result.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.training.fragment.cuptimer.repository.entity.CupTimerResult;
import java.util.List;

public interface ICupTimerResultView extends MvpView {
    void setChartViewData(List<CupTimerResult> list);

    void updateTrainingDurationView(long j);
}
