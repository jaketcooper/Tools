package javax.vecmath;

import java.io.Serializable;

public abstract class Tuple4b implements Serializable, Cloneable {
    static final long serialVersionUID = -8226727741811898211L;

    /* renamed from: w */
    public byte f164w;

    /* renamed from: x */
    public byte f165x;

    /* renamed from: y */
    public byte f166y;

    /* renamed from: z */
    public byte f167z;

    public Tuple4b(byte b1, byte b2, byte b3, byte b4) {
        this.f165x = b1;
        this.f166y = b2;
        this.f167z = b3;
        this.f164w = b4;
    }

    public Tuple4b(byte[] t) {
        this.f165x = t[0];
        this.f166y = t[1];
        this.f167z = t[2];
        this.f164w = t[3];
    }

    public Tuple4b(Tuple4b t1) {
        this.f165x = t1.f165x;
        this.f166y = t1.f166y;
        this.f167z = t1.f167z;
        this.f164w = t1.f164w;
    }

    public Tuple4b() {
        this.f165x = 0;
        this.f166y = 0;
        this.f167z = 0;
        this.f164w = 0;
    }

    public String toString() {
        return "(" + (this.f165x & 255) + ", " + (this.f166y & 255) + ", " + (this.f167z & 255) + ", " + (this.f164w & 255) + ")";
    }

    public final void get(byte[] b) {
        b[0] = this.f165x;
        b[1] = this.f166y;
        b[2] = this.f167z;
        b[3] = this.f164w;
    }

    public final void get(Tuple4b t1) {
        t1.f165x = this.f165x;
        t1.f166y = this.f166y;
        t1.f167z = this.f167z;
        t1.f164w = this.f164w;
    }

    public final void set(Tuple4b t1) {
        this.f165x = t1.f165x;
        this.f166y = t1.f166y;
        this.f167z = t1.f167z;
        this.f164w = t1.f164w;
    }

    public final void set(byte[] b) {
        this.f165x = b[0];
        this.f166y = b[1];
        this.f167z = b[2];
        this.f164w = b[3];
    }

    public boolean equals(Tuple4b t1) {
        try {
            return this.f165x == t1.f165x && this.f166y == t1.f166y && this.f167z == t1.f167z && this.f164w == t1.f164w;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean equals(Object t1) {
        try {
            Tuple4b t2 = (Tuple4b) t1;
            if (this.f165x == t2.f165x && this.f166y == t2.f166y && this.f167z == t2.f167z && this.f164w == t2.f164w) {
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
        return ((this.f165x & 255) << 0) | ((this.f166y & 255) << 8) | ((this.f167z & 255) << 16) | ((this.f164w & 255) << 24);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public final byte getX() {
        return this.f165x;
    }

    public final void setX(byte x) {
        this.f165x = x;
    }

    public final byte getY() {
        return this.f166y;
    }

    public final void setY(byte y) {
        this.f166y = y;
    }

    public final byte getZ() {
        return this.f167z;
    }

    public final void setZ(byte z) {
        this.f167z = z;
    }

    public final byte getW() {
        return this.f164w;
    }

    public final void setW(byte w) {
        this.f164w = w;
    }
}
