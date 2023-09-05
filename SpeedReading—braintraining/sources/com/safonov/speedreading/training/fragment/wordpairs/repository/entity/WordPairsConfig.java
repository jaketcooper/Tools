package com.safonov.speedreading.training.fragment.wordpairs.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import p006io.realm.RealmObject;
import p006io.realm.WordPairsConfigRealmProxyInterface;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class WordPairsConfig extends RealmObject implements IdentityRealmObject, WordPairsConfigRealmProxyInterface {
    public static final String FIELD_COLUMN_COUNT = "columnCount";
    public static final String FIELD_DIFFERENT_WORD_PAIRS_COUNT = "differentWordPairsCount";
    public static final String FIELD_ROW_COUNT = "rowCount";
    public static final String FIELD_TRAINING_DURATION = "trainingDuration";
    private int columnCount;
    private int differentWordPairsCount;
    @PrimaryKey

    /* renamed from: id */
    private int f134id;
    private int rowCount;
    private int trainingDuration;

    public int realmGet$columnCount() {
        return this.columnCount;
    }

    public int realmGet$differentWordPairsCount() {
        return this.differentWordPairsCount;
    }

    public int realmGet$id() {
        return this.f134id;
    }

    public int realmGet$rowCount() {
        return this.rowCount;
    }

    public int realmGet$trainingDuration() {
        return this.trainingDuration;
    }

    public void realmSet$columnCount(int i) {
        this.columnCount = i;
    }

    public void realmSet$differentWordPairsCount(int i) {
        this.differentWordPairsCount = i;
    }

    public void realmSet$id(int i) {
        this.f134id = i;
    }

    public void realmSet$rowCount(int i) {
        this.rowCount = i;
    }

    public void realmSet$trainingDuration(int i) {
        this.trainingDuration = i;
    }

    public WordPairsConfig() {
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

    public int getDifferentWordPairsCount() {
        return realmGet$differentWordPairsCount();
    }

    public void setDifferentWordPairsCount(int differentWordPairsCount2) {
        realmSet$differentWordPairsCount(differentWordPairsCount2);
    }

    public int getTrainingDuration() {
        return realmGet$trainingDuration();
    }

    public void setTrainingDuration(int trainingDuration2) {
        realmSet$trainingDuration(trainingDuration2);
    }
}
