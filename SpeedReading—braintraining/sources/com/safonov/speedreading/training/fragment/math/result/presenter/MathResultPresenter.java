package com.safonov.speedreading.training.fragment.math.result.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.math.repository.IMathRepository;
import com.safonov.speedreading.training.fragment.math.repository.entity.MathResult;
import com.safonov.speedreading.training.fragment.math.result.view.IMathResultView;
import com.safonov.speedreading.training.util.ResultListUtil;
import java.util.List;

public class MathResultPresenter extends MvpBasePresenter<IMathResultView> implements IMathResultPresenter {
    private IMathRepository repository;

    public MathResultPresenter(@NonNull IMathRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int resultId) {
        MathResult result = this.repository.getResult(resultId);
        MathResult bestResult = this.repository.getBestResult(result.getConfig().getId());
        List<MathResult> resultList = this.repository.getResultList(result.getConfig().getId());
        int score = result.getScore();
        int bestScore = bestResult.getScore();
        boolean isNewBest = result.getId() == bestResult.getId();
        if (isViewAttached()) {
            ((IMathResultView) getView()).updateScoreView(score);
            ((IMathResultView) getView()).updateBestScoreView(bestScore);
            ((IMathResultView) getView()).setNewBestScoreViewVisibility(isNewBest);
            ((IMathResultView) getView()).setChartViewData(ResultListUtil.getLastPartOfList(resultList));
        }
    }
}
