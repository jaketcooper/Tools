package com.safonov.speedreading.training.fragment.wordpairs.passcourseresult.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.passcource.util.WordPairsScoreUtil;
import com.safonov.speedreading.training.fragment.wordpairs.passcourseresult.view.IWordPairsPassCourseResultView;
import com.safonov.speedreading.training.fragment.wordpairs.repository.IWordPairsRepository;
import com.safonov.speedreading.training.fragment.wordpairs.repository.entity.WordPairsResult;

public class WordPairsPassCourseResultPresenter extends MvpBasePresenter<IWordPairsPassCourseResultView> implements IWordPairsPassCourseResultPresenter {
    private IWordPairsRepository repository;

    public WordPairsPassCourseResultPresenter(@NonNull IWordPairsRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int trainingResultId) {
        WordPairsResult currentResult = this.repository.getResult(trainingResultId);
        WordPairsResult bestResult = this.repository.getBestResult(currentResult.getConfig().getId());
        int score = currentResult.getScore();
        int bestScore = bestResult.getScore();
        boolean isNewBest = currentResult.getId() == bestResult.getId();
        if (isViewAttached()) {
            ((IWordPairsPassCourseResultView) getView()).updateScoreView(score);
            ((IWordPairsPassCourseResultView) getView()).updateBestScoreView(bestScore);
            ((IWordPairsPassCourseResultView) getView()).setNewBestScoreViewVisibility(isNewBest);
            ((IWordPairsPassCourseResultView) getView()).updatePassCoursePointsView(WordPairsScoreUtil.getPassCourseScore(score));
        }
    }
}
