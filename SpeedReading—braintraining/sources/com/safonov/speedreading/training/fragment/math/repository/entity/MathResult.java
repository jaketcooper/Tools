package com.safonov.speedreading.training.fragment.math.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import p006io.realm.MathResultRealmProxyInterface;
import p006io.realm.RealmObject;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class MathResult extends RealmObject implements IdentityRealmObject, MathResultRealmProxyInterface {
    public static final String FIELD_CONFIG_ID = "config.id";
    public static final String FIELD_SCORE = "score";
    private MathConfig config;
    @PrimaryKey

    /* renamed from: id */
    private int f122id;
    private int score;

    public MathConfig realmGet$config() {
        return this.config;
    }

    public int realmGet$id() {
        return this.f122id;
    }

    public int realmGet$score() {
        return this.score;
    }

    public void realmSet$config(MathConfig mathConfig) {
        this.config = mathConfig;
    }

    public void realmSet$id(int i) {
        this.f122id = i;
    }

    public void realmSet$score(int i) {
        this.score = i;
    }

    public MathResult() {
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

    public MathConfig getConfig() {
        return realmGet$config();
    }

    public void setConfig(MathConfig config2) {
        realmSet$config(config2);
    }
}
