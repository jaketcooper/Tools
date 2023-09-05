package com.safonov.speedreading.training.fragment.greendot.result.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.training.fragment.greendot.repository.entity.GreenDotResult;
import java.util.List;

public interface IGreenDotResultView extends MvpView {
    void setChartViewData(List<GreenDotResult> list);

    void updateTrainingDurationView(long j);
}
