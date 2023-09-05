package p006io.realm.internal;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p006io.realm.internal.ObserverPairList.ObserverPair;

/* renamed from: io.realm.internal.ObserverPairList */
class ObserverPairList<T extends ObserverPair> {
    private boolean cleared = false;
    private List<T> pairs = new CopyOnWriteArrayList();

    /* renamed from: io.realm.internal.ObserverPairList$Callback */
    interface Callback<T extends ObserverPair> {
        void onCalled(T t, Object obj);
    }

    ObserverPairList() {
    }

    /* renamed from: io.realm.internal.ObserverPairList$ObserverPair */
    static abstract class ObserverPair<T, S> {
        protected final S listener;
        final WeakReference<T> observerRef;
        boolean removed = false;

        ObserverPair(T observer, S listener2) {
            this.listener = listener2;
            this.observerRef = new WeakReference<>(observer);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ObserverPair)) {
                return false;
            }
            ObserverPair anotherPair = (ObserverPair) obj;
            if (!this.listener.equals(anotherPair.listener) || this.observerRef.get() != anotherPair.observerRef.get()) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            T observer = this.observerRef.get();
            if (observer != null) {
                i = observer.hashCode();
            } else {
                i = 0;
            }
            int i3 = (i + 527) * 31;
            if (this.listener != null) {
                i2 = this.listener.hashCode();
            }
            return i3 + i2;
        }
    }

    /* access modifiers changed from: package-private */
    public void foreach(Callback<T> callback) {
        for (T pair : this.pairs) {
            if (!this.cleared) {
                Object observer = pair.observerRef.get();
                if (observer == null) {
                    this.pairs.remove(pair);
                } else if (!pair.removed) {
                    callback.onCalled(pair, observer);
                }
            } else {
                return;
            }
        }
    }

    public boolean isEmpty() {
        return this.pairs.isEmpty();
    }

    public void clear() {
        this.cleared = true;
        this.pairs.clear();
    }

    public void add(T pair) {
        if (!this.pairs.contains(pair)) {
            this.pairs.add(pair);
            pair.removed = false;
        }
        if (this.cleared) {
            this.cleared = false;
        }
    }

    public <S, U> void remove(S observer, U listener) {
        for (T pair : this.pairs) {
            if (observer == pair.observerRef.get() && listener.equals(pair.listener)) {
                pair.removed = true;
                this.pairs.remove(pair);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void removeByObserver(Object observer) {
        for (T pair : this.pairs) {
            Object object = pair.observerRef.get();
            if (object == null || object == observer) {
                pair.removed = true;
                this.pairs.remove(pair);
            }
        }
    }

    public int size() {
        return this.pairs.size();
    }
}
