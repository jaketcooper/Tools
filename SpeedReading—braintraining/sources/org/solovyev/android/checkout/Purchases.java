package org.solovyev.android.checkout;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.solovyev.android.checkout.Purchase;

@Immutable
public final class Purchases {
    static final String BUNDLE_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    static final String BUNDLE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    static final String BUNDLE_SIGNATURE_LIST = "INAPP_DATA_SIGNATURE_LIST";
    @Nullable
    public final String continuationToken;
    @Nonnull
    public final List<Purchase> list;
    @Nonnull
    public final String product;

    Purchases(@Nonnull String product2, @Nonnull List<Purchase> list2, @Nullable String continuationToken2) {
        this.product = product2;
        this.list = Collections.unmodifiableList(list2);
        this.continuationToken = continuationToken2;
    }

    @Nonnull
    static Purchases fromBundle(@Nonnull Bundle bundle, @Nonnull String product2) throws JSONException {
        return new Purchases(product2, getListFromBundle(bundle), getContinuationTokenFromBundle(bundle));
    }

    @Nullable
    static String getContinuationTokenFromBundle(@Nonnull Bundle bundle) {
        return bundle.getString(BUNDLE_CONTINUATION_TOKEN);
    }

    @Nonnull
    static List<Purchase> getListFromBundle(@Nonnull Bundle bundle) throws JSONException {
        List<String> datas = extractDatasList(bundle);
        List<String> signatures = bundle.getStringArrayList(BUNDLE_SIGNATURE_LIST);
        List<Purchase> purchases = new ArrayList<>(datas.size());
        for (int i = 0; i < datas.size(); i++) {
            purchases.add(Purchase.fromJson(datas.get(i), signatures != null ? signatures.get(i) : ""));
        }
        return purchases;
    }

    @Nonnull
    private static List<String> extractDatasList(@Nonnull Bundle bundle) {
        List<String> list2 = bundle.getStringArrayList(BUNDLE_DATA_LIST);
        return list2 != null ? list2 : Collections.emptyList();
    }

    @Nullable
    static Purchase getPurchaseInState(@Nonnull List<Purchase> purchases, @Nonnull String sku, @Nonnull Purchase.State state) {
        for (Purchase purchase : purchases) {
            if (purchase.sku.equals(sku) && purchase.state == state) {
                return purchase;
            }
        }
        return null;
    }

    @Nonnull
    static List<Purchase> neutralize(@Nonnull List<Purchase> purchases) {
        List<Purchase> purchases2 = new LinkedList<>(purchases);
        List<Purchase> result = new ArrayList<>(purchases2.size());
        Collections.sort(purchases2, PurchaseComparator.earliestFirst());
        while (!purchases2.isEmpty()) {
            Purchase purchase = purchases2.get(0);
            switch (purchase.state) {
                case PURCHASED:
                    if (isNeutralized(purchases2, purchase)) {
                        break;
                    } else {
                        result.add(purchase);
                        break;
                    }
                case CANCELLED:
                case REFUNDED:
                case EXPIRED:
                    if (isDangling(purchases2, purchase)) {
                        break;
                    } else {
                        result.add(purchase);
                        break;
                    }
            }
            purchases2.remove(0);
        }
        Collections.reverse(result);
        return result;
    }

    private static boolean isDangling(@Nonnull List<Purchase> purchases, @Nonnull Purchase purchase) {
        boolean z;
        if (purchase.state == Purchase.State.PURCHASED) {
            z = true;
        } else {
            z = false;
        }
        Check.isFalse(z, "Must not be PURCHASED");
        for (int i = 1; i < purchases.size(); i++) {
            if (purchases.get(i).sku.equals(purchase.sku)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNeutralized(@Nonnull List<Purchase> purchases, @Nonnull Purchase purchase) {
        boolean z;
        if (purchase.state == Purchase.State.PURCHASED) {
            z = true;
        } else {
            z = false;
        }
        Check.isTrue(z, "Must be PURCHASED");
        int i = 1;
        while (i < purchases.size()) {
            Purchase same = purchases.get(i);
            if (same.sku.equals(purchase.sku)) {
                switch (same.state) {
                    case PURCHASED:
                        Billing.warning("Two purchases with same SKU found: " + purchase + " and " + same);
                        return true;
                    case CANCELLED:
                    case REFUNDED:
                    case EXPIRED:
                        purchases.remove(i);
                        return true;
                    default:
                        return true;
                }
            } else {
                i++;
            }
        }
        return false;
    }

    @Nonnull
    public String toJson() {
        return toJson(false);
    }

    @Nonnull
    public String toJson(boolean withSignatures) {
        return toJsonObject(withSignatures).toString();
    }

    /* access modifiers changed from: package-private */
    @Nonnull
    public JSONObject toJsonObject(boolean withSignatures) {
        JSONObject json = new JSONObject();
        try {
            json.put("product", this.product);
            JSONArray array = new JSONArray();
            for (int i = 0; i < this.list.size(); i++) {
                array.put(i, this.list.get(i).toJsonObject(withSignatures));
            }
            json.put("list", array);
            return json;
        } catch (JSONException e) {
            throw new AssertionError(e);
        }
    }

    @Nullable
    public Purchase getPurchase(@Nonnull String sku) {
        for (Purchase purchase : this.list) {
            if (purchase.sku.equals(sku)) {
                return purchase;
            }
        }
        return null;
    }

    public boolean hasPurchase(@Nonnull String sku) {
        return getPurchase(sku) != null;
    }

    public boolean hasPurchaseInState(@Nonnull String sku, @Nonnull Purchase.State state) {
        return getPurchaseInState(sku, state) != null;
    }

    @Nullable
    public Purchase getPurchaseInState(@Nonnull String sku, @Nonnull Purchase.State state) {
        return getPurchaseInState(this.list, sku, state);
    }
}
