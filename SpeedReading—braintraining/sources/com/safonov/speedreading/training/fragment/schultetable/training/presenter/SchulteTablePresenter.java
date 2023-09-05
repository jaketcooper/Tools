package com.safonov.speedreading.training.fragment.schultetable.training.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.application.util.timeticker.TimeUpTicker;
import com.safonov.speedreading.training.fragment.schultetable.repository.ISchulteTableRepository;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableConfig;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableResult;
import com.safonov.speedreading.training.fragment.schultetable.training.model.ISchulteTableModel;
import com.safonov.speedreading.training.fragment.schultetable.training.view.ISchulteTableView;
import java.util.List;

public class SchulteTablePresenter extends MvpBasePresenter<ISchulteTableView> implements ISchulteTablePresenter {
    private SchulteTableConfig config;
    private int configId;
    private long currentPlayedTime;
    private boolean isTrueAnswer;
    private int itemCount;
    private List<String> items;
    private ISchulteTableModel model;
    private String nextItemValue = "1";
    private ISchulteTableRepository repository;
    private TimeUpTicker timeTicker;

    public SchulteTablePresenter(@NonNull ISchulteTableModel model2, @NonNull ISchulteTableRepository repository2) {
        this.model = model2;
        this.repository = repository2;
    }

    public void init(int configId2) {
        this.configId = configId2;
        this.config = this.repository.getConfig(configId2);
        this.itemCount = this.config.getRowCount() * this.config.getColumnCount();
        this.timeTicker = new TimeUpTicker(new TimeUpTicker.TickerUpdateListener() {
            public void onTick(long playedTime) {
                if (SchulteTablePresenter.this.isViewAttached()) {
                    ((ISchulteTableView) SchulteTablePresenter.this.getView()).updateCurrentTimeView(playedTime);
                }
            }
        });
        SchulteTableResult bestResult = this.repository.getBestResult(configId2);
        if (isViewAttached()) {
            ((ISchulteTableView) getView()).initBoard(this.config.getRowCount(), this.config.getColumnCount(), this.config.isFullscreen());
            if (!this.config.isFullscreen()) {
                ((ISchulteTableView) getView()).updateBestTimeView(bestResult == null ? 0 : bestResult.getTime());
                ((ISchulteTableView) getView()).updateNextItemView(this.nextItemValue);
            }
        }
    }

    public void startTraining() {
        this.timeTicker.start();
        if (isViewAttached()) {
            this.items = this.model.getRandomNumbers(this.itemCount);
            ((ISchulteTableView) getView()).setBoardItems(this.items);
        }
    }

    public void cancelTraining() {
        this.timeTicker.cancel();
    }

    public void pauseTraining() {
        if (isViewAttached()) {
            ((ISchulteTableView) getView()).setBoardItemsEnable(false);
        }
        this.currentPlayedTime = this.timeTicker.cancel();
    }

    public void resumeTraining() {
        if (isViewAttached()) {
            ((ISchulteTableView) getView()).setBoardItemsEnable(true);
        }
        this.timeTicker.start(this.currentPlayedTime);
    }

    public void onItemTouchDown(int itemIndex) {
        this.isTrueAnswer = this.items.get(itemIndex).equals(this.nextItemValue);
        if (this.isTrueAnswer) {
            this.nextItemValue = this.model.getNextNumberItem(this.nextItemValue, this.itemCount);
        }
        if (isViewAttached()) {
            ((ISchulteTableView) getView()).itemTouchDown(itemIndex, this.isTrueAnswer);
        }
    }

    public void onItemTouchUp(int itemIndex) {
        if (isViewAttached()) {
            ((ISchulteTableView) getView()).itemTouchUp(itemIndex, this.isTrueAnswer);
            if (!this.isTrueAnswer) {
                return;
            }
            if (this.nextItemValue == null) {
                ((ISchulteTableView) getView()).setBoardItemsEnable(false);
                this.currentPlayedTime = this.timeTicker.cancel();
                SchulteTableResult result = new SchulteTableResult();
                result.setTime(this.currentPlayedTime);
                result.setUnixTime(System.currentTimeMillis());
                this.repository.addResult(result, this.configId, new ISchulteTableRepository.OnSingleTransactionCallback() {
                    public void onTransactionCompleted(int id) {
                        if (SchulteTablePresenter.this.isViewAttached()) {
                            ((ISchulteTableView) SchulteTablePresenter.this.getView()).onSchulteTableTrainingCompleted(id);
                        }
                    }
                });
                return;
            }
            ((ISchulteTableView) getView()).updateNextItemView(this.nextItemValue);
        }
    }
}
