package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.p000v4.p002os.EnvironmentCompat;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbi;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbej;
import com.google.android.gms.internal.zzbem;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;

public class PlaceReport extends zzbej implements ReflectedParcelable {
    public static final Parcelable.Creator<PlaceReport> CREATOR = new zzl();
    private final String mTag;
    private final String zzdoe;
    private int zzdzm;
    private final String zzikw;

    PlaceReport(int i, String str, String str2, String str3) {
        this.zzdzm = i;
        this.zzikw = str;
        this.mTag = str2;
        this.zzdoe = str3;
    }

    public static PlaceReport create(String str, String str2) {
        boolean z = false;
        zzbq.checkNotNull(str);
        zzbq.zzgi(str2);
        zzbq.zzgi(EnvironmentCompat.MEDIA_UNKNOWN);
        char c = 65535;
        switch (EnvironmentCompat.MEDIA_UNKNOWN.hashCode()) {
            case -1436706272:
                if (EnvironmentCompat.MEDIA_UNKNOWN.equals("inferredGeofencing")) {
                    c = 2;
                    break;
                }
                break;
            case -1194968642:
                if (EnvironmentCompat.MEDIA_UNKNOWN.equals("userReported")) {
                    c = 1;
                    break;
                }
                break;
            case -284840886:
                if (EnvironmentCompat.MEDIA_UNKNOWN.equals(EnvironmentCompat.MEDIA_UNKNOWN)) {
                    c = 0;
                    break;
                }
                break;
            case -262743844:
                if (EnvironmentCompat.MEDIA_UNKNOWN.equals("inferredReverseGeocoding")) {
                    c = 4;
                    break;
                }
                break;
            case 1164924125:
                if (EnvironmentCompat.MEDIA_UNKNOWN.equals("inferredSnappedToRoad")) {
                    c = 5;
                    break;
                }
                break;
            case 1287171955:
                if (EnvironmentCompat.MEDIA_UNKNOWN.equals("inferredRadioSignals")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                z = true;
                break;
        }
        zzbq.checkArgument(z, "Invalid source");
        return new PlaceReport(1, str, str2, EnvironmentCompat.MEDIA_UNKNOWN);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return zzbg.equal(this.zzikw, placeReport.zzikw) && zzbg.equal(this.mTag, placeReport.mTag) && zzbg.equal(this.zzdoe, placeReport.zzdoe);
    }

    public String getPlaceId() {
        return this.zzikw;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzikw, this.mTag, this.zzdoe});
    }

    public String toString() {
        zzbi zzw = zzbg.zzw(this);
        zzw.zzg("placeId", this.zzikw);
        zzw.zzg("tag", this.mTag);
        if (!EnvironmentCompat.MEDIA_UNKNOWN.equals(this.zzdoe)) {
            zzw.zzg(FirebaseAnalytics.Param.SOURCE, this.zzdoe);
        }
        return zzw.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zzc(parcel, 1, this.zzdzm);
        zzbem.zza(parcel, 2, getPlaceId(), false);
        zzbem.zza(parcel, 3, getTag(), false);
        zzbem.zza(parcel, 4, this.zzdoe, false);
        zzbem.zzai(parcel, zze);
    }
}
