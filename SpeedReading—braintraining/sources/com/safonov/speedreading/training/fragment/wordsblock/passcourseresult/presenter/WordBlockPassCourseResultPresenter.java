package com.safonov.speedreading.training.fragment.wordsblock.passcourseresult.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.wordsblock.passcourseresult.view.IWordBlockPassCourseResultView;
import com.safonov.speedreading.training.fragment.wordsblock.repository.IWordBlockRepository;
import com.safonov.speedreading.training.fragment.wordsblock.repository.entity.WordBlockResult;

public class WordBlockPassCourseResultPresenter extends MvpBasePresenter<IWordBlockPassCourseResultView> implements IWordBlockPassCourseResultPresenter {
    private IWordBlockRepository repository;

    public WordBlockPassCourseResultPresenter(IWordBlockRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int resultId) {
        WordBlockResult result = this.repository.getResult(resultId);
        if (isViewAttached()) {
            ((IWordBlockPassCourseResultView) getView()).updateTrainingDurationView(result.getConfig().getTrainingDuration());
        }
    }
}
