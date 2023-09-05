package com.safonov.speedreading.training.fragment.wordpairs.result.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.training.fragment.wordpairs.repository.entity.WordPairsResult;
import java.util.List;

public interface IWordPairsResultView extends MvpView {
    void setChartViewData(List<WordPairsResult> list);

    void setNewBestScoreViewVisibility(boolean z);

    void updateBestScoreView(int i);

    void updateScoreView(int i);
}
