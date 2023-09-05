package com.safonov.speedreading.training.fragment.truecolors.result.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.truecolors.repository.ITrueColorsRepository;
import com.safonov.speedreading.training.fragment.truecolors.repository.entity.TrueColorsResult;
import com.safonov.speedreading.training.fragment.truecolors.result.view.ITrueColorsResultView;
import com.safonov.speedreading.training.util.ResultListUtil;
import java.util.List;

public class TrueColorsResultPresenter extends MvpBasePresenter<ITrueColorsResultView> implements ITrueColorsResultPresenter {
    private ITrueColorsRepository repository;

    public TrueColorsResultPresenter(@NonNull ITrueColorsRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int resultId) {
        TrueColorsResult result = this.repository.getResult(resultId);
        TrueColorsResult bestResult = this.repository.getBestResult(result.getConfig().getId());
        List<TrueColorsResult> resultList = this.repository.getResultList(result.getConfig().getId());
        int score = result.getScore();
        int bestScore = bestResult.getScore();
        boolean isNewBest = result.getId() == bestResult.getId();
        if (isViewAttached()) {
            ((ITrueColorsResultView) getView()).updateScoreView(score);
            ((ITrueColorsResultView) getView()).updateBestScoreView(bestScore);
            ((ITrueColorsResultView) getView()).setNewBestScoreViewVisibility(isNewBest);
            ((ITrueColorsResultView) getView()).setChartViewData(ResultListUtil.getLastPartOfList(resultList));
        }
    }
}
