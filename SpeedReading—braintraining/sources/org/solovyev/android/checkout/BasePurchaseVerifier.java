package org.solovyev.android.checkout;

import android.os.Handler;
import android.os.Looper;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;

public abstract class BasePurchaseVerifier implements PurchaseVerifier {
    @Nonnull
    private final Executor mBackground;
    /* access modifiers changed from: private */
    @Nonnull
    public final MainThread mMainThread;

    /* access modifiers changed from: protected */
    public abstract void doVerify(@Nonnull List<Purchase> list, @Nonnull RequestListener<List<Purchase>> requestListener);

    protected BasePurchaseVerifier() {
        this(new Handler(Looper.getMainLooper()));
    }

    protected BasePurchaseVerifier(@Nonnull Handler handler) {
        this(handler, 2, defaultThreadFactory());
    }

    protected BasePurchaseVerifier(@Nonnull Handler handler, int threadCount, @Nonnull ThreadFactory threadFactory) {
        this.mMainThread = new MainThread(handler);
        this.mBackground = Executors.newFixedThreadPool(threadCount, threadFactory);
    }

    @Nonnull
    private static ThreadFactory defaultThreadFactory() {
        return new ThreadFactory() {
            @Nonnull
            private final AtomicInteger mCount = new AtomicInteger();

            public Thread newThread(@Nonnull Runnable r) {
                return new Thread(r, "PurchaseVerifierThread #" + this.mCount.getAndIncrement());
            }
        };
    }

    public final void verify(@Nonnull final List<Purchase> purchases, @Nonnull final RequestListener<List<Purchase>> listener) {
        if (MainThread.isMainThread()) {
            this.mBackground.execute(new Runnable() {
                public void run() {
                    BasePurchaseVerifier.this.doVerify(purchases, new MainThreadRequestListener(listener));
                }
            });
        } else {
            doVerify(purchases, listener);
        }
    }

    private final class MainThreadRequestListener implements RequestListener<List<Purchase>> {
        /* access modifiers changed from: private */
        @Nonnull
        public final RequestListener<List<Purchase>> mListener;

        private MainThreadRequestListener(@Nonnull RequestListener<List<Purchase>> listener) {
            this.mListener = listener;
        }

        public void onSuccess(@Nonnull final List<Purchase> result) {
            BasePurchaseVerifier.this.mMainThread.execute(new Runnable() {
                public void run() {
                    MainThreadRequestListener.this.mListener.onSuccess(result);
                }
            });
        }

        public void onError(final int response, @Nonnull final Exception e) {
            BasePurchaseVerifier.this.mMainThread.execute(new Runnable() {
                public void run() {
                    MainThreadRequestListener.this.mListener.onError(response, e);
                }
            });
        }
    }
}
