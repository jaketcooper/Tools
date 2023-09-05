package javax.vecmath;

import java.io.Serializable;

public abstract class Tuple2i implements Serializable, Cloneable {
    static final long serialVersionUID = -3555701650170169638L;

    /* renamed from: x */
    public int f150x;

    /* renamed from: y */
    public int f151y;

    public Tuple2i(int x, int y) {
        this.f150x = x;
        this.f151y = y;
    }

    public Tuple2i(int[] t) {
        this.f150x = t[0];
        this.f151y = t[1];
    }

    public Tuple2i(Tuple2i t1) {
        this.f150x = t1.f150x;
        this.f151y = t1.f151y;
    }

    public Tuple2i() {
        this.f150x = 0;
        this.f151y = 0;
    }

    public final void set(int x, int y) {
        this.f150x = x;
        this.f151y = y;
    }

    public final void set(int[] t) {
        this.f150x = t[0];
        this.f151y = t[1];
    }

    public final void set(Tuple2i t1) {
        this.f150x = t1.f150x;
        this.f151y = t1.f151y;
    }

    public final void get(int[] t) {
        t[0] = this.f150x;
        t[1] = this.f151y;
    }

    public final void get(Tuple2i t) {
        t.f150x = this.f150x;
        t.f151y = this.f151y;
    }

    public final void add(Tuple2i t1, Tuple2i t2) {
        this.f150x = t1.f150x + t2.f150x;
        this.f151y = t1.f151y + t2.f151y;
    }

    public final void add(Tuple2i t1) {
        this.f150x += t1.f150x;
        this.f151y += t1.f151y;
    }

    public final void sub(Tuple2i t1, Tuple2i t2) {
        this.f150x = t1.f150x - t2.f150x;
        this.f151y = t1.f151y - t2.f151y;
    }

    public final void sub(Tuple2i t1) {
        this.f150x -= t1.f150x;
        this.f151y -= t1.f151y;
    }

    public final void negate(Tuple2i t1) {
        this.f150x = -t1.f150x;
        this.f151y = -t1.f151y;
    }

    public final void negate() {
        this.f150x = -this.f150x;
        this.f151y = -this.f151y;
    }

    public final void scale(int s, Tuple2i t1) {
        this.f150x = t1.f150x * s;
        this.f151y = t1.f151y * s;
    }

    public final void scale(int s) {
        this.f150x *= s;
        this.f151y *= s;
    }

    public final void scaleAdd(int s, Tuple2i t1, Tuple2i t2) {
        this.f150x = (t1.f150x * s) + t2.f150x;
        this.f151y = (t1.f151y * s) + t2.f151y;
    }

    public final void scaleAdd(int s, Tuple2i t1) {
        this.f150x = (this.f150x * s) + t1.f150x;
        this.f151y = (this.f151y * s) + t1.f151y;
    }

    public String toString() {
        return "(" + this.f150x + ", " + this.f151y + ")";
    }

    public boolean equals(Object t1) {
        try {
            Tuple2i t2 = (Tuple2i) t1;
            if (this.f150x == t2.f150x && this.f151y == t2.f151y) {
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
        long bits = (31 * ((31 * 1) + ((long) this.f150x))) + ((long) this.f151y);
        return (int) ((bits >> 32) ^ bits);
    }

    public final void clamp(int min, int max, Tuple2i t) {
        if (t.f150x > max) {
            this.f150x = max;
        } else if (t.f150x < min) {
            this.f150x = min;
        } else {
            this.f150x = t.f150x;
        }
        if (t.f151y > max) {
            this.f151y = max;
        } else if (t.f151y < min) {
            this.f151y = min;
        } else {
            this.f151y = t.f151y;
        }
    }

    public final void clampMin(int min, Tuple2i t) {
        if (t.f150x < min) {
            this.f150x = min;
        } else {
            this.f150x = t.f150x;
        }
        if (t.f151y < min) {
            this.f151y = min;
        } else {
            this.f151y = t.f151y;
        }
    }

    public final void clampMax(int max, Tuple2i t) {
        if (t.f150x > max) {
            this.f150x = max;
        } else {
            this.f150x = t.f150x;
        }
        if (t.f151y > max) {
            this.f151y = max;
        } else {
            this.f151y = t.f151y;
        }
    }

    public final void absolute(Tuple2i t) {
        this.f150x = Math.abs(t.f150x);
        this.f151y = Math.abs(t.f151y);
    }

    public final void clamp(int min, int max) {
        if (this.f150x > max) {
            this.f150x = max;
        } else if (this.f150x < min) {
            this.f150x = min;
        }
        if (this.f151y > max) {
            this.f151y = max;
        } else if (this.f151y < min) {
            this.f151y = min;
        }
    }

    public final void clampMin(int min) {
        if (this.f150x < min) {
            this.f150x = min;
        }
        if (this.f151y < min) {
            this.f151y = min;
        }
    }

    public final void clampMax(int max) {
        if (this.f150x > max) {
            this.f150x = max;
        }
        if (this.f151y > max) {
            this.f151y = max;
        }
    }

    public final void absolute() {
        this.f150x = Math.abs(this.f150x);
        this.f151y = Math.abs(this.f151y);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public final int getX() {
        return this.f150x;
    }

    public final void setX(int x) {
        this.f150x = x;
    }

    public final int getY() {
        return this.f151y;
    }

    public final void setY(int y) {
        this.f151y = y;
    }
}
