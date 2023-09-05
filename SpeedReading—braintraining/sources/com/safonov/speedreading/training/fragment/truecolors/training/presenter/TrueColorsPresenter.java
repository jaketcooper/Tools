package com.safonov.speedreading.training.fragment.truecolors.training.presenter;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.truecolors.repository.ITrueColorsRepository;
import com.safonov.speedreading.training.fragment.truecolors.repository.entity.TrueColorsConfig;
import com.safonov.speedreading.training.fragment.truecolors.repository.entity.TrueColorsResult;
import com.safonov.speedreading.training.fragment.truecolors.training.model.TrueColorsModel;
import com.safonov.speedreading.training.fragment.truecolors.training.view.ITrueColorsView;
import java.util.Collections;
import java.util.List;

public class TrueColorsPresenter extends MvpBasePresenter<ITrueColorsView> implements ITrueColorsPresenter {
    public static final int ANSWER_DURATION = 300;
    public static final int DEFAULT_INCORRECT_ANSWER_CORRECTION = 1000;
    public static final int DEFAULT_LEVEL_DURATION = 5000;
    public static final int PRE_SHOW_DURATION = 0;
    public static final int SHOW_COUNT = 50;
    List<TrueColorsModel> answerColors;
    private TrueColorsResult bestResult;
    List<TrueColorsModel> colors;
    private TrueColorsConfig config;
    private int configId;
    TrueColorsModel currentColor;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    private ITrueColorsRepository repository;
    int score = 0;
    private Runnable showCorrectAnswer = new Runnable() {
        public void run() {
            ((ITrueColorsView) TrueColorsPresenter.this.getView()).setAnswerImage(true);
            ((ITrueColorsView) TrueColorsPresenter.this.getView()).timerPause();
            ((ITrueColorsView) TrueColorsPresenter.this.getView()).disableButtons();
            TrueColorsPresenter trueColorsPresenter = TrueColorsPresenter.this;
            trueColorsPresenter.score = ((int) (5000 / ((ITrueColorsView) TrueColorsPresenter.this.getView()).getProgress())) + trueColorsPresenter.score;
            TrueColorsPresenter.this.handler.postDelayed(TrueColorsPresenter.this.showWords, 300);
        }
    };
    int showCount = 0;
    private Runnable showIncorrectAnswer = new Runnable() {
        public void run() {
            ((ITrueColorsView) TrueColorsPresenter.this.getView()).setAnswerImage(false);
            ((ITrueColorsView) TrueColorsPresenter.this.getView()).timerPause();
            ((ITrueColorsView) TrueColorsPresenter.this.getView()).disableButtons();
            TrueColorsPresenter.this.score -= (int) (1 + (((ITrueColorsView) TrueColorsPresenter.this.getView()).getProgress() / 1000));
            TrueColorsPresenter.this.handler.postDelayed(TrueColorsPresenter.this.showWords, 300);
        }
    };
    /* access modifiers changed from: private */
    public Runnable showWords = new Runnable() {
        public void run() {
            ((ITrueColorsView) TrueColorsPresenter.this.getView()).hideAnswerImage();
            if (TrueColorsPresenter.this.score < 0) {
                TrueColorsPresenter.this.score = 0;
            }
            if (TrueColorsPresenter.this.showCount == 50) {
                TrueColorsPresenter.this.finishTraining();
                return;
            }
            TrueColorsPresenter.this.answerColors = TrueColorsPresenter.this.getAnswers();
            ((ITrueColorsView) TrueColorsPresenter.this.getView()).showLevel(TrueColorsPresenter.this.currentColor, TrueColorsPresenter.this.answerColors);
            ((ITrueColorsView) TrueColorsPresenter.this.getView()).updateScoreView(TrueColorsPresenter.this.score);
            ((ITrueColorsView) TrueColorsPresenter.this.getView()).updateProgressBar(TrueColorsPresenter.this.showCount);
            ((ITrueColorsView) TrueColorsPresenter.this.getView()).timerStart();
            ((ITrueColorsView) TrueColorsPresenter.this.getView()).enableButtons();
        }
    };

    public TrueColorsPresenter(@NonNull ITrueColorsRepository repository2) {
        this.repository = repository2;
    }

    public void startTraining(int configId2) {
        this.configId = configId2;
        this.config = this.repository.getConfig(configId2);
        this.bestResult = this.repository.getBestResult(configId2);
        ((ITrueColorsView) getView()).updateScoreView(0);
        ((ITrueColorsView) getView()).updateBestScoreView(this.bestResult == null ? 0 : this.bestResult.getScore());
        ((ITrueColorsView) getView()).initProgressBar(50);
        ((ITrueColorsView) getView()).updateProgressBar(0);
        this.colors = ((ITrueColorsView) getView()).getColors();
        this.answerColors = getAnswers();
        ((ITrueColorsView) getView()).showLevel(this.currentColor, this.answerColors);
        ((ITrueColorsView) getView()).initCountDownTimer(5000);
    }

    public List<TrueColorsModel> getAnswers() {
        Collections.shuffle(this.colors);
        List<TrueColorsModel> answers = this.colors.subList(0, 4);
        this.currentColor = answers.get(0);
        Collections.shuffle(answers);
        return answers;
    }

    public void cancelTraining() {
        this.handler.removeCallbacks(this.showCorrectAnswer);
        this.handler.removeCallbacks(this.showIncorrectAnswer);
        this.handler.removeCallbacks(this.showWords);
        this.handler = null;
    }

    public void pauseTraining() {
        ((ITrueColorsView) getView()).timerPause();
        ((ITrueColorsView) getView()).disableButtons();
    }

    public void resumeTraining() {
        ((ITrueColorsView) getView()).timerStart();
        ((ITrueColorsView) getView()).enableButtons();
        this.answerColors = getAnswers();
        ((ITrueColorsView) getView()).showLevel(this.currentColor, this.answerColors);
    }

    public void finishTraining() {
        TrueColorsResult result = new TrueColorsResult();
        result.setScore(this.score);
        this.repository.addResult(result, this.configId, new ITrueColorsRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                if (TrueColorsPresenter.this.isViewAttached()) {
                    ((ITrueColorsView) TrueColorsPresenter.this.getView()).onTrueColorsTrainingCompleted(id);
                }
            }
        });
    }

    public void onNumberButtonPressed(TrueColorsModel rightAnswer, String answerText) {
        this.showCount++;
        if (rightAnswer.getColorName().equals(answerText)) {
            this.handler.postDelayed(this.showCorrectAnswer, 0);
        } else {
            this.handler.postDelayed(this.showIncorrectAnswer, 0);
        }
    }
}
