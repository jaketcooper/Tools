package com.safonov.speedreading.training.fragment.wordpairs.training.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.application.util.timeticker.TimeDownTicker;
import com.safonov.speedreading.training.fragment.wordpairs.repository.IWordPairsRepository;
import com.safonov.speedreading.training.fragment.wordpairs.repository.entity.WordPairsConfig;
import com.safonov.speedreading.training.fragment.wordpairs.repository.entity.WordPairsResult;
import com.safonov.speedreading.training.fragment.wordpairs.training.model.IWordPairsModel;
import com.safonov.speedreading.training.fragment.wordpairs.training.model.WordPair;
import com.safonov.speedreading.training.fragment.wordpairs.training.view.IWordPairsView;
import java.util.List;

public class WordPairsPresenter extends MvpBasePresenter<IWordPairsView> implements IWordPairsPresenter {
    private WordPairsResult bestResult;
    /* access modifiers changed from: private */
    public WordPairsConfig config;
    private long currentPlayTime;
    private boolean isTrueAnswer;
    private List<WordPair> items;
    private IWordPairsModel model;
    /* access modifiers changed from: private */
    public IWordPairsRepository repository;
    /* access modifiers changed from: private */
    public int score;
    private TimeDownTicker timeDownTicker;
    private int trueAnswerCount;

    public WordPairsPresenter(@NonNull IWordPairsModel model2, @NonNull IWordPairsRepository repository2) {
        this.model = model2;
        this.repository = repository2;
    }

    public void init(final int configId) {
        this.config = this.repository.getConfig(configId);
        this.bestResult = this.repository.getBestResult(configId);
        this.currentPlayTime = (long) this.config.getTrainingDuration();
        this.timeDownTicker = new TimeDownTicker();
        this.timeDownTicker.setTickerListener(new TimeDownTicker.TickerListener() {
            public void onStart() {
            }

            public void onTick(long playedTime) {
                if (WordPairsPresenter.this.isViewAttached()) {
                    ((IWordPairsView) WordPairsPresenter.this.getView()).updateProgressBar((int) (((long) WordPairsPresenter.this.config.getTrainingDuration()) - playedTime));
                }
            }

            public void onEnd() {
                WordPairsResult result = new WordPairsResult();
                result.setScore(WordPairsPresenter.this.score);
                result.setUnixTime(System.currentTimeMillis());
                WordPairsPresenter.this.repository.addResult(result, configId, new IWordPairsRepository.OnSingleTransactionCallback() {
                    public void onTransactionCompleted(int id) {
                        ((IWordPairsView) WordPairsPresenter.this.getView()).onWordPairsTrainingCompleted(id);
                    }
                });
            }
        });
        if (isViewAttached()) {
            ((IWordPairsView) getView()).initBoard(this.config.getRowCount(), this.config.getColumnCount());
        }
    }

    public void cancelTraining() {
        this.timeDownTicker.cancel();
        this.timeDownTicker = null;
        this.currentPlayTime = 0;
    }

    public void startTraining() {
        this.trueAnswerCount = 0;
        if (isViewAttached()) {
            ((IWordPairsView) getView()).updateProgressBar(0);
            ((IWordPairsView) getView()).initProgressBar(this.config.getTrainingDuration());
            ((IWordPairsView) getView()).updateRecord(this.bestResult == null ? 0 : this.bestResult.getScore());
            ((IWordPairsView) getView()).updateScore(0);
            this.items = this.model.createWordPairs(this.config.getRowCount() * this.config.getColumnCount(), this.config.getDifferentWordPairsCount());
            ((IWordPairsView) getView()).setBoardItems(this.items);
            this.timeDownTicker.start(this.currentPlayTime);
        }
    }

    public void pauseTraining() {
        if (isViewAttached()) {
            ((IWordPairsView) getView()).setBoardItemsEnable(false);
        }
        this.currentPlayTime = this.timeDownTicker.cancel();
    }

    public void resumeTraining() {
        if (isViewAttached()) {
            this.items = this.model.createWordPairs(this.config.getRowCount() * this.config.getColumnCount(), this.config.getDifferentWordPairsCount());
            ((IWordPairsView) getView()).setBoardItems(this.items);
            ((IWordPairsView) getView()).setBoardItemsEnable(true);
            this.trueAnswerCount = 0;
            this.timeDownTicker.start(this.currentPlayTime);
        }
    }

    public void onItemTouchDown(int itemIndex) {
        if (isViewAttached()) {
            this.isTrueAnswer = !this.items.get(itemIndex).areWordsEqual();
            if (this.isTrueAnswer) {
                this.trueAnswerCount++;
                this.score++;
            } else if (this.score > 0) {
                this.score--;
            }
            ((IWordPairsView) getView()).updateScore(this.score);
            ((IWordPairsView) getView()).itemTouchDown(itemIndex, this.isTrueAnswer);
        }
    }

    public void onItemTouchUp(int itemIndex) {
        if (isViewAttached()) {
            ((IWordPairsView) getView()).itemTouchUp(itemIndex, this.isTrueAnswer);
            if (this.trueAnswerCount == this.config.getDifferentWordPairsCount()) {
                this.trueAnswerCount = 0;
                this.items = this.model.createWordPairs(this.config.getRowCount() * this.config.getColumnCount(), this.config.getDifferentWordPairsCount());
                ((IWordPairsView) getView()).setBoardItems(this.items);
            }
        }
    }
}
