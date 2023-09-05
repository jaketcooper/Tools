package p006io.realm.exceptions;

import p006io.realm.internal.Keep;

@Keep
/* renamed from: io.realm.exceptions.RealmMigrationNeededException */
public final class RealmMigrationNeededException extends RuntimeException {
    private final String canonicalRealmPath;

    public RealmMigrationNeededException(String canonicalRealmPath2, String detailMessage) {
        super(detailMessage);
        this.canonicalRealmPath = canonicalRealmPath2;
    }

    public RealmMigrationNeededException(String canonicalRealmPath2, String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
        this.canonicalRealmPath = canonicalRealmPath2;
    }

    public String getPath() {
        return this.canonicalRealmPath;
    }
}
