package javax.vecmath;

import com.github.mikephil.charting.utils.Utils;
import java.io.Serializable;

public class Matrix4f implements Serializable, Cloneable {
    private static final double EPS = 1.0E-8d;
    static final long serialVersionUID = -8405036035410109353L;
    public float m00;
    public float m01;
    public float m02;
    public float m03;
    public float m10;
    public float m11;
    public float m12;
    public float m13;
    public float m20;
    public float m21;
    public float m22;
    public float m23;
    public float m30;
    public float m31;
    public float m32;
    public float m33;

    public Matrix4f(float m002, float m012, float m022, float m032, float m102, float m112, float m122, float m132, float m202, float m212, float m222, float m232, float m302, float m312, float m322, float m332) {
        this.m00 = m002;
        this.m01 = m012;
        this.m02 = m022;
        this.m03 = m032;
        this.m10 = m102;
        this.m11 = m112;
        this.m12 = m122;
        this.m13 = m132;
        this.m20 = m202;
        this.m21 = m212;
        this.m22 = m222;
        this.m23 = m232;
        this.m30 = m302;
        this.m31 = m312;
        this.m32 = m322;
        this.m33 = m332;
    }

    public Matrix4f(float[] v) {
        this.m00 = v[0];
        this.m01 = v[1];
        this.m02 = v[2];
        this.m03 = v[3];
        this.m10 = v[4];
        this.m11 = v[5];
        this.m12 = v[6];
        this.m13 = v[7];
        this.m20 = v[8];
        this.m21 = v[9];
        this.m22 = v[10];
        this.m23 = v[11];
        this.m30 = v[12];
        this.m31 = v[13];
        this.m32 = v[14];
        this.m33 = v[15];
    }

    public Matrix4f(Quat4f q1, Vector3f t1, float s) {
        this.m00 = (float) (((double) s) * ((1.0d - ((2.0d * ((double) q1.f174y)) * ((double) q1.f174y))) - ((2.0d * ((double) q1.f175z)) * ((double) q1.f175z))));
        this.m10 = (float) (((double) s) * 2.0d * ((double) ((q1.f173x * q1.f174y) + (q1.f172w * q1.f175z))));
        this.m20 = (float) (((double) s) * 2.0d * ((double) ((q1.f173x * q1.f175z) - (q1.f172w * q1.f174y))));
        this.m01 = (float) (((double) s) * 2.0d * ((double) ((q1.f173x * q1.f174y) - (q1.f172w * q1.f175z))));
        this.m11 = (float) (((double) s) * ((1.0d - ((2.0d * ((double) q1.f173x)) * ((double) q1.f173x))) - ((2.0d * ((double) q1.f175z)) * ((double) q1.f175z))));
        this.m21 = (float) (((double) s) * 2.0d * ((double) ((q1.f174y * q1.f175z) + (q1.f172w * q1.f173x))));
        this.m02 = (float) (((double) s) * 2.0d * ((double) ((q1.f173x * q1.f175z) + (q1.f172w * q1.f174y))));
        this.m12 = (float) (((double) s) * 2.0d * ((double) ((q1.f174y * q1.f175z) - (q1.f172w * q1.f173x))));
        this.m22 = (float) (((double) s) * ((1.0d - ((2.0d * ((double) q1.f173x)) * ((double) q1.f173x))) - ((2.0d * ((double) q1.f174y)) * ((double) q1.f174y))));
        this.m03 = t1.f158x;
        this.m13 = t1.f159y;
        this.m23 = t1.f160z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public Matrix4f(Matrix4d m1) {
        this.m00 = (float) m1.m00;
        this.m01 = (float) m1.m01;
        this.m02 = (float) m1.m02;
        this.m03 = (float) m1.m03;
        this.m10 = (float) m1.m10;
        this.m11 = (float) m1.m11;
        this.m12 = (float) m1.m12;
        this.m13 = (float) m1.m13;
        this.m20 = (float) m1.m20;
        this.m21 = (float) m1.m21;
        this.m22 = (float) m1.m22;
        this.m23 = (float) m1.m23;
        this.m30 = (float) m1.m30;
        this.m31 = (float) m1.m31;
        this.m32 = (float) m1.m32;
        this.m33 = (float) m1.m33;
    }

    public Matrix4f(Matrix4f m1) {
        this.m00 = m1.m00;
        this.m01 = m1.m01;
        this.m02 = m1.m02;
        this.m03 = m1.m03;
        this.m10 = m1.m10;
        this.m11 = m1.m11;
        this.m12 = m1.m12;
        this.m13 = m1.m13;
        this.m20 = m1.m20;
        this.m21 = m1.m21;
        this.m22 = m1.m22;
        this.m23 = m1.m23;
        this.m30 = m1.m30;
        this.m31 = m1.m31;
        this.m32 = m1.m32;
        this.m33 = m1.m33;
    }

    public Matrix4f(Matrix3f m1, Vector3f t1, float s) {
        this.m00 = m1.m00 * s;
        this.m01 = m1.m01 * s;
        this.m02 = m1.m02 * s;
        this.m03 = t1.f158x;
        this.m10 = m1.m10 * s;
        this.m11 = m1.m11 * s;
        this.m12 = m1.m12 * s;
        this.m13 = t1.f159y;
        this.m20 = m1.m20 * s;
        this.m21 = m1.m21 * s;
        this.m22 = m1.m22 * s;
        this.m23 = t1.f160z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public Matrix4f() {
        this.m00 = 0.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 0.0f;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 0.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 0.0f;
    }

    public String toString() {
        return this.m00 + ", " + this.m01 + ", " + this.m02 + ", " + this.m03 + "\n" + this.m10 + ", " + this.m11 + ", " + this.m12 + ", " + this.m13 + "\n" + this.m20 + ", " + this.m21 + ", " + this.m22 + ", " + this.m23 + "\n" + this.m30 + ", " + this.m31 + ", " + this.m32 + ", " + this.m33 + "\n";
    }

    public final void setIdentity() {
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 1.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void setElement(int row, int column, float value) {
        switch (row) {
            case 0:
                switch (column) {
                    case 0:
                        this.m00 = value;
                        return;
                    case 1:
                        this.m01 = value;
                        return;
                    case 2:
                        this.m02 = value;
                        return;
                    case 3:
                        this.m03 = value;
                        return;
                    default:
                        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f0"));
                }
            case 1:
                switch (column) {
                    case 0:
                        this.m10 = value;
                        return;
                    case 1:
                        this.m11 = value;
                        return;
                    case 2:
                        this.m12 = value;
                        return;
                    case 3:
                        this.m13 = value;
                        return;
                    default:
                        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f0"));
                }
            case 2:
                switch (column) {
                    case 0:
                        this.m20 = value;
                        return;
                    case 1:
                        this.m21 = value;
                        return;
                    case 2:
                        this.m22 = value;
                        return;
                    case 3:
                        this.m23 = value;
                        return;
                    default:
                        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f0"));
                }
            case 3:
                switch (column) {
                    case 0:
                        this.m30 = value;
                        return;
                    case 1:
                        this.m31 = value;
                        return;
                    case 2:
                        this.m32 = value;
                        return;
                    case 3:
                        this.m33 = value;
                        return;
                    default:
                        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f0"));
                }
            default:
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f0"));
        }
    }

    public final float getElement(int row, int column) {
        switch (row) {
            case 0:
                switch (column) {
                    case 0:
                        return this.m00;
                    case 1:
                        return this.m01;
                    case 2:
                        return this.m02;
                    case 3:
                        return this.m03;
                }
            case 1:
                switch (column) {
                    case 0:
                        return this.m10;
                    case 1:
                        return this.m11;
                    case 2:
                        return this.m12;
                    case 3:
                        return this.m13;
                }
            case 2:
                switch (column) {
                    case 0:
                        return this.m20;
                    case 1:
                        return this.m21;
                    case 2:
                        return this.m22;
                    case 3:
                        return this.m23;
                }
            case 3:
                switch (column) {
                    case 0:
                        return this.m30;
                    case 1:
                        return this.m31;
                    case 2:
                        return this.m32;
                    case 3:
                        return this.m33;
                }
        }
        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f1"));
    }

    public final void getRow(int row, Vector4f v) {
        if (row == 0) {
            v.f173x = this.m00;
            v.f174y = this.m01;
            v.f175z = this.m02;
            v.f172w = this.m03;
        } else if (row == 1) {
            v.f173x = this.m10;
            v.f174y = this.m11;
            v.f175z = this.m12;
            v.f172w = this.m13;
        } else if (row == 2) {
            v.f173x = this.m20;
            v.f174y = this.m21;
            v.f175z = this.m22;
            v.f172w = this.m23;
        } else if (row == 3) {
            v.f173x = this.m30;
            v.f174y = this.m31;
            v.f175z = this.m32;
            v.f172w = this.m33;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f2"));
        }
    }

    public final void getRow(int row, float[] v) {
        if (row == 0) {
            v[0] = this.m00;
            v[1] = this.m01;
            v[2] = this.m02;
            v[3] = this.m03;
        } else if (row == 1) {
            v[0] = this.m10;
            v[1] = this.m11;
            v[2] = this.m12;
            v[3] = this.m13;
        } else if (row == 2) {
            v[0] = this.m20;
            v[1] = this.m21;
            v[2] = this.m22;
            v[3] = this.m23;
        } else if (row == 3) {
            v[0] = this.m30;
            v[1] = this.m31;
            v[2] = this.m32;
            v[3] = this.m33;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f2"));
        }
    }

    public final void getColumn(int column, Vector4f v) {
        if (column == 0) {
            v.f173x = this.m00;
            v.f174y = this.m10;
            v.f175z = this.m20;
            v.f172w = this.m30;
        } else if (column == 1) {
            v.f173x = this.m01;
            v.f174y = this.m11;
            v.f175z = this.m21;
            v.f172w = this.m31;
        } else if (column == 2) {
            v.f173x = this.m02;
            v.f174y = this.m12;
            v.f175z = this.m22;
            v.f172w = this.m32;
        } else if (column == 3) {
            v.f173x = this.m03;
            v.f174y = this.m13;
            v.f175z = this.m23;
            v.f172w = this.m33;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f4"));
        }
    }

    public final void getColumn(int column, float[] v) {
        if (column == 0) {
            v[0] = this.m00;
            v[1] = this.m10;
            v[2] = this.m20;
            v[3] = this.m30;
        } else if (column == 1) {
            v[0] = this.m01;
            v[1] = this.m11;
            v[2] = this.m21;
            v[3] = this.m31;
        } else if (column == 2) {
            v[0] = this.m02;
            v[1] = this.m12;
            v[2] = this.m22;
            v[3] = this.m32;
        } else if (column == 3) {
            v[0] = this.m03;
            v[1] = this.m13;
            v[2] = this.m23;
            v[3] = this.m33;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f4"));
        }
    }

    public final void setScale(float scale) {
        double[] tmp_rot = new double[9];
        getScaleRotate(new double[3], tmp_rot);
        this.m00 = (float) (tmp_rot[0] * ((double) scale));
        this.m01 = (float) (tmp_rot[1] * ((double) scale));
        this.m02 = (float) (tmp_rot[2] * ((double) scale));
        this.m10 = (float) (tmp_rot[3] * ((double) scale));
        this.m11 = (float) (tmp_rot[4] * ((double) scale));
        this.m12 = (float) (tmp_rot[5] * ((double) scale));
        this.m20 = (float) (tmp_rot[6] * ((double) scale));
        this.m21 = (float) (tmp_rot[7] * ((double) scale));
        this.m22 = (float) (tmp_rot[8] * ((double) scale));
    }

    public final void get(Matrix3d m1) {
        double[] tmp_rot = new double[9];
        getScaleRotate(new double[3], tmp_rot);
        m1.m00 = tmp_rot[0];
        m1.m01 = tmp_rot[1];
        m1.m02 = tmp_rot[2];
        m1.m10 = tmp_rot[3];
        m1.m11 = tmp_rot[4];
        m1.m12 = tmp_rot[5];
        m1.m20 = tmp_rot[6];
        m1.m21 = tmp_rot[7];
        m1.m22 = tmp_rot[8];
    }

    public final void get(Matrix3f m1) {
        double[] tmp_rot = new double[9];
        getScaleRotate(new double[3], tmp_rot);
        m1.m00 = (float) tmp_rot[0];
        m1.m01 = (float) tmp_rot[1];
        m1.m02 = (float) tmp_rot[2];
        m1.m10 = (float) tmp_rot[3];
        m1.m11 = (float) tmp_rot[4];
        m1.m12 = (float) tmp_rot[5];
        m1.m20 = (float) tmp_rot[6];
        m1.m21 = (float) tmp_rot[7];
        m1.m22 = (float) tmp_rot[8];
    }

    public final float get(Matrix3f m1, Vector3f t1) {
        double[] tmp_rot = new double[9];
        double[] tmp_scale = new double[3];
        getScaleRotate(tmp_scale, tmp_rot);
        m1.m00 = (float) tmp_rot[0];
        m1.m01 = (float) tmp_rot[1];
        m1.m02 = (float) tmp_rot[2];
        m1.m10 = (float) tmp_rot[3];
        m1.m11 = (float) tmp_rot[4];
        m1.m12 = (float) tmp_rot[5];
        m1.m20 = (float) tmp_rot[6];
        m1.m21 = (float) tmp_rot[7];
        m1.m22 = (float) tmp_rot[8];
        t1.f158x = this.m03;
        t1.f159y = this.m13;
        t1.f160z = this.m23;
        return (float) Matrix3d.max3(tmp_scale);
    }

    public final void get(Quat4f q1) {
        double d;
        double d2;
        double[] tmp_rot = new double[9];
        getScaleRotate(new double[3], tmp_rot);
        double ww = 0.25d * (1.0d + tmp_rot[0] + tmp_rot[4] + tmp_rot[8]);
        if ((ww < Utils.DOUBLE_EPSILON ? -ww : ww) >= 1.0E-30d) {
            q1.f172w = (float) Math.sqrt(ww);
            double ww2 = 0.25d / ((double) q1.f172w);
            q1.f173x = (float) ((tmp_rot[7] - tmp_rot[5]) * ww2);
            q1.f174y = (float) ((tmp_rot[2] - tmp_rot[6]) * ww2);
            q1.f175z = (float) ((tmp_rot[3] - tmp_rot[1]) * ww2);
            return;
        }
        q1.f172w = 0.0f;
        double ww3 = -0.5d * (tmp_rot[4] + tmp_rot[8]);
        if (ww3 < Utils.DOUBLE_EPSILON) {
            d = -ww3;
        } else {
            d = ww3;
        }
        if (d >= 1.0E-30d) {
            q1.f173x = (float) Math.sqrt(ww3);
            double ww4 = 0.5d / ((double) q1.f173x);
            q1.f174y = (float) (tmp_rot[3] * ww4);
            q1.f175z = (float) (tmp_rot[6] * ww4);
            return;
        }
        q1.f173x = 0.0f;
        double ww5 = 0.5d * (1.0d - tmp_rot[8]);
        if (ww5 < Utils.DOUBLE_EPSILON) {
            d2 = -ww5;
        } else {
            d2 = ww5;
        }
        if (d2 >= 1.0E-30d) {
            q1.f174y = (float) Math.sqrt(ww5);
            q1.f175z = (float) (tmp_rot[7] / (2.0d * ((double) q1.f174y)));
            return;
        }
        q1.f174y = 0.0f;
        q1.f175z = 1.0f;
    }

    public final void get(Vector3f trans) {
        trans.f158x = this.m03;
        trans.f159y = this.m13;
        trans.f160z = this.m23;
    }

    public final void getRotationScale(Matrix3f m1) {
        m1.m00 = this.m00;
        m1.m01 = this.m01;
        m1.m02 = this.m02;
        m1.m10 = this.m10;
        m1.m11 = this.m11;
        m1.m12 = this.m12;
        m1.m20 = this.m20;
        m1.m21 = this.m21;
        m1.m22 = this.m22;
    }

    public final float getScale() {
        double[] tmp_scale = new double[3];
        getScaleRotate(tmp_scale, new double[9]);
        return (float) Matrix3d.max3(tmp_scale);
    }

    public final void setRotationScale(Matrix3f m1) {
        this.m00 = m1.m00;
        this.m01 = m1.m01;
        this.m02 = m1.m02;
        this.m10 = m1.m10;
        this.m11 = m1.m11;
        this.m12 = m1.m12;
        this.m20 = m1.m20;
        this.m21 = m1.m21;
        this.m22 = m1.m22;
    }

    public final void setRow(int row, float x, float y, float z, float w) {
        switch (row) {
            case 0:
                this.m00 = x;
                this.m01 = y;
                this.m02 = z;
                this.m03 = w;
                return;
            case 1:
                this.m10 = x;
                this.m11 = y;
                this.m12 = z;
                this.m13 = w;
                return;
            case 2:
                this.m20 = x;
                this.m21 = y;
                this.m22 = z;
                this.m23 = w;
                return;
            case 3:
                this.m30 = x;
                this.m31 = y;
                this.m32 = z;
                this.m33 = w;
                return;
            default:
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f6"));
        }
    }

    public final void setRow(int row, Vector4f v) {
        switch (row) {
            case 0:
                this.m00 = v.f173x;
                this.m01 = v.f174y;
                this.m02 = v.f175z;
                this.m03 = v.f172w;
                return;
            case 1:
                this.m10 = v.f173x;
                this.m11 = v.f174y;
                this.m12 = v.f175z;
                this.m13 = v.f172w;
                return;
            case 2:
                this.m20 = v.f173x;
                this.m21 = v.f174y;
                this.m22 = v.f175z;
                this.m23 = v.f172w;
                return;
            case 3:
                this.m30 = v.f173x;
                this.m31 = v.f174y;
                this.m32 = v.f175z;
                this.m33 = v.f172w;
                return;
            default:
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f6"));
        }
    }

    public final void setRow(int row, float[] v) {
        switch (row) {
            case 0:
                this.m00 = v[0];
                this.m01 = v[1];
                this.m02 = v[2];
                this.m03 = v[3];
                return;
            case 1:
                this.m10 = v[0];
                this.m11 = v[1];
                this.m12 = v[2];
                this.m13 = v[3];
                return;
            case 2:
                this.m20 = v[0];
                this.m21 = v[1];
                this.m22 = v[2];
                this.m23 = v[3];
                return;
            case 3:
                this.m30 = v[0];
                this.m31 = v[1];
                this.m32 = v[2];
                this.m33 = v[3];
                return;
            default:
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f6"));
        }
    }

    public final void setColumn(int column, float x, float y, float z, float w) {
        switch (column) {
            case 0:
                this.m00 = x;
                this.m10 = y;
                this.m20 = z;
                this.m30 = w;
                return;
            case 1:
                this.m01 = x;
                this.m11 = y;
                this.m21 = z;
                this.m31 = w;
                return;
            case 2:
                this.m02 = x;
                this.m12 = y;
                this.m22 = z;
                this.m32 = w;
                return;
            case 3:
                this.m03 = x;
                this.m13 = y;
                this.m23 = z;
                this.m33 = w;
                return;
            default:
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f9"));
        }
    }

    public final void setColumn(int column, Vector4f v) {
        switch (column) {
            case 0:
                this.m00 = v.f173x;
                this.m10 = v.f174y;
                this.m20 = v.f175z;
                this.m30 = v.f172w;
                return;
            case 1:
                this.m01 = v.f173x;
                this.m11 = v.f174y;
                this.m21 = v.f175z;
                this.m31 = v.f172w;
                return;
            case 2:
                this.m02 = v.f173x;
                this.m12 = v.f174y;
                this.m22 = v.f175z;
                this.m32 = v.f172w;
                return;
            case 3:
                this.m03 = v.f173x;
                this.m13 = v.f174y;
                this.m23 = v.f175z;
                this.m33 = v.f172w;
                return;
            default:
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f9"));
        }
    }

    public final void setColumn(int column, float[] v) {
        switch (column) {
            case 0:
                this.m00 = v[0];
                this.m10 = v[1];
                this.m20 = v[2];
                this.m30 = v[3];
                return;
            case 1:
                this.m01 = v[0];
                this.m11 = v[1];
                this.m21 = v[2];
                this.m31 = v[3];
                return;
            case 2:
                this.m02 = v[0];
                this.m12 = v[1];
                this.m22 = v[2];
                this.m32 = v[3];
                return;
            case 3:
                this.m03 = v[0];
                this.m13 = v[1];
                this.m23 = v[2];
                this.m33 = v[3];
                return;
            default:
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f9"));
        }
    }

    public final void add(float scalar) {
        this.m00 += scalar;
        this.m01 += scalar;
        this.m02 += scalar;
        this.m03 += scalar;
        this.m10 += scalar;
        this.m11 += scalar;
        this.m12 += scalar;
        this.m13 += scalar;
        this.m20 += scalar;
        this.m21 += scalar;
        this.m22 += scalar;
        this.m23 += scalar;
        this.m30 += scalar;
        this.m31 += scalar;
        this.m32 += scalar;
        this.m33 += scalar;
    }

    public final void add(float scalar, Matrix4f m1) {
        this.m00 = m1.m00 + scalar;
        this.m01 = m1.m01 + scalar;
        this.m02 = m1.m02 + scalar;
        this.m03 = m1.m03 + scalar;
        this.m10 = m1.m10 + scalar;
        this.m11 = m1.m11 + scalar;
        this.m12 = m1.m12 + scalar;
        this.m13 = m1.m13 + scalar;
        this.m20 = m1.m20 + scalar;
        this.m21 = m1.m21 + scalar;
        this.m22 = m1.m22 + scalar;
        this.m23 = m1.m23 + scalar;
        this.m30 = m1.m30 + scalar;
        this.m31 = m1.m31 + scalar;
        this.m32 = m1.m32 + scalar;
        this.m33 = m1.m33 + scalar;
    }

    public final void add(Matrix4f m1, Matrix4f m2) {
        this.m00 = m1.m00 + m2.m00;
        this.m01 = m1.m01 + m2.m01;
        this.m02 = m1.m02 + m2.m02;
        this.m03 = m1.m03 + m2.m03;
        this.m10 = m1.m10 + m2.m10;
        this.m11 = m1.m11 + m2.m11;
        this.m12 = m1.m12 + m2.m12;
        this.m13 = m1.m13 + m2.m13;
        this.m20 = m1.m20 + m2.m20;
        this.m21 = m1.m21 + m2.m21;
        this.m22 = m1.m22 + m2.m22;
        this.m23 = m1.m23 + m2.m23;
        this.m30 = m1.m30 + m2.m30;
        this.m31 = m1.m31 + m2.m31;
        this.m32 = m1.m32 + m2.m32;
        this.m33 = m1.m33 + m2.m33;
    }

    public final void add(Matrix4f m1) {
        this.m00 += m1.m00;
        this.m01 += m1.m01;
        this.m02 += m1.m02;
        this.m03 += m1.m03;
        this.m10 += m1.m10;
        this.m11 += m1.m11;
        this.m12 += m1.m12;
        this.m13 += m1.m13;
        this.m20 += m1.m20;
        this.m21 += m1.m21;
        this.m22 += m1.m22;
        this.m23 += m1.m23;
        this.m30 += m1.m30;
        this.m31 += m1.m31;
        this.m32 += m1.m32;
        this.m33 += m1.m33;
    }

    public final void sub(Matrix4f m1, Matrix4f m2) {
        this.m00 = m1.m00 - m2.m00;
        this.m01 = m1.m01 - m2.m01;
        this.m02 = m1.m02 - m2.m02;
        this.m03 = m1.m03 - m2.m03;
        this.m10 = m1.m10 - m2.m10;
        this.m11 = m1.m11 - m2.m11;
        this.m12 = m1.m12 - m2.m12;
        this.m13 = m1.m13 - m2.m13;
        this.m20 = m1.m20 - m2.m20;
        this.m21 = m1.m21 - m2.m21;
        this.m22 = m1.m22 - m2.m22;
        this.m23 = m1.m23 - m2.m23;
        this.m30 = m1.m30 - m2.m30;
        this.m31 = m1.m31 - m2.m31;
        this.m32 = m1.m32 - m2.m32;
        this.m33 = m1.m33 - m2.m33;
    }

    public final void sub(Matrix4f m1) {
        this.m00 -= m1.m00;
        this.m01 -= m1.m01;
        this.m02 -= m1.m02;
        this.m03 -= m1.m03;
        this.m10 -= m1.m10;
        this.m11 -= m1.m11;
        this.m12 -= m1.m12;
        this.m13 -= m1.m13;
        this.m20 -= m1.m20;
        this.m21 -= m1.m21;
        this.m22 -= m1.m22;
        this.m23 -= m1.m23;
        this.m30 -= m1.m30;
        this.m31 -= m1.m31;
        this.m32 -= m1.m32;
        this.m33 -= m1.m33;
    }

    public final void transpose() {
        float temp = this.m10;
        this.m10 = this.m01;
        this.m01 = temp;
        float temp2 = this.m20;
        this.m20 = this.m02;
        this.m02 = temp2;
        float temp3 = this.m30;
        this.m30 = this.m03;
        this.m03 = temp3;
        float temp4 = this.m21;
        this.m21 = this.m12;
        this.m12 = temp4;
        float temp5 = this.m31;
        this.m31 = this.m13;
        this.m13 = temp5;
        float temp6 = this.m32;
        this.m32 = this.m23;
        this.m23 = temp6;
    }

    public final void transpose(Matrix4f m1) {
        if (this != m1) {
            this.m00 = m1.m00;
            this.m01 = m1.m10;
            this.m02 = m1.m20;
            this.m03 = m1.m30;
            this.m10 = m1.m01;
            this.m11 = m1.m11;
            this.m12 = m1.m21;
            this.m13 = m1.m31;
            this.m20 = m1.m02;
            this.m21 = m1.m12;
            this.m22 = m1.m22;
            this.m23 = m1.m32;
            this.m30 = m1.m03;
            this.m31 = m1.m13;
            this.m32 = m1.m23;
            this.m33 = m1.m33;
            return;
        }
        transpose();
    }

    public final void set(Quat4f q1) {
        this.m00 = (1.0f - ((q1.f174y * 2.0f) * q1.f174y)) - ((q1.f175z * 2.0f) * q1.f175z);
        this.m10 = ((q1.f173x * q1.f174y) + (q1.f172w * q1.f175z)) * 2.0f;
        this.m20 = ((q1.f173x * q1.f175z) - (q1.f172w * q1.f174y)) * 2.0f;
        this.m01 = ((q1.f173x * q1.f174y) - (q1.f172w * q1.f175z)) * 2.0f;
        this.m11 = (1.0f - ((q1.f173x * 2.0f) * q1.f173x)) - ((q1.f175z * 2.0f) * q1.f175z);
        this.m21 = ((q1.f174y * q1.f175z) + (q1.f172w * q1.f173x)) * 2.0f;
        this.m02 = ((q1.f173x * q1.f175z) + (q1.f172w * q1.f174y)) * 2.0f;
        this.m12 = ((q1.f174y * q1.f175z) - (q1.f172w * q1.f173x)) * 2.0f;
        this.m22 = (1.0f - ((q1.f173x * 2.0f) * q1.f173x)) - ((q1.f174y * 2.0f) * q1.f174y);
        this.m03 = 0.0f;
        this.m13 = 0.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(AxisAngle4f a1) {
        float mag = (float) Math.sqrt((double) ((a1.f143x * a1.f143x) + (a1.f144y * a1.f144y) + (a1.f145z * a1.f145z)));
        if (((double) mag) < EPS) {
            this.m00 = 1.0f;
            this.m01 = 0.0f;
            this.m02 = 0.0f;
            this.m10 = 0.0f;
            this.m11 = 1.0f;
            this.m12 = 0.0f;
            this.m20 = 0.0f;
            this.m21 = 0.0f;
            this.m22 = 1.0f;
        } else {
            float mag2 = 1.0f / mag;
            float ax = a1.f143x * mag2;
            float ay = a1.f144y * mag2;
            float az = a1.f145z * mag2;
            float sinTheta = (float) Math.sin((double) a1.angle);
            float cosTheta = (float) Math.cos((double) a1.angle);
            float t = 1.0f - cosTheta;
            float xz = ax * az;
            float xy = ax * ay;
            float yz = ay * az;
            this.m00 = (t * ax * ax) + cosTheta;
            this.m01 = (t * xy) - (sinTheta * az);
            this.m02 = (t * xz) + (sinTheta * ay);
            this.m10 = (t * xy) + (sinTheta * az);
            this.m11 = (t * ay * ay) + cosTheta;
            this.m12 = (t * yz) - (sinTheta * ax);
            this.m20 = (t * xz) - (sinTheta * ay);
            this.m21 = (t * yz) + (sinTheta * ax);
            this.m22 = (t * az * az) + cosTheta;
        }
        this.m03 = 0.0f;
        this.m13 = 0.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(Quat4d q1) {
        this.m00 = (float) ((1.0d - ((q1.f170y * 2.0d) * q1.f170y)) - ((q1.f171z * 2.0d) * q1.f171z));
        this.m10 = (float) (((q1.f169x * q1.f170y) + (q1.f168w * q1.f171z)) * 2.0d);
        this.m20 = (float) (((q1.f169x * q1.f171z) - (q1.f168w * q1.f170y)) * 2.0d);
        this.m01 = (float) (((q1.f169x * q1.f170y) - (q1.f168w * q1.f171z)) * 2.0d);
        this.m11 = (float) ((1.0d - ((q1.f169x * 2.0d) * q1.f169x)) - ((q1.f171z * 2.0d) * q1.f171z));
        this.m21 = (float) (((q1.f170y * q1.f171z) + (q1.f168w * q1.f169x)) * 2.0d);
        this.m02 = (float) (((q1.f169x * q1.f171z) + (q1.f168w * q1.f170y)) * 2.0d);
        this.m12 = (float) (((q1.f170y * q1.f171z) - (q1.f168w * q1.f169x)) * 2.0d);
        this.m22 = (float) ((1.0d - ((q1.f169x * 2.0d) * q1.f169x)) - ((q1.f170y * 2.0d) * q1.f170y));
        this.m03 = 0.0f;
        this.m13 = 0.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(AxisAngle4d a1) {
        double mag = Math.sqrt((a1.f140x * a1.f140x) + (a1.f141y * a1.f141y) + (a1.f142z * a1.f142z));
        if (mag < EPS) {
            this.m00 = 1.0f;
            this.m01 = 0.0f;
            this.m02 = 0.0f;
            this.m10 = 0.0f;
            this.m11 = 1.0f;
            this.m12 = 0.0f;
            this.m20 = 0.0f;
            this.m21 = 0.0f;
            this.m22 = 1.0f;
        } else {
            double mag2 = 1.0d / mag;
            double ax = a1.f140x * mag2;
            double ay = a1.f141y * mag2;
            double az = a1.f142z * mag2;
            float sinTheta = (float) Math.sin(a1.angle);
            float cosTheta = (float) Math.cos(a1.angle);
            float t = 1.0f - cosTheta;
            float xz = (float) (ax * az);
            float xy = (float) (ax * ay);
            float yz = (float) (ay * az);
            this.m00 = (((float) (ax * ax)) * t) + cosTheta;
            this.m01 = (t * xy) - (((float) az) * sinTheta);
            this.m02 = (t * xz) + (((float) ay) * sinTheta);
            this.m10 = (t * xy) + (((float) az) * sinTheta);
            this.m11 = (((float) (ay * ay)) * t) + cosTheta;
            this.m12 = (t * yz) - (((float) ax) * sinTheta);
            this.m20 = (t * xz) - (((float) ay) * sinTheta);
            this.m21 = (t * yz) + (((float) ax) * sinTheta);
            this.m22 = (((float) (az * az)) * t) + cosTheta;
        }
        this.m03 = 0.0f;
        this.m13 = 0.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(Quat4d q1, Vector3d t1, double s) {
        this.m00 = (float) (((1.0d - ((q1.f170y * 2.0d) * q1.f170y)) - ((q1.f171z * 2.0d) * q1.f171z)) * s);
        this.m10 = (float) (((q1.f169x * q1.f170y) + (q1.f168w * q1.f171z)) * 2.0d * s);
        this.m20 = (float) (((q1.f169x * q1.f171z) - (q1.f168w * q1.f170y)) * 2.0d * s);
        this.m01 = (float) (((q1.f169x * q1.f170y) - (q1.f168w * q1.f171z)) * 2.0d * s);
        this.m11 = (float) (((1.0d - ((q1.f169x * 2.0d) * q1.f169x)) - ((q1.f171z * 2.0d) * q1.f171z)) * s);
        this.m21 = (float) (((q1.f170y * q1.f171z) + (q1.f168w * q1.f169x)) * 2.0d * s);
        this.m02 = (float) (((q1.f169x * q1.f171z) + (q1.f168w * q1.f170y)) * 2.0d * s);
        this.m12 = (float) (((q1.f170y * q1.f171z) - (q1.f168w * q1.f169x)) * 2.0d * s);
        this.m22 = (float) (((1.0d - ((q1.f169x * 2.0d) * q1.f169x)) - ((q1.f170y * 2.0d) * q1.f170y)) * s);
        this.m03 = (float) t1.f155x;
        this.m13 = (float) t1.f156y;
        this.m23 = (float) t1.f157z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(Quat4f q1, Vector3f t1, float s) {
        this.m00 = ((1.0f - ((q1.f174y * 2.0f) * q1.f174y)) - ((q1.f175z * 2.0f) * q1.f175z)) * s;
        this.m10 = ((q1.f173x * q1.f174y) + (q1.f172w * q1.f175z)) * 2.0f * s;
        this.m20 = ((q1.f173x * q1.f175z) - (q1.f172w * q1.f174y)) * 2.0f * s;
        this.m01 = ((q1.f173x * q1.f174y) - (q1.f172w * q1.f175z)) * 2.0f * s;
        this.m11 = ((1.0f - ((q1.f173x * 2.0f) * q1.f173x)) - ((q1.f175z * 2.0f) * q1.f175z)) * s;
        this.m21 = ((q1.f174y * q1.f175z) + (q1.f172w * q1.f173x)) * 2.0f * s;
        this.m02 = ((q1.f173x * q1.f175z) + (q1.f172w * q1.f174y)) * 2.0f * s;
        this.m12 = ((q1.f174y * q1.f175z) - (q1.f172w * q1.f173x)) * 2.0f * s;
        this.m22 = ((1.0f - ((q1.f173x * 2.0f) * q1.f173x)) - ((q1.f174y * 2.0f) * q1.f174y)) * s;
        this.m03 = t1.f158x;
        this.m13 = t1.f159y;
        this.m23 = t1.f160z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(Matrix4d m1) {
        this.m00 = (float) m1.m00;
        this.m01 = (float) m1.m01;
        this.m02 = (float) m1.m02;
        this.m03 = (float) m1.m03;
        this.m10 = (float) m1.m10;
        this.m11 = (float) m1.m11;
        this.m12 = (float) m1.m12;
        this.m13 = (float) m1.m13;
        this.m20 = (float) m1.m20;
        this.m21 = (float) m1.m21;
        this.m22 = (float) m1.m22;
        this.m23 = (float) m1.m23;
        this.m30 = (float) m1.m30;
        this.m31 = (float) m1.m31;
        this.m32 = (float) m1.m32;
        this.m33 = (float) m1.m33;
    }

    public final void set(Matrix4f m1) {
        this.m00 = m1.m00;
        this.m01 = m1.m01;
        this.m02 = m1.m02;
        this.m03 = m1.m03;
        this.m10 = m1.m10;
        this.m11 = m1.m11;
        this.m12 = m1.m12;
        this.m13 = m1.m13;
        this.m20 = m1.m20;
        this.m21 = m1.m21;
        this.m22 = m1.m22;
        this.m23 = m1.m23;
        this.m30 = m1.m30;
        this.m31 = m1.m31;
        this.m32 = m1.m32;
        this.m33 = m1.m33;
    }

    public final void invert(Matrix4f m1) {
        invertGeneral(m1);
    }

    public final void invert() {
        invertGeneral(this);
    }

    /* access modifiers changed from: package-private */
    public final void invertGeneral(Matrix4f m1) {
        double[] result = new double[16];
        int[] row_perm = new int[4];
        double[] temp = {(double) m1.m00, (double) m1.m01, (double) m1.m02, (double) m1.m03, (double) m1.m10, (double) m1.m11, (double) m1.m12, (double) m1.m13, (double) m1.m20, (double) m1.m21, (double) m1.m22, (double) m1.m23, (double) m1.m30, (double) m1.m31, (double) m1.m32, (double) m1.m33};
        if (!luDecomposition(temp, row_perm)) {
            throw new SingularMatrixException(VecMathI18N.getString("Matrix4f12"));
        }
        for (int i = 0; i < 16; i++) {
            result[i] = 0.0d;
        }
        result[0] = 1.0d;
        result[5] = 1.0d;
        result[10] = 1.0d;
        result[15] = 1.0d;
        luBacksubstitution(temp, row_perm, result);
        this.m00 = (float) result[0];
        this.m01 = (float) result[1];
        this.m02 = (float) result[2];
        this.m03 = (float) result[3];
        this.m10 = (float) result[4];
        this.m11 = (float) result[5];
        this.m12 = (float) result[6];
        this.m13 = (float) result[7];
        this.m20 = (float) result[8];
        this.m21 = (float) result[9];
        this.m22 = (float) result[10];
        this.m23 = (float) result[11];
        this.m30 = (float) result[12];
        this.m31 = (float) result[13];
        this.m32 = (float) result[14];
        this.m33 = (float) result[15];
    }

    static boolean luDecomposition(double[] matrix0, int[] row_perm) {
        int ptr;
        double[] row_scale = new double[4];
        int ptr2 = 0;
        int i = 4;
        int rs = 0;
        while (true) {
            int i2 = i;
            i = i2 - 1;
            if (i2 != 0) {
                double big = Utils.DOUBLE_EPSILON;
                int j = 4;
                while (true) {
                    ptr = ptr2;
                    int j2 = j;
                    j = j2 - 1;
                    if (j2 == 0) {
                        break;
                    }
                    ptr2 = ptr + 1;
                    double temp = Math.abs(matrix0[ptr]);
                    if (temp > big) {
                        big = temp;
                    }
                }
                if (big == Utils.DOUBLE_EPSILON) {
                    return false;
                }
                row_scale[rs] = 1.0d / big;
                rs++;
                ptr2 = ptr;
            } else {
                for (int j3 = 0; j3 < 4; j3++) {
                    for (int i3 = 0; i3 < j3; i3++) {
                        int target = (i3 * 4) + 0 + j3;
                        double sum = matrix0[target];
                        int k = i3;
                        int p1 = 0 + (i3 * 4);
                        int p2 = 0 + j3;
                        while (true) {
                            int k2 = k;
                            k = k2 - 1;
                            if (k2 == 0) {
                                break;
                            }
                            sum -= matrix0[p1] * matrix0[p2];
                            p1++;
                            p2 += 4;
                        }
                        matrix0[target] = sum;
                    }
                    double big2 = Utils.DOUBLE_EPSILON;
                    int imax = -1;
                    for (int i4 = j3; i4 < 4; i4++) {
                        int target2 = (i4 * 4) + 0 + j3;
                        double sum2 = matrix0[target2];
                        int k3 = j3;
                        int p12 = 0 + (i4 * 4);
                        int p22 = 0 + j3;
                        while (true) {
                            int k4 = k3;
                            k3 = k4 - 1;
                            if (k4 == 0) {
                                break;
                            }
                            sum2 -= matrix0[p12] * matrix0[p22];
                            p12++;
                            p22 += 4;
                        }
                        matrix0[target2] = sum2;
                        double temp2 = row_scale[i4] * Math.abs(sum2);
                        if (temp2 >= big2) {
                            big2 = temp2;
                            imax = i4;
                        }
                    }
                    if (imax < 0) {
                        throw new RuntimeException(VecMathI18N.getString("Matrix4f13"));
                    }
                    if (j3 != imax) {
                        int k5 = 4;
                        int p13 = 0 + (imax * 4);
                        int p23 = 0 + (j3 * 4);
                        while (true) {
                            int p24 = p23;
                            int p14 = p13;
                            int k6 = k5;
                            k5 = k6 - 1;
                            if (k6 == 0) {
                                break;
                            }
                            double temp3 = matrix0[p14];
                            p13 = p14 + 1;
                            matrix0[p14] = matrix0[p24];
                            p23 = p24 + 1;
                            matrix0[p24] = temp3;
                        }
                        row_scale[imax] = row_scale[j3];
                    }
                    row_perm[j3] = imax;
                    if (matrix0[(j3 * 4) + 0 + j3] == Utils.DOUBLE_EPSILON) {
                        return false;
                    }
                    if (j3 != 3) {
                        double temp4 = 1.0d / matrix0[((j3 * 4) + 0) + j3];
                        int target3 = ((j3 + 1) * 4) + 0 + j3;
                        int i5 = 3 - j3;
                        while (true) {
                            int i6 = i5;
                            i5 = i6 - 1;
                            if (i6 == 0) {
                                break;
                            }
                            matrix0[target3] = matrix0[target3] * temp4;
                            target3 += 4;
                        }
                    }
                }
                return true;
            }
        }
    }

    static void luBacksubstitution(double[] matrix1, int[] row_perm, double[] matrix2) {
        for (int k = 0; k < 4; k++) {
            int cv = k;
            int ii = -1;
            for (int i = 0; i < 4; i++) {
                int ip = row_perm[0 + i];
                double sum = matrix2[(ip * 4) + cv];
                matrix2[(ip * 4) + cv] = matrix2[(i * 4) + cv];
                if (ii >= 0) {
                    int rv = i * 4;
                    for (int j = ii; j <= i - 1; j++) {
                        sum -= matrix1[rv + j] * matrix2[(j * 4) + cv];
                    }
                } else if (sum != Utils.DOUBLE_EPSILON) {
                    ii = i;
                }
                matrix2[(i * 4) + cv] = sum;
            }
            int i2 = cv + 12;
            matrix2[i2] = matrix2[i2] / matrix1[15];
            matrix2[cv + 8] = (matrix2[cv + 8] - (matrix1[11] * matrix2[cv + 12])) / matrix1[10];
            matrix2[cv + 4] = ((matrix2[cv + 4] - (matrix1[6] * matrix2[cv + 8])) - (matrix1[7] * matrix2[cv + 12])) / matrix1[5];
            int rv2 = ((12 - 4) - 4) - 4;
            matrix2[cv + 0] = (((matrix2[cv + 0] - (matrix1[1] * matrix2[cv + 4])) - (matrix1[2] * matrix2[cv + 8])) - (matrix1[3] * matrix2[cv + 12])) / matrix1[0];
        }
    }

    public final float determinant() {
        return (((this.m00 * (((((((this.m11 * this.m22) * this.m33) + ((this.m12 * this.m23) * this.m31)) + ((this.m13 * this.m21) * this.m32)) - ((this.m13 * this.m22) * this.m31)) - ((this.m11 * this.m23) * this.m32)) - ((this.m12 * this.m21) * this.m33))) - (this.m01 * (((((((this.m10 * this.m22) * this.m33) + ((this.m12 * this.m23) * this.m30)) + ((this.m13 * this.m20) * this.m32)) - ((this.m13 * this.m22) * this.m30)) - ((this.m10 * this.m23) * this.m32)) - ((this.m12 * this.m20) * this.m33)))) + (this.m02 * (((((((this.m10 * this.m21) * this.m33) + ((this.m11 * this.m23) * this.m30)) + ((this.m13 * this.m20) * this.m31)) - ((this.m13 * this.m21) * this.m30)) - ((this.m10 * this.m23) * this.m31)) - ((this.m11 * this.m20) * this.m33)))) - (this.m03 * (((((((this.m10 * this.m21) * this.m32) + ((this.m11 * this.m22) * this.m30)) + ((this.m12 * this.m20) * this.m31)) - ((this.m12 * this.m21) * this.m30)) - ((this.m10 * this.m22) * this.m31)) - ((this.m11 * this.m20) * this.m32)));
    }

    public final void set(Matrix3f m1) {
        this.m00 = m1.m00;
        this.m01 = m1.m01;
        this.m02 = m1.m02;
        this.m03 = 0.0f;
        this.m10 = m1.m10;
        this.m11 = m1.m11;
        this.m12 = m1.m12;
        this.m13 = 0.0f;
        this.m20 = m1.m20;
        this.m21 = m1.m21;
        this.m22 = m1.m22;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(Matrix3d m1) {
        this.m00 = (float) m1.m00;
        this.m01 = (float) m1.m01;
        this.m02 = (float) m1.m02;
        this.m03 = 0.0f;
        this.m10 = (float) m1.m10;
        this.m11 = (float) m1.m11;
        this.m12 = (float) m1.m12;
        this.m13 = 0.0f;
        this.m20 = (float) m1.m20;
        this.m21 = (float) m1.m21;
        this.m22 = (float) m1.m22;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(float scale) {
        this.m00 = scale;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = scale;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = scale;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(float[] m) {
        this.m00 = m[0];
        this.m01 = m[1];
        this.m02 = m[2];
        this.m03 = m[3];
        this.m10 = m[4];
        this.m11 = m[5];
        this.m12 = m[6];
        this.m13 = m[7];
        this.m20 = m[8];
        this.m21 = m[9];
        this.m22 = m[10];
        this.m23 = m[11];
        this.m30 = m[12];
        this.m31 = m[13];
        this.m32 = m[14];
        this.m33 = m[15];
    }

    public final void set(Vector3f v1) {
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = v1.f158x;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        this.m13 = v1.f159y;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 1.0f;
        this.m23 = v1.f160z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(float scale, Vector3f t1) {
        this.m00 = scale;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = t1.f158x;
        this.m10 = 0.0f;
        this.m11 = scale;
        this.m12 = 0.0f;
        this.m13 = t1.f159y;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = scale;
        this.m23 = t1.f160z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(Vector3f t1, float scale) {
        this.m00 = scale;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = t1.f158x * scale;
        this.m10 = 0.0f;
        this.m11 = scale;
        this.m12 = 0.0f;
        this.m13 = t1.f159y * scale;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = scale;
        this.m23 = t1.f160z * scale;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(Matrix3f m1, Vector3f t1, float scale) {
        this.m00 = m1.m00 * scale;
        this.m01 = m1.m01 * scale;
        this.m02 = m1.m02 * scale;
        this.m03 = t1.f158x;
        this.m10 = m1.m10 * scale;
        this.m11 = m1.m11 * scale;
        this.m12 = m1.m12 * scale;
        this.m13 = t1.f159y;
        this.m20 = m1.m20 * scale;
        this.m21 = m1.m21 * scale;
        this.m22 = m1.m22 * scale;
        this.m23 = t1.f160z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(Matrix3d m1, Vector3d t1, double scale) {
        this.m00 = (float) (m1.m00 * scale);
        this.m01 = (float) (m1.m01 * scale);
        this.m02 = (float) (m1.m02 * scale);
        this.m03 = (float) t1.f155x;
        this.m10 = (float) (m1.m10 * scale);
        this.m11 = (float) (m1.m11 * scale);
        this.m12 = (float) (m1.m12 * scale);
        this.m13 = (float) t1.f156y;
        this.m20 = (float) (m1.m20 * scale);
        this.m21 = (float) (m1.m21 * scale);
        this.m22 = (float) (m1.m22 * scale);
        this.m23 = (float) t1.f157z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void setTranslation(Vector3f trans) {
        this.m03 = trans.f158x;
        this.m13 = trans.f159y;
        this.m23 = trans.f160z;
    }

    public final void rotX(float angle) {
        float sinAngle = (float) Math.sin((double) angle);
        float cosAngle = (float) Math.cos((double) angle);
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = cosAngle;
        this.m12 = -sinAngle;
        this.m13 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = sinAngle;
        this.m22 = cosAngle;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void rotY(float angle) {
        float sinAngle = (float) Math.sin((double) angle);
        float cosAngle = (float) Math.cos((double) angle);
        this.m00 = cosAngle;
        this.m01 = 0.0f;
        this.m02 = sinAngle;
        this.m03 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = -sinAngle;
        this.m21 = 0.0f;
        this.m22 = cosAngle;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void rotZ(float angle) {
        float sinAngle = (float) Math.sin((double) angle);
        float cosAngle = (float) Math.cos((double) angle);
        this.m00 = cosAngle;
        this.m01 = -sinAngle;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = sinAngle;
        this.m11 = cosAngle;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 1.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void mul(float scalar) {
        this.m00 *= scalar;
        this.m01 *= scalar;
        this.m02 *= scalar;
        this.m03 *= scalar;
        this.m10 *= scalar;
        this.m11 *= scalar;
        this.m12 *= scalar;
        this.m13 *= scalar;
        this.m20 *= scalar;
        this.m21 *= scalar;
        this.m22 *= scalar;
        this.m23 *= scalar;
        this.m30 *= scalar;
        this.m31 *= scalar;
        this.m32 *= scalar;
        this.m33 *= scalar;
    }

    public final void mul(float scalar, Matrix4f m1) {
        this.m00 = m1.m00 * scalar;
        this.m01 = m1.m01 * scalar;
        this.m02 = m1.m02 * scalar;
        this.m03 = m1.m03 * scalar;
        this.m10 = m1.m10 * scalar;
        this.m11 = m1.m11 * scalar;
        this.m12 = m1.m12 * scalar;
        this.m13 = m1.m13 * scalar;
        this.m20 = m1.m20 * scalar;
        this.m21 = m1.m21 * scalar;
        this.m22 = m1.m22 * scalar;
        this.m23 = m1.m23 * scalar;
        this.m30 = m1.m30 * scalar;
        this.m31 = m1.m31 * scalar;
        this.m32 = m1.m32 * scalar;
        this.m33 = m1.m33 * scalar;
    }

    public final void mul(Matrix4f m1) {
        float m002 = (this.m00 * m1.m00) + (this.m01 * m1.m10) + (this.m02 * m1.m20) + (this.m03 * m1.m30);
        float m012 = (this.m00 * m1.m01) + (this.m01 * m1.m11) + (this.m02 * m1.m21) + (this.m03 * m1.m31);
        float m022 = (this.m00 * m1.m02) + (this.m01 * m1.m12) + (this.m02 * m1.m22) + (this.m03 * m1.m32);
        float m032 = (this.m00 * m1.m03) + (this.m01 * m1.m13) + (this.m02 * m1.m23) + (this.m03 * m1.m33);
        float m102 = (this.m10 * m1.m00) + (this.m11 * m1.m10) + (this.m12 * m1.m20) + (this.m13 * m1.m30);
        float m112 = (this.m10 * m1.m01) + (this.m11 * m1.m11) + (this.m12 * m1.m21) + (this.m13 * m1.m31);
        float m122 = (this.m10 * m1.m02) + (this.m11 * m1.m12) + (this.m12 * m1.m22) + (this.m13 * m1.m32);
        float m132 = (this.m10 * m1.m03) + (this.m11 * m1.m13) + (this.m12 * m1.m23) + (this.m13 * m1.m33);
        float m202 = (this.m20 * m1.m00) + (this.m21 * m1.m10) + (this.m22 * m1.m20) + (this.m23 * m1.m30);
        float m212 = (this.m20 * m1.m01) + (this.m21 * m1.m11) + (this.m22 * m1.m21) + (this.m23 * m1.m31);
        float m222 = (this.m20 * m1.m02) + (this.m21 * m1.m12) + (this.m22 * m1.m22) + (this.m23 * m1.m32);
        float m232 = (this.m20 * m1.m03) + (this.m21 * m1.m13) + (this.m22 * m1.m23) + (this.m23 * m1.m33);
        float m302 = (this.m30 * m1.m00) + (this.m31 * m1.m10) + (this.m32 * m1.m20) + (this.m33 * m1.m30);
        float m312 = (this.m30 * m1.m01) + (this.m31 * m1.m11) + (this.m32 * m1.m21) + (this.m33 * m1.m31);
        float m322 = (this.m30 * m1.m02) + (this.m31 * m1.m12) + (this.m32 * m1.m22) + (this.m33 * m1.m32);
        this.m00 = m002;
        this.m01 = m012;
        this.m02 = m022;
        this.m03 = m032;
        this.m10 = m102;
        this.m11 = m112;
        this.m12 = m122;
        this.m13 = m132;
        this.m20 = m202;
        this.m21 = m212;
        this.m22 = m222;
        this.m23 = m232;
        this.m30 = m302;
        this.m31 = m312;
        this.m32 = m322;
        this.m33 = (this.m30 * m1.m03) + (this.m31 * m1.m13) + (this.m32 * m1.m23) + (this.m33 * m1.m33);
    }

    public final void mul(Matrix4f m1, Matrix4f m2) {
        if (this == m1 || this == m2) {
            float m002 = (m1.m00 * m2.m00) + (m1.m01 * m2.m10) + (m1.m02 * m2.m20) + (m1.m03 * m2.m30);
            float m012 = (m1.m00 * m2.m01) + (m1.m01 * m2.m11) + (m1.m02 * m2.m21) + (m1.m03 * m2.m31);
            float m022 = (m1.m00 * m2.m02) + (m1.m01 * m2.m12) + (m1.m02 * m2.m22) + (m1.m03 * m2.m32);
            float m032 = (m1.m00 * m2.m03) + (m1.m01 * m2.m13) + (m1.m02 * m2.m23) + (m1.m03 * m2.m33);
            float m102 = (m1.m10 * m2.m00) + (m1.m11 * m2.m10) + (m1.m12 * m2.m20) + (m1.m13 * m2.m30);
            float m112 = (m1.m10 * m2.m01) + (m1.m11 * m2.m11) + (m1.m12 * m2.m21) + (m1.m13 * m2.m31);
            float m122 = (m1.m10 * m2.m02) + (m1.m11 * m2.m12) + (m1.m12 * m2.m22) + (m1.m13 * m2.m32);
            float m132 = (m1.m10 * m2.m03) + (m1.m11 * m2.m13) + (m1.m12 * m2.m23) + (m1.m13 * m2.m33);
            float m202 = (m1.m20 * m2.m00) + (m1.m21 * m2.m10) + (m1.m22 * m2.m20) + (m1.m23 * m2.m30);
            float m212 = (m1.m20 * m2.m01) + (m1.m21 * m2.m11) + (m1.m22 * m2.m21) + (m1.m23 * m2.m31);
            float m222 = (m1.m20 * m2.m02) + (m1.m21 * m2.m12) + (m1.m22 * m2.m22) + (m1.m23 * m2.m32);
            float m232 = (m1.m20 * m2.m03) + (m1.m21 * m2.m13) + (m1.m22 * m2.m23) + (m1.m23 * m2.m33);
            float m302 = (m1.m30 * m2.m00) + (m1.m31 * m2.m10) + (m1.m32 * m2.m20) + (m1.m33 * m2.m30);
            float m312 = (m1.m30 * m2.m01) + (m1.m31 * m2.m11) + (m1.m32 * m2.m21) + (m1.m33 * m2.m31);
            float m322 = (m1.m30 * m2.m02) + (m1.m31 * m2.m12) + (m1.m32 * m2.m22) + (m1.m33 * m2.m32);
            this.m00 = m002;
            this.m01 = m012;
            this.m02 = m022;
            this.m03 = m032;
            this.m10 = m102;
            this.m11 = m112;
            this.m12 = m122;
            this.m13 = m132;
            this.m20 = m202;
            this.m21 = m212;
            this.m22 = m222;
            this.m23 = m232;
            this.m30 = m302;
            this.m31 = m312;
            this.m32 = m322;
            this.m33 = (m1.m30 * m2.m03) + (m1.m31 * m2.m13) + (m1.m32 * m2.m23) + (m1.m33 * m2.m33);
            return;
        }
        this.m00 = (m1.m00 * m2.m00) + (m1.m01 * m2.m10) + (m1.m02 * m2.m20) + (m1.m03 * m2.m30);
        this.m01 = (m1.m00 * m2.m01) + (m1.m01 * m2.m11) + (m1.m02 * m2.m21) + (m1.m03 * m2.m31);
        this.m02 = (m1.m00 * m2.m02) + (m1.m01 * m2.m12) + (m1.m02 * m2.m22) + (m1.m03 * m2.m32);
        this.m03 = (m1.m00 * m2.m03) + (m1.m01 * m2.m13) + (m1.m02 * m2.m23) + (m1.m03 * m2.m33);
        this.m10 = (m1.m10 * m2.m00) + (m1.m11 * m2.m10) + (m1.m12 * m2.m20) + (m1.m13 * m2.m30);
        this.m11 = (m1.m10 * m2.m01) + (m1.m11 * m2.m11) + (m1.m12 * m2.m21) + (m1.m13 * m2.m31);
        this.m12 = (m1.m10 * m2.m02) + (m1.m11 * m2.m12) + (m1.m12 * m2.m22) + (m1.m13 * m2.m32);
        this.m13 = (m1.m10 * m2.m03) + (m1.m11 * m2.m13) + (m1.m12 * m2.m23) + (m1.m13 * m2.m33);
        this.m20 = (m1.m20 * m2.m00) + (m1.m21 * m2.m10) + (m1.m22 * m2.m20) + (m1.m23 * m2.m30);
        this.m21 = (m1.m20 * m2.m01) + (m1.m21 * m2.m11) + (m1.m22 * m2.m21) + (m1.m23 * m2.m31);
        this.m22 = (m1.m20 * m2.m02) + (m1.m21 * m2.m12) + (m1.m22 * m2.m22) + (m1.m23 * m2.m32);
        this.m23 = (m1.m20 * m2.m03) + (m1.m21 * m2.m13) + (m1.m22 * m2.m23) + (m1.m23 * m2.m33);
        this.m30 = (m1.m30 * m2.m00) + (m1.m31 * m2.m10) + (m1.m32 * m2.m20) + (m1.m33 * m2.m30);
        this.m31 = (m1.m30 * m2.m01) + (m1.m31 * m2.m11) + (m1.m32 * m2.m21) + (m1.m33 * m2.m31);
        this.m32 = (m1.m30 * m2.m02) + (m1.m31 * m2.m12) + (m1.m32 * m2.m22) + (m1.m33 * m2.m32);
        this.m33 = (m1.m30 * m2.m03) + (m1.m31 * m2.m13) + (m1.m32 * m2.m23) + (m1.m33 * m2.m33);
    }

    public final void mulTransposeBoth(Matrix4f m1, Matrix4f m2) {
        if (this == m1 || this == m2) {
            float m002 = (m1.m00 * m2.m00) + (m1.m10 * m2.m01) + (m1.m20 * m2.m02) + (m1.m30 * m2.m03);
            float m012 = (m1.m00 * m2.m10) + (m1.m10 * m2.m11) + (m1.m20 * m2.m12) + (m1.m30 * m2.m13);
            float m022 = (m1.m00 * m2.m20) + (m1.m10 * m2.m21) + (m1.m20 * m2.m22) + (m1.m30 * m2.m23);
            float m032 = (m1.m00 * m2.m30) + (m1.m10 * m2.m31) + (m1.m20 * m2.m32) + (m1.m30 * m2.m33);
            float m102 = (m1.m01 * m2.m00) + (m1.m11 * m2.m01) + (m1.m21 * m2.m02) + (m1.m31 * m2.m03);
            float m112 = (m1.m01 * m2.m10) + (m1.m11 * m2.m11) + (m1.m21 * m2.m12) + (m1.m31 * m2.m13);
            float m122 = (m1.m01 * m2.m20) + (m1.m11 * m2.m21) + (m1.m21 * m2.m22) + (m1.m31 * m2.m23);
            float m132 = (m1.m01 * m2.m30) + (m1.m11 * m2.m31) + (m1.m21 * m2.m32) + (m1.m31 * m2.m33);
            float m202 = (m1.m02 * m2.m00) + (m1.m12 * m2.m01) + (m1.m22 * m2.m02) + (m1.m32 * m2.m03);
            float m212 = (m1.m02 * m2.m10) + (m1.m12 * m2.m11) + (m1.m22 * m2.m12) + (m1.m32 * m2.m13);
            float m222 = (m1.m02 * m2.m20) + (m1.m12 * m2.m21) + (m1.m22 * m2.m22) + (m1.m32 * m2.m23);
            float m232 = (m1.m02 * m2.m30) + (m1.m12 * m2.m31) + (m1.m22 * m2.m32) + (m1.m32 * m2.m33);
            float m302 = (m1.m03 * m2.m00) + (m1.m13 * m2.m01) + (m1.m23 * m2.m02) + (m1.m33 * m2.m03);
            float m312 = (m1.m03 * m2.m10) + (m1.m13 * m2.m11) + (m1.m23 * m2.m12) + (m1.m33 * m2.m13);
            float m322 = (m1.m03 * m2.m20) + (m1.m13 * m2.m21) + (m1.m23 * m2.m22) + (m1.m33 * m2.m23);
            this.m00 = m002;
            this.m01 = m012;
            this.m02 = m022;
            this.m03 = m032;
            this.m10 = m102;
            this.m11 = m112;
            this.m12 = m122;
            this.m13 = m132;
            this.m20 = m202;
            this.m21 = m212;
            this.m22 = m222;
            this.m23 = m232;
            this.m30 = m302;
            this.m31 = m312;
            this.m32 = m322;
            this.m33 = (m1.m03 * m2.m30) + (m1.m13 * m2.m31) + (m1.m23 * m2.m32) + (m1.m33 * m2.m33);
            return;
        }
        this.m00 = (m1.m00 * m2.m00) + (m1.m10 * m2.m01) + (m1.m20 * m2.m02) + (m1.m30 * m2.m03);
        this.m01 = (m1.m00 * m2.m10) + (m1.m10 * m2.m11) + (m1.m20 * m2.m12) + (m1.m30 * m2.m13);
        this.m02 = (m1.m00 * m2.m20) + (m1.m10 * m2.m21) + (m1.m20 * m2.m22) + (m1.m30 * m2.m23);
        this.m03 = (m1.m00 * m2.m30) + (m1.m10 * m2.m31) + (m1.m20 * m2.m32) + (m1.m30 * m2.m33);
        this.m10 = (m1.m01 * m2.m00) + (m1.m11 * m2.m01) + (m1.m21 * m2.m02) + (m1.m31 * m2.m03);
        this.m11 = (m1.m01 * m2.m10) + (m1.m11 * m2.m11) + (m1.m21 * m2.m12) + (m1.m31 * m2.m13);
        this.m12 = (m1.m01 * m2.m20) + (m1.m11 * m2.m21) + (m1.m21 * m2.m22) + (m1.m31 * m2.m23);
        this.m13 = (m1.m01 * m2.m30) + (m1.m11 * m2.m31) + (m1.m21 * m2.m32) + (m1.m31 * m2.m33);
        this.m20 = (m1.m02 * m2.m00) + (m1.m12 * m2.m01) + (m1.m22 * m2.m02) + (m1.m32 * m2.m03);
        this.m21 = (m1.m02 * m2.m10) + (m1.m12 * m2.m11) + (m1.m22 * m2.m12) + (m1.m32 * m2.m13);
        this.m22 = (m1.m02 * m2.m20) + (m1.m12 * m2.m21) + (m1.m22 * m2.m22) + (m1.m32 * m2.m23);
        this.m23 = (m1.m02 * m2.m30) + (m1.m12 * m2.m31) + (m1.m22 * m2.m32) + (m1.m32 * m2.m33);
        this.m30 = (m1.m03 * m2.m00) + (m1.m13 * m2.m01) + (m1.m23 * m2.m02) + (m1.m33 * m2.m03);
        this.m31 = (m1.m03 * m2.m10) + (m1.m13 * m2.m11) + (m1.m23 * m2.m12) + (m1.m33 * m2.m13);
        this.m32 = (m1.m03 * m2.m20) + (m1.m13 * m2.m21) + (m1.m23 * m2.m22) + (m1.m33 * m2.m23);
        this.m33 = (m1.m03 * m2.m30) + (m1.m13 * m2.m31) + (m1.m23 * m2.m32) + (m1.m33 * m2.m33);
    }

    public final void mulTransposeRight(Matrix4f m1, Matrix4f m2) {
        if (this == m1 || this == m2) {
            float m002 = (m1.m00 * m2.m00) + (m1.m01 * m2.m01) + (m1.m02 * m2.m02) + (m1.m03 * m2.m03);
            float m012 = (m1.m00 * m2.m10) + (m1.m01 * m2.m11) + (m1.m02 * m2.m12) + (m1.m03 * m2.m13);
            float m022 = (m1.m00 * m2.m20) + (m1.m01 * m2.m21) + (m1.m02 * m2.m22) + (m1.m03 * m2.m23);
            float m032 = (m1.m00 * m2.m30) + (m1.m01 * m2.m31) + (m1.m02 * m2.m32) + (m1.m03 * m2.m33);
            float m102 = (m1.m10 * m2.m00) + (m1.m11 * m2.m01) + (m1.m12 * m2.m02) + (m1.m13 * m2.m03);
            float m112 = (m1.m10 * m2.m10) + (m1.m11 * m2.m11) + (m1.m12 * m2.m12) + (m1.m13 * m2.m13);
            float m122 = (m1.m10 * m2.m20) + (m1.m11 * m2.m21) + (m1.m12 * m2.m22) + (m1.m13 * m2.m23);
            float m132 = (m1.m10 * m2.m30) + (m1.m11 * m2.m31) + (m1.m12 * m2.m32) + (m1.m13 * m2.m33);
            float m202 = (m1.m20 * m2.m00) + (m1.m21 * m2.m01) + (m1.m22 * m2.m02) + (m1.m23 * m2.m03);
            float m212 = (m1.m20 * m2.m10) + (m1.m21 * m2.m11) + (m1.m22 * m2.m12) + (m1.m23 * m2.m13);
            float m222 = (m1.m20 * m2.m20) + (m1.m21 * m2.m21) + (m1.m22 * m2.m22) + (m1.m23 * m2.m23);
            float m232 = (m1.m20 * m2.m30) + (m1.m21 * m2.m31) + (m1.m22 * m2.m32) + (m1.m23 * m2.m33);
            float m302 = (m1.m30 * m2.m00) + (m1.m31 * m2.m01) + (m1.m32 * m2.m02) + (m1.m33 * m2.m03);
            float m312 = (m1.m30 * m2.m10) + (m1.m31 * m2.m11) + (m1.m32 * m2.m12) + (m1.m33 * m2.m13);
            float m322 = (m1.m30 * m2.m20) + (m1.m31 * m2.m21) + (m1.m32 * m2.m22) + (m1.m33 * m2.m23);
            this.m00 = m002;
            this.m01 = m012;
            this.m02 = m022;
            this.m03 = m032;
            this.m10 = m102;
            this.m11 = m112;
            this.m12 = m122;
            this.m13 = m132;
            this.m20 = m202;
            this.m21 = m212;
            this.m22 = m222;
            this.m23 = m232;
            this.m30 = m302;
            this.m31 = m312;
            this.m32 = m322;
            this.m33 = (m1.m30 * m2.m30) + (m1.m31 * m2.m31) + (m1.m32 * m2.m32) + (m1.m33 * m2.m33);
            return;
        }
        this.m00 = (m1.m00 * m2.m00) + (m1.m01 * m2.m01) + (m1.m02 * m2.m02) + (m1.m03 * m2.m03);
        this.m01 = (m1.m00 * m2.m10) + (m1.m01 * m2.m11) + (m1.m02 * m2.m12) + (m1.m03 * m2.m13);
        this.m02 = (m1.m00 * m2.m20) + (m1.m01 * m2.m21) + (m1.m02 * m2.m22) + (m1.m03 * m2.m23);
        this.m03 = (m1.m00 * m2.m30) + (m1.m01 * m2.m31) + (m1.m02 * m2.m32) + (m1.m03 * m2.m33);
        this.m10 = (m1.m10 * m2.m00) + (m1.m11 * m2.m01) + (m1.m12 * m2.m02) + (m1.m13 * m2.m03);
        this.m11 = (m1.m10 * m2.m10) + (m1.m11 * m2.m11) + (m1.m12 * m2.m12) + (m1.m13 * m2.m13);
        this.m12 = (m1.m10 * m2.m20) + (m1.m11 * m2.m21) + (m1.m12 * m2.m22) + (m1.m13 * m2.m23);
        this.m13 = (m1.m10 * m2.m30) + (m1.m11 * m2.m31) + (m1.m12 * m2.m32) + (m1.m13 * m2.m33);
        this.m20 = (m1.m20 * m2.m00) + (m1.m21 * m2.m01) + (m1.m22 * m2.m02) + (m1.m23 * m2.m03);
        this.m21 = (m1.m20 * m2.m10) + (m1.m21 * m2.m11) + (m1.m22 * m2.m12) + (m1.m23 * m2.m13);
        this.m22 = (m1.m20 * m2.m20) + (m1.m21 * m2.m21) + (m1.m22 * m2.m22) + (m1.m23 * m2.m23);
        this.m23 = (m1.m20 * m2.m30) + (m1.m21 * m2.m31) + (m1.m22 * m2.m32) + (m1.m23 * m2.m33);
        this.m30 = (m1.m30 * m2.m00) + (m1.m31 * m2.m01) + (m1.m32 * m2.m02) + (m1.m33 * m2.m03);
        this.m31 = (m1.m30 * m2.m10) + (m1.m31 * m2.m11) + (m1.m32 * m2.m12) + (m1.m33 * m2.m13);
        this.m32 = (m1.m30 * m2.m20) + (m1.m31 * m2.m21) + (m1.m32 * m2.m22) + (m1.m33 * m2.m23);
        this.m33 = (m1.m30 * m2.m30) + (m1.m31 * m2.m31) + (m1.m32 * m2.m32) + (m1.m33 * m2.m33);
    }

    public final void mulTransposeLeft(Matrix4f m1, Matrix4f m2) {
        if (this == m1 || this == m2) {
            float m002 = (m1.m00 * m2.m00) + (m1.m10 * m2.m10) + (m1.m20 * m2.m20) + (m1.m30 * m2.m30);
            float m012 = (m1.m00 * m2.m01) + (m1.m10 * m2.m11) + (m1.m20 * m2.m21) + (m1.m30 * m2.m31);
            float m022 = (m1.m00 * m2.m02) + (m1.m10 * m2.m12) + (m1.m20 * m2.m22) + (m1.m30 * m2.m32);
            float m032 = (m1.m00 * m2.m03) + (m1.m10 * m2.m13) + (m1.m20 * m2.m23) + (m1.m30 * m2.m33);
            float m102 = (m1.m01 * m2.m00) + (m1.m11 * m2.m10) + (m1.m21 * m2.m20) + (m1.m31 * m2.m30);
            float m112 = (m1.m01 * m2.m01) + (m1.m11 * m2.m11) + (m1.m21 * m2.m21) + (m1.m31 * m2.m31);
            float m122 = (m1.m01 * m2.m02) + (m1.m11 * m2.m12) + (m1.m21 * m2.m22) + (m1.m31 * m2.m32);
            float m132 = (m1.m01 * m2.m03) + (m1.m11 * m2.m13) + (m1.m21 * m2.m23) + (m1.m31 * m2.m33);
            float m202 = (m1.m02 * m2.m00) + (m1.m12 * m2.m10) + (m1.m22 * m2.m20) + (m1.m32 * m2.m30);
            float m212 = (m1.m02 * m2.m01) + (m1.m12 * m2.m11) + (m1.m22 * m2.m21) + (m1.m32 * m2.m31);
            float m222 = (m1.m02 * m2.m02) + (m1.m12 * m2.m12) + (m1.m22 * m2.m22) + (m1.m32 * m2.m32);
            float m232 = (m1.m02 * m2.m03) + (m1.m12 * m2.m13) + (m1.m22 * m2.m23) + (m1.m32 * m2.m33);
            float m302 = (m1.m03 * m2.m00) + (m1.m13 * m2.m10) + (m1.m23 * m2.m20) + (m1.m33 * m2.m30);
            float m312 = (m1.m03 * m2.m01) + (m1.m13 * m2.m11) + (m1.m23 * m2.m21) + (m1.m33 * m2.m31);
            float m322 = (m1.m03 * m2.m02) + (m1.m13 * m2.m12) + (m1.m23 * m2.m22) + (m1.m33 * m2.m32);
            this.m00 = m002;
            this.m01 = m012;
            this.m02 = m022;
            this.m03 = m032;
            this.m10 = m102;
            this.m11 = m112;
            this.m12 = m122;
            this.m13 = m132;
            this.m20 = m202;
            this.m21 = m212;
            this.m22 = m222;
            this.m23 = m232;
            this.m30 = m302;
            this.m31 = m312;
            this.m32 = m322;
            this.m33 = (m1.m03 * m2.m03) + (m1.m13 * m2.m13) + (m1.m23 * m2.m23) + (m1.m33 * m2.m33);
            return;
        }
        this.m00 = (m1.m00 * m2.m00) + (m1.m10 * m2.m10) + (m1.m20 * m2.m20) + (m1.m30 * m2.m30);
        this.m01 = (m1.m00 * m2.m01) + (m1.m10 * m2.m11) + (m1.m20 * m2.m21) + (m1.m30 * m2.m31);
        this.m02 = (m1.m00 * m2.m02) + (m1.m10 * m2.m12) + (m1.m20 * m2.m22) + (m1.m30 * m2.m32);
        this.m03 = (m1.m00 * m2.m03) + (m1.m10 * m2.m13) + (m1.m20 * m2.m23) + (m1.m30 * m2.m33);
        this.m10 = (m1.m01 * m2.m00) + (m1.m11 * m2.m10) + (m1.m21 * m2.m20) + (m1.m31 * m2.m30);
        this.m11 = (m1.m01 * m2.m01) + (m1.m11 * m2.m11) + (m1.m21 * m2.m21) + (m1.m31 * m2.m31);
        this.m12 = (m1.m01 * m2.m02) + (m1.m11 * m2.m12) + (m1.m21 * m2.m22) + (m1.m31 * m2.m32);
        this.m13 = (m1.m01 * m2.m03) + (m1.m11 * m2.m13) + (m1.m21 * m2.m23) + (m1.m31 * m2.m33);
        this.m20 = (m1.m02 * m2.m00) + (m1.m12 * m2.m10) + (m1.m22 * m2.m20) + (m1.m32 * m2.m30);
        this.m21 = (m1.m02 * m2.m01) + (m1.m12 * m2.m11) + (m1.m22 * m2.m21) + (m1.m32 * m2.m31);
        this.m22 = (m1.m02 * m2.m02) + (m1.m12 * m2.m12) + (m1.m22 * m2.m22) + (m1.m32 * m2.m32);
        this.m23 = (m1.m02 * m2.m03) + (m1.m12 * m2.m13) + (m1.m22 * m2.m23) + (m1.m32 * m2.m33);
        this.m30 = (m1.m03 * m2.m00) + (m1.m13 * m2.m10) + (m1.m23 * m2.m20) + (m1.m33 * m2.m30);
        this.m31 = (m1.m03 * m2.m01) + (m1.m13 * m2.m11) + (m1.m23 * m2.m21) + (m1.m33 * m2.m31);
        this.m32 = (m1.m03 * m2.m02) + (m1.m13 * m2.m12) + (m1.m23 * m2.m22) + (m1.m33 * m2.m32);
        this.m33 = (m1.m03 * m2.m03) + (m1.m13 * m2.m13) + (m1.m23 * m2.m23) + (m1.m33 * m2.m33);
    }

    public boolean equals(Matrix4f m1) {
        try {
            return this.m00 == m1.m00 && this.m01 == m1.m01 && this.m02 == m1.m02 && this.m03 == m1.m03 && this.m10 == m1.m10 && this.m11 == m1.m11 && this.m12 == m1.m12 && this.m13 == m1.m13 && this.m20 == m1.m20 && this.m21 == m1.m21 && this.m22 == m1.m22 && this.m23 == m1.m23 && this.m30 == m1.m30 && this.m31 == m1.m31 && this.m32 == m1.m32 && this.m33 == m1.m33;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean equals(Object t1) {
        try {
            Matrix4f m2 = (Matrix4f) t1;
            if (this.m00 == m2.m00 && this.m01 == m2.m01 && this.m02 == m2.m02 && this.m03 == m2.m03 && this.m10 == m2.m10 && this.m11 == m2.m11 && this.m12 == m2.m12 && this.m13 == m2.m13 && this.m20 == m2.m20 && this.m21 == m2.m21 && this.m22 == m2.m22 && this.m23 == m2.m23 && this.m30 == m2.m30 && this.m31 == m2.m31 && this.m32 == m2.m32 && this.m33 == m2.m33) {
                return true;
            }
            return false;
        } catch (ClassCastException e) {
            return false;
        } catch (NullPointerException e2) {
            return false;
        }
    }

    public boolean epsilonEquals(Matrix4f m1, float epsilon) {
        boolean status = true;
        if (Math.abs(this.m00 - m1.m00) > epsilon) {
            status = false;
        }
        if (Math.abs(this.m01 - m1.m01) > epsilon) {
            status = false;
        }
        if (Math.abs(this.m02 - m1.m02) > epsilon) {
            status = false;
        }
        if (Math.abs(this.m03 - m1.m03) > epsilon) {
            status = false;
        }
        if (Math.abs(this.m10 - m1.m10) > epsilon) {
            status = false;
        }
        if (Math.abs(this.m11 - m1.m11) > epsilon) {
            status = false;
        }
        if (Math.abs(this.m12 - m1.m12) > epsilon) {
            status = false;
        }
        if (Math.abs(this.m13 - m1.m13) > epsilon) {
            status = false;
        }
        if (Math.abs(this.m20 - m1.m20) > epsilon) {
            status = false;
        }
        if (Math.abs(this.m21 - m1.m21) > epsilon) {
            status = false;
        }
        if (Math.abs(this.m22 - m1.m22) > epsilon) {
            status = false;
        }
        if (Math.abs(this.m23 - m1.m23) > epsilon) {
            status = false;
        }
        if (Math.abs(this.m30 - m1.m30) > epsilon) {
            status = false;
        }
        if (Math.abs(this.m31 - m1.m31) > epsilon) {
            status = false;
        }
        if (Math.abs(this.m32 - m1.m32) > epsilon) {
            status = false;
        }
        if (Math.abs(this.m33 - m1.m33) > epsilon) {
            return false;
        }
        return status;
    }

    public int hashCode() {
        long bits = (31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * 1) + ((long) VecMathUtil.floatToIntBits(this.m00)))) + ((long) VecMathUtil.floatToIntBits(this.m01)))) + ((long) VecMathUtil.floatToIntBits(this.m02)))) + ((long) VecMathUtil.floatToIntBits(this.m03)))) + ((long) VecMathUtil.floatToIntBits(this.m10)))) + ((long) VecMathUtil.floatToIntBits(this.m11)))) + ((long) VecMathUtil.floatToIntBits(this.m12)))) + ((long) VecMathUtil.floatToIntBits(this.m13)))) + ((long) VecMathUtil.floatToIntBits(this.m20)))) + ((long) VecMathUtil.floatToIntBits(this.m21)))) + ((long) VecMathUtil.floatToIntBits(this.m22)))) + ((long) VecMathUtil.floatToIntBits(this.m23)))) + ((long) VecMathUtil.floatToIntBits(this.m30)))) + ((long) VecMathUtil.floatToIntBits(this.m31)))) + ((long) VecMathUtil.floatToIntBits(this.m32)))) + ((long) VecMathUtil.floatToIntBits(this.m33));
        return (int) ((bits >> 32) ^ bits);
    }

    public final void transform(Tuple4f vec, Tuple4f vecOut) {
        float x = (this.m00 * vec.f173x) + (this.m01 * vec.f174y) + (this.m02 * vec.f175z) + (this.m03 * vec.f172w);
        float y = (this.m10 * vec.f173x) + (this.m11 * vec.f174y) + (this.m12 * vec.f175z) + (this.m13 * vec.f172w);
        float z = (this.m20 * vec.f173x) + (this.m21 * vec.f174y) + (this.m22 * vec.f175z) + (this.m23 * vec.f172w);
        vecOut.f172w = (this.m30 * vec.f173x) + (this.m31 * vec.f174y) + (this.m32 * vec.f175z) + (this.m33 * vec.f172w);
        vecOut.f173x = x;
        vecOut.f174y = y;
        vecOut.f175z = z;
    }

    public final void transform(Tuple4f vec) {
        float x = (this.m00 * vec.f173x) + (this.m01 * vec.f174y) + (this.m02 * vec.f175z) + (this.m03 * vec.f172w);
        float y = (this.m10 * vec.f173x) + (this.m11 * vec.f174y) + (this.m12 * vec.f175z) + (this.m13 * vec.f172w);
        float z = (this.m20 * vec.f173x) + (this.m21 * vec.f174y) + (this.m22 * vec.f175z) + (this.m23 * vec.f172w);
        vec.f172w = (this.m30 * vec.f173x) + (this.m31 * vec.f174y) + (this.m32 * vec.f175z) + (this.m33 * vec.f172w);
        vec.f173x = x;
        vec.f174y = y;
        vec.f175z = z;
    }

    public final void transform(Point3f point, Point3f pointOut) {
        float x = (this.m00 * point.f158x) + (this.m01 * point.f159y) + (this.m02 * point.f160z) + this.m03;
        float y = (this.m10 * point.f158x) + (this.m11 * point.f159y) + (this.m12 * point.f160z) + this.m13;
        pointOut.f160z = (this.m20 * point.f158x) + (this.m21 * point.f159y) + (this.m22 * point.f160z) + this.m23;
        pointOut.f158x = x;
        pointOut.f159y = y;
    }

    public final void transform(Point3f point) {
        float x = (this.m00 * point.f158x) + (this.m01 * point.f159y) + (this.m02 * point.f160z) + this.m03;
        float y = (this.m10 * point.f158x) + (this.m11 * point.f159y) + (this.m12 * point.f160z) + this.m13;
        point.f160z = (this.m20 * point.f158x) + (this.m21 * point.f159y) + (this.m22 * point.f160z) + this.m23;
        point.f158x = x;
        point.f159y = y;
    }

    public final void transform(Vector3f normal, Vector3f normalOut) {
        float x = (this.m00 * normal.f158x) + (this.m01 * normal.f159y) + (this.m02 * normal.f160z);
        float y = (this.m10 * normal.f158x) + (this.m11 * normal.f159y) + (this.m12 * normal.f160z);
        normalOut.f160z = (this.m20 * normal.f158x) + (this.m21 * normal.f159y) + (this.m22 * normal.f160z);
        normalOut.f158x = x;
        normalOut.f159y = y;
    }

    public final void transform(Vector3f normal) {
        float x = (this.m00 * normal.f158x) + (this.m01 * normal.f159y) + (this.m02 * normal.f160z);
        float y = (this.m10 * normal.f158x) + (this.m11 * normal.f159y) + (this.m12 * normal.f160z);
        normal.f160z = (this.m20 * normal.f158x) + (this.m21 * normal.f159y) + (this.m22 * normal.f160z);
        normal.f158x = x;
        normal.f159y = y;
    }

    public final void setRotation(Matrix3d m1) {
        double[] tmp_scale = new double[3];
        getScaleRotate(tmp_scale, new double[9]);
        this.m00 = (float) (m1.m00 * tmp_scale[0]);
        this.m01 = (float) (m1.m01 * tmp_scale[1]);
        this.m02 = (float) (m1.m02 * tmp_scale[2]);
        this.m10 = (float) (m1.m10 * tmp_scale[0]);
        this.m11 = (float) (m1.m11 * tmp_scale[1]);
        this.m12 = (float) (m1.m12 * tmp_scale[2]);
        this.m20 = (float) (m1.m20 * tmp_scale[0]);
        this.m21 = (float) (m1.m21 * tmp_scale[1]);
        this.m22 = (float) (m1.m22 * tmp_scale[2]);
    }

    public final void setRotation(Matrix3f m1) {
        double[] tmp_scale = new double[3];
        getScaleRotate(tmp_scale, new double[9]);
        this.m00 = (float) (((double) m1.m00) * tmp_scale[0]);
        this.m01 = (float) (((double) m1.m01) * tmp_scale[1]);
        this.m02 = (float) (((double) m1.m02) * tmp_scale[2]);
        this.m10 = (float) (((double) m1.m10) * tmp_scale[0]);
        this.m11 = (float) (((double) m1.m11) * tmp_scale[1]);
        this.m12 = (float) (((double) m1.m12) * tmp_scale[2]);
        this.m20 = (float) (((double) m1.m20) * tmp_scale[0]);
        this.m21 = (float) (((double) m1.m21) * tmp_scale[1]);
        this.m22 = (float) (((double) m1.m22) * tmp_scale[2]);
    }

    public final void setRotation(Quat4f q1) {
        double[] tmp_scale = new double[3];
        getScaleRotate(tmp_scale, new double[9]);
        this.m00 = (float) (((double) ((1.0f - ((q1.f174y * 2.0f) * q1.f174y)) - ((q1.f175z * 2.0f) * q1.f175z))) * tmp_scale[0]);
        this.m10 = (float) (((double) (((q1.f173x * q1.f174y) + (q1.f172w * q1.f175z)) * 2.0f)) * tmp_scale[0]);
        this.m20 = (float) (((double) (((q1.f173x * q1.f175z) - (q1.f172w * q1.f174y)) * 2.0f)) * tmp_scale[0]);
        this.m01 = (float) (((double) (((q1.f173x * q1.f174y) - (q1.f172w * q1.f175z)) * 2.0f)) * tmp_scale[1]);
        this.m11 = (float) (((double) ((1.0f - ((q1.f173x * 2.0f) * q1.f173x)) - ((q1.f175z * 2.0f) * q1.f175z))) * tmp_scale[1]);
        this.m21 = (float) (((double) (((q1.f174y * q1.f175z) + (q1.f172w * q1.f173x)) * 2.0f)) * tmp_scale[1]);
        this.m02 = (float) (((double) (((q1.f173x * q1.f175z) + (q1.f172w * q1.f174y)) * 2.0f)) * tmp_scale[2]);
        this.m12 = (float) (((double) (((q1.f174y * q1.f175z) - (q1.f172w * q1.f173x)) * 2.0f)) * tmp_scale[2]);
        this.m22 = (float) (((double) ((1.0f - ((q1.f173x * 2.0f) * q1.f173x)) - ((q1.f174y * 2.0f) * q1.f174y))) * tmp_scale[2]);
    }

    public final void setRotation(Quat4d q1) {
        double[] tmp_scale = new double[3];
        getScaleRotate(tmp_scale, new double[9]);
        this.m00 = (float) (((1.0d - ((2.0d * q1.f170y) * q1.f170y)) - ((2.0d * q1.f171z) * q1.f171z)) * tmp_scale[0]);
        this.m10 = (float) (2.0d * ((q1.f169x * q1.f170y) + (q1.f168w * q1.f171z)) * tmp_scale[0]);
        this.m20 = (float) (2.0d * ((q1.f169x * q1.f171z) - (q1.f168w * q1.f170y)) * tmp_scale[0]);
        this.m01 = (float) (2.0d * ((q1.f169x * q1.f170y) - (q1.f168w * q1.f171z)) * tmp_scale[1]);
        this.m11 = (float) (((1.0d - ((2.0d * q1.f169x) * q1.f169x)) - ((2.0d * q1.f171z) * q1.f171z)) * tmp_scale[1]);
        this.m21 = (float) (2.0d * ((q1.f170y * q1.f171z) + (q1.f168w * q1.f169x)) * tmp_scale[1]);
        this.m02 = (float) (2.0d * ((q1.f169x * q1.f171z) + (q1.f168w * q1.f170y)) * tmp_scale[2]);
        this.m12 = (float) (2.0d * ((q1.f170y * q1.f171z) - (q1.f168w * q1.f169x)) * tmp_scale[2]);
        this.m22 = (float) (((1.0d - ((2.0d * q1.f169x) * q1.f169x)) - ((2.0d * q1.f170y) * q1.f170y)) * tmp_scale[2]);
    }

    public final void setRotation(AxisAngle4f a1) {
        double[] tmp_scale = new double[3];
        getScaleRotate(tmp_scale, new double[9]);
        double mag = Math.sqrt((double) ((a1.f143x * a1.f143x) + (a1.f144y * a1.f144y) + (a1.f145z * a1.f145z)));
        if (mag < EPS) {
            this.m00 = 1.0f;
            this.m01 = 0.0f;
            this.m02 = 0.0f;
            this.m10 = 0.0f;
            this.m11 = 1.0f;
            this.m12 = 0.0f;
            this.m20 = 0.0f;
            this.m21 = 0.0f;
            this.m22 = 1.0f;
            return;
        }
        double mag2 = 1.0d / mag;
        double ax = ((double) a1.f143x) * mag2;
        double ay = ((double) a1.f144y) * mag2;
        double az = ((double) a1.f145z) * mag2;
        double sinTheta = Math.sin((double) a1.angle);
        double cosTheta = Math.cos((double) a1.angle);
        double t = 1.0d - cosTheta;
        double xz = (double) (a1.f143x * a1.f145z);
        double xy = (double) (a1.f143x * a1.f144y);
        double yz = (double) (a1.f144y * a1.f145z);
        this.m00 = (float) (((t * ax * ax) + cosTheta) * tmp_scale[0]);
        this.m01 = (float) (((t * xy) - (sinTheta * az)) * tmp_scale[1]);
        this.m02 = (float) (((t * xz) + (sinTheta * ay)) * tmp_scale[2]);
        this.m10 = (float) (((t * xy) + (sinTheta * az)) * tmp_scale[0]);
        this.m11 = (float) (((t * ay * ay) + cosTheta) * tmp_scale[1]);
        this.m12 = (float) (((t * yz) - (sinTheta * ax)) * tmp_scale[2]);
        this.m20 = (float) (((t * xz) - (sinTheta * ay)) * tmp_scale[0]);
        this.m21 = (float) (((t * yz) + (sinTheta * ax)) * tmp_scale[1]);
        this.m22 = (float) (((t * az * az) + cosTheta) * tmp_scale[2]);
    }

    public final void setZero() {
        this.m00 = 0.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 0.0f;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 0.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 0.0f;
    }

    public final void negate() {
        this.m00 = -this.m00;
        this.m01 = -this.m01;
        this.m02 = -this.m02;
        this.m03 = -this.m03;
        this.m10 = -this.m10;
        this.m11 = -this.m11;
        this.m12 = -this.m12;
        this.m13 = -this.m13;
        this.m20 = -this.m20;
        this.m21 = -this.m21;
        this.m22 = -this.m22;
        this.m23 = -this.m23;
        this.m30 = -this.m30;
        this.m31 = -this.m31;
        this.m32 = -this.m32;
        this.m33 = -this.m33;
    }

    public final void negate(Matrix4f m1) {
        this.m00 = -m1.m00;
        this.m01 = -m1.m01;
        this.m02 = -m1.m02;
        this.m03 = -m1.m03;
        this.m10 = -m1.m10;
        this.m11 = -m1.m11;
        this.m12 = -m1.m12;
        this.m13 = -m1.m13;
        this.m20 = -m1.m20;
        this.m21 = -m1.m21;
        this.m22 = -m1.m22;
        this.m23 = -m1.m23;
        this.m30 = -m1.m30;
        this.m31 = -m1.m31;
        this.m32 = -m1.m32;
        this.m33 = -m1.m33;
    }

    private final void getScaleRotate(double[] scales, double[] rots) {
        Matrix3d.compute_svd(new double[]{(double) this.m00, (double) this.m01, (double) this.m02, (double) this.m10, (double) this.m11, (double) this.m12, (double) this.m20, (double) this.m21, (double) this.m22}, scales, rots);
    }

    public Object clone() {
        try {
            return (Matrix4f) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public final float getM00() {
        return this.m00;
    }

    public final void setM00(float m002) {
        this.m00 = m002;
    }

    public final float getM01() {
        return this.m01;
    }

    public final void setM01(float m012) {
        this.m01 = m012;
    }

    public final float getM02() {
        return this.m02;
    }

    public final void setM02(float m022) {
        this.m02 = m022;
    }

    public final float getM10() {
        return this.m10;
    }

    public final void setM10(float m102) {
        this.m10 = m102;
    }

    public final float getM11() {
        return this.m11;
    }

    public final void setM11(float m112) {
        this.m11 = m112;
    }

    public final float getM12() {
        return this.m12;
    }

    public final void setM12(float m122) {
        this.m12 = m122;
    }

    public final float getM20() {
        return this.m20;
    }

    public final void setM20(float m202) {
        this.m20 = m202;
    }

    public final float getM21() {
        return this.m21;
    }

    public final void setM21(float m212) {
        this.m21 = m212;
    }

    public final float getM22() {
        return this.m22;
    }

    public final void setM22(float m222) {
        this.m22 = m222;
    }

    public final float getM03() {
        return this.m03;
    }

    public final void setM03(float m032) {
        this.m03 = m032;
    }

    public final float getM13() {
        return this.m13;
    }

    public final void setM13(float m132) {
        this.m13 = m132;
    }

    public final float getM23() {
        return this.m23;
    }

    public final void setM23(float m232) {
        this.m23 = m232;
    }

    public final float getM30() {
        return this.m30;
    }

    public final void setM30(float m302) {
        this.m30 = m302;
    }

    public final float getM31() {
        return this.m31;
    }

    public final void setM31(float m312) {
        this.m31 = m312;
    }

    public final float getM32() {
        return this.m32;
    }

    public final void setM32(float m322) {
        this.m32 = m322;
    }

    public final float getM33() {
        return this.m33;
    }

    public final void setM33(float m332) {
        this.m33 = m332;
    }
}
