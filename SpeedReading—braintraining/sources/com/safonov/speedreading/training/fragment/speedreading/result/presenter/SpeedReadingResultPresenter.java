package com.safonov.speedreading.training.fragment.speedreading.result.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.speedreading.repository.ISpeedReadingRepository;
import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingResult;
import com.safonov.speedreading.training.fragment.speedreading.result.view.ISpeedReadingResultView;
import com.safonov.speedreading.training.util.ResultListUtil;
import java.util.List;

public class SpeedReadingResultPresenter extends MvpBasePresenter<ISpeedReadingResultView> implements ISpeedReadingResultPresenter {
    private ISpeedReadingRepository repository;

    public SpeedReadingResultPresenter(@NonNull ISpeedReadingRepository repository2) {
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
        if (isViewAttached()) {
            ((ISpeedReadingResultView) getView()).updateMaxSpeedView(maxSpeed);
            ((ISpeedReadingResultView) getView()).updateBestMaxSpeedView(bestMaxSpeed);
            ((ISpeedReadingResultView) getView()).setNewBestMaxSpeedViewVisibility(isNewBestMaxSpeed);
        }
        int averageSpeed = currentResult.getAverageSpeed();
        int bestAverageSpeed = bestAverageSpeedResult.getAverageSpeed();
        if (currentResult.getId() == bestAverageSpeedResult.getId()) {
            isNewBestAverageSpeed = true;
        } else {
            isNewBestAverageSpeed = false;
        }
        if (isViewAttached()) {
            ((ISpeedReadingResultView) getView()).updateAverageSpeedView(averageSpeed);
            ((ISpeedReadingResultView) getView()).updateBestAverageSpeedView(bestAverageSpeed);
            ((ISpeedReadingResultView) getView()).setNewBestAverageSpeedViewVisibility(isNewBestAverageSpeed);
        }
        List<SpeedReadingResult> resultList = this.repository.getResultList(currentResult.getConfig().getId());
        if (isViewAttached()) {
            ((ISpeedReadingResultView) getView()).setChartViewData(ResultListUtil.getLastPartOfList(resultList));
        }
    }
}
