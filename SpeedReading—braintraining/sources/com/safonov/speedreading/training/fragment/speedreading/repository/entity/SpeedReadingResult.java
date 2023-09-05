package com.safonov.speedreading.training.fragment.speedreading.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.application.realm.UnixTimeRealmObject;
import p006io.realm.RealmObject;
import p006io.realm.SpeedReadingResultRealmProxyInterface;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class SpeedReadingResult extends RealmObject implements IdentityRealmObject, UnixTimeRealmObject, SpeedReadingResultRealmProxyInterface {
    public static final String FIELD_AVERAGE_SPEED = "averageSpeed";
    public static final String FIELD_CONFIG_ID = "config.id";
    public static final String FIELD_MAX_SPEED = "maxSpeed";
    private int averageSpeed;
    private SpeedReadingConfig config;
    @PrimaryKey

    /* renamed from: id */
    private int f131id;
    private int maxSpeed;
    private long unixTime;

    public int realmGet$averageSpeed() {
        return this.averageSpeed;
    }

    public SpeedReadingConfig realmGet$config() {
        return this.config;
    }

    public int realmGet$id() {
        return this.f131id;
    }

    public int realmGet$maxSpeed() {
        return this.maxSpeed;
    }

    public long realmGet$unixTime() {
        return this.unixTime;
    }

    public void realmSet$averageSpeed(int i) {
        this.averageSpeed = i;
    }

    public void realmSet$config(SpeedReadingConfig speedReadingConfig) {
        this.config = speedReadingConfig;
    }

    public void realmSet$id(int i) {
        this.f131id = i;
    }

    public void realmSet$maxSpeed(int i) {
        this.maxSpeed = i;
    }

    public void realmSet$unixTime(long j) {
        this.unixTime = j;
    }

    public SpeedReadingResult() {
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

    public int getMaxSpeed() {
        return realmGet$maxSpeed();
    }

    public void setMaxSpeed(int maxSpeed2) {
        realmSet$maxSpeed(maxSpeed2);
    }

    public int getAverageSpeed() {
        return realmGet$averageSpeed();
    }

    public void setAverageSpeed(int averageSpeed2) {
        realmSet$averageSpeed(averageSpeed2);
    }

    public long getUnixTime() {
        return realmGet$unixTime();
    }

    public void setUnixTime(long unixTime2) {
        realmSet$unixTime(unixTime2);
    }

    public SpeedReadingConfig getConfig() {
        return realmGet$config();
    }

    public void setConfig(SpeedReadingConfig config2) {
        realmSet$config(config2);
    }
}
