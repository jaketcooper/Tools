package org.solovyev.android.checkout;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import javax.annotation.Nonnull;

public final class ActivityCheckout extends UiCheckout {
    /* access modifiers changed from: private */
    @Nonnull
    public final Activity mActivity;
    @Nonnull
    private final IntentStarter mIntentStarter = new IntentStarter() {
        public void startForResult(@Nonnull IntentSender intentSender, int requestCode, @Nonnull Intent intent) throws IntentSender.SendIntentException {
            ActivityCheckout.this.mActivity.startIntentSenderForResult(intentSender, requestCode, intent, 0, 0, 0);
        }
    };

    ActivityCheckout(@Nonnull Activity activity, @Nonnull Billing billing) {
        super(activity, billing);
        this.mActivity = activity;
    }

    /* access modifiers changed from: protected */
    @Nonnull
    public IntentStarter makeIntentStarter() {
        return this.mIntentStarter;
    }
}
