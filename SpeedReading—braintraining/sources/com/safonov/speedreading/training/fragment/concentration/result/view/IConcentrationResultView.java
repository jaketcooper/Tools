package com.safonov.speedreading.training.fragment.concentration.result.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.training.fragment.concentration.repository.entity.ConcentrationResult;
import java.util.List;

public interface IConcentrationResultView extends MvpView {
    void setChartViewData(List<ConcentrationResult> list);

    void setNewBestScoreViewVisibility(boolean z);

    void updateBestScoreView(int i);

    void updateScoreView(int i);
}
