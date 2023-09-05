package com.safonov.speedreading.training.fragment.greendot.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.UnixTimeRealmObject;
import p006io.realm.GreenDotResultRealmProxyInterface;
import p006io.realm.RealmObject;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class GreenDotResult extends RealmObject implements IdentityRealmObject, UnixTimeRealmObject, GreenDotResultRealmProxyInterface {
    public static final String FIELD_CONFIG_ID = "config.id";
    private GreenDotConfig config;
    @PrimaryKey

    /* renamed from: id */
    private int f118id;
    private long unixTime;

    public GreenDotConfig realmGet$config() {
        return this.config;
    }

    public int realmGet$id() {
        return this.f118id;
    }

    public long realmGet$unixTime() {
        return this.unixTime;
    }

    public void realmSet$config(GreenDotConfig greenDotConfig) {
        this.config = greenDotConfig;
    }

    public void realmSet$id(int i) {
        this.f118id = i;
    }

    public void realmSet$unixTime(long j) {
        this.unixTime = j;
    }

    public GreenDotResult() {
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

    public long getUnixTime() {
        return realmGet$unixTime();
    }

    public void setUnixTime(long unixTime2) {
        realmSet$unixTime(unixTime2);
    }

    public GreenDotConfig getConfig() {
        return realmGet$config();
    }

    public void setConfig(GreenDotConfig config2) {
        realmSet$config(config2);
    }
}
