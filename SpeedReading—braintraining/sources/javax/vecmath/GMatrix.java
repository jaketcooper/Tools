package javax.vecmath;

import com.github.mikephil.charting.utils.Utils;
import java.io.Serializable;
import java.lang.reflect.Array;

public class GMatrix implements Serializable, Cloneable {
    private static final double EPS = 1.0E-10d;
    private static final boolean debug = false;
    static final long serialVersionUID = 2777097312029690941L;
    int nCol;
    int nRow;
    double[][] values;

    public GMatrix(int nRow2, int nCol2) {
        int l;
        this.values = (double[][]) Array.newInstance(Double.TYPE, new int[]{nRow2, nCol2});
        this.nRow = nRow2;
        this.nCol = nCol2;
        for (int i = 0; i < nRow2; i++) {
            for (int j = 0; j < nCol2; j++) {
                this.values[i][j] = 0.0d;
            }
        }
        if (nRow2 < nCol2) {
            l = nRow2;
        } else {
            l = nCol2;
        }
        for (int i2 = 0; i2 < l; i2++) {
            this.values[i2][i2] = 1.0d;
        }
    }

    public GMatrix(int nRow2, int nCol2, double[] matrix) {
        this.values = (double[][]) Array.newInstance(Double.TYPE, new int[]{nRow2, nCol2});
        this.nRow = nRow2;
        this.nCol = nCol2;
        for (int i = 0; i < nRow2; i++) {
            for (int j = 0; j < nCol2; j++) {
                this.values[i][j] = matrix[(i * nCol2) + j];
            }
        }
    }

    public GMatrix(GMatrix matrix) {
        this.nRow = matrix.nRow;
        this.nCol = matrix.nCol;
        this.values = (double[][]) Array.newInstance(Double.TYPE, new int[]{this.nRow, this.nCol});
        for (int i = 0; i < this.nRow; i++) {
            for (int j = 0; j < this.nCol; j++) {
                this.values[i][j] = matrix.values[i][j];
            }
        }
    }

    public final void mul(GMatrix m1) {
        if (this.nCol == m1.nRow && this.nCol == m1.nCol) {
            double[][] tmp = (double[][]) Array.newInstance(Double.TYPE, new int[]{this.nRow, this.nCol});
            for (int i = 0; i < this.nRow; i++) {
                for (int j = 0; j < this.nCol; j++) {
                    tmp[i][j] = 0.0d;
                    for (int k = 0; k < this.nCol; k++) {
                        double[] dArr = tmp[i];
                        dArr[j] = dArr[j] + (this.values[i][k] * m1.values[k][j]);
                    }
                }
            }
            this.values = tmp;
            return;
        }
        throw new MismatchedSizeException(VecMathI18N.getString("GMatrix0"));
    }

    public final void mul(GMatrix m1, GMatrix m2) {
        if (m1.nCol == m2.nRow && this.nRow == m1.nRow && this.nCol == m2.nCol) {
            double[][] tmp = (double[][]) Array.newInstance(Double.TYPE, new int[]{this.nRow, this.nCol});
            for (int i = 0; i < m1.nRow; i++) {
                for (int j = 0; j < m2.nCol; j++) {
                    tmp[i][j] = 0.0d;
                    for (int k = 0; k < m1.nCol; k++) {
                        double[] dArr = tmp[i];
                        dArr[j] = dArr[j] + (m1.values[i][k] * m2.values[k][j]);
                    }
                }
            }
            this.values = tmp;
            return;
        }
        throw new MismatchedSizeException(VecMathI18N.getString("GMatrix1"));
    }

    public final void mul(GVector v1, GVector v2) {
        if (this.nRow < v1.getSize()) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix2"));
        } else if (this.nCol < v2.getSize()) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix3"));
        } else {
            for (int i = 0; i < v1.getSize(); i++) {
                for (int j = 0; j < v2.getSize(); j++) {
                    this.values[i][j] = v1.values[i] * v2.values[j];
                }
            }
        }
    }

    public final void add(GMatrix m1) {
        if (this.nRow != m1.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix4"));
        } else if (this.nCol != m1.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix5"));
        } else {
            for (int i = 0; i < this.nRow; i++) {
                for (int j = 0; j < this.nCol; j++) {
                    this.values[i][j] = this.values[i][j] + m1.values[i][j];
                }
            }
        }
    }

    public final void add(GMatrix m1, GMatrix m2) {
        if (m2.nRow != m1.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix6"));
        } else if (m2.nCol != m1.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix7"));
        } else if (this.nCol == m1.nCol && this.nRow == m1.nRow) {
            for (int i = 0; i < this.nRow; i++) {
                for (int j = 0; j < this.nCol; j++) {
                    this.values[i][j] = m1.values[i][j] + m2.values[i][j];
                }
            }
        } else {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix8"));
        }
    }

    public final void sub(GMatrix m1) {
        if (this.nRow != m1.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix9"));
        } else if (this.nCol != m1.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix28"));
        } else {
            for (int i = 0; i < this.nRow; i++) {
                for (int j = 0; j < this.nCol; j++) {
                    this.values[i][j] = this.values[i][j] - m1.values[i][j];
                }
            }
        }
    }

    public final void sub(GMatrix m1, GMatrix m2) {
        if (m2.nRow != m1.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix10"));
        } else if (m2.nCol != m1.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix11"));
        } else if (this.nRow == m1.nRow && this.nCol == m1.nCol) {
            for (int i = 0; i < this.nRow; i++) {
                for (int j = 0; j < this.nCol; j++) {
                    this.values[i][j] = m1.values[i][j] - m2.values[i][j];
                }
            }
        } else {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix12"));
        }
    }

    public final void negate() {
        for (int i = 0; i < this.nRow; i++) {
            for (int j = 0; j < this.nCol; j++) {
                this.values[i][j] = -this.values[i][j];
            }
        }
    }

    public final void negate(GMatrix m1) {
        if (this.nRow == m1.nRow && this.nCol == m1.nCol) {
            for (int i = 0; i < this.nRow; i++) {
                for (int j = 0; j < this.nCol; j++) {
                    this.values[i][j] = -m1.values[i][j];
                }
            }
            return;
        }
        throw new MismatchedSizeException(VecMathI18N.getString("GMatrix13"));
    }

    public final void setIdentity() {
        int l;
        for (int i = 0; i < this.nRow; i++) {
            for (int j = 0; j < this.nCol; j++) {
                this.values[i][j] = 0.0d;
            }
        }
        if (this.nRow < this.nCol) {
            l = this.nRow;
        } else {
            l = this.nCol;
        }
        for (int i2 = 0; i2 < l; i2++) {
            this.values[i2][i2] = 1.0d;
        }
    }

    public final void setZero() {
        for (int i = 0; i < this.nRow; i++) {
            for (int j = 0; j < this.nCol; j++) {
                this.values[i][j] = 0.0d;
            }
        }
    }

    public final void identityMinus() {
        int l;
        for (int i = 0; i < this.nRow; i++) {
            for (int j = 0; j < this.nCol; j++) {
                this.values[i][j] = -this.values[i][j];
            }
        }
        if (this.nRow < this.nCol) {
            l = this.nRow;
        } else {
            l = this.nCol;
        }
        for (int i2 = 0; i2 < l; i2++) {
            double[] dArr = this.values[i2];
            dArr[i2] = dArr[i2] + 1.0d;
        }
    }

    public final void invert() {
        invertGeneral(this);
    }

    public final void invert(GMatrix m1) {
        invertGeneral(m1);
    }

    public final void copySubMatrix(int rowSource, int colSource, int numRow, int numCol, int rowDest, int colDest, GMatrix target) {
        if (this != target) {
            for (int i = 0; i < numRow; i++) {
                for (int j = 0; j < numCol; j++) {
                    target.values[rowDest + i][colDest + j] = this.values[rowSource + i][colSource + j];
                }
            }
            return;
        }
        double[][] tmp = (double[][]) Array.newInstance(Double.TYPE, new int[]{numRow, numCol});
        for (int i2 = 0; i2 < numRow; i2++) {
            for (int j2 = 0; j2 < numCol; j2++) {
                tmp[i2][j2] = this.values[rowSource + i2][colSource + j2];
            }
        }
        for (int i3 = 0; i3 < numRow; i3++) {
            for (int j3 = 0; j3 < numCol; j3++) {
                target.values[rowDest + i3][colDest + j3] = tmp[i3][j3];
            }
        }
    }

    public final void setSize(int nRow2, int nCol2) {
        int maxRow;
        int maxCol;
        double[][] tmp = (double[][]) Array.newInstance(Double.TYPE, new int[]{nRow2, nCol2});
        if (this.nRow < nRow2) {
            maxRow = this.nRow;
        } else {
            maxRow = nRow2;
        }
        if (this.nCol < nCol2) {
            maxCol = this.nCol;
        } else {
            maxCol = nCol2;
        }
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                tmp[i][j] = this.values[i][j];
            }
        }
        this.nRow = nRow2;
        this.nCol = nCol2;
        this.values = tmp;
    }

    public final void set(double[] matrix) {
        for (int i = 0; i < this.nRow; i++) {
            for (int j = 0; j < this.nCol; j++) {
                this.values[i][j] = matrix[(this.nCol * i) + j];
            }
        }
    }

    public final void set(Matrix3f m1) {
        if (this.nCol < 3 || this.nRow < 3) {
            this.nCol = 3;
            this.nRow = 3;
            this.values = (double[][]) Array.newInstance(Double.TYPE, new int[]{this.nRow, this.nCol});
        }
        this.values[0][0] = (double) m1.m00;
        this.values[0][1] = (double) m1.m01;
        this.values[0][2] = (double) m1.m02;
        this.values[1][0] = (double) m1.m10;
        this.values[1][1] = (double) m1.m11;
        this.values[1][2] = (double) m1.m12;
        this.values[2][0] = (double) m1.m20;
        this.values[2][1] = (double) m1.m21;
        this.values[2][2] = (double) m1.m22;
        for (int i = 3; i < this.nRow; i++) {
            for (int j = 3; j < this.nCol; j++) {
                this.values[i][j] = 0.0d;
            }
        }
    }

    public final void set(Matrix3d m1) {
        if (this.nRow < 3 || this.nCol < 3) {
            this.values = (double[][]) Array.newInstance(Double.TYPE, new int[]{3, 3});
            this.nRow = 3;
            this.nCol = 3;
        }
        this.values[0][0] = m1.m00;
        this.values[0][1] = m1.m01;
        this.values[0][2] = m1.m02;
        this.values[1][0] = m1.m10;
        this.values[1][1] = m1.m11;
        this.values[1][2] = m1.m12;
        this.values[2][0] = m1.m20;
        this.values[2][1] = m1.m21;
        this.values[2][2] = m1.m22;
        for (int i = 3; i < this.nRow; i++) {
            for (int j = 3; j < this.nCol; j++) {
                this.values[i][j] = 0.0d;
            }
        }
    }

    public final void set(Matrix4f m1) {
        if (this.nRow < 4 || this.nCol < 4) {
            this.values = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
            this.nRow = 4;
            this.nCol = 4;
        }
        this.values[0][0] = (double) m1.m00;
        this.values[0][1] = (double) m1.m01;
        this.values[0][2] = (double) m1.m02;
        this.values[0][3] = (double) m1.m03;
        this.values[1][0] = (double) m1.m10;
        this.values[1][1] = (double) m1.m11;
        this.values[1][2] = (double) m1.m12;
        this.values[1][3] = (double) m1.m13;
        this.values[2][0] = (double) m1.m20;
        this.values[2][1] = (double) m1.m21;
        this.values[2][2] = (double) m1.m22;
        this.values[2][3] = (double) m1.m23;
        this.values[3][0] = (double) m1.m30;
        this.values[3][1] = (double) m1.m31;
        this.values[3][2] = (double) m1.m32;
        this.values[3][3] = (double) m1.m33;
        for (int i = 4; i < this.nRow; i++) {
            for (int j = 4; j < this.nCol; j++) {
                this.values[i][j] = 0.0d;
            }
        }
    }

    public final void set(Matrix4d m1) {
        if (this.nRow < 4 || this.nCol < 4) {
            this.values = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
            this.nRow = 4;
            this.nCol = 4;
        }
        this.values[0][0] = m1.m00;
        this.values[0][1] = m1.m01;
        this.values[0][2] = m1.m02;
        this.values[0][3] = m1.m03;
        this.values[1][0] = m1.m10;
        this.values[1][1] = m1.m11;
        this.values[1][2] = m1.m12;
        this.values[1][3] = m1.m13;
        this.values[2][0] = m1.m20;
        this.values[2][1] = m1.m21;
        this.values[2][2] = m1.m22;
        this.values[2][3] = m1.m23;
        this.values[3][0] = m1.m30;
        this.values[3][1] = m1.m31;
        this.values[3][2] = m1.m32;
        this.values[3][3] = m1.m33;
        for (int i = 4; i < this.nRow; i++) {
            for (int j = 4; j < this.nCol; j++) {
                this.values[i][j] = 0.0d;
            }
        }
    }

    public final void set(GMatrix m1) {
        if (this.nRow < m1.nRow || this.nCol < m1.nCol) {
            this.nRow = m1.nRow;
            this.nCol = m1.nCol;
            this.values = (double[][]) Array.newInstance(Double.TYPE, new int[]{this.nRow, this.nCol});
        }
        for (int i = 0; i < Math.min(this.nRow, m1.nRow); i++) {
            for (int j = 0; j < Math.min(this.nCol, m1.nCol); j++) {
                this.values[i][j] = m1.values[i][j];
            }
        }
        for (int i2 = m1.nRow; i2 < this.nRow; i2++) {
            for (int j2 = m1.nCol; j2 < this.nCol; j2++) {
                this.values[i2][j2] = 0.0d;
            }
        }
    }

    public final int getNumRow() {
        return this.nRow;
    }

    public final int getNumCol() {
        return this.nCol;
    }

    public final double getElement(int row, int column) {
        return this.values[row][column];
    }

    public final void setElement(int row, int column, double value) {
        this.values[row][column] = value;
    }

    public final void getRow(int row, double[] array) {
        for (int i = 0; i < this.nCol; i++) {
            array[i] = this.values[row][i];
        }
    }

    public final void getRow(int row, GVector vector) {
        if (vector.getSize() < this.nCol) {
            vector.setSize(this.nCol);
        }
        for (int i = 0; i < this.nCol; i++) {
            vector.values[i] = this.values[row][i];
        }
    }

    public final void getColumn(int col, double[] array) {
        for (int i = 0; i < this.nRow; i++) {
            array[i] = this.values[i][col];
        }
    }

    public final void getColumn(int col, GVector vector) {
        if (vector.getSize() < this.nRow) {
            vector.setSize(this.nRow);
        }
        for (int i = 0; i < this.nRow; i++) {
            vector.values[i] = this.values[i][col];
        }
    }

    public final void get(Matrix3d m1) {
        if (this.nRow < 3 || this.nCol < 3) {
            m1.setZero();
            if (this.nCol > 0) {
                if (this.nRow > 0) {
                    m1.m00 = this.values[0][0];
                    if (this.nRow > 1) {
                        m1.m10 = this.values[1][0];
                        if (this.nRow > 2) {
                            m1.m20 = this.values[2][0];
                        }
                    }
                }
                if (this.nCol > 1) {
                    if (this.nRow > 0) {
                        m1.m01 = this.values[0][1];
                        if (this.nRow > 1) {
                            m1.m11 = this.values[1][1];
                            if (this.nRow > 2) {
                                m1.m21 = this.values[2][1];
                            }
                        }
                    }
                    if (this.nCol > 2 && this.nRow > 0) {
                        m1.m02 = this.values[0][2];
                        if (this.nRow > 1) {
                            m1.m12 = this.values[1][2];
                            if (this.nRow > 2) {
                                m1.m22 = this.values[2][2];
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        m1.m00 = this.values[0][0];
        m1.m01 = this.values[0][1];
        m1.m02 = this.values[0][2];
        m1.m10 = this.values[1][0];
        m1.m11 = this.values[1][1];
        m1.m12 = this.values[1][2];
        m1.m20 = this.values[2][0];
        m1.m21 = this.values[2][1];
        m1.m22 = this.values[2][2];
    }

    public final void get(Matrix3f m1) {
        if (this.nRow < 3 || this.nCol < 3) {
            m1.setZero();
            if (this.nCol > 0) {
                if (this.nRow > 0) {
                    m1.m00 = (float) this.values[0][0];
                    if (this.nRow > 1) {
                        m1.m10 = (float) this.values[1][0];
                        if (this.nRow > 2) {
                            m1.m20 = (float) this.values[2][0];
                        }
                    }
                }
                if (this.nCol > 1) {
                    if (this.nRow > 0) {
                        m1.m01 = (float) this.values[0][1];
                        if (this.nRow > 1) {
                            m1.m11 = (float) this.values[1][1];
                            if (this.nRow > 2) {
                                m1.m21 = (float) this.values[2][1];
                            }
                        }
                    }
                    if (this.nCol > 2 && this.nRow > 0) {
                        m1.m02 = (float) this.values[0][2];
                        if (this.nRow > 1) {
                            m1.m12 = (float) this.values[1][2];
                            if (this.nRow > 2) {
                                m1.m22 = (float) this.values[2][2];
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        m1.m00 = (float) this.values[0][0];
        m1.m01 = (float) this.values[0][1];
        m1.m02 = (float) this.values[0][2];
        m1.m10 = (float) this.values[1][0];
        m1.m11 = (float) this.values[1][1];
        m1.m12 = (float) this.values[1][2];
        m1.m20 = (float) this.values[2][0];
        m1.m21 = (float) this.values[2][1];
        m1.m22 = (float) this.values[2][2];
    }

    public final void get(Matrix4d m1) {
        if (this.nRow < 4 || this.nCol < 4) {
            m1.setZero();
            if (this.nCol > 0) {
                if (this.nRow > 0) {
                    m1.m00 = this.values[0][0];
                    if (this.nRow > 1) {
                        m1.m10 = this.values[1][0];
                        if (this.nRow > 2) {
                            m1.m20 = this.values[2][0];
                            if (this.nRow > 3) {
                                m1.m30 = this.values[3][0];
                            }
                        }
                    }
                }
                if (this.nCol > 1) {
                    if (this.nRow > 0) {
                        m1.m01 = this.values[0][1];
                        if (this.nRow > 1) {
                            m1.m11 = this.values[1][1];
                            if (this.nRow > 2) {
                                m1.m21 = this.values[2][1];
                                if (this.nRow > 3) {
                                    m1.m31 = this.values[3][1];
                                }
                            }
                        }
                    }
                    if (this.nCol > 2) {
                        if (this.nRow > 0) {
                            m1.m02 = this.values[0][2];
                            if (this.nRow > 1) {
                                m1.m12 = this.values[1][2];
                                if (this.nRow > 2) {
                                    m1.m22 = this.values[2][2];
                                    if (this.nRow > 3) {
                                        m1.m32 = this.values[3][2];
                                    }
                                }
                            }
                        }
                        if (this.nCol > 3 && this.nRow > 0) {
                            m1.m03 = this.values[0][3];
                            if (this.nRow > 1) {
                                m1.m13 = this.values[1][3];
                                if (this.nRow > 2) {
                                    m1.m23 = this.values[2][3];
                                    if (this.nRow > 3) {
                                        m1.m33 = this.values[3][3];
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        m1.m00 = this.values[0][0];
        m1.m01 = this.values[0][1];
        m1.m02 = this.values[0][2];
        m1.m03 = this.values[0][3];
        m1.m10 = this.values[1][0];
        m1.m11 = this.values[1][1];
        m1.m12 = this.values[1][2];
        m1.m13 = this.values[1][3];
        m1.m20 = this.values[2][0];
        m1.m21 = this.values[2][1];
        m1.m22 = this.values[2][2];
        m1.m23 = this.values[2][3];
        m1.m30 = this.values[3][0];
        m1.m31 = this.values[3][1];
        m1.m32 = this.values[3][2];
        m1.m33 = this.values[3][3];
    }

    public final void get(Matrix4f m1) {
        if (this.nRow < 4 || this.nCol < 4) {
            m1.setZero();
            if (this.nCol > 0) {
                if (this.nRow > 0) {
                    m1.m00 = (float) this.values[0][0];
                    if (this.nRow > 1) {
                        m1.m10 = (float) this.values[1][0];
                        if (this.nRow > 2) {
                            m1.m20 = (float) this.values[2][0];
                            if (this.nRow > 3) {
                                m1.m30 = (float) this.values[3][0];
                            }
                        }
                    }
                }
                if (this.nCol > 1) {
                    if (this.nRow > 0) {
                        m1.m01 = (float) this.values[0][1];
                        if (this.nRow > 1) {
                            m1.m11 = (float) this.values[1][1];
                            if (this.nRow > 2) {
                                m1.m21 = (float) this.values[2][1];
                                if (this.nRow > 3) {
                                    m1.m31 = (float) this.values[3][1];
                                }
                            }
                        }
                    }
                    if (this.nCol > 2) {
                        if (this.nRow > 0) {
                            m1.m02 = (float) this.values[0][2];
                            if (this.nRow > 1) {
                                m1.m12 = (float) this.values[1][2];
                                if (this.nRow > 2) {
                                    m1.m22 = (float) this.values[2][2];
                                    if (this.nRow > 3) {
                                        m1.m32 = (float) this.values[3][2];
                                    }
                                }
                            }
                        }
                        if (this.nCol > 3 && this.nRow > 0) {
                            m1.m03 = (float) this.values[0][3];
                            if (this.nRow > 1) {
                                m1.m13 = (float) this.values[1][3];
                                if (this.nRow > 2) {
                                    m1.m23 = (float) this.values[2][3];
                                    if (this.nRow > 3) {
                                        m1.m33 = (float) this.values[3][3];
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        m1.m00 = (float) this.values[0][0];
        m1.m01 = (float) this.values[0][1];
        m1.m02 = (float) this.values[0][2];
        m1.m03 = (float) this.values[0][3];
        m1.m10 = (float) this.values[1][0];
        m1.m11 = (float) this.values[1][1];
        m1.m12 = (float) this.values[1][2];
        m1.m13 = (float) this.values[1][3];
        m1.m20 = (float) this.values[2][0];
        m1.m21 = (float) this.values[2][1];
        m1.m22 = (float) this.values[2][2];
        m1.m23 = (float) this.values[2][3];
        m1.m30 = (float) this.values[3][0];
        m1.m31 = (float) this.values[3][1];
        m1.m32 = (float) this.values[3][2];
        m1.m33 = (float) this.values[3][3];
    }

    public final void get(GMatrix m1) {
        int nc;
        int nr;
        if (this.nCol < m1.nCol) {
            nc = this.nCol;
        } else {
            nc = m1.nCol;
        }
        if (this.nRow < m1.nRow) {
            nr = this.nRow;
        } else {
            nr = m1.nRow;
        }
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                m1.values[i][j] = this.values[i][j];
            }
        }
        for (int i2 = nr; i2 < m1.nRow; i2++) {
            for (int j2 = 0; j2 < m1.nCol; j2++) {
                m1.values[i2][j2] = 0.0d;
            }
        }
        for (int j3 = nc; j3 < m1.nCol; j3++) {
            for (int i3 = 0; i3 < nr; i3++) {
                m1.values[i3][j3] = 0.0d;
            }
        }
    }

    public final void setRow(int row, double[] array) {
        for (int i = 0; i < this.nCol; i++) {
            this.values[row][i] = array[i];
        }
    }

    public final void setRow(int row, GVector vector) {
        for (int i = 0; i < this.nCol; i++) {
            this.values[row][i] = vector.values[i];
        }
    }

    public final void setColumn(int col, double[] array) {
        for (int i = 0; i < this.nRow; i++) {
            this.values[i][col] = array[i];
        }
    }

    public final void setColumn(int col, GVector vector) {
        for (int i = 0; i < this.nRow; i++) {
            this.values[i][col] = vector.values[i];
        }
    }

    public final void mulTransposeBoth(GMatrix m1, GMatrix m2) {
        if (m1.nRow != m2.nCol || this.nRow != m1.nCol || this.nCol != m2.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix14"));
        } else if (m1 == this || m2 == this) {
            double[][] tmp = (double[][]) Array.newInstance(Double.TYPE, new int[]{this.nRow, this.nCol});
            for (int i = 0; i < this.nRow; i++) {
                for (int j = 0; j < this.nCol; j++) {
                    tmp[i][j] = 0.0d;
                    for (int k = 0; k < m1.nRow; k++) {
                        double[] dArr = tmp[i];
                        dArr[j] = dArr[j] + (m1.values[k][i] * m2.values[j][k]);
                    }
                }
            }
            this.values = tmp;
        } else {
            for (int i2 = 0; i2 < this.nRow; i2++) {
                for (int j2 = 0; j2 < this.nCol; j2++) {
                    this.values[i2][j2] = 0.0d;
                    for (int k2 = 0; k2 < m1.nRow; k2++) {
                        double[] dArr2 = this.values[i2];
                        dArr2[j2] = dArr2[j2] + (m1.values[k2][i2] * m2.values[j2][k2]);
                    }
                }
            }
        }
    }

    public final void mulTransposeRight(GMatrix m1, GMatrix m2) {
        if (m1.nCol != m2.nCol || this.nCol != m2.nRow || this.nRow != m1.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix15"));
        } else if (m1 == this || m2 == this) {
            double[][] tmp = (double[][]) Array.newInstance(Double.TYPE, new int[]{this.nRow, this.nCol});
            for (int i = 0; i < this.nRow; i++) {
                for (int j = 0; j < this.nCol; j++) {
                    tmp[i][j] = 0.0d;
                    for (int k = 0; k < m1.nCol; k++) {
                        double[] dArr = tmp[i];
                        dArr[j] = dArr[j] + (m1.values[i][k] * m2.values[j][k]);
                    }
                }
            }
            this.values = tmp;
        } else {
            for (int i2 = 0; i2 < this.nRow; i2++) {
                for (int j2 = 0; j2 < this.nCol; j2++) {
                    this.values[i2][j2] = 0.0d;
                    for (int k2 = 0; k2 < m1.nCol; k2++) {
                        double[] dArr2 = this.values[i2];
                        dArr2[j2] = dArr2[j2] + (m1.values[i2][k2] * m2.values[j2][k2]);
                    }
                }
            }
        }
    }

    public final void mulTransposeLeft(GMatrix m1, GMatrix m2) {
        if (m1.nRow != m2.nRow || this.nCol != m2.nCol || this.nRow != m1.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix16"));
        } else if (m1 == this || m2 == this) {
            double[][] tmp = (double[][]) Array.newInstance(Double.TYPE, new int[]{this.nRow, this.nCol});
            for (int i = 0; i < this.nRow; i++) {
                for (int j = 0; j < this.nCol; j++) {
                    tmp[i][j] = 0.0d;
                    for (int k = 0; k < m1.nRow; k++) {
                        double[] dArr = tmp[i];
                        dArr[j] = dArr[j] + (m1.values[k][i] * m2.values[k][j]);
                    }
                }
            }
            this.values = tmp;
        } else {
            for (int i2 = 0; i2 < this.nRow; i2++) {
                for (int j2 = 0; j2 < this.nCol; j2++) {
                    this.values[i2][j2] = 0.0d;
                    for (int k2 = 0; k2 < m1.nRow; k2++) {
                        double[] dArr2 = this.values[i2];
                        dArr2[j2] = dArr2[j2] + (m1.values[k2][i2] * m2.values[k2][j2]);
                    }
                }
            }
        }
    }

    public final void transpose() {
        if (this.nRow != this.nCol) {
            int i = this.nRow;
            this.nRow = this.nCol;
            this.nCol = i;
            double[][] tmp = (double[][]) Array.newInstance(Double.TYPE, new int[]{this.nRow, this.nCol});
            for (int i2 = 0; i2 < this.nRow; i2++) {
                for (int j = 0; j < this.nCol; j++) {
                    tmp[i2][j] = this.values[j][i2];
                }
            }
            this.values = tmp;
            return;
        }
        for (int i3 = 0; i3 < this.nRow; i3++) {
            for (int j2 = 0; j2 < i3; j2++) {
                double swap = this.values[i3][j2];
                this.values[i3][j2] = this.values[j2][i3];
                this.values[j2][i3] = swap;
            }
        }
    }

    public final void transpose(GMatrix m1) {
        if (this.nRow != m1.nCol || this.nCol != m1.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix17"));
        } else if (m1 != this) {
            for (int i = 0; i < this.nRow; i++) {
                for (int j = 0; j < this.nCol; j++) {
                    this.values[i][j] = m1.values[j][i];
                }
            }
        } else {
            transpose();
        }
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer(this.nRow * this.nCol * 8);
        for (int i = 0; i < this.nRow; i++) {
            for (int j = 0; j < this.nCol; j++) {
                buffer.append(this.values[i][j]).append(" ");
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }

    private static void checkMatrix(GMatrix m) {
        for (int i = 0; i < m.nRow; i++) {
            for (int j = 0; j < m.nCol; j++) {
                if (Math.abs(m.values[i][j]) < EPS) {
                    System.out.print(" 0.0     ");
                } else {
                    System.out.print(" " + m.values[i][j]);
                }
            }
            System.out.print("\n");
        }
    }

    public int hashCode() {
        long bits = (31 * ((31 * 1) + ((long) this.nRow))) + ((long) this.nCol);
        for (int i = 0; i < this.nRow; i++) {
            for (int j = 0; j < this.nCol; j++) {
                bits = (31 * bits) + VecMathUtil.doubleToLongBits(this.values[i][j]);
            }
        }
        return (int) ((bits >> 32) ^ bits);
    }

    public boolean equals(GMatrix m1) {
        try {
            if (this.nRow != m1.nRow || this.nCol != m1.nCol) {
                return false;
            }
            for (int i = 0; i < this.nRow; i++) {
                for (int j = 0; j < this.nCol; j++) {
                    if (this.values[i][j] != m1.values[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean equals(Object o1) {
        try {
            GMatrix m2 = (GMatrix) o1;
            if (this.nRow != m2.nRow || this.nCol != m2.nCol) {
                return false;
            }
            for (int i = 0; i < this.nRow; i++) {
                for (int j = 0; j < this.nCol; j++) {
                    if (this.values[i][j] != m2.values[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        } catch (NullPointerException e2) {
            return false;
        }
    }

    public boolean epsilonEquals(GMatrix m1, float epsilon) {
        return epsilonEquals(m1, (double) epsilon);
    }

    public boolean epsilonEquals(GMatrix m1, double epsilon) {
        if (this.nRow != m1.nRow || this.nCol != m1.nCol) {
            return false;
        }
        for (int i = 0; i < this.nRow; i++) {
            for (int j = 0; j < this.nCol; j++) {
                double diff = this.values[i][j] - m1.values[i][j];
                if (diff < Utils.DOUBLE_EPSILON) {
                    diff = -diff;
                }
                if (diff > epsilon) {
                    return false;
                }
            }
        }
        return true;
    }

    public final double trace() {
        int l;
        if (this.nRow < this.nCol) {
            l = this.nRow;
        } else {
            l = this.nCol;
        }
        double t = Utils.DOUBLE_EPSILON;
        for (int i = 0; i < l; i++) {
            t += this.values[i][i];
        }
        return t;
    }

    public final int SVD(GMatrix U, GMatrix W, GMatrix V) {
        if (this.nCol != V.nCol || this.nCol != V.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix18"));
        } else if (this.nRow != U.nRow || this.nRow != U.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix25"));
        } else if (this.nRow != W.nRow || this.nCol != W.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix26"));
        } else if (this.nRow != 2 || this.nCol != 2 || this.values[1][0] != Utils.DOUBLE_EPSILON) {
            return computeSVD(this, U, W, V);
        } else {
            U.setIdentity();
            V.setIdentity();
            if (this.values[0][1] == Utils.DOUBLE_EPSILON) {
                return 2;
            }
            double[] sinl = new double[1];
            double[] sinr = new double[1];
            double[] cosl = new double[1];
            double[] cosr = new double[1];
            compute_2X2(this.values[0][0], this.values[0][1], this.values[1][1], new double[]{this.values[0][0], this.values[1][1]}, sinl, cosl, sinr, cosr, 0);
            update_u(0, U, cosl, sinl);
            update_v(0, V, cosr, sinr);
            return 2;
        }
    }

    public final int LUD(GMatrix LU, GVector permutation) {
        double[] temp = new double[(LU.nRow * LU.nCol)];
        int[] even_row_exchange = new int[1];
        int[] row_perm = new int[LU.nRow];
        if (this.nRow != this.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix19"));
        } else if (this.nRow != LU.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix27"));
        } else if (this.nCol != LU.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix27"));
        } else if (LU.nRow != permutation.getSize()) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix20"));
        } else {
            for (int i = 0; i < this.nRow; i++) {
                for (int j = 0; j < this.nCol; j++) {
                    temp[(this.nCol * i) + j] = this.values[i][j];
                }
            }
            if (!luDecomposition(LU.nRow, temp, row_perm, even_row_exchange)) {
                throw new SingularMatrixException(VecMathI18N.getString("GMatrix21"));
            }
            for (int i2 = 0; i2 < this.nRow; i2++) {
                for (int j2 = 0; j2 < this.nCol; j2++) {
                    LU.values[i2][j2] = temp[(this.nCol * i2) + j2];
                }
            }
            for (int i3 = 0; i3 < LU.nRow; i3++) {
                permutation.values[i3] = (double) row_perm[i3];
            }
            return even_row_exchange[0];
        }
    }

    public final void setScale(double scale) {
        int l;
        if (this.nRow < this.nCol) {
            l = this.nRow;
        } else {
            l = this.nCol;
        }
        for (int i = 0; i < this.nRow; i++) {
            for (int j = 0; j < this.nCol; j++) {
                this.values[i][j] = 0.0d;
            }
        }
        for (int i2 = 0; i2 < l; i2++) {
            this.values[i2][i2] = scale;
        }
    }

    /* access modifiers changed from: package-private */
    public final void invertGeneral(GMatrix m1) {
        int size = m1.nRow * m1.nCol;
        double[] temp = new double[size];
        double[] result = new double[size];
        int[] row_perm = new int[m1.nRow];
        int[] even_row_exchange = new int[1];
        if (m1.nRow != m1.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix22"));
        }
        for (int i = 0; i < this.nRow; i++) {
            for (int j = 0; j < this.nCol; j++) {
                temp[(this.nCol * i) + j] = m1.values[i][j];
            }
        }
        if (!luDecomposition(m1.nRow, temp, row_perm, even_row_exchange)) {
            throw new SingularMatrixException(VecMathI18N.getString("GMatrix21"));
        }
        for (int i2 = 0; i2 < size; i2++) {
            result[i2] = 0.0d;
        }
        for (int i3 = 0; i3 < this.nCol; i3++) {
            result[(this.nCol * i3) + i3] = 1.0d;
        }
        luBacksubstitution(m1.nRow, temp, row_perm, result);
        for (int i4 = 0; i4 < this.nRow; i4++) {
            for (int j2 = 0; j2 < this.nCol; j2++) {
                this.values[i4][j2] = result[(this.nCol * i4) + j2];
            }
        }
    }

    static boolean luDecomposition(int dim, double[] matrix0, int[] row_perm, int[] even_row_xchg) {
        int ptr;
        double[] row_scale = new double[dim];
        int ptr2 = 0;
        even_row_xchg[0] = 1;
        int i = dim;
        int rs = 0;
        while (true) {
            int i2 = i;
            i = i2 - 1;
            if (i2 != 0) {
                double big = Utils.DOUBLE_EPSILON;
                int j = dim;
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
                    int i3 = ptr;
                    return false;
                }
                row_scale[rs] = 1.0d / big;
                rs++;
                ptr2 = ptr;
            } else {
                for (int j3 = 0; j3 < dim; j3++) {
                    for (int i4 = 0; i4 < j3; i4++) {
                        int target = (dim * i4) + 0 + j3;
                        double sum = matrix0[target];
                        int k = i4;
                        int p1 = 0 + (dim * i4);
                        int p2 = 0 + j3;
                        while (true) {
                            int k2 = k;
                            k = k2 - 1;
                            if (k2 == 0) {
                                break;
                            }
                            sum -= matrix0[p1] * matrix0[p2];
                            p1++;
                            p2 += dim;
                        }
                        matrix0[target] = sum;
                    }
                    double big2 = Utils.DOUBLE_EPSILON;
                    int imax = -1;
                    for (int i5 = j3; i5 < dim; i5++) {
                        int target2 = (dim * i5) + 0 + j3;
                        double sum2 = matrix0[target2];
                        int k3 = j3;
                        int p12 = 0 + (dim * i5);
                        int p22 = 0 + j3;
                        while (true) {
                            int k4 = k3;
                            k3 = k4 - 1;
                            if (k4 == 0) {
                                break;
                            }
                            sum2 -= matrix0[p12] * matrix0[p22];
                            p12++;
                            p22 += dim;
                        }
                        matrix0[target2] = sum2;
                        double temp2 = row_scale[i5] * Math.abs(sum2);
                        if (temp2 >= big2) {
                            big2 = temp2;
                            imax = i5;
                        }
                    }
                    if (imax < 0) {
                        throw new RuntimeException(VecMathI18N.getString("GMatrix24"));
                    }
                    if (j3 != imax) {
                        int k5 = dim;
                        int p13 = 0 + (dim * imax);
                        int p23 = 0 + (dim * j3);
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
                        even_row_xchg[0] = -even_row_xchg[0];
                    }
                    row_perm[j3] = imax;
                    if (matrix0[(dim * j3) + 0 + j3] == Utils.DOUBLE_EPSILON) {
                        return false;
                    }
                    if (j3 != dim - 1) {
                        double temp4 = 1.0d / matrix0[((dim * j3) + 0) + j3];
                        int target3 = ((j3 + 1) * dim) + 0 + j3;
                        int i6 = (dim - 1) - j3;
                        while (true) {
                            int i7 = i6;
                            i6 = i7 - 1;
                            if (i7 == 0) {
                                break;
                            }
                            matrix0[target3] = matrix0[target3] * temp4;
                            target3 += dim;
                        }
                    }
                }
                return true;
            }
        }
    }

    static void luBacksubstitution(int dim, double[] matrix1, int[] row_perm, double[] matrix2) {
        for (int k = 0; k < dim; k++) {
            int cv = k;
            int ii = -1;
            for (int i = 0; i < dim; i++) {
                int ip = row_perm[0 + i];
                double sum = matrix2[(dim * ip) + cv];
                matrix2[(dim * ip) + cv] = matrix2[(dim * i) + cv];
                if (ii >= 0) {
                    int rv = i * dim;
                    for (int j = ii; j <= i - 1; j++) {
                        sum -= matrix1[rv + j] * matrix2[(dim * j) + cv];
                    }
                } else if (sum != Utils.DOUBLE_EPSILON) {
                    ii = i;
                }
                matrix2[(dim * i) + cv] = sum;
            }
            for (int i2 = 0; i2 < dim; i2++) {
                int ri = (dim - 1) - i2;
                int rv2 = dim * ri;
                double tt = Utils.DOUBLE_EPSILON;
                for (int j2 = 1; j2 <= i2; j2++) {
                    tt += matrix1[(rv2 + dim) - j2] * matrix2[((dim - j2) * dim) + cv];
                }
                matrix2[(dim * ri) + cv] = (matrix2[(dim * ri) + cv] - tt) / matrix1[rv2 + ri];
            }
        }
    }

    static int computeSVD(GMatrix mat, GMatrix U, GMatrix W, GMatrix V) {
        int sLength;
        int eLength;
        int vecLength;
        GMatrix gMatrix = new GMatrix(mat.nRow, mat.nCol);
        GMatrix gMatrix2 = new GMatrix(mat.nRow, mat.nCol);
        GMatrix gMatrix3 = new GMatrix(mat.nRow, mat.nCol);
        GMatrix gMatrix4 = new GMatrix(mat);
        if (gMatrix4.nRow >= gMatrix4.nCol) {
            sLength = gMatrix4.nCol;
            eLength = gMatrix4.nCol - 1;
        } else {
            sLength = gMatrix4.nRow;
            eLength = gMatrix4.nRow;
        }
        if (gMatrix4.nRow > gMatrix4.nCol) {
            vecLength = gMatrix4.nRow;
        } else {
            vecLength = gMatrix4.nCol;
        }
        double[] vec = new double[vecLength];
        double[] single_values = new double[sLength];
        double[] e = new double[eLength];
        U.setIdentity();
        V.setIdentity();
        int nr = gMatrix4.nRow;
        int nc = gMatrix4.nCol;
        for (int si = 0; si < sLength; si++) {
            if (nr > 1) {
                double mag = Utils.DOUBLE_EPSILON;
                for (int i = 0; i < nr; i++) {
                    mag += gMatrix4.values[i + si][si] * gMatrix4.values[i + si][si];
                }
                double mag2 = Math.sqrt(mag);
                if (gMatrix4.values[si][si] == Utils.DOUBLE_EPSILON) {
                    vec[0] = mag2;
                } else {
                    vec[0] = gMatrix4.values[si][si] + d_sign(mag2, gMatrix4.values[si][si]);
                }
                for (int i2 = 1; i2 < nr; i2++) {
                    vec[i2] = gMatrix4.values[si + i2][si];
                }
                double scale = Utils.DOUBLE_EPSILON;
                for (int i3 = 0; i3 < nr; i3++) {
                    scale += vec[i3] * vec[i3];
                }
                double scale2 = 2.0d / scale;
                for (int j = si; j < gMatrix4.nRow; j++) {
                    for (int k = si; k < gMatrix4.nRow; k++) {
                        gMatrix2.values[j][k] = (-scale2) * vec[j - si] * vec[k - si];
                    }
                }
                for (int i4 = si; i4 < gMatrix4.nRow; i4++) {
                    double[] dArr = gMatrix2.values[i4];
                    dArr[i4] = dArr[i4] + 1.0d;
                }
                double t = Utils.DOUBLE_EPSILON;
                for (int i5 = si; i5 < gMatrix4.nRow; i5++) {
                    t += gMatrix2.values[si][i5] * gMatrix4.values[i5][si];
                }
                gMatrix4.values[si][si] = t;
                for (int j2 = si; j2 < gMatrix4.nRow; j2++) {
                    for (int k2 = si + 1; k2 < gMatrix4.nCol; k2++) {
                        gMatrix.values[j2][k2] = 0.0d;
                        for (int i6 = si; i6 < gMatrix4.nCol; i6++) {
                            double[] dArr2 = gMatrix.values[j2];
                            dArr2[k2] = dArr2[k2] + (gMatrix2.values[j2][i6] * gMatrix4.values[i6][k2]);
                        }
                    }
                }
                for (int j3 = si; j3 < gMatrix4.nRow; j3++) {
                    for (int k3 = si + 1; k3 < gMatrix4.nCol; k3++) {
                        gMatrix4.values[j3][k3] = gMatrix.values[j3][k3];
                    }
                }
                for (int j4 = si; j4 < gMatrix4.nRow; j4++) {
                    for (int k4 = 0; k4 < gMatrix4.nCol; k4++) {
                        gMatrix.values[j4][k4] = 0.0d;
                        for (int i7 = si; i7 < gMatrix4.nCol; i7++) {
                            double[] dArr3 = gMatrix.values[j4];
                            dArr3[k4] = dArr3[k4] + (gMatrix2.values[j4][i7] * U.values[i7][k4]);
                        }
                    }
                }
                for (int j5 = si; j5 < gMatrix4.nRow; j5++) {
                    for (int k5 = 0; k5 < gMatrix4.nCol; k5++) {
                        U.values[j5][k5] = gMatrix.values[j5][k5];
                    }
                }
                nr--;
            }
            if (nc > 2) {
                double mag3 = Utils.DOUBLE_EPSILON;
                for (int i8 = 1; i8 < nc; i8++) {
                    mag3 += gMatrix4.values[si][si + i8] * gMatrix4.values[si][si + i8];
                }
                double mag4 = Math.sqrt(mag3);
                if (gMatrix4.values[si][si + 1] == Utils.DOUBLE_EPSILON) {
                    vec[0] = mag4;
                } else {
                    vec[0] = gMatrix4.values[si][si + 1] + d_sign(mag4, gMatrix4.values[si][si + 1]);
                }
                for (int i9 = 1; i9 < nc - 1; i9++) {
                    vec[i9] = gMatrix4.values[si][si + i9 + 1];
                }
                double scale3 = Utils.DOUBLE_EPSILON;
                for (int i10 = 0; i10 < nc - 1; i10++) {
                    scale3 += vec[i10] * vec[i10];
                }
                double scale4 = 2.0d / scale3;
                for (int j6 = si + 1; j6 < nc; j6++) {
                    for (int k6 = si + 1; k6 < gMatrix4.nCol; k6++) {
                        gMatrix3.values[j6][k6] = (-scale4) * vec[(j6 - si) - 1] * vec[(k6 - si) - 1];
                    }
                }
                for (int i11 = si + 1; i11 < gMatrix4.nCol; i11++) {
                    double[] dArr4 = gMatrix3.values[i11];
                    dArr4[i11] = dArr4[i11] + 1.0d;
                }
                double t2 = Utils.DOUBLE_EPSILON;
                for (int i12 = si; i12 < gMatrix4.nCol; i12++) {
                    t2 += gMatrix3.values[i12][si + 1] * gMatrix4.values[si][i12];
                }
                gMatrix4.values[si][si + 1] = t2;
                for (int j7 = si + 1; j7 < gMatrix4.nRow; j7++) {
                    for (int k7 = si + 1; k7 < gMatrix4.nCol; k7++) {
                        gMatrix.values[j7][k7] = 0.0d;
                        for (int i13 = si + 1; i13 < gMatrix4.nCol; i13++) {
                            double[] dArr5 = gMatrix.values[j7];
                            dArr5[k7] = dArr5[k7] + (gMatrix3.values[i13][k7] * gMatrix4.values[j7][i13]);
                        }
                    }
                }
                for (int j8 = si + 1; j8 < gMatrix4.nRow; j8++) {
                    for (int k8 = si + 1; k8 < gMatrix4.nCol; k8++) {
                        gMatrix4.values[j8][k8] = gMatrix.values[j8][k8];
                    }
                }
                for (int j9 = 0; j9 < gMatrix4.nRow; j9++) {
                    for (int k9 = si + 1; k9 < gMatrix4.nCol; k9++) {
                        gMatrix.values[j9][k9] = 0.0d;
                        for (int i14 = si + 1; i14 < gMatrix4.nCol; i14++) {
                            double[] dArr6 = gMatrix.values[j9];
                            dArr6[k9] = dArr6[k9] + (gMatrix3.values[i14][k9] * V.values[j9][i14]);
                        }
                    }
                }
                for (int j10 = 0; j10 < gMatrix4.nRow; j10++) {
                    for (int k10 = si + 1; k10 < gMatrix4.nCol; k10++) {
                        V.values[j10][k10] = gMatrix.values[j10][k10];
                    }
                }
                nc--;
            }
        }
        for (int i15 = 0; i15 < sLength; i15++) {
            single_values[i15] = gMatrix4.values[i15][i15];
        }
        for (int i16 = 0; i16 < eLength; i16++) {
            e[i16] = gMatrix4.values[i16][i16 + 1];
        }
        if (gMatrix4.nRow == 2 && gMatrix4.nCol == 2) {
            double[] cosl = new double[1];
            double[] cosr = new double[1];
            double[] sinl = new double[1];
            double[] sinr = new double[1];
            compute_2X2(single_values[0], e[0], single_values[1], single_values, sinl, cosl, sinr, cosr, 0);
            update_u(0, U, cosl, sinl);
            update_v(0, V, cosr, sinr);
            return 2;
        }
        compute_qr(0, e.length - 1, single_values, e, U, V);
        return single_values.length;
    }

    static void compute_qr(int start, int end, double[] s, double[] e, GMatrix u, GMatrix v) {
        int sl;
        double[] cosl = new double[1];
        double[] cosr = new double[1];
        double[] sinl = new double[1];
        double[] sinr = new double[1];
        new GMatrix(u.nCol, v.nRow);
        boolean converged = false;
        double f = Utils.DOUBLE_EPSILON;
        double g = Utils.DOUBLE_EPSILON;
        for (int k = 0; k < 2 && !converged; k++) {
            int i = start;
            while (i <= end) {
                if (i == start) {
                    if (e.length == s.length) {
                        sl = end;
                    } else {
                        sl = end + 1;
                    }
                    double shift = compute_shift(s[sl - 1], e[end], s[sl]);
                    f = (Math.abs(s[i]) - shift) * (d_sign(1.0d, s[i]) + (shift / s[i]));
                    g = e[i];
                }
                double r = compute_rot(f, g, sinr, cosr);
                if (i != start) {
                    e[i - 1] = r;
                }
                double f2 = (cosr[0] * s[i]) + (sinr[0] * e[i]);
                e[i] = (cosr[0] * e[i]) - (sinr[0] * s[i]);
                g = sinr[0] * s[i + 1];
                s[i + 1] = cosr[0] * s[i + 1];
                update_v(i, v, cosr, sinr);
                s[i] = compute_rot(f2, g, sinl, cosl);
                f = (cosl[0] * e[i]) + (sinl[0] * s[i + 1]);
                s[i + 1] = (cosl[0] * s[i + 1]) - (sinl[0] * e[i]);
                if (i < end) {
                    g = sinl[0] * e[i + 1];
                    e[i + 1] = cosl[0] * e[i + 1];
                }
                update_u(i, u, cosl, sinl);
                i++;
            }
            if (s.length == e.length) {
                double compute_rot = compute_rot(f, g, sinr, cosr);
                f = (cosr[0] * s[i]) + (sinr[0] * e[i]);
                e[i] = (cosr[0] * e[i]) - (sinr[0] * s[i]);
                s[i + 1] = cosr[0] * s[i + 1];
                update_v(i, v, cosr, sinr);
            }
            while (end - start > 1 && Math.abs(e[end]) < 4.89E-15d) {
                end--;
            }
            for (int n = end - 2; n > start; n--) {
                if (Math.abs(e[n]) < 4.89E-15d) {
                    compute_qr(n + 1, end, s, e, u, v);
                    end = n - 1;
                    while (end - start > 1 && Math.abs(e[end]) < 4.89E-15d) {
                        end--;
                    }
                }
            }
            if (end - start <= 1 && Math.abs(e[start + 1]) < 4.89E-15d) {
                converged = true;
            }
        }
        if (Math.abs(e[1]) < 4.89E-15d) {
            compute_2X2(s[start], e[start], s[start + 1], s, sinl, cosl, sinr, cosr, 0);
            e[start] = 0.0d;
            e[start + 1] = 0.0d;
        }
        int i2 = start;
        update_u(i2, u, cosl, sinl);
        update_v(i2, v, cosr, sinr);
    }

    private static void print_se(double[] s, double[] e) {
        System.out.println("\ns =" + s[0] + " " + s[1] + " " + s[2]);
        System.out.println("e =" + e[0] + " " + e[1]);
    }

    private static void update_v(int index, GMatrix v, double[] cosr, double[] sinr) {
        for (int j = 0; j < v.nRow; j++) {
            double vtemp = v.values[j][index];
            v.values[j][index] = (cosr[0] * vtemp) + (sinr[0] * v.values[j][index + 1]);
            v.values[j][index + 1] = ((-sinr[0]) * vtemp) + (cosr[0] * v.values[j][index + 1]);
        }
    }

    private static void chase_up(double[] s, double[] e, int k, GMatrix v) {
        double[] cosr = new double[1];
        double[] sinr = new double[1];
        GMatrix t = new GMatrix(v.nRow, v.nCol);
        GMatrix m = new GMatrix(v.nRow, v.nCol);
        double f = e[k];
        double g = s[k];
        int i = k;
        while (i > 0) {
            double r = compute_rot(f, g, sinr, cosr);
            f = (-e[i - 1]) * sinr[0];
            g = s[i - 1];
            s[i] = r;
            e[i - 1] = e[i - 1] * cosr[0];
            update_v_split(i, k + 1, v, cosr, sinr, t, m);
            i--;
        }
        s[i + 1] = compute_rot(f, g, sinr, cosr);
        update_v_split(i, k + 1, v, cosr, sinr, t, m);
    }

    private static void chase_across(double[] s, double[] e, int k, GMatrix u) {
        double[] cosl = new double[1];
        double[] sinl = new double[1];
        GMatrix t = new GMatrix(u.nRow, u.nCol);
        GMatrix m = new GMatrix(u.nRow, u.nCol);
        double g = e[k];
        double f = s[k + 1];
        int i = k;
        while (i < u.nCol - 2) {
            double r = compute_rot(f, g, sinl, cosl);
            g = (-e[i + 1]) * sinl[0];
            f = s[i + 2];
            s[i + 1] = r;
            e[i + 1] = e[i + 1] * cosl[0];
            update_u_split(k, i + 1, u, cosl, sinl, t, m);
            i++;
        }
        s[i + 1] = compute_rot(f, g, sinl, cosl);
        update_u_split(k, i + 1, u, cosl, sinl, t, m);
    }

    private static void update_v_split(int topr, int bottomr, GMatrix v, double[] cosr, double[] sinr, GMatrix t, GMatrix m) {
        for (int j = 0; j < v.nRow; j++) {
            double vtemp = v.values[j][topr];
            v.values[j][topr] = (cosr[0] * vtemp) - (sinr[0] * v.values[j][bottomr]);
            v.values[j][bottomr] = (sinr[0] * vtemp) + (cosr[0] * v.values[j][bottomr]);
        }
        System.out.println("topr    =" + topr);
        System.out.println("bottomr =" + bottomr);
        System.out.println("cosr =" + cosr[0]);
        System.out.println("sinr =" + sinr[0]);
        System.out.println("\nm =");
        checkMatrix(m);
        System.out.println("\nv =");
        checkMatrix(t);
        m.mul(m, t);
        System.out.println("\nt*m =");
        checkMatrix(m);
    }

    private static void update_u_split(int topr, int bottomr, GMatrix u, double[] cosl, double[] sinl, GMatrix t, GMatrix m) {
        for (int j = 0; j < u.nCol; j++) {
            double utemp = u.values[topr][j];
            u.values[topr][j] = (cosl[0] * utemp) - (sinl[0] * u.values[bottomr][j]);
            u.values[bottomr][j] = (sinl[0] * utemp) + (cosl[0] * u.values[bottomr][j]);
        }
        System.out.println("\nm=");
        checkMatrix(m);
        System.out.println("\nu=");
        checkMatrix(t);
        m.mul(t, m);
        System.out.println("\nt*m=");
        checkMatrix(m);
    }

    private static void update_u(int index, GMatrix u, double[] cosl, double[] sinl) {
        for (int j = 0; j < u.nCol; j++) {
            double utemp = u.values[index][j];
            u.values[index][j] = (cosl[0] * utemp) + (sinl[0] * u.values[index + 1][j]);
            u.values[index + 1][j] = ((-sinl[0]) * utemp) + (cosl[0] * u.values[index + 1][j]);
        }
    }

    private static void print_m(GMatrix m, GMatrix u, GMatrix v) {
        GMatrix mtmp = new GMatrix(m.nCol, m.nRow);
        mtmp.mul(u, mtmp);
        mtmp.mul(mtmp, v);
        System.out.println("\n m = \n" + toString(mtmp));
    }

    private static String toString(GMatrix m) {
        StringBuffer buffer = new StringBuffer(m.nRow * m.nCol * 8);
        for (int i = 0; i < m.nRow; i++) {
            for (int j = 0; j < m.nCol; j++) {
                if (Math.abs(m.values[i][j]) < 1.0E-9d) {
                    buffer.append("0.0000 ");
                } else {
                    buffer.append(m.values[i][j]).append(" ");
                }
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }

    private static void print_svd(double[] s, double[] e, GMatrix u, GMatrix v) {
        GMatrix mtmp = new GMatrix(u.nCol, v.nRow);
        System.out.println(" \ns = ");
        for (int i = 0; i < s.length; i++) {
            System.out.println(" " + s[i]);
        }
        System.out.println(" \ne = ");
        for (int i2 = 0; i2 < e.length; i2++) {
            System.out.println(" " + e[i2]);
        }
        System.out.println(" \nu  = \n" + u.toString());
        System.out.println(" \nv  = \n" + v.toString());
        mtmp.setIdentity();
        for (int i3 = 0; i3 < s.length; i3++) {
            mtmp.values[i3][i3] = s[i3];
        }
        for (int i4 = 0; i4 < e.length; i4++) {
            mtmp.values[i4][i4 + 1] = e[i4];
        }
        System.out.println(" \nm  = \n" + mtmp.toString());
        mtmp.mulTransposeLeft(u, mtmp);
        mtmp.mulTransposeRight(mtmp, v);
        System.out.println(" \n u.transpose*m*v.transpose  = \n" + mtmp.toString());
    }

    static double max(double a, double b) {
        return a > b ? a : b;
    }

    static double min(double a, double b) {
        return a < b ? a : b;
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

    static double compute_rot(double f, double g, double[] sin, double[] cos) {
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
        sin[0] = sn;
        cos[0] = cs;
        return r;
    }

    static double d_sign(double a, double b) {
        double x = a >= Utils.DOUBLE_EPSILON ? a : -a;
        return b >= Utils.DOUBLE_EPSILON ? x : -x;
    }

    public Object clone() {
        try {
            GMatrix m1 = (GMatrix) super.clone();
            m1.values = (double[][]) Array.newInstance(Double.TYPE, new int[]{this.nRow, this.nCol});
            for (int i = 0; i < this.nRow; i++) {
                for (int j = 0; j < this.nCol; j++) {
                    m1.values[i][j] = this.values[i][j];
                }
            }
            return m1;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
}
