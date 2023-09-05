package javax.vecmath;

import com.github.mikephil.charting.utils.Utils;
import java.io.Serializable;

public class Quat4f extends Tuple4f implements Serializable {
    static final double EPS = 1.0E-6d;
    static final double EPS2 = 1.0E-30d;
    static final double PIO2 = 1.57079632679d;
    static final long serialVersionUID = 2675933778405442383L;

    public Quat4f(float x, float y, float z, float w) {
        float mag = (float) (1.0d / Math.sqrt((double) ((((x * x) + (y * y)) + (z * z)) + (w * w))));
        this.f173x = x * mag;
        this.f174y = y * mag;
        this.f175z = z * mag;
        this.f172w = w * mag;
    }

    public Quat4f(float[] q) {
        float mag = (float) (1.0d / Math.sqrt((double) ((((q[0] * q[0]) + (q[1] * q[1])) + (q[2] * q[2])) + (q[3] * q[3]))));
        this.f173x = q[0] * mag;
        this.f174y = q[1] * mag;
        this.f175z = q[2] * mag;
        this.f172w = q[3] * mag;
    }

    public Quat4f(Quat4f q1) {
        super((Tuple4f) q1);
    }

    public Quat4f(Quat4d q1) {
        super((Tuple4d) q1);
    }

    public Quat4f(Tuple4f t1) {
        float mag = (float) (1.0d / Math.sqrt((double) ((((t1.f173x * t1.f173x) + (t1.f174y * t1.f174y)) + (t1.f175z * t1.f175z)) + (t1.f172w * t1.f172w))));
        this.f173x = t1.f173x * mag;
        this.f174y = t1.f174y * mag;
        this.f175z = t1.f175z * mag;
        this.f172w = t1.f172w * mag;
    }

    public Quat4f(Tuple4d t1) {
        double mag = 1.0d / Math.sqrt((((t1.f169x * t1.f169x) + (t1.f170y * t1.f170y)) + (t1.f171z * t1.f171z)) + (t1.f168w * t1.f168w));
        this.f173x = (float) (t1.f169x * mag);
        this.f174y = (float) (t1.f170y * mag);
        this.f175z = (float) (t1.f171z * mag);
        this.f172w = (float) (t1.f168w * mag);
    }

    public Quat4f() {
    }

    public final void conjugate(Quat4f q1) {
        this.f173x = -q1.f173x;
        this.f174y = -q1.f174y;
        this.f175z = -q1.f175z;
        this.f172w = q1.f172w;
    }

    public final void conjugate() {
        this.f173x = -this.f173x;
        this.f174y = -this.f174y;
        this.f175z = -this.f175z;
    }

    public final void mul(Quat4f q1, Quat4f q2) {
        if (this == q1 || this == q2) {
            float w = (((q1.f172w * q2.f172w) - (q1.f173x * q2.f173x)) - (q1.f174y * q2.f174y)) - (q1.f175z * q2.f175z);
            float x = (((q1.f172w * q2.f173x) + (q2.f172w * q1.f173x)) + (q1.f174y * q2.f175z)) - (q1.f175z * q2.f174y);
            float y = (((q1.f172w * q2.f174y) + (q2.f172w * q1.f174y)) - (q1.f173x * q2.f175z)) + (q1.f175z * q2.f173x);
            this.f175z = (((q1.f172w * q2.f175z) + (q2.f172w * q1.f175z)) + (q1.f173x * q2.f174y)) - (q1.f174y * q2.f173x);
            this.f172w = w;
            this.f173x = x;
            this.f174y = y;
            return;
        }
        this.f172w = (((q1.f172w * q2.f172w) - (q1.f173x * q2.f173x)) - (q1.f174y * q2.f174y)) - (q1.f175z * q2.f175z);
        this.f173x = (((q1.f172w * q2.f173x) + (q2.f172w * q1.f173x)) + (q1.f174y * q2.f175z)) - (q1.f175z * q2.f174y);
        this.f174y = (((q1.f172w * q2.f174y) + (q2.f172w * q1.f174y)) - (q1.f173x * q2.f175z)) + (q1.f175z * q2.f173x);
        this.f175z = (((q1.f172w * q2.f175z) + (q2.f172w * q1.f175z)) + (q1.f173x * q2.f174y)) - (q1.f174y * q2.f173x);
    }

    public final void mul(Quat4f q1) {
        float w = (((this.f172w * q1.f172w) - (this.f173x * q1.f173x)) - (this.f174y * q1.f174y)) - (this.f175z * q1.f175z);
        float x = (((this.f172w * q1.f173x) + (q1.f172w * this.f173x)) + (this.f174y * q1.f175z)) - (this.f175z * q1.f174y);
        float y = (((this.f172w * q1.f174y) + (q1.f172w * this.f174y)) - (this.f173x * q1.f175z)) + (this.f175z * q1.f173x);
        this.f175z = (((this.f172w * q1.f175z) + (q1.f172w * this.f175z)) + (this.f173x * q1.f174y)) - (this.f174y * q1.f173x);
        this.f172w = w;
        this.f173x = x;
        this.f174y = y;
    }

    public final void mulInverse(Quat4f q1, Quat4f q2) {
        Quat4f tempQuat = new Quat4f(q2);
        tempQuat.inverse();
        mul(q1, tempQuat);
    }

    public final void mulInverse(Quat4f q1) {
        Quat4f tempQuat = new Quat4f(q1);
        tempQuat.inverse();
        mul(tempQuat);
    }

    public final void inverse(Quat4f q1) {
        float norm = 1.0f / ((((q1.f172w * q1.f172w) + (q1.f173x * q1.f173x)) + (q1.f174y * q1.f174y)) + (q1.f175z * q1.f175z));
        this.f172w = q1.f172w * norm;
        this.f173x = (-norm) * q1.f173x;
        this.f174y = (-norm) * q1.f174y;
        this.f175z = (-norm) * q1.f175z;
    }

    public final void inverse() {
        float norm = 1.0f / ((((this.f172w * this.f172w) + (this.f173x * this.f173x)) + (this.f174y * this.f174y)) + (this.f175z * this.f175z));
        this.f172w *= norm;
        this.f173x *= -norm;
        this.f174y *= -norm;
        this.f175z *= -norm;
    }

    public final void normalize(Quat4f q1) {
        float norm = (q1.f173x * q1.f173x) + (q1.f174y * q1.f174y) + (q1.f175z * q1.f175z) + (q1.f172w * q1.f172w);
        if (norm > 0.0f) {
            float norm2 = 1.0f / ((float) Math.sqrt((double) norm));
            this.f173x = q1.f173x * norm2;
            this.f174y = q1.f174y * norm2;
            this.f175z = q1.f175z * norm2;
            this.f172w = q1.f172w * norm2;
            return;
        }
        this.f173x = 0.0f;
        this.f174y = 0.0f;
        this.f175z = 0.0f;
        this.f172w = 0.0f;
    }

    public final void normalize() {
        float norm = (this.f173x * this.f173x) + (this.f174y * this.f174y) + (this.f175z * this.f175z) + (this.f172w * this.f172w);
        if (norm > 0.0f) {
            float norm2 = 1.0f / ((float) Math.sqrt((double) norm));
            this.f173x *= norm2;
            this.f174y *= norm2;
            this.f175z *= norm2;
            this.f172w *= norm2;
            return;
        }
        this.f173x = 0.0f;
        this.f174y = 0.0f;
        this.f175z = 0.0f;
        this.f172w = 0.0f;
    }

    public final void set(Matrix4f m1) {
        float ww = 0.25f * (m1.m00 + m1.m11 + m1.m22 + m1.m33);
        if (ww < 0.0f) {
            this.f172w = 0.0f;
            this.f173x = 0.0f;
            this.f174y = 0.0f;
            this.f175z = 1.0f;
        } else if (((double) ww) >= EPS2) {
            this.f172w = (float) Math.sqrt((double) ww);
            float ww2 = 0.25f / this.f172w;
            this.f173x = (m1.m21 - m1.m12) * ww2;
            this.f174y = (m1.m02 - m1.m20) * ww2;
            this.f175z = (m1.m10 - m1.m01) * ww2;
        } else {
            this.f172w = 0.0f;
            float ww3 = -0.5f * (m1.m11 + m1.m22);
            if (ww3 < 0.0f) {
                this.f173x = 0.0f;
                this.f174y = 0.0f;
                this.f175z = 1.0f;
            } else if (((double) ww3) >= EPS2) {
                this.f173x = (float) Math.sqrt((double) ww3);
                float ww4 = 1.0f / (this.f173x * 2.0f);
                this.f174y = m1.m10 * ww4;
                this.f175z = m1.m20 * ww4;
            } else {
                this.f173x = 0.0f;
                float ww5 = 0.5f * (1.0f - m1.m22);
                if (((double) ww5) >= EPS2) {
                    this.f174y = (float) Math.sqrt((double) ww5);
                    this.f175z = m1.m21 / (this.f174y * 2.0f);
                    return;
                }
                this.f174y = 0.0f;
                this.f175z = 1.0f;
            }
        }
    }

    public final void set(Matrix4d m1) {
        double ww = 0.25d * (m1.m00 + m1.m11 + m1.m22 + m1.m33);
        if (ww < Utils.DOUBLE_EPSILON) {
            this.f172w = 0.0f;
            this.f173x = 0.0f;
            this.f174y = 0.0f;
            this.f175z = 1.0f;
        } else if (ww >= EPS2) {
            this.f172w = (float) Math.sqrt(ww);
            double ww2 = 0.25d / ((double) this.f172w);
            this.f173x = (float) ((m1.m21 - m1.m12) * ww2);
            this.f174y = (float) ((m1.m02 - m1.m20) * ww2);
            this.f175z = (float) ((m1.m10 - m1.m01) * ww2);
        } else {
            this.f172w = 0.0f;
            double ww3 = -0.5d * (m1.m11 + m1.m22);
            if (ww3 < Utils.DOUBLE_EPSILON) {
                this.f173x = 0.0f;
                this.f174y = 0.0f;
                this.f175z = 1.0f;
            } else if (ww3 >= EPS2) {
                this.f173x = (float) Math.sqrt(ww3);
                double ww4 = 0.5d / ((double) this.f173x);
                this.f174y = (float) (m1.m10 * ww4);
                this.f175z = (float) (m1.m20 * ww4);
            } else {
                this.f173x = 0.0f;
                double ww5 = 0.5d * (1.0d - m1.m22);
                if (ww5 >= EPS2) {
                    this.f174y = (float) Math.sqrt(ww5);
                    this.f175z = (float) (m1.m21 / (2.0d * ((double) this.f174y)));
                    return;
                }
                this.f174y = 0.0f;
                this.f175z = 1.0f;
            }
        }
    }

    public final void set(Matrix3f m1) {
        float ww = 0.25f * (m1.m00 + m1.m11 + m1.m22 + 1.0f);
        if (ww < 0.0f) {
            this.f172w = 0.0f;
            this.f173x = 0.0f;
            this.f174y = 0.0f;
            this.f175z = 1.0f;
        } else if (((double) ww) >= EPS2) {
            this.f172w = (float) Math.sqrt((double) ww);
            float ww2 = 0.25f / this.f172w;
            this.f173x = (m1.m21 - m1.m12) * ww2;
            this.f174y = (m1.m02 - m1.m20) * ww2;
            this.f175z = (m1.m10 - m1.m01) * ww2;
        } else {
            this.f172w = 0.0f;
            float ww3 = -0.5f * (m1.m11 + m1.m22);
            if (ww3 < 0.0f) {
                this.f173x = 0.0f;
                this.f174y = 0.0f;
                this.f175z = 1.0f;
            } else if (((double) ww3) >= EPS2) {
                this.f173x = (float) Math.sqrt((double) ww3);
                float ww4 = 0.5f / this.f173x;
                this.f174y = m1.m10 * ww4;
                this.f175z = m1.m20 * ww4;
            } else {
                this.f173x = 0.0f;
                float ww5 = 0.5f * (1.0f - m1.m22);
                if (((double) ww5) >= EPS2) {
                    this.f174y = (float) Math.sqrt((double) ww5);
                    this.f175z = m1.m21 / (2.0f * this.f174y);
                    return;
                }
                this.f174y = 0.0f;
                this.f175z = 1.0f;
            }
        }
    }

    public final void set(Matrix3d m1) {
        double ww = 0.25d * (m1.m00 + m1.m11 + m1.m22 + 1.0d);
        if (ww < Utils.DOUBLE_EPSILON) {
            this.f172w = 0.0f;
            this.f173x = 0.0f;
            this.f174y = 0.0f;
            this.f175z = 1.0f;
        } else if (ww >= EPS2) {
            this.f172w = (float) Math.sqrt(ww);
            double ww2 = 0.25d / ((double) this.f172w);
            this.f173x = (float) ((m1.m21 - m1.m12) * ww2);
            this.f174y = (float) ((m1.m02 - m1.m20) * ww2);
            this.f175z = (float) ((m1.m10 - m1.m01) * ww2);
        } else {
            this.f172w = 0.0f;
            double ww3 = -0.5d * (m1.m11 + m1.m22);
            if (ww3 < Utils.DOUBLE_EPSILON) {
                this.f173x = 0.0f;
                this.f174y = 0.0f;
                this.f175z = 1.0f;
            } else if (ww3 >= EPS2) {
                this.f173x = (float) Math.sqrt(ww3);
                double ww4 = 0.5d / ((double) this.f173x);
                this.f174y = (float) (m1.m10 * ww4);
                this.f175z = (float) (m1.m20 * ww4);
            } else {
                this.f173x = 0.0f;
                double ww5 = 0.5d * (1.0d - m1.m22);
                if (ww5 >= EPS2) {
                    this.f174y = (float) Math.sqrt(ww5);
                    this.f175z = (float) (m1.m21 / (2.0d * ((double) this.f174y)));
                    return;
                }
                this.f174y = 0.0f;
                this.f175z = 1.0f;
            }
        }
    }

    public final void set(AxisAngle4f a) {
        float amag = (float) Math.sqrt((double) ((a.f143x * a.f143x) + (a.f144y * a.f144y) + (a.f145z * a.f145z)));
        if (((double) amag) < EPS) {
            this.f172w = 0.0f;
            this.f173x = 0.0f;
            this.f174y = 0.0f;
            this.f175z = 0.0f;
            return;
        }
        float amag2 = 1.0f / amag;
        float mag = (float) Math.sin(((double) a.angle) / 2.0d);
        this.f172w = (float) Math.cos(((double) a.angle) / 2.0d);
        this.f173x = a.f143x * amag2 * mag;
        this.f174y = a.f144y * amag2 * mag;
        this.f175z = a.f145z * amag2 * mag;
    }

    public final void set(AxisAngle4d a) {
        float amag = (float) (1.0d / Math.sqrt(((a.f140x * a.f140x) + (a.f141y * a.f141y)) + (a.f142z * a.f142z)));
        if (((double) amag) < EPS) {
            this.f172w = 0.0f;
            this.f173x = 0.0f;
            this.f174y = 0.0f;
            this.f175z = 0.0f;
            return;
        }
        float amag2 = 1.0f / amag;
        float mag = (float) Math.sin(a.angle / 2.0d);
        this.f172w = (float) Math.cos(a.angle / 2.0d);
        this.f173x = ((float) a.f140x) * amag2 * mag;
        this.f174y = ((float) a.f141y) * amag2 * mag;
        this.f175z = ((float) a.f142z) * amag2 * mag;
    }

    public final void interpolate(Quat4f q1, float alpha) {
        double s1;
        double s2;
        double dot = (double) ((this.f173x * q1.f173x) + (this.f174y * q1.f174y) + (this.f175z * q1.f175z) + (this.f172w * q1.f172w));
        if (dot < Utils.DOUBLE_EPSILON) {
            q1.f173x = -q1.f173x;
            q1.f174y = -q1.f174y;
            q1.f175z = -q1.f175z;
            q1.f172w = -q1.f172w;
            dot = -dot;
        }
        if (1.0d - dot > EPS) {
            double om = Math.acos(dot);
            double sinom = Math.sin(om);
            s1 = Math.sin((1.0d - ((double) alpha)) * om) / sinom;
            s2 = Math.sin(((double) alpha) * om) / sinom;
        } else {
            s1 = 1.0d - ((double) alpha);
            s2 = (double) alpha;
        }
        this.f172w = (float) ((((double) this.f172w) * s1) + (((double) q1.f172w) * s2));
        this.f173x = (float) ((((double) this.f173x) * s1) + (((double) q1.f173x) * s2));
        this.f174y = (float) ((((double) this.f174y) * s1) + (((double) q1.f174y) * s2));
        this.f175z = (float) ((((double) this.f175z) * s1) + (((double) q1.f175z) * s2));
    }

    public final void interpolate(Quat4f q1, Quat4f q2, float alpha) {
        double s1;
        double s2;
        double dot = (double) ((q2.f173x * q1.f173x) + (q2.f174y * q1.f174y) + (q2.f175z * q1.f175z) + (q2.f172w * q1.f172w));
        if (dot < Utils.DOUBLE_EPSILON) {
            q1.f173x = -q1.f173x;
            q1.f174y = -q1.f174y;
            q1.f175z = -q1.f175z;
            q1.f172w = -q1.f172w;
            dot = -dot;
        }
        if (1.0d - dot > EPS) {
            double om = Math.acos(dot);
            double sinom = Math.sin(om);
            s1 = Math.sin((1.0d - ((double) alpha)) * om) / sinom;
            s2 = Math.sin(((double) alpha) * om) / sinom;
        } else {
            s1 = 1.0d - ((double) alpha);
            s2 = (double) alpha;
        }
        this.f172w = (float) ((((double) q1.f172w) * s1) + (((double) q2.f172w) * s2));
        this.f173x = (float) ((((double) q1.f173x) * s1) + (((double) q2.f173x) * s2));
        this.f174y = (float) ((((double) q1.f174y) * s1) + (((double) q2.f174y) * s2));
        this.f175z = (float) ((((double) q1.f175z) * s1) + (((double) q2.f175z) * s2));
    }
}
