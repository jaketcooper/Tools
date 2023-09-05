package org.solovyev.android.checkout;

import javax.annotation.Nonnull;

public interface RequestListener<R> {
    void onError(int i, @Nonnull Exception exc);

    void onSuccess(@Nonnull R r);
}
