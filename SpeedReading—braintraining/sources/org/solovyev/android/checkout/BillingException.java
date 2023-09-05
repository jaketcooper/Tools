package org.solovyev.android.checkout;

public final class BillingException extends Exception {
    private final int mResponse;

    BillingException(int response) {
        this.mResponse = response;
    }

    public int getResponse() {
        return this.mResponse;
    }
}
