package p006io.realm.exceptions;

import p006io.realm.internal.Keep;

@Keep
/* renamed from: io.realm.exceptions.RealmError */
public final class RealmError extends Error {
    public RealmError(String detailMessage) {
        super(detailMessage);
    }
}
