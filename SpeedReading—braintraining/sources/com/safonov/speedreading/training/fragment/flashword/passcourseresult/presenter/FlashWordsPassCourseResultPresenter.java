package com.safonov.speedreading.training.fragment.flashword.passcourseresult.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.flashword.passcourseresult.view.IFlashWordsPassCourseResultView;
import com.safonov.speedreading.training.fragment.flashword.repository.IFlashWordRepository;
import com.safonov.speedreading.training.fragment.flashword.repository.entity.FlashWordResult;

public class FlashWordsPassCourseResultPresenter extends MvpBasePresenter<IFlashWordsPassCourseResultView> implements IFlashWordsPassCourseResultPresenter {
    private IFlashWordRepository repository;

    public FlashWordsPassCourseResultPresenter(IFlashWordRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int resultId) {
        FlashWordResult result = this.repository.getResult(resultId);
        if (isViewAttached()) {
            ((IFlashWordsPassCourseResultView) getView()).updateTrainingDurationView(result.getConfig().getTrainingDuration());
        }
    }
}
