package javax.vecmath;

import java.io.Serializable;

public abstract class Tuple3b implements Serializable, Cloneable {
    static final long serialVersionUID = -483782685323607044L;

    /* renamed from: x */
    public byte f152x;

    /* renamed from: y */
    public byte f153y;

    /* renamed from: z */
    public byte f154z;

    public Tuple3b(byte b1, byte b2, byte b3) {
        this.f152x = b1;
        this.f153y = b2;
        this.f154z = b3;
    }

    public Tuple3b(byte[] t) {
        this.f152x = t[0];
        this.f153y = t[1];
        this.f154z = t[2];
    }

    public Tuple3b(Tuple3b t1) {
        this.f152x = t1.f152x;
        this.f153y = t1.f153y;
        this.f154z = t1.f154z;
    }

    public Tuple3b() {
        this.f152x = 0;
        this.f153y = 0;
        this.f154z = 0;
    }

    public String toString() {
        return "(" + (this.f152x & 255) + ", " + (this.f153y & 255) + ", " + (this.f154z & 255) + ")";
    }

    public final void get(byte[] t) {
        t[0] = this.f152x;
        t[1] = this.f153y;
        t[2] = this.f154z;
    }

    public final void get(Tuple3b t1) {
        t1.f152x = this.f152x;
        t1.f153y = this.f153y;
        t1.f154z = this.f154z;
    }

    public final void set(Tuple3b t1) {
        this.f152x = t1.f152x;
        this.f153y = t1.f153y;
        this.f154z = t1.f154z;
    }

    public final void set(byte[] t) {
        this.f152x = t[0];
        this.f153y = t[1];
        this.f154z = t[2];
    }

    public boolean equals(Tuple3b t1) {
        try {
            return this.f152x == t1.f152x && this.f153y == t1.f153y && this.f154z == t1.f154z;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean equals(Object t1) {
        try {
            Tuple3b t2 = (Tuple3b) t1;
            if (this.f152x == t2.f152x && this.f153y == t2.f153y && this.f154z == t2.f154z) {
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
        return ((this.f152x & 255) << 0) | ((this.f153y & 255) << 8) | ((this.f154z & 255) << 16);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public final byte getX() {
        return this.f152x;
    }

    public final void setX(byte x) {
        this.f152x = x;
    }

    public final byte getY() {
        return this.f153y;
    }

    public final void setY(byte y) {
        this.f153y = y;
    }

    public final byte getZ() {
        return this.f154z;
    }

    public final void setZ(byte z) {
        this.f154z = z;
    }
}
