package p006io.realm.internal;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import p006io.realm.RealmChangeListener;
import p006io.realm.internal.ObserverPairList;

@Keep
/* renamed from: io.realm.internal.RealmNotifier */
public abstract class RealmNotifier implements Closeable {
    private final ObserverPairList.Callback<RealmObserverPair> onChangeCallBack = new ObserverPairList.Callback<RealmObserverPair>() {
        public void onCalled(RealmObserverPair pair, Object observer) {
            if (RealmNotifier.this.sharedRealm != null && !RealmNotifier.this.sharedRealm.isClosed()) {
                pair.onChange(observer);
            }
        }
    };
    private ObserverPairList<RealmObserverPair> realmObserverPairs = new ObserverPairList<>();
    /* access modifiers changed from: private */
    public SharedRealm sharedRealm;
    private List<Runnable> transactionCallbacks = new ArrayList();

    public abstract boolean post(Runnable runnable);

    /* renamed from: io.realm.internal.RealmNotifier$RealmObserverPair */
    private static class RealmObserverPair<T> extends ObserverPairList.ObserverPair<T, RealmChangeListener<T>> {
        public RealmObserverPair(T observer, RealmChangeListener<T> listener) {
            super(observer, listener);
        }

        /* access modifiers changed from: private */
        public void onChange(T observer) {
            if (observer != null) {
                ((RealmChangeListener) this.listener).onChange(observer);
            }
        }
    }

    protected RealmNotifier(SharedRealm sharedRealm2) {
        this.sharedRealm = sharedRealm2;
    }

    /* access modifiers changed from: package-private */
    public void didChange() {
        this.realmObserverPairs.foreach(this.onChangeCallBack);
        for (Runnable runnable : this.transactionCallbacks) {
            runnable.run();
        }
        this.transactionCallbacks.clear();
    }

    /* access modifiers changed from: package-private */
    public void beforeNotify() {
        this.sharedRealm.invalidateIterators();
    }

    public void close() {
        removeAllChangeListeners();
    }

    public <T> void addChangeListener(T observer, RealmChangeListener<T> realmChangeListener) {
        this.realmObserverPairs.add(new RealmObserverPair(observer, realmChangeListener));
    }

    public <E> void removeChangeListener(E observer, RealmChangeListener<E> realmChangeListener) {
        this.realmObserverPairs.remove(observer, realmChangeListener);
    }

    public <E> void removeChangeListeners(E observer) {
        this.realmObserverPairs.removeByObserver(observer);
    }

    private void removeAllChangeListeners() {
        this.realmObserverPairs.clear();
    }

    public void addTransactionCallback(Runnable runnable) {
        this.transactionCallbacks.add(runnable);
    }

    public int getListenersListSize() {
        return this.realmObserverPairs.size();
    }
}
