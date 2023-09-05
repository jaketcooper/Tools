package javax.vecmath;

import java.io.Serializable;

public abstract class Tuple4i implements Serializable, Cloneable {
    static final long serialVersionUID = 8064614250942616720L;

    /* renamed from: w */
    public int f176w;

    /* renamed from: x */
    public int f177x;

    /* renamed from: y */
    public int f178y;

    /* renamed from: z */
    public int f179z;

    public Tuple4i(int x, int y, int z, int w) {
        this.f177x = x;
        this.f178y = y;
        this.f179z = z;
        this.f176w = w;
    }

    public Tuple4i(int[] t) {
        this.f177x = t[0];
        this.f178y = t[1];
        this.f179z = t[2];
        this.f176w = t[3];
    }

    public Tuple4i(Tuple4i t1) {
        this.f177x = t1.f177x;
        this.f178y = t1.f178y;
        this.f179z = t1.f179z;
        this.f176w = t1.f176w;
    }

    public Tuple4i() {
        this.f177x = 0;
        this.f178y = 0;
        this.f179z = 0;
        this.f176w = 0;
    }

    public final void set(int x, int y, int z, int w) {
        this.f177x = x;
        this.f178y = y;
        this.f179z = z;
        this.f176w = w;
    }

    public final void set(int[] t) {
        this.f177x = t[0];
        this.f178y = t[1];
        this.f179z = t[2];
        this.f176w = t[3];
    }

    public final void set(Tuple4i t1) {
        this.f177x = t1.f177x;
        this.f178y = t1.f178y;
        this.f179z = t1.f179z;
        this.f176w = t1.f176w;
    }

    public final void get(int[] t) {
        t[0] = this.f177x;
        t[1] = this.f178y;
        t[2] = this.f179z;
        t[3] = this.f176w;
    }

    public final void get(Tuple4i t) {
        t.f177x = this.f177x;
        t.f178y = this.f178y;
        t.f179z = this.f179z;
        t.f176w = this.f176w;
    }

    public final void add(Tuple4i t1, Tuple4i t2) {
        this.f177x = t1.f177x + t2.f177x;
        this.f178y = t1.f178y + t2.f178y;
        this.f179z = t1.f179z + t2.f179z;
        this.f176w = t1.f176w + t2.f176w;
    }

    public final void add(Tuple4i t1) {
        this.f177x += t1.f177x;
        this.f178y += t1.f178y;
        this.f179z += t1.f179z;
        this.f176w += t1.f176w;
    }

    public final void sub(Tuple4i t1, Tuple4i t2) {
        this.f177x = t1.f177x - t2.f177x;
        this.f178y = t1.f178y - t2.f178y;
        this.f179z = t1.f179z - t2.f179z;
        this.f176w = t1.f176w - t2.f176w;
    }

    public final void sub(Tuple4i t1) {
        this.f177x -= t1.f177x;
        this.f178y -= t1.f178y;
        this.f179z -= t1.f179z;
        this.f176w -= t1.f176w;
    }

    public final void negate(Tuple4i t1) {
        this.f177x = -t1.f177x;
        this.f178y = -t1.f178y;
        this.f179z = -t1.f179z;
        this.f176w = -t1.f176w;
    }

    public final void negate() {
        this.f177x = -this.f177x;
        this.f178y = -this.f178y;
        this.f179z = -this.f179z;
        this.f176w = -this.f176w;
    }

    public final void scale(int s, Tuple4i t1) {
        this.f177x = t1.f177x * s;
        this.f178y = t1.f178y * s;
        this.f179z = t1.f179z * s;
        this.f176w = t1.f176w * s;
    }

    public final void scale(int s) {
        this.f177x *= s;
        this.f178y *= s;
        this.f179z *= s;
        this.f176w *= s;
    }

    public final void scaleAdd(int s, Tuple4i t1, Tuple4i t2) {
        this.f177x = (t1.f177x * s) + t2.f177x;
        this.f178y = (t1.f178y * s) + t2.f178y;
        this.f179z = (t1.f179z * s) + t2.f179z;
        this.f176w = (t1.f176w * s) + t2.f176w;
    }

    public final void scaleAdd(int s, Tuple4i t1) {
        this.f177x = (this.f177x * s) + t1.f177x;
        this.f178y = (this.f178y * s) + t1.f178y;
        this.f179z = (this.f179z * s) + t1.f179z;
        this.f176w = (this.f176w * s) + t1.f176w;
    }

    public String toString() {
        return "(" + this.f177x + ", " + this.f178y + ", " + this.f179z + ", " + this.f176w + ")";
    }

    public boolean equals(Object t1) {
        try {
            Tuple4i t2 = (Tuple4i) t1;
            if (this.f177x == t2.f177x && this.f178y == t2.f178y && this.f179z == t2.f179z && this.f176w == t2.f176w) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public int hashCode() {
        long bits = (31 * ((31 * ((31 * ((31 * 1) + ((long) this.f177x))) + ((long) this.f178y))) + ((long) this.f179z))) + ((long) this.f176w);
        return (int) ((bits >> 32) ^ bits);
    }

    public final void clamp(int min, int max, Tuple4i t) {
        if (t.f177x > max) {
            this.f177x = max;
        } else if (t.f177x < min) {
            this.f177x = min;
        } else {
            this.f177x = t.f177x;
        }
        if (t.f178y > max) {
            this.f178y = max;
        } else if (t.f178y < min) {
            this.f178y = min;
        } else {
            this.f178y = t.f178y;
        }
        if (t.f179z > max) {
            this.f179z = max;
        } else if (t.f179z < min) {
            this.f179z = min;
        } else {
            this.f179z = t.f179z;
        }
        if (t.f176w > max) {
            this.f176w = max;
        } else if (t.f176w < min) {
            this.f176w = min;
        } else {
            this.f176w = t.f176w;
        }
    }

    public final void clampMin(int min, Tuple4i t) {
        if (t.f177x < min) {
            this.f177x = min;
        } else {
            this.f177x = t.f177x;
        }
        if (t.f178y < min) {
            this.f178y = min;
        } else {
            this.f178y = t.f178y;
        }
        if (t.f179z < min) {
            this.f179z = min;
        } else {
            this.f179z = t.f179z;
        }
        if (t.f176w < min) {
            this.f176w = min;
        } else {
            this.f176w = t.f176w;
        }
    }

    public final void clampMax(int max, Tuple4i t) {
        if (t.f177x > max) {
            this.f177x = max;
        } else {
            this.f177x = t.f177x;
        }
        if (t.f178y > max) {
            this.f178y = max;
        } else {
            this.f178y = t.f178y;
        }
        if (t.f179z > max) {
            this.f179z = max;
        } else {
            this.f179z = t.f179z;
        }
        if (t.f176w > max) {
            this.f176w = max;
        } else {
            this.f176w = t.f179z;
        }
    }

    public final void absolute(Tuple4i t) {
        this.f177x = Math.abs(t.f177x);
        this.f178y = Math.abs(t.f178y);
        this.f179z = Math.abs(t.f179z);
        this.f176w = Math.abs(t.f176w);
    }

    public final void clamp(int min, int max) {
        if (this.f177x > max) {
            this.f177x = max;
        } else if (this.f177x < min) {
            this.f177x = min;
        }
        if (this.f178y > max) {
            this.f178y = max;
        } else if (this.f178y < min) {
            this.f178y = min;
        }
        if (this.f179z > max) {
            this.f179z = max;
        } else if (this.f179z < min) {
            this.f179z = min;
        }
        if (this.f176w > max) {
            this.f176w = max;
        } else if (this.f176w < min) {
            this.f176w = min;
        }
    }

    public final void clampMin(int min) {
        if (this.f177x < min) {
            this.f177x = min;
        }
        if (this.f178y < min) {
            this.f178y = min;
        }
        if (this.f179z < min) {
            this.f179z = min;
        }
        if (this.f176w < min) {
            this.f176w = min;
        }
    }

    public final void clampMax(int max) {
        if (this.f177x > max) {
            this.f177x = max;
        }
        if (this.f178y > max) {
            this.f178y = max;
        }
        if (this.f179z > max) {
            this.f179z = max;
        }
        if (this.f176w > max) {
            this.f176w = max;
        }
    }

    public final void absolute() {
        this.f177x = Math.abs(this.f177x);
        this.f178y = Math.abs(this.f178y);
        this.f179z = Math.abs(this.f179z);
        this.f176w = Math.abs(this.f176w);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public final int getX() {
        return this.f177x;
    }

    public final void setX(int x) {
        this.f177x = x;
    }

    public final int getY() {
        return this.f178y;
    }

    public final void setY(int y) {
        this.f178y = y;
    }

    public final int getZ() {
        return this.f179z;
    }

    public final void setZ(int z) {
        this.f179z = z;
    }

    public final int getW() {
        return this.f176w;
    }

    public final void setW(int w) {
        this.f176w = w;
    }
}
