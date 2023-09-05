package javax.vecmath;

import com.github.mikephil.charting.utils.Utils;
import java.io.Serializable;

public abstract class Tuple3d implements Serializable, Cloneable {
    static final long serialVersionUID = 5542096614926168415L;

    /* renamed from: x */
    public double f155x;

    /* renamed from: y */
    public double f156y;

    /* renamed from: z */
    public double f157z;

    public Tuple3d(double x, double y, double z) {
        this.f155x = x;
        this.f156y = y;
        this.f157z = z;
    }

    public Tuple3d(double[] t) {
        this.f155x = t[0];
        this.f156y = t[1];
        this.f157z = t[2];
    }

    public Tuple3d(Tuple3d t1) {
        this.f155x = t1.f155x;
        this.f156y = t1.f156y;
        this.f157z = t1.f157z;
    }

    public Tuple3d(Tuple3f t1) {
        this.f155x = (double) t1.f158x;
        this.f156y = (double) t1.f159y;
        this.f157z = (double) t1.f160z;
    }

    public Tuple3d() {
        this.f155x = Utils.DOUBLE_EPSILON;
        this.f156y = Utils.DOUBLE_EPSILON;
        this.f157z = Utils.DOUBLE_EPSILON;
    }

    public final void set(double x, double y, double z) {
        this.f155x = x;
        this.f156y = y;
        this.f157z = z;
    }

    public final void set(double[] t) {
        this.f155x = t[0];
        this.f156y = t[1];
        this.f157z = t[2];
    }

    public final void set(Tuple3d t1) {
        this.f155x = t1.f155x;
        this.f156y = t1.f156y;
        this.f157z = t1.f157z;
    }

    public final void set(Tuple3f t1) {
        this.f155x = (double) t1.f158x;
        this.f156y = (double) t1.f159y;
        this.f157z = (double) t1.f160z;
    }

    public final void get(double[] t) {
        t[0] = this.f155x;
        t[1] = this.f156y;
        t[2] = this.f157z;
    }

    public final void get(Tuple3d t) {
        t.f155x = this.f155x;
        t.f156y = this.f156y;
        t.f157z = this.f157z;
    }

    public final void add(Tuple3d t1, Tuple3d t2) {
        this.f155x = t1.f155x + t2.f155x;
        this.f156y = t1.f156y + t2.f156y;
        this.f157z = t1.f157z + t2.f157z;
    }

    public final void add(Tuple3d t1) {
        this.f155x += t1.f155x;
        this.f156y += t1.f156y;
        this.f157z += t1.f157z;
    }

    public final void sub(Tuple3d t1, Tuple3d t2) {
        this.f155x = t1.f155x - t2.f155x;
        this.f156y = t1.f156y - t2.f156y;
        this.f157z = t1.f157z - t2.f157z;
    }

    public final void sub(Tuple3d t1) {
        this.f155x -= t1.f155x;
        this.f156y -= t1.f156y;
        this.f157z -= t1.f157z;
    }

    public final void negate(Tuple3d t1) {
        this.f155x = -t1.f155x;
        this.f156y = -t1.f156y;
        this.f157z = -t1.f157z;
    }

    public final void negate() {
        this.f155x = -this.f155x;
        this.f156y = -this.f156y;
        this.f157z = -this.f157z;
    }

    public final void scale(double s, Tuple3d t1) {
        this.f155x = t1.f155x * s;
        this.f156y = t1.f156y * s;
        this.f157z = t1.f157z * s;
    }

    public final void scale(double s) {
        this.f155x *= s;
        this.f156y *= s;
        this.f157z *= s;
    }

    public final void scaleAdd(double s, Tuple3d t1, Tuple3d t2) {
        this.f155x = (t1.f155x * s) + t2.f155x;
        this.f156y = (t1.f156y * s) + t2.f156y;
        this.f157z = (t1.f157z * s) + t2.f157z;
    }

    public final void scaleAdd(double s, Tuple3f t1) {
        scaleAdd(s, (Tuple3d) new Point3d(t1));
    }

    public final void scaleAdd(double s, Tuple3d t1) {
        this.f155x = (this.f155x * s) + t1.f155x;
        this.f156y = (this.f156y * s) + t1.f156y;
        this.f157z = (this.f157z * s) + t1.f157z;
    }

    public String toString() {
        return "(" + this.f155x + ", " + this.f156y + ", " + this.f157z + ")";
    }

    public int hashCode() {
        long bits = (31 * ((31 * ((31 * 1) + VecMathUtil.doubleToLongBits(this.f155x))) + VecMathUtil.doubleToLongBits(this.f156y))) + VecMathUtil.doubleToLongBits(this.f157z);
        return (int) ((bits >> 32) ^ bits);
    }

    public boolean equals(Tuple3d t1) {
        try {
            return this.f155x == t1.f155x && this.f156y == t1.f156y && this.f157z == t1.f157z;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean equals(Object t1) {
        try {
            Tuple3d t2 = (Tuple3d) t1;
            if (this.f155x == t2.f155x && this.f156y == t2.f156y && this.f157z == t2.f157z) {
                return true;
            }
            return false;
        } catch (ClassCastException e) {
            return false;
        } catch (NullPointerException e2) {
            return false;
        }
    }

    public boolean epsilonEquals(Tuple3d t1, double epsilon) {
        double d;
        double d2;
        double diff = this.f155x - t1.f155x;
        if (Double.isNaN(diff)) {
            return false;
        }
        if ((diff < Utils.DOUBLE_EPSILON ? -diff : diff) > epsilon) {
            return false;
        }
        double diff2 = this.f156y - t1.f156y;
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
        double diff3 = this.f157z - t1.f157z;
        if (Double.isNaN(diff3)) {
            return false;
        }
        if (diff3 < Utils.DOUBLE_EPSILON) {
            d2 = -diff3;
        } else {
            d2 = diff3;
        }
        if (d2 <= epsilon) {
            return true;
        }
        return false;
    }

    public final void clamp(float min, float max, Tuple3d t) {
        clamp((double) min, (double) max, t);
    }

    public final void clamp(double min, double max, Tuple3d t) {
        if (t.f155x > max) {
            this.f155x = max;
        } else if (t.f155x < min) {
            this.f155x = min;
        } else {
            this.f155x = t.f155x;
        }
        if (t.f156y > max) {
            this.f156y = max;
        } else if (t.f156y < min) {
            this.f156y = min;
        } else {
            this.f156y = t.f156y;
        }
        if (t.f157z > max) {
            this.f157z = max;
        } else if (t.f157z < min) {
            this.f157z = min;
        } else {
            this.f157z = t.f157z;
        }
    }

    public final void clampMin(float min, Tuple3d t) {
        clampMin((double) min, t);
    }

    public final void clampMin(double min, Tuple3d t) {
        if (t.f155x < min) {
            this.f155x = min;
        } else {
            this.f155x = t.f155x;
        }
        if (t.f156y < min) {
            this.f156y = min;
        } else {
            this.f156y = t.f156y;
        }
        if (t.f157z < min) {
            this.f157z = min;
        } else {
            this.f157z = t.f157z;
        }
    }

    public final void clampMax(float max, Tuple3d t) {
        clampMax((double) max, t);
    }

    public final void clampMax(double max, Tuple3d t) {
        if (t.f155x > max) {
            this.f155x = max;
        } else {
            this.f155x = t.f155x;
        }
        if (t.f156y > max) {
            this.f156y = max;
        } else {
            this.f156y = t.f156y;
        }
        if (t.f157z > max) {
            this.f157z = max;
        } else {
            this.f157z = t.f157z;
        }
    }

    public final void absolute(Tuple3d t) {
        this.f155x = Math.abs(t.f155x);
        this.f156y = Math.abs(t.f156y);
        this.f157z = Math.abs(t.f157z);
    }

    public final void clamp(float min, float max) {
        clamp((double) min, (double) max);
    }

    public final void clamp(double min, double max) {
        if (this.f155x > max) {
            this.f155x = max;
        } else if (this.f155x < min) {
            this.f155x = min;
        }
        if (this.f156y > max) {
            this.f156y = max;
        } else if (this.f156y < min) {
            this.f156y = min;
        }
        if (this.f157z > max) {
            this.f157z = max;
        } else if (this.f157z < min) {
            this.f157z = min;
        }
    }

    public final void clampMin(float min) {
        clampMin((double) min);
    }

    public final void clampMin(double min) {
        if (this.f155x < min) {
            this.f155x = min;
        }
        if (this.f156y < min) {
            this.f156y = min;
        }
        if (this.f157z < min) {
            this.f157z = min;
        }
    }

    public final void clampMax(float max) {
        clampMax((double) max);
    }

    public final void clampMax(double max) {
        if (this.f155x > max) {
            this.f155x = max;
        }
        if (this.f156y > max) {
            this.f156y = max;
        }
        if (this.f157z > max) {
            this.f157z = max;
        }
    }

    public final void absolute() {
        this.f155x = Math.abs(this.f155x);
        this.f156y = Math.abs(this.f156y);
        this.f157z = Math.abs(this.f157z);
    }

    public final void interpolate(Tuple3d t1, Tuple3d t2, float alpha) {
        interpolate(t1, t2, (double) alpha);
    }

    public final void interpolate(Tuple3d t1, Tuple3d t2, double alpha) {
        this.f155x = ((1.0d - alpha) * t1.f155x) + (t2.f155x * alpha);
        this.f156y = ((1.0d - alpha) * t1.f156y) + (t2.f156y * alpha);
        this.f157z = ((1.0d - alpha) * t1.f157z) + (t2.f157z * alpha);
    }

    public final void interpolate(Tuple3d t1, float alpha) {
        interpolate(t1, (double) alpha);
    }

    public final void interpolate(Tuple3d t1, double alpha) {
        this.f155x = ((1.0d - alpha) * this.f155x) + (t1.f155x * alpha);
        this.f156y = ((1.0d - alpha) * this.f156y) + (t1.f156y * alpha);
        this.f157z = ((1.0d - alpha) * this.f157z) + (t1.f157z * alpha);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public final double getX() {
        return this.f155x;
    }

    public final void setX(double x) {
        this.f155x = x;
    }

    public final double getY() {
        return this.f156y;
    }

    public final void setY(double y) {
        this.f156y = y;
    }

    public final double getZ() {
        return this.f157z;
    }

    public final void setZ(double z) {
        this.f157z = z;
    }
}
