package com.safonov.speedreading.training.fragment.lineofsight.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.UnixTimeRealmObject;
import p006io.realm.LineOfSightResultRealmProxyInterface;
import p006io.realm.RealmObject;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class LineOfSightResult extends RealmObject implements IdentityRealmObject, UnixTimeRealmObject, LineOfSightResultRealmProxyInterface {
    public static final String FIELD_CONFIG_ID = "config.id";
    public static final String FIELD_FOUND_MISTAKE_COUNT = "foundMistakeCount";
    public static final String FIELD_MISTAKE_COUNT = "mistakeCount";
    private LineOfSightConfig config;
    private int foundMistakeCount;
    @PrimaryKey

    /* renamed from: id */
    private int f120id;
    private int mistakeCount;
    private long unixTime;

    public LineOfSightConfig realmGet$config() {
        return this.config;
    }

    public int realmGet$foundMistakeCount() {
        return this.foundMistakeCount;
    }

    public int realmGet$id() {
        return this.f120id;
    }

    public int realmGet$mistakeCount() {
        return this.mistakeCount;
    }

    public long realmGet$unixTime() {
        return this.unixTime;
    }

    public void realmSet$config(LineOfSightConfig lineOfSightConfig) {
        this.config = lineOfSightConfig;
    }

    public void realmSet$foundMistakeCount(int i) {
        this.foundMistakeCount = i;
    }

    public void realmSet$id(int i) {
        this.f120id = i;
    }

    public void realmSet$mistakeCount(int i) {
        this.mistakeCount = i;
    }

    public void realmSet$unixTime(long j) {
        this.unixTime = j;
    }

    public LineOfSightResult() {
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

    public int getMistakeCount() {
        return realmGet$mistakeCount();
    }

    public void setMistakeCount(int mistakeCount2) {
        realmSet$mistakeCount(mistakeCount2);
    }

    public int getFoundMistakeCount() {
        return realmGet$foundMistakeCount();
    }

    public void setFoundMistakeCount(int foundMistakeCount2) {
        realmSet$foundMistakeCount(foundMistakeCount2);
    }

    public float getFoundMistakesAccuracy() {
        if (realmGet$mistakeCount() == 0 || realmGet$foundMistakeCount() == 0) {
            return 0.0f;
        }
        if (realmGet$mistakeCount() < realmGet$foundMistakeCount()) {
            return ((float) realmGet$mistakeCount()) / ((float) realmGet$foundMistakeCount());
        }
        if (realmGet$mistakeCount() > realmGet$foundMistakeCount()) {
            return ((float) realmGet$foundMistakeCount()) / ((float) realmGet$mistakeCount());
        }
        return 1.0f;
    }

    public long getUnixTime() {
        return realmGet$unixTime();
    }

    public void setUnixTime(long unixTime2) {
        realmSet$unixTime(unixTime2);
    }

    public LineOfSightConfig getConfig() {
        return realmGet$config();
    }

    public void setConfig(LineOfSightConfig config2) {
        realmSet$config(config2);
    }
}
