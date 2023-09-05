package com.safonov.speedreading.training.fragment.concentration.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import p006io.realm.ConcentrationResultRealmProxyInterface;
import p006io.realm.RealmObject;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class ConcentrationResult extends RealmObject implements IdentityRealmObject, ConcentrationResultRealmProxyInterface {
    public static final String FIELD_CONFIG_ID = "config.id";
    public static final String FIELD_SCORE = "score";
    private ConcentrationConfig config;
    @PrimaryKey

    /* renamed from: id */
    private int f109id;
    private int score;

    public ConcentrationConfig realmGet$config() {
        return this.config;
    }

    public int realmGet$id() {
        return this.f109id;
    }

    public int realmGet$score() {
        return this.score;
    }

    public void realmSet$config(ConcentrationConfig concentrationConfig) {
        this.config = concentrationConfig;
    }

    public void realmSet$id(int i) {
        this.f109id = i;
    }

    public void realmSet$score(int i) {
        this.score = i;
    }

    public ConcentrationResult() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public int getScore() {
        return realmGet$score();
    }

    public void setScore(int score2) {
        realmSet$score(score2);
    }

    public ConcentrationConfig getConfig() {
        return realmGet$config();
    }

    public void setConfig(ConcentrationConfig config2) {
        realmSet$config(config2);
    }

    public void setId(int id) {
        realmSet$id(id);
    }

    public int getId() {
        return realmGet$id();
    }
}
