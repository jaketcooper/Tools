package com.safonov.speedreading.training.fragment.remembernumber.passcourseresult.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.passcource.util.RememberNumberScoreUtil;
import com.safonov.speedreading.training.fragment.remembernumber.passcourseresult.view.IRememberNumberPassCourseResultView;
import com.safonov.speedreading.training.fragment.remembernumber.repository.IRememberNumberRepository;
import com.safonov.speedreading.training.fragment.remembernumber.repository.entity.RememberNumberResult;

public class RememberNumberPassCourseResultPresenter extends MvpBasePresenter<IRememberNumberPassCourseResultView> implements IRememberNumberPassCourseResultPresenter {
    private IRememberNumberRepository repository;

    public RememberNumberPassCourseResultPresenter(@NonNull IRememberNumberRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int resultId) {
        RememberNumberResult result = this.repository.getResult(resultId);
        RememberNumberResult bestResult = this.repository.getBestResult(result.getConfig().getId());
        int score = result.getScore();
        int bestScore = bestResult.getScore();
        boolean isNewBest = result.getId() == bestResult.getId();
        if (isViewAttached()) {
            ((IRememberNumberPassCourseResultView) getView()).updateScoreView(score);
            ((IRememberNumberPassCourseResultView) getView()).updateBestScoreView(bestScore);
            ((IRememberNumberPassCourseResultView) getView()).setNewBestScoreViewVisibility(isNewBest);
            ((IRememberNumberPassCourseResultView) getView()).updatePassCoursePointsView(RememberNumberScoreUtil.getPassCourseScore(score));
        }
    }
}
