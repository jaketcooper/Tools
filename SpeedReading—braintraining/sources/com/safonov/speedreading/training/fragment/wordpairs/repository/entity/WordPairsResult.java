package com.safonov.speedreading.training.fragment.wordpairs.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.UnixTimeRealmObject;
import p006io.realm.RealmObject;
import p006io.realm.WordPairsResultRealmProxyInterface;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class WordPairsResult extends RealmObject implements IdentityRealmObject, UnixTimeRealmObject, WordPairsResultRealmProxyInterface {
    public static final String FIELD_CONFIG_ID = "config.id";
    public static final String FIELD_SCORE = "score";
    private WordPairsConfig config;
    @PrimaryKey

    /* renamed from: id */
    private int f135id;
    private int score;
    private long unixTime;

    public WordPairsConfig realmGet$config() {
        return this.config;
    }

    public int realmGet$id() {
        return this.f135id;
    }

    public int realmGet$score() {
        return this.score;
    }

    public long realmGet$unixTime() {
        return this.unixTime;
    }

    public void realmSet$config(WordPairsConfig wordPairsConfig) {
        this.config = wordPairsConfig;
    }

    public void realmSet$id(int i) {
        this.f135id = i;
    }

    public void realmSet$score(int i) {
        this.score = i;
    }

    public void realmSet$unixTime(long j) {
        this.unixTime = j;
    }

    public WordPairsResult() {
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

    public int getScore() {
        return realmGet$score();
    }

    public void setScore(int score2) {
        realmSet$score(score2);
    }

    public long getUnixTime() {
        return realmGet$unixTime();
    }

    public void setUnixTime(long unixTime2) {
        realmSet$unixTime(unixTime2);
    }

    public WordPairsConfig getConfig() {
        return realmGet$config();
    }

    public void setConfig(WordPairsConfig config2) {
        realmSet$config(config2);
    }
}
