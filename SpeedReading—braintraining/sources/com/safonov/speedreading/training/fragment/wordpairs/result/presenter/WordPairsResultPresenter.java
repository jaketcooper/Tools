package com.safonov.speedreading.training.fragment.wordpairs.result.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.wordpairs.repository.IWordPairsRepository;
import com.safonov.speedreading.training.fragment.wordpairs.repository.entity.WordPairsResult;
import com.safonov.speedreading.training.fragment.wordpairs.result.view.IWordPairsResultView;
import com.safonov.speedreading.training.util.ResultListUtil;
import java.util.List;

public class WordPairsResultPresenter extends MvpBasePresenter<IWordPairsResultView> implements IWordPairsResultPresenter {
    private IWordPairsRepository repository;

    public WordPairsResultPresenter(@NonNull IWordPairsRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int trainingResultId) {
        WordPairsResult currentResult = this.repository.getResult(trainingResultId);
        WordPairsResult bestResult = this.repository.getBestResult(currentResult.getConfig().getId());
        List<WordPairsResult> resultList = this.repository.getResultList(currentResult.getConfig().getId());
        int score = currentResult.getScore();
        int bestScore = bestResult.getScore();
        boolean isNewBest = currentResult.getId() == bestResult.getId();
        if (isViewAttached()) {
            ((IWordPairsResultView) getView()).updateScoreView(score);
            ((IWordPairsResultView) getView()).updateBestScoreView(bestScore);
            ((IWordPairsResultView) getView()).setNewBestScoreViewVisibility(isNewBest);
            ((IWordPairsResultView) getView()).setChartViewData(ResultListUtil.getLastPartOfList(resultList));
        }
    }
}
