package com.safonov.speedreading.training.fragment.flashword.training.view;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import java.util.List;

public interface IFlashWordsView extends MvpView {
    void initBoardView(int i);

    void onTrainingCompleted(int i);

    void setItemsEmptyText();

    void setItemsText(int i, @NonNull List<String> list);

    void updateLevelView(int i);

    void updateSpeedView(int i);

    void updateTimeView(long j);
}
