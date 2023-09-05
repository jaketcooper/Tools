package com.safonov.speedreading.training.fragment.flashword.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import p006io.realm.FlashWordsConfigRealmProxyInterface;
import p006io.realm.RealmObject;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class FlashWordsConfig extends RealmObject implements IdentityRealmObject, FlashWordsConfigRealmProxyInterface {
    public static final int BOARD_TYPE_FIRST = 1;
    public static final int BOARD_TYPE_SECOND = 2;
    public static final int BOARD_TYPE_THIRD = 3;
    public static final String FIELD_BOARD_TYPE = "boarType";
    public static final String FIELD_TRAINING_DURATION = "trainingDuration";
    private int boarType;
    @PrimaryKey

    /* renamed from: id */
    private int f115id;
    private int speed;
    private long trainingDuration;

    public int realmGet$boarType() {
        return this.boarType;
    }

    public int realmGet$id() {
        return this.f115id;
    }

    public int realmGet$speed() {
        return this.speed;
    }

    public long realmGet$trainingDuration() {
        return this.trainingDuration;
    }

    public void realmSet$boarType(int i) {
        this.boarType = i;
    }

    public void realmSet$id(int i) {
        this.f115id = i;
    }

    public void realmSet$speed(int i) {
        this.speed = i;
    }

    public void realmSet$trainingDuration(long j) {
        this.trainingDuration = j;
    }

    public FlashWordsConfig() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public int getId() {
        return realmGet$id();
    }

    public void setId(int id) {
        realmSet$id(id);
    }

    public int getSpeed() {
        return realmGet$speed();
    }

    public void setSpeed(int speed2) {
        realmSet$speed(speed2);
    }

    public int getBoarType() {
        return realmGet$boarType();
    }

    public void setBoarType(int boarType2) {
        realmSet$boarType(boarType2);
    }

    public long getTrainingDuration() {
        return realmGet$trainingDuration();
    }

    public void setTrainingDuration(long trainingDuration2) {
        realmSet$trainingDuration(trainingDuration2);
    }
}
