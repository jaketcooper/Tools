package com.safonov.speedreading.training.fragment.wordscolumns.passcourseresult.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.wordscolumns.passcourseresult.view.IWordColumnsCourseResultView;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.IWordsColumnsRepository;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.entity.WordsColumnsResult;

public class WordColumnsCourseResultPresenter extends MvpBasePresenter<IWordColumnsCourseResultView> implements IWordColumnsCourseResultPresenter {
    private IWordsColumnsRepository repository;

    public WordColumnsCourseResultPresenter(IWordsColumnsRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int resultId) {
        WordsColumnsResult result = this.repository.getResult(resultId);
        if (isViewAttached()) {
            ((IWordColumnsCourseResultView) getView()).updateTrainingDurationView(result.getConfig().getTrainingDuration());
        }
    }
}
