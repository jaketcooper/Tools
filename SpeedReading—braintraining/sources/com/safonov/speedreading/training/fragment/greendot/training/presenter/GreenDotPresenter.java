package com.safonov.speedreading.training.fragment.greendot.training.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.application.util.timeticker.TimeDownTicker;
import com.safonov.speedreading.training.fragment.greendot.repository.IGreenDotRepository;
import com.safonov.speedreading.training.fragment.greendot.repository.entity.GreenDotConfig;
import com.safonov.speedreading.training.fragment.greendot.repository.entity.GreenDotResult;
import com.safonov.speedreading.training.fragment.greendot.training.view.IGreenDotView;

public class GreenDotPresenter extends MvpBasePresenter<IGreenDotView> implements IGreenDotPresenter {
    public static final int MAX_PROGRESS = 100;
    /* access modifiers changed from: private */
    public boolean isAfterPause = false;
    /* access modifiers changed from: private */
    public int progress = 0;
    /* access modifiers changed from: private */
    public int progressBeforePause = 0;
    /* access modifiers changed from: private */
    public IGreenDotRepository repository;
    private long timeBeforePause = 0;
    private TimeDownTicker timeDownTicker;

    static /* synthetic */ int access$108(GreenDotPresenter x0) {
        int i = x0.progress;
        x0.progress = i + 1;
        return i;
    }

    public GreenDotPresenter(@NonNull IGreenDotRepository repository2) {
        this.repository = repository2;
    }

    public void startTraining(final int configId) {
        GreenDotConfig config = this.repository.getConfig(configId);
        this.timeDownTicker = new TimeDownTicker();
        this.timeDownTicker.setTickerListener(new TimeDownTicker.TickerListener() {
            public void onStart() {
            }

            public void onTick(long playedTime) {
                if (GreenDotPresenter.this.isViewAttached()) {
                    if (GreenDotPresenter.this.isAfterPause) {
                        int unused = GreenDotPresenter.this.progress = GreenDotPresenter.this.progressBeforePause;
                        boolean unused2 = GreenDotPresenter.this.isAfterPause = false;
                    }
                    ((IGreenDotView) GreenDotPresenter.this.getView()).setGreenDotViewProgress(GreenDotPresenter.access$108(GreenDotPresenter.this));
                }
            }

            public void onEnd() {
                if (GreenDotPresenter.this.isViewAttached()) {
                    GreenDotResult result = new GreenDotResult();
                    result.setUnixTime(System.currentTimeMillis());
                    GreenDotPresenter.this.repository.addResult(result, configId, new IGreenDotRepository.OnSingleTransactionCallback() {
                        public void onTransactionCompleted(int id) {
                            if (GreenDotPresenter.this.isViewAttached()) {
                                ((IGreenDotView) GreenDotPresenter.this.getView()).onGreenDotTrainingCompleted(id);
                            }
                        }
                    });
                }
            }
        });
        this.timeDownTicker.start(config.getDuration(), config.getDuration() / 100);
    }

    public void cancelTraining() {
        this.timeDownTicker.cancel();
        this.timeDownTicker = null;
        this.progress = 0;
        this.repository = null;
    }

    public void pauseTraining() {
        this.timeBeforePause = this.timeDownTicker.cancel();
        this.progressBeforePause = this.progress;
        this.progress = 0;
    }

    public void resumeTraining() {
        this.isAfterPause = true;
        this.timeDownTicker.start(this.timeBeforePause, this.timeBeforePause / ((long) (100 - this.progressBeforePause)));
    }
}
