package com.safonov.speedreading.training.fragment.cuptimer.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.UnixTimeRealmObject;
import p006io.realm.CupTimerResultRealmProxyInterface;
import p006io.realm.RealmObject;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class CupTimerResult extends RealmObject implements IdentityRealmObject, UnixTimeRealmObject, CupTimerResultRealmProxyInterface {
    public static final String FIELD_CONFIG_ID = "config.id";
    private CupTimerConfig config;
    @PrimaryKey

    /* renamed from: id */
    private int f111id;
    private long unixTime;

    public CupTimerConfig realmGet$config() {
        return this.config;
    }

    public int realmGet$id() {
        return this.f111id;
    }

    public long realmGet$unixTime() {
        return this.unixTime;
    }

    public void realmSet$config(CupTimerConfig cupTimerConfig) {
        this.config = cupTimerConfig;
    }

    public void realmSet$id(int i) {
        this.f111id = i;
    }

    public void realmSet$unixTime(long j) {
        this.unixTime = j;
    }

    public CupTimerResult() {
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

    public CupTimerConfig getConfig() {
        return realmGet$config();
    }

    public void setConfig(CupTimerConfig config2) {
        realmSet$config(config2);
    }
}
