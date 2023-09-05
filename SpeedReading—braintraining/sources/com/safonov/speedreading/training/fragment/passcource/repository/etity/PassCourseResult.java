package com.safonov.speedreading.training.fragment.passcource.repository.etity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.UnixTimeRealmObject;
import p006io.realm.PassCourseResultRealmProxyInterface;
import p006io.realm.RealmObject;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class PassCourseResult extends RealmObject implements IdentityRealmObject, UnixTimeRealmObject, PassCourseResultRealmProxyInterface {
    public static final String FIELD_SCORE = "score";
    @PrimaryKey

    /* renamed from: id */
    private int f123id;
    private int score;
    private int type;
    private long unixTime;

    public int realmGet$id() {
        return this.f123id;
    }

    public int realmGet$score() {
        return this.score;
    }

    public int realmGet$type() {
        return this.type;
    }

    public long realmGet$unixTime() {
        return this.unixTime;
    }

    public void realmSet$id(int i) {
        this.f123id = i;
    }

    public void realmSet$score(int i) {
        this.score = i;
    }

    public void realmSet$type(int i) {
        this.type = i;
    }

    public void realmSet$unixTime(long j) {
        this.unixTime = j;
    }

    public PassCourseResult() {
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

    public int getId() {
        return realmGet$id();
    }

    public void setId(int id) {
        realmSet$id(id);
    }

    public int getType() {
        return realmGet$type();
    }

    public void setType(int type2) {
        realmSet$type(type2);
    }

    public long getUnixTime() {
        return realmGet$unixTime();
    }

    public void setUnixTime(long unixTime2) {
        realmSet$unixTime(unixTime2);
    }
}
