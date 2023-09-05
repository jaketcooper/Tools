package org.solovyev.android.checkout;

import javax.annotation.Nonnull;

final class CustomUiCheckout extends UiCheckout {
    @Nonnull
    private final IntentStarter mIntentStarter;

    CustomUiCheckout(@Nonnull IntentStarter intentStarter, @Nonnull Object tag, @Nonnull Billing billing) {
        super(tag, billing);
        this.mIntentStarter = intentStarter;
    }

    /* access modifiers changed from: protected */
    @Nonnull
    public IntentStarter makeIntentStarter() {
        return this.mIntentStarter;
    }
}
