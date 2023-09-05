package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new zzq();
    private IBinder zzfwv;

    public BinderWrapper() {
        this.zzfwv = null;
    }

    public BinderWrapper(IBinder iBinder) {
        this.zzfwv = null;
        this.zzfwv = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        this.zzfwv = null;
        this.zzfwv = parcel.readStrongBinder();
    }

    /* synthetic */ BinderWrapper(Parcel parcel, zzq zzq) {
        this(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.zzfwv);
    }
}
