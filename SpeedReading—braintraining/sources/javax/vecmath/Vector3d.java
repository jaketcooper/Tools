package javax.vecmath;

import java.io.Serializable;

public class Vector3d extends Tuple3d implements Serializable {
    static final long serialVersionUID = 3761969948420550442L;

    public Vector3d(double x, double y, double z) {
        super(x, y, z);
    }

    public Vector3d(double[] v) {
        super(v);
    }

    public Vector3d(Vector3d v1) {
        super((Tuple3d) v1);
    }

    public Vector3d(Vector3f v1) {
        super((Tuple3f) v1);
    }

    public Vector3d(Tuple3f t1) {
        super(t1);
    }

    public Vector3d(Tuple3d t1) {
        super(t1);
    }

    public Vector3d() {
    }

    public final void cross(Vector3d v1, Vector3d v2) {
        double x = (v1.f156y * v2.f157z) - (v1.f157z * v2.f156y);
        double y = (v2.f155x * v1.f157z) - (v2.f157z * v1.f155x);
        this.f157z = (v1.f155x * v2.f156y) - (v1.f156y * v2.f155x);
        this.f155x = x;
        this.f156y = y;
    }

    public final void normalize(Vector3d v1) {
        double norm = 1.0d / Math.sqrt(((v1.f155x * v1.f155x) + (v1.f156y * v1.f156y)) + (v1.f157z * v1.f157z));
        this.f155x = v1.f155x * norm;
        this.f156y = v1.f156y * norm;
        this.f157z = v1.f157z * norm;
    }

    public final void normalize() {
        double norm = 1.0d / Math.sqrt(((this.f155x * this.f155x) + (this.f156y * this.f156y)) + (this.f157z * this.f157z));
        this.f155x *= norm;
        this.f156y *= norm;
        this.f157z *= norm;
    }

    public final double dot(Vector3d v1) {
        return (this.f155x * v1.f155x) + (this.f156y * v1.f156y) + (this.f157z * v1.f157z);
    }

    public final double lengthSquared() {
        return (this.f155x * this.f155x) + (this.f156y * this.f156y) + (this.f157z * this.f157z);
    }

    public final double length() {
        return Math.sqrt((this.f155x * this.f155x) + (this.f156y * this.f156y) + (this.f157z * this.f157z));
    }

    public final double angle(Vector3d v1) {
        double vDot = dot(v1) / (length() * v1.length());
        if (vDot < -1.0d) {
            vDot = -1.0d;
        }
        if (vDot > 1.0d) {
            vDot = 1.0d;
        }
        return Math.acos(vDot);
    }
}
