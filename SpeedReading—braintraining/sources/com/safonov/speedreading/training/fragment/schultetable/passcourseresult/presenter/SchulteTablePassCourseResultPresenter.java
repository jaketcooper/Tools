package com.safonov.speedreading.training.fragment.schultetable.passcourseresult.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.passcource.util.SchulteTableScoreUtil;
import com.safonov.speedreading.training.fragment.schultetable.passcourseresult.view.ISchulteTablePassCourseResultView;
import com.safonov.speedreading.training.fragment.schultetable.repository.ISchulteTableRepository;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableResult;

public class SchulteTablePassCourseResultPresenter extends MvpBasePresenter<ISchulteTablePassCourseResultView> implements ISchulteTablePassCourseResultPresenter {
    private ISchulteTableRepository repository;

    public SchulteTablePassCourseResultPresenter(@NonNull ISchulteTableRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int resultId) {
        SchulteTableResult result = this.repository.getResult(resultId);
        SchulteTableResult bestResult = this.repository.getBestResult(result.getConfig().getId());
        boolean isNewBest = result.getId() == bestResult.getId();
        if (isViewAttached()) {
            ((ISchulteTablePassCourseResultView) getView()).updateTimeView(result.getTime());
            ((ISchulteTablePassCourseResultView) getView()).updateBestTimeView(bestResult.getTime());
            ((ISchulteTablePassCourseResultView) getView()).setNewBestTimeViewVisibility(isNewBest);
            ((ISchulteTablePassCourseResultView) getView()).updatePassCoursePointsView(SchulteTableScoreUtil.getPassCourseScore(result.getTime()));
        }
    }
}
