package org.solovyev.android.checkout;

import javax.annotation.Nonnull;

class SameThreadExecutor implements CancellableExecutor {
    @Nonnull
    public static final SameThreadExecutor INSTANCE = new SameThreadExecutor();

    private SameThreadExecutor() {
    }

    public void execute(@Nonnull Runnable command) {
        command.run();
    }

    public void cancel(@Nonnull Runnable runnable) {
    }
}
