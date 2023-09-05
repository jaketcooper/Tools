package com.safonov.speedreading.training.fragment.evennumbers.training.view;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.training.fragment.evennumbers.training.model.NumberWrapper;
import java.util.List;

public interface IEvenNumbersView extends MvpView, EvenNumbersTrainingCompleteListener {
    void initBoard(int i, int i2);

    void initProgressBar(int i);

    void itemTouchDown(int i, boolean z);

    void itemTouchUp(int i, boolean z);

    void setBoardItems(@NonNull List<NumberWrapper> list);

    void setBoardItemsEnable(boolean z);

    void updateProgressBar(int i);

    void updateRecord(int i);

    void updateScore(int i);
}
