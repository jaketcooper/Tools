package com.safonov.speedreading.training.fragment.remembernumber.result.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.training.fragment.remembernumber.repository.entity.RememberNumberResult;
import java.util.List;

public interface IRememberNumberResultView extends MvpView {
    void setChartViewData(List<RememberNumberResult> list);

    void setNewBestScoreViewVisibility(boolean z);

    void updateBestScoreView(int i);

    void updateScoreView(int i);
}
