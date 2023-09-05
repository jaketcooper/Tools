package org.solovyev.android.checkout;

import javax.annotation.Nonnull;

public class EmptyRequestListener<R> implements RequestListener<R> {
    public void onSuccess(@Nonnull R r) {
    }

    public void onError(int response, @Nonnull Exception e) {
    }
}
