package com.safonov.speedreading.training.fragment.speedreading.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import p006io.realm.RealmObject;
import p006io.realm.SpeedReadingConfigRealmProxyInterface;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class SpeedReadingConfig extends RealmObject implements IdentityRealmObject, SpeedReadingConfigRealmProxyInterface {
    public static final String FIELD_MAX_WORD_SHOW_COUNT = "maxWordShowCount";
    public static final String FIELD_MIN_SPEED = "minSpeed";
    public static final String FIELD_MIN_WORD_SHOW_COUNT = "minWordShowCount";
    public static final String FIELD_SPEED = "speed";
    public static final String FIELD_SPEED_STEP = "speedStep";
    public static final String FIELD_TRAINING_SHOW_COUNT = "trainingShowCount";
    @PrimaryKey

    /* renamed from: id */
    private int f130id;
    private int maxWordShowCount;
    private int minSpeed;
    private int minWordShowCount;
    private int speed;
    private int speedStep;
    private int trainingShowCount;

    public int realmGet$id() {
        return this.f130id;
    }

    public int realmGet$maxWordShowCount() {
        return this.maxWordShowCount;
    }

    public int realmGet$minSpeed() {
        return this.minSpeed;
    }

    public int realmGet$minWordShowCount() {
        return this.minWordShowCount;
    }

    public int realmGet$speed() {
        return this.speed;
    }

    public int realmGet$speedStep() {
        return this.speedStep;
    }

    public int realmGet$trainingShowCount() {
        return this.trainingShowCount;
    }

    public void realmSet$id(int i) {
        this.f130id = i;
    }

    public void realmSet$maxWordShowCount(int i) {
        this.maxWordShowCount = i;
    }

    public void realmSet$minSpeed(int i) {
        this.minSpeed = i;
    }

    public void realmSet$minWordShowCount(int i) {
        this.minWordShowCount = i;
    }

    public void realmSet$speed(int i) {
        this.speed = i;
    }

    public void realmSet$speedStep(int i) {
        this.speedStep = i;
    }

    public void realmSet$trainingShowCount(int i) {
        this.trainingShowCount = i;
    }

    public SpeedReadingConfig() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public void setId(int id) {
        realmSet$id(id);
    }

    public int getId() {
        return realmGet$id();
    }

    public int getTrainingShowCount() {
        return realmGet$trainingShowCount();
    }

    public void setTrainingShowCount(int trainingShowCount2) {
        realmSet$trainingShowCount(trainingShowCount2);
    }

    public int getSpeed() {
        return realmGet$speed();
    }

    public void setSpeed(int speed2) {
        realmSet$speed(speed2);
    }

    public int getMinSpeed() {
        return realmGet$minSpeed();
    }

    public void setMinSpeed(int minSpeed2) {
        realmSet$minSpeed(minSpeed2);
    }

    public int getSpeedStep() {
        return realmGet$speedStep();
    }

    public void setSpeedStep(int speedStep2) {
        realmSet$speedStep(speedStep2);
    }

    public int getMinWordShowCount() {
        return realmGet$minWordShowCount();
    }

    public void setMinWordShowCount(int minWordShowCount2) {
        realmSet$minWordShowCount(minWordShowCount2);
    }

    public int getMaxWordShowCount() {
        return realmGet$maxWordShowCount();
    }

    public void setMaxWordShowCount(int maxWordShowCount2) {
        realmSet$maxWordShowCount(maxWordShowCount2);
    }
}
