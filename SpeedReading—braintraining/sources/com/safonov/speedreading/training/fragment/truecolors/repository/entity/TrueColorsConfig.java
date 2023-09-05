package com.safonov.speedreading.training.fragment.truecolors.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import p006io.realm.RealmObject;
import p006io.realm.TrueColorsConfigRealmProxyInterface;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class TrueColorsConfig extends RealmObject implements IdentityRealmObject, TrueColorsConfigRealmProxyInterface {
    public static final String FIELD_SHOW_TIME = "showTime";
    @PrimaryKey

    /* renamed from: id */
    private int f132id;
    private int showTime;

    public int realmGet$id() {
        return this.f132id;
    }

    public int realmGet$showTime() {
        return this.showTime;
    }

    public void realmSet$id(int i) {
        this.f132id = i;
    }

    public void realmSet$showTime(int i) {
        this.showTime = i;
    }

    public TrueColorsConfig() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public int getShowTime() {
        return realmGet$showTime();
    }

    public void setShowTime(int showTime2) {
        realmSet$showTime(showTime2);
    }

    public int getId() {
        return realmGet$id();
    }

    public void setId(int id) {
        realmSet$id(id);
    }
}
