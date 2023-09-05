package com.safonov.speedreading.training.fragment.truecolors.result.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.training.fragment.truecolors.repository.entity.TrueColorsResult;
import java.util.List;

public interface ITrueColorsResultView extends MvpView {
    void setChartViewData(List<TrueColorsResult> list);

    void setNewBestScoreViewVisibility(boolean z);

    void updateBestScoreView(int i);

    void updateScoreView(int i);
}
