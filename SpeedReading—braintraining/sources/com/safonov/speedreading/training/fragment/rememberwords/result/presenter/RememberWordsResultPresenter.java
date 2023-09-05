package com.safonov.speedreading.training.fragment.rememberwords.result.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.rememberwords.repository.IRememberWordsRepository;
import com.safonov.speedreading.training.fragment.rememberwords.repository.entity.RememberWordsResult;
import com.safonov.speedreading.training.fragment.rememberwords.result.view.IRememberWordsResultView;
import com.safonov.speedreading.training.util.ResultListUtil;
import java.util.List;

public class RememberWordsResultPresenter extends MvpBasePresenter<IRememberWordsResultView> implements IRememberWordsResultPresenter {
    private IRememberWordsRepository repository;

    public RememberWordsResultPresenter(@NonNull IRememberWordsRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int resultId) {
        RememberWordsResult result = this.repository.getResult(resultId);
        RememberWordsResult bestResult = this.repository.getBestResult(result.getConfig().getId());
        List<RememberWordsResult> resultList = this.repository.getResultList(result.getConfig().getId());
        int score = result.getScore();
        int bestScore = bestResult.getScore();
        boolean isNewBest = result.getId() == bestResult.getId();
        if (isViewAttached()) {
            ((IRememberWordsResultView) getView()).updateScoreView(score);
            ((IRememberWordsResultView) getView()).updateBestScoreView(bestScore);
            ((IRememberWordsResultView) getView()).setNewBestScoreViewVisibility(isNewBest);
            ((IRememberWordsResultView) getView()).setChartViewData(ResultListUtil.getLastPartOfList(resultList));
        }
    }
}
