package javax.vecmath;

import com.github.mikephil.charting.utils.Utils;
import java.io.Serializable;

public class Vector4d extends Tuple4d implements Serializable {
    static final long serialVersionUID = 3938123424117448700L;

    public Vector4d(double x, double y, double z, double w) {
        super(x, y, z, w);
    }

    public Vector4d(double[] v) {
        super(v);
    }

    public Vector4d(Vector4d v1) {
        super((Tuple4d) v1);
    }

    public Vector4d(Vector4f v1) {
        super((Tuple4f) v1);
    }

    public Vector4d(Tuple4f t1) {
        super(t1);
    }

    public Vector4d(Tuple4d t1) {
        super(t1);
    }

    public Vector4d(Tuple3d t1) {
        super(t1.f155x, t1.f156y, t1.f157z, Utils.DOUBLE_EPSILON);
    }

    public Vector4d() {
    }

    public final void set(Tuple3d t1) {
        this.f169x = t1.f155x;
        this.f170y = t1.f156y;
        this.f171z = t1.f157z;
        this.f168w = Utils.DOUBLE_EPSILON;
    }

    public final double length() {
        return Math.sqrt((this.f169x * this.f169x) + (this.f170y * this.f170y) + (this.f171z * this.f171z) + (this.f168w * this.f168w));
    }

    public final double lengthSquared() {
        return (this.f169x * this.f169x) + (this.f170y * this.f170y) + (this.f171z * this.f171z) + (this.f168w * this.f168w);
    }

    public final double dot(Vector4d v1) {
        return (this.f169x * v1.f169x) + (this.f170y * v1.f170y) + (this.f171z * v1.f171z) + (this.f168w * v1.f168w);
    }

    public final void normalize(Vector4d v1) {
        double norm = 1.0d / Math.sqrt((((v1.f169x * v1.f169x) + (v1.f170y * v1.f170y)) + (v1.f171z * v1.f171z)) + (v1.f168w * v1.f168w));
        this.f169x = v1.f169x * norm;
        this.f170y = v1.f170y * norm;
        this.f171z = v1.f171z * norm;
        this.f168w = v1.f168w * norm;
    }

    public final void normalize() {
        double norm = 1.0d / Math.sqrt((((this.f169x * this.f169x) + (this.f170y * this.f170y)) + (this.f171z * this.f171z)) + (this.f168w * this.f168w));
        this.f169x *= norm;
        this.f170y *= norm;
        this.f171z *= norm;
        this.f168w *= norm;
    }

    public final double angle(Vector4d v1) {
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
