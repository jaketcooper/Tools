package org.solovyev.android.checkout;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nonnull;

public final class ProductTypes {
    public static final List<String> ALL = Arrays.asList(new String[]{IN_APP, SUBSCRIPTION});
    public static final String IN_APP = "inapp";
    public static final String SUBSCRIPTION = "subs";

    private ProductTypes() {
        throw new AssertionError();
    }

    static void checkSupported(@Nonnull String product) {
        Check.isTrue(ALL.contains(product), "Unsupported product: " + product);
    }
}
