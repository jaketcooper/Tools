package com.safonov.speedreading.training.fragment.evennumbers.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.UnixTimeRealmObject;
import p006io.realm.EvenNumbersResultRealmProxyInterface;
import p006io.realm.RealmObject;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class EvenNumbersResult extends RealmObject implements IdentityRealmObject, UnixTimeRealmObject, EvenNumbersResultRealmProxyInterface {
    public static final String FIELD_CONFIG_ID = "config.id";
    public static final String FIELD_SCORE = "score";
    private EvenNumbersConfig config;
    @PrimaryKey

    /* renamed from: id */
    private int f113id;
    private int score;
    private long unixTime;

    public EvenNumbersConfig realmGet$config() {
        return this.config;
    }

    public int realmGet$id() {
        return this.f113id;
    }

    public int realmGet$score() {
        return this.score;
    }

    public long realmGet$unixTime() {
        return this.unixTime;
    }

    public void realmSet$config(EvenNumbersConfig evenNumbersConfig) {
        this.config = evenNumbersConfig;
    }

    public void realmSet$id(int i) {
        this.f113id = i;
    }

    public void realmSet$score(int i) {
        this.score = i;
    }

    public void realmSet$unixTime(long j) {
        this.unixTime = j;
    }

    public EvenNumbersResult() {
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

    public EvenNumbersConfig getConfig() {
        return realmGet$config();
    }

    public void setConfig(EvenNumbersConfig config2) {
        realmSet$config(config2);
    }
}
