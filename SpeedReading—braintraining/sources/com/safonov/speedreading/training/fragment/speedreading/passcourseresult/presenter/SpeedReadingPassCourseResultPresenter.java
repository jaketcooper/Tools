package com.safonov.speedreading.training.fragment.speedreading.passcourseresult.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.passcource.util.SpeedReadingScoreUtil;
import com.safonov.speedreading.training.fragment.speedreading.passcourseresult.view.ISpeedReadingPassCourseResultView;
import com.safonov.speedreading.training.fragment.speedreading.repository.ISpeedReadingRepository;
import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingResult;

public class SpeedReadingPassCourseResultPresenter extends MvpBasePresenter<ISpeedReadingPassCourseResultView> implements ISpeedReadingPassCourseResultPresenter {
    private ISpeedReadingRepository repository;

    public SpeedReadingPassCourseResultPresenter(@NonNull ISpeedReadingRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int resultId) {
        boolean isNewBestMaxSpeed;
        boolean isNewBestAverageSpeed;
        SpeedReadingResult currentResult = this.repository.getResult(resultId);
        SpeedReadingResult bestMaxSpeedResult = this.repository.getBestResultByMaxSpeed(currentResult.getConfig().getId());
        SpeedReadingResult bestAverageSpeedResult = this.repository.getBestResultByAverageSpeed(currentResult.getConfig().getId());
        int maxSpeed = currentResult.getMaxSpeed();
        int bestMaxSpeed = bestMaxSpeedResult.getMaxSpeed();
        if (currentResult.getId() == bestMaxSpeedResult.getId()) {
            isNewBestMaxSpeed = true;
        } else {
            isNewBestMaxSpeed = false;
        }
        int averageSpeed = currentResult.getAverageSpeed();
        int bestAverageSpeed = bestAverageSpeedResult.getAverageSpeed();
        if (currentResult.getId() == bestAverageSpeedResult.getId()) {
            isNewBestAverageSpeed = true;
        } else {
            isNewBestAverageSpeed = false;
        }
        if (isViewAttached()) {
            ((ISpeedReadingPassCourseResultView) getView()).updateMaxSpeedView(maxSpeed);
            ((ISpeedReadingPassCourseResultView) getView()).updateBestMaxSpeedView(bestMaxSpeed);
            ((ISpeedReadingPassCourseResultView) getView()).setNewBestMaxSpeedViewVisibility(isNewBestMaxSpeed);
            ((ISpeedReadingPassCourseResultView) getView()).updateAverageSpeedView(averageSpeed);
            ((ISpeedReadingPassCourseResultView) getView()).updateBestAverageSpeedView(bestAverageSpeed);
            ((ISpeedReadingPassCourseResultView) getView()).setNewBestAverageSpeedViewVisibility(isNewBestAverageSpeed);
            ((ISpeedReadingPassCourseResultView) getView()).updatePassCoursePointsView(SpeedReadingScoreUtil.getPassCourseScore(maxSpeed));
        }
    }
}
