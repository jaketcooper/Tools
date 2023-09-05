package com.safonov.speedreading.training.fragment.lineofsight.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import p006io.realm.LineOfSightConfigRealmProxyInterface;
import p006io.realm.RealmObject;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class LineOfSightConfig extends RealmObject implements IdentityRealmObject, LineOfSightConfigRealmProxyInterface {
    public static final String FIELD_COLUMN_COUNT = "columnCount";
    public static final String FIELD_MISTAKE_PROBABILITY = "mistakeProbability";
    public static final String FIELD_ROW_COUNT = "rowCount";
    public static final String FIELD_SHOW_COUNT = "showCount";
    public static final String FIELD_SHOW_DELAY = "showDelay";
    public static final String FIELD_TYPE = "fieldType";
    public static final int FIELD_TYPE_LARGE = 1;
    public static final int FIELD_TYPE_SMALL = 0;
    private int columnCount;
    private int fieldType;
    @PrimaryKey

    /* renamed from: id */
    private int f119id;
    private int mistakeProbability;
    private int rowCount;
    private int showCount;
    private long showDelay;

    public int realmGet$columnCount() {
        return this.columnCount;
    }

    public int realmGet$fieldType() {
        return this.fieldType;
    }

    public int realmGet$id() {
        return this.f119id;
    }

    public int realmGet$mistakeProbability() {
        return this.mistakeProbability;
    }

    public int realmGet$rowCount() {
        return this.rowCount;
    }

    public int realmGet$showCount() {
        return this.showCount;
    }

    public long realmGet$showDelay() {
        return this.showDelay;
    }

    public void realmSet$columnCount(int i) {
        this.columnCount = i;
    }

    public void realmSet$fieldType(int i) {
        this.fieldType = i;
    }

    public void realmSet$id(int i) {
        this.f119id = i;
    }

    public void realmSet$mistakeProbability(int i) {
        this.mistakeProbability = i;
    }

    public void realmSet$rowCount(int i) {
        this.rowCount = i;
    }

    public void realmSet$showCount(int i) {
        this.showCount = i;
    }

    public void realmSet$showDelay(long j) {
        this.showDelay = j;
    }

    public LineOfSightConfig() {
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

    public int getFieldType() {
        return realmGet$fieldType();
    }

    public void setFieldType(int fieldType2) {
        realmSet$fieldType(fieldType2);
    }

    public int getShowCount() {
        return realmGet$showCount();
    }

    public void setShowCount(int showCount2) {
        realmSet$showCount(showCount2);
    }

    public long getShowDelay() {
        return realmGet$showDelay();
    }

    public void setShowDelay(long showDelay2) {
        realmSet$showDelay(showDelay2);
    }

    public int getMistakeProbability() {
        return realmGet$mistakeProbability();
    }

    public void setMistakeProbability(int mistakeProbability2) {
        realmSet$mistakeProbability(mistakeProbability2);
    }
}
