package com.safonov.speedreading.training.fragment.rememberwords.repository.entity;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import p006io.realm.RealmObject;
import p006io.realm.RememberWordsConfigRealmProxyInterface;
import p006io.realm.annotations.PrimaryKey;
import p006io.realm.internal.RealmObjectProxy;

public class RememberWordsConfig extends RealmObject implements IdentityRealmObject, RememberWordsConfigRealmProxyInterface {
    public static final String FIELD_START_WORDS_COUNT = "startWordsCount";
    @PrimaryKey

    /* renamed from: id */
    private int f126id;
    private int startWordsCount;

    public int realmGet$id() {
        return this.f126id;
    }

    public int realmGet$startWordsCount() {
        return this.startWordsCount;
    }

    public void realmSet$id(int i) {
        this.f126id = i;
    }

    public void realmSet$startWordsCount(int i) {
        this.startWordsCount = i;
    }

    public RememberWordsConfig() {
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

    public int getStartWordsCount() {
        return realmGet$startWordsCount();
    }

    public void setStartWordsCount(int startWordsCount2) {
        realmSet$startWordsCount(startWordsCount2);
    }
}
