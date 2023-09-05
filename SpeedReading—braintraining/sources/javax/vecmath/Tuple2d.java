package javax.vecmath;

import com.github.mikephil.charting.utils.Utils;
import java.io.Serializable;

public abstract class Tuple2d implements Serializable, Cloneable {
    static final long serialVersionUID = 6205762482756093838L;

    /* renamed from: x */
    public double f146x;

    /* renamed from: y */
    public double f147y;

    public Tuple2d(double x, double y) {
        this.f146x = x;
        this.f147y = y;
    }

    public Tuple2d(double[] t) {
        this.f146x = t[0];
        this.f147y = t[1];
    }

    public Tuple2d(Tuple2d t1) {
        this.f146x = t1.f146x;
        this.f147y = t1.f147y;
    }

    public Tuple2d(Tuple2f t1) {
        this.f146x = (double) t1.f148x;
        this.f147y = (double) t1.f149y;
    }

    public Tuple2d() {
        this.f146x = Utils.DOUBLE_EPSILON;
        this.f147y = Utils.DOUBLE_EPSILON;
    }

    public final void set(double x, double y) {
        this.f146x = x;
        this.f147y = y;
    }

    public final void set(double[] t) {
        this.f146x = t[0];
        this.f147y = t[1];
    }

    public final void set(Tuple2d t1) {
        this.f146x = t1.f146x;
        this.f147y = t1.f147y;
    }

    public final void set(Tuple2f t1) {
        this.f146x = (double) t1.f148x;
        this.f147y = (double) t1.f149y;
    }

    public final void get(double[] t) {
        t[0] = this.f146x;
        t[1] = this.f147y;
    }

    public final void add(Tuple2d t1, Tuple2d t2) {
        this.f146x = t1.f146x + t2.f146x;
        this.f147y = t1.f147y + t2.f147y;
    }

    public final void add(Tuple2d t1) {
        this.f146x += t1.f146x;
        this.f147y += t1.f147y;
    }

    public final void sub(Tuple2d t1, Tuple2d t2) {
        this.f146x = t1.f146x - t2.f146x;
        this.f147y = t1.f147y - t2.f147y;
    }

    public final void sub(Tuple2d t1) {
        this.f146x -= t1.f146x;
        this.f147y -= t1.f147y;
    }

    public final void negate(Tuple2d t1) {
        this.f146x = -t1.f146x;
        this.f147y = -t1.f147y;
    }

    public final void negate() {
        this.f146x = -this.f146x;
        this.f147y = -this.f147y;
    }

    public final void scale(double s, Tuple2d t1) {
        this.f146x = t1.f146x * s;
        this.f147y = t1.f147y * s;
    }

    public final void scale(double s) {
        this.f146x *= s;
        this.f147y *= s;
    }

    public final void scaleAdd(double s, Tuple2d t1, Tuple2d t2) {
        this.f146x = (t1.f146x * s) + t2.f146x;
        this.f147y = (t1.f147y * s) + t2.f147y;
    }

    public final void scaleAdd(double s, Tuple2d t1) {
        this.f146x = (this.f146x * s) + t1.f146x;
        this.f147y = (this.f147y * s) + t1.f147y;
    }

    public int hashCode() {
        long bits = (31 * ((31 * 1) + VecMathUtil.doubleToLongBits(this.f146x))) + VecMathUtil.doubleToLongBits(this.f147y);
        return (int) ((bits >> 32) ^ bits);
    }

    public boolean equals(Tuple2d t1) {
        try {
            return this.f146x == t1.f146x && this.f147y == t1.f147y;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean equals(Object t1) {
        try {
            Tuple2d t2 = (Tuple2d) t1;
            if (this.f146x == t2.f146x && this.f147y == t2.f147y) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public boolean epsilonEquals(Tuple2d t1, double epsilon) {
        double d;
        double diff = this.f146x - t1.f146x;
        if (Double.isNaN(diff)) {
            return false;
        }
        if ((diff < Utils.DOUBLE_EPSILON ? -diff : diff) > epsilon) {
            return false;
        }
        double diff2 = this.f147y - t1.f147y;
        if (Double.isNaN(diff2)) {
            return false;
        }
        if (diff2 < Utils.DOUBLE_EPSILON) {
            d = -diff2;
        } else {
            d = diff2;
        }
        if (d <= epsilon) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "(" + this.f146x + ", " + this.f147y + ")";
    }

    public final void clamp(double min, double max, Tuple2d t) {
        if (t.f146x > max) {
            this.f146x = max;
        } else if (t.f146x < min) {
            this.f146x = min;
        } else {
            this.f146x = t.f146x;
        }
        if (t.f147y > max) {
            this.f147y = max;
        } else if (t.f147y < min) {
            this.f147y = min;
        } else {
            this.f147y = t.f147y;
        }
    }

    public final void clampMin(double min, Tuple2d t) {
        if (t.f146x < min) {
            this.f146x = min;
        } else {
            this.f146x = t.f146x;
        }
        if (t.f147y < min) {
            this.f147y = min;
        } else {
            this.f147y = t.f147y;
        }
    }

    public final void clampMax(double max, Tuple2d t) {
        if (t.f146x > max) {
            this.f146x = max;
        } else {
            this.f146x = t.f146x;
        }
        if (t.f147y > max) {
            this.f147y = max;
        } else {
            this.f147y = t.f147y;
        }
    }

    public final void absolute(Tuple2d t) {
        this.f146x = Math.abs(t.f146x);
        this.f147y = Math.abs(t.f147y);
    }

    public final void clamp(double min, double max) {
        if (this.f146x > max) {
            this.f146x = max;
        } else if (this.f146x < min) {
            this.f146x = min;
        }
        if (this.f147y > max) {
            this.f147y = max;
        } else if (this.f147y < min) {
            this.f147y = min;
        }
    }

    public final void clampMin(double min) {
        if (this.f146x < min) {
            this.f146x = min;
        }
        if (this.f147y < min) {
            this.f147y = min;
        }
    }

    public final void clampMax(double max) {
        if (this.f146x > max) {
            this.f146x = max;
        }
        if (this.f147y > max) {
            this.f147y = max;
        }
    }

    public final void absolute() {
        this.f146x = Math.abs(this.f146x);
        this.f147y = Math.abs(this.f147y);
    }

    public final void interpolate(Tuple2d t1, Tuple2d t2, double alpha) {
        this.f146x = ((1.0d - alpha) * t1.f146x) + (t2.f146x * alpha);
        this.f147y = ((1.0d - alpha) * t1.f147y) + (t2.f147y * alpha);
    }

    public final void interpolate(Tuple2d t1, double alpha) {
        this.f146x = ((1.0d - alpha) * this.f146x) + (t1.f146x * alpha);
        this.f147y = ((1.0d - alpha) * this.f147y) + (t1.f147y * alpha);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public final double getX() {
        return this.f146x;
    }

    public final void setX(double x) {
        this.f146x = x;
    }

    public final double getY() {
        return this.f147y;
    }

    public final void setY(double y) {
        this.f147y = y;
    }
}
