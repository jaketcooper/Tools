package com.safonov.speedreading.training.fragment.aceeleratorcourse.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.aceeleratorcourse.view.IAcceleratorCourseResultView;
import com.safonov.speedreading.training.fragment.flashword.repository.IFlashWordRepository;
import com.safonov.speedreading.training.fragment.wordsblock.repository.IWordBlockRepository;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.IWordsColumnsRepository;

public class AcceleratorCourseResultPresenter extends MvpBasePresenter<IAcceleratorCourseResultView> implements IAcceleratorCourseResultPresenter {
    private IFlashWordRepository flashWordRepository;
    private IWordBlockRepository wordBlockRepository;
    private IWordsColumnsRepository wordsColumnsRepository;

    public AcceleratorCourseResultPresenter(@NonNull IWordsColumnsRepository wordsColumnsRepository2, @NonNull IWordBlockRepository wordBlockRepository2, @NonNull IFlashWordRepository flashWordRepository2) {
        this.wordsColumnsRepository = wordsColumnsRepository2;
        this.wordBlockRepository = wordBlockRepository2;
        this.flashWordRepository = flashWordRepository2;
    }

    public void initTrainingResults(int[] resultIds) {
        long duration = 0;
        for (int i = 0; i <= 4; i++) {
            duration += this.wordsColumnsRepository.getResult(resultIds[i]).getConfig().getTrainingDuration();
        }
        for (int i2 = 5; i2 <= 7; i2++) {
            duration += this.flashWordRepository.getResult(resultIds[i2]).getConfig().getTrainingDuration();
        }
        long duration2 = duration + this.wordBlockRepository.getResult(resultIds[8]).getConfig().getTrainingDuration();
        if (isViewAttached()) {
            ((IAcceleratorCourseResultView) getView()).updateTrainingDurationView(duration2);
        }
    }
}
