package javax.vecmath;

import com.github.mikephil.charting.utils.Utils;

class VecMathUtil {
    static int floatToIntBits(float f) {
        if (f == 0.0f) {
            return 0;
        }
        return Float.floatToIntBits(f);
    }

    static long doubleToLongBits(double d) {
        if (d == Utils.DOUBLE_EPSILON) {
            return 0;
        }
        return Double.doubleToLongBits(d);
    }

    private VecMathUtil() {
    }
}
