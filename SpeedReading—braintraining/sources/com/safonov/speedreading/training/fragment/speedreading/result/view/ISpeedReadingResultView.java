package com.safonov.speedreading.training.fragment.speedreading.result.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingResult;
import java.util.List;

public interface ISpeedReadingResultView extends MvpView {
    void setChartViewData(List<SpeedReadingResult> list);

    void setNewBestAverageSpeedViewVisibility(boolean z);

    void setNewBestMaxSpeedViewVisibility(boolean z);

    void updateAverageSpeedView(int i);

    void updateBestAverageSpeedView(int i);

    void updateBestMaxSpeedView(int i);

    void updateMaxSpeedView(int i);
}
