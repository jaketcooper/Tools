package com.safonov.speedreading.training.fragment.evennumbers.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import p006io.realm.EvenNumbersConfigRealmProxyInterface;
import p006io.realm.RealmObject;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class EvenNumbersConfig extends RealmObject implements IdentityRealmObject, EvenNumbersConfigRealmProxyInterface {
    public static final String FIELD_COLUMN_COUNT = "columnCount";
    public static final String FIELD_DIGITS_PER_NUMBER = "digitsPerNumber";
    public static final String FIELD_EVEN_NUMBERS_COUNT = "evenNumberCount";
    public static final String FIELD_ROW_COUNT = "rowCount";
    public static final String FIELD_TRAINING_DURATION = "trainingDuration";
    private int columnCount;
    private int digitsPerNumber;
    private int evenNumberCount;
    @PrimaryKey

    /* renamed from: id */
    private int f112id;
    private int rowCount;
    private int trainingDuration;

    public int realmGet$columnCount() {
        return this.columnCount;
    }

    public int realmGet$digitsPerNumber() {
        return this.digitsPerNumber;
    }

    public int realmGet$evenNumberCount() {
        return this.evenNumberCount;
    }

    public int realmGet$id() {
        return this.f112id;
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

    public void realmSet$digitsPerNumber(int i) {
        this.digitsPerNumber = i;
    }

    public void realmSet$evenNumberCount(int i) {
        this.evenNumberCount = i;
    }

    public void realmSet$id(int i) {
        this.f112id = i;
    }

    public void realmSet$rowCount(int i) {
        this.rowCount = i;
    }

    public void realmSet$trainingDuration(int i) {
        this.trainingDuration = i;
    }

    public EvenNumbersConfig() {
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

    public int getEvenNumberCount() {
        return realmGet$evenNumberCount();
    }

    public void setEvenNumberCount(int evenNumberCount2) {
        realmSet$evenNumberCount(evenNumberCount2);
    }

    public int getDigitsPerNumber() {
        return realmGet$digitsPerNumber();
    }

    public void setDigitsPerNumber(int digitsPerNumber2) {
        realmSet$digitsPerNumber(digitsPerNumber2);
    }

    public int getTrainingDuration() {
        return realmGet$trainingDuration();
    }

    public void setTrainingDuration(int trainingDuration2) {
        realmSet$trainingDuration(trainingDuration2);
    }
}
