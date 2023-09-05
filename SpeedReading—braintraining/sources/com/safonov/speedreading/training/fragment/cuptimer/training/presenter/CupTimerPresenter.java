package com.safonov.speedreading.training.fragment.cuptimer.training.presenter;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.cuptimer.repository.ICupTimerRepository;
import com.safonov.speedreading.training.fragment.cuptimer.repository.entity.CupTimerConfig;
import com.safonov.speedreading.training.fragment.cuptimer.repository.entity.CupTimerResult;
import com.safonov.speedreading.training.fragment.cuptimer.training.view.ICupTimerView;
import com.speedreading.alexander.speedreading.R;

public class CupTimerPresenter extends MvpBasePresenter<ICupTimerView> implements ICupTimerPresenter {
    public static final int DEFAULT_COUNT_TIME = 10;
    public static final int MAX_COUNT = 2;
    public static final int NOTIFICATION_SHOWING_TIME = 2500;
    /* access modifiers changed from: private */
    public CupTimerConfig config;
    /* access modifiers changed from: private */
    public int firstImage;
    CountDownTimer firstTimer;
    private Handler handler = new Handler();
    boolean isFirst;
    CountDownTimer mainTimer;
    private ICupTimerRepository repository;
    /* access modifiers changed from: private */
    public int secondImage;
    CountDownTimer secondTimer;
    private Runnable startGame = new Runnable() {
        public void run() {
            ((ICupTimerView) CupTimerPresenter.this.getView()).hideNotification();
            ((ICupTimerView) CupTimerPresenter.this.getView()).setImage(CupTimerPresenter.this.firstImage);
            ((ICupTimerView) CupTimerPresenter.this.getView()).showImage();
            ((ICupTimerView) CupTimerPresenter.this.getView()).setMaxProgress(CupTimerPresenter.this.config.getDuration() * 2);
            CupTimerPresenter.this.startFirstTimer(CupTimerPresenter.this.config.getDuration());
            CupTimerPresenter.this.startMainTimer(CupTimerPresenter.this.config.getDuration() * 2);
        }
    };

    public CupTimerPresenter(@NonNull ICupTimerRepository repository2) {
        this.repository = repository2;
    }

    public void startTraining(int configId) {
        this.config = this.repository.getConfig(configId);
        ((ICupTimerView) getView()).hideImage();
        switch (this.config.getType()) {
            case 1:
                this.firstImage = R.drawable.cup_icon;
                this.secondImage = R.drawable.faces_icon;
                ((ICupTimerView) getView()).showNotification(R.string.notification_first_type);
                break;
            case 2:
                this.firstImage = R.drawable.pyramide_icon;
                this.secondImage = R.drawable.pyramide_icon;
                ((ICupTimerView) getView()).hideProgressBar();
                ((ICupTimerView) getView()).showNotification(R.string.notification_second_type);
                break;
            default:
                this.firstImage = R.drawable.cup_icon;
                this.secondImage = R.drawable.faces_icon;
                ((ICupTimerView) getView()).showNotification(R.string.notification_first_type);
                break;
        }
        this.handler.postDelayed(this.startGame, 2500);
    }

    public void cancelTraining() {
        pauseTraining();
    }

    public void saveResult() {
        CupTimerResult result = new CupTimerResult();
        result.setUnixTime(this.config.getDuration());
        this.repository.addResult(result, this.config.getId(), new ICupTimerRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                ((ICupTimerView) CupTimerPresenter.this.getView()).onCupTimerTrainingCompleted(id);
            }
        });
    }

    public void pauseTraining() {
        if (this.firstTimer != null) {
            this.firstTimer.cancel();
        }
        if (this.secondTimer != null) {
            this.secondTimer.cancel();
        }
        if (this.mainTimer != null) {
            this.mainTimer.cancel();
        }
    }

    public void resumeTraining() {
        if (this.isFirst) {
            if (this.firstTimer != null) {
                this.firstTimer.start();
            }
        } else if (this.secondTimer != null) {
            this.secondTimer.start();
        }
        this.mainTimer.start();
    }

    /* access modifiers changed from: private */
    public void startFirstTimer(long time) {
        this.isFirst = true;
        final long j = time;
        this.firstTimer = new CountDownTimer(time, 10) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                ((ICupTimerView) CupTimerPresenter.this.getView()).setImage(CupTimerPresenter.this.secondImage);
                CupTimerPresenter.this.startSecondTimer(j);
            }
        }.start();
    }

    /* access modifiers changed from: private */
    public void startMainTimer(long time) {
        final long j = time;
        this.mainTimer = new CountDownTimer(time, 10) {
            public void onTick(long millisUntilFinished) {
                ((ICupTimerView) CupTimerPresenter.this.getView()).setProgress((int) (j - millisUntilFinished));
            }

            public void onFinish() {
                CupTimerPresenter.this.cancelTraining();
                CupTimerPresenter.this.saveResult();
            }
        }.start();
    }

    /* access modifiers changed from: private */
    public void startSecondTimer(long time) {
        this.isFirst = false;
        final long j = time;
        this.secondTimer = new CountDownTimer(time, 10) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                ((ICupTimerView) CupTimerPresenter.this.getView()).setImage(CupTimerPresenter.this.firstImage);
                CupTimerPresenter.this.startFirstTimer(j);
            }
        }.start();
    }
}
