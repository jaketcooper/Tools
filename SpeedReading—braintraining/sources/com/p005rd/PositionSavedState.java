package com.p005rd;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* renamed from: com.rd.PositionSavedState */
public class PositionSavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<PositionSavedState> CREATOR = new Parcelable.Creator<PositionSavedState>() {
        public PositionSavedState createFromParcel(Parcel in) {
            return new PositionSavedState(in);
        }

        public PositionSavedState[] newArray(int size) {
            return new PositionSavedState[size];
        }
    };
    private int lastSelectedPosition;
    private int selectedPosition;
    private int selectingPosition;

    protected PositionSavedState(Parcelable superState) {
        super(superState);
    }

    private PositionSavedState(Parcel in) {
        super(in);
        this.selectedPosition = in.readInt();
        this.selectingPosition = in.readInt();
        this.lastSelectedPosition = in.readInt();
    }

    public int getSelectedPosition() {
        return this.selectedPosition;
    }

    public void setSelectedPosition(int selectedPosition2) {
        this.selectedPosition = selectedPosition2;
    }

    public int getSelectingPosition() {
        return this.selectingPosition;
    }

    public void setSelectingPosition(int selectingPosition2) {
        this.selectingPosition = selectingPosition2;
    }

    public int getLastSelectedPosition() {
        return this.lastSelectedPosition;
    }

    public void setLastSelectedPosition(int lastSelectedPosition2) {
        this.lastSelectedPosition = lastSelectedPosition2;
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeInt(this.selectedPosition);
        out.writeInt(this.selectingPosition);
        out.writeInt(this.lastSelectedPosition);
    }
}
