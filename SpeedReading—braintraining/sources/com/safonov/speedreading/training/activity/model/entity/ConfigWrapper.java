package com.safonov.speedreading.training.activity.model.entity;

import android.support.annotation.NonNull;
import com.safonov.speedreading.training.TrainingType;

public class ConfigWrapper {
    private int configId;
    private boolean fullscreen;
    private TrainingType trainingType;

    public ConfigWrapper() {
    }

    public ConfigWrapper(@NonNull TrainingType trainingType2, int configId2, boolean fullscreen2) {
        this.trainingType = trainingType2;
        this.configId = configId2;
        this.fullscreen = fullscreen2;
    }

    public TrainingType getTrainingType() {
        return this.trainingType;
    }

    public void setTrainingType(TrainingType trainingType2) {
        this.trainingType = trainingType2;
    }

    public int getConfigId() {
        return this.configId;
    }

    public void setConfigId(int configId2) {
        this.configId = configId2;
    }

    public boolean isFullscreen() {
        return this.fullscreen;
    }

    public void setFullscreen(boolean fullscreen2) {
        this.fullscreen = fullscreen2;
    }
}
