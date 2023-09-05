package com.safonov.speedreading.training.fragment.greendot.passcourseresult.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.greendot.passcourseresult.view.IGreenDotPassCourseResultView;
import com.safonov.speedreading.training.fragment.greendot.repository.IGreenDotRepository;
import com.safonov.speedreading.training.fragment.passcource.util.GreenDotScoreUtil;

public class GreenDotPassCourseResultPresenter extends MvpBasePresenter<IGreenDotPassCourseResultView> implements IGreenDotPassCourseResultPresenter {
    private IGreenDotRepository repository;

    public GreenDotPassCourseResultPresenter(IGreenDotRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int resultId) {
        long duration = this.repository.getResult(resultId).getConfig().getDuration();
        if (isViewAttached()) {
            ((IGreenDotPassCourseResultView) getView()).updateTrainingDurationView(duration);
            ((IGreenDotPassCourseResultView) getView()).updatePassCoursePointsView(GreenDotScoreUtil.getPassCourseScore(duration));
        }
    }
}
