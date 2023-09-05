package com.safonov.speedreading.training.fragment.schultetable.training.view;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import java.util.List;

public interface ISchulteTableView extends MvpView, SchulteTableTrainingCompleteListener {
    void initBoard(int i, int i2, boolean z);

    void itemTouchDown(int i, boolean z);

    void itemTouchUp(int i, boolean z);

    void setBoardItems(@NonNull List<String> list);

    void setBoardItemsEnable(boolean z);

    void updateBestTimeView(long j);

    void updateCurrentTimeView(long j);

    void updateNextItemView(String str);
}
