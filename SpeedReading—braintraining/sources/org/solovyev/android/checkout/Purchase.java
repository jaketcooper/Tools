package org.solovyev.android.checkout;

import android.text.TextUtils;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import org.json.JSONException;
import org.json.JSONObject;

@Immutable
public final class Purchase {
    public final boolean autoRenewing;
    @Nonnull
    public final String data;
    @Nonnull
    public final String orderId;
    @Nonnull
    public final String packageName;
    @Nonnull
    public final String payload;
    @Nonnull
    public final String signature;
    @Nonnull
    public final String sku;
    @Nonnull
    public final State state;
    public final long time;
    @Nonnull
    public final String token;

    Purchase(@Nonnull String sku2, @Nonnull String orderId2, @Nonnull String packageName2, long time2, int state2, @Nonnull String payload2, @Nonnull String token2, boolean autoRenewing2, @Nonnull String data2, @Nonnull String signature2) {
        this.sku = sku2;
        this.orderId = orderId2;
        this.packageName = packageName2;
        this.time = time2;
        this.state = State.valueOf(state2);
        this.payload = payload2;
        this.token = token2;
        this.autoRenewing = autoRenewing2;
        this.signature = signature2;
        this.data = data2;
    }

    Purchase(@Nonnull String data2, @Nonnull String signature2) throws JSONException {
        JSONObject json = new JSONObject(data2);
        this.sku = json.getString("productId");
        this.orderId = json.optString("orderId");
        this.packageName = json.optString("packageName");
        this.time = json.getLong("purchaseTime");
        this.state = State.valueOf(json.optInt("purchaseState", 0));
        this.payload = json.optString("developerPayload");
        this.token = json.optString("token", json.optString("purchaseToken"));
        this.autoRenewing = json.optBoolean("autoRenewing");
        this.data = data2;
        this.signature = signature2;
    }

    @Nonnull
    static Purchase fromJson(@Nonnull String data2, @Nonnull String signature2) throws JSONException {
        return new Purchase(data2, signature2);
    }

    private static void tryPut(@Nonnull JSONObject json, @Nonnull String key, @Nonnull String name) throws JSONException {
        if (!TextUtils.isEmpty(name)) {
            json.put(key, name);
        }
    }

    @Nonnull
    public String toJson() {
        return toJson(false);
    }

    @Nonnull
    public String toJson(boolean withSignature) {
        return toJsonObject(withSignature).toString();
    }

    /* access modifiers changed from: package-private */
    @Nonnull
    public JSONObject toJsonObject(boolean withSignature) {
        JSONObject json = new JSONObject();
        try {
            json.put("productId", this.sku);
            tryPut(json, "orderId", this.orderId);
            tryPut(json, "packageName", this.packageName);
            json.put("purchaseTime", this.time);
            json.put("purchaseState", this.state.f183id);
            tryPut(json, "developerPayload", this.payload);
            tryPut(json, "token", this.token);
            if (this.autoRenewing) {
                json.put("autoRenewing", true);
            }
            if (withSignature) {
                tryPut(json, "signature", this.signature);
            }
            return json;
        } catch (JSONException e) {
            throw new AssertionError(e);
        }
    }

    public String toString() {
        return "Purchase{state=" + this.state + ", time=" + this.time + ", sku='" + this.sku + '\'' + '}';
    }

    public enum State {
        PURCHASED(0),
        CANCELLED(1),
        REFUNDED(2),
        EXPIRED(3);
        

        /* renamed from: id */
        public final int f183id;

        private State(int id) {
            this.f183id = id;
        }

        @Nonnull
        static State valueOf(int id) {
            switch (id) {
                case 0:
                    return PURCHASED;
                case 1:
                    return CANCELLED;
                case 2:
                    return REFUNDED;
                case 3:
                    return EXPIRED;
                default:
                    throw new IllegalArgumentException("Id=" + id + " is not supported");
            }
        }
    }
}
