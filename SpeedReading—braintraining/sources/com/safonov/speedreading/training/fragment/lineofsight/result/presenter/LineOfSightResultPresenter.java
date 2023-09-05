package com.safonov.speedreading.training.fragment.lineofsight.result.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.lineofsight.repository.ILineOfSightRepository;
import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightResult;
import com.safonov.speedreading.training.fragment.lineofsight.result.view.ILineOfSightResultView;
import com.safonov.speedreading.training.util.ResultListUtil;
import java.util.List;

public class LineOfSightResultPresenter extends MvpBasePresenter<ILineOfSightResultView> implements ILineOfSightResultPresenter {
    private final ILineOfSightRepository repository;

    public LineOfSightResultPresenter(@NonNull ILineOfSightRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int resultId) {
        LineOfSightResult result = this.repository.getResult(resultId);
        List<LineOfSightResult> resultList = this.repository.getResultList(result.getConfig().getId());
        if (isViewAttached()) {
            ((ILineOfSightResultView) getView()).updateMistakesView(result.getMistakeCount());
            ((ILineOfSightResultView) getView()).updateFoundMistakesView(result.getFoundMistakeCount());
            ((ILineOfSightResultView) getView()).updateFoundMistakesPercentView(result.getFoundMistakesAccuracy());
            ((ILineOfSightResultView) getView()).setChartViewData(ResultListUtil.getLastPartOfList(resultList));
        }
    }
}
