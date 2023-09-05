package com.safonov.speedreading.training.fragment.rememberwords.result.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.training.fragment.rememberwords.repository.entity.RememberWordsResult;
import java.util.List;

public interface IRememberWordsResultView extends MvpView {
    void setChartViewData(List<RememberWordsResult> list);

    void setNewBestScoreViewVisibility(boolean z);

    void updateBestScoreView(int i);

    void updateScoreView(int i);
}
