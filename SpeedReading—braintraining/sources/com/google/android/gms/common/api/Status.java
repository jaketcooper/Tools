package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbej;
import com.google.android.gms.internal.zzbem;
import java.util.Arrays;

public final class Status extends zzbej implements Result, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new zzg();
    public static final Status zzfky = new Status(0);
    public static final Status zzfkz = new Status(14);
    public static final Status zzfla = new Status(8);
    public static final Status zzflb = new Status(15);
    public static final Status zzflc = new Status(16);
    public static final Status zzfld = new Status(17);
    private static Status zzfle = new Status(18);
    private int zzdzm;
    @Nullable
    private final PendingIntent zzebp;
    private final int zzfda;
    @Nullable
    private final String zzfij;

    public Status(int i) {
        this(i, (String) null);
    }

    Status(int i, int i2, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        this.zzdzm = i;
        this.zzfda = i2;
        this.zzfij = str;
        this.zzebp = pendingIntent;
    }

    public Status(int i, @Nullable String str) {
        this(1, i, str, (PendingIntent) null);
    }

    public Status(int i, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.zzdzm == status.zzdzm && this.zzfda == status.zzfda && zzbg.equal(this.zzfij, status.zzfij) && zzbg.equal(this.zzebp, status.zzebp);
    }

    public final PendingIntent getResolution() {
        return this.zzebp;
    }

    public final Status getStatus() {
        return this;
    }

    public final int getStatusCode() {
        return this.zzfda;
    }

    @Nullable
    public final String getStatusMessage() {
        return this.zzfij;
    }

    public final boolean hasResolution() {
        return this.zzebp != null;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzdzm), Integer.valueOf(this.zzfda), this.zzfij, this.zzebp});
    }

    public final boolean isCanceled() {
        return this.zzfda == 16;
    }

    public final boolean isInterrupted() {
        return this.zzfda == 14;
    }

    public final boolean isSuccess() {
        return this.zzfda <= 0;
    }

    public final void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.zzebp.getIntentSender(), i, (Intent) null, 0, 0, 0);
        }
    }

    public final String toString() {
        return zzbg.zzw(this).zzg("statusCode", zzagl()).zzg("resolution", this.zzebp).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zzc(parcel, 1, getStatusCode());
        zzbem.zza(parcel, 2, getStatusMessage(), false);
        zzbem.zza(parcel, 3, (Parcelable) this.zzebp, i, false);
        zzbem.zzc(parcel, 1000, this.zzdzm);
        zzbem.zzai(parcel, zze);
    }

    public final String zzagl() {
        return this.zzfij != null ? this.zzfij : CommonStatusCodes.getStatusCodeString(this.zzfda);
    }
}
