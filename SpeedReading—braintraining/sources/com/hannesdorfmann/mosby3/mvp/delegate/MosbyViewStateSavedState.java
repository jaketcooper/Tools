package com.hannesdorfmann.mosby3.mvp.delegate;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.p002os.ParcelableCompat;
import android.support.p000v4.p002os.ParcelableCompatCreatorCallbacks;
import com.hannesdorfmann.mosby3.MosbySavedState;
import com.hannesdorfmann.mosby3.mvp.viewstate.RestorableParcelableViewState;

public class MosbyViewStateSavedState extends MosbySavedState {
    public static final Parcelable.Creator<MosbyViewStateSavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<MosbyViewStateSavedState>() {
        public MosbyViewStateSavedState createFromParcel(Parcel in, ClassLoader loader) {
            if (loader == null) {
                loader = RestorableParcelableViewState.class.getClassLoader();
            }
            return new MosbyViewStateSavedState(in, loader);
        }

        public MosbyViewStateSavedState[] newArray(int size) {
            return new MosbyViewStateSavedState[size];
        }
    });
    private RestorableParcelableViewState mosbyViewState;

    public MosbyViewStateSavedState(Parcelable superState, @NonNull String viewId, @Nullable RestorableParcelableViewState viewState) {
        super(superState, viewId);
        this.mosbyViewState = viewState;
    }

    protected MosbyViewStateSavedState(Parcel in, ClassLoader loader) {
        super(in, loader);
        this.mosbyViewState = (RestorableParcelableViewState) in.readParcelable(loader);
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeParcelable(this.mosbyViewState, flags);
    }

    @Nullable
    public RestorableParcelableViewState getRestoreableViewState() {
        return this.mosbyViewState;
    }
}
