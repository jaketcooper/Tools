package com.safonov.speedreading.training.fragment.concentration.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import p006io.realm.ConcentrationConfigRealmProxyInterface;
import p006io.realm.RealmObject;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class ConcentrationConfig extends RealmObject implements IdentityRealmObject, ConcentrationConfigRealmProxyInterface {
    public static final String FIELD_CIRCLES_COUNT = "circlesCount";
    public static final String FIELD_CIRCLES_RADIUS = "circlesRadius";
    public static final String FIELD_CIRCLES_SPEED = "circlesSpeed";
    public static final String FIELD_GRAY_TIME = "grayTime";
    private int circlesCount;
    private int circlesCountCustom;
    private int circlesRadius;
    private int circlesSizeCustom;
    private int circlesSpeed;
    private int circlesSpeedCustom;
    private int complexity;
    private int grayTime;
    @PrimaryKey

    /* renamed from: id */
    private int f108id;

    public int realmGet$circlesCount() {
        return this.circlesCount;
    }

    public int realmGet$circlesCountCustom() {
        return this.circlesCountCustom;
    }

    public int realmGet$circlesRadius() {
        return this.circlesRadius;
    }

    public int realmGet$circlesSizeCustom() {
        return this.circlesSizeCustom;
    }

    public int realmGet$circlesSpeed() {
        return this.circlesSpeed;
    }

    public int realmGet$circlesSpeedCustom() {
        return this.circlesSpeedCustom;
    }

    public int realmGet$complexity() {
        return this.complexity;
    }

    public int realmGet$grayTime() {
        return this.grayTime;
    }

    public int realmGet$id() {
        return this.f108id;
    }

    public void realmSet$circlesCount(int i) {
        this.circlesCount = i;
    }

    public void realmSet$circlesCountCustom(int i) {
        this.circlesCountCustom = i;
    }

    public void realmSet$circlesRadius(int i) {
        this.circlesRadius = i;
    }

    public void realmSet$circlesSizeCustom(int i) {
        this.circlesSizeCustom = i;
    }

    public void realmSet$circlesSpeed(int i) {
        this.circlesSpeed = i;
    }

    public void realmSet$circlesSpeedCustom(int i) {
        this.circlesSpeedCustom = i;
    }

    public void realmSet$complexity(int i) {
        this.complexity = i;
    }

    public void realmSet$grayTime(int i) {
        this.grayTime = i;
    }

    public void realmSet$id(int i) {
        this.f108id = i;
    }

    public ConcentrationConfig() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public int getCirclesSpeedCustom() {
        return realmGet$circlesSpeedCustom();
    }

    public void setCirclesSpeedCustom(int circlesSpeedCustom2) {
        realmSet$circlesSpeedCustom(circlesSpeedCustom2);
    }

    public int getCirclesSizeCustom() {
        return realmGet$circlesSizeCustom();
    }

    public void setCirclesSizeCustom(int circlesSizeCustom2) {
        realmSet$circlesSizeCustom(circlesSizeCustom2);
    }

    public int getCirclesCountCustom() {
        return realmGet$circlesCountCustom();
    }

    public void setCirclesCountCustom(int circlesCountCustom2) {
        realmSet$circlesCountCustom(circlesCountCustom2);
    }

    public int getGrayTime() {
        return realmGet$grayTime();
    }

    public void setGrayTime(int grayTime2) {
        realmSet$grayTime(grayTime2);
    }

    public int getCirclesCount() {
        return realmGet$circlesCount();
    }

    public void setCirclesCount(int circlesCount2) {
        realmSet$circlesCount(circlesCount2);
    }

    public int getCirclesRadius() {
        return realmGet$circlesRadius();
    }

    public void setCirclesRadius(int circlesRadius2) {
        realmSet$circlesRadius(circlesRadius2);
    }

    public int getCirclesSpeed() {
        return realmGet$circlesSpeed();
    }

    public void setCirclesSpeed(int circlesSpeed2) {
        realmSet$circlesSpeed(circlesSpeed2);
    }

    public int getComplexity() {
        return realmGet$complexity();
    }

    public void setComplexity(int complexity2) {
        realmSet$complexity(complexity2);
    }

    public void setId(int id) {
        realmSet$id(id);
    }

    public int getId() {
        return realmGet$id();
    }
}
