package javax.vecmath;

import com.github.mikephil.charting.utils.Utils;
import java.io.Serializable;

public class AxisAngle4d implements Serializable, Cloneable {
    static final double EPS = 1.0E-12d;
    static final long serialVersionUID = 3644296204459140589L;
    public double angle;

    /* renamed from: x */
    public double f140x;

    /* renamed from: y */
    public double f141y;

    /* renamed from: z */
    public double f142z;

    public AxisAngle4d(double x, double y, double z, double angle2) {
        this.f140x = x;
        this.f141y = y;
        this.f142z = z;
        this.angle = angle2;
    }

    public AxisAngle4d(double[] a) {
        this.f140x = a[0];
        this.f141y = a[1];
        this.f142z = a[2];
        this.angle = a[3];
    }

    public AxisAngle4d(AxisAngle4d a1) {
        this.f140x = a1.f140x;
        this.f141y = a1.f141y;
        this.f142z = a1.f142z;
        this.angle = a1.angle;
    }

    public AxisAngle4d(AxisAngle4f a1) {
        this.f140x = (double) a1.f143x;
        this.f141y = (double) a1.f144y;
        this.f142z = (double) a1.f145z;
        this.angle = (double) a1.angle;
    }

    public AxisAngle4d(Vector3d axis, double angle2) {
        this.f140x = axis.f155x;
        this.f141y = axis.f156y;
        this.f142z = axis.f157z;
        this.angle = angle2;
    }

    public AxisAngle4d() {
        this.f140x = Utils.DOUBLE_EPSILON;
        this.f141y = Utils.DOUBLE_EPSILON;
        this.f142z = 1.0d;
        this.angle = Utils.DOUBLE_EPSILON;
    }

    public final void set(double x, double y, double z, double angle2) {
        this.f140x = x;
        this.f141y = y;
        this.f142z = z;
        this.angle = angle2;
    }

    public final void set(double[] a) {
        this.f140x = a[0];
        this.f141y = a[1];
        this.f142z = a[2];
        this.angle = a[3];
    }

    public final void set(AxisAngle4d a1) {
        this.f140x = a1.f140x;
        this.f141y = a1.f141y;
        this.f142z = a1.f142z;
        this.angle = a1.angle;
    }

    public final void set(AxisAngle4f a1) {
        this.f140x = (double) a1.f143x;
        this.f141y = (double) a1.f144y;
        this.f142z = (double) a1.f145z;
        this.angle = (double) a1.angle;
    }

    public final void set(Vector3d axis, double angle2) {
        this.f140x = axis.f155x;
        this.f141y = axis.f156y;
        this.f142z = axis.f157z;
        this.angle = angle2;
    }

    public final void get(double[] a) {
        a[0] = this.f140x;
        a[1] = this.f141y;
        a[2] = this.f142z;
        a[3] = this.angle;
    }

    public final void set(Matrix4f m1) {
        Matrix3d m3d = new Matrix3d();
        m1.get(m3d);
        this.f140x = (double) ((float) (m3d.m21 - m3d.m12));
        this.f141y = (double) ((float) (m3d.m02 - m3d.m20));
        this.f142z = (double) ((float) (m3d.m10 - m3d.m01));
        double mag = (this.f140x * this.f140x) + (this.f141y * this.f141y) + (this.f142z * this.f142z);
        if (mag > EPS) {
            double mag2 = Math.sqrt(mag);
            this.angle = (double) ((float) Math.atan2(0.5d * mag2, 0.5d * (((m3d.m00 + m3d.m11) + m3d.m22) - 1.0d)));
            double invMag = 1.0d / mag2;
            this.f140x *= invMag;
            this.f141y *= invMag;
            this.f142z *= invMag;
            return;
        }
        this.f140x = Utils.DOUBLE_EPSILON;
        this.f141y = 1.0d;
        this.f142z = Utils.DOUBLE_EPSILON;
        this.angle = Utils.DOUBLE_EPSILON;
    }

    public final void set(Matrix4d m1) {
        Matrix3d m3d = new Matrix3d();
        m1.get(m3d);
        this.f140x = (double) ((float) (m3d.m21 - m3d.m12));
        this.f141y = (double) ((float) (m3d.m02 - m3d.m20));
        this.f142z = (double) ((float) (m3d.m10 - m3d.m01));
        double mag = (this.f140x * this.f140x) + (this.f141y * this.f141y) + (this.f142z * this.f142z);
        if (mag > EPS) {
            double mag2 = Math.sqrt(mag);
            this.angle = (double) ((float) Math.atan2(0.5d * mag2, 0.5d * (((m3d.m00 + m3d.m11) + m3d.m22) - 1.0d)));
            double invMag = 1.0d / mag2;
            this.f140x *= invMag;
            this.f141y *= invMag;
            this.f142z *= invMag;
            return;
        }
        this.f140x = Utils.DOUBLE_EPSILON;
        this.f141y = 1.0d;
        this.f142z = Utils.DOUBLE_EPSILON;
        this.angle = Utils.DOUBLE_EPSILON;
    }

    public final void set(Matrix3f m1) {
        this.f140x = (double) (m1.m21 - m1.m12);
        this.f141y = (double) (m1.m02 - m1.m20);
        this.f142z = (double) (m1.m10 - m1.m01);
        double mag = (this.f140x * this.f140x) + (this.f141y * this.f141y) + (this.f142z * this.f142z);
        if (mag > EPS) {
            double mag2 = Math.sqrt(mag);
            this.angle = (double) ((float) Math.atan2(0.5d * mag2, 0.5d * (((double) ((m1.m00 + m1.m11) + m1.m22)) - 1.0d)));
            double invMag = 1.0d / mag2;
            this.f140x *= invMag;
            this.f141y *= invMag;
            this.f142z *= invMag;
            return;
        }
        this.f140x = Utils.DOUBLE_EPSILON;
        this.f141y = 1.0d;
        this.f142z = Utils.DOUBLE_EPSILON;
        this.angle = Utils.DOUBLE_EPSILON;
    }

    public final void set(Matrix3d m1) {
        this.f140x = (double) ((float) (m1.m21 - m1.m12));
        this.f141y = (double) ((float) (m1.m02 - m1.m20));
        this.f142z = (double) ((float) (m1.m10 - m1.m01));
        double mag = (this.f140x * this.f140x) + (this.f141y * this.f141y) + (this.f142z * this.f142z);
        if (mag > EPS) {
            double mag2 = Math.sqrt(mag);
            this.angle = (double) ((float) Math.atan2(0.5d * mag2, 0.5d * (((m1.m00 + m1.m11) + m1.m22) - 1.0d)));
            double invMag = 1.0d / mag2;
            this.f140x *= invMag;
            this.f141y *= invMag;
            this.f142z *= invMag;
            return;
        }
        this.f140x = Utils.DOUBLE_EPSILON;
        this.f141y = 1.0d;
        this.f142z = Utils.DOUBLE_EPSILON;
        this.angle = Utils.DOUBLE_EPSILON;
    }

    public final void set(Quat4f q1) {
        double mag = (double) ((q1.f173x * q1.f173x) + (q1.f174y * q1.f174y) + (q1.f175z * q1.f175z));
        if (mag > EPS) {
            double mag2 = Math.sqrt(mag);
            double invMag = 1.0d / mag2;
            this.f140x = ((double) q1.f173x) * invMag;
            this.f141y = ((double) q1.f174y) * invMag;
            this.f142z = ((double) q1.f175z) * invMag;
            this.angle = 2.0d * Math.atan2(mag2, (double) q1.f172w);
            return;
        }
        this.f140x = Utils.DOUBLE_EPSILON;
        this.f141y = 1.0d;
        this.f142z = Utils.DOUBLE_EPSILON;
        this.angle = Utils.DOUBLE_EPSILON;
    }

    public final void set(Quat4d q1) {
        double mag = (q1.f169x * q1.f169x) + (q1.f170y * q1.f170y) + (q1.f171z * q1.f171z);
        if (mag > EPS) {
            double mag2 = Math.sqrt(mag);
            double invMag = 1.0d / mag2;
            this.f140x = q1.f169x * invMag;
            this.f141y = q1.f170y * invMag;
            this.f142z = q1.f171z * invMag;
            this.angle = 2.0d * Math.atan2(mag2, q1.f168w);
            return;
        }
        this.f140x = Utils.DOUBLE_EPSILON;
        this.f141y = 1.0d;
        this.f142z = Utils.DOUBLE_EPSILON;
        this.angle = Utils.DOUBLE_EPSILON;
    }

    public String toString() {
        return "(" + this.f140x + ", " + this.f141y + ", " + this.f142z + ", " + this.angle + ")";
    }

    public boolean equals(AxisAngle4d a1) {
        try {
            return this.f140x == a1.f140x && this.f141y == a1.f141y && this.f142z == a1.f142z && this.angle == a1.angle;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean equals(Object o1) {
        try {
            AxisAngle4d a2 = (AxisAngle4d) o1;
            if (this.f140x == a2.f140x && this.f141y == a2.f141y && this.f142z == a2.f142z && this.angle == a2.angle) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public boolean epsilonEquals(AxisAngle4d a1, double epsilon) {
        double d;
        double d2;
        double d3;
        double diff = this.f140x - a1.f140x;
        if (diff < Utils.DOUBLE_EPSILON) {
            d = -diff;
        } else {
            d = diff;
        }
        if (d > epsilon) {
            return false;
        }
        double diff2 = this.f141y - a1.f141y;
        if ((diff2 < Utils.DOUBLE_EPSILON ? -diff2 : diff2) > epsilon) {
            return false;
        }
        double diff3 = this.f142z - a1.f142z;
        if (diff3 < Utils.DOUBLE_EPSILON) {
            d2 = -diff3;
        } else {
            d2 = diff3;
        }
        if (d2 > epsilon) {
            return false;
        }
        double diff4 = this.angle - a1.angle;
        if (diff4 < Utils.DOUBLE_EPSILON) {
            d3 = -diff4;
        } else {
            d3 = diff4;
        }
        if (d3 <= epsilon) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long bits = (31 * ((31 * ((31 * ((31 * 1) + VecMathUtil.doubleToLongBits(this.f140x))) + VecMathUtil.doubleToLongBits(this.f141y))) + VecMathUtil.doubleToLongBits(this.f142z))) + VecMathUtil.doubleToLongBits(this.angle);
        return (int) ((bits >> 32) ^ bits);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public final double getAngle() {
        return this.angle;
    }

    public final void setAngle(double angle2) {
        this.angle = angle2;
    }

    public double getX() {
        return this.f140x;
    }

    public final void setX(double x) {
        this.f140x = x;
    }

    public final double getY() {
        return this.f141y;
    }

    public final void setY(double y) {
        this.f141y = y;
    }

    public double getZ() {
        return this.f142z;
    }

    public final void setZ(double z) {
        this.f142z = z;
    }
}
