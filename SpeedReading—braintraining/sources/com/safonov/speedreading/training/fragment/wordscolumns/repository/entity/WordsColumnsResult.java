package com.safonov.speedreading.training.fragment.wordscolumns.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.UnixTimeRealmObject;
import p006io.realm.RealmObject;
import p006io.realm.WordsColumnsResultRealmProxyInterface;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class WordsColumnsResult extends RealmObject implements IdentityRealmObject, UnixTimeRealmObject, WordsColumnsResultRealmProxyInterface {
    private WordsColumnsConfig config;
    @PrimaryKey

    /* renamed from: id */
    private int f139id;
    private long unixTime;

    public WordsColumnsConfig realmGet$config() {
        return this.config;
    }

    public int realmGet$id() {
        return this.f139id;
    }

    public long realmGet$unixTime() {
        return this.unixTime;
    }

    public void realmSet$config(WordsColumnsConfig wordsColumnsConfig) {
        this.config = wordsColumnsConfig;
    }

    public void realmSet$id(int i) {
        this.f139id = i;
    }

    public void realmSet$unixTime(long j) {
        this.unixTime = j;
    }

    public WordsColumnsResult() {
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

    public WordsColumnsConfig getConfig() {
        return realmGet$config();
    }

    public void setConfig(WordsColumnsConfig config2) {
        realmSet$config(config2);
    }
}
