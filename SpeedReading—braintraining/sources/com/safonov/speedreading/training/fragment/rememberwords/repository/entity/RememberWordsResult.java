package com.safonov.speedreading.training.fragment.rememberwords.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import p006io.realm.RealmObject;
import p006io.realm.RememberWordsResultRealmProxyInterface;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class RememberWordsResult extends RealmObject implements IdentityRealmObject, RememberWordsResultRealmProxyInterface {
    public static final String FIELD_CONFIG_ID = "config.id";
    public static final String FIELD_SCORE = "score";
    private RememberWordsConfig config;
    @PrimaryKey

    /* renamed from: id */
    private int f127id;
    private int score;

    public RememberWordsConfig realmGet$config() {
        return this.config;
    }

    public int realmGet$id() {
        return this.f127id;
    }

    public int realmGet$score() {
        return this.score;
    }

    public void realmSet$config(RememberWordsConfig rememberWordsConfig) {
        this.config = rememberWordsConfig;
    }

    public void realmSet$id(int i) {
        this.f127id = i;
    }

    public void realmSet$score(int i) {
        this.score = i;
    }

    public RememberWordsResult() {
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

    public RememberWordsConfig getConfig() {
        return realmGet$config();
    }

    public void setConfig(RememberWordsConfig config2) {
        realmSet$config(config2);
    }
}
