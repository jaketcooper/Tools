package com.safonov.speedreading.application.util.timeticker;

import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;

public class TimeDownTicker {
    private static final long DEFAULT_DELAY = 100;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    /* access modifiers changed from: private */
    public TickerListener listener;
    /* access modifiers changed from: private */
    public long timeLeft;
    /* access modifiers changed from: private */
    public Timer timer;

    public interface TickerListener {
        void onEnd();

        void onStart();

        void onTick(long j);
    }

    public void setTickerListener(TickerListener listener2) {
        this.listener = listener2;
    }

    public void start(long timeLeft2) {
        start(timeLeft2, DEFAULT_DELAY);
    }

    public void start(long timeLeft2, final long delay) {
        this.timeLeft = timeLeft2;
        if (this.listener != null) {
            this.listener.onStart();
        }
        if (this.timeLeft > 0) {
            this.timer = new Timer();
            this.timer.schedule(new TimerTask() {
                public void run() {
                    TimeDownTicker.this.handler.post(new Runnable() {
                        public void run() {
                            TimeDownTicker timeDownTicker = TimeDownTicker.this;
                            long unused = timeDownTicker.timeLeft = timeDownTicker.timeLeft - delay;
                            if (TimeDownTicker.this.timeLeft < 0) {
                                long unused2 = TimeDownTicker.this.timeLeft = 0;
                            }
                            if (TimeDownTicker.this.listener != null) {
                                TimeDownTicker.this.listener.onTick(TimeDownTicker.this.timeLeft);
                            }
                            if (TimeDownTicker.this.timeLeft == 0) {
                                if (TimeDownTicker.this.timer != null) {
                                    TimeDownTicker.this.timer.cancel();
                                    Timer unused3 = TimeDownTicker.this.timer = null;
                                }
                                if (TimeDownTicker.this.listener != null) {
                                    TimeDownTicker.this.listener.onEnd();
                                }
                            }
                        }
                    });
                }
            }, delay, delay);
        } else if (this.listener != null) {
            this.listener.onEnd();
        }
    }

    public long cancel() {
        if (this.timer != null) {
            this.timer.cancel();
            this.timer = null;
        }
        return this.timeLeft;
    }
}
