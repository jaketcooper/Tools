package com.safonov.speedreading.training.fragment.remembernumber.training.presenter;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.remembernumber.repository.IRememberNumberRepository;
import com.safonov.speedreading.training.fragment.remembernumber.repository.entity.RememberNumberConfig;
import com.safonov.speedreading.training.fragment.remembernumber.repository.entity.RememberNumberResult;
import com.safonov.speedreading.training.fragment.remembernumber.training.model.IRememberNumberModel;
import com.safonov.speedreading.training.fragment.remembernumber.training.view.IRememberNumberView;

public class RememberNumberPresenter extends MvpBasePresenter<IRememberNumberView> implements IRememberNumberPresenter {
    private static final int BLINK_DURATION = 200;
    private static final int PRE_SHOW_DURATION = 750;
    private static final int SHOW_NUMBER_DURATION = 500;
    private RememberNumberResult bestResult;
    /* access modifiers changed from: private */
    public Runnable blinkRunnable = new Runnable() {
        public void run() {
            if (!RememberNumberPresenter.this.isPaused) {
                if (RememberNumberPresenter.this.isViewAttached()) {
                    ((IRememberNumberView) RememberNumberPresenter.this.getView()).setBlinkCardsTextColor();
                }
                RememberNumberPresenter.this.handler.postDelayed(RememberNumberPresenter.this.showNumberRunnable, 200);
            }
        }
    };
    private int cardIndex;
    /* access modifiers changed from: private */
    public int complexity;
    /* access modifiers changed from: private */
    public RememberNumberConfig config;
    /* access modifiers changed from: private */
    public int configId;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    /* access modifiers changed from: private */
    public boolean isPaused;
    /* access modifiers changed from: private */
    public IRememberNumberModel model;
    /* access modifiers changed from: private */
    public boolean numberHasShown;
    /* access modifiers changed from: private */
    public Runnable postShowNumberRunnable = new Runnable() {
        public void run() {
            if (!RememberNumberPresenter.this.isPaused && RememberNumberPresenter.this.isViewAttached()) {
                ((IRememberNumberView) RememberNumberPresenter.this.getView()).setCardsDefaultValues();
                ((IRememberNumberView) RememberNumberPresenter.this.getView()).setButtonsEnabled(true);
                boolean unused = RememberNumberPresenter.this.numberHasShown = true;
            }
        }
    };
    private Runnable preShowNumberRunnable = new Runnable() {
        public void run() {
            boolean unused = RememberNumberPresenter.this.numberHasShown = false;
            if (!RememberNumberPresenter.this.isPaused) {
                if (RememberNumberPresenter.this.showCount == RememberNumberPresenter.this.config.getTrainingShowCount()) {
                    RememberNumberResult result = new RememberNumberResult();
                    result.setScore(RememberNumberPresenter.this.score);
                    result.setUnixTime(System.currentTimeMillis());
                    RememberNumberPresenter.this.repository.updateConfigComplexity(RememberNumberPresenter.this.configId, RememberNumberPresenter.this.complexity);
                    RememberNumberPresenter.this.repository.addResult(result, RememberNumberPresenter.this.configId, new IRememberNumberRepository.OnSingleTransactionCallback() {
                        public void onTransactionCompleted(int id) {
                            if (RememberNumberPresenter.this.isViewAttached()) {
                                ((IRememberNumberView) RememberNumberPresenter.this.getView()).onRememberNumberTrainingCompleted(id);
                            }
                        }
                    });
                    boolean unused2 = RememberNumberPresenter.this.isPaused = true;
                    return;
                }
                if (RememberNumberPresenter.this.isViewAttached()) {
                    ((IRememberNumberView) RememberNumberPresenter.this.getView()).setCardViews(RememberNumberPresenter.this.complexity);
                    ((IRememberNumberView) RememberNumberPresenter.this.getView()).setCardsDefaultBackground();
                    ((IRememberNumberView) RememberNumberPresenter.this.getView()).setCardsDefaultTextColor();
                    ((IRememberNumberView) RememberNumberPresenter.this.getView()).setCardsDefaultValues();
                }
                RememberNumberPresenter.this.handler.postDelayed(RememberNumberPresenter.this.blinkRunnable, 750);
            }
        }
    };
    /* access modifiers changed from: private */
    public IRememberNumberRepository repository;
    /* access modifiers changed from: private */
    public int score;
    /* access modifiers changed from: private */
    public int showCount;
    /* access modifiers changed from: private */
    public Runnable showNumberRunnable = new Runnable() {
        public void run() {
            if (!RememberNumberPresenter.this.isPaused) {
                String[] unused = RememberNumberPresenter.this.userAnswer = new String[RememberNumberPresenter.this.complexity];
                String[] unused2 = RememberNumberPresenter.this.trueAnswer = RememberNumberPresenter.this.model.createNumber(RememberNumberPresenter.this.complexity);
                if (RememberNumberPresenter.this.isViewAttached()) {
                    ((IRememberNumberView) RememberNumberPresenter.this.getView()).setCardsDefaultTextColor();
                    ((IRememberNumberView) RememberNumberPresenter.this.getView()).setCardsValues(RememberNumberPresenter.this.trueAnswer);
                }
                RememberNumberPresenter.this.handler.postDelayed(RememberNumberPresenter.this.postShowNumberRunnable, 500);
            }
        }
    };
    /* access modifiers changed from: private */
    public String[] trueAnswer;
    private int trueAnswerCount;
    /* access modifiers changed from: private */
    public String[] userAnswer;

    public RememberNumberPresenter(@NonNull IRememberNumberModel model2, @NonNull IRememberNumberRepository repository2) {
        this.model = model2;
        this.repository = repository2;
    }

    public void startTraining(int configId2) {
        this.configId = configId2;
        this.config = this.repository.getConfig(configId2);
        this.bestResult = this.repository.getBestResult(configId2);
        this.complexity = this.config.getComplexity();
        ((IRememberNumberView) getView()).updateScoreView(0);
        ((IRememberNumberView) getView()).updateBestScoreView(this.bestResult == null ? 0 : this.bestResult.getScore());
        ((IRememberNumberView) getView()).initProgressBar(this.config.getTrainingShowCount());
        ((IRememberNumberView) getView()).updateProgressBar(0);
        ((IRememberNumberView) getView()).setCardViews(this.complexity);
        ((IRememberNumberView) getView()).setCardsDefaultBackground();
        ((IRememberNumberView) getView()).setCardsDefaultValues();
        ((IRememberNumberView) getView()).setCardsDefaultTextColor();
        ((IRememberNumberView) getView()).setButtonsEnabled(false);
        this.handler.postDelayed(this.preShowNumberRunnable, 750);
    }

    public void cancelTraining() {
        this.handler.removeCallbacks(this.preShowNumberRunnable);
        this.handler.removeCallbacks(this.showNumberRunnable);
        this.handler.removeCallbacks(this.postShowNumberRunnable);
        this.handler.removeCallbacks(this.blinkRunnable);
        this.handler = null;
        this.model = null;
        this.userAnswer = null;
        this.trueAnswer = null;
    }

    public void pauseTraining() {
        this.isPaused = true;
    }

    public void resumeTraining() {
        this.isPaused = false;
        if (!this.numberHasShown) {
            this.handler.postDelayed(this.preShowNumberRunnable, 750);
        }
    }

    public void onNumberButtonPressed(String value) {
        this.userAnswer[this.cardIndex] = value;
        ((IRememberNumberView) getView()).setCardValueAt(this.cardIndex, value);
        this.cardIndex++;
        if (this.cardIndex == this.complexity) {
            this.showCount++;
            this.cardIndex = 0;
            boolean isTrueAnswer = true;
            for (int i = 0; i < this.complexity; i++) {
                if (this.userAnswer[i].equals(this.trueAnswer[i])) {
                    this.score++;
                    ((IRememberNumberView) getView()).setCardAnswerBackgroundAt(i, true);
                } else {
                    isTrueAnswer = false;
                    this.score--;
                    ((IRememberNumberView) getView()).setCardAnswerBackgroundAt(i, false);
                }
            }
            if (this.score < 0) {
                this.score = 0;
            }
            if (isTrueAnswer) {
                this.trueAnswerCount++;
            } else {
                this.trueAnswerCount--;
            }
            if (this.trueAnswerCount == this.config.getAnswersToComplexityDown()) {
                if (this.complexity > this.config.getMinComplexity()) {
                    this.complexity--;
                }
                this.trueAnswerCount = 0;
            }
            if (this.trueAnswerCount == this.config.getAnswersToComplexityUp()) {
                if (this.complexity < this.config.getMaxComplexity()) {
                    this.complexity++;
                }
                this.trueAnswerCount = 0;
            }
            ((IRememberNumberView) getView()).updateScoreView(this.score);
            ((IRememberNumberView) getView()).setButtonsEnabled(false);
            ((IRememberNumberView) getView()).updateProgressBar(this.showCount);
            this.handler.postDelayed(this.preShowNumberRunnable, 750);
        }
    }

    public void onBackspaceButtonPressed() {
        if (this.cardIndex > 0) {
            this.cardIndex--;
            if (isViewAttached()) {
                ((IRememberNumberView) getView()).sedDefaultCardValueAt(this.cardIndex);
            }
        }
    }
}
