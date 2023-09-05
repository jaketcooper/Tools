package org.solovyev.android.checkout;

import javax.annotation.Nullable;

interface RequestRunnable {
    void cancel();

    int getId();

    @Nullable
    Request getRequest();

    @Nullable
    Object getTag();

    boolean run();
}
