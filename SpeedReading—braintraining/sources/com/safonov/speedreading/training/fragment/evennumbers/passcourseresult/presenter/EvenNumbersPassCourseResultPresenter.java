package com.safonov.speedreading.training.fragment.evennumbers.passcourseresult.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.evennumbers.passcourseresult.view.IEvenNumbersPassCourseResultView;
import com.safonov.speedreading.training.fragment.evennumbers.repository.IEvenNumberRepository;
import com.safonov.speedreading.training.fragment.evennumbers.repository.entity.EvenNumbersResult;
import com.safonov.speedreading.training.fragment.passcource.util.EvenNumbersScoreUtil;

public class EvenNumbersPassCourseResultPresenter extends MvpBasePresenter<IEvenNumbersPassCourseResultView> implements IEvenNumbersPassCourseResultPresenter {
    private IEvenNumberRepository repository;

    public EvenNumbersPassCourseResultPresenter(@NonNull IEvenNumberRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int resultId) {
        EvenNumbersResult currentResult = this.repository.getResult(resultId);
        EvenNumbersResult bestResult = this.repository.getBestResult(currentResult.getConfig().getId());
        int score = currentResult.getScore();
        int bestScore = bestResult.getScore();
        boolean isNewBest = currentResult.getId() == bestResult.getId();
        if (isViewAttached()) {
            ((IEvenNumbersPassCourseResultView) getView()).updateScoreView(score);
            ((IEvenNumbersPassCourseResultView) getView()).updateBestScoreView(bestScore);
            ((IEvenNumbersPassCourseResultView) getView()).setNewBestScoreViewVisibility(isNewBest);
            ((IEvenNumbersPassCourseResultView) getView()).updatePassCoursePointsView(EvenNumbersScoreUtil.getPassCourseScore(score));
        }
    }
}
