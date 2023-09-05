package com.safonov.speedreading.training.fragment.evennumbers.result.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.evennumbers.repository.IEvenNumberRepository;
import com.safonov.speedreading.training.fragment.evennumbers.repository.entity.EvenNumbersResult;
import com.safonov.speedreading.training.fragment.evennumbers.result.view.IEvenNumbersResultView;
import com.safonov.speedreading.training.util.ResultListUtil;
import java.util.List;

public class EvenNumbersResultPresenter extends MvpBasePresenter<IEvenNumbersResultView> implements IEvenNumbersResultPresenter {
    private IEvenNumberRepository repository;

    public EvenNumbersResultPresenter(@NonNull IEvenNumberRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int resultId) {
        EvenNumbersResult currentResult = this.repository.getResult(resultId);
        EvenNumbersResult bestResult = this.repository.getBestResult(currentResult.getConfig().getId());
        List<EvenNumbersResult> resultList = this.repository.getResultList(currentResult.getConfig().getId());
        int score = currentResult.getScore();
        int bestScore = bestResult.getScore();
        boolean isNewBest = currentResult.getId() == bestResult.getId();
        if (isViewAttached()) {
            ((IEvenNumbersResultView) getView()).updateScoreView(score);
            ((IEvenNumbersResultView) getView()).updateBestScoreView(bestScore);
            ((IEvenNumbersResultView) getView()).setNewBestScoreViewVisibility(isNewBest);
            ((IEvenNumbersResultView) getView()).setChartViewData(ResultListUtil.getLastPartOfList(resultList));
        }
    }
}
