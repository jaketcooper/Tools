package com.safonov.speedreading.training.fragment.truecolors.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import p006io.realm.RealmObject;
import p006io.realm.TrueColorsResultRealmProxyInterface;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class TrueColorsResult extends RealmObject implements IdentityRealmObject, TrueColorsResultRealmProxyInterface {
    public static final String FIELD_CONFIG_ID = "config.id";
    public static final String FIELD_SCORE = "score";
    private TrueColorsConfig config;
    @PrimaryKey

    /* renamed from: id */
    private int f133id;
    private int score;

    public TrueColorsConfig realmGet$config() {
        return this.config;
    }

    public int realmGet$id() {
        return this.f133id;
    }

    public int realmGet$score() {
        return this.score;
    }

    public void realmSet$config(TrueColorsConfig trueColorsConfig) {
        this.config = trueColorsConfig;
    }

    public void realmSet$id(int i) {
        this.f133id = i;
    }

    public void realmSet$score(int i) {
        this.score = i;
    }

    public TrueColorsResult() {
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

    public TrueColorsConfig getConfig() {
        return realmGet$config();
    }

    public void setConfig(TrueColorsConfig config2) {
        realmSet$config(config2);
    }
}
