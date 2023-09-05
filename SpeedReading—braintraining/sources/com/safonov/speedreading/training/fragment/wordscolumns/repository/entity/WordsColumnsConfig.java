package com.safonov.speedreading.training.fragment.wordscolumns.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import p006io.realm.RealmObject;
import p006io.realm.WordsColumnsConfigRealmProxyInterface;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class WordsColumnsConfig extends RealmObject implements IdentityRealmObject, WordsColumnsConfigRealmProxyInterface {
    public static final String FIELD_COLUMN_COUNT = "columnCount";
    public static final String FIELD_ROW_COUNT = "rowCount";
    public static final String FIELD_TRAINING_DURATION = "trainingDuration";
    public static final String FIELD_WORDS_PER_ITEM = "wordsPerItem";
    private int columnCount;
    @PrimaryKey

    /* renamed from: id */
    private int f138id;
    private int rowCount;
    private int speed;
    private long trainingDuration;
    private int wordsPerItem;

    public int realmGet$columnCount() {
        return this.columnCount;
    }

    public int realmGet$id() {
        return this.f138id;
    }

    public int realmGet$rowCount() {
        return this.rowCount;
    }

    public int realmGet$speed() {
        return this.speed;
    }

    public long realmGet$trainingDuration() {
        return this.trainingDuration;
    }

    public int realmGet$wordsPerItem() {
        return this.wordsPerItem;
    }

    public void realmSet$columnCount(int i) {
        this.columnCount = i;
    }

    public void realmSet$id(int i) {
        this.f138id = i;
    }

    public void realmSet$rowCount(int i) {
        this.rowCount = i;
    }

    public void realmSet$speed(int i) {
        this.speed = i;
    }

    public void realmSet$trainingDuration(long j) {
        this.trainingDuration = j;
    }

    public void realmSet$wordsPerItem(int i) {
        this.wordsPerItem = i;
    }

    public WordsColumnsConfig() {
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

    public int getRowCount() {
        return realmGet$rowCount();
    }

    public void setRowCount(int rowCount2) {
        realmSet$rowCount(rowCount2);
    }

    public int getColumnCount() {
        return realmGet$columnCount();
    }

    public void setColumnCount(int columnCount2) {
        realmSet$columnCount(columnCount2);
    }

    public int getItemCount() {
        return realmGet$rowCount() * realmGet$columnCount();
    }

    public int getWordsPerItem() {
        return realmGet$wordsPerItem();
    }

    public void setWordsPerItem(int wordsPerItem2) {
        realmSet$wordsPerItem(wordsPerItem2);
    }

    public int getSpeed() {
        return realmGet$speed();
    }

    public void setSpeed(int speed2) {
        realmSet$speed(speed2);
    }

    public long getTrainingDuration() {
        return realmGet$trainingDuration();
    }

    public void setTrainingDuration(long trainingDuration2) {
        realmSet$trainingDuration(trainingDuration2);
    }
}
