package com.safonov.speedreading.training.fragment.remembernumber.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.UnixTimeRealmObject;
import p006io.realm.RealmObject;
import p006io.realm.RememberNumberResultRealmProxyInterface;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class RememberNumberResult extends RealmObject implements IdentityRealmObject, UnixTimeRealmObject, RememberNumberResultRealmProxyInterface {
    public static final String FIELD_CONFIG_ID = "config.id";
    public static final String FIELD_SCORE = "score";
    private RememberNumberConfig config;
    @PrimaryKey

    /* renamed from: id */
    private int f125id;
    private int score;
    private long unixTime;

    public RememberNumberConfig realmGet$config() {
        return this.config;
    }

    public int realmGet$id() {
        return this.f125id;
    }

    public int realmGet$score() {
        return this.score;
    }

    public long realmGet$unixTime() {
        return this.unixTime;
    }

    public void realmSet$config(RememberNumberConfig rememberNumberConfig) {
        this.config = rememberNumberConfig;
    }

    public void realmSet$id(int i) {
        this.f125id = i;
    }

    public void realmSet$score(int i) {
        this.score = i;
    }

    public void realmSet$unixTime(long j) {
        this.unixTime = j;
    }

    public RememberNumberResult() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public void setId(int id) {
        realmSet$id(id);
    }

    public int getId() {
        return realmGet$id();
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

    public RememberNumberConfig getConfig() {
        return realmGet$config();
    }

    public void setConfig(RememberNumberConfig config2) {
        realmSet$config(config2);
    }
}
