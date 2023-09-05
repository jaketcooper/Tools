package javax.vecmath;

import java.io.Serializable;

public class AxisAngle4f implements Serializable, Cloneable {
    static final double EPS = 1.0E-6d;
    static final long serialVersionUID = -163246355858070601L;
    public float angle;

    /* renamed from: x */
    public float f143x;

    /* renamed from: y */
    public float f144y;

    /* renamed from: z */
    public float f145z;

    public AxisAngle4f(float x, float y, float z, float angle2) {
        this.f143x = x;
        this.f144y = y;
        this.f145z = z;
        this.angle = angle2;
    }

    public AxisAngle4f(float[] a) {
        this.f143x = a[0];
        this.f144y = a[1];
        this.f145z = a[2];
        this.angle = a[3];
    }

    public AxisAngle4f(AxisAngle4f a1) {
        this.f143x = a1.f143x;
        this.f144y = a1.f144y;
        this.f145z = a1.f145z;
        this.angle = a1.angle;
    }

    public AxisAngle4f(AxisAngle4d a1) {
        this.f143x = (float) a1.f140x;
        this.f144y = (float) a1.f141y;
        this.f145z = (float) a1.f142z;
        this.angle = (float) a1.angle;
    }

    public AxisAngle4f(Vector3f axis, float angle2) {
        this.f143x = axis.f158x;
        this.f144y = axis.f159y;
        this.f145z = axis.f160z;
        this.angle = angle2;
    }

    public AxisAngle4f() {
        this.f143x = 0.0f;
        this.f144y = 0.0f;
        this.f145z = 1.0f;
        this.angle = 0.0f;
    }

    public final void set(float x, float y, float z, float angle2) {
        this.f143x = x;
        this.f144y = y;
        this.f145z = z;
        this.angle = angle2;
    }

    public final void set(float[] a) {
        this.f143x = a[0];
        this.f144y = a[1];
        this.f145z = a[2];
        this.angle = a[3];
    }

    public final void set(AxisAngle4f a1) {
        this.f143x = a1.f143x;
        this.f144y = a1.f144y;
        this.f145z = a1.f145z;
        this.angle = a1.angle;
    }

    public final void set(AxisAngle4d a1) {
        this.f143x = (float) a1.f140x;
        this.f144y = (float) a1.f141y;
        this.f145z = (float) a1.f142z;
        this.angle = (float) a1.angle;
    }

    public final void set(Vector3f axis, float angle2) {
        this.f143x = axis.f158x;
        this.f144y = axis.f159y;
        this.f145z = axis.f160z;
        this.angle = angle2;
    }

    public final void get(float[] a) {
        a[0] = this.f143x;
        a[1] = this.f144y;
        a[2] = this.f145z;
        a[3] = this.angle;
    }

    public final void set(Quat4f q1) {
        double mag = (double) ((q1.f173x * q1.f173x) + (q1.f174y * q1.f174y) + (q1.f175z * q1.f175z));
        if (mag > EPS) {
            double mag2 = Math.sqrt(mag);
            double invMag = 1.0d / mag2;
            this.f143x = (float) (((double) q1.f173x) * invMag);
            this.f144y = (float) (((double) q1.f174y) * invMag);
            this.f145z = (float) (((double) q1.f175z) * invMag);
            this.angle = (float) (2.0d * Math.atan2(mag2, (double) q1.f172w));
            return;
        }
        this.f143x = 0.0f;
        this.f144y = 1.0f;
        this.f145z = 0.0f;
        this.angle = 0.0f;
    }

    public final void set(Quat4d q1) {
        double mag = (q1.f169x * q1.f169x) + (q1.f170y * q1.f170y) + (q1.f171z * q1.f171z);
        if (mag > EPS) {
            double mag2 = Math.sqrt(mag);
            double invMag = 1.0d / mag2;
            this.f143x = (float) (q1.f169x * invMag);
            this.f144y = (float) (q1.f170y * invMag);
            this.f145z = (float) (q1.f171z * invMag);
            this.angle = (float) (2.0d * Math.atan2(mag2, q1.f168w));
            return;
        }
        this.f143x = 0.0f;
        this.f144y = 1.0f;
        this.f145z = 0.0f;
        this.angle = 0.0f;
    }

    public final void set(Matrix4f m1) {
        Matrix3f m3f = new Matrix3f();
        m1.get(m3f);
        this.f143x = m3f.m21 - m3f.m12;
        this.f144y = m3f.m02 - m3f.m20;
        this.f145z = m3f.m10 - m3f.m01;
        double mag = (double) ((this.f143x * this.f143x) + (this.f144y * this.f144y) + (this.f145z * this.f145z));
        if (mag > EPS) {
            double mag2 = Math.sqrt(mag);
            this.angle = (float) Math.atan2(0.5d * mag2, 0.5d * (((double) ((m3f.m00 + m3f.m11) + m3f.m22)) - 1.0d));
            double invMag = 1.0d / mag2;
            this.f143x = (float) (((double) this.f143x) * invMag);
            this.f144y = (float) (((double) this.f144y) * invMag);
            this.f145z = (float) (((double) this.f145z) * invMag);
            return;
        }
        this.f143x = 0.0f;
        this.f144y = 1.0f;
        this.f145z = 0.0f;
        this.angle = 0.0f;
    }

    public final void set(Matrix4d m1) {
        Matrix3d m3d = new Matrix3d();
        m1.get(m3d);
        this.f143x = (float) (m3d.m21 - m3d.m12);
        this.f144y = (float) (m3d.m02 - m3d.m20);
        this.f145z = (float) (m3d.m10 - m3d.m01);
        double mag = (double) ((this.f143x * this.f143x) + (this.f144y * this.f144y) + (this.f145z * this.f145z));
        if (mag > EPS) {
            double mag2 = Math.sqrt(mag);
            this.angle = (float) Math.atan2(0.5d * mag2, 0.5d * (((m3d.m00 + m3d.m11) + m3d.m22) - 1.0d));
            double invMag = 1.0d / mag2;
            this.f143x = (float) (((double) this.f143x) * invMag);
            this.f144y = (float) (((double) this.f144y) * invMag);
            this.f145z = (float) (((double) this.f145z) * invMag);
            return;
        }
        this.f143x = 0.0f;
        this.f144y = 1.0f;
        this.f145z = 0.0f;
        this.angle = 0.0f;
    }

    public final void set(Matrix3f m1) {
        this.f143x = m1.m21 - m1.m12;
        this.f144y = m1.m02 - m1.m20;
        this.f145z = m1.m10 - m1.m01;
        double mag = (double) ((this.f143x * this.f143x) + (this.f144y * this.f144y) + (this.f145z * this.f145z));
        if (mag > EPS) {
            double mag2 = Math.sqrt(mag);
            this.angle = (float) Math.atan2(0.5d * mag2, 0.5d * (((double) ((m1.m00 + m1.m11) + m1.m22)) - 1.0d));
            double invMag = 1.0d / mag2;
            this.f143x = (float) (((double) this.f143x) * invMag);
            this.f144y = (float) (((double) this.f144y) * invMag);
            this.f145z = (float) (((double) this.f145z) * invMag);
            return;
        }
        this.f143x = 0.0f;
        this.f144y = 1.0f;
        this.f145z = 0.0f;
        this.angle = 0.0f;
    }

    public final void set(Matrix3d m1) {
        this.f143x = (float) (m1.m21 - m1.m12);
        this.f144y = (float) (m1.m02 - m1.m20);
        this.f145z = (float) (m1.m10 - m1.m01);
        double mag = (double) ((this.f143x * this.f143x) + (this.f144y * this.f144y) + (this.f145z * this.f145z));
        if (mag > EPS) {
            double mag2 = Math.sqrt(mag);
            this.angle = (float) Math.atan2(0.5d * mag2, 0.5d * (((m1.m00 + m1.m11) + m1.m22) - 1.0d));
            double invMag = 1.0d / mag2;
            this.f143x = (float) (((double) this.f143x) * invMag);
            this.f144y = (float) (((double) this.f144y) * invMag);
            this.f145z = (float) (((double) this.f145z) * invMag);
            return;
        }
        this.f143x = 0.0f;
        this.f144y = 1.0f;
        this.f145z = 0.0f;
        this.angle = 0.0f;
    }

    public String toString() {
        return "(" + this.f143x + ", " + this.f144y + ", " + this.f145z + ", " + this.angle + ")";
    }

    public boolean equals(AxisAngle4f a1) {
        try {
            return this.f143x == a1.f143x && this.f144y == a1.f144y && this.f145z == a1.f145z && this.angle == a1.angle;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean equals(Object o1) {
        try {
            AxisAngle4f a2 = (AxisAngle4f) o1;
            if (this.f143x == a2.f143x && this.f144y == a2.f144y && this.f145z == a2.f145z && this.angle == a2.angle) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public boolean epsilonEquals(AxisAngle4f a1, float epsilon) {
        float f;
        float f2;
        float f3;
        float diff = this.f143x - a1.f143x;
        if (diff < 0.0f) {
            f = -diff;
        } else {
            f = diff;
        }
        if (f > epsilon) {
            return false;
        }
        float diff2 = this.f144y - a1.f144y;
        if ((diff2 < 0.0f ? -diff2 : diff2) > epsilon) {
            return false;
        }
        float diff3 = this.f145z - a1.f145z;
        if (diff3 < 0.0f) {
            f2 = -diff3;
        } else {
            f2 = diff3;
        }
        if (f2 > epsilon) {
            return false;
        }
        float diff4 = this.angle - a1.angle;
        if (diff4 < 0.0f) {
            f3 = -diff4;
        } else {
            f3 = diff4;
        }
        if (f3 <= epsilon) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long bits = (31 * ((31 * ((31 * ((31 * 1) + ((long) VecMathUtil.floatToIntBits(this.f143x)))) + ((long) VecMathUtil.floatToIntBits(this.f144y)))) + ((long) VecMathUtil.floatToIntBits(this.f145z)))) + ((long) VecMathUtil.floatToIntBits(this.angle));
        return (int) ((bits >> 32) ^ bits);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public final float getAngle() {
        return this.angle;
    }

    public final void setAngle(float angle2) {
        this.angle = angle2;
    }

    public final float getX() {
        return this.f143x;
    }

    public final void setX(float x) {
        this.f143x = x;
    }

    public final float getY() {
        return this.f144y;
    }

    public final void setY(float y) {
        this.f144y = y;
    }

    public final float getZ() {
        return this.f145z;
    }

    public final void setZ(float z) {
        this.f145z = z;
    }
}
