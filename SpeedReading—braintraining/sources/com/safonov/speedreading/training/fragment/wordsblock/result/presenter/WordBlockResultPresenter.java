package com.safonov.speedreading.training.fragment.wordsblock.result.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.wordsblock.repository.IWordBlockRepository;
import com.safonov.speedreading.training.fragment.wordsblock.repository.entity.WordBlockResult;
import com.safonov.speedreading.training.fragment.wordsblock.result.view.IWordBlockResultView;
import com.safonov.speedreading.training.util.ResultListUtil;
import java.util.List;

public class WordBlockResultPresenter extends MvpBasePresenter<IWordBlockResultView> implements IWordBlockResultPresenter {
    private IWordBlockRepository repository;

    public WordBlockResultPresenter(IWordBlockRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int resultId) {
        WordBlockResult result = this.repository.getResult(resultId);
        List<WordBlockResult> resultList = this.repository.getResultList();
        if (isViewAttached()) {
            ((IWordBlockResultView) getView()).updateTrainingDurationView(result.getConfig().getTrainingDuration());
            ((IWordBlockResultView) getView()).setChartViewData(ResultListUtil.getLastPartOfList(resultList));
        }
    }
}
