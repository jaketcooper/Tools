package com.safonov.speedreading.training.fragment.flashword.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.UnixTimeRealmObject;
import p006io.realm.FlashWordResultRealmProxyInterface;
import p006io.realm.RealmObject;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class FlashWordResult extends RealmObject implements IdentityRealmObject, UnixTimeRealmObject, FlashWordResultRealmProxyInterface {
    private FlashWordsConfig config;
    @PrimaryKey

    /* renamed from: id */
    private int f114id;
    private long unixTime;

    public FlashWordsConfig realmGet$config() {
        return this.config;
    }

    public int realmGet$id() {
        return this.f114id;
    }

    public long realmGet$unixTime() {
        return this.unixTime;
    }

    public void realmSet$config(FlashWordsConfig flashWordsConfig) {
        this.config = flashWordsConfig;
    }

    public void realmSet$id(int i) {
        this.f114id = i;
    }

    public void realmSet$unixTime(long j) {
        this.unixTime = j;
    }

    public FlashWordResult() {
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

    public void setUnixTime(long unixTime2) {
        realmSet$unixTime(unixTime2);
    }

    public long getUnixTime() {
        return realmGet$unixTime();
    }

    public FlashWordsConfig getConfig() {
        return realmGet$config();
    }

    public void setConfig(FlashWordsConfig config2) {
        realmSet$config(config2);
    }
}
