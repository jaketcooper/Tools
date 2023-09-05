package javax.vecmath;

import com.github.mikephil.charting.utils.Utils;
import java.io.Serializable;

public class Matrix4d implements Serializable, Cloneable {
    private static final double EPS = 1.0E-10d;
    static final long serialVersionUID = 8223903484171633710L;
    public double m00;
    public double m01;
    public double m02;
    public double m03;
    public double m10;
    public double m11;
    public double m12;
    public double m13;
    public double m20;
    public double m21;
    public double m22;
    public double m23;
    public double m30;
    public double m31;
    public double m32;
    public double m33;

    public Matrix4d(double m002, double m012, double m022, double m032, double m102, double m112, double m122, double m132, double m202, double m212, double m222, double m232, double m302, double m312, double m322, double m332) {
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

    public Matrix4d(double[] v) {
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

    public Matrix4d(Quat4d q1, Vector3d t1, double s) {
        this.m00 = ((1.0d - ((2.0d * q1.f170y) * q1.f170y)) - ((2.0d * q1.f171z) * q1.f171z)) * s;
        this.m10 = 2.0d * ((q1.f169x * q1.f170y) + (q1.f168w * q1.f171z)) * s;
        this.m20 = 2.0d * ((q1.f169x * q1.f171z) - (q1.f168w * q1.f170y)) * s;
        this.m01 = 2.0d * ((q1.f169x * q1.f170y) - (q1.f168w * q1.f171z)) * s;
        this.m11 = ((1.0d - ((2.0d * q1.f169x) * q1.f169x)) - ((2.0d * q1.f171z) * q1.f171z)) * s;
        this.m21 = 2.0d * ((q1.f170y * q1.f171z) + (q1.f168w * q1.f169x)) * s;
        this.m02 = 2.0d * ((q1.f169x * q1.f171z) + (q1.f168w * q1.f170y)) * s;
        this.m12 = 2.0d * ((q1.f170y * q1.f171z) - (q1.f168w * q1.f169x)) * s;
        this.m22 = ((1.0d - ((2.0d * q1.f169x) * q1.f169x)) - ((2.0d * q1.f170y) * q1.f170y)) * s;
        this.m03 = t1.f155x;
        this.m13 = t1.f156y;
        this.m23 = t1.f157z;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public Matrix4d(Quat4f q1, Vector3d t1, double s) {
        this.m00 = ((1.0d - ((2.0d * ((double) q1.f174y)) * ((double) q1.f174y))) - ((2.0d * ((double) q1.f175z)) * ((double) q1.f175z))) * s;
        this.m10 = 2.0d * ((double) ((q1.f173x * q1.f174y) + (q1.f172w * q1.f175z))) * s;
        this.m20 = 2.0d * ((double) ((q1.f173x * q1.f175z) - (q1.f172w * q1.f174y))) * s;
        this.m01 = 2.0d * ((double) ((q1.f173x * q1.f174y) - (q1.f172w * q1.f175z))) * s;
        this.m11 = ((1.0d - ((2.0d * ((double) q1.f173x)) * ((double) q1.f173x))) - ((2.0d * ((double) q1.f175z)) * ((double) q1.f175z))) * s;
        this.m21 = 2.0d * ((double) ((q1.f174y * q1.f175z) + (q1.f172w * q1.f173x))) * s;
        this.m02 = 2.0d * ((double) ((q1.f173x * q1.f175z) + (q1.f172w * q1.f174y))) * s;
        this.m12 = 2.0d * ((double) ((q1.f174y * q1.f175z) - (q1.f172w * q1.f173x))) * s;
        this.m22 = ((1.0d - ((2.0d * ((double) q1.f173x)) * ((double) q1.f173x))) - ((2.0d * ((double) q1.f174y)) * ((double) q1.f174y))) * s;
        this.m03 = t1.f155x;
        this.m13 = t1.f156y;
        this.m23 = t1.f157z;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public Matrix4d(Matrix4d m1) {
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

    public Matrix4d(Matrix4f m1) {
        this.m00 = (double) m1.m00;
        this.m01 = (double) m1.m01;
        this.m02 = (double) m1.m02;
        this.m03 = (double) m1.m03;
        this.m10 = (double) m1.m10;
        this.m11 = (double) m1.m11;
        this.m12 = (double) m1.m12;
        this.m13 = (double) m1.m13;
        this.m20 = (double) m1.m20;
        this.m21 = (double) m1.m21;
        this.m22 = (double) m1.m22;
        this.m23 = (double) m1.m23;
        this.m30 = (double) m1.m30;
        this.m31 = (double) m1.m31;
        this.m32 = (double) m1.m32;
        this.m33 = (double) m1.m33;
    }

    public Matrix4d(Matrix3f m1, Vector3d t1, double s) {
        this.m00 = ((double) m1.m00) * s;
        this.m01 = ((double) m1.m01) * s;
        this.m02 = ((double) m1.m02) * s;
        this.m03 = t1.f155x;
        this.m10 = ((double) m1.m10) * s;
        this.m11 = ((double) m1.m11) * s;
        this.m12 = ((double) m1.m12) * s;
        this.m13 = t1.f156y;
        this.m20 = ((double) m1.m20) * s;
        this.m21 = ((double) m1.m21) * s;
        this.m22 = ((double) m1.m22) * s;
        this.m23 = t1.f157z;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public Matrix4d(Matrix3d m1, Vector3d t1, double s) {
        this.m00 = m1.m00 * s;
        this.m01 = m1.m01 * s;
        this.m02 = m1.m02 * s;
        this.m03 = t1.f155x;
        this.m10 = m1.m10 * s;
        this.m11 = m1.m11 * s;
        this.m12 = m1.m12 * s;
        this.m13 = t1.f156y;
        this.m20 = m1.m20 * s;
        this.m21 = m1.m21 * s;
        this.m22 = m1.m22 * s;
        this.m23 = t1.f157z;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public Matrix4d() {
        this.m00 = Utils.DOUBLE_EPSILON;
        this.m01 = Utils.DOUBLE_EPSILON;
        this.m02 = Utils.DOUBLE_EPSILON;
        this.m03 = Utils.DOUBLE_EPSILON;
        this.m10 = Utils.DOUBLE_EPSILON;
        this.m11 = Utils.DOUBLE_EPSILON;
        this.m12 = Utils.DOUBLE_EPSILON;
        this.m13 = Utils.DOUBLE_EPSILON;
        this.m20 = Utils.DOUBLE_EPSILON;
        this.m21 = Utils.DOUBLE_EPSILON;
        this.m22 = Utils.DOUBLE_EPSILON;
        this.m23 = Utils.DOUBLE_EPSILON;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = Utils.DOUBLE_EPSILON;
    }

    public String toString() {
        return this.m00 + ", " + this.m01 + ", " + this.m02 + ", " + this.m03 + "\n" + this.m10 + ", " + this.m11 + ", " + this.m12 + ", " + this.m13 + "\n" + this.m20 + ", " + this.m21 + ", " + this.m22 + ", " + this.m23 + "\n" + this.m30 + ", " + this.m31 + ", " + this.m32 + ", " + this.m33 + "\n";
    }

    public final void setIdentity() {
        this.m00 = 1.0d;
        this.m01 = Utils.DOUBLE_EPSILON;
        this.m02 = Utils.DOUBLE_EPSILON;
        this.m03 = Utils.DOUBLE_EPSILON;
        this.m10 = Utils.DOUBLE_EPSILON;
        this.m11 = 1.0d;
        this.m12 = Utils.DOUBLE_EPSILON;
        this.m13 = Utils.DOUBLE_EPSILON;
        this.m20 = Utils.DOUBLE_EPSILON;
        this.m21 = Utils.DOUBLE_EPSILON;
        this.m22 = 1.0d;
        this.m23 = Utils.DOUBLE_EPSILON;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public final void setElement(int row, int column, double value) {
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
                        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d0"));
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
                        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d0"));
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
                        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d0"));
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
                        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d0"));
                }
            default:
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d0"));
        }
    }

    public final double getElement(int row, int column) {
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
        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d1"));
    }

    public final void getRow(int row, Vector4d v) {
        if (row == 0) {
            v.f169x = this.m00;
            v.f170y = this.m01;
            v.f171z = this.m02;
            v.f168w = this.m03;
        } else if (row == 1) {
            v.f169x = this.m10;
            v.f170y = this.m11;
            v.f171z = this.m12;
            v.f168w = this.m13;
        } else if (row == 2) {
            v.f169x = this.m20;
            v.f170y = this.m21;
            v.f171z = this.m22;
            v.f168w = this.m23;
        } else if (row == 3) {
            v.f169x = this.m30;
            v.f170y = this.m31;
            v.f171z = this.m32;
            v.f168w = this.m33;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d2"));
        }
    }

    public final void getRow(int row, double[] v) {
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
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d2"));
        }
    }

    public final void getColumn(int column, Vector4d v) {
        if (column == 0) {
            v.f169x = this.m00;
            v.f170y = this.m10;
            v.f171z = this.m20;
            v.f168w = this.m30;
        } else if (column == 1) {
            v.f169x = this.m01;
            v.f170y = this.m11;
            v.f171z = this.m21;
            v.f168w = this.m31;
        } else if (column == 2) {
            v.f169x = this.m02;
            v.f170y = this.m12;
            v.f171z = this.m22;
            v.f168w = this.m32;
        } else if (column == 3) {
            v.f169x = this.m03;
            v.f170y = this.m13;
            v.f171z = this.m23;
            v.f168w = this.m33;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d3"));
        }
    }

    public final void getColumn(int column, double[] v) {
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
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d3"));
        }
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

    public final double get(Matrix3d m1, Vector3d t1) {
        double[] tmp_rot = new double[9];
        double[] tmp_scale = new double[3];
        getScaleRotate(tmp_scale, tmp_rot);
        m1.m00 = tmp_rot[0];
        m1.m01 = tmp_rot[1];
        m1.m02 = tmp_rot[2];
        m1.m10 = tmp_rot[3];
        m1.m11 = tmp_rot[4];
        m1.m12 = tmp_rot[5];
        m1.m20 = tmp_rot[6];
        m1.m21 = tmp_rot[7];
        m1.m22 = tmp_rot[8];
        t1.f155x = this.m03;
        t1.f156y = this.m13;
        t1.f157z = this.m23;
        return Matrix3d.max3(tmp_scale);
    }

    public final double get(Matrix3f m1, Vector3d t1) {
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
        t1.f155x = this.m03;
        t1.f156y = this.m13;
        t1.f157z = this.m23;
        return Matrix3d.max3(tmp_scale);
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

    public final void get(Quat4d q1) {
        double d;
        double d2;
        double[] tmp_rot = new double[9];
        getScaleRotate(new double[3], tmp_rot);
        double ww = 0.25d * (1.0d + tmp_rot[0] + tmp_rot[4] + tmp_rot[8]);
        if ((ww < Utils.DOUBLE_EPSILON ? -ww : ww) >= 1.0E-30d) {
            q1.f168w = Math.sqrt(ww);
            double ww2 = 0.25d / q1.f168w;
            q1.f169x = (tmp_rot[7] - tmp_rot[5]) * ww2;
            q1.f170y = (tmp_rot[2] - tmp_rot[6]) * ww2;
            q1.f171z = (tmp_rot[3] - tmp_rot[1]) * ww2;
            return;
        }
        q1.f168w = Utils.DOUBLE_EPSILON;
        double ww3 = -0.5d * (tmp_rot[4] + tmp_rot[8]);
        if (ww3 < Utils.DOUBLE_EPSILON) {
            d = -ww3;
        } else {
            d = ww3;
        }
        if (d >= 1.0E-30d) {
            q1.f169x = Math.sqrt(ww3);
            double ww4 = 0.5d / q1.f169x;
            q1.f170y = tmp_rot[3] * ww4;
            q1.f171z = tmp_rot[6] * ww4;
            return;
        }
        q1.f169x = Utils.DOUBLE_EPSILON;
        double ww5 = 0.5d * (1.0d - tmp_rot[8]);
        if (ww5 < Utils.DOUBLE_EPSILON) {
            d2 = -ww5;
        } else {
            d2 = ww5;
        }
        if (d2 >= 1.0E-30d) {
            q1.f170y = Math.sqrt(ww5);
            q1.f171z = tmp_rot[7] / (2.0d * q1.f170y);
            return;
        }
        q1.f170y = Utils.DOUBLE_EPSILON;
        q1.f171z = 1.0d;
    }

    public final void get(Vector3d trans) {
        trans.f155x = this.m03;
        trans.f156y = this.m13;
        trans.f157z = this.m23;
    }

    public final void getRotationScale(Matrix3f m1) {
        m1.m00 = (float) this.m00;
        m1.m01 = (float) this.m01;
        m1.m02 = (float) this.m02;
        m1.m10 = (float) this.m10;
        m1.m11 = (float) this.m11;
        m1.m12 = (float) this.m12;
        m1.m20 = (float) this.m20;
        m1.m21 = (float) this.m21;
        m1.m22 = (float) this.m22;
    }

    public final void getRotationScale(Matrix3d m1) {
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

    public final double getScale() {
        double[] tmp_scale = new double[3];
        getScaleRotate(tmp_scale, new double[9]);
        return Matrix3d.max3(tmp_scale);
    }

    public final void setRotationScale(Matrix3d m1) {
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

    public final void setRotationScale(Matrix3f m1) {
        this.m00 = (double) m1.m00;
        this.m01 = (double) m1.m01;
        this.m02 = (double) m1.m02;
        this.m10 = (double) m1.m10;
        this.m11 = (double) m1.m11;
        this.m12 = (double) m1.m12;
        this.m20 = (double) m1.m20;
        this.m21 = (double) m1.m21;
        this.m22 = (double) m1.m22;
    }

    public final void setScale(double scale) {
        double[] tmp_rot = new double[9];
        getScaleRotate(new double[3], tmp_rot);
        this.m00 = tmp_rot[0] * scale;
        this.m01 = tmp_rot[1] * scale;
        this.m02 = tmp_rot[2] * scale;
        this.m10 = tmp_rot[3] * scale;
        this.m11 = tmp_rot[4] * scale;
        this.m12 = tmp_rot[5] * scale;
        this.m20 = tmp_rot[6] * scale;
        this.m21 = tmp_rot[7] * scale;
        this.m22 = tmp_rot[8] * scale;
    }

    public final void setRow(int row, double x, double y, double z, double w) {
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
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d4"));
        }
    }

    public final void setRow(int row, Vector4d v) {
        switch (row) {
            case 0:
                this.m00 = v.f169x;
                this.m01 = v.f170y;
                this.m02 = v.f171z;
                this.m03 = v.f168w;
                return;
            case 1:
                this.m10 = v.f169x;
                this.m11 = v.f170y;
                this.m12 = v.f171z;
                this.m13 = v.f168w;
                return;
            case 2:
                this.m20 = v.f169x;
                this.m21 = v.f170y;
                this.m22 = v.f171z;
                this.m23 = v.f168w;
                return;
            case 3:
                this.m30 = v.f169x;
                this.m31 = v.f170y;
                this.m32 = v.f171z;
                this.m33 = v.f168w;
                return;
            default:
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d4"));
        }
    }

    public final void setRow(int row, double[] v) {
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
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d4"));
        }
    }

    public final void setColumn(int column, double x, double y, double z, double w) {
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
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d7"));
        }
    }

    public final void setColumn(int column, Vector4d v) {
        switch (column) {
            case 0:
                this.m00 = v.f169x;
                this.m10 = v.f170y;
                this.m20 = v.f171z;
                this.m30 = v.f168w;
                return;
            case 1:
                this.m01 = v.f169x;
                this.m11 = v.f170y;
                this.m21 = v.f171z;
                this.m31 = v.f168w;
                return;
            case 2:
                this.m02 = v.f169x;
                this.m12 = v.f170y;
                this.m22 = v.f171z;
                this.m32 = v.f168w;
                return;
            case 3:
                this.m03 = v.f169x;
                this.m13 = v.f170y;
                this.m23 = v.f171z;
                this.m33 = v.f168w;
                return;
            default:
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d7"));
        }
    }

    public final void setColumn(int column, double[] v) {
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
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d7"));
        }
    }

    public final void add(double scalar) {
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

    public final void add(double scalar, Matrix4d m1) {
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

    public final void add(Matrix4d m1, Matrix4d m2) {
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

    public final void add(Matrix4d m1) {
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

    public final void sub(Matrix4d m1, Matrix4d m2) {
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

    public final void sub(Matrix4d m1) {
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
        double temp = this.m10;
        this.m10 = this.m01;
        this.m01 = temp;
        double temp2 = this.m20;
        this.m20 = this.m02;
        this.m02 = temp2;
        double temp3 = this.m30;
        this.m30 = this.m03;
        this.m03 = temp3;
        double temp4 = this.m21;
        this.m21 = this.m12;
        this.m12 = temp4;
        double temp5 = this.m31;
        this.m31 = this.m13;
        this.m13 = temp5;
        double temp6 = this.m32;
        this.m32 = this.m23;
        this.m23 = temp6;
    }

    public final void transpose(Matrix4d m1) {
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

    public final void set(double[] m) {
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

    public final void set(Matrix3f m1) {
        this.m00 = (double) m1.m00;
        this.m01 = (double) m1.m01;
        this.m02 = (double) m1.m02;
        this.m03 = Utils.DOUBLE_EPSILON;
        this.m10 = (double) m1.m10;
        this.m11 = (double) m1.m11;
        this.m12 = (double) m1.m12;
        this.m13 = Utils.DOUBLE_EPSILON;
        this.m20 = (double) m1.m20;
        this.m21 = (double) m1.m21;
        this.m22 = (double) m1.m22;
        this.m23 = Utils.DOUBLE_EPSILON;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public final void set(Matrix3d m1) {
        this.m00 = m1.m00;
        this.m01 = m1.m01;
        this.m02 = m1.m02;
        this.m03 = Utils.DOUBLE_EPSILON;
        this.m10 = m1.m10;
        this.m11 = m1.m11;
        this.m12 = m1.m12;
        this.m13 = Utils.DOUBLE_EPSILON;
        this.m20 = m1.m20;
        this.m21 = m1.m21;
        this.m22 = m1.m22;
        this.m23 = Utils.DOUBLE_EPSILON;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public final void set(Quat4d q1) {
        this.m00 = (1.0d - ((q1.f170y * 2.0d) * q1.f170y)) - ((q1.f171z * 2.0d) * q1.f171z);
        this.m10 = ((q1.f169x * q1.f170y) + (q1.f168w * q1.f171z)) * 2.0d;
        this.m20 = ((q1.f169x * q1.f171z) - (q1.f168w * q1.f170y)) * 2.0d;
        this.m01 = ((q1.f169x * q1.f170y) - (q1.f168w * q1.f171z)) * 2.0d;
        this.m11 = (1.0d - ((q1.f169x * 2.0d) * q1.f169x)) - ((q1.f171z * 2.0d) * q1.f171z);
        this.m21 = ((q1.f170y * q1.f171z) + (q1.f168w * q1.f169x)) * 2.0d;
        this.m02 = ((q1.f169x * q1.f171z) + (q1.f168w * q1.f170y)) * 2.0d;
        this.m12 = ((q1.f170y * q1.f171z) - (q1.f168w * q1.f169x)) * 2.0d;
        this.m22 = (1.0d - ((q1.f169x * 2.0d) * q1.f169x)) - ((q1.f170y * 2.0d) * q1.f170y);
        this.m03 = Utils.DOUBLE_EPSILON;
        this.m13 = Utils.DOUBLE_EPSILON;
        this.m23 = Utils.DOUBLE_EPSILON;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public final void set(AxisAngle4d a1) {
        double mag = Math.sqrt((a1.f140x * a1.f140x) + (a1.f141y * a1.f141y) + (a1.f142z * a1.f142z));
        if (mag < EPS) {
            this.m00 = 1.0d;
            this.m01 = Utils.DOUBLE_EPSILON;
            this.m02 = Utils.DOUBLE_EPSILON;
            this.m10 = Utils.DOUBLE_EPSILON;
            this.m11 = 1.0d;
            this.m12 = Utils.DOUBLE_EPSILON;
            this.m20 = Utils.DOUBLE_EPSILON;
            this.m21 = Utils.DOUBLE_EPSILON;
            this.m22 = 1.0d;
        } else {
            double mag2 = 1.0d / mag;
            double ax = a1.f140x * mag2;
            double ay = a1.f141y * mag2;
            double az = a1.f142z * mag2;
            double sinTheta = Math.sin(a1.angle);
            double cosTheta = Math.cos(a1.angle);
            double t = 1.0d - cosTheta;
            double xz = ax * az;
            double xy = ax * ay;
            double yz = ay * az;
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
        this.m03 = Utils.DOUBLE_EPSILON;
        this.m13 = Utils.DOUBLE_EPSILON;
        this.m23 = Utils.DOUBLE_EPSILON;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public final void set(Quat4f q1) {
        this.m00 = (1.0d - ((((double) q1.f174y) * 2.0d) * ((double) q1.f174y))) - ((((double) q1.f175z) * 2.0d) * ((double) q1.f175z));
        this.m10 = ((double) ((q1.f173x * q1.f174y) + (q1.f172w * q1.f175z))) * 2.0d;
        this.m20 = ((double) ((q1.f173x * q1.f175z) - (q1.f172w * q1.f174y))) * 2.0d;
        this.m01 = ((double) ((q1.f173x * q1.f174y) - (q1.f172w * q1.f175z))) * 2.0d;
        this.m11 = (1.0d - ((((double) q1.f173x) * 2.0d) * ((double) q1.f173x))) - ((((double) q1.f175z) * 2.0d) * ((double) q1.f175z));
        this.m21 = ((double) ((q1.f174y * q1.f175z) + (q1.f172w * q1.f173x))) * 2.0d;
        this.m02 = ((double) ((q1.f173x * q1.f175z) + (q1.f172w * q1.f174y))) * 2.0d;
        this.m12 = ((double) ((q1.f174y * q1.f175z) - (q1.f172w * q1.f173x))) * 2.0d;
        this.m22 = (1.0d - ((((double) q1.f173x) * 2.0d) * ((double) q1.f173x))) - ((((double) q1.f174y) * 2.0d) * ((double) q1.f174y));
        this.m03 = Utils.DOUBLE_EPSILON;
        this.m13 = Utils.DOUBLE_EPSILON;
        this.m23 = Utils.DOUBLE_EPSILON;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public final void set(AxisAngle4f a1) {
        double mag = Math.sqrt((double) ((a1.f143x * a1.f143x) + (a1.f144y * a1.f144y) + (a1.f145z * a1.f145z)));
        if (mag < EPS) {
            this.m00 = 1.0d;
            this.m01 = Utils.DOUBLE_EPSILON;
            this.m02 = Utils.DOUBLE_EPSILON;
            this.m10 = Utils.DOUBLE_EPSILON;
            this.m11 = 1.0d;
            this.m12 = Utils.DOUBLE_EPSILON;
            this.m20 = Utils.DOUBLE_EPSILON;
            this.m21 = Utils.DOUBLE_EPSILON;
            this.m22 = 1.0d;
        } else {
            double mag2 = 1.0d / mag;
            double ax = ((double) a1.f143x) * mag2;
            double ay = ((double) a1.f144y) * mag2;
            double az = ((double) a1.f145z) * mag2;
            double sinTheta = Math.sin((double) a1.angle);
            double cosTheta = Math.cos((double) a1.angle);
            double t = 1.0d - cosTheta;
            double xz = ax * az;
            double xy = ax * ay;
            double yz = ay * az;
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
        this.m03 = Utils.DOUBLE_EPSILON;
        this.m13 = Utils.DOUBLE_EPSILON;
        this.m23 = Utils.DOUBLE_EPSILON;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public final void set(Quat4d q1, Vector3d t1, double s) {
        this.m00 = ((1.0d - ((2.0d * q1.f170y) * q1.f170y)) - ((2.0d * q1.f171z) * q1.f171z)) * s;
        this.m10 = 2.0d * ((q1.f169x * q1.f170y) + (q1.f168w * q1.f171z)) * s;
        this.m20 = 2.0d * ((q1.f169x * q1.f171z) - (q1.f168w * q1.f170y)) * s;
        this.m01 = 2.0d * ((q1.f169x * q1.f170y) - (q1.f168w * q1.f171z)) * s;
        this.m11 = ((1.0d - ((2.0d * q1.f169x) * q1.f169x)) - ((2.0d * q1.f171z) * q1.f171z)) * s;
        this.m21 = 2.0d * ((q1.f170y * q1.f171z) + (q1.f168w * q1.f169x)) * s;
        this.m02 = 2.0d * ((q1.f169x * q1.f171z) + (q1.f168w * q1.f170y)) * s;
        this.m12 = 2.0d * ((q1.f170y * q1.f171z) - (q1.f168w * q1.f169x)) * s;
        this.m22 = ((1.0d - ((2.0d * q1.f169x) * q1.f169x)) - ((2.0d * q1.f170y) * q1.f170y)) * s;
        this.m03 = t1.f155x;
        this.m13 = t1.f156y;
        this.m23 = t1.f157z;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public final void set(Quat4f q1, Vector3d t1, double s) {
        this.m00 = ((1.0d - ((2.0d * ((double) q1.f174y)) * ((double) q1.f174y))) - ((2.0d * ((double) q1.f175z)) * ((double) q1.f175z))) * s;
        this.m10 = 2.0d * ((double) ((q1.f173x * q1.f174y) + (q1.f172w * q1.f175z))) * s;
        this.m20 = 2.0d * ((double) ((q1.f173x * q1.f175z) - (q1.f172w * q1.f174y))) * s;
        this.m01 = 2.0d * ((double) ((q1.f173x * q1.f174y) - (q1.f172w * q1.f175z))) * s;
        this.m11 = ((1.0d - ((2.0d * ((double) q1.f173x)) * ((double) q1.f173x))) - ((2.0d * ((double) q1.f175z)) * ((double) q1.f175z))) * s;
        this.m21 = 2.0d * ((double) ((q1.f174y * q1.f175z) + (q1.f172w * q1.f173x))) * s;
        this.m02 = 2.0d * ((double) ((q1.f173x * q1.f175z) + (q1.f172w * q1.f174y))) * s;
        this.m12 = 2.0d * ((double) ((q1.f174y * q1.f175z) - (q1.f172w * q1.f173x))) * s;
        this.m22 = ((1.0d - ((2.0d * ((double) q1.f173x)) * ((double) q1.f173x))) - ((2.0d * ((double) q1.f174y)) * ((double) q1.f174y))) * s;
        this.m03 = t1.f155x;
        this.m13 = t1.f156y;
        this.m23 = t1.f157z;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public final void set(Quat4f q1, Vector3f t1, float s) {
        this.m00 = ((double) s) * ((1.0d - ((2.0d * ((double) q1.f174y)) * ((double) q1.f174y))) - ((2.0d * ((double) q1.f175z)) * ((double) q1.f175z)));
        this.m10 = ((double) s) * 2.0d * ((double) ((q1.f173x * q1.f174y) + (q1.f172w * q1.f175z)));
        this.m20 = ((double) s) * 2.0d * ((double) ((q1.f173x * q1.f175z) - (q1.f172w * q1.f174y)));
        this.m01 = ((double) s) * 2.0d * ((double) ((q1.f173x * q1.f174y) - (q1.f172w * q1.f175z)));
        this.m11 = ((double) s) * ((1.0d - ((2.0d * ((double) q1.f173x)) * ((double) q1.f173x))) - ((2.0d * ((double) q1.f175z)) * ((double) q1.f175z)));
        this.m21 = ((double) s) * 2.0d * ((double) ((q1.f174y * q1.f175z) + (q1.f172w * q1.f173x)));
        this.m02 = ((double) s) * 2.0d * ((double) ((q1.f173x * q1.f175z) + (q1.f172w * q1.f174y)));
        this.m12 = ((double) s) * 2.0d * ((double) ((q1.f174y * q1.f175z) - (q1.f172w * q1.f173x)));
        this.m22 = ((double) s) * ((1.0d - ((2.0d * ((double) q1.f173x)) * ((double) q1.f173x))) - ((2.0d * ((double) q1.f174y)) * ((double) q1.f174y)));
        this.m03 = (double) t1.f158x;
        this.m13 = (double) t1.f159y;
        this.m23 = (double) t1.f160z;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public final void set(Matrix4f m1) {
        this.m00 = (double) m1.m00;
        this.m01 = (double) m1.m01;
        this.m02 = (double) m1.m02;
        this.m03 = (double) m1.m03;
        this.m10 = (double) m1.m10;
        this.m11 = (double) m1.m11;
        this.m12 = (double) m1.m12;
        this.m13 = (double) m1.m13;
        this.m20 = (double) m1.m20;
        this.m21 = (double) m1.m21;
        this.m22 = (double) m1.m22;
        this.m23 = (double) m1.m23;
        this.m30 = (double) m1.m30;
        this.m31 = (double) m1.m31;
        this.m32 = (double) m1.m32;
        this.m33 = (double) m1.m33;
    }

    public final void set(Matrix4d m1) {
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

    public final void invert(Matrix4d m1) {
        invertGeneral(m1);
    }

    public final void invert() {
        invertGeneral(this);
    }

    /* access modifiers changed from: package-private */
    public final void invertGeneral(Matrix4d m1) {
        double[] result = new double[16];
        int[] row_perm = new int[4];
        double[] tmp = {m1.m00, m1.m01, m1.m02, m1.m03, m1.m10, m1.m11, m1.m12, m1.m13, m1.m20, m1.m21, m1.m22, m1.m23, m1.m30, m1.m31, m1.m32, m1.m33};
        if (!luDecomposition(tmp, row_perm)) {
            throw new SingularMatrixException(VecMathI18N.getString("Matrix4d10"));
        }
        for (int i = 0; i < 16; i++) {
            result[i] = 0.0d;
        }
        result[0] = 1.0d;
        result[5] = 1.0d;
        result[10] = 1.0d;
        result[15] = 1.0d;
        luBacksubstitution(tmp, row_perm, result);
        this.m00 = result[0];
        this.m01 = result[1];
        this.m02 = result[2];
        this.m03 = result[3];
        this.m10 = result[4];
        this.m11 = result[5];
        this.m12 = result[6];
        this.m13 = result[7];
        this.m20 = result[8];
        this.m21 = result[9];
        this.m22 = result[10];
        this.m23 = result[11];
        this.m30 = result[12];
        this.m31 = result[13];
        this.m32 = result[14];
        this.m33 = result[15];
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
                        throw new RuntimeException(VecMathI18N.getString("Matrix4d11"));
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

    public final double determinant() {
        return (((this.m00 * (((((((this.m11 * this.m22) * this.m33) + ((this.m12 * this.m23) * this.m31)) + ((this.m13 * this.m21) * this.m32)) - ((this.m13 * this.m22) * this.m31)) - ((this.m11 * this.m23) * this.m32)) - ((this.m12 * this.m21) * this.m33))) - (this.m01 * (((((((this.m10 * this.m22) * this.m33) + ((this.m12 * this.m23) * this.m30)) + ((this.m13 * this.m20) * this.m32)) - ((this.m13 * this.m22) * this.m30)) - ((this.m10 * this.m23) * this.m32)) - ((this.m12 * this.m20) * this.m33)))) + (this.m02 * (((((((this.m10 * this.m21) * this.m33) + ((this.m11 * this.m23) * this.m30)) + ((this.m13 * this.m20) * this.m31)) - ((this.m13 * this.m21) * this.m30)) - ((this.m10 * this.m23) * this.m31)) - ((this.m11 * this.m20) * this.m33)))) - (this.m03 * (((((((this.m10 * this.m21) * this.m32) + ((this.m11 * this.m22) * this.m30)) + ((this.m12 * this.m20) * this.m31)) - ((this.m12 * this.m21) * this.m30)) - ((this.m10 * this.m22) * this.m31)) - ((this.m11 * this.m20) * this.m32)));
    }

    public final void set(double scale) {
        this.m00 = scale;
        this.m01 = Utils.DOUBLE_EPSILON;
        this.m02 = Utils.DOUBLE_EPSILON;
        this.m03 = Utils.DOUBLE_EPSILON;
        this.m10 = Utils.DOUBLE_EPSILON;
        this.m11 = scale;
        this.m12 = Utils.DOUBLE_EPSILON;
        this.m13 = Utils.DOUBLE_EPSILON;
        this.m20 = Utils.DOUBLE_EPSILON;
        this.m21 = Utils.DOUBLE_EPSILON;
        this.m22 = scale;
        this.m23 = Utils.DOUBLE_EPSILON;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public final void set(Vector3d v1) {
        this.m00 = 1.0d;
        this.m01 = Utils.DOUBLE_EPSILON;
        this.m02 = Utils.DOUBLE_EPSILON;
        this.m03 = v1.f155x;
        this.m10 = Utils.DOUBLE_EPSILON;
        this.m11 = 1.0d;
        this.m12 = Utils.DOUBLE_EPSILON;
        this.m13 = v1.f156y;
        this.m20 = Utils.DOUBLE_EPSILON;
        this.m21 = Utils.DOUBLE_EPSILON;
        this.m22 = 1.0d;
        this.m23 = v1.f157z;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public final void set(double scale, Vector3d v1) {
        this.m00 = scale;
        this.m01 = Utils.DOUBLE_EPSILON;
        this.m02 = Utils.DOUBLE_EPSILON;
        this.m03 = v1.f155x;
        this.m10 = Utils.DOUBLE_EPSILON;
        this.m11 = scale;
        this.m12 = Utils.DOUBLE_EPSILON;
        this.m13 = v1.f156y;
        this.m20 = Utils.DOUBLE_EPSILON;
        this.m21 = Utils.DOUBLE_EPSILON;
        this.m22 = scale;
        this.m23 = v1.f157z;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public final void set(Vector3d v1, double scale) {
        this.m00 = scale;
        this.m01 = Utils.DOUBLE_EPSILON;
        this.m02 = Utils.DOUBLE_EPSILON;
        this.m03 = v1.f155x * scale;
        this.m10 = Utils.DOUBLE_EPSILON;
        this.m11 = scale;
        this.m12 = Utils.DOUBLE_EPSILON;
        this.m13 = v1.f156y * scale;
        this.m20 = Utils.DOUBLE_EPSILON;
        this.m21 = Utils.DOUBLE_EPSILON;
        this.m22 = scale;
        this.m23 = v1.f157z * scale;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public final void set(Matrix3f m1, Vector3f t1, float scale) {
        this.m00 = (double) (m1.m00 * scale);
        this.m01 = (double) (m1.m01 * scale);
        this.m02 = (double) (m1.m02 * scale);
        this.m03 = (double) t1.f158x;
        this.m10 = (double) (m1.m10 * scale);
        this.m11 = (double) (m1.m11 * scale);
        this.m12 = (double) (m1.m12 * scale);
        this.m13 = (double) t1.f159y;
        this.m20 = (double) (m1.m20 * scale);
        this.m21 = (double) (m1.m21 * scale);
        this.m22 = (double) (m1.m22 * scale);
        this.m23 = (double) t1.f160z;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public final void set(Matrix3d m1, Vector3d t1, double scale) {
        this.m00 = m1.m00 * scale;
        this.m01 = m1.m01 * scale;
        this.m02 = m1.m02 * scale;
        this.m03 = t1.f155x;
        this.m10 = m1.m10 * scale;
        this.m11 = m1.m11 * scale;
        this.m12 = m1.m12 * scale;
        this.m13 = t1.f156y;
        this.m20 = m1.m20 * scale;
        this.m21 = m1.m21 * scale;
        this.m22 = m1.m22 * scale;
        this.m23 = t1.f157z;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public final void setTranslation(Vector3d trans) {
        this.m03 = trans.f155x;
        this.m13 = trans.f156y;
        this.m23 = trans.f157z;
    }

    public final void rotX(double angle) {
        double sinAngle = Math.sin(angle);
        double cosAngle = Math.cos(angle);
        this.m00 = 1.0d;
        this.m01 = Utils.DOUBLE_EPSILON;
        this.m02 = Utils.DOUBLE_EPSILON;
        this.m03 = Utils.DOUBLE_EPSILON;
        this.m10 = Utils.DOUBLE_EPSILON;
        this.m11 = cosAngle;
        this.m12 = -sinAngle;
        this.m13 = Utils.DOUBLE_EPSILON;
        this.m20 = Utils.DOUBLE_EPSILON;
        this.m21 = sinAngle;
        this.m22 = cosAngle;
        this.m23 = Utils.DOUBLE_EPSILON;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public final void rotY(double angle) {
        double sinAngle = Math.sin(angle);
        double cosAngle = Math.cos(angle);
        this.m00 = cosAngle;
        this.m01 = Utils.DOUBLE_EPSILON;
        this.m02 = sinAngle;
        this.m03 = Utils.DOUBLE_EPSILON;
        this.m10 = Utils.DOUBLE_EPSILON;
        this.m11 = 1.0d;
        this.m12 = Utils.DOUBLE_EPSILON;
        this.m13 = Utils.DOUBLE_EPSILON;
        this.m20 = -sinAngle;
        this.m21 = Utils.DOUBLE_EPSILON;
        this.m22 = cosAngle;
        this.m23 = Utils.DOUBLE_EPSILON;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public final void rotZ(double angle) {
        double sinAngle = Math.sin(angle);
        double cosAngle = Math.cos(angle);
        this.m00 = cosAngle;
        this.m01 = -sinAngle;
        this.m02 = Utils.DOUBLE_EPSILON;
        this.m03 = Utils.DOUBLE_EPSILON;
        this.m10 = sinAngle;
        this.m11 = cosAngle;
        this.m12 = Utils.DOUBLE_EPSILON;
        this.m13 = Utils.DOUBLE_EPSILON;
        this.m20 = Utils.DOUBLE_EPSILON;
        this.m21 = Utils.DOUBLE_EPSILON;
        this.m22 = 1.0d;
        this.m23 = Utils.DOUBLE_EPSILON;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = 1.0d;
    }

    public final void mul(double scalar) {
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

    public final void mul(double scalar, Matrix4d m1) {
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

    public final void mul(Matrix4d m1) {
        double m002 = (this.m00 * m1.m00) + (this.m01 * m1.m10) + (this.m02 * m1.m20) + (this.m03 * m1.m30);
        double m012 = (this.m00 * m1.m01) + (this.m01 * m1.m11) + (this.m02 * m1.m21) + (this.m03 * m1.m31);
        double m022 = (this.m00 * m1.m02) + (this.m01 * m1.m12) + (this.m02 * m1.m22) + (this.m03 * m1.m32);
        double m032 = (this.m00 * m1.m03) + (this.m01 * m1.m13) + (this.m02 * m1.m23) + (this.m03 * m1.m33);
        double m102 = (this.m10 * m1.m00) + (this.m11 * m1.m10) + (this.m12 * m1.m20) + (this.m13 * m1.m30);
        double m112 = (this.m10 * m1.m01) + (this.m11 * m1.m11) + (this.m12 * m1.m21) + (this.m13 * m1.m31);
        double m122 = (this.m10 * m1.m02) + (this.m11 * m1.m12) + (this.m12 * m1.m22) + (this.m13 * m1.m32);
        double m132 = (this.m10 * m1.m03) + (this.m11 * m1.m13) + (this.m12 * m1.m23) + (this.m13 * m1.m33);
        double m202 = (this.m20 * m1.m00) + (this.m21 * m1.m10) + (this.m22 * m1.m20) + (this.m23 * m1.m30);
        double m212 = (this.m20 * m1.m01) + (this.m21 * m1.m11) + (this.m22 * m1.m21) + (this.m23 * m1.m31);
        double m222 = (this.m20 * m1.m02) + (this.m21 * m1.m12) + (this.m22 * m1.m22) + (this.m23 * m1.m32);
        double m232 = (this.m20 * m1.m03) + (this.m21 * m1.m13) + (this.m22 * m1.m23) + (this.m23 * m1.m33);
        double m302 = (this.m30 * m1.m00) + (this.m31 * m1.m10) + (this.m32 * m1.m20) + (this.m33 * m1.m30);
        double m312 = (this.m30 * m1.m01) + (this.m31 * m1.m11) + (this.m32 * m1.m21) + (this.m33 * m1.m31);
        double m322 = (this.m30 * m1.m02) + (this.m31 * m1.m12) + (this.m32 * m1.m22) + (this.m33 * m1.m32);
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

    public final void mul(Matrix4d m1, Matrix4d m2) {
        if (this == m1 || this == m2) {
            double m002 = (m1.m00 * m2.m00) + (m1.m01 * m2.m10) + (m1.m02 * m2.m20) + (m1.m03 * m2.m30);
            double m012 = (m1.m00 * m2.m01) + (m1.m01 * m2.m11) + (m1.m02 * m2.m21) + (m1.m03 * m2.m31);
            double m022 = (m1.m00 * m2.m02) + (m1.m01 * m2.m12) + (m1.m02 * m2.m22) + (m1.m03 * m2.m32);
            double m032 = (m1.m00 * m2.m03) + (m1.m01 * m2.m13) + (m1.m02 * m2.m23) + (m1.m03 * m2.m33);
            double m102 = (m1.m10 * m2.m00) + (m1.m11 * m2.m10) + (m1.m12 * m2.m20) + (m1.m13 * m2.m30);
            double m112 = (m1.m10 * m2.m01) + (m1.m11 * m2.m11) + (m1.m12 * m2.m21) + (m1.m13 * m2.m31);
            double m122 = (m1.m10 * m2.m02) + (m1.m11 * m2.m12) + (m1.m12 * m2.m22) + (m1.m13 * m2.m32);
            double m132 = (m1.m10 * m2.m03) + (m1.m11 * m2.m13) + (m1.m12 * m2.m23) + (m1.m13 * m2.m33);
            double m202 = (m1.m20 * m2.m00) + (m1.m21 * m2.m10) + (m1.m22 * m2.m20) + (m1.m23 * m2.m30);
            double m212 = (m1.m20 * m2.m01) + (m1.m21 * m2.m11) + (m1.m22 * m2.m21) + (m1.m23 * m2.m31);
            double m222 = (m1.m20 * m2.m02) + (m1.m21 * m2.m12) + (m1.m22 * m2.m22) + (m1.m23 * m2.m32);
            double m232 = (m1.m20 * m2.m03) + (m1.m21 * m2.m13) + (m1.m22 * m2.m23) + (m1.m23 * m2.m33);
            double m302 = (m1.m30 * m2.m00) + (m1.m31 * m2.m10) + (m1.m32 * m2.m20) + (m1.m33 * m2.m30);
            double m312 = (m1.m30 * m2.m01) + (m1.m31 * m2.m11) + (m1.m32 * m2.m21) + (m1.m33 * m2.m31);
            double m322 = (m1.m30 * m2.m02) + (m1.m31 * m2.m12) + (m1.m32 * m2.m22) + (m1.m33 * m2.m32);
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

    public final void mulTransposeBoth(Matrix4d m1, Matrix4d m2) {
        if (this == m1 || this == m2) {
            double m002 = (m1.m00 * m2.m00) + (m1.m10 * m2.m01) + (m1.m20 * m2.m02) + (m1.m30 * m2.m03);
            double m012 = (m1.m00 * m2.m10) + (m1.m10 * m2.m11) + (m1.m20 * m2.m12) + (m1.m30 * m2.m13);
            double m022 = (m1.m00 * m2.m20) + (m1.m10 * m2.m21) + (m1.m20 * m2.m22) + (m1.m30 * m2.m23);
            double m032 = (m1.m00 * m2.m30) + (m1.m10 * m2.m31) + (m1.m20 * m2.m32) + (m1.m30 * m2.m33);
            double m102 = (m1.m01 * m2.m00) + (m1.m11 * m2.m01) + (m1.m21 * m2.m02) + (m1.m31 * m2.m03);
            double m112 = (m1.m01 * m2.m10) + (m1.m11 * m2.m11) + (m1.m21 * m2.m12) + (m1.m31 * m2.m13);
            double m122 = (m1.m01 * m2.m20) + (m1.m11 * m2.m21) + (m1.m21 * m2.m22) + (m1.m31 * m2.m23);
            double m132 = (m1.m01 * m2.m30) + (m1.m11 * m2.m31) + (m1.m21 * m2.m32) + (m1.m31 * m2.m33);
            double m202 = (m1.m02 * m2.m00) + (m1.m12 * m2.m01) + (m1.m22 * m2.m02) + (m1.m32 * m2.m03);
            double m212 = (m1.m02 * m2.m10) + (m1.m12 * m2.m11) + (m1.m22 * m2.m12) + (m1.m32 * m2.m13);
            double m222 = (m1.m02 * m2.m20) + (m1.m12 * m2.m21) + (m1.m22 * m2.m22) + (m1.m32 * m2.m23);
            double m232 = (m1.m02 * m2.m30) + (m1.m12 * m2.m31) + (m1.m22 * m2.m32) + (m1.m32 * m2.m33);
            double m302 = (m1.m03 * m2.m00) + (m1.m13 * m2.m01) + (m1.m23 * m2.m02) + (m1.m33 * m2.m03);
            double m312 = (m1.m03 * m2.m10) + (m1.m13 * m2.m11) + (m1.m23 * m2.m12) + (m1.m33 * m2.m13);
            double m322 = (m1.m03 * m2.m20) + (m1.m13 * m2.m21) + (m1.m23 * m2.m22) + (m1.m33 * m2.m23);
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

    public final void mulTransposeRight(Matrix4d m1, Matrix4d m2) {
        if (this == m1 || this == m2) {
            double m002 = (m1.m00 * m2.m00) + (m1.m01 * m2.m01) + (m1.m02 * m2.m02) + (m1.m03 * m2.m03);
            double m012 = (m1.m00 * m2.m10) + (m1.m01 * m2.m11) + (m1.m02 * m2.m12) + (m1.m03 * m2.m13);
            double m022 = (m1.m00 * m2.m20) + (m1.m01 * m2.m21) + (m1.m02 * m2.m22) + (m1.m03 * m2.m23);
            double m032 = (m1.m00 * m2.m30) + (m1.m01 * m2.m31) + (m1.m02 * m2.m32) + (m1.m03 * m2.m33);
            double m102 = (m1.m10 * m2.m00) + (m1.m11 * m2.m01) + (m1.m12 * m2.m02) + (m1.m13 * m2.m03);
            double m112 = (m1.m10 * m2.m10) + (m1.m11 * m2.m11) + (m1.m12 * m2.m12) + (m1.m13 * m2.m13);
            double m122 = (m1.m10 * m2.m20) + (m1.m11 * m2.m21) + (m1.m12 * m2.m22) + (m1.m13 * m2.m23);
            double m132 = (m1.m10 * m2.m30) + (m1.m11 * m2.m31) + (m1.m12 * m2.m32) + (m1.m13 * m2.m33);
            double m202 = (m1.m20 * m2.m00) + (m1.m21 * m2.m01) + (m1.m22 * m2.m02) + (m1.m23 * m2.m03);
            double m212 = (m1.m20 * m2.m10) + (m1.m21 * m2.m11) + (m1.m22 * m2.m12) + (m1.m23 * m2.m13);
            double m222 = (m1.m20 * m2.m20) + (m1.m21 * m2.m21) + (m1.m22 * m2.m22) + (m1.m23 * m2.m23);
            double m232 = (m1.m20 * m2.m30) + (m1.m21 * m2.m31) + (m1.m22 * m2.m32) + (m1.m23 * m2.m33);
            double m302 = (m1.m30 * m2.m00) + (m1.m31 * m2.m01) + (m1.m32 * m2.m02) + (m1.m33 * m2.m03);
            double m312 = (m1.m30 * m2.m10) + (m1.m31 * m2.m11) + (m1.m32 * m2.m12) + (m1.m33 * m2.m13);
            double m322 = (m1.m30 * m2.m20) + (m1.m31 * m2.m21) + (m1.m32 * m2.m22) + (m1.m33 * m2.m23);
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

    public final void mulTransposeLeft(Matrix4d m1, Matrix4d m2) {
        if (this == m1 || this == m2) {
            double m002 = (m1.m00 * m2.m00) + (m1.m10 * m2.m10) + (m1.m20 * m2.m20) + (m1.m30 * m2.m30);
            double m012 = (m1.m00 * m2.m01) + (m1.m10 * m2.m11) + (m1.m20 * m2.m21) + (m1.m30 * m2.m31);
            double m022 = (m1.m00 * m2.m02) + (m1.m10 * m2.m12) + (m1.m20 * m2.m22) + (m1.m30 * m2.m32);
            double m032 = (m1.m00 * m2.m03) + (m1.m10 * m2.m13) + (m1.m20 * m2.m23) + (m1.m30 * m2.m33);
            double m102 = (m1.m01 * m2.m00) + (m1.m11 * m2.m10) + (m1.m21 * m2.m20) + (m1.m31 * m2.m30);
            double m112 = (m1.m01 * m2.m01) + (m1.m11 * m2.m11) + (m1.m21 * m2.m21) + (m1.m31 * m2.m31);
            double m122 = (m1.m01 * m2.m02) + (m1.m11 * m2.m12) + (m1.m21 * m2.m22) + (m1.m31 * m2.m32);
            double m132 = (m1.m01 * m2.m03) + (m1.m11 * m2.m13) + (m1.m21 * m2.m23) + (m1.m31 * m2.m33);
            double m202 = (m1.m02 * m2.m00) + (m1.m12 * m2.m10) + (m1.m22 * m2.m20) + (m1.m32 * m2.m30);
            double m212 = (m1.m02 * m2.m01) + (m1.m12 * m2.m11) + (m1.m22 * m2.m21) + (m1.m32 * m2.m31);
            double m222 = (m1.m02 * m2.m02) + (m1.m12 * m2.m12) + (m1.m22 * m2.m22) + (m1.m32 * m2.m32);
            double m232 = (m1.m02 * m2.m03) + (m1.m12 * m2.m13) + (m1.m22 * m2.m23) + (m1.m32 * m2.m33);
            double m302 = (m1.m03 * m2.m00) + (m1.m13 * m2.m10) + (m1.m23 * m2.m20) + (m1.m33 * m2.m30);
            double m312 = (m1.m03 * m2.m01) + (m1.m13 * m2.m11) + (m1.m23 * m2.m21) + (m1.m33 * m2.m31);
            double m322 = (m1.m03 * m2.m02) + (m1.m13 * m2.m12) + (m1.m23 * m2.m22) + (m1.m33 * m2.m32);
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

    public boolean equals(Matrix4d m1) {
        try {
            return this.m00 == m1.m00 && this.m01 == m1.m01 && this.m02 == m1.m02 && this.m03 == m1.m03 && this.m10 == m1.m10 && this.m11 == m1.m11 && this.m12 == m1.m12 && this.m13 == m1.m13 && this.m20 == m1.m20 && this.m21 == m1.m21 && this.m22 == m1.m22 && this.m23 == m1.m23 && this.m30 == m1.m30 && this.m31 == m1.m31 && this.m32 == m1.m32 && this.m33 == m1.m33;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean equals(Object t1) {
        try {
            Matrix4d m2 = (Matrix4d) t1;
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

    public boolean epsilonEquals(Matrix4d m1, float epsilon) {
        return epsilonEquals(m1, (double) epsilon);
    }

    public boolean epsilonEquals(Matrix4d m1, double epsilon) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        double d11;
        double d12;
        double d13;
        double d14;
        double d15;
        double diff = this.m00 - m1.m00;
        if (diff < Utils.DOUBLE_EPSILON) {
            d = -diff;
        } else {
            d = diff;
        }
        if (d > epsilon) {
            return false;
        }
        double diff2 = this.m01 - m1.m01;
        if ((diff2 < Utils.DOUBLE_EPSILON ? -diff2 : diff2) > epsilon) {
            return false;
        }
        double diff3 = this.m02 - m1.m02;
        if (diff3 < Utils.DOUBLE_EPSILON) {
            d2 = -diff3;
        } else {
            d2 = diff3;
        }
        if (d2 > epsilon) {
            return false;
        }
        double diff4 = this.m03 - m1.m03;
        if (diff4 < Utils.DOUBLE_EPSILON) {
            d3 = -diff4;
        } else {
            d3 = diff4;
        }
        if (d3 > epsilon) {
            return false;
        }
        double diff5 = this.m10 - m1.m10;
        if (diff5 < Utils.DOUBLE_EPSILON) {
            d4 = -diff5;
        } else {
            d4 = diff5;
        }
        if (d4 > epsilon) {
            return false;
        }
        double diff6 = this.m11 - m1.m11;
        if (diff6 < Utils.DOUBLE_EPSILON) {
            d5 = -diff6;
        } else {
            d5 = diff6;
        }
        if (d5 > epsilon) {
            return false;
        }
        double diff7 = this.m12 - m1.m12;
        if (diff7 < Utils.DOUBLE_EPSILON) {
            d6 = -diff7;
        } else {
            d6 = diff7;
        }
        if (d6 > epsilon) {
            return false;
        }
        double diff8 = this.m13 - m1.m13;
        if (diff8 < Utils.DOUBLE_EPSILON) {
            d7 = -diff8;
        } else {
            d7 = diff8;
        }
        if (d7 > epsilon) {
            return false;
        }
        double diff9 = this.m20 - m1.m20;
        if (diff9 < Utils.DOUBLE_EPSILON) {
            d8 = -diff9;
        } else {
            d8 = diff9;
        }
        if (d8 > epsilon) {
            return false;
        }
        double diff10 = this.m21 - m1.m21;
        if (diff10 < Utils.DOUBLE_EPSILON) {
            d9 = -diff10;
        } else {
            d9 = diff10;
        }
        if (d9 > epsilon) {
            return false;
        }
        double diff11 = this.m22 - m1.m22;
        if (diff11 < Utils.DOUBLE_EPSILON) {
            d10 = -diff11;
        } else {
            d10 = diff11;
        }
        if (d10 > epsilon) {
            return false;
        }
        double diff12 = this.m23 - m1.m23;
        if (diff12 < Utils.DOUBLE_EPSILON) {
            d11 = -diff12;
        } else {
            d11 = diff12;
        }
        if (d11 > epsilon) {
            return false;
        }
        double diff13 = this.m30 - m1.m30;
        if (diff13 < Utils.DOUBLE_EPSILON) {
            d12 = -diff13;
        } else {
            d12 = diff13;
        }
        if (d12 > epsilon) {
            return false;
        }
        double diff14 = this.m31 - m1.m31;
        if (diff14 < Utils.DOUBLE_EPSILON) {
            d13 = -diff14;
        } else {
            d13 = diff14;
        }
        if (d13 > epsilon) {
            return false;
        }
        double diff15 = this.m32 - m1.m32;
        if (diff15 < Utils.DOUBLE_EPSILON) {
            d14 = -diff15;
        } else {
            d14 = diff15;
        }
        if (d14 > epsilon) {
            return false;
        }
        double diff16 = this.m33 - m1.m33;
        if (diff16 < Utils.DOUBLE_EPSILON) {
            d15 = -diff16;
        } else {
            d15 = diff16;
        }
        if (d15 <= epsilon) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long bits = (31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * 1) + VecMathUtil.doubleToLongBits(this.m00))) + VecMathUtil.doubleToLongBits(this.m01))) + VecMathUtil.doubleToLongBits(this.m02))) + VecMathUtil.doubleToLongBits(this.m03))) + VecMathUtil.doubleToLongBits(this.m10))) + VecMathUtil.doubleToLongBits(this.m11))) + VecMathUtil.doubleToLongBits(this.m12))) + VecMathUtil.doubleToLongBits(this.m13))) + VecMathUtil.doubleToLongBits(this.m20))) + VecMathUtil.doubleToLongBits(this.m21))) + VecMathUtil.doubleToLongBits(this.m22))) + VecMathUtil.doubleToLongBits(this.m23))) + VecMathUtil.doubleToLongBits(this.m30))) + VecMathUtil.doubleToLongBits(this.m31))) + VecMathUtil.doubleToLongBits(this.m32))) + VecMathUtil.doubleToLongBits(this.m33);
        return (int) ((bits >> 32) ^ bits);
    }

    public final void transform(Tuple4d vec, Tuple4d vecOut) {
        double x = (this.m00 * vec.f169x) + (this.m01 * vec.f170y) + (this.m02 * vec.f171z) + (this.m03 * vec.f168w);
        double y = (this.m10 * vec.f169x) + (this.m11 * vec.f170y) + (this.m12 * vec.f171z) + (this.m13 * vec.f168w);
        double z = (this.m20 * vec.f169x) + (this.m21 * vec.f170y) + (this.m22 * vec.f171z) + (this.m23 * vec.f168w);
        vecOut.f168w = (this.m30 * vec.f169x) + (this.m31 * vec.f170y) + (this.m32 * vec.f171z) + (this.m33 * vec.f168w);
        vecOut.f169x = x;
        vecOut.f170y = y;
        vecOut.f171z = z;
    }

    public final void transform(Tuple4d vec) {
        double x = (this.m00 * vec.f169x) + (this.m01 * vec.f170y) + (this.m02 * vec.f171z) + (this.m03 * vec.f168w);
        double y = (this.m10 * vec.f169x) + (this.m11 * vec.f170y) + (this.m12 * vec.f171z) + (this.m13 * vec.f168w);
        double z = (this.m20 * vec.f169x) + (this.m21 * vec.f170y) + (this.m22 * vec.f171z) + (this.m23 * vec.f168w);
        vec.f168w = (this.m30 * vec.f169x) + (this.m31 * vec.f170y) + (this.m32 * vec.f171z) + (this.m33 * vec.f168w);
        vec.f169x = x;
        vec.f170y = y;
        vec.f171z = z;
    }

    public final void transform(Tuple4f vec, Tuple4f vecOut) {
        float x = (float) ((this.m00 * ((double) vec.f173x)) + (this.m01 * ((double) vec.f174y)) + (this.m02 * ((double) vec.f175z)) + (this.m03 * ((double) vec.f172w)));
        float y = (float) ((this.m10 * ((double) vec.f173x)) + (this.m11 * ((double) vec.f174y)) + (this.m12 * ((double) vec.f175z)) + (this.m13 * ((double) vec.f172w)));
        float z = (float) ((this.m20 * ((double) vec.f173x)) + (this.m21 * ((double) vec.f174y)) + (this.m22 * ((double) vec.f175z)) + (this.m23 * ((double) vec.f172w)));
        vecOut.f172w = (float) ((this.m30 * ((double) vec.f173x)) + (this.m31 * ((double) vec.f174y)) + (this.m32 * ((double) vec.f175z)) + (this.m33 * ((double) vec.f172w)));
        vecOut.f173x = x;
        vecOut.f174y = y;
        vecOut.f175z = z;
    }

    public final void transform(Tuple4f vec) {
        float x = (float) ((this.m00 * ((double) vec.f173x)) + (this.m01 * ((double) vec.f174y)) + (this.m02 * ((double) vec.f175z)) + (this.m03 * ((double) vec.f172w)));
        float y = (float) ((this.m10 * ((double) vec.f173x)) + (this.m11 * ((double) vec.f174y)) + (this.m12 * ((double) vec.f175z)) + (this.m13 * ((double) vec.f172w)));
        float z = (float) ((this.m20 * ((double) vec.f173x)) + (this.m21 * ((double) vec.f174y)) + (this.m22 * ((double) vec.f175z)) + (this.m23 * ((double) vec.f172w)));
        vec.f172w = (float) ((this.m30 * ((double) vec.f173x)) + (this.m31 * ((double) vec.f174y)) + (this.m32 * ((double) vec.f175z)) + (this.m33 * ((double) vec.f172w)));
        vec.f173x = x;
        vec.f174y = y;
        vec.f175z = z;
    }

    public final void transform(Point3d point, Point3d pointOut) {
        double x = (this.m00 * point.f155x) + (this.m01 * point.f156y) + (this.m02 * point.f157z) + this.m03;
        double y = (this.m10 * point.f155x) + (this.m11 * point.f156y) + (this.m12 * point.f157z) + this.m13;
        pointOut.f157z = (this.m20 * point.f155x) + (this.m21 * point.f156y) + (this.m22 * point.f157z) + this.m23;
        pointOut.f155x = x;
        pointOut.f156y = y;
    }

    public final void transform(Point3d point) {
        double x = (this.m00 * point.f155x) + (this.m01 * point.f156y) + (this.m02 * point.f157z) + this.m03;
        double y = (this.m10 * point.f155x) + (this.m11 * point.f156y) + (this.m12 * point.f157z) + this.m13;
        point.f157z = (this.m20 * point.f155x) + (this.m21 * point.f156y) + (this.m22 * point.f157z) + this.m23;
        point.f155x = x;
        point.f156y = y;
    }

    public final void transform(Point3f point, Point3f pointOut) {
        float x = (float) ((this.m00 * ((double) point.f158x)) + (this.m01 * ((double) point.f159y)) + (this.m02 * ((double) point.f160z)) + this.m03);
        float y = (float) ((this.m10 * ((double) point.f158x)) + (this.m11 * ((double) point.f159y)) + (this.m12 * ((double) point.f160z)) + this.m13);
        pointOut.f160z = (float) ((this.m20 * ((double) point.f158x)) + (this.m21 * ((double) point.f159y)) + (this.m22 * ((double) point.f160z)) + this.m23);
        pointOut.f158x = x;
        pointOut.f159y = y;
    }

    public final void transform(Point3f point) {
        float x = (float) ((this.m00 * ((double) point.f158x)) + (this.m01 * ((double) point.f159y)) + (this.m02 * ((double) point.f160z)) + this.m03);
        float y = (float) ((this.m10 * ((double) point.f158x)) + (this.m11 * ((double) point.f159y)) + (this.m12 * ((double) point.f160z)) + this.m13);
        point.f160z = (float) ((this.m20 * ((double) point.f158x)) + (this.m21 * ((double) point.f159y)) + (this.m22 * ((double) point.f160z)) + this.m23);
        point.f158x = x;
        point.f159y = y;
    }

    public final void transform(Vector3d normal, Vector3d normalOut) {
        double x = (this.m00 * normal.f155x) + (this.m01 * normal.f156y) + (this.m02 * normal.f157z);
        double y = (this.m10 * normal.f155x) + (this.m11 * normal.f156y) + (this.m12 * normal.f157z);
        normalOut.f157z = (this.m20 * normal.f155x) + (this.m21 * normal.f156y) + (this.m22 * normal.f157z);
        normalOut.f155x = x;
        normalOut.f156y = y;
    }

    public final void transform(Vector3d normal) {
        double x = (this.m00 * normal.f155x) + (this.m01 * normal.f156y) + (this.m02 * normal.f157z);
        double y = (this.m10 * normal.f155x) + (this.m11 * normal.f156y) + (this.m12 * normal.f157z);
        normal.f157z = (this.m20 * normal.f155x) + (this.m21 * normal.f156y) + (this.m22 * normal.f157z);
        normal.f155x = x;
        normal.f156y = y;
    }

    public final void transform(Vector3f normal, Vector3f normalOut) {
        float x = (float) ((this.m00 * ((double) normal.f158x)) + (this.m01 * ((double) normal.f159y)) + (this.m02 * ((double) normal.f160z)));
        float y = (float) ((this.m10 * ((double) normal.f158x)) + (this.m11 * ((double) normal.f159y)) + (this.m12 * ((double) normal.f160z)));
        normalOut.f160z = (float) ((this.m20 * ((double) normal.f158x)) + (this.m21 * ((double) normal.f159y)) + (this.m22 * ((double) normal.f160z)));
        normalOut.f158x = x;
        normalOut.f159y = y;
    }

    public final void transform(Vector3f normal) {
        float x = (float) ((this.m00 * ((double) normal.f158x)) + (this.m01 * ((double) normal.f159y)) + (this.m02 * ((double) normal.f160z)));
        float y = (float) ((this.m10 * ((double) normal.f158x)) + (this.m11 * ((double) normal.f159y)) + (this.m12 * ((double) normal.f160z)));
        normal.f160z = (float) ((this.m20 * ((double) normal.f158x)) + (this.m21 * ((double) normal.f159y)) + (this.m22 * ((double) normal.f160z)));
        normal.f158x = x;
        normal.f159y = y;
    }

    public final void setRotation(Matrix3d m1) {
        double[] tmp_scale = new double[3];
        getScaleRotate(tmp_scale, new double[9]);
        this.m00 = m1.m00 * tmp_scale[0];
        this.m01 = m1.m01 * tmp_scale[1];
        this.m02 = m1.m02 * tmp_scale[2];
        this.m10 = m1.m10 * tmp_scale[0];
        this.m11 = m1.m11 * tmp_scale[1];
        this.m12 = m1.m12 * tmp_scale[2];
        this.m20 = m1.m20 * tmp_scale[0];
        this.m21 = m1.m21 * tmp_scale[1];
        this.m22 = m1.m22 * tmp_scale[2];
    }

    public final void setRotation(Matrix3f m1) {
        double[] tmp_scale = new double[3];
        getScaleRotate(tmp_scale, new double[9]);
        this.m00 = ((double) m1.m00) * tmp_scale[0];
        this.m01 = ((double) m1.m01) * tmp_scale[1];
        this.m02 = ((double) m1.m02) * tmp_scale[2];
        this.m10 = ((double) m1.m10) * tmp_scale[0];
        this.m11 = ((double) m1.m11) * tmp_scale[1];
        this.m12 = ((double) m1.m12) * tmp_scale[2];
        this.m20 = ((double) m1.m20) * tmp_scale[0];
        this.m21 = ((double) m1.m21) * tmp_scale[1];
        this.m22 = ((double) m1.m22) * tmp_scale[2];
    }

    public final void setRotation(Quat4f q1) {
        double[] tmp_scale = new double[3];
        getScaleRotate(tmp_scale, new double[9]);
        this.m00 = ((1.0d - ((double) ((q1.f174y * 2.0f) * q1.f174y))) - ((double) ((q1.f175z * 2.0f) * q1.f175z))) * tmp_scale[0];
        this.m10 = ((double) ((q1.f173x * q1.f174y) + (q1.f172w * q1.f175z))) * 2.0d * tmp_scale[0];
        this.m20 = ((double) ((q1.f173x * q1.f175z) - (q1.f172w * q1.f174y))) * 2.0d * tmp_scale[0];
        this.m01 = ((double) ((q1.f173x * q1.f174y) - (q1.f172w * q1.f175z))) * 2.0d * tmp_scale[1];
        this.m11 = ((1.0d - ((double) ((q1.f173x * 2.0f) * q1.f173x))) - ((double) ((q1.f175z * 2.0f) * q1.f175z))) * tmp_scale[1];
        this.m21 = ((double) ((q1.f174y * q1.f175z) + (q1.f172w * q1.f173x))) * 2.0d * tmp_scale[1];
        this.m02 = ((double) ((q1.f173x * q1.f175z) + (q1.f172w * q1.f174y))) * 2.0d * tmp_scale[2];
        this.m12 = ((double) ((q1.f174y * q1.f175z) - (q1.f172w * q1.f173x))) * 2.0d * tmp_scale[2];
        this.m22 = ((1.0d - ((double) ((q1.f173x * 2.0f) * q1.f173x))) - ((double) ((q1.f174y * 2.0f) * q1.f174y))) * tmp_scale[2];
    }

    public final void setRotation(Quat4d q1) {
        double[] tmp_scale = new double[3];
        getScaleRotate(tmp_scale, new double[9]);
        this.m00 = ((1.0d - ((2.0d * q1.f170y) * q1.f170y)) - ((2.0d * q1.f171z) * q1.f171z)) * tmp_scale[0];
        this.m10 = 2.0d * ((q1.f169x * q1.f170y) + (q1.f168w * q1.f171z)) * tmp_scale[0];
        this.m20 = 2.0d * ((q1.f169x * q1.f171z) - (q1.f168w * q1.f170y)) * tmp_scale[0];
        this.m01 = 2.0d * ((q1.f169x * q1.f170y) - (q1.f168w * q1.f171z)) * tmp_scale[1];
        this.m11 = ((1.0d - ((2.0d * q1.f169x) * q1.f169x)) - ((2.0d * q1.f171z) * q1.f171z)) * tmp_scale[1];
        this.m21 = 2.0d * ((q1.f170y * q1.f171z) + (q1.f168w * q1.f169x)) * tmp_scale[1];
        this.m02 = 2.0d * ((q1.f169x * q1.f171z) + (q1.f168w * q1.f170y)) * tmp_scale[2];
        this.m12 = 2.0d * ((q1.f170y * q1.f171z) - (q1.f168w * q1.f169x)) * tmp_scale[2];
        this.m22 = ((1.0d - ((2.0d * q1.f169x) * q1.f169x)) - ((2.0d * q1.f170y) * q1.f170y)) * tmp_scale[2];
    }

    public final void setRotation(AxisAngle4d a1) {
        double[] tmp_scale = new double[3];
        getScaleRotate(tmp_scale, new double[9]);
        double mag = 1.0d / Math.sqrt(((a1.f140x * a1.f140x) + (a1.f141y * a1.f141y)) + (a1.f142z * a1.f142z));
        double ax = a1.f140x * mag;
        double ay = a1.f141y * mag;
        double az = a1.f142z * mag;
        double sinTheta = Math.sin(a1.angle);
        double cosTheta = Math.cos(a1.angle);
        double t = 1.0d - cosTheta;
        double xz = a1.f140x * a1.f142z;
        double xy = a1.f140x * a1.f141y;
        double yz = a1.f141y * a1.f142z;
        this.m00 = ((t * ax * ax) + cosTheta) * tmp_scale[0];
        this.m01 = ((t * xy) - (sinTheta * az)) * tmp_scale[1];
        this.m02 = ((t * xz) + (sinTheta * ay)) * tmp_scale[2];
        this.m10 = ((t * xy) + (sinTheta * az)) * tmp_scale[0];
        this.m11 = ((t * ay * ay) + cosTheta) * tmp_scale[1];
        this.m12 = ((t * yz) - (sinTheta * ax)) * tmp_scale[2];
        this.m20 = ((t * xz) - (sinTheta * ay)) * tmp_scale[0];
        this.m21 = ((t * yz) + (sinTheta * ax)) * tmp_scale[1];
        this.m22 = ((t * az * az) + cosTheta) * tmp_scale[2];
    }

    public final void setZero() {
        this.m00 = Utils.DOUBLE_EPSILON;
        this.m01 = Utils.DOUBLE_EPSILON;
        this.m02 = Utils.DOUBLE_EPSILON;
        this.m03 = Utils.DOUBLE_EPSILON;
        this.m10 = Utils.DOUBLE_EPSILON;
        this.m11 = Utils.DOUBLE_EPSILON;
        this.m12 = Utils.DOUBLE_EPSILON;
        this.m13 = Utils.DOUBLE_EPSILON;
        this.m20 = Utils.DOUBLE_EPSILON;
        this.m21 = Utils.DOUBLE_EPSILON;
        this.m22 = Utils.DOUBLE_EPSILON;
        this.m23 = Utils.DOUBLE_EPSILON;
        this.m30 = Utils.DOUBLE_EPSILON;
        this.m31 = Utils.DOUBLE_EPSILON;
        this.m32 = Utils.DOUBLE_EPSILON;
        this.m33 = Utils.DOUBLE_EPSILON;
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

    public final void negate(Matrix4d m1) {
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
        Matrix3d.compute_svd(new double[]{this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m20, this.m21, this.m22}, scales, rots);
    }

    public Object clone() {
        try {
            return (Matrix4d) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public final double getM00() {
        return this.m00;
    }

    public final void setM00(double m002) {
        this.m00 = m002;
    }

    public final double getM01() {
        return this.m01;
    }

    public final void setM01(double m012) {
        this.m01 = m012;
    }

    public final double getM02() {
        return this.m02;
    }

    public final void setM02(double m022) {
        this.m02 = m022;
    }

    public final double getM10() {
        return this.m10;
    }

    public final void setM10(double m102) {
        this.m10 = m102;
    }

    public final double getM11() {
        return this.m11;
    }

    public final void setM11(double m112) {
        this.m11 = m112;
    }

    public final double getM12() {
        return this.m12;
    }

    public final void setM12(double m122) {
        this.m12 = m122;
    }

    public final double getM20() {
        return this.m20;
    }

    public final void setM20(double m202) {
        this.m20 = m202;
    }

    public final double getM21() {
        return this.m21;
    }

    public final void setM21(double m212) {
        this.m21 = m212;
    }

    public final double getM22() {
        return this.m22;
    }

    public final void setM22(double m222) {
        this.m22 = m222;
    }

    public final double getM03() {
        return this.m03;
    }

    public final void setM03(double m032) {
        this.m03 = m032;
    }

    public final double getM13() {
        return this.m13;
    }

    public final void setM13(double m132) {
        this.m13 = m132;
    }

    public final double getM23() {
        return this.m23;
    }

    public final void setM23(double m232) {
        this.m23 = m232;
    }

    public final double getM30() {
        return this.m30;
    }

    public final void setM30(double m302) {
        this.m30 = m302;
    }

    public final double getM31() {
        return this.m31;
    }

    public final void setM31(double m312) {
        this.m31 = m312;
    }

    public final double getM32() {
        return this.m32;
    }

    public final void setM32(double m322) {
        this.m32 = m322;
    }

    public final double getM33() {
        return this.m33;
    }

    public final void setM33(double m332) {
        this.m33 = m332;
    }
}
