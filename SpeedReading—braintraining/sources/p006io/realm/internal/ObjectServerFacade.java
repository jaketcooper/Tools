package p006io.realm.internal;

import android.content.Context;
import p006io.realm.RealmConfiguration;
import p006io.realm.exceptions.RealmException;

/* renamed from: io.realm.internal.ObjectServerFacade */
public class ObjectServerFacade {
    private static final ObjectServerFacade nonSyncFacade = new ObjectServerFacade();
    private static ObjectServerFacade syncFacade;

    static {
        syncFacade = null;
        try {
            syncFacade = (ObjectServerFacade) Class.forName("io.realm.internal.objectserver.SyncObjectServerFacade").newInstance();
        } catch (ClassNotFoundException e) {
        } catch (InstantiationException e2) {
            throw new RealmException("Failed to init SyncObjectServerFacade", e2);
        } catch (IllegalAccessException e3) {
            throw new RealmException("Failed to init SyncObjectServerFacade", e3);
        }
    }

    public void init(Context context) {
    }

    public void notifyCommit(RealmConfiguration configuration, long lastSnapshotVersion) {
    }

    public void realmClosed(RealmConfiguration configuration) {
    }

    public void realmOpened(RealmConfiguration configuration) {
    }

    public String[] getUserAndServerUrl(RealmConfiguration config) {
        return new String[2];
    }

    public static ObjectServerFacade getFacade(boolean needSyncFacade) {
        if (needSyncFacade) {
            return syncFacade;
        }
        return nonSyncFacade;
    }

    public static ObjectServerFacade getSyncFacadeIfPossible() {
        if (syncFacade != null) {
            return syncFacade;
        }
        return nonSyncFacade;
    }
}
