package javax.vecmath;

import java.io.Serializable;

public class Vector4f extends Tuple4f implements Serializable {
    static final long serialVersionUID = 8749319902347760659L;

    public Vector4f(float x, float y, float z, float w) {
        super(x, y, z, w);
    }

    public Vector4f(float[] v) {
        super(v);
    }

    public Vector4f(Vector4f v1) {
        super((Tuple4f) v1);
    }

    public Vector4f(Vector4d v1) {
        super((Tuple4d) v1);
    }

    public Vector4f(Tuple4f t1) {
        super(t1);
    }

    public Vector4f(Tuple4d t1) {
        super(t1);
    }

    public Vector4f(Tuple3f t1) {
        super(t1.f158x, t1.f159y, t1.f160z, 0.0f);
    }

    public Vector4f() {
    }

    public final void set(Tuple3f t1) {
        this.f173x = t1.f158x;
        this.f174y = t1.f159y;
        this.f175z = t1.f160z;
        this.f172w = 0.0f;
    }

    public final float length() {
        return (float) Math.sqrt((double) ((this.f173x * this.f173x) + (this.f174y * this.f174y) + (this.f175z * this.f175z) + (this.f172w * this.f172w)));
    }

    public final float lengthSquared() {
        return (this.f173x * this.f173x) + (this.f174y * this.f174y) + (this.f175z * this.f175z) + (this.f172w * this.f172w);
    }

    public final float dot(Vector4f v1) {
        return (this.f173x * v1.f173x) + (this.f174y * v1.f174y) + (this.f175z * v1.f175z) + (this.f172w * v1.f172w);
    }

    public final void normalize(Vector4f v1) {
        float norm = (float) (1.0d / Math.sqrt((double) ((((v1.f173x * v1.f173x) + (v1.f174y * v1.f174y)) + (v1.f175z * v1.f175z)) + (v1.f172w * v1.f172w))));
        this.f173x = v1.f173x * norm;
        this.f174y = v1.f174y * norm;
        this.f175z = v1.f175z * norm;
        this.f172w = v1.f172w * norm;
    }

    public final void normalize() {
        float norm = (float) (1.0d / Math.sqrt((double) ((((this.f173x * this.f173x) + (this.f174y * this.f174y)) + (this.f175z * this.f175z)) + (this.f172w * this.f172w))));
        this.f173x *= norm;
        this.f174y *= norm;
        this.f175z *= norm;
        this.f172w *= norm;
    }

    public final float angle(Vector4f v1) {
        double vDot = (double) (dot(v1) / (length() * v1.length()));
        if (vDot < -1.0d) {
            vDot = -1.0d;
        }
        if (vDot > 1.0d) {
            vDot = 1.0d;
        }
        return (float) Math.acos(vDot);
    }
}
