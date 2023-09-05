package com.safonov.speedreading.training.fragment.schultetable.result.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.schultetable.repository.ISchulteTableRepository;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableResult;
import com.safonov.speedreading.training.fragment.schultetable.result.view.ISchulteTableResultView;
import com.safonov.speedreading.training.util.ResultListUtil;
import java.util.List;

public class SchulteTableResultPresenter extends MvpBasePresenter<ISchulteTableResultView> implements ISchulteTableResultPresenter {
    private ISchulteTableRepository repository;

    public SchulteTableResultPresenter(@NonNull ISchulteTableRepository repository2) {
        this.repository = repository2;
    }

    public void initTrainingResults(int resultId) {
        SchulteTableResult result = this.repository.getResult(resultId);
        SchulteTableResult bestResult = this.repository.getBestResult(result.getConfig().getId());
        boolean isNewBest = result.getId() == bestResult.getId();
        List<SchulteTableResult> resultList = this.repository.getResultList(result.getConfig().getId());
        if (isViewAttached()) {
            ((ISchulteTableResultView) getView()).updateTimeView(result.getTime());
            ((ISchulteTableResultView) getView()).updateBestTimeView(bestResult.getTime());
            ((ISchulteTableResultView) getView()).setNewBestTimeViewVisibility(isNewBest);
            ((ISchulteTableResultView) getView()).setData(ResultListUtil.getLastPartOfList(resultList));
        }
    }
}
