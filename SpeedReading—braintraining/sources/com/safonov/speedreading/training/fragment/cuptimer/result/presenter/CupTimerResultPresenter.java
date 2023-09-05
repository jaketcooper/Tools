package com.safonov.speedreading.training.fragment.cuptimer.result.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.cuptimer.repository.ICupTimerRepository;
import com.safonov.speedreading.training.fragment.cuptimer.repository.entity.CupTimerResult;
import com.safonov.speedreading.training.fragment.cuptimer.result.view.ICupTimerResultView;
import com.safonov.speedreading.training.util.ResultListUtil;
import java.util.List;

public class CupTimerResultPresenter extends MvpBasePresenter<ICupTimerResultView> implements ICupTimerResultPresenter {
    private ICupTimerRepository repository;

    public CupTimerResultPresenter(ICupTimerRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int resultId) {
        CupTimerResult cupTimerResult = this.repository.getResult(resultId);
        List<CupTimerResult> resultList = this.repository.getResultList();
        if (isViewAttached()) {
            ((ICupTimerResultView) getView()).updateTrainingDurationView(cupTimerResult.getConfig().getDuration() * 2);
            ((ICupTimerResultView) getView()).setChartViewData(ResultListUtil.getLastPartOfList(resultList));
        }
    }
}
