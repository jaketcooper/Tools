package com.safonov.speedreading.training.fragment.wordsblock.training.presenter;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.application.util.timeticker.TimeDownTicker;
import com.safonov.speedreading.training.fragment.speedreading.util.SpeedConverterUtil;
import com.safonov.speedreading.training.fragment.wordsblock.repository.IWordBlockRepository;
import com.safonov.speedreading.training.fragment.wordsblock.repository.entity.WordBlockConfig;
import com.safonov.speedreading.training.fragment.wordsblock.repository.entity.WordBlockResult;
import com.safonov.speedreading.training.fragment.wordsblock.training.view.IWordBlockView;
import com.speedreading.alexander.speedreading.R;
import java.util.Random;

public class WordBlockPresenter extends MvpBasePresenter<IWordBlockView> implements IWordBlockPresenter {
    private static final int MAX_SPEED = 3000;
    private static final int MAX_WORD_COUNT = 80;
    private static final int MIN_SPEED = 100;
    private static final int MIN_WORD_COUNT = 1;
    private static final int SPEED_STEP = 50;
    private WordBlockConfig config;
    private long currentPlayedTime;
    /* access modifiers changed from: private */
    public int delay;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    private Random random = new Random();
    /* access modifiers changed from: private */
    public IWordBlockRepository repository;
    /* access modifiers changed from: private */
    public int speed;
    private TimeDownTicker timeTicker = new TimeDownTicker();
    /* access modifiers changed from: private */
    public boolean trainingPaused;
    /* access modifiers changed from: private */
    public int wordCount;
    /* access modifiers changed from: private */
    public Runnable wordSelectorRunnable = new Runnable() {
        public void run() {
            if (!WordBlockPresenter.this.trainingPaused && WordBlockPresenter.this.isViewAttached()) {
                ((IWordBlockView) WordBlockPresenter.this.getView()).setWordBlockItemText(WordBlockPresenter.this.getWordBlockText(WordBlockPresenter.this.wordCount));
                WordBlockPresenter.this.handler.postDelayed(this, (long) WordBlockPresenter.this.delay);
            }
        }
    };
    private String[] words;

    public WordBlockPresenter(@NonNull Context context, @NonNull IWordBlockRepository repository2) {
        this.words = context.getResources().getStringArray(R.array.speed_reading_words);
        this.repository = repository2;
    }

    public void init(final int configId) {
        this.config = this.repository.getConfig(configId);
        this.speed = this.config.getSpeed();
        this.wordCount = this.config.getWordCount();
        this.currentPlayedTime = this.config.getTrainingDuration();
        this.delay = SpeedConverterUtil.getWordShowingTime(this.speed) * this.wordCount;
        this.timeTicker.setTickerListener(new TimeDownTicker.TickerListener() {
            public void onStart() {
                boolean unused = WordBlockPresenter.this.trainingPaused = false;
                WordBlockPresenter.this.handler.post(WordBlockPresenter.this.wordSelectorRunnable);
            }

            public void onTick(long playedTime) {
                if (WordBlockPresenter.this.isViewAttached()) {
                    ((IWordBlockView) WordBlockPresenter.this.getView()).updateTimeView(playedTime);
                }
            }

            public void onEnd() {
                boolean unused = WordBlockPresenter.this.trainingPaused = true;
                WordBlockPresenter.this.handler.removeCallbacks(WordBlockPresenter.this.wordSelectorRunnable);
                WordBlockResult result = new WordBlockResult();
                result.setUnixTime(System.currentTimeMillis());
                WordBlockPresenter.this.repository.updateConfig(configId, WordBlockPresenter.this.speed, WordBlockPresenter.this.wordCount);
                WordBlockPresenter.this.repository.addResult(result, configId, new IWordBlockRepository.OnSingleTransactionCallback() {
                    public void onTransactionCompleted(int id) {
                        if (WordBlockPresenter.this.isViewAttached()) {
                            ((IWordBlockView) WordBlockPresenter.this.getView()).onTrainingCompleted(id);
                        }
                    }
                });
            }
        });
        if (isViewAttached()) {
            ((IWordBlockView) getView()).updateSpeedView(this.speed);
            ((IWordBlockView) getView()).updateWordCountView(this.wordCount);
            ((IWordBlockView) getView()).setWordBlockItemText(getWordBlockText(this.wordCount));
            startTraining();
        }
    }

    public void startTraining() {
        this.timeTicker.start(this.currentPlayedTime);
    }

    public void switchPauseStatus() {
        if (this.trainingPaused) {
            resumeTraining();
        } else {
            pauseTraining();
        }
    }

    public void pauseTraining() {
        this.trainingPaused = true;
        this.currentPlayedTime = this.timeTicker.cancel();
    }

    public void resumeTraining() {
        this.trainingPaused = false;
        this.timeTicker.start(this.currentPlayedTime);
    }

    public void cancelTraining() {
        this.timeTicker.cancel();
        this.trainingPaused = true;
        this.handler.removeCallbacks(this.wordSelectorRunnable);
    }

    public void speedUp() {
        this.speed += 50;
        if (this.speed > 3000) {
            this.speed = 3000;
        }
        changeSpeed(this.speed);
    }

    public void speedDown() {
        this.speed -= 50;
        if (this.speed < 100) {
            this.speed = 100;
        }
        changeSpeed(this.speed);
    }

    private void changeSpeed(int speed2) {
        this.delay = SpeedConverterUtil.getWordShowingTime(speed2) * this.wordCount;
        if (isViewAttached()) {
            ((IWordBlockView) getView()).updateSpeedView(speed2);
        }
    }

    public void wordCountPlus() {
        this.wordCount++;
        if (this.wordCount > 80) {
            this.wordCount = 80;
        }
        changeWordCount(this.wordCount);
    }

    public void wordCountMinus() {
        this.wordCount--;
        if (this.wordCount < 1) {
            this.wordCount = 1;
        }
        changeWordCount(this.wordCount);
    }

    private void changeWordCount(int wordCount2) {
        this.delay = SpeedConverterUtil.getWordShowingTime(this.speed) * wordCount2;
        if (isViewAttached()) {
            ((IWordBlockView) getView()).updateWordCountView(wordCount2);
            this.trainingPaused = true;
            this.handler.removeCallbacks(this.wordSelectorRunnable);
            this.trainingPaused = false;
            this.handler.post(this.wordSelectorRunnable);
        }
    }

    /* access modifiers changed from: private */
    public String getWordBlockText(int wordCount2) {
        StringBuilder builder = new StringBuilder(this.words[this.random.nextInt(this.words.length)]);
        for (int i = 1; i < wordCount2; i++) {
            builder.append(' ');
            builder.append(this.words[this.random.nextInt(this.words.length)]);
        }
        return builder.toString();
    }
}
