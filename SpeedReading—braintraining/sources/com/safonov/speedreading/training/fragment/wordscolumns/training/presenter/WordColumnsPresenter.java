package com.safonov.speedreading.training.fragment.wordscolumns.training.presenter;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.application.util.timeticker.TimeDownTicker;
import com.safonov.speedreading.training.fragment.speedreading.util.SpeedConverterUtil;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.IWordsColumnsRepository;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.entity.WordsColumnsConfig;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.entity.WordsColumnsResult;
import com.safonov.speedreading.training.fragment.wordscolumns.training.view.IWordColumnsView;
import com.speedreading.alexander.speedreading.R;
import java.util.Random;

public class WordColumnsPresenter extends MvpBasePresenter<IWordColumnsView> implements IWordColumnsPresenter {
    private static final int MAX_SPEED = 3000;
    private static final int MIN_SPEED = 100;
    private static final int SPEED_STEP = 50;
    /* access modifiers changed from: private */
    public WordsColumnsConfig config;
    private long currentPlayedTime;
    /* access modifiers changed from: private */
    public int delay;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    private Random random = new Random();
    /* access modifiers changed from: private */
    public IWordsColumnsRepository repository;
    /* access modifiers changed from: private */
    public int selectedIndex;
    /* access modifiers changed from: private */
    public int speed;
    private TimeDownTicker timeTicker = new TimeDownTicker();
    /* access modifiers changed from: private */
    public boolean trainingPaused;
    /* access modifiers changed from: private */
    public Runnable wordSelectorRunnable = new Runnable() {
        public void run() {
            if (!WordColumnsPresenter.this.trainingPaused && WordColumnsPresenter.this.isViewAttached()) {
                if (WordColumnsPresenter.this.selectedIndex == 0) {
                    ((IWordColumnsView) WordColumnsPresenter.this.getView()).setItems(WordColumnsPresenter.this.getItems(WordColumnsPresenter.this.config.getItemCount(), WordColumnsPresenter.this.config.getWordsPerItem()));
                    ((IWordColumnsView) WordColumnsPresenter.this.getView()).deselectItem(WordColumnsPresenter.this.config.getItemCount() - 1);
                } else {
                    ((IWordColumnsView) WordColumnsPresenter.this.getView()).deselectItem(WordColumnsPresenter.this.selectedIndex - 1);
                }
                ((IWordColumnsView) WordColumnsPresenter.this.getView()).selectItem(WordColumnsPresenter.this.selectedIndex);
                WordColumnsPresenter.access$508(WordColumnsPresenter.this);
                if (WordColumnsPresenter.this.selectedIndex > WordColumnsPresenter.this.config.getItemCount() - 1) {
                    int unused = WordColumnsPresenter.this.selectedIndex = 0;
                }
                if (!WordColumnsPresenter.this.trainingPaused) {
                    WordColumnsPresenter.this.handler.postDelayed(this, (long) WordColumnsPresenter.this.delay);
                }
            }
        }
    };
    private String[] words;

    static /* synthetic */ int access$508(WordColumnsPresenter x0) {
        int i = x0.selectedIndex;
        x0.selectedIndex = i + 1;
        return i;
    }

    public WordColumnsPresenter(@NonNull Context context, @NonNull IWordsColumnsRepository repository2) {
        this.words = context.getResources().getStringArray(R.array.speed_reading_words);
        this.repository = repository2;
    }

    /* access modifiers changed from: private */
    public String[] getItems(int itemCount, int wordsPerItem) {
        String[] items = new String[itemCount];
        for (int i = 0; i < itemCount; i++) {
            String item = this.words[this.random.nextInt(this.words.length)];
            for (int j = 1; j < wordsPerItem; j++) {
                item = item + " " + this.words[this.random.nextInt(this.words.length)];
            }
            items[i] = item;
        }
        return items;
    }

    public void init(final int configId) {
        this.config = this.repository.getConfig(configId);
        this.speed = this.config.getSpeed();
        this.currentPlayedTime = this.config.getTrainingDuration();
        this.delay = SpeedConverterUtil.getWordShowingTime(this.speed) * this.config.getWordsPerItem();
        this.timeTicker.setTickerListener(new TimeDownTicker.TickerListener() {
            public void onStart() {
                boolean unused = WordColumnsPresenter.this.trainingPaused = false;
                WordColumnsPresenter.this.handler.post(WordColumnsPresenter.this.wordSelectorRunnable);
            }

            public void onTick(long playedTime) {
                if (WordColumnsPresenter.this.isViewAttached()) {
                    ((IWordColumnsView) WordColumnsPresenter.this.getView()).updateTimeView(playedTime);
                }
            }

            public void onEnd() {
                boolean unused = WordColumnsPresenter.this.trainingPaused = true;
                WordColumnsPresenter.this.handler.removeCallbacks(WordColumnsPresenter.this.wordSelectorRunnable);
                WordsColumnsResult result = new WordsColumnsResult();
                result.setUnixTime(System.currentTimeMillis());
                WordColumnsPresenter.this.repository.updateConfigSpeed(configId, WordColumnsPresenter.this.speed);
                WordColumnsPresenter.this.repository.addResult(result, configId, new IWordsColumnsRepository.OnSingleTransactionCallback() {
                    public void onTransactionCompleted(int id) {
                        if (WordColumnsPresenter.this.isViewAttached()) {
                            ((IWordColumnsView) WordColumnsPresenter.this.getView()).onTrainingCompleted(id);
                        }
                    }
                });
            }
        });
        if (isViewAttached()) {
            ((IWordColumnsView) getView()).updateSpeedView(this.speed);
            ((IWordColumnsView) getView()).initGridLayout(this.config.getRowCount(), this.config.getColumnCount());
        }
    }

    public void switchTrainingPauseStatus() {
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
        this.delay = SpeedConverterUtil.getWordShowingTime(this.speed) * this.config.getWordsPerItem();
        if (isViewAttached()) {
            ((IWordColumnsView) getView()).updateSpeedView(this.speed);
        }
    }

    public void speedDown() {
        this.speed -= 50;
        if (this.speed < 100) {
            this.speed = 100;
        }
        this.delay = SpeedConverterUtil.getWordShowingTime(this.speed) * this.config.getWordsPerItem();
        if (isViewAttached()) {
            ((IWordColumnsView) getView()).updateSpeedView(this.speed);
        }
    }

    public void startTraining() {
        this.timeTicker.start(this.currentPlayedTime);
    }
}
