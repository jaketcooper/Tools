package javax.vecmath;

import com.github.mikephil.charting.utils.Utils;
import java.io.Serializable;

public class GVector implements Serializable, Cloneable {
    static final long serialVersionUID = 1398850036893875112L;
    private int length;
    double[] values;

    public GVector(int length2) {
        this.length = length2;
        this.values = new double[length2];
        for (int i = 0; i < length2; i++) {
            this.values[i] = 0.0d;
        }
    }

    public GVector(double[] vector) {
        this.length = vector.length;
        this.values = new double[vector.length];
        for (int i = 0; i < this.length; i++) {
            this.values[i] = vector[i];
        }
    }

    public GVector(GVector vector) {
        this.values = new double[vector.length];
        this.length = vector.length;
        for (int i = 0; i < this.length; i++) {
            this.values[i] = vector.values[i];
        }
    }

    public GVector(Tuple2f tuple) {
        this.values = new double[2];
        this.values[0] = (double) tuple.f148x;
        this.values[1] = (double) tuple.f149y;
        this.length = 2;
    }

    public GVector(Tuple3f tuple) {
        this.values = new double[3];
        this.values[0] = (double) tuple.f158x;
        this.values[1] = (double) tuple.f159y;
        this.values[2] = (double) tuple.f160z;
        this.length = 3;
    }

    public GVector(Tuple3d tuple) {
        this.values = new double[3];
        this.values[0] = tuple.f155x;
        this.values[1] = tuple.f156y;
        this.values[2] = tuple.f157z;
        this.length = 3;
    }

    public GVector(Tuple4f tuple) {
        this.values = new double[4];
        this.values[0] = (double) tuple.f173x;
        this.values[1] = (double) tuple.f174y;
        this.values[2] = (double) tuple.f175z;
        this.values[3] = (double) tuple.f172w;
        this.length = 4;
    }

    public GVector(Tuple4d tuple) {
        this.values = new double[4];
        this.values[0] = tuple.f169x;
        this.values[1] = tuple.f170y;
        this.values[2] = tuple.f171z;
        this.values[3] = tuple.f168w;
        this.length = 4;
    }

    public GVector(double[] vector, int length2) {
        this.length = length2;
        this.values = new double[length2];
        for (int i = 0; i < length2; i++) {
            this.values[i] = vector[i];
        }
    }

    public final double norm() {
        double sq = Utils.DOUBLE_EPSILON;
        for (int i = 0; i < this.length; i++) {
            sq += this.values[i] * this.values[i];
        }
        return Math.sqrt(sq);
    }

    public final double normSquared() {
        double sq = Utils.DOUBLE_EPSILON;
        for (int i = 0; i < this.length; i++) {
            sq += this.values[i] * this.values[i];
        }
        return sq;
    }

    public final void normalize(GVector v1) {
        double sq = Utils.DOUBLE_EPSILON;
        if (this.length != v1.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector0"));
        }
        for (int i = 0; i < this.length; i++) {
            sq += v1.values[i] * v1.values[i];
        }
        double invMag = 1.0d / Math.sqrt(sq);
        for (int i2 = 0; i2 < this.length; i2++) {
            this.values[i2] = v1.values[i2] * invMag;
        }
    }

    public final void normalize() {
        double sq = Utils.DOUBLE_EPSILON;
        for (int i = 0; i < this.length; i++) {
            sq += this.values[i] * this.values[i];
        }
        double invMag = 1.0d / Math.sqrt(sq);
        for (int i2 = 0; i2 < this.length; i2++) {
            this.values[i2] = this.values[i2] * invMag;
        }
    }

    public final void scale(double s, GVector v1) {
        if (this.length != v1.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector1"));
        }
        for (int i = 0; i < this.length; i++) {
            this.values[i] = v1.values[i] * s;
        }
    }

    public final void scale(double s) {
        for (int i = 0; i < this.length; i++) {
            this.values[i] = this.values[i] * s;
        }
    }

    public final void scaleAdd(double s, GVector v1, GVector v2) {
        if (v2.length != v1.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector2"));
        } else if (this.length != v1.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector3"));
        } else {
            for (int i = 0; i < this.length; i++) {
                this.values[i] = (v1.values[i] * s) + v2.values[i];
            }
        }
    }

    public final void add(GVector vector) {
        if (this.length != vector.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector4"));
        }
        for (int i = 0; i < this.length; i++) {
            double[] dArr = this.values;
            dArr[i] = dArr[i] + vector.values[i];
        }
    }

    public final void add(GVector vector1, GVector vector2) {
        if (vector1.length != vector2.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector5"));
        } else if (this.length != vector1.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector6"));
        } else {
            for (int i = 0; i < this.length; i++) {
                this.values[i] = vector1.values[i] + vector2.values[i];
            }
        }
    }

    public final void sub(GVector vector) {
        if (this.length != vector.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector7"));
        }
        for (int i = 0; i < this.length; i++) {
            double[] dArr = this.values;
            dArr[i] = dArr[i] - vector.values[i];
        }
    }

    public final void sub(GVector vector1, GVector vector2) {
        if (vector1.length != vector2.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector8"));
        } else if (this.length != vector1.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector9"));
        } else {
            for (int i = 0; i < this.length; i++) {
                this.values[i] = vector1.values[i] - vector2.values[i];
            }
        }
    }

    public final void mul(GMatrix m1, GVector v1) {
        double[] v;
        if (m1.getNumCol() != v1.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector10"));
        } else if (this.length != m1.getNumRow()) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector11"));
        } else {
            if (v1 != this) {
                v = v1.values;
            } else {
                v = (double[]) this.values.clone();
            }
            for (int j = this.length - 1; j >= 0; j--) {
                this.values[j] = 0.0d;
                for (int i = v1.length - 1; i >= 0; i--) {
                    double[] dArr = this.values;
                    dArr[j] = dArr[j] + (m1.values[j][i] * v[i]);
                }
            }
        }
    }

    public final void mul(GVector v1, GMatrix m1) {
        double[] v;
        if (m1.getNumRow() != v1.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector12"));
        } else if (this.length != m1.getNumCol()) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector13"));
        } else {
            if (v1 != this) {
                v = v1.values;
            } else {
                v = (double[]) this.values.clone();
            }
            for (int j = this.length - 1; j >= 0; j--) {
                this.values[j] = 0.0d;
                for (int i = v1.length - 1; i >= 0; i--) {
                    double[] dArr = this.values;
                    dArr[j] = dArr[j] + (m1.values[i][j] * v[i]);
                }
            }
        }
    }

    public final void negate() {
        for (int i = this.length - 1; i >= 0; i--) {
            double[] dArr = this.values;
            dArr[i] = dArr[i] * -1.0d;
        }
    }

    public final void zero() {
        for (int i = 0; i < this.length; i++) {
            this.values[i] = 0.0d;
        }
    }

    public final void setSize(int length2) {
        int max;
        double[] tmp = new double[length2];
        if (this.length < length2) {
            max = this.length;
        } else {
            max = length2;
        }
        for (int i = 0; i < max; i++) {
            tmp[i] = this.values[i];
        }
        this.length = length2;
        this.values = tmp;
    }

    public final void set(double[] vector) {
        for (int i = this.length - 1; i >= 0; i--) {
            this.values[i] = vector[i];
        }
    }

    public final void set(GVector vector) {
        if (this.length < vector.length) {
            this.length = vector.length;
            this.values = new double[this.length];
            for (int i = 0; i < this.length; i++) {
                this.values[i] = vector.values[i];
            }
            return;
        }
        for (int i2 = 0; i2 < vector.length; i2++) {
            this.values[i2] = vector.values[i2];
        }
        for (int i3 = vector.length; i3 < this.length; i3++) {
            this.values[i3] = 0.0d;
        }
    }

    public final void set(Tuple2f tuple) {
        if (this.length < 2) {
            this.length = 2;
            this.values = new double[2];
        }
        this.values[0] = (double) tuple.f148x;
        this.values[1] = (double) tuple.f149y;
        for (int i = 2; i < this.length; i++) {
            this.values[i] = 0.0d;
        }
    }

    public final void set(Tuple3f tuple) {
        if (this.length < 3) {
            this.length = 3;
            this.values = new double[3];
        }
        this.values[0] = (double) tuple.f158x;
        this.values[1] = (double) tuple.f159y;
        this.values[2] = (double) tuple.f160z;
        for (int i = 3; i < this.length; i++) {
            this.values[i] = 0.0d;
        }
    }

    public final void set(Tuple3d tuple) {
        if (this.length < 3) {
            this.length = 3;
            this.values = new double[3];
        }
        this.values[0] = tuple.f155x;
        this.values[1] = tuple.f156y;
        this.values[2] = tuple.f157z;
        for (int i = 3; i < this.length; i++) {
            this.values[i] = 0.0d;
        }
    }

    public final void set(Tuple4f tuple) {
        if (this.length < 4) {
            this.length = 4;
            this.values = new double[4];
        }
        this.values[0] = (double) tuple.f173x;
        this.values[1] = (double) tuple.f174y;
        this.values[2] = (double) tuple.f175z;
        this.values[3] = (double) tuple.f172w;
        for (int i = 4; i < this.length; i++) {
            this.values[i] = 0.0d;
        }
    }

    public final void set(Tuple4d tuple) {
        if (this.length < 4) {
            this.length = 4;
            this.values = new double[4];
        }
        this.values[0] = tuple.f169x;
        this.values[1] = tuple.f170y;
        this.values[2] = tuple.f171z;
        this.values[3] = tuple.f168w;
        for (int i = 4; i < this.length; i++) {
            this.values[i] = 0.0d;
        }
    }

    public final int getSize() {
        return this.values.length;
    }

    public final double getElement(int index) {
        return this.values[index];
    }

    public final void setElement(int index, double value) {
        this.values[index] = value;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer(this.length * 8);
        for (int i = 0; i < this.length; i++) {
            buffer.append(this.values[i]).append(" ");
        }
        return buffer.toString();
    }

    public int hashCode() {
        long bits = 1;
        for (int i = 0; i < this.length; i++) {
            bits = (31 * bits) + VecMathUtil.doubleToLongBits(this.values[i]);
        }
        return (int) ((bits >> 32) ^ bits);
    }

    public boolean equals(GVector vector1) {
        try {
            if (this.length != vector1.length) {
                return false;
            }
            for (int i = 0; i < this.length; i++) {
                if (this.values[i] != vector1.values[i]) {
                    return false;
                }
            }
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean equals(Object o1) {
        try {
            GVector v2 = (GVector) o1;
            if (this.length != v2.length) {
                return false;
            }
            for (int i = 0; i < this.length; i++) {
                if (this.values[i] != v2.values[i]) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        } catch (NullPointerException e2) {
            return false;
        }
    }

    public boolean epsilonEquals(GVector v1, double epsilon) {
        if (this.length != v1.length) {
            return false;
        }
        for (int i = 0; i < this.length; i++) {
            double diff = this.values[i] - v1.values[i];
            if (diff < Utils.DOUBLE_EPSILON) {
                diff = -diff;
            }
            if (diff > epsilon) {
                return false;
            }
        }
        return true;
    }

    public final double dot(GVector v1) {
        if (this.length != v1.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector14"));
        }
        double result = Utils.DOUBLE_EPSILON;
        for (int i = 0; i < this.length; i++) {
            result += this.values[i] * v1.values[i];
        }
        return result;
    }

    public final void SVDBackSolve(GMatrix U, GMatrix W, GMatrix V, GVector b) {
        if (U.nRow != b.getSize() || U.nRow != U.nCol || U.nRow != W.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector15"));
        } else if (W.nCol == this.values.length && W.nCol == V.nCol && W.nCol == V.nRow) {
            GMatrix tmp = new GMatrix(U.nRow, W.nCol);
            tmp.mul(U, V);
            tmp.mulTransposeRight(U, W);
            tmp.invert();
            mul(tmp, b);
        } else {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector23"));
        }
    }

    public final void LUDBackSolve(GMatrix LU, GVector b, GVector permutation) {
        int size = LU.nRow * LU.nCol;
        double[] temp = new double[size];
        double[] result = new double[size];
        int[] row_perm = new int[b.getSize()];
        if (LU.nRow != b.getSize()) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector16"));
        } else if (LU.nRow != permutation.getSize()) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector24"));
        } else if (LU.nRow != LU.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector25"));
        } else {
            for (int i = 0; i < LU.nRow; i++) {
                for (int j = 0; j < LU.nCol; j++) {
                    temp[(LU.nCol * i) + j] = LU.values[i][j];
                }
            }
            for (int i2 = 0; i2 < size; i2++) {
                result[i2] = 0.0d;
            }
            for (int i3 = 0; i3 < LU.nRow; i3++) {
                result[LU.nCol * i3] = b.values[i3];
            }
            for (int i4 = 0; i4 < LU.nCol; i4++) {
                row_perm[i4] = (int) permutation.values[i4];
            }
            GMatrix.luBacksubstitution(LU.nRow, temp, row_perm, result);
            for (int i5 = 0; i5 < LU.nRow; i5++) {
                this.values[i5] = result[LU.nCol * i5];
            }
        }
    }

    public final double angle(GVector v1) {
        return Math.acos(dot(v1) / (norm() * v1.norm()));
    }

    public final void interpolate(GVector v1, GVector v2, float alpha) {
        interpolate(v1, v2, (double) alpha);
    }

    public final void interpolate(GVector v1, float alpha) {
        interpolate(v1, (double) alpha);
    }

    public final void interpolate(GVector v1, GVector v2, double alpha) {
        if (v2.length != v1.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector20"));
        } else if (this.length != v1.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector21"));
        } else {
            for (int i = 0; i < this.length; i++) {
                this.values[i] = ((1.0d - alpha) * v1.values[i]) + (v2.values[i] * alpha);
            }
        }
    }

    public final void interpolate(GVector v1, double alpha) {
        if (v1.length != this.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector22"));
        }
        for (int i = 0; i < this.length; i++) {
            this.values[i] = ((1.0d - alpha) * this.values[i]) + (v1.values[i] * alpha);
        }
    }

    public Object clone() {
        try {
            GVector v1 = (GVector) super.clone();
            v1.values = new double[this.length];
            for (int i = 0; i < this.length; i++) {
                v1.values[i] = this.values[i];
            }
            return v1;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
}
