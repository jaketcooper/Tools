package com.safonov.speedreading.training.fragment.math.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import p006io.realm.MathConfigRealmProxyInterface;
import p006io.realm.RealmObject;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class MathConfig extends RealmObject implements IdentityRealmObject, MathConfigRealmProxyInterface {
    public static final String FIELD_COMPLEXITY = "complexity";
    public static final String FIELD_DURATION = "duration";
    private int complexity;
    private long duration;
    @PrimaryKey

    /* renamed from: id */
    private int f121id;

    public int realmGet$complexity() {
        return this.complexity;
    }

    public long realmGet$duration() {
        return this.duration;
    }

    public int realmGet$id() {
        return this.f121id;
    }

    public void realmSet$complexity(int i) {
        this.complexity = i;
    }

    public void realmSet$duration(long j) {
        this.duration = j;
    }

    public void realmSet$id(int i) {
        this.f121id = i;
    }

    public MathConfig() {
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

    public int getComplexity() {
        return realmGet$complexity();
    }

    public void setComplexity(int complexity2) {
        realmSet$complexity(complexity2);
    }

    public long getDuration() {
        return realmGet$duration();
    }

    public void setDuration(long duration2) {
        realmSet$duration(duration2);
    }
}
