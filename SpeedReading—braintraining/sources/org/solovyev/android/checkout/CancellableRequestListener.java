package org.solovyev.android.checkout;

interface CancellableRequestListener<R> extends RequestListener<R> {
    void cancel();
}
