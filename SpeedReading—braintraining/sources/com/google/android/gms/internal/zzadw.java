package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;

@zzzb
public final class zzadw extends zzbej {
    public static final Parcelable.Creator<zzadw> CREATOR = new zzadx();
    public final String type;
    public final int zzcuk;

    public zzadw(RewardItem rewardItem) {
        this(rewardItem.getType(), rewardItem.getAmount());
    }

    public zzadw(String str, int i) {
        this.type = str;
        this.zzcuk = i;
    }

    @Nullable
    public static zzadw zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new zzadw(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    @Nullable
    public static zzadw zzbt(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return zza(new JSONArray(str));
        } catch (JSONException e) {
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzadw)) {
            return false;
        }
        zzadw zzadw = (zzadw) obj;
        return zzbg.equal(this.type, zzadw.type) && zzbg.equal(Integer.valueOf(this.zzcuk), Integer.valueOf(zzadw.zzcuk));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.type, Integer.valueOf(this.zzcuk)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zza(parcel, 2, this.type, false);
        zzbem.zzc(parcel, 3, this.zzcuk);
        zzbem.zzai(parcel, zze);
    }
}
