package com.google.firebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzca;
import com.google.android.gms.common.util.zzu;
import java.util.Arrays;

public final class FirebaseOptions {
    /* access modifiers changed from: private */
    public final String zzekr;
    /* access modifiers changed from: private */
    public final String zzlxd;
    /* access modifiers changed from: private */
    public final String zzlxe;
    /* access modifiers changed from: private */
    public final String zzlxf;
    /* access modifiers changed from: private */
    public final String zzlxg;
    /* access modifiers changed from: private */
    public final String zzlxh;
    /* access modifiers changed from: private */
    public final String zzlxi;

    public static final class Builder {
        private String zzekr;
        private String zzlxd;
        private String zzlxe;
        private String zzlxf;
        private String zzlxg;
        private String zzlxh;
        private String zzlxi;

        public Builder() {
        }

        public Builder(FirebaseOptions firebaseOptions) {
            this.zzekr = firebaseOptions.zzekr;
            this.zzlxd = firebaseOptions.zzlxd;
            this.zzlxe = firebaseOptions.zzlxe;
            this.zzlxf = firebaseOptions.zzlxf;
            this.zzlxg = firebaseOptions.zzlxg;
            this.zzlxh = firebaseOptions.zzlxh;
            this.zzlxi = firebaseOptions.zzlxi;
        }

        public final FirebaseOptions build() {
            return new FirebaseOptions(this.zzekr, this.zzlxd, this.zzlxe, this.zzlxf, this.zzlxg, this.zzlxh, this.zzlxi);
        }

        public final Builder setApiKey(@NonNull String str) {
            this.zzlxd = zzbq.zzh(str, "ApiKey must be set.");
            return this;
        }

        public final Builder setApplicationId(@NonNull String str) {
            this.zzekr = zzbq.zzh(str, "ApplicationId must be set.");
            return this;
        }

        public final Builder setDatabaseUrl(@Nullable String str) {
            this.zzlxe = str;
            return this;
        }

        public final Builder setGcmSenderId(@Nullable String str) {
            this.zzlxg = str;
            return this;
        }

        public final Builder setProjectId(@Nullable String str) {
            this.zzlxi = str;
            return this;
        }

        public final Builder setStorageBucket(@Nullable String str) {
            this.zzlxh = str;
            return this;
        }
    }

    private FirebaseOptions(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        zzbq.zza(!zzu.zzgo(str), (Object) "ApplicationId must be set.");
        this.zzekr = str;
        this.zzlxd = str2;
        this.zzlxe = str3;
        this.zzlxf = str4;
        this.zzlxg = str5;
        this.zzlxh = str6;
        this.zzlxi = str7;
    }

    public static FirebaseOptions fromResource(Context context) {
        zzca zzca = new zzca(context);
        String string = zzca.getString("google_app_id");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new FirebaseOptions(string, zzca.getString("google_api_key"), zzca.getString("firebase_database_url"), zzca.getString("ga_trackingId"), zzca.getString("gcm_defaultSenderId"), zzca.getString("google_storage_bucket"), zzca.getString("project_id"));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        return zzbg.equal(this.zzekr, firebaseOptions.zzekr) && zzbg.equal(this.zzlxd, firebaseOptions.zzlxd) && zzbg.equal(this.zzlxe, firebaseOptions.zzlxe) && zzbg.equal(this.zzlxf, firebaseOptions.zzlxf) && zzbg.equal(this.zzlxg, firebaseOptions.zzlxg) && zzbg.equal(this.zzlxh, firebaseOptions.zzlxh) && zzbg.equal(this.zzlxi, firebaseOptions.zzlxi);
    }

    public final String getApiKey() {
        return this.zzlxd;
    }

    public final String getApplicationId() {
        return this.zzekr;
    }

    public final String getDatabaseUrl() {
        return this.zzlxe;
    }

    public final String getGcmSenderId() {
        return this.zzlxg;
    }

    public final String getProjectId() {
        return this.zzlxi;
    }

    public final String getStorageBucket() {
        return this.zzlxh;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzekr, this.zzlxd, this.zzlxe, this.zzlxf, this.zzlxg, this.zzlxh, this.zzlxi});
    }

    public final String toString() {
        return zzbg.zzw(this).zzg("applicationId", this.zzekr).zzg("apiKey", this.zzlxd).zzg("databaseUrl", this.zzlxe).zzg("gcmSenderId", this.zzlxg).zzg("storageBucket", this.zzlxh).zzg("projectId", this.zzlxi).toString();
    }
}
