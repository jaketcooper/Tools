package com.safonov.speedreading.training.fragment.schultetable.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import p006io.realm.RealmObject;
import p006io.realm.SchulteTableConfigRealmProxyInterface;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class SchulteTableConfig extends RealmObject implements IdentityRealmObject, SchulteTableConfigRealmProxyInterface {
    public static final String FIELD_COLUMN_COUNT = "columnCount";
    public static final String FIELD_FULLSCREEN = "isFullscreen";
    public static final String FIELD_ROW_COUNT = "rowCount";
    private int columnCount;
    @PrimaryKey

    /* renamed from: id */
    private int f128id;
    private boolean isFullscreen;
    private int rowCount;

    public int realmGet$columnCount() {
        return this.columnCount;
    }

    public int realmGet$id() {
        return this.f128id;
    }

    public boolean realmGet$isFullscreen() {
        return this.isFullscreen;
    }

    public int realmGet$rowCount() {
        return this.rowCount;
    }

    public void realmSet$columnCount(int i) {
        this.columnCount = i;
    }

    public void realmSet$id(int i) {
        this.f128id = i;
    }

    public void realmSet$isFullscreen(boolean z) {
        this.isFullscreen = z;
    }

    public void realmSet$rowCount(int i) {
        this.rowCount = i;
    }

    public SchulteTableConfig() {
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

    public boolean isFullscreen() {
        return realmGet$isFullscreen();
    }

    public void setFullscreen(boolean fullscreen) {
        realmSet$isFullscreen(fullscreen);
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
}
