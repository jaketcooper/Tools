package com.safonov.speedreading.training.fragment.lineofsight.training.view;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import java.util.List;

public interface ILineOfSightView extends MvpView, LineOfSightTrainingCompleteListener {
    void cancelPreShowAnimation();

    void initBoardView(int i, int i2, int i3);

    void initProgressBar(int i);

    void setCheckButtonEnabled(boolean z);

    void setCheckedItemsData(@NonNull List<String> list);

    void setItemsData(@NonNull List<String> list);

    void startPreShowAnimation();

    void updateProgressBar(int i);
}
