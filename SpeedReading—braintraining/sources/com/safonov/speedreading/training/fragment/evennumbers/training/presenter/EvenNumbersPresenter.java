package com.safonov.speedreading.training.fragment.evennumbers.training.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.application.util.timeticker.TimeDownTicker;
import com.safonov.speedreading.training.fragment.evennumbers.repository.IEvenNumberRepository;
import com.safonov.speedreading.training.fragment.evennumbers.repository.entity.EvenNumbersConfig;
import com.safonov.speedreading.training.fragment.evennumbers.repository.entity.EvenNumbersResult;
import com.safonov.speedreading.training.fragment.evennumbers.training.model.IEvenNumbersModel;
import com.safonov.speedreading.training.fragment.evennumbers.training.model.NumberWrapper;
import com.safonov.speedreading.training.fragment.evennumbers.training.view.IEvenNumbersView;
import java.util.List;

public class EvenNumbersPresenter extends MvpBasePresenter<IEvenNumbersView> implements IEvenNumbersPresenter {
    private EvenNumbersResult bestResult;
    /* access modifiers changed from: private */
    public EvenNumbersConfig config;
    private long currentPlayTime;
    private boolean isTrueAnswer;
    private List<NumberWrapper> items;
    private IEvenNumbersModel model;
    /* access modifiers changed from: private */
    public IEvenNumberRepository repository;
    /* access modifiers changed from: private */
    public int score;
    private TimeDownTicker timeDownTicker;
    private int trueAnswersCount;

    public EvenNumbersPresenter(@NonNull IEvenNumbersModel model2, @NonNull IEvenNumberRepository repository2) {
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
                if (EvenNumbersPresenter.this.isViewAttached()) {
                    ((IEvenNumbersView) EvenNumbersPresenter.this.getView()).updateProgressBar((int) (((long) EvenNumbersPresenter.this.config.getTrainingDuration()) - playedTime));
                }
            }

            public void onEnd() {
                EvenNumbersResult result = new EvenNumbersResult();
                result.setScore(EvenNumbersPresenter.this.score);
                result.setUnixTime(System.currentTimeMillis());
                EvenNumbersPresenter.this.repository.addResult(result, configId, new IEvenNumberRepository.OnSingleTransactionCallback() {
                    public void onTransactionCompleted(int id) {
                        if (EvenNumbersPresenter.this.isViewAttached()) {
                            ((IEvenNumbersView) EvenNumbersPresenter.this.getView()).onEvenNumbersTrainingCompleted(id);
                        }
                    }
                });
            }
        });
        if (isViewAttached()) {
            ((IEvenNumbersView) getView()).initBoard(this.config.getRowCount(), this.config.getColumnCount());
        }
    }

    public void startTraining() {
        if (isViewAttached()) {
            ((IEvenNumbersView) getView()).updateProgressBar(0);
            ((IEvenNumbersView) getView()).initProgressBar(this.config.getTrainingDuration());
            ((IEvenNumbersView) getView()).updateScore(0);
            ((IEvenNumbersView) getView()).updateRecord(this.bestResult == null ? 0 : this.bestResult.getScore());
            this.items = this.model.createItems(this.config.getRowCount() * this.config.getColumnCount(), this.config.getEvenNumberCount(), this.config.getDigitsPerNumber());
            ((IEvenNumbersView) getView()).setBoardItems(this.items);
            this.trueAnswersCount = 0;
            this.timeDownTicker.start(this.currentPlayTime);
        }
    }

    public void cancelTraining() {
        this.timeDownTicker.cancel();
        this.timeDownTicker = null;
        this.currentPlayTime = 0;
    }

    public void pauseTraining() {
        if (isViewAttached()) {
            ((IEvenNumbersView) getView()).setBoardItemsEnable(false);
        }
        this.currentPlayTime = this.timeDownTicker.cancel();
    }

    public void resumeTraining() {
        if (isViewAttached()) {
            this.trueAnswersCount = 0;
            this.items = this.model.createItems(this.config.getRowCount() * this.config.getColumnCount(), this.config.getEvenNumberCount(), this.config.getDigitsPerNumber());
            ((IEvenNumbersView) getView()).setBoardItems(this.items);
            ((IEvenNumbersView) getView()).setBoardItemsEnable(true);
            this.timeDownTicker.start(this.currentPlayTime);
        }
    }

    public void onItemTouchDown(int itemIndex) {
        if (isViewAttached()) {
            this.isTrueAnswer = this.items.get(itemIndex).isEvenNumber();
            if (this.isTrueAnswer) {
                this.trueAnswersCount++;
                this.score++;
            } else if (this.score > 0) {
                this.score--;
            }
            ((IEvenNumbersView) getView()).updateScore(this.score);
            ((IEvenNumbersView) getView()).itemTouchDown(itemIndex, this.isTrueAnswer);
        }
    }

    public void onItemTouchUp(int itemIndex) {
        if (isViewAttached()) {
            ((IEvenNumbersView) getView()).itemTouchUp(itemIndex, this.isTrueAnswer);
            if (this.trueAnswersCount == this.config.getEvenNumberCount()) {
                this.trueAnswersCount = 0;
                this.items = this.model.createItems(this.config.getRowCount() * this.config.getColumnCount(), this.config.getEvenNumberCount(), this.config.getDigitsPerNumber());
                ((IEvenNumbersView) getView()).setBoardItems(this.items);
            }
        }
    }
}
