package javax.vecmath;

import com.github.mikephil.charting.utils.Utils;
import java.io.Serializable;

public class Matrix3f implements Serializable, Cloneable {
    private static final double EPS = 1.0E-8d;
    static final long serialVersionUID = 329697160112089834L;
    public float m00;
    public float m01;
    public float m02;
    public float m10;
    public float m11;
    public float m12;
    public float m20;
    public float m21;
    public float m22;

    public Matrix3f(float m002, float m012, float m022, float m102, float m112, float m122, float m202, float m212, float m222) {
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

    public Matrix3f(float[] v) {
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

    public Matrix3f(Matrix3d m1) {
        this.m00 = (float) m1.m00;
        this.m01 = (float) m1.m01;
        this.m02 = (float) m1.m02;
        this.m10 = (float) m1.m10;
        this.m11 = (float) m1.m11;
        this.m12 = (float) m1.m12;
        this.m20 = (float) m1.m20;
        this.m21 = (float) m1.m21;
        this.m22 = (float) m1.m22;
    }

    public Matrix3f(Matrix3f m1) {
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

    public Matrix3f() {
        this.m00 = 0.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 0.0f;
        this.m12 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 0.0f;
    }

    public String toString() {
        return this.m00 + ", " + this.m01 + ", " + this.m02 + "\n" + this.m10 + ", " + this.m11 + ", " + this.m12 + "\n" + this.m20 + ", " + this.m21 + ", " + this.m22 + "\n";
    }

    public final void setIdentity() {
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 1.0f;
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
                    default:
                        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f0"));
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
                        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f0"));
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
                        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f0"));
                }
            default:
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f0"));
        }
    }

    public final void getRow(int row, Vector3f v) {
        if (row == 0) {
            v.f158x = this.m00;
            v.f159y = this.m01;
            v.f160z = this.m02;
        } else if (row == 1) {
            v.f158x = this.m10;
            v.f159y = this.m11;
            v.f160z = this.m12;
        } else if (row == 2) {
            v.f158x = this.m20;
            v.f159y = this.m21;
            v.f160z = this.m22;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f1"));
        }
    }

    public final void getRow(int row, float[] v) {
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
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f1"));
        }
    }

    public final void getColumn(int column, Vector3f v) {
        if (column == 0) {
            v.f158x = this.m00;
            v.f159y = this.m10;
            v.f160z = this.m20;
        } else if (column == 1) {
            v.f158x = this.m01;
            v.f159y = this.m11;
            v.f160z = this.m21;
        } else if (column == 2) {
            v.f158x = this.m02;
            v.f159y = this.m12;
            v.f160z = this.m22;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f3"));
        }
    }

    public final void getColumn(int column, float[] v) {
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
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f3"));
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
        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f5"));
    }

    public final void setRow(int row, float x, float y, float z) {
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
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f6"));
        }
    }

    public final void setRow(int row, Vector3f v) {
        switch (row) {
            case 0:
                this.m00 = v.f158x;
                this.m01 = v.f159y;
                this.m02 = v.f160z;
                return;
            case 1:
                this.m10 = v.f158x;
                this.m11 = v.f159y;
                this.m12 = v.f160z;
                return;
            case 2:
                this.m20 = v.f158x;
                this.m21 = v.f159y;
                this.m22 = v.f160z;
                return;
            default:
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f6"));
        }
    }

    public final void setRow(int row, float[] v) {
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
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f6"));
        }
    }

    public final void setColumn(int column, float x, float y, float z) {
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
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f9"));
        }
    }

    public final void setColumn(int column, Vector3f v) {
        switch (column) {
            case 0:
                this.m00 = v.f158x;
                this.m10 = v.f159y;
                this.m20 = v.f160z;
                return;
            case 1:
                this.m01 = v.f158x;
                this.m11 = v.f159y;
                this.m21 = v.f160z;
                return;
            case 2:
                this.m02 = v.f158x;
                this.m12 = v.f159y;
                this.m22 = v.f160z;
                return;
            default:
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f9"));
        }
    }

    public final void setColumn(int column, float[] v) {
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
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f9"));
        }
    }

    public final float getScale() {
        double[] tmp_scale = new double[3];
        getScaleRotate(tmp_scale, new double[9]);
        return (float) Matrix3d.max3(tmp_scale);
    }

    public final void add(float scalar) {
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

    public final void add(float scalar, Matrix3f m1) {
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

    public final void add(Matrix3f m1, Matrix3f m2) {
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

    public final void add(Matrix3f m1) {
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

    public final void sub(Matrix3f m1, Matrix3f m2) {
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

    public final void sub(Matrix3f m1) {
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
        float temp = this.m10;
        this.m10 = this.m01;
        this.m01 = temp;
        float temp2 = this.m20;
        this.m20 = this.m02;
        this.m02 = temp2;
        float temp3 = this.m21;
        this.m21 = this.m12;
        this.m12 = temp3;
    }

    public final void transpose(Matrix3f m1) {
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
            return;
        }
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
        this.m00 = (float) ((t * ax * ax) + cosTheta);
        this.m01 = (float) ((t * xy) - (sinTheta * az));
        this.m02 = (float) ((t * xz) + (sinTheta * ay));
        this.m10 = (float) ((t * xy) + (sinTheta * az));
        this.m11 = (float) ((t * ay * ay) + cosTheta);
        this.m12 = (float) ((t * yz) - (sinTheta * ax));
        this.m20 = (float) ((t * xz) - (sinTheta * ay));
        this.m21 = (float) ((t * yz) + (sinTheta * ax));
        this.m22 = (float) ((t * az * az) + cosTheta);
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
    }

    public final void set(float[] m) {
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

    public final void set(Matrix3f m1) {
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

    public final void set(Matrix3d m1) {
        this.m00 = (float) m1.m00;
        this.m01 = (float) m1.m01;
        this.m02 = (float) m1.m02;
        this.m10 = (float) m1.m10;
        this.m11 = (float) m1.m11;
        this.m12 = (float) m1.m12;
        this.m20 = (float) m1.m20;
        this.m21 = (float) m1.m21;
        this.m22 = (float) m1.m22;
    }

    public final void invert(Matrix3f m1) {
        invertGeneral(m1);
    }

    public final void invert() {
        invertGeneral(this);
    }

    private final void invertGeneral(Matrix3f m1) {
        double[] result = new double[9];
        int[] row_perm = new int[3];
        double[] temp = {(double) m1.m00, (double) m1.m01, (double) m1.m02, (double) m1.m10, (double) m1.m11, (double) m1.m12, (double) m1.m20, (double) m1.m21, (double) m1.m22};
        if (!luDecomposition(temp, row_perm)) {
            throw new SingularMatrixException(VecMathI18N.getString("Matrix3f12"));
        }
        for (int i = 0; i < 9; i++) {
            result[i] = 0.0d;
        }
        result[0] = 1.0d;
        result[4] = 1.0d;
        result[8] = 1.0d;
        luBacksubstitution(temp, row_perm, result);
        this.m00 = (float) result[0];
        this.m01 = (float) result[1];
        this.m02 = (float) result[2];
        this.m10 = (float) result[3];
        this.m11 = (float) result[4];
        this.m12 = (float) result[5];
        this.m20 = (float) result[6];
        this.m21 = (float) result[7];
        this.m22 = (float) result[8];
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
                        throw new RuntimeException(VecMathI18N.getString("Matrix3f13"));
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

    public final float determinant() {
        return (this.m00 * ((this.m11 * this.m22) - (this.m12 * this.m21))) + (this.m01 * ((this.m12 * this.m20) - (this.m10 * this.m22))) + (this.m02 * ((this.m10 * this.m21) - (this.m11 * this.m20)));
    }

    public final void set(float scale) {
        this.m00 = scale;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = scale;
        this.m12 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = scale;
    }

    public final void rotX(float angle) {
        float sinAngle = (float) Math.sin((double) angle);
        float cosAngle = (float) Math.cos((double) angle);
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = cosAngle;
        this.m12 = -sinAngle;
        this.m20 = 0.0f;
        this.m21 = sinAngle;
        this.m22 = cosAngle;
    }

    public final void rotY(float angle) {
        float sinAngle = (float) Math.sin((double) angle);
        float cosAngle = (float) Math.cos((double) angle);
        this.m00 = cosAngle;
        this.m01 = 0.0f;
        this.m02 = sinAngle;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        this.m20 = -sinAngle;
        this.m21 = 0.0f;
        this.m22 = cosAngle;
    }

    public final void rotZ(float angle) {
        float sinAngle = (float) Math.sin((double) angle);
        float cosAngle = (float) Math.cos((double) angle);
        this.m00 = cosAngle;
        this.m01 = -sinAngle;
        this.m02 = 0.0f;
        this.m10 = sinAngle;
        this.m11 = cosAngle;
        this.m12 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 1.0f;
    }

    public final void mul(float scalar) {
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

    public final void mul(float scalar, Matrix3f m1) {
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

    public final void mul(Matrix3f m1) {
        float m002 = (this.m00 * m1.m00) + (this.m01 * m1.m10) + (this.m02 * m1.m20);
        float m012 = (this.m00 * m1.m01) + (this.m01 * m1.m11) + (this.m02 * m1.m21);
        float m022 = (this.m00 * m1.m02) + (this.m01 * m1.m12) + (this.m02 * m1.m22);
        float m102 = (this.m10 * m1.m00) + (this.m11 * m1.m10) + (this.m12 * m1.m20);
        float m112 = (this.m10 * m1.m01) + (this.m11 * m1.m11) + (this.m12 * m1.m21);
        float m122 = (this.m10 * m1.m02) + (this.m11 * m1.m12) + (this.m12 * m1.m22);
        float m202 = (this.m20 * m1.m00) + (this.m21 * m1.m10) + (this.m22 * m1.m20);
        float m212 = (this.m20 * m1.m01) + (this.m21 * m1.m11) + (this.m22 * m1.m21);
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

    public final void mul(Matrix3f m1, Matrix3f m2) {
        if (this == m1 || this == m2) {
            float m002 = (m1.m00 * m2.m00) + (m1.m01 * m2.m10) + (m1.m02 * m2.m20);
            float m012 = (m1.m00 * m2.m01) + (m1.m01 * m2.m11) + (m1.m02 * m2.m21);
            float m022 = (m1.m00 * m2.m02) + (m1.m01 * m2.m12) + (m1.m02 * m2.m22);
            float m102 = (m1.m10 * m2.m00) + (m1.m11 * m2.m10) + (m1.m12 * m2.m20);
            float m112 = (m1.m10 * m2.m01) + (m1.m11 * m2.m11) + (m1.m12 * m2.m21);
            float m122 = (m1.m10 * m2.m02) + (m1.m11 * m2.m12) + (m1.m12 * m2.m22);
            float m202 = (m1.m20 * m2.m00) + (m1.m21 * m2.m10) + (m1.m22 * m2.m20);
            float m212 = (m1.m20 * m2.m01) + (m1.m21 * m2.m11) + (m1.m22 * m2.m21);
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

    public final void mulNormalize(Matrix3f m1) {
        double[] tmp_rot = new double[9];
        Matrix3d.compute_svd(new double[]{(double) ((this.m00 * m1.m00) + (this.m01 * m1.m10) + (this.m02 * m1.m20)), (double) ((this.m00 * m1.m01) + (this.m01 * m1.m11) + (this.m02 * m1.m21)), (double) ((this.m00 * m1.m02) + (this.m01 * m1.m12) + (this.m02 * m1.m22)), (double) ((this.m10 * m1.m00) + (this.m11 * m1.m10) + (this.m12 * m1.m20)), (double) ((this.m10 * m1.m01) + (this.m11 * m1.m11) + (this.m12 * m1.m21)), (double) ((this.m10 * m1.m02) + (this.m11 * m1.m12) + (this.m12 * m1.m22)), (double) ((this.m20 * m1.m00) + (this.m21 * m1.m10) + (this.m22 * m1.m20)), (double) ((this.m20 * m1.m01) + (this.m21 * m1.m11) + (this.m22 * m1.m21)), (double) ((this.m20 * m1.m02) + (this.m21 * m1.m12) + (this.m22 * m1.m22))}, new double[3], tmp_rot);
        this.m00 = (float) tmp_rot[0];
        this.m01 = (float) tmp_rot[1];
        this.m02 = (float) tmp_rot[2];
        this.m10 = (float) tmp_rot[3];
        this.m11 = (float) tmp_rot[4];
        this.m12 = (float) tmp_rot[5];
        this.m20 = (float) tmp_rot[6];
        this.m21 = (float) tmp_rot[7];
        this.m22 = (float) tmp_rot[8];
    }

    public final void mulNormalize(Matrix3f m1, Matrix3f m2) {
        double[] tmp_rot = new double[9];
        Matrix3d.compute_svd(new double[]{(double) ((m1.m00 * m2.m00) + (m1.m01 * m2.m10) + (m1.m02 * m2.m20)), (double) ((m1.m00 * m2.m01) + (m1.m01 * m2.m11) + (m1.m02 * m2.m21)), (double) ((m1.m00 * m2.m02) + (m1.m01 * m2.m12) + (m1.m02 * m2.m22)), (double) ((m1.m10 * m2.m00) + (m1.m11 * m2.m10) + (m1.m12 * m2.m20)), (double) ((m1.m10 * m2.m01) + (m1.m11 * m2.m11) + (m1.m12 * m2.m21)), (double) ((m1.m10 * m2.m02) + (m1.m11 * m2.m12) + (m1.m12 * m2.m22)), (double) ((m1.m20 * m2.m00) + (m1.m21 * m2.m10) + (m1.m22 * m2.m20)), (double) ((m1.m20 * m2.m01) + (m1.m21 * m2.m11) + (m1.m22 * m2.m21)), (double) ((m1.m20 * m2.m02) + (m1.m21 * m2.m12) + (m1.m22 * m2.m22))}, new double[3], tmp_rot);
        this.m00 = (float) tmp_rot[0];
        this.m01 = (float) tmp_rot[1];
        this.m02 = (float) tmp_rot[2];
        this.m10 = (float) tmp_rot[3];
        this.m11 = (float) tmp_rot[4];
        this.m12 = (float) tmp_rot[5];
        this.m20 = (float) tmp_rot[6];
        this.m21 = (float) tmp_rot[7];
        this.m22 = (float) tmp_rot[8];
    }

    public final void mulTransposeBoth(Matrix3f m1, Matrix3f m2) {
        if (this == m1 || this == m2) {
            float m002 = (m1.m00 * m2.m00) + (m1.m10 * m2.m01) + (m1.m20 * m2.m02);
            float m012 = (m1.m00 * m2.m10) + (m1.m10 * m2.m11) + (m1.m20 * m2.m12);
            float m022 = (m1.m00 * m2.m20) + (m1.m10 * m2.m21) + (m1.m20 * m2.m22);
            float m102 = (m1.m01 * m2.m00) + (m1.m11 * m2.m01) + (m1.m21 * m2.m02);
            float m112 = (m1.m01 * m2.m10) + (m1.m11 * m2.m11) + (m1.m21 * m2.m12);
            float m122 = (m1.m01 * m2.m20) + (m1.m11 * m2.m21) + (m1.m21 * m2.m22);
            float m202 = (m1.m02 * m2.m00) + (m1.m12 * m2.m01) + (m1.m22 * m2.m02);
            float m212 = (m1.m02 * m2.m10) + (m1.m12 * m2.m11) + (m1.m22 * m2.m12);
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

    public final void mulTransposeRight(Matrix3f m1, Matrix3f m2) {
        if (this == m1 || this == m2) {
            float m002 = (m1.m00 * m2.m00) + (m1.m01 * m2.m01) + (m1.m02 * m2.m02);
            float m012 = (m1.m00 * m2.m10) + (m1.m01 * m2.m11) + (m1.m02 * m2.m12);
            float m022 = (m1.m00 * m2.m20) + (m1.m01 * m2.m21) + (m1.m02 * m2.m22);
            float m102 = (m1.m10 * m2.m00) + (m1.m11 * m2.m01) + (m1.m12 * m2.m02);
            float m112 = (m1.m10 * m2.m10) + (m1.m11 * m2.m11) + (m1.m12 * m2.m12);
            float m122 = (m1.m10 * m2.m20) + (m1.m11 * m2.m21) + (m1.m12 * m2.m22);
            float m202 = (m1.m20 * m2.m00) + (m1.m21 * m2.m01) + (m1.m22 * m2.m02);
            float m212 = (m1.m20 * m2.m10) + (m1.m21 * m2.m11) + (m1.m22 * m2.m12);
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

    public final void mulTransposeLeft(Matrix3f m1, Matrix3f m2) {
        if (this == m1 || this == m2) {
            float m002 = (m1.m00 * m2.m00) + (m1.m10 * m2.m10) + (m1.m20 * m2.m20);
            float m012 = (m1.m00 * m2.m01) + (m1.m10 * m2.m11) + (m1.m20 * m2.m21);
            float m022 = (m1.m00 * m2.m02) + (m1.m10 * m2.m12) + (m1.m20 * m2.m22);
            float m102 = (m1.m01 * m2.m00) + (m1.m11 * m2.m10) + (m1.m21 * m2.m20);
            float m112 = (m1.m01 * m2.m01) + (m1.m11 * m2.m11) + (m1.m21 * m2.m21);
            float m122 = (m1.m01 * m2.m02) + (m1.m11 * m2.m12) + (m1.m21 * m2.m22);
            float m202 = (m1.m02 * m2.m00) + (m1.m12 * m2.m10) + (m1.m22 * m2.m20);
            float m212 = (m1.m02 * m2.m01) + (m1.m12 * m2.m11) + (m1.m22 * m2.m21);
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
        this.m00 = (float) tmp_rot[0];
        this.m01 = (float) tmp_rot[1];
        this.m02 = (float) tmp_rot[2];
        this.m10 = (float) tmp_rot[3];
        this.m11 = (float) tmp_rot[4];
        this.m12 = (float) tmp_rot[5];
        this.m20 = (float) tmp_rot[6];
        this.m21 = (float) tmp_rot[7];
        this.m22 = (float) tmp_rot[8];
    }

    public final void normalize(Matrix3f m1) {
        double[] tmp_rot = new double[9];
        Matrix3d.compute_svd(new double[]{(double) m1.m00, (double) m1.m01, (double) m1.m02, (double) m1.m10, (double) m1.m11, (double) m1.m12, (double) m1.m20, (double) m1.m21, (double) m1.m22}, new double[3], tmp_rot);
        this.m00 = (float) tmp_rot[0];
        this.m01 = (float) tmp_rot[1];
        this.m02 = (float) tmp_rot[2];
        this.m10 = (float) tmp_rot[3];
        this.m11 = (float) tmp_rot[4];
        this.m12 = (float) tmp_rot[5];
        this.m20 = (float) tmp_rot[6];
        this.m21 = (float) tmp_rot[7];
        this.m22 = (float) tmp_rot[8];
    }

    public final void normalizeCP() {
        float mag = 1.0f / ((float) Math.sqrt((double) (((this.m00 * this.m00) + (this.m10 * this.m10)) + (this.m20 * this.m20))));
        this.m00 *= mag;
        this.m10 *= mag;
        this.m20 *= mag;
        float mag2 = 1.0f / ((float) Math.sqrt((double) (((this.m01 * this.m01) + (this.m11 * this.m11)) + (this.m21 * this.m21))));
        this.m01 *= mag2;
        this.m11 *= mag2;
        this.m21 *= mag2;
        this.m02 = (this.m10 * this.m21) - (this.m11 * this.m20);
        this.m12 = (this.m01 * this.m20) - (this.m00 * this.m21);
        this.m22 = (this.m00 * this.m11) - (this.m01 * this.m10);
    }

    public final void normalizeCP(Matrix3f m1) {
        float mag = 1.0f / ((float) Math.sqrt((double) (((m1.m00 * m1.m00) + (m1.m10 * m1.m10)) + (m1.m20 * m1.m20))));
        this.m00 = m1.m00 * mag;
        this.m10 = m1.m10 * mag;
        this.m20 = m1.m20 * mag;
        float mag2 = 1.0f / ((float) Math.sqrt((double) (((m1.m01 * m1.m01) + (m1.m11 * m1.m11)) + (m1.m21 * m1.m21))));
        this.m01 = m1.m01 * mag2;
        this.m11 = m1.m11 * mag2;
        this.m21 = m1.m21 * mag2;
        this.m02 = (this.m10 * this.m21) - (this.m11 * this.m20);
        this.m12 = (this.m01 * this.m20) - (this.m00 * this.m21);
        this.m22 = (this.m00 * this.m11) - (this.m01 * this.m10);
    }

    public boolean equals(Matrix3f m1) {
        try {
            return this.m00 == m1.m00 && this.m01 == m1.m01 && this.m02 == m1.m02 && this.m10 == m1.m10 && this.m11 == m1.m11 && this.m12 == m1.m12 && this.m20 == m1.m20 && this.m21 == m1.m21 && this.m22 == m1.m22;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean equals(Object o1) {
        try {
            Matrix3f m2 = (Matrix3f) o1;
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

    public boolean epsilonEquals(Matrix3f m1, float epsilon) {
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
        if (Math.abs(this.m10 - m1.m10) > epsilon) {
            status = false;
        }
        if (Math.abs(this.m11 - m1.m11) > epsilon) {
            status = false;
        }
        if (Math.abs(this.m12 - m1.m12) > epsilon) {
            status = false;
        }
        if (Math.abs(this.m20 - m1.m20) > epsilon) {
            status = false;
        }
        if (Math.abs(this.m21 - m1.m21) > epsilon) {
            status = false;
        }
        if (Math.abs(this.m22 - m1.m22) > epsilon) {
            return false;
        }
        return status;
    }

    public int hashCode() {
        long bits = (31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * 1) + ((long) VecMathUtil.floatToIntBits(this.m00)))) + ((long) VecMathUtil.floatToIntBits(this.m01)))) + ((long) VecMathUtil.floatToIntBits(this.m02)))) + ((long) VecMathUtil.floatToIntBits(this.m10)))) + ((long) VecMathUtil.floatToIntBits(this.m11)))) + ((long) VecMathUtil.floatToIntBits(this.m12)))) + ((long) VecMathUtil.floatToIntBits(this.m20)))) + ((long) VecMathUtil.floatToIntBits(this.m21)))) + ((long) VecMathUtil.floatToIntBits(this.m22));
        return (int) ((bits >> 32) ^ bits);
    }

    public final void setZero() {
        this.m00 = 0.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 0.0f;
        this.m12 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 0.0f;
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

    public final void negate(Matrix3f m1) {
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

    public final void transform(Tuple3f t) {
        t.set((this.m00 * t.f158x) + (this.m01 * t.f159y) + (this.m02 * t.f160z), (this.m10 * t.f158x) + (this.m11 * t.f159y) + (this.m12 * t.f160z), (this.m20 * t.f158x) + (this.m21 * t.f159y) + (this.m22 * t.f160z));
    }

    public final void transform(Tuple3f t, Tuple3f result) {
        float x = (this.m00 * t.f158x) + (this.m01 * t.f159y) + (this.m02 * t.f160z);
        float y = (this.m10 * t.f158x) + (this.m11 * t.f159y) + (this.m12 * t.f160z);
        result.f160z = (this.m20 * t.f158x) + (this.m21 * t.f159y) + (this.m22 * t.f160z);
        result.f158x = x;
        result.f159y = y;
    }

    /* access modifiers changed from: package-private */
    public void getScaleRotate(double[] scales, double[] rot) {
        Matrix3d.compute_svd(new double[]{(double) this.m00, (double) this.m01, (double) this.m02, (double) this.m10, (double) this.m11, (double) this.m12, (double) this.m20, (double) this.m21, (double) this.m22}, scales, rot);
    }

    public Object clone() {
        try {
            return (Matrix3f) super.clone();
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
}
