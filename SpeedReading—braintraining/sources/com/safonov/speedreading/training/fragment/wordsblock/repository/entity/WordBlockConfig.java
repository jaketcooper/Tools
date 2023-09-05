package com.safonov.speedreading.training.fragment.wordsblock.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import p006io.realm.RealmObject;
import p006io.realm.WordBlockConfigRealmProxyInterface;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class WordBlockConfig extends RealmObject implements IdentityRealmObject, WordBlockConfigRealmProxyInterface {
    public static final String FIELD_TRAINING_DURATION = "trainingDuration";
    @PrimaryKey

    /* renamed from: id */
    private int f136id;
    private int speed;
    private long trainingDuration;
    private int wordCount;

    public int realmGet$id() {
        return this.f136id;
    }

    public int realmGet$speed() {
        return this.speed;
    }

    public long realmGet$trainingDuration() {
        return this.trainingDuration;
    }

    public int realmGet$wordCount() {
        return this.wordCount;
    }

    public void realmSet$id(int i) {
        this.f136id = i;
    }

    public void realmSet$speed(int i) {
        this.speed = i;
    }

    public void realmSet$trainingDuration(long j) {
        this.trainingDuration = j;
    }

    public void realmSet$wordCount(int i) {
        this.wordCount = i;
    }

    public WordBlockConfig() {
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

    public int getWordCount() {
        return realmGet$wordCount();
    }

    public void setWordCount(int wordCount2) {
        realmSet$wordCount(wordCount2);
    }

    public long getTrainingDuration() {
        return realmGet$trainingDuration();
    }

    public void setTrainingDuration(long trainingDuration2) {
        realmSet$trainingDuration(trainingDuration2);
    }
}
