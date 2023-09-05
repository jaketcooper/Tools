package com.safonov.speedreading.training.fragment.lineofsight.passcourseresult.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.lineofsight.passcourseresult.view.ILineOfSightPassCourseResultView;
import com.safonov.speedreading.training.fragment.lineofsight.repository.ILineOfSightRepository;
import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightResult;
import com.safonov.speedreading.training.fragment.passcource.util.LineOfSightScoreUtil;

public class LineOfSightPassCourseResultPresenter extends MvpBasePresenter<ILineOfSightPassCourseResultView> implements ILineOfSightPassCourseResultPresenter {
    private final ILineOfSightRepository repository;

    public LineOfSightPassCourseResultPresenter(@NonNull ILineOfSightRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int resultId) {
        LineOfSightResult result = this.repository.getResult(resultId);
        int passCoursePoints = LineOfSightScoreUtil.getPassCourseScore(result.getMistakeCount(), result.getFoundMistakeCount());
        if (isViewAttached()) {
            ((ILineOfSightPassCourseResultView) getView()).updateMistakesView(result.getMistakeCount());
            ((ILineOfSightPassCourseResultView) getView()).updateFoundMistakesView(result.getFoundMistakeCount());
            ((ILineOfSightPassCourseResultView) getView()).updateFoundMistakesPercentView(result.getFoundMistakesAccuracy());
            ((ILineOfSightPassCourseResultView) getView()).updatePassCoursePointsView(passCoursePoints);
        }
    }
}
