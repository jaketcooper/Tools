package org.solovyev.android.checkout;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.Service;
import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.solovyev.android.checkout.Billing;
import org.solovyev.android.checkout.Inventory;

public class Checkout {
    @Nonnull
    protected final Billing mBilling;
    @GuardedBy("mLock")
    @Nonnull
    private final Listeners mListeners = new Listeners();
    @Nonnull
    final Object mLock = new Object();
    @Nonnull
    private final OnLoadExecutor mOnLoadExecutor = new OnLoadExecutor();
    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public Billing.Requests mRequests;
    @GuardedBy("mLock")
    @Nonnull
    private State mState = State.INITIAL;
    @GuardedBy("mLock")
    @Nonnull
    private final Map<String, Boolean> mSupportedProducts = new HashMap();
    @Nullable
    private final Object mTag;

    public interface Listener {
        void onReady(@Nonnull BillingRequests billingRequests);

        void onReady(@Nonnull BillingRequests billingRequests, @Nonnull String str, boolean z);
    }

    private enum State {
        INITIAL,
        STARTED,
        STOPPED
    }

    Checkout(@Nullable Object tag, @Nonnull Billing billing) {
        this.mTag = tag;
        this.mBilling = billing;
    }

    @Nonnull
    public static UiCheckout forUi(@Nonnull IntentStarter intentStarter, @Nonnull Object tag, @Nonnull Billing billing) {
        return new CustomUiCheckout(intentStarter, tag, billing);
    }

    @Nonnull
    @TargetApi(24)
    public static UiCheckout forFragment(@Nonnull Fragment fragment, @Nonnull Billing billing) {
        return new FragmentCheckout(fragment, billing);
    }

    @Nonnull
    public static ActivityCheckout forActivity(@Nonnull Activity activity, @Nonnull Billing billing) {
        return new ActivityCheckout(activity, billing);
    }

    @Nonnull
    public static Checkout forService(@Nonnull Service service, @Nonnull Billing billing) {
        return new Checkout(service, billing);
    }

    @Nonnull
    public static Checkout forApplication(@Nonnull Billing billing) {
        return new Checkout((Object) null, billing);
    }

    /* access modifiers changed from: package-private */
    @Nonnull
    public Context getContext() {
        return this.mBilling.getContext();
    }

    public void start() {
        start((Listener) null);
    }

    public void start(@Nullable Listener listener) {
        Check.isMainThread();
        synchronized (this.mLock) {
            Check.isFalse(this.mState == State.STARTED, "Already started");
            Check.isNull(this.mRequests, "Already started");
            this.mState = State.STARTED;
            this.mBilling.onCheckoutStarted();
            this.mRequests = this.mBilling.getRequests(this.mTag);
            if (listener != null) {
                this.mListeners.add(listener);
            }
            for (final String product : ProductTypes.ALL) {
                this.mRequests.isBillingSupported(product, (RequestListener<Object>) new RequestListener<Object>() {
                    public void onSuccess(@Nonnull Object result) {
                        Checkout.this.onBillingSupported(product, true);
                    }

                    public void onError(int response, @Nonnull Exception e) {
                        Checkout.this.onBillingSupported(product, false);
                    }
                });
            }
        }
    }

    public void whenReady(@Nonnull Listener listener) {
        Check.isMainThread();
        synchronized (this.mLock) {
            for (Map.Entry<String, Boolean> entry : this.mSupportedProducts.entrySet()) {
                listener.onReady(this.mRequests, entry.getKey(), entry.getValue().booleanValue());
            }
            if (isReady()) {
                checkIsNotStopped();
                Check.isNotNull(this.mRequests);
                listener.onReady(this.mRequests);
            } else {
                this.mListeners.add(listener);
            }
        }
    }

    private void checkIsNotStopped() {
        Check.isFalse(this.mState == State.STOPPED, "Checkout is stopped");
    }

    private boolean isReady() {
        Check.isTrue(Thread.holdsLock(this.mLock), "Should be called from synchronized block");
        return this.mSupportedProducts.size() == ProductTypes.ALL.size();
    }

    /* access modifiers changed from: private */
    public void onBillingSupported(@Nonnull String product, boolean supported) {
        synchronized (this.mLock) {
            this.mSupportedProducts.put(product, Boolean.valueOf(supported));
            this.mListeners.onReady(this.mRequests, product, supported);
            if (isReady()) {
                this.mListeners.onReady(this.mRequests);
                this.mListeners.clear();
            }
        }
    }

    @Nonnull
    public Inventory loadInventory(@Nonnull Inventory.Request request, @Nonnull Inventory.Callback callback) {
        Inventory inventory = makeInventory();
        inventory.load(request, callback);
        return inventory;
    }

    @Nonnull
    public Inventory makeInventory() {
        Check.isMainThread();
        synchronized (this.mLock) {
            checkIsNotStopped();
        }
        Inventory fallbackInventory = this.mBilling.getConfiguration().getFallbackInventory(this, this.mOnLoadExecutor);
        if (fallbackInventory == null) {
            return new CheckoutInventory(this);
        }
        return new FallingBackInventory(this, fallbackInventory);
    }

    public void stop() {
        Check.isMainThread();
        synchronized (this.mLock) {
            this.mSupportedProducts.clear();
            this.mListeners.clear();
            if (this.mState != State.INITIAL) {
                this.mState = State.STOPPED;
            }
            if (this.mRequests != null) {
                this.mRequests.cancelAll();
                this.mRequests = null;
            }
            if (this.mState == State.STOPPED) {
                this.mBilling.onCheckoutStopped();
            }
        }
    }

    public boolean isBillingSupported(@Nonnull String product) {
        Check.isTrue(ProductTypes.ALL.contains(product), "Product should be added to the products list");
        Check.isTrue(this.mSupportedProducts.containsKey(product), "Billing information is not ready yet");
        return this.mSupportedProducts.get(product).booleanValue();
    }

    public static abstract class EmptyListener implements Listener {
        public void onReady(@Nonnull BillingRequests requests) {
        }

        public void onReady(@Nonnull BillingRequests requests, @Nonnull String product, boolean billingSupported) {
        }
    }

    private static final class Listeners implements Listener {
        @Nonnull
        private final List<Listener> mList;

        private Listeners() {
            this.mList = new ArrayList();
        }

        public void add(@Nonnull Listener l) {
            if (!this.mList.contains(l)) {
                this.mList.add(l);
            }
        }

        public void onReady(@Nonnull BillingRequests requests) {
            List<Listener> localList = new ArrayList<>(this.mList);
            this.mList.clear();
            for (Listener listener : localList) {
                listener.onReady(requests);
            }
        }

        public void onReady(@Nonnull BillingRequests requests, @Nonnull String product, boolean billingSupported) {
            for (Listener listener : this.mList) {
                listener.onReady(requests, product, billingSupported);
            }
        }

        public void clear() {
            this.mList.clear();
        }
    }

    private final class OnLoadExecutor implements Executor {
        private OnLoadExecutor() {
        }

        public void execute(Runnable command) {
            Executor executor;
            synchronized (Checkout.this.mLock) {
                executor = Checkout.this.mRequests != null ? Checkout.this.mRequests.getDeliveryExecutor() : null;
            }
            if (executor != null) {
                executor.execute(command);
            } else {
                Billing.error("Trying to deliver result on a stopped checkout.");
            }
        }
    }
}
