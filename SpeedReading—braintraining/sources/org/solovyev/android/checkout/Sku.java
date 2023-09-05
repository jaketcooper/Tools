package org.solovyev.android.checkout;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.sqlliteimpl.BookDescriptionDatabaseHelper;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import org.json.JSONException;
import org.json.JSONObject;

@Immutable
public final class Sku {
    @Nonnull
    public final String description;
    @Nonnull
    public final Price detailedPrice;
    @Nonnull

    /* renamed from: id */
    public final C1230Id f185id;
    @Nullable
    private String mDisplayTitle;
    @Nonnull
    public final String price;
    @Nonnull
    public final String title;

    public Sku(@Nonnull String product, @Nonnull String code, @Nonnull String price2, @Nonnull Price detailedPrice2, @Nonnull String title2, @Nonnull String description2) {
        this.f185id = new C1230Id(product, code);
        this.price = price2;
        this.detailedPrice = detailedPrice2;
        this.title = title2;
        this.description = description2;
    }

    Sku(@Nonnull String json, @Nonnull String product) throws JSONException {
        JSONObject object = new JSONObject(json);
        this.f185id = new C1230Id(product, object.getString("productId"));
        this.price = object.getString(FirebaseAnalytics.Param.PRICE);
        this.detailedPrice = Price.fromJson(object);
        this.title = object.getString(BookDescriptionDatabaseHelper.BOOK_TITLE);
        this.description = object.optString("description");
    }

    @Nonnull
    static Sku fromJson(@Nonnull String json, @Nonnull String product) throws JSONException {
        return new Sku(json, product);
    }

    /* access modifiers changed from: package-private */
    @Nonnull
    public String toJson() throws JSONException {
        return toJsonObject().toString();
    }

    @Nonnull
    private JSONObject toJsonObject() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("productId", this.f185id.code);
        json.put(FirebaseAnalytics.Param.PRICE, this.price);
        json.put("price_amount_micros", this.detailedPrice.amount);
        json.put("price_currency_code", this.detailedPrice.currency);
        json.put(BookDescriptionDatabaseHelper.BOOK_TITLE, this.title);
        json.put("description", this.description);
        return json;
    }

    public String toString() {
        return this.f185id + "{" + getDisplayTitle() + ", " + this.price + "}";
    }

    @Nonnull
    public String getDisplayTitle() {
        if (this.mDisplayTitle == null) {
            this.mDisplayTitle = makeDisplayTitle(this.title);
        }
        return this.mDisplayTitle;
    }

    @Nonnull
    private static String makeDisplayTitle(String title2) {
        int i;
        if (TextUtils.isEmpty(title2)) {
            return "";
        }
        if (title2.charAt(title2.length() - 1) != ')' || (i = indexOfAppName(title2)) <= 0) {
            return title2;
        }
        return title2.substring(0, i).trim();
    }

    private static int indexOfAppName(String title2) {
        int depth = 0;
        for (int i = title2.length() - 1; i >= 0; i--) {
            char c = title2.charAt(i);
            if (c == ')') {
                depth++;
            } else if (c == '(') {
                depth--;
            }
            if (depth == 0) {
                return i;
            }
        }
        return -1;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return this.f185id.equals(((Sku) o).f185id);
    }

    public int hashCode() {
        return this.f185id.hashCode();
    }

    public boolean isInApp() {
        return this.f185id.isInApp();
    }

    public boolean isSubscription() {
        return this.f185id.isSubscription();
    }

    /* renamed from: org.solovyev.android.checkout.Sku$Id */
    public static final class C1230Id {
        public final String code;
        public final String product;

        public C1230Id(String product2, String code2) {
            this.product = product2;
            this.code = code2;
        }

        public boolean isInApp() {
            return this.product.equals(ProductTypes.IN_APP);
        }

        public boolean isSubscription() {
            return this.product.equals(ProductTypes.SUBSCRIPTION);
        }

        public String toString() {
            return this.product + "/" + this.code;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            C1230Id that = (C1230Id) o;
            if (this.product.equals(that.product)) {
                return this.code.equals(that.code);
            }
            return false;
        }

        public int hashCode() {
            return (this.product.hashCode() * 31) + this.code.hashCode();
        }
    }

    public static final class Price {
        @Nonnull
        public static final Price EMPTY = new Price(0, "");
        public final long amount;
        @Nonnull
        public final String currency;

        public Price(long amount2, @Nonnull String currency2) {
            this.amount = amount2;
            this.currency = currency2;
        }

        /* access modifiers changed from: private */
        @Nonnull
        public static Price fromJson(@Nonnull JSONObject json) throws JSONException {
            long amount2 = json.optLong("price_amount_micros");
            String currency2 = json.optString("price_currency_code");
            if (amount2 == 0 || TextUtils.isEmpty(currency2)) {
                return EMPTY;
            }
            return new Price(amount2, currency2);
        }

        public boolean isValid() {
            return this.amount > 0 && !TextUtils.isEmpty(this.currency);
        }

        public String toString() {
            return this.currency + this.amount;
        }
    }
}
