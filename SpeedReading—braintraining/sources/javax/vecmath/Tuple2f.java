package javax.vecmath;

import java.io.Serializable;

public abstract class Tuple2f implements Serializable, Cloneable {
    static final long serialVersionUID = 9011180388985266884L;

    /* renamed from: x */
    public float f148x;

    /* renamed from: y */
    public float f149y;

    public Tuple2f(float x, float y) {
        this.f148x = x;
        this.f149y = y;
    }

    public Tuple2f(float[] t) {
        this.f148x = t[0];
        this.f149y = t[1];
    }

    public Tuple2f(Tuple2f t1) {
        this.f148x = t1.f148x;
        this.f149y = t1.f149y;
    }

    public Tuple2f(Tuple2d t1) {
        this.f148x = (float) t1.f146x;
        this.f149y = (float) t1.f147y;
    }

    public Tuple2f() {
        this.f148x = 0.0f;
        this.f149y = 0.0f;
    }

    public final void set(float x, float y) {
        this.f148x = x;
        this.f149y = y;
    }

    public final void set(float[] t) {
        this.f148x = t[0];
        this.f149y = t[1];
    }

    public final void set(Tuple2f t1) {
        this.f148x = t1.f148x;
        this.f149y = t1.f149y;
    }

    public final void set(Tuple2d t1) {
        this.f148x = (float) t1.f146x;
        this.f149y = (float) t1.f147y;
    }

    public final void get(float[] t) {
        t[0] = this.f148x;
        t[1] = this.f149y;
    }

    public final void add(Tuple2f t1, Tuple2f t2) {
        this.f148x = t1.f148x + t2.f148x;
        this.f149y = t1.f149y + t2.f149y;
    }

    public final void add(Tuple2f t1) {
        this.f148x += t1.f148x;
        this.f149y += t1.f149y;
    }

    public final void sub(Tuple2f t1, Tuple2f t2) {
        this.f148x = t1.f148x - t2.f148x;
        this.f149y = t1.f149y - t2.f149y;
    }

    public final void sub(Tuple2f t1) {
        this.f148x -= t1.f148x;
        this.f149y -= t1.f149y;
    }

    public final void negate(Tuple2f t1) {
        this.f148x = -t1.f148x;
        this.f149y = -t1.f149y;
    }

    public final void negate() {
        this.f148x = -this.f148x;
        this.f149y = -this.f149y;
    }

    public final void scale(float s, Tuple2f t1) {
        this.f148x = t1.f148x * s;
        this.f149y = t1.f149y * s;
    }

    public final void scale(float s) {
        this.f148x *= s;
        this.f149y *= s;
    }

    public final void scaleAdd(float s, Tuple2f t1, Tuple2f t2) {
        this.f148x = (t1.f148x * s) + t2.f148x;
        this.f149y = (t1.f149y * s) + t2.f149y;
    }

    public final void scaleAdd(float s, Tuple2f t1) {
        this.f148x = (this.f148x * s) + t1.f148x;
        this.f149y = (this.f149y * s) + t1.f149y;
    }

    public int hashCode() {
        long bits = (31 * ((31 * 1) + ((long) VecMathUtil.floatToIntBits(this.f148x)))) + ((long) VecMathUtil.floatToIntBits(this.f149y));
        return (int) ((bits >> 32) ^ bits);
    }

    public boolean equals(Tuple2f t1) {
        try {
            return this.f148x == t1.f148x && this.f149y == t1.f149y;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean equals(Object t1) {
        try {
            Tuple2f t2 = (Tuple2f) t1;
            if (this.f148x == t2.f148x && this.f149y == t2.f149y) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public boolean epsilonEquals(Tuple2f t1, float epsilon) {
        float f;
        float diff = this.f148x - t1.f148x;
        if (Float.isNaN(diff)) {
            return false;
        }
        if ((diff < 0.0f ? -diff : diff) > epsilon) {
            return false;
        }
        float diff2 = this.f149y - t1.f149y;
        if (Float.isNaN(diff2)) {
            return false;
        }
        if (diff2 < 0.0f) {
            f = -diff2;
        } else {
            f = diff2;
        }
        if (f <= epsilon) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "(" + this.f148x + ", " + this.f149y + ")";
    }

    public final void clamp(float min, float max, Tuple2f t) {
        if (t.f148x > max) {
            this.f148x = max;
        } else if (t.f148x < min) {
            this.f148x = min;
        } else {
            this.f148x = t.f148x;
        }
        if (t.f149y > max) {
            this.f149y = max;
        } else if (t.f149y < min) {
            this.f149y = min;
        } else {
            this.f149y = t.f149y;
        }
    }

    public final void clampMin(float min, Tuple2f t) {
        if (t.f148x < min) {
            this.f148x = min;
        } else {
            this.f148x = t.f148x;
        }
        if (t.f149y < min) {
            this.f149y = min;
        } else {
            this.f149y = t.f149y;
        }
    }

    public final void clampMax(float max, Tuple2f t) {
        if (t.f148x > max) {
            this.f148x = max;
        } else {
            this.f148x = t.f148x;
        }
        if (t.f149y > max) {
            this.f149y = max;
        } else {
            this.f149y = t.f149y;
        }
    }

    public final void absolute(Tuple2f t) {
        this.f148x = Math.abs(t.f148x);
        this.f149y = Math.abs(t.f149y);
    }

    public final void clamp(float min, float max) {
        if (this.f148x > max) {
            this.f148x = max;
        } else if (this.f148x < min) {
            this.f148x = min;
        }
        if (this.f149y > max) {
            this.f149y = max;
        } else if (this.f149y < min) {
            this.f149y = min;
        }
    }

    public final void clampMin(float min) {
        if (this.f148x < min) {
            this.f148x = min;
        }
        if (this.f149y < min) {
            this.f149y = min;
        }
    }

    public final void clampMax(float max) {
        if (this.f148x > max) {
            this.f148x = max;
        }
        if (this.f149y > max) {
            this.f149y = max;
        }
    }

    public final void absolute() {
        this.f148x = Math.abs(this.f148x);
        this.f149y = Math.abs(this.f149y);
    }

    public final void interpolate(Tuple2f t1, Tuple2f t2, float alpha) {
        this.f148x = ((1.0f - alpha) * t1.f148x) + (t2.f148x * alpha);
        this.f149y = ((1.0f - alpha) * t1.f149y) + (t2.f149y * alpha);
    }

    public final void interpolate(Tuple2f t1, float alpha) {
        this.f148x = ((1.0f - alpha) * this.f148x) + (t1.f148x * alpha);
        this.f149y = ((1.0f - alpha) * this.f149y) + (t1.f149y * alpha);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public final float getX() {
        return this.f148x;
    }

    public final void setX(float x) {
        this.f148x = x;
    }

    public final float getY() {
        return this.f149y;
    }

    public final void setY(float y) {
        this.f149y = y;
    }
}
