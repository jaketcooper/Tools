package com.safonov.speedreading.training.fragment.math.result.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.training.fragment.math.repository.entity.MathResult;
import java.util.List;

public interface IMathResultView extends MvpView {
    void setChartViewData(List<MathResult> list);

    void setNewBestScoreViewVisibility(boolean z);

    void updateBestScoreView(int i);

    void updateScoreView(int i);
}
