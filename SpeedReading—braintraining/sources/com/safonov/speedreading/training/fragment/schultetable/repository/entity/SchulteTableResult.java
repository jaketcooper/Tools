package com.safonov.speedreading.training.fragment.schultetable.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.UnixTimeRealmObject;
import p006io.realm.RealmObject;
import p006io.realm.SchulteTableResultRealmProxyInterface;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class SchulteTableResult extends RealmObject implements IdentityRealmObject, UnixTimeRealmObject, SchulteTableResultRealmProxyInterface {
    public static final String FIELD_CONFIG_ID = "config.id";
    public static final String FIELD_TIME = "time";
    private SchulteTableConfig config;
    @PrimaryKey

    /* renamed from: id */
    private int f129id;
    private long time;
    private long unixTime;

    public SchulteTableConfig realmGet$config() {
        return this.config;
    }

    public int realmGet$id() {
        return this.f129id;
    }

    public long realmGet$time() {
        return this.time;
    }

    public long realmGet$unixTime() {
        return this.unixTime;
    }

    public void realmSet$config(SchulteTableConfig schulteTableConfig) {
        this.config = schulteTableConfig;
    }

    public void realmSet$id(int i) {
        this.f129id = i;
    }

    public void realmSet$time(long j) {
        this.time = j;
    }

    public void realmSet$unixTime(long j) {
        this.unixTime = j;
    }

    public SchulteTableResult() {
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

    public long getTime() {
        return realmGet$time();
    }

    public void setTime(long time2) {
        realmSet$time(time2);
    }

    public long getUnixTime() {
        return realmGet$unixTime();
    }

    public void setUnixTime(long unixTime2) {
        realmSet$unixTime(unixTime2);
    }

    public SchulteTableConfig getConfig() {
        return realmGet$config();
    }

    public void setConfig(SchulteTableConfig config2) {
        realmSet$config(config2);
    }
}
