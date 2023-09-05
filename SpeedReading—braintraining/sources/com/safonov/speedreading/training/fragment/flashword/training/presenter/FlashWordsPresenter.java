package com.safonov.speedreading.training.fragment.flashword.training.presenter;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.application.util.timeticker.TimeDownTicker;
import com.safonov.speedreading.training.fragment.flashword.repository.IFlashWordRepository;
import com.safonov.speedreading.training.fragment.flashword.repository.entity.FlashWordResult;
import com.safonov.speedreading.training.fragment.flashword.repository.entity.FlashWordsConfig;
import com.safonov.speedreading.training.fragment.flashword.training.view.IFlashWordsView;
import com.safonov.speedreading.training.fragment.speedreading.util.SpeedConverterUtil;
import com.speedreading.alexander.speedreading.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlashWordsPresenter extends MvpBasePresenter<IFlashWordsView> implements IFlashWordsPresenter {
    private static final int BLINK_DURATION = 200;
    private static final int MAX_SPEED = 3000;
    private static final int MIN_SPEED = 100;
    private static final int SPEED_STEP = 50;
    private static final int WORD_COUNT = 4;
    /* access modifiers changed from: private */
    public BoardType boardTypeWrapper;
    /* access modifiers changed from: private */
    public int bordPartIndex;
    private FlashWordsConfig config;
    private long currentPlayedTime;
    /* access modifiers changed from: private */
    public Runnable defaultItemsRunnable = new Runnable() {
        public void run() {
            if (!FlashWordsPresenter.this.trainingPaused && FlashWordsPresenter.this.isViewAttached()) {
                ((IFlashWordsView) FlashWordsPresenter.this.getView()).setItemsEmptyText();
                FlashWordsPresenter.this.handler.postDelayed(FlashWordsPresenter.this.itemsRunnable, 200);
            }
        }
    };
    /* access modifiers changed from: private */
    public int delay;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    /* access modifiers changed from: private */
    public Runnable itemsRunnable = new Runnable() {
        public void run() {
            if (!FlashWordsPresenter.this.trainingPaused && FlashWordsPresenter.this.isViewAttached()) {
                ((IFlashWordsView) FlashWordsPresenter.this.getView()).setItemsText(FlashWordsPresenter.this.bordPartIndex, FlashWordsPresenter.this.getItemTextList(4));
                FlashWordsPresenter.access$608(FlashWordsPresenter.this);
                if (FlashWordsPresenter.this.bordPartIndex > FlashWordsPresenter.this.boardTypeWrapper.getBoardPartCount() - 1) {
                    int unused = FlashWordsPresenter.this.bordPartIndex = 0;
                }
                FlashWordsPresenter.this.handler.postDelayed(FlashWordsPresenter.this.defaultItemsRunnable, (long) FlashWordsPresenter.this.delay);
            }
        }
    };
    private Random random = new Random();
    /* access modifiers changed from: private */
    public IFlashWordRepository repository;
    /* access modifiers changed from: private */
    public int speed;
    private TimeDownTicker timeTicker = new TimeDownTicker();
    /* access modifiers changed from: private */
    public boolean trainingPaused;
    private String[] words;

    static /* synthetic */ int access$608(FlashWordsPresenter x0) {
        int i = x0.bordPartIndex;
        x0.bordPartIndex = i + 1;
        return i;
    }

    public FlashWordsPresenter(@NonNull Context context, @NonNull IFlashWordRepository repository2) {
        this.words = context.getResources().getStringArray(R.array.speed_reading_words);
        this.repository = repository2;
    }

    /* access modifiers changed from: private */
    public List<String> getItemTextList(int itemCount) {
        List<String> itemTextList = new ArrayList<>(itemCount);
        for (int i = 0; i < itemCount; i++) {
            itemTextList.add(this.words[this.random.nextInt(this.words.length)]);
        }
        return itemTextList;
    }

    public void init(final int configId) {
        this.config = this.repository.getConfig(configId);
        this.speed = this.config.getSpeed();
        this.currentPlayedTime = this.config.getTrainingDuration();
        this.boardTypeWrapper = BoardType.crete(this.config.getBoarType());
        this.delay = SpeedConverterUtil.getWordShowingTime(this.speed) * 4 * this.boardTypeWrapper.getBoardPartCount();
        this.timeTicker.setTickerListener(new TimeDownTicker.TickerListener() {
            public void onStart() {
                boolean unused = FlashWordsPresenter.this.trainingPaused = false;
                FlashWordsPresenter.this.handler.post(FlashWordsPresenter.this.defaultItemsRunnable);
            }

            public void onTick(long playedTime) {
                if (FlashWordsPresenter.this.isViewAttached()) {
                    ((IFlashWordsView) FlashWordsPresenter.this.getView()).updateTimeView(playedTime);
                }
            }

            public void onEnd() {
                boolean unused = FlashWordsPresenter.this.trainingPaused = true;
                FlashWordsPresenter.this.handler.removeCallbacks(FlashWordsPresenter.this.itemsRunnable);
                FlashWordsPresenter.this.handler.removeCallbacks(FlashWordsPresenter.this.defaultItemsRunnable);
                FlashWordResult result = new FlashWordResult();
                result.setUnixTime(System.currentTimeMillis());
                FlashWordsPresenter.this.repository.updateConfig(configId, FlashWordsPresenter.this.speed);
                FlashWordsPresenter.this.repository.addResult(result, configId, new IFlashWordRepository.OnSingleTransactionCallback() {
                    public void onTransactionCompleted(int id) {
                        if (FlashWordsPresenter.this.isViewAttached()) {
                            ((IFlashWordsView) FlashWordsPresenter.this.getView()).onTrainingCompleted(id);
                        }
                    }
                });
            }
        });
        if (isViewAttached()) {
            ((IFlashWordsView) getView()).updateSpeedView(this.speed);
            ((IFlashWordsView) getView()).updateLevelView(this.boardTypeWrapper.getType());
            ((IFlashWordsView) getView()).initBoardView(this.boardTypeWrapper.getType());
        }
    }

    public void switchTrainingPause() {
        if (this.trainingPaused) {
            resumeTraining();
        } else {
            pauseTraining();
        }
    }

    public void startTraining() {
        this.trainingPaused = false;
        this.timeTicker.start(this.currentPlayedTime);
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
        this.trainingPaused = true;
        this.timeTicker.cancel();
    }

    private enum BoardType {
        FIRST(1),
        SECOND(2),
        THIRD(3);
        
        private final int type;

        private BoardType(int type2) {
            this.type = type2;
        }

        public int getBoardPartCount() {
            switch (this.type) {
                case 1:
                    return 3;
                case 2:
                    return 2;
                case 3:
                    return 1;
                default:
                    return this.type;
            }
        }

        public int getType() {
            return this.type;
        }

        public static BoardType crete(int type2) {
            switch (type2) {
                case 1:
                    return FIRST;
                case 2:
                    return SECOND;
                case 3:
                    return THIRD;
                default:
                    return null;
            }
        }

        @Nullable
        public static BoardType getPrevious(BoardType boardType) {
            switch (boardType) {
                case SECOND:
                    return FIRST;
                case THIRD:
                    return SECOND;
                default:
                    return null;
            }
        }

        @Nullable
        public static BoardType getNext(BoardType boardType) {
            switch (boardType) {
                case FIRST:
                    return SECOND;
                case SECOND:
                    return THIRD;
                default:
                    return null;
            }
        }
    }

    public void levelUp() {
        if (BoardType.getNext(this.boardTypeWrapper) != null) {
            this.boardTypeWrapper = BoardType.getNext(this.boardTypeWrapper);
            changeLevel(this.boardTypeWrapper);
        }
    }

    public void levelDown() {
        if (BoardType.getPrevious(this.boardTypeWrapper) != null) {
            this.boardTypeWrapper = BoardType.getPrevious(this.boardTypeWrapper);
            changeLevel(this.boardTypeWrapper);
        }
    }

    private void changeLevel(BoardType boardType) {
        this.bordPartIndex = 0;
        this.trainingPaused = true;
        this.currentPlayedTime = this.timeTicker.cancel();
        this.handler.removeCallbacks(this.itemsRunnable);
        this.handler.removeCallbacks(this.defaultItemsRunnable);
        if (isViewAttached()) {
            ((IFlashWordsView) getView()).updateLevelView(boardType.getType());
            ((IFlashWordsView) getView()).initBoardView(boardType.getType());
        }
    }

    public void speedUp() {
        this.speed += 50;
        if (this.speed > 3000) {
            this.speed = 3000;
        }
        this.delay = SpeedConverterUtil.getWordShowingTime(this.speed) * 4 * this.boardTypeWrapper.getBoardPartCount();
        if (isViewAttached()) {
            ((IFlashWordsView) getView()).updateSpeedView(this.speed);
        }
    }

    public void speedDown() {
        this.speed -= 50;
        if (this.speed < 100) {
            this.speed = 100;
        }
        this.delay = SpeedConverterUtil.getWordShowingTime(this.speed) * 4 * this.boardTypeWrapper.getBoardPartCount();
        if (isViewAttached()) {
            ((IFlashWordsView) getView()).updateSpeedView(this.speed);
        }
    }
}
