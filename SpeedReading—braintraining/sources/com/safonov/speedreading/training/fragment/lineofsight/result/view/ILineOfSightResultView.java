package com.safonov.speedreading.training.fragment.lineofsight.result.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightResult;
import java.util.List;

public interface ILineOfSightResultView extends MvpView {
    void setChartViewData(List<LineOfSightResult> list);

    void updateFoundMistakesPercentView(float f);

    void updateFoundMistakesView(int i);

    void updateMistakesView(int i);
}
