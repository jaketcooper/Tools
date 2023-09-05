package com.safonov.speedreading.training.fragment.remembernumber.result.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.remembernumber.repository.IRememberNumberRepository;
import com.safonov.speedreading.training.fragment.remembernumber.repository.entity.RememberNumberResult;
import com.safonov.speedreading.training.fragment.remembernumber.result.view.IRememberNumberResultView;
import com.safonov.speedreading.training.util.ResultListUtil;
import java.util.List;

public class RememberNumberResultPresenter extends MvpBasePresenter<IRememberNumberResultView> implements IRememberNumberResultPresenter {
    private IRememberNumberRepository repository;

    public RememberNumberResultPresenter(@NonNull IRememberNumberRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int resultId) {
        RememberNumberResult result = this.repository.getResult(resultId);
        RememberNumberResult bestResult = this.repository.getBestResult(result.getConfig().getId());
        List<RememberNumberResult> resultList = this.repository.getResultList(result.getConfig().getId());
        int score = result.getScore();
        int bestScore = bestResult.getScore();
        boolean isNewBest = result.getId() == bestResult.getId();
        if (isViewAttached()) {
            ((IRememberNumberResultView) getView()).updateScoreView(score);
            ((IRememberNumberResultView) getView()).updateBestScoreView(bestScore);
            ((IRememberNumberResultView) getView()).setNewBestScoreViewVisibility(isNewBest);
            ((IRememberNumberResultView) getView()).setChartViewData(ResultListUtil.getLastPartOfList(resultList));
        }
    }
}
