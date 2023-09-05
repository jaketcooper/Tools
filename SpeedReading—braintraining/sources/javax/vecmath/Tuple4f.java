package javax.vecmath;

import java.io.Serializable;

public abstract class Tuple4f implements Serializable, Cloneable {
    static final long serialVersionUID = 7068460319248845763L;

    /* renamed from: w */
    public float f172w;

    /* renamed from: x */
    public float f173x;

    /* renamed from: y */
    public float f174y;

    /* renamed from: z */
    public float f175z;

    public Tuple4f(float x, float y, float z, float w) {
        this.f173x = x;
        this.f174y = y;
        this.f175z = z;
        this.f172w = w;
    }

    public Tuple4f(float[] t) {
        this.f173x = t[0];
        this.f174y = t[1];
        this.f175z = t[2];
        this.f172w = t[3];
    }

    public Tuple4f(Tuple4f t1) {
        this.f173x = t1.f173x;
        this.f174y = t1.f174y;
        this.f175z = t1.f175z;
        this.f172w = t1.f172w;
    }

    public Tuple4f(Tuple4d t1) {
        this.f173x = (float) t1.f169x;
        this.f174y = (float) t1.f170y;
        this.f175z = (float) t1.f171z;
        this.f172w = (float) t1.f168w;
    }

    public Tuple4f() {
        this.f173x = 0.0f;
        this.f174y = 0.0f;
        this.f175z = 0.0f;
        this.f172w = 0.0f;
    }

    public final void set(float x, float y, float z, float w) {
        this.f173x = x;
        this.f174y = y;
        this.f175z = z;
        this.f172w = w;
    }

    public final void set(float[] t) {
        this.f173x = t[0];
        this.f174y = t[1];
        this.f175z = t[2];
        this.f172w = t[3];
    }

    public final void set(Tuple4f t1) {
        this.f173x = t1.f173x;
        this.f174y = t1.f174y;
        this.f175z = t1.f175z;
        this.f172w = t1.f172w;
    }

    public final void set(Tuple4d t1) {
        this.f173x = (float) t1.f169x;
        this.f174y = (float) t1.f170y;
        this.f175z = (float) t1.f171z;
        this.f172w = (float) t1.f168w;
    }

    public final void get(float[] t) {
        t[0] = this.f173x;
        t[1] = this.f174y;
        t[2] = this.f175z;
        t[3] = this.f172w;
    }

    public final void get(Tuple4f t) {
        t.f173x = this.f173x;
        t.f174y = this.f174y;
        t.f175z = this.f175z;
        t.f172w = this.f172w;
    }

    public final void add(Tuple4f t1, Tuple4f t2) {
        this.f173x = t1.f173x + t2.f173x;
        this.f174y = t1.f174y + t2.f174y;
        this.f175z = t1.f175z + t2.f175z;
        this.f172w = t1.f172w + t2.f172w;
    }

    public final void add(Tuple4f t1) {
        this.f173x += t1.f173x;
        this.f174y += t1.f174y;
        this.f175z += t1.f175z;
        this.f172w += t1.f172w;
    }

    public final void sub(Tuple4f t1, Tuple4f t2) {
        this.f173x = t1.f173x - t2.f173x;
        this.f174y = t1.f174y - t2.f174y;
        this.f175z = t1.f175z - t2.f175z;
        this.f172w = t1.f172w - t2.f172w;
    }

    public final void sub(Tuple4f t1) {
        this.f173x -= t1.f173x;
        this.f174y -= t1.f174y;
        this.f175z -= t1.f175z;
        this.f172w -= t1.f172w;
    }

    public final void negate(Tuple4f t1) {
        this.f173x = -t1.f173x;
        this.f174y = -t1.f174y;
        this.f175z = -t1.f175z;
        this.f172w = -t1.f172w;
    }

    public final void negate() {
        this.f173x = -this.f173x;
        this.f174y = -this.f174y;
        this.f175z = -this.f175z;
        this.f172w = -this.f172w;
    }

    public final void scale(float s, Tuple4f t1) {
        this.f173x = t1.f173x * s;
        this.f174y = t1.f174y * s;
        this.f175z = t1.f175z * s;
        this.f172w = t1.f172w * s;
    }

    public final void scale(float s) {
        this.f173x *= s;
        this.f174y *= s;
        this.f175z *= s;
        this.f172w *= s;
    }

    public final void scaleAdd(float s, Tuple4f t1, Tuple4f t2) {
        this.f173x = (t1.f173x * s) + t2.f173x;
        this.f174y = (t1.f174y * s) + t2.f174y;
        this.f175z = (t1.f175z * s) + t2.f175z;
        this.f172w = (t1.f172w * s) + t2.f172w;
    }

    public final void scaleAdd(float s, Tuple4f t1) {
        this.f173x = (this.f173x * s) + t1.f173x;
        this.f174y = (this.f174y * s) + t1.f174y;
        this.f175z = (this.f175z * s) + t1.f175z;
        this.f172w = (this.f172w * s) + t1.f172w;
    }

    public String toString() {
        return "(" + this.f173x + ", " + this.f174y + ", " + this.f175z + ", " + this.f172w + ")";
    }

    public boolean equals(Tuple4f t1) {
        try {
            return this.f173x == t1.f173x && this.f174y == t1.f174y && this.f175z == t1.f175z && this.f172w == t1.f172w;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean equals(Object t1) {
        try {
            Tuple4f t2 = (Tuple4f) t1;
            if (this.f173x == t2.f173x && this.f174y == t2.f174y && this.f175z == t2.f175z && this.f172w == t2.f172w) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public boolean epsilonEquals(Tuple4f t1, float epsilon) {
        float f;
        float f2;
        float f3;
        float diff = this.f173x - t1.f173x;
        if (Float.isNaN(diff)) {
            return false;
        }
        if ((diff < 0.0f ? -diff : diff) > epsilon) {
            return false;
        }
        float diff2 = this.f174y - t1.f174y;
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
        float diff3 = this.f175z - t1.f175z;
        if (Float.isNaN(diff3)) {
            return false;
        }
        if (diff3 < 0.0f) {
            f2 = -diff3;
        } else {
            f2 = diff3;
        }
        if (f2 > epsilon) {
            return false;
        }
        float diff4 = this.f172w - t1.f172w;
        if (Float.isNaN(diff4)) {
            return false;
        }
        if (diff4 < 0.0f) {
            f3 = -diff4;
        } else {
            f3 = diff4;
        }
        if (f3 <= epsilon) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long bits = (31 * ((31 * ((31 * ((31 * 1) + ((long) VecMathUtil.floatToIntBits(this.f173x)))) + ((long) VecMathUtil.floatToIntBits(this.f174y)))) + ((long) VecMathUtil.floatToIntBits(this.f175z)))) + ((long) VecMathUtil.floatToIntBits(this.f172w));
        return (int) ((bits >> 32) ^ bits);
    }

    public final void clamp(float min, float max, Tuple4f t) {
        if (t.f173x > max) {
            this.f173x = max;
        } else if (t.f173x < min) {
            this.f173x = min;
        } else {
            this.f173x = t.f173x;
        }
        if (t.f174y > max) {
            this.f174y = max;
        } else if (t.f174y < min) {
            this.f174y = min;
        } else {
            this.f174y = t.f174y;
        }
        if (t.f175z > max) {
            this.f175z = max;
        } else if (t.f175z < min) {
            this.f175z = min;
        } else {
            this.f175z = t.f175z;
        }
        if (t.f172w > max) {
            this.f172w = max;
        } else if (t.f172w < min) {
            this.f172w = min;
        } else {
            this.f172w = t.f172w;
        }
    }

    public final void clampMin(float min, Tuple4f t) {
        if (t.f173x < min) {
            this.f173x = min;
        } else {
            this.f173x = t.f173x;
        }
        if (t.f174y < min) {
            this.f174y = min;
        } else {
            this.f174y = t.f174y;
        }
        if (t.f175z < min) {
            this.f175z = min;
        } else {
            this.f175z = t.f175z;
        }
        if (t.f172w < min) {
            this.f172w = min;
        } else {
            this.f172w = t.f172w;
        }
    }

    public final void clampMax(float max, Tuple4f t) {
        if (t.f173x > max) {
            this.f173x = max;
        } else {
            this.f173x = t.f173x;
        }
        if (t.f174y > max) {
            this.f174y = max;
        } else {
            this.f174y = t.f174y;
        }
        if (t.f175z > max) {
            this.f175z = max;
        } else {
            this.f175z = t.f175z;
        }
        if (t.f172w > max) {
            this.f172w = max;
        } else {
            this.f172w = t.f175z;
        }
    }

    public final void absolute(Tuple4f t) {
        this.f173x = Math.abs(t.f173x);
        this.f174y = Math.abs(t.f174y);
        this.f175z = Math.abs(t.f175z);
        this.f172w = Math.abs(t.f172w);
    }

    public final void clamp(float min, float max) {
        if (this.f173x > max) {
            this.f173x = max;
        } else if (this.f173x < min) {
            this.f173x = min;
        }
        if (this.f174y > max) {
            this.f174y = max;
        } else if (this.f174y < min) {
            this.f174y = min;
        }
        if (this.f175z > max) {
            this.f175z = max;
        } else if (this.f175z < min) {
            this.f175z = min;
        }
        if (this.f172w > max) {
            this.f172w = max;
        } else if (this.f172w < min) {
            this.f172w = min;
        }
    }

    public final void clampMin(float min) {
        if (this.f173x < min) {
            this.f173x = min;
        }
        if (this.f174y < min) {
            this.f174y = min;
        }
        if (this.f175z < min) {
            this.f175z = min;
        }
        if (this.f172w < min) {
            this.f172w = min;
        }
    }

    public final void clampMax(float max) {
        if (this.f173x > max) {
            this.f173x = max;
        }
        if (this.f174y > max) {
            this.f174y = max;
        }
        if (this.f175z > max) {
            this.f175z = max;
        }
        if (this.f172w > max) {
            this.f172w = max;
        }
    }

    public final void absolute() {
        this.f173x = Math.abs(this.f173x);
        this.f174y = Math.abs(this.f174y);
        this.f175z = Math.abs(this.f175z);
        this.f172w = Math.abs(this.f172w);
    }

    public void interpolate(Tuple4f t1, Tuple4f t2, float alpha) {
        this.f173x = ((1.0f - alpha) * t1.f173x) + (t2.f173x * alpha);
        this.f174y = ((1.0f - alpha) * t1.f174y) + (t2.f174y * alpha);
        this.f175z = ((1.0f - alpha) * t1.f175z) + (t2.f175z * alpha);
        this.f172w = ((1.0f - alpha) * t1.f172w) + (t2.f172w * alpha);
    }

    public void interpolate(Tuple4f t1, float alpha) {
        this.f173x = ((1.0f - alpha) * this.f173x) + (t1.f173x * alpha);
        this.f174y = ((1.0f - alpha) * this.f174y) + (t1.f174y * alpha);
        this.f175z = ((1.0f - alpha) * this.f175z) + (t1.f175z * alpha);
        this.f172w = ((1.0f - alpha) * this.f172w) + (t1.f172w * alpha);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public final float getX() {
        return this.f173x;
    }

    public final void setX(float x) {
        this.f173x = x;
    }

    public final float getY() {
        return this.f174y;
    }

    public final void setY(float y) {
        this.f174y = y;
    }

    public final float getZ() {
        return this.f175z;
    }

    public final void setZ(float z) {
        this.f175z = z;
    }

    public final float getW() {
        return this.f172w;
    }

    public final void setW(float w) {
        this.f172w = w;
    }
}
