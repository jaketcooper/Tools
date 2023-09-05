package javax.vecmath;

import java.io.Serializable;

public abstract class Tuple3f implements Serializable, Cloneable {
    static final long serialVersionUID = 5019834619484343712L;

    /* renamed from: x */
    public float f158x;

    /* renamed from: y */
    public float f159y;

    /* renamed from: z */
    public float f160z;

    public Tuple3f(float x, float y, float z) {
        this.f158x = x;
        this.f159y = y;
        this.f160z = z;
    }

    public Tuple3f(float[] t) {
        this.f158x = t[0];
        this.f159y = t[1];
        this.f160z = t[2];
    }

    public Tuple3f(Tuple3f t1) {
        this.f158x = t1.f158x;
        this.f159y = t1.f159y;
        this.f160z = t1.f160z;
    }

    public Tuple3f(Tuple3d t1) {
        this.f158x = (float) t1.f155x;
        this.f159y = (float) t1.f156y;
        this.f160z = (float) t1.f157z;
    }

    public Tuple3f() {
        this.f158x = 0.0f;
        this.f159y = 0.0f;
        this.f160z = 0.0f;
    }

    public String toString() {
        return "(" + this.f158x + ", " + this.f159y + ", " + this.f160z + ")";
    }

    public final void set(float x, float y, float z) {
        this.f158x = x;
        this.f159y = y;
        this.f160z = z;
    }

    public final void set(float[] t) {
        this.f158x = t[0];
        this.f159y = t[1];
        this.f160z = t[2];
    }

    public final void set(Tuple3f t1) {
        this.f158x = t1.f158x;
        this.f159y = t1.f159y;
        this.f160z = t1.f160z;
    }

    public final void set(Tuple3d t1) {
        this.f158x = (float) t1.f155x;
        this.f159y = (float) t1.f156y;
        this.f160z = (float) t1.f157z;
    }

    public final void get(float[] t) {
        t[0] = this.f158x;
        t[1] = this.f159y;
        t[2] = this.f160z;
    }

    public final void get(Tuple3f t) {
        t.f158x = this.f158x;
        t.f159y = this.f159y;
        t.f160z = this.f160z;
    }

    public final void add(Tuple3f t1, Tuple3f t2) {
        this.f158x = t1.f158x + t2.f158x;
        this.f159y = t1.f159y + t2.f159y;
        this.f160z = t1.f160z + t2.f160z;
    }

    public final void add(Tuple3f t1) {
        this.f158x += t1.f158x;
        this.f159y += t1.f159y;
        this.f160z += t1.f160z;
    }

    public final void sub(Tuple3f t1, Tuple3f t2) {
        this.f158x = t1.f158x - t2.f158x;
        this.f159y = t1.f159y - t2.f159y;
        this.f160z = t1.f160z - t2.f160z;
    }

    public final void sub(Tuple3f t1) {
        this.f158x -= t1.f158x;
        this.f159y -= t1.f159y;
        this.f160z -= t1.f160z;
    }

    public final void negate(Tuple3f t1) {
        this.f158x = -t1.f158x;
        this.f159y = -t1.f159y;
        this.f160z = -t1.f160z;
    }

    public final void negate() {
        this.f158x = -this.f158x;
        this.f159y = -this.f159y;
        this.f160z = -this.f160z;
    }

    public final void scale(float s, Tuple3f t1) {
        this.f158x = t1.f158x * s;
        this.f159y = t1.f159y * s;
        this.f160z = t1.f160z * s;
    }

    public final void scale(float s) {
        this.f158x *= s;
        this.f159y *= s;
        this.f160z *= s;
    }

    public final void scaleAdd(float s, Tuple3f t1, Tuple3f t2) {
        this.f158x = (t1.f158x * s) + t2.f158x;
        this.f159y = (t1.f159y * s) + t2.f159y;
        this.f160z = (t1.f160z * s) + t2.f160z;
    }

    public final void scaleAdd(float s, Tuple3f t1) {
        this.f158x = (this.f158x * s) + t1.f158x;
        this.f159y = (this.f159y * s) + t1.f159y;
        this.f160z = (this.f160z * s) + t1.f160z;
    }

    public boolean equals(Tuple3f t1) {
        try {
            return this.f158x == t1.f158x && this.f159y == t1.f159y && this.f160z == t1.f160z;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean equals(Object t1) {
        try {
            Tuple3f t2 = (Tuple3f) t1;
            if (this.f158x == t2.f158x && this.f159y == t2.f159y && this.f160z == t2.f160z) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public boolean epsilonEquals(Tuple3f t1, float epsilon) {
        float f;
        float f2;
        float diff = this.f158x - t1.f158x;
        if (Float.isNaN(diff)) {
            return false;
        }
        if ((diff < 0.0f ? -diff : diff) > epsilon) {
            return false;
        }
        float diff2 = this.f159y - t1.f159y;
        if (Float.isNaN(diff2)) {
            return false;
        }
        if (diff2 < 0.0f) {
            f = -diff2;
        } else {
            f = diff2;
        }
        if (f > epsilon) {
            return false;
        }
        float diff3 = this.f160z - t1.f160z;
        if (Float.isNaN(diff3)) {
            return false;
        }
        if (diff3 < 0.0f) {
            f2 = -diff3;
        } else {
            f2 = diff3;
        }
        if (f2 <= epsilon) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long bits = (31 * ((31 * ((31 * 1) + ((long) VecMathUtil.floatToIntBits(this.f158x)))) + ((long) VecMathUtil.floatToIntBits(this.f159y)))) + ((long) VecMathUtil.floatToIntBits(this.f160z));
        return (int) ((bits >> 32) ^ bits);
    }

    public final void clamp(float min, float max, Tuple3f t) {
        if (t.f158x > max) {
            this.f158x = max;
        } else if (t.f158x < min) {
            this.f158x = min;
        } else {
            this.f158x = t.f158x;
        }
        if (t.f159y > max) {
            this.f159y = max;
        } else if (t.f159y < min) {
            this.f159y = min;
        } else {
            this.f159y = t.f159y;
        }
        if (t.f160z > max) {
            this.f160z = max;
        } else if (t.f160z < min) {
            this.f160z = min;
        } else {
            this.f160z = t.f160z;
        }
    }

    public final void clampMin(float min, Tuple3f t) {
        if (t.f158x < min) {
            this.f158x = min;
        } else {
            this.f158x = t.f158x;
        }
        if (t.f159y < min) {
            this.f159y = min;
        } else {
            this.f159y = t.f159y;
        }
        if (t.f160z < min) {
            this.f160z = min;
        } else {
            this.f160z = t.f160z;
        }
    }

    public final void clampMax(float max, Tuple3f t) {
        if (t.f158x > max) {
            this.f158x = max;
        } else {
            this.f158x = t.f158x;
        }
        if (t.f159y > max) {
            this.f159y = max;
        } else {
            this.f159y = t.f159y;
        }
        if (t.f160z > max) {
            this.f160z = max;
        } else {
            this.f160z = t.f160z;
        }
    }

    public final void absolute(Tuple3f t) {
        this.f158x = Math.abs(t.f158x);
        this.f159y = Math.abs(t.f159y);
        this.f160z = Math.abs(t.f160z);
    }

    public final void clamp(float min, float max) {
        if (this.f158x > max) {
            this.f158x = max;
        } else if (this.f158x < min) {
            this.f158x = min;
        }
        if (this.f159y > max) {
            this.f159y = max;
        } else if (this.f159y < min) {
            this.f159y = min;
        }
        if (this.f160z > max) {
            this.f160z = max;
        } else if (this.f160z < min) {
            this.f160z = min;
        }
    }

    public final void clampMin(float min) {
        if (this.f158x < min) {
            this.f158x = min;
        }
        if (this.f159y < min) {
            this.f159y = min;
        }
        if (this.f160z < min) {
            this.f160z = min;
        }
    }

    public final void clampMax(float max) {
        if (this.f158x > max) {
            this.f158x = max;
        }
        if (this.f159y > max) {
            this.f159y = max;
        }
        if (this.f160z > max) {
            this.f160z = max;
        }
    }

    public final void absolute() {
        this.f158x = Math.abs(this.f158x);
        this.f159y = Math.abs(this.f159y);
        this.f160z = Math.abs(this.f160z);
    }

    public final void interpolate(Tuple3f t1, Tuple3f t2, float alpha) {
        this.f158x = ((1.0f - alpha) * t1.f158x) + (t2.f158x * alpha);
        this.f159y = ((1.0f - alpha) * t1.f159y) + (t2.f159y * alpha);
        this.f160z = ((1.0f - alpha) * t1.f160z) + (t2.f160z * alpha);
    }

    public final void interpolate(Tuple3f t1, float alpha) {
        this.f158x = ((1.0f - alpha) * this.f158x) + (t1.f158x * alpha);
        this.f159y = ((1.0f - alpha) * this.f159y) + (t1.f159y * alpha);
        this.f160z = ((1.0f - alpha) * this.f160z) + (t1.f160z * alpha);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public final float getX() {
        return this.f158x;
    }

    public final void setX(float x) {
        this.f158x = x;
    }

    public final float getY() {
        return this.f159y;
    }

    public final void setY(float y) {
        this.f159y = y;
    }

    public final float getZ() {
        return this.f160z;
    }

    public final void setZ(float z) {
        this.f160z = z;
    }
}
