package com.safonov.speedreading.training.fragment.evennumbers.result.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.training.fragment.evennumbers.repository.entity.EvenNumbersResult;
import java.util.List;

public interface IEvenNumbersResultView extends MvpView {
    void setChartViewData(List<EvenNumbersResult> list);

    void setNewBestScoreViewVisibility(boolean z);

    void updateBestScoreView(int i);

    void updateScoreView(int i);
}
