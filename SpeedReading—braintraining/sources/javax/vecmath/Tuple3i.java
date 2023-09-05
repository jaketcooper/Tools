package javax.vecmath;

import java.io.Serializable;

public abstract class Tuple3i implements Serializable, Cloneable {
    static final long serialVersionUID = -732740491767276200L;

    /* renamed from: x */
    public int f161x;

    /* renamed from: y */
    public int f162y;

    /* renamed from: z */
    public int f163z;

    public Tuple3i(int x, int y, int z) {
        this.f161x = x;
        this.f162y = y;
        this.f163z = z;
    }

    public Tuple3i(int[] t) {
        this.f161x = t[0];
        this.f162y = t[1];
        this.f163z = t[2];
    }

    public Tuple3i(Tuple3i t1) {
        this.f161x = t1.f161x;
        this.f162y = t1.f162y;
        this.f163z = t1.f163z;
    }

    public Tuple3i() {
        this.f161x = 0;
        this.f162y = 0;
        this.f163z = 0;
    }

    public final void set(int x, int y, int z) {
        this.f161x = x;
        this.f162y = y;
        this.f163z = z;
    }

    public final void set(int[] t) {
        this.f161x = t[0];
        this.f162y = t[1];
        this.f163z = t[2];
    }

    public final void set(Tuple3i t1) {
        this.f161x = t1.f161x;
        this.f162y = t1.f162y;
        this.f163z = t1.f163z;
    }

    public final void get(int[] t) {
        t[0] = this.f161x;
        t[1] = this.f162y;
        t[2] = this.f163z;
    }

    public final void get(Tuple3i t) {
        t.f161x = this.f161x;
        t.f162y = this.f162y;
        t.f163z = this.f163z;
    }

    public final void add(Tuple3i t1, Tuple3i t2) {
        this.f161x = t1.f161x + t2.f161x;
        this.f162y = t1.f162y + t2.f162y;
        this.f163z = t1.f163z + t2.f163z;
    }

    public final void add(Tuple3i t1) {
        this.f161x += t1.f161x;
        this.f162y += t1.f162y;
        this.f163z += t1.f163z;
    }

    public final void sub(Tuple3i t1, Tuple3i t2) {
        this.f161x = t1.f161x - t2.f161x;
        this.f162y = t1.f162y - t2.f162y;
        this.f163z = t1.f163z - t2.f163z;
    }

    public final void sub(Tuple3i t1) {
        this.f161x -= t1.f161x;
        this.f162y -= t1.f162y;
        this.f163z -= t1.f163z;
    }

    public final void negate(Tuple3i t1) {
        this.f161x = -t1.f161x;
        this.f162y = -t1.f162y;
        this.f163z = -t1.f163z;
    }

    public final void negate() {
        this.f161x = -this.f161x;
        this.f162y = -this.f162y;
        this.f163z = -this.f163z;
    }

    public final void scale(int s, Tuple3i t1) {
        this.f161x = t1.f161x * s;
        this.f162y = t1.f162y * s;
        this.f163z = t1.f163z * s;
    }

    public final void scale(int s) {
        this.f161x *= s;
        this.f162y *= s;
        this.f163z *= s;
    }

    public final void scaleAdd(int s, Tuple3i t1, Tuple3i t2) {
        this.f161x = (t1.f161x * s) + t2.f161x;
        this.f162y = (t1.f162y * s) + t2.f162y;
        this.f163z = (t1.f163z * s) + t2.f163z;
    }

    public final void scaleAdd(int s, Tuple3i t1) {
        this.f161x = (this.f161x * s) + t1.f161x;
        this.f162y = (this.f162y * s) + t1.f162y;
        this.f163z = (this.f163z * s) + t1.f163z;
    }

    public String toString() {
        return "(" + this.f161x + ", " + this.f162y + ", " + this.f163z + ")";
    }

    public boolean equals(Object t1) {
        try {
            Tuple3i t2 = (Tuple3i) t1;
            if (this.f161x == t2.f161x && this.f162y == t2.f162y && this.f163z == t2.f163z) {
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
        long bits = (31 * ((31 * ((31 * 1) + ((long) this.f161x))) + ((long) this.f162y))) + ((long) this.f163z);
        return (int) ((bits >> 32) ^ bits);
    }

    public final void clamp(int min, int max, Tuple3i t) {
        if (t.f161x > max) {
            this.f161x = max;
        } else if (t.f161x < min) {
            this.f161x = min;
        } else {
            this.f161x = t.f161x;
        }
        if (t.f162y > max) {
            this.f162y = max;
        } else if (t.f162y < min) {
            this.f162y = min;
        } else {
            this.f162y = t.f162y;
        }
        if (t.f163z > max) {
            this.f163z = max;
        } else if (t.f163z < min) {
            this.f163z = min;
        } else {
            this.f163z = t.f163z;
        }
    }

    public final void clampMin(int min, Tuple3i t) {
        if (t.f161x < min) {
            this.f161x = min;
        } else {
            this.f161x = t.f161x;
        }
        if (t.f162y < min) {
            this.f162y = min;
        } else {
            this.f162y = t.f162y;
        }
        if (t.f163z < min) {
            this.f163z = min;
        } else {
            this.f163z = t.f163z;
        }
    }

    public final void clampMax(int max, Tuple3i t) {
        if (t.f161x > max) {
            this.f161x = max;
        } else {
            this.f161x = t.f161x;
        }
        if (t.f162y > max) {
            this.f162y = max;
        } else {
            this.f162y = t.f162y;
        }
        if (t.f163z > max) {
            this.f163z = max;
        } else {
            this.f163z = t.f163z;
        }
    }

    public final void absolute(Tuple3i t) {
        this.f161x = Math.abs(t.f161x);
        this.f162y = Math.abs(t.f162y);
        this.f163z = Math.abs(t.f163z);
    }

    public final void clamp(int min, int max) {
        if (this.f161x > max) {
            this.f161x = max;
        } else if (this.f161x < min) {
            this.f161x = min;
        }
        if (this.f162y > max) {
            this.f162y = max;
        } else if (this.f162y < min) {
            this.f162y = min;
        }
        if (this.f163z > max) {
            this.f163z = max;
        } else if (this.f163z < min) {
            this.f163z = min;
        }
    }

    public final void clampMin(int min) {
        if (this.f161x < min) {
            this.f161x = min;
        }
        if (this.f162y < min) {
            this.f162y = min;
        }
        if (this.f163z < min) {
            this.f163z = min;
        }
    }

    public final void clampMax(int max) {
        if (this.f161x > max) {
            this.f161x = max;
        }
        if (this.f162y > max) {
            this.f162y = max;
        }
        if (this.f163z > max) {
            this.f163z = max;
        }
    }

    public final void absolute() {
        this.f161x = Math.abs(this.f161x);
        this.f162y = Math.abs(this.f162y);
        this.f163z = Math.abs(this.f163z);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public final int getX() {
        return this.f161x;
    }

    public final void setX(int x) {
        this.f161x = x;
    }

    public final int getY() {
        return this.f162y;
    }

    public final void setY(int y) {
        this.f162y = y;
    }

    public final int getZ() {
        return this.f163z;
    }

    public final void setZ(int z) {
        this.f163z = z;
    }
}
