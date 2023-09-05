package org.solovyev.android.checkout;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.GuardedBy;

class PlayStoreBroadcastReceiver extends BroadcastReceiver {
    private static final String ACTION = "com.android.vending.billing.PURCHASES_UPDATED";
    @Nonnull
    private final Context mContext;
    @GuardedBy("mLock")
    @Nonnull
    private final List<PlayStoreListener> mListeners = new ArrayList();
    @Nonnull
    private final Object mLock;

    PlayStoreBroadcastReceiver(@Nonnull Context context, @Nonnull Object lock) {
        this.mContext = context;
        this.mLock = lock;
    }

    /* access modifiers changed from: package-private */
    public void addListener(@Nonnull PlayStoreListener listener) {
        synchronized (this.mLock) {
            Check.isTrue(!this.mListeners.contains(listener), "Listener " + listener + " is already in the list");
            this.mListeners.add(listener);
            if (this.mListeners.size() == 1) {
                this.mContext.registerReceiver(this, new IntentFilter(ACTION));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void removeListener(@Nonnull PlayStoreListener listener) {
        synchronized (this.mLock) {
            Check.isTrue(this.mListeners.contains(listener), "Listener " + listener + " is not in the list");
            this.mListeners.remove(listener);
            if (this.mListeners.size() == 0) {
                this.mContext.unregisterReceiver(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean contains(@Nonnull PlayStoreListener listener) {
        boolean contains;
        synchronized (this.mLock) {
            contains = this.mListeners.contains(listener);
        }
        return contains;
    }

    public void onReceive(Context context, Intent intent) {
        List<PlayStoreListener> listeners;
        if (intent != null && TextUtils.equals(intent.getAction(), ACTION)) {
            synchronized (this.mLock) {
                listeners = new ArrayList<>(this.mListeners);
            }
            for (PlayStoreListener listener : listeners) {
                listener.onPurchasesChanged();
            }
        }
    }
}
