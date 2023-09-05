package javax.vecmath;

import com.github.mikephil.charting.utils.Utils;
import java.io.Serializable;

public abstract class Tuple4d implements Serializable, Cloneable {
    static final long serialVersionUID = -4748953690425311052L;

    /* renamed from: w */
    public double f168w;

    /* renamed from: x */
    public double f169x;

    /* renamed from: y */
    public double f170y;

    /* renamed from: z */
    public double f171z;

    public Tuple4d(double x, double y, double z, double w) {
        this.f169x = x;
        this.f170y = y;
        this.f171z = z;
        this.f168w = w;
    }

    public Tuple4d(double[] t) {
        this.f169x = t[0];
        this.f170y = t[1];
        this.f171z = t[2];
        this.f168w = t[3];
    }

    public Tuple4d(Tuple4d t1) {
        this.f169x = t1.f169x;
        this.f170y = t1.f170y;
        this.f171z = t1.f171z;
        this.f168w = t1.f168w;
    }

    public Tuple4d(Tuple4f t1) {
        this.f169x = (double) t1.f173x;
        this.f170y = (double) t1.f174y;
        this.f171z = (double) t1.f175z;
        this.f168w = (double) t1.f172w;
    }

    public Tuple4d() {
        this.f169x = Utils.DOUBLE_EPSILON;
        this.f170y = Utils.DOUBLE_EPSILON;
        this.f171z = Utils.DOUBLE_EPSILON;
        this.f168w = Utils.DOUBLE_EPSILON;
    }

    public final void set(double x, double y, double z, double w) {
        this.f169x = x;
        this.f170y = y;
        this.f171z = z;
        this.f168w = w;
    }

    public final void set(double[] t) {
        this.f169x = t[0];
        this.f170y = t[1];
        this.f171z = t[2];
        this.f168w = t[3];
    }

    public final void set(Tuple4d t1) {
        this.f169x = t1.f169x;
        this.f170y = t1.f170y;
        this.f171z = t1.f171z;
        this.f168w = t1.f168w;
    }

    public final void set(Tuple4f t1) {
        this.f169x = (double) t1.f173x;
        this.f170y = (double) t1.f174y;
        this.f171z = (double) t1.f175z;
        this.f168w = (double) t1.f172w;
    }

    public final void get(double[] t) {
        t[0] = this.f169x;
        t[1] = this.f170y;
        t[2] = this.f171z;
        t[3] = this.f168w;
    }

    public final void get(Tuple4d t) {
        t.f169x = this.f169x;
        t.f170y = this.f170y;
        t.f171z = this.f171z;
        t.f168w = this.f168w;
    }

    public final void add(Tuple4d t1, Tuple4d t2) {
        this.f169x = t1.f169x + t2.f169x;
        this.f170y = t1.f170y + t2.f170y;
        this.f171z = t1.f171z + t2.f171z;
        this.f168w = t1.f168w + t2.f168w;
    }

    public final void add(Tuple4d t1) {
        this.f169x += t1.f169x;
        this.f170y += t1.f170y;
        this.f171z += t1.f171z;
        this.f168w += t1.f168w;
    }

    public final void sub(Tuple4d t1, Tuple4d t2) {
        this.f169x = t1.f169x - t2.f169x;
        this.f170y = t1.f170y - t2.f170y;
        this.f171z = t1.f171z - t2.f171z;
        this.f168w = t1.f168w - t2.f168w;
    }

    public final void sub(Tuple4d t1) {
        this.f169x -= t1.f169x;
        this.f170y -= t1.f170y;
        this.f171z -= t1.f171z;
        this.f168w -= t1.f168w;
    }

    public final void negate(Tuple4d t1) {
        this.f169x = -t1.f169x;
        this.f170y = -t1.f170y;
        this.f171z = -t1.f171z;
        this.f168w = -t1.f168w;
    }

    public final void negate() {
        this.f169x = -this.f169x;
        this.f170y = -this.f170y;
        this.f171z = -this.f171z;
        this.f168w = -this.f168w;
    }

    public final void scale(double s, Tuple4d t1) {
        this.f169x = t1.f169x * s;
        this.f170y = t1.f170y * s;
        this.f171z = t1.f171z * s;
        this.f168w = t1.f168w * s;
    }

    public final void scale(double s) {
        this.f169x *= s;
        this.f170y *= s;
        this.f171z *= s;
        this.f168w *= s;
    }

    public final void scaleAdd(double s, Tuple4d t1, Tuple4d t2) {
        this.f169x = (t1.f169x * s) + t2.f169x;
        this.f170y = (t1.f170y * s) + t2.f170y;
        this.f171z = (t1.f171z * s) + t2.f171z;
        this.f168w = (t1.f168w * s) + t2.f168w;
    }

    public final void scaleAdd(float s, Tuple4d t1) {
        scaleAdd((double) s, t1);
    }

    public final void scaleAdd(double s, Tuple4d t1) {
        this.f169x = (this.f169x * s) + t1.f169x;
        this.f170y = (this.f170y * s) + t1.f170y;
        this.f171z = (this.f171z * s) + t1.f171z;
        this.f168w = (this.f168w * s) + t1.f168w;
    }

    public String toString() {
        return "(" + this.f169x + ", " + this.f170y + ", " + this.f171z + ", " + this.f168w + ")";
    }

    public boolean equals(Tuple4d t1) {
        try {
            return this.f169x == t1.f169x && this.f170y == t1.f170y && this.f171z == t1.f171z && this.f168w == t1.f168w;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean equals(Object t1) {
        try {
            Tuple4d t2 = (Tuple4d) t1;
            if (this.f169x == t2.f169x && this.f170y == t2.f170y && this.f171z == t2.f171z && this.f168w == t2.f168w) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public boolean epsilonEquals(Tuple4d t1, double epsilon) {
        double d;
        double d2;
        double d3;
        double diff = this.f169x - t1.f169x;
        if (Double.isNaN(diff)) {
            return false;
        }
        if ((diff < Utils.DOUBLE_EPSILON ? -diff : diff) > epsilon) {
            return false;
        }
        double diff2 = this.f170y - t1.f170y;
        if (Double.isNaN(diff2)) {
            return false;
        }
        if (diff2 < Utils.DOUBLE_EPSILON) {
            d = -diff2;
        } else {
            d = diff2;
        }
        if (d > epsilon) {
            return false;
        }
        double diff3 = this.f171z - t1.f171z;
        if (Double.isNaN(diff3)) {
            return false;
        }
        if (diff3 < Utils.DOUBLE_EPSILON) {
            d2 = -diff3;
        } else {
            d2 = diff3;
        }
        if (d2 > epsilon) {
            return false;
        }
        double diff4 = this.f168w - t1.f168w;
        if (Double.isNaN(diff4)) {
            return false;
        }
        if (diff4 < Utils.DOUBLE_EPSILON) {
            d3 = -diff4;
        } else {
            d3 = diff4;
        }
        if (d3 <= epsilon) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long bits = (31 * ((31 * ((31 * ((31 * 1) + VecMathUtil.doubleToLongBits(this.f169x))) + VecMathUtil.doubleToLongBits(this.f170y))) + VecMathUtil.doubleToLongBits(this.f171z))) + VecMathUtil.doubleToLongBits(this.f168w);
        return (int) ((bits >> 32) ^ bits);
    }

    public final void clamp(float min, float max, Tuple4d t) {
        clamp((double) min, (double) max, t);
    }

    public final void clamp(double min, double max, Tuple4d t) {
        if (t.f169x > max) {
            this.f169x = max;
        } else if (t.f169x < min) {
            this.f169x = min;
        } else {
            this.f169x = t.f169x;
        }
        if (t.f170y > max) {
            this.f170y = max;
        } else if (t.f170y < min) {
            this.f170y = min;
        } else {
            this.f170y = t.f170y;
        }
        if (t.f171z > max) {
            this.f171z = max;
        } else if (t.f171z < min) {
            this.f171z = min;
        } else {
            this.f171z = t.f171z;
        }
        if (t.f168w > max) {
            this.f168w = max;
        } else if (t.f168w < min) {
            this.f168w = min;
        } else {
            this.f168w = t.f168w;
        }
    }

    public final void clampMin(float min, Tuple4d t) {
        clampMin((double) min, t);
    }

    public final void clampMin(double min, Tuple4d t) {
        if (t.f169x < min) {
            this.f169x = min;
        } else {
            this.f169x = t.f169x;
        }
        if (t.f170y < min) {
            this.f170y = min;
        } else {
            this.f170y = t.f170y;
        }
        if (t.f171z < min) {
            this.f171z = min;
        } else {
            this.f171z = t.f171z;
        }
        if (t.f168w < min) {
            this.f168w = min;
        } else {
            this.f168w = t.f168w;
        }
    }

    public final void clampMax(float max, Tuple4d t) {
        clampMax((double) max, t);
    }

    public final void clampMax(double max, Tuple4d t) {
        if (t.f169x > max) {
            this.f169x = max;
        } else {
            this.f169x = t.f169x;
        }
        if (t.f170y > max) {
            this.f170y = max;
        } else {
            this.f170y = t.f170y;
        }
        if (t.f171z > max) {
            this.f171z = max;
        } else {
            this.f171z = t.f171z;
        }
        if (t.f168w > max) {
            this.f168w = max;
        } else {
            this.f168w = t.f171z;
        }
    }

    public final void absolute(Tuple4d t) {
        this.f169x = Math.abs(t.f169x);
        this.f170y = Math.abs(t.f170y);
        this.f171z = Math.abs(t.f171z);
        this.f168w = Math.abs(t.f168w);
    }

    public final void clamp(float min, float max) {
        clamp((double) min, (double) max);
    }

    public final void clamp(double min, double max) {
        if (this.f169x > max) {
            this.f169x = max;
        } else if (this.f169x < min) {
            this.f169x = min;
        }
        if (this.f170y > max) {
            this.f170y = max;
        } else if (this.f170y < min) {
            this.f170y = min;
        }
        if (this.f171z > max) {
            this.f171z = max;
        } else if (this.f171z < min) {
            this.f171z = min;
        }
        if (this.f168w > max) {
            this.f168w = max;
        } else if (this.f168w < min) {
            this.f168w = min;
        }
    }

    public final void clampMin(float min) {
        clampMin((double) min);
    }

    public final void clampMin(double min) {
        if (this.f169x < min) {
            this.f169x = min;
        }
        if (this.f170y < min) {
            this.f170y = min;
        }
        if (this.f171z < min) {
            this.f171z = min;
        }
        if (this.f168w < min) {
            this.f168w = min;
        }
    }

    public final void clampMax(float max) {
        clampMax((double) max);
    }

    public final void clampMax(double max) {
        if (this.f169x > max) {
            this.f169x = max;
        }
        if (this.f170y > max) {
            this.f170y = max;
        }
        if (this.f171z > max) {
            this.f171z = max;
        }
        if (this.f168w > max) {
            this.f168w = max;
        }
    }

    public final void absolute() {
        this.f169x = Math.abs(this.f169x);
        this.f170y = Math.abs(this.f170y);
        this.f171z = Math.abs(this.f171z);
        this.f168w = Math.abs(this.f168w);
    }

    public void interpolate(Tuple4d t1, Tuple4d t2, float alpha) {
        interpolate(t1, t2, (double) alpha);
    }

    public void interpolate(Tuple4d t1, Tuple4d t2, double alpha) {
        this.f169x = ((1.0d - alpha) * t1.f169x) + (t2.f169x * alpha);
        this.f170y = ((1.0d - alpha) * t1.f170y) + (t2.f170y * alpha);
        this.f171z = ((1.0d - alpha) * t1.f171z) + (t2.f171z * alpha);
        this.f168w = ((1.0d - alpha) * t1.f168w) + (t2.f168w * alpha);
    }

    public void interpolate(Tuple4d t1, float alpha) {
        interpolate(t1, (double) alpha);
    }

    public void interpolate(Tuple4d t1, double alpha) {
        this.f169x = ((1.0d - alpha) * this.f169x) + (t1.f169x * alpha);
        this.f170y = ((1.0d - alpha) * this.f170y) + (t1.f170y * alpha);
        this.f171z = ((1.0d - alpha) * this.f171z) + (t1.f171z * alpha);
        this.f168w = ((1.0d - alpha) * this.f168w) + (t1.f168w * alpha);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public final double getX() {
        return this.f169x;
    }

    public final void setX(double x) {
        this.f169x = x;
    }

    public final double getY() {
        return this.f170y;
    }

    public final void setY(double y) {
        this.f170y = y;
    }

    public final double getZ() {
        return this.f171z;
    }

    public final void setZ(double z) {
        this.f171z = z;
    }

    public final double getW() {
        return this.f168w;
    }

    public final void setW(double w) {
        this.f168w = w;
    }
}
