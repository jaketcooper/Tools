package com.safonov.speedreading.reader.reader.view;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.reader.reader.model.TimerModeModel;

public interface IReaderView extends MvpView {
    void dismissProgressDialog();

    void finish();

    void hideActionBar();

    void initNavigationSeekBar(int i);

    void initProgressViewProgress(int i);

    void onRequestToGetTextViewData();

    void seNavigationViewVisibility(boolean z);

    void setActionBarSelectReadingModeVisibility(boolean z);

    void setActionBarTitle(String str);

    void setAd();

    void setBookPurchaseActivity();

    void setCourseActivityResult(boolean z);

    void setNavigationChapterView(String str);

    void setNavigationPageView(int i, int i2);

    void setNavigationSeekBar(int i);

    void setPageView(int i, int i2);

    void setPencilFrameLineCountView(int i);

    void setPencilFrameView(int i, int i2);

    void setPencilFrameViewVisibility(boolean z);

    void setPrimaryTextColor();

    void setProgressViewProgress(int i);

    void setProgressViewVisibility(boolean z);

    void setSecondaryTextColor();

    void setSpeedView(int i);

    void setSpeedViewVisibility(boolean z);

    void setText(CharSequence charSequence);

    void setTimerView(long j);

    void setTimerViewVisibility(boolean z);

    void showActionBar();

    void showErrorMessage();

    void showExitDialog();

    void showGuideDialog();

    void showProgressDialog();

    void showPurchasePremiumDialog();

    void showSelectChapterDialog(String[] strArr);

    void showSelectPageDialog(int i, int i2);

    void showSelectReadingModeDialog(int i);

    void showTimerModeCompletedDialog(@NonNull TimerModeModel[] timerModeModelArr);

    void showTimerModeDialog(@NonNull TimerModeModel[] timerModeModelArr);
}
