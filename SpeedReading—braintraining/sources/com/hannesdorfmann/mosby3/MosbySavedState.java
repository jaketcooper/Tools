package com.hannesdorfmann.mosby3;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.p000v4.p002os.ParcelableCompat;
import android.support.p000v4.p002os.ParcelableCompatCreatorCallbacks;
import android.support.p000v4.view.AbsSavedState;

public class MosbySavedState extends AbsSavedState {
    public static final Parcelable.Creator<MosbySavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<MosbySavedState>() {
        public MosbySavedState createFromParcel(Parcel in, ClassLoader loader) {
            if (loader == null) {
                loader = MosbySavedState.class.getClassLoader();
            }
            return new MosbySavedState(in, loader);
        }

        public MosbySavedState[] newArray(int size) {
            return new MosbySavedState[size];
        }
    });
    private String mosbyViewId;

    public MosbySavedState(Parcelable superState, String mosbyViewId2) {
        super(superState);
        this.mosbyViewId = mosbyViewId2;
    }

    protected MosbySavedState(Parcel in, ClassLoader loader) {
        super(in, loader);
        this.mosbyViewId = in.readString();
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeString(this.mosbyViewId);
    }

    public String getMosbyViewId() {
        return this.mosbyViewId;
    }
}
