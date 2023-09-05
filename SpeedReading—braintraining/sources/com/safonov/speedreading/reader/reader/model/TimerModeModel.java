package com.safonov.speedreading.reader.reader.model;

public class TimerModeModel {
    private final int readingMode;
    private long remainingTime;

    public TimerModeModel(int readingMode2, long remainingTime2) {
        this.readingMode = readingMode2;
        this.remainingTime = remainingTime2;
    }

    public void setRemainingTime(long remainingTime2) {
        this.remainingTime = remainingTime2;
    }

    public long getRemainingTime() {
        return this.remainingTime;
    }

    public int getReadingMode() {
        return this.readingMode;
    }

    public boolean isCompleted() {
        return this.remainingTime == 0;
    }
}
