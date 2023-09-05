package com.safonov.speedreading.reader.reader.presenter;

import android.support.annotation.NonNull;
import android.text.TextPaint;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.reader.reader.view.IReaderView;

public interface IReaderPresenter extends MvpPresenter<IReaderView> {
    void init(int i, long j);

    void onBackPressed();

    void onGuideDialogClosed(boolean z);

    void onNavigationChapterSelected(int i);

    void onNavigationChapterViewClick();

    void onNavigationNextPageViewClick();

    void onNavigationPageSelected(int i);

    void onNavigationPageViewClick();

    void onNavigationPreviousPageViewClick();

    void onNavigationSeekBarPageChanged(int i);

    void onNavigationSeekBarPageSelected();

    void onPageViewCenterClick(boolean z);

    void onPageViewLeftClick();

    void onPageViewRightClick();

    void onPause();

    void onPencilFrameMinusClick();

    void onPencilFramePlusClick();

    void onReadingModeSelected(int i);

    void onResume();

    void onShowReadingModeDialogClick();

    void onStop();

    void onTimerModeCompletedDialogClosed();

    void onTimerModeDialogClosed();

    void requestToSplitBook(@NonNull TextPaint textPaint, int i, int i2);
}
