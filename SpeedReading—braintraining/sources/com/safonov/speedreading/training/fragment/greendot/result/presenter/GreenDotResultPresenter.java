package com.safonov.speedreading.training.fragment.greendot.result.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.greendot.repository.IGreenDotRepository;
import com.safonov.speedreading.training.fragment.greendot.repository.entity.GreenDotResult;
import com.safonov.speedreading.training.fragment.greendot.result.view.IGreenDotResultView;
import com.safonov.speedreading.training.util.ResultListUtil;
import java.util.List;

public class GreenDotResultPresenter extends MvpBasePresenter<IGreenDotResultView> implements IGreenDotResultPresenter {
    private IGreenDotRepository repository;

    public GreenDotResultPresenter(IGreenDotRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int resultId) {
        GreenDotResult greenDotResult = this.repository.getResult(resultId);
        List<GreenDotResult> resultList = this.repository.getResultList();
        if (isViewAttached()) {
            ((IGreenDotResultView) getView()).updateTrainingDurationView(greenDotResult.getConfig().getDuration());
            ((IGreenDotResultView) getView()).setChartViewData(ResultListUtil.getLastPartOfList(resultList));
        }
    }
}
