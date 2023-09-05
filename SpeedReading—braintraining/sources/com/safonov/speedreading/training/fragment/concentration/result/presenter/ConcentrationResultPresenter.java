package com.safonov.speedreading.training.fragment.concentration.result.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.concentration.repository.IConcentrationRepository;
import com.safonov.speedreading.training.fragment.concentration.repository.entity.ConcentrationResult;
import com.safonov.speedreading.training.fragment.concentration.result.view.IConcentrationResultView;
import com.safonov.speedreading.training.util.ResultListUtil;
import java.util.List;

public class ConcentrationResultPresenter extends MvpBasePresenter<IConcentrationResultView> implements IConcentrationResultPresenter {
    private IConcentrationRepository repository;

    public ConcentrationResultPresenter(@NonNull IConcentrationRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int resultId) {
        ConcentrationResult result = this.repository.getResult(resultId);
        ConcentrationResult bestResult = this.repository.getBestResult(result.getConfig().getId());
        List<ConcentrationResult> resultList = this.repository.getResultList(result.getConfig().getId());
        int score = result.getScore();
        int bestScore = bestResult.getScore();
        boolean isNewBest = result.getId() == bestResult.getId();
        if (isViewAttached()) {
            ((IConcentrationResultView) getView()).updateScoreView(score);
            ((IConcentrationResultView) getView()).updateBestScoreView(bestScore);
            ((IConcentrationResultView) getView()).setNewBestScoreViewVisibility(isNewBest);
            ((IConcentrationResultView) getView()).setChartViewData(ResultListUtil.getLastPartOfList(resultList));
        }
    }
}
