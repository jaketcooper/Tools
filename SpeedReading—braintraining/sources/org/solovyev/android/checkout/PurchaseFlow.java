package org.solovyev.android.checkout;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONException;

public final class PurchaseFlow implements CancellableRequestListener<PendingIntent> {
    static final String EXTRA_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
    static final String EXTRA_PURCHASE_SIGNATURE = "INAPP_DATA_SIGNATURE";
    static final String EXTRA_RESPONSE = "RESPONSE_CODE";
    @Nonnull
    private final IntentStarter mIntentStarter;
    /* access modifiers changed from: private */
    @Nullable
    public RequestListener<Purchase> mListener;
    private final int mRequestCode;
    @Nonnull
    private final PurchaseVerifier mVerifier;

    PurchaseFlow(@Nonnull IntentStarter intentStarter, int requestCode, @Nonnull RequestListener<Purchase> listener, @Nonnull PurchaseVerifier verifier) {
        this.mIntentStarter = intentStarter;
        this.mRequestCode = requestCode;
        this.mListener = listener;
        this.mVerifier = verifier;
    }

    public void onSuccess(@Nonnull PendingIntent purchaseIntent) {
        if (this.mListener != null) {
            try {
                this.mIntentStarter.startForResult(purchaseIntent.getIntentSender(), this.mRequestCode, new Intent());
            } catch (IntentSender.SendIntentException | RuntimeException e) {
                handleError(e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        try {
            Check.equals(this.mRequestCode, requestCode);
            if (intent == null) {
                handleError((int) ResponseCodes.NULL_INTENT);
                return;
            }
            int responseCode = intent.getIntExtra(EXTRA_RESPONSE, 0);
            if (resultCode == -1 && responseCode == 0) {
                String data = intent.getStringExtra(EXTRA_PURCHASE_DATA);
                String signature = intent.getStringExtra(EXTRA_PURCHASE_SIGNATURE);
                Check.isNotNull(data);
                Check.isNotNull(signature);
                this.mVerifier.verify(Collections.singletonList(Purchase.fromJson(data, signature)), new VerificationListener());
                return;
            }
            handleError(responseCode);
        } catch (RuntimeException | JSONException e) {
            handleError(e);
        }
    }

    /* access modifiers changed from: private */
    public void handleError(int response) {
        Billing.error("Error response: " + response + " in Purchase/ChangePurchase request");
        onError(response, new BillingException(response));
    }

    /* access modifiers changed from: private */
    public void handleError(@Nonnull Exception e) {
        Billing.error("Exception in Purchase/ChangePurchase request: ", e);
        onError(ResponseCodes.EXCEPTION, e);
    }

    public void onError(int response, @Nonnull Exception e) {
        if (this.mListener != null) {
            this.mListener.onError(response, e);
        }
    }

    public void cancel() {
        if (this.mListener != null) {
            Billing.cancel((RequestListener<?>) this.mListener);
            this.mListener = null;
        }
    }

    private class VerificationListener implements RequestListener<List<Purchase>> {
        private VerificationListener() {
        }

        public void onSuccess(@Nonnull List<Purchase> verifiedPurchases) {
            Check.isMainThread();
            if (verifiedPurchases.isEmpty()) {
                PurchaseFlow.this.handleError((int) ResponseCodes.WRONG_SIGNATURE);
            } else if (PurchaseFlow.this.mListener != null) {
                PurchaseFlow.this.mListener.onSuccess(verifiedPurchases.get(0));
            }
        }

        public void onError(int response, @Nonnull Exception e) {
            Check.isMainThread();
            if (response == 10001) {
                PurchaseFlow.this.handleError(e);
            } else {
                PurchaseFlow.this.handleError(response);
            }
        }
    }
}
