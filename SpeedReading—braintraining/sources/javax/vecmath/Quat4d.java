package javax.vecmath;

import com.github.mikephil.charting.utils.Utils;
import java.io.Serializable;

public class Quat4d extends Tuple4d implements Serializable {
    static final double EPS = 1.0E-12d;
    static final double EPS2 = 1.0E-30d;
    static final double PIO2 = 1.57079632679d;
    static final long serialVersionUID = 7577479888820201099L;

    public Quat4d(double x, double y, double z, double w) {
        double mag = 1.0d / Math.sqrt((((x * x) + (y * y)) + (z * z)) + (w * w));
        this.f169x = x * mag;
        this.f170y = y * mag;
        this.f171z = z * mag;
        this.f168w = w * mag;
    }

    public Quat4d(double[] q) {
        double mag = 1.0d / Math.sqrt((((q[0] * q[0]) + (q[1] * q[1])) + (q[2] * q[2])) + (q[3] * q[3]));
        this.f169x = q[0] * mag;
        this.f170y = q[1] * mag;
        this.f171z = q[2] * mag;
        this.f168w = q[3] * mag;
    }

    public Quat4d(Quat4d q1) {
        super((Tuple4d) q1);
    }

    public Quat4d(Quat4f q1) {
        super((Tuple4f) q1);
    }

    public Quat4d(Tuple4f t1) {
        double mag = 1.0d / Math.sqrt((double) ((((t1.f173x * t1.f173x) + (t1.f174y * t1.f174y)) + (t1.f175z * t1.f175z)) + (t1.f172w * t1.f172w)));
        this.f169x = ((double) t1.f173x) * mag;
        this.f170y = ((double) t1.f174y) * mag;
        this.f171z = ((double) t1.f175z) * mag;
        this.f168w = ((double) t1.f172w) * mag;
    }

    public Quat4d(Tuple4d t1) {
        double mag = 1.0d / Math.sqrt((((t1.f169x * t1.f169x) + (t1.f170y * t1.f170y)) + (t1.f171z * t1.f171z)) + (t1.f168w * t1.f168w));
        this.f169x = t1.f169x * mag;
        this.f170y = t1.f170y * mag;
        this.f171z = t1.f171z * mag;
        this.f168w = t1.f168w * mag;
    }

    public Quat4d() {
    }

    public final void conjugate(Quat4d q1) {
        this.f169x = -q1.f169x;
        this.f170y = -q1.f170y;
        this.f171z = -q1.f171z;
        this.f168w = q1.f168w;
    }

    public final void conjugate() {
        this.f169x = -this.f169x;
        this.f170y = -this.f170y;
        this.f171z = -this.f171z;
    }

    public final void mul(Quat4d q1, Quat4d q2) {
        if (this == q1 || this == q2) {
            double w = (((q1.f168w * q2.f168w) - (q1.f169x * q2.f169x)) - (q1.f170y * q2.f170y)) - (q1.f171z * q2.f171z);
            double x = (((q1.f168w * q2.f169x) + (q2.f168w * q1.f169x)) + (q1.f170y * q2.f171z)) - (q1.f171z * q2.f170y);
            double y = (((q1.f168w * q2.f170y) + (q2.f168w * q1.f170y)) - (q1.f169x * q2.f171z)) + (q1.f171z * q2.f169x);
            this.f171z = (((q1.f168w * q2.f171z) + (q2.f168w * q1.f171z)) + (q1.f169x * q2.f170y)) - (q1.f170y * q2.f169x);
            this.f168w = w;
            this.f169x = x;
            this.f170y = y;
            return;
        }
        this.f168w = (((q1.f168w * q2.f168w) - (q1.f169x * q2.f169x)) - (q1.f170y * q2.f170y)) - (q1.f171z * q2.f171z);
        this.f169x = (((q1.f168w * q2.f169x) + (q2.f168w * q1.f169x)) + (q1.f170y * q2.f171z)) - (q1.f171z * q2.f170y);
        this.f170y = (((q1.f168w * q2.f170y) + (q2.f168w * q1.f170y)) - (q1.f169x * q2.f171z)) + (q1.f171z * q2.f169x);
        this.f171z = (((q1.f168w * q2.f171z) + (q2.f168w * q1.f171z)) + (q1.f169x * q2.f170y)) - (q1.f170y * q2.f169x);
    }

    public final void mul(Quat4d q1) {
        double w = (((this.f168w * q1.f168w) - (this.f169x * q1.f169x)) - (this.f170y * q1.f170y)) - (this.f171z * q1.f171z);
        double x = (((this.f168w * q1.f169x) + (q1.f168w * this.f169x)) + (this.f170y * q1.f171z)) - (this.f171z * q1.f170y);
        double y = (((this.f168w * q1.f170y) + (q1.f168w * this.f170y)) - (this.f169x * q1.f171z)) + (this.f171z * q1.f169x);
        this.f171z = (((this.f168w * q1.f171z) + (q1.f168w * this.f171z)) + (this.f169x * q1.f170y)) - (this.f170y * q1.f169x);
        this.f168w = w;
        this.f169x = x;
        this.f170y = y;
    }

    public final void mulInverse(Quat4d q1, Quat4d q2) {
        Quat4d tempQuat = new Quat4d(q2);
        tempQuat.inverse();
        mul(q1, tempQuat);
    }

    public final void mulInverse(Quat4d q1) {
        Quat4d tempQuat = new Quat4d(q1);
        tempQuat.inverse();
        mul(tempQuat);
    }

    public final void inverse(Quat4d q1) {
        double norm = 1.0d / ((((q1.f168w * q1.f168w) + (q1.f169x * q1.f169x)) + (q1.f170y * q1.f170y)) + (q1.f171z * q1.f171z));
        this.f168w = q1.f168w * norm;
        this.f169x = (-norm) * q1.f169x;
        this.f170y = (-norm) * q1.f170y;
        this.f171z = (-norm) * q1.f171z;
    }

    public final void inverse() {
        double norm = 1.0d / ((((this.f168w * this.f168w) + (this.f169x * this.f169x)) + (this.f170y * this.f170y)) + (this.f171z * this.f171z));
        this.f168w *= norm;
        this.f169x *= -norm;
        this.f170y *= -norm;
        this.f171z *= -norm;
    }

    public final void normalize(Quat4d q1) {
        double norm = (q1.f169x * q1.f169x) + (q1.f170y * q1.f170y) + (q1.f171z * q1.f171z) + (q1.f168w * q1.f168w);
        if (norm > Utils.DOUBLE_EPSILON) {
            double norm2 = 1.0d / Math.sqrt(norm);
            this.f169x = q1.f169x * norm2;
            this.f170y = q1.f170y * norm2;
            this.f171z = q1.f171z * norm2;
            this.f168w = q1.f168w * norm2;
            return;
        }
        this.f169x = Utils.DOUBLE_EPSILON;
        this.f170y = Utils.DOUBLE_EPSILON;
        this.f171z = Utils.DOUBLE_EPSILON;
        this.f168w = Utils.DOUBLE_EPSILON;
    }

    public final void normalize() {
        double norm = (this.f169x * this.f169x) + (this.f170y * this.f170y) + (this.f171z * this.f171z) + (this.f168w * this.f168w);
        if (norm > Utils.DOUBLE_EPSILON) {
            double norm2 = 1.0d / Math.sqrt(norm);
            this.f169x *= norm2;
            this.f170y *= norm2;
            this.f171z *= norm2;
            this.f168w *= norm2;
            return;
        }
        this.f169x = Utils.DOUBLE_EPSILON;
        this.f170y = Utils.DOUBLE_EPSILON;
        this.f171z = Utils.DOUBLE_EPSILON;
        this.f168w = Utils.DOUBLE_EPSILON;
    }

    public final void set(Matrix4f m1) {
        double ww = 0.25d * ((double) (m1.m00 + m1.m11 + m1.m22 + m1.m33));
        if (ww < Utils.DOUBLE_EPSILON) {
            this.f168w = Utils.DOUBLE_EPSILON;
            this.f169x = Utils.DOUBLE_EPSILON;
            this.f170y = Utils.DOUBLE_EPSILON;
            this.f171z = 1.0d;
        } else if (ww >= EPS2) {
            this.f168w = Math.sqrt(ww);
            double ww2 = 0.25d / this.f168w;
            this.f169x = ((double) (m1.m21 - m1.m12)) * ww2;
            this.f170y = ((double) (m1.m02 - m1.m20)) * ww2;
            this.f171z = ((double) (m1.m10 - m1.m01)) * ww2;
        } else {
            this.f168w = Utils.DOUBLE_EPSILON;
            double ww3 = -0.5d * ((double) (m1.m11 + m1.m22));
            if (ww3 < Utils.DOUBLE_EPSILON) {
                this.f169x = Utils.DOUBLE_EPSILON;
                this.f170y = Utils.DOUBLE_EPSILON;
                this.f171z = 1.0d;
            } else if (ww3 >= EPS2) {
                this.f169x = Math.sqrt(ww3);
                double ww4 = 1.0d / (this.f169x * 2.0d);
                this.f170y = ((double) m1.m10) * ww4;
                this.f171z = ((double) m1.m20) * ww4;
            } else {
                this.f169x = Utils.DOUBLE_EPSILON;
                double ww5 = 0.5d * (1.0d - ((double) m1.m22));
                if (ww5 >= EPS2) {
                    this.f170y = Math.sqrt(ww5);
                    this.f171z = ((double) m1.m21) / (this.f170y * 2.0d);
                    return;
                }
                this.f170y = Utils.DOUBLE_EPSILON;
                this.f171z = 1.0d;
            }
        }
    }

    public final void set(Matrix4d m1) {
        double ww = 0.25d * (m1.m00 + m1.m11 + m1.m22 + m1.m33);
        if (ww < Utils.DOUBLE_EPSILON) {
            this.f168w = Utils.DOUBLE_EPSILON;
            this.f169x = Utils.DOUBLE_EPSILON;
            this.f170y = Utils.DOUBLE_EPSILON;
            this.f171z = 1.0d;
        } else if (ww >= EPS2) {
            this.f168w = Math.sqrt(ww);
            double ww2 = 0.25d / this.f168w;
            this.f169x = (m1.m21 - m1.m12) * ww2;
            this.f170y = (m1.m02 - m1.m20) * ww2;
            this.f171z = (m1.m10 - m1.m01) * ww2;
        } else {
            this.f168w = Utils.DOUBLE_EPSILON;
            double ww3 = -0.5d * (m1.m11 + m1.m22);
            if (ww3 < Utils.DOUBLE_EPSILON) {
                this.f169x = Utils.DOUBLE_EPSILON;
                this.f170y = Utils.DOUBLE_EPSILON;
                this.f171z = 1.0d;
            } else if (ww3 >= EPS2) {
                this.f169x = Math.sqrt(ww3);
                double ww4 = 0.5d / this.f169x;
                this.f170y = m1.m10 * ww4;
                this.f171z = m1.m20 * ww4;
            } else {
                this.f169x = Utils.DOUBLE_EPSILON;
                double ww5 = 0.5d * (1.0d - m1.m22);
                if (ww5 >= EPS2) {
                    this.f170y = Math.sqrt(ww5);
                    this.f171z = m1.m21 / (2.0d * this.f170y);
                    return;
                }
                this.f170y = Utils.DOUBLE_EPSILON;
                this.f171z = 1.0d;
            }
        }
    }

    public final void set(Matrix3f m1) {
        double ww = 0.25d * (((double) (m1.m00 + m1.m11 + m1.m22)) + 1.0d);
        if (ww < Utils.DOUBLE_EPSILON) {
            this.f168w = Utils.DOUBLE_EPSILON;
            this.f169x = Utils.DOUBLE_EPSILON;
            this.f170y = Utils.DOUBLE_EPSILON;
            this.f171z = 1.0d;
        } else if (ww >= EPS2) {
            this.f168w = Math.sqrt(ww);
            double ww2 = 0.25d / this.f168w;
            this.f169x = ((double) (m1.m21 - m1.m12)) * ww2;
            this.f170y = ((double) (m1.m02 - m1.m20)) * ww2;
            this.f171z = ((double) (m1.m10 - m1.m01)) * ww2;
        } else {
            this.f168w = Utils.DOUBLE_EPSILON;
            double ww3 = -0.5d * ((double) (m1.m11 + m1.m22));
            if (ww3 < Utils.DOUBLE_EPSILON) {
                this.f169x = Utils.DOUBLE_EPSILON;
                this.f170y = Utils.DOUBLE_EPSILON;
                this.f171z = 1.0d;
            } else if (ww3 >= EPS2) {
                this.f169x = Math.sqrt(ww3);
                double ww4 = 0.5d / this.f169x;
                this.f170y = ((double) m1.m10) * ww4;
                this.f171z = ((double) m1.m20) * ww4;
            } else {
                this.f169x = Utils.DOUBLE_EPSILON;
                double ww5 = 0.5d * (1.0d - ((double) m1.m22));
                if (ww5 >= EPS2) {
                    this.f170y = Math.sqrt(ww5);
                    this.f171z = ((double) m1.m21) / (2.0d * this.f170y);
                }
                this.f170y = Utils.DOUBLE_EPSILON;
                this.f171z = 1.0d;
            }
        }
    }

    public final void set(Matrix3d m1) {
        double ww = 0.25d * (m1.m00 + m1.m11 + m1.m22 + 1.0d);
        if (ww < Utils.DOUBLE_EPSILON) {
            this.f168w = Utils.DOUBLE_EPSILON;
            this.f169x = Utils.DOUBLE_EPSILON;
            this.f170y = Utils.DOUBLE_EPSILON;
            this.f171z = 1.0d;
        } else if (ww >= EPS2) {
            this.f168w = Math.sqrt(ww);
            double ww2 = 0.25d / this.f168w;
            this.f169x = (m1.m21 - m1.m12) * ww2;
            this.f170y = (m1.m02 - m1.m20) * ww2;
            this.f171z = (m1.m10 - m1.m01) * ww2;
        } else {
            this.f168w = Utils.DOUBLE_EPSILON;
            double ww3 = -0.5d * (m1.m11 + m1.m22);
            if (ww3 < Utils.DOUBLE_EPSILON) {
                this.f169x = Utils.DOUBLE_EPSILON;
                this.f170y = Utils.DOUBLE_EPSILON;
                this.f171z = 1.0d;
            } else if (ww3 >= EPS2) {
                this.f169x = Math.sqrt(ww3);
                double ww4 = 0.5d / this.f169x;
                this.f170y = m1.m10 * ww4;
                this.f171z = m1.m20 * ww4;
            } else {
                this.f169x = Utils.DOUBLE_EPSILON;
                double ww5 = 0.5d * (1.0d - m1.m22);
                if (ww5 >= EPS2) {
                    this.f170y = Math.sqrt(ww5);
                    this.f171z = m1.m21 / (2.0d * this.f170y);
                    return;
                }
                this.f170y = Utils.DOUBLE_EPSILON;
                this.f171z = 1.0d;
            }
        }
    }

    public final void set(AxisAngle4f a) {
        double amag = Math.sqrt((double) ((a.f143x * a.f143x) + (a.f144y * a.f144y) + (a.f145z * a.f145z)));
        if (amag < EPS) {
            this.f168w = Utils.DOUBLE_EPSILON;
            this.f169x = Utils.DOUBLE_EPSILON;
            this.f170y = Utils.DOUBLE_EPSILON;
            this.f171z = Utils.DOUBLE_EPSILON;
            return;
        }
        double mag = Math.sin(((double) a.angle) / 2.0d);
        double amag2 = 1.0d / amag;
        this.f168w = Math.cos(((double) a.angle) / 2.0d);
        this.f169x = ((double) a.f143x) * amag2 * mag;
        this.f170y = ((double) a.f144y) * amag2 * mag;
        this.f171z = ((double) a.f145z) * amag2 * mag;
    }

    public final void set(AxisAngle4d a) {
        double amag = Math.sqrt((a.f140x * a.f140x) + (a.f141y * a.f141y) + (a.f142z * a.f142z));
        if (amag < EPS) {
            this.f168w = Utils.DOUBLE_EPSILON;
            this.f169x = Utils.DOUBLE_EPSILON;
            this.f170y = Utils.DOUBLE_EPSILON;
            this.f171z = Utils.DOUBLE_EPSILON;
            return;
        }
        double amag2 = 1.0d / amag;
        double mag = Math.sin(a.angle / 2.0d);
        this.f168w = Math.cos(a.angle / 2.0d);
        this.f169x = a.f140x * amag2 * mag;
        this.f170y = a.f141y * amag2 * mag;
        this.f171z = a.f142z * amag2 * mag;
    }

    public final void interpolate(Quat4d q1, double alpha) {
        double s1;
        double s2;
        double dot = (this.f169x * q1.f169x) + (this.f170y * q1.f170y) + (this.f171z * q1.f171z) + (this.f168w * q1.f168w);
        if (dot < Utils.DOUBLE_EPSILON) {
            q1.f169x = -q1.f169x;
            q1.f170y = -q1.f170y;
            q1.f171z = -q1.f171z;
            q1.f168w = -q1.f168w;
            dot = -dot;
        }
        if (1.0d - dot > EPS) {
            double om = Math.acos(dot);
            double sinom = Math.sin(om);
            s1 = Math.sin((1.0d - alpha) * om) / sinom;
            s2 = Math.sin(alpha * om) / sinom;
        } else {
            s1 = 1.0d - alpha;
            s2 = alpha;
        }
        this.f168w = (this.f168w * s1) + (q1.f168w * s2);
        this.f169x = (this.f169x * s1) + (q1.f169x * s2);
        this.f170y = (this.f170y * s1) + (q1.f170y * s2);
        this.f171z = (this.f171z * s1) + (q1.f171z * s2);
    }

    public final void interpolate(Quat4d q1, Quat4d q2, double alpha) {
        double s1;
        double s2;
        double dot = (q2.f169x * q1.f169x) + (q2.f170y * q1.f170y) + (q2.f171z * q1.f171z) + (q2.f168w * q1.f168w);
        if (dot < Utils.DOUBLE_EPSILON) {
            q1.f169x = -q1.f169x;
            q1.f170y = -q1.f170y;
            q1.f171z = -q1.f171z;
            q1.f168w = -q1.f168w;
            dot = -dot;
        }
        if (1.0d - dot > EPS) {
            double om = Math.acos(dot);
            double sinom = Math.sin(om);
            s1 = Math.sin((1.0d - alpha) * om) / sinom;
            s2 = Math.sin(alpha * om) / sinom;
        } else {
            s1 = 1.0d - alpha;
            s2 = alpha;
        }
        this.f168w = (q1.f168w * s1) + (q2.f168w * s2);
        this.f169x = (q1.f169x * s1) + (q2.f169x * s2);
        this.f170y = (q1.f170y * s1) + (q2.f170y * s2);
        this.f171z = (q1.f171z * s1) + (q2.f171z * s2);
    }
}
