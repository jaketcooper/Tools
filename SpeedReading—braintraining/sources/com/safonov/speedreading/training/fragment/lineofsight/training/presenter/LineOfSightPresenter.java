package com.safonov.speedreading.training.fragment.lineofsight.training.presenter;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.lineofsight.repository.ILineOfSightRepository;
import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightConfig;
import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightResult;
import com.safonov.speedreading.training.fragment.lineofsight.training.model.ILineOfSightModel;
import com.safonov.speedreading.training.fragment.lineofsight.training.view.ILineOfSightView;
import java.util.ArrayList;
import java.util.List;

public class LineOfSightPresenter extends MvpBasePresenter<ILineOfSightView> implements ILineOfSightPresenter {
    private static final String CENTER_VALUE = "•";
    /* access modifiers changed from: private */
    public int checkedItemCount;
    /* access modifiers changed from: private */
    public LineOfSightConfig config;
    /* access modifiers changed from: private */
    public int configId;
    /* access modifiers changed from: private */
    public int foundMistakes;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    /* access modifiers changed from: private */
    public boolean isPaused;
    private boolean isPreShowAnimationCompleted;
    /* access modifiers changed from: private */
    public int mistakes;
    /* access modifiers changed from: private */
    public ILineOfSightModel model;
    private List<String> preShowItemList;
    /* access modifiers changed from: private */
    public ILineOfSightRepository repository;
    /* access modifiers changed from: private */
    public int showIndex;
    private Runnable showRunnable = new Runnable() {
        public void run() {
            if (LineOfSightPresenter.this.isPaused || !LineOfSightPresenter.this.isViewAttached()) {
                return;
            }
            if (LineOfSightPresenter.this.showIndex < LineOfSightPresenter.this.config.getShowCount()) {
                ((ILineOfSightView) LineOfSightPresenter.this.getView()).updateProgressBar(LineOfSightPresenter.this.showIndex + 1);
                boolean nextIsMistake = LineOfSightPresenter.this.model.nextIsMistake(LineOfSightPresenter.this.config.getMistakeProbability());
                if (nextIsMistake) {
                    LineOfSightPresenter.access$408(LineOfSightPresenter.this);
                }
                ((ILineOfSightView) LineOfSightPresenter.this.getView()).setCheckedItemsData(LineOfSightPresenter.this.model.getCheckedItems(LineOfSightPresenter.this.checkedItemCount, !nextIsMistake));
                LineOfSightPresenter.access$108(LineOfSightPresenter.this);
                LineOfSightPresenter.this.handler.postDelayed(this, LineOfSightPresenter.this.config.getShowDelay());
                return;
            }
            LineOfSightResult result = new LineOfSightResult();
            result.setMistakeCount(LineOfSightPresenter.this.mistakes);
            result.setFoundMistakeCount(LineOfSightPresenter.this.foundMistakes);
            result.setUnixTime(System.currentTimeMillis());
            LineOfSightPresenter.this.repository.addResult(result, LineOfSightPresenter.this.configId, new ILineOfSightRepository.OnSingleTransactionCallback() {
                public void onTransactionCompleted(int id) {
                    if (LineOfSightPresenter.this.isViewAttached()) {
                        ((ILineOfSightView) LineOfSightPresenter.this.getView()).onLineOfSightTrainingCompleted(id);
                    }
                }
            });
        }
    };

    static /* synthetic */ int access$108(LineOfSightPresenter x0) {
        int i = x0.showIndex;
        x0.showIndex = i + 1;
        return i;
    }

    static /* synthetic */ int access$408(LineOfSightPresenter x0) {
        int i = x0.mistakes;
        x0.mistakes = i + 1;
        return i;
    }

    public LineOfSightPresenter(@NonNull ILineOfSightModel model2, @NonNull ILineOfSightRepository repository2) {
        this.model = model2;
        this.repository = repository2;
    }

    public void init(int configId2) {
        this.configId = configId2;
        this.config = this.repository.getConfig(configId2);
        this.checkedItemCount = this.config.getFieldType() == 0 ? 4 : 8;
        this.preShowItemList = new ArrayList(this.config.getFieldType());
        for (int i = 0; i < this.checkedItemCount; i++) {
            this.preShowItemList.add(CENTER_VALUE);
        }
        if (isViewAttached()) {
            ((ILineOfSightView) getView()).initBoardView(this.config.getRowCount(), this.config.getColumnCount(), this.config.getFieldType());
        }
    }

    public void startTraining() {
        ((ILineOfSightView) getView()).setCheckButtonEnabled(false);
        ((ILineOfSightView) getView()).setItemsData(this.model.getItems(this.config.getRowCount(), this.config.getColumnCount()));
        ((ILineOfSightView) getView()).setCheckedItemsData(this.preShowItemList);
        ((ILineOfSightView) getView()).startPreShowAnimation();
        ((ILineOfSightView) getView()).initProgressBar(this.config.getShowCount());
        ((ILineOfSightView) getView()).updateProgressBar(0);
    }

    public void onPreShowAnimationCompleted() {
        this.isPreShowAnimationCompleted = true;
        ((ILineOfSightView) getView()).setCheckButtonEnabled(true);
        this.handler.postDelayed(this.showRunnable, this.config.getShowDelay());
    }

    public void cancelTraining() {
        this.isPaused = true;
        this.handler.removeCallbacks(this.showRunnable);
        this.preShowItemList = null;
        this.showRunnable = null;
        this.handler = null;
        this.model = null;
    }

    public void pauseTraining() {
        if (this.isPreShowAnimationCompleted) {
            this.isPaused = true;
        } else if (isViewAttached()) {
            ((ILineOfSightView) getView()).cancelPreShowAnimation();
        }
    }

    public void resumeTraining() {
        if (this.isPreShowAnimationCompleted) {
            this.isPaused = false;
            this.handler.postDelayed(this.showRunnable, this.config.getShowDelay());
        } else if (isViewAttached()) {
            ((ILineOfSightView) getView()).startPreShowAnimation();
        }
    }

    public void onCheckButtonPressed() {
        this.foundMistakes++;
    }
}
