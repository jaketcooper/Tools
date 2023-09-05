package com.safonov.speedreading.training.fragment.greendot.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import p006io.realm.GreenDotConfigRealmProxyInterface;
import p006io.realm.RealmObject;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class GreenDotConfig extends RealmObject implements IdentityRealmObject, GreenDotConfigRealmProxyInterface {
    public static final String FIELD_DURATION = "duration";
    private long duration;
    @PrimaryKey

    /* renamed from: id */
    private int f117id;

    public long realmGet$duration() {
        return this.duration;
    }

    public int realmGet$id() {
        return this.f117id;
    }

    public void realmSet$duration(long j) {
        this.duration = j;
    }

    public void realmSet$id(int i) {
        this.f117id = i;
    }

    public GreenDotConfig() {
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
}
