package javax.vecmath;

import com.github.mikephil.charting.utils.Utils;
import java.io.Serializable;

public class Matrix3d implements Serializable, Cloneable {
    private static final double EPS = 1.110223024E-16d;
    private static final double ERR_EPS = 1.0E-8d;
    static final long serialVersionUID = 6837536777072402710L;
    private static double xin;
    private static double xout;
    private static double yin;
    private static double yout;
    private static double zin;
    private static double zout;
    public double m00;
    public double m01;
    public double m02;
    public double m10;
    public double m11;
    public double m12;
    public double m20;
    public double m21;
    public double m22;

    public Matrix3d(double m002, double m012, double m022, double m102, double m112, double m122, double m202, double m212, double m222) {
        this.m00 = m002;
        this.m01 = m012;
        this.m02 = m022;
        this.m10 = m102;
        this.m11 = m112;
        this.m12 = m122;
        this.m20 = m202;
        this.m21 = m212;
        this.m22 = m222;
    }

    public Matrix3d(double[] v) {
        this.m00 = v[0];
        this.m01 = v[1];
        this.m02 = v[2];
        this.m10 = v[3];
        this.m11 = v[4];
        this.m12 = v[5];
        this.m20 = v[6];
        this.m21 = v[7];
        this.m22 = v[8];
    }

    public Matrix3d(Matrix3d m1) {
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

    public Matrix3d(Matrix3f m1) {
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

    public Matrix3d() {
        this.m00 = Utils.DOUBLE_EPSILON;
        this.m01 = Utils.DOUBLE_EPSILON;
        this.m02 = Utils.DOUBLE_EPSILON;
        this.m10 = Utils.DOUBLE_EPSILON;
        this.m11 = Utils.DOUBLE_EPSILON;
        this.m12 = Utils.DOUBLE_EPSILON;
        this.m20 = Utils.DOUBLE_EPSILON;
        this.m21 = Utils.DOUBLE_EPSILON;
        this.m22 = Utils.DOUBLE_EPSILON;
    }

    public String toString() {
        return this.m00 + ", " + this.m01 + ", " + this.m02 + "\n" + this.m10 + ", " + this.m11 + ", " + this.m12 + "\n" + this.m20 + ", " + this.m21 + ", " + this.m22 + "\n";
    }

    public final void setIdentity() {
        this.m00 = 1.0d;
        this.m01 = Utils.DOUBLE_EPSILON;
        this.m02 = Utils.DOUBLE_EPSILON;
        this.m10 = Utils.DOUBLE_EPSILON;
        this.m11 = 1.0d;
        this.m12 = Utils.DOUBLE_EPSILON;
        this.m20 = Utils.DOUBLE_EPSILON;
        this.m21 = Utils.DOUBLE_EPSILON;
        this.m22 = 1.0d;
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
                    default:
                        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d0"));
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
                    default:
                        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d0"));
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
                    default:
                        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d0"));
                }
            default:
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d0"));
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
                }
            case 1:
                switch (column) {
                    case 0:
                        return this.m10;
                    case 1:
                        return this.m11;
                    case 2:
                        return this.m12;
                }
            case 2:
                switch (column) {
                    case 0:
                        return this.m20;
                    case 1:
                        return this.m21;
                    case 2:
                        return this.m22;
                }
        }
        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d1"));
    }

    public final void getRow(int row, Vector3d v) {
        if (row == 0) {
            v.f155x = this.m00;
            v.f156y = this.m01;
            v.f157z = this.m02;
        } else if (row == 1) {
            v.f155x = this.m10;
            v.f156y = this.m11;
            v.f157z = this.m12;
        } else if (row == 2) {
            v.f155x = this.m20;
            v.f156y = this.m21;
            v.f157z = this.m22;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d2"));
        }
    }

    public final void getRow(int row, double[] v) {
        if (row == 0) {
            v[0] = this.m00;
            v[1] = this.m01;
            v[2] = this.m02;
        } else if (row == 1) {
            v[0] = this.m10;
            v[1] = this.m11;
            v[2] = this.m12;
        } else if (row == 2) {
            v[0] = this.m20;
            v[1] = this.m21;
            v[2] = this.m22;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d2"));
        }
    }

    public final void getColumn(int column, Vector3d v) {
        if (column == 0) {
            v.f155x = this.m00;
            v.f156y = this.m10;
            v.f157z = this.m20;
        } else if (column == 1) {
            v.f155x = this.m01;
            v.f156y = this.m11;
            v.f157z = this.m21;
        } else if (column == 2) {
            v.f155x = this.m02;
            v.f156y = this.m12;
            v.f157z = this.m22;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d4"));
        }
    }

    public final void getColumn(int column, double[] v) {
        if (column == 0) {
            v[0] = this.m00;
            v[1] = this.m10;
            v[2] = this.m20;
        } else if (column == 1) {
            v[0] = this.m01;
            v[1] = this.m11;
            v[2] = this.m21;
        } else if (column == 2) {
            v[0] = this.m02;
            v[1] = this.m12;
            v[2] = this.m22;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d4"));
        }
    }

    public final void setRow(int row, double x, double y, double z) {
        switch (row) {
            case 0:
                this.m00 = x;
                this.m01 = y;
                this.m02 = z;
                return;
            case 1:
                this.m10 = x;
                this.m11 = y;
                this.m12 = z;
                return;
            case 2:
                this.m20 = x;
                this.m21 = y;
                this.m22 = z;
                return;
            default:
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d6"));
        }
    }

    public final void setRow(int row, Vector3d v) {
        switch (row) {
            case 0:
                this.m00 = v.f155x;
                this.m01 = v.f156y;
                this.m02 = v.f157z;
                return;
            case 1:
                this.m10 = v.f155x;
                this.m11 = v.f156y;
                this.m12 = v.f157z;
                return;
            case 2:
                this.m20 = v.f155x;
                this.m21 = v.f156y;
                this.m22 = v.f157z;
                return;
            default:
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d6"));
        }
    }

    public final void setRow(int row, double[] v) {
        switch (row) {
            case 0:
                this.m00 = v[0];
                this.m01 = v[1];
                this.m02 = v[2];
                return;
            case 1:
                this.m10 = v[0];
                this.m11 = v[1];
                this.m12 = v[2];
                return;
            case 2:
                this.m20 = v[0];
                this.m21 = v[1];
                this.m22 = v[2];
                return;
            default:
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d6"));
        }
    }

    public final void setColumn(int column, double x, double y, double z) {
        switch (column) {
            case 0:
                this.m00 = x;
                this.m10 = y;
                this.m20 = z;
                return;
            case 1:
                this.m01 = x;
                this.m11 = y;
                this.m21 = z;
                return;
            case 2:
                this.m02 = x;
                this.m12 = y;
                this.m22 = z;
                return;
            default:
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d9"));
        }
    }

    public final void setColumn(int column, Vector3d v) {
        switch (column) {
            case 0:
                this.m00 = v.f155x;
                this.m10 = v.f156y;
                this.m20 = v.f157z;
                return;
            case 1:
                this.m01 = v.f155x;
                this.m11 = v.f156y;
                this.m21 = v.f157z;
                return;
            case 2:
                this.m02 = v.f155x;
                this.m12 = v.f156y;
                this.m22 = v.f157z;
                return;
            default:
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d9"));
        }
    }

    public final void setColumn(int column, double[] v) {
        switch (column) {
            case 0:
                this.m00 = v[0];
                this.m10 = v[1];
                this.m20 = v[2];
                return;
            case 1:
                this.m01 = v[0];
                this.m11 = v[1];
                this.m21 = v[2];
                return;
            case 2:
                this.m02 = v[0];
                this.m12 = v[1];
                this.m22 = v[2];
                return;
            default:
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d9"));
        }
    }

    public final double getScale() {
        double[] tmp_scale = new double[3];
        getScaleRotate(tmp_scale, new double[9]);
        return max3(tmp_scale);
    }

    public final void add(double scalar) {
        this.m00 += scalar;
        this.m01 += scalar;
        this.m02 += scalar;
        this.m10 += scalar;
        this.m11 += scalar;
        this.m12 += scalar;
        this.m20 += scalar;
        this.m21 += scalar;
        this.m22 += scalar;
    }

    public final void add(double scalar, Matrix3d m1) {
        this.m00 = m1.m00 + scalar;
        this.m01 = m1.m01 + scalar;
        this.m02 = m1.m02 + scalar;
        this.m10 = m1.m10 + scalar;
        this.m11 = m1.m11 + scalar;
        this.m12 = m1.m12 + scalar;
        this.m20 = m1.m20 + scalar;
        this.m21 = m1.m21 + scalar;
        this.m22 = m1.m22 + scalar;
    }

    public final void add(Matrix3d m1, Matrix3d m2) {
        this.m00 = m1.m00 + m2.m00;
        this.m01 = m1.m01 + m2.m01;
        this.m02 = m1.m02 + m2.m02;
        this.m10 = m1.m10 + m2.m10;
        this.m11 = m1.m11 + m2.m11;
        this.m12 = m1.m12 + m2.m12;
        this.m20 = m1.m20 + m2.m20;
        this.m21 = m1.m21 + m2.m21;
        this.m22 = m1.m22 + m2.m22;
    }

    public final void add(Matrix3d m1) {
        this.m00 += m1.m00;
        this.m01 += m1.m01;
        this.m02 += m1.m02;
        this.m10 += m1.m10;
        this.m11 += m1.m11;
        this.m12 += m1.m12;
        this.m20 += m1.m20;
        this.m21 += m1.m21;
        this.m22 += m1.m22;
    }

    public final void sub(Matrix3d m1, Matrix3d m2) {
        this.m00 = m1.m00 - m2.m00;
        this.m01 = m1.m01 - m2.m01;
        this.m02 = m1.m02 - m2.m02;
        this.m10 = m1.m10 - m2.m10;
        this.m11 = m1.m11 - m2.m11;
        this.m12 = m1.m12 - m2.m12;
        this.m20 = m1.m20 - m2.m20;
        this.m21 = m1.m21 - m2.m21;
        this.m22 = m1.m22 - m2.m22;
    }

    public final void sub(Matrix3d m1) {
        this.m00 -= m1.m00;
        this.m01 -= m1.m01;
        this.m02 -= m1.m02;
        this.m10 -= m1.m10;
        this.m11 -= m1.m11;
        this.m12 -= m1.m12;
        this.m20 -= m1.m20;
        this.m21 -= m1.m21;
        this.m22 -= m1.m22;
    }

    public final void transpose() {
        double temp = this.m10;
        this.m10 = this.m01;
        this.m01 = temp;
        double temp2 = this.m20;
        this.m20 = this.m02;
        this.m02 = temp2;
        double temp3 = this.m21;
        this.m21 = this.m12;
        this.m12 = temp3;
    }

    public final void transpose(Matrix3d m1) {
        if (this != m1) {
            this.m00 = m1.m00;
            this.m01 = m1.m10;
            this.m02 = m1.m20;
            this.m10 = m1.m01;
            this.m11 = m1.m11;
            this.m12 = m1.m21;
            this.m20 = m1.m02;
            this.m21 = m1.m12;
            this.m22 = m1.m22;
            return;
        }
        transpose();
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
            return;
        }
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
            return;
        }
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

    public final void set(Matrix3f m1) {
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

    public final void set(Matrix3d m1) {
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

    public final void set(double[] m) {
        this.m00 = m[0];
        this.m01 = m[1];
        this.m02 = m[2];
        this.m10 = m[3];
        this.m11 = m[4];
        this.m12 = m[5];
        this.m20 = m[6];
        this.m21 = m[7];
        this.m22 = m[8];
    }

    public final void invert(Matrix3d m1) {
        invertGeneral(m1);
    }

    public final void invert() {
        invertGeneral(this);
    }

    private final void invertGeneral(Matrix3d m1) {
        double[] result = new double[9];
        int[] row_perm = new int[3];
        double[] tmp = {m1.m00, m1.m01, m1.m02, m1.m10, m1.m11, m1.m12, m1.m20, m1.m21, m1.m22};
        if (!luDecomposition(tmp, row_perm)) {
            throw new SingularMatrixException(VecMathI18N.getString("Matrix3d12"));
        }
        for (int i = 0; i < 9; i++) {
            result[i] = 0.0d;
        }
        result[0] = 1.0d;
        result[4] = 1.0d;
        result[8] = 1.0d;
        luBacksubstitution(tmp, row_perm, result);
        this.m00 = result[0];
        this.m01 = result[1];
        this.m02 = result[2];
        this.m10 = result[3];
        this.m11 = result[4];
        this.m12 = result[5];
        this.m20 = result[6];
        this.m21 = result[7];
        this.m22 = result[8];
    }

    static boolean luDecomposition(double[] matrix0, int[] row_perm) {
        int ptr;
        double[] row_scale = new double[3];
        int ptr2 = 0;
        int i = 3;
        int rs = 0;
        while (true) {
            int i2 = i;
            i = i2 - 1;
            if (i2 != 0) {
                double big = Utils.DOUBLE_EPSILON;
                int j = 3;
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
                for (int j3 = 0; j3 < 3; j3++) {
                    for (int i3 = 0; i3 < j3; i3++) {
                        int target = (i3 * 3) + 0 + j3;
                        double sum = matrix0[target];
                        int k = i3;
                        int p1 = 0 + (i3 * 3);
                        int p2 = 0 + j3;
                        while (true) {
                            int k2 = k;
                            k = k2 - 1;
                            if (k2 == 0) {
                                break;
                            }
                            sum -= matrix0[p1] * matrix0[p2];
                            p1++;
                            p2 += 3;
                        }
                        matrix0[target] = sum;
                    }
                    double big2 = Utils.DOUBLE_EPSILON;
                    int imax = -1;
                    for (int i4 = j3; i4 < 3; i4++) {
                        int target2 = (i4 * 3) + 0 + j3;
                        double sum2 = matrix0[target2];
                        int k3 = j3;
                        int p12 = 0 + (i4 * 3);
                        int p22 = 0 + j3;
                        while (true) {
                            int k4 = k3;
                            k3 = k4 - 1;
                            if (k4 == 0) {
                                break;
                            }
                            sum2 -= matrix0[p12] * matrix0[p22];
                            p12++;
                            p22 += 3;
                        }
                        matrix0[target2] = sum2;
                        double temp2 = row_scale[i4] * Math.abs(sum2);
                        if (temp2 >= big2) {
                            big2 = temp2;
                            imax = i4;
                        }
                    }
                    if (imax < 0) {
                        throw new RuntimeException(VecMathI18N.getString("Matrix3d13"));
                    }
                    if (j3 != imax) {
                        int k5 = 3;
                        int p13 = 0 + (imax * 3);
                        int p23 = 0 + (j3 * 3);
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
                    if (matrix0[(j3 * 3) + 0 + j3] == Utils.DOUBLE_EPSILON) {
                        return false;
                    }
                    if (j3 != 2) {
                        double temp4 = 1.0d / matrix0[((j3 * 3) + 0) + j3];
                        int target3 = ((j3 + 1) * 3) + 0 + j3;
                        int i5 = 2 - j3;
                        while (true) {
                            int i6 = i5;
                            i5 = i6 - 1;
                            if (i6 == 0) {
                                break;
                            }
                            matrix0[target3] = matrix0[target3] * temp4;
                            target3 += 3;
                        }
                    }
                }
                return true;
            }
        }
    }

    static void luBacksubstitution(double[] matrix1, int[] row_perm, double[] matrix2) {
        for (int k = 0; k < 3; k++) {
            int cv = k;
            int ii = -1;
            for (int i = 0; i < 3; i++) {
                int ip = row_perm[0 + i];
                double sum = matrix2[(ip * 3) + cv];
                matrix2[(ip * 3) + cv] = matrix2[(i * 3) + cv];
                if (ii >= 0) {
                    int rv = i * 3;
                    for (int j = ii; j <= i - 1; j++) {
                        sum -= matrix1[rv + j] * matrix2[(j * 3) + cv];
                    }
                } else if (sum != Utils.DOUBLE_EPSILON) {
                    ii = i;
                }
                matrix2[(i * 3) + cv] = sum;
            }
            int i2 = cv + 6;
            matrix2[i2] = matrix2[i2] / matrix1[8];
            matrix2[cv + 3] = (matrix2[cv + 3] - (matrix1[5] * matrix2[cv + 6])) / matrix1[4];
            int rv2 = (6 - 3) - 3;
            matrix2[cv + 0] = ((matrix2[cv + 0] - (matrix1[1] * matrix2[cv + 3])) - (matrix1[2] * matrix2[cv + 6])) / matrix1[0];
        }
    }

    public final double determinant() {
        return (this.m00 * ((this.m11 * this.m22) - (this.m12 * this.m21))) + (this.m01 * ((this.m12 * this.m20) - (this.m10 * this.m22))) + (this.m02 * ((this.m10 * this.m21) - (this.m11 * this.m20)));
    }

    public final void set(double scale) {
        this.m00 = scale;
        this.m01 = Utils.DOUBLE_EPSILON;
        this.m02 = Utils.DOUBLE_EPSILON;
        this.m10 = Utils.DOUBLE_EPSILON;
        this.m11 = scale;
        this.m12 = Utils.DOUBLE_EPSILON;
        this.m20 = Utils.DOUBLE_EPSILON;
        this.m21 = Utils.DOUBLE_EPSILON;
        this.m22 = scale;
    }

    public final void rotX(double angle) {
        double sinAngle = Math.sin(angle);
        double cosAngle = Math.cos(angle);
        this.m00 = 1.0d;
        this.m01 = Utils.DOUBLE_EPSILON;
        this.m02 = Utils.DOUBLE_EPSILON;
        this.m10 = Utils.DOUBLE_EPSILON;
        this.m11 = cosAngle;
        this.m12 = -sinAngle;
        this.m20 = Utils.DOUBLE_EPSILON;
        this.m21 = sinAngle;
        this.m22 = cosAngle;
    }

    public final void rotY(double angle) {
        double sinAngle = Math.sin(angle);
        double cosAngle = Math.cos(angle);
        this.m00 = cosAngle;
        this.m01 = Utils.DOUBLE_EPSILON;
        this.m02 = sinAngle;
        this.m10 = Utils.DOUBLE_EPSILON;
        this.m11 = 1.0d;
        this.m12 = Utils.DOUBLE_EPSILON;
        this.m20 = -sinAngle;
        this.m21 = Utils.DOUBLE_EPSILON;
        this.m22 = cosAngle;
    }

    public final void rotZ(double angle) {
        double sinAngle = Math.sin(angle);
        double cosAngle = Math.cos(angle);
        this.m00 = cosAngle;
        this.m01 = -sinAngle;
        this.m02 = Utils.DOUBLE_EPSILON;
        this.m10 = sinAngle;
        this.m11 = cosAngle;
        this.m12 = Utils.DOUBLE_EPSILON;
        this.m20 = Utils.DOUBLE_EPSILON;
        this.m21 = Utils.DOUBLE_EPSILON;
        this.m22 = 1.0d;
    }

    public final void mul(double scalar) {
        this.m00 *= scalar;
        this.m01 *= scalar;
        this.m02 *= scalar;
        this.m10 *= scalar;
        this.m11 *= scalar;
        this.m12 *= scalar;
        this.m20 *= scalar;
        this.m21 *= scalar;
        this.m22 *= scalar;
    }

    public final void mul(double scalar, Matrix3d m1) {
        this.m00 = m1.m00 * scalar;
        this.m01 = m1.m01 * scalar;
        this.m02 = m1.m02 * scalar;
        this.m10 = m1.m10 * scalar;
        this.m11 = m1.m11 * scalar;
        this.m12 = m1.m12 * scalar;
        this.m20 = m1.m20 * scalar;
        this.m21 = m1.m21 * scalar;
        this.m22 = m1.m22 * scalar;
    }

    public final void mul(Matrix3d m1) {
        double m002 = (this.m00 * m1.m00) + (this.m01 * m1.m10) + (this.m02 * m1.m20);
        double m012 = (this.m00 * m1.m01) + (this.m01 * m1.m11) + (this.m02 * m1.m21);
        double m022 = (this.m00 * m1.m02) + (this.m01 * m1.m12) + (this.m02 * m1.m22);
        double m102 = (this.m10 * m1.m00) + (this.m11 * m1.m10) + (this.m12 * m1.m20);
        double m112 = (this.m10 * m1.m01) + (this.m11 * m1.m11) + (this.m12 * m1.m21);
        double m122 = (this.m10 * m1.m02) + (this.m11 * m1.m12) + (this.m12 * m1.m22);
        double m202 = (this.m20 * m1.m00) + (this.m21 * m1.m10) + (this.m22 * m1.m20);
        double m212 = (this.m20 * m1.m01) + (this.m21 * m1.m11) + (this.m22 * m1.m21);
        this.m00 = m002;
        this.m01 = m012;
        this.m02 = m022;
        this.m10 = m102;
        this.m11 = m112;
        this.m12 = m122;
        this.m20 = m202;
        this.m21 = m212;
        this.m22 = (this.m20 * m1.m02) + (this.m21 * m1.m12) + (this.m22 * m1.m22);
    }

    public final void mul(Matrix3d m1, Matrix3d m2) {
        if (this == m1 || this == m2) {
            double m002 = (m1.m00 * m2.m00) + (m1.m01 * m2.m10) + (m1.m02 * m2.m20);
            double m012 = (m1.m00 * m2.m01) + (m1.m01 * m2.m11) + (m1.m02 * m2.m21);
            double m022 = (m1.m00 * m2.m02) + (m1.m01 * m2.m12) + (m1.m02 * m2.m22);
            double m102 = (m1.m10 * m2.m00) + (m1.m11 * m2.m10) + (m1.m12 * m2.m20);
            double m112 = (m1.m10 * m2.m01) + (m1.m11 * m2.m11) + (m1.m12 * m2.m21);
            double m122 = (m1.m10 * m2.m02) + (m1.m11 * m2.m12) + (m1.m12 * m2.m22);
            double m202 = (m1.m20 * m2.m00) + (m1.m21 * m2.m10) + (m1.m22 * m2.m20);
            double m212 = (m1.m20 * m2.m01) + (m1.m21 * m2.m11) + (m1.m22 * m2.m21);
            this.m00 = m002;
            this.m01 = m012;
            this.m02 = m022;
            this.m10 = m102;
            this.m11 = m112;
            this.m12 = m122;
            this.m20 = m202;
            this.m21 = m212;
            this.m22 = (m1.m20 * m2.m02) + (m1.m21 * m2.m12) + (m1.m22 * m2.m22);
            return;
        }
        this.m00 = (m1.m00 * m2.m00) + (m1.m01 * m2.m10) + (m1.m02 * m2.m20);
        this.m01 = (m1.m00 * m2.m01) + (m1.m01 * m2.m11) + (m1.m02 * m2.m21);
        this.m02 = (m1.m00 * m2.m02) + (m1.m01 * m2.m12) + (m1.m02 * m2.m22);
        this.m10 = (m1.m10 * m2.m00) + (m1.m11 * m2.m10) + (m1.m12 * m2.m20);
        this.m11 = (m1.m10 * m2.m01) + (m1.m11 * m2.m11) + (m1.m12 * m2.m21);
        this.m12 = (m1.m10 * m2.m02) + (m1.m11 * m2.m12) + (m1.m12 * m2.m22);
        this.m20 = (m1.m20 * m2.m00) + (m1.m21 * m2.m10) + (m1.m22 * m2.m20);
        this.m21 = (m1.m20 * m2.m01) + (m1.m21 * m2.m11) + (m1.m22 * m2.m21);
        this.m22 = (m1.m20 * m2.m02) + (m1.m21 * m2.m12) + (m1.m22 * m2.m22);
    }

    public final void mulNormalize(Matrix3d m1) {
        double[] tmp_rot = new double[9];
        compute_svd(new double[]{(this.m00 * m1.m00) + (this.m01 * m1.m10) + (this.m02 * m1.m20), (this.m00 * m1.m01) + (this.m01 * m1.m11) + (this.m02 * m1.m21), (this.m00 * m1.m02) + (this.m01 * m1.m12) + (this.m02 * m1.m22), (this.m10 * m1.m00) + (this.m11 * m1.m10) + (this.m12 * m1.m20), (this.m10 * m1.m01) + (this.m11 * m1.m11) + (this.m12 * m1.m21), (this.m10 * m1.m02) + (this.m11 * m1.m12) + (this.m12 * m1.m22), (this.m20 * m1.m00) + (this.m21 * m1.m10) + (this.m22 * m1.m20), (this.m20 * m1.m01) + (this.m21 * m1.m11) + (this.m22 * m1.m21), (this.m20 * m1.m02) + (this.m21 * m1.m12) + (this.m22 * m1.m22)}, new double[3], tmp_rot);
        this.m00 = tmp_rot[0];
        this.m01 = tmp_rot[1];
        this.m02 = tmp_rot[2];
        this.m10 = tmp_rot[3];
        this.m11 = tmp_rot[4];
        this.m12 = tmp_rot[5];
        this.m20 = tmp_rot[6];
        this.m21 = tmp_rot[7];
        this.m22 = tmp_rot[8];
    }

    public final void mulNormalize(Matrix3d m1, Matrix3d m2) {
        double[] tmp_rot = new double[9];
        compute_svd(new double[]{(m1.m00 * m2.m00) + (m1.m01 * m2.m10) + (m1.m02 * m2.m20), (m1.m00 * m2.m01) + (m1.m01 * m2.m11) + (m1.m02 * m2.m21), (m1.m00 * m2.m02) + (m1.m01 * m2.m12) + (m1.m02 * m2.m22), (m1.m10 * m2.m00) + (m1.m11 * m2.m10) + (m1.m12 * m2.m20), (m1.m10 * m2.m01) + (m1.m11 * m2.m11) + (m1.m12 * m2.m21), (m1.m10 * m2.m02) + (m1.m11 * m2.m12) + (m1.m12 * m2.m22), (m1.m20 * m2.m00) + (m1.m21 * m2.m10) + (m1.m22 * m2.m20), (m1.m20 * m2.m01) + (m1.m21 * m2.m11) + (m1.m22 * m2.m21), (m1.m20 * m2.m02) + (m1.m21 * m2.m12) + (m1.m22 * m2.m22)}, new double[3], tmp_rot);
        this.m00 = tmp_rot[0];
        this.m01 = tmp_rot[1];
        this.m02 = tmp_rot[2];
        this.m10 = tmp_rot[3];
        this.m11 = tmp_rot[4];
        this.m12 = tmp_rot[5];
        this.m20 = tmp_rot[6];
        this.m21 = tmp_rot[7];
        this.m22 = tmp_rot[8];
    }

    public final void mulTransposeBoth(Matrix3d m1, Matrix3d m2) {
        if (this == m1 || this == m2) {
            double m002 = (m1.m00 * m2.m00) + (m1.m10 * m2.m01) + (m1.m20 * m2.m02);
            double m012 = (m1.m00 * m2.m10) + (m1.m10 * m2.m11) + (m1.m20 * m2.m12);
            double m022 = (m1.m00 * m2.m20) + (m1.m10 * m2.m21) + (m1.m20 * m2.m22);
            double m102 = (m1.m01 * m2.m00) + (m1.m11 * m2.m01) + (m1.m21 * m2.m02);
            double m112 = (m1.m01 * m2.m10) + (m1.m11 * m2.m11) + (m1.m21 * m2.m12);
            double m122 = (m1.m01 * m2.m20) + (m1.m11 * m2.m21) + (m1.m21 * m2.m22);
            double m202 = (m1.m02 * m2.m00) + (m1.m12 * m2.m01) + (m1.m22 * m2.m02);
            double m212 = (m1.m02 * m2.m10) + (m1.m12 * m2.m11) + (m1.m22 * m2.m12);
            this.m00 = m002;
            this.m01 = m012;
            this.m02 = m022;
            this.m10 = m102;
            this.m11 = m112;
            this.m12 = m122;
            this.m20 = m202;
            this.m21 = m212;
            this.m22 = (m1.m02 * m2.m20) + (m1.m12 * m2.m21) + (m1.m22 * m2.m22);
            return;
        }
        this.m00 = (m1.m00 * m2.m00) + (m1.m10 * m2.m01) + (m1.m20 * m2.m02);
        this.m01 = (m1.m00 * m2.m10) + (m1.m10 * m2.m11) + (m1.m20 * m2.m12);
        this.m02 = (m1.m00 * m2.m20) + (m1.m10 * m2.m21) + (m1.m20 * m2.m22);
        this.m10 = (m1.m01 * m2.m00) + (m1.m11 * m2.m01) + (m1.m21 * m2.m02);
        this.m11 = (m1.m01 * m2.m10) + (m1.m11 * m2.m11) + (m1.m21 * m2.m12);
        this.m12 = (m1.m01 * m2.m20) + (m1.m11 * m2.m21) + (m1.m21 * m2.m22);
        this.m20 = (m1.m02 * m2.m00) + (m1.m12 * m2.m01) + (m1.m22 * m2.m02);
        this.m21 = (m1.m02 * m2.m10) + (m1.m12 * m2.m11) + (m1.m22 * m2.m12);
        this.m22 = (m1.m02 * m2.m20) + (m1.m12 * m2.m21) + (m1.m22 * m2.m22);
    }

    public final void mulTransposeRight(Matrix3d m1, Matrix3d m2) {
        if (this == m1 || this == m2) {
            double m002 = (m1.m00 * m2.m00) + (m1.m01 * m2.m01) + (m1.m02 * m2.m02);
            double m012 = (m1.m00 * m2.m10) + (m1.m01 * m2.m11) + (m1.m02 * m2.m12);
            double m022 = (m1.m00 * m2.m20) + (m1.m01 * m2.m21) + (m1.m02 * m2.m22);
            double m102 = (m1.m10 * m2.m00) + (m1.m11 * m2.m01) + (m1.m12 * m2.m02);
            double m112 = (m1.m10 * m2.m10) + (m1.m11 * m2.m11) + (m1.m12 * m2.m12);
            double m122 = (m1.m10 * m2.m20) + (m1.m11 * m2.m21) + (m1.m12 * m2.m22);
            double m202 = (m1.m20 * m2.m00) + (m1.m21 * m2.m01) + (m1.m22 * m2.m02);
            double m212 = (m1.m20 * m2.m10) + (m1.m21 * m2.m11) + (m1.m22 * m2.m12);
            this.m00 = m002;
            this.m01 = m012;
            this.m02 = m022;
            this.m10 = m102;
            this.m11 = m112;
            this.m12 = m122;
            this.m20 = m202;
            this.m21 = m212;
            this.m22 = (m1.m20 * m2.m20) + (m1.m21 * m2.m21) + (m1.m22 * m2.m22);
            return;
        }
        this.m00 = (m1.m00 * m2.m00) + (m1.m01 * m2.m01) + (m1.m02 * m2.m02);
        this.m01 = (m1.m00 * m2.m10) + (m1.m01 * m2.m11) + (m1.m02 * m2.m12);
        this.m02 = (m1.m00 * m2.m20) + (m1.m01 * m2.m21) + (m1.m02 * m2.m22);
        this.m10 = (m1.m10 * m2.m00) + (m1.m11 * m2.m01) + (m1.m12 * m2.m02);
        this.m11 = (m1.m10 * m2.m10) + (m1.m11 * m2.m11) + (m1.m12 * m2.m12);
        this.m12 = (m1.m10 * m2.m20) + (m1.m11 * m2.m21) + (m1.m12 * m2.m22);
        this.m20 = (m1.m20 * m2.m00) + (m1.m21 * m2.m01) + (m1.m22 * m2.m02);
        this.m21 = (m1.m20 * m2.m10) + (m1.m21 * m2.m11) + (m1.m22 * m2.m12);
        this.m22 = (m1.m20 * m2.m20) + (m1.m21 * m2.m21) + (m1.m22 * m2.m22);
    }

    public final void mulTransposeLeft(Matrix3d m1, Matrix3d m2) {
        if (this == m1 || this == m2) {
            double m002 = (m1.m00 * m2.m00) + (m1.m10 * m2.m10) + (m1.m20 * m2.m20);
            double m012 = (m1.m00 * m2.m01) + (m1.m10 * m2.m11) + (m1.m20 * m2.m21);
            double m022 = (m1.m00 * m2.m02) + (m1.m10 * m2.m12) + (m1.m20 * m2.m22);
            double m102 = (m1.m01 * m2.m00) + (m1.m11 * m2.m10) + (m1.m21 * m2.m20);
            double m112 = (m1.m01 * m2.m01) + (m1.m11 * m2.m11) + (m1.m21 * m2.m21);
            double m122 = (m1.m01 * m2.m02) + (m1.m11 * m2.m12) + (m1.m21 * m2.m22);
            double m202 = (m1.m02 * m2.m00) + (m1.m12 * m2.m10) + (m1.m22 * m2.m20);
            double m212 = (m1.m02 * m2.m01) + (m1.m12 * m2.m11) + (m1.m22 * m2.m21);
            this.m00 = m002;
            this.m01 = m012;
            this.m02 = m022;
            this.m10 = m102;
            this.m11 = m112;
            this.m12 = m122;
            this.m20 = m202;
            this.m21 = m212;
            this.m22 = (m1.m02 * m2.m02) + (m1.m12 * m2.m12) + (m1.m22 * m2.m22);
            return;
        }
        this.m00 = (m1.m00 * m2.m00) + (m1.m10 * m2.m10) + (m1.m20 * m2.m20);
        this.m01 = (m1.m00 * m2.m01) + (m1.m10 * m2.m11) + (m1.m20 * m2.m21);
        this.m02 = (m1.m00 * m2.m02) + (m1.m10 * m2.m12) + (m1.m20 * m2.m22);
        this.m10 = (m1.m01 * m2.m00) + (m1.m11 * m2.m10) + (m1.m21 * m2.m20);
        this.m11 = (m1.m01 * m2.m01) + (m1.m11 * m2.m11) + (m1.m21 * m2.m21);
        this.m12 = (m1.m01 * m2.m02) + (m1.m11 * m2.m12) + (m1.m21 * m2.m22);
        this.m20 = (m1.m02 * m2.m00) + (m1.m12 * m2.m10) + (m1.m22 * m2.m20);
        this.m21 = (m1.m02 * m2.m01) + (m1.m12 * m2.m11) + (m1.m22 * m2.m21);
        this.m22 = (m1.m02 * m2.m02) + (m1.m12 * m2.m12) + (m1.m22 * m2.m22);
    }

    public final void normalize() {
        double[] tmp_rot = new double[9];
        getScaleRotate(new double[3], tmp_rot);
        this.m00 = tmp_rot[0];
        this.m01 = tmp_rot[1];
        this.m02 = tmp_rot[2];
        this.m10 = tmp_rot[3];
        this.m11 = tmp_rot[4];
        this.m12 = tmp_rot[5];
        this.m20 = tmp_rot[6];
        this.m21 = tmp_rot[7];
        this.m22 = tmp_rot[8];
    }

    public final void normalize(Matrix3d m1) {
        double[] tmp_rot = new double[9];
        compute_svd(new double[]{m1.m00, m1.m01, m1.m02, m1.m10, m1.m11, m1.m12, m1.m20, m1.m21, m1.m22}, new double[3], tmp_rot);
        this.m00 = tmp_rot[0];
        this.m01 = tmp_rot[1];
        this.m02 = tmp_rot[2];
        this.m10 = tmp_rot[3];
        this.m11 = tmp_rot[4];
        this.m12 = tmp_rot[5];
        this.m20 = tmp_rot[6];
        this.m21 = tmp_rot[7];
        this.m22 = tmp_rot[8];
    }

    public final void normalizeCP() {
        double mag = 1.0d / Math.sqrt(((this.m00 * this.m00) + (this.m10 * this.m10)) + (this.m20 * this.m20));
        this.m00 *= mag;
        this.m10 *= mag;
        this.m20 *= mag;
        double mag2 = 1.0d / Math.sqrt(((this.m01 * this.m01) + (this.m11 * this.m11)) + (this.m21 * this.m21));
        this.m01 *= mag2;
        this.m11 *= mag2;
        this.m21 *= mag2;
        this.m02 = (this.m10 * this.m21) - (this.m11 * this.m20);
        this.m12 = (this.m01 * this.m20) - (this.m00 * this.m21);
        this.m22 = (this.m00 * this.m11) - (this.m01 * this.m10);
    }

    public final void normalizeCP(Matrix3d m1) {
        double mag = 1.0d / Math.sqrt(((m1.m00 * m1.m00) + (m1.m10 * m1.m10)) + (m1.m20 * m1.m20));
        this.m00 = m1.m00 * mag;
        this.m10 = m1.m10 * mag;
        this.m20 = m1.m20 * mag;
        double mag2 = 1.0d / Math.sqrt(((m1.m01 * m1.m01) + (m1.m11 * m1.m11)) + (m1.m21 * m1.m21));
        this.m01 = m1.m01 * mag2;
        this.m11 = m1.m11 * mag2;
        this.m21 = m1.m21 * mag2;
        this.m02 = (this.m10 * this.m21) - (this.m11 * this.m20);
        this.m12 = (this.m01 * this.m20) - (this.m00 * this.m21);
        this.m22 = (this.m00 * this.m11) - (this.m01 * this.m10);
    }

    public boolean equals(Matrix3d m1) {
        try {
            return this.m00 == m1.m00 && this.m01 == m1.m01 && this.m02 == m1.m02 && this.m10 == m1.m10 && this.m11 == m1.m11 && this.m12 == m1.m12 && this.m20 == m1.m20 && this.m21 == m1.m21 && this.m22 == m1.m22;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean equals(Object t1) {
        try {
            Matrix3d m2 = (Matrix3d) t1;
            if (this.m00 == m2.m00 && this.m01 == m2.m01 && this.m02 == m2.m02 && this.m10 == m2.m10 && this.m11 == m2.m11 && this.m12 == m2.m12 && this.m20 == m2.m20 && this.m21 == m2.m21 && this.m22 == m2.m22) {
                return true;
            }
            return false;
        } catch (ClassCastException e) {
            return false;
        } catch (NullPointerException e2) {
            return false;
        }
    }

    public boolean epsilonEquals(Matrix3d m1, double epsilon) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
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
        double diff4 = this.m10 - m1.m10;
        if (diff4 < Utils.DOUBLE_EPSILON) {
            d3 = -diff4;
        } else {
            d3 = diff4;
        }
        if (d3 > epsilon) {
            return false;
        }
        double diff5 = this.m11 - m1.m11;
        if (diff5 < Utils.DOUBLE_EPSILON) {
            d4 = -diff5;
        } else {
            d4 = diff5;
        }
        if (d4 > epsilon) {
            return false;
        }
        double diff6 = this.m12 - m1.m12;
        if (diff6 < Utils.DOUBLE_EPSILON) {
            d5 = -diff6;
        } else {
            d5 = diff6;
        }
        if (d5 > epsilon) {
            return false;
        }
        double diff7 = this.m20 - m1.m20;
        if (diff7 < Utils.DOUBLE_EPSILON) {
            d6 = -diff7;
        } else {
            d6 = diff7;
        }
        if (d6 > epsilon) {
            return false;
        }
        double diff8 = this.m21 - m1.m21;
        if (diff8 < Utils.DOUBLE_EPSILON) {
            d7 = -diff8;
        } else {
            d7 = diff8;
        }
        if (d7 > epsilon) {
            return false;
        }
        double diff9 = this.m22 - m1.m22;
        if (diff9 < Utils.DOUBLE_EPSILON) {
            d8 = -diff9;
        } else {
            d8 = diff9;
        }
        if (d8 <= epsilon) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long bits = (31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * 1) + VecMathUtil.doubleToLongBits(this.m00))) + VecMathUtil.doubleToLongBits(this.m01))) + VecMathUtil.doubleToLongBits(this.m02))) + VecMathUtil.doubleToLongBits(this.m10))) + VecMathUtil.doubleToLongBits(this.m11))) + VecMathUtil.doubleToLongBits(this.m12))) + VecMathUtil.doubleToLongBits(this.m20))) + VecMathUtil.doubleToLongBits(this.m21))) + VecMathUtil.doubleToLongBits(this.m22);
        return (int) ((bits >> 32) ^ bits);
    }

    public final void setZero() {
        this.m00 = Utils.DOUBLE_EPSILON;
        this.m01 = Utils.DOUBLE_EPSILON;
        this.m02 = Utils.DOUBLE_EPSILON;
        this.m10 = Utils.DOUBLE_EPSILON;
        this.m11 = Utils.DOUBLE_EPSILON;
        this.m12 = Utils.DOUBLE_EPSILON;
        this.m20 = Utils.DOUBLE_EPSILON;
        this.m21 = Utils.DOUBLE_EPSILON;
        this.m22 = Utils.DOUBLE_EPSILON;
    }

    public final void negate() {
        this.m00 = -this.m00;
        this.m01 = -this.m01;
        this.m02 = -this.m02;
        this.m10 = -this.m10;
        this.m11 = -this.m11;
        this.m12 = -this.m12;
        this.m20 = -this.m20;
        this.m21 = -this.m21;
        this.m22 = -this.m22;
    }

    public final void negate(Matrix3d m1) {
        this.m00 = -m1.m00;
        this.m01 = -m1.m01;
        this.m02 = -m1.m02;
        this.m10 = -m1.m10;
        this.m11 = -m1.m11;
        this.m12 = -m1.m12;
        this.m20 = -m1.m20;
        this.m21 = -m1.m21;
        this.m22 = -m1.m22;
    }

    public final void transform(Tuple3d t) {
        t.set((this.m00 * t.f155x) + (this.m01 * t.f156y) + (this.m02 * t.f157z), (this.m10 * t.f155x) + (this.m11 * t.f156y) + (this.m12 * t.f157z), (this.m20 * t.f155x) + (this.m21 * t.f156y) + (this.m22 * t.f157z));
    }

    public final void transform(Tuple3d t, Tuple3d result) {
        double x = (this.m00 * t.f155x) + (this.m01 * t.f156y) + (this.m02 * t.f157z);
        double y = (this.m10 * t.f155x) + (this.m11 * t.f156y) + (this.m12 * t.f157z);
        result.f157z = (this.m20 * t.f155x) + (this.m21 * t.f156y) + (this.m22 * t.f157z);
        result.f155x = x;
        result.f156y = y;
    }

    /* access modifiers changed from: package-private */
    public final void getScaleRotate(double[] scales, double[] rots) {
        compute_svd(new double[]{this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m20, this.m21, this.m22}, scales, rots);
    }

    static void compute_svd(double[] m, double[] outScale, double[] outRot) {
        double[] u1 = new double[9];
        double[] v1 = new double[9];
        double[] t1 = new double[9];
        double[] t2 = new double[9];
        double[] tmp = t1;
        double[] single_values = t2;
        double[] rot = new double[9];
        double[] e = new double[3];
        double[] scales = new double[3];
        int negCnt = 0;
        for (int i = 0; i < 9; i++) {
            rot[i] = m[i];
        }
        if (m[3] * m[3] < EPS) {
            u1[0] = 4607182418800017408;
            u1[1] = 0;
            u1[2] = 0;
            u1[3] = 0;
            u1[4] = 4607182418800017408;
            u1[5] = 0;
            u1[6] = 0;
            u1[7] = 0;
            u1[8] = 4607182418800017408;
        } else if (m[0] * m[0] < EPS) {
            tmp[0] = m[0];
            tmp[1] = m[1];
            tmp[2] = m[2];
            m[0] = m[3];
            m[1] = m[4];
            m[2] = m[5];
            m[3] = -tmp[0];
            m[4] = -tmp[1];
            m[5] = -tmp[2];
            u1[0] = 0.0d;
            u1[1] = 1.0d;
            u1[2] = 0.0d;
            u1[3] = -1.0d;
            u1[4] = 0.0d;
            u1[5] = 0.0d;
            u1[6] = 0.0d;
            u1[7] = 0.0d;
            u1[8] = 1.0d;
        } else {
            double g = 1.0d / Math.sqrt((m[0] * m[0]) + (m[3] * m[3]));
            double c1 = m[0] * g;
            double s1 = m[3] * g;
            tmp[0] = (m[0] * c1) + (m[3] * s1);
            tmp[1] = (m[1] * c1) + (m[4] * s1);
            tmp[2] = (m[2] * c1) + (m[5] * s1);
            m[3] = ((-s1) * m[0]) + (m[3] * c1);
            m[4] = ((-s1) * m[1]) + (m[4] * c1);
            m[5] = ((-s1) * m[2]) + (m[5] * c1);
            m[0] = tmp[0];
            m[1] = tmp[1];
            m[2] = tmp[2];
            u1[0] = c1;
            u1[1] = s1;
            u1[2] = 0.0d;
            u1[3] = -s1;
            u1[4] = c1;
            u1[5] = 0.0d;
            u1[6] = 0.0d;
            u1[7] = 0.0d;
            u1[8] = 1.0d;
        }
        if (m[6] * m[6] >= EPS) {
            if (m[0] * m[0] < EPS) {
                tmp[0] = m[0];
                tmp[1] = m[1];
                tmp[2] = m[2];
                m[0] = m[6];
                m[1] = m[7];
                m[2] = m[8];
                m[6] = -tmp[0];
                m[7] = -tmp[1];
                m[8] = -tmp[2];
                tmp[0] = u1[0];
                tmp[1] = u1[1];
                tmp[2] = u1[2];
                u1[0] = u1[6];
                u1[1] = u1[7];
                u1[2] = u1[8];
                u1[6] = -tmp[0];
                u1[7] = -tmp[1];
                u1[8] = -tmp[2];
            } else {
                double g2 = 1.0d / Math.sqrt((m[0] * m[0]) + (m[6] * m[6]));
                double c2 = m[0] * g2;
                double s2 = m[6] * g2;
                tmp[0] = (m[0] * c2) + (m[6] * s2);
                tmp[1] = (m[1] * c2) + (m[7] * s2);
                tmp[2] = (m[2] * c2) + (m[8] * s2);
                m[6] = ((-s2) * m[0]) + (m[6] * c2);
                m[7] = ((-s2) * m[1]) + (m[7] * c2);
                m[8] = ((-s2) * m[2]) + (m[8] * c2);
                m[0] = tmp[0];
                m[1] = tmp[1];
                m[2] = tmp[2];
                tmp[0] = u1[0] * c2;
                tmp[1] = u1[1] * c2;
                u1[2] = s2;
                tmp[6] = (-u1[0]) * s2;
                tmp[7] = (-u1[1]) * s2;
                u1[8] = c2;
                u1[0] = tmp[0];
                u1[1] = tmp[1];
                u1[6] = tmp[6];
                u1[7] = tmp[7];
            }
        }
        if (m[2] * m[2] < EPS) {
            v1[0] = 1.0d;
            v1[1] = 0.0d;
            v1[2] = 0.0d;
            v1[3] = 0.0d;
            v1[4] = 1.0d;
            v1[5] = 0.0d;
            v1[6] = 0.0d;
            v1[7] = 0.0d;
            v1[8] = 1.0d;
        } else if (m[1] * m[1] < EPS) {
            tmp[2] = m[2];
            tmp[5] = m[5];
            tmp[8] = m[8];
            m[2] = -m[1];
            m[5] = -m[4];
            m[8] = -m[7];
            m[1] = tmp[2];
            m[4] = tmp[5];
            m[7] = tmp[8];
            v1[0] = 1.0d;
            v1[1] = 0.0d;
            v1[2] = 0.0d;
            v1[3] = 0.0d;
            v1[4] = 0.0d;
            v1[5] = -1.0d;
            v1[6] = 0.0d;
            v1[7] = 1.0d;
            v1[8] = 0.0d;
        } else {
            double g3 = 1.0d / Math.sqrt((m[1] * m[1]) + (m[2] * m[2]));
            double c3 = m[1] * g3;
            double s3 = m[2] * g3;
            tmp[1] = (m[1] * c3) + (m[2] * s3);
            m[2] = ((-s3) * m[1]) + (m[2] * c3);
            m[1] = tmp[1];
            tmp[4] = (m[4] * c3) + (m[5] * s3);
            m[5] = ((-s3) * m[4]) + (m[5] * c3);
            m[4] = tmp[4];
            tmp[7] = (m[7] * c3) + (m[8] * s3);
            m[8] = ((-s3) * m[7]) + (m[8] * c3);
            m[7] = tmp[7];
            v1[0] = 1.0d;
            v1[1] = 0.0d;
            v1[2] = 0.0d;
            v1[3] = 0.0d;
            v1[4] = c3;
            v1[5] = -s3;
            v1[6] = 0.0d;
            v1[7] = s3;
            v1[8] = c3;
        }
        if (m[7] * m[7] >= EPS) {
            if (m[4] * m[4] < EPS) {
                tmp[3] = m[3];
                tmp[4] = m[4];
                tmp[5] = m[5];
                m[3] = m[6];
                m[4] = m[7];
                m[5] = m[8];
                m[6] = -tmp[3];
                m[7] = -tmp[4];
                m[8] = -tmp[5];
                tmp[3] = u1[3];
                tmp[4] = u1[4];
                tmp[5] = u1[5];
                u1[3] = u1[6];
                u1[4] = u1[7];
                u1[5] = u1[8];
                u1[6] = -tmp[3];
                u1[7] = -tmp[4];
                u1[8] = -tmp[5];
            } else {
                double g4 = 1.0d / Math.sqrt((m[4] * m[4]) + (m[7] * m[7]));
                double c4 = m[4] * g4;
                double s4 = m[7] * g4;
                tmp[3] = (m[3] * c4) + (m[6] * s4);
                m[6] = ((-s4) * m[3]) + (m[6] * c4);
                m[3] = tmp[3];
                tmp[4] = (m[4] * c4) + (m[7] * s4);
                m[7] = ((-s4) * m[4]) + (m[7] * c4);
                m[4] = tmp[4];
                tmp[5] = (m[5] * c4) + (m[8] * s4);
                m[8] = ((-s4) * m[5]) + (m[8] * c4);
                m[5] = tmp[5];
                tmp[3] = (u1[3] * c4) + (u1[6] * s4);
                u1[6] = ((-s4) * u1[3]) + (u1[6] * c4);
                u1[3] = tmp[3];
                tmp[4] = (u1[4] * c4) + (u1[7] * s4);
                u1[7] = ((-s4) * u1[4]) + (u1[7] * c4);
                u1[4] = tmp[4];
                tmp[5] = (u1[5] * c4) + (u1[8] * s4);
                u1[8] = ((-s4) * u1[5]) + (u1[8] * c4);
                u1[5] = tmp[5];
            }
        }
        single_values[0] = m[0];
        single_values[1] = m[4];
        single_values[2] = m[8];
        e[0] = m[1];
        e[1] = m[5];
        if (e[0] * e[0] >= EPS || e[1] * e[1] >= EPS) {
            compute_qr(single_values, e, u1, v1);
        }
        scales[0] = single_values[0];
        scales[1] = single_values[1];
        scales[2] = single_values[2];
        if (almostEqual(Math.abs(scales[0]), 1.0d) && almostEqual(Math.abs(scales[1]), 1.0d) && almostEqual(Math.abs(scales[2]), 1.0d)) {
            for (int i2 = 0; i2 < 3; i2++) {
                if (scales[i2] < Utils.DOUBLE_EPSILON) {
                    negCnt++;
                }
            }
            if (negCnt == 0 || negCnt == 2) {
                outScale[2] = 1.0d;
                outScale[1] = 1.0d;
                outScale[0] = 1.0d;
                for (int i3 = 0; i3 < 9; i3++) {
                    outRot[i3] = rot[i3];
                }
                return;
            }
        }
        transpose_mat(u1, t1);
        transpose_mat(v1, t2);
        svdReorder(m, t1, t2, scales, outRot, outScale);
    }

    static void svdReorder(double[] m, double[] t1, double[] t2, double[] scales, double[] outRot, double[] outScale) {
        int in2;
        int in1;
        int in0;
        int[] out = new int[3];
        int[] iArr = new int[3];
        double[] mag = new double[3];
        double[] rot = new double[9];
        if (scales[0] < Utils.DOUBLE_EPSILON) {
            scales[0] = -scales[0];
            t2[0] = -t2[0];
            t2[1] = -t2[1];
            t2[2] = -t2[2];
        }
        if (scales[1] < Utils.DOUBLE_EPSILON) {
            scales[1] = -scales[1];
            t2[3] = -t2[3];
            t2[4] = -t2[4];
            t2[5] = -t2[5];
        }
        if (scales[2] < Utils.DOUBLE_EPSILON) {
            scales[2] = -scales[2];
            t2[6] = -t2[6];
            t2[7] = -t2[7];
            t2[8] = -t2[8];
        }
        mat_mul(t1, t2, rot);
        if (!almostEqual(Math.abs(scales[0]), Math.abs(scales[1])) || !almostEqual(Math.abs(scales[1]), Math.abs(scales[2]))) {
            if (scales[0] > scales[1]) {
                if (scales[0] <= scales[2]) {
                    out[0] = 2;
                    out[1] = 0;
                    out[2] = 1;
                } else if (scales[2] > scales[1]) {
                    out[0] = 0;
                    out[1] = 2;
                    out[2] = 1;
                } else {
                    out[0] = 0;
                    out[1] = 1;
                    out[2] = 2;
                }
            } else if (scales[1] <= scales[2]) {
                out[0] = 2;
                out[1] = 1;
                out[2] = 0;
            } else if (scales[2] > scales[0]) {
                out[0] = 1;
                out[1] = 2;
                out[2] = 0;
            } else {
                out[0] = 1;
                out[1] = 0;
                out[2] = 2;
            }
            mag[0] = (m[0] * m[0]) + (m[1] * m[1]) + (m[2] * m[2]);
            mag[1] = (m[3] * m[3]) + (m[4] * m[4]) + (m[5] * m[5]);
            mag[2] = (m[6] * m[6]) + (m[7] * m[7]) + (m[8] * m[8]);
            if (mag[0] > mag[1]) {
                if (mag[0] <= mag[2]) {
                    in2 = 0;
                    in0 = 1;
                    in1 = 2;
                } else if (mag[2] > mag[1]) {
                    in0 = 0;
                    in2 = 1;
                    in1 = 2;
                } else {
                    in0 = 0;
                    in1 = 1;
                    in2 = 2;
                }
            } else if (mag[1] <= mag[2]) {
                in2 = 0;
                in1 = 1;
                in0 = 2;
            } else if (mag[2] > mag[0]) {
                in1 = 0;
                in2 = 1;
                in0 = 2;
            } else {
                in1 = 0;
                in0 = 1;
                in2 = 2;
            }
            outScale[0] = scales[out[in0]];
            outScale[1] = scales[out[in1]];
            outScale[2] = scales[out[in2]];
            outRot[0] = rot[out[in0]];
            outRot[3] = rot[out[in0] + 3];
            outRot[6] = rot[out[in0] + 6];
            outRot[1] = rot[out[in1]];
            outRot[4] = rot[out[in1] + 3];
            outRot[7] = rot[out[in1] + 6];
            outRot[2] = rot[out[in2]];
            outRot[5] = rot[out[in2] + 3];
            outRot[8] = rot[out[in2] + 6];
            return;
        }
        for (int i = 0; i < 9; i++) {
            outRot[i] = rot[i];
        }
        for (int i2 = 0; i2 < 3; i2++) {
            outScale[i2] = scales[i2];
        }
    }

    static int compute_qr(double[] s, double[] e, double[] u, double[] v) {
        double[] cosl = new double[2];
        double[] cosr = new double[2];
        double[] sinl = new double[2];
        double[] sinr = new double[2];
        double[] m = new double[9];
        boolean converged = false;
        int first = 1;
        if (Math.abs(e[1]) < 4.89E-15d || Math.abs(e[0]) < 4.89E-15d) {
            converged = true;
        }
        for (int k = 0; k < 10 && !converged; k++) {
            double shift = compute_shift(s[1], e[1], s[2]);
            double compute_rot = compute_rot((Math.abs(s[0]) - shift) * (d_sign(1.0d, s[0]) + (shift / s[0])), e[0], sinr, cosr, 0, first);
            double f = (cosr[0] * s[0]) + (sinr[0] * e[0]);
            e[0] = (cosr[0] * e[0]) - (sinr[0] * s[0]);
            double g = sinr[0] * s[1];
            s[1] = cosr[0] * s[1];
            double r = compute_rot(f, g, sinl, cosl, 0, first);
            first = 0;
            s[0] = r;
            double f2 = (cosl[0] * e[0]) + (sinl[0] * s[1]);
            s[1] = (cosl[0] * s[1]) - (sinl[0] * e[0]);
            double g2 = sinl[0] * e[1];
            e[1] = cosl[0] * e[1];
            e[0] = compute_rot(f2, g2, sinr, cosr, 1, 0);
            double f3 = (cosr[1] * s[1]) + (sinr[1] * e[1]);
            e[1] = (cosr[1] * e[1]) - (sinr[1] * s[1]);
            double g3 = sinr[1] * s[2];
            s[2] = cosr[1] * s[2];
            s[1] = compute_rot(f3, g3, sinl, cosl, 1, 0);
            double f4 = (cosl[1] * e[1]) + (sinl[1] * s[2]);
            s[2] = (cosl[1] * s[2]) - (sinl[1] * e[1]);
            e[1] = f4;
            double utemp = u[0];
            u[0] = (cosl[0] * utemp) + (sinl[0] * u[3]);
            u[3] = ((-sinl[0]) * utemp) + (cosl[0] * u[3]);
            double utemp2 = u[1];
            u[1] = (cosl[0] * utemp2) + (sinl[0] * u[4]);
            u[4] = ((-sinl[0]) * utemp2) + (cosl[0] * u[4]);
            double utemp3 = u[2];
            u[2] = (cosl[0] * utemp3) + (sinl[0] * u[5]);
            u[5] = ((-sinl[0]) * utemp3) + (cosl[0] * u[5]);
            double utemp4 = u[3];
            u[3] = (cosl[1] * utemp4) + (sinl[1] * u[6]);
            u[6] = ((-sinl[1]) * utemp4) + (cosl[1] * u[6]);
            double utemp5 = u[4];
            u[4] = (cosl[1] * utemp5) + (sinl[1] * u[7]);
            u[7] = ((-sinl[1]) * utemp5) + (cosl[1] * u[7]);
            double utemp6 = u[5];
            u[5] = (cosl[1] * utemp6) + (sinl[1] * u[8]);
            u[8] = ((-sinl[1]) * utemp6) + (cosl[1] * u[8]);
            double vtemp = v[0];
            v[0] = (cosr[0] * vtemp) + (sinr[0] * v[1]);
            v[1] = ((-sinr[0]) * vtemp) + (cosr[0] * v[1]);
            double vtemp2 = v[3];
            v[3] = (cosr[0] * vtemp2) + (sinr[0] * v[4]);
            v[4] = ((-sinr[0]) * vtemp2) + (cosr[0] * v[4]);
            double vtemp3 = v[6];
            v[6] = (cosr[0] * vtemp3) + (sinr[0] * v[7]);
            v[7] = ((-sinr[0]) * vtemp3) + (cosr[0] * v[7]);
            double vtemp4 = v[1];
            v[1] = (cosr[1] * vtemp4) + (sinr[1] * v[2]);
            v[2] = ((-sinr[1]) * vtemp4) + (cosr[1] * v[2]);
            double vtemp5 = v[4];
            v[4] = (cosr[1] * vtemp5) + (sinr[1] * v[5]);
            v[5] = ((-sinr[1]) * vtemp5) + (cosr[1] * v[5]);
            double vtemp6 = v[7];
            v[7] = (cosr[1] * vtemp6) + (sinr[1] * v[8]);
            v[8] = ((-sinr[1]) * vtemp6) + (cosr[1] * v[8]);
            m[0] = s[0];
            m[1] = e[0];
            m[2] = 0.0d;
            m[3] = 0.0d;
            m[4] = s[1];
            m[5] = e[1];
            m[6] = 0.0d;
            m[7] = 0.0d;
            m[8] = s[2];
            if (Math.abs(e[1]) < 4.89E-15d || Math.abs(e[0]) < 4.89E-15d) {
                converged = true;
            }
        }
        if (Math.abs(e[1]) < 4.89E-15d) {
            compute_2X2(s[0], e[0], s[1], s, sinl, cosl, sinr, cosr, 0);
            double utemp7 = u[0];
            u[0] = (cosl[0] * utemp7) + (sinl[0] * u[3]);
            u[3] = ((-sinl[0]) * utemp7) + (cosl[0] * u[3]);
            double utemp8 = u[1];
            u[1] = (cosl[0] * utemp8) + (sinl[0] * u[4]);
            u[4] = ((-sinl[0]) * utemp8) + (cosl[0] * u[4]);
            double utemp9 = u[2];
            u[2] = (cosl[0] * utemp9) + (sinl[0] * u[5]);
            u[5] = ((-sinl[0]) * utemp9) + (cosl[0] * u[5]);
            double vtemp7 = v[0];
            v[0] = (cosr[0] * vtemp7) + (sinr[0] * v[1]);
            v[1] = ((-sinr[0]) * vtemp7) + (cosr[0] * v[1]);
            double vtemp8 = v[3];
            v[3] = (cosr[0] * vtemp8) + (sinr[0] * v[4]);
            v[4] = ((-sinr[0]) * vtemp8) + (cosr[0] * v[4]);
            double vtemp9 = v[6];
            v[6] = (cosr[0] * vtemp9) + (sinr[0] * v[7]);
            v[7] = ((-sinr[0]) * vtemp9) + (cosr[0] * v[7]);
            return 0;
        }
        compute_2X2(s[1], e[1], s[2], s, sinl, cosl, sinr, cosr, 1);
        double utemp10 = u[3];
        u[3] = (cosl[0] * utemp10) + (sinl[0] * u[6]);
        u[6] = ((-sinl[0]) * utemp10) + (cosl[0] * u[6]);
        double utemp11 = u[4];
        u[4] = (cosl[0] * utemp11) + (sinl[0] * u[7]);
        u[7] = ((-sinl[0]) * utemp11) + (cosl[0] * u[7]);
        double utemp12 = u[5];
        u[5] = (cosl[0] * utemp12) + (sinl[0] * u[8]);
        u[8] = ((-sinl[0]) * utemp12) + (cosl[0] * u[8]);
        double vtemp10 = v[1];
        v[1] = (cosr[0] * vtemp10) + (sinr[0] * v[2]);
        v[2] = ((-sinr[0]) * vtemp10) + (cosr[0] * v[2]);
        double vtemp11 = v[4];
        v[4] = (cosr[0] * vtemp11) + (sinr[0] * v[5]);
        v[5] = ((-sinr[0]) * vtemp11) + (cosr[0] * v[5]);
        double vtemp12 = v[7];
        v[7] = (cosr[0] * vtemp12) + (sinr[0] * v[8]);
        v[8] = ((-sinr[0]) * vtemp12) + (cosr[0] * v[8]);
        return 0;
    }

    static double max(double a, double b) {
        return a > b ? a : b;
    }

    static double min(double a, double b) {
        return a < b ? a : b;
    }

    static double d_sign(double a, double b) {
        double x = a >= Utils.DOUBLE_EPSILON ? a : -a;
        return b >= Utils.DOUBLE_EPSILON ? x : -x;
    }

    static double compute_shift(double f, double g, double h) {
        double fa = Math.abs(f);
        double ga = Math.abs(g);
        double ha = Math.abs(h);
        double fhmn = min(fa, ha);
        double fhmx = max(fa, ha);
        if (fhmn == Utils.DOUBLE_EPSILON) {
            if (fhmx == Utils.DOUBLE_EPSILON) {
                return Utils.DOUBLE_EPSILON;
            }
            double min = min(fhmx, ga) / max(fhmx, ga);
            return Utils.DOUBLE_EPSILON;
        } else if (ga < fhmx) {
            double as = (fhmn / fhmx) + 1.0d;
            double at = (fhmx - fhmn) / fhmx;
            double d__1 = ga / fhmx;
            double au = d__1 * d__1;
            return fhmn * (2.0d / (Math.sqrt((as * as) + au) + Math.sqrt((at * at) + au)));
        } else {
            double au2 = fhmx / ga;
            if (au2 == Utils.DOUBLE_EPSILON) {
                return (fhmn * fhmx) / ga;
            }
            double d__12 = ((fhmn / fhmx) + 1.0d) * au2;
            double d__2 = ((fhmx - fhmn) / fhmx) * au2;
            double ssmin = fhmn * (1.0d / (Math.sqrt((d__12 * d__12) + 1.0d) + Math.sqrt((d__2 * d__2) + 1.0d))) * au2;
            return ssmin + ssmin;
        }
    }

    static int compute_2X2(double f, double g, double h, double[] single_values, double[] snl, double[] csl, double[] snr, double[] csr, int index) {
        boolean swap;
        double l;
        double r;
        double l2;
        double r2;
        double t;
        double ssmin;
        double ssmax = single_values[0];
        double ssmin2 = single_values[1];
        double clt = Utils.DOUBLE_EPSILON;
        double crt = Utils.DOUBLE_EPSILON;
        double slt = Utils.DOUBLE_EPSILON;
        double srt = Utils.DOUBLE_EPSILON;
        double tsign = Utils.DOUBLE_EPSILON;
        double ft = f;
        double fa = Math.abs(ft);
        double ht = h;
        double ha = Math.abs(h);
        int pmax = 1;
        if (ha > fa) {
            swap = true;
        } else {
            swap = false;
        }
        if (swap) {
            pmax = 3;
            double temp = ft;
            ft = ht;
            ht = temp;
            double temp2 = fa;
            fa = ha;
            ha = temp2;
        }
        double gt = g;
        double ga = Math.abs(gt);
        if (ga == Utils.DOUBLE_EPSILON) {
            single_values[1] = ha;
            single_values[0] = fa;
            return 0;
        }
        boolean gasmal = true;
        if (ga > fa) {
            pmax = 2;
            if (fa / ga < EPS) {
                gasmal = false;
                ssmax = ga;
                if (ha > 1.0d) {
                    ssmin2 = fa / (ga / ha);
                } else {
                    ssmin2 = (fa / ga) * ha;
                }
                clt = 1.0d;
                slt = ht / gt;
                srt = 1.0d;
                crt = ft / gt;
            }
        }
        if (gasmal) {
            double d = fa - ha;
            if (d == fa) {
                l = 1.0d;
            } else {
                l = d / fa;
            }
            double m = gt / ft;
            double t2 = 2.0d - l;
            double mm = m * m;
            double s = Math.sqrt((t2 * t2) + mm);
            if (l == Utils.DOUBLE_EPSILON) {
                r = Math.abs(m);
            } else {
                r = Math.sqrt((l * l) + mm);
            }
            double d2 = (s + r) * 0.5d;
            if (ga > fa) {
                pmax = 2;
                if (fa / ga < EPS) {
                    gasmal = false;
                    ssmax = ga;
                    if (ha > 1.0d) {
                        ssmin = fa / (ga / ha);
                    } else {
                        ssmin = (fa / ga) * ha;
                    }
                    clt = 1.0d;
                    slt = ht / gt;
                    srt = 1.0d;
                    crt = ft / gt;
                }
            }
            if (gasmal) {
                double d3 = fa - ha;
                if (d3 == fa) {
                    l2 = 1.0d;
                } else {
                    l2 = d3 / fa;
                }
                double m2 = gt / ft;
                double t3 = 2.0d - l2;
                double mm2 = m2 * m2;
                double s2 = Math.sqrt((t3 * t3) + mm2);
                if (l2 == Utils.DOUBLE_EPSILON) {
                    r2 = Math.abs(m2);
                } else {
                    r2 = Math.sqrt((l2 * l2) + mm2);
                }
                double a = (s2 + r2) * 0.5d;
                ssmin2 = ha / a;
                ssmax = fa * a;
                if (mm2 != Utils.DOUBLE_EPSILON) {
                    t = ((m2 / (s2 + t3)) + (m2 / (r2 + l2))) * (1.0d + a);
                } else if (l2 == Utils.DOUBLE_EPSILON) {
                    t = d_sign(2.0d, ft) * d_sign(1.0d, gt);
                } else {
                    t = (gt / d_sign(d3, ft)) + (m2 / t3);
                }
                double l3 = Math.sqrt((t * t) + 4.0d);
                crt = 2.0d / l3;
                srt = t / l3;
                clt = ((srt * m2) + crt) / a;
                slt = ((ht / ft) * srt) / a;
            }
        }
        if (swap) {
            csl[0] = srt;
            snl[0] = crt;
            csr[0] = slt;
            snr[0] = clt;
        } else {
            csl[0] = clt;
            snl[0] = slt;
            csr[0] = crt;
            snr[0] = srt;
        }
        if (pmax == 1) {
            tsign = d_sign(1.0d, csr[0]) * d_sign(1.0d, csl[0]) * d_sign(1.0d, f);
        }
        if (pmax == 2) {
            tsign = d_sign(1.0d, snr[0]) * d_sign(1.0d, csl[0]) * d_sign(1.0d, g);
        }
        if (pmax == 3) {
            tsign = d_sign(1.0d, snr[0]) * d_sign(1.0d, snl[0]) * d_sign(1.0d, h);
        }
        single_values[index] = d_sign(ssmax, tsign);
        single_values[index + 1] = d_sign(ssmin2, d_sign(1.0d, f) * tsign * d_sign(1.0d, h));
        return 0;
    }

    static double compute_rot(double f, double g, double[] sin, double[] cos, int index, int first) {
        double sn;
        double r;
        double cs;
        if (g == Utils.DOUBLE_EPSILON) {
            cs = 1.0d;
            sn = Utils.DOUBLE_EPSILON;
            r = f;
        } else if (f == Utils.DOUBLE_EPSILON) {
            cs = Utils.DOUBLE_EPSILON;
            sn = 1.0d;
            r = g;
        } else {
            double f1 = f;
            double g1 = g;
            double scale = max(Math.abs(f1), Math.abs(g1));
            if (scale >= 4.9947976805055876E145d) {
                int count = 0;
                while (scale >= 4.9947976805055876E145d) {
                    count++;
                    f1 *= 2.002083095183101E-146d;
                    g1 *= 2.002083095183101E-146d;
                    scale = max(Math.abs(f1), Math.abs(g1));
                }
                r = Math.sqrt((f1 * f1) + (g1 * g1));
                cs = f1 / r;
                sn = g1 / r;
                int i = count;
                for (int i2 = 1; i2 <= count; i2++) {
                    r *= 4.9947976805055876E145d;
                }
            } else if (scale <= 2.002083095183101E-146d) {
                int count2 = 0;
                while (scale <= 2.002083095183101E-146d) {
                    count2++;
                    f1 *= 4.9947976805055876E145d;
                    g1 *= 4.9947976805055876E145d;
                    scale = max(Math.abs(f1), Math.abs(g1));
                }
                double r2 = Math.sqrt((f1 * f1) + (g1 * g1));
                cs = f1 / r2;
                sn = g1 / r2;
                int i3 = count2;
                for (int i4 = 1; i4 <= count2; i4++) {
                    r2 = r * 2.002083095183101E-146d;
                }
            } else {
                r = Math.sqrt((f1 * f1) + (g1 * g1));
                cs = f1 / r;
                sn = g1 / r;
            }
            if (Math.abs(f) > Math.abs(g) && cs < Utils.DOUBLE_EPSILON) {
                cs = -cs;
                sn = -sn;
                r = -r;
            }
        }
        sin[index] = sn;
        cos[index] = cs;
        return r;
    }

    static void print_mat(double[] mat) {
        for (int i = 0; i < 3; i++) {
            System.out.println(mat[(i * 3) + 0] + " " + mat[(i * 3) + 1] + " " + mat[(i * 3) + 2] + "\n");
        }
    }

    static void print_det(double[] mat) {
        System.out.println("det= " + (((((((mat[0] * mat[4]) * mat[8]) + ((mat[1] * mat[5]) * mat[6])) + ((mat[2] * mat[3]) * mat[7])) - ((mat[2] * mat[4]) * mat[6])) - ((mat[0] * mat[5]) * mat[7])) - ((mat[1] * mat[3]) * mat[8])));
    }

    static void mat_mul(double[] m1, double[] m2, double[] m3) {
        double[] tmp = {(m1[0] * m2[0]) + (m1[1] * m2[3]) + (m1[2] * m2[6]), (m1[0] * m2[1]) + (m1[1] * m2[4]) + (m1[2] * m2[7]), (m1[0] * m2[2]) + (m1[1] * m2[5]) + (m1[2] * m2[8]), (m1[3] * m2[0]) + (m1[4] * m2[3]) + (m1[5] * m2[6]), (m1[3] * m2[1]) + (m1[4] * m2[4]) + (m1[5] * m2[7]), (m1[3] * m2[2]) + (m1[4] * m2[5]) + (m1[5] * m2[8]), (m1[6] * m2[0]) + (m1[7] * m2[3]) + (m1[8] * m2[6]), (m1[6] * m2[1]) + (m1[7] * m2[4]) + (m1[8] * m2[7]), (m1[6] * m2[2]) + (m1[7] * m2[5]) + (m1[8] * m2[8])};
        for (int i = 0; i < 9; i++) {
            m3[i] = tmp[i];
        }
    }

    static void transpose_mat(double[] in, double[] out) {
        out[0] = in[0];
        out[1] = in[3];
        out[2] = in[6];
        out[3] = in[1];
        out[4] = in[4];
        out[5] = in[7];
        out[6] = in[2];
        out[7] = in[5];
        out[8] = in[8];
    }

    static double max3(double[] values) {
        if (values[0] > values[1]) {
            if (values[0] > values[2]) {
                return values[0];
            }
            return values[2];
        } else if (values[1] > values[2]) {
            return values[1];
        } else {
            return values[2];
        }
    }

    private static final boolean almostEqual(double a, double b) {
        double max;
        if (a == b) {
            return true;
        }
        double diff = Math.abs(a - b);
        double absA = Math.abs(a);
        double absB = Math.abs(b);
        if (absA >= absB) {
            max = absA;
        } else {
            max = absB;
        }
        if (diff >= 1.0E-6d && diff / max >= 1.0E-4d) {
            return false;
        }
        return true;
    }

    public Object clone() {
        try {
            return (Matrix3d) super.clone();
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
}
