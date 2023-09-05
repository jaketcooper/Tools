package com.safonov.speedreading.training.fragment.schultetable.result.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableResult;
import java.util.List;

public interface ISchulteTableResultView extends MvpView {
    void setData(List<SchulteTableResult> list);

    void setNewBestTimeViewVisibility(boolean z);

    void updateBestTimeView(long j);

    void updateTimeView(long j);
}
