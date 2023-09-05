package org.solovyev.android.checkout;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import org.json.JSONException;

@Immutable
public final class Skus {
    @Nonnull
    static final String BUNDLE_LIST = "DETAILS_LIST";
    @Nonnull
    public final List<Sku> list;
    @Nonnull
    public final String product;

    Skus(@Nonnull String product2, @Nonnull List<Sku> list2) {
        this.product = product2;
        this.list = Collections.unmodifiableList(list2);
    }

    @Nonnull
    static Skus fromBundle(@Nonnull Bundle bundle, @Nonnull String product2) throws RequestException {
        List<String> list2 = extractList(bundle);
        List<Sku> skus = new ArrayList<>(list2.size());
        for (String response : list2) {
            try {
                skus.add(Sku.fromJson(response, product2));
            } catch (JSONException e) {
                throw new RequestException(e);
            }
        }
        return new Skus(product2, skus);
    }

    @Nonnull
    private static List<String> extractList(@Nonnull Bundle bundle) {
        List<String> list2 = bundle.getStringArrayList(BUNDLE_LIST);
        return list2 != null ? list2 : Collections.emptyList();
    }

    @Nullable
    public Sku getSku(@Nonnull String sku) {
        for (Sku s : this.list) {
            if (s.f185id.code.equals(sku)) {
                return s;
            }
        }
        return null;
    }

    public boolean hasSku(@Nonnull String sku) {
        return getSku(sku) != null;
    }
}
