package org.solovyev.android.checkout;

import android.content.Intent;
import android.content.IntentSender;
import javax.annotation.Nonnull;

public interface IntentStarter {
    void startForResult(@Nonnull IntentSender intentSender, int i, @Nonnull Intent intent) throws IntentSender.SendIntentException;
}
