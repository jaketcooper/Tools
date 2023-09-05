package javax.vecmath;

import java.io.Serializable;

public class Vector3f extends Tuple3f implements Serializable {
    static final long serialVersionUID = -7031930069184524614L;

    public Vector3f(float x, float y, float z) {
        super(x, y, z);
    }

    public Vector3f(float[] v) {
        super(v);
    }

    public Vector3f(Vector3f v1) {
        super((Tuple3f) v1);
    }

    public Vector3f(Vector3d v1) {
        super((Tuple3d) v1);
    }

    public Vector3f(Tuple3f t1) {
        super(t1);
    }

    public Vector3f(Tuple3d t1) {
        super(t1);
    }

    public Vector3f() {
    }

    public final float lengthSquared() {
        return (this.f158x * this.f158x) + (this.f159y * this.f159y) + (this.f160z * this.f160z);
    }

    public final float length() {
        return (float) Math.sqrt((double) ((this.f158x * this.f158x) + (this.f159y * this.f159y) + (this.f160z * this.f160z)));
    }

    public final void cross(Vector3f v1, Vector3f v2) {
        float x = (v1.f159y * v2.f160z) - (v1.f160z * v2.f159y);
        float y = (v2.f158x * v1.f160z) - (v2.f160z * v1.f158x);
        this.f160z = (v1.f158x * v2.f159y) - (v1.f159y * v2.f158x);
        this.f158x = x;
        this.f159y = y;
    }

    public final float dot(Vector3f v1) {
        return (this.f158x * v1.f158x) + (this.f159y * v1.f159y) + (this.f160z * v1.f160z);
    }

    public final void normalize(Vector3f v1) {
        float norm = (float) (1.0d / Math.sqrt((double) (((v1.f158x * v1.f158x) + (v1.f159y * v1.f159y)) + (v1.f160z * v1.f160z))));
        this.f158x = v1.f158x * norm;
        this.f159y = v1.f159y * norm;
        this.f160z = v1.f160z * norm;
    }

    public final void normalize() {
        float norm = (float) (1.0d / Math.sqrt((double) (((this.f158x * this.f158x) + (this.f159y * this.f159y)) + (this.f160z * this.f160z))));
        this.f158x *= norm;
        this.f159y *= norm;
        this.f160z *= norm;
    }

    public final float angle(Vector3f v1) {
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
