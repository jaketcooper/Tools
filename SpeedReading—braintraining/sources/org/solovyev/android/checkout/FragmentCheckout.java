package org.solovyev.android.checkout;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import javax.annotation.Nonnull;

@TargetApi(24)
final class FragmentCheckout extends UiCheckout implements IntentStarter {
    @Nonnull
    private final Fragment mFragment;

    FragmentCheckout(@Nonnull Fragment fragment, @Nonnull Billing billing) {
        super(fragment, billing);
        this.mFragment = fragment;
    }

    /* access modifiers changed from: protected */
    @Nonnull
    public IntentStarter makeIntentStarter() {
        return this;
    }

    public void startForResult(@Nonnull IntentSender intentSender, int requestCode, @Nonnull Intent intent) throws IntentSender.SendIntentException {
        this.mFragment.startIntentSenderForResult(intentSender, requestCode, intent, 0, 0, 0, (Bundle) null);
    }
}
