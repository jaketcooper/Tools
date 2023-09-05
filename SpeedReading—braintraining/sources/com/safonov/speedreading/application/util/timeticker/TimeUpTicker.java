package com.safonov.speedreading.application.util.timeticker;

import android.os.Handler;
import android.support.annotation.NonNull;
import java.util.Timer;
import java.util.TimerTask;

public class TimeUpTicker {
    private static final long DEFAULT_DELAY = 100;
    /* access modifiers changed from: private */
    public long currentPlayedTime;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    /* access modifiers changed from: private */
    public TickerUpdateListener listener;
    private Timer timer;

    public interface TickerUpdateListener {
        void onTick(long j);
    }

    public TimeUpTicker(@NonNull TickerUpdateListener listener2) {
        this.listener = listener2;
    }

    public void start() {
        start(0, DEFAULT_DELAY);
    }

    public void start(long playedTime) {
        start(playedTime, DEFAULT_DELAY);
    }

    public void start(long playedTime, final long delay) {
        this.currentPlayedTime = playedTime;
        this.timer = new Timer();
        this.timer.schedule(new TimerTask() {
            public void run() {
                TimeUpTicker.this.handler.post(new Runnable() {
                    public void run() {
                        long unused = TimeUpTicker.this.currentPlayedTime = TimeUpTicker.this.currentPlayedTime + delay;
                        TimeUpTicker.this.listener.onTick(TimeUpTicker.this.currentPlayedTime);
                    }
                });
            }
        }, delay, delay);
    }

    public long cancel() {
        if (this.timer != null) {
            this.timer.cancel();
            this.timer = null;
        }
        return this.currentPlayedTime;
    }
}
