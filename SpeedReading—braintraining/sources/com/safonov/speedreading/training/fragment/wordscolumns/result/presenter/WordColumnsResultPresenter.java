package com.safonov.speedreading.training.fragment.wordscolumns.result.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.IWordsColumnsRepository;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.entity.WordsColumnsResult;
import com.safonov.speedreading.training.fragment.wordscolumns.result.view.IWordColumnsResultView;
import com.safonov.speedreading.training.util.ResultListUtil;
import java.util.List;

public class WordColumnsResultPresenter extends MvpBasePresenter<IWordColumnsResultView> implements IWordColumnsResultPresenter {
    private IWordsColumnsRepository repository;

    public WordColumnsResultPresenter(IWordsColumnsRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int resultId) {
        WordsColumnsResult result = this.repository.getResult(resultId);
        List<WordsColumnsResult> resultList = this.repository.getResultList();
        if (isViewAttached()) {
            ((IWordColumnsResultView) getView()).updateTrainingDurationView(result.getConfig().getTrainingDuration());
            ((IWordColumnsResultView) getView()).setChartViewData(ResultListUtil.getLastPartOfList(resultList));
        }
    }
}
