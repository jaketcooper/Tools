package com.safonov.speedreading.application.realm;

import android.support.annotation.NonNull;
import p006io.realm.Realm;
import p006io.realm.RealmObject;

public abstract class RealmUtil {
    protected Realm realm;

    public RealmUtil(@NonNull Realm realm2) {
        this.realm = realm2;
    }

    /* access modifiers changed from: protected */
    public int getNextId(Class<? extends RealmObject> realmObjectClass) {
        Number currentId = this.realm.where(realmObjectClass).max(IdentityRealmObject.FIELD_ID);
        if (currentId == null) {
            return 1;
        }
        return currentId.intValue() + 1;
    }

    public void close() {
        this.realm.close();
        this.realm = null;
    }
}
