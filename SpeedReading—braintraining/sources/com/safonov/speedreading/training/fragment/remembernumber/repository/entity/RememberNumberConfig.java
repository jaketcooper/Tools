package com.safonov.speedreading.training.fragment.remembernumber.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import p006io.realm.RealmObject;
import p006io.realm.RememberNumberConfigRealmProxyInterface;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class RememberNumberConfig extends RealmObject implements IdentityRealmObject, RememberNumberConfigRealmProxyInterface {
    public static final String FIELD_ANSWERS_TO_COMPLEXITY_DOWN = "answersToComplexityDown";
    public static final String FIELD_ANSWERS_TO_COMPLEXITY_UP = "answersToComplexityUp";
    public static final String FIELD_COMPLEXITY = "complexity";
    public static final String FIELD_MAX_COMPLEXITY = "maxComplexity";
    public static final String FIELD_MIN_COMPLEXITY = "minComplexity";
    public static final String FIELD_TRAINING_SHOW_COUNT = "trainingShowCount";
    private int answersToComplexityDown;
    private int answersToComplexityUp;
    private int complexity;
    @PrimaryKey

    /* renamed from: id */
    private int f124id;
    private int maxComplexity;
    private int minComplexity;
    private int trainingShowCount;

    public int realmGet$answersToComplexityDown() {
        return this.answersToComplexityDown;
    }

    public int realmGet$answersToComplexityUp() {
        return this.answersToComplexityUp;
    }

    public int realmGet$complexity() {
        return this.complexity;
    }

    public int realmGet$id() {
        return this.f124id;
    }

    public int realmGet$maxComplexity() {
        return this.maxComplexity;
    }

    public int realmGet$minComplexity() {
        return this.minComplexity;
    }

    public int realmGet$trainingShowCount() {
        return this.trainingShowCount;
    }

    public void realmSet$answersToComplexityDown(int i) {
        this.answersToComplexityDown = i;
    }

    public void realmSet$answersToComplexityUp(int i) {
        this.answersToComplexityUp = i;
    }

    public void realmSet$complexity(int i) {
        this.complexity = i;
    }

    public void realmSet$id(int i) {
        this.f124id = i;
    }

    public void realmSet$maxComplexity(int i) {
        this.maxComplexity = i;
    }

    public void realmSet$minComplexity(int i) {
        this.minComplexity = i;
    }

    public void realmSet$trainingShowCount(int i) {
        this.trainingShowCount = i;
    }

    public RememberNumberConfig() {
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

    public int getTrainingShowCount() {
        return realmGet$trainingShowCount();
    }

    public void setTrainingShowCount(int trainingShowCount2) {
        realmSet$trainingShowCount(trainingShowCount2);
    }

    public int getMinComplexity() {
        return realmGet$minComplexity();
    }

    public void setMinComplexity(int minComplexity2) {
        realmSet$minComplexity(minComplexity2);
    }

    public int getMaxComplexity() {
        return realmGet$maxComplexity();
    }

    public void setMaxComplexity(int maxComplexity2) {
        realmSet$maxComplexity(maxComplexity2);
    }

    public int getComplexity() {
        return realmGet$complexity();
    }

    public void setComplexity(int complexity2) {
        realmSet$complexity(complexity2);
    }

    public int getAnswersToComplexityUp() {
        return realmGet$answersToComplexityUp();
    }

    public void setAnswersToComplexityUp(int answersToComplexityUp2) {
        realmSet$answersToComplexityUp(answersToComplexityUp2);
    }

    public int getAnswersToComplexityDown() {
        return realmGet$answersToComplexityDown();
    }

    public void setAnswersToComplexityDown(int answersToComplexityDown2) {
        realmSet$answersToComplexityDown(answersToComplexityDown2);
    }
}
