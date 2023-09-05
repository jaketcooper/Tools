package com.safonov.speedreading.training.fragment.speedreading.training.presenter;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.speedreading.repository.ISpeedReadingRepository;
import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingConfig;
import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingResult;
import com.safonov.speedreading.training.fragment.speedreading.training.model.ISpeedReadingModel;
import com.safonov.speedreading.training.fragment.speedreading.training.view.ISpeedReadingView;
import com.safonov.speedreading.training.fragment.speedreading.util.IndexesUtil;
import com.safonov.speedreading.training.fragment.speedreading.util.SpeedConverterUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SpeedReadingPresenter extends MvpBasePresenter<ISpeedReadingView> implements ISpeedReadingPresenter {
    private SpeedReadingConfig config;
    private int configId;
    private int currentSpeed;
    private int[] currentTrainingSpeeds;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    /* access modifiers changed from: private */
    public boolean isPaused;
    private boolean isShowingWords;
    /* access modifiers changed from: private */
    public List<String> items;
    private int maxSpeed;
    private ISpeedReadingModel model;
    private Random random = new Random();
    private ISpeedReadingRepository repository;
    private Runnable showWord = new Runnable() {
        private int getPreviousViewIndex(int currentViewIndex) {
            if (currentViewIndex == 0) {
                return 8;
            }
            int previousViewIndex = currentViewIndex - 1;
            if (previousViewIndex < 0) {
                return 0;
            }
            return previousViewIndex;
        }

        public void run() {
            if (SpeedReadingPresenter.this.isPaused || !SpeedReadingPresenter.this.isViewAttached()) {
                return;
            }
            if (SpeedReadingPresenter.this.wordIndex < SpeedReadingPresenter.this.wordsCount) {
                ((ISpeedReadingView) SpeedReadingPresenter.this.getView()).setWordItem(getPreviousViewIndex(SpeedReadingPresenter.this.viewIndex), "");
                ((ISpeedReadingView) SpeedReadingPresenter.this.getView()).setWordItem(SpeedReadingPresenter.this.viewIndex, (String) SpeedReadingPresenter.this.items.get(SpeedReadingPresenter.this.wordIndex));
                if (SpeedReadingPresenter.this.viewIndex < 8) {
                    SpeedReadingPresenter.access$308(SpeedReadingPresenter.this);
                } else {
                    int unused = SpeedReadingPresenter.this.viewIndex = 0;
                }
                SpeedReadingPresenter.access$108(SpeedReadingPresenter.this);
                SpeedReadingPresenter.this.handler.postDelayed(this, (long) SpeedReadingPresenter.this.wordShowingTime);
                return;
            }
            ((ISpeedReadingView) SpeedReadingPresenter.this.getView()).setWordItem(getPreviousViewIndex(SpeedReadingPresenter.this.viewIndex), "");
            int unused2 = SpeedReadingPresenter.this.viewIndex = 0;
            int unused3 = SpeedReadingPresenter.this.wordIndex = 0;
            SpeedReadingPresenter.this.showAnswer();
        }
    };
    private int trainingShowingCount;
    private int trueAnswerIndex;
    /* access modifiers changed from: private */
    public int viewIndex;
    /* access modifiers changed from: private */
    public int wordIndex;
    /* access modifiers changed from: private */
    public int wordShowingTime;
    /* access modifiers changed from: private */
    public int wordsCount;

    static /* synthetic */ int access$108(SpeedReadingPresenter x0) {
        int i = x0.wordIndex;
        x0.wordIndex = i + 1;
        return i;
    }

    static /* synthetic */ int access$308(SpeedReadingPresenter x0) {
        int i = x0.viewIndex;
        x0.viewIndex = i + 1;
        return i;
    }

    public SpeedReadingPresenter(@NonNull ISpeedReadingModel model2, @NonNull ISpeedReadingRepository repository2) {
        this.model = model2;
        this.repository = repository2;
    }

    public void startTraining(int configId2) {
        this.configId = configId2;
        this.config = this.repository.getConfig(configId2);
        ((ISpeedReadingView) getView()).showWordsView();
        ((ISpeedReadingView) getView()).initProgressBar(this.config.getTrainingShowCount());
        ((ISpeedReadingView) getView()).updateProgressBar(0);
        this.currentSpeed = this.config.getSpeed();
        this.maxSpeed = this.currentSpeed;
        this.currentTrainingSpeeds = new int[this.config.getTrainingShowCount()];
        this.wordShowingTime = SpeedConverterUtil.getWordShowingTime(this.currentSpeed);
        showWords();
    }

    private void showWords() {
        this.isShowingWords = true;
        ((ISpeedReadingView) getView()).showWordsView();
        ((ISpeedReadingView) getView()).hideAnswerView();
        ((ISpeedReadingView) getView()).updateProgressBar(this.trainingShowingCount);
        ((ISpeedReadingView) getView()).updateSpeed(this.currentSpeed);
        this.currentTrainingSpeeds[this.trainingShowingCount] = this.currentSpeed;
        do {
            this.wordsCount = this.random.nextInt(this.config.getMaxWordShowCount() + 1);
        } while (this.wordsCount < this.config.getMinWordShowCount());
        this.items = this.model.createItems(this.wordsCount);
        this.handler.post(this.showWord);
    }

    /* access modifiers changed from: private */
    public void showAnswer() {
        this.isShowingWords = false;
        if (isViewAttached()) {
            ((ISpeedReadingView) getView()).hideWordsView();
            ((ISpeedReadingView) getView()).showAnswerView();
            ((ISpeedReadingView) getView()).setAnswerButtonsEnabled(true);
            int[] falseAnswersIndexes = IndexesUtil.generateUniqueIndexes((this.wordsCount - 1) - 1, 5);
            List<String> answers = new ArrayList<>(6);
            answers.add(this.items.get(this.wordsCount - 1));
            for (int index : falseAnswersIndexes) {
                answers.add(this.items.get(index));
            }
            this.trueAnswerIndex = new Random().nextInt(6);
            Collections.swap(answers, 0, this.trueAnswerIndex);
            ((ISpeedReadingView) getView()).updateAnswerSpeed(this.currentSpeed);
            ((ISpeedReadingView) getView()).setAnswerItems(answers);
        }
    }

    public void cancelTraining() {
        this.isPaused = true;
        this.handler.removeCallbacks(this.showWord);
        this.items = null;
        this.handler = null;
        this.repository = null;
        this.model = null;
    }

    public void pauseTraining() {
        this.isPaused = true;
    }

    public void resumeTraining() {
        this.isPaused = false;
        if (this.isShowingWords) {
            this.viewIndex--;
            if (this.viewIndex < 0) {
                this.viewIndex = 8;
            }
            ((ISpeedReadingView) getView()).setWordItem(this.viewIndex, "");
            this.wordIndex = 0;
            this.viewIndex = 0;
            showWords();
        }
    }

    public void answerButtonClick(int index) {
        if (isViewAttached()) {
            boolean isTrueAnswer = index == this.trueAnswerIndex;
            if (isTrueAnswer) {
                this.currentSpeed += this.config.getSpeedStep();
                if (this.currentSpeed > this.maxSpeed) {
                    this.maxSpeed = this.currentSpeed;
                }
            } else {
                this.currentSpeed -= this.config.getSpeedStep();
                if (this.currentSpeed < this.config.getMinSpeed()) {
                    this.currentSpeed = this.config.getMinSpeed();
                }
            }
            this.wordShowingTime = SpeedConverterUtil.getWordShowingTime(this.currentSpeed);
            ((ISpeedReadingView) getView()).setAnswerButtonsEnabled(false);
            ((ISpeedReadingView) getView()).updateAnswerSpeedWithAnimation(this.currentSpeed, isTrueAnswer);
        }
    }

    private int getAverageSpeed(int[] speeds) {
        int result = 0;
        for (int speed : speeds) {
            result += speed;
        }
        return result / speeds.length;
    }

    public void answerAnimationEnded() {
        this.trainingShowingCount++;
        if (this.trainingShowingCount == this.config.getTrainingShowCount()) {
            SpeedReadingResult result = new SpeedReadingResult();
            result.setMaxSpeed(this.maxSpeed);
            result.setAverageSpeed(getAverageSpeed(this.currentTrainingSpeeds));
            result.setUnixTime(System.currentTimeMillis());
            this.repository.updateConfigSpeed(this.configId, this.currentSpeed);
            this.repository.addResult(result, this.configId, new ISpeedReadingRepository.OnSingleTransactionCallback() {
                public void onTransactionCompleted(int id) {
                    if (SpeedReadingPresenter.this.isViewAttached()) {
                        ((ISpeedReadingView) SpeedReadingPresenter.this.getView()).onSpeedReadingTrainingCompleted(id);
                    }
                }
            });
            return;
        }
        showWords();
    }
}
