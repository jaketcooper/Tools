package org.solovyev.android.checkout;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;
import com.google.android.gms.common.zzo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.solovyev.android.checkout.Cache;
import org.solovyev.android.checkout.Purchase;

public final class Billing {
    static final long DAY = 86400000;
    static final long HOUR = 3600000;
    static final long MINUTE = 60000;
    static final long SECOND = 1000;
    @Nonnull
    private static final String TAG = "Checkout";

    /* renamed from: V3 */
    static final int f180V3 = 3;

    /* renamed from: V5 */
    static final int f181V5 = 5;
    @Nonnull
    private static final EmptyRequestListener sEmptyListener = new EmptyRequestListener();
    @Nonnull
    private static Logger sLogger = newLogger();
    @Nonnull
    private static final EnumMap<State, List<State>> sPreviousStates = new EnumMap<>(State.class);
    @Nonnull
    private Executor mBackground;
    /* access modifiers changed from: private */
    @Nonnull
    public final ConcurrentCache mCache;
    @GuardedBy("mLock")
    private int mCheckoutCount;
    /* access modifiers changed from: private */
    @Nonnull
    public final StaticConfiguration mConfiguration;
    @Nonnull
    private ServiceConnector mConnector;
    /* access modifiers changed from: private */
    @Nonnull
    public final Context mContext;
    /* access modifiers changed from: private */
    @Nonnull
    public final Object mLock;
    /* access modifiers changed from: private */
    @Nonnull
    public CancellableExecutor mMainThread;
    /* access modifiers changed from: private */
    @Nonnull
    public final PendingRequests mPendingRequests;
    @GuardedBy("mLock")
    @Nonnull
    private final PlayStoreBroadcastReceiver mPlayStoreBroadcastReceiver;
    @Nonnull
    private final PlayStoreListener mPlayStoreListener;
    @Nonnull
    private final BillingRequests mRequests;
    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    @Nullable
    public IInAppBillingService mService;
    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    @Nonnull
    public State mState;

    public interface Configuration {
        @Nullable
        Cache getCache();

        @Nullable
        Inventory getFallbackInventory(@Nonnull Checkout checkout, @Nonnull Executor executor);

        @Nonnull
        String getPublicKey();

        @Nonnull
        PurchaseVerifier getPurchaseVerifier();

        boolean isAutoConnect();
    }

    interface ServiceConnector {
        boolean connect();

        void disconnect();
    }

    enum State {
        INITIAL,
        CONNECTING,
        CONNECTED,
        DISCONNECTING,
        DISCONNECTED,
        FAILED
    }

    static {
        sPreviousStates.put(State.INITIAL, Collections.emptyList());
        sPreviousStates.put(State.CONNECTING, Arrays.asList(new State[]{State.INITIAL, State.FAILED, State.DISCONNECTED, State.DISCONNECTING}));
        sPreviousStates.put(State.CONNECTED, Collections.singletonList(State.CONNECTING));
        sPreviousStates.put(State.DISCONNECTING, Collections.singletonList(State.CONNECTED));
        sPreviousStates.put(State.DISCONNECTED, Arrays.asList(new State[]{State.DISCONNECTING, State.CONNECTING}));
        sPreviousStates.put(State.FAILED, Collections.singletonList(State.CONNECTING));
    }

    public Billing(@Nonnull Context context, @Nonnull Configuration configuration) {
        this(context, new Handler(), configuration);
        Check.isMainThread();
    }

    public Billing(@Nonnull Context context, @Nonnull Handler handler, @Nonnull Configuration configuration) {
        SafeCache safeCache = null;
        this.mLock = new Object();
        this.mPendingRequests = new PendingRequests();
        this.mRequests = newRequestsBuilder().withTag((Object) null).onBackgroundThread().create();
        this.mPlayStoreListener = new PlayStoreListener() {
            public void onPurchasesChanged() {
                Billing.this.mCache.removeAll(RequestType.GET_PURCHASES.getCacheKeyType());
            }
        };
        this.mState = State.INITIAL;
        this.mBackground = Executors.newSingleThreadExecutor(new ThreadFactory() {
            public Thread newThread(@Nonnull Runnable r) {
                return new Thread(r, "RequestThread");
            }
        });
        this.mConnector = new DefaultServiceConnector();
        if (context instanceof Application) {
            this.mContext = context;
        } else {
            this.mContext = context.getApplicationContext();
        }
        this.mMainThread = new MainThread(handler);
        this.mConfiguration = new StaticConfiguration(configuration);
        Check.isNotEmpty(this.mConfiguration.getPublicKey());
        Cache cache = configuration.getCache();
        this.mCache = new ConcurrentCache(cache != null ? new SafeCache(cache) : safeCache);
        this.mPlayStoreBroadcastReceiver = new PlayStoreBroadcastReceiver(this.mContext, this.mLock);
    }

    static void waitGooglePlay() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            error((Exception) e);
        }
    }

    /* access modifiers changed from: private */
    @Nonnull
    public static <R> RequestListener<R> emptyListener() {
        return sEmptyListener;
    }

    static void error(@Nonnull String message) {
        sLogger.mo19367e(TAG, message);
    }

    static void error(@Nonnull Exception e) {
        error(e.getMessage(), e);
    }

    static void error(@Nonnull String message, @Nonnull Exception e) {
        if (e instanceof BillingException) {
            switch (((BillingException) e).getResponse()) {
                case 0:
                case 1:
                case 2:
                    sLogger.mo19368e(TAG, message, e);
                    return;
                default:
                    sLogger.mo19368e(TAG, message, e);
                    return;
            }
        } else {
            sLogger.mo19368e(TAG, message, e);
        }
    }

    static void debug(@Nonnull String subTag, @Nonnull String message) {
        sLogger.mo19365d("Checkout/" + subTag, message);
    }

    static void debug(@Nonnull String message) {
        sLogger.mo19365d(TAG, message);
    }

    static void warning(@Nonnull String message) {
        sLogger.mo19374w(TAG, message);
    }

    public static void setLogger(@Nullable Logger logger) {
        if (logger == null) {
            logger = new EmptyLogger();
        }
        sLogger = logger;
    }

    @Nonnull
    public static Cache newCache() {
        return new MapCache();
    }

    @Nonnull
    public static PurchaseVerifier newPurchaseVerifier(@Nonnull String publicKey) {
        return new DefaultPurchaseVerifier(publicKey);
    }

    @Nonnull
    public static Logger newLogger() {
        return new DefaultLogger();
    }

    @Nonnull
    public static Logger newMainThreadLogger(@Nonnull Logger logger) {
        return new MainThreadLogger(logger);
    }

    static void cancel(@Nonnull RequestListener<?> listener) {
        if (listener instanceof CancellableRequestListener) {
            ((CancellableRequestListener) listener).cancel();
        }
    }

    @Nonnull
    public Context getContext() {
        return this.mContext;
    }

    /* access modifiers changed from: package-private */
    @Nonnull
    public Configuration getConfiguration() {
        return this.mConfiguration;
    }

    /* access modifiers changed from: package-private */
    @Nonnull
    public ServiceConnector getConnector() {
        return this.mConnector;
    }

    /* access modifiers changed from: package-private */
    public void setConnector(@Nonnull ServiceConnector connector) {
        this.mConnector = connector;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setService(@javax.annotation.Nullable com.android.vending.billing.IInAppBillingService r6, boolean r7) {
        /*
            r5 = this;
            java.lang.Object r2 = r5.mLock
            monitor-enter(r2)
            if (r7 == 0) goto L_0x0025
            org.solovyev.android.checkout.Billing$State r1 = r5.mState     // Catch:{ all -> 0x001f }
            org.solovyev.android.checkout.Billing$State r3 = org.solovyev.android.checkout.Billing.State.CONNECTING     // Catch:{ all -> 0x001f }
            if (r1 == r3) goto L_0x0014
            if (r6 == 0) goto L_0x0012
            org.solovyev.android.checkout.Billing$ServiceConnector r1 = r5.mConnector     // Catch:{ all -> 0x001f }
            r1.disconnect()     // Catch:{ all -> 0x001f }
        L_0x0012:
            monitor-exit(r2)     // Catch:{ all -> 0x001f }
        L_0x0013:
            return
        L_0x0014:
            if (r6 != 0) goto L_0x0022
            org.solovyev.android.checkout.Billing$State r0 = org.solovyev.android.checkout.Billing.State.FAILED     // Catch:{ all -> 0x001f }
        L_0x0018:
            r5.mService = r6     // Catch:{ all -> 0x001f }
            r5.setState(r0)     // Catch:{ all -> 0x001f }
            monitor-exit(r2)     // Catch:{ all -> 0x001f }
            goto L_0x0013
        L_0x001f:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001f }
            throw r1
        L_0x0022:
            org.solovyev.android.checkout.Billing$State r0 = org.solovyev.android.checkout.Billing.State.CONNECTED     // Catch:{ all -> 0x001f }
            goto L_0x0018
        L_0x0025:
            org.solovyev.android.checkout.Billing$State r1 = r5.mState     // Catch:{ all -> 0x001f }
            org.solovyev.android.checkout.Billing$State r3 = org.solovyev.android.checkout.Billing.State.INITIAL     // Catch:{ all -> 0x001f }
            if (r1 == r3) goto L_0x0037
            org.solovyev.android.checkout.Billing$State r1 = r5.mState     // Catch:{ all -> 0x001f }
            org.solovyev.android.checkout.Billing$State r3 = org.solovyev.android.checkout.Billing.State.DISCONNECTED     // Catch:{ all -> 0x001f }
            if (r1 == r3) goto L_0x0037
            org.solovyev.android.checkout.Billing$State r1 = r5.mState     // Catch:{ all -> 0x001f }
            org.solovyev.android.checkout.Billing$State r3 = org.solovyev.android.checkout.Billing.State.FAILED     // Catch:{ all -> 0x001f }
            if (r1 != r3) goto L_0x003e
        L_0x0037:
            com.android.vending.billing.IInAppBillingService r1 = r5.mService     // Catch:{ all -> 0x001f }
            org.solovyev.android.checkout.Check.isNull(r1)     // Catch:{ all -> 0x001f }
            monitor-exit(r2)     // Catch:{ all -> 0x001f }
            goto L_0x0013
        L_0x003e:
            org.solovyev.android.checkout.Billing$State r1 = r5.mState     // Catch:{ all -> 0x001f }
            org.solovyev.android.checkout.Billing$State r3 = org.solovyev.android.checkout.Billing.State.CONNECTED     // Catch:{ all -> 0x001f }
            if (r1 != r3) goto L_0x0049
            org.solovyev.android.checkout.Billing$State r1 = org.solovyev.android.checkout.Billing.State.DISCONNECTING     // Catch:{ all -> 0x001f }
            r5.setState(r1)     // Catch:{ all -> 0x001f }
        L_0x0049:
            org.solovyev.android.checkout.Billing$State r1 = r5.mState     // Catch:{ all -> 0x001f }
            org.solovyev.android.checkout.Billing$State r3 = org.solovyev.android.checkout.Billing.State.DISCONNECTING     // Catch:{ all -> 0x001f }
            if (r1 != r3) goto L_0x0052
            org.solovyev.android.checkout.Billing$State r0 = org.solovyev.android.checkout.Billing.State.DISCONNECTED     // Catch:{ all -> 0x001f }
            goto L_0x0018
        L_0x0052:
            org.solovyev.android.checkout.Billing$State r1 = r5.mState     // Catch:{ all -> 0x001f }
            org.solovyev.android.checkout.Billing$State r3 = org.solovyev.android.checkout.Billing.State.CONNECTING     // Catch:{ all -> 0x001f }
            if (r1 != r3) goto L_0x0074
            r1 = 1
        L_0x0059:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x001f }
            r3.<init>()     // Catch:{ all -> 0x001f }
            java.lang.String r4 = "Unexpected state: "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x001f }
            org.solovyev.android.checkout.Billing$State r4 = r5.mState     // Catch:{ all -> 0x001f }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x001f }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x001f }
            org.solovyev.android.checkout.Check.isTrue(r1, r3)     // Catch:{ all -> 0x001f }
            org.solovyev.android.checkout.Billing$State r0 = org.solovyev.android.checkout.Billing.State.FAILED     // Catch:{ all -> 0x001f }
            goto L_0x0018
        L_0x0074:
            r1 = 0
            goto L_0x0059
        */
        throw new UnsupportedOperationException("Method not decompiled: org.solovyev.android.checkout.Billing.setService(com.android.vending.billing.IInAppBillingService, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public void setBackground(@Nonnull Executor background) {
        this.mBackground = background;
    }

    /* access modifiers changed from: package-private */
    public void setMainThread(@Nonnull CancellableExecutor mainThread) {
        this.mMainThread = mainThread;
    }

    /* access modifiers changed from: package-private */
    public void setPurchaseVerifier(@Nonnull PurchaseVerifier purchaseVerifier) {
        this.mConfiguration.setPurchaseVerifier(purchaseVerifier);
    }

    private void executePendingRequests() {
        this.mBackground.execute(this.mPendingRequests);
    }

    /* access modifiers changed from: package-private */
    @Nonnull
    public State getState() {
        State state;
        synchronized (this.mLock) {
            state = this.mState;
        }
        return state;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setState(@javax.annotation.Nonnull org.solovyev.android.checkout.Billing.State r5) {
        /*
            r4 = this;
            java.lang.Object r1 = r4.mLock
            monitor-enter(r1)
            org.solovyev.android.checkout.Billing$State r0 = r4.mState     // Catch:{ all -> 0x0050 }
            if (r0 != r5) goto L_0x0009
            monitor-exit(r1)     // Catch:{ all -> 0x0050 }
        L_0x0008:
            return
        L_0x0009:
            java.util.EnumMap<org.solovyev.android.checkout.Billing$State, java.util.List<org.solovyev.android.checkout.Billing$State>> r0 = sPreviousStates     // Catch:{ all -> 0x0050 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x0050 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0050 }
            org.solovyev.android.checkout.Billing$State r2 = r4.mState     // Catch:{ all -> 0x0050 }
            boolean r0 = r0.contains(r2)     // Catch:{ all -> 0x0050 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0050 }
            r2.<init>()     // Catch:{ all -> 0x0050 }
            java.lang.String r3 = "State "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0050 }
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ all -> 0x0050 }
            java.lang.String r3 = " can't come right after "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0050 }
            org.solovyev.android.checkout.Billing$State r3 = r4.mState     // Catch:{ all -> 0x0050 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0050 }
            java.lang.String r3 = " state"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0050 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0050 }
            org.solovyev.android.checkout.Check.isTrue(r0, r2)     // Catch:{ all -> 0x0050 }
            r4.mState = r5     // Catch:{ all -> 0x0050 }
            int[] r0 = org.solovyev.android.checkout.Billing.C12067.$SwitchMap$org$solovyev$android$checkout$Billing$State     // Catch:{ all -> 0x0050 }
            org.solovyev.android.checkout.Billing$State r2 = r4.mState     // Catch:{ all -> 0x0050 }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x0050 }
            r0 = r0[r2]     // Catch:{ all -> 0x0050 }
            switch(r0) {
                case 1: goto L_0x0053;
                case 2: goto L_0x005b;
                case 3: goto L_0x0066;
                default: goto L_0x004e;
            }     // Catch:{ all -> 0x0050 }
        L_0x004e:
            monitor-exit(r1)     // Catch:{ all -> 0x0050 }
            goto L_0x0008
        L_0x0050:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0050 }
            throw r0
        L_0x0053:
            org.solovyev.android.checkout.PlayStoreBroadcastReceiver r0 = r4.mPlayStoreBroadcastReceiver     // Catch:{ all -> 0x0050 }
            org.solovyev.android.checkout.PlayStoreListener r2 = r4.mPlayStoreListener     // Catch:{ all -> 0x0050 }
            r0.removeListener(r2)     // Catch:{ all -> 0x0050 }
            goto L_0x004e
        L_0x005b:
            org.solovyev.android.checkout.PlayStoreBroadcastReceiver r0 = r4.mPlayStoreBroadcastReceiver     // Catch:{ all -> 0x0050 }
            org.solovyev.android.checkout.PlayStoreListener r2 = r4.mPlayStoreListener     // Catch:{ all -> 0x0050 }
            r0.addListener(r2)     // Catch:{ all -> 0x0050 }
            r4.executePendingRequests()     // Catch:{ all -> 0x0050 }
            goto L_0x004e
        L_0x0066:
            org.solovyev.android.checkout.PlayStoreBroadcastReceiver r0 = r4.mPlayStoreBroadcastReceiver     // Catch:{ all -> 0x0050 }
            org.solovyev.android.checkout.PlayStoreListener r2 = r4.mPlayStoreListener     // Catch:{ all -> 0x0050 }
            boolean r0 = r0.contains(r2)     // Catch:{ all -> 0x0050 }
            if (r0 != 0) goto L_0x0081
            r0 = 1
        L_0x0071:
            java.lang.String r2 = "Leaking the listener"
            org.solovyev.android.checkout.Check.isTrue(r0, r2)     // Catch:{ all -> 0x0050 }
            org.solovyev.android.checkout.CancellableExecutor r0 = r4.mMainThread     // Catch:{ all -> 0x0050 }
            org.solovyev.android.checkout.Billing$3 r2 = new org.solovyev.android.checkout.Billing$3     // Catch:{ all -> 0x0050 }
            r2.<init>()     // Catch:{ all -> 0x0050 }
            r0.execute(r2)     // Catch:{ all -> 0x0050 }
            goto L_0x004e
        L_0x0081:
            r0 = 0
            goto L_0x0071
        */
        throw new UnsupportedOperationException("Method not decompiled: org.solovyev.android.checkout.Billing.setState(org.solovyev.android.checkout.Billing$State):void");
    }

    public void connect() {
        synchronized (this.mLock) {
            if (this.mState == State.CONNECTED) {
                executePendingRequests();
            } else if (this.mState != State.CONNECTING) {
                if (this.mConfiguration.isAutoConnect() && this.mCheckoutCount <= 0) {
                    warning("Auto connection feature is turned on. There is no need in calling Billing.connect() manually. See Billing.Configuration.isAutoConnect");
                }
                setState(State.CONNECTING);
                this.mMainThread.execute(new Runnable() {
                    public void run() {
                        Billing.this.connectOnMainThread();
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void connectOnMainThread() {
        Check.isMainThread();
        if (!this.mConnector.connect()) {
            setState(State.FAILED);
        }
    }

    public void addPlayStoreListener(@Nonnull PlayStoreListener listener) {
        synchronized (this.mLock) {
            this.mPlayStoreBroadcastReceiver.addListener(listener);
        }
    }

    public void removePlayStoreListener(@Nonnull PlayStoreListener listener) {
        synchronized (this.mLock) {
            this.mPlayStoreBroadcastReceiver.removeListener(listener);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void disconnect() {
        /*
            r3 = this;
            java.lang.Object r1 = r3.mLock
            monitor-enter(r1)
            org.solovyev.android.checkout.Billing$State r0 = r3.mState     // Catch:{ all -> 0x0024 }
            org.solovyev.android.checkout.Billing$State r2 = org.solovyev.android.checkout.Billing.State.DISCONNECTED     // Catch:{ all -> 0x0024 }
            if (r0 == r2) goto L_0x0015
            org.solovyev.android.checkout.Billing$State r0 = r3.mState     // Catch:{ all -> 0x0024 }
            org.solovyev.android.checkout.Billing$State r2 = org.solovyev.android.checkout.Billing.State.DISCONNECTING     // Catch:{ all -> 0x0024 }
            if (r0 == r2) goto L_0x0015
            org.solovyev.android.checkout.Billing$State r0 = r3.mState     // Catch:{ all -> 0x0024 }
            org.solovyev.android.checkout.Billing$State r2 = org.solovyev.android.checkout.Billing.State.INITIAL     // Catch:{ all -> 0x0024 }
            if (r0 != r2) goto L_0x0017
        L_0x0015:
            monitor-exit(r1)     // Catch:{ all -> 0x0024 }
        L_0x0016:
            return
        L_0x0017:
            org.solovyev.android.checkout.Billing$State r0 = r3.mState     // Catch:{ all -> 0x0024 }
            org.solovyev.android.checkout.Billing$State r2 = org.solovyev.android.checkout.Billing.State.FAILED     // Catch:{ all -> 0x0024 }
            if (r0 != r2) goto L_0x0027
            org.solovyev.android.checkout.PendingRequests r0 = r3.mPendingRequests     // Catch:{ all -> 0x0024 }
            r0.cancelAll()     // Catch:{ all -> 0x0024 }
            monitor-exit(r1)     // Catch:{ all -> 0x0024 }
            goto L_0x0016
        L_0x0024:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0024 }
            throw r0
        L_0x0027:
            org.solovyev.android.checkout.Billing$State r0 = r3.mState     // Catch:{ all -> 0x0024 }
            org.solovyev.android.checkout.Billing$State r2 = org.solovyev.android.checkout.Billing.State.CONNECTED     // Catch:{ all -> 0x0024 }
            if (r0 != r2) goto L_0x0043
            org.solovyev.android.checkout.Billing$State r0 = org.solovyev.android.checkout.Billing.State.DISCONNECTING     // Catch:{ all -> 0x0024 }
            r3.setState(r0)     // Catch:{ all -> 0x0024 }
            org.solovyev.android.checkout.CancellableExecutor r0 = r3.mMainThread     // Catch:{ all -> 0x0024 }
            org.solovyev.android.checkout.Billing$5 r2 = new org.solovyev.android.checkout.Billing$5     // Catch:{ all -> 0x0024 }
            r2.<init>()     // Catch:{ all -> 0x0024 }
            r0.execute(r2)     // Catch:{ all -> 0x0024 }
        L_0x003c:
            org.solovyev.android.checkout.PendingRequests r0 = r3.mPendingRequests     // Catch:{ all -> 0x0024 }
            r0.cancelAll()     // Catch:{ all -> 0x0024 }
            monitor-exit(r1)     // Catch:{ all -> 0x0024 }
            goto L_0x0016
        L_0x0043:
            org.solovyev.android.checkout.Billing$State r0 = org.solovyev.android.checkout.Billing.State.DISCONNECTED     // Catch:{ all -> 0x0024 }
            r3.setState(r0)     // Catch:{ all -> 0x0024 }
            goto L_0x003c
        */
        throw new UnsupportedOperationException("Method not decompiled: org.solovyev.android.checkout.Billing.disconnect():void");
    }

    /* access modifiers changed from: private */
    public void disconnectOnMainThread() {
        Check.isMainThread();
        this.mConnector.disconnect();
    }

    /* access modifiers changed from: private */
    public int runWhenConnected(@Nonnull Request request, @Nullable Object tag) {
        return runWhenConnected(request, (RequestListener) null, tag);
    }

    /* access modifiers changed from: package-private */
    public <R> int runWhenConnected(@Nonnull Request<R> request, @Nullable RequestListener<R> listener, @Nullable Object tag) {
        if (listener != null) {
            if (this.mCache.hasCache()) {
                listener = new CachingRequestListener<>(request, listener);
            }
            request.setListener(listener);
        }
        if (tag != null) {
            request.setTag(tag);
        }
        this.mPendingRequests.add(onConnectedService(request));
        connect();
        return request.getId();
    }

    public void cancel(int requestId) {
        this.mPendingRequests.cancel(requestId);
    }

    public void cancelAll() {
        this.mPendingRequests.cancelAll();
    }

    @Nonnull
    private RequestRunnable onConnectedService(@Nonnull Request request) {
        return new OnConnectedServiceRunnable(request);
    }

    @Nonnull
    public RequestsBuilder newRequestsBuilder() {
        return new RequestsBuilder();
    }

    @Nonnull
    public BillingRequests getRequests() {
        return this.mRequests;
    }

    @Nonnull
    public Requests getRequests(@Nullable Object tag) {
        if (tag == null) {
            return (Requests) getRequests();
        }
        return (Requests) new RequestsBuilder().withTag(tag).onMainThread().create();
    }

    /* access modifiers changed from: package-private */
    @Nonnull
    public PurchaseFlow createPurchaseFlow(@Nonnull IntentStarter intentStarter, int requestCode, @Nonnull RequestListener<Purchase> listener) {
        if (this.mCache.hasCache()) {
            listener = new RequestListenerWrapper<Purchase>(listener) {
                public void onSuccess(@Nonnull Purchase result) {
                    Billing.this.mCache.removeAll(RequestType.GET_PURCHASES.getCacheKeyType());
                    super.onSuccess(result);
                }
            };
        }
        return new PurchaseFlow(intentStarter, requestCode, listener, this.mConfiguration.getPurchaseVerifier());
    }

    /* access modifiers changed from: private */
    @Nonnull
    public <R> RequestListener<R> onMainThread(@Nonnull RequestListener<R> listener) {
        return new MainThreadRequestListener(this.mMainThread, listener);
    }

    public void onCheckoutStarted() {
        Check.isMainThread();
        synchronized (this.mLock) {
            this.mCheckoutCount++;
            if (this.mCheckoutCount > 0 && this.mConfiguration.isAutoConnect()) {
                connect();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onCheckoutStopped() {
        Check.isMainThread();
        synchronized (this.mLock) {
            this.mCheckoutCount--;
            if (this.mCheckoutCount < 0) {
                this.mCheckoutCount = 0;
                warning("Billing#onCheckoutStopped is called more than Billing#onCheckoutStarted");
            }
            if (this.mCheckoutCount == 0 && this.mConfiguration.isAutoConnect()) {
                disconnect();
            }
        }
    }

    public static abstract class DefaultConfiguration implements Configuration {
        @Nullable
        public Cache getCache() {
            return Billing.newCache();
        }

        @Nonnull
        public PurchaseVerifier getPurchaseVerifier() {
            Billing.warning("Default purchase verification procedure is used, please read https://github.com/serso/android-checkout#purchase-verification");
            return Billing.newPurchaseVerifier(getPublicKey());
        }

        @Nullable
        public Inventory getFallbackInventory(@Nonnull Checkout checkout, @Nonnull Executor onLoadExecutor) {
            return null;
        }

        public boolean isAutoConnect() {
            return true;
        }
    }

    private static final class StaticConfiguration implements Configuration {
        @Nonnull
        private final Configuration mOriginal;
        @Nonnull
        private final String mPublicKey;
        @Nonnull
        private PurchaseVerifier mPurchaseVerifier;

        private StaticConfiguration(@Nonnull Configuration original) {
            this.mOriginal = original;
            this.mPublicKey = original.getPublicKey();
            this.mPurchaseVerifier = original.getPurchaseVerifier();
        }

        @Nonnull
        public String getPublicKey() {
            return this.mPublicKey;
        }

        @Nullable
        public Cache getCache() {
            return this.mOriginal.getCache();
        }

        @Nonnull
        public PurchaseVerifier getPurchaseVerifier() {
            return this.mPurchaseVerifier;
        }

        /* access modifiers changed from: package-private */
        public void setPurchaseVerifier(@Nonnull PurchaseVerifier purchaseVerifier) {
            this.mPurchaseVerifier = purchaseVerifier;
        }

        @Nullable
        public Inventory getFallbackInventory(@Nonnull Checkout checkout, @Nonnull Executor onLoadExecutor) {
            return this.mOriginal.getFallbackInventory(checkout, onLoadExecutor);
        }

        public boolean isAutoConnect() {
            return this.mOriginal.isAutoConnect();
        }
    }

    private final class OnConnectedServiceRunnable implements RequestRunnable {
        @GuardedBy("this")
        @Nullable
        private Request mRequest;

        public OnConnectedServiceRunnable(@Nonnull Request request) {
            this.mRequest = request;
        }

        public boolean run() {
            State localState;
            IInAppBillingService localService;
            Request localRequest = getRequest();
            if (localRequest == null || checkCache(localRequest)) {
                return true;
            }
            synchronized (Billing.this.mLock) {
                localState = Billing.this.mState;
                localService = Billing.this.mService;
            }
            if (localState == State.CONNECTED) {
                Check.isNotNull(localService);
                try {
                    localRequest.start(localService, Billing.this.mContext.getPackageName());
                    return true;
                } catch (RemoteException | RuntimeException | RequestException e) {
                    localRequest.onError(e);
                    return true;
                }
            } else if (localState != State.FAILED) {
                Billing.this.connect();
                return false;
            } else {
                localRequest.onError((int) ResponseCodes.SERVICE_NOT_CONNECTED);
                return true;
            }
        }

        private boolean checkCache(@Nonnull Request request) {
            String key;
            Cache.Entry entry;
            if (!Billing.this.mCache.hasCache() || (key = request.getCacheKey()) == null || (entry = Billing.this.mCache.get(request.getType().getCacheKey(key))) == null) {
                return false;
            }
            request.onSuccess(entry.data);
            return true;
        }

        @Nullable
        public Request getRequest() {
            Request request;
            synchronized (this) {
                request = this.mRequest;
            }
            return request;
        }

        public void cancel() {
            synchronized (this) {
                if (this.mRequest != null) {
                    Billing.debug("Cancelling request: " + this.mRequest);
                    this.mRequest.cancel();
                }
                this.mRequest = null;
            }
        }

        public int getId() {
            int id;
            synchronized (this) {
                id = this.mRequest != null ? this.mRequest.getId() : -1;
            }
            return id;
        }

        @Nullable
        public Object getTag() {
            Object tag;
            synchronized (this) {
                tag = this.mRequest != null ? this.mRequest.getTag() : null;
            }
            return tag;
        }

        public String toString() {
            return String.valueOf(this.mRequest);
        }
    }

    public final class RequestsBuilder {
        @Nullable
        private Boolean mOnMainThread;
        @Nullable
        private Object mTag;

        private RequestsBuilder() {
        }

        @Nonnull
        public RequestsBuilder withTag(@Nullable Object tag) {
            Check.isNull(this.mTag);
            this.mTag = tag;
            return this;
        }

        @Nonnull
        public RequestsBuilder onBackgroundThread() {
            Check.isNull(this.mOnMainThread);
            this.mOnMainThread = false;
            return this;
        }

        @Nonnull
        public RequestsBuilder onMainThread() {
            Check.isNull(this.mOnMainThread);
            this.mOnMainThread = true;
            return this;
        }

        @Nonnull
        public BillingRequests create() {
            return new Requests(this.mTag, this.mOnMainThread == null ? true : this.mOnMainThread.booleanValue());
        }
    }

    final class Requests implements BillingRequests {
        private final boolean mOnMainThread;
        /* access modifiers changed from: private */
        @Nullable
        public final Object mTag;

        private Requests(@Nullable Object tag, boolean onMainThread) {
            this.mTag = tag;
            this.mOnMainThread = onMainThread;
        }

        public int isBillingSupported(@Nonnull String product) {
            return isBillingSupported(product, (RequestListener<Object>) Billing.emptyListener());
        }

        public int isBillingSupported(@Nonnull String product, int apiVersion) {
            return isBillingSupported(product, apiVersion, Billing.emptyListener());
        }

        public int isBillingSupported(@Nonnull String product, int apiVersion, @Nonnull RequestListener<Object> listener) {
            Check.isNotEmpty(product);
            return Billing.this.runWhenConnected(new BillingSupportedRequest(product, apiVersion), wrapListener(listener), this.mTag);
        }

        public int isBillingSupported(@Nonnull String product, @Nonnull RequestListener<Object> listener) {
            return isBillingSupported(product, 3, listener);
        }

        @Nonnull
        private <R> RequestListener<R> wrapListener(@Nonnull RequestListener<R> listener) {
            return this.mOnMainThread ? Billing.this.onMainThread(listener) : listener;
        }

        /* access modifiers changed from: package-private */
        @Nonnull
        public Executor getDeliveryExecutor() {
            return this.mOnMainThread ? Billing.this.mMainThread : SameThreadExecutor.INSTANCE;
        }

        public int getPurchases(@Nonnull String product, @Nullable String continuationToken, @Nonnull RequestListener<Purchases> listener) {
            Check.isNotEmpty(product);
            return Billing.this.runWhenConnected(new GetPurchasesRequest(product, continuationToken, Billing.this.mConfiguration.getPurchaseVerifier()), wrapListener(listener), this.mTag);
        }

        public int getAllPurchases(@Nonnull String product, @Nonnull RequestListener<Purchases> listener) {
            Check.isNotEmpty(product);
            GetAllPurchasesListener getAllPurchasesListener = new GetAllPurchasesListener(listener);
            GetPurchasesRequest request = new GetPurchasesRequest(product, (String) null, Billing.this.mConfiguration.getPurchaseVerifier());
            GetPurchasesRequest unused = getAllPurchasesListener.mRequest = request;
            return Billing.this.runWhenConnected(request, wrapListener(getAllPurchasesListener), this.mTag);
        }

        public int isPurchased(@Nonnull String product, @Nonnull String sku, @Nonnull RequestListener<Boolean> listener) {
            Check.isNotEmpty(sku);
            IsPurchasedListener isPurchasedListener = new IsPurchasedListener(sku, listener);
            GetPurchasesRequest request = new GetPurchasesRequest(product, (String) null, Billing.this.mConfiguration.getPurchaseVerifier());
            GetPurchasesRequest unused = isPurchasedListener.mRequest = request;
            return Billing.this.runWhenConnected(request, wrapListener(isPurchasedListener), this.mTag);
        }

        public int getSkus(@Nonnull String product, @Nonnull List<String> skus, @Nonnull RequestListener<Skus> listener) {
            Check.isNotEmpty(product);
            Check.isNotEmpty((Collection<?>) skus);
            return Billing.this.runWhenConnected(new GetSkuDetailsRequest(product, skus), wrapListener(listener), this.mTag);
        }

        public int purchase(@Nonnull String product, @Nonnull String sku, @Nullable String payload, @Nonnull PurchaseFlow purchaseFlow) {
            Check.isNotEmpty(product);
            Check.isNotEmpty(sku);
            return Billing.this.runWhenConnected(new PurchaseRequest(product, sku, payload), wrapListener(purchaseFlow), this.mTag);
        }

        public int changeSubscription(@Nonnull List<String> oldSkus, @Nonnull String newSku, @Nullable String payload, @Nonnull PurchaseFlow purchaseFlow) {
            Check.isNotEmpty((Collection<?>) oldSkus);
            Check.isNotEmpty(newSku);
            return Billing.this.runWhenConnected(new ChangePurchaseRequest(ProductTypes.SUBSCRIPTION, oldSkus, newSku, payload), wrapListener(purchaseFlow), this.mTag);
        }

        public int changeSubscription(@Nonnull List<Sku> oldSkus, @Nonnull Sku newSku, @Nullable String payload, @Nonnull PurchaseFlow purchaseFlow) {
            Check.isTrue(ProductTypes.SUBSCRIPTION.equals(newSku.f185id.product), "Only subscriptions can be downgraded/upgraded");
            List<String> oldSkuIds = new ArrayList<>(oldSkus.size());
            for (Sku oldSku : oldSkus) {
                Check.isTrue(oldSku.f185id.product.equals(newSku.f185id.product), "Product type can't be changed");
                oldSkuIds.add(oldSku.f185id.code);
            }
            return changeSubscription(oldSkuIds, newSku.f185id.code, payload, purchaseFlow);
        }

        public int isChangeSubscriptionSupported(RequestListener<Object> listener) {
            return isBillingSupported(ProductTypes.SUBSCRIPTION, 5, listener);
        }

        public int purchase(@Nonnull Sku sku, @Nullable String payload, @Nonnull PurchaseFlow purchaseFlow) {
            return purchase(sku.f185id.product, sku.f185id.code, payload, purchaseFlow);
        }

        public int consume(@Nonnull String token, @Nonnull RequestListener<Object> listener) {
            Check.isNotEmpty(token);
            return Billing.this.runWhenConnected(new ConsumePurchaseRequest(token), wrapListener(listener), this.mTag);
        }

        public void cancelAll() {
            Billing.this.mPendingRequests.cancelAll(this.mTag);
        }

        public void cancel(int requestId) {
            Billing.this.mPendingRequests.cancel(requestId);
        }

        private final class IsPurchasedListener implements CancellableRequestListener<Purchases> {
            @Nonnull
            private final RequestListener<Boolean> mListener;
            /* access modifiers changed from: private */
            @Nonnull
            public GetPurchasesRequest mRequest;
            @Nonnull
            private final String mSku;

            public IsPurchasedListener(@Nonnull String sku, @Nonnull RequestListener<Boolean> listener) {
                this.mSku = sku;
                this.mListener = listener;
            }

            public void onSuccess(@Nonnull Purchases purchases) {
                boolean z = false;
                Purchase purchase = purchases.getPurchase(this.mSku);
                if (purchase != null) {
                    RequestListener<Boolean> requestListener = this.mListener;
                    if (purchase.state == Purchase.State.PURCHASED) {
                        z = true;
                    }
                    requestListener.onSuccess(Boolean.valueOf(z));
                } else if (purchases.continuationToken == null) {
                    this.mListener.onSuccess(false);
                } else {
                    this.mRequest = new GetPurchasesRequest(this.mRequest, purchases.continuationToken);
                    int unused = Billing.this.runWhenConnected(this.mRequest, Requests.this.mTag);
                }
            }

            public void onError(int response, @Nonnull Exception e) {
                this.mListener.onError(response, e);
            }

            public void cancel() {
                Billing.cancel((RequestListener<?>) this.mListener);
            }
        }

        private final class GetAllPurchasesListener implements CancellableRequestListener<Purchases> {
            @Nonnull
            private final RequestListener<Purchases> mListener;
            @Nonnull
            private final List<Purchase> mPurchases = new ArrayList();
            /* access modifiers changed from: private */
            @Nonnull
            public GetPurchasesRequest mRequest;

            public GetAllPurchasesListener(@Nonnull RequestListener<Purchases> listener) {
                this.mListener = listener;
            }

            public void onSuccess(@Nonnull Purchases purchases) {
                this.mPurchases.addAll(purchases.list);
                if (purchases.continuationToken == null) {
                    this.mListener.onSuccess(new Purchases(purchases.product, this.mPurchases, (String) null));
                    return;
                }
                this.mRequest = new GetPurchasesRequest(this.mRequest, purchases.continuationToken);
                int unused = Billing.this.runWhenConnected(this.mRequest, Requests.this.mTag);
            }

            public void onError(int response, @Nonnull Exception e) {
                this.mListener.onError(response, e);
            }

            public void cancel() {
                Billing.cancel((RequestListener<?>) this.mListener);
            }
        }
    }

    private class CachingRequestListener<R> extends RequestListenerWrapper<R> {
        @Nonnull
        private final Request<R> mRequest;

        public CachingRequestListener(@Nonnull Request<R> request, @Nonnull RequestListener<R> listener) {
            super(listener);
            Check.isTrue(Billing.this.mCache.hasCache(), "Cache must exist");
            this.mRequest = request;
        }

        public void onSuccess(@Nonnull R result) {
            String key = this.mRequest.getCacheKey();
            RequestType type = this.mRequest.getType();
            if (key != null) {
                Billing.this.mCache.putIfNotExist(type.getCacheKey(key), new Cache.Entry(result, type.expiresIn + System.currentTimeMillis()));
            }
            switch (type) {
                case PURCHASE:
                case CHANGE_PURCHASE:
                case CONSUME_PURCHASE:
                    Billing.this.mCache.removeAll(RequestType.GET_PURCHASES.getCacheKeyType());
                    break;
            }
            super.onSuccess(result);
        }

        public void onError(int response, @Nonnull Exception e) {
            switch (this.mRequest.getType()) {
                case PURCHASE:
                case CHANGE_PURCHASE:
                    if (response == 7) {
                        Billing.this.mCache.removeAll(RequestType.GET_PURCHASES.getCacheKeyType());
                        break;
                    }
                    break;
                case CONSUME_PURCHASE:
                    if (response == 8) {
                        Billing.this.mCache.removeAll(RequestType.GET_PURCHASES.getCacheKeyType());
                        break;
                    }
                    break;
            }
            super.onError(response, e);
        }
    }

    private final class DefaultServiceConnector implements ServiceConnector {
        @Nonnull
        private final ServiceConnection mConnection;

        private DefaultServiceConnector() {
            this.mConnection = new ServiceConnection() {
                public void onServiceDisconnected(ComponentName name) {
                    Billing.this.setService((IInAppBillingService) null, false);
                }

                public void onServiceConnected(ComponentName name, IBinder service) {
                    Billing.this.setService(IInAppBillingService.Stub.asInterface(service), true);
                }
            };
        }

        public boolean connect() {
            try {
                Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                intent.setPackage(zzo.GOOGLE_PLAY_STORE_PACKAGE);
                return Billing.this.mContext.bindService(intent, this.mConnection, 1);
            } catch (IllegalArgumentException | NullPointerException e) {
                return false;
            }
        }

        public void disconnect() {
            Billing.this.mContext.unbindService(this.mConnection);
        }
    }
}
