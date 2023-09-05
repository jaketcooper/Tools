package com.safonov.speedreading.training.fragment.flashword.result.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.flashword.repository.IFlashWordRepository;
import com.safonov.speedreading.training.fragment.flashword.repository.entity.FlashWordResult;
import com.safonov.speedreading.training.fragment.flashword.result.view.IFlashWordsResultView;
import com.safonov.speedreading.training.util.ResultListUtil;
import java.util.List;

public class FlashWordsResultPresenter extends MvpBasePresenter<IFlashWordsResultView> implements IFlashWordsResultPresenter {
    private IFlashWordRepository repository;

    public FlashWordsResultPresenter(IFlashWordRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int resultId) {
        FlashWordResult result = this.repository.getResult(resultId);
        List<FlashWordResult> resultList = this.repository.getResultList();
        if (isViewAttached()) {
            ((IFlashWordsResultView) getView()).updateTrainingDurationView(result.getConfig().getTrainingDuration());
            ((IFlashWordsResultView) getView()).setChartViewData(ResultListUtil.getLastPartOfList(resultList));
        }
    }
}
