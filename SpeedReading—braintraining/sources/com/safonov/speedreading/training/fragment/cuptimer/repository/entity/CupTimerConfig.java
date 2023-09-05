package com.safonov.speedreading.training.fragment.cuptimer.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import p006io.realm.CupTimerConfigRealmProxyInterface;
import p006io.realm.RealmObject;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class CupTimerConfig extends RealmObject implements IdentityRealmObject, CupTimerConfigRealmProxyInterface {
    public static final String FIELD_DURATION = "duration";
    public static final String FIELD_TYPE = "type";
    private long duration;
    @PrimaryKey

    /* renamed from: id */
    private int f110id;
    private int type;

    public long realmGet$duration() {
        return this.duration;
    }

    public int realmGet$id() {
        return this.f110id;
    }

    public int realmGet$type() {
        return this.type;
    }

    public void realmSet$duration(long j) {
        this.duration = j;
    }

    public void realmSet$id(int i) {
        this.f110id = i;
    }

    public void realmSet$type(int i) {
        this.type = i;
    }

    public CupTimerConfig() {
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

    public long getDuration() {
        return realmGet$duration();
    }

    public void setDuration(long duration2) {
        realmSet$duration(duration2);
    }

    public void setType(int type2) {
        realmSet$type(type2);
    }

    public int getType() {
        return realmGet$type();
    }
}
