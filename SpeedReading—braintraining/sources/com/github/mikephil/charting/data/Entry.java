package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import com.github.mikephil.charting.utils.Utils;

public class Entry extends BaseEntry implements Parcelable {
    public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator<Entry>() {
        public Entry createFromParcel(Parcel source) {
            return new Entry(source);
        }

        public Entry[] newArray(int size) {
            return new Entry[size];
        }
    };

    /* renamed from: x */
    private float f58x = 0.0f;

    public Entry() {
    }

    public Entry(float x, float y) {
        super(y);
        this.f58x = x;
    }

    public Entry(float x, float y, Object data) {
        super(y, data);
        this.f58x = x;
    }

    public Entry(float x, float y, Drawable icon) {
        super(y, icon);
        this.f58x = x;
    }

    public Entry(float x, float y, Drawable icon, Object data) {
        super(y, icon, data);
        this.f58x = x;
    }

    public float getX() {
        return this.f58x;
    }

    public void setX(float x) {
        this.f58x = x;
    }

    public Entry copy() {
        return new Entry(this.f58x, getY(), getData());
    }

    public boolean equalTo(Entry e) {
        if (e != null && e.getData() == getData() && Math.abs(e.f58x - this.f58x) <= Utils.FLOAT_EPSILON && Math.abs(e.getY() - getY()) <= Utils.FLOAT_EPSILON) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Entry, x: " + this.f58x + " y: " + getY();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(this.f58x);
        dest.writeFloat(getY());
        if (getData() == null) {
            dest.writeInt(0);
        } else if (getData() instanceof Parcelable) {
            dest.writeInt(1);
            dest.writeParcelable((Parcelable) getData(), flags);
        } else {
            throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
        }
    }

    protected Entry(Parcel in) {
        this.f58x = in.readFloat();
        setY(in.readFloat());
        if (in.readInt() == 1) {
            setData(in.readParcelable(Object.class.getClassLoader()));
        }
    }
}
