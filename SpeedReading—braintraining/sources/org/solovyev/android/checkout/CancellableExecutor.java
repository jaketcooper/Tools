package org.solovyev.android.checkout;

import java.util.concurrent.Executor;
import javax.annotation.Nonnull;

interface CancellableExecutor extends Executor {
    void cancel(@Nonnull Runnable runnable);

    void execute(@Nonnull Runnable runnable);
}
