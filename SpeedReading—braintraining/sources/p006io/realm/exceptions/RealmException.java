package p006io.realm.exceptions;

import p006io.realm.internal.Keep;

@Keep
/* renamed from: io.realm.exceptions.RealmException */
public final class RealmException extends RuntimeException {
    public RealmException(String detailMessage) {
        super(detailMessage);
    }

    public RealmException(String detailMessage, Throwable exception) {
        super(detailMessage, exception);
    }
}
