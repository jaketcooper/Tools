package com.safonov.speedreading.training.fragment.wordsblock.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.UnixTimeRealmObject;
import p006io.realm.RealmObject;
import p006io.realm.WordBlockResultRealmProxyInterface;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class WordBlockResult extends RealmObject implements IdentityRealmObject, UnixTimeRealmObject, WordBlockResultRealmProxyInterface {
    private WordBlockConfig config;
    @PrimaryKey

    /* renamed from: id */
    private int f137id;
    private long unixTime;

    public WordBlockConfig realmGet$config() {
        return this.config;
    }

    public int realmGet$id() {
        return this.f137id;
    }

    public long realmGet$unixTime() {
        return this.unixTime;
    }

    public void realmSet$config(WordBlockConfig wordBlockConfig) {
        this.config = wordBlockConfig;
    }

    public void realmSet$id(int i) {
        this.f137id = i;
    }

    public void realmSet$unixTime(long j) {
        this.unixTime = j;
    }

    public WordBlockResult() {
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

    public WordBlockConfig getConfig() {
        return realmGet$config();
    }

    public void setConfig(WordBlockConfig config2) {
        realmSet$config(config2);
    }
}
